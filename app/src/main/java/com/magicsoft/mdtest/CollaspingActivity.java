package com.magicsoft.mdtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/29
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}toolbar 折叠
 * </pre>
 */


public class CollaspingActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ctl)
    CollapsingToolbarLayout mCtl;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collasping);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        // app:layout_anchor="@id/ctl"如果是collasping这在上移时不会消失
        // app:layout_anchor="@id/toolbar" 上移消失

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mCtl.setTitle("任意标题");
        mCtl.setTitleEnabled(true);//设置是否有标题
        //mCtl.setExpandedTitleTextColor();设置展开标题颜色
        //mCtl.setCollapsedTitleTextColor();//折叠标题颜色
        //mCtl.setCollapsedTitleGravity();设置折叠位置
        //mCtl.setCollapsedTitleTextAppearance();
        //mCtl.setExpandedTitleTextAppearance(R.style.CollaspingTextAppearance);
        //mCtl.setCollapsedTitleTextAppearance();
        // app:contentScrim="?attr/colorPrimary"使用主题背景
    }

    @OnClick(R.id.fab)
    public void onClick() {
        Snackbar.make(mFab, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
