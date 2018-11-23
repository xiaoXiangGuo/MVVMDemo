package com.mvvmdemo.www.library_common.utils;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mvvmdemo.www.library_common.R;
import com.mvvmdemo.www.library_common.base.BaseApp;


/**
 * toast工具 by Administrator on 2018/4/18.
 */

public class ToastUtil {

    private static Toast mToast;

    public static void showToastShort(CharSequence text) {
        showToast(text, Toast.LENGTH_SHORT);
    }

    public static void showToastLong(CharSequence text) {
        showToast(text, Toast.LENGTH_LONG);
    }

    @SuppressLint("ShowToast")
    private static void showToast(CharSequence text, int duration) {
        if (null == mToast) {
            mToast = Toast.makeText(BaseApp.getContext(), text, duration);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }

    private static Toast estToast;
    private static TextView tvToast;
    private static View toastRoot;

    public static void showCenterToastLong(String message) {
        showCenterToast(message, Toast.LENGTH_LONG);
    }

    public static void showCenterToastShort(CharSequence message) {
        showCenterToast(message, Toast.LENGTH_SHORT);
    }

    private static void showCenterToast(CharSequence message, int duration) {
        if (null == toastRoot) {
            toastRoot = View.inflate(BaseApp.getContext(),R.layout.toast_center,null);
//            toastRoot = LayoutInflater.from(BaseApp.getContext()).inflate(R.layout.toast_center, null);
        }
        if (null == tvToast) {
            tvToast = toastRoot.findViewById(R.id.tv_toast);
        }
        tvToast.setText(message);
        if (null == estToast) {
            estToast = new Toast(BaseApp.getContext());
            estToast.setGravity(Gravity.CENTER, 0, -40);
            estToast.setDuration(duration);
        }
        estToast.setView(toastRoot);
        estToast.show();
    }
}
