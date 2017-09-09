package com.joe.study.androidstudy.view.button.statebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.joe.study.androidstudy.R;
import com.joe.study.baselibrary.base.BaseActivity;

import butterknife.ButterKnife;

public class StateButtonActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_button);
        ButterKnife.bind(this);
        setToolBar(R.id.toolBar, "");
    }
}
