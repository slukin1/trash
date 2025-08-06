package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class EciesP256EncryptedKey extends ASN1Object {

    /* renamed from: c  reason: collision with root package name */
    private final ASN1OctetString f59474c;

    /* renamed from: t  reason: collision with root package name */
    private final ASN1OctetString f59475t;

    /* renamed from: v  reason: collision with root package name */
    private final EccP256CurvePoint f59476v;

    public static class Builder {

        /* renamed from: c  reason: collision with root package name */
        private ASN1OctetString f59477c;

        /* renamed from: t  reason: collision with root package name */
        private ASN1OctetString f59478t;

        /* renamed from: v  reason: collision with root package name */
        private EccP256CurvePoint f59479v;

        public EciesP256EncryptedKey createEciesP256EncryptedKey() {
            return new EciesP256EncryptedKey(this.f59479v, this.f59477c, this.f59478t);
        }

        public Builder setC(ASN1OctetString aSN1OctetString) {
            this.f59477c = aSN1OctetString;
            return this;
        }

        public Builder setC(byte[] bArr) {
            this.f59477c = new DEROctetString(Arrays.clone(bArr));
            return this;
        }

        public Builder setT(ASN1OctetString aSN1OctetString) {
            this.f59478t = aSN1OctetString;
            return this;
        }

        public Builder setT(byte[] bArr) {
            this.f59478t = new DEROctetString(Arrays.clone(bArr));
            return this;
        }

        public Builder setV(EccP256CurvePoint eccP256CurvePoint) {
            this.f59479v = eccP256CurvePoint;
            return this;
        }
    }

    private EciesP256EncryptedKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.f59476v = EccP256CurvePoint.getInstance(aSN1Sequence.getObjectAt(0));
            this.f59474c = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
            this.f59475t = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2));
            return;
        }
        throw new IllegalArgumentException("expected sequence size of 3");
    }

    public EciesP256EncryptedKey(EccP256CurvePoint eccP256CurvePoint, ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        this.f59476v = eccP256CurvePoint;
        this.f59474c = aSN1OctetString;
        this.f59475t = aSN1OctetString2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static EciesP256EncryptedKey getInstance(Object obj) {
        if (obj instanceof EciesP256EncryptedKey) {
            return (EciesP256EncryptedKey) obj;
        }
        if (obj != null) {
            return new EciesP256EncryptedKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getC() {
        return this.f59474c;
    }

    public ASN1OctetString getT() {
        return this.f59475t;
    }

    public EccP256CurvePoint getV() {
        return this.f59476v;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f59476v, this.f59474c, this.f59475t});
    }
}
