package com.magicsoft.qiuitest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.magicsoft.qiuitest.R;

/**
 * <pre>
 *     @author : Lss winding
 *     @e-mail : kiwilss@163.com
 *     @time   : 2018/2/25
 *     @desc   : ${DESCRIPTION}
 *     @version: ${VERSION}
 * </pre>
 */


public class FragmentActivity extends AppCompatActivity {
    private android.widget.FrameLayout fl;
    private FragmentManager mFm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        this.fl = (FrameLayout) findViewById(R.id.fl);

        mFm = getSupportFragmentManager();




    }

    public void oneListener(View view) {

    }

    public void twoListener(View view) {

    }

    public void threeListener(View view) {

    }
}
