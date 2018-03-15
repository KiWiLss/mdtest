package com.magicsoft.mdtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void scroll(View view) {
        startActivity(new Intent(this,ScrollingActivity.class));
    }

    public void snackbar(View view) {
        startActivity(new Intent(this,SnakeBarActivity.class));
    }

    public void collasping(View view) {
        startActivity(new Intent(this,CollaspingActivity.class));
    }

    public void footerbehaivor(View view) {
        startActivity(new Intent(this,FootBehaivorActivity.class));
    }

    public void tablayout(View view) {
        startActivity(new Intent(this,TabLayoutActivity.class));
    }

    public void collaspingTest(View view) {
        startActivity(new Intent(this,CollaspingTestActivity.class));
    }

    public void bookdetail(View view) {
        startActivity(new Intent(this,BookDetailActivity.class));
    }

    public void behaviorTop(View view) {
        startActivity(new Intent(this,TopBehaviorActivity.class));
    }
}
