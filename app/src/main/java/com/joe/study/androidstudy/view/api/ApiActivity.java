package com.joe.study.androidstudy.view.api;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.joe.study.androidstudy.R;
import com.joe.study.baselibrary.base.BaseActivity;
import com.joe.study.baselibrary.util.StringUtils;
import com.joe.study.baselibrary.util.UIHelper;
import com.joe.study.baselibrary.util.okhttp.OkHttpUtils;
import com.joe.study.baselibrary.util.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class ApiActivity extends BaseActivity {

    @BindView(R.id.etUserNo)
    EditText etUserNo;
    @BindView(R.id.txtvResult)
    TextView txtvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        ButterKnife.bind(this);
        setToolBar(R.id.toolBar, "Api调试");
    }

    @OnClick(R.id.btnRefreshImToken)
    public void onViewClicked() {
        String userNo = etUserNo.getText().toString();
        if (TextUtils.isEmpty(userNo)) {
            UIHelper.showShortToast(this, "输入员工工号");
            return;
        }
        txtvResult.setText("");
        txtvResult.setText("PostUrl：http://10.1.12.185:8080/wxApp/api/v1/user/refreshToken");
        OkHttpUtils.getInstance()
                .post()
                .url("http://10.1.12.185:8080/wxApp/api/v1/user/refreshToken")
                .addParams("userNo", userNo)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        showResult("接口错误:" + e != null ? e.getMessage() : "Exception为null");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        showResult("服务器返回:" + response);
                    }
                });
    }

    private void showResult(String result) {
        this.runOnUiThread(() -> {
            String currentTime = StringUtils.dateFormat(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
            txtvResult.setText(txtvResult.getText() + "\n结果：\n" + "时间：" + currentTime + "\n" + result);
        });
    }
}
