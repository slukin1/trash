package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

final class OggPageHeader {
    private static final int CAPTURE_PATTERN = 1332176723;
    private static final int CAPTURE_PATTERN_SIZE = 4;
    public static final int EMPTY_PAGE_HEADER_SIZE = 27;
    public static final int MAX_PAGE_PAYLOAD = 65025;
    public static final int MAX_PAGE_SIZE = 65307;
    public static final int MAX_SEGMENT_COUNT = 255;
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public final int[] laces = new int[255];
    public long pageChecksum;
    public int pageSegmentCount;
    public long pageSequenceNumber;
    public int revision;
    private final ParsableByteArray scratch = new ParsableByteArray(255);
    public long streamSerialNumber;
    public int type;

    private static boolean peekSafely(ExtractorInput extractorInput, byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        try {
            return extractorInput.peekFully(bArr, i11, i12, z11);
        } catch (EOFException e11) {
            if (z11) {
                return false;
            }
            throw e11;
        }
    }

    public boolean populate(ExtractorInput extractorInput, boolean z11) throws IOException {
        reset();
        this.scratch.reset(27);
        if (!peekSafely(extractorInput, this.scratch.getData(), 0, 27, z11) || this.scratch.readUnsignedInt() != 1332176723) {
            return false;
        }
        int readUnsignedByte = this.scratch.readUnsignedByte();
        this.revision = readUnsignedByte;
        if (readUnsignedByte == 0) {
            this.type = this.scratch.readUnsignedByte();
            this.granulePosition = this.scratch.readLittleEndianLong();
            this.streamSerialNumber = this.scratch.readLittleEndianUnsignedInt();
            this.pageSequenceNumber = this.scratch.readLittleEndianUnsignedInt();
            this.pageChecksum = this.scratch.readLittleEndianUnsignedInt();
            int readUnsignedByte2 = this.scratch.readUnsignedByte();
            this.pageSegmentCount = readUnsignedByte2;
            this.headerSize = readUnsignedByte2 + 27;
            this.scratch.reset(readUnsignedByte2);
            extractorInput.peekFully(this.scratch.getData(), 0, this.pageSegmentCount);
            for (int i11 = 0; i11 < this.pageSegmentCount; i11++) {
                this.laces[i11] = this.scratch.readUnsignedByte();
                this.bodySize += this.laces[i11];
            }
            return true;
        } else if (z11) {
            return false;
        } else {
            throw new ParserException("unsupported bit stream revision");
        }
    }

    public void reset() {
        this.revision = 0;
        this.type = 0;
        this.granulePosition = 0;
        this.streamSerialNumber = 0;
        this.pageSequenceNumber = 0;
        this.pageChecksum = 0;
        this.pageSegmentCount = 0;
        this.headerSize = 0;
        this.bodySize = 0;
    }

    public boolean skipToNextPage(ExtractorInput extractorInput) throws IOException {
        return skipToNextPage(extractorInput, -1);
    }

    public boolean skipToNextPage(ExtractorInput extractorInput, long j11) throws IOException {
        int i11;
        Assertions.checkArgument(extractorInput.getPosition() == extractorInput.getPeekPosition());
        this.scratch.reset(4);
        while (true) {
            i11 = (j11 > -1 ? 1 : (j11 == -1 ? 0 : -1));
            if ((i11 == 0 || extractorInput.getPosition() + 4 < j11) && peekSafely(extractorInput, this.scratch.getData(), 0, 4, true)) {
                this.scratch.setPosition(0);
                if (this.scratch.readUnsignedInt() == 1332176723) {
                    extractorInput.resetPeekPosition();
                    return true;
                }
                extractorInput.skipFully(1);
            }
        }
        do {
            if ((i11 != 0 && extractorInput.getPosition() >= j11) || extractorInput.skip(1) == -1) {
                return false;
            }
            break;
        } while (extractorInput.skip(1) == -1);
        return false;
    }
}
