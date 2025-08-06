package com.tencent.ugc.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.decoder.MediaCodecDecoder;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder;
import java.util.concurrent.TimeUnit;

public class MediaCodecHDRDecoder extends MediaCodecDecoder {
    /* access modifiers changed from: private */
    public Surface mOutputSurface;

    public MediaCodecHDRDecoder(HardwareDecoderMediaFormatBuilder hardwareDecoderMediaFormatBuilder, Size size, boolean z11, MediaCodecDecoder.MediaCodecDecoderListener mediaCodecDecoderListener, CustomHandler customHandler) {
        super(hardwareDecoderMediaFormatBuilder, size, z11, mediaCodecDecoderListener, customHandler);
        this.mTAG = "MediaCodecHDRDecoder";
    }

    public boolean configureMediaCodec(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        Surface surface = this.mOutputSurface;
        if (surface == null) {
            return false;
        }
        MediaCodecWrapper.configure(mediaCodec, mediaFormat, surface, (MediaCrypto) null, 0);
        return true;
    }

    public boolean handleOutputBuffer(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, int i11) {
        mediaCodec.releaseOutputBuffer(i11, true);
        if ((bufferInfo.flags & 4) != 0) {
            LiteavLog.i(this.mTAG, "meet end of stream.");
            MediaCodecDecoder.MediaCodecDecoderListener mediaCodecDecoderListener = this.mListener;
            if (mediaCodecDecoderListener != null) {
                mediaCodecDecoderListener.onDecodeFrame((PixelFrame) null, true);
            }
        } else {
            PixelFrame pixelFrame = new PixelFrame();
            pixelFrame.setWidth(this.mResolution.width);
            pixelFrame.setHeight(this.mResolution.height);
            pixelFrame.setTimestamp(TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs));
            MediaCodecDecoder.MediaCodecDecoderListener mediaCodecDecoderListener2 = this.mListener;
            if (mediaCodecDecoderListener2 != null) {
                mediaCodecDecoderListener2.onDecodeFrame(pixelFrame, false);
            }
        }
        return false;
    }

    public void setOutputSurface(Surface surface) {
        runOnWorkThread(i.a(this, surface));
    }

    public boolean start(Object obj) {
        return true;
    }

    public void updateOutputSurface(MediaCodec mediaCodec) {
    }
}
