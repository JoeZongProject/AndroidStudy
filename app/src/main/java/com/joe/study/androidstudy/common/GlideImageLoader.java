package com.joe.study.androidstudy.common;

import android.content.Context;
import android.widget.ImageView;

import com.joe.study.androidstudy.R;
import com.joe.study.baselibrary.common.GlideApp;
import com.youth.banner.loader.ImageLoader;

/**
 * @Author zongdongdong on 2017/8/30.
 * {@link }
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        GlideApp.with(context).load(path).placeholder(R.mipmap.img_banner_default).error(R.mipmap.img_banner_default).into(imageView);
    }
}
