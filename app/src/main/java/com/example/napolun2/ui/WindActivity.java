package com.example.napolun2.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.napolun2.MainActivity;
import com.example.napolun2.R;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WindActivity extends AppCompatActivity {

    @BindView(R.id.left_wind)
    ImageView mLeftWind;
    @BindView(R.id.auto_wind)
    ImageView mAutoWind;
    @BindView(R.id.manual_wind)
    ImageView mManualWind;
    @BindView(R.id.off_wind)
    ImageView mOffWind;
    @BindView(R.id.back_wind)
    Button mBackWind;
    private boolean checked = false;

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
        setContentView(R.layout.activity_wind);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.auto_wind, R.id.manual_wind, R.id.off_wind, R.id.back_wind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.auto_wind:
                mLeftWind.setBackgroundResource(R.mipmap.noneworking);
                mAutoWind.setBackgroundResource(R.mipmap.mm_03);
                mManualWind.setBackgroundResource(R.mipmap.rr_03);
                mOffWind.setBackgroundResource(R.mipmap.rr_03);
                checked = true;
                break;
            case R.id.manual_wind:
                mLeftWind.setBackgroundResource(R.mipmap.fanlogo);
                mAutoWind.setBackgroundResource(R.mipmap.rr_03);
                mManualWind.setBackgroundResource(R.mipmap.mm_03);
                mOffWind.setBackgroundResource(R.mipmap.rr_03);
                checked = true;
                break;
            case R.id.off_wind:
                mLeftWind.setBackgroundResource(R.mipmap.noneworking);
                mAutoWind.setBackgroundResource(R.mipmap.rr_03);
                mManualWind.setBackgroundResource(R.mipmap.rr_03);
                mOffWind.setBackgroundResource(R.mipmap.mm_03);
                checked = true;
                break;
            case R.id.back_wind:
                Intent intent = new Intent(this, Main2Activity.class);
                if (checked == true){
                    Drawable background = mLeftWind.getBackground();
                    drawableToBitamp(background);
                    byte[] bytes = bitmap2Bytes(bitmap);
                    intent.putExtra("img",bytes);
                }
                startActivity(intent);
                this.finish();
                break;
        }
    }

    private Bitmap bitmap;
    //drawable转化成bitmap的方法
    private void drawableToBitamp(Drawable drawable) {
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        System.out.println("Drawable转Bitmap");
        Bitmap.Config config =
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                        : Bitmap.Config.RGB_565;
        bitmap = Bitmap.createBitmap(w,h,config);
        //注意，下面三行代码要用到，否在在View或者surfaceview里的canvas.drawBitmap会看不到图
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
    }

    private byte[] bitmap2Bytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
