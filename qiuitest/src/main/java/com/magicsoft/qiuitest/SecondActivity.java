package com.magicsoft.qiuitest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * <pre>
 *     @author : Lss winding
 *     @e-mail : kiwilss@163.com
 *     @time   : 2018/2/23
 *     @desc   : ${DESCRIPTION}
 *     @version: ${VERSION}
 * </pre>
 */


public class SecondActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        mTv = (TextView) findViewById(R.id.tv_second_one);

    }
}
