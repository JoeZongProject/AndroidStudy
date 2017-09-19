package com.joe.study.androidstudy.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.common.GlideImageLoader;
import com.joe.study.androidstudy.view.button.ButtonListActivity;
import com.joe.study.androidstudy.view.third.tongchen.SearchActivity;
import com.joe.study.baselibrary.util.UIHelper;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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
}
