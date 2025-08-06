package org.bouncycastle.crypto.digests;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.math.DoubleMath;
import com.google.zxing.oned.Code39Reader;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.jmrtd.cbeff.ISO781611;

public final class WhirlpoolDigest implements ExtendedDigest, Memoable {
    private static final int BITCOUNT_ARRAY_SIZE = 32;
    private static final int BYTE_LENGTH = 64;
    private static final long[] C0 = new long[256];
    private static final long[] C1 = new long[256];
    private static final long[] C2 = new long[256];
    private static final long[] C3 = new long[256];
    private static final long[] C4 = new long[256];
    private static final long[] C5 = new long[256];
    private static final long[] C6 = new long[256];
    private static final long[] C7 = new long[256];
    private static final int DIGEST_LENGTH_BYTES = 64;
    private static final short[] EIGHT;
    private static final int REDUCTION_POLYNOMIAL = 285;
    private static final int ROUNDS = 10;
    private static final int[] SBOX = {24, 35, 198, 232, 135, 184, 1, 79, 54, 166, 210, 245, 121, 111, 145, 82, 96, 188, 155, 142, 163, 12, 123, 53, 29, 224, TPNativePlayerInitConfig.BOOL_VIDEO_KEEP_MEDIA_CODEC_PTS, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT, 46, 75, 254, 87, 21, 119, 55, 229, 159, 240, 74, 218, 88, 201, 41, 10, 177, 160, 107, 133, PsExtractor.PRIVATE_STREAM_1, 93, 16, TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE, 203, 62, 5, 103, 228, 39, 65, 139, TPPixelFormat.TP_PIX_FMT_MEDIACODEC, 125, 149, 216, 251, 238, 124, 102, 221, 23, 71, ISO781611.SMT_DO_DS, 202, 45, 191, 7, 173, 90, 131, 51, 99, 2, DoubleMath.MAX_FACTORIAL, 113, 200, 25, 73, 217, 242, 227, 91, 136, 154, 38, 50, 176, 233, 15, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, 128, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 205, 52, 72, 255, 122, 144, 95, 32, 104, 26, 174, 180, 84, 147, 34, 100, 241, 115, 18, 64, 8, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_LOSSLESS, 236, 219, 161, TPOptionalID.OPTION_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK, 61, 151, 0, 207, 43, 118, 130, 214, 27, 181, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 106, 80, 69, 243, 48, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 63, 85, 162, 234, 101, 186, 47, 192, 222, 28, ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR, 77, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_IGNORE_VIDEO_STREAM_IN_COMMON_AUDIO_FORMATS, 117, 6, 138, 178, 230, 14, 31, 98, 212, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE, 150, 249, 197, 37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 59, 171, 206, 17, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_ORIGINAL_VIDEO_INFO_CALLBACK_FROM_SURFACE_LISTENER, 78, 183, 235, 60, 129, Code39Reader.ASTERISK_ENCODING, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 185, 19, 44, 211, 231, 110, 196, 3, 86, 68, 127, 169, 42, 187, 193, 83, 220, 11, 157, 108, 49, 116, 246, 70, 172, 137, 20, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 22, 58, 105, 9, 112, 182, 208, 237, 204, 66, 152, 164, 40, 92, 248, 134};
    private long[] _K = new long[8];
    private long[] _L = new long[8];
    private short[] _bitCount = new short[32];
    private long[] _block = new long[8];
    private byte[] _buffer = new byte[64];
    private int _bufferPos = 0;
    private long[] _hash = new long[8];
    private final long[] _rc = new long[11];
    private long[] _state = new long[8];

    static {
        short[] sArr = new short[32];
        EIGHT = sArr;
        sArr[31] = 8;
    }

