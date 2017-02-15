package com.andy2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class B_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick2C(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.c");
        intent.addCategory("android.intent.category.c");
        startActivity(intent);
    }

    public void onClick2D(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.d");
        intent.addCategory("android.intent.category.d");
        startActivity(intent);
    }
}
