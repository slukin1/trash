package com.tencent.ugc;

import android.os.Looper;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.TXVideoJoiner;
import com.tencent.ugc.UGCFrameQueue;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import java.util.LinkedList;
import java.util.List;

public class UGCMultiFilePixelFrameProvider implements UGCFrameQueue.UGCFrameQueueListener, UGCPixelFrameProvider {
    private static final String TAG = "UGCMultiFileVideoFrameProvider";
    private final List<Clip> mClipList;
    private long mCurrentTimestamp = 0;
    private final TXVideoJoiner.DurationControlMode mDurationControlMode;
    private long mFrameDuration = 0;
    private final UGCFrameQueue<List<PixelFrame>> mPixelFrameListQueue;
    private final PixelFrame[] mPixelFrameStash;
    private final UGCPixelFrameProvider[] mProviderList;
    private final CustomHandler mSingleFileProviderHandler;
    private final CustomHandler mWorkHandler;

    public UGCMultiFilePixelFrameProvider(List<Clip> list, TXVideoJoiner.DurationControlMode durationControlMode, CustomHandler customHandler) {
        UGCFrameQueue<List<PixelFrame>> uGCFrameQueue = new UGCFrameQueue<>();
        this.mPixelFrameListQueue = uGCFrameQueue;
        this.mProviderList = new UGCPixelFrameProvider[list.size()];
        this.mPixelFrameStash = new PixelFrame[list.size()];
        this.mClipList = list;
        this.mDurationControlMode = durationControlMode;
        this.mSingleFileProviderHandler = customHandler;
        this.mWorkHandler = new CustomHandler(Looper.myLooper());
        uGCFrameQueue.setUGCFrameQueueListener(this);
    }

    private void clearFrameCache() {
        int i11 = 0;
        while (true) {
            PixelFrame[] pixelFrameArr = this.mPixelFrameStash;
            if (i11 < pixelFrameArr.length) {
                if (pixelFrameArr[i11] != null) {
                    pixelFrameArr[i11].release();
                    this.mPixelFrameStash[i11] = null;
                }
                i11++;
            } else {
                return;
            }
        }
    }

    private void clearFrameQueue() {
        for (List<PixelFrame> releasePixelFrames : this.mPixelFrameListQueue.dequeueAll()) {
            PixelFrame.releasePixelFrames(releasePixelFrames);
        }
    }

    private PixelFrame copyPixelFrame(PixelFrame pixelFrame) {
        if (!(pixelFrame instanceof GLTexturePool.TextureFrame)) {
            return null;
        }
        GLTexturePool.TextureFrame textureFrame = (GLTexturePool.TextureFrame) pixelFrame;
        return textureFrame.getGLTexture().wrap(textureFrame.getGLContext());
    }

    private PixelFrame getFrameFromProvider(int i11) {
        UGCPixelFrameProvider uGCPixelFrameProvider = this.mProviderList[i11];
        if (uGCPixelFrameProvider == null) {
            return null;
        }
        List<PixelFrame> dequeue = uGCPixelFrameProvider.getFrameQueue().dequeue();
        if (dequeue != UGCPixelFrameProvider.END_OF_STREAM) {
            return dequeue.get(0);
        }
        uGCPixelFrameProvider.stop();
        uGCPixelFrameProvider.uninitialize();
        this.mProviderList[i11] = null;
        return null;
    }

    private boolean hasOneProviderMeetsEndOfStream() {
        for (UGCPixelFrameProvider uGCPixelFrameProvider : this.mProviderList) {
            if (uGCPixelFrameProvider == null) {
                return true;
            }
        }
        return false;
    }

