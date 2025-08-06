package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

class DefiniteLengthInputStream extends LimitedInputStream {
    private static final byte[] EMPTY_BYTES = new byte[0];
    private final int _originalLength;
    private int _remaining;

    public DefiniteLengthInputStream(InputStream inputStream, int i11, int i12) {
        super(inputStream, i12);
        if (i11 <= 0) {
            if (i11 >= 0) {
                setParentEofDetect(true);
            } else {
                throw new IllegalArgumentException("negative lengths not allowed");
            }
        }
        this._originalLength = i11;
        this._remaining = i11;
    }

    public int getRemaining() {
        return this._remaining;
    }

    public int read() throws IOException {
        if (this._remaining == 0) {
            return -1;
        }
        int read = this._in.read();
        if (read >= 0) {
            int i11 = this._remaining - 1;
            this._remaining = i11;
            if (i11 == 0) {
                setParentEofDetect(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = this._remaining;
        if (i13 == 0) {
            return -1;
        }
        int read = this._in.read(bArr, i11, Math.min(i12, i13));
        if (read >= 0) {
            int i14 = this._remaining - read;
            this._remaining = i14;
            if (i14 == 0) {
                setParentEofDetect(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    public void readAllIntoByteArray(byte[] bArr) throws IOException {
        int i11 = this._remaining;
        if (i11 != bArr.length) {
            throw new IllegalArgumentException("buffer length not right for data");
        } else if (i11 != 0) {
            int limit = getLimit();
            int i12 = this._remaining;
            if (i12 < limit) {
                int readFully = i12 - Streams.readFully(this._in, bArr, 0, bArr.length);
                this._remaining = readFully;
                if (readFully == 0) {
                    setParentEofDetect(true);
                    return;
                }
                throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
            }
            throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + limit);
        }
    }

    public byte[] toByteArray() throws IOException {
        if (this._remaining == 0) {
            return EMPTY_BYTES;
        }
        int limit = getLimit();
        int i11 = this._remaining;
        if (i11 < limit) {
            byte[] bArr = new byte[i11];
            int readFully = i11 - Streams.readFully(this._in, bArr, 0, i11);
            this._remaining = readFully;
            if (readFully == 0) {
                setParentEofDetect(true);
                return bArr;
            }
            throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
        }
        throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + limit);
    }
}
