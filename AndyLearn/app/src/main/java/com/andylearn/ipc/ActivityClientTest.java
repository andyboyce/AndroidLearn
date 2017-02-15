package com.andylearn.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.andylearn.R;

public class ActivityClientTest extends Activity {

    private IBinder proxy;
    private String result;
    private TextView tvnote;

    private ServiceConnection sconnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder service) {
            //接受服务端返回的Binder对象
            proxy = service;
        }

        public void onServiceDisconnected(ComponentName name) {

        }

    };


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvnote = (TextView) this.findViewById(R.id.tvnote);
        Button bind = (Button) this.findViewById(R.id.bind);
        Button bsend = (Button) this.findViewById(R.id.bsendrequest);
        bind.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setAction("com.andy.ipc.service");
                    bindService(intent, sconnection, Context.BIND_AUTO_CREATE);
                    Log.e("---------activity", "bind service");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        bsend.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                try {
                    //构建请求对象
                    Parcel req = Parcel.obtain();
                    //构建返回值对象
                    Parcel res = Parcel.obtain();

                    req.writeString("vivian");
                    //发送请求
                    proxy.transact(1, req, res, 0);

                    //获取返回值
                    result = res.readString();
                    tvnote.setText(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}