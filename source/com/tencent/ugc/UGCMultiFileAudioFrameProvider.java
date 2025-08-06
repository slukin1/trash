package com.tencent.ugc;

import android.os.Looper;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.TXVideoJoiner;
import com.tencent.ugc.UGCFrameQueue;
import java.util.LinkedList;
import java.util.List;

public class UGCMultiFileAudioFrameProvider implements UGCAudioFrameProvider, UGCFrameQueue.UGCFrameQueueListener {
    private static final String TAG = "UGCMultiFileAudioFrameProvider";
    private final UGCFrameQueue<List<AudioFrame>> mAudioFrameListQueue;
    private final List<Clip> mClipList;
    private final TXVideoJoiner.DurationControlMode mDurationControlMode;
    private final UGCAudioFrameProvider[] mProviderList;
    private final CustomHandler mSingleFileProviderHandler;
    private final CustomHandler mWorkHandler = new CustomHandler(Looper.myLooper());

    public UGCMultiFileAudioFrameProvider(List<Clip> list, TXVideoJoiner.DurationControlMode durationControlMode, CustomHandler customHandler) {
        UGCFrameQueue<List<AudioFrame>> uGCFrameQueue = new UGCFrameQueue<>();
        this.mAudioFrameListQueue = uGCFrameQueue;
        this.mProviderList = new UGCAudioFrameProvider[list.size()];
        this.mClipList = list;
        this.mDurationControlMode = durationControlMode;
        this.mSingleFileProviderHandler = customHandler;
        uGCFrameQueue.setUGCFrameQueueListener(this);
    }

    private boolean hasOneProviderMeetsEndOfStream() {
        for (UGCAudioFrameProvider uGCAudioFrameProvider : this.mProviderList) {
            if (uGCAudioFrameProvider == null) {
                return true;
            }
        }
        return false;
    }

    private boolean isAllProviderEndOfStream() {
        for (UGCAudioFrameProvider uGCAudioFrameProvider : this.mProviderList) {
            if (uGCAudioFrameProvider != null) {
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

    public static /* synthetic */ void lambda$seekTo$2(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider, long j11) {
        for (UGCAudioFrameProvider uGCAudioFrameProvider : uGCMultiFileAudioFrameProvider.mProviderList) {
            if (uGCAudioFrameProvider != null) {
                uGCAudioFrameProvider.seekTo(j11);
            }
        }
        uGCMultiFileAudioFrameProvider.mAudioFrameListQueue.clear();
    }

    public static /* synthetic */ void lambda$start$0(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        for (int i11 = 0; i11 < uGCMultiFileAudioFrameProvider.mClipList.size(); i11++) {
            UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider = new UGCSingleFileAudioFrameProvider(uGCMultiFileAudioFrameProvider.mClipList.get(i11), uGCMultiFileAudioFrameProvider.mSingleFileProviderHandler);
            uGCSingleFileAudioFrameProvider.initialize();
            uGCSingleFileAudioFrameProvider.start();
            uGCMultiFileAudioFrameProvider.mProviderList[i11] = uGCSingleFileAudioFrameProvider;
        }
        uGCMultiFileAudioFrameProvider.readFrameToQueue();
    }

    public static /* synthetic */ void lambda$stop$1(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        int i11 = 0;
        while (true) {
            UGCAudioFrameProvider[] uGCAudioFrameProviderArr = uGCMultiFileAudioFrameProvider.mProviderList;
            if (i11 < uGCAudioFrameProviderArr.length) {
                if (uGCAudioFrameProviderArr[i11] != null) {
                    uGCAudioFrameProviderArr[i11].stop();
                    uGCMultiFileAudioFrameProvider.mProviderList[i11].uninitialize();
                }
                uGCMultiFileAudioFrameProvider.mProviderList[i11] = null;
                i11++;
            } else {
                uGCMultiFileAudioFrameProvider.mAudioFrameListQueue.clear();
                return;
            }
        }
    }

    public UGCFrameQueue<List<AudioFrame>> getFrameQueue() {
        return this.mAudioFrameListQueue;
    }

    public void initialize() {
        LiteavLog.i(TAG, "initialize");
    }

    public void onFrameDequeued() {
        this.mWorkHandler.runOrPost(eu.a(this));
    }

    public void readFrameToQueue() {
        LinkedList linkedList = new LinkedList();
        int i11 = 0;
        while (true) {
            UGCAudioFrameProvider[] uGCAudioFrameProviderArr = this.mProviderList;
            if (i11 >= uGCAudioFrameProviderArr.length) {
                break;
            }
            UGCAudioFrameProvider uGCAudioFrameProvider = uGCAudioFrameProviderArr[i11];
            if (uGCAudioFrameProvider == null) {
                linkedList.add(new AudioFrame());
            } else {
                List<AudioFrame> dequeue = uGCAudioFrameProvider.getFrameQueue().dequeue();
                if (dequeue == UGCAudioFrameProvider.END_OF_STREAM) {
                    uGCAudioFrameProvider.stop();
                    uGCAudioFrameProvider.uninitialize();
                    this.mProviderList[i11] = null;
                    linkedList.add(new AudioFrame());
                } else {
                    linkedList.add(dequeue.get(0));
                }
            }
            i11++;
        }
        if (isEndStream()) {
            this.mAudioFrameListQueue.queue(UGCAudioFrameProvider.END_OF_STREAM);
        } else {
            this.mAudioFrameListQueue.queue(linkedList);
        }
    }

    public void seekTo(long j11) {
        this.mWorkHandler.runOrPost(et.a(this, j11));
    }

    public void setPlayEndPts(long j11) {
    }

    public void start() {
        this.mWorkHandler.runOrPost(er.a(this));
    }

    public void stop() {
        this.mWorkHandler.runOrPost(es.a(this));
    }

    public void uninitialize() {
        stop();
    }
}
