package com.andylearn.launchmode.singletask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * author：zhouhuan date： 2017/2/14 11:25 email：zhouhuan@fangdd.com function：
 */
public class Test_Act extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Button button = new Button(this);
        button.setText("启动A--B,检测AB是否在相同的栈");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Test_Act.this, A_Act.class));
            }
        });
        linearLayout.addView(button);


        button = new Button(this);
        button.setText("启动C--D,检测CD是否在相同的栈");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Test_Act.this, C_Act.class));
            }
        });
        linearLayout.addView(button);
        setContentView(linearLayout);
    }
}
