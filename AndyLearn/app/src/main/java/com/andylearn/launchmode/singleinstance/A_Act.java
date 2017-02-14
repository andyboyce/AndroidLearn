package com.andylearn.launchmode.singleinstance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * author：zhouhuan date： 2017/2/13 10:45 email：zhouhuan@fangdd.com function：
 */
public class A_Act extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);
        button.setText("A--启动B");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(A_Act.this, B_Act.class));

            }
        });

        setContentView(button);
    }
}
