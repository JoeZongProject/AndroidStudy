package com.joe.study.androidstudy.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.view.api.ApiActivity;
import com.joe.study.androidstudy.view.button.ButtonListActivity;
import com.joe.study.androidstudy.view.textview.TextViewListActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;

public class HomePageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);
        Bmob.initialize(this, "b568a5656bab68c2c0432613fe306639");
    }


    @OnClick(R.id.aboutPanel)
    public void onViewClicked() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    @OnClick(R.id.buttonPanel)
    public void onButtonList() {
        startActivity(new Intent(this, ButtonListActivity.class));
    }

    @OnClick(R.id.textViewPanel)
    public void onTextViewClicked() {
        startActivity(new Intent(this, TextViewListActivity.class));
    }

    @OnClick(R.id.basePanel)
    public void onBaseClicked() {
        startActivity(new Intent(this, BaseStudyActivity.class));
    }

    @OnClick(R.id.apiPanel)
    public void onApiClicked() {
        startActivity(new Intent(this, ApiActivity.class));
    }
}
