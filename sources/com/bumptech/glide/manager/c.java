package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.a;
import f4.h;

public final class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public final Context f64161b;

    /* renamed from: c  reason: collision with root package name */
    public final a.C0706a f64162c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64163d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64164e;

    /* renamed from: f  reason: collision with root package name */
    public final BroadcastReceiver f64165f = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            c cVar = c.this;
            boolean z11 = cVar.f64163d;
            cVar.f64163d = cVar.a(context);
            if (z11 != c.this.f64163d) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + c.this.f64163d);
                }
                c cVar2 = c.this;
                cVar2.f64162c.a(cVar2.f64163d);
            }
        }
    }

    public c(Context context, a.C0706a aVar) {
        this.f64161b = context.getApplicationContext();
        this.f64162c = aVar;
    }

    @SuppressLint({"MissingPermission"})
    public boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) h.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (RuntimeException e11) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e11);
            }
            return true;
        }
    }

    public final void b() {
        if (!this.f64164e) {
            this.f64163d = a(this.f64161b);
            try {
                this.f64161b.registerReceiver(this.f64165f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f64164e = true;
            } catch (SecurityException e11) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register", e11);
                }
            }
        }
    }

    public final void c() {
        if (this.f64164e) {
            this.f64161b.unregisterReceiver(this.f64165f);
            this.f64164e = false;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
        b();
    }

    public void onStop() {
        c();
    }
}
