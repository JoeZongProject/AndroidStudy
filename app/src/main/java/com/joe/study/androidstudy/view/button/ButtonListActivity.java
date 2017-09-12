package com.joe.study.androidstudy.view.button;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.data.model.button.ButtonStudy;
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

public class ButtonListActivity extends BaseActivity {

    @BindView(R.id.buttonRecyclerView)
    XRecyclerView buttonRecyclerView;

    private CommonAdapter<ButtonStudy> commonAdapter;

    private List<ButtonStudy> buttonStudyList = new ArrayList<>();

    private int pageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_list);
        ButterKnife.bind(this);
        setToolBar(R.id.toolBar, "Button学习列表");
        initView();
        initListeners();
        loadButtonStudyListData();
    }

    public void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        buttonRecyclerView.setLayoutManager(layoutManager);
        buttonRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        buttonRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);

        commonAdapter = new CommonAdapter<ButtonStudy>(this, R.layout.item_button_list, buttonStudyList) {
            @Override
            protected void convert(ViewHolder holder, ButtonStudy buttonStudy, int position) {
                holder.setText(R.id.txtvButtonTitle, buttonStudy.getButtonTitle());
                holder.setText(R.id.txtvButtonDesc, buttonStudy.getButtonDesc());
            }
        };
        buttonRecyclerView.setAdapter(commonAdapter);
    }

    public void initListeners() {
        buttonRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                pageIndex = 0;
                loadButtonStudyListData();
            }

            @Override
            public void onLoadMore() {
                loadButtonStudyListData();
            }
        });

        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private void loadButtonStudyListData() {
        BmobQuery<ButtonStudy> query = new BmobQuery<>();
        query.setLimit(20).setSkip(pageIndex == 0 ? 0 : buttonStudyList.size()).order("-createdAt")
                .findObjects(new FindListener<ButtonStudy>() {
                    @Override
                    public void done(List<ButtonStudy> list, BmobException e) {
                        boolean isRefresh = pageIndex == 0;
                        if (pageIndex == 0) {
                            buttonStudyList.clear();
                        }
                        if (e == null) {
                            if (pageIndex == 0) {
                                if (list == null) {
                                    list = new ArrayList<>();
                                }
                                buttonStudyList.addAll(list);
                                pageIndex++;
                            } else {
                                if (list == null || list.size() == 0) {
                                    UIHelper.showShortToast(ButtonListActivity.this, "/(ㄒoㄒ)/~~没有更多数据了");
                                } else {
                                    buttonStudyList.addAll(list);
                                    pageIndex++;
                                }
                            }
                        }

                        if (isRefresh) {
                            buttonRecyclerView.refreshComplete();
                        } else {
                            buttonRecyclerView.loadMoreComplete();
                        }
                        commonAdapter.notifyDataSetChanged();
                    }
                });
    }
}
