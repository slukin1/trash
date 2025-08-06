package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.sumsub.sns.internal.ml.autocapture.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class DtsUtil {
    private static final int[] CHANNELS_BY_AMODE = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    public static final int DTS_HD_MAX_RATE_BYTES_PER_SECOND = 2250000;
    public static final int DTS_MAX_RATE_BYTES_PER_SECOND = 192000;
    private static final byte FIRST_BYTE_14B_BE = 31;
    private static final byte FIRST_BYTE_14B_LE = -1;
    private static final byte FIRST_BYTE_BE = Byte.MAX_VALUE;
    private static final byte FIRST_BYTE_LE = -2;
    private static final int[] SAMPLE_RATE_BY_SFREQ = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int SYNC_VALUE_14B_BE = 536864768;
    private static final int SYNC_VALUE_14B_LE = -14745368;
    private static final int SYNC_VALUE_BE = 2147385345;
    private static final int SYNC_VALUE_LE = -25230976;
    private static final int[] TWICE_BITRATE_KBPS_BY_RATE = {64, 112, 128, 192, 224, 256, b.f34945b, 448, 512, b.f34944a, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    private DtsUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getDtsFrameSize(byte[] r7) {
        /*
            r0 = 0
            byte r1 = r7[r0]
            r2 = -2
            r3 = 6
            r4 = 7
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L_0x004a
            r2 = -1
            if (r1 == r2) goto L_0x0032
            r2 = 31
            if (r1 == r2) goto L_0x0021
            r1 = 5
            byte r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            byte r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r7 = r7[r4]
            goto L_0x0058
        L_0x0021:
            byte r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            byte r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            byte r7 = r7[r1]
            goto L_0x0042
        L_0x0032:
            byte r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            byte r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            byte r7 = r7[r1]
        L_0x0042:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L_0x005d
        L_0x004a:
            byte r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            byte r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r7 = r7[r3]
        L_0x0058:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
        L_0x005d:
            if (r0 == 0) goto L_0x0063
            int r7 = r7 * 16
            int r7 = r7 / 14
        L_0x0063:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DtsUtil.getDtsFrameSize(byte[]):int");
    }

    private static ParsableBitArray getNormalizedFrameHeader(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new ParsableBitArray(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (isLittleEndianFrameHeader(copyOf)) {
            for (int i11 = 0; i11 < copyOf.length - 1; i11 += 2) {
                byte b11 = copyOf[i11];
                int i12 = i11 + 1;
                copyOf[i11] = copyOf[i12];
                copyOf[i12] = b11;
            }
        }
        ParsableBitArray parsableBitArray = new ParsableBitArray(copyOf);
        if (copyOf[0] == 31) {
            ParsableBitArray parsableBitArray2 = new ParsableBitArray(copyOf);
            while (parsableBitArray2.bitsLeft() >= 16) {
                parsableBitArray2.skipBits(2);
                parsableBitArray.putInt(parsableBitArray2.readBits(14), 14);
            }
        }
        parsableBitArray.reset(copyOf);
        return parsableBitArray;
    }

    private static boolean isLittleEndianFrameHeader(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }

    public static boolean isSyncWord(int i11) {
        return i11 == SYNC_VALUE_BE || i11 == SYNC_VALUE_LE || i11 == SYNC_VALUE_14B_BE || i11 == SYNC_VALUE_14B_LE;
    }

    public static int parseDtsAudioSampleCount(byte[] bArr) {
        byte b11;
        int i11;
        byte b12;
        int i12;
        byte b13;
        byte b14 = bArr[0];
        if (b14 != -2) {
            if (b14 == -1) {
                i11 = (bArr[4] & 7) << 4;
                b13 = bArr[7];
            } else if (b14 != 31) {
                i12 = (bArr[4] & 1) << 6;
                b12 = bArr[5];
            } else {
                i11 = (bArr[5] & 7) << 4;
                b13 = bArr[6];
            }
            b11 = b13 & 60;
            return (((b11 >> 2) | i11) + 1) * 32;
        }
        i12 = (bArr[5] & 1) << 6;
        b12 = bArr[4];
        b11 = b12 & 252;
        return (((b11 >> 2) | i11) + 1) * 32;
    }

    public static Format parseDtsFormat(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int i11;
        ParsableBitArray normalizedFrameHeader = getNormalizedFrameHeader(bArr);
        normalizedFrameHeader.skipBits(60);
        int i12 = CHANNELS_BY_AMODE[normalizedFrameHeader.readBits(6)];
        int i13 = SAMPLE_RATE_BY_SFREQ[normalizedFrameHeader.readBits(4)];
        int readBits = normalizedFrameHeader.readBits(5);
        int[] iArr = TWICE_BITRATE_KBPS_BY_RATE;
        if (readBits >= iArr.length) {
            i11 = -1;
        } else {
            i11 = (iArr[readBits] * 1000) / 2;
        }
        normalizedFrameHeader.skipBits(10);
        return new Format.Builder().setId(str).setSampleMimeType(MimeTypes.AUDIO_DTS).setAverageBitrate(i11).setChannelCount(i12 + (normalizedFrameHeader.readBits(2) > 0 ? 1 : 0)).setSampleRate(i13).setDrmInitData(drmInitData).setLanguage(str2).build();
    }

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer) {
        byte b11;
        int i11;
        byte b12;
        int i12;
        byte b13;
        int position = byteBuffer.position();
        byte b14 = byteBuffer.get(position);
        if (b14 != -2) {
            if (b14 == -1) {
                i11 = (byteBuffer.get(position + 4) & 7) << 4;
                b13 = byteBuffer.get(position + 7);
            } else if (b14 != 31) {
                i12 = (byteBuffer.get(position + 4) & 1) << 6;
                b12 = byteBuffer.get(position + 5);
            } else {
                i11 = (byteBuffer.get(position + 5) & 7) << 4;
                b13 = byteBuffer.get(position + 6);
            }
            b11 = b13 & 60;
            return (((b11 >> 2) | i11) + 1) * 32;
        }
        i12 = (byteBuffer.get(position + 5) & 1) << 6;
        b12 = byteBuffer.get(position + 4);
        b11 = b12 & 252;
        return (((b11 >> 2) | i11) + 1) * 32;
    }
}
