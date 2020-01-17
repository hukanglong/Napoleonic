package com.example.napolun2.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.napolun2.MainActivity;
import com.example.napolun2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlarmFragment extends Fragment {


    @BindView(R.id.title_alarm)
    TextView mTitleAlarm;
    @BindView(R.id.clear_alarm)
    TextView mClearAlarm;
    Unbinder unbinder;
    @BindView(R.id.msg_alarm)
    TextView mMsgAlarm;

    public AlarmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alarm, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.clear_alarm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.clear_alarm:
                mMsgAlarm.setVisibility(View.GONE);
                break;
        }
    }
}
