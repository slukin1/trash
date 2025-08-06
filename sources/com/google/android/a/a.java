package com.google.android.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f65590a;

    /* renamed from: b  reason: collision with root package name */
    private final String f65591b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    public a(IBinder iBinder) {
        this.f65590a = iBinder;
    }

    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f65591b);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f65590a;
    }

    public final Parcel b(Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f65590a.transact(1, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e11) {
            throw e11;
        } finally {
            parcel.recycle();
        }
    }
}
