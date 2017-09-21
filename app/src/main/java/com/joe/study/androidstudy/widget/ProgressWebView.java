package com.joe.study.androidstudy.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.joe.study.androidstudy.view.base.BaseWebView;


/**
 * @Autor zongdongdong on 2016/12/15.
 * {@link }
 */

public class ProgressWebView extends BaseWebView {
    public ProgressWebView(Context context) {
        super(context);
        init();
    }

    public ProgressWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        this.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    loading.stop();
                }
                if (!loading.isStart()) {
                    loading.start();
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }
}
