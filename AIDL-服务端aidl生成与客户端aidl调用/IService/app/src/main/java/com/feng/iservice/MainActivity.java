package com.feng.iservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * 远程服务
 * http://wenda.so.com/q/1461819612728313
 */
public class MainActivity extends AppCompatActivity {
    private static final String AIDL_ACTION = "com.feng.iservice.AIDL_SERVICE_NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startservice(View view){
        this.startService(new Intent(AIDL_ACTION).setPackage("com.feng.iservice"));

    }
}
