package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class BEROctetString extends ASN1OctetString {
    private static final int DEFAULT_SEGMENT_LIMIT = 1000;
    /* access modifiers changed from: private */
    public final ASN1OctetString[] elements;
    /* access modifiers changed from: private */
    public final int segmentLimit;

    public BEROctetString(byte[] bArr) {
        this(bArr, 1000);
    }

    public BEROctetString(byte[] bArr, int i11) {
        this(bArr, (ASN1OctetString[]) null, i11);
    }

    private BEROctetString(byte[] bArr, ASN1OctetString[] aSN1OctetStringArr, int i11) {
        super(bArr);
        this.elements = aSN1OctetStringArr;
        this.segmentLimit = i11;
    }

    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr) {
        this(aSN1OctetStringArr, 1000);
    }

    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr, int i11) {
        this(flattenOctetStrings(aSN1OctetStringArr), aSN1OctetStringArr, i11);
    }

    public static byte[] flattenOctetStrings(ASN1OctetString[] aSN1OctetStringArr) {
        if (r0 == 0) {
            return ASN1OctetString.EMPTY_OCTETS;
        }
        if (r0 == 1) {
            return aSN1OctetStringArr[0].string;
        }
        int i11 = 0;
        for (ASN1OctetString aSN1OctetString : aSN1OctetStringArr) {
            i11 += aSN1OctetString.string.length;
        }
        byte[] bArr = new byte[i11];
        int i12 = 0;
        for (ASN1OctetString aSN1OctetString2 : aSN1OctetStringArr) {
            byte[] bArr2 = aSN1OctetString2.string;
            System.arraycopy(bArr2, 0, bArr, i12, bArr2.length);
            i12 += bArr2.length;
        }
        return bArr;
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        if (!encodeConstructed()) {
            byte[] bArr = this.string;
            DEROctetString.encode(aSN1OutputStream, z11, bArr, 0, bArr.length);
            return;
        }
        aSN1OutputStream.writeIdentifier(z11, 36);
        aSN1OutputStream.write(128);
        ASN1OctetString[] aSN1OctetStringArr = this.elements;
        if (aSN1OctetStringArr == null) {
            int i11 = 0;
            while (true) {
                byte[] bArr2 = this.string;
                if (i11 >= bArr2.length) {
                    break;
                }
                int min = Math.min(bArr2.length - i11, this.segmentLimit);
                DEROctetString.encode(aSN1OutputStream, true, this.string, i11, min);
                i11 += min;
            }
        } else {
            aSN1OutputStream.writePrimitives(aSN1OctetStringArr);
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    public boolean encodeConstructed() {
        return this.elements != null || this.string.length > this.segmentLimit;
    }

    public int encodedLength(boolean z11) throws IOException {
        if (!encodeConstructed()) {
            return DEROctetString.encodedLength(z11, this.string.length);
        }
        int i11 = z11 ? 4 : 3;
        if (this.elements != null) {
            int i12 = 0;
            while (true) {
                ASN1OctetString[] aSN1OctetStringArr = this.elements;
                if (i12 >= aSN1OctetStringArr.length) {
                    return i11;
                }
                i11 += aSN1OctetStringArr[i12].encodedLength(true);
                i12++;
            }
        } else {
            int length = this.string.length;
            int i13 = this.segmentLimit;
            int i14 = length / i13;
            int encodedLength = i11 + (DEROctetString.encodedLength(true, i13) * i14);
            int length2 = this.string.length - (i14 * this.segmentLimit);
            return length2 > 0 ? encodedLength + DEROctetString.encodedLength(true, length2) : encodedLength;
        }
    }

    public Enumeration getObjects() {
        return this.elements == null ? new Enumeration() {
            public int pos = 0;

            public boolean hasMoreElements() {
                return this.pos < BEROctetString.this.string.length;
            }

            public Object nextElement() {
                int i11 = this.pos;
                BEROctetString bEROctetString = BEROctetString.this;
                byte[] bArr = bEROctetString.string;
                if (i11 < bArr.length) {
                    int min = Math.min(bArr.length - i11, bEROctetString.segmentLimit);
                    byte[] bArr2 = new byte[min];
                    System.arraycopy(BEROctetString.this.string, this.pos, bArr2, 0, min);
                    this.pos += min;
                    return new DEROctetString(bArr2);
                }
                throw new NoSuchElementException();
            }
        } : new Enumeration() {
            public int counter = 0;

            public boolean hasMoreElements() {
                return this.counter < BEROctetString.this.elements.length;
            }

            public Object nextElement() {
                if (this.counter < BEROctetString.this.elements.length) {
                    ASN1OctetString[] access$100 = BEROctetString.this.elements;
                    int i11 = this.counter;
                    this.counter = i11 + 1;
                    return access$100[i11];
                }
                throw new NoSuchElementException();
            }
        };
    }
}
