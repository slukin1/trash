package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public abstract class BERGenerator extends ASN1Generator {
    private boolean _isExplicit;
    private int _tagNo;
    private boolean _tagged;

    public BERGenerator(OutputStream outputStream) {
        super(outputStream);
        this._tagged = false;
    }

    public BERGenerator(OutputStream outputStream, int i11, boolean z11) {
        super(outputStream);
        this._tagged = false;
        this._tagged = true;
        this._isExplicit = z11;
        this._tagNo = i11;
    }

    private void writeHdr(int i11) throws IOException {
        this._out.write(i11);
        this._out.write(128);
    }

    public OutputStream getRawOutputStream() {
        return this._out;
    }

    public void writeBEREnd() throws IOException {
        this._out.write(0);
        this._out.write(0);
        if (this._tagged && this._isExplicit) {
            this._out.write(0);
            this._out.write(0);
        }
    }

    public void writeBERHeader(int i11) throws IOException {
        if (this._tagged) {
            int i12 = this._tagNo | 128;
            if (this._isExplicit) {
                writeHdr(i12 | 32);
            } else if ((i11 & 32) != 0) {
                i11 = i12 | 32;
            } else {
                writeHdr(i12);
                return;
            }
        }
        writeHdr(i11);
    }
}