    public WhirlpoolDigest() {
        for (int i11 = 0; i11 < 256; i11++) {
            int i12 = SBOX[i11];
            int maskWithReductionPolynomial = maskWithReductionPolynomial(i12 << 1);
            int maskWithReductionPolynomial2 = maskWithReductionPolynomial(maskWithReductionPolynomial << 1);
            int i13 = maskWithReductionPolynomial2 ^ i12;
            int maskWithReductionPolynomial3 = maskWithReductionPolynomial(maskWithReductionPolynomial2 << 1);
            int i14 = maskWithReductionPolynomial3 ^ i12;
            int i15 = i12;
            C0[i11] = packIntoLong(i12, i15, maskWithReductionPolynomial2, i12, maskWithReductionPolynomial3, i13, maskWithReductionPolynomial, i14);
            int i16 = i12;
            C1[i11] = packIntoLong(i14, i15, i16, maskWithReductionPolynomial2, i12, maskWithReductionPolynomial3, i13, maskWithReductionPolynomial);
            int i17 = i12;
            C2[i11] = packIntoLong(maskWithReductionPolynomial, i14, i16, i17, maskWithReductionPolynomial2, i12, maskWithReductionPolynomial3, i13);
            int i18 = i12;
            C3[i11] = packIntoLong(i13, maskWithReductionPolynomial, i14, i17, i18, maskWithReductionPolynomial2, i12, maskWithReductionPolynomial3);
            int i19 = i12;
            C4[i11] = packIntoLong(maskWithReductionPolynomial3, i13, maskWithReductionPolynomial, i14, i18, i19, maskWithReductionPolynomial2, i12);
            int i21 = i12;
            C5[i11] = packIntoLong(i12, maskWithReductionPolynomial3, i13, maskWithReductionPolynomial, i14, i19, i21, maskWithReductionPolynomial2);
            int i22 = i12;
            C6[i11] = packIntoLong(maskWithReductionPolynomial2, i12, maskWithReductionPolynomial3, i13, maskWithReductionPolynomial, i14, i21, i22);
            C7[i11] = packIntoLong(i12, maskWithReductionPolynomial2, i12, maskWithReductionPolynomial3, i13, maskWithReductionPolynomial, i14, i22);
        }
        this._rc[0] = 0;
        for (int i23 = 1; i23 <= 10; i23++) {
            int i24 = (i23 - 1) * 8;
            this._rc[i23] = (((((((C0[i24] & -72057594037927936L) ^ (C1[i24 + 1] & 71776119061217280L)) ^ (C2[i24 + 2] & 280375465082880L)) ^ (C3[i24 + 3] & 1095216660480L)) ^ (C4[i24 + 4] & 4278190080L)) ^ (C5[i24 + 5] & 16711680)) ^ (C6[i24 + 6] & 65280)) ^ (C7[i24 + 7] & 255);
        }
    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpoolDigest) {
        reset(whirlpoolDigest);
    }

    private long bytesToLongFromBuffer(byte[] bArr, int i11) {
        return (((long) bArr[i11 + 7]) & 255) | ((((long) bArr[i11 + 0]) & 255) << 56) | ((((long) bArr[i11 + 1]) & 255) << 48) | ((((long) bArr[i11 + 2]) & 255) << 40) | ((((long) bArr[i11 + 3]) & 255) << 32) | ((((long) bArr[i11 + 4]) & 255) << 24) | ((((long) bArr[i11 + 5]) & 255) << 16) | ((((long) bArr[i11 + 6]) & 255) << 8);
    }

