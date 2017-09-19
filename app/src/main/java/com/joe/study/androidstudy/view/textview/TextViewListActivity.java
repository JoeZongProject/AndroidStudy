package com.joe.study.androidstudy.view.textview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.joe.study.androidstudy.R;
import com.joe.study.baselibrary.base.BaseActivity;

public class TextViewListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_list);
        setToolBar(R.id.toolBar, "TextView学习列表");

    }
}
