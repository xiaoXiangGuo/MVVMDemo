package com.mvvmdemo.www.app_mobile_manager.viewModel;

import android.view.View;

import com.mvvmdemo.www.app_mobile_manager.R;
import com.mvvmdemo.www.library_common.utils.ToastUtil;

/**
 * author:  zhouchaoxiang
 * date:    2018/11/13
 * explain:
 */
public class MainViewModel extends BaseViewModel{
    public void onClick(int id) {
        if (id == R.id.tv_clear) {
            ToastUtil.showCenterToastShort("清理完成!");
        }
    }
}
