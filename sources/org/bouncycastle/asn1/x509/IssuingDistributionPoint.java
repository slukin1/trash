package org.bouncycastle.asn1.x509;

import com.sumsub.sns.internal.core.analytics.d;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Strings;

public class IssuingDistributionPoint extends ASN1Object {
    private DistributionPointName distributionPoint;
    private boolean indirectCRL;
    private boolean onlyContainsAttributeCerts;
    private boolean onlyContainsCACerts;
    private boolean onlyContainsUserCerts;
    private ReasonFlags onlySomeReasons;
    private ASN1Sequence seq;

    private IssuingDistributionPoint(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
        for (int i11 = 0; i11 != aSN1Sequence.size(); i11++) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i11));
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.distributionPoint = DistributionPointName.getInstance(instance, true);
            } else if (tagNo == 1) {
                this.onlyContainsUserCerts = ASN1Boolean.getInstance(instance, false).isTrue();
            } else if (tagNo == 2) {
                this.onlyContainsCACerts = ASN1Boolean.getInstance(instance, false).isTrue();
            } else if (tagNo == 3) {
                this.onlySomeReasons = new ReasonFlags(ASN1BitString.getInstance(instance, false));
            } else if (tagNo == 4) {
                this.indirectCRL = ASN1Boolean.getInstance(instance, false).isTrue();
            } else if (tagNo == 5) {
                this.onlyContainsAttributeCerts = ASN1Boolean.getInstance(instance, false).isTrue();
            } else {
                throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
            }
        }
    }

    public IssuingDistributionPoint(DistributionPointName distributionPointName, boolean z11, boolean z12) {
        this(distributionPointName, false, false, (ReasonFlags) null, z11, z12);
    }

    public IssuingDistributionPoint(DistributionPointName distributionPointName, boolean z11, boolean z12, ReasonFlags reasonFlags, boolean z13, boolean z14) {
        this.distributionPoint = distributionPointName;
        this.indirectCRL = z13;
        this.onlyContainsAttributeCerts = z14;
        this.onlyContainsCACerts = z12;
        this.onlyContainsUserCerts = z11;
        this.onlySomeReasons = reasonFlags;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        if (distributionPointName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable) distributionPointName));
        }
        if (z11) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable) ASN1Boolean.getInstance(true)));
        }
        if (z12) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, (ASN1Encodable) ASN1Boolean.getInstance(true)));
        }
        if (reasonFlags != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 3, (ASN1Encodable) reasonFlags));
        }
        if (z13) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 4, (ASN1Encodable) ASN1Boolean.getInstance(true)));
        }
        if (z14) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 5, (ASN1Encodable) ASN1Boolean.getInstance(true)));
        }
        this.seq = new DERSequence(aSN1EncodableVector);
    }

    private void appendObject(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }

    private String booleanToString(boolean z11) {
        return z11 ? "true" : d.f31895b;
    }

    public static IssuingDistributionPoint getInstance(Object obj) {
        if (obj instanceof IssuingDistributionPoint) {
            return (IssuingDistributionPoint) obj;
        }
        if (obj != null) {
            return new IssuingDistributionPoint(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static IssuingDistributionPoint getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z11));
    }

    public DistributionPointName getDistributionPoint() {
        return this.distributionPoint;
    }

    public ReasonFlags getOnlySomeReasons() {
        return this.onlySomeReasons;
    }

    public boolean isIndirectCRL() {
        return this.indirectCRL;
    }

    public boolean onlyContainsAttributeCerts() {
        return this.onlyContainsAttributeCerts;
    }

    public boolean onlyContainsCACerts() {
        return this.onlyContainsCACerts;
    }

    public boolean onlyContainsUserCerts() {
        return this.onlyContainsUserCerts;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }

    public String toString() {
        String lineSeparator = Strings.lineSeparator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IssuingDistributionPoint: [");
        stringBuffer.append(lineSeparator);
        DistributionPointName distributionPointName = this.distributionPoint;
        if (distributionPointName != null) {
            appendObject(stringBuffer, lineSeparator, "distributionPoint", distributionPointName.toString());
        }
        boolean z11 = this.onlyContainsUserCerts;
        if (z11) {
            appendObject(stringBuffer, lineSeparator, "onlyContainsUserCerts", booleanToString(z11));
        }
        boolean z12 = this.onlyContainsCACerts;
        if (z12) {
            appendObject(stringBuffer, lineSeparator, "onlyContainsCACerts", booleanToString(z12));
        }
        ReasonFlags reasonFlags = this.onlySomeReasons;
        if (reasonFlags != null) {
            appendObject(stringBuffer, lineSeparator, "onlySomeReasons", reasonFlags.toString());
        }
        boolean z13 = this.onlyContainsAttributeCerts;
        if (z13) {
            appendObject(stringBuffer, lineSeparator, "onlyContainsAttributeCerts", booleanToString(z13));
        }
        boolean z14 = this.indirectCRL;
        if (z14) {
            appendObject(stringBuffer, lineSeparator, "indirectCRL", booleanToString(z14));
        }
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }
}
