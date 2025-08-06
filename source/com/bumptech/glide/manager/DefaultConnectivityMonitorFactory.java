package com.bumptech.glide.manager;

import a4.f;
import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.a;

public class DefaultConnectivityMonitorFactory implements b {
    public a a(Context context, a.C0706a aVar) {
        boolean z11 = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z11 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        if (z11) {
            return new c(context, aVar);
        }
        return new f();
    }
}
