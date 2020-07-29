package com.jeesite.modules.city.web.snapshot;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.city.entity.snapshot.CitySnapshot;
import com.jeesite.modules.city.service.snapshot.CitySnapshotService;
import com.jeesite.modules.sys.entity.Office;
import com.jeesite.modules.sys.entity.Role;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 随手拍事件Controller
 *
 * @author chang
 * @version 2020-06-11
 */
@Controller
@RequestMapping(value = "${adminPath}/city/snapshot/citySnapshot")
public class CitySnapshotController extends BaseController {

    @Autowired
    private CitySnapshotService citySnapshotService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public CitySnapshot get(String id, boolean isNewRecord) {
        return citySnapshotService.get(id, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequiresPermissions("city:snapshot:citySnapshot:view")
    @RequestMapping(value = {"list", ""})
    public String list(CitySnapshot citySnapshot, Model model) {
        model.addAttribute("citySnapshot", citySnapshot);
        return "modules/city/snapshot/citySnapshotList";
    }

    /**
     * 查询列表数据
     */
    @RequiresPermissions("city:snapshot:citySnapshot:view")
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<CitySnapshot> listData(CitySnapshot citySnapshot, HttpServletRequest request, HttpServletResponse response) {
        citySnapshot.setPage(new Page<>(request, response));
        Office office = EmpUtils.getOffice();
        String officeCode = office.getOfficeCode();
        User curUser = UserUtils.getUser();
        List<Role> roleList = curUser.getRoleList();
        for (Role role : roleList) {
            if ("SSP_BM_FZR".equals(role.getRoleCode())) {
                officeCode = null;
                break;
            }
        }
        citySnapshot.setOfficeCode(officeCode);
        Page<CitySnapshot> page = citySnapshotService.findPage(citySnapshot);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequiresPermissions("city:snapshot:citySnapshot:view")
    @RequestMapping(value = "form")
    public String form(CitySnapshot citySnapshot, Model model) {
        model.addAttribute("citySnapshot", citySnapshot);
        return "modules/city/snapshot/citySnapshotForm";
    }

    /**
     * 保存随手拍事件
     */
    @RequiresPermissions("city:snapshot:citySnapshot:edit")
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated CitySnapshot citySnapshot) {
        citySnapshotService.save(citySnapshot);
        return renderResult(Global.TRUE, text("保存成功！"));
    }

    /**
     * 删除随手拍事件
     */
    @RequiresPermissions("city:snapshot:citySnapshot:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(CitySnapshot citySnapshot) {
        citySnapshotService.delete(citySnapshot);
        return renderResult(Global.TRUE, text("删除成功！"));
    }

    /**
     * 发送到各部门
     */
    @RequiresPermissions("city:snapshot:citySnapshot:edit")
    @PostMapping(value = "send")
    @ResponseBody
    public String send(CitySnapshot citySnapshot) {
        if (citySnapshot.getEventStatus().equals("0") || citySnapshot.getEventStatus().equals("4")) {
            if (citySnapshot.getOfficeCode() == null || "".equals(citySnapshot.getOfficeCode().trim())) {
                return renderResult(Global.FALSE, text("未选择部门，不能转派!"));
            }
            citySnapshot.setEventStatus("5");//将状态改为“已转派”
            citySnapshot.setSendDate(new Date());//设置发送时间
            citySnapshotService.save(citySnapshot);
            return renderResult(Global.TRUE, text("转派成功!"));
        }
        return renderResult(Global.FALSE, text("只能转派未转派事件!"));
    }

    /**
     * 部门受理
     */
    @RequiresPermissions("city:snapshot:citySnapshot:edit")
    @PostMapping(value = "acceptance")
    @ResponseBody
    public String acceptance(CitySnapshot citySnapshot) {
        if (citySnapshot.getEventStatus().equals("5")) {
            citySnapshot.setEventStatus("2");//将状态改为“处理中”
            citySnapshot.setSendDate(new Date());//设置接受时间
            citySnapshotService.save(citySnapshot);
            return renderResult(Global.TRUE, text("接受成功!"));
        }
        return renderResult(Global.FALSE, text("只能接受已转派事件!"));
    }

    /**
     * 完结
     */
    @RequiresPermissions("city:snapshot:citySnapshot:edit")
    @PostMapping(value = "end")
    @ResponseBody
    public String end(CitySnapshot citySnapshot) {
        if (citySnapshot.getEventStatus().equals("2")) {
            citySnapshot.setEventStatus("3");//将状态改为“处理中”
            citySnapshot.setSendDate(new Date());//设置完结时间
            citySnapshotService.save(citySnapshot);
            return renderResult(Global.TRUE, text("提交成功!"));
        }
        return renderResult(Global.FALSE, text("只能完结处理中事件!"));
    }

    /**
     * 不接受，退回
     */
    @RequiresPermissions("city:snapshot:citySnapshot:edit")
    @PostMapping(value = "return1")
    @ResponseBody
    public String return1(CitySnapshot citySnapshot) {
        if (citySnapshot.getEventStatus().equals("5")) {
            citySnapshot.setEventStatus("4");//将状态改为“退回”
            citySnapshotService.save(citySnapshot);
            return renderResult(Global.TRUE, text("退回成功!"));
        }
        return renderResult(Global.FALSE, text("只能退回已转派事件!"));
    }
}