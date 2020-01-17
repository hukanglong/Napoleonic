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
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.napolun2.R;
import com.example.napolun2.ui.adapters.FanScheAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterFragment extends Fragment {


    @BindView(R.id.title_filter)
    TextView mTitleFilter;
    @BindView(R.id.zero_filter)
    TextView mZeroFilter;
    @BindView(R.id.time_filter)
    TextView mTimeFilter;
    @BindView(R.id.reset_filter)
    TextView mResetFilter;
    @BindView(R.id.days_filter)
    TextView mDaysFilter;
    @BindView(R.id.save_filter)
    TextView mSaveFilter;
    Unbinder unbinder;
    @BindView(R.id.con_filter)
    ConstraintLayout mConFilter;
    private List<String> mDays;

    public FilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mDays = new ArrayList<>();
        for (int i = 0; i < 365; i+=30) {
            mDays.add(i+"");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.zero_filter, R.id.time_filter, R.id.days_filter, R.id.save_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zero_filter:
                mDaysFilter.setText("0");
                break;
            case R.id.time_filter:

                break;
            case R.id.days_filter:
                showPopu(mDays,mDaysFilter,"Time");
                String time = mDaysFilter.getText().toString();
                String[] s = time.split(" ");
                mDaysFilter.setText(s[0]);
                break;
            case R.id.save_filter:

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
                text.setText(list.get(position)+" days");
                popupWindow.dismiss();
                return null;
            }
        });
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(mConFilter, Gravity.CENTER, 0, 0);
    }
}
