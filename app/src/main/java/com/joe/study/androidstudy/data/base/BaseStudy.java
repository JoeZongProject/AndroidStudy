package com.joe.study.androidstudy.data.base;

import cn.bmob.v3.BmobObject;

/**
 * @Author zongdongdong on 2017/9/20.
 * {@link }
 */

public class BaseStudy extends BmobObject {
    private String title;
    private String htmlUrl;
    private int type;//1基础知识，2关于

    public String getTitle() {
        return title;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public int getType() {
        return type;
    }
}
