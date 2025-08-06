package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;

public class TimeStampReq extends ASN1Object {
    public ASN1Boolean certReq;
    public Extensions extensions;
    public MessageImprint messageImprint;
    public ASN1Integer nonce;
    public ASN1ObjectIdentifier tsaPolicy;
    public ASN1Integer version;

    private TimeStampReq(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.messageImprint = MessageImprint.getInstance(aSN1Sequence.getObjectAt(1));
        for (int i11 = 2; i11 < size; i11++) {
            if (aSN1Sequence.getObjectAt(i11) instanceof ASN1ObjectIdentifier) {
                checkOption(this.tsaPolicy, i11, 2);
                this.tsaPolicy = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(i11));
            } else if (aSN1Sequence.getObjectAt(i11) instanceof ASN1Integer) {
                checkOption(this.nonce, i11, 3);
                this.nonce = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i11));
            } else if (aSN1Sequence.getObjectAt(i11) instanceof ASN1Boolean) {
                checkOption(this.certReq, i11, 4);
                this.certReq = ASN1Boolean.getInstance((Object) aSN1Sequence.getObjectAt(i11));
            } else if (aSN1Sequence.getObjectAt(i11) instanceof ASN1TaggedObject) {
                checkOption(this.extensions, i11, 5);
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i11);
                if (aSN1TaggedObject.getTagNo() == 0) {
                    this.extensions = Extensions.getInstance(aSN1TaggedObject, false);
                }
            } else {
                throw new IllegalArgumentException("unidentified structure in sequence");
            }
        }
    }

    public TimeStampReq(MessageImprint messageImprint2, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Boolean aSN1Boolean, Extensions extensions2) {
        this.version = new ASN1Integer(1);
        this.messageImprint = messageImprint2;
        this.tsaPolicy = aSN1ObjectIdentifier;
        this.nonce = aSN1Integer;
        this.certReq = aSN1Boolean;
        this.extensions = extensions2;
    }

    private void checkOption(Object obj, int i11, int i12) {
        if (obj != null || i11 > i12) {
            throw new IllegalArgumentException("badly placed optional in sequence");
        }
    }

    public static TimeStampReq getInstance(Object obj) {
        if (obj instanceof TimeStampReq) {
            return (TimeStampReq) obj;
        }
        if (obj != null) {
            return new TimeStampReq(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Boolean getCertReq() {
        ASN1Boolean aSN1Boolean = this.certReq;
        return aSN1Boolean == null ? ASN1Boolean.FALSE : aSN1Boolean;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public MessageImprint getMessageImprint() {
        return this.messageImprint;
    }

    public ASN1Integer getNonce() {
        return this.nonce;
    }

    public ASN1ObjectIdentifier getReqPolicy() {
        return this.tsaPolicy;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.messageImprint);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.tsaPolicy;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.add(aSN1ObjectIdentifier);
        }
        ASN1Integer aSN1Integer = this.nonce;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        ASN1Boolean aSN1Boolean = this.certReq;
        if (aSN1Boolean != null && aSN1Boolean.isTrue()) {
            aSN1EncodableVector.add(this.certReq);
        }
        Extensions extensions2 = this.extensions;
        if (extensions2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable) extensions2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
