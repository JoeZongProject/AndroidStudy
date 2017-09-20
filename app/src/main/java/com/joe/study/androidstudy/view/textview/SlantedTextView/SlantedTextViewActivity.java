package com.joe.study.androidstudy.view.textview.SlantedTextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.data.model.button.ButtonStudy;
import com.joe.study.androidstudy.data.model.textview.TextViewStudy;
import com.joe.study.androidstudy.dialog.GetPathDialog;
import com.joe.study.baselibrary.base.BaseActivity;

public class SlantedTextViewActivity extends BaseActivity {
    private TextViewStudy textViewStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slanted_text_view);
        setToolBar(R.id.toolBar, "角标、标签");
        textViewStudy = (TextViewStudy) getIntent().getSerializableExtra(TextViewStudy.class.getSimpleName());
        initListeners();
    }

    public void initListeners() {
        getToolbar().setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menuActionGet:
                    if (textViewStudy != null) {
                        GetPathDialog.newInstance(textViewStudy.getProjectTitle(), textViewStudy.getGitUrl(), textViewStudy.getDemoUrl(), textViewStudy.getPermissionDesc())
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
