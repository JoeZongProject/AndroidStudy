package com.joe.study.androidstudy.view.home;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.data.base.BaseStudy;
import com.joe.study.androidstudy.widget.ProgressWebView;
import com.joe.study.androidstudy.widget.ProgressX5WebView;
import com.joe.study.baselibrary.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class BaseStudyActivity extends BaseActivity {

    @BindView(R.id.webview)
    ProgressX5WebView webview;
    @BindView(R.id.txtvEmptyTip)
    TextView txtvEmptyTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_study);
        setToolBar(R.id.toolBar, "基础学习资料");
        ButterKnife.bind(this);
        loadTextViewStudyListData();
    }

    private void loadTextViewStudyListData() {
        BmobQuery<BaseStudy> query = new BmobQuery<>();
        query.findObjects(new FindListener<BaseStudy>() {
            @Override
            public void done(List<BaseStudy> list, BmobException e) {
                if (e == null && list != null && list.size() > 0) {
                    webview.setVisibility(View.VISIBLE);
                    txtvEmptyTip.setVisibility(View.GONE);
                    for (BaseStudy baseStudy : list) {
                        if (baseStudy.getType() == 1) {
                            webview.loadUrl(baseStudy.getHtmlUrl());
                            break;
                        }
                    }
                } else {
                    txtvEmptyTip.setVisibility(View.VISIBLE);
                    webview.setVisibility(View.GONE);
                }
            }
        });
    }
}
