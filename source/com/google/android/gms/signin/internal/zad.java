package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public abstract class zad extends zab implements zae {
    public zad() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public final boolean zaa(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        switch (i11) {
            case 3:
                ConnectionResult connectionResult = (ConnectionResult) zac.zaa(parcel, ConnectionResult.CREATOR);
                zaa zaa = (zaa) zac.zaa(parcel, zaa.CREATOR);
                break;
            case 4:
                Status status = (Status) zac.zaa(parcel, Status.CREATOR);
                break;
            case 6:
                Status status2 = (Status) zac.zaa(parcel, Status.CREATOR);
                break;
            case 7:
                Status status3 = (Status) zac.zaa(parcel, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) zac.zaa(parcel, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                zab((zak) zac.zaa(parcel, zak.CREATOR));
                break;
            case 9:
                zag zag = (zag) zac.zaa(parcel, zag.CREATOR);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
