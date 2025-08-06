package com.tencent.liteav.extensions.codec;

import android.media.MediaFormat;
import com.google.android.exoplayer2.util.MimeTypes;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.extensions.codec.AacMediaCodecWrapper;
import java.nio.ByteBuffer;

public class HardwareAacDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final AacMediaCodecWrapper f21586a = new AacMediaCodecWrapper(AacMediaCodecWrapper.a.f21584b);

    public ByteBuffer decode(ByteBuffer byteBuffer) {
        return this.f21586a.processFrame(byteBuffer);
    }

    public int getCacheSize() {
        return this.f21586a.f21578b;
    }

    public int getOutputChannelCount() {
        MediaFormat mediaFormat = this.f21586a.f21577a;
        if (mediaFormat == null) {
            return -1;
        }
        try {
            return mediaFormat.getInteger("channel-count");
        } catch (Exception e11) {
            Log.e("HardwareAacDecoder", "getOutputChannelCount failed. ".concat(String.valueOf(e11)), new Object[0]);
            return -1;
        }
    }

    public int getOutputSampleRate() {
        MediaFormat mediaFormat = this.f21586a.f21577a;
        if (mediaFormat == null) {
            return -1;
        }
        try {
            return mediaFormat.getInteger("sample-rate");
        } catch (Exception e11) {
            Log.e("HardwareAacDecoder", "getOutputSampleRate failed. ".concat(String.valueOf(e11)), new Object[0]);
            return -1;
        }
    }

    public boolean init(int i11, int i12, ByteBuffer byteBuffer) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(MimeTypes.AUDIO_AAC, i11, i12);
        createAudioFormat.setString("mime", MimeTypes.AUDIO_AAC);
        createAudioFormat.setByteBuffer("csd-0", byteBuffer);
        return this.f21586a.a(createAudioFormat);
    }

    public void unInit() {
        this.f21586a.a();
    }
}
