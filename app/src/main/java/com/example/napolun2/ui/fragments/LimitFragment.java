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
public class LimitFragment extends Fragment {


    @BindView(R.id.text_limit)
    TextView mTextLimit;
    @BindView(R.id.add_limit)
    ImageView mAddLimit;
    @BindView(R.id.num_limit)
    TextView mNumLimit;
    @BindView(R.id.minus_limit)
    ImageView mMinusLimit;
    Unbinder unbinder;
    private String[] mS1;
    private int mNum;

    public LimitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_limit, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mNum == 37 ){
            mAddLimit.setImageDrawable(getResources().getDrawable(R.mipmap.add_no));
        }
        String s = mNumLimit.getText().toString();
        mS1 = s.split(" ");
        mS1 = s.split(" ");
        mNum = Integer.parseInt(mS1[0]);
        if (mNum == 37 || mNum == 0){

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.add_limit, R.id.minus_limit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_limit:
                if (mNum<37){
                    mNum++;
                    String s = String.valueOf(mNum);
                    mNumLimit.setText(s+mS1[1]);
                }
                if (mNum == 37 ){
                    mAddLimit.setImageDrawable(getResources().getDrawable(R.mipmap.add_no));
                }
                mMinusLimit.setImageDrawable(getResources().getDrawable(R.mipmap.minus_ok));
                break;
            case R.id.minus_limit:
                if (mNum>0){
                    mNum--;
                    String s = String.valueOf(mNum);
                    mNumLimit.setText(s+mS1[1]);
                }
                if (mNum == 0 ){
                    mMinusLimit.setImageDrawable(getResources().getDrawable(R.mipmap.minus_no));
                }
                mAddLimit.setImageDrawable(getResources().getDrawable(R.mipmap.add_ok));
                break;
        }
    }
}
