package com.sensorsdata.analytics.android.advert.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.common.PackageConstants;
import com.sensorsdata.analytics.android.advert.oaid.IRomOAID;
import com.sensorsdata.analytics.android.sdk.SALog;

public class HuaweiImpl implements IRomOAID {
    private static final String TAG = "SA.HuaweiImpl";
    private final Context mContext;
    private String mPackageName;
    private final OAIDService mService = new OAIDService();

    public static final class HuaWeiInterface implements IInterface {
        private final IBinder iBinder;

        public IBinder asBinder() {
            return this.iBinder;
        }

        public String getOAID() {
            String str = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str;
            } catch (Throwable th2) {
                SALog.i(HuaweiImpl.TAG, th2);
                return str;
            }
        }

        private HuaWeiInterface(IBinder iBinder2) {
            this.iBinder = iBinder2;
        }
    }

    public HuaweiImpl(Context context) {
        this.mContext = context;
    }

    public String getRomOAID() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(this.mContext.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    SALog.i(TAG, "Get oaid from global settings");
                    return string;
                }
            } catch (Throwable th2) {
                SALog.i(TAG, th2);
            }
        }
        if (!TextUtils.isEmpty(this.mPackageName) || isSupported()) {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(this.mPackageName);
            try {
                if (this.mContext.bindService(intent, this.mService, 1)) {
                    return new HuaWeiInterface(OAIDService.BINDER_QUEUE.take()).getOAID();
                }
                return null;
            } catch (Throwable th3) {
                SALog.i(TAG, th3);
                return null;
            }
        } else {
            SALog.i(TAG, "Huawei Advertising ID not available");
            return null;
        }
    }

    public boolean isSupported() {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.mPackageName = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.mPackageName = "com.huawei.hwid.tv";
            } else {
                this.mPackageName = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
                if (packageManager.getPackageInfo(PackageConstants.SERVICES_PACKAGE_ALL_SCENE, 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
            return false;
        }
    }
}
