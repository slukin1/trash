package com.tencent.ugc.datereport;

import android.text.TextUtils;
import com.tencent.liteav.base.datareport.Event4XReporter;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.ugc.UGCLicenseChecker;
import java.util.Locale;

public class UGCDataReport {
    private static final String TAG = "UGCDataReport";
    private static UGCDataReport sInstance;
    private String mAppName = (LiteavSystemInfo.getAppName() + ":" + this.mPkgName);
    private final Event4XReporter mDAUReporter = new Event4XReporter(UGCDataReportDef.COMMAND_ID_DAU, 1004, "", true, 1);
    private String mDevId = LiteavSystemInfo.getDeviceUuid();
    private String mDevUUID = LiteavSystemInfo.getDeviceUuid();
    private String mNetType = Integer.toString(LiteavSystemInfo.getNetworkType());
    private String mPkgName = LiteavSystemInfo.getAppPackageName();
    private String mSystemVersion = String.valueOf(LiteavSystemInfo.getSystemOSVersionInt());

    private UGCDataReport() {
    }

    private long getAppId() {
        String licenseAppId = UGCLicenseChecker.getLicenseAppId();
        if (TextUtils.isEmpty(licenseAppId)) {
            return 0;
        }
        try {
            return Long.parseLong(licenseAppId);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static UGCDataReport getInstance() {
        if (sInstance == null) {
            synchronized (UGCDataReport.class) {
                if (sInstance == null) {
                    sInstance = new UGCDataReport();
                }
            }
        }
        return sInstance;
    }

    public static synchronized void reportDAU(int i11) {
        synchronized (UGCDataReport.class) {
            getInstance().reportDAUImpl(i11, 0, "");
        }
    }

    private void reportDAUImpl(int i11, int i12, String str) {
        setCommonInfo();
        this.mDAUReporter.reportDau(i11, i12, str == null ? "" : str);
        LiteavLog.i(TAG, String.format(Locale.ENGLISH, "reportDAU devUUID = %s, eventId = %d,  errCode = %d, errInfo = %s", new Object[]{this.mDevUUID, Integer.valueOf(i11), Integer.valueOf(i12), str}));
    }

    public static void reportLicenseIsValid() {
        LicenseChecker.d valid = LicenseChecker.getInstance().valid(LicenseChecker.a.UGC_SIMPLE);
        if (valid == LicenseChecker.d.OK) {
            reportDAU(1016);
        } else {
            reportDAU(1017, valid.value, "");
        }
    }

    private void setCommonInfo() {
        String str = this.mNetType;
        if (str != null) {
            this.mDAUReporter.setCommonStringValue("net_type", str);
        }
        String str2 = this.mDevId;
        if (str2 != null) {
            this.mDAUReporter.setCommonStringValue(UGCDataReportDef.DR_KEY_DEV_ID, str2);
        }
        String str3 = this.mDevUUID;
        if (str3 != null) {
            this.mDAUReporter.setCommonStringValue(UGCDataReportDef.DR_KEY_DEV_UUID, str3);
        }
        String str4 = this.mAppName;
        if (str4 != null) {
            this.mDAUReporter.setCommonStringValue("app_name", str4);
        }
        String str5 = this.mSystemVersion;
        if (str5 != null) {
            this.mDAUReporter.setCommonStringValue(UGCDataReportDef.DR_KEY_SYS_VER, str5);
        }
        long appId = getAppId();
        if (appId != 0) {
            this.mDAUReporter.setCommonIntValue(UGCDataReportDef.DR_KEY_APP_ID, appId);
        }
    }

    public static synchronized void reportDAU(int i11, int i12, String str) {
        synchronized (UGCDataReport.class) {
            getInstance().reportDAUImpl(i11, i12, str);
        }
    }
}
