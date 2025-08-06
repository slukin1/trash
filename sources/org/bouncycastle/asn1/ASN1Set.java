package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import okhttp3.HttpUrl;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

public abstract class ASN1Set extends ASN1Primitive implements Iterable<ASN1Encodable> {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1Set.class, 17) {
        public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
            return aSN1Sequence.toASN1Set();
        }
    };
    public final ASN1Encodable[] elements;
    public final boolean isSorted;

    public ASN1Set() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
        this.isSorted = true;
    }

    public ASN1Set(ASN1Encodable aSN1Encodable) {
        Objects.requireNonNull(aSN1Encodable, "'element' cannot be null");
        this.elements = new ASN1Encodable[]{aSN1Encodable};
        this.isSorted = true;
    }

    public ASN1Set(ASN1EncodableVector aSN1EncodableVector, boolean z11) {
        ASN1Encodable[] aSN1EncodableArr;
        Objects.requireNonNull(aSN1EncodableVector, "'elementVector' cannot be null");
        if (!z11 || aSN1EncodableVector.size() < 2) {
            aSN1EncodableArr = aSN1EncodableVector.takeElements();
        } else {
            aSN1EncodableArr = aSN1EncodableVector.copyElements();
            sort(aSN1EncodableArr);
        }
        this.elements = aSN1EncodableArr;
        this.isSorted = z11 || aSN1EncodableArr.length < 2;
    }

    public ASN1Set(boolean z11, ASN1Encodable[] aSN1EncodableArr) {
        this.elements = aSN1EncodableArr;
        this.isSorted = z11 || aSN1EncodableArr.length < 2;
    }

    public ASN1Set(ASN1Encodable[] aSN1EncodableArr, boolean z11) {
        if (!Arrays.isNullOrContainsNull(aSN1EncodableArr)) {
            ASN1Encodable[] cloneElements = ASN1EncodableVector.cloneElements(aSN1EncodableArr);
            if (z11 && cloneElements.length >= 2) {
                sort(cloneElements);
            }
            this.elements = cloneElements;
            this.isSorted = z11 || cloneElements.length < 2;
            return;
        }
        throw new NullPointerException("'elements' cannot be null, or contain null");
    }

    private static byte[] getDEREncoded(ASN1Encodable aSN1Encodable) {
        try {
            return aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static ASN1Set getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Set)) {
            return (ASN1Set) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Set) {
                return (ASN1Set) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (ASN1Set) TYPE.fromByteArray((byte[]) obj);
            } catch (IOException e11) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e11.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1Set getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1Set) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    private static boolean lessThanOrEqual(byte[] bArr, byte[] bArr2) {
        byte b11 = bArr[0] & -33;
        byte b12 = bArr2[0] & -33;
        if (b11 != b12) {
            return b11 < b12;
        }
        int min = Math.min(bArr.length, bArr2.length) - 1;
        for (int i11 = 1; i11 < min; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return (bArr[i11] & 255) < (bArr2[i11] & 255);
            }
        }
        return (bArr[min] & 255) <= (bArr2[min] & 255);
    }

    private static void sort(ASN1Encodable[] aSN1EncodableArr) {
        int length = aSN1EncodableArr.length;
        if (length >= 2) {
            ASN1Encodable aSN1Encodable = aSN1EncodableArr[0];
            ASN1Encodable aSN1Encodable2 = aSN1EncodableArr[1];
            byte[] dEREncoded = getDEREncoded(aSN1Encodable);
            byte[] dEREncoded2 = getDEREncoded(aSN1Encodable2);
            if (lessThanOrEqual(dEREncoded2, dEREncoded)) {
                ASN1Encodable aSN1Encodable3 = aSN1Encodable2;
                aSN1Encodable2 = aSN1Encodable;
                aSN1Encodable = aSN1Encodable3;
                byte[] bArr = dEREncoded2;
                dEREncoded2 = dEREncoded;
                dEREncoded = bArr;
            }
            for (int i11 = 2; i11 < length; i11++) {
                ASN1Encodable aSN1Encodable4 = aSN1EncodableArr[i11];
                byte[] dEREncoded3 = getDEREncoded(aSN1Encodable4);
                if (lessThanOrEqual(dEREncoded2, dEREncoded3)) {
                    aSN1EncodableArr[i11 - 2] = aSN1Encodable;
                    aSN1Encodable = aSN1Encodable2;
                    dEREncoded = dEREncoded2;
                    aSN1Encodable2 = aSN1Encodable4;
                    dEREncoded2 = dEREncoded3;
                } else if (lessThanOrEqual(dEREncoded, dEREncoded3)) {
                    aSN1EncodableArr[i11 - 2] = aSN1Encodable;
                    aSN1Encodable = aSN1Encodable4;
                    dEREncoded = dEREncoded3;
                } else {
                    int i12 = i11 - 1;
                    while (true) {
                        i12--;
                        if (i12 <= 0) {
                            break;
                        }
                        ASN1Encodable aSN1Encodable5 = aSN1EncodableArr[i12 - 1];
                        if (lessThanOrEqual(getDEREncoded(aSN1Encodable5), dEREncoded3)) {
                            break;
                        }
                        aSN1EncodableArr[i12] = aSN1Encodable5;
                    }
                    aSN1EncodableArr[i12] = aSN1Encodable4;
                }
            }
            aSN1EncodableArr[length - 2] = aSN1Encodable;
            aSN1EncodableArr[length - 1] = aSN1Encodable2;
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Set)) {
            return false;
        }
        ASN1Set aSN1Set = (ASN1Set) aSN1Primitive;
        int size = size();
        if (aSN1Set.size() != size) {
            return false;
        }
        DERSet dERSet = (DERSet) toDERObject();
        DERSet dERSet2 = (DERSet) aSN1Set.toDERObject();
        for (int i11 = 0; i11 < size; i11++) {
            ASN1Primitive aSN1Primitive2 = dERSet.elements[i11].toASN1Primitive();
            ASN1Primitive aSN1Primitive3 = dERSet2.elements[i11].toASN1Primitive();
            if (aSN1Primitive2 != aSN1Primitive3 && !aSN1Primitive2.asn1Equals(aSN1Primitive3)) {
                return false;
            }
        }
        return true;
    }

    public boolean encodeConstructed() {
        return true;
    }

    public ASN1Encodable getObjectAt(int i11) {
        return this.elements[i11];
    }

    public Enumeration getObjects() {
        return new Enumeration() {
            private int pos = 0;

            public boolean hasMoreElements() {
                return this.pos < ASN1Set.this.elements.length;
            }

            public Object nextElement() {
                int i11 = this.pos;
                ASN1Encodable[] aSN1EncodableArr = ASN1Set.this.elements;
                if (i11 < aSN1EncodableArr.length) {
                    this.pos = i11 + 1;
                    return aSN1EncodableArr[i11];
                }
                throw new NoSuchElementException();
            }
        };
    }

    public int hashCode() {
        int length = this.elements.length;
        int i11 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i11;
            }
            i11 += this.elements[length].toASN1Primitive().hashCode();
        }
    }

    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(toArray());
    }

    public ASN1SetParser parser() {
        final int size = size();
        return new ASN1SetParser() {
            private int pos = 0;

            public ASN1Primitive getLoadedObject() {
                return ASN1Set.this;
            }

            public ASN1Encodable readObject() throws IOException {
                int i11 = size;
                int i12 = this.pos;
                if (i11 == i12) {
                    return null;
                }
                ASN1Encodable[] aSN1EncodableArr = ASN1Set.this.elements;
                this.pos = i12 + 1;
                ASN1Encodable aSN1Encodable = aSN1EncodableArr[i12];
                return aSN1Encodable instanceof ASN1Sequence ? ((ASN1Sequence) aSN1Encodable).parser() : aSN1Encodable instanceof ASN1Set ? ((ASN1Set) aSN1Encodable).parser() : aSN1Encodable;
            }

            public ASN1Primitive toASN1Primitive() {
                return ASN1Set.this;
            }
        };
    }

    public int size() {
        return this.elements.length;
    }

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    public ASN1Primitive toDERObject() {
        ASN1Encodable[] aSN1EncodableArr;
        if (this.isSorted) {
            aSN1EncodableArr = this.elements;
        } else {
            aSN1EncodableArr = (ASN1Encodable[]) this.elements.clone();
            sort(aSN1EncodableArr);
        }
        return new DERSet(true, aSN1EncodableArr);
    }

    public ASN1Primitive toDLObject() {
        return new DLSet(this.isSorted, this.elements);
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i11 = 0;
        while (true) {
            stringBuffer.append(this.elements[i11]);
            i11++;
            if (i11 >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }
}
