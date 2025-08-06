package com.tencent.thumbplayer.tcmedia.core.decoder;

import android.view.Surface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ITPMediaCodecDecoder {
    public static final int BOOL_DISABLE_MEDIA_CODEC_DOLBY_VISION_COMPONENT = 6;
    public static final int BOOL_ENABLE_ASYNC_MODE = 1;
    public static final int BOOL_ENABLE_MEDIACODEC_OUTPUT_DATA = 5;
    public static final int BOOL_ENABLE_MEDIACODEC_REUSE = 4;
    public static final int BOOL_ENABLE_SET_OUTPUT_SURFACE_API = 0;
    public static final int BOOL_SET_IS_ADTS = 2;
    public static final int BOOL_SET_IS_AUDIO_PASSTHROUGH = 3;
    public static final int BYTES_SET_CSD0_DATA = 200;
    public static final int BYTES_SET_CSD1_DATA = 201;
    public static final int BYTES_SET_CSD2_DATA = 202;
    public static final int OBJECT_SET_MEDIA_CRYPTO = 300;
    public static final int TP_CODEC_RETURN_CODE_EOS = 2;
    public static final int TP_CODEC_RETURN_CODE_ERROR = 3;
    public static final int TP_CODEC_RETURN_CODE_INTERNAL_RESET = 4;
    public static final int TP_CODEC_RETURN_CODE_OK = 0;
    public static final int TP_CODEC_RETURN_CODE_TRY_AGAIN = 1;
    public static final int TP_ERROR_DECODE_FAILED = 103;
    public static final int TP_ERROR_FLUSH_FAILED = 104;
    public static final int TP_ERROR_INVALID_CODECPAR = 100;
    public static final int TP_ERROR_NO_CODEC = 101;
    public static final int TP_ERROR_OPEN_FAILED = 102;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaCodecReturnCode {
    }

    int decode(byte[] bArr, boolean z11, long j11, boolean z12);

    TPFrameInfo dequeueOutputBuffer();

    int flush();

    boolean initDecoder(String str, int i11, int i12, int i13, int i14);

    boolean initDecoder(String str, int i11, int i12, int i13, Surface surface, int i14, int i15, int i16);

    int release();

    int releaseOutputBuffer(int i11, boolean z11);

    void setCryptoInfo(int i11, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i12);

    int setOperateRate(float f11);

    int setOutputSurface(Surface surface);

    boolean setParamBool(int i11, boolean z11);

    boolean setParamBytes(int i11, byte[] bArr);

    boolean setParamInt(int i11, int i12);

    boolean setParamLong(int i11, long j11);

    boolean setParamObject(int i11, Object obj);

    boolean setParamString(int i11, String str);

    int signalEndOfStream();

    boolean startDecoder();
}
