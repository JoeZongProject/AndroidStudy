//package com.joe.study.baselibrary.util.okhttp;
//
//import android.os.Handler;
//import android.os.Looper;
//import android.util.Log;
//
//
//import java.io.IOException;
//import java.net.SocketException;
//import java.net.SocketTimeoutException;
//import java.net.UnknownHostException;
//import java.util.Map;
//
//
///**
// * @Autor zongdongdong on 2016/9/20.
// */
//
//public class OkHttpConnect {
//    public static final String TAG = "@vcredit.http";
//    private HttpData httpData;
//    private OnHttpResultListener onHttpResultListener;
//
//
//    public HttpData getHttpData() {
//        return httpData;
//    }
//
//    public void setHttpData(HttpData httpData) {
//        this.httpData = httpData;
//    }
//
//    public Response request(OnHttpResultListener onHttpResultListener) {
//        this.onHttpResultListener = onHttpResultListener;
//        return requestThread();
//    }
//
//    protected Response requestThread() {
//        RequestCall call = null;
//        Log.i(TAG, "Id:" + httpData.getId() + "->" + httpData.getUrl());
//        Log.i(TAG, "Id:" + httpData.getId() + "->" + httpData.getHttpMethod());
//        Log.i(TAG, "Id:" + httpData.getId() + "->request:" + JSONUtils.toJson(httpData.getRequestObj()));
//        if (httpData.getHttpMethod() == HttpMethod.POST) {
//            PostFormBuilder postFormBuilder = OkHttpUtils.getInstance(httpData.getHttpTimeout()).post();
//            postFormBuilder.url(httpData.getUrl());
//            if (httpData.getTag() != null) {
//                postFormBuilder.tag(httpData.getTag());
//            }
//
//            if (getHttpData().getRequestHeaders() != null) {
//                for (String key : getHttpData().getRequestHeaders().keySet()) {
//                    postFormBuilder.addHeader(key, getHttpData().getRequestHeaders().get(key));
//                }
//            }
//            postFormBuilder.params(((Map<String, String>) httpData.getRequestObj()));
//            //文件
//            if (httpData.getRequestFile() != null && httpData.getRequestFile().size() > 0) {
//                for (HttpData.FileInputData fileInputData : httpData.getRequestFile()) {
//                    postFormBuilder.addFile(fileInputData.key, fileInputData.fileName, fileInputData.file);
//                }
//            }
//            call = postFormBuilder.build();
//        } else if (httpData.getHttpMethod() == HttpMethod.GET) {
//            GetBuilder getBuilder = OkHttpUtils.getInstance(httpData.getHttpTimeout()).get();
//            getBuilder.url(httpData.getUrl());
//            if (httpData.getTag() != null) {
//                getBuilder.tag(httpData.getTag());
//            }
//            if (getHttpData().getRequestHeaders() != null) {
//                for (String key : getHttpData().getRequestHeaders().keySet()) {
//                    getBuilder.addHeader(key, getHttpData().getRequestHeaders().get(key));
//                }
//            }
//            getBuilder.params(((Map<String, String>) httpData.getRequestObj()));
//            call = getBuilder.build();
//        } else if (httpData.getHttpMethod() == HttpMethod.POST_JSON) {
//            PostStringBuilder postStringBuilder = OkHttpUtils.getInstance(httpData.getHttpTimeout()).postString();
//            postStringBuilder.url(httpData.getUrl());
//            postStringBuilder.mediaType(MediaType.parse("application/json; charset=utf-8"));
//            if (httpData.getTag() != null) {
//                postStringBuilder.tag(httpData.getTag());
//            }
//            postStringBuilder.content(JSONUtils.toJson(httpData.getRequestObj()));
//            call = postStringBuilder.build();
//        }
//        if (call != null) {
//            if (getHttpData().isSync()) {
//                try {
//                    return call.execute();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                call.execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        if (e != null) {
//                            getHttpData().setExceptionMessage(e.getMessage());
//                        }
//                        setResultError(e);
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        getHttpData().setResponseString(response);
//                        onResult(true);
//                        Log.i(TAG, "Id:" + httpData.getId() + "->response:" + response);
//                    }
//                });
//            }
//        }
//        return null;
//    }
//
//    protected void cancel(Object tag) {
//        OkHttpUtils.getInstance().cancelTag(tag);
//    }
//
//    private void setResultError(Exception e) {
//        if (e instanceof UnknownHostException) {
//            setResult(HttpError.CONNECT_FAILED);
//        } else if (e instanceof SocketException) {
//            setResult(HttpError.CONNECT_FAILED);
//        } else if (e instanceof SocketTimeoutException) {
//            setResult(HttpError.CONNECT_TIME_OUT);
//        } else if (e instanceof IOException && "Canceled".equals(e.getMessage())) {
//            setResult(HttpError.CANCEL);
//        } else if (e instanceof Exception) {
//            setResult(HttpError.ERROR);
//        }
//        onResult(false);
//    }
//
//    private void setResult(HttpError httpError) {
////        Log.i(TAG, "Id:" + getHttpData().getId() + "->responseError:" + httpError);
//        getHttpData().setHttpError(httpError);
//    }
//
//    protected void onResult(final boolean isSuccess) {
////        Log.i(TAG, "Id:" + getHttpData().getId() + "->running times:" + (System.currentTimeMillis() - startTime) + "ms");
//        if (onHttpResultListener != null) {
//            new Handler(Looper.getMainLooper()).post(new Runnable() {
//                @Override
//                public void run() {
//                    onHttpResultListener.onHttpResult(isSuccess, getHttpData());
//                }
//            });
//        }
//    }
//}
