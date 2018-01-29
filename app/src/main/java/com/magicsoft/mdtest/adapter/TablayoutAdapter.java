package com.magicsoft.mdtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magicsoft.mdtest.R;

import java.util.List;

/**
 * FileName: TablayoutAdapter
 * Description: ${DESCRIPTION}
 */

public class TablayoutAdapter extends RecyclerView.Adapter<TablayoutAdapter.ViewHolder>{

    private final LayoutInflater mInflater;

    public TablayoutAdapter(List<String> data, Context context) {
        mData = data;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    private List<String>mData;
    Context mContext;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_tablay,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
