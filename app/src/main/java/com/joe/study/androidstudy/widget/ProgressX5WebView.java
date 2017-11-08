package com.joe.study.androidstudy.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * @Author zongdongdong on 2017/8/24.
 * {@link }
 */

public class ProgressX5WebView extends X5WebView {
    public ProgressX5WebView(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
        init();
    }

    private RotateLoading loading;

    private void init() {
        loading = new RotateLoading(getContext());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(150, 150);
        params.gravity = Gravity.CENTER;
        loading.setLayoutParams(params);
        linearLayout.addView(loading);
        addView(linearLayout);

        this.setWebViewClient(new WebViewClient() {
            /**
             * 防止加载网页时调起系统浏览器
             */
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                if (listener != null) {
                    listener.onPageFinish(webView, s);
                }
            }
        });
        this.setWebChromeClient(new com.tencent.smtt.sdk.WebChromeClient() {
            @Override
            public void onProgressChanged(WebView webView, int newProgress) {
                super.onProgressChanged(webView, newProgress);
                if (newProgress == 100) {
                    loading.stop();
                }
                if (!loading.isStart()) {
                    loading.start();
                }
            }
        });
    }

    private OnWebViewListener listener;

    public void setWebViewListener(OnWebViewListener listener) {
        this.listener = listener;
    }

    public interface OnWebViewListener {
        void onPageFinish(WebView webView, String s);
    }
}
