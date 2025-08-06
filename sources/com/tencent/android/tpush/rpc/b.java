package com.tencent.android.tpush.rpc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: com.tencent.android.tpush.rpc.b$a$a  reason: collision with other inner class name */
        public static class C0752a implements b {

            /* renamed from: a  reason: collision with root package name */
            public static b f69491a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f69492b;

            public C0752a(IBinder iBinder) {
                this.f69492b = iBinder;
            }

            public void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITaskCallback");
                    if (this.f69492b.transact(1, obtain, obtain2, 0) || a.b() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    a.b().a();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f69492b;
            }
        }

        public a() {
            attachInterface(this, "com.tencent.android.tpush.rpc.ITaskCallback");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.android.tpush.rpc.ITaskCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0752a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public static b b() {
            return C0752a.f69491a;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.tencent.android.tpush.rpc.ITaskCallback");
                a();
                parcel2.writeNoException();
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.tencent.android.tpush.rpc.ITaskCallback");
                return true;
            }
        }
    }

    void a();
}
