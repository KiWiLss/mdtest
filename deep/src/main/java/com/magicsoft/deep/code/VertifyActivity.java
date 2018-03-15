package com.magicsoft.deep.code;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.magicsoft.deep.R;
import com.magicsoft.deep.utils.CodeUtils;

import java.util.Random;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/2/9
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class VertifyActivity extends AppCompatActivity {
    public static final String TAG = "MMM";
    private android.widget.ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertify);
        this.iv = (ImageView) findViewById(R.id.iv);

        Bitmap bitmap = CodeUtils.getInstance().createBitmap();
        iv.setImageBitmap(bitmap);





    }

    public void change(View view) {

        Random random = new Random();
        int i = random.nextInt();
        Log.e(TAG, "onCreate: "+i );

        int two = random.nextInt(20);
        Log.e(TAG, "change: --two--->"+two );


    /*    String code = CodeUtils.getInstance().createCode();
        Log.e(TAG, "change: "+code);
        Bitmap bitmap = CodeUtils.getInstance().createBitmap();
        iv.setImageBitmap(bitmap);
        String code1 = CodeUtils.getInstance().getCode();
        Log.e(TAG, "change: ---->"+code1 );*/
    }
}
