package com.joe.study.androidstudy.view.button.switchbutton;

import android.os.Bundle;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.data.model.ShowInfo;
import com.joe.study.androidstudy.dialog.GetPathDialog;
import com.joe.study.baselibrary.base.BaseActivity;

public class SwitchButtonActivity extends BaseActivity {
    private ShowInfo showInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button);
        setToolBar(R.id.toolBar, "花式SwitchButton");
        showInfo = (ShowInfo) getIntent().getSerializableExtra(ShowInfo.class.getSimpleName());
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
            }
            return true;
        });
    }

    @Override
    public int provideMeunLayoutId() {
        return R.menu.menu_get_path;
    }
}
