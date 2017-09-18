package com.joe.study.androidstudy.view.button.statebutton;

import android.os.Bundle;
import android.widget.Button;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.data.model.button.ButtonStudy;
import com.joe.study.androidstudy.dialog.GetPathDialog;
import com.joe.study.androidstudy.view.button.ButtonListActivity;
import com.joe.study.baselibrary.base.BaseActivity;
import com.joe.study.baselibrary.util.UIHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StateButtonActivity extends BaseActivity {

    @BindView(R.id.stateButtonDiff)
    StateButton stateButtonDiff;

    private ButtonStudy buttonStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_button);
        ButterKnife.bind(this);
        setToolBar(R.id.toolBar, "状态Button");
        buttonStudy = (ButtonStudy) getIntent().getSerializableExtra(ButtonStudy.class.getSimpleName());
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
                    if (buttonStudy != null) {
                        GetPathDialog.newInstance(buttonStudy.getProjectTitle(), buttonStudy.getGitUrl(), buttonStudy.getDemoUrl(), buttonStudy.getPermissionDesc())
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
