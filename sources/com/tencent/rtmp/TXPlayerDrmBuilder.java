package com.tencent.rtmp;

import android.text.TextUtils;
import com.tencent.liteav.txcplayer.a.a;
import com.tencent.rtmp.TXPlayerGlobalSetting;

public class TXPlayerDrmBuilder {
    private static String DEFAULT_CN_PROVISION_URL;
    private static String DEFAULT_COM_PROVISION_URL;
    public String mDeviceCertificateUrl;
    public String mKeyLicenseUrl;
    public String mPlayUrl;

    public TXPlayerDrmBuilder() {
        initProvision();
    }

    private void initProvision() {
        if (TextUtils.isEmpty(DEFAULT_COM_PROVISION_URL)) {
            DEFAULT_COM_PROVISION_URL = a.e("aHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vY2VydGlmaWNhdGVwcm92aXNpb25pbmcvdjEvZGV2aWNlY2VydGlmaWNhdGVzL2NyZWF0ZT9rZXk9QUl6YVN5Qi01T0xLVHgyaVU1bWtvMThEZmR3SzU2MTFKSWpiVWhF");
        }
        if (TextUtils.isEmpty(DEFAULT_CN_PROVISION_URL)) {
            DEFAULT_CN_PROVISION_URL = a.e("aHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jbi9jZXJ0aWZpY2F0ZXByb3Zpc2lvbmluZy92MS9kZXZpY2VjZXJ0aWZpY2F0ZXMvY3JlYXRlP2tleT1BSXphU3lCLTVPTEtUeDJpVTVta28xOERmZHdLNTYxMUpJamJVaEU=");
        }
    }

    public String getDeviceCertificateUrl() {
        if (!TextUtils.isEmpty(this.mDeviceCertificateUrl)) {
            return this.mDeviceCertificateUrl;
        }
        if (TXPlayerGlobalSetting.getDrmProvisionEnv() == TXPlayerGlobalSetting.DrmProvisionEnv.DRM_PROVISION_ENV_COM) {
            return DEFAULT_COM_PROVISION_URL;
        }
        return DEFAULT_CN_PROVISION_URL;
    }

    public String getKeyLicenseUrl() {
        return this.mKeyLicenseUrl;
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public TXPlayerDrmBuilder setDeviceCertificateUrl(String str) {
        this.mDeviceCertificateUrl = str;
        return this;
    }

    public TXPlayerDrmBuilder setKeyLicenseUrl(String str) {
        this.mKeyLicenseUrl = str;
        return this;
    }

    public TXPlayerDrmBuilder setPlayUrl(String str) {
        this.mPlayUrl = str;
        return this;
    }

    public String toString() {
        return "TXPlayerDrmBuilder{deviceCertificateUrl='" + this.mDeviceCertificateUrl + '\'' + ", licenseUrl='" + this.mKeyLicenseUrl + '\'' + ", playUrl='" + this.mPlayUrl + '\'' + '}';
    }

    public TXPlayerDrmBuilder(String str, String str2) {
        initProvision();
        this.mKeyLicenseUrl = str;
        this.mPlayUrl = str2;
    }
}
