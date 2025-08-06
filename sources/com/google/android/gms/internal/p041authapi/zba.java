package com.google.android.gms.internal.p041authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.auth-api.zba  reason: invalid package */
public class zba implements IInterface {
    private final IBinder zba;
    private final String zbb;

    public zba(IBinder iBinder, String str) {
        this.zba = iBinder;
        this.zbb = str;
    }

    public final IBinder asBinder() {
        return this.zba;
    }

    public final Parcel zba() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zbb);
        return obtain;
    }

    public final void zbb(int i11, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zba.transact(i11, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
