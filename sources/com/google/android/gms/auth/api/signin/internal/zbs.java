package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p041authapi.zba;
import com.google.android.gms.internal.p041authapi.zbc;

public final class zbs extends zba {
    public zbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zbc(zbr zbr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbr);
        zbc.zbc(zba, googleSignInOptions);
        zbb(103, zba);
    }

    public final void zbd(zbr zbr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbr);
        zbc.zbc(zba, googleSignInOptions);
        zbb(102, zba);
    }

    public final void zbe(zbr zbr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbr);
        zbc.zbc(zba, googleSignInOptions);
        zbb(101, zba);
    }
}
