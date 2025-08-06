package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ForwardingExtractorInput;
import com.google.android.exoplayer2.util.Assertions;

final class StartOffsetExtractorInput extends ForwardingExtractorInput {
    private final long startOffset;

    public StartOffsetExtractorInput(ExtractorInput extractorInput, long j11) {
        super(extractorInput);
        Assertions.checkArgument(extractorInput.getPosition() >= j11);
        this.startOffset = j11;
    }

    public long getLength() {
        return super.getLength() - this.startOffset;
    }

    public long getPeekPosition() {
        return super.getPeekPosition() - this.startOffset;
    }

    public long getPosition() {
        return super.getPosition() - this.startOffset;
    }

    public <E extends Throwable> void setRetryPosition(long j11, E e11) throws Throwable {
        super.setRetryPosition(j11 + this.startOffset, e11);
    }
}
