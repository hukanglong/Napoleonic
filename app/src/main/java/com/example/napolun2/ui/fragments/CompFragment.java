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
public class CompFragment extends Fragment {


    @BindView(R.id.text_comp)
    TextView mTextComp;
    @BindView(R.id.add_comp)
    ImageView mAddComp;
    @BindView(R.id.min_comp)
    TextView mMinComp;
    @BindView(R.id.minus_comp)
    ImageView mMinusComp;
    Unbinder unbinder;
    private int mMin;
    private String[] mS1;

    public CompFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comp, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String s = mMinComp.getText().toString();
        mS1 = s.split(" ");
        mMin = Integer.parseInt(mS1[0]);
        if (mMin == 10 || mMin == 0){

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.add_comp, R.id.minus_comp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_comp:
                if (mMin<10){
                    mMin++;
                    String s = String.valueOf(mMin);
                    mMinComp.setText(s+mS1[1]);
                }
                if (mMin == 10 ){
                    mAddComp.setImageDrawable(getResources().getDrawable(R.mipmap.add_no));
                }
                mMinusComp.setImageDrawable(getResources().getDrawable(R.mipmap.minus_ok));
                break;
            case R.id.minus_comp:
                if (mMin>0){
                    mMin--;
                    String m = String.valueOf(mMin);
                    mMinComp.setText(m+mS1[1]);
                }
                if (mMin == 0 ){
                    mMinusComp.setImageDrawable(getResources().getDrawable(R.mipmap.minus_no));
                }
                mAddComp.setImageDrawable(getResources().getDrawable(R.mipmap.add_ok));
                break;
        }
    }
}
