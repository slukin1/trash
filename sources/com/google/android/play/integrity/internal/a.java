package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f66860a;

    /* renamed from: b  reason: collision with root package name */
    private final String f66861b;

    public a(IBinder iBinder, String str) {
        this.f66860a = iBinder;
        this.f66861b = str;
    }

    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f66861b);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f66860a;
    }

    public final void b(int i11, Parcel parcel) throws RemoteException {
        try {
            this.f66860a.transact(i11, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
