package com.tencent.android.tpush.rpc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.android.tpush.rpc.b;

public interface a extends IInterface {
    void a();

    void a(String str, b bVar);

    void b();

    /* renamed from: com.tencent.android.tpush.rpc.a$a  reason: collision with other inner class name */
    public static abstract class C0750a extends Binder implements a {
        public C0750a() {
            attachInterface(this, "com.tencent.android.tpush.rpc.ITask");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.android.tpush.rpc.ITask");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0751a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public static a c() {
            return C0751a.f69489a;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.tencent.android.tpush.rpc.ITask");
                a();
                parcel2.writeNoException();
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface("com.tencent.android.tpush.rpc.ITask");
                b();
                parcel2.writeNoException();
                return true;
            } else if (i11 == 3) {
                parcel.enforceInterface("com.tencent.android.tpush.rpc.ITask");
                a(parcel.readString(), b.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.tencent.android.tpush.rpc.ITask");
                return true;
            }
        }

        /* renamed from: com.tencent.android.tpush.rpc.a$a$a  reason: collision with other inner class name */
        public static class C0751a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f69489a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f69490b;

            public C0751a(IBinder iBinder) {
                this.f69490b = iBinder;
            }

            public void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITask");
                    if (this.f69490b.transact(1, obtain, obtain2, 0) || C0750a.c() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C0750a.c().a();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f69490b;
            }

            public void b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITask");
                    if (this.f69490b.transact(2, obtain, obtain2, 0) || C0750a.c() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C0750a.c().b();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str, b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITask");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.f69490b.transact(3, obtain, obtain2, 0) || C0750a.c() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C0750a.c().a(str, bVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
