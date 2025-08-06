package org.bouncycastle.asn1;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bouncycastle.util.Arrays;

public class ASN1ObjectIdentifier extends ASN1Primitive {
    private static final long LONG_LIMIT = 72057594037927808L;
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1ObjectIdentifier.class, 6) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1ObjectIdentifier.createPrimitive(dEROctetString.getOctets(), false);
        }
    };
    private static final ConcurrentMap<OidHandle, ASN1ObjectIdentifier> pool = new ConcurrentHashMap();
    private byte[] contents;
    private final String identifier;

    public static class OidHandle {
        private final byte[] contents;
        private final int key;

        public OidHandle(byte[] bArr) {
            this.key = Arrays.hashCode(bArr);
            this.contents = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof OidHandle) {
                return Arrays.areEqual(this.contents, ((OidHandle) obj).contents);
            }
            return false;
        }

        public int hashCode() {
            return this.key;
        }
    }

    public ASN1ObjectIdentifier(String str) {
        Objects.requireNonNull(str, "'identifier' cannot be null");
        if (isValidIdentifier(str)) {
            this.identifier = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not an OID");
    }

    public ASN1ObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (ASN1RelativeOID.isValidIdentifier(str, 0)) {
            this.identifier = aSN1ObjectIdentifier.getId() + InstructionFileId.DOT + str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a valid OID branch");
    }

    public ASN1ObjectIdentifier(byte[] bArr, boolean z11) {
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z12 = true;
        long j11 = 0;
        BigInteger bigInteger = null;
        for (int i11 = 0; i11 != bArr2.length; i11++) {
            byte b11 = bArr2[i11] & 255;
            if (j11 <= LONG_LIMIT) {
                long j12 = j11 + ((long) (b11 & Ascii.DEL));
                if ((b11 & 128) == 0) {
                    if (z12) {
                        if (j12 < 40) {
                            stringBuffer.append('0');
                        } else if (j12 < 80) {
                            stringBuffer.append('1');
                            j12 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j12 -= 80;
                        }
                        z12 = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j12);
                    j11 = 0;
                } else {
                    j11 = j12 << 7;
                }
            } else {
                BigInteger or2 = (bigInteger == null ? BigInteger.valueOf(j11) : bigInteger).or(BigInteger.valueOf((long) (b11 & Ascii.DEL)));
                if ((b11 & 128) == 0) {
                    if (z12) {
                        stringBuffer.append('2');
                        or2 = or2.subtract(BigInteger.valueOf(80));
                        z12 = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or2);
                    j11 = 0;
                    bigInteger = null;
                } else {
                    bigInteger = or2.shiftLeft(7);
                }
            }
        }
        this.identifier = stringBuffer.toString();
        this.contents = z11 ? Arrays.clone(bArr) : bArr2;
    }

    public static ASN1ObjectIdentifier createPrimitive(byte[] bArr, boolean z11) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) pool.get(new OidHandle(bArr));
        return aSN1ObjectIdentifier == null ? new ASN1ObjectIdentifier(bArr, z11) : aSN1ObjectIdentifier;
    }

    private void doOutput(ByteArrayOutputStream byteArrayOutputStream) {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.identifier);
        int parseInt = Integer.parseInt(oIDTokenizer.nextToken()) * 40;
        String nextToken = oIDTokenizer.nextToken();
        if (nextToken.length() <= 18) {
            ASN1RelativeOID.writeField(byteArrayOutputStream, ((long) parseInt) + Long.parseLong(nextToken));
        } else {
            ASN1RelativeOID.writeField(byteArrayOutputStream, new BigInteger(nextToken).add(BigInteger.valueOf((long) parseInt)));
        }
        while (oIDTokenizer.hasMoreTokens()) {
            String nextToken2 = oIDTokenizer.nextToken();
            if (nextToken2.length() <= 18) {
                ASN1RelativeOID.writeField(byteArrayOutputStream, Long.parseLong(nextToken2));
            } else {
                ASN1RelativeOID.writeField(byteArrayOutputStream, new BigInteger(nextToken2));
            }
        }
    }

    public static ASN1ObjectIdentifier fromContents(byte[] bArr) {
        return createPrimitive(bArr, true);
    }

    private synchronized byte[] getContents() {
        if (this.contents == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            doOutput(byteArrayOutputStream);
            this.contents = byteArrayOutputStream.toByteArray();
        }
        return this.contents;
    }

    public static ASN1ObjectIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ObjectIdentifier)) {
            return (ASN1ObjectIdentifier) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                return (ASN1ObjectIdentifier) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (ASN1ObjectIdentifier) TYPE.fromByteArray((byte[]) obj);
            } catch (IOException e11) {
                throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e11.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        if (!z11 && !aSN1TaggedObject.isParsed()) {
            ASN1Primitive object = aSN1TaggedObject.getObject();
            if (!(object instanceof ASN1ObjectIdentifier)) {
                return fromContents(ASN1OctetString.getInstance(object).getOctets());
            }
        }
        return (ASN1ObjectIdentifier) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    private static boolean isValidIdentifier(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        return ASN1RelativeOID.isValidIdentifier(str, 2);
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == this) {
            return true;
        }
        if (!(aSN1Primitive instanceof ASN1ObjectIdentifier)) {
            return false;
        }
        return this.identifier.equals(((ASN1ObjectIdentifier) aSN1Primitive).identifier);
    }

    public ASN1ObjectIdentifier branch(String str) {
        return new ASN1ObjectIdentifier(this, str);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 6, getContents());
    }

    public boolean encodeConstructed() {
        return false;
    }

    public int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, getContents().length);
    }

    public String getId() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    public ASN1ObjectIdentifier intern() {
        OidHandle oidHandle = new OidHandle(getContents());
        ConcurrentMap<OidHandle, ASN1ObjectIdentifier> concurrentMap = pool;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) concurrentMap.get(oidHandle);
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        ASN1ObjectIdentifier putIfAbsent = concurrentMap.putIfAbsent(oidHandle, this);
        return putIfAbsent == null ? this : putIfAbsent;
    }

    public boolean on(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String id2 = getId();
        String id3 = aSN1ObjectIdentifier.getId();
        return id2.length() > id3.length() && id2.charAt(id3.length()) == '.' && id2.startsWith(id3);
    }

    public String toString() {
        return getId();
    }
}
