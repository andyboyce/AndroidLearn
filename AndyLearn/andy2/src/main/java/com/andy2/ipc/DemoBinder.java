package com.andy2.ipc;

import android.content.Context;
import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

public class DemoBinder extends Binder {
    private Context mContext;

    public DemoBinder(Context mContext) {
        this.mContext = mContext;
    }

    //data包含有客户端送过来的请求数据，reply是在服务端执行完了给客户端的返回值
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags)
            throws RemoteException {
        try {

            switch (code) {
                case 1:
                    //打印请求数据
                    Log.e("--------request data", data.readString());
                    //设置返回值
                    reply.writeString("query ok");
                    query();
                    break;
                case 2:
                    //打印请求数据
                    Log.e("--------request data", data.readString());
                    //设置返回值
                    reply.writeString("add ok");
                    add();
                    break;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public void query() {
        Log.e("==============onBinder", "query");
    }

    public void add() {
        Log.e("==============onBinder", "add");
    }
}
