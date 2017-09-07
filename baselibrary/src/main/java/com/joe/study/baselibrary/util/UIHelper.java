package com.joe.study.baselibrary.util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * @author zongdongdong on 2016/7/20.
 */
public class UIHelper {
    public static Toast mToast;

    public static void showShortToast(Context context, String msg) {
        if(TextUtils.isEmpty(msg)){
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    public static void showLongToast(Context context, String msg) {
        if(TextUtils.isEmpty(msg)){
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        }
        mToast.setText(msg);
        mToast.show();
    }


    private static ProgressDialog mProgressDialog;

    public static void showDefautlProgress(Context context) {
        if (mProgressDialog != null) {
            mProgressDialog.cancel();
        }
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage("正在加载...");
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();
    }

    public static void showProgress(Context context, String msg) {
        if (mProgressDialog != null) {
            mProgressDialog.cancel();
        }
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(msg);
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();
    }

    public static void hideProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }


    private static AlertDialog dialog;

    public static void showDialog(Context context,
                                  String title,
                                  String msg,
                                  String buttonText1, DialogInterface.OnClickListener listener1, boolean cancelable) {
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        if (title == null || title.equals("")) {
            title = "提示";
        }
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT < 21) {
            builder = new AlertDialog.Builder(context);
        } else {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
        }
        builder.setTitle(title).setMessage(msg);
        if (buttonText1 != null) {
            builder.setPositiveButton(buttonText1, listener1);
        }
        dialog = builder.create();
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);
        dialog.show();
    }
}
