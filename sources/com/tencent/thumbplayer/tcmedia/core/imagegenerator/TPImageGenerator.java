package com.tencent.thumbplayer.tcmedia.core.imagegenerator;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLibraryLoader;
import java.util.Map;

public class TPImageGenerator {
    private ITPImageGeneratorCallback mCallback = null;
    private int mFd = -1;
    private long mFdLength;
    private long mFdOffset;
    private Map<String, String> mHttpHeader = null;
    private boolean mInited = false;
    private boolean mIsLibLoaded = false;
    private long mNativeContext = 0;
    private String mUrl = null;

    public TPImageGenerator(int i11, long j11, long j12, ITPImageGeneratorCallback iTPImageGeneratorCallback) {
        loadLibrary();
        this.mFd = i11;
        this.mFdOffset = j11;
        this.mFdLength = j12;
        this.mCallback = iTPImageGeneratorCallback;
    }

    public TPImageGenerator(String str, ITPImageGeneratorCallback iTPImageGeneratorCallback) {
        loadLibrary();
        this.mUrl = str;
        this.mCallback = iTPImageGeneratorCallback;
    }

    public TPImageGenerator(String str, Map<String, String> map, ITPImageGeneratorCallback iTPImageGeneratorCallback) {
        loadLibrary();
        this.mUrl = str;
        this.mHttpHeader = map;
        this.mCallback = iTPImageGeneratorCallback;
    }

    private native void _cancelAllImageGenerations();

    private native int _createWithFd(int i11, long j11, long j12, Object obj);

    private native int _createWithUrl(String str, Object obj);

    private native void _generateImageAsyncAtTime(long j11, long j12, Object obj);

    private native void _generateImagesAsyncForTimes(long[] jArr, long j11, Object obj);

    private native void _release();

    private void loadLibrary() {
        try {
            TPNativeLibraryLoader.loadLibIfNeeded((Context) null);
            this.mIsLibLoaded = true;
        } catch (UnsupportedOperationException e11) {
            e11.printStackTrace();
            this.mIsLibLoaded = false;
        }
    }

    public void cancelAllImageGenerations() {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            _cancelAllImageGenerations();
        }
    }

    public void generateImageAsyncAtTime(long j11, long j12, TPImageGeneratorParams tPImageGeneratorParams) {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            _generateImageAsyncAtTime(j11, j12, tPImageGeneratorParams);
        } else {
            throw new IllegalStateException("Failed to generate image at time " + j11 + " due to invalid state.");
        }
    }

    public void generateImagesAsyncForTimes(long[] jArr, long j11, TPImageGeneratorParams tPImageGeneratorParams) {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            _generateImagesAsyncForTimes(jArr, j11, tPImageGeneratorParams);
        } else {
            throw new IllegalStateException("Failed to generate images due to invalid state.");
        }
    }

    public void init() {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (!this.mInited) {
            this.mInited = true;
            String str = this.mUrl;
            if (str != null && this.mHttpHeader != null) {
                return;
            }
            if (str != null) {
                _createWithUrl(str, this.mCallback);
                return;
            }
            _createWithFd(this.mFd, this.mFdOffset, this.mFdLength, this.mCallback);
        } else {
            throw new IllegalStateException("Failed to init due to invalid state.");
        }
    }

    public void unInit() {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            this.mInited = false;
            _release();
        }
    }
}
