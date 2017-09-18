package com.joe.study.androidstudy.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.joe.study.androidstudy.R;
import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.ViewHolder;

/**
 * @Author zongdongdong on 2017/9/18.
 * {@link }
 */

public class GetPathDialog extends BaseNiceDialog {
    public static GetPathDialog newInstance(String projectTitle, String gitUrl, String demoUrl, String permissionDesc) {

        Bundle args = new Bundle();
        args.putString("projectTitle", projectTitle);
        args.putString("gitUrl", gitUrl);
        args.putString("demoUrl", demoUrl);
        args.putString("permissionDesc", permissionDesc);

        GetPathDialog fragment = new GetPathDialog();
        fragment.setArguments(args);
        return fragment;
    }

    private String projectTitle, gitUrl, demoUrl, permissionDesc;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        projectTitle = bundle.getString("projectTitle");
        gitUrl = bundle.getString("gitUrl");
        demoUrl = bundle.getString("demoUrl");
        permissionDesc = bundle.getString("permissionDesc");
    }

    @Override
    public int intLayoutId() {
        return R.layout.dialog_get_path;
    }

    @Override
    public void convertView(ViewHolder viewHolder, BaseNiceDialog baseNiceDialog) {
        viewHolder.setText(R.id.txtvProjectTitle, projectTitle);
        if (TextUtils.isEmpty(gitUrl)) {
            viewHolder.getView(R.id.llGit).setVisibility(View.GONE);
        } else {
            viewHolder.setText(R.id.txtvGitUrl, gitUrl);
        }
        if (TextUtils.isEmpty(demoUrl)) {
            viewHolder.getView(R.id.llDemo).setVisibility(View.GONE);
        } else {
            viewHolder.setText(R.id.txtvDemoUrl, demoUrl);
        }
        viewHolder.setText(R.id.txtvPermissionDesc, permissionDesc);
        viewHolder.setOnClickListener(R.id.imgvClose, v -> {
            this.dismiss();
        });

    }
}
