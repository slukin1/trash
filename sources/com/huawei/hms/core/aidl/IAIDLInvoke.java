package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.core.aidl.IAIDLCallback;

public interface IAIDLInvoke extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLInvoke";

    public static abstract class Stub extends Binder implements IAIDLInvoke {

        public static class a implements IAIDLInvoke {

            /* renamed from: b  reason: collision with root package name */
            public static IAIDLInvoke f37966b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f37967a;

            public a(IBinder iBinder) {
                this.f37967a = iBinder;
            }

            public IBinder asBinder() {
                return this.f37967a;
            }

            public void asyncCall(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAIDLInvoke.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iAIDLCallback != null ? iAIDLCallback.asBinder() : null);
                    if (this.f37967a.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().asyncCall(dataBuffer, iAIDLCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void syncCall(DataBuffer dataBuffer) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAIDLInvoke.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f37967a.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().syncCall(dataBuffer);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAIDLInvoke.DESCRIPTOR);
        }

        public static IAIDLInvoke asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAIDLInvoke.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAIDLInvoke)) {
                return new a(iBinder);
            }
            return (IAIDLInvoke) queryLocalInterface;
        }

        public static IAIDLInvoke getDefaultImpl() {
            return a.f37966b;
        }

        public static boolean setDefaultImpl(IAIDLInvoke iAIDLInvoke) {
            if (a.f37966b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iAIDLInvoke == null) {
                return false;
            } else {
                a.f37966b = iAIDLInvoke;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 != 1598968902) {
                DataBuffer dataBuffer = null;
                if (i11 == 1) {
                    parcel.enforceInterface(IAIDLInvoke.DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        dataBuffer = DataBuffer.CREATOR.createFromParcel(parcel);
                    }
                    syncCall(dataBuffer);
                    parcel2.writeNoException();
                    return true;
                } else if (i11 != 2) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                } else {
                    parcel.enforceInterface(IAIDLInvoke.DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        dataBuffer = DataBuffer.CREATOR.createFromParcel(parcel);
                    }
                    asyncCall(dataBuffer, IAIDLCallback.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                }
            } else {
                parcel2.writeString(IAIDLInvoke.DESCRIPTOR);
                return true;
            }
        }
    }

    void asyncCall(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) throws RemoteException;

    void syncCall(DataBuffer dataBuffer) throws RemoteException;
}
