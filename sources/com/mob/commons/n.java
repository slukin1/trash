package com.mob.commons;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mob.tools.MobLog;
import java.util.concurrent.CountDownLatch;

public class n extends Binder implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private CountDownLatch f27284a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f27285b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f27286c = false;

    /* renamed from: d  reason: collision with root package name */
    private final String f27287d;

    public n() {
        String a11 = s.a("043c7dkdfdl_hYdi,h)dk+eKdkdjdlWcg-dkdgdcfi7fKdjdddi3cfCdldk(d7didcdleeghfdeefledUdgg fj<dc'eh");
        this.f27287d = a11;
        attachInterface(this, a11);
    }

    public String a() {
        return this.f27285b;
    }

    public void a(int i11, long j11, boolean z11, float f11, double d11, String str) {
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean b() {
        return this.f27286c;
    }

    public String getInterfaceDescriptor() {
        return this.f27287d;
    }

    public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            parcel.enforceInterface(this.f27287d);
            a(parcel.readInt(), parcel.readLong(), parcel.readInt() > 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
        } else if (i11 == 2) {
            parcel.enforceInterface(this.f27287d);
            a(parcel.readInt(), parcel.readInt() > 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
        } else if (i11 != 1598968902) {
            return super.onTransact(i11, parcel, parcel2, i12);
        } else {
            parcel2.writeString(this.f27287d);
            return true;
        }
        parcel2.writeNoException();
        return true;
    }

    public n a(CountDownLatch countDownLatch) {
        this.f27284a = countDownLatch;
        return this;
    }

    public void a(int i11, Bundle bundle) {
        try {
            if (bundle.containsKey(s.a("010)dkSdHdhdidcdhefTgd'ej"))) {
                this.f27285b = bundle.getString(s.a("010]dk dWdhdidcdhefTgd1ej"));
            } else if (bundle.containsKey(s.a("017_dk6d=dhdidcdhEgKdidfdi>i4dhfi?idif"))) {
                this.f27286c = bundle.getBoolean(s.a("0171dkBd9dhdidcdhPgNdidfdiSi?dhfiQidif"));
            }
            CountDownLatch countDownLatch = this.f27284a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }
}
