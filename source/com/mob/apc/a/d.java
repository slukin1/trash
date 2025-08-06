package com.mob.apc.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class d extends Binder implements IInterface {

    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f26877a;

        public a(IBinder iBinder) {
            this.f26877a = iBinder;
        }

        public e a(e eVar) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.mob.apc.impl.IAidlInterface");
                if (eVar != null) {
                    eVar.a(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
                this.f26877a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return e.a(obtain2);
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f26877a;
        }

        public String getInterfaceDescriptor() {
            return "com.mob.apc.impl.IAidlInterface";
        }
    }

    public d() {
        attachInterface(this, "com.mob.apc.impl.IAidlInterface");
    }

    public static d a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.mob.apc.impl.IAidlInterface");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
            return new a(iBinder);
        }
        return (d) queryLocalInterface;
    }

    public abstract e a(e eVar) throws RemoteException;

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 1) {
            parcel.enforceInterface("com.mob.apc.impl.IAidlInterface");
            e a11 = a(e.a(parcel));
            parcel2.writeNoException();
            if (a11 != null) {
                a11.a(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        } else if (i11 != 1598968902) {
            return super.onTransact(i11, parcel, parcel2, i12);
        } else {
            parcel2.writeString("com.mob.apc.impl.IAidlInterface");
            return true;
        }
    }
}
