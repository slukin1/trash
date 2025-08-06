package com.tencent.rtmp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TXVodPlayConfig {
    public boolean mAutoRotate = true;
    public String mCacheFolderPath;
    public String mCacheMp4ExtName = "mp4";
    public int mConnectRetryCount = 3;
    public int mConnectRetryInterval = 3;
    public boolean mEnableAccurateSeek = true;
    public boolean mEnableRenderProcess = true;
    public Map<String, Object> mExtInfoMap = new ConcurrentHashMap();
    public int mFirstStartPlayBufferTime = 0;
    public Map<String, String> mHeaders;
    public float mMaxBufferSize = 0.0f;
    public int mMaxCacheItems;
    public float mMaxPreloadSize = 0.0f;
    public int mMediaType = 0;
    public int mNextStartPlayBufferTime = 0;
    public String mOverlayIv;
    public String mOverlayKey;
    public int mPlayerType = 1;
    public long mPreferredResolution = -1;
    public int mProgressInterval;
    public boolean mSmoothSwitchBitrate = false;
    public int mTimeout = 10;

    public String getCacheFolderPath() {
        return this.mCacheFolderPath;
    }

    public String getCacheMp4ExtName() {
        return this.mCacheMp4ExtName;
    }

    public int getConnectRetryCount() {
        return this.mConnectRetryCount;
    }

    public int getConnectRetryInterval() {
        return this.mConnectRetryInterval;
    }

    public Map<String, Object> getExtInfoMap() {
        return this.mExtInfoMap;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public float getMaxBufferSize() {
        return this.mMaxBufferSize;
    }

    public int getMaxCacheItems() {
        return this.mMaxCacheItems;
    }

    public float getMaxPreloadSize() {
        return this.mMaxPreloadSize;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public String getOverlayIv() {
        return this.mOverlayIv;
    }

    public String getOverlayKey() {
        return this.mOverlayKey;
    }

    public int getPlayerType() {
        return this.mPlayerType;
    }

    public long getPreferredResolution() {
        return this.mPreferredResolution;
    }

    public int getProgressInterval() {
        return this.mProgressInterval;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public boolean isAutoRotate() {
        return this.mAutoRotate;
    }

    public boolean isEnableAccurateSeek() {
        return this.mEnableAccurateSeek;
    }

    public boolean isEnableRenderProcess() {
        return this.mEnableRenderProcess;
    }

    public boolean isSmoothSwitchBitrate() {
        return this.mSmoothSwitchBitrate;
    }

    public void setAutoRotate(boolean z11) {
        this.mAutoRotate = z11;
    }

    @Deprecated
    public void setCacheFolderPath(String str) {
        this.mCacheFolderPath = str;
    }

    public void setCacheMp4ExtName(String str) {
        this.mCacheMp4ExtName = str;
    }

    public void setConnectRetryCount(int i11) {
        this.mConnectRetryCount = i11;
    }

    public void setConnectRetryInterval(int i11) {
        this.mConnectRetryInterval = i11;
    }

    public void setEnableAccurateSeek(boolean z11) {
        this.mEnableAccurateSeek = z11;
    }

    public void setEnableRenderProcess(boolean z11) {
        this.mEnableRenderProcess = z11;
    }

    public void setExtInfo(Map<String, Object> map) {
        this.mExtInfoMap.clear();
        this.mExtInfoMap.putAll(map);
    }

    @Deprecated
    public void setFirstStartPlayBufferTime(int i11) {
        this.mFirstStartPlayBufferTime = i11;
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setMaxBufferSize(float f11) {
        this.mMaxBufferSize = f11;
    }

    @Deprecated
    public void setMaxCacheItems(int i11) {
        this.mMaxCacheItems = i11;
    }

    public void setMaxPreloadSize(float f11) {
        this.mMaxPreloadSize = f11;
    }

    public void setMediaType(int i11) {
        this.mMediaType = i11;
    }

    @Deprecated
    public void setNextStartPlayBufferTime(int i11) {
        this.mNextStartPlayBufferTime = i11;
    }

    public void setOverlayIv(String str) {
        this.mOverlayIv = str;
    }

    public void setOverlayKey(String str) {
        this.mOverlayKey = str;
    }

    public void setPlayerType(int i11) {
        this.mPlayerType = i11;
    }

    public void setPreferredResolution(long j11) {
        this.mPreferredResolution = j11;
    }

    public void setProgressInterval(int i11) {
        this.mProgressInterval = i11;
    }

    public void setSmoothSwitchBitrate(boolean z11) {
        this.mSmoothSwitchBitrate = z11;
    }

    public void setTimeout(int i11) {
        this.mTimeout = i11;
    }
}
