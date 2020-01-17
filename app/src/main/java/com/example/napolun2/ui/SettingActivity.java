package com.example.napolun2.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.napolun2.MainActivity;
import com.example.napolun2.R;
import com.example.napolun2.ui.fragments.AlarmFragment;
import com.example.napolun2.ui.fragments.AutoFragment;
import com.example.napolun2.ui.fragments.BackFragment;
import com.example.napolun2.ui.fragments.CallFragment;
import com.example.napolun2.ui.fragments.CleanFragment;
import com.example.napolun2.ui.fragments.CompFragment;
import com.example.napolun2.ui.fragments.DtimeFragment;
import com.example.napolun2.ui.fragments.FactoryFragment;
import com.example.napolun2.ui.fragments.FanFragment;
import com.example.napolun2.ui.fragments.FilterFragment;
import com.example.napolun2.ui.fragments.HumFragment;
import com.example.napolun2.ui.fragments.LimitFragment;
import com.example.napolun2.ui.fragments.ProductFragment;
import com.example.napolun2.ui.fragments.ResetFragment;
import com.example.napolun2.ui.fragments.SwitchFragment;
import com.example.napolun2.ui.fragments.SystemFragment;
import com.example.napolun2.ui.fragments.TechFragment;
import com.example.napolun2.ui.fragments.TempFragment;
import com.example.napolun2.ui.fragments.TestFragment;
import com.example.napolun2.ui.fragments.UnitcFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.frag_setting)
    FrameLayout mFragSetting;
    @BindView(R.id.btn1_setting)
    RadioButton mBtn1Setting;
    @BindView(R.id.btn2_setting)
    RadioButton mBtn2Setting;
    @BindView(R.id.btn3_setting)
    RadioButton mBtn3Setting;
    @BindView(R.id.btn4_setting)
    RadioButton mBtn4Setting;
    @BindView(R.id.btn5_setting)
    RadioButton mBtn5Setting;
    @BindView(R.id.btn6_setting)
    RadioButton mBtn6Setting;
    @BindView(R.id.btn7_setting)
    RadioButton mBtn7Setting;
    @BindView(R.id.btn8_setting)
    RadioButton mBtn8Setting;
    @BindView(R.id.btn9_setting)
    RadioButton mBtn9Setting;
    @BindView(R.id.btn10_setting)
    RadioButton mBtn10Setting;
    @BindView(R.id.btn11_setting)
    RadioButton mBtn11Setting;
    @BindView(R.id.btn13_setting)
    RadioButton mBtn13Setting;
    @BindView(R.id.btn14_setting)
    RadioButton mBtn14Setting;
    @BindView(R.id.btn15_setting)
    RadioButton mBtn15Setting;
    @BindView(R.id.btn16_setting)
    RadioButton mBtn16Setting;
    @BindView(R.id.btn17_setting)
    RadioButton mBtn17Setting;
    @BindView(R.id.btn18_setting)
    RadioButton mBtn18Setting;
    @BindView(R.id.btn19_setting)
    RadioButton mBtn19Setting;
    @BindView(R.id.group_setting)
    RadioGroup mGroupSetting;
    @BindView(R.id.scr_setting)
    ScrollView mScrSetting;
    @BindView(R.id.back_setting)
    ImageView mBackSetting;
    @BindView(R.id.btn12_setting)
    RadioButton mBtn12Setting;
    @BindView(R.id.btn20_setting)
    RadioButton mBtn20Setting;
    private ArrayList<Fragment> mOptions;
    private int position = 11;
    private TempFragment mTempFragment;
    private CompFragment mCompFragment;
    private TestFragment mTestFragment;
    private CleanFragment mCleanFragment;
    private ResetFragment mResetFragment;
    private TechFragment mTechFragment;
    private ProductFragment mProductFragment;
    private FactoryFragment mFactoryFragment;
    private SwitchFragment mSwitchFragment;
    private FanFragment mFanFragment;
    private SystemFragment mSystemFragment;
    private UnitcFragment mUnitcFragment;
    private DtimeFragment mDtimeFragment;
    private BackFragment mBackFragment;
    private AutoFragment mAutoFragment;
    private FilterFragment mFilterFragment;
    private HumFragment mHumFragment;
    private CallFragment mCallFragment;
    private LimitFragment mLimitFragment;
    private int TEST = 1;
    private int TC = 2;
    private EditText mPass;
    private AlarmFragment mAlarmFragment;

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
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        setTabSelection(position);
        initView();
    }

    private void initView() {
        getOptions();
        mGroupSetting.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn1_setting:
                        setTabSelection(1);
                        break;
                    case R.id.btn2_setting:
                        setTabSelection(2);
                        break;
                    case R.id.btn3_setting:
                        setTabSelection(3);
                        break;
                    case R.id.btn4_setting:
                        setTabSelection(4);
                        break;
                    case R.id.btn5_setting:
                        setTabSelection(5);
                        break;
                    case R.id.btn6_setting:
                        setTabSelection(6);
                        break;
                    case R.id.btn7_setting:
                        setTabSelection(7);
                        break;
                    case R.id.btn8_setting:
                        setTabSelection(8);
                        break;
                    case R.id.btn9_setting:
                        //Inputpopup(TC);
                        setTabSelection(9);
                        break;
                    case R.id.btn10_setting:
                        setTabSelection(10);
                        break;
                    case R.id.btn11_setting:
                        setTabSelection(11);
                        break;
                    case R.id.btn12_setting:
                        setTabSelection(12);
                        break;
                    case R.id.btn13_setting:
                        setTabSelection(13);
                        break;
                    case R.id.btn14_setting:
                        setTabSelection(14);
                        break;
                    case R.id.btn15_setting:
                        setTabSelection(15);
                        break;
                    case R.id.btn16_setting:
                        setTabSelection(16);
                        break;
                    case R.id.btn17_setting:
                        setTabSelection(17);
                        break;
                    case R.id.btn18_setting:
                        setTabSelection(18);
                        break;
                    case R.id.btn19_setting:
                        setTabSelection(19);
                        break;
                    case R.id.btn20_setting:
                        setTabSelection(20);
                        break;
                }
            }
        });
    }

    private void Inputpopup(int test) {
        View view = LayoutInflater.from(this).inflate(R.layout.popu_input, null);
        mPass = view.findViewById(R.id.pass_popu);
        TextView cancle = view.findViewById(R.id.cancel_popu);
        TextView confirm = view.findViewById(R.id.confirm_popu);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = mPass.getText().toString();
                if (pass.equals("1234")) {
                    Toast.makeText(SettingActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                } else {
                    Toast.makeText(SettingActivity.this, "密码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(mFragSetting, Gravity.CENTER, 0, 0);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.3f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(params);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 1.0f;
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                getWindow().setAttributes(params);
            }
        });
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
            case 1:
                if (mTempFragment == null) {
                    mTempFragment = new TempFragment();
                    transaction.add(R.id.frag_setting, mTempFragment, "mTempFragment");
                } else {
                    transaction.show(mTempFragment);
                }
                break;
            case 2:
                if (mCompFragment == null) {
                    mCompFragment = new CompFragment();
                    transaction.add(R.id.frag_setting, mCompFragment, "mCompFragment");
                } else {
                    transaction.show(mCompFragment);
                }
                break;
            case 3:
                if (mTestFragment == null) {
                    mTestFragment = new TestFragment();
                    transaction.add(R.id.frag_setting, mTestFragment, "mTestFragment");
                } else {
                    transaction.show(mTestFragment);
                }
                break;
            case 4:
                if (mCleanFragment == null) {
                    mCleanFragment = new CleanFragment();
                    transaction.add(R.id.frag_setting, mCleanFragment, "mCleanFragment");
                } else {
                    transaction.show(mCleanFragment);
                }
                break;
            case 5:
                if (mResetFragment == null) {
                    mResetFragment = new ResetFragment();
                    transaction.add(R.id.frag_setting, mResetFragment, "mResetFragment");
                } else {
                    transaction.show(mResetFragment);
                }
                break;
            case 6:
                if (mTechFragment == null) {
                    mTechFragment = new TechFragment();
                    transaction.add(R.id.frag_setting, mTechFragment, "mTechFragment");
                } else {
                    transaction.show(mTechFragment);
                }
                break;
            case 7:
                if (mProductFragment == null) {
                    mProductFragment = new ProductFragment();
                    transaction.add(R.id.frag_setting, mProductFragment, "mProductFragment");
                } else {
                    transaction.show(mProductFragment);
                }
                break;
            case 8:
                if (mFactoryFragment == null) {
                    mFactoryFragment = new FactoryFragment();
                    transaction.add(R.id.frag_setting, mFactoryFragment, "mFactoryFragment");
                } else {
                    transaction.show(mFactoryFragment);
                }
                break;
            case 9:
                if (mSwitchFragment == null) {
                    mSwitchFragment = new SwitchFragment();
                    transaction.add(R.id.frag_setting, mSwitchFragment, "mSwitchFragment");
                } else {
                    transaction.show(mSwitchFragment);
                }
                break;
            case 10:
                if (mFanFragment == null) {
                    mFanFragment = new FanFragment();
                    transaction.add(R.id.frag_setting, mFanFragment, "mFanFragment");
                } else {
                    transaction.show(mFanFragment);
                }
                break;
            case 11:
                if (mSystemFragment == null) {
                    mSystemFragment = new SystemFragment();
                    transaction.add(R.id.frag_setting, mSystemFragment, "mSystemFragment");
                } else {
                    transaction.show(mSystemFragment);
                }
                break;
            case 12:
                if (mUnitcFragment == null) {
                    mUnitcFragment = new UnitcFragment();
                    transaction.add(R.id.frag_setting, mUnitcFragment, "mUnitcFragment");
                } else {
                    transaction.show(mUnitcFragment);
                }
                break;
            case 13:
                if (mDtimeFragment == null) {
                    mDtimeFragment = new DtimeFragment();
                    transaction.add(R.id.frag_setting, mDtimeFragment, "mDtimeFragment");
                } else {
                    transaction.show(mDtimeFragment);
                }
                break;
            case 14:
                if (mBackFragment == null) {
                    mBackFragment = new BackFragment();
                    transaction.add(R.id.frag_setting, mBackFragment, "mBackFragment");
                } else {
                    transaction.show(mBackFragment);
                }
                break;
            case 15:
                if (mAutoFragment == null) {
                    mAutoFragment = new AutoFragment();
                    transaction.add(R.id.frag_setting, mAutoFragment, "mAutoFragment");
                } else {
                    transaction.show(mAutoFragment);
                }
                break;
            case 16:
                if (mFilterFragment == null) {
                    mFilterFragment = new FilterFragment();
                    transaction.add(R.id.frag_setting, mFilterFragment, "mFilterFragment");
                } else {
                    transaction.show(mFilterFragment);
                }
                break;
            case 17:
                if (mHumFragment == null) {
                    mHumFragment = new HumFragment();
                    transaction.add(R.id.frag_setting, mHumFragment, "mHumFragment");
                } else {
                    transaction.show(mHumFragment);
                }
                break;
            case 18:
                if (mCallFragment == null) {
                    mCallFragment = new CallFragment();
                    transaction.add(R.id.frag_setting, mCallFragment, "mCallFragment");
                } else {
                    transaction.show(mCallFragment);
                }
                break;
            case 19:
                if (mLimitFragment == null) {
                    mLimitFragment = new LimitFragment();
                    transaction.add(R.id.frag_setting, mLimitFragment, "mLimitFragment");
                } else {
                    transaction.show(mLimitFragment);
                }
                break;
            case 20:
                if (mAlarmFragment == null) {
                    mAlarmFragment = new AlarmFragment();
                    transaction.add(R.id.frag_setting, mAlarmFragment, "mAlarmFragment");
                } else {
                    transaction.show(mAlarmFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mTempFragment != null)
            transaction.hide(mTempFragment);
        if (mCompFragment != null)
            transaction.hide(mCompFragment);
        if (mTestFragment != null)
            transaction.hide(mTestFragment);
        if (mCleanFragment != null)
            transaction.hide(mCleanFragment);
        if (mResetFragment != null)
            transaction.hide(mResetFragment);
        if (mTechFragment != null)
            transaction.hide(mTechFragment);
        if (mProductFragment != null)
            transaction.hide(mProductFragment);
        if (mFactoryFragment != null)
            transaction.hide(mFactoryFragment);
        if (mSwitchFragment != null)
            transaction.hide(mSwitchFragment);
        if (mFanFragment != null)
            transaction.hide(mFanFragment);
        if (mSystemFragment != null)
            transaction.hide(mSystemFragment);
        if (mUnitcFragment != null)
            transaction.hide(mUnitcFragment);
        if (mDtimeFragment != null)
            transaction.hide(mDtimeFragment);
        if (mBackFragment != null)
            transaction.hide(mBackFragment);
        if (mAutoFragment != null)
            transaction.hide(mAutoFragment);
        if (mFilterFragment != null)
            transaction.hide(mFilterFragment);
        if (mHumFragment != null)
            transaction.hide(mHumFragment);
        if (mCallFragment != null)
            transaction.hide(mCallFragment);
        if (mLimitFragment != null)
            transaction.hide(mLimitFragment);
        if (mAlarmFragment != null)
            transaction.hide(mAlarmFragment);
        transaction.commit();
    }

    private void getOptions() {
        mOptions = new ArrayList<>();
        mOptions.add(new TempFragment());
        mOptions.add(new CompFragment());
        mOptions.add(new TestFragment());
        mOptions.add(new CleanFragment());
        mOptions.add(new ResetFragment());
        mOptions.add(new TechFragment());
        mOptions.add(new ProductFragment());
        mOptions.add(new FactoryFragment());
        mOptions.add(new SwitchFragment());
        mOptions.add(new FanFragment());
        mOptions.add(new SystemFragment());
        mOptions.add(new UnitcFragment());
        mOptions.add(new DtimeFragment());
        mOptions.add(new BackFragment());
        mOptions.add(new AutoFragment());
        mOptions.add(new FilterFragment());
        mOptions.add(new HumFragment());
        mOptions.add(new CallFragment());
        mOptions.add(new LimitFragment());
        mOptions.add(new AlarmFragment());
    }

    @OnClick(R.id.back_setting)
    public void onViewClicked() {
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }
}
