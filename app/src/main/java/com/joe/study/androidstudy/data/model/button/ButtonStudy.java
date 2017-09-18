package com.joe.study.androidstudy.data.model.button;

import cn.bmob.v3.BmobObject;

/**
 * @Author zongdongdong on 2017/9/12.
 * {@link }
 */

public class ButtonStudy extends BmobObject {
    private String buttonTitle;
    private String buttonDesc;
    private String targetUrl;
    private String htmlUrl;
    private String picUrl;
    private String gitUrl;
    private String projectTitle;
    private String demoUrl;
    private String permissionDesc;//侵权描述

    public String getButtonTitle() {
        return buttonTitle;
    }

    public String getButtonDesc() {
        return buttonDesc;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }
}
