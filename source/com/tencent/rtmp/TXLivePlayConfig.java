package com.tencent.rtmp;

import java.io.Serializable;
import java.util.Map;

public class TXLivePlayConfig implements Serializable {
    private static final long serialVersionUID = 1;
    public boolean mAutoAdjustCacheTime = true;
    public float mCacheTime = 5.0f;
    public int mConnectRetryCount = 3;
    public int mConnectRetryInterval = 3;
    public boolean mEnableAec = false;
    public boolean mEnableMessage = false;
    public boolean mEnableMetaData = false;
    public boolean mEnableNearestIP = true;
    public String mFlvSessionKey = "";
    public Map<String, String> mHeaders;
    public float mMaxAutoAdjustCacheTime = 5.0f;
    public float mMinAutoAdjustCacheTime = 1.0f;
    public int mRtmpChannelType = 0;
    public int mVideoBlockThreshold = TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE;

    public float getCacheTime() {
        return this.mCacheTime;
    }

    public int getConnectRetryCount() {
        return this.mConnectRetryCount;
    }

    public int getConnectRetryInterval() {
        return this.mConnectRetryInterval;
    }

    public String getFlvSessionKey() {
        return this.mFlvSessionKey;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public float getMaxAutoAdjustCacheTime() {
        return this.mMaxAutoAdjustCacheTime;
    }

    public float getMinAutoAdjustCacheTime() {
        return this.mMinAutoAdjustCacheTime;
    }

    public int getRtmpChannelType() {
        return this.mRtmpChannelType;
    }

    public int getVideoBlockThreshold() {
        return this.mVideoBlockThreshold;
    }

    public boolean isAutoAdjustCacheTime() {
        return this.mAutoAdjustCacheTime;
    }

    public boolean isEnableAec() {
        return this.mEnableAec;
    }

    public boolean isEnableMessage() {
        return this.mEnableMessage;
    }

    public boolean isEnableMetaData() {
        return this.mEnableMetaData;
    }

    public boolean isEnableNearestIP() {
        return this.mEnableNearestIP;
    }

    public void setAutoAdjustCacheTime(boolean z11) {
        this.mAutoAdjustCacheTime = z11;
    }

    public void setCacheTime(float f11) {
        this.mCacheTime = f11;
    }

    public void setConnectRetryCount(int i11) {
        this.mConnectRetryCount = i11;
    }

    public void setConnectRetryInterval(int i11) {
        this.mConnectRetryInterval = i11;
    }

    @Deprecated
    public void setEnableAEC(boolean z11) {
        this.mEnableAec = z11;
    }

    public void setEnableMessage(boolean z11) {
        this.mEnableMessage = z11;
    }

    public void setEnableMetaData(boolean z11) {
        this.mEnableMetaData = z11;
    }

    @Deprecated
    public void setEnableNearestIP(boolean z11) {
        this.mEnableNearestIP = z11;
    }

    public void setFlvSessionKey(String str) {
        this.mFlvSessionKey = str;
    }

    @Deprecated
    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setMaxAutoAdjustCacheTime(float f11) {
        this.mMaxAutoAdjustCacheTime = f11;
    }

    public void setMinAutoAdjustCacheTime(float f11) {
        this.mMinAutoAdjustCacheTime = f11;
    }

    @Deprecated
    public void setRtmpChannelType(int i11) {
        this.mRtmpChannelType = i11;
    }

    public void setVideoBlockThreshold(int i11) {
        this.mVideoBlockThreshold = i11;
    }

    public String toString() {
        return "{mCacheTime=" + this.mCacheTime + ", mMaxAutoAdjustCacheTime=" + this.mMaxAutoAdjustCacheTime + ", mMinAutoAdjustCacheTime=" + this.mMinAutoAdjustCacheTime + ", mAutoAdjustCacheTime=" + this.mAutoAdjustCacheTime + ", mVideoBlockThreshold=" + this.mVideoBlockThreshold + ", mConnectRetryCount=" + this.mConnectRetryCount + ", mConnectRetryInterval=" + this.mConnectRetryInterval + ", mEnableAec=" + this.mEnableAec + ", mEnableMessage=" + this.mEnableMessage + ", mEnableMetaData=" + this.mEnableMetaData + '}';
    }
}
