package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class FlacFrameReader {

    public static final class SampleNumberHolder {
        public long sampleNumber;
    }

    private FlacFrameReader() {
    }

    private static boolean checkAndReadBlockSizeSamples(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i11) {
        int readFrameBlockSizeSamplesFromKey = readFrameBlockSizeSamplesFromKey(parsableByteArray, i11);
        return readFrameBlockSizeSamplesFromKey != -1 && readFrameBlockSizeSamplesFromKey <= flacStreamMetadata.maxBlockSizeSamples;
    }

    private static boolean checkAndReadCrc(ParsableByteArray parsableByteArray, int i11) {
        return parsableByteArray.readUnsignedByte() == Util.crc8(parsableByteArray.getData(), i11, parsableByteArray.getPosition() - 1, 0);
    }

    private static boolean checkAndReadFirstSampleNumber(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean z11, SampleNumberHolder sampleNumberHolder) {
        try {
            long readUtf8EncodedLong = parsableByteArray.readUtf8EncodedLong();
            if (!z11) {
                readUtf8EncodedLong *= (long) flacStreamMetadata.maxBlockSizeSamples;
            }
            sampleNumberHolder.sampleNumber = readUtf8EncodedLong;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean checkAndReadFrameHeader(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i11, SampleNumberHolder sampleNumberHolder) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        FlacStreamMetadata flacStreamMetadata2 = flacStreamMetadata;
        int position = parsableByteArray.getPosition();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long j11 = readUnsignedInt >>> 16;
        if (j11 != ((long) i11)) {
            return false;
        }
        boolean z11 = (j11 & 1) == 1;
        int i12 = (int) ((readUnsignedInt >> 12) & 15);
        int i13 = (int) ((readUnsignedInt >> 8) & 15);
        int i14 = (int) ((readUnsignedInt >> 4) & 15);
        int i15 = (int) ((readUnsignedInt >> 1) & 7);
        boolean z12 = (readUnsignedInt & 1) == 1;
        if (!checkChannelAssignment(i14, flacStreamMetadata2) || !checkBitsPerSample(i15, flacStreamMetadata2) || z12 || !checkAndReadFirstSampleNumber(parsableByteArray2, flacStreamMetadata2, z11, sampleNumberHolder) || !checkAndReadBlockSizeSamples(parsableByteArray2, flacStreamMetadata2, i12) || !checkAndReadSampleRate(parsableByteArray2, flacStreamMetadata2, i13) || !checkAndReadCrc(parsableByteArray2, position)) {
            return false;
        }
        return true;
    }

    private static boolean checkAndReadSampleRate(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i11) {
        int i12 = flacStreamMetadata.sampleRate;
        if (i11 == 0) {
            return true;
        }
        if (i11 <= 11) {
            if (i11 == flacStreamMetadata.sampleRateLookupKey) {
                return true;
            }
            return false;
        } else if (i11 == 12) {
            if (parsableByteArray.readUnsignedByte() * 1000 == i12) {
                return true;
            }
            return false;
        } else if (i11 > 14) {
            return false;
        } else {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            if (i11 == 14) {
                readUnsignedShort *= 10;
            }
            if (readUnsignedShort == i12) {
                return true;
            }
            return false;
        }
    }

    private static boolean checkBitsPerSample(int i11, FlacStreamMetadata flacStreamMetadata) {
        return i11 == 0 || i11 == flacStreamMetadata.bitsPerSampleLookupKey;
    }

    private static boolean checkChannelAssignment(int i11, FlacStreamMetadata flacStreamMetadata) {
        if (i11 <= 7) {
            return i11 == flacStreamMetadata.channels - 1;
        }
        if (i11 > 10 || flacStreamMetadata.channels != 2) {
            return false;
        }
        return true;
    }

    public static boolean checkFrameHeaderFromPeek(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata, int i11, SampleNumberHolder sampleNumberHolder) throws IOException {
        long peekPosition = extractorInput.getPeekPosition();
        byte[] bArr = new byte[2];
        extractorInput.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i11) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy(bArr, 0, parsableByteArray.getData(), 0, 2);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.getData(), 2, 14));
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
        return checkAndReadFrameHeader(parsableByteArray, flacStreamMetadata, i11, sampleNumberHolder);
    }

    public static long getFirstSampleNumber(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata) throws IOException {
        extractorInput.resetPeekPosition();
        boolean z11 = true;
        extractorInput.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        extractorInput.peekFully(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z11 = false;
        }
        extractorInput.advancePeekPosition(2);
        int i11 = z11 ? 7 : 6;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i11);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.getData(), 0, i11));
        extractorInput.resetPeekPosition();
        SampleNumberHolder sampleNumberHolder = new SampleNumberHolder();
        if (checkAndReadFirstSampleNumber(parsableByteArray, flacStreamMetadata, z11, sampleNumberHolder)) {
            return sampleNumberHolder.sampleNumber;
        }
        throw new ParserException();
    }

    public static int readFrameBlockSizeSamplesFromKey(ParsableByteArray parsableByteArray, int i11) {
        switch (i11) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i11 - 2);
            case 6:
                return parsableByteArray.readUnsignedByte() + 1;
            case 7:
                return parsableByteArray.readUnsignedShort() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i11 - 8);
            default:
                return -1;
        }
    }
}
