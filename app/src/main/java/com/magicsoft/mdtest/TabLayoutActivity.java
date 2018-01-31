package com.magicsoft.mdtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.magicsoft.mdtest.fragment.TabLayoutFg;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * FileName: TabLayoutActivity
 * Description: ${DESCRIPTION}
 */

public class TabLayoutActivity extends AppCompatActivity {
    @BindView(R.id.tb)
    TabLayout mTb;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.appbar)AppBarLayout mAppbar;
    private ArrayList<String> mTitle;
    private ArrayList<Fragment> mFgList;
    @BindView(R.id.srl)SwipeRefreshLayout mSrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        ButterKnife.bind(this);

        mTitle = new ArrayList<>();
        mFgList = new ArrayList<>();
        mTitle.add("测试一");
        mTitle.add("测试二");
        mTitle.add("测试三");
        for (int i = 0; i < 3; i++) {
            TabLayoutFg tabLayoutFg = new TabLayoutFg();
            mFgList.add(tabLayoutFg);
        }
        mVp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTb.setupWithViewPager(mVp);

        //mSrl.setEnabled(false);
        //设置样式刷新显示的位置
        mSrl.setProgressViewOffset(true, -20, 100);
        mSrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSrl.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSrl.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        mAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset>=0){
                    mSrl.setEnabled(true);
                }else {
                    mSrl.setEnabled(false);
                }
            }
        });

    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFgList.get(position);
        }

        @Override
        public int getCount() {
            return mTitle.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle.get(position);
        }
    }

}
