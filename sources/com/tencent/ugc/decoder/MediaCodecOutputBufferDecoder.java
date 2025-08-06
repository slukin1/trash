package com.tencent.ugc.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.decoder.MediaCodecDecoder;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder;
import com.tencent.ugc.videobase.utils.MemoryAllocator;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class MediaCodecOutputBufferDecoder extends MediaCodecDecoder {
    private int mSliceHeight = 0;
    private int mStride = 0;

    public MediaCodecOutputBufferDecoder(HardwareDecoderMediaFormatBuilder hardwareDecoderMediaFormatBuilder, Size size, boolean z11, MediaCodecDecoder.MediaCodecDecoderListener mediaCodecDecoderListener, CustomHandler customHandler) {
        super(hardwareDecoderMediaFormatBuilder, size, z11, mediaCodecDecoderListener, customHandler);
        this.mTAG = "MediaCodecOutputBufferDecoder";
    }

    private void copyI420Buffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i11, int i12, int i13, int i14) {
        copyPlane(byteBuffer, 0, byteBuffer2, 0, i13, i11, i12);
        int i15 = i13 * i14;
        int i16 = i15 + 0;
        int i17 = i11 * i12;
        int i18 = i17 + 0;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        int i19 = i13 / 2;
        int i21 = i11 / 2;
        int i22 = i12 / 2;
        copyPlane(byteBuffer3, i16, byteBuffer4, i18, i19, i21, i22);
        copyPlane(byteBuffer3, i16 + (i15 / 4), byteBuffer4, i18 + (i17 / 4), i19, i21, i22);
    }

    private void copyNV12Buffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i11, int i12, int i13, int i14) {
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        int i15 = i13;
        int i16 = i11;
        copyPlane(byteBuffer3, 0, byteBuffer4, 0, i15, i16, i12);
        copyPlane(byteBuffer3, (i14 * i13) + 0, byteBuffer4, (i11 * i12) + 0, i15, i16, i12 / 2);
    }

    private void copyPlane(ByteBuffer byteBuffer, int i11, ByteBuffer byteBuffer2, int i12, int i13, int i14, int i15) {
        OpenGlUtils.nativeCopyYuvFromByteBufferToByteBuffer(byteBuffer, i11, byteBuffer2, i12, i13, i14, i15);
    }

    private ByteBuffer copyYuvBuffer(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i11) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        byteBuffer.rewind();
        Size size = this.mResolution;
        ByteBuffer allocateDirectBuffer = MemoryAllocator.allocateDirectBuffer(((size.width * size.height) * 3) / 2);
        if (allocateDirectBuffer == null) {
            return null;
        }
        if (i11 == 19) {
            Size size2 = this.mResolution;
            copyI420Buffer(byteBuffer, allocateDirectBuffer, size2.width, size2.height, this.mStride, this.mSliceHeight);
        } else if (i11 != 21) {
            return null;
        } else {
            Size size3 = this.mResolution;
            copyNV12Buffer(byteBuffer, allocateDirectBuffer, size3.width, size3.height, this.mStride, this.mSliceHeight);
        }
        allocateDirectBuffer.rewind();
        return allocateDirectBuffer;
    }

    private PixelFrame createPixelFrame(ByteBuffer byteBuffer, MediaFormat mediaFormat, long j11) {
        int integer = mediaFormat.getInteger("color-format");
        if (!isSupportColorFormat(integer)) {
            return null;
        }
        PixelFrame pixelFrame = new PixelFrame();
        pixelFrame.setWidth(this.mResolution.width);
        pixelFrame.setHeight(this.mResolution.height);
        pixelFrame.setTimestamp(TimeUnit.MICROSECONDS.toMillis(j11));
        pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.BYTE_BUFFER);
        pixelFrame.setBuffer(byteBuffer);
        pixelFrame.setPixelFormatType(integer == 19 ? GLConstants.PixelFormatType.I420 : GLConstants.PixelFormatType.NV12);
        pixelFrame.setColorFormat(getMediaFormatValue(mediaFormat, "color-range", 2) == 1 ? GLConstants.ColorRange.FULL_RANGE : GLConstants.ColorRange.VIDEO_RANGE, getMediaFormatValue(mediaFormat, "color-standard", 2) == 1 ? GLConstants.ColorSpace.BT709 : GLConstants.ColorSpace.BT601);
        return pixelFrame;
    }

    private int getMediaFormatValue(MediaFormat mediaFormat, String str, int i11) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i11;
    }

    public static boolean isSupportColorFormat(int i11) {
        return i11 == 19 || i11 == 21;
    }

    public boolean configureMediaCodec(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int supportColorFormat = DecodeAbilityProvider.getInstance().getSupportColorFormat(mediaFormat.getString("mime"));
        if (supportColorFormat <= 0) {
            return false;
        }
        mediaFormat.setInteger("color-format", supportColorFormat);
        MediaCodecWrapper.configure(mediaCodec, mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        return true;
    }

    public boolean handleOutputBuffer(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, int i11) {
        if (this.mListener == null) {
            return false;
        }
        if ((bufferInfo.flags & 4) != 0) {
            LiteavLog.i(this.mTAG, "meet end of stream.");
            this.mListener.onDecodeFrame((PixelFrame) null, true);
        } else {
            ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i11);
            MediaFormat outputFormat = mediaCodec.getOutputFormat();
            ByteBuffer copyYuvBuffer = copyYuvBuffer(outputBuffer, bufferInfo, outputFormat.getInteger("color-format"));
            if (copyYuvBuffer == null) {
                return false;
            }
            PixelFrame createPixelFrame = createPixelFrame(copyYuvBuffer, outputFormat, bufferInfo.presentationTimeUs);
            if (createPixelFrame != null) {
                this.mListener.onDecodeFrame(createPixelFrame, false);
            } else {
                LiteavLog.e(this.mThrottlers.a("handleOutputBuffer"), this.mTAG, String.format("output color format(%d) is unknown", new Object[]{Integer.valueOf(outputFormat.getInteger("color-format"))}), new Object[0]);
                this.mListener.onDecoderError();
            }
        }
        mediaCodec.releaseOutputBuffer(i11, false);
        return false;
    }

    public void outputFormatChange(MediaFormat mediaFormat) {
        LiteavLog.i(this.mTAG, "decode output format changed: ".concat(String.valueOf(mediaFormat)));
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        this.mStride = integer;
        this.mSliceHeight = integer2;
        if (mediaFormat.containsKey("stride")) {
            this.mStride = mediaFormat.getInteger("stride");
        }
        if (mediaFormat.containsKey("slice-height")) {
            this.mSliceHeight = mediaFormat.getInteger("slice-height");
        }
        this.mStride = Math.max(integer, this.mStride);
        this.mSliceHeight = Math.max(integer2, this.mSliceHeight);
    }

    public boolean start(Object obj) {
        return true;
    }

    public void updateOutputSurface(MediaCodec mediaCodec) {
    }
}
