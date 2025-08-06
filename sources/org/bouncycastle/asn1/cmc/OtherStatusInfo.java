package org.bouncycastle.asn1.cmc;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class OtherStatusInfo extends ASN1Object implements ASN1Choice {
    private final ExtendedFailInfo extendedFailInfo;
    private final CMCFailInfo failInfo;
    private final PendInfo pendInfo;

    public OtherStatusInfo(CMCFailInfo cMCFailInfo) {
        this(cMCFailInfo, (PendInfo) null, (ExtendedFailInfo) null);
    }

    private OtherStatusInfo(CMCFailInfo cMCFailInfo, PendInfo pendInfo2, ExtendedFailInfo extendedFailInfo2) {
        this.failInfo = cMCFailInfo;
        this.pendInfo = pendInfo2;
        this.extendedFailInfo = extendedFailInfo2;
    }

    public OtherStatusInfo(ExtendedFailInfo extendedFailInfo2) {
        this((CMCFailInfo) null, (PendInfo) null, extendedFailInfo2);
    }

    public OtherStatusInfo(PendInfo pendInfo2) {
        this((CMCFailInfo) null, pendInfo2, (ExtendedFailInfo) null);
    }

    public static OtherStatusInfo getInstance(Object obj) {
        if (obj instanceof OtherStatusInfo) {
            return (OtherStatusInfo) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Integer) {
                return new OtherStatusInfo(CMCFailInfo.getInstance(aSN1Primitive));
            }
            if (aSN1Primitive instanceof ASN1Sequence) {
                return ((ASN1Sequence) aSN1Primitive).getObjectAt(0) instanceof ASN1ObjectIdentifier ? new OtherStatusInfo(ExtendedFailInfo.getInstance(aSN1Primitive)) : new OtherStatusInfo(PendInfo.getInstance(aSN1Primitive));
            }
        } else if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e11) {
                throw new IllegalArgumentException("parsing error: " + e11.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    public boolean isExtendedFailInfo() {
        return this.extendedFailInfo != null;
    }

    public boolean isFailInfo() {
        return this.failInfo != null;
    }

    public boolean isPendingInfo() {
        return this.pendInfo != null;
    }

    public ASN1Primitive toASN1Primitive() {
        PendInfo pendInfo2 = this.pendInfo;
        if (pendInfo2 != null) {
            return pendInfo2.toASN1Primitive();
        }
        CMCFailInfo cMCFailInfo = this.failInfo;
        return cMCFailInfo != null ? cMCFailInfo.toASN1Primitive() : this.extendedFailInfo.toASN1Primitive();
    }
}
