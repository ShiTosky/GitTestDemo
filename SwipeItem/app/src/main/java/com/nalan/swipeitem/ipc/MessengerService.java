package com.nalan.swipeitem.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ShiLiang on 2018/5/1.
 * IPC Messenger方式使用
 */

public class MessengerService extends Service {
    private static final String TAG = "MessengerService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case Contants.IPC_MSG_FROM_CLIENT:
                    Log.i(TAG,"接收到客户端消息："+msg.getData().getString("msg"));
                    break;
                    default:
                        super.handleMessage(msg);
            }
        }
    }
    private final Messenger mMessenger= new Messenger(new MessengerHandler());

}
