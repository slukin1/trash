package com.tencent.liteav.audio2.earmonitor.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface a extends IInterface {
    List a() throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    boolean a(int i11) throws RemoteException;

    /* renamed from: com.tencent.liteav.audio2.earmonitor.a.a$a  reason: collision with other inner class name */
    public static abstract class C0165a extends Binder implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0166a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
                List a11 = a();
                parcel2.writeNoException();
                parcel2.writeList(a11);
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
                boolean a12 = a(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(a12 ? 1 : 0);
                return true;
            } else if (i11 == 3) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
                a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.huawei.multimedia.audioengine.IHwAudioEngine");
                return true;
            }
        }

        /* renamed from: com.tencent.liteav.audio2.earmonitor.a.a$a$a  reason: collision with other inner class name */
        public static class C0166a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f21342a;

            public C0166a(IBinder iBinder) {
                this.f21342a = iBinder;
            }

            public final List a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
                    this.f21342a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readArrayList(C0166a.class.getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f21342a;
            }

            public final boolean a(int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
                    obtain.writeInt(i11);
                    boolean z11 = false;
                    this.f21342a.transact(2, obtain, obtain2, 0);
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

            public final void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f21342a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
