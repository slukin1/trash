package com.tencent.ugc;

import android.os.HandlerThread;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.UGCFrameQueue;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import java.nio.ByteBuffer;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@JNINamespace("liteav::ugc")
public class VideoDemuxerFFmpeg implements UGCFrameQueue.UGCFrameQueueListener, VideoDemuxer {
    private static final int MAX_FRAME_SIZE = 20;
    private static final int OPEN_MEDIA_OUT_TIME = 3000;
    private static final String TAG = "VideoDemuxerFFmpeg";
    private final UGCFrameQueue<EncodedVideoFrame> mFrameQueue = new UGCFrameQueue<>();
    private long mNativeHandler;
    private AtomicBoolean mOpenSuccess = new AtomicBoolean(false);
    private CustomHandler mWorkHandler;

    private void clearFrameQueue() {
        for (EncodedVideoFrame next : this.mFrameQueue.dequeueAll()) {
            if (next != null) {
                next.release();
            }
        }
    }

    private void destroyNativeHandler() {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeClose(j11);
            nativeDestroy(this.mNativeHandler);
            this.mNativeHandler = 0;
        }
    }

    /* access modifiers changed from: private */
    public void getNextEncodeVideoFrameInternal() {
        ByteBuffer byteBuffer;
        if (this.mNativeHandler == 0) {
            this.mFrameQueue.queue(VideoDemuxer.END_OF_STREAM);
        } else if (this.mFrameQueue.size() <= 20) {
            EncodedVideoFrame nativeGetNextEncodeVideoFrame = nativeGetNextEncodeVideoFrame(this.mNativeHandler);
            if (nativeGetNextEncodeVideoFrame == null || (byteBuffer = nativeGetNextEncodeVideoFrame.data) == null || byteBuffer.remaining() == 0) {
                this.mFrameQueue.queue(VideoDemuxer.END_OF_STREAM);
            } else {
                this.mFrameQueue.queue(nativeGetNextEncodeVideoFrame);
            }
            CustomHandler customHandler = this.mWorkHandler;
            if (customHandler != null) {
                customHandler.removeCallbacks(hq.a(this));
                this.mWorkHandler.post(hr.a(this));
            }
        }
    }

    public static /* synthetic */ void lambda$close$1(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        videoDemuxerFFmpeg.clearFrameQueue();
        videoDemuxerFFmpeg.mFrameQueue.queue(VideoDemuxer.END_OF_STREAM);
        videoDemuxerFFmpeg.mFrameQueue.setUGCFrameQueueListener((UGCFrameQueue.UGCFrameQueueListener) null);
        videoDemuxerFFmpeg.destroyNativeHandler();
        videoDemuxerFFmpeg.mOpenSuccess.set(false);
        CustomHandler customHandler = videoDemuxerFFmpeg.mWorkHandler;
        if (customHandler != null) {
            customHandler.quitLooper();
            videoDemuxerFFmpeg.mWorkHandler = null;
        }
    }

    public static /* synthetic */ void lambda$open$0(VideoDemuxerFFmpeg videoDemuxerFFmpeg, String str) {
        long nativeCreate = nativeCreate(videoDemuxerFFmpeg);
        videoDemuxerFFmpeg.mNativeHandler = nativeCreate;
        if (nativeCreate == 0) {
            LiteavLog.e(TAG, "create native instance failed.");
            videoDemuxerFFmpeg.mFrameQueue.queue(VideoDemuxer.END_OF_STREAM);
        } else if (nativeOpen(nativeCreate, str) != 0) {
            LiteavLog.e(TAG, "native FFmpegDemuxerWrapper open failed.");
            videoDemuxerFFmpeg.destroyNativeHandler();
            videoDemuxerFFmpeg.mFrameQueue.queue(VideoDemuxer.END_OF_STREAM);
        } else {
            videoDemuxerFFmpeg.mOpenSuccess.set(true);
            videoDemuxerFFmpeg.mFrameQueue.setUGCFrameQueueListener(videoDemuxerFFmpeg);
            videoDemuxerFFmpeg.mFrameQueue.clear();
            videoDemuxerFFmpeg.runOnWorkThread(ht.a(videoDemuxerFFmpeg));
            LiteavLog.i(TAG, "demuxer open success.");
        }
    }

    public static /* synthetic */ Boolean lambda$seek$2(VideoDemuxerFFmpeg videoDemuxerFFmpeg, long j11) throws Exception {
        if (videoDemuxerFFmpeg.mNativeHandler == 0) {
            return Boolean.FALSE;
        }
        videoDemuxerFFmpeg.clearFrameQueue();
        boolean nativeSeek = nativeSeek(videoDemuxerFFmpeg.mNativeHandler, j11);
        videoDemuxerFFmpeg.getNextEncodeVideoFrameInternal();
        return Boolean.valueOf(nativeSeek);
    }

    private static native void nativeClose(long j11);

    private static native long nativeCreate(VideoDemuxerFFmpeg videoDemuxerFFmpeg);

    private static native void nativeDestroy(long j11);

    private static native long nativeGetFirstFramePtsOfAllStream(long j11);

    private static native EncodedVideoFrame nativeGetNextEncodeVideoFrame(long j11);

    private static native int nativeOpen(long j11, String str);

    private static native boolean nativeSeek(long j11, long j12);

    private void runOnWorkThread(Runnable runnable) {
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler != null) {
            customHandler.runOrPost(runnable);
        }
    }

    public void close() {
        runOnWorkThread(ho.a(this));
    }

    public long getFirstFramePtsOfAllStream() {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            return nativeGetFirstFramePtsOfAllStream(j11);
        }
        return 0;
    }

    public EncodedVideoFrame getNextEncodeVideoFrame() {
        return this.mFrameQueue.dequeue();
    }

    public void onFrameDequeued() {
        runOnWorkThread(hs.a(this));
    }

    public boolean open(String str) {
        synchronized (this) {
            if (this.mWorkHandler != null) {
                LiteavLog.w(TAG, "demuxer is already open!");
                return false;
            }
            HandlerThread handlerThread = new HandlerThread("ugc-media-list-source");
            handlerThread.start();
            CustomHandler customHandler = new CustomHandler(handlerThread.getLooper());
            this.mWorkHandler = customHandler;
            customHandler.runAndWaitDone(hn.a(this, str), 3000);
            return this.mOpenSuccess.get();
        }
    }

    public boolean seek(long j11) {
        FutureTask futureTask = new FutureTask(hp.a(this, j11));
        runOnWorkThread(futureTask);
        try {
            return ((Boolean) futureTask.get(500, TimeUnit.MILLISECONDS)).booleanValue();
        } catch (Exception e11) {
            LiteavLog.w(TAG, "seek future task exception: ".concat(String.valueOf(e11)));
            return false;
        }
    }
}
