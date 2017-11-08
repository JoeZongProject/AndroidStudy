package com.joe.study.androidstudy.view.showview;

import android.os.Bundle;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.data.model.ShowInfo;
import com.joe.study.androidstudy.dialog.GetPathDialog;
import com.joe.study.androidstudy.widget.ProgressWebView;
import com.joe.study.androidstudy.widget.ProgressX5WebView;
import com.joe.study.baselibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowWebviewActivity extends BaseActivity {

    @BindView(R.id.webview)
    ProgressX5WebView webview;

    private ShowInfo showInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_webview);
        ButterKnife.bind(this);

        showInfo = (ShowInfo) getIntent().getSerializableExtra(ShowInfo.class.getSimpleName());
        setToolBar(R.id.toolBar, showInfo == null ? "返回" : showInfo.getTitle());

        if (showInfo != null) {
            webview.loadUrl(showInfo.getHtmlUrl());
        }
        initListeners();
    }


    /**
     * 初始化点击事件
     */
    public void initListeners() {
        getToolbar().setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menuActionGet:
                    if (showInfo != null) {
                        GetPathDialog.newInstance(showInfo.getProjectTitle(), showInfo.getGitUrl(), showInfo.getDemoUrl(), showInfo.getPermissionDesc())
                                .setMargin(40)
                                .show(getSupportFragmentManager());
                    }
                    break;
                default:
                    break;
            }
            return true;
        });
    }

    @Override
    public int provideMeunLayoutId() {
        return R.menu.menu_get_path;
    }
}
