package com.magicsoft.deep;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.deep.imagelib.DeepImage;
import com.deep.imagelib.beans.ImageConfigure;
import com.magicsoft.deep.code.VertifyActivity;

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

    public void constraint(View view) {
        startActivity(new Intent(this,ConstraintActivity.class));
    }

    public void edit(View view) {
        startActivity(new Intent(this,EditActivity.class));
    }

    public void vertify(View view) {
        startActivity(new Intent(this,VertifyActivity.class));
    }
}
