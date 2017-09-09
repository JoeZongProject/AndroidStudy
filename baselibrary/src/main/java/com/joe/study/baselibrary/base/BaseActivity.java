package com.joe.study.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.joe.study.baselibrary.R;

/**
 * @Author zongdongdong on 2017/9/9.
 * {@link }
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setToolBar(int toolBarId, String title) {
        Toolbar toolbar = (Toolbar) findViewById(toolBarId);
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        this.setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.icon_back_white);
    }
}
