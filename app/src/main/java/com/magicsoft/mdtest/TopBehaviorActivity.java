package com.magicsoft.mdtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.magicsoft.mdtest.adapter.TablayoutAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/2/6
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class TopBehaviorActivity extends AppCompatActivity {
    @BindView(R.id.rv_top_behavior_list)
    RecyclerView mRvTopBehaviorList;
    @BindView(R.id.srl_top_behavior_refresh)
    SwipeRefreshLayout mSrlTopBehaviorRefresh;
    @BindView(R.id.et_top_behavior_input)
    EditText mEtTopBehaviorInput;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_behavior);
        ButterKnife.bind(this);

        initData();

        mSrlTopBehaviorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mSrlTopBehaviorRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSrlTopBehaviorRefresh.setRefreshing(false);
                    }
                }, 3000);

            }
        });
    }

    private void initData() {

        mData = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            mData.add("df");
        }
        mRvTopBehaviorList.setLayoutManager(new LinearLayoutManager(this));
        TablayoutAdapter adapter = new TablayoutAdapter(mData, this);
        mRvTopBehaviorList.setAdapter(adapter);
    }
}
