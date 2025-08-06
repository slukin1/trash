package androidx.test.runner.internal.deps.aidl;

import android.os.Parcel;
import android.os.RemoteException;

public interface TransactionInterceptor {
    boolean a(BaseStub baseStub, int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException;
}
