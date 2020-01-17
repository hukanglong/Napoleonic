package com.example.napolun2.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.napolun2.R;
import com.example.napolun2.customview.IndicatorSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HumFragment extends Fragment {


    @BindView(R.id.title_hum)
    TextView mTitleHum;
    @BindView(R.id.slideon_hum)
    TextView mSlideonHum;
    @BindView(R.id.line_hum)
    View mLineHum;
    Unbinder unbinder;
    @BindView(R.id.tv_indicator)
    TextView mTvIndicator;
    @BindView(R.id.seekbar_hum)
    IndicatorSeekBar mSeekbarHum;

    public HumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hum, container, false);
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
        mSeekbarHum.setOnSeekBarChangeListener(new IndicatorSeekBar.OnIndicatorSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, float indicatorOffset) {
                String indicatorText = progress + "%";
                mTvIndicator.setText(indicatorText);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.slideon_hum)
    public void onViewClicked() {
        if (mSlideonHum.getText().toString().equals("ON")) {
            mSlideonHum.setText("OFF");
            mSlideonHum.setBackgroundResource(R.mipmap.slideoff);
        } else {
            mSlideonHum.setText("ON");
            mSlideonHum.setBackgroundResource(R.mipmap.slideon);
        }
    }
}
