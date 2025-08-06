package com.engagelab.privates.common.binder;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;

public class MTMessengerConnection implements ServiceConnection {
    private final Context context;

    public MTMessengerConnection(Context context2) {
        this.context = context2;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MTMessenger.getInstance().onServiceConnected(this.context, iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        MTMessenger.getInstance().onServiceDisconnected(this.context);
    }
}
