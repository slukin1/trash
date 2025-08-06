package com.tencent.ugc.videobase.common;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.common.base.Ascii;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import java.nio.ByteBuffer;

@JNINamespace("liteav::ugc")
public class EncodedVideoFrame {
    private static final String TAG = "EncodedVideoFrame";
    public CodecType codecType = CodecType.H264;
    public ByteBuffer data;
    public long dts;
    public long frameIndex = 0;
    public long gopFrameIndex = 0;
    public long gopIndex = 0;
    public HDRType hdrType = HDRType.UNKNOWN;
    public int height;
    public MediaCodec.BufferInfo info = null;
    public boolean isEosFrame = false;
    public VideoFrameType nalType = VideoFrameType.UNKNOWN;
    public long nativePtr = 0;
    public VideoProfileType profileType = VideoProfileType.UNKNOWN;
    public long pts;
    public long refFrameIndex = 0;
    public int rotation;
    public Integer svcInfo = null;
    public MediaFormat videoFormat;
    public int width;

    public static EncodedVideoFrame createEncodedVideoFrame(ByteBuffer byteBuffer, int i11, int i12, int i13, long j11, long j12, long j13, long j14, long j15, long j16, int i14, long j17, int i15, int i16, boolean z11, int i17, int i18) {
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        encodedVideoFrame.data = byteBuffer;
        encodedVideoFrame.nativePtr = j17;
        encodedVideoFrame.nalType = VideoFrameType.fromInteger(i11);
        encodedVideoFrame.profileType = VideoProfileType.fromInteger(i12);
        encodedVideoFrame.codecType = CodecType.fromInteger(i14);
        encodedVideoFrame.rotation = i13;
        encodedVideoFrame.dts = j11;
        encodedVideoFrame.pts = j12;
        encodedVideoFrame.gopIndex = j13;
        encodedVideoFrame.gopFrameIndex = j14;
        encodedVideoFrame.frameIndex = j15;
        encodedVideoFrame.refFrameIndex = j16;
        encodedVideoFrame.info = null;
        encodedVideoFrame.width = i15;
        encodedVideoFrame.height = i16;
        if (z11) {
            encodedVideoFrame.svcInfo = Integer.valueOf(i17);
        } else {
            encodedVideoFrame.svcInfo = null;
        }
        encodedVideoFrame.hdrType = HDRType.fromInteger(i18);
        return encodedVideoFrame;
    }

    private VideoFrameType getNalTypeFromH264NALHeader(ByteBuffer byteBuffer, int i11) {
        byte b11 = byteBuffer.get(i11) & Ascii.US;
        if (b11 == 5) {
            return VideoFrameType.IDR;
        }
        if (b11 == 6) {
            return VideoFrameType.SEI;
        }
        if (b11 == 7) {
            return VideoFrameType.SPS;
        }
        if (b11 != 8) {
            return VideoFrameType.UNKNOWN;
        }
        return VideoFrameType.PPS;
    }

    private VideoFrameType getNalTypeFromH265NALHeader(ByteBuffer byteBuffer, int i11) {
        int i12 = (byteBuffer.get(i11) & 126) >> 1;
        if (i12 == 39) {
            return VideoFrameType.SEI;
        }
        switch (i12) {
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return VideoFrameType.IDR;
            default:
                switch (i12) {
                    case 32:
                        return VideoFrameType.VPS;
                    case 33:
                        return VideoFrameType.SPS;
                    case 34:
                        return VideoFrameType.PPS;
                    default:
                        return VideoFrameType.UNKNOWN;
                }
        }
    }

    public static int getNextNALHeaderPos(int i11, ByteBuffer byteBuffer) {
        while (true) {
            int i12 = i11 + 3;
            if (i12 >= byteBuffer.remaining()) {
                return -1;
            }
            if (byteBuffer.get(i11) == 0 && byteBuffer.get(i11 + 1) == 0 && byteBuffer.get(i11 + 2) == 0 && byteBuffer.get(i12) == 1) {
                return i11 + 4;
            }
            if (byteBuffer.get(i11) == 0 && byteBuffer.get(i11 + 1) == 0 && byteBuffer.get(i11 + 2) == 1) {
                return i12;
            }
            i11++;
        }
    }

    private native void nativeRelease(long j11);

    public static long resetEncodedVideoFrame(EncodedVideoFrame encodedVideoFrame) {
        long j11 = encodedVideoFrame.nativePtr;
        if (j11 == 0 || encodedVideoFrame.data == null) {
            return 0;
        }
        encodedVideoFrame.data = null;
        encodedVideoFrame.nativePtr = 0;
        return j11;
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativePtr != 0) {
            LiteavLog.w(TAG, "nativePtr != 0, must call release before finalize ");
            release();
        }
    }

    public boolean isH265() {
        return this.codecType == CodecType.H265;
    }

    public boolean isHDRFrame() {
        HDRType hDRType = this.hdrType;
        return (hDRType == null || hDRType == HDRType.UNKNOWN) ? false : true;
    }

    public boolean isIDRFrame() {
        VideoFrameType videoFrameType = this.nalType;
        return videoFrameType != null && videoFrameType.isIDRFrame();
    }

    public boolean isRPSEnable() {
        VideoProfileType videoProfileType = this.profileType;
        return videoProfileType == VideoProfileType.BASELINE_RPS || videoProfileType == VideoProfileType.MAIN_RPS || videoProfileType == VideoProfileType.HIGH_RPS;
    }

    public boolean isSVCEnable() {
        return this.svcInfo != null;
    }

    public boolean isValidFrame() {
        ByteBuffer byteBuffer = this.data;
        return byteBuffer != null && byteBuffer.remaining() > 0 && this.nalType != null && this.codecType != null && this.width > 0 && this.height > 0;
    }

    public void release() {
        long j11 = this.nativePtr;
        if (j11 != 0) {
            nativeRelease(j11);
            this.nativePtr = 0;
        }
    }

    public String toString() {
        return "nalType = " + this.nalType + ", profiletype=" + this.profileType + ", rotation=" + this.rotation + ", codecType=" + this.codecType + ", dts=" + this.dts + ", pts=" + this.pts + ", gopIndex=" + this.gopIndex + ", gopFrameIndex=" + this.gopFrameIndex + ", frameIndex=" + this.frameIndex;
    }

    public void updateNALTypeAccordingNALHeader() {
        VideoFrameType videoFrameType;
        if (this.data != null) {
            VideoFrameType videoFrameType2 = this.nalType;
            if (videoFrameType2 == null || videoFrameType2 == VideoFrameType.UNKNOWN) {
                int i11 = 0;
                while (true) {
                    i11 = getNextNALHeaderPos(i11, this.data);
                    if (i11 != -1 && i11 < this.data.remaining()) {
                        VideoFrameType videoFrameType3 = VideoFrameType.UNKNOWN;
                        if (isH265()) {
                            videoFrameType = getNalTypeFromH265NALHeader(this.data, i11);
                        } else {
                            videoFrameType = getNalTypeFromH264NALHeader(this.data, i11);
                        }
                        VideoFrameType videoFrameType4 = this.nalType;
                        if (videoFrameType4 == null || videoFrameType4 == videoFrameType3 || videoFrameType == VideoFrameType.IDR) {
                            this.nalType = videoFrameType;
                        }
                        VideoFrameType videoFrameType5 = this.nalType;
                        if (videoFrameType5 != VideoFrameType.SPS && videoFrameType5 != VideoFrameType.PPS && videoFrameType5 != VideoFrameType.VPS && videoFrameType5 != VideoFrameType.SEI) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
