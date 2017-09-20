package com.joe.study.androidstudy.data.model.textview;

import cn.bmob.v3.BmobObject;

/**
 * @Author zongdongdong on 2017/9/20.
 * {@link }
 */

public class TextViewStudy extends BmobObject {
    private String textViewTitle;
    private String textViewDesc;
    private String targetUrl;
    private String htmlUrl;
    private String picUrl;
    private String gitUrl;
    private String projectTitle;
    private String demoUrl;
    private String permissionDesc;//侵权描述

    public String getTextViewTitle() {
        return textViewTitle;
    }

    public String getTextViewDesc() {
        return textViewDesc;
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
