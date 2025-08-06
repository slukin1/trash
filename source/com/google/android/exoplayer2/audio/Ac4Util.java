package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.primitives.SignedBytes;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import java.nio.ByteBuffer;

public final class Ac4Util {
    public static final int AC40_SYNCWORD = 44096;
    public static final int AC41_SYNCWORD = 44097;
    private static final int CHANNEL_COUNT_2 = 2;
    public static final int HEADER_SIZE_FOR_PARSER = 16;
    public static final int MAX_RATE_BYTES_PER_SECOND = 336000;
    private static final int[] SAMPLE_COUNT = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE, TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE, TXVodDownloadDataSource.QUALITY_480P, 400, 400, 2048};
    public static final int SAMPLE_HEADER_SIZE = 7;

    public static final class SyncFrameInfo {
        public final int bitstreamVersion;
        public final int channelCount;
        public final int frameSize;
        public final int sampleCount;
        public final int sampleRate;

        private SyncFrameInfo(int i11, int i12, int i13, int i14, int i15) {
            this.bitstreamVersion = i11;
            this.channelCount = i12;
            this.sampleRate = i13;
            this.frameSize = i14;
            this.sampleCount = i15;
        }
    }

    private Ac4Util() {
    }

    public static void getAc4SampleHeader(int i11, ParsableByteArray parsableByteArray) {
        parsableByteArray.reset(7);
        byte[] data = parsableByteArray.getData();
        data[0] = -84;
        data[1] = SignedBytes.MAX_POWER_OF_TWO;
        data[2] = -1;
        data[3] = -1;
        data[4] = (byte) ((i11 >> 16) & 255);
        data[5] = (byte) ((i11 >> 8) & 255);
        data[6] = (byte) (i11 & 255);
    }

    public static Format parseAc4AnnexEFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        parsableByteArray.skipBytes(1);
        return new Format.Builder().setId(str).setSampleMimeType(MimeTypes.AUDIO_AC4).setChannelCount(2).setSampleRate(((parsableByteArray.readUnsignedByte() & 32) >> 5) == 1 ? 48000 : 44100).setDrmInitData(drmInitData).setLanguage(str2).build();
    }

    public static int parseAc4SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return parseAc4SyncframeInfo(new ParsableBitArray(bArr)).sampleCount;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0082, code lost:
        if (r10 != 11) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0087, code lost:
        if (r10 != 11) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008c, code lost:
        if (r10 != 8) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.audio.Ac4Util.SyncFrameInfo parseAc4SyncframeInfo(com.google.android.exoplayer2.util.ParsableBitArray r10) {
        /*
            r0 = 16
            int r1 = r10.readBits(r0)
            int r0 = r10.readBits(r0)
            r2 = 4
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r3) goto L_0x0018
            r0 = 24
            int r0 = r10.readBits(r0)
            r3 = 7
            goto L_0x0019
        L_0x0018:
            r3 = r2
        L_0x0019:
            int r0 = r0 + r3
            r3 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r3) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r7 = r0
            r0 = 2
            int r1 = r10.readBits(r0)
            r3 = 3
            if (r1 != r3) goto L_0x002f
            int r4 = readVariableBits(r10, r0)
            int r1 = r1 + r4
        L_0x002f:
            r4 = r1
            r1 = 10
            int r1 = r10.readBits(r1)
            boolean r5 = r10.readBit()
            if (r5 == 0) goto L_0x0045
            int r5 = r10.readBits(r3)
            if (r5 <= 0) goto L_0x0045
            r10.skipBits(r0)
        L_0x0045:
            boolean r5 = r10.readBit()
            r6 = 48000(0xbb80, float:6.7262E-41)
            r8 = 44100(0xac44, float:6.1797E-41)
            if (r5 == 0) goto L_0x0053
            r9 = r6
            goto L_0x0054
        L_0x0053:
            r9 = r8
        L_0x0054:
            int r10 = r10.readBits(r2)
            r5 = 0
            if (r9 != r8) goto L_0x0065
            r8 = 13
            if (r10 != r8) goto L_0x0065
            int[] r0 = SAMPLE_COUNT
            r10 = r0[r10]
            r8 = r10
            goto L_0x0091
        L_0x0065:
            if (r9 != r6) goto L_0x0090
            int[] r6 = SAMPLE_COUNT
            int r8 = r6.length
            if (r10 >= r8) goto L_0x0090
            r5 = r6[r10]
            int r1 = r1 % 5
            r6 = 8
            r8 = 1
            if (r1 == r8) goto L_0x008a
            r8 = 11
            if (r1 == r0) goto L_0x0085
            if (r1 == r3) goto L_0x008a
            if (r1 == r2) goto L_0x007e
            goto L_0x0090
        L_0x007e:
            if (r10 == r3) goto L_0x008e
            if (r10 == r6) goto L_0x008e
            if (r10 != r8) goto L_0x0090
            goto L_0x0089
        L_0x0085:
            if (r10 == r6) goto L_0x008e
            if (r10 != r8) goto L_0x0090
        L_0x0089:
            goto L_0x008e
        L_0x008a:
            if (r10 == r3) goto L_0x008e
            if (r10 != r6) goto L_0x0090
        L_0x008e:
            int r5 = r5 + 1
        L_0x0090:
            r8 = r5
        L_0x0091:
            com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo r10 = new com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo
            r5 = 2
            r0 = 0
            r3 = r10
            r6 = r9
            r9 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.Ac4Util.parseAc4SyncframeInfo(com.google.android.exoplayer2.util.ParsableBitArray):com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo");
    }

    public static int parseAc4SyncframeSize(byte[] bArr, int i11) {
        int i12 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        byte b11 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (b11 == 65535) {
            b11 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i12 = 4;
        }
        if (i11 == 44097) {
            i12 += 2;
        }
        return b11 + i12;
    }

    private static int readVariableBits(ParsableBitArray parsableBitArray, int i11) {
        int i12 = 0;
        while (true) {
            int readBits = i12 + parsableBitArray.readBits(i11);
            if (!parsableBitArray.readBit()) {
                return readBits;
            }
            i12 = (readBits + 1) << i11;
        }
    }
}
