package com.example.napolun2.ui.fragments;


import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
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
public class ResetFragment extends Fragment {


    @BindView(R.id.text_reset)
    TextView mTextReset;
    @BindView(R.id.on_reset)
    TextView mOnReset;
    Unbinder unbinder;
    @BindView(R.id.rela_reset)
    RelativeLayout mRelaReset;
    private TextView mOk;

    public ResetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reset, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.on_reset)
    public void onViewClicked() {
        String s = mOnReset.getText().toString();
        if (s.equals("OFF")) {
            showPopu();
        }else {
            mOnReset.setText("OFF");
            mOnReset.setBackgroundResource(R.mipmap.slideoff);
        }
    }

    private void showPopu() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.popu_reset, null);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mOk = view.findViewById(R.id.ok_reset);
        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnReset.setText("ON");
                mOnReset.setBackgroundResource(R.mipmap.slideon);

                popupWindow.dismiss();
            }
        });
        TextView no = view.findViewById(R.id.no_reset);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(mRelaReset, Gravity.CENTER, 0, 0);
    }
}