    private boolean isAllProviderEndOfStream() {
        for (UGCPixelFrameProvider uGCPixelFrameProvider : this.mProviderList) {
            if (uGCPixelFrameProvider != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isEndStream() {
        if (this.mDurationControlMode == TXVideoJoiner.DurationControlMode.ALIGNS_TO_LONGEST) {
            return isAllProviderEndOfStream();
        }
        return hasOneProviderMeetsEndOfStream();
    }

    public static /* synthetic */ void lambda$seekTo$2(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider, long j11, boolean z11) {
        for (UGCPixelFrameProvider uGCPixelFrameProvider : uGCMultiFilePixelFrameProvider.mProviderList) {
            if (uGCPixelFrameProvider != null) {
                uGCPixelFrameProvider.seekTo(j11, z11);
            }
        }
        uGCMultiFilePixelFrameProvider.mCurrentTimestamp = j11;
        uGCMultiFilePixelFrameProvider.clearFrameCache();
        uGCMultiFilePixelFrameProvider.clearFrameQueue();
        uGCMultiFilePixelFrameProvider.readFrameToQueue();
    }

    public static /* synthetic */ void lambda$start$0(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        float f11 = -1.0f;
        for (int i11 = 0; i11 < uGCMultiFilePixelFrameProvider.mClipList.size(); i11++) {
            UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider = new UGCSingleFilePixelFrameProvider(uGCMultiFilePixelFrameProvider.mClipList.get(i11), uGCMultiFilePixelFrameProvider.mSingleFileProviderHandler);
            uGCSingleFilePixelFrameProvider.initialize();
            uGCSingleFilePixelFrameProvider.start();
            uGCMultiFilePixelFrameProvider.mProviderList[i11] = uGCSingleFilePixelFrameProvider;
            if (f11 < uGCMultiFilePixelFrameProvider.mClipList.get(i11).fps) {
                f11 = uGCMultiFilePixelFrameProvider.mClipList.get(i11).fps;
            }
        }
        uGCMultiFilePixelFrameProvider.mFrameDuration = (long) (f11 > 0.0f ? 1000.0f / f11 : 40.0f);
        uGCMultiFilePixelFrameProvider.readFrameToQueue();
    }

    public static /* synthetic */ void lambda$stop$1(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        int i11 = 0;
        while (true) {
            UGCPixelFrameProvider[] uGCPixelFrameProviderArr = uGCMultiFilePixelFrameProvider.mProviderList;
            if (i11 < uGCPixelFrameProviderArr.length) {
                if (uGCPixelFrameProviderArr[i11] != null) {
                    uGCPixelFrameProviderArr[i11].stop();
                    uGCMultiFilePixelFrameProvider.mProviderList[i11].uninitialize();
                }
                uGCMultiFilePixelFrameProvider.mProviderList[i11] = null;
                i11++;
            } else {
                uGCMultiFilePixelFrameProvider.clearFrameCache();
                uGCMultiFilePixelFrameProvider.clearFrameQueue();
                return;
            }
        }
    }

    private void putOneFrameToList(PixelFrame pixelFrame, List<PixelFrame> list) {
        if (pixelFrame != null) {
            if (pixelFrame.getTimestamp() == this.mCurrentTimestamp) {
                list.add(pixelFrame);
                pixelFrame.retain();
                return;
            }
            PixelFrame copyPixelFrame = copyPixelFrame(pixelFrame);
            if (copyPixelFrame != null) {
                copyPixelFrame.setTimestamp(this.mCurrentTimestamp);
                pixelFrame = copyPixelFrame;
            } else {
                pixelFrame.retain();
            }
            list.add(pixelFrame);
        }
    }

    private void readFrameToCache() {
        PixelFrame frameFromProvider;
        for (int i11 = 0; i11 < this.mProviderList.length; i11++) {
            PixelFrame pixelFrame = this.mPixelFrameStash[i11];
            if ((pixelFrame == null || this.mCurrentTimestamp - pixelFrame.getTimestamp() > this.mFrameDuration / 2) && (frameFromProvider = getFrameFromProvider(i11)) != null) {
                this.mPixelFrameStash[i11] = frameFromProvider;
                if (pixelFrame != null) {
                    pixelFrame.release();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void readFrameToQueue() {
        if (this.mPixelFrameListQueue.size() <= 1) {
            this.mCurrentTimestamp += this.mFrameDuration;
            readFrameToCache();
            if (isEndStream()) {
                this.mPixelFrameListQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
                return;
            }
            LinkedList linkedList = new LinkedList();
            for (PixelFrame putOneFrameToList : this.mPixelFrameStash) {
                putOneFrameToList(putOneFrameToList, linkedList);
            }
            if (linkedList.isEmpty()) {
                this.mPixelFrameListQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
            } else {
                this.mPixelFrameListQueue.queue(linkedList);
            }
        }
    }

    public UGCFrameQueue<List<PixelFrame>> getFrameQueue() {
        return this.mPixelFrameListQueue;
    }

    public void initialize() {
        LiteavLog.i(TAG, "initialize");
    }

    public void onFrameDequeued() {
        this.mWorkHandler.runOrPost(ey.a(this));
    }

    public void seekTo(long j11, boolean z11) {
        this.mWorkHandler.runOrPost(ex.a(this, j11, z11));
    }

    public void setMaxBufferFrameCount(int i11) {
    }

    public void setPlayEndPts(long j11) {
    }

    public void setReverse(boolean z11) {
    }

    public void start() {
        this.mWorkHandler.runOrPost(ev.a(this));
    }

    public void stop() {
        this.mWorkHandler.runOrPost(ew.a(this));
    }

    public void uninitialize() {
        stop();
    }
}
