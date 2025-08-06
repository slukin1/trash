package com.tencent.rtmp.downloader;

import android.text.TextUtils;
import com.tencent.rtmp.TXPlayerAuthBuilder;

public class TXVodDownloadDataSource {
    public static final int QUALITY_1080P = 1080;
    public static final int QUALITY_240P = 240;
    public static final int QUALITY_2K = 5;
    public static final int QUALITY_360P = 360;
    public static final int QUALITY_480P = 480;
    public static final int QUALITY_4K = 6;
    public static final int QUALITY_540P = 540;
    public static final int QUALITY_720P = 720;
    @Deprecated
    public static final int QUALITY_FHD = 4;
    @Deprecated
    public static final int QUALITY_FLU = 1;
    @Deprecated
    public static final int QUALITY_HD = 3;
    public static final int QUALITY_OD = 0;
    @Deprecated
    public static final int QUALITY_SD = 2;
    public static final int QUALITY_UNK = 1000;
    public int appId = -1;
    public TXPlayerAuthBuilder authBuilder;
    public String fileId = "";
    public String overlayIv = "";
    public String overlayKey = "";
    public String pSign = "";
    public int quality = 1000;
    public String templateName;
    public String token;
    public String userName = "default";

    public TXVodDownloadDataSource(int i11, String str, int i12, String str2, String str3) {
        this.appId = i11;
        this.fileId = str;
        this.quality = i12;
        this.pSign = str2;
        if (!TextUtils.isEmpty(str3)) {
            this.userName = str3;
        }
    }

    public int getAppId() {
        return this.appId;
    }

    @Deprecated
    public TXPlayerAuthBuilder getAuthBuilder() {
        return this.authBuilder;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getOverlayIv() {
        return this.overlayIv;
    }

    public String getOverlayKey() {
        return this.overlayKey;
    }

    public String getPSign() {
        return this.pSign;
    }

    public int getQuality() {
        return this.quality;
    }

    @Deprecated
    public String getTemplateName() {
        return this.templateName;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setQuality(int i11) {
        this.quality = i11;
    }

    public void setToken(String str) {
        this.token = str;
    }

    @Deprecated
    public TXVodDownloadDataSource(TXPlayerAuthBuilder tXPlayerAuthBuilder, int i11) {
        this.authBuilder = tXPlayerAuthBuilder;
        this.quality = i11;
    }

    @Deprecated
    public TXVodDownloadDataSource(TXPlayerAuthBuilder tXPlayerAuthBuilder, String str) {
        this.authBuilder = tXPlayerAuthBuilder;
        this.templateName = str;
    }

    public TXVodDownloadDataSource() {
    }
}
