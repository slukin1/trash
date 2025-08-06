package com.tencent.ugc;

public class AudioEncodeParams {
    private int mBitrate;
    private int mBitsPerChannel;
    private int mChannels;
    private int mSampleRate;

    public AudioEncodeParams() {
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public int getBitsPerChannel() {
        return this.mBitsPerChannel;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public void setBitrate(int i11) {
        this.mBitrate = i11;
    }

    public void setBitsPerChannel(int i11) {
        this.mBitsPerChannel = i11;
    }

    public void setChannels(int i11) {
        this.mChannels = i11;
    }

    public void setSampleRate(int i11) {
        this.mSampleRate = i11;
    }

    public AudioEncodeParams(AudioEncodeParams audioEncodeParams) {
        if (audioEncodeParams != null) {
            this.mChannels = audioEncodeParams.mChannels;
            this.mSampleRate = audioEncodeParams.mSampleRate;
            this.mBitsPerChannel = audioEncodeParams.mBitsPerChannel;
            this.mBitrate = audioEncodeParams.mBitrate;
        }
    }
}
