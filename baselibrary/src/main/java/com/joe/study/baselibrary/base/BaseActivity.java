package com.joe.study.baselibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.joe.study.baselibrary.R;

/**
 * @Author zongdongdong on 2017/9/9.
 * {@link }
 */

public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    public void setToolBar(int toolBarId, String title) {
        toolbar = (Toolbar) findViewById(toolBarId);
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        this.setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.icon_back_white);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (provideMeunLayoutId() > 0) {
            getMenuInflater().inflate(provideMeunLayoutId(), menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * toolar menu
     *
     * @return
     */
    public int provideMeunLayoutId() {
        return 0;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }
}
