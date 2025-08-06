package com.tencent.thumbplayer.tcmedia.config;

import android.content.Context;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMgr;
import com.tencent.thumbplayer.tcmedia.core.config.TPPlayerCoreConfig;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPPlayerConfig {
    private static String DOT = "\\.";
    public static final boolean ISOTT = false;
    private static final String TAG = "TPPlayerConfig";
    public static final String VERSION = "2.32.0.338";
    private static String appVersion = "";
    private static String appVersionName = null;
    public static String beacon_log_host = "";
    public static String beacon_policy_host = "";
    private static long buildNum = -1;
    private static String host_config = "";
    private static String mAbUserId = "";
    private static boolean mEnableDataReport = false;
    private static boolean mEnablePlayerReport = false;
    private static String mGuid = "";
    private static String mOutNetIp = "";
    private static int mPlatform = -1;
    private static String mProxyCacheDir = null;
    private static String mProxyDataDir = null;
    private static long mProxyMaxStorageSizeMB = 0;
    private static long mProxyMaxUseMemoryMB = 0;
    private static int mProxyServiceType = -1;
    private static boolean mUseP2P = true;
    private static boolean mUserIsVip = false;
    private static String mUserUin = null;
    private static String mUserUpc = "";
    private static int mUserUpcState;

    public static String getAbUserId() {
        return TextUtils.isEmpty(mAbUserId) ? "" : mAbUserId;
    }

    public static String getAppBigVersion(Context context) {
        if (!TextUtils.isEmpty(appVersion)) {
            return appVersion;
        }
        String appVersionName2 = getAppVersionName(context);
        if (!TextUtils.isEmpty(appVersionName2)) {
            String[] split = appVersionName2.split(DOT);
            if (split != null && split.length == 4) {
                appVersionName2 = appVersionName2.substring(0, appVersionName2.lastIndexOf(InstructionFileId.DOT));
            }
        } else {
            appVersionName2 = "0.0.0";
        }
        appVersion = appVersionName2;
        return appVersionName2;
    }

    public static String getAppVersionName(Context context) {
        if (!TextUtils.isEmpty(appVersionName)) {
            return appVersionName;
        }
        if (context == null) {
            return "";
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            appVersionName = str;
            return str == null ? "" : str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long getBuildNumber(Context context) {
        long j11 = buildNum;
        if (-1 != j11) {
            return j11;
        }
        try {
            long longVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).getLongVersionCode();
            buildNum = longVersionCode;
            return longVersionCode;
        } catch (Throwable unused) {
            TPLogUtil.e(TAG, "getLongVersionCode less api 28");
            return buildNum;
        }
    }

    public static String getGuid() {
        return mGuid;
    }

    public static boolean getMediaDrmReuseEnable() {
        return TPPlayerCoreConfig.getMediaDrmReuseEnable();
    }

    public static boolean getNewReportEnable() {
        return TPPlayerCoreConfig.getCoreEventProcessEnable();
    }

    public static String getOutNetIp() {
        return mOutNetIp;
    }

    public static int getPlatform() {
        return mPlatform;
    }

    public static String getProxyCacheDir() {
        return mProxyCacheDir;
    }

    public static String getProxyConfigDir() {
        if (TextUtils.isEmpty(host_config)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(host_config);
            return !jSONObject.has(TPPlayerMgr.PROXY_HOST_KEY) ? "" : jSONObject.getString(TPPlayerMgr.PROXY_HOST_KEY);
        } catch (JSONException e11) {
            TPLogUtil.e(TAG, (Throwable) e11);
            return "";
        }
    }

    public static String getProxyDataDir() {
        return mProxyDataDir;
    }

    public static long getProxyMaxStorageSizeMB() {
        return mProxyMaxStorageSizeMB;
    }

    public static long getProxyMaxUseMemoryMB() {
        return mProxyMaxUseMemoryMB;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r2 = mPlatform;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getProxyServiceType() {
        /*
            int r0 = mProxyServiceType
            r1 = -1
            if (r0 != r1) goto L_0x000a
            int r2 = mPlatform
            if (r2 == r1) goto L_0x000a
            return r2
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig.getProxyServiceType():int");
    }

    public static String getUserUin() {
        return mUserUin;
    }

    public static String getUserUpc() {
        return mUserUpc;
    }

    public static int getUserUpcState() {
        return mUserUpcState;
    }

    public static int getVideoMediaCodecCoexistMaxCnt() {
        return TPPlayerCoreConfig.getVideoMediaCodecCoexistMaxCnt();
    }

    public static String getWidevineProvisioningServerUrl() {
        return TPPlayerCoreConfig.getWidevineProvisioningServerUrl();
    }

    public static boolean isDataReportEnable() {
        return mEnableDataReport;
    }

    public static boolean isPlayerReportEnable() {
        return mEnablePlayerReport;
    }

    public static boolean isUseP2P() {
        return mUseP2P;
    }

    public static boolean isUserIsVip() {
        return mUserIsVip;
    }

    public static void parseHostConfig(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "parseHostConfig, config is null.";
        } else {
            host_config = str;
            TPLogUtil.i(TAG, "parseHostConfig:".concat(String.valueOf(str)));
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(TPPlayerMgr.PLYAER_HOST_KEY)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(TPPlayerMgr.PLYAER_HOST_KEY);
                    if (jSONObject2.has(TPPlayerMgr.BEACON_POLICY_HOST_KEY)) {
                        beacon_policy_host = jSONObject2.getString(TPPlayerMgr.BEACON_POLICY_HOST_KEY);
                    }
                    if (jSONObject2.has(TPPlayerMgr.BEACON_LOG_HOST_KEY)) {
                        beacon_log_host = jSONObject2.getString(TPPlayerMgr.BEACON_LOG_HOST_KEY);
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th2) {
                str2 = "parseHostConfig exception: " + th2.toString();
            }
        }
        TPLogUtil.w(TAG, str2);
    }

    public static void setAbUserId(String str) {
        mAbUserId = str;
    }

    public static void setDataReportEnable(boolean z11) {
        mEnableDataReport = z11;
    }

    public static void setDebugEnable(boolean z11) {
        TPLogUtil.setDebugEnable(z11);
    }

    public static void setGuid(String str) {
        mGuid = str;
    }

    public static void setMediaDrmReuseEnable(boolean z11) {
        TPPlayerCoreConfig.setMediaDrmReuseEnable(z11);
    }

    public static void setNewReportEnable(boolean z11) {
        TPPlayerCoreConfig.setCoreEventProcessEnable(z11);
    }

    public static void setOutNetIp(String str) {
        mOutNetIp = str;
    }

    public static void setP2PEnable(boolean z11) {
        mUseP2P = z11;
    }

    public static void setPlatform(int i11) {
        mPlatform = i11;
    }

    public static void setPlayerReportEnable(boolean z11) {
        mEnablePlayerReport = z11;
    }

    public static void setProxyCacheDir(String str) {
        mProxyCacheDir = str;
    }

    public static void setProxyDataDir(String str) {
        mProxyDataDir = str;
    }

    public static void setProxyMaxStorageSizeMB(long j11) {
        mProxyMaxStorageSizeMB = j11;
    }

    public static void setProxyMaxUseMemoryMB(long j11) {
        mProxyMaxUseMemoryMB = j11;
    }

    public static void setProxyServiceType(int i11) {
        mProxyServiceType = i11;
    }

    public static void setUserIsVip(boolean z11) {
        mUserIsVip = z11;
    }

    public static void setUserUin(String str) {
        mUserUin = str;
    }

    public static void setUserUpc(String str) {
        mUserUpc = str;
    }

    public static void setUserUpcState(int i11) {
        mUserUpcState = i11;
    }

    public static void setVideoMediaCodecCoexistMaxCnt(int i11) {
        TPPlayerCoreConfig.setVideoMediaCodecCoexistMaxCnt(i11);
    }

    public static void setWidevineProvisioningServerUrl(String str) {
        TPPlayerCoreConfig.setWidevineProvisioningServerUrl(str);
    }
}
