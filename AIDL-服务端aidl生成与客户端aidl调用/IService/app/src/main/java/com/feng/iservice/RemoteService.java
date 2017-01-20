package com.feng.iservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * 远程服务类
 * Created by admin on 2017/1/20.
 */

public class RemoteService extends Service {
    /**
     * 3. 返回中间人对象,让Activity获取
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    /**
     * 服务中的业务逻辑
     */
    public void shaotoast(){
//        Toast.makeText(this, "服务"+this.getPackageName(), Toast.LENGTH_SHORT).show();
        Log.e("mmmmmm","========shaotoast服务中的业务逻辑=====");
    }


    /**
     * 1. 中间人
     */
    private class MyBinder extends IService.Stub {
        @Override
        public void call() {
            //调用服务中的业务逻辑方法
            shaotoast();
        }
    }
}
