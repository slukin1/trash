package com.tencent.liteav.audio2.earmonitor.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface b extends IInterface {
    int a(String str, int i11) throws RemoteException;

    int a(boolean z11) throws RemoteException;

    void a(String str) throws RemoteException;

    boolean a() throws RemoteException;

    int b() throws RemoteException;

    public static abstract class a extends Binder implements b {
        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0167a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                boolean a11 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a11 ? 1 : 0);
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                int a12 = a(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(a12);
                return true;
            } else if (i11 == 3) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                int b11 = b();
                parcel2.writeNoException();
                parcel2.writeInt(b11);
                return true;
            } else if (i11 == 4) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                int a13 = a(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(a13);
                return true;
            } else if (i11 == 5) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                return true;
            }
        }

        /* renamed from: com.tencent.liteav.audio2.earmonitor.a.b$a$a  reason: collision with other inner class name */
        public static class C0167a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f21343a;

            public C0167a(IBinder iBinder) {
                this.f21343a = iBinder;
            }

            public final boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                    boolean z11 = false;
                    this.f21343a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z11 = true;
                    }
                    return z11;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f21343a;
            }

            public final int b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                    this.f21343a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int a(boolean z11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                    obtain.writeInt(z11 ? 1 : 0);
                    this.f21343a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int a(String str, int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                    obtain.writeString(str);
                    obtain.writeInt(i11);
                    this.f21343a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                    obtain.writeString(str);
                    this.f21343a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
