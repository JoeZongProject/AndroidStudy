package com.joe.study.androidstudy.data.base;

import cn.bmob.v3.BmobObject;

/**
 * @Author zongdongdong on 2017/11/1.
 * {@link }
 */

public class BaseDataModel extends BmobObject {
    private String title;
    private String desc;
    private String targetUrl;
    private String htmlUrl;
    private String picUrl;
    private String gitUrl;
    private String projectTitle;
    private String demoUrl;
    private String permissionDesc;//侵权描述
    private int showType;//0 原生 1 webview 2 Imageview

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
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

    public int getShowType() {
        return showType;
    }
}
