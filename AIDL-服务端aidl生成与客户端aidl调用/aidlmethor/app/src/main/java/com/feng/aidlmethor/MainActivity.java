package com.feng.aidlmethor;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.os.IResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.feng.iservice.IService;

/**
 * 本地程序
 * 1. 绑定服务,只能使用隐式意图,需要远程服务给配置Action
 * 2. 在本地程序绑定服务时需要得到远程服务的IService服务,需要远程服务提供一个对外的接口文件,把这个文件放到本地程序中
 */
public class MainActivity extends AppCompatActivity {
    private static final String AIDL_ACTION = "com.feng.iservice.AIDL_SERVICE_NAME";
    Intent intent;
    private IService myBinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent();
        intent.setAction(AIDL_ACTION);
        intent.setPackage("com.feng.iservice");
    }
    public void startservice(View view){
        //远程服务制定一个action
        startService(intent);
    }
    public void bindservice(View view){
        //远程服务制定一个action
        bindService(intent,new myconn(),BIND_AUTO_CREATE);
    }
    //调用服务端方法
    public  void user(View view){
        try {
            myBinder.call();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public class myconn implements ServiceConnection{
        //绑定服务成功时,建立链接成功时调用
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //,调用逻辑业务方法
            myBinder= IService.Stub.asInterface(iBinder);
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
