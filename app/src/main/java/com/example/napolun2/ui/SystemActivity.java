package com.example.napolun2.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.napolun2.MainActivity;
import com.example.napolun2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SystemActivity extends AppCompatActivity {

    @BindView(R.id.dna_system)
    Button mDnaSystem;
    @BindView(R.id.hvac_system)
    Button mHvacSystem;

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
        setContentView(R.layout.activity_system);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.dna_system, R.id.hvac_system})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dna_system:
                startActivity(new Intent(this,Main2Activity.class));
                this.finish();
                break;
            case R.id.hvac_system:
                startActivity(new Intent(this,MainActivity.class));
                this.finish();
                break;
        }
    }
}
