package com.tencent.tpns.mqttchannel.core.common.inf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IMqttCallback extends IInterface {

    public static abstract class a extends Binder implements IMqttCallback {

        /* renamed from: com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback$a$a  reason: collision with other inner class name */
        public static class C0636a implements IMqttCallback {

            /* renamed from: a  reason: collision with root package name */
            public static IMqttCallback f49973a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f49974b;

            public C0636a(IBinder iBinder) {
                this.f49974b = iBinder;
            }

            public IBinder asBinder() {
                return this.f49974b;
            }

            public void handleCallback(int i11, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    if (this.f49974b.transact(1, obtain, obtain2, 0) || a.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    a.getDefaultImpl().handleCallback(i11, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
        }

        public static IMqttCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMqttCallback)) {
                return new C0636a(iBinder);
            }
            return (IMqttCallback) queryLocalInterface;
        }

        public static IMqttCallback getDefaultImpl() {
            return C0636a.f49973a;
        }

        public static boolean setDefaultImpl(IMqttCallback iMqttCallback) {
            if (C0636a.f49973a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iMqttCallback == null) {
                return false;
            } else {
                C0636a.f49973a = iMqttCallback;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
                handleCallback(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
                return true;
            }
        }
    }

    void handleCallback(int i11, String str);
}
