package com.example.napolun2.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.napolun2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    int mTemp = 0;

    @BindView(R.id.set_head)
    Button mSetHead;
    @BindView(R.id.menu_head)
    Button mMenuHead;
    @BindView(R.id.big_head)
    ImageView mBigHead;
    @BindView(R.id.smll_head)
    TextView mSmllHead;
    @BindView(R.id.up_head)
    Button mUpHead;
    @BindView(R.id.down_head)
    Button mDownHead;
    @BindView(R.id.show_head)
    TextView mShowHead;
    @BindView(R.id.working_head)
    ImageView mWorkingHead;
    @BindView(R.id.num_head)
    TextView mNumHead;
    @BindView(R.id.unit_head)
    TextView mUnitHead;

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
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        String s = mSmllHead.getText().toString();
        int i = Integer.parseInt(s);
        mTemp = i;

        Intent intent = getIntent();
        byte[] appIcons = intent.getByteArrayExtra("img");
        if (appIcons != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(appIcons, 0, appIcons.length);
            mWorkingHead.setImageBitmap(bitmap);
        }

    }

    @OnClick({R.id.set_head, R.id.menu_head, R.id.big_head, R.id.smll_head, R.id.up_head, R.id.down_head, R.id.logon_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.set_head:
                startActivity(new Intent(this, WindActivity.class));
                this.finish();
                break;
            case R.id.menu_head:
                startActivity(new Intent(this, MenuActivity.class));
                break;
            case R.id.big_head:
                break;
            case R.id.smll_head:
                break;
            case R.id.up_head:
                if (mTemp < 80) {
                    mTemp++;
                } else {
                    mUpHead.setBackgroundResource(R.mipmap.downnone);
                }
                if (mTemp > 60) {
                    mDownHead.setBackgroundResource(R.mipmap.upc);
                }
                mSmllHead.setText(String.valueOf(mTemp));
                break;
            case R.id.down_head:

                if (mTemp > 60) {
                    mTemp--;
                } else {
                    mDownHead.setBackgroundResource(R.mipmap.upnone);
                }
                if (mTemp < 80) {
                    mUpHead.setBackgroundResource(R.mipmap.downc);
                }
                mSmllHead.setText(String.valueOf(mTemp));
                break;
            case R.id.logon_head:
                startActivity(new Intent(this, SystemActivity.class));
                this.finish();
                break;
        }
    }
}
