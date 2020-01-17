package com.example.napolun2.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.napolun2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends Fragment {


    @BindView(R.id.minus_call)
    ImageView mMinusCall;
    @BindView(R.id.min_call)
    TextView mMinCall;
    @BindView(R.id.add_call)
    ImageView mAddCall;
    Unbinder unbinder;
    private String[] mS1;
    private int mNum;

    public CallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        String s = mMinCall.getText().toString();
        mS1 = s.split(" ");
        mNum = Integer.parseInt(mS1[0]);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.minus_call, R.id.add_call})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.minus_call:
                if (mNum>-10){
                    mNum--;
                    String s = String.valueOf(mNum);
                    mMinCall.setText(s+mS1[1]);
                    if (mNum == -10 ){
                        mMinusCall.setImageDrawable(getResources().getDrawable(R.mipmap.minus_no));
                    }
                    mAddCall.setImageDrawable(getResources().getDrawable(R.mipmap.add_ok));
                }
                break;
            case R.id.add_call:
                if (mNum<10){
                    mNum++;
                    String s = String.valueOf(mNum);
                    mMinCall.setText(s+mS1[1]);
                    if (mNum == 10 ){
                        mAddCall.setImageDrawable(getResources().getDrawable(R.mipmap.add_no));
                    }
                    mMinusCall.setImageDrawable(getResources().getDrawable(R.mipmap.minus_ok));
                }
                break;
        }
    }
}
