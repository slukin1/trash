package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class BEROctetStringGenerator extends BERGenerator {

    public class BufferedBEROctetStream extends OutputStream {
        private byte[] _buf;
        private DEROutputStream _derOut;
        private int _off = 0;

        public BufferedBEROctetStream(byte[] bArr) {
            this._buf = bArr;
            this._derOut = new DEROutputStream(BEROctetStringGenerator.this._out);
        }

        public void close() throws IOException {
            int i11 = this._off;
            if (i11 != 0) {
                DEROctetString.encode(this._derOut, true, this._buf, 0, i11);
            }
            this._derOut.flushInternal();
            BEROctetStringGenerator.this.writeBEREnd();
        }

        public void write(int i11) throws IOException {
            byte[] bArr = this._buf;
            int i12 = this._off;
            int i13 = i12 + 1;
            this._off = i13;
            bArr[i12] = (byte) i11;
            if (i13 == bArr.length) {
                DEROctetString.encode(this._derOut, true, bArr, 0, bArr.length);
                this._off = 0;
            }
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            int i13;
            byte[] bArr2 = this._buf;
            int length = bArr2.length;
            int i14 = this._off;
            int i15 = length - i14;
            if (i12 < i15) {
                System.arraycopy(bArr, i11, bArr2, i14, i12);
                this._off += i12;
                return;
            }
            if (i14 > 0) {
                System.arraycopy(bArr, i11, bArr2, i14, i15);
                i13 = i15 + 0;
                DEROctetString.encode(this._derOut, true, this._buf, 0, length);
            } else {
                i13 = 0;
            }
            while (true) {
                int i16 = i12 - i13;
                if (i16 >= length) {
                    DEROctetString.encode(this._derOut, true, bArr, i11 + i13, length);
                    i13 += length;
                } else {
                    System.arraycopy(bArr, i11 + i13, this._buf, 0, i16);
                    this._off = i16;
                    return;
                }
            }
        }
    }

    public BEROctetStringGenerator(OutputStream outputStream) throws IOException {
        super(outputStream);
        writeBERHeader(36);
    }

    public BEROctetStringGenerator(OutputStream outputStream, int i11, boolean z11) throws IOException {
        super(outputStream, i11, z11);
        writeBERHeader(36);
    }

    public OutputStream getOctetOutputStream() {
        return getOctetOutputStream(new byte[1000]);
    }

    public OutputStream getOctetOutputStream(byte[] bArr) {
        return new BufferedBEROctetStream(bArr);
    }
}
