package com.magicsoft.mdtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/29
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}//snakebar简单使用,toolbar上滑隐藏,下滑出现
 * </pre>
 */


public class SnakeBarActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snakebar);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @OnClick(R.id.fab)
    public void onClick() {

        Snackbar.make(mFab,"Snackbar",Snackbar.LENGTH_LONG).setAction("点击",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SnakeBarActivity.this, "Snackbar", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}
