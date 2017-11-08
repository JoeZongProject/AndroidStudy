package com.joe.study.androidstudy.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.view.ViewListActivity;
import com.joe.study.androidstudy.view.api.ApiActivity;
import com.joe.study.baselibrary.util.AppUtils;
import com.joe.study.baselibrary.util.UIHelper;
import com.tencent.bugly.crashreport.CrashReport;

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

//        CrashReport.testJavaCrash();
    }


    @OnClick(R.id.aboutPanel)
    public void onViewClicked() {
        if (checkNetwork()) {
            startActivity(new Intent(this, AboutActivity.class));
        }
    }

    @OnClick(R.id.buttonPanel)
    public void onButtonList() {
        if (checkNetwork()) {
            Intent buttonIntent = new Intent(this, ViewListActivity.class);
            buttonIntent.putExtra("tableName", "ButtonStudy");
            buttonIntent.putExtra("actionbarTitle", "Button学习列表");
            startActivity(buttonIntent);
        }
    }

    @OnClick(R.id.textViewPanel)
    public void onTextViewClicked() {
        if (checkNetwork()) {
            Intent intent = new Intent(this, ViewListActivity.class);
            intent.putExtra("tableName", "TextViewStudy");
            intent.putExtra("actionbarTitle", "TextView学习列表");
            startActivity(intent);
//            startActivity(new Intent(this, TextViewListActivity.class));
        }
    }

    @OnClick(R.id.basePanel)
    public void onBaseClicked() {
        if (checkNetwork()) {
            startActivity(new Intent(this, BaseStudyActivity.class));
        }
    }

    @OnClick(R.id.apiPanel)
    public void onApiClicked() {
        if (checkNetwork()) {
            startActivity(new Intent(this, ApiActivity.class));
        }
    }

    private boolean checkNetwork() {
        if (AppUtils.hasNetwork(this)) {
            return true;
        } else {
            UIHelper.showLongToast(this, "老铁，想干嘛，网络还没开呢！");
            return false;
        }
    }
}
