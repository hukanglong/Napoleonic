package com.example.napolun2;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.napolun2.ui.ScheduleActivity;
import com.example.napolun2.ui.SettingActivity;
import com.example.napolun2.ui.SystemActivity;
import com.example.napolun2.ui.VacActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.temp_main)
    ImageView mTempMain;
    @BindView(R.id.num_main)
    TextView mNumMain;
    @BindView(R.id.unit_mian)
    TextView mUnitMian;
    @BindView(R.id.mode_main)
    RadioButton mModeMain;
    @BindView(R.id.fan_main)
    RadioButton mFanMain;
    @BindView(R.id.schedule_main)
    RadioButton mScheduleMain;
    @BindView(R.id.set_main)
    RadioButton mSetMain;
    @BindView(R.id.group_main)
    RadioGroup mGroupMain;
    @BindView(R.id.setto_main)
    TextView mSettoMain;
    @BindView(R.id.settemp_main)
    TextView mSettempMain;
    @BindView(R.id.dot_main)
    ImageView mDotMain;
    @BindView(R.id.up_main)
    Button mUpMain;
    @BindView(R.id.down_main)
    Button mDownMain;
    @BindView(R.id.am_main)
    TextView mAmMain;
    @BindView(R.id.time_main)
    TextView mTimeMain;
    @BindView(R.id.date_main)
    TextView mDateMain;
    @BindView(R.id.dateimg_main)
    ImageView mDateimgMain;
    @BindView(R.id.logon_main)
    ImageView mLogonMain;
    @BindView(R.id.state_main)
    TextView mStateMain;
    private int mTemp = 0;
    private int mMode = 0;
    private int mFan = 0;
    private RadioButton mHeatModePopu;
    private RadioButton mCoolModePopu;
    private RadioButton mAutoModePopu;
    private RadioButton mEmheatModePopu;
    private RadioButton mOffModePopu;
    private RadioButton mOnBtnMain;
    private RadioButton mAutoBtnMain;
    private RadioButton mCirBtnMain;
    private RadioButton mHighBtnMain;
    private RadioButton mMediumBtnMain;
    private RadioButton mLowBtnMain;
    private int mNum;

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
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        String s = mSettempMain.getText().toString();
        mTemp = Integer.parseInt(s);
        String s1 = mNumMain.getText().toString();
        mNum = Integer.parseInt(s1);

        if (mTemp > mNum){
            mStateMain.setText("Heat on");
        }else if (mTemp < mNum){
            mStateMain.setText("Cool on");
        }

        mGroupMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.mode_main:
                        showPop("mode");
                        mGroupMain.setBackgroundResource(R.mipmap.m1);
                        if (mMode == 0) {
                            mHeatModePopu.setChecked(true);
                        } else if (mMode == 1) {
                            mCoolModePopu.setChecked(true);
                        } else if (mMode == 2) {
                            mAutoModePopu.setChecked(true);
                        } else if (mMode == 3) {
                            mEmheatModePopu.setChecked(true);
                        } else if (mMode == 4) {
                            mOffModePopu.setChecked(true);
                        }
                        break;
                    case R.id.fan_main:
                        showPop("fan");
                        mGroupMain.setBackgroundResource(R.mipmap.m2);
                        if (mFan == 0) {
                            mOnBtnMain.setChecked(true);
                        } else if (mFan == 1) {
                            mAutoBtnMain.setChecked(true);
                        } else if (mFan == 2) {
                            mCirBtnMain.setChecked(true);
                        } else if (mFan == 3) {
                            mHighBtnMain.setChecked(true);
                        } else if (mFan == 4) {
                            mMediumBtnMain.setChecked(true);
                        } else if (mFan == 5) {
                            mLowBtnMain.setChecked(true);
                        }
                        break;
                    case R.id.schedule_main:
                        showPop("schedule");
                        mGroupMain.setBackgroundResource(R.mipmap.m3);
                        break;
                    case R.id.set_main:
                        mGroupMain.setBackgroundResource(R.mipmap.m0);
                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
                        finish();
                        break;
                }
            }
        });
    }

    private void showPop(String type) {
        if (type.equals("mode")) {
            View view = LayoutInflater.from(this).inflate(R.layout.popu_mode, null);
            mHeatModePopu = view.findViewById(R.id.heat_mode_popu);
            mCoolModePopu = view.findViewById(R.id.cool_mode_popu);
            mAutoModePopu = view.findViewById(R.id.auto_mode_popu);
            mEmheatModePopu = view.findViewById(R.id.emheat_mode_popu);
            mOffModePopu = view.findViewById(R.id.off_mode_popu);
            RadioGroup group = view.findViewById(R.id.mode_popu);
            final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.heat_mode_popu:
                            mModeMain.setText("Mode   [HEAT]");
                            mTempMain.setImageDrawable(getResources().getDrawable(R.mipmap.blue_y));
                            //popupWindow.dismiss();
                            mMode = 0;
                            break;
                        case R.id.cool_mode_popu:
                            mModeMain.setText("Mode   [COOL]");
                            mTempMain.setImageDrawable(getResources().getDrawable(R.mipmap.blue_c));
                            //popupWindow.dismiss();
                            mMode = 1;
                            break;
                        case R.id.auto_mode_popu:
                            mModeMain.setText("Mode   [AUTO]");
                            //popupWindow.dismiss();
                            mMode = 2;
                            break;
                        case R.id.emheat_mode_popu:
                            mModeMain.setText("Mode   [EM HEAT]");
                            //popupWindow.dismiss();
                            mMode = 3;
                            break;
                        case R.id.off_mode_popu:
                            mModeMain.setText("Mode   [OFF]");
                            //popupWindow.dismiss();
                            mMode = 4;
                            break;
                    }
                }
            });
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.setOutsideTouchable(true);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    changeBg();
                }
            });
            mGroupMain.clearCheck();
            popupWindow.showAsDropDown(mGroupMain, 0, -110);
        } else if (type.equals("fan")){
            View view = LayoutInflater.from(this).inflate(R.layout.popu_fan, null);
            mOnBtnMain = view.findViewById(R.id.on_btn_main);
            mAutoBtnMain = view.findViewById(R.id.auto_btn_main);
            mCirBtnMain = view.findViewById(R.id.cir_btn_main);
            mHighBtnMain = view.findViewById(R.id.high_btn_main);
            mMediumBtnMain = view.findViewById(R.id.medium_btn_main);
            mLowBtnMain = view.findViewById(R.id.low_btn_main);
            RadioGroup group = view.findViewById(R.id.setting_main);
            final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.on_btn_main:
                            mFanMain.setText("FAN   [OFF]");
                            mFan = 0;
                            //popupWindow.dismiss();
                            break;
                        case R.id.auto_btn_main:
                            mFanMain.setText("FAN   [AUTO]");
                            mFan = 1;
                            //popupWindow.dismiss();
                            break;
                        case R.id.cir_btn_main:
                            mFanMain.setText("FAN   [CIRCULATE]");
                            mFan = 2;
                            //popupWindow.dismiss();
                            break;
                        case R.id.high_btn_main:
                            mFanMain.setText("FAN   [HIGH]");
                            mFan = 3;
                            //popupWindow.dismiss();
                            break;
                        case R.id.medium_btn_main:
                            mFanMain.setText("FAN   [MEDIUM]");
                            mFan = 4;
                            //popupWindow.dismiss();
                            break;
                        case R.id.low_btn_main:
                            mFanMain.setText("FAN   [LOW]");
                            mFan = 5;
                            //popupWindow.dismiss();
                            break;
                    }
                }
            });
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.setOutsideTouchable(true);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    changeBg();
                }
            });
            mGroupMain.clearCheck();
            popupWindow.showAsDropDown(mGroupMain, 0, -110);
        }else {
            View view = LayoutInflater.from(this).inflate(R.layout.popu_schedule, null);
            RadioGroup sche = view.findViewById(R.id.sche_popu);
            final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            sche.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.diy_btn_main:
                            startActivity(new Intent(MainActivity.this, ScheduleActivity.class));
                            mGroupMain.setBackgroundResource(R.mipmap.m0);
                            popupWindow.dismiss();
                            break;
                        case R.id.vac_btn_main:
                            startActivity(new Intent(MainActivity.this, VacActivity.class));
                            mGroupMain.setBackgroundResource(R.mipmap.m0);
                            popupWindow.dismiss();
                            break;
                    }
                }
            });
            popupWindow.setFocusable(true);// 聚焦点击事件不会透传给下面的View
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.setOutsideTouchable(true);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    changeBg();
                }
            });
            mGroupMain.clearCheck();
            popupWindow.showAsDropDown(mScheduleMain, 0, -110);

        }
    }

    private void changeBg() {

        mGroupMain.setBackgroundResource(R.mipmap.m0);
        mModeMain.setChecked(false);
        mFanMain.setChecked(false);
        mScheduleMain.setChecked(false);
        mSetMain.setChecked(false);
    }

    @OnClick({R.id.unit_mian, R.id.up_main, R.id.down_main, R.id.logon_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.unit_mian:
                String s = mUnitMian.getText().toString();
                if (s.equals("℃")) {
                    mUnitMian.setText("℉");
                } else {
                    mUnitMian.setText("℃");
                }
                break;
            case R.id.up_main:
                if (mTemp < 80) {
                    mTemp++;
                } else {
                    mUpMain.setBackgroundResource(R.mipmap.up_no);
                }
                if (mTemp > 60) {
                    mDownMain.setBackgroundResource(R.mipmap.minus_d);
                }
                mSettempMain.setText(String.valueOf(mTemp));
                if (mTemp > mNum){
                    mStateMain.setText("Heat on");
                }
                break;
            case R.id.down_main:
                if (mTemp > 60) {
                    mTemp--;
                } else {
                    mDownMain.setBackgroundResource(R.mipmap.minus_no);
                }
                if (mTemp < 80) {
                    mUpMain.setBackgroundResource(R.mipmap.up_d);
                }
                mSettempMain.setText(String.valueOf(mTemp));
                if (mTemp < mNum){
                    mStateMain.setText("Cool on");
                }
                break;
            case R.id.logon_main:
                startActivity(new Intent(this, SystemActivity.class));
                this.finish();
                break;
        }
    }
}
