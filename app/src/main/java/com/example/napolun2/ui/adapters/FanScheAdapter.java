package com.example.napolun2.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.napolun2.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FanScheAdapter extends RecyclerView.Adapter<FanScheAdapter.MyHolder> {

    private Context mContext;
    private List<String> mList;

    public FanScheAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_fan, null);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        myHolder.mText.setText(mList.get(i));

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOnclick.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView mText;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private MyOnclick MyOnclick;

    public void setMyOnclick(FanScheAdapter.MyOnclick myOnclick) {
        MyOnclick = myOnclick;
    }

    public interface MyOnclick{
        Void onClick(int position);
    }

}
