package com.huobi.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import i6.d;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public final class z {

    public class a extends Subscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c6.b f83797b;

        public a(c6.b bVar) {
            this.f83797b = bVar;
        }

        /* renamed from: a */
        public void onNext(String str) {
            c6.b bVar = this.f83797b;
            if (bVar != null) {
                bVar.onCallback(str);
            }
            d.c("GAIDUtil", "GAID: " + str);
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            c6.b bVar = this.f83797b;
            if (bVar != null) {
                bVar.onCallback(null);
            }
            d.f("GAIDUtil", th2);
        }
    }

    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        public final IBinder f83800a;

        public c(IBinder iBinder) {
            this.f83800a = iBinder;
        }

        public IBinder asBinder() {
            return this.f83800a;
        }

        public String d() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f83800a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static String b() {
        String i11 = SP.i("com.huobi.gaid", "");
        d.c("GAIDUtil", "GAID from SP: " + i11);
        return i11;
    }

    public static void c(Context context, c6.b<String> bVar) {
        Observable.create(new y(context)).subscribeOn(Schedulers.io()).subscribe(new a(bVar));
    }

    public static void d(Context context) {
        if (StringUtils.r(b())) {
            try {
                c(context, (c6.b<String>) null);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void e(Context context, Subscriber subscriber) {
        subscriber.onNext(f(context));
        subscriber.onCompleted();
    }

    public static String f(Context context) {
        String b11 = b();
        if (!StringUtils.r(b11)) {
            return b11;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        b bVar = new b((a) null);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, bVar, 1)) {
            return "";
        }
        try {
            String d11 = new c(bVar.a()).d();
            if (!StringUtils.r(d11)) {
                SP.s("com.huobi.gaid", d11);
            }
            return d11;
        } catch (Exception e12) {
            e12.printStackTrace();
            return "";
        } finally {
            context.unbindService(bVar);
        }
    }

    public static final class b implements ServiceConnection {

        /* renamed from: b  reason: collision with root package name */
        public boolean f83798b;

        /* renamed from: c  reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f83799c;

        public b() {
            this.f83798b = false;
            this.f83799c = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (!this.f83798b) {
                this.f83798b = true;
                return this.f83799c.take();
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f83799c.put(iBinder);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
