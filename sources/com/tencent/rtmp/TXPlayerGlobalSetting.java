package com.tencent.rtmp;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.liteav.txcplayer.common.VodPlayerControl;
import com.tencent.liteav.txcplayer.common.b;
import com.tencent.liteav.txcplayer.common.c;

public class TXPlayerGlobalSetting {
    private static DrmProvisionEnv sDrmProvisionEnv = DrmProvisionEnv.DRM_PROVISION_ENV_COM;

    public enum DrmProvisionEnv {
        DRM_PROVISION_ENV_COM,
        DRM_PROVISION_ENV_CN
    }

    public static String getCacheFolderPath() {
        return b.a();
    }

    public static DrmProvisionEnv getDrmProvisionEnv() {
        return sDrmProvisionEnv;
    }

    public static int getMaxCacheSize() {
        return Math.max(b.b(), 0);
    }

    public static Object getOptions(int i11) {
        if (i11 != 1000) {
            return null;
        }
        if (c.a(LicenseChecker.a.PLAYER_PROJECTION)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static void setCacheFolderPath(String str) {
        b.a(str);
    }

    public static void setDrmProvisionEnv(DrmProvisionEnv drmProvisionEnv) {
        sDrmProvisionEnv = drmProvisionEnv;
    }

    public static void setLicenseFlexibleValid(boolean z11) {
        LiteavLog.i("VodLicenseCheck", "setLicenseFlexibleValid isOpen=".concat(String.valueOf(z11)));
        VodPlayerControl.nativeSetLicenseFlexibleValid(z11);
    }

    public static void setMaxCacheSize(int i11) {
        b.a(i11);
    }
}
