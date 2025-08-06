package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class OpusUtil {
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    private static final int FULL_CODEC_INITIALIZATION_DATA_BUFFER_COUNT = 3;
    public static final int SAMPLE_RATE = 48000;

    private OpusUtil() {
    }

    public static List<byte[]> buildInitializationData(byte[] bArr) {
        long sampleCountToNanoseconds = sampleCountToNanoseconds((long) getPreSkipSamples(bArr));
        long sampleCountToNanoseconds2 = sampleCountToNanoseconds(3840);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(buildNativeOrderByteArray(sampleCountToNanoseconds));
        arrayList.add(buildNativeOrderByteArray(sampleCountToNanoseconds2));
        return arrayList;
    }

    private static byte[] buildNativeOrderByteArray(long j11) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j11).array();
    }

    public static int getChannelCount(byte[] bArr) {
        return bArr[9] & 255;
    }

    public static int getPreSkipSamples(List<byte[]> list) {
        if (list.size() == 3) {
            return (int) nanosecondsToSampleCount(ByteBuffer.wrap(list.get(1)).order(ByteOrder.nativeOrder()).getLong());
        }
        return getPreSkipSamples(list.get(0));
    }

    public static int getSeekPreRollSamples(List<byte[]> list) {
        return list.size() == 3 ? (int) nanosecondsToSampleCount(ByteBuffer.wrap(list.get(2)).order(ByteOrder.nativeOrder()).getLong()) : DEFAULT_SEEK_PRE_ROLL_SAMPLES;
    }

    private static long nanosecondsToSampleCount(long j11) {
        return (j11 * 48000) / 1000000000;
    }

    private static long sampleCountToNanoseconds(long j11) {
        return (j11 * 1000000000) / 48000;
    }

    private static int getPreSkipSamples(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }
}
