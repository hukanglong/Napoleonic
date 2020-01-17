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
public class TempFragment extends Fragment {


    @BindView(R.id.text_temp)
    TextView mTextTemp;
    @BindView(R.id.add_temp)
    ImageView mAddTemp;
    @BindView(R.id.num_temp)
    TextView mNumTemp;
    @BindView(R.id.minus_temp)
    ImageView mMinusTemp;
    Unbinder unbinder;
    private int mNum;
    private String[] mS1;

    public TempFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temp, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String s = mNumTemp.getText().toString();
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

    @OnClick({R.id.add_temp, R.id.minus_temp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_temp:
                if (mNum<37){
                    mNum++;
                    String s = String.valueOf(mNum);
                    mNumTemp.setText(s+mS1[1]);
                    if (mNum == 37 ){
                        mAddTemp.setImageDrawable(getResources().getDrawable(R.mipmap.add_no));
                    }
                    mMinusTemp.setImageDrawable(getResources().getDrawable(R.mipmap.minus_ok));
                }
                break;
            case R.id.minus_temp:
                if (mNum>0){
                    mNum--;
                    String s = String.valueOf(mNum);
                    mNumTemp.setText(s+mS1[1]);
                }
                if (mNum == 0 ){
                    mMinusTemp.setImageDrawable(getResources().getDrawable(R.mipmap.minus_no));
                }
                mAddTemp.setImageDrawable(getResources().getDrawable(R.mipmap.add_ok));
                break;
        }
    }
}
