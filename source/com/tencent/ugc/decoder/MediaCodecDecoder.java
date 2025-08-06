package com.tencent.ugc.decoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.google.common.base.Ascii;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.videobase.common.CodecType;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.common.MediaCodecAbility;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.CollectionUtils;
import com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder;
import com.tencent.ugc.videobase.utils.MemoryAllocator;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public abstract class MediaCodecDecoder {
    public final MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private final HardwareDecoderMediaFormatBuilder mDecoderMediaFormatBuilder;
    private boolean mEnableLimitMaxDecFrameBufferingInH264Sps = false;
    public final boolean mForceSoftwareDecoder;
    public MediaCodecDecoderListener mListener;
    private MediaCodec mMediaCodec = null;
    public final Size mResolution;
    private final H264SPSModifier mSPSModifier = new H264SPSModifier();
    public String mTAG = "MediaCodecDecoder";
    public final b mThrottlers = new b();
    private volatile CustomHandler mWorkHandler;

    public static class BuildResult {
        public boolean isSuccess = true;
        public String warningMessage = "";
    }

    public interface MediaCodecDecoderListener {
        void onDecodeFrame(PixelFrame pixelFrame, boolean z11);

        void onDecoderError();
    }

    public MediaCodecDecoder(HardwareDecoderMediaFormatBuilder hardwareDecoderMediaFormatBuilder, Size size, boolean z11, MediaCodecDecoderListener mediaCodecDecoderListener, CustomHandler customHandler) {
        this.mDecoderMediaFormatBuilder = hardwareDecoderMediaFormatBuilder;
        this.mResolution = size;
        this.mForceSoftwareDecoder = z11;
        this.mListener = mediaCodecDecoderListener;
        this.mWorkHandler = customHandler;
    }

    private byte[] getSpsData(byte[] bArr, int[] iArr) {
        int i11 = 0;
        while (true) {
            if (i11 + 4 < bArr.length && (i11 = EncodedVideoFrame.getNextNALHeaderPos(i11, ByteBuffer.wrap(bArr))) >= 0) {
                if ((bArr[i11] & Ascii.US) == 7) {
                    iArr[0] = i11;
                    break;
                }
            } else {
                break;
            }
        }
        if (iArr[0] < 0) {
            return null;
        }
        int length = bArr.length - iArr[0];
        int i12 = iArr[0];
        while (true) {
            int i13 = i12 + 3;
            if (i13 >= bArr.length) {
                break;
            } else if (!((bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 1) || (bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 0 && bArr[i13] == 1))) {
                i12++;
            }
        }
        length = i12 - iArr[0];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, iArr[0], bArr2, 0, length);
        return bArr2;
    }

    private void limitMaxDecFrameBufferingInH264Sps(EncodedVideoFrame encodedVideoFrame) {
        byte[] allocateByteArray;
        ByteBuffer allocateDirectBuffer;
        if (encodedVideoFrame.isIDRFrame() && encodedVideoFrame.codecType == CodecType.H264 && this.mEnableLimitMaxDecFrameBufferingInH264Sps && (allocateByteArray = MemoryAllocator.allocateByteArray(encodedVideoFrame.data.remaining())) != null) {
            encodedVideoFrame.data.get(allocateByteArray);
            encodedVideoFrame.data.rewind();
            int[] iArr = {-1};
            byte[] spsData = getSpsData(allocateByteArray, iArr);
            if (spsData != null && iArr[0] >= 0) {
                byte[] bArr = null;
                try {
                    bArr = this.mSPSModifier.updateVUIforMaxBuffering(spsData);
                } catch (Throwable th2) {
                    LiteavLog.e(this.mTAG, "modify dec buffer error ", th2);
                }
                if (bArr != null && (allocateDirectBuffer = MemoryAllocator.allocateDirectBuffer((allocateByteArray.length - spsData.length) + bArr.length)) != null) {
                    encodedVideoFrame.data = allocateDirectBuffer;
                    if (iArr[0] > 0) {
                        allocateDirectBuffer.put(allocateByteArray, 0, iArr[0]);
                    }
                    encodedVideoFrame.data.put(bArr);
                    encodedVideoFrame.data.put(allocateByteArray, iArr[0] + spsData.length, (allocateByteArray.length - iArr[0]) - spsData.length);
                    encodedVideoFrame.data.rewind();
                }
            }
        }
    }

    public BuildResult buildMediaCodec(boolean z11, MediaCodec mediaCodec) {
        String str;
        this.mDecoderMediaFormatBuilder.setIsLowLatencyDecodeEnabled(z11);
        MediaFormat build = this.mDecoderMediaFormatBuilder.build();
        BuildResult buildResult = new BuildResult();
        boolean z12 = false;
        String str2 = "";
        if (mediaCodec != null) {
            try {
                this.mMediaCodec = mediaCodec;
                updateOutputSurface(mediaCodec);
                LiteavLog.i(this.mTAG, "preload MediaCodec update surface success (%s)", this.mMediaCodec.getName());
                z12 = true;
            } catch (Throwable th2) {
                LiteavLog.e(this.mTAG, "start MediaCodec failed.", th2);
                if (th2 instanceof IllegalArgumentException) {
                    str = "VideoDecode: illegal argument, Start decoder failed";
                } else {
                    str = th2 instanceof IllegalStateException ? "VideoDecode: illegal state, Start decoder failed" : "VideoDecode: Start decoder failed";
                }
                str2 = "decoder config fail, message:" + str + " exception:" + th2.getMessage();
            }
        } else {
            MediaCodec createMediaCodecInternal = createMediaCodecInternal(this.mForceSoftwareDecoder, build.getString("mime"));
            this.mMediaCodec = createMediaCodecInternal;
            createMediaCodecInternal.setVideoScalingMode(1);
            boolean configureMediaCodec = configureMediaCodec(this.mMediaCodec, build);
            if (configureMediaCodec) {
                LiteavLog.i(this.mTAG, "configure MediaCodec with ".concat(String.valueOf(build)));
                this.mMediaCodec.start();
                LiteavLog.i(this.mTAG, "start MediaCodec(%s) success.", this.mMediaCodec.getName());
            }
            z12 = configureMediaCodec;
        }
        buildResult.isSuccess = z12;
        if (!z12) {
            destroyMediaCodec();
            buildResult.warningMessage = str2;
        }
        return buildResult;
    }

    public abstract boolean configureMediaCodec(MediaCodec mediaCodec, MediaFormat mediaFormat);

    public MediaCodec createMediaCodecInternal(boolean z11, String str) throws IOException {
        if (!z11) {
            return MediaCodec.createDecoderByType(str);
        }
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
            if (!mediaCodecInfo.isEncoder()) {
                int length = supportedTypes.length;
                int i11 = 0;
                while (i11 < length) {
                    if (!supportedTypes[i11].contains(str) || !MediaCodecAbility.isSoftOnlyDecoder(mediaCodecInfo)) {
                        i11++;
                    } else {
                        LiteavLog.i(this.mTAG, "Use soft only decoder:%s", mediaCodecInfo.getName());
                        return MediaCodec.createByCodecName(mediaCodecInfo.getName());
                    }
                }
                continue;
            }
        }
        return MediaCodec.createDecoderByType(str);
    }

    public void destroyMediaCodec() {
        if (this.mMediaCodec != null) {
            try {
                LiteavLog.i(this.mTAG, "mediaCodec stop");
                this.mMediaCodec.stop();
                try {
                    LiteavLog.i(this.mTAG, "mediaCodec release");
                    this.mMediaCodec.release();
                } catch (Throwable th2) {
                    LiteavLog.e(this.mTAG, "release MediaCodec failed.", th2);
                }
                this.mMediaCodec = null;
                return;
            } catch (Throwable th3) {
                LiteavLog.e(this.mTAG, "release MediaCodec failed.", th3);
            }
        } else {
            return;
        }
        this.mMediaCodec = null;
    }

    public boolean drainDecodedFrame() {
        int dequeueOutputBuffer;
        if (this.mMediaCodec == null) {
            return false;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= 3 || (dequeueOutputBuffer = MediaCodecWrapper.dequeueOutputBuffer(this.mMediaCodec, this.mBufferInfo, TimeUnit.MILLISECONDS.toMicros(1))) == -1) {
                return false;
            }
            if (dequeueOutputBuffer == -3) {
                LiteavLog.i(this.mTAG, "on output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                outputFormatChange(this.mMediaCodec.getOutputFormat());
            } else if (dequeueOutputBuffer >= 0) {
                return handleOutputBuffer(this.mMediaCodec, this.mBufferInfo, dequeueOutputBuffer);
            } else {
                LiteavLog.d(this.mTAG, "dequeueOutputBuffer get invalid index: %d", Integer.valueOf(dequeueOutputBuffer));
            }
            i11++;
        }
        return false;
    }

    public void enableLimitMaxDecFrameBuffer(boolean z11) {
        this.mEnableLimitMaxDecFrameBufferingInH264Sps = z11;
    }

    public boolean feedEncodedFrame(EncodedVideoFrame encodedVideoFrame) {
        ByteBuffer byteBuffer;
        if (this.mMediaCodec == null) {
            return false;
        }
        if (encodedVideoFrame == null || (!encodedVideoFrame.isEosFrame && ((byteBuffer = encodedVideoFrame.data) == null || byteBuffer.remaining() == 0))) {
            LiteavLog.w(this.mTAG, "receive empty buffer.");
            return true;
        }
        ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
        if (CollectionUtils.isEmpty((T[]) inputBuffers)) {
            LiteavLog.e(this.mTAG, "get invalid input buffers.");
            return false;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int dequeueInputBuffer = MediaCodecWrapper.dequeueInputBuffer(mediaCodec, timeUnit.toMicros(3));
        if (dequeueInputBuffer < 0) {
            return false;
        }
        if (!encodedVideoFrame.isEosFrame) {
            limitMaxDecFrameBufferingInH264Sps(encodedVideoFrame);
            int remaining = encodedVideoFrame.data.remaining();
            inputBuffers[dequeueInputBuffer].put(encodedVideoFrame.data);
            MediaCodecWrapper.queueInputBuffer(this.mMediaCodec, dequeueInputBuffer, 0, remaining, timeUnit.toMicros(encodedVideoFrame.pts), 0);
        } else {
            LiteavLog.i(this.mTAG, "feedDataToMediaCodec BUFFER_FLAG_END_OF_STREAM");
            MediaCodecWrapper.queueInputBuffer(this.mMediaCodec, dequeueInputBuffer, 0, 0, 0, 4);
        }
        return true;
    }

    public void flush() {
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            mediaCodec.flush();
        }
    }

    public abstract boolean handleOutputBuffer(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, int i11);

    public void outputFormatChange(MediaFormat mediaFormat) {
        LiteavLog.i(this.mTAG, "decode output format changed: ".concat(String.valueOf(mediaFormat)));
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        LiteavLog.i(this.mTAG, "cropWidth: %d, cropHeight: %d, frameWidth: %d, frameHeight: %d", Integer.valueOf(Math.abs(mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1), Integer.valueOf(Math.abs(mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1), Integer.valueOf(integer), Integer.valueOf(integer2));
    }

    public void runOnWorkThread(Runnable runnable) {
        if (this.mWorkHandler != null) {
            this.mWorkHandler.runOrPost(runnable);
        }
    }

    public abstract boolean start(Object obj);

    public void stop() {
        destroyMediaCodec();
    }

    public abstract void updateOutputSurface(MediaCodec mediaCodec);
}
