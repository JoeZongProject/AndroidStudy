package com.joe.study.androidstudy.view.textview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.data.model.textview.TextViewStudy;
import com.joe.study.androidstudy.util.ImageLoadUtil;
import com.joe.study.baselibrary.base.BaseActivity;
import com.joe.study.baselibrary.util.UIHelper;
import com.joe.study.baselibrary.widget.recyclerview.CommonAdapter;
import com.joe.study.baselibrary.widget.recyclerview.MultiItemTypeAdapter;
import com.joe.study.baselibrary.widget.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class TextViewListActivity extends BaseActivity {

    @BindView(R.id.textViewRecyclerView)
    XRecyclerView textViewRecyclerView;

    private CommonAdapter<TextViewStudy> commonAdapter;

    private List<TextViewStudy> textViewStudyList = new ArrayList<>();

    private int pageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_list);
        ButterKnife.bind(this);
        setToolBar(R.id.toolBar, "TextView学习列表");
        initView();
        initListeners();
//        loadTextViewStudyListData();
        textViewRecyclerView.refresh();
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        textViewRecyclerView.setLayoutManager(layoutManager);
        textViewRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        textViewRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        textViewRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);
        commonAdapter = new CommonAdapter<TextViewStudy>(this, R.layout.item_textview_list, textViewStudyList) {
            @Override
            protected void convert(ViewHolder holder, TextViewStudy textViewStudy, int position) {
                holder.setText(R.id.txtvTextViewTitle, textViewStudy.getTextViewTitle());
                holder.setText(R.id.txtvTextViewDesc, textViewStudy.getTextViewDesc());
                ImageLoadUtil.load(mContext, holder.getView(R.id.imgvPic), textViewStudy.getPicUrl());
            }
        };
        textViewRecyclerView.setAdapter(commonAdapter);
    }

    private void initListeners() {
        textViewRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                pageIndex = 0;
                loadTextViewStudyListData();
            }

            @Override
            public void onLoadMore() {
                loadTextViewStudyListData();
            }
        });

        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                TextViewStudy textViewStudy = textViewStudyList.get(position - 1);
                if (!TextUtils.isEmpty(textViewStudy.getTargetUrl())) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(textViewStudy.getTargetUrl()));
                    intent.putExtra(TextViewStudy.class.getSimpleName(), textViewStudy);
                    startActivity(intent);
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private void loadTextViewStudyListData() {
        BmobQuery<TextViewStudy> query = new BmobQuery<>();
        query.setLimit(20).setSkip(pageIndex == 0 ? 0 : textViewStudyList.size()).order("-createdAt")
                .findObjects(new FindListener<TextViewStudy>() {
                    @Override
                    public void done(List<TextViewStudy> list, BmobException e) {
                        boolean isRefresh = pageIndex == 0;
                        if (pageIndex == 0) {
                            textViewStudyList.clear();
                        }
                        if (e == null) {
                            if (pageIndex == 0) {
                                if (list == null) {
                                    list = new ArrayList<>();
                                }
                                textViewStudyList.addAll(list);
                                pageIndex++;
                            } else {
                                if (list == null || list.size() == 0) {
                                    UIHelper.showShortToast(mContext, "/(ㄒoㄒ)/~~没有更多数据了");
                                } else {
                                    textViewStudyList.addAll(list);
                                    pageIndex++;
                                }
                            }
                        }

                        if (isRefresh) {
                            textViewRecyclerView.refreshComplete();
                        } else {
                            textViewRecyclerView.loadMoreComplete();
                        }
                        commonAdapter.notifyDataSetChanged();
                    }
                });
    }

}
