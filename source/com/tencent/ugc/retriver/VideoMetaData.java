package com.tencent.ugc.retriver;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::ugc")
public class VideoMetaData {
    private long mAudioBitrate;
    private long mAudioDuration;
    private int mChannels;
    private float mFps;
    private int mHeight;
    private int mRotation;
    private int mSampleRate;
    private long mVideoBitrate;
    private long mVideoDuration;
    private String mVideoMimeType;
    private int mWidth;

    public long getAudioBitrate() {
        return this.mAudioBitrate;
    }

    public long getAudioDuration() {
        return this.mAudioDuration;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public float getFps() {
        return this.mFps;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public long getVideoBitrate() {
        return this.mVideoBitrate;
    }

    public long getVideoDuration() {
        return this.mVideoDuration;
    }

    public String getVideoMimeType() {
        return this.mVideoMimeType;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setAudioBitrate(long j11) {
        this.mAudioBitrate = j11;
    }

    public void setAudioDuration(long j11) {
        this.mAudioDuration = j11;
    }

    public void setChannels(int i11) {
        this.mChannels = i11;
    }

    public void setFps(float f11) {
        this.mFps = f11;
    }

    public void setHeight(int i11) {
        this.mHeight = i11;
    }

    public void setRotation(int i11) {
        this.mRotation = i11;
    }

    public void setSampleRate(int i11) {
        this.mSampleRate = i11;
    }

    public void setVideoBitrate(long j11) {
        this.mVideoBitrate = j11;
    }

    public void setVideoDuration(long j11) {
        this.mVideoDuration = j11;
    }

    public void setVideoMimeType(String str) {
        this.mVideoMimeType = str;
    }

    public void setWidth(int i11) {
        this.mWidth = i11;
    }

    public String toString() {
        return "FFMediaInfo{rotation=" + this.mRotation + ", width=" + this.mWidth + ", height=" + this.mHeight + ", fps=" + this.mFps + ", videoBitrate=" + this.mVideoBitrate + ", videoDuration=" + this.mVideoDuration + ", sampleRate=" + this.mSampleRate + ", channels=" + this.mChannels + ", audioBitrate=" + this.mAudioBitrate + ", audioDuration=" + this.mAudioDuration + '}';
    }
}
