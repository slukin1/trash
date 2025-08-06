package com.zopim.android.sdk.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.model.Connection;

public class ConnectionPath extends Path<Connection> {
    /* access modifiers changed from: private */
    public static final ConnectionPath INSTANCE = new ConnectionPath();
    private static final String LOG_TAG = "ConnectionPath";
    /* access modifiers changed from: private */
    public Boolean deviceNoConnectivity;

    public static class ConnectivityReceiver extends BroadcastReceiver {
        private static final String LOG_TAG = "ConnectivityReceiver";

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                Logger.l(LOG_TAG, "onReceive: intent was null or getAction() was mismatched", new Object[0]);
                return;
            }
            if (intent.hasExtra("noConnectivity")) {
                Boolean unused = ConnectionPath.INSTANCE.deviceNoConnectivity = Boolean.valueOf(intent.getBooleanExtra("noConnectivity", false));
            } else {
                Logger.l(LOG_TAG, "Network change occurred, but no connectivity extras available", new Object[0]);
                boolean z11 = true;
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                    Logger.j(LOG_TAG, "Looking up active network info...", new Object[0]);
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    ConnectionPath access$000 = ConnectionPath.INSTANCE;
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        z11 = false;
                    }
                    Boolean unused2 = access$000.deviceNoConnectivity = Boolean.valueOf(z11);
                } else {
                    Logger.j(LOG_TAG, "Unable to check device connection state. Assuming device is connected and leaving it to the web widget to verify connection.", new Object[0]);
                    Boolean unused3 = ConnectionPath.INSTANCE.deviceNoConnectivity = Boolean.FALSE;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Device ");
            sb2.append(ConnectionPath.INSTANCE.deviceNoConnectivity.booleanValue() ? "disconnected" : "connected");
            Logger.j(LOG_TAG, sb2.toString(), new Object[0]);
            ConnectionPath.INSTANCE.broadcast(ConnectionPath.INSTANCE.getData());
        }
    }

    private ConnectionPath() {
    }

    public static synchronized ConnectionPath getInstance() {
        ConnectionPath connectionPath;
        synchronized (ConnectionPath.class) {
            connectionPath = INSTANCE;
        }
        return connectionPath;
    }

    public void clear() {
        this.data = null;
        this.deviceNoConnectivity = null;
    }

    public void update(String str) {
        if (str != null && !str.isEmpty()) {
            this.data = ChatGson.get().fromJson(str, Connection.class);
            broadcast(getData());
        }
    }

    public Connection getData() {
        Boolean bool = this.deviceNoConnectivity;
        if (bool == null || !bool.booleanValue()) {
            T t11 = this.data;
            if (t11 == null) {
                return new Connection(Connection.Status.UNKNOWN);
            }
            return (Connection) t11;
        }
        Logger.j(LOG_TAG, "Device has no connection. Will return widget's connection as NO_CONNECTION", new Object[0]);
        return new Connection(Connection.Status.NO_CONNECTION);
    }
}
