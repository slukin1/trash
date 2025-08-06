package org.bouncycastle.asn1;

import com.sumsub.sns.internal.core.common.n0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.bouncycastle.util.Arrays;

public abstract class ASN1BitString extends ASN1Primitive implements ASN1String, ASN1BitStringParser {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1BitString.class, 3) {
        public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
            return aSN1Sequence.toASN1BitString();
        }

        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1BitString.createPrimitive(dEROctetString.getOctets());
        }
    };
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final byte[] contents;

    public ASN1BitString(byte b11, int i11) {
        if (i11 > 7 || i11 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.contents = new byte[]{(byte) i11, b11};
    }

    public ASN1BitString(byte[] bArr, int i11) {
        Objects.requireNonNull(bArr, "'data' cannot be null");
        if (bArr.length == 0 && i11 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        } else if (i11 > 7 || i11 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        } else {
            this.contents = Arrays.prepend(bArr, (byte) i11);
        }
    }

    public ASN1BitString(byte[] bArr, boolean z11) {
        if (z11) {
            Objects.requireNonNull(bArr, "'contents' cannot be null");
            if (bArr.length >= 1) {
                byte b11 = bArr[0] & 255;
                if (b11 > 0) {
                    if (bArr.length < 2) {
                        throw new IllegalArgumentException("zero length data with non-zero pad bits");
                    } else if (b11 > 7) {
                        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                    }
                }
            } else {
                throw new IllegalArgumentException("'contents' cannot be empty");
            }
        }
        this.contents = bArr;
    }

    public static ASN1BitString createPrimitive(byte[] bArr) {
        int length = bArr.length;
        if (length >= 1) {
            byte b11 = bArr[0] & 255;
            if (b11 > 0) {
                if (b11 > 7 || length < 2) {
                    throw new IllegalArgumentException("invalid pad bits detected");
                }
                byte b12 = bArr[length - 1];
                if (b12 != ((byte) ((255 << b11) & b12))) {
                    return new DLBitString(bArr, false);
                }
            }
            return new DERBitString(bArr, false);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    public static byte[] getBytes(int i11) {
        if (i11 == 0) {
            return new byte[0];
        }
        int i12 = 4;
        int i13 = 3;
        while (i13 >= 1 && ((255 << (i13 * 8)) & i11) == 0) {
            i12--;
            i13--;
        }
        byte[] bArr = new byte[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            bArr[i14] = (byte) ((i11 >> (i14 * 8)) & 255);
        }
        return bArr;
    }

    public static ASN1BitString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1BitString)) {
            return (ASN1BitString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1BitString) {
                return (ASN1BitString) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (ASN1BitString) TYPE.fromByteArray((byte[]) obj);
            } catch (IOException e11) {
                throw new IllegalArgumentException("failed to construct BIT STRING from byte[]: " + e11.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1BitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1BitString) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    public static int getPadBits(int i11) {
        int i12;
        int i13 = 3;
        while (true) {
            if (i13 < 0) {
                i12 = 0;
                break;
            }
            if (i13 != 0) {
                int i14 = i11 >> (i13 * 8);
                if (i14 != 0) {
                    i12 = i14 & 255;
                    break;
                }
            } else if (i11 != 0) {
                i12 = i11 & 255;
                break;
            }
            i13--;
        }
        if (i12 == 0) {
            return 0;
        }
        int i15 = 1;
        while (true) {
            i12 <<= 1;
            if ((i12 & 255) == 0) {
                return 8 - i15;
            }
            i15++;
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1BitString)) {
            return false;
        }
        byte[] bArr = this.contents;
        byte[] bArr2 = ((ASN1BitString) aSN1Primitive).contents;
        int length = bArr.length;
        if (bArr2.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i11 = length - 1;
        for (int i12 = 0; i12 < i11; i12++) {
            if (bArr[i12] != bArr2[i12]) {
                return false;
            }
        }
        int i13 = 255 << (bArr[0] & 255);
        return ((byte) (bArr[i11] & i13)) == ((byte) (bArr2[i11] & i13));
    }

    public InputStream getBitStream() throws IOException {
        byte[] bArr = this.contents;
        return new ByteArrayInputStream(bArr, 1, bArr.length - 1);
    }

    public byte[] getBytes() {
        byte[] bArr = this.contents;
        if (bArr.length == 1) {
            return ASN1OctetString.EMPTY_OCTETS;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, bArr.length);
        int length = copyOfRange.length - 1;
        copyOfRange[length] = (byte) (((byte) (255 << (bArr[0] & 255))) & copyOfRange[length]);
        return copyOfRange;
    }

    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    public InputStream getOctetStream() throws IOException {
        byte b11 = this.contents[0] & 255;
        if (b11 == 0) {
            return getBitStream();
        }
        throw new IOException("expected octet-aligned bitstring, but found padBits: " + b11);
    }

    public byte[] getOctets() {
        byte[] bArr = this.contents;
        if (bArr[0] == 0) {
            return Arrays.copyOfRange(bArr, 1, bArr.length);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public int getPadBits() {
        return this.contents[0] & 255;
    }

    public String getString() {
        try {
            byte[] encoded = getEncoded();
            StringBuffer stringBuffer = new StringBuffer((encoded.length * 2) + 1);
            stringBuffer.append(n0.h.f32179b);
            for (int i11 = 0; i11 != encoded.length; i11++) {
                byte b11 = encoded[i11];
                char[] cArr = table;
                stringBuffer.append(cArr[(b11 >>> 4) & 15]);
                stringBuffer.append(cArr[b11 & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e11) {
            throw new ASN1ParsingException("Internal error encoding BitString: " + e11.getMessage(), e11);
        }
    }

    public int hashCode() {
        byte[] bArr = this.contents;
        if (bArr.length < 2) {
            return 1;
        }
        int length = bArr.length - 1;
        return (Arrays.hashCode(bArr, 0, length) * 257) ^ ((byte) (bArr[length] & (255 << (bArr[0] & 255))));
    }

    public int intValue() {
        int min = Math.min(5, this.contents.length - 1);
        int i11 = 0;
        for (int i12 = 1; i12 < min; i12++) {
            i11 |= (255 & this.contents[i12]) << ((i12 - 1) * 8);
        }
        if (1 > min || min >= 5) {
            return i11;
        }
        byte[] bArr = this.contents;
        return i11 | ((((byte) (bArr[min] & (255 << (bArr[0] & 255)))) & 255) << ((min - 1) * 8));
    }

    public ASN1BitStringParser parser() {
        return this;
    }

    public ASN1Primitive toDERObject() {
        return new DERBitString(this.contents, false);
    }

    public ASN1Primitive toDLObject() {
        return new DLBitString(this.contents, false);
    }

    public String toString() {
        return getString();
    }
}
