package com.joe.study.androidstudy.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.joe.study.baselibrary.common.GlideApp;

/**
 * @Author zongdongdong on 2017/9/18.
 * {@link }
 */

public class ImageLoadUtil {
    public static void load(Context aContext, ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            GlideApp.with(aContext).load(url).into(imageView);
        }
    }
}
