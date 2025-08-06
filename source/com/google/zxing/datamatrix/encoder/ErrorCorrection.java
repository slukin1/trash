package com.google.zxing.datamatrix.encoder;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.math.DoubleMath;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import org.jmrtd.cbeff.ISO781611;

public final class ErrorCorrection {
    private static final int[] ALOG = new int[255];
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 138, 205, 12, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE, 39, 245, 60, 97, 120}, new int[]{41, 153, ISO781611.SMT_DO_DS, 91, 61, 42, 142, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_LOSSLESS, 100, 39, 188, 75, 66, 61, 241, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, 109, 129, 94, 254, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 48, 90, 188}, new int[]{15, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_LOSSLESS, TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE, 9, 233, 71, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE, 2, 188, 160, 153, 145, ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, DoubleMath.MAX_FACTORIAL, 53, 75, 34, 249, 121, 17, 138, 110, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, TPOptionalID.OPTION_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK, 136, 120, 151, 233, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE, 93, 255}, new int[]{245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 184, 59, 25, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 105, 122, 2, 245, 133, 242, 8, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 95, 100, 9, TPPixelFormat.TP_PIX_FMT_MEDIACODEC, 105, 214, 111, 57, 121, 21, 1, ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, DoubleMath.MAX_FACTORIAL, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 69, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, 92, ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 19}, new int[]{HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 9, 223, 238, 12, 17, 220, 208, 100, 29, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, DoubleMath.MAX_FACTORIAL, 230, 192, TPNativePlayerInitConfig.BOOL_VIDEO_KEEP_MEDIA_CODEC_PTS, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_IGNORE_VIDEO_STREAM_IN_COMMON_AUDIO_FORMATS, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 28, 155, 43, 203, 107, 233, 53, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_ORIGINAL_VIDEO_INFO_CALLBACK_FROM_SURFACE_LISTENER, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, PsExtractor.PRIVATE_STREAM_1, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_ORIGINAL_VIDEO_INFO_CALLBACK_FROM_SURFACE_LISTENER, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 250, 106, 185, 221, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, DoubleMath.MAX_FACTORIAL, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE, 154, 36, 73, 127, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, 136, 248, 180, 234, 197, ISO781611.SMT_DO_DS, 177, 68, 122, 93, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, 15, 160, 227, 236, 66, 139, 153, 185, 202, TPPixelFormat.TP_PIX_FMT_MEDIACODEC, 179, 25, 220, 232, 96, 210, 231, 136, 223, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 181, 241, 59, 52, 172, 25, 49, 232, 211, PsExtractor.PRIVATE_STREAM_1, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[] LOG = new int[256];
    private static final int MODULO_VALUE = 301;

    static {
        int i11 = 1;
        for (int i12 = 0; i12 < 255; i12++) {
            ALOG[i12] = i11;
            LOG[i11] = i12;
            i11 <<= 1;
            if (i11 >= 256) {
                i11 ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    private static String createECCBlock(CharSequence charSequence, int i11) {
        return createECCBlock(charSequence, 0, charSequence.length(), i11);
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() == symbolInfo.getDataCapacity()) {
            StringBuilder sb2 = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
            sb2.append(str);
            int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
            if (interleavedBlockCount == 1) {
                sb2.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
            } else {
                sb2.setLength(sb2.capacity());
                int[] iArr = new int[interleavedBlockCount];
                int[] iArr2 = new int[interleavedBlockCount];
                int[] iArr3 = new int[interleavedBlockCount];
                int i11 = 0;
                while (i11 < interleavedBlockCount) {
                    int i12 = i11 + 1;
                    iArr[i11] = symbolInfo.getDataLengthForInterleavedBlock(i12);
                    iArr2[i11] = symbolInfo.getErrorLengthForInterleavedBlock(i12);
                    iArr3[i11] = 0;
                    if (i11 > 0) {
                        iArr3[i11] = iArr3[i11 - 1] + iArr[i11];
                    }
                    i11 = i12;
                }
                for (int i13 = 0; i13 < interleavedBlockCount; i13++) {
                    StringBuilder sb3 = new StringBuilder(iArr[i13]);
                    for (int i14 = i13; i14 < symbolInfo.getDataCapacity(); i14 += interleavedBlockCount) {
                        sb3.append(str.charAt(i14));
                    }
                    String createECCBlock = createECCBlock(sb3.toString(), iArr2[i13]);
                    int i15 = i13;
                    int i16 = 0;
                    while (i15 < iArr2[i13] * interleavedBlockCount) {
                        sb2.setCharAt(symbolInfo.getDataCapacity() + i15, createECCBlock.charAt(i16));
                        i15 += interleavedBlockCount;
                        i16++;
                    }
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String createECCBlock(CharSequence charSequence, int i11, int i12, int i13) {
        int i14 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i14 >= iArr.length) {
                i14 = -1;
                break;
            } else if (iArr[i14] == i13) {
                break;
            } else {
                i14++;
            }
        }
        if (i14 >= 0) {
            int[] iArr2 = FACTORS[i14];
            char[] cArr = new char[i13];
            for (int i15 = 0; i15 < i13; i15++) {
                cArr[i15] = 0;
            }
            for (int i16 = i11; i16 < i11 + i12; i16++) {
                int i17 = i13 - 1;
                char charAt = cArr[i17] ^ charSequence.charAt(i16);
                while (i17 > 0) {
                    if (charAt == 0 || iArr2[i17] == 0) {
                        cArr[i17] = cArr[i17 - 1];
                    } else {
                        char c11 = cArr[i17 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i17] = (char) (c11 ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i17]]) % 255]);
                    }
                    i17--;
                }
                if (charAt == 0 || iArr2[0] == 0) {
                    cArr[0] = 0;
                } else {
                    int[] iArr5 = ALOG;
                    int[] iArr6 = LOG;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                }
            }
            char[] cArr2 = new char[i13];
            for (int i18 = 0; i18 < i13; i18++) {
                cArr2[i18] = cArr[(i13 - i18) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i13)));
    }
}
