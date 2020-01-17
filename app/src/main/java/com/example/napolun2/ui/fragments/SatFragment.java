package com.example.napolun2.ui.fragments;


import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.napolun2.R;
import com.example.napolun2.ui.adapters.FanScheAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SatFragment extends Fragment {

    @BindView(R.id.time_schedule)
    TextView mTimeSchedule;
    @BindView(R.id.heat_schedule)
    TextView mHeatSchedule;
    @BindView(R.id.cool_schedule)
    TextView mCoolSchedule;
    @BindView(R.id.fan_schedule)
    TextView mFanSchedule;
    @BindView(R.id.personal_schedule)
    TextView mPersonalSchedule;
    @BindView(R.id.time1_btn)
    Button mTime1Btn;
    @BindView(R.id.time2_btn)
    Button mTime2Btn;
    @BindView(R.id.time3_btn)
    Button mTime3Btn;
    @BindView(R.id.time4_btn)
    Button mTime4Btn;
    @BindView(R.id.heat1_btn)
    Button mHeat1Btn;
    @BindView(R.id.heat2_btn)
    Button mHeat2Btn;
    @BindView(R.id.heat3_btn)
    Button mHeat3Btn;
    @BindView(R.id.heat4_btn)
    Button mHeat4Btn;
    @BindView(R.id.cool1_btn)
    Button mCool1Btn;
    @BindView(R.id.cool2_btn)
    Button mCool2Btn;
    @BindView(R.id.cool3_btn)
    Button mCool3Btn;
    @BindView(R.id.cool4_btn)
    Button mCool4Btn;
    @BindView(R.id.fan1_btn)
    Button mFan1Btn;
    @BindView(R.id.fan2_btn)
    Button mFan2Btn;
    @BindView(R.id.fan3_btn)
    Button mFan3Btn;
    @BindView(R.id.fan4_btn)
    Button mFan4Btn;
    @BindView(R.id.per1_btn)
    Button mPer1Btn;
    @BindView(R.id.per2_btn)
    Button mPer2Btn;
    @BindView(R.id.per3_btn)
    Button mPer3Btn;
    @BindView(R.id.per4_btn)
    Button mPer4Btn;
    @BindView(R.id.paret_schedule)
    ConstraintLayout mParetSchedule;
    Unbinder unbinder;
    private int mHour;
    private int mMin;
    private List<String> mFan;
    private List<String> mMtemp;

    public SatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mon, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mFan = new ArrayList<>();
        mFan.add("OFF");
        mFan.add("AUTO");
        mFan.add("CIRCULATE");
        mFan.add("HIGH");
        mFan.add("MEDIUM");
        mFan.add("LOW");
        mMtemp = new ArrayList<>();
        for (int i = 60; i <= 80; i++) {
            mMtemp.add(i+"℉");
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.time1_btn, R.id.time2_btn, R.id.time3_btn, R.id.time4_btn, R.id.heat1_btn, R.id.heat2_btn, R.id.heat3_btn, R.id.heat4_btn, R.id.cool1_btn, R.id.cool2_btn, R.id.cool3_btn, R.id.cool4_btn, R.id.fan1_btn, R.id.fan2_btn, R.id.fan3_btn, R.id.fan4_btn, R.id.per1_btn, R.id.per2_btn, R.id.per3_btn, R.id.per4_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.time1_btn:
                showPopupTime(mTime1Btn);
                break;
            case R.id.time2_btn:
                showPopupTime(mTime2Btn);
                break;
            case R.id.time3_btn:
                showPopupTime(mTime3Btn);
                break;
            case R.id.time4_btn:
                showPopupTime(mTime4Btn);
                break;
            case R.id.heat1_btn:
                showPopu(mMtemp,mHeat1Btn,"Head");
                break;
            case R.id.heat2_btn:
                showPopu(mMtemp,mHeat2Btn,"Head");
                break;
            case R.id.heat3_btn:
                showPopu(mMtemp,mHeat3Btn,"Head");
                break;
            case R.id.heat4_btn:
                showPopu(mMtemp,mHeat4Btn,"Head");
                break;
            case R.id.cool1_btn:
                showPopu(mMtemp,mCool1Btn,"Cool");
                break;
            case R.id.cool2_btn:
                showPopu(mMtemp,mCool2Btn,"Cool");
                break;
            case R.id.cool3_btn:
                showPopu(mMtemp,mCool3Btn,"Cool");
                break;
            case R.id.cool4_btn:
                showPopu(mMtemp,mCool4Btn,"Cool");
                break;
            case R.id.fan1_btn:
                showPopupFan(mFan1Btn);
                break;
            case R.id.fan2_btn:
                showPopupFan(mFan2Btn);
                break;
            case R.id.fan3_btn:
                showPopupFan(mFan3Btn);
                break;
            case R.id.fan4_btn:
                showPopupFan(mFan4Btn);
                break;
            case R.id.per1_btn:
                break;
            case R.id.per2_btn:
                break;
            case R.id.per3_btn:
                break;
            case R.id.per4_btn:
                break;
        }
    }

    private void showPopu(final List<String> list, final TextView text, final String title) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.popu_fan_sche, null);
        TextView name = view.findViewById(R.id.name_popu);
        name.setText(title);
        RecyclerView rlv = view.findViewById(R.id.rlv_fan);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        FanScheAdapter fanScheAdapter = new FanScheAdapter(getActivity(), list);
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
        popupWindow.showAtLocation(mParetSchedule, Gravity.CENTER, 0, 0);
    }

    private void showPopupFan(final Button fanBtn) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.popu_fan_sche, null);
        RecyclerView rlv = view.findViewById(R.id.rlv_fan);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        FanScheAdapter fanScheAdapter = new FanScheAdapter(getActivity(), mFan);
        rlv.setAdapter(fanScheAdapter);

        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        fanScheAdapter.setMyOnclick(new FanScheAdapter.MyOnclick() {
            @Override
            public Void onClick(int position) {
                fanBtn.setText(mFan.get(position));
                popupWindow.dismiss();
                return null;
            }
        });
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(mParetSchedule, Gravity.CENTER,0,0);
    }

    private void showPopupTime(final Button time) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.popu_time, null);
        TimePicker tp = view.findViewById(R.id.tp_time);
        tp.setDescendantFocusability(TimePicker.FOCUS_BLOCK_DESCENDANTS);
        tp.setIs24HourView(true);
        Calendar cal = Calendar.getInstance();
        tp.setCurrentHour(7);
        tp.setCurrentMinute(30);
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMin = minute;
            }
        });
        TextView ok = view.findViewById(R.id.ok_popu);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(mParetSchedule, Gravity.CENTER,0,0);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setText(mHour+":"+mMin);
                popupWindow.dismiss();
            }
        });
    }
}
