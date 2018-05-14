package com.nalan.swipeitem.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.nalan.swipeitem.R;

/**
 * Created by ShiLiang on 2018/5/1.
 */

public class TestActivity extends Activity{

    public static final String TAG = "TestActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = new Intent(TestActivity.this,MessengerService.class);
        bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
        findViewById(R.id.tv_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this,MessengerService.class);
                bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });
    }
    private Messenger mMessenger;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMessenger = new Messenger(service);
            Message message = Message.obtain(null, Contants.IPC_MSG_FROM_CLIENT);
            Bundle bundle = new Bundle();
            bundle.putString("msg","这是客户端发送的消息，Hello World!");
            Log.i(TAG,bundle.toString());
            message.setData(bundle);
            try {
                mMessenger.send(message);
            } catch (RemoteException e) {
                Log.e(TAG,e.getMessage());
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        unbindService(mServiceConnection);
        super.onDestroy();
    }
}
