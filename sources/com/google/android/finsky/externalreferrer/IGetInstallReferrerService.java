package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.a.a;
import com.google.android.a.b;
import com.google.android.a.c;

public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends b implements IGetInstallReferrerService {

        public static class Proxy extends a implements IGetInstallReferrerService {
            public Proxy(IBinder iBinder) {
                super(iBinder);
            }

            public final Bundle c(Bundle bundle) throws RemoteException {
                Parcel a11 = a();
                c.b(a11, bundle);
                Parcel b11 = b(a11);
                Bundle bundle2 = (Bundle) c.a(b11, Bundle.CREATOR);
                b11.recycle();
                return bundle2;
            }
        }

        public static IGetInstallReferrerService b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof IGetInstallReferrerService) {
                return (IGetInstallReferrerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public final boolean a(int i11, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i11 != 1) {
                return false;
            }
            Bundle c11 = c((Bundle) c.a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            c.c(parcel2, c11);
            return true;
        }
    }

    Bundle c(Bundle bundle) throws RemoteException;
}
