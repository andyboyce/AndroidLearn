package com.andylearn.intentfilter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.andylearn.launchmode.singleinstance.C_Act;

/**
 * author：zhouhuan date： 2017/2/13 10:45 email：zhouhuan@fangdd.com function：
 */
public class To_Act extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);
        button.setText("我是目标To_Act,里面含有很多过滤规则");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(To_Act.this, C_Act.class));
            }
        });

        setContentView(button);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("B--","onNewIntent");
    }
}
