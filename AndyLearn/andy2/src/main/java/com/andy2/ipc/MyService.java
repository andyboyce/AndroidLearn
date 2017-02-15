package com.andy2.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    private IBinder proxy;

    public void onCreate() {
        super.onCreate();
        proxy = new DemoBinder(getApplicationContext());
    }

    public IBinder onBind(Intent intent) {
        return proxy;
    }

}
