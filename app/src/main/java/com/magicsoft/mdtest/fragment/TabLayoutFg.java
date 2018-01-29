package com.magicsoft.mdtest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magicsoft.mdtest.R;
import com.magicsoft.mdtest.adapter.TablayoutAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * FileName: TabLayoutFg
 * Description: ${DESCRIPTION}
 */

public class TabLayoutFg extends Fragment {

    @BindView(R.id.tv_fg_title)
    TextView mTvFgTitle;
    @BindView(R.id.rv_fg_list)
    RecyclerView mRvFgList;
    Unbinder unbinder;
    private ArrayList<String> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablayout, container, false);

        unbinder = ButterKnife.bind(this, view);


        mData = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            mData.add("df");
        }
        mRvFgList.setLayoutManager(new LinearLayoutManager(getContext()));
        TablayoutAdapter adapter = new TablayoutAdapter(mData, getContext());
        mRvFgList.setAdapter(adapter);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
