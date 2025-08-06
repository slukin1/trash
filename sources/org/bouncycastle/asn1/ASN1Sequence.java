package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import okhttp3.HttpUrl;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

public abstract class ASN1Sequence extends ASN1Primitive implements Iterable<ASN1Encodable> {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1Sequence.class, 16) {
        public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
            return aSN1Sequence;
        }
    };
    public ASN1Encodable[] elements;

    public ASN1Sequence() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
    }

    public ASN1Sequence(ASN1Encodable aSN1Encodable) {
        Objects.requireNonNull(aSN1Encodable, "'element' cannot be null");
        this.elements = new ASN1Encodable[]{aSN1Encodable};
    }

    public ASN1Sequence(ASN1EncodableVector aSN1EncodableVector) {
        Objects.requireNonNull(aSN1EncodableVector, "'elementVector' cannot be null");
        this.elements = aSN1EncodableVector.takeElements();
    }

    public ASN1Sequence(ASN1Encodable[] aSN1EncodableArr) {
        if (!Arrays.isNullOrContainsNull(aSN1EncodableArr)) {
            this.elements = ASN1EncodableVector.cloneElements(aSN1EncodableArr);
            return;
        }
        throw new NullPointerException("'elements' cannot be null, or contain null");
    }

    public ASN1Sequence(ASN1Encodable[] aSN1EncodableArr, boolean z11) {
        this.elements = z11 ? ASN1EncodableVector.cloneElements(aSN1EncodableArr) : aSN1EncodableArr;
    }

    public static ASN1Sequence getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Sequence)) {
            return (ASN1Sequence) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Sequence) {
                return (ASN1Sequence) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (ASN1Sequence) TYPE.fromByteArray((byte[]) obj);
            } catch (IOException e11) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e11.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1Sequence) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Sequence)) {
            return false;
        }
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Primitive;
        int size = size();
        if (aSN1Sequence.size() != size) {
            return false;
        }
        for (int i11 = 0; i11 < size; i11++) {
            ASN1Primitive aSN1Primitive2 = this.elements[i11].toASN1Primitive();
            ASN1Primitive aSN1Primitive3 = aSN1Sequence.elements[i11].toASN1Primitive();
            if (aSN1Primitive2 != aSN1Primitive3 && !aSN1Primitive2.asn1Equals(aSN1Primitive3)) {
                return false;
            }
        }
        return true;
    }

    public boolean encodeConstructed() {
        return true;
    }

    public ASN1BitString[] getConstructedBitStrings() {
        int size = size();
        ASN1BitString[] aSN1BitStringArr = new ASN1BitString[size];
        for (int i11 = 0; i11 < size; i11++) {
            aSN1BitStringArr[i11] = ASN1BitString.getInstance(this.elements[i11]);
        }
        return aSN1BitStringArr;
    }

    public ASN1OctetString[] getConstructedOctetStrings() {
        int size = size();
        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[size];
        for (int i11 = 0; i11 < size; i11++) {
            aSN1OctetStringArr[i11] = ASN1OctetString.getInstance(this.elements[i11]);
        }
        return aSN1OctetStringArr;
    }

    public ASN1Encodable getObjectAt(int i11) {
        return this.elements[i11];
    }

    public Enumeration getObjects() {
        return new Enumeration() {
            private int pos = 0;

            public boolean hasMoreElements() {
                return this.pos < ASN1Sequence.this.elements.length;
            }

            public Object nextElement() {
                int i11 = this.pos;
                ASN1Encodable[] aSN1EncodableArr = ASN1Sequence.this.elements;
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
            i11 = (i11 * 257) ^ this.elements[length].toASN1Primitive().hashCode();
        }
    }

    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(this.elements);
    }

    public ASN1SequenceParser parser() {
        final int size = size();
        return new ASN1SequenceParser() {
            private int pos = 0;

            public ASN1Primitive getLoadedObject() {
                return ASN1Sequence.this;
            }

            public ASN1Encodable readObject() throws IOException {
                int i11 = size;
                int i12 = this.pos;
                if (i11 == i12) {
                    return null;
                }
                ASN1Encodable[] aSN1EncodableArr = ASN1Sequence.this.elements;
                this.pos = i12 + 1;
                ASN1Encodable aSN1Encodable = aSN1EncodableArr[i12];
                return aSN1Encodable instanceof ASN1Sequence ? ((ASN1Sequence) aSN1Encodable).parser() : aSN1Encodable instanceof ASN1Set ? ((ASN1Set) aSN1Encodable).parser() : aSN1Encodable;
            }

            public ASN1Primitive toASN1Primitive() {
                return ASN1Sequence.this;
            }
        };
    }

    public int size() {
        return this.elements.length;
    }

    public abstract ASN1BitString toASN1BitString();

    public abstract ASN1External toASN1External();

    public abstract ASN1OctetString toASN1OctetString();

    public abstract ASN1Set toASN1Set();

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    public ASN1Encodable[] toArrayInternal() {
        return this.elements;
    }

    public ASN1Primitive toDERObject() {
        return new DERSequence(this.elements, false);
    }

    public ASN1Primitive toDLObject() {
        return new DLSequence(this.elements, false);
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
