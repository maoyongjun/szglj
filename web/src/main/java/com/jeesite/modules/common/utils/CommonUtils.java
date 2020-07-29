package com.jeesite.modules.common.utils;

import com.jeesite.modules.file.entity.FileUpload;
import com.jeesite.modules.file.utils.FileUploadUtils;

import java.util.List;

/**
 * @author VictorChang
 */
public class CommonUtils {

    /**
     * 获取上传图片/文件地址
     *
     * @param bizKey  存储文件的ID
     * @param bizType 存储文件类型
     * @return
     */
    public static String getImgPath(String bizKey, String bizType) {
        List<FileUpload> list = FileUploadUtils.findFileUpload(bizKey, bizType);
        String imgUrl = "";
        if (list.size() > 0) {
            imgUrl = list.get(0).getFileUrl();
        }
        return imgUrl;
    }


}
