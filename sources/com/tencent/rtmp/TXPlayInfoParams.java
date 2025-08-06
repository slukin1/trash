package com.tencent.rtmp;

import android.text.TextUtils;

public class TXPlayInfoParams {
    public int mAppId;
    public String mFileId;
    public int mMediaType = 0;
    public String mPSign;
    public String mUrl;

    public TXPlayInfoParams(int i11, String str, String str2) {
        this.mAppId = i11;
        this.mFileId = str;
        this.mPSign = str2;
    }

    public int getAppId() {
        return this.mAppId;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public String getPSign() {
        return this.mPSign;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setMediaType(int i11) {
        this.mMediaType = i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("TXPlayInfoParams{");
        if (!TextUtils.isEmpty(this.mFileId)) {
            sb2.append("mAppId=");
            sb2.append(this.mAppId);
            sb2.append(", mFileId='");
            sb2.append(this.mFileId);
            sb2.append('\'');
            sb2.append(", mPSign='");
            sb2.append(this.mPSign);
            sb2.append('\'');
            sb2.append(", mMediaType='");
            sb2.append(this.mMediaType);
            sb2.append('\'');
            sb2.append('}');
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            sb2.append(", mUrl='");
            sb2.append(this.mUrl);
            sb2.append('\'');
            sb2.append(", mMediaType='");
            sb2.append(this.mMediaType);
            sb2.append('\'');
            sb2.append('}');
        }
        return sb2.toString();
    }

    public TXPlayInfoParams(String str) {
        this.mUrl = str;
    }
}
