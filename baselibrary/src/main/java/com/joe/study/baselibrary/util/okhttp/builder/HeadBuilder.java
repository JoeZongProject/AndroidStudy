package com.joe.study.baselibrary.util.okhttp.builder;


import com.joe.study.baselibrary.util.okhttp.OkHttpUtils;
import com.joe.study.baselibrary.util.okhttp.request.OtherRequest;
import com.joe.study.baselibrary.util.okhttp.request.RequestCall;

public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
