package com.google.android.exoplayer2.extractor;

import java.io.IOException;

public class ForwardingExtractorInput implements ExtractorInput {
    private final ExtractorInput input;

    public ForwardingExtractorInput(ExtractorInput extractorInput) {
        this.input = extractorInput;
    }

    public boolean advancePeekPosition(int i11, boolean z11) throws IOException {
        return this.input.advancePeekPosition(i11, z11);
    }

    public long getLength() {
        return this.input.getLength();
    }

    public long getPeekPosition() {
        return this.input.getPeekPosition();
    }

    public long getPosition() {
        return this.input.getPosition();
    }

    public int peek(byte[] bArr, int i11, int i12) throws IOException {
        return this.input.peek(bArr, i11, i12);
    }

    public boolean peekFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        return this.input.peekFully(bArr, i11, i12, z11);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        return this.input.read(bArr, i11, i12);
    }

    public boolean readFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        return this.input.readFully(bArr, i11, i12, z11);
    }

    public void resetPeekPosition() {
        this.input.resetPeekPosition();
    }

    public <E extends Throwable> void setRetryPosition(long j11, E e11) throws Throwable {
        this.input.setRetryPosition(j11, e11);
    }

    public int skip(int i11) throws IOException {
        return this.input.skip(i11);
    }

    public boolean skipFully(int i11, boolean z11) throws IOException {
        return this.input.skipFully(i11, z11);
    }

    public void advancePeekPosition(int i11) throws IOException {
        this.input.advancePeekPosition(i11);
    }

    public void peekFully(byte[] bArr, int i11, int i12) throws IOException {
        this.input.peekFully(bArr, i11, i12);
    }

    public void readFully(byte[] bArr, int i11, int i12) throws IOException {
        this.input.readFully(bArr, i11, i12);
    }

    public void skipFully(int i11) throws IOException {
        this.input.skipFully(i11);
    }
}
