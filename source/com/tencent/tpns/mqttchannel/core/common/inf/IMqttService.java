package com.tencent.tpns.mqttchannel.core.common.inf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.tpns.mqttchannel.core.common.data.Request;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback;

public interface IMqttService extends IInterface {

    public static class Default implements IMqttService {
        public IBinder asBinder() {
            return null;
        }

        public void getConnectState(IMqttCallback iMqttCallback) {
        }

        public void isValidClientId(IMqttCallback iMqttCallback) {
        }

        public void ping(IMqttCallback iMqttCallback) {
        }

        public void sendPublishData(Request request, IMqttCallback iMqttCallback) {
        }

        public void sendRequest(Request request, IMqttCallback iMqttCallback) {
        }

        public void startConnect(IMqttCallback iMqttCallback) {
        }

        public void stopConnect(IMqttCallback iMqttCallback) {
        }

        public void subscrbie(Request request, IMqttCallback iMqttCallback) {
        }

        public void unSubscrbie(Request request, IMqttCallback iMqttCallback) {
        }
    }

    void getConnectState(IMqttCallback iMqttCallback);

    void isValidClientId(IMqttCallback iMqttCallback);

    void ping(IMqttCallback iMqttCallback);

    void sendPublishData(Request request, IMqttCallback iMqttCallback);

    void sendRequest(Request request, IMqttCallback iMqttCallback);

    void startConnect(IMqttCallback iMqttCallback);

    void stopConnect(IMqttCallback iMqttCallback);

    void subscrbie(Request request, IMqttCallback iMqttCallback);

    void unSubscrbie(Request request, IMqttCallback iMqttCallback);

    public static abstract class Stub extends Binder implements IMqttService {

        public static class Proxy implements IMqttService {

            /* renamed from: a  reason: collision with root package name */
            public static IMqttService f49975a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f49976b;

            public Proxy(IBinder iBinder) {
                this.f49976b = iBinder;
            }

            public IBinder asBinder() {
                return this.f49976b;
            }

            public void getConnectState(IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (this.f49976b.transact(3, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.a().getConnectState(iMqttCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void isValidClientId(IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (this.f49976b.transact(4, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.a().isValidClientId(iMqttCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void ping(IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (this.f49976b.transact(5, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.a().ping(iMqttCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void sendPublishData(Request request, IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (this.f49976b.transact(7, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.a().sendPublishData(request, iMqttCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void sendRequest(Request request, IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (this.f49976b.transact(6, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.a().sendRequest(request, iMqttCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startConnect(IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (this.f49976b.transact(1, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.a().startConnect(iMqttCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopConnect(IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (this.f49976b.transact(2, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.a().stopConnect(iMqttCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void subscrbie(Request request, IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (this.f49976b.transact(8, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.a().subscrbie(request, iMqttCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unSubscrbie(Request request, IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (this.f49976b.transact(9, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.a().unSubscrbie(request, iMqttCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        }

        public static IMqttService a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMqttService)) {
                return new Proxy(iBinder);
            }
            return (IMqttService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 != 1598968902) {
                Request request = null;
                switch (i11) {
                    case 1:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        startConnect(IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        stopConnect(IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        getConnectState(IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        isValidClientId(IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        ping(IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        if (parcel.readInt() != 0) {
                            request = Request.CREATOR.createFromParcel(parcel);
                        }
                        sendRequest(request, IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        if (parcel.readInt() != 0) {
                            request = Request.CREATOR.createFromParcel(parcel);
                        }
                        sendPublishData(request, IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        if (parcel.readInt() != 0) {
                            request = Request.CREATOR.createFromParcel(parcel);
                        }
                        subscrbie(request, IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        if (parcel.readInt() != 0) {
                            request = Request.CREATOR.createFromParcel(parcel);
                        }
                        unSubscrbie(request, IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i11, parcel, parcel2, i12);
                }
            } else {
                parcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                return true;
            }
        }

        public static IMqttService a() {
            return Proxy.f49975a;
        }
    }
}
