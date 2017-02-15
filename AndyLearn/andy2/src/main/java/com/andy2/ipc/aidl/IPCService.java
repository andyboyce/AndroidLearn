package com.andy2.ipc.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.andy2.ITestService;
import com.andy2.Student;


public class IPCService extends Service {

    private ITestService.Stub stub = new ITestService.Stub() {

        public String add(String name) throws RemoteException {
            Log.e("--Service add", "param:" + name);
            return "add ok";
        }

        @Override
        public Student addStudent(Student student) throws RemoteException {
            Log.e("--Service addStudent", "student:" + student);
            return null;
        }


        public String query(int id) throws RemoteException {
            Log.e("--Service query", "param:" + id);
            return "query ok";
        }

    };

    public IBinder onBind(Intent intent) {
        Log.e("--Service onBind", "通过ADIL文件生成Binder,这里服务启动");
        return stub;
    }

}
