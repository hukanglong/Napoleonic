package com.example.napolun2.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.napolun2.MainActivity;
import com.example.napolun2.R;
import com.example.napolun2.ui.fragments.FirFragment;
import com.example.napolun2.ui.fragments.MonFragment;
import com.example.napolun2.ui.fragments.SatFragment;
import com.example.napolun2.ui.fragments.SunFragment;
import com.example.napolun2.ui.fragments.ThuFragment;
import com.example.napolun2.ui.fragments.TueFragment;
import com.example.napolun2.ui.fragments.WebFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScheduleActivity extends AppCompatActivity {

    @BindView(R.id.back_schedule)
    Button mBackSchedule;
    @BindView(R.id.save_schedule)
    Button mSaveSchedule;
    @BindView(R.id.sun_box_schedule)
    CheckBox mSunBoxSchedule;
    @BindView(R.id.mon_box_schedule)
    CheckBox mMonBoxSchedule;
    @BindView(R.id.tue_box_schedule)
    CheckBox mTueBoxSchedule;
    @BindView(R.id.web_box_schedule)
    CheckBox mWebBoxSchedule;
    @BindView(R.id.thu_box_schedule)
    CheckBox mThuBoxSchedule;
    @BindView(R.id.fri_box_schedule)
    CheckBox mFriBoxSchedule;
    @BindView(R.id.sat_box_schedule)
    CheckBox mSatBoxSchedule;
    @BindView(R.id.box_schedule)
    LinearLayout mBoxSchedule;
    @BindView(R.id.frag_schedule)
    FrameLayout mFragSchedule;
    private int position = 0;
    private SunFragment mSunFragment;
    private MonFragment mMonFragment;
    private TueFragment mTueFragment;
    private WebFragment mWebFragment;
    private FirFragment mFirFragment;
    private ThuFragment mThuFragment;
    private SatFragment mSatFragment;

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
        setContentView(R.layout.activity_schedule);
        ButterKnife.bind(this);
        //setTabSelection(0);
        initView();
    }

    private void initView() {

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
                if (mSunFragment == null) {
                    mSunFragment = new SunFragment();
                    transaction.add(R.id.frag_schedule, mSunFragment, "mSunFragment");
                } else {
                    transaction.show(mSunFragment);
                }
                break;
            case 1:
                if (mMonFragment == null) {
                    mMonFragment = new MonFragment();
                    transaction.add(R.id.frag_schedule, mMonFragment, "mMonFragment");
                } else {
                    transaction.show(mMonFragment);
                }
                break;
            case 2:
                if (mTueFragment == null) {
                    mTueFragment = new TueFragment();
                    transaction.add(R.id.frag_schedule, mTueFragment, "mTueFragment");
                } else {
                    transaction.show(mTueFragment);
                }
                break;
            case 3:
                if (mWebFragment == null) {
                    mWebFragment = new WebFragment();
                    transaction.add(R.id.frag_schedule, mWebFragment, "mWebFragment");
                } else {
                    transaction.show(mWebFragment);
                }
                break;
            case 4:
                if (mThuFragment == null) {
                    mThuFragment = new ThuFragment();
                    transaction.add(R.id.frag_schedule, mThuFragment, "mThuFragment");
                } else {
                    transaction.show(mThuFragment);
                }
                break;
            case 5:
                if (mFirFragment == null) {
                    mFirFragment = new FirFragment();
                    transaction.add(R.id.frag_schedule, mFirFragment, "mFirFragment");
                } else {
                    transaction.show(mFirFragment);
                }
                break;
            case 6:
                if (mSatFragment == null) {
                    mSatFragment = new SatFragment();
                    transaction.add(R.id.frag_schedule, mSatFragment, "mSatFragment");
                } else {
                    transaction.show(mSatFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mSunFragment != null)
            transaction.hide(mSunFragment);
        if (mMonFragment != null)
            transaction.hide(mMonFragment);
        if (mTueFragment != null)
            transaction.hide(mTueFragment);
        if (mWebFragment != null)
            transaction.hide(mWebFragment);
        if (mThuFragment != null)
            transaction.hide(mThuFragment);
        if (mFirFragment != null)
            transaction.hide(mFirFragment);
        if (mSatFragment != null)
            transaction.hide(mSatFragment);
        transaction.commit();
    }

    @OnClick({R.id.back_schedule, R.id.save_schedule,R.id.sun_box_schedule,
            R.id.mon_box_schedule, R.id.tue_box_schedule, R.id.web_box_schedule,
            R.id.thu_box_schedule, R.id.fri_box_schedule, R.id.sat_box_schedule})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_schedule:
                finish();
                break;
            case R.id.save_schedule:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.sun_box_schedule:
                setTabSelection(0);
                break;
            case R.id.mon_box_schedule:
                setTabSelection(1);
                break;
            case R.id.tue_box_schedule:
                setTabSelection(2);
                break;
            case R.id.web_box_schedule:
                setTabSelection(3);
                break;
            case R.id.thu_box_schedule:
                setTabSelection(4);
                break;
            case R.id.fri_box_schedule:
                setTabSelection(5);
                break;
            case R.id.sat_box_schedule:
                setTabSelection(6);
                break;
        }
    }

}
