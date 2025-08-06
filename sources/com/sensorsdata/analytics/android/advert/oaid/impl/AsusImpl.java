package com.sensorsdata.analytics.android.advert.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.sensorsdata.analytics.android.advert.oaid.IRomOAID;
import com.sensorsdata.analytics.android.sdk.SALog;

class AsusImpl implements IRomOAID {
    private static final String TAG = "SA.AsusImpl";
    private final Context mContext;
    private final OAIDService mService = new OAIDService();

    public static class AsusInterface implements IInterface {
        private final IBinder mIBinder;

        public AsusInterface(IBinder iBinder) {
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
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.mIBinder.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str;
            } catch (Throwable th2) {
                SALog.i(AsusImpl.TAG, th2);
                return str;
            }
        }
    }

    public AsusImpl(Context context) {
        this.mContext = context;
    }

    public String getRomOAID() {
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        try {
            if (!this.mContext.bindService(intent, this.mService, 1)) {
                return null;
            }
            String oaid = new AsusInterface(OAIDService.BINDER_QUEUE.take()).getOAID();
            this.mContext.unbindService(this.mService);
            return oaid;
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
            return null;
        }
    }

    public boolean isSupported() {
        try {
            return this.mContext.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
            return false;
        }
    }
}
