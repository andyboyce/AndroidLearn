package com.andylearn.ipc.aidl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.andy2.ITestService;
import com.andylearn.R;



public class AIDLClientAct extends Activity {
    TextView tvnote;
    private ITestService proxy;
    public static final String TAG = "AIDLClientAct--";
    private ServiceConnection sc = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG,"--onServiceConnected");
            proxy = ITestService.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub

        }

    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aidl_test);

        tvnote = (TextView) this.findViewById(R.id.tvrs);
        Button bbind = (Button) this.findViewById(R.id.bbind);
        bbind.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.andy.ipc.aidl.ipcservice");
                bindService(intent, sc, Context.BIND_AUTO_CREATE);

            }
        });

        Button bcall = (Button) this.findViewById(R.id.bcall);
        bcall.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                try {
                    tvnote.setText(proxy.add("vivian"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}