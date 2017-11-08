package com.joe.study.androidstudy.view.button.statebutton;

import android.os.Bundle;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.data.model.ShowInfo;
import com.joe.study.androidstudy.dialog.GetPathDialog;
import com.joe.study.baselibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StateButtonActivity extends BaseActivity {

    @BindView(R.id.stateButtonDiff)
    StateButton stateButtonDiff;

    private ShowInfo showInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_button);
        ButterKnife.bind(this);
        setToolBar(R.id.toolBar, "状态Button");
        showInfo = (ShowInfo) getIntent().getSerializableExtra(ShowInfo.class.getSimpleName());
        initView();
        initListeners();
    }

    public void initView() {
        stateButtonDiff.setRadius(new float[]{0, 0, 20, 20, 40, 40, 60, 60});
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
