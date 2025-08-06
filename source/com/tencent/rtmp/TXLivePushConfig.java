package com.tencent.rtmp;

import android.graphics.Bitmap;
import java.io.Serializable;
import java.util.HashMap;

public class TXLivePushConfig implements Serializable {
    public static final int DEFAULT_MAX_VIDEO_BITRATE = 1200;
    public static final int DEFAULT_MIN_VIDEO_BITRATE = 800;
    public int mAudioBitrate;
    public int mAudioChannels = 1;
    public String mAudioPreProcessFuncName;
    public String mAudioPreProcessLibrary;
    public int mAudioSample = 48000;
    public boolean mAutoAdjustBitrate = false;
    public int mAutoAdjustStrategy = 0;
    public int mBeautyLevel = 0;
    public int mConnectRetryCount = 3;
    public int mConnectRetryInterval = 3;
    public int mCustomModeType = 0;
    public boolean mEnableAec = false;
    public boolean mEnableAgc = false;
    public boolean mEnableAns = false;
    public boolean mEnableAudioPreview = false;
    public boolean mEnableHighResolutionCapture = false;
    public boolean mEnableNearestIP = true;
    public boolean mEnablePureAudioPush = false;
    public boolean mEnableScreenCaptureAutoRotate = false;
    public boolean mEnableVideoHardEncoderMainProfile = true;
    public boolean mEnableZoom = false;
    public int mEyeScaleLevel = 0;
    public int mFaceSlimLevel = 0;
    public boolean mFrontCamera = true;
    public int mHardwareAccel = 2;
    public int mHomeOrientation = 1;
    public int mLocalVideoMirrorType = 0;
    public int mMaxVideoBitrate = 1500;
    public HashMap<String, String> mMetaData;
    public int mMinVideoBitrate = DEFAULT_MIN_VIDEO_BITRATE;
    public int mPauseFlag = 1;
    public int mPauseFps = 5;
    public Bitmap mPauseImg = null;
    public int mPauseTime = 300;
    public int mRtmpChannelType = 0;
    public int mRuddyLevel = 0;
    public boolean mTouchFocus = true;
    public int mVideoBitrate = 1200;
    public int mVideoEncodeGop = 3;
    public boolean mVideoEncoderXMirror = false;
    public int mVideoFPS = 20;
    public String mVideoPreProcessFuncName;
    public String mVideoPreProcessLibrary;
    public TXVideoResolution mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_540_960;
    public int mVolumeType = 0;
    public Bitmap mWatermark;
    public float mWatermarkWidth = -1.0f;
    public int mWatermarkX = 0;
    public float mWatermarkXF = 0.0f;
    public int mWatermarkY = 0;
    public float mWatermarkYF = 0.0f;
    public int mWhiteningLevel = 0;

    @Deprecated
    public void enableAEC(boolean z11) {
        this.mEnableAec = z11;
    }

    @Deprecated
    public void enableAGC(boolean z11) {
        this.mEnableAgc = z11;
    }

    public void enableANS(boolean z11) {
        this.mEnableAns = z11;
    }

    public void enableAudioEarMonitoring(boolean z11) {
        this.mEnableAudioPreview = z11;
    }

    @Deprecated
    public void enableHighResolutionCaptureMode(boolean z11) {
        this.mEnableHighResolutionCapture = z11;
    }

    @Deprecated
    public void enableNearestIP(boolean z11) {
        this.mEnableNearestIP = z11;
    }

    public void enablePureAudioPush(boolean z11) {
        this.mEnablePureAudioPush = z11;
    }

    public void enableScreenCaptureAutoRotate(boolean z11) {
        this.mEnableScreenCaptureAutoRotate = z11;
    }

    public void enableVideoHardEncoderMainProfile(boolean z11) {
        this.mEnableVideoHardEncoderMainProfile = z11;
    }

    public void setAudioChannels(int i11) {
        this.mAudioChannels = i11;
    }

    public void setAudioSampleRate(int i11) {
        this.mAudioSample = i11;
    }

    public void setAutoAdjustBitrate(boolean z11) {
        this.mAutoAdjustBitrate = z11;
    }

    public void setAutoAdjustStrategy(int i11) {
        this.mAutoAdjustStrategy = i11;
    }

    @Deprecated
    public void setBeautyFilter(int i11, int i12, int i13) {
        this.mBeautyLevel = i11;
        this.mWhiteningLevel = i12;
        this.mRuddyLevel = i13;
    }

    public void setConnectRetryCount(int i11) {
        this.mConnectRetryCount = i11;
    }

    public void setConnectRetryInterval(int i11) {
        this.mConnectRetryInterval = i11;
    }

