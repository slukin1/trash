package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1PrintableString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.DirectoryString;

public class ProfessionInfo extends ASN1Object {
    public static final ASN1ObjectIdentifier Notar;
    public static final ASN1ObjectIdentifier Notariatsverwalter;
    public static final ASN1ObjectIdentifier Notariatsverwalterin;
    public static final ASN1ObjectIdentifier Notarin;
    public static final ASN1ObjectIdentifier Notarvertreter;
    public static final ASN1ObjectIdentifier Notarvertreterin;
    public static final ASN1ObjectIdentifier Patentanwalt;
    public static final ASN1ObjectIdentifier Patentanwltin;
    public static final ASN1ObjectIdentifier Rechtsanwalt;
    public static final ASN1ObjectIdentifier Rechtsanwltin;
    public static final ASN1ObjectIdentifier Rechtsbeistand;
    public static final ASN1ObjectIdentifier Steuerberater;
    public static final ASN1ObjectIdentifier Steuerberaterin;
    public static final ASN1ObjectIdentifier Steuerbevollmchtigte;
    public static final ASN1ObjectIdentifier Steuerbevollmchtigter;
    public static final ASN1ObjectIdentifier VereidigteBuchprferin;
    public static final ASN1ObjectIdentifier VereidigterBuchprfer;
    public static final ASN1ObjectIdentifier Wirtschaftsprfer;
    public static final ASN1ObjectIdentifier Wirtschaftsprferin;
    private ASN1OctetString addProfessionInfo;
    private NamingAuthority namingAuthority;
    private ASN1Sequence professionItems;
    private ASN1Sequence professionOIDs;
    private String registrationNumber;

    static {
        StringBuilder sb2 = new StringBuilder();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern;
        sb2.append(aSN1ObjectIdentifier);
        sb2.append(".1");
        Rechtsanwltin = new ASN1ObjectIdentifier(sb2.toString());
        Rechtsanwalt = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".2");
        Rechtsbeistand = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".3");
        Steuerberaterin = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".4");
        Steuerberater = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".5");
        Steuerbevollmchtigte = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".6");
        Steuerbevollmchtigter = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".7");
        Notarin = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".8");
        Notar = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".9");
        Notarvertreterin = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".10");
        Notarvertreter = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".11");
        Notariatsverwalterin = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".12");
        Notariatsverwalter = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".13");
        Wirtschaftsprferin = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".14");
        Wirtschaftsprfer = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".15");
        VereidigteBuchprferin = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".16");
        VereidigterBuchprfer = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".17");
        Patentanwltin = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".18");
        Patentanwalt = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".19");
    }

    private ProfessionInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() <= 5) {
            Enumeration objects = aSN1Sequence.getObjects();
            ASN1Encodable aSN1Encodable = (ASN1Encodable) objects.nextElement();
            if (aSN1Encodable instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Encodable;
                if (aSN1TaggedObject.getTagNo() == 0) {
                    this.namingAuthority = NamingAuthority.getInstance(aSN1TaggedObject, true);
                    aSN1Encodable = (ASN1Encodable) objects.nextElement();
                } else {
                    throw new IllegalArgumentException("Bad tag number: " + aSN1TaggedObject.getTagNo());
                }
            }
            this.professionItems = ASN1Sequence.getInstance(aSN1Encodable);
            if (objects.hasMoreElements()) {
                ASN1Encodable aSN1Encodable2 = (ASN1Encodable) objects.nextElement();
                if (aSN1Encodable2 instanceof ASN1Sequence) {
                    this.professionOIDs = ASN1Sequence.getInstance(aSN1Encodable2);
                } else if (aSN1Encodable2 instanceof ASN1PrintableString) {
                    this.registrationNumber = ASN1PrintableString.getInstance(aSN1Encodable2).getString();
                } else if (aSN1Encodable2 instanceof ASN1OctetString) {
                    this.addProfessionInfo = ASN1OctetString.getInstance(aSN1Encodable2);
                } else {
                    throw new IllegalArgumentException("Bad object encountered: " + aSN1Encodable2.getClass());
                }
            }
            if (objects.hasMoreElements()) {
                ASN1Encodable aSN1Encodable3 = (ASN1Encodable) objects.nextElement();
                if (aSN1Encodable3 instanceof ASN1PrintableString) {
                    this.registrationNumber = ASN1PrintableString.getInstance(aSN1Encodable3).getString();
                } else if (aSN1Encodable3 instanceof DEROctetString) {
                    this.addProfessionInfo = (DEROctetString) aSN1Encodable3;
                } else {
                    throw new IllegalArgumentException("Bad object encountered: " + aSN1Encodable3.getClass());
                }
            }
            if (objects.hasMoreElements()) {
                ASN1Encodable aSN1Encodable4 = (ASN1Encodable) objects.nextElement();
                if (aSN1Encodable4 instanceof DEROctetString) {
                    this.addProfessionInfo = (DEROctetString) aSN1Encodable4;
                    return;
                }
                throw new IllegalArgumentException("Bad object encountered: " + aSN1Encodable4.getClass());
            }
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public ProfessionInfo(NamingAuthority namingAuthority2, DirectoryString[] directoryStringArr, ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr, String str, ASN1OctetString aSN1OctetString) {
        this.namingAuthority = namingAuthority2;
        this.professionItems = new DERSequence((ASN1Encodable[]) directoryStringArr);
        if (aSN1ObjectIdentifierArr != null) {
            this.professionOIDs = new DERSequence((ASN1Encodable[]) aSN1ObjectIdentifierArr);
        }
        this.registrationNumber = str;
        this.addProfessionInfo = aSN1OctetString;
    }

    public static ProfessionInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof ProfessionInfo)) {
            return (ProfessionInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ProfessionInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public ASN1OctetString getAddProfessionInfo() {
        return this.addProfessionInfo;
    }

    public NamingAuthority getNamingAuthority() {
        return this.namingAuthority;
    }

    public DirectoryString[] getProfessionItems() {
        DirectoryString[] directoryStringArr = new DirectoryString[this.professionItems.size()];
        Enumeration objects = this.professionItems.getObjects();
        int i11 = 0;
        while (objects.hasMoreElements()) {
            directoryStringArr[i11] = DirectoryString.getInstance(objects.nextElement());
            i11++;
        }
        return directoryStringArr;
    }

    public ASN1ObjectIdentifier[] getProfessionOIDs() {
        ASN1Sequence aSN1Sequence = this.professionOIDs;
        int i11 = 0;
        if (aSN1Sequence == null) {
            return new ASN1ObjectIdentifier[0];
        }
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = new ASN1ObjectIdentifier[aSN1Sequence.size()];
        Enumeration objects = this.professionOIDs.getObjects();
        while (objects.hasMoreElements()) {
            aSN1ObjectIdentifierArr[i11] = ASN1ObjectIdentifier.getInstance(objects.nextElement());
            i11++;
        }
        return aSN1ObjectIdentifierArr;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        NamingAuthority namingAuthority2 = this.namingAuthority;
        if (namingAuthority2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable) namingAuthority2));
        }
        aSN1EncodableVector.add(this.professionItems);
        ASN1Sequence aSN1Sequence = this.professionOIDs;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        if (this.registrationNumber != null) {
            aSN1EncodableVector.add(new DERPrintableString(this.registrationNumber, true));
        }
        ASN1OctetString aSN1OctetString = this.addProfessionInfo;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(aSN1OctetString);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