    private void convertLongToByteArray(long j11, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < 8; i12++) {
            bArr[i11 + i12] = (byte) ((int) ((j11 >> (56 - (i12 * 8))) & 255));
        }
    }

    private byte[] copyBitLength() {
        byte[] bArr = new byte[32];
        for (int i11 = 0; i11 < 32; i11++) {
            bArr[i11] = (byte) (this._bitCount[i11] & 255);
        }
        return bArr;
    }

    private void finish() {
        byte[] copyBitLength = copyBitLength();
        byte[] bArr = this._buffer;
        int i11 = this._bufferPos;
        int i12 = i11 + 1;
        this._bufferPos = i12;
        bArr[i11] = (byte) (bArr[i11] | 128);
        if (i12 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        if (this._bufferPos > 32) {
            while (this._bufferPos != 0) {
                update((byte) 0);
            }
        }
        while (this._bufferPos <= 32) {
            update((byte) 0);
        }
        System.arraycopy(copyBitLength, 0, this._buffer, 32, copyBitLength.length);
        processFilledBuffer(this._buffer, 0);
    }

    private void increment() {
        int i11 = 0;
        for (int length = this._bitCount.length - 1; length >= 0; length--) {
            short[] sArr = this._bitCount;
            int i12 = (sArr[length] & 255) + EIGHT[length] + i11;
            i11 = i12 >>> 8;
            sArr[length] = (short) (i12 & 255);
        }
    }

    private int maskWithReductionPolynomial(int i11) {
        return ((long) i11) >= 256 ? i11 ^ 285 : i11;
    }

    private long packIntoLong(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        return (((((((((long) i12) << 48) ^ (((long) i11) << 56)) ^ (((long) i13) << 40)) ^ (((long) i14) << 32)) ^ (((long) i15) << 24)) ^ (((long) i16) << 16)) ^ (((long) i17) << 8)) ^ ((long) i18);
    }

    private void processFilledBuffer(byte[] bArr, int i11) {
        for (int i12 = 0; i12 < this._state.length; i12++) {
            this._block[i12] = bytesToLongFromBuffer(this._buffer, i12 * 8);
        }
        processBlock();
        this._bufferPos = 0;
        Arrays.fill(this._buffer, (byte) 0);
    }

    public Memoable copy() {
        return new WhirlpoolDigest(this);
    }

    public int doFinal(byte[] bArr, int i11) {
        finish();
        for (int i12 = 0; i12 < 8; i12++) {
            convertLongToByteArray(this._hash[i12], bArr, (i12 * 8) + i11);
        }
        reset();
        return getDigestSize();
    }

    public String getAlgorithmName() {
        return "Whirlpool";
    }

    public int getByteLength() {
        return 64;
    }

    public int getDigestSize() {
        return 64;
    }

    public void processBlock() {
        long[] jArr;
        for (int i11 = 0; i11 < 8; i11++) {
            long[] jArr2 = this._state;
            long j11 = this._block[i11];
            long[] jArr3 = this._K;
            long j12 = this._hash[i11];
            jArr3[i11] = j12;
            jArr2[i11] = j11 ^ j12;
        }
        int i12 = 1;
        while (i12 <= 10) {
            int i13 = 0;
            while (i13 < 8) {
                long[] jArr4 = this._L;
                jArr4[i13] = 0;
                long j13 = jArr4[i13];
                long[] jArr5 = C0;
                long[] jArr6 = this._K;
                jArr4[i13] = jArr5[((int) (jArr6[(i13 + 0) & 7] >>> 56)) & 255] ^ j13;
                jArr4[i13] = jArr4[i13] ^ C1[((int) (jArr6[(i13 - 1) & 7] >>> 48)) & 255];
                jArr4[i13] = jArr4[i13] ^ C2[((int) (jArr6[(i13 - 2) & 7] >>> 40)) & 255];
                jArr4[i13] = jArr4[i13] ^ C3[((int) (jArr6[(i13 - 3) & 7] >>> 32)) & 255];
                jArr4[i13] = jArr4[i13] ^ C4[((int) (jArr6[(i13 - 4) & 7] >>> 24)) & 255];
                jArr4[i13] = jArr4[i13] ^ C5[((int) (jArr6[(i13 - 5) & 7] >>> 16)) & 255];
                jArr4[i13] = jArr4[i13] ^ C6[((int) (jArr6[(i13 - 6) & 7] >>> 8)) & 255];
                jArr4[i13] = jArr4[i13] ^ C7[((int) jArr6[(i13 - 7) & 7]) & 255];
                i13++;
                i12 = i12;
            }
            int i14 = i12;
            long[] jArr7 = this._L;
            long[] jArr8 = this._K;
            System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
            long[] jArr9 = this._K;
            jArr9[0] = jArr9[0] ^ this._rc[i14];
            int i15 = 0;
            while (true) {
                jArr = this._L;
                if (i15 >= 8) {
                    break;
                }
                jArr[i15] = this._K[i15];
                long j14 = jArr[i15];
                long[] jArr10 = C0;
                long[] jArr11 = this._state;
                jArr[i15] = j14 ^ jArr10[((int) (jArr11[(i15 + 0) & 7] >>> 56)) & 255];
                jArr[i15] = jArr[i15] ^ C1[((int) (jArr11[(i15 - 1) & 7] >>> 48)) & 255];
                jArr[i15] = jArr[i15] ^ C2[((int) (jArr11[(i15 - 2) & 7] >>> 40)) & 255];
                jArr[i15] = jArr[i15] ^ C3[((int) (jArr11[(i15 - 3) & 7] >>> 32)) & 255];
                jArr[i15] = jArr[i15] ^ C4[((int) (jArr11[(i15 - 4) & 7] >>> 24)) & 255];
                jArr[i15] = jArr[i15] ^ C5[((int) (jArr11[(i15 - 5) & 7] >>> 16)) & 255];
                jArr[i15] = jArr[i15] ^ C6[((int) (jArr11[(i15 - 6) & 7] >>> 8)) & 255];
                jArr[i15] = jArr[i15] ^ C7[((int) jArr11[(i15 - 7) & 7]) & 255];
                i15++;
            }
            long[] jArr12 = this._state;
            System.arraycopy(jArr, 0, jArr12, 0, jArr12.length);
            i12 = i14 + 1;
        }
        for (int i16 = 0; i16 < 8; i16++) {
            long[] jArr13 = this._hash;
            jArr13[i16] = jArr13[i16] ^ (this._state[i16] ^ this._block[i16]);
        }
    }

    public void reset() {
        this._bufferPos = 0;
        Arrays.fill(this._bitCount, 0);
        Arrays.fill(this._buffer, (byte) 0);
        Arrays.fill(this._hash, 0);
        Arrays.fill(this._K, 0);
        Arrays.fill(this._L, 0);
        Arrays.fill(this._block, 0);
        Arrays.fill(this._state, 0);
    }

    public void reset(Memoable memoable) {
        WhirlpoolDigest whirlpoolDigest = (WhirlpoolDigest) memoable;
        long[] jArr = whirlpoolDigest._rc;
        long[] jArr2 = this._rc;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        byte[] bArr = whirlpoolDigest._buffer;
        byte[] bArr2 = this._buffer;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this._bufferPos = whirlpoolDigest._bufferPos;
        short[] sArr = whirlpoolDigest._bitCount;
        short[] sArr2 = this._bitCount;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        long[] jArr3 = whirlpoolDigest._hash;
        long[] jArr4 = this._hash;
        System.arraycopy(jArr3, 0, jArr4, 0, jArr4.length);
        long[] jArr5 = whirlpoolDigest._K;
        long[] jArr6 = this._K;
        System.arraycopy(jArr5, 0, jArr6, 0, jArr6.length);
        long[] jArr7 = whirlpoolDigest._L;
        long[] jArr8 = this._L;
        System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
        long[] jArr9 = whirlpoolDigest._block;
        long[] jArr10 = this._block;
        System.arraycopy(jArr9, 0, jArr10, 0, jArr10.length);
        long[] jArr11 = whirlpoolDigest._state;
        long[] jArr12 = this._state;
        System.arraycopy(jArr11, 0, jArr12, 0, jArr12.length);
    }

    public void update(byte b11) {
        byte[] bArr = this._buffer;
        int i11 = this._bufferPos;
        bArr[i11] = b11;
        int i12 = i11 + 1;
        this._bufferPos = i12;
        if (i12 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        increment();
    }

    public void update(byte[] bArr, int i11, int i12) {
        while (i12 > 0) {
            update(bArr[i11]);
            i11++;
            i12--;
        }
    }
}
