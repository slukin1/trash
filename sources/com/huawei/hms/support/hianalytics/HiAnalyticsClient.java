package com.huawei.hms.support.hianalytics;

import android.content.Context;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.Map;

public class HiAnalyticsClient extends HiAnalyticsBase {
    private static final String TAG = "HiAnalyticsClient";

    @Deprecated
    public static String reportEntry(Context context, String str) {
        if (context != null) {
            return reportEntry(context, str, Util.getAppId(context), 0);
        }
        HMSLog.e(TAG, "<reportEntry 2 param> context is null.");
        return "";
    }

    public static void reportExit(Context context, String str, String str2, int i11, int i12) {
        if (context == null) {
            HMSLog.e(TAG, "<reportExit 5 param> context is null.");
            return;
        }
        reportExit(context, str, str2, Util.getAppId(context), i11, i12, 0);
    }

    public static String reportEntry(Context context, String str, int i11) {
        if (context != null) {
            return reportEntry(context, str, Util.getAppId(context), i11);
        }
        HMSLog.e(TAG, "<reportEntry 3 param> context is null.");
        return "";
    }

    public static void reportExit(Context context, String str, String str2, int i11, int i12, int i13) {
        if (context == null) {
            HMSLog.e(TAG, "<reportExit 6 param> context is null.");
            return;
        }
        reportExit(context, str, str2, Util.getAppId(context), i11, i12, i13);
    }

    public static String reportEntry(Context context, String str, String str2, int i11) {
        if (context == null) {
            HMSLog.e(TAG, "<reportEntry 4 param> context is null.");
            return "";
        }
        String id2 = TransactionIdCreater.getId(str2, str);
        Map<String, String> mapForBi = HiAnalyticsBase.getMapForBi(context, str);
        mapForBi.put("appid", str2);
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, id2);
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(i11)));
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_KIT_API_CALLED, mapForBi);
        return id2;
    }

    public static void reportExit(Context context, String str, String str2, String str3, int i11, int i12, int i13) {
        if (context == null) {
            HMSLog.e(TAG, "<reportExit 7 param> context is null.");
            return;
        }
        Map<String, String> mapForBi = HiAnalyticsBase.getMapForBi(context, str);
        mapForBi.put("appid", str3);
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, str2);
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(i11));
        mapForBi.put("result", String.valueOf(i12));
        mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(i13)));
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_KIT_API_CALLED, mapForBi);
    }
}
