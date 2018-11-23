package com.mvvmdemo.www.app_mobile_manager.view.activity;

import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mvvmdemo.www.app_mobile_manager.R;
import com.mvvmdemo.www.app_mobile_manager.databinding.ActivityMainBinding;
import com.mvvmdemo.www.app_mobile_manager.view.activity.base.BaseActivity;
import com.mvvmdemo.www.app_mobile_manager.viewModel.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private static final int RV_SPAN_COUNT = 3;//recyclerview横向个数
/*
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }*/

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setViewModel(ActivityMainBinding binding) {
        binding.setViewModel(new MainViewModel());
        initRv(binding);


    }

    private void initRv(ActivityMainBinding binding) {
        binding.rvFunction.setLayoutManager(new GridLayoutManager(this,RV_SPAN_COUNT));
        BaseQuickAdapter<Pair<Integer, String>, BaseViewHolder> baseQuickAdapter = new BaseQuickAdapter<Pair<Integer, String>, BaseViewHolder>(R.layout.rv_item_mobile_manager) {
            @Override
            protected void convert(BaseViewHolder helper, Pair<Integer, String> item) {

            }
        };
        binding.rvFunction.setAdapter(baseQuickAdapter);
    }

}
