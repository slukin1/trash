package androidx.test.runner.internal.deps.aidl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class BaseProxy implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f11688a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11689b;

    public BaseProxy(IBinder iBinder, String str) {
        this.f11688a = iBinder;
        this.f11689b = str;
    }

    public IBinder asBinder() {
        return this.f11688a;
    }

    public Parcel d() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f11689b);
        return obtain;
    }

    public void e(int i11, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f11688a.transact(i11, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
