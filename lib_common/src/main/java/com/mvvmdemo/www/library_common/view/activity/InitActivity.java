package com.mvvmdemo.www.library_common.view.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * author:  zhouchaoxiang
 * date:    2018/10/31
 * explain:
 */
public abstract class InitActivity<T extends ViewDataBinding> extends AppCompatActivity {

    private T mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        setViewModel(mBinding);
    }


    protected abstract int getLayoutId();

    protected abstract void setViewModel(T binding);

    public T getBinding() {
        return mBinding;
    }

}
