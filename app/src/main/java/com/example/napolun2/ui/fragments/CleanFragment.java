package com.example.napolun2.ui.fragments;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.napolun2.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CleanFragment extends Fragment {


    @BindView(R.id.img_clean)
    ImageView mImgClean;
    @BindView(R.id.time_clean)
    TextView mTimeClean;
    @BindView(R.id.btn_clean)
    Button mBtnClean;
    Unbinder unbinder;
    int num = 30;
    private TimerTask mTimerTask;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                num--;
                mTimeClean.setText(num+"s");
                if (num == 0){
                    mTimerTask.cancel();
                }
            }
        }
    };

    public CleanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clean, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_clean)
    public void onViewClicked() {
        ObjectAnimator rotation = ObjectAnimator.ofFloat(mImgClean, "rotation", 0, 2160);
        rotation.setDuration(3000);
        rotation.start();

        Timer timer = new Timer();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(1);
            }
        };
        timer.schedule(mTimerTask,100,100);
    }
}
