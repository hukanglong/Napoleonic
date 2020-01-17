package com.example.napolun2.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.napolun2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SleepFragment extends Fragment {

    @BindView(R.id.off_sleep_frag)
    RadioButton mOffSleepFrag;
    @BindView(R.id.on_sleep_frag)
    RadioButton mOnSleepFrag;
    @BindView(R.id.group_sleep_frag)
    RadioGroup mGroupSleepFrag;
    Unbinder unbinder;

    public SleepFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sleep, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mGroupSleepFrag.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.off_sleep_frag:
                        mGroupSleepFrag.setBackgroundResource(R.mipmap.off);
                        break;
                    case R.id.on_sleep_frag:
                        mGroupSleepFrag.setBackgroundResource(R.mipmap.offon);
                        break;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
