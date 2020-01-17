package com.example.napolun2.ui.fragments;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.napolun2.R;
import com.example.napolun2.customview.IndicatorSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackFragment extends Fragment {


    @BindView(R.id.seekbar_back)
    IndicatorSeekBar mSeekbarBack;
    @BindView(R.id.zero_back)
    TextView mZeroBack;
    Unbinder unbinder;
    @BindView(R.id.tv_indicator)
    TextView mTvIndicator;
    @BindView(R.id.lin_back)
    LinearLayout mLinBack;
    private Paint mPaint = new Paint();

    public BackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_back, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        final LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mTvIndicator.getLayoutParams();
        mSeekbarBack.setOnSeekBarChangeListener(new IndicatorSeekBar.OnIndicatorSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, float indicatorOffset) {
                String indicatorText = progress + "%";
                mTvIndicator.setText(indicatorText);
                changeAppBrightness(progress);
                params.leftMargin = (int) indicatorOffset;
                mTvIndicator.setLayoutParams(params);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mTvIndicator.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //mTvIndicator.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void changeAppBrightness(int brightness) {

        Window window = getActivity().getWindow();

        WindowManager.LayoutParams lp = window.getAttributes();

        if (brightness == -1) {

            lp.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;

        } else {

            //需要注意的是，返回的亮度是介于0~255之间的int类型值（也是为什么我们将seekBar的MaxValue设置为255的原因）

            lp.screenBrightness = (brightness <= 0 ? 1 : brightness) / 255f;

        }

        window.setAttributes(lp);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
