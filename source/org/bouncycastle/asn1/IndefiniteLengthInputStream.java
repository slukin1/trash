package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class IndefiniteLengthInputStream extends LimitedInputStream {
    private int _b1;
    private int _b2;
    private boolean _eofOn00 = true;
    private boolean _eofReached = false;

    public IndefiniteLengthInputStream(InputStream inputStream, int i11) throws IOException {
        super(inputStream, i11);
        this._b1 = inputStream.read();
        int read = inputStream.read();
        this._b2 = read;
        if (read >= 0) {
            checkForEof();
            return;
        }
        throw new EOFException();
    }

    private boolean checkForEof() {
        if (!this._eofReached && this._eofOn00 && this._b1 == 0 && this._b2 == 0) {
            this._eofReached = true;
            setParentEofDetect(true);
        }
        return this._eofReached;
    }

    public int read() throws IOException {
        if (checkForEof()) {
            return -1;
        }
        int read = this._in.read();
        if (read >= 0) {
            int i11 = this._b1;
            this._b1 = this._b2;
            this._b2 = read;
            return i11;
        }
        throw new EOFException();
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this._eofOn00 || i12 < 3) {
            return super.read(bArr, i11, i12);
        }
        if (this._eofReached) {
            return -1;
        }
        int read = this._in.read(bArr, i11 + 2, i12 - 2);
        if (read >= 0) {
            bArr[i11] = (byte) this._b1;
            bArr[i11 + 1] = (byte) this._b2;
            this._b1 = this._in.read();
            int read2 = this._in.read();
            this._b2 = read2;
            if (read2 >= 0) {
                return read + 2;
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    public void setEofOn00(boolean z11) {
        this._eofOn00 = z11;
        checkForEof();
    }
}
