package com.tencent.liteav.videobase.common;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.common.base.Ascii;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
public class EncodedVideoFrame {
    private static final String TAG = "EncodedVideoFrame";
    public CodecType codecType = CodecType.H264;
    public final ConsumerChainTimestamp consumerChainTimestamp = new ConsumerChainTimestamp();
    public ByteBuffer data;
    public long dts;
    public long frameIndex = 0;
    public long gopFrameIndex = 0;
    public long gopIndex = 0;
    public b hdrType = b.UNKNOWN;
    public int height;
    public MediaCodec.BufferInfo info = null;
    public boolean isEosFrame = false;
    public d nalType = d.UNKNOWN;
    public long nativePtr = 0;
    public final ProducerChainTimestamp producerChainTimestamp = new ProducerChainTimestamp();
    public e profileType = e.UNKNOWN;
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
        encodedVideoFrame.nalType = d.a(i11);
        encodedVideoFrame.profileType = e.a(i12);
        encodedVideoFrame.codecType = CodecType.a(i14);
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
        encodedVideoFrame.hdrType = b.a(i18);
        return encodedVideoFrame;
    }

    private d getNalTypeFromH264NALHeader(ByteBuffer byteBuffer, int i11) {
        byte b11 = byteBuffer.get(i11) & Ascii.US;
        if (b11 == 5) {
            return d.IDR;
        }
        if (b11 == 6) {
            return d.SEI;
        }
        if (b11 == 7) {
            return d.SPS;
        }
        if (b11 != 8) {
            return d.UNKNOWN;
        }
        return d.PPS;
    }

    private d getNalTypeFromH265NALHeader(ByteBuffer byteBuffer, int i11) {
        int i12 = (byteBuffer.get(i11) & 126) >> 1;
        if (i12 == 39) {
            return d.SEI;
        }
        switch (i12) {
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return d.IDR;
            default:
                switch (i12) {
                    case 32:
                        return d.VPS;
                    case 33:
                        return d.SPS;
                    case 34:
                        return d.PPS;
                    default:
                        return d.UNKNOWN;
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
        b bVar = this.hdrType;
        return (bVar == null || bVar == b.UNKNOWN) ? false : true;
    }

    public boolean isIDRFrame() {
        d dVar = this.nalType;
        if (dVar != null) {
            if (dVar == d.IDR) {
                return true;
            }
        }
        return false;
    }

    public boolean isRPSEnable() {
        e eVar = this.profileType;
        return eVar == e.BASELINE_RPS || eVar == e.MAIN_RPS || eVar == e.HIGH_RPS;
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
        d dVar;
        if (this.data != null) {
            d dVar2 = this.nalType;
            if (dVar2 == null || dVar2 == d.UNKNOWN) {
                int i11 = 0;
                while (true) {
                    i11 = getNextNALHeaderPos(i11, this.data);
                    if (i11 != -1 && i11 < this.data.remaining()) {
                        d dVar3 = d.UNKNOWN;
                        if (isH265()) {
                            dVar = getNalTypeFromH265NALHeader(this.data, i11);
                        } else {
                            dVar = getNalTypeFromH264NALHeader(this.data, i11);
                        }
                        d dVar4 = this.nalType;
                        if (dVar4 == null || dVar4 == dVar3 || dVar == d.IDR) {
                            this.nalType = dVar;
                        }
                        d dVar5 = this.nalType;
                        if (dVar5 != d.SPS && dVar5 != d.PPS && dVar5 != d.VPS && dVar5 != d.SEI) {
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
