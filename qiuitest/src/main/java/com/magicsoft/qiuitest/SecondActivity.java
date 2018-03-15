package com.magicsoft.qiuitest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

    public static final String TAG = "MMM";
    private TextView mTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        mTv = (TextView) findViewById(R.id.tv_second_one);


        Log.e(TAG, "second---onCreate: " );
        Log.e(TAG, "onCreate: 11111" );
        Log.e(TAG, "onCreate: 22222" );
        Log.e(TAG, "onCreate: 33333" );

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "second---onRestart: " );
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "sencond---onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "sencond---onResume: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "sencond---onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "sencond---onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "sencond---onDestroy: " );
    }




}
