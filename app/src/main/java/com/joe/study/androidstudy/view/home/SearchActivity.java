package com.joe.study.androidstudy.view.home;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;
import com.joe.study.androidstudy.R;
import com.joe.study.baselibrary.util.DensityUtil;
import com.joe.study.baselibrary.util.UIHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.flexboxLayout)
    FlexboxLayout flexboxLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        String[] tags = {"火车票", "汽车票·船票", "水上乐园", "过山车", "野生动物园", "景点", "快捷酒店", "邮轮", "周边游", "自由行", "附近的景区", "温泉", "国际机票", "轮滑", "健身房", "旅游攻略", "攀岩", "全国风景区"};
        List<Integer> random = new ArrayList<>();
        random.add(new Random().nextInt(tags.length));
        random.add(new Random().nextInt(tags.length));
        random.add(new Random().nextInt(tags.length));
        for (int i = 0; i < tags.length; i++) {
            flexboxLayout.addView(createFlexItem(tags[i], random.contains(i) ? R.color.orange_FF714F : R.color.gray_7F7F7F));
        }
    }

    @OnClick(R.id.imgvBack)
    public void onViewClicked() {
        finish();
    }

    private TextView createFlexItem(final String text, int textColor) {
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setTextSize(12);
        textView.setTextColor(ContextCompat.getColor(this, textColor));
        textView.setBackgroundResource(R.drawable.bg_lightgray_flexbox_item);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UIHelper.showShortToast(SearchActivity.this, ((TextView) view).getText().toString());
            }
        });
        int paddingTopAndBottom = DensityUtil.dip2px(this, 6);
        int paddingLeftAndRight = DensityUtil.dip2px(this, 10);
        ViewCompat.setPaddingRelative(textView, paddingLeftAndRight, paddingTopAndBottom, paddingLeftAndRight, paddingTopAndBottom);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = DensityUtil.dip2px(this, 6);
        int marginTop = DensityUtil.dip2px(this, 16);
        layoutParams.setMargins(margin, marginTop, margin, 0);
        textView.setLayoutParams(layoutParams);
        return textView;
    }
}
