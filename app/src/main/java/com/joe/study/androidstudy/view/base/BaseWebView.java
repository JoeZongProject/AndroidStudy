package com.joe.study.androidstudy.view.base;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @Author zongdongdong on 2017/5/16.
 * {@link }
 */

public class BaseWebView extends WebView {
    public BaseWebView(Context context) {
        super(context);
        initConfig();
    }

    public BaseWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initConfig();
    }

    public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initConfig();
    }

    private void initConfig() {
        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccess(true);  //设置可以访问文件
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    /**
     * 打开缩放功能
     */
    public void openScale() {
        WebSettings webSettings = this.getSettings();

        webSettings.setUseWideViewPort(true);//设定支持viewport

        webSettings.setLoadWithOverviewMode(true);

        webSettings.setBuiltInZoomControls(true);

        webSettings.setDisplayZoomControls(false);

        webSettings.setSupportZoom(true);//设定支持缩放
    }
}
