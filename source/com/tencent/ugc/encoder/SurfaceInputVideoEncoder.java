package com.tencent.ugc.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.w;
import com.tencent.ugc.decoder.SpsInfo;
import com.tencent.ugc.encoder.VideoEncoderDef;
import com.tencent.ugc.encoder.VideoEncoderInterface;
import com.tencent.ugc.videobase.base.VideoPersistStorageKey;
import com.tencent.ugc.videobase.common.CodecType;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.common.VideoFrameType;
import com.tencent.ugc.videobase.common.VideoProfileType;
import com.tencent.ugc.videobase.utils.MemoryAllocator;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class SurfaceInputVideoEncoder {
    private static final int INTERVAL_DRAIN_OUTPUT = 3;
    private static final String KEY_NEED_RESTART_WHEN_DOWN_BITRATE = "need_restart_when_down_bitrate";
    private static final String MIME_TYPE_H264 = "video/avc";
    private static final String MIME_TYPE_H265 = "video/hevc";
    private static final int MSG_DEQUEUE_OUTPUT_BUFFER = 10;
    private boolean mAddSpsPpsForEachIFrame = true;
    private final Deque<Long> mCheckTimestamps = new LinkedList();
    private int mCompareBitrateKbps = 0;
    private final ConcurrentLinkedQueue<Long> mDTSQueue = new ConcurrentLinkedQueue<>();
    private w mDequeueEosFrameTimer = null;
    private long mEncodeBytesForThisGOP = 0;
    private long mFirstEncodeTimestamp = 0;
    private long mFirstPresentationTimestamp = 0;
    private long mFrameCountForCalcFPS = 0;
    private long mFrameIndexInThisGOP = 0;
    private long mGopIndex = 0;
    private boolean mHasFindBFrame = false;
    private long mLastEncodeTimestamp = 0;
    private long mLastIFrameTickMS = 0;
    private long mLastPresentationTimestamp = Long.MIN_VALUE;
    private long mLastUpdateFPSTick = 0;
    private VideoEncoderInterface.VideoEncoderListener mListener;
    private MediaCodec mMediaCodec;
    private CustomHandler mMediaCodecHandler;
    private int mPFrameCount = -1;
    private long mRealBitrate = 0;
    private double mRealFPS = 0.0d;
    private final Runnable mRequestRestartRunnable = s.a(this);
    private final Bundle mSessionStates;
    private byte[] mSpsPps = null;
    private String mTAG;
    private VideoEncodeParams mVideoEncodeParams;

    public SurfaceInputVideoEncoder(Bundle bundle) {
        this.mSessionStates = bundle;
        this.mTAG = "SurfaceInputVideoEncoder_" + hashCode();
    }

    private byte[] addSpsPpsForIFrame(byte[] bArr) {
        byte[] allocateByteArray = MemoryAllocator.allocateByteArray(this.mSpsPps.length + bArr.length);
        if (allocateByteArray != null) {
            byte[] bArr2 = this.mSpsPps;
            System.arraycopy(bArr2, 0, allocateByteArray, 0, bArr2.length);
            System.arraycopy(bArr, 0, allocateByteArray, this.mSpsPps.length, bArr.length);
            return allocateByteArray;
        }
        notifyEncodeError("add spspps for I frame, allocate buffer failed.");
        return bArr;
    }

    private void checkBitrateIfRestartEncoder() {
        Long peekFirst;
        if (!this.mCheckTimestamps.isEmpty()) {
            int i11 = this.mVideoEncodeParams.fps;
            if (((float) (((double) i11) - this.mRealFPS)) <= Math.max(((float) i11) / 2.0f, 5.0f) && (peekFirst = this.mCheckTimestamps.peekFirst()) != null && SystemClock.elapsedRealtime() > peekFirst.longValue()) {
                this.mCheckTimestamps.removeFirst();
                if (((long) this.mCompareBitrateKbps) - this.mRealBitrate > ((long) Math.max(this.mVideoEncodeParams.bitrate / 2, 100))) {
                    String str = this.mTAG;
                    LiteavLog.w(str, "restart hardware encoder because real bitrate is too low.expectBitrate: " + this.mCompareBitrateKbps + ", realBitrate=" + this.mRealBitrate);
                    this.mSessionStates.putBoolean(KEY_NEED_RESTART_WHEN_DOWN_BITRATE, true);
                    this.mRequestRestartRunnable.run();
                    this.mCheckTimestamps.clear();
                }
            }
        }
    }

    private void checkPTSFallBack(EncodedVideoFrame encodedVideoFrame) {
        boolean z11 = this.mVideoEncodeParams.enableBFrame;
        if (!z11 && !this.mHasFindBFrame && encodedVideoFrame.pts < this.mLastPresentationTimestamp) {
            LiteavLog.i(this.mTAG, "has B frame,isEnablesBframe=%b,mLastPresentationTimestamp=%d,packet.pts=%d", Boolean.valueOf(z11), Long.valueOf(this.mLastPresentationTimestamp), Long.valueOf(encodedVideoFrame.pts));
            this.mHasFindBFrame = true;
            PersistStorage persistStorage = new PersistStorage(PersistStorage.GLOBAL_DOMAIN);
            persistStorage.put(VideoPersistStorageKey.CONFIG_KEY_LOCAL_RTC_ENCODE_HIGH_PROFILE, 0);
            persistStorage.commit();
            VideoEncoderInterface.VideoEncoderListener videoEncoderListener = this.mListener;
            if (videoEncoderListener != null) {
                videoEncoderListener.onRequestRestart();
            }
        }
        this.mLastPresentationTimestamp = encodedVideoFrame.pts;
    }

    private boolean configureEncoder(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return false;
        }
        try {
            LiteavLog.i(this.mTAG, "configure format: %s", mediaFormat);
            mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return true;
        } catch (Throwable th2) {
            LiteavLog.e(this.mTAG, "configure failed.", th2);
            return false;
        }
    }

    private static byte[] convertAnnexBToAVCC(byte[] bArr) {
        int i11;
        int length = bArr.length;
        ArrayList<int[]> arrayList = new ArrayList<>(20);
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 <= length) {
            int i15 = i12 + 2;
            if (i15 < length && bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i15] == 1) {
                i11 = 3;
            } else {
                int i16 = i12 + 3;
                i11 = (i16 < length && bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i15] == 0 && bArr[i16] == 1) ? 4 : 1;
            }
            if (i11 == 3 || i11 == 4 || i12 == length) {
                if (i14 != i12) {
                    arrayList.add(new int[]{i14, i12});
                    i13 += i12 - i14;
                }
                i14 = i12 + i11;
            }
            i12 += i11;
        }
        byte[] allocateByteArray = MemoryAllocator.allocateByteArray(i13 + (arrayList.size() * 4));
        if (allocateByteArray == null) {
            return bArr;
        }
        int i17 = 0;
        for (int[] iArr : arrayList) {
            int i18 = iArr[1] - iArr[0];
            ByteBuffer order = ByteBuffer.wrap(new byte[4]).order(ByteOrder.BIG_ENDIAN);
            order.putInt(i18);
            System.arraycopy(order.array(), 0, allocateByteArray, i17, 4);
            int i19 = i17 + 4;
            System.arraycopy(bArr, iArr[0], allocateByteArray, i19, i18);
            i17 = i19 + i18;
        }
        return allocateByteArray;
    }

    private MediaCodec createHWMediaCodec(String str) throws Throwable {
        String str2;
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        try {
            str2 = createEncoderByType.getName();
        } catch (Throwable th2) {
            LiteavLog.e(this.mTAG, "mediaCodec getName failed.", th2);
            str2 = null;
        }
        LiteavLog.i(this.mTAG, "codecName=".concat(String.valueOf(str2)));
        if (str2 == null || !str2.equals("OMX.google.h264.encoder")) {
            return createEncoderByType;
        }
        LiteavLog.w(this.mTAG, "will be destroyed codecName=".concat(str2));
        destroyMediaCodec(createEncoderByType);
        throw new IOException("this is a Google H264 soft encoder. cancel use MediaCodec.");
    }

    private long dequeueEncodeTimestamp() {
        Long poll = this.mDTSQueue.poll();
        if (poll == null) {
            return 0;
        }
        return poll.longValue();
    }

    /* access modifiers changed from: private */
    public void dequeueOutputBufferInternal() {
        ByteBuffer byteBuffer;
        if (this.mMediaCodec != null) {
            while (true) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                try {
                    int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(3));
                    if (dequeueOutputBuffer == -1) {
                        break;
                    } else if (dequeueOutputBuffer == -3) {
                        LiteavLog.i(this.mTAG, "encoder output buffers changed");
                    } else if (dequeueOutputBuffer == -2) {
                        try {
                            MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
                            VideoEncoderInterface.VideoEncoderListener videoEncoderListener = this.mListener;
                            if (videoEncoderListener != null) {
                                videoEncoderListener.onOutputFormatChanged(outputFormat);
                            }
                            LiteavLog.i(this.mTAG, "encoder output format changed: %s", outputFormat);
                        } catch (Throwable th2) {
                            notifyEncodeError("getOutputFormat failed." + th2.getMessage());
                        }
                    } else if (dequeueOutputBuffer < 0) {
                        notifyEncodeError("dequeueOutputBuffer return ".concat(String.valueOf(dequeueOutputBuffer)));
                        break;
                    } else {
                        try {
                            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                                byteBuffer = this.mMediaCodec.getOutputBuffer(dequeueOutputBuffer);
                            } else {
                                byteBuffer = this.mMediaCodec.getOutputBuffers()[dequeueOutputBuffer];
                            }
                            if (byteBuffer == null || (bufferInfo.size == 0 && (bufferInfo.flags & 4) == 0)) {
                                notifyEncodeError("size is zero, but it isn't end of stream");
                            } else {
                                processEncodedData(byteBuffer, bufferInfo);
                            }
                            MediaCodec mediaCodec = this.mMediaCodec;
                            if (mediaCodec != null) {
                                try {
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                } catch (Throwable th3) {
                                    notifyEncodeError("releaseOutputBuffer failed." + th3.getMessage());
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th4) {
                            notifyEncodeError("getOutputBuffer failed." + th4.getMessage());
                        }
                    }
                } catch (Throwable th5) {
                    notifyEncodeError("dequeueOutputBuffer failed." + th5.getMessage());
                }
            }
            scheduleDequeueNextOutputBuffer();
        }
    }

    private void destroyMediaCodec(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Throwable th2) {
                LiteavLog.e(this.mTAG, "destroy mediaCodec stop failed.", th2);
            }
            try {
                mediaCodec.release();
            } catch (Throwable th3) {
                LiteavLog.e(this.mTAG, "destroy mediaCodec release failed.", th3);
            }
            LiteavLog.i(this.mTAG, "destroy mediaCodec");
        }
    }

    private static String getDeviceInfo() {
        return String.format(Locale.ENGLISH, "[module:%s] [Hardware:%s] [osVersion:%s]", new Object[]{LiteavSystemInfo.getModel(), LiteavSystemInfo.getHardware(), LiteavSystemInfo.getSystemOSVersion()});
    }

    public static /* synthetic */ void lambda$new$0(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        if (surfaceInputVideoEncoder.mListener != null) {
            LiteavLog.w(surfaceInputVideoEncoder.mTAG, "onRequestRestart");
            surfaceInputVideoEncoder.mListener.onRequestRestart();
        }
    }

    public static /* synthetic */ void lambda$signalBeforeSwapBuffers$2(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        CustomHandler customHandler = surfaceInputVideoEncoder.mMediaCodecHandler;
        if (customHandler != null) {
            customHandler.sendEmptyMessageDelayed(10, 3);
        }
    }

    public static /* synthetic */ void lambda$signalEndOfStream$3(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        MediaCodec mediaCodec = surfaceInputVideoEncoder.mMediaCodec;
        if (mediaCodec != null) {
            try {
                mediaCodec.signalEndOfInputStream();
            } catch (Throwable th2) {
                LiteavLog.e(surfaceInputVideoEncoder.mTAG, "signalEndOfStream failed.", th2);
            }
        }
        if (surfaceInputVideoEncoder.mDequeueEosFrameTimer == null) {
            w wVar = new w(Looper.myLooper(), new y(surfaceInputVideoEncoder));
            surfaceInputVideoEncoder.mDequeueEosFrameTimer = wVar;
            wVar.a(3);
        }
    }

    public static /* synthetic */ void lambda$start$1(SurfaceInputVideoEncoder surfaceInputVideoEncoder, VideoEncoderInterface.VideoEncoderListener videoEncoderListener, Surface[] surfaceArr, VideoEncodeParams videoEncodeParams, Size[] sizeArr) {
        surfaceInputVideoEncoder.mListener = videoEncoderListener;
        surfaceArr[0] = surfaceInputVideoEncoder.startCodecInternal(videoEncodeParams);
        sizeArr[0] = new Size(720, 1280);
        VideoEncodeParams videoEncodeParams2 = surfaceInputVideoEncoder.mVideoEncodeParams;
        if (videoEncodeParams2 != null) {
            sizeArr[0].set(videoEncodeParams2.width, videoEncodeParams2.height);
        }
    }

    public static /* synthetic */ void lambda$stopSync$4(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        surfaceInputVideoEncoder.stopEosTimer();
        surfaceInputVideoEncoder.stopCodecInternal();
    }

    public static /* synthetic */ void lambda$uninitialize$5(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        surfaceInputVideoEncoder.stopCodecInternal();
        CustomHandler customHandler = surfaceInputVideoEncoder.mMediaCodecHandler;
        if (customHandler != null) {
            customHandler.quitLooper();
            surfaceInputVideoEncoder.mMediaCodecHandler = null;
        }
    }

    private byte[] modifyEncodedData(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        byte[] allocateByteArray = MemoryAllocator.allocateByteArray(bufferInfo.size);
        if (allocateByteArray == null) {
            return null;
        }
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        byteBuffer.get(allocateByteArray);
        byte[] removeExtraLeadingZero = removeExtraLeadingZero(allocateByteArray);
        VideoEncodeParams videoEncodeParams = this.mVideoEncodeParams;
        return (videoEncodeParams == null || videoEncodeParams.annexb) ? removeExtraLeadingZero : convertAnnexBToAVCC(removeExtraLeadingZero);
    }

    private void notifyEncodeError(String str) {
        LiteavLog.e(this.mTAG, "notifyEncodeError message = ".concat(String.valueOf(str)));
        VideoEncoderInterface.VideoEncoderListener videoEncoderListener = this.mListener;
        if (videoEncoderListener != null) {
            videoEncoderListener.onEncodedFail();
        }
    }

    private void notifyEncodedData(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
        boolean z11 = true;
        boolean z12 = (bufferInfo.flags & 1) > 0;
        requestSyncFrameIfNeed(z12);
        updateRealBitrate(z12, (long) bArr.length);
        updateRealFPS();
        if (z12) {
            this.mGopIndex++;
            this.mFrameIndexInThisGOP = 0;
        } else {
            this.mFrameIndexInThisGOP++;
        }
        long dequeueEncodeTimestamp = dequeueEncodeTimestamp();
        long millis = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
        if (this.mFirstEncodeTimestamp == 0) {
            this.mFirstEncodeTimestamp = dequeueEncodeTimestamp;
        }
        if (this.mFirstPresentationTimestamp == 0) {
            this.mFirstPresentationTimestamp = millis;
        }
        long j11 = millis + (this.mFirstEncodeTimestamp - this.mFirstPresentationTimestamp);
        long j12 = this.mLastEncodeTimestamp;
        if (dequeueEncodeTimestamp <= j12) {
            dequeueEncodeTimestamp = j12 + 1;
        }
        if (dequeueEncodeTimestamp > j11) {
            dequeueEncodeTimestamp = j11;
        }
        this.mLastEncodeTimestamp = dequeueEncodeTimestamp;
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        VideoEncodeParams videoEncodeParams = this.mVideoEncodeParams;
        if (videoEncodeParams == null || !videoEncodeParams.isEnablesUnlimitedGop()) {
            encodedVideoFrame.nalType = z12 ? VideoFrameType.IDR : VideoFrameType.P;
        } else {
            encodedVideoFrame.nalType = z12 ? VideoFrameType.IDR : VideoFrameType.P_MULTI_REF;
        }
        ByteBuffer allocateDirectBuffer = MemoryAllocator.allocateDirectBuffer(bArr.length);
        encodedVideoFrame.data = allocateDirectBuffer;
        if (allocateDirectBuffer == null) {
            notifyEncodeError("allocate direct buffer for nal failed");
            return;
        }
        allocateDirectBuffer.put(bArr);
        encodedVideoFrame.data.rewind();
        encodedVideoFrame.dts = dequeueEncodeTimestamp;
        encodedVideoFrame.pts = j11;
        encodedVideoFrame.info = bufferInfo;
        encodedVideoFrame.gopIndex = this.mGopIndex;
        long j13 = this.mFrameIndexInThisGOP;
        encodedVideoFrame.frameIndex = j13;
        encodedVideoFrame.gopFrameIndex = j13;
        if (!z12) {
            j13--;
        }
        encodedVideoFrame.refFrameIndex = j13;
        encodedVideoFrame.profileType = VideoProfileType.BASELINE;
        VideoEncodeParams videoEncodeParams2 = this.mVideoEncodeParams;
        encodedVideoFrame.codecType = videoEncodeParams2.codecType;
        encodedVideoFrame.width = videoEncodeParams2.width;
        encodedVideoFrame.height = videoEncodeParams2.height;
        if ((bufferInfo.flags & 4) > 0) {
            stopEosTimer();
        } else {
            checkPTSFallBack(encodedVideoFrame);
            z11 = false;
        }
        VideoEncoderInterface.VideoEncoderListener videoEncoderListener = this.mListener;
        if (videoEncoderListener != null) {
            videoEncoderListener.onEncodedNAL(encodedVideoFrame, z11);
        }
    }

    private void processEncodedData(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        byte[] modifyEncodedData = modifyEncodedData(byteBuffer, bufferInfo);
        if (modifyEncodedData == null) {
            notifyEncodeError("modifyEncodedData return null byte array");
            return;
        }
        int i11 = bufferInfo.flags;
        boolean z11 = false;
        boolean z12 = (i11 & 2) > 0;
        boolean z13 = (i11 & 1) > 0;
        if (z12 && z13) {
            VideoEncodeParams videoEncodeParams = this.mVideoEncodeParams;
            boolean z14 = videoEncodeParams == null || videoEncodeParams.codecType == CodecType.H264;
            if (videoEncodeParams == null || videoEncodeParams.annexb) {
                z11 = true;
            }
            this.mSpsPps = SpsInfo.nativeGetSpsPps(modifyEncodedData, z14, z11);
        } else if (z12) {
            this.mSpsPps = (byte[]) modifyEncodedData.clone();
            return;
        } else if (this.mAddSpsPpsForEachIFrame && z13) {
            if (this.mSpsPps != null) {
                modifyEncodedData = addSpsPpsForIFrame(modifyEncodedData);
            } else {
                notifyEncodeError("mSpsPps is null.");
            }
        }
        notifyEncodedData(modifyEncodedData, bufferInfo);
    }

    private static byte[] removeExtraLeadingZero(byte[] bArr) {
        byte[] allocateByteArray;
        if (bArr.length > 5 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0 && bArr[5] == 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 3;
                if (i12 < bArr.length) {
                    if ((bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 0 && bArr[i12] == 1) || (bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 1)) {
                        break;
                    }
                    i11++;
                } else {
                    i11 = 0;
                    break;
                }
            }
            if (i11 == 0 || (allocateByteArray = MemoryAllocator.allocateByteArray(bArr.length - i11)) == null) {
                return bArr;
            }
            System.arraycopy(bArr, i11, allocateByteArray, 0, allocateByteArray.length);
            return allocateByteArray;
        }
        return bArr;
    }

    private void requestSyncFrameIfNeed(boolean z11) {
        if (z11) {
            this.mPFrameCount = -1;
        }
        VideoEncodeParams videoEncodeParams = this.mVideoEncodeParams;
        if (videoEncodeParams != null && !videoEncodeParams.fullIFrame) {
            int i11 = this.mPFrameCount + 1;
            this.mPFrameCount = i11;
            if (i11 == videoEncodeParams.fps * videoEncodeParams.gop) {
                restartIDRFrame();
            }
        }
    }

    private void resetBitrateAfterApiLevel30(MediaCodec mediaCodec, int i11) {
        if (mediaCodec != null && LiteavSystemInfo.getSystemOSVersionInt() > 30) {
            LiteavLog.i(this.mTAG, "resetBitrateAfterApiLevel30,bitrate=".concat(String.valueOf(i11)));
            updateBitrateToMediaCodec(mediaCodec, i11);
        }
    }

    private void restartIDRFrame() {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 19 && this.mMediaCodec != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("request-sync", 0);
                this.mMediaCodec.setParameters(bundle);
            } catch (Throwable th2) {
                LiteavLog.e(this.mTAG, "requestSyncFrame failed.", th2);
            }
        }
    }

    private boolean runAndWaitDone(Runnable runnable, long j11) {
        CustomHandler customHandler = this.mMediaCodecHandler;
        if (customHandler == null) {
            return false;
        }
        if (customHandler.getLooper() != Looper.myLooper()) {
            return customHandler.runAndWaitDone(runnable, j11);
        }
        runnable.run();
        return true;
    }

    private void runInMediaCodecThread(Runnable runnable) {
        CustomHandler customHandler = this.mMediaCodecHandler;
        if (customHandler != null) {
            if (customHandler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                customHandler.post(runnable);
            }
        }
    }

    private void scheduleDequeueNextOutputBuffer() {
        CustomHandler customHandler;
        if (!this.mDTSQueue.isEmpty() && (customHandler = this.mMediaCodecHandler) != null && !customHandler.hasMessages(10)) {
            customHandler.sendEmptyMessageDelayed(10, 3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.Surface startCodecInternal(com.tencent.ugc.encoder.VideoEncodeParams r8) {
        /*
            r7 = this;
            r0 = -9223372036854775808
            r7.mLastPresentationTimestamp = r0
            int r0 = r8.bitrate
            if (r0 != 0) goto L_0x001d
            int r0 = r8.width
            int r0 = r0 * r0
            int r1 = r8.height
            int r1 = r1 * r1
            int r0 = r0 + r1
            double r0 = (double) r0
            double r0 = java.lang.Math.sqrt(r0)
            r2 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            double r0 = r0 * r2
            int r0 = (int) r0
            r8.bitrate = r0
        L_0x001d:
            com.tencent.ugc.encoder.VideoEncodeParams r0 = new com.tencent.ugc.encoder.VideoEncodeParams
            r0.<init>(r8)
            r7.mVideoEncodeParams = r0
            long r1 = r0.baseGopIndex
            r7.mGopIndex = r1
            r1 = 0
            r7.mFrameIndexInThisGOP = r1
            com.tencent.ugc.videobase.common.CodecType r8 = r0.codecType
            com.tencent.ugc.videobase.common.CodecType r0 = com.tencent.ugc.videobase.common.CodecType.H265
            if (r8 != r0) goto L_0x0035
            java.lang.String r8 = "video/hevc"
            goto L_0x0037
        L_0x0035:
            java.lang.String r8 = "video/avc"
        L_0x0037:
            r7.updateMainProfileToHighProfile()
            r7.updateProfileAccordingLocalStorage()
            r0 = 0
            android.media.MediaCodec r1 = r7.createHWMediaCodec(r8)     // Catch:{ all -> 0x00c6 }
            com.tencent.ugc.encoder.MediaFormatBuilder r2 = new com.tencent.ugc.encoder.MediaFormatBuilder     // Catch:{ all -> 0x00c2 }
            com.tencent.ugc.encoder.VideoEncodeParams r3 = r7.mVideoEncodeParams     // Catch:{ all -> 0x00c2 }
            r2.<init>(r1, r8, r3)     // Catch:{ all -> 0x00c2 }
            r8 = 1
            com.tencent.ugc.encoder.MediaFormatBuilder r3 = r2.enableSetBitrateModeIfSupport(r8)     // Catch:{ all -> 0x00c2 }
            android.media.MediaFormat r3 = r3.build()     // Catch:{ all -> 0x00c2 }
            boolean r4 = r7.configureEncoder(r1, r3)     // Catch:{ all -> 0x00c2 }
            r5 = 0
            if (r4 != 0) goto L_0x0069
            com.tencent.ugc.encoder.MediaFormatBuilder r2 = r2.useProfileAndLevel(r5)     // Catch:{ all -> 0x00c2 }
            android.media.MediaFormat r3 = r2.build()     // Catch:{ all -> 0x00c2 }
            boolean r2 = r7.configureEncoder(r1, r3)     // Catch:{ all -> 0x00c2 }
            if (r2 == 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r8 = r5
        L_0x0069:
            if (r8 == 0) goto L_0x00ba
            android.view.Surface r8 = r1.createInputSurface()     // Catch:{ all -> 0x00c2 }
            r1.start()     // Catch:{ all -> 0x00b4 }
            com.tencent.ugc.encoder.VideoEncodeParams r2 = r7.mVideoEncodeParams     // Catch:{ all -> 0x009a }
            java.lang.String r4 = "width"
            int r4 = r3.getInteger(r4)     // Catch:{ all -> 0x009a }
            r2.width = r4     // Catch:{ all -> 0x009a }
            com.tencent.ugc.encoder.VideoEncodeParams r2 = r7.mVideoEncodeParams     // Catch:{ all -> 0x009a }
            java.lang.String r4 = "height"
            int r4 = r3.getInteger(r4)     // Catch:{ all -> 0x009a }
            r2.height = r4     // Catch:{ all -> 0x009a }
            com.tencent.ugc.encoder.VideoEncodeParams r2 = r7.mVideoEncodeParams     // Catch:{ all -> 0x009a }
            java.lang.String r4 = "bitrate"
            int r4 = r3.getInteger(r4)     // Catch:{ all -> 0x009a }
            int r4 = r4 / 1024
            r2.bitrate = r4     // Catch:{ all -> 0x009a }
            com.tencent.ugc.encoder.VideoEncodeParams r2 = r7.mVideoEncodeParams     // Catch:{ all -> 0x009a }
            int r2 = r2.bitrate     // Catch:{ all -> 0x009a }
            r7.resetBitrateAfterApiLevel30(r1, r2)     // Catch:{ all -> 0x009a }
            goto L_0x00a2
        L_0x009a:
            r2 = move-exception
            java.lang.String r4 = r7.mTAG     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = "MediaFormat get key fail"
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r4, (java.lang.String) r5, (java.lang.Throwable) r2)     // Catch:{ all -> 0x00b4 }
        L_0x00a2:
            java.lang.String r2 = r7.mTAG     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = "start MediaCodec with format: "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = r4.concat(r3)     // Catch:{ all -> 0x00b4 }
            com.tencent.liteav.base.util.LiteavLog.i(r2, r3)     // Catch:{ all -> 0x00b4 }
            r7.mMediaCodec = r1
            return r8
        L_0x00b4:
            r2 = move-exception
            r6 = r1
            r1 = r8
            r8 = r2
            r2 = r6
            goto L_0x00c9
        L_0x00ba:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00c2 }
            java.lang.String r2 = "configure encoder failed."
            r8.<init>(r2)     // Catch:{ all -> 0x00c2 }
            throw r8     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r8 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x00c9
        L_0x00c6:
            r8 = move-exception
            r1 = r0
            r2 = r1
        L_0x00c9:
            if (r1 == 0) goto L_0x00ce
            r1.release()
        L_0x00ce:
            r7.destroyMediaCodec(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Start encoder failed:"
            r1.<init>(r2)
            java.lang.String r2 = r8.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            int r2 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r3 = 23
            if (r2 < r3) goto L_0x010c
            boolean r2 = r8 instanceof android.media.MediaCodec.CodecException
            if (r2 == 0) goto L_0x010c
            r2 = r8
            android.media.MediaCodec$CodecException r2 = (android.media.MediaCodec.CodecException) r2
            int r2 = r2.getErrorCode()
            r3 = 1100(0x44c, float:1.541E-42)
            if (r2 != r3) goto L_0x010c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Insufficient resource, Start encoder failed:"
            r1.<init>(r2)
            java.lang.String r2 = r8.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x010c:
            java.lang.String r2 = r7.mTAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Start media codec failed,encode params:"
            r3.<init>(r4)
            com.tencent.ugc.encoder.VideoEncodeParams r4 = r7.mVideoEncodeParams
            r3.append(r4)
            java.lang.String r4 = " error message: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r2, (java.lang.String) r1, (java.lang.Throwable) r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.encoder.SurfaceInputVideoEncoder.startCodecInternal(com.tencent.ugc.encoder.VideoEncodeParams):android.view.Surface");
    }

    private void stopCodecInternal() {
        CustomHandler customHandler = this.mMediaCodecHandler;
        if (customHandler != null) {
            customHandler.removeMessages(10);
        }
        destroyMediaCodec(this.mMediaCodec);
        this.mMediaCodec = null;
    }

    private void stopEosTimer() {
        if (this.mDequeueEosFrameTimer != null) {
            LiteavLog.i(this.mTAG, "stopEosTimer");
            this.mDequeueEosFrameTimer.a();
            this.mDequeueEosFrameTimer = null;
        }
    }

    private void updateBitrateToMediaCodec(MediaCodec mediaCodec, int i11) {
        if (mediaCodec != null && LiteavSystemInfo.getSystemOSVersionInt() >= 19) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", i11 * 1024);
                mediaCodec.setParameters(bundle);
            } catch (Throwable th2) {
                LiteavLog.e(this.mTAG, "updateBitrateToMediaCodec failed.", th2);
            }
        }
    }

    private void updateMainProfileToHighProfile() {
        VideoEncodeParams videoEncodeParams = this.mVideoEncodeParams;
        if (videoEncodeParams.encoderProfile == VideoEncoderDef.EncoderProfile.PROFILE_MAIN) {
            videoEncodeParams.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
        }
    }

    private void updateProfileAccordingLocalStorage() {
        VideoEncodeParams videoEncodeParams = this.mVideoEncodeParams;
        VideoEncoderDef.EncoderProfile encoderProfile = videoEncodeParams.encoderProfile;
        if ((encoderProfile == VideoEncoderDef.EncoderProfile.PROFILE_HIGH || encoderProfile == VideoEncoderDef.EncoderProfile.PROFILE_MAIN) && !videoEncodeParams.enableBFrame) {
            Integer num = new PersistStorage(PersistStorage.GLOBAL_DOMAIN).getInt(VideoPersistStorageKey.CONFIG_KEY_LOCAL_RTC_ENCODE_HIGH_PROFILE);
            LiteavLog.i(this.mTAG, "enable high profile from persist storage:".concat(String.valueOf(num)));
            if (num != null && num.intValue() == 0) {
                this.mVideoEncodeParams.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
            }
        }
    }

    private void updateRealBitrate(boolean z11, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (z11) {
            long j12 = this.mLastIFrameTickMS;
            if (elapsedRealtime > 1000 + j12) {
                this.mRealBitrate = (long) (((((double) this.mEncodeBytesForThisGOP) * 8000.0d) / ((double) (elapsedRealtime - j12))) / 1024.0d);
                this.mEncodeBytesForThisGOP = 0;
                this.mLastIFrameTickMS = elapsedRealtime;
                checkBitrateIfRestartEncoder();
            }
        }
        this.mEncodeBytesForThisGOP += j11;
    }

    private void updateRealFPS() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime <= this.mLastUpdateFPSTick + TimeUnit.SECONDS.toMillis(2)) {
            this.mFrameCountForCalcFPS++;
            return;
        }
        this.mRealFPS = (((double) this.mFrameCountForCalcFPS) * 1000.0d) / ((double) (elapsedRealtime - this.mLastUpdateFPSTick));
        this.mFrameCountForCalcFPS = 1;
        this.mLastUpdateFPSTick = elapsedRealtime;
    }

    public void initialize() {
        HandlerThread handlerThread = new HandlerThread("hw-surface-input-encoder");
        handlerThread.start();
        this.mMediaCodecHandler = new CustomHandler(handlerThread.getLooper()) {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 10) {
                    SurfaceInputVideoEncoder.this.dequeueOutputBufferInternal();
                }
            }
        };
    }

    public void signalBeforeSwapBuffers(long j11) {
        this.mDTSQueue.add(Long.valueOf(j11));
        runInMediaCodecThread(u.a(this));
    }

    public void signalEndOfStream() {
        LiteavLog.i(this.mTAG, "signalEndOfStream");
        runInMediaCodecThread(v.a(this));
    }

    public Pair<Surface, Size> start(VideoEncodeParams videoEncodeParams, VideoEncoderInterface.VideoEncoderListener videoEncoderListener) {
        LiteavLog.d(this.mTAG, "start");
        Surface[] surfaceArr = new Surface[1];
        Size[] sizeArr = new Size[1];
        return runAndWaitDone(t.a(this, videoEncoderListener, surfaceArr, videoEncodeParams, sizeArr), 5000) ? new Pair<>(surfaceArr[0], sizeArr[0]) : new Pair<>((Object) null, new Size(720, 1280));
    }

    public void stopSync(long j11) {
        LiteavLog.i(this.mTAG, "stop sync. wait time is ".concat(String.valueOf(j11)));
        runAndWaitDone(w.a(this), j11);
    }

    public void uninitialize() {
        runInMediaCodecThread(x.a(this));
    }
}
