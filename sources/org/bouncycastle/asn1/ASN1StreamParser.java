package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser {
    private final InputStream _in;
    private final int _limit;
    private final byte[][] tmpBuffers;

    public ASN1StreamParser(InputStream inputStream) {
        this(inputStream, StreamUtil.findLimit(inputStream));
    }

    public ASN1StreamParser(InputStream inputStream, int i11) {
        this(inputStream, i11, new byte[11][]);
    }

    public ASN1StreamParser(InputStream inputStream, int i11, byte[][] bArr) {
        this._in = inputStream;
        this._limit = i11;
        this.tmpBuffers = bArr;
    }

    public ASN1StreamParser(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    private void set00Check(boolean z11) {
        InputStream inputStream = this._in;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) inputStream).setEofOn00(z11);
        }
    }

    public ASN1Encodable implParseObject(int i11) throws IOException {
        boolean z11 = false;
        set00Check(false);
        int readTagNumber = ASN1InputStream.readTagNumber(this._in, i11);
        int readLength = ASN1InputStream.readLength(this._in, this._limit, readTagNumber == 3 || readTagNumber == 4 || readTagNumber == 16 || readTagNumber == 17 || readTagNumber == 8);
        if (readLength >= 0) {
            DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this._in, readLength, this._limit);
            if ((i11 & 224) == 0) {
                return parseImplicitPrimitive(readTagNumber, definiteLengthInputStream);
            }
            ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(definiteLengthInputStream, definiteLengthInputStream.getLimit(), this.tmpBuffers);
            int i12 = i11 & 192;
            if (i12 == 0) {
                return aSN1StreamParser.parseImplicitConstructedDL(readTagNumber);
            }
            if ((i11 & 32) != 0) {
                z11 = true;
            }
            return 64 == i12 ? (DLApplicationSpecific) aSN1StreamParser.loadTaggedDL(i12, readTagNumber, z11) : new DLTaggedObjectParser(i12, readTagNumber, z11, aSN1StreamParser);
        } else if ((i11 & 32) != 0) {
            ASN1StreamParser aSN1StreamParser2 = new ASN1StreamParser(new IndefiniteLengthInputStream(this._in, this._limit), this._limit, this.tmpBuffers);
            int i13 = i11 & 192;
            return i13 != 0 ? 64 == i13 ? new BERApplicationSpecificParser(readTagNumber, aSN1StreamParser2) : new BERTaggedObjectParser(i13, readTagNumber, aSN1StreamParser2) : aSN1StreamParser2.parseImplicitConstructedIL(readTagNumber);
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }

    public ASN1Primitive loadTaggedDL(int i11, int i12, boolean z11) throws IOException {
        return !z11 ? ASN1TaggedObject.createPrimitive(i11, i12, ((DefiniteLengthInputStream) this._in).toByteArray()) : ASN1TaggedObject.createConstructedDL(i11, i12, readVector());
    }

    public ASN1Primitive loadTaggedIL(int i11, int i12) throws IOException {
        return ASN1TaggedObject.createConstructedIL(i11, i12, readVector());
    }

    public ASN1Encodable parseImplicitConstructedDL(int i11) throws IOException {
        if (i11 == 3) {
            return new BERBitStringParser(this);
        }
        if (i11 == 4) {
            return new BEROctetStringParser(this);
        }
        if (i11 == 8) {
            return new DERExternalParser(this);
        }
        if (i11 == 16) {
            return new DLSequenceParser(this);
        }
        if (i11 == 17) {
            return new DLSetParser(this);
        }
        throw new ASN1Exception("unknown DL object encountered: 0x" + Integer.toHexString(i11));
    }

    public ASN1Encodable parseImplicitConstructedIL(int i11) throws IOException {
        if (i11 == 3) {
            return new BERBitStringParser(this);
        }
        if (i11 == 4) {
            return new BEROctetStringParser(this);
        }
        if (i11 == 8) {
            return new DERExternalParser(this);
        }
        if (i11 == 16) {
            return new BERSequenceParser(this);
        }
        if (i11 == 17) {
            return new BERSetParser(this);
        }
        throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(i11));
    }

    public ASN1Encodable parseImplicitPrimitive(int i11) throws IOException {
        return parseImplicitPrimitive(i11, (DefiniteLengthInputStream) this._in);
    }

    public ASN1Encodable parseImplicitPrimitive(int i11, DefiniteLengthInputStream definiteLengthInputStream) throws IOException {
        if (i11 == 3) {
            return new DLBitStringParser(definiteLengthInputStream);
        }
        if (i11 == 4) {
            return new DEROctetStringParser(definiteLengthInputStream);
        }
        if (i11 == 8) {
            throw new ASN1Exception("externals must use constructed encoding (see X.690 8.18)");
        } else if (i11 == 16) {
            throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
        } else if (i11 != 17) {
            try {
                return ASN1InputStream.createPrimitiveDERObject(i11, definiteLengthInputStream, this.tmpBuffers);
            } catch (IllegalArgumentException e11) {
                throw new ASN1Exception("corrupted stream detected", e11);
            }
        } else {
            throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
        }
    }

    public ASN1Encodable parseObject(int i11) throws IOException {
        if (i11 < 0 || i11 > 30) {
            throw new IllegalArgumentException("invalid universal tag number: " + i11);
        }
        int read = this._in.read();
        if (read < 0) {
            return null;
        }
        if ((read & -33) == i11) {
            return implParseObject(read);
        }
        throw new IOException("unexpected identifier encountered: " + read);
    }

    public ASN1TaggedObjectParser parseTaggedObject() throws IOException {
        int read = this._in.read();
        if (read < 0) {
            return null;
        }
        if ((read & 192) != 0) {
            return (ASN1TaggedObjectParser) implParseObject(read);
        }
        throw new ASN1Exception("no tagged object found");
    }

    public ASN1Encodable readObject() throws IOException {
        int read = this._in.read();
        if (read < 0) {
            return null;
        }
        return implParseObject(read);
    }

    public ASN1EncodableVector readVector() throws IOException {
        int read = this._in.read();
        if (read < 0) {
            return new ASN1EncodableVector(0);
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        do {
            ASN1Encodable implParseObject = implParseObject(read);
            aSN1EncodableVector.add(implParseObject instanceof InMemoryRepresentable ? ((InMemoryRepresentable) implParseObject).getLoadedObject() : implParseObject.toASN1Primitive());
            read = this._in.read();
        } while (read >= 0);
        return aSN1EncodableVector;
    }
}
