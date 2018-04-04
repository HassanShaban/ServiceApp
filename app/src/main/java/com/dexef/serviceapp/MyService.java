package com.dexef.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    public MyService() {

    }

    class Mybinder extends Binder {


        public MyService getService(){
            return MyService.this;
        }
    }
    IBinder mBinder = new Mybinder();

    @Override
    public IBinder onBind(Intent intent) {

        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Log.i("start","start");
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {

        Log.e("Stop","Stop");
        super.onDestroy();
    }
}
