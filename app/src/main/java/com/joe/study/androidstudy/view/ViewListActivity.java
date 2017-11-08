package com.joe.study.androidstudy.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.joe.study.androidstudy.R;
import com.joe.study.androidstudy.data.base.BaseDataModel;
import com.joe.study.androidstudy.data.model.ShowInfo;
import com.joe.study.androidstudy.util.ImageLoadUtil;
import com.joe.study.androidstudy.view.showview.ShowImageActivity;
import com.joe.study.androidstudy.view.showview.ShowWebviewActivity;
import com.joe.study.baselibrary.base.BaseActivity;
import com.joe.study.baselibrary.util.JSONUtils;
import com.joe.study.baselibrary.util.UIHelper;
import com.joe.study.baselibrary.widget.recyclerview.CommonAdapter;
import com.joe.study.baselibrary.widget.recyclerview.MultiItemTypeAdapter;
import com.joe.study.baselibrary.widget.recyclerview.base.ViewHolder;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

public class ViewListActivity extends BaseActivity {

    @BindView(R.id.viewRecyclerView)
    XRecyclerView viewRecyclerView;

    private CommonAdapter<BaseDataModel> commonAdapter;

    private List<BaseDataModel> studyList = new ArrayList<>();

    private int pageIndex = 0;

    private String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        ButterKnife.bind(this);
        String actionbarTitle = getIntent().getStringExtra("actionbarTitle");
        tableName = getIntent().getStringExtra("tableName");
        setToolBar(R.id.toolBar, actionbarTitle);
        initView();
        initListeners();
        viewRecyclerView.refresh();
    }

    public void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        viewRecyclerView.setLayoutManager(layoutManager);
        viewRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        viewRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        viewRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);
        commonAdapter = new CommonAdapter<BaseDataModel>(this, R.layout.item_button_list, studyList) {
            @Override
            protected void convert(ViewHolder holder, BaseDataModel baseDataModel, int position) {
                holder.setText(R.id.txtvButtonTitle, baseDataModel.getTitle());
                holder.setText(R.id.txtvButtonDesc, baseDataModel.getDesc());
                ImageLoadUtil.load(ViewListActivity.this, holder.getView(R.id.imgvPic), baseDataModel.getPicUrl());
            }
        };
        viewRecyclerView.setAdapter(commonAdapter);
    }


    public void initListeners() {
        viewRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
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
                BaseDataModel baseDataModel = studyList.get(position - 1);
                int showType = baseDataModel.getShowType();
                switch (showType) {
                    case 0:
                        if (!TextUtils.isEmpty(baseDataModel.getTargetUrl())) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(baseDataModel.getTargetUrl()));
                            intent.putExtra(ShowInfo.class.getSimpleName(), new ShowInfo(baseDataModel));
                            startActivity(intent);
                        }
                        break;
                    case 1:
                        Intent webIntent = new Intent(ViewListActivity.this, ShowWebviewActivity.class);
                        webIntent.putExtra(ShowInfo.class.getSimpleName(), new ShowInfo(baseDataModel));
                        startActivity(webIntent);
                        break;
                    case 2:
                        Intent imageIntent = new Intent(ViewListActivity.this, ShowImageActivity.class);
                        imageIntent.putExtra(ShowInfo.class.getSimpleName(), new ShowInfo(baseDataModel));
                        startActivity(imageIntent);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    /**
     * 获取列表数据
     */
    private void loadButtonStudyListData() {
        BmobQuery query = new BmobQuery(tableName);
        query.setLimit(20).setSkip(pageIndex == 0 ? 0 : studyList.size()).order("-createdAt")
                .findObjectsByTable(new QueryListener<JSONArray>() {
                    @Override
                    public void done(JSONArray jsonArray, BmobException e) {
                        dealResponse(e == null, jsonArray);
                    }
                });
    }

    private void dealResponse(boolean success, JSONArray jsonArray) {
        List<BaseDataModel> resultList = new ArrayList<>();
        if (jsonArray != null) {
            resultList = JSONUtils.fromJson(jsonArray.toString(), new TypeToken<List<BaseDataModel>>() {
            });
        }

        boolean isRefresh = pageIndex == 0;
        if (pageIndex == 0) {
            studyList.clear();
        }
        if (success) {
            if (pageIndex == 0) {
                if (resultList == null) {
                    studyList = new ArrayList<>();
                }
                studyList.addAll(resultList);
                pageIndex++;
            } else {
                if (resultList == null || resultList.size() == 0) {
                    UIHelper.showShortToast(ViewListActivity.this, "/(ㄒoㄒ)/~~没有更多数据了");
                } else {
                    studyList.addAll(resultList);
                    pageIndex++;
                }
            }
        }

        if (isRefresh) {
            viewRecyclerView.refreshComplete();
        } else {
            viewRecyclerView.loadMoreComplete();
        }
        commonAdapter.notifyDataSetChanged();
    }
}
