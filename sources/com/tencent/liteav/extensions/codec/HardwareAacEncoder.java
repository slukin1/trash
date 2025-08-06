package com.tencent.liteav.extensions.codec;

import android.media.MediaFormat;
import com.google.android.exoplayer2.util.MimeTypes;
import com.tencent.liteav.extensions.codec.AacMediaCodecWrapper;
import java.nio.ByteBuffer;

public class HardwareAacEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final AacMediaCodecWrapper f21587a = new AacMediaCodecWrapper(AacMediaCodecWrapper.a.f21583a);

    public ByteBuffer encode(ByteBuffer byteBuffer) {
        return this.f21587a.processFrame(byteBuffer);
    }

    public boolean init(int i11, int i12, int i13) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(MimeTypes.AUDIO_AAC, i11, i12);
        createAudioFormat.setInteger("bitrate", i13);
        createAudioFormat.setInteger("aac-profile", 2);
        return this.f21587a.a(createAudioFormat);
    }

    public void unInit() {
        this.f21587a.a();
    }
}
