package com.example.napolun2.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.napolun2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FactoryFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.one_factory)
    TextView mOneFactory;
    @BindView(R.id.two_factory)
    TextView mTwoFactory;
    @BindView(R.id.three_factory)
    TextView mThreeFactory;
    @BindView(R.id.five_factory)
    TextView mFiveFactory;
    @BindView(R.id.text_factory)
    TextView mTextFactory;
    @BindView(R.id.rela_factory)
    RelativeLayout mRelaFactory;
    private EditText mName;
    private EditText mPass;

    public FactoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_factory, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.one_factory, R.id.two_factory, R.id.three_factory, R.id.five_factory})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.one_factory:
                mRelaFactory.setVisibility(View.GONE);
                mTextFactory.setVisibility(View.VISIBLE);
                break;
            case R.id.two_factory:
                mRelaFactory.setVisibility(View.GONE);
                mTextFactory.setVisibility(View.VISIBLE);
                break;
            case R.id.three_factory:
                mRelaFactory.setVisibility(View.GONE);
                mTextFactory.setVisibility(View.VISIBLE);
                break;
            case R.id.five_factory:
                mRelaFactory.setVisibility(View.GONE);
                mTextFactory.setVisibility(View.VISIBLE);
                break;
        }
    }
}
