package com.magicsoft.deep;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.deep.imagelib.DeepImage;
import com.deep.imagelib.beans.ImageConfigure;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






    }
    @SuppressLint("SdCardPath")
    public void save(View view) {
        ImageConfigure configure = new ImageConfigure();
        configure.directoryname = "/sdcard/android";//目录名
        configure.filename = "beautiful.jpg";//文件名
        DeepImage deepImage = new DeepImage(MainActivity.this,R.drawable.image2,configure);

        deepImage.asFile();

    }
}
