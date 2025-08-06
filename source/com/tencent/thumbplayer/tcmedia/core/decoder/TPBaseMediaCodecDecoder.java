package com.tencent.thumbplayer.tcmedia.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.g.a.a;
import com.tencent.thumbplayer.tcmedia.g.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class TPBaseMediaCodecDecoder implements ITPMediaCodecDecoder {
    private static final int DUMP_BYTE_BUFFER_BYTES = 100;
    private static final int DUMP_ONE_LINE_BYTES = 20;
    private static final int MEDIA_CODEC_ERROR_INDEX = -1000;
    private static long MEDIA_CODEC_INPUT_TIMEOUT_US = 2000;
    private static long MEDIA_CODEC_OUTPUT_TIMEOUT_US = 2000;
    private static final int MSG_FLUSH = 1002;
    private static final int MSG_RELEASE = 1003;
    private static final int MSG_RELEASE_OUTPUT_BUFFER = 1000;
    private static final int MSG_SET_OUTPUT_SURFACE = 1001;
    private static boolean sTMediaCodecInited = false;
    private b mCodec = null;
    public int mCodecId;
    private MediaCodec.CryptoInfo mCryptoInfo = null;
    private HandlerThread mDecodeThread = null;
    private AsyncDecodeHandler mDecoderHandler = null;
    public int mDrmType = -1;
    public boolean mEnableAsyncMode = false;
    private boolean mEnableAudioPassThrough = false;
    public boolean mEnableMediaCodecReuse = false;
    private boolean mEnableSetOutputSurfaceApi = false;
    private TPFrameInfo mFrameInfo = new TPFrameInfo();
    private int mHandlerResult = 0;
    /* access modifiers changed from: private */
    public BlockingQueue<Integer> mInputQueue = new LinkedBlockingQueue();
    public MediaCrypto mMediaCrypto = null;
    /* access modifiers changed from: private */
    public BlockingQueue<TPFrameInfo> mOutputQueue = new LinkedBlockingQueue();
    private boolean mRestartCodecOnException = false;
    public boolean mStarted = false;
    public Surface mSurface = null;
    /* access modifiers changed from: private */
    public final Object mThreadLock = new Object();

    public class AsyncDecodeHandler extends Handler {
        public AsyncDecodeHandler(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder r0 = com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder.this
                java.lang.Object r0 = r0.mThreadLock
                monitor-enter(r0)
                int r1 = r6.what     // Catch:{ all -> 0x003c }
                r2 = 0
                switch(r1) {
                    case 1000: goto L_0x0027;
                    case 1001: goto L_0x001c;
                    case 1002: goto L_0x0015;
                    case 1003: goto L_0x000e;
                    default: goto L_0x000d;
                }     // Catch:{ all -> 0x003c }
            L_0x000d:
                goto L_0x0035
            L_0x000e:
                com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder r6 = com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder.this     // Catch:{ all -> 0x003c }
                int r2 = r6.onRelease()     // Catch:{ all -> 0x003c }
                goto L_0x0035
            L_0x0015:
                com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder r6 = com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder.this     // Catch:{ all -> 0x003c }
                int r2 = r6.onFlush()     // Catch:{ all -> 0x003c }
                goto L_0x0035
            L_0x001c:
                com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder r1 = com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder.this     // Catch:{ all -> 0x003c }
                java.lang.Object r6 = r6.obj     // Catch:{ all -> 0x003c }
                android.view.Surface r6 = (android.view.Surface) r6     // Catch:{ all -> 0x003c }
                int r2 = r1.onSetOutputSurface(r6)     // Catch:{ all -> 0x003c }
                goto L_0x0035
            L_0x0027:
                com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder r1 = com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder.this     // Catch:{ all -> 0x003c }
                int r3 = r6.arg1     // Catch:{ all -> 0x003c }
                int r6 = r6.arg2     // Catch:{ all -> 0x003c }
                r4 = 1
                if (r6 != r4) goto L_0x0031
                r2 = r4
            L_0x0031:
                int r2 = r1.onReleaseOutputBuffer(r3, r2)     // Catch:{ all -> 0x003c }
            L_0x0035:
                com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder r6 = com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder.this     // Catch:{ all -> 0x003c }
                r6.handleMessageComplete(r2)     // Catch:{ all -> 0x003c }
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                return
            L_0x003c:
                r6 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.decoder.TPBaseMediaCodecDecoder.AsyncDecodeHandler.handleMessage(android.os.Message):void");
        }
    }

    public class BufferCallback extends b.a {
        private BufferCallback() {
        }

        public void onError(b bVar, MediaCodec.CodecException codecException) {
            String logTag = TPBaseMediaCodecDecoder.this.getLogTag();
            TPNativeLog.printLog(4, logTag, "onError: " + TPBaseMediaCodecDecoder.this.getStackTrace(codecException));
            int unused = TPBaseMediaCodecDecoder.this.handleRelease();
        }

        public void onInputBufferAvailable(b bVar, int i11) {
            try {
                TPBaseMediaCodecDecoder.this.mInputQueue.put(Integer.valueOf(i11));
            } catch (Exception e11) {
                TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(e11));
            }
        }

        public void onOutputBufferAvailable(b bVar, int i11, MediaCodec.BufferInfo bufferInfo) {
            try {
                TPFrameInfo tPFrameInfo = new TPFrameInfo();
                tPFrameInfo.errCode = 0;
                tPFrameInfo.bufferIndex = i11;
                tPFrameInfo.ptsUs = bufferInfo.presentationTimeUs;
                TPBaseMediaCodecDecoder.this.processOutputBuffer(bVar, i11, bufferInfo, tPFrameInfo);
                TPBaseMediaCodecDecoder.this.mOutputQueue.put(tPFrameInfo);
            } catch (Exception e11) {
                TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(e11));
            }
        }

        public void onOutputFormatChanged(b bVar, MediaFormat mediaFormat) {
            TPBaseMediaCodecDecoder.this.processOutputFormatChanged(mediaFormat);
        }
    }

    public TPBaseMediaCodecDecoder(int i11) {
        this.mCodecId = i11;
        initTMediaCodec();
    }

    private void bufferSizeCheck(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() < bArr.length) {
            String logTag = getLogTag();
            TPNativeLog.printLog(4, logTag, "decodeAsync, not enough space, byteBuffer.remaining:" + byteBuffer.remaining() + ", buffer size:" + bArr.length);
            try {
                dumpByteArray(bArr, 0, 100, 20);
            } catch (Exception e11) {
                TPNativeLog.printLog(4, getLogTag(), e11.toString());
            }
        }
    }

    private int decodeAsync(byte[] bArr, boolean z11, long j11, boolean z12) {
        Integer num = (Integer) this.mInputQueue.poll();
        if (num == null) {
            return 1;
        }
        try {
            ByteBuffer c11 = this.mCodec.c(num.intValue());
            if (c11 != null) {
                bufferSizeCheck(c11, bArr);
                c11.put(bArr);
            }
            if (!z12 || this.mCryptoInfo == null) {
                this.mCodec.a(num.intValue(), 0, bArr.length, j11, z11 ? 1 : 0);
            } else {
                this.mCodec.a(num.intValue(), 0, this.mCryptoInfo, j11, z11 ? 1 : 0);
            }
            return 0;
        } catch (Exception e11) {
            return onMediaCodecException(e11);
        }
    }

    private TPFrameInfo dequeueOutputBufferAsync() {
        this.mFrameInfo.errCode = 1;
        TPFrameInfo tPFrameInfo = (TPFrameInfo) this.mOutputQueue.poll();
        return tPFrameInfo == null ? this.mFrameInfo : tPFrameInfo;
    }

    private void dumpByteArray(byte[] bArr, int i11, int i12, int i13) {
        if (bArr == null || i11 < 0 || i12 <= 0 || i11 >= bArr.length || i11 >= i12 || i13 <= 0) {
            throw new IllegalArgumentException();
        }
        if (bArr.length <= i12) {
            i12 = bArr.length;
        }
        int min = Math.min(i12 - i11, 100) + i11;
        StringBuilder sb2 = new StringBuilder();
        TPNativeLog.printLog(2, getLogTag(), "dumpByteArray begin:");
        int i14 = 0;
        while (i11 < min) {
            String hexString = Integer.toHexString(bArr[i11] & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            sb2.append(hexString.toUpperCase());
            i14++;
            if (i14 % i13 == 0) {
                TPNativeLog.printLog(2, getLogTag(), sb2.toString());
                sb2.setLength(0);
            } else {
                sb2.append(" ");
            }
            i11++;
        }
        TPNativeLog.printLog(2, getLogTag(), "dumpByteArray end.");
    }

    private void exitDecodeThread() {
        HandlerThread handlerThread = this.mDecodeThread;
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            } else {
                handlerThread.quit();
            }
            try {
                this.mDecodeThread.join();
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }
    }

    private int flushAsync() {
        TPNativeLog.printLog(2, getLogTag(), "flushAsync: ");
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1002;
        return waitingForHandleMessage(obtainMessage);
    }

    private int handleFlush() {
        TPNativeLog.printLog(2, getLogTag(), "handleFlush: ");
        b bVar = this.mCodec;
        if (bVar == null) {
            return 104;
        }
        try {
            bVar.h();
            return 0;
        } catch (Exception e11) {
            return onMediaCodecException(e11);
        }
    }

    /* access modifiers changed from: private */
    public void handleMessageComplete(int i11) {
        this.mHandlerResult = i11;
        this.mThreadLock.notify();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public int handleRelease() {
        b bVar = this.mCodec;
        if (bVar == null) {
            return 101;
        }
        this.mStarted = false;
        try {
            bVar.f();
            this.mCodec.g();
            this.mCodec = null;
            return 0;
        } catch (Exception e11) {
            String logTag = getLogTag();
            TPNativeLog.printLog(4, logTag, "stop: failed!" + getStackTrace(e11));
            this.mCodec.g();
            this.mCodec = null;
            return 3;
        } catch (Throwable th2) {
            this.mCodec.g();
            this.mCodec = null;
            throw th2;
        }
    }

    private int handleReleaseOutputBuffer(int i11, boolean z11) {
        b bVar = this.mCodec;
        if (bVar == null || i11 < 0) {
            return 3;
        }
        try {
            bVar.a(i11, z11);
            return 0;
        } catch (Exception e11) {
            return onMediaCodecException(e11);
        }
    }

    private int handleSetOutputSurface(Surface surface) {
        TPNativeLog.printLog(2, getLogTag(), "setOutputSurface: ".concat(String.valueOf(surface)));
        Surface surface2 = this.mSurface;
        if (surface2 == surface) {
            TPNativeLog.printLog(3, getLogTag(), "setOutputSurface: set the same surface.");
            return 0;
        }
        this.mSurface = surface;
        if (this.mCodec != null) {
            if (surface2 == null || surface == null) {
                return 3;
            }
            try {
                if (!surface.isValid() || Build.VERSION.SDK_INT < 23 || !this.mEnableSetOutputSurfaceApi) {
                    return 3;
                }
                this.mCodec.a(surface);
            } catch (Exception e11) {
                String logTag = getLogTag();
                TPNativeLog.printLog(4, logTag, "setOutputSurface onMediaCodecException:\n" + getStackTrace(e11));
                return 3;
            }
        }
        return 0;
    }

    private int handleSignalEndOfStream(int i11) {
        try {
            this.mCodec.a(i11, 0, 0, 0, 4);
            return 0;
        } catch (Exception e11) {
            String logTag = getLogTag();
            TPNativeLog.printLog(4, logTag, "handleSignalEndOfStream: failed!" + getStackTrace(e11));
            return 3;
        }
    }

    private boolean initMediaCodecInternal() {
        try {
            List<String> mimeCandidates = getMimeCandidates();
            boolean z11 = false;
            String str = null;
            String str2 = null;
            for (int i11 = 0; i11 < mimeCandidates.size() && str == null; i11++) {
                str2 = mimeCandidates.get(i11);
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec with mime:" + str2 + " mDrmType:" + this.mDrmType);
                MediaCrypto mediaCrypto = this.mMediaCrypto;
                boolean requiresSecureDecoderComponent = mediaCrypto != null ? mediaCrypto.requiresSecureDecoderComponent(str2) : false;
                if (!requiresSecureDecoderComponent || !TPCodecUtils.isInDRMLevel1Blacklist(this.mDrmType)) {
                    z11 = requiresSecureDecoderComponent;
                } else {
                    TPNativeLog.printLog(2, getLogTag(), "Device " + TPSystemInfo.getDeviceName() + " DrmType " + this.mDrmType + " fallback to L3.");
                    z11 = false;
                }
                str = getCodecName(str2, z11);
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec got codecName:" + str + " secureComponent " + z11);
            }
            if (str == null) {
                TPNativeLog.printLog(4, getLogTag(), "initMediaCodec failed, codecName is null.");
                return false;
            }
            if (MimeTypes.AUDIO_DTS.equals(str2)) {
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec current mime type:" + str2 + " is audio dts, need set input timeout to 0!");
                MEDIA_CODEC_INPUT_TIMEOUT_US = 0;
                MEDIA_CODEC_OUTPUT_TIMEOUT_US = 0;
            }
            b a11 = b.a(str);
            this.mCodec = a11;
            a11.a(this.mEnableMediaCodecReuse && !this.mEnableAsyncMode);
            this.mCodec.a((a) new com.tencent.thumbplayer.tcmedia.g.a.b() {
                public void onReuseCodecAPIException(String str, Throwable th2) {
                    super.onReuseCodecAPIException(str, th2);
                    TPMediaCodecManager.onMediaCodecException(TPBaseMediaCodecDecoder.this.mCodecId, str);
                }

                public void onStarted(Boolean bool, String str) {
                    super.onStarted(bool, str);
                    TPMediaCodecManager.onMediaCodecReady(TPBaseMediaCodecDecoder.this.mCodecId, str);
                }
            });
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec codec name: ".concat(str));
            if (this.mEnableAsyncMode && Build.VERSION.SDK_INT >= 23) {
                TPNativeLog.printLog(2, getLogTag(), "MediaCodec EnableAsyncMode！");
                HandlerThread handlerThread = new HandlerThread("MediaCodecThread");
                this.mDecodeThread = handlerThread;
                handlerThread.start();
                this.mDecoderHandler = new AsyncDecodeHandler(this.mDecodeThread.getLooper());
                this.mCodec.a((b.a) new BufferCallback(), (Handler) this.mDecoderHandler);
            }
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 1);
            configCodec(this.mCodec, str2);
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 2);
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 3);
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec, start codec start");
            this.mCodec.e();
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec, start codec finished");
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 4);
            this.mStarted = true;
            if (this.mDrmType != -1) {
                boolean z12 = TPCodecUtils.getDecoderName(str2, true) != null;
                TPMediaDrmInfo tPMediaDrmInfo = new TPMediaDrmInfo();
                tPMediaDrmInfo.supportSecureDecoder = z12;
                tPMediaDrmInfo.supportSecureDecrypt = z11;
                tPMediaDrmInfo.componentName = str;
                tPMediaDrmInfo.drmType = this.mDrmType;
                TPNativeLog.printLog(2, getLogTag(), "DRM Info: supportSecureDecoder: " + tPMediaDrmInfo.supportSecureDecoder + " supportSecureDecrypt:" + tPMediaDrmInfo.supportSecureDecrypt + " componentName: " + tPMediaDrmInfo.componentName + " drmType: " + tPMediaDrmInfo.drmType);
                TPMediaCodecManager.onMediaDrmInfo(this.mCodecId, tPMediaDrmInfo);
            }
            return true;
        } catch (Exception e11) {
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 4);
            TPNativeLog.printLog(4, getLogTag(), getStackTrace(e11));
            return false;
        }
    }

    private static synchronized void initTMediaCodec() {
        synchronized (TPBaseMediaCodecDecoder.class) {
            if (!sTMediaCodecInited) {
                com.tencent.thumbplayer.tcmedia.g.a.b();
                com.tencent.thumbplayer.tcmedia.g.a.a().a(true);
                com.tencent.thumbplayer.tcmedia.g.a.a().a((com.tencent.thumbplayer.tcmedia.g.h.a) new com.tencent.thumbplayer.tcmedia.g.h.a() {
                    public final void d(String str, String str2) {
                        TPNativeLog.printLog(1, str, str2);
                    }

                    public final void e(String str, String str2, Throwable th2) {
                        TPNativeLog.printLog(4, str, str2);
                    }

                    public final void i(String str, String str2) {
                        TPNativeLog.printLog(2, str, str2);
                    }

                    public final void v(String str, String str2) {
                        TPNativeLog.printLog(0, str, str2);
                    }

                    public final void w(String str, String str2, Throwable th2) {
                        TPNativeLog.printLog(3, str, str2);
                    }
                });
                sTMediaCodecInited = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public int onFlush() {
        this.mInputQueue.clear();
        this.mOutputQueue.clear();
        int handleFlush = handleFlush();
        this.mCodec.e();
        return handleFlush;
    }

    private int onMediaCodecException(Exception exc) {
        String logTag = getLogTag();
        TPNativeLog.printLog(4, logTag, "onMediaCodecException!\n" + getStackTrace(exc));
        resetFrameInfo();
        processMediaCodecException(exc);
        if (this.mRestartCodecOnException) {
            initMediaCodecInternal();
            return 4;
        }
        handleRelease();
        return 103;
    }

    /* access modifiers changed from: private */
    public int onRelease() {
        this.mInputQueue.clear();
        this.mOutputQueue.clear();
        return handleRelease();
    }

    /* access modifiers changed from: private */
    public int onReleaseOutputBuffer(int i11, boolean z11) {
        return handleReleaseOutputBuffer(i11, z11);
    }

    /* access modifiers changed from: private */
    public int onSetOutputSurface(Surface surface) {
        return handleSetOutputSurface(surface);
    }

    private int queueInputBuffer(byte[] bArr, long j11, boolean z11) {
        MediaCodec.CryptoInfo cryptoInfo;
        try {
            ByteBuffer[] j12 = this.mCodec.j();
            int a11 = this.mCodec.a(MEDIA_CODEC_INPUT_TIMEOUT_US);
            if (a11 < 0) {
                return a11 == -1 ? 1 : 103;
            }
            ByteBuffer byteBuffer = j12[a11];
            bufferSizeCheck(byteBuffer, bArr);
            byteBuffer.put(bArr);
            if (!z11 || (cryptoInfo = this.mCryptoInfo) == null) {
                this.mCodec.a(a11, 0, bArr.length, j11, 0);
            } else {
                this.mCodec.a(a11, 0, cryptoInfo, j11, 0);
            }
            return 0;
        } catch (Exception e11) {
            return onMediaCodecException(e11);
        }
    }

    private int releaseAsync() {
        TPNativeLog.printLog(2, getLogTag(), "releaseAsync: ");
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1003;
        int waitingForHandleMessage = waitingForHandleMessage(obtainMessage);
        exitDecodeThread();
        return waitingForHandleMessage;
    }

    private int releaseOutputBufferAsync(int i11, boolean z11) {
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1000;
        obtainMessage.arg1 = i11;
        obtainMessage.arg2 = z11 ? 1 : 0;
        return waitingForHandleMessage(obtainMessage);
    }

    private void resetFrameInfo() {
        TPFrameInfo tPFrameInfo = this.mFrameInfo;
        tPFrameInfo.bufferIndex = -1000;
        tPFrameInfo.ptsUs = -1;
        tPFrameInfo.data = null;
        tPFrameInfo.errCode = 103;
    }

    private MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i11 = 0; i11 < codecCount; i11++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i11);
            if (!codecInfoAt.isEncoder()) {
                for (String equalsIgnoreCase : codecInfoAt.getSupportedTypes()) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private int setOutputSurfaceAsync(Surface surface) {
        TPNativeLog.printLog(2, getLogTag(), "setOutputSurfaceAsync: ".concat(String.valueOf(surface)));
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1001;
        obtainMessage.obj = surface;
        return waitingForHandleMessage(obtainMessage);
    }

    private int signalEndOfStreamAsync() {
        Integer num = (Integer) this.mInputQueue.poll();
        if (num == null) {
            return 1;
        }
        return handleSignalEndOfStream(num.intValue());
    }

    private int waitingForHandleMessage(Message message) {
        synchronized (this.mThreadLock) {
            message.sendToTarget();
            try {
                this.mThreadLock.wait();
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }
        return this.mHandlerResult;
    }

    public abstract void configCodec(b bVar, String str);

    public int decode(byte[] bArr, boolean z11, long j11, boolean z12) {
        if (!this.mStarted || this.mCodec == null) {
            return 101;
        }
        return (!this.mEnableAsyncMode || Build.VERSION.SDK_INT < 23) ? queueInputBuffer(bArr, j11, z12) : decodeAsync(bArr, z11, j11, z12);
    }

    public TPFrameInfo dequeueOutputBuffer() {
        String logTag;
        String str;
        if (this.mCodec == null) {
            return this.mFrameInfo;
        }
        resetFrameInfo();
        if (this.mEnableAsyncMode) {
            return dequeueOutputBufferAsync();
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        try {
            int a11 = this.mCodec.a(bufferInfo, MEDIA_CODEC_OUTPUT_TIMEOUT_US);
            if (a11 >= 0) {
                int i11 = bufferInfo.flags;
                if (i11 == 4) {
                    logTag = getLogTag();
                    str = "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM";
                } else {
                    if (i11 != 2 || !this.mEnableAudioPassThrough) {
                        TPFrameInfo tPFrameInfo = this.mFrameInfo;
                        tPFrameInfo.bufferIndex = a11;
                        tPFrameInfo.ptsUs = bufferInfo.presentationTimeUs;
                        tPFrameInfo.errCode = 0;
                        processOutputBuffer(this.mCodec, a11, bufferInfo, tPFrameInfo);
                    } else {
                        TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_CODEC_CONFIG, AudioPassThrough");
                        TPFrameInfo tPFrameInfo2 = this.mFrameInfo;
                        tPFrameInfo2.bufferIndex = a11;
                        tPFrameInfo2.ptsUs = bufferInfo.presentationTimeUs;
                        processOutputConfigData(this.mCodec, a11, bufferInfo, tPFrameInfo2);
                    }
                    return this.mFrameInfo;
                }
            } else {
                if (a11 == -2) {
                    processOutputFormatChanged(this.mCodec.i());
                } else if (a11 != -1) {
                    if (a11 == -3) {
                        TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: INFO_OUTPUT_BUFFERS_CHANGED!");
                    } else if (bufferInfo.flags == 4) {
                        logTag = getLogTag();
                        str = "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM!";
                    } else {
                        TPNativeLog.printLog(4, getLogTag(), "dequeueOutputBuffer: TP_ERROR_DECODE_FAILED! index = ".concat(String.valueOf(a11)));
                        this.mFrameInfo.errCode = 103;
                        return this.mFrameInfo;
                    }
                }
                this.mFrameInfo.errCode = 1;
                return this.mFrameInfo;
            }
            TPNativeLog.printLog(2, logTag, str);
            this.mFrameInfo.errCode = 2;
            return this.mFrameInfo;
        } catch (Exception e11) {
            this.mFrameInfo.errCode = onMediaCodecException(e11);
            return this.mFrameInfo;
        }
    }

    public int flush() {
        TPNativeLog.printLog(2, getLogTag(), "flush: ");
        if (this.mCodec == null) {
            return 104;
        }
        return this.mEnableAsyncMode ? flushAsync() : handleFlush();
    }

    public abstract String getCodecName(String str, boolean z11);

    public abstract String getLogTag();

    public abstract List<String> getMimeCandidates();

    public String getStackTrace(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public abstract void processMediaCodecException(Exception exc);

    public abstract void processOutputBuffer(b bVar, int i11, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo);

    public abstract void processOutputConfigData(b bVar, int i11, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo);

    public abstract void processOutputFormatChanged(MediaFormat mediaFormat);

    public int release() {
        return this.mEnableAsyncMode ? releaseAsync() : handleRelease();
    }

    public int releaseOutputBuffer(int i11, boolean z11) {
        if (this.mCodec == null || i11 < 0) {
            return 3;
        }
        return this.mEnableAsyncMode ? releaseOutputBufferAsync(i11, z11) : handleReleaseOutputBuffer(i11, z11);
    }

    public void setCryptoInfo(int i11, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i12) {
        if (this.mCryptoInfo == null) {
            this.mCryptoInfo = new MediaCodec.CryptoInfo();
        }
        this.mCryptoInfo.set(i11, iArr, iArr2, bArr, bArr2, i12);
    }

    public int setOperateRate(float f11) {
        if (this.mCodec != null) {
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    TPNativeLog.printLog(2, getLogTag(), "setOperateRate: ".concat(String.valueOf(f11)));
                    Bundle bundle = new Bundle();
                    bundle.putShort("priority", 0);
                    bundle.putFloat("operating-rate", f11);
                    this.mCodec.a(bundle);
                }
            } catch (Exception unused) {
                String logTag = getLogTag();
                TPNativeLog.printLog(3, logTag, "setOperateRate: " + f11 + " failed.");
            }
        }
        return 0;
    }

    public int setOutputSurface(Surface surface) {
        return this.mEnableAsyncMode ? setOutputSurfaceAsync(surface) : handleSetOutputSurface(surface);
    }

    public boolean setParamBool(int i11, boolean z11) {
        if (i11 == 0) {
            this.mEnableSetOutputSurfaceApi = z11;
        } else if (i11 != 1) {
            if (i11 == 3) {
                this.mEnableAudioPassThrough = z11;
                String logTag = getLogTag();
                TPNativeLog.printLog(2, logTag, "BOOL_SET_IS_AUDIO_PASSTHROUGH mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
            } else if (i11 != 4) {
                TPNativeLog.printLog(3, getLogTag(), "Unknown paramKey: ".concat(String.valueOf(i11)));
                return false;
            } else {
                this.mEnableMediaCodecReuse = z11;
            }
        } else if (!this.mStarted) {
            this.mEnableAsyncMode = z11;
        } else {
            TPNativeLog.printLog(3, getLogTag(), "BOOL_ENABLE_ASYNC_MODE must setup before started!");
        }
        return true;
    }

    public boolean setParamBytes(int i11, byte[] bArr) {
        return false;
    }

    public boolean setParamInt(int i11, int i12) {
        return false;
    }

    public boolean setParamLong(int i11, long j11) {
        return false;
    }

    public boolean setParamObject(int i11, Object obj) {
        if (i11 != 300) {
            return false;
        }
        this.mMediaCrypto = (MediaCrypto) obj;
        return true;
    }

    public boolean setParamString(int i11, String str) {
        return false;
    }

    public int signalEndOfStream() {
        TPNativeLog.printLog(2, getLogTag(), "signalEndOfStream: ");
        b bVar = this.mCodec;
        if (bVar == null) {
            return 3;
        }
        if (this.mEnableAsyncMode) {
            return signalEndOfStreamAsync();
        }
        int a11 = bVar.a(MEDIA_CODEC_INPUT_TIMEOUT_US);
        return a11 >= 0 ? handleSignalEndOfStream(a11) : a11 == -1 ? 1 : 3;
    }

    public boolean startDecoder() {
        return initMediaCodecInternal();
    }
}
