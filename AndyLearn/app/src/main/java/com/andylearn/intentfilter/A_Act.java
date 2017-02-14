package com.andylearn.intentfilter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * author：zhouhuan date： 2017/2/13 10:45 email：zhouhuan@fangdd.com function：
 */
public class A_Act extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Button button = new Button(this);
        button.setText("通过action a1");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction("android.intent.action.a1");
                startActivity(intent);
            }
        });
        linearLayout.addView(button);

        button = new Button(this);
        button.setText("单纯通过action.b1");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.b1");
                startActivity(intent);
            }
        });
        linearLayout.addView(button);

        button = new Button(this);
        button.setText("通过action.b1 category.b1");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.b1");
                intent.addCategory("android.intent.category.b1");
                startActivity(intent);
            }
        });
        linearLayout.addView(button);

        button = new Button(this);
        button.setText("单纯通过 category.bb1");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.addCategory("android.intent.category.bb1");
                startActivity(intent);
            }
        });
        linearLayout.addView(button);

        button = new Button(this);
        button.setText("通过action.b1 category.b1 c3");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.b1");
                intent.addCategory("android.intent.category.b1");
                intent.addCategory("android.intent.category.c3");
                startActivity(intent);
            }
        });
        linearLayout.addView(button);


        setContentView(linearLayout);
    }
}
