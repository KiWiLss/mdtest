package com.magicsoft.qiuitest.thread;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.magicsoft.qiuitest.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 *     @author : Lss winding
 *     @e-mail : kiwilss@163.com
 *     @time   : 2018/2/24
 *     @desc   : ${DESCRIPTION}
 *     @version: ${VERSION}
 * </pre>
 */


public class ThreadActivity extends AppCompatActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);





    }

    int mThreadCount;
    public void display(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;  ; ) {
                    mThreadCount++;
                    SystemClock.sleep(1000);
                    Log.e(TAG, "run: thread---> "+mThreadCount );
                }

            }
        }).start();
    }


    public void threadPool(View view) {
        //new ThreadPoolExecutor()
        // 参数是要线程池的线程最大值
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "run: fixedthreadpool");
            }
        });
    }
}
