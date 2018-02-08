package com.magicsoft.deep;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/2/8
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class EditActivity extends AppCompatActivity {


    public static final String TAG = "MMM";
    private android.widget.Button btn;
    private android.widget.Button btntop;
    private android.widget.Button btnbottom;
    private android.widget.ScrollView scrollview;
    private android.widget.EditText et;
    private android.widget.LinearLayout ll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        this.ll = (LinearLayout) findViewById(R.id.ll);
        this.et = (EditText) findViewById(R.id.et);
        this.scrollview = (ScrollView) findViewById(R.id.scrollview);
        this.btnbottom = (Button) findViewById(R.id.btn_bottom);
        this.btntop = (Button) findViewById(R.id.btn_top);
        this.btn = (Button) findViewById(R.id.btn);


        btntop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollview.fullScroll(ScrollView.FOCUS_UP);
            }
        });

        btnbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //scrollview.fullScroll(ScrollView.FOCUS_DOWN);
                et.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollview.smoothScrollTo(0,scrollview.getHeight());
                    }
                });
            }
        });

        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.e(TAG, "onFocusChange: "+b);
            }
        });


        //监听软键盘是否显示或隐藏
        ll.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                ll.getWindowVisibleDisplayFrame(r);
                int screenHeight = ll.getRootView()
                        .getHeight();
                int heightDifference = screenHeight - (r.bottom);
                if (heightDifference > 200) {
                    //软键盘显示
                    Log.e(TAG, "onGlobalLayout: 显示" );
// changeKeyboardHeight(heightDifference);
                    scrollview.fullScroll(ScrollView.FOCUS_DOWN);
                } else {
                    //软键盘隐藏
                    Log.e(TAG, "onGlobalLayout: 隐藏" );
                }



            }
        });

    }




}
