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

public class CMCEPrivateKey extends ASN1Object {
    private byte[] C;
    private CMCEPublicKey PublicKey;
    private byte[] alpha;
    private byte[] delta;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f59489g;

    /* renamed from: s  reason: collision with root package name */
    private byte[] f59490s;
    private int version;

    public CMCEPrivateKey(int i11, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this(i11, bArr, bArr2, bArr3, bArr4, bArr5, (CMCEPublicKey) null);
    }

    public CMCEPrivateKey(int i11, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, CMCEPublicKey cMCEPublicKey) {
        this.version = i11;
        if (i11 == 0) {
            this.delta = Arrays.clone(bArr);
            this.C = Arrays.clone(bArr2);
            this.f59489g = Arrays.clone(bArr3);
            this.alpha = Arrays.clone(bArr4);
            this.f59490s = Arrays.clone(bArr5);
            this.PublicKey = cMCEPublicKey;
            return;
        }
        throw new IllegalArgumentException("unrecognized version");
    }

    private CMCEPrivateKey(ASN1Sequence aSN1Sequence) {
        int intValueExact = BigIntegers.intValueExact(ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue());
        this.version = intValueExact;
        if (intValueExact == 0) {
            this.delta = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
            this.C = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
            this.f59489g = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(3)).getOctets());
            this.alpha = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(4)).getOctets());
            this.f59490s = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(5)).getOctets());
            if (aSN1Sequence.size() == 7) {
                this.PublicKey = CMCEPublicKey.getInstance(aSN1Sequence.getObjectAt(6));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("unrecognized version");
    }

    public static CMCEPrivateKey getInstance(Object obj) {
        if (obj instanceof CMCEPrivateKey) {
            return (CMCEPrivateKey) obj;
        }
        if (obj != null) {
            return new CMCEPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getAlpha() {
        return Arrays.clone(this.alpha);
    }

    public byte[] getC() {
        return Arrays.clone(this.C);
    }

    public byte[] getDelta() {
        return Arrays.clone(this.delta);
    }

    public byte[] getG() {
        return Arrays.clone(this.f59489g);
    }

    public CMCEPublicKey getPublicKey() {
        return this.PublicKey;
    }

    public byte[] getS() {
        return Arrays.clone(this.f59490s);
    }

    public int getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.version));
        aSN1EncodableVector.add(new DEROctetString(this.delta));
        aSN1EncodableVector.add(new DEROctetString(this.C));
        aSN1EncodableVector.add(new DEROctetString(this.f59489g));
        aSN1EncodableVector.add(new DEROctetString(this.alpha));
        aSN1EncodableVector.add(new DEROctetString(this.f59490s));
        CMCEPublicKey cMCEPublicKey = this.PublicKey;
        if (cMCEPublicKey != null) {
            aSN1EncodableVector.add(new CMCEPublicKey(cMCEPublicKey.getT()));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
