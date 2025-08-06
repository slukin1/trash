package com.sensorsdata.analytics.android.advert.oaid.impl;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huochat.community.util.FileTool;
import com.sensorsdata.analytics.android.advert.oaid.IRomOAID;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.security.MessageDigest;

class OppoImpl implements IRomOAID {
    private static final String TAG = "SA.OppoImpl";
    private final Context mContext;
    private final OAIDService mService = new OAIDService();
    private String mSign;

    public static class OppoInterface implements IInterface {
        private final IBinder mIBinder;

        public OppoInterface(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        public IBinder asBinder() {
            return this.mIBinder;
        }

        public String getSerID(String str, String str2, String str3) {
            String str4 = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                this.mIBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str4 = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str4;
            } catch (Throwable th2) {
                SALog.i(OppoImpl.TAG, th2);
                return str4;
            }
        }
    }

    public OppoImpl(Context context) {
        this.mContext = context;
    }

    private String getSerId(String str, String str2) throws InterruptedException {
        return new OppoInterface(OAIDService.BINDER_QUEUE.take()).getSerID(str, str2, "OUID");
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private String realGetOUID() {
        String packageName = this.mContext.getPackageName();
        try {
            String str = this.mSign;
            if (str != null) {
                return getSerId(packageName, str);
            }
            byte[] digest = MessageDigest.getInstance(FileTool.HASH_TYPE_SHA1).digest(this.mContext.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : digest) {
                sb2.append(Integer.toHexString((b11 & 255) | 256).substring(1, 3));
            }
            String sb3 = sb2.toString();
            this.mSign = sb3;
            return getSerId(packageName, sb3);
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
            return null;
        }
    }

    public String getRomOAID() {
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        try {
            if (!this.mContext.bindService(intent, this.mService, 1)) {
                return null;
            }
            String realGetOUID = realGetOUID();
            this.mContext.unbindService(this.mService);
            return realGetOUID;
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
            return null;
        }
    }

    public boolean isSupported() {
        try {
            return this.mContext.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
            return false;
        }
    }
}
