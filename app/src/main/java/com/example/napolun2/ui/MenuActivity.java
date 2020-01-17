package com.example.napolun2.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.napolun2.R;
import com.example.napolun2.ui.fragments.AboutFragment;
import com.example.napolun2.ui.fragments.HomeFragment;
import com.example.napolun2.ui.fragments.SleepFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.sleep_menu)
    RadioButton mSleepMenu;
    @BindView(R.id.home_menu)
    RadioButton mHomeMenu;
    @BindView(R.id.about_menu)
    RadioButton mAboutMenu;
    @BindView(R.id.group_menu)
    RadioGroup mGroupMenu;
    @BindView(R.id.back_menu)
    Button mBackMenu;
    @BindView(R.id.logon_menu)
    ImageView mLogonMenu;

    private int position = 0;
    private SleepFragment mSleepFragment;
    private HomeFragment mHomeFragment;
    private AboutFragment mAboutFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        setTabSelection(position);
        initView();
    }

    private void initView() {

        mGroupMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.sleep_menu:
                        setTabSelection(0);
                        break;
                    case R.id.home_menu:
                        setTabSelection(1);
                        break;
                    case R.id.about_menu:
                        setTabSelection(2);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.back_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_menu:
                finish();
                break;
        }
    }

    public void setTabSelection(int position) {
        //记录position
        this.position = position;
        //更改底部导航栏按钮状态
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
//        transaction.hide(mHomeFragment).hide(mMessageFragment).hide(mMineFragment).hide(mMoreFragment).commit();
        transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                mSleepMenu.setChecked(true);
                if (mSleepFragment == null) {
                    mSleepFragment = new SleepFragment();
                    transaction.add(R.id.frag_menu, mSleepFragment, "SleepFragment");
                } else {
                    transaction.show(mSleepFragment);
                }
                break;
            case 1:
                mHomeMenu.setChecked(true);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.frag_menu, mHomeFragment, "HomeFragment");
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
            case 2:
                mAboutMenu.setChecked(true);
                if (mAboutFragment == null) {
                    mAboutFragment = new AboutFragment();
                    transaction.add(R.id.frag_menu, mAboutFragment, "AboutFragment");
                } else {
                    transaction.show(mAboutFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mSleepFragment != null)
            transaction.hide(mSleepFragment);
        if (mHomeFragment != null)
            transaction.hide(mHomeFragment);
        if (mAboutFragment != null)
            transaction.hide(mAboutFragment);
        transaction.commit();
    }

}