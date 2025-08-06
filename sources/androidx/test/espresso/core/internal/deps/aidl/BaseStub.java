package androidx.test.espresso.core.internal.deps.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class BaseStub extends Binder implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public static TransactionInterceptor f11144a;

    public BaseStub(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    public abstract boolean d(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException;

    public boolean e(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 > 16777215) {
            return super.onTransact(i11, parcel, parcel2, i12);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (e(i11, parcel, parcel2, i12)) {
            return true;
        }
        TransactionInterceptor transactionInterceptor = f11144a;
        if (transactionInterceptor == null) {
            return d(i11, parcel, parcel2, i12);
        }
        return transactionInterceptor.a(this, i11, parcel, parcel2, i12);
    }
}
