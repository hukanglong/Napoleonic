package com.example.napolun2.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.napolun2.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.MyHolder> {

    private Context mContext;
    private ArrayList<String> mList;

    public OptionAdapter(Context context, ArrayList<String> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.option_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, final int i) {
        myHolder.mSetItem.setText(mList.get(i));

        myHolder.mSetItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MyOnclick.onClick(i);
                myHolder.mSetItem.setSelected(true);
            }
        });
        myHolder.mSetItem.setSelected(false);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.set_item)
        TextView mSetItem;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private MyOnclick MyOnclick;

    public void setMyOnclick(OptionAdapter.MyOnclick myOnclick) {
        MyOnclick = myOnclick;
    }

    public interface MyOnclick{
        void onClick(int position);
    }

}
