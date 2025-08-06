package org.bouncycastle.asn1;

import java.io.InputStream;

abstract class LimitedInputStream extends InputStream {
    public final InputStream _in;
    private int _limit;

    public LimitedInputStream(InputStream inputStream, int i11) {
        this._in = inputStream;
        this._limit = i11;
    }

    public int getLimit() {
        return this._limit;
    }

    public void setParentEofDetect(boolean z11) {
        InputStream inputStream = this._in;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) inputStream).setEofOn00(z11);
        }
    }
}
