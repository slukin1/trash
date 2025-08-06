package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class SABERPrivateKey extends ASN1Object {
    private SABERPublicKey PublicKey;
    private byte[] hpk;

    /* renamed from: s  reason: collision with root package name */
    private byte[] f59508s;
    private int version;

    /* renamed from: z  reason: collision with root package name */
    private byte[] f59509z;

    public SABERPrivateKey(int i11, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.version = i11;
        if (i11 == 0) {
            this.f59509z = bArr;
            this.f59508s = bArr2;
            this.hpk = bArr3;
            return;
        }
        throw new IllegalArgumentException("unrecognized version");
    }

    public SABERPrivateKey(int i11, byte[] bArr, byte[] bArr2, byte[] bArr3, SABERPublicKey sABERPublicKey) {
        this.version = i11;
        if (i11 == 0) {
            this.f59509z = bArr;
            this.f59508s = bArr2;
            this.hpk = bArr3;
            this.PublicKey = sABERPublicKey;
            return;
        }
        throw new IllegalArgumentException("unrecognized version");
    }

    private SABERPrivateKey(ASN1Sequence aSN1Sequence) {
        int intValueExact = BigIntegers.intValueExact(ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue());
        this.version = intValueExact;
        if (intValueExact == 0) {
            this.f59509z = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
            this.f59508s = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
            this.PublicKey = SABERPublicKey.getInstance(aSN1Sequence.getObjectAt(3));
            this.hpk = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(4)).getOctets());
            return;
        }
        throw new IllegalArgumentException("unrecognized version");
    }

    public static SABERPrivateKey getInstance(Object obj) {
        if (obj instanceof SABERPrivateKey) {
            return (SABERPrivateKey) obj;
        }
        if (obj != null) {
            return new SABERPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getHpk() {
        return this.hpk;
    }

    public SABERPublicKey getPublicKey() {
        return this.PublicKey;
    }

    public byte[] getS() {
        return this.f59508s;
    }

    public int getVersion() {
        return this.version;
    }

    public byte[] getZ() {
        return this.f59509z;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.version));
        aSN1EncodableVector.add(new DEROctetString(this.f59509z));
        aSN1EncodableVector.add(new DEROctetString(this.f59508s));
        aSN1EncodableVector.add(new DEROctetString(this.hpk));
        return new DERSequence(aSN1EncodableVector);
    }
}
