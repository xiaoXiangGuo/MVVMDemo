package com.mvvmdemo.www.mvvmdemo.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mvvmdemo.www.mvvmdemo.R;
import com.mvvmdemo.www.mvvmdemo.databinding.ActivityScrollingBinding;
import com.mvvmdemo.www.mvvmdemo.factory.ViewModelFactory;
import com.mvvmdemo.www.mvvmdemo.view.BaseActivity;
import com.mvvmdemo.www.mvvmdemo.viewModel.ScrollingViewModel;

public class ScrollingActivity extends BaseActivity<ActivityScrollingBinding> {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_scrolling);
//        setContentView(R.layout.activity_scrolling);
        ScrollingViewModel viewModel = new ScrollingViewModel();
        mBinding.setViewModel(viewModel);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mBinding.toolbar);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        mBinding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }*/

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scrolling;
    }

    @Override
    protected void setViewModel(ActivityScrollingBinding binding) {
        binding.setViewModel((ScrollingViewModel) ViewModelFactory.newViewModel(ViewModelFactory.TAG_SCROLLING));
        setSupportActionBar(binding.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
