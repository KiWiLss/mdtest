package com.magicsoft.qiuitest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.magicsoft.qiuitest.R;
import com.magicsoft.qiuitest.SecondActivity;

/**
 * <pre>
 *     @author : Lss winding
 *     @e-mail : kiwilss@163.com
 *     @time   : 2018/2/25
 *     @desc   : ${DESCRIPTION}
 *     @version: ${VERSION}
 * </pre>
 */


public class FirstActivity extends AppCompatActivity {
    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Log.e(TAG, "first---onCreate: ");

        for (int i = 0; i < 10; i++) {
            Log.e(TAG, "onCreate: "+i );
            i++;
        }

        Log.e(TAG, "onCreate: 11111" );
        Log.e(TAG, "onCreate: 22222" );
        Log.e(TAG, "onCreate: 33333" );
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "first---onRestart: " );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "first---onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "first---onResume: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "first---onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "first---onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "first---onDestroy: " );
    }

    public void second(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }


}