    public void setCustomModeType(int i11) {
        this.mCustomModeType = i11;
    }

    public void setEnableZoom(boolean z11) {
        this.mEnableZoom = z11;
    }

    @Deprecated
    public void setEyeScaleLevel(int i11) {
        this.mEyeScaleLevel = i11;
    }

    @Deprecated
    public void setFaceSlimLevel(int i11) {
        this.mFaceSlimLevel = i11;
    }

    @Deprecated
    public void setFrontCamera(boolean z11) {
        this.mFrontCamera = z11;
    }

    public void setHardwareAcceleration(int i11) {
        int i12 = 2;
        if (i11 < 0) {
            i11 = 2;
        }
        if (i11 <= 2) {
            i12 = i11;
        }
        this.mHardwareAccel = i12;
    }

    public void setHomeOrientation(int i11) {
        this.mHomeOrientation = i11;
    }

    public void setLocalVideoMirrorType(int i11) {
        this.mLocalVideoMirrorType = i11;
    }

    public void setMaxVideoBitrate(int i11) {
        this.mMaxVideoBitrate = i11;
    }

    public void setMetaData(HashMap<String, String> hashMap) {
        this.mMetaData = hashMap;
    }

    public void setMinVideoBitrate(int i11) {
        this.mMinVideoBitrate = i11;
    }

    public void setPauseFlag(int i11) {
        this.mPauseFlag = i11;
    }

    public void setPauseImg(Bitmap bitmap) {
        this.mPauseImg = bitmap;
    }

    @Deprecated
    public void setRtmpChannelType(int i11) {
        this.mRtmpChannelType = i11;
    }

    public void setTouchFocus(boolean z11) {
        this.mTouchFocus = z11;
    }

    public void setVideoBitrate(int i11) {
        this.mVideoBitrate = i11;
    }

    public void setVideoEncodeGop(int i11) {
        this.mVideoEncodeGop = i11;
    }

    public void setVideoEncoderXMirror(boolean z11) {
        this.mVideoEncoderXMirror = z11;
    }

    public void setVideoFPS(int i11) {
        this.mVideoFPS = i11;
    }

    public void setVideoResolution(int i11) {
        if (i11 == 30) {
            this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_1080_1920;
        } else if (i11 != 31) {
            switch (i11) {
                case 0:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_360_640;
                    return;
                case 1:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_540_960;
                    return;
                case 2:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_720_1280;
                    return;
                case 3:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_640_360;
                    return;
                case 4:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_960_540;
                    return;
                case 5:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_1280_720;
                    return;
                case 6:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_320_480;
                    return;
                case 7:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_180_320;
                    return;
                case 8:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_270_480;
                    return;
                case 9:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_320_180;
                    return;
                case 10:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_270;
                    return;
                case 11:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_240_320;
                    return;
                case 12:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_360_480;
                    return;
                case 13:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_640;
                    return;
                case 14:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_320_240;
                    return;
                case 15:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_360;
                    return;
                case 16:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_640_480;
                    return;
                case 17:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_480;
                    return;
                case 18:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_270_270;
                    return;
                case 19:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_160_160;
                    return;
                default:
                    return;
            }
        } else {
            this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_1920_1080;
        }
    }

    public void setVolumeType(int i11) {
        this.mVolumeType = i11;
    }

    public void setWatermark(Bitmap bitmap, int i11, int i12) {
        this.mWatermark = bitmap;
        this.mWatermarkX = i11;
        this.mWatermarkY = i12;
    }

    public String toString() {
        return "[resolution:" + this.mVideoResolution + "][fps:" + this.mVideoFPS + "][gop:" + this.mVideoEncodeGop + "][bitrate:" + this.mVideoBitrate + "][maxBitrate:" + this.mMaxVideoBitrate + "][minBitrate:" + this.mMinVideoBitrate + "][highCapture:" + this.mEnableHighResolutionCapture + "][hwAcc:" + this.mHardwareAccel + "][homeOrientation:" + this.mHomeOrientation + "][volumeType:" + this.mVolumeType + "][earMonitor:" + this.mEnableAudioPreview + "][agc:" + this.mEnableAgc + "][ans:" + this.mEnableAns + "][aec:" + this.mEnableAec + "][sample:" + this.mAudioSample + "][pureAudioPush:" + this.mEnablePureAudioPush + "]";
    }

    @Deprecated
    public void setPauseImg(int i11, int i12) {
        this.mPauseTime = i11;
        this.mPauseFps = i12;
    }

    public void setWatermark(Bitmap bitmap, float f11, float f12, float f13) {
        this.mWatermark = bitmap;
        this.mWatermarkXF = f11;
        this.mWatermarkYF = f12;
        this.mWatermarkWidth = f13;
    }
}
