package com.joe.study.androidstudy.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.common.GlideImageLoader;
import com.joe.study.baselibrary.util.UIHelper;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomePageActivity extends AppCompatActivity {
    @BindView(R.id.banner)
    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);

        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(getBannerUrls());
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    public List<String> getBannerUrls() {
        List<String> images = new ArrayList<>();
        images.add("http://a2.qpic.cn/psb?/V14ClHR14TMBkM/FhsbUe7V.EbVcnKqOAiSgYji9xMPLFBv13.Q74Lnie8!/b/dDwBAAAAAAAA&bo=bAIsAQAAAAARB3M!&rf=viewer_4");
        images.add("http://a2.qpic.cn/psb?/V14ClHR14TMBkM/TTkX0v2ypKyx2TKbxOAdups1Xk9lxSwkVppR6oxcVBM!/b/dGwBAAAAAAAA&bo=bAIsAQAAAAARAHQ!&rf=viewer_4");
        images.add("http://a3.qpic.cn/psb?/V14ClHR14TMBkM/NmvcXGCB*7jdutNNsNi2RSrHj3xRky2oQvaI8gmlgu4!/b/dD0BAAAAAAAA&bo=bAIsAQAAAAARAHQ!&rf=viewer_4");
        return images;
    }

    @OnClick({R.id.imgvQcode, R.id.imgvMessage, R.id.txtvSearch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgvQcode:
            case R.id.imgvMessage:
                UIHelper.showShortToast(this, "功能正在建设中...");
                break;
            case R.id.txtvSearch:
                startActivity(new Intent(this, SearchActivity.class));
                break;
        }
    }

    @OnClick(R.id.aboutPanel)
    public void onViewClicked() {
        startActivity(new Intent(this, AboutActivity.class));
    }
}
