package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;

class LazyEncodedSequence extends ASN1Sequence {
    private byte[] encoded;

    public LazyEncodedSequence(byte[] bArr) throws IOException {
        Objects.requireNonNull(bArr, "'encoded' cannot be null");
        this.encoded = bArr;
    }

    private synchronized void force() {
        if (this.encoded != null) {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(this.encoded, true);
            try {
                ASN1EncodableVector readVector = aSN1InputStream.readVector();
                aSN1InputStream.close();
                this.elements = readVector.takeElements();
                this.encoded = null;
            } catch (IOException e11) {
                throw new ASN1ParsingException("malformed ASN.1: " + e11, e11);
            }
        }
    }

    private synchronized byte[] getContents() {
        return this.encoded;
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        byte[] contents = getContents();
        if (contents != null) {
            aSN1OutputStream.writeEncodingDL(z11, 48, contents);
        } else {
            super.toDLObject().encode(aSN1OutputStream, z11);
        }
    }

    public int encodedLength(boolean z11) throws IOException {
        byte[] contents = getContents();
        return contents != null ? ASN1OutputStream.getLengthOfEncodingDL(z11, contents.length) : super.toDLObject().encodedLength(z11);
    }

    public ASN1Encodable getObjectAt(int i11) {
        force();
        return super.getObjectAt(i11);
    }

    public Enumeration getObjects() {
        byte[] contents = getContents();
        return contents != null ? new LazyConstructionEnumeration(contents) : super.getObjects();
    }

    public int hashCode() {
        force();
        return super.hashCode();
    }

    public Iterator<ASN1Encodable> iterator() {
        force();
        return super.iterator();
    }

    public int size() {
        force();
        return super.size();
    }

    public ASN1BitString toASN1BitString() {
        return ((ASN1Sequence) toDLObject()).toASN1BitString();
    }

    public ASN1External toASN1External() {
        return ((ASN1Sequence) toDLObject()).toASN1External();
    }

    public ASN1OctetString toASN1OctetString() {
        return ((ASN1Sequence) toDLObject()).toASN1OctetString();
    }

    public ASN1Set toASN1Set() {
        return ((ASN1Sequence) toDLObject()).toASN1Set();
    }

    public ASN1Encodable[] toArray() {
        force();
        return super.toArray();
    }

    public ASN1Encodable[] toArrayInternal() {
        force();
        return super.toArrayInternal();
    }

    public ASN1Primitive toDERObject() {
        force();
        return super.toDERObject();
    }

    public ASN1Primitive toDLObject() {
        force();
        return super.toDLObject();
    }
}
