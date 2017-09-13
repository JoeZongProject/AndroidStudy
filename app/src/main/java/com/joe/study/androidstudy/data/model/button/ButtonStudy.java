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
}
