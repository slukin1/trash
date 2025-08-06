package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;

public class X9ECPoint extends ASN1Object {

    /* renamed from: c  reason: collision with root package name */
    private ECCurve f59094c;
    private final ASN1OctetString encoding;

    /* renamed from: p  reason: collision with root package name */
    private ECPoint f59095p;

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this(eCCurve, aSN1OctetString.getOctets());
    }

    public X9ECPoint(ECCurve eCCurve, byte[] bArr) {
        this.f59094c = eCCurve;
        this.encoding = new DEROctetString(Arrays.clone(bArr));
    }

    public X9ECPoint(ECPoint eCPoint, boolean z11) {
        this.f59095p = eCPoint.normalize();
        this.encoding = new DEROctetString(eCPoint.getEncoded(z11));
    }

    public synchronized ECPoint getPoint() {
        if (this.f59095p == null) {
            this.f59095p = this.f59094c.decodePoint(this.encoding.getOctets()).normalize();
        }
        return this.f59095p;
    }

    public byte[] getPointEncoding() {
        return Arrays.clone(this.encoding.getOctets());
    }

    public boolean isPointCompressed() {
        byte[] octets = this.encoding.getOctets();
        if (octets == null || octets.length <= 0) {
            return false;
        }
        return octets[0] == 2 || octets[0] == 3;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }
}
