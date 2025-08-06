package com.sensorsdata.analytics.android.advert.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.sensorsdata.analytics.android.advert.oaid.IRomOAID;
import com.sensorsdata.analytics.android.sdk.SALog;

class SamsungImpl implements IRomOAID {
    private static final String TAG = "SA.SamsungImpl";
    private final Context mContext;
    private final OAIDService mService = new OAIDService();

    public static class SamsungInterface implements IInterface {
        private final IBinder mIBinder;

        public SamsungInterface(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        public IBinder asBinder() {
            return this.mIBinder;
        }

        public String getOAID() {
            String str = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.mIBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return str;
            } catch (Throwable th2) {
                SALog.i(SamsungImpl.TAG, th2);
                return str;
            }
        }
    }

    public SamsungImpl(Context context) {
        this.mContext = context;
    }

    public String getRomOAID() {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        try {
            if (!this.mContext.bindService(intent, this.mService, 1)) {
                return null;
            }
            String oaid = new SamsungInterface(OAIDService.BINDER_QUEUE.take()).getOAID();
            this.mContext.unbindService(this.mService);
            return oaid;
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
            return null;
        }
    }

    public boolean isSupported() {
        try {
            return this.mContext.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
            return false;
        }
    }
}
