package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class WavHeaderReader {
    private static final String TAG = "WavHeaderReader";

    public static final class ChunkHeader {
        public static final int SIZE_IN_BYTES = 8;

        /* renamed from: id  reason: collision with root package name */
        public final int f65908id;
        public final long size;

        private ChunkHeader(int i11, long j11) {
            this.f65908id = i11;
            this.size = j11;
        }

        public static ChunkHeader peek(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
            extractorInput.peekFully(parsableByteArray.getData(), 0, 8);
            parsableByteArray.setPosition(0);
            return new ChunkHeader(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
        }
    }

    private WavHeaderReader() {
    }

    public static WavHeader peek(ExtractorInput extractorInput) throws IOException {
        byte[] bArr;
        Assertions.checkNotNull(extractorInput);
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        if (ChunkHeader.peek(extractorInput, parsableByteArray).f65908id != 1380533830) {
            return null;
        }
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        parsableByteArray.setPosition(0);
        int readInt = parsableByteArray.readInt();
        if (readInt != 1463899717) {
            StringBuilder sb2 = new StringBuilder(36);
            sb2.append("Unsupported RIFF format: ");
            sb2.append(readInt);
            Log.e(TAG, sb2.toString());
            return null;
        }
        ChunkHeader peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (peek.f65908id != 1718449184) {
            extractorInput.advancePeekPosition((int) peek.size);
            peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        }
        Assertions.checkState(peek.size >= 16);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 16);
        parsableByteArray.setPosition(0);
        int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
        int i11 = ((int) peek.size) - 16;
        if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            extractorInput.peekFully(bArr2, 0, i11);
            bArr = bArr2;
        } else {
            bArr = Util.EMPTY_BYTE_ARRAY;
        }
        return new WavHeader(readLittleEndianUnsignedShort, readLittleEndianUnsignedShort2, readLittleEndianUnsignedIntToInt, readLittleEndianUnsignedIntToInt2, readLittleEndianUnsignedShort3, readLittleEndianUnsignedShort4, bArr);
    }

    public static Pair<Long, Long> skipToData(ExtractorInput extractorInput) throws IOException {
        Assertions.checkNotNull(extractorInput);
        extractorInput.resetPeekPosition();
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (true) {
            int i11 = peek.f65908id;
            if (i11 != 1684108385) {
                if (!(i11 == 1380533830 || i11 == 1718449184)) {
                    StringBuilder sb2 = new StringBuilder(39);
                    sb2.append("Ignoring unknown WAV chunk: ");
                    sb2.append(i11);
                    Log.w(TAG, sb2.toString());
                }
                long j11 = peek.size + 8;
                if (peek.f65908id == 1380533830) {
                    j11 = 12;
                }
                if (j11 <= 2147483647L) {
                    extractorInput.skipFully((int) j11);
                    peek = ChunkHeader.peek(extractorInput, parsableByteArray);
                } else {
                    int i12 = peek.f65908id;
                    StringBuilder sb3 = new StringBuilder(51);
                    sb3.append("Chunk is too large (~2GB+) to skip; id: ");
                    sb3.append(i12);
                    throw new ParserException(sb3.toString());
                }
            } else {
                extractorInput.skipFully(8);
                long position = extractorInput.getPosition();
                long j12 = peek.size + position;
                long length = extractorInput.getLength();
                if (length != -1 && j12 > length) {
                    StringBuilder sb4 = new StringBuilder(69);
                    sb4.append("Data exceeds input length: ");
                    sb4.append(j12);
                    sb4.append(", ");
                    sb4.append(length);
                    Log.w(TAG, sb4.toString());
                    j12 = length;
                }
                return Pair.create(Long.valueOf(position), Long.valueOf(j12));
            }
        }
    }
}
