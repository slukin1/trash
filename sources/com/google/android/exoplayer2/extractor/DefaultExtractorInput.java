package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class DefaultExtractorInput implements ExtractorInput {
    private static final int PEEK_MAX_FREE_SPACE = 524288;
    private static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 65536;
    private static final int SCRATCH_SPACE_SIZE = 4096;
    private final DataReader dataReader;
    private byte[] peekBuffer = new byte[65536];
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final byte[] scratchSpace = new byte[4096];
    private final long streamLength;

    public DefaultExtractorInput(DataReader dataReader2, long j11, long j12) {
        this.dataReader = dataReader2;
        this.position = j11;
        this.streamLength = j12;
    }

    private void commitBytesRead(int i11) {
        if (i11 != -1) {
            this.position += (long) i11;
        }
    }

    private void ensureSpaceForPeek(int i11) {
        int i12 = this.peekBufferPosition + i11;
        byte[] bArr = this.peekBuffer;
        if (i12 > bArr.length) {
            this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i12, i12 + 524288));
        }
    }

    private int readFromPeekBuffer(byte[] bArr, int i11, int i12) {
        int i13 = this.peekBufferLength;
        if (i13 == 0) {
            return 0;
        }
        int min = Math.min(i13, i12);
        System.arraycopy(this.peekBuffer, 0, bArr, i11, min);
        updatePeekBuffer(min);
        return min;
    }

    private int readFromUpstream(byte[] bArr, int i11, int i12, int i13, boolean z11) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.dataReader.read(bArr, i11 + i13, i12 - i13);
            if (read != -1) {
                return i13 + read;
            }
            if (i13 == 0 && z11) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    private int skipFromPeekBuffer(int i11) {
        int min = Math.min(this.peekBufferLength, i11);
        updatePeekBuffer(min);
        return min;
    }

    private void updatePeekBuffer(int i11) {
        int i12 = this.peekBufferLength - i11;
        this.peekBufferLength = i12;
        this.peekBufferPosition = 0;
        byte[] bArr = this.peekBuffer;
        byte[] bArr2 = i12 < bArr.length - 524288 ? new byte[(65536 + i12)] : bArr;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        this.peekBuffer = bArr2;
    }

    public boolean advancePeekPosition(int i11, boolean z11) throws IOException {
        ensureSpaceForPeek(i11);
        int i12 = this.peekBufferLength - this.peekBufferPosition;
        while (i12 < i11) {
            i12 = readFromUpstream(this.peekBuffer, this.peekBufferPosition, i11, i12, z11);
            if (i12 == -1) {
                return false;
            }
            this.peekBufferLength = this.peekBufferPosition + i12;
        }
        this.peekBufferPosition += i11;
        return true;
    }

    public long getLength() {
        return this.streamLength;
    }

    public long getPeekPosition() {
        return this.position + ((long) this.peekBufferPosition);
    }

    public long getPosition() {
        return this.position;
    }

    public int peek(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        ensureSpaceForPeek(i12);
        int i14 = this.peekBufferLength;
        int i15 = this.peekBufferPosition;
        int i16 = i14 - i15;
        if (i16 == 0) {
            i13 = readFromUpstream(this.peekBuffer, i15, i12, 0, true);
            if (i13 == -1) {
                return -1;
            }
            this.peekBufferLength += i13;
        } else {
            i13 = Math.min(i12, i16);
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition, bArr, i11, i13);
        this.peekBufferPosition += i13;
        return i13;
    }

    public boolean peekFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        if (!advancePeekPosition(i12, z11)) {
            return false;
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition - i12, bArr, i11, i12);
        return true;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i11, i12);
        if (readFromPeekBuffer == 0) {
            readFromPeekBuffer = readFromUpstream(bArr, i11, i12, 0, true);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer;
    }

    public boolean readFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i11, i12);
        while (readFromPeekBuffer < i12 && readFromPeekBuffer != -1) {
            readFromPeekBuffer = readFromUpstream(bArr, i11, i12, readFromPeekBuffer, z11);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer != -1;
    }

    public void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    public <E extends Throwable> void setRetryPosition(long j11, E e11) throws Throwable {
        Assertions.checkArgument(j11 >= 0);
        this.position = j11;
        throw e11;
    }

    public int skip(int i11) throws IOException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i11);
        if (skipFromPeekBuffer == 0) {
            byte[] bArr = this.scratchSpace;
            skipFromPeekBuffer = readFromUpstream(bArr, 0, Math.min(i11, bArr.length), 0, true);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer;
    }

    public boolean skipFully(int i11, boolean z11) throws IOException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i11);
        while (skipFromPeekBuffer < i11 && skipFromPeekBuffer != -1) {
            skipFromPeekBuffer = readFromUpstream(this.scratchSpace, -skipFromPeekBuffer, Math.min(i11, this.scratchSpace.length + skipFromPeekBuffer), skipFromPeekBuffer, z11);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer != -1;
    }

    public void peekFully(byte[] bArr, int i11, int i12) throws IOException {
        peekFully(bArr, i11, i12, false);
    }

    public void readFully(byte[] bArr, int i11, int i12) throws IOException {
        readFully(bArr, i11, i12, false);
    }

    public void skipFully(int i11) throws IOException {
        skipFully(i11, false);
    }

    public void advancePeekPosition(int i11) throws IOException {
        advancePeekPosition(i11, false);
    }
}
