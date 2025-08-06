package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IResultReceiver extends IInterface {
    public static final String DESCRIPTOR = "android$support$v4$os$IResultReceiver".replace(DecodedChar.FNC1, '.');

    public static class Default implements IResultReceiver {
        public IBinder asBinder() {
            return null;
        }

        public void send(int i11, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IResultReceiver {
        public static final int TRANSACTION_send = 1;

        public static class Proxy implements IResultReceiver {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IResultReceiver.DESCRIPTOR;
            }

            public void send(int i11, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IResultReceiver.DESCRIPTOR);
                    obtain.writeInt(i11);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IResultReceiver.DESCRIPTOR);
        }

        public static IResultReceiver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IResultReceiver.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IResultReceiver)) {
                return new Proxy(iBinder);
            }
            return (IResultReceiver) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            String str = IResultReceiver.DESCRIPTOR;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                send(parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                return true;
            }
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t11, int i11) {
            if (t11 != null) {
                parcel.writeInt(1);
                t11.writeToParcel(parcel, i11);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void send(int i11, Bundle bundle) throws RemoteException;
}
