package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAIDLCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLCallback";

    public static abstract class Stub extends Binder implements IAIDLCallback {
        public static final int TRANSACTION_call = 1;

        public static class a implements IAIDLCallback {

            /* renamed from: b  reason: collision with root package name */
            public static IAIDLCallback f37964b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f37965a;

            public a(IBinder iBinder) {
                this.f37965a = iBinder;
            }

            public IBinder asBinder() {
                return this.f37965a;
            }

            public void call(DataBuffer dataBuffer) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAIDLCallback.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f37965a.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().call(dataBuffer);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAIDLCallback.DESCRIPTOR);
        }

        public static IAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAIDLCallback.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAIDLCallback)) {
                return new a(iBinder);
            }
            return (IAIDLCallback) queryLocalInterface;
        }

        public static IAIDLCallback getDefaultImpl() {
            return a.f37964b;
        }

        public static boolean setDefaultImpl(IAIDLCallback iAIDLCallback) {
            if (a.f37964b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iAIDLCallback == null) {
                return false;
            } else {
                a.f37964b = iAIDLCallback;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1598968902) {
                parcel2.writeString(IAIDLCallback.DESCRIPTOR);
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel.enforceInterface(IAIDLCallback.DESCRIPTOR);
                call(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
        }
    }

    void call(DataBuffer dataBuffer) throws RemoteException;
}
