package com.joe.study.androidstudy.data.model;

import com.joe.study.androidstudy.data.base.BaseDataModel;

import java.io.Serializable;

/**
 * @Author zongdongdong on 2017/10/26.
 * {@link }
 * 在ShowWebview中展示的数据
 */

public class ShowInfo implements Serializable {
    /**
     * Actionbar title
     */
    private String title;

    /**
     * 展示webview url
     */
    private String htmlUrl;

    /**
     * 图片展示URL
     */
    private String imageUrl;

    /**
     * 项目标题
     */
    private String projectTitle;

    /**
     * gitHub地址
     */
    private String gitUrl;

    /**
     * 自己demo的地址
     */
    private String demoUrl;

    /**
     * 侵权描述
     */
    private String permissionDesc;


    public ShowInfo(BaseDataModel baseDataModel) {
        title = baseDataModel.getTitle();
        htmlUrl = baseDataModel.getHtmlUrl();
        imageUrl = baseDataModel.getPicUrl();
        projectTitle = baseDataModel.getProjectTitle();
        gitUrl = baseDataModel.getGitUrl();
        demoUrl = baseDataModel.getDemoUrl();
        permissionDesc = baseDataModel.getPermissionDesc();
    }

    public String getTitle() {
        return title;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }
}
