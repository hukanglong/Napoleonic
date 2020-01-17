package com.example.napolun2.ui.fragments;


import android.annotation.SuppressLint;
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
public class SystemFragment extends Fragment {

    @BindView(R.id.h1c1_system)
    RadioButton mH1c1System;
    @BindView(R.id.h1c2_system)
    RadioButton mH1c2System;
    @BindView(R.id.h2c1_system)
    RadioButton mH2c1System;
    @BindView(R.id.group_system)
    RadioGroup mGroupSystem;
    @BindView(R.id.h2c2_system)
    RadioButton mH2c2System;
    @BindView(R.id.inverter_system)
    RadioButton mInveterSystem;
    @BindView(R.id.group2_system)
    RadioGroup mGroup2System;
    Unbinder unbinder;

    public SystemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_system, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mGroupSystem.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                boolean isSelect = false;
                if(group != null&& !isSelect &&  checkedId > -1 ){
                    isSelect = true;
                    mGroup2System.clearCheck();
                    isSelect = false;
                }
                switch (checkedId){
                    case R.id.h1c1_system:

                        break;
                    case R.id.h1c2_system:

                        break;
                    case R.id.h2c1_system:

                        break;
                }
            }
        });

        mGroup2System.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.h2c2_system:

                        break;
                    case R.id.inverter_system:

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
