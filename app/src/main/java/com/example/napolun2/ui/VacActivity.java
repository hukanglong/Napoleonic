package com.example.napolun2.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.napolun2.MainActivity;
import com.example.napolun2.R;
import com.example.napolun2.ui.adapters.FanScheAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VacActivity extends AppCompatActivity {

    @BindView(R.id.days_vac)
    TextView mDaysVac;
    @BindView(R.id.temp_vac)
    TextView mTempVac;
    @BindView(R.id.back_vac)
    ImageView mBackVac;
    @BindView(R.id.save_vac)
    TextView mSaveVac;
    @BindView(R.id.con_vac)
    ConstraintLayout mConVac;
    private List<String> mDays;
    private List<String> mTemp;

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
        setContentView(R.layout.activity_vac);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mDays = new ArrayList<>();
        for (int i = 0; i < 365; i+=30) {
            mDays.add(i+"");
        }
        mDays.add(365+"");
        mTemp = new ArrayList<>();
        for (int i = 5; i <= 37; i++) {
            mTemp.add(i + "");
        }
    }

    @OnClick({R.id.days_vac, R.id.temp_vac, R.id.back_vac, R.id.save_vac})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.days_vac:
                showPopu(mDays, mDaysVac,"Vacation");
                break;
            case R.id.temp_vac:
                showPopu(mTemp, mTempVac,"Temp");
                break;
            case R.id.back_vac:
                finish();
                break;
            case R.id.save_vac:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }
    }

    private void showPopu(final List<String> list, final TextView text, final String title) {
        View view = LayoutInflater.from(this).inflate(R.layout.popu_fan_sche, null);
        TextView name = view.findViewById(R.id.name_popu);
        name.setText(title);
        RecyclerView rlv = view.findViewById(R.id.rlv_fan);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        FanScheAdapter fanScheAdapter = new FanScheAdapter(this, list);
        rlv.setAdapter(fanScheAdapter);

        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        fanScheAdapter.setMyOnclick(new FanScheAdapter.MyOnclick() {
            @Override
            public Void onClick(int position) {
                text.setText(list.get(position));
                popupWindow.dismiss();
                return null;
            }
        });
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(mConVac, Gravity.CENTER, 0, 0);
    }
}
