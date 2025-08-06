package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i11, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzb(int i11, Bundle bundle) throws RemoteException;

    void zzc(int i11, IBinder iBinder, zzk zzk) throws RemoteException;
}
