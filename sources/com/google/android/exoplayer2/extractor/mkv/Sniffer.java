package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    private long readUint(ExtractorInput extractorInput) throws IOException {
        int i11 = 0;
        extractorInput.peekFully(this.scratch.getData(), 0, 1);
        byte b11 = this.scratch.getData()[0] & 255;
        if (b11 == 0) {
            return Long.MIN_VALUE;
        }
        int i12 = 128;
        int i13 = 0;
        while ((b11 & i12) == 0) {
            i12 >>= 1;
            i13++;
        }
        int i14 = b11 & (~i12);
        extractorInput.peekFully(this.scratch.getData(), 1, i13);
        while (i11 < i13) {
            i11++;
            i14 = (this.scratch.getData()[i11] & 255) + (i14 << 8);
        }
        this.peekLength += i13 + 1;
        return (long) i14;
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        long readUint;
        int i11;
        long length = extractorInput.getLength();
        int i12 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        long j11 = 1024;
        if (i12 != 0 && length <= 1024) {
            j11 = length;
        }
        int i13 = (int) j11;
        extractorInput.peekFully(this.scratch.getData(), 0, 4);
        long readUnsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (readUnsignedInt != 440786851) {
            int i14 = this.peekLength + 1;
            this.peekLength = i14;
            if (i14 == i13) {
                return false;
            }
            extractorInput.peekFully(this.scratch.getData(), 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & -256) | ((long) (this.scratch.getData()[0] & 255));
        }
        long readUint2 = readUint(extractorInput);
        long j12 = (long) this.peekLength;
        if (readUint2 == Long.MIN_VALUE) {
            return false;
        }
        if (i12 != 0 && j12 + readUint2 >= length) {
            return false;
        }
        while (true) {
            int i15 = this.peekLength;
            long j13 = j12 + readUint2;
            if (((long) i15) < j13) {
                if (readUint(extractorInput) != Long.MIN_VALUE && readUint >= 0 && readUint <= 2147483647L) {
                    if (i11 != 0) {
                        int readUint3 = (int) (readUint = readUint(extractorInput));
                        extractorInput.advancePeekPosition(readUint3);
                        this.peekLength += readUint3;
                    }
                }
            } else if (((long) i15) == j13) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
