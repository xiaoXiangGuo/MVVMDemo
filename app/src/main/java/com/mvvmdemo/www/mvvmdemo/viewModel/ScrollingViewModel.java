package com.mvvmdemo.www.mvvmdemo.viewModel;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.mvvmdemo.www.mvvmdemo.viewModel.base.BaseViewModel;

/**
 * author:  zhouchaoxiang
 * date:    2018/10/31
 * explain:
 */
public class ScrollingViewModel extends BaseViewModel {
    private String title = "你好";

    public String getTitle() {
        return "周超翔";
    }

    public void onFabClick(View view) {
        Snackbar.make(view, "啥子鬼", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
