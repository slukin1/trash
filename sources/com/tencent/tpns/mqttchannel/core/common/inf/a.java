package com.tencent.tpns.mqttchannel.core.common.inf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.tpns.mqttchannel.core.common.data.Request;

public interface a extends IInterface {

    /* renamed from: com.tencent.tpns.mqttchannel.core.common.inf.a$a  reason: collision with other inner class name */
    public static abstract class C0637a extends Binder implements a {
        public C0637a() {
            attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                a(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                a();
                parcel2.writeNoException();
                return true;
            } else if (i11 == 3) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                b();
                parcel2.writeNoException();
                return true;
            } else if (i11 == 4) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                a(parcel.readInt() != 0 ? Request.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                return true;
            }
        }
    }

    void a();

    void a(Request request);

    void a(boolean z11);

    void b();
}
