package com.joe.study.androidstudy.view.showview;

import android.os.Bundle;
import android.widget.ImageView;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.data.model.ShowInfo;
import com.joe.study.androidstudy.dialog.GetPathDialog;
import com.joe.study.androidstudy.util.ImageLoadUtil;
import com.joe.study.baselibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowImageActivity extends BaseActivity {
    @BindView(R.id.imageView)
    ImageView imageView;

    private ShowInfo showInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        ButterKnife.bind(this);
        showInfo = (ShowInfo) getIntent().getSerializableExtra(ShowInfo.class.getSimpleName());
        setToolBar(R.id.toolBar, showInfo == null ? "返回" : showInfo.getTitle());
        ImageLoadUtil.load(this, imageView, showInfo == null ? "" : showInfo.getImageUrl());
        initListeners();
    }

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
