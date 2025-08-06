package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class j extends b implements k {
    public j() {
        super("com.google.android.play.core.integrity.protocol.IExpressIntegrityServiceCallback");
    }

    public final boolean a(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 2) {
            c.b(parcel);
            e((Bundle) c.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i11 == 3) {
            c.b(parcel);
            c((Bundle) c.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i11 == 4) {
            c.b(parcel);
            d((Bundle) c.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i11 != 5) {
            return false;
        } else {
            c.b(parcel);
            b((Bundle) c.a(parcel, Bundle.CREATOR));
            return true;
        }
    }
}
