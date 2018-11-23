package com.mvvmdemo.www.mvvmdemo.factory;

import com.mvvmdemo.www.mvvmdemo.viewModel.ScrollingViewModel;
import com.mvvmdemo.www.mvvmdemo.viewModel.base.BaseViewModel;

/**
 * author:  zhouchaoxiang
 * date:    2018/10/31
 * explain:
 */
public class ViewModelFactory {
    public static final int TAG_SCROLLING = 1;

    public static <T extends BaseViewModel> T newViewModel(int tag) {
        switch (tag) {
            case TAG_SCROLLING:
                return (T) new ScrollingViewModel();
            default:
                return (T) new BaseViewModel();
        }
    }
}
