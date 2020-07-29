/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.city.service.snapshot;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.city.dao.snapshot.CitySnapshotDao;
import com.jeesite.modules.city.entity.snapshot.CitySnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 随手拍事件Service
 *
 * @author chang
 * @version 2020-06-11
 */
@Service
@Transactional(readOnly = true)
public class CitySnapshotService extends CrudService<CitySnapshotDao, CitySnapshot> {

    @Autowired
    private CitySnapshotDao citySnapshotDao;


    /**
     * 通过uuid获取
     * @param uuid
     * @return
     */
    public CitySnapshot getCitySnapshotByUuid(String uuid) {
        return citySnapshotDao.getCitySnapshotByUuid(uuid);
    }

    /**
     * 获取单条数据
     *
     * @param citySnapshot
     * @return
     */
    @Override
    public CitySnapshot get(CitySnapshot citySnapshot) {
        return super.get(citySnapshot);
    }

    /**
     * 查询分页数据
     *
     * @param citySnapshot      查询条件
     * @param citySnapshot.page 分页对象
     * @return
     */
    @Override
    public Page<CitySnapshot> findPage(CitySnapshot citySnapshot) {
        return super.findPage(citySnapshot);
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param citySnapshot
     */
    @Override
    @Transactional(readOnly = false)
    public void save(CitySnapshot citySnapshot) {
        super.save(citySnapshot);
    }

    /**
     * 更新状态
     *
     * @param citySnapshot
     */
    @Override
    @Transactional(readOnly = false)
    public void updateStatus(CitySnapshot citySnapshot) {
        super.updateStatus(citySnapshot);
    }

    /**
     * 删除数据
     *
     * @param citySnapshot
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(CitySnapshot citySnapshot) {
        super.delete(citySnapshot);
    }


}