package com.joe.study.androidstudy.data.model.button;

import cn.bmob.v3.BmobObject;

/**
 * @Author zongdongdong on 2017/9/12.
 * {@link }
 */

public class ButtonStudy extends BmobObject {
    private String buttonTitle;
    private String buttonDesc;

    public String getButtonTitle() {
        return buttonTitle;
    }

    public void setButtonTitle(String buttonTitle) {
        this.buttonTitle = buttonTitle;
    }

    public String getButtonDesc() {
        return buttonDesc;
    }

    public void setButtonDesc(String buttonDesc) {
        this.buttonDesc = buttonDesc;
    }
}
