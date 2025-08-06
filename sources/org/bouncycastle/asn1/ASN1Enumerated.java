package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class ASN1Enumerated extends ASN1Primitive {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1Enumerated.class, 10) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1Enumerated.createPrimitive(dEROctetString.getOctets(), false);
        }
    };
    private static final ASN1Enumerated[] cache = new ASN1Enumerated[12];
    private final byte[] contents;
    private final int start;

    public ASN1Enumerated(int i11) {
        if (i11 >= 0) {
            this.contents = BigInteger.valueOf((long) i11).toByteArray();
            this.start = 0;
            return;
        }
        throw new IllegalArgumentException("enumerated must be non-negative");
    }

    public ASN1Enumerated(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            this.contents = bigInteger.toByteArray();
            this.start = 0;
            return;
        }
        throw new IllegalArgumentException("enumerated must be non-negative");
    }

    public ASN1Enumerated(byte[] bArr) {
        this(bArr, true);
    }

    public ASN1Enumerated(byte[] bArr, boolean z11) {
        if (ASN1Integer.isMalformed(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        } else if ((bArr[0] & 128) == 0) {
            this.contents = z11 ? Arrays.clone(bArr) : bArr;
            this.start = ASN1Integer.signBytesToSkip(bArr);
        } else {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
    }

    public static ASN1Enumerated createPrimitive(byte[] bArr, boolean z11) {
        if (bArr.length > 1) {
            return new ASN1Enumerated(bArr, z11);
        }
        if (bArr.length != 0) {
            byte b11 = bArr[0] & 255;
            ASN1Enumerated[] aSN1EnumeratedArr = cache;
            if (b11 >= aSN1EnumeratedArr.length) {
                return new ASN1Enumerated(bArr, z11);
            }
            ASN1Enumerated aSN1Enumerated = aSN1EnumeratedArr[b11];
            if (aSN1Enumerated != null) {
                return aSN1Enumerated;
            }
            ASN1Enumerated aSN1Enumerated2 = new ASN1Enumerated(bArr, z11);
            aSN1EnumeratedArr[b11] = aSN1Enumerated2;
            return aSN1Enumerated2;
        }
        throw new IllegalArgumentException("ENUMERATED has zero length");
    }

    public static ASN1Enumerated getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Enumerated)) {
            return (ASN1Enumerated) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1Enumerated) TYPE.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1Enumerated getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1Enumerated) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Enumerated)) {
            return false;
        }
        return Arrays.areEqual(this.contents, ((ASN1Enumerated) aSN1Primitive).contents);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 10, this.contents);
    }

    public boolean encodeConstructed() {
        return false;
    }

    public int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, this.contents.length);
    }

    public BigInteger getValue() {
        return new BigInteger(this.contents);
    }

    public boolean hasValue(int i11) {
        byte[] bArr = this.contents;
        int length = bArr.length;
        int i12 = this.start;
        return length - i12 <= 4 && ASN1Integer.intValue(bArr, i12, -1) == i11;
    }

    public boolean hasValue(BigInteger bigInteger) {
        return bigInteger != null && ASN1Integer.intValue(this.contents, this.start, -1) == bigInteger.intValue() && getValue().equals(bigInteger);
    }

    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public int intValueExact() {
        byte[] bArr = this.contents;
        int length = bArr.length;
        int i11 = this.start;
        if (length - i11 <= 4) {
            return ASN1Integer.intValue(bArr, i11, -1);
        }
        throw new ArithmeticException("ASN.1 Enumerated out of int range");
    }
}
