package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class AuthEnvelopedData extends ASN1Object {
    private ASN1Set authAttrs;
    private EncryptedContentInfo authEncryptedContentInfo;
    private ASN1OctetString mac;
    private OriginatorInfo originatorInfo;
    private ASN1Set recipientInfos;
    private ASN1Set unauthAttrs;
    private ASN1Integer version;

    private AuthEnvelopedData(ASN1Sequence aSN1Sequence) {
        ASN1Set aSN1Set;
        ASN1Integer instance = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0).toASN1Primitive());
        this.version = instance;
        if (instance.hasValue(0)) {
            int i11 = 2;
            ASN1Primitive aSN1Primitive = aSN1Sequence.getObjectAt(1).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                this.originatorInfo = OriginatorInfo.getInstance((ASN1TaggedObject) aSN1Primitive, false);
                aSN1Primitive = aSN1Sequence.getObjectAt(2).toASN1Primitive();
                i11 = 3;
            }
            ASN1Set instance2 = ASN1Set.getInstance(aSN1Primitive);
            this.recipientInfos = instance2;
            if (instance2.size() != 0) {
                int i12 = i11 + 1;
                this.authEncryptedContentInfo = EncryptedContentInfo.getInstance(aSN1Sequence.getObjectAt(i11).toASN1Primitive());
                int i13 = i12 + 1;
                ASN1Primitive aSN1Primitive2 = aSN1Sequence.getObjectAt(i12).toASN1Primitive();
                if (aSN1Primitive2 instanceof ASN1TaggedObject) {
                    this.authAttrs = ASN1Set.getInstance((ASN1TaggedObject) aSN1Primitive2, false);
                    aSN1Primitive2 = aSN1Sequence.getObjectAt(i13).toASN1Primitive();
                    i13++;
                } else if (!this.authEncryptedContentInfo.getContentType().equals((ASN1Primitive) CMSObjectIdentifiers.data) && ((aSN1Set = this.authAttrs) == null || aSN1Set.size() == 0)) {
                    throw new IllegalArgumentException("authAttrs must be present with non-data content");
                }
                this.mac = ASN1OctetString.getInstance(aSN1Primitive2);
                if (aSN1Sequence.size() > i13) {
                    this.unauthAttrs = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i13).toASN1Primitive(), false);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
        }
        throw new IllegalArgumentException("AuthEnvelopedData version number must be 0");
    }

    public AuthEnvelopedData(OriginatorInfo originatorInfo2, ASN1Set aSN1Set, EncryptedContentInfo encryptedContentInfo, ASN1Set aSN1Set2, ASN1OctetString aSN1OctetString, ASN1Set aSN1Set3) {
        this.version = new ASN1Integer(0);
        this.originatorInfo = originatorInfo2;
        this.recipientInfos = aSN1Set;
        if (aSN1Set.size() != 0) {
            this.authEncryptedContentInfo = encryptedContentInfo;
            this.authAttrs = aSN1Set2;
            if (encryptedContentInfo.getContentType().equals((ASN1Primitive) CMSObjectIdentifiers.data) || !(aSN1Set2 == null || aSN1Set2.size() == 0)) {
                this.mac = aSN1OctetString;
                this.unauthAttrs = aSN1Set3;
                return;
            }
            throw new IllegalArgumentException("authAttrs must be present with non-data content");
        }
        throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
    }

    public static AuthEnvelopedData getInstance(Object obj) {
        if (obj instanceof AuthEnvelopedData) {
            return (AuthEnvelopedData) obj;
        }
        if (obj != null) {
            return new AuthEnvelopedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static AuthEnvelopedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z11));
    }

    public ASN1Set getAuthAttrs() {
        return this.authAttrs;
    }

    public EncryptedContentInfo getAuthEncryptedContentInfo() {
        return this.authEncryptedContentInfo;
    }

    public ASN1OctetString getMac() {
        return this.mac;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.originatorInfo;
    }

    public ASN1Set getRecipientInfos() {
        return this.recipientInfos;
    }

    public ASN1Set getUnauthAttrs() {
        return this.unauthAttrs;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(7);
        aSN1EncodableVector.add(this.version);
        OriginatorInfo originatorInfo2 = this.originatorInfo;
        if (originatorInfo2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable) originatorInfo2));
        }
        aSN1EncodableVector.add(this.recipientInfos);
        aSN1EncodableVector.add(this.authEncryptedContentInfo);
        ASN1Set aSN1Set = this.authAttrs;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable) aSN1Set));
        }
        aSN1EncodableVector.add(this.mac);
        ASN1Set aSN1Set2 = this.unauthAttrs;
        if (aSN1Set2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, (ASN1Encodable) aSN1Set2));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
