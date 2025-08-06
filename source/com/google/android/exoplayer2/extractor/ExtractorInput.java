package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;

public interface ExtractorInput extends DataReader {
    void advancePeekPosition(int i11) throws IOException;

    boolean advancePeekPosition(int i11, boolean z11) throws IOException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    int peek(byte[] bArr, int i11, int i12) throws IOException;

    void peekFully(byte[] bArr, int i11, int i12) throws IOException;

    boolean peekFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException;

    int read(byte[] bArr, int i11, int i12) throws IOException;

    void readFully(byte[] bArr, int i11, int i12) throws IOException;

    boolean readFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException;

    void resetPeekPosition();

    <E extends Throwable> void setRetryPosition(long j11, E e11) throws Throwable;

    int skip(int i11) throws IOException;

    void skipFully(int i11) throws IOException;

    boolean skipFully(int i11, boolean z11) throws IOException;
}
