package org.bouncycastle.oer.its.template.ieee1609dot2;

import com.tencent.qcloud.tuicore.TUIConstants;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.oer.Element;
import org.bouncycastle.oer.ElementSupplier;
import org.bouncycastle.oer.OERDefinition;
import org.bouncycastle.oer.Switch;
import org.bouncycastle.oer.SwitchIndexer;
import org.bouncycastle.oer.its.template.etsi103097.extension.EtsiTs103097ExtensionModule;
import org.bouncycastle.oer.its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;
import org.bouncycastle.util.BigIntegers;

public class IEEE1609dot2 {
    public static final OERDefinition.Builder AesCcmCiphertext;
    public static final OERDefinition.Builder Certificate;
    public static final OERDefinition.Builder CertificateBase;
    public static final OERDefinition.Builder CertificateId;
    public static final OERDefinition.Builder CertificateType;
    public static final OERDefinition.Builder ContributedExtensionBlock;
    public static final Switch ContributedExtensionBlockSwitch;
    public static final OERDefinition.Builder ContributedExtensionBlocks;
    public static final OERDefinition.Builder CounterSignature;
    public static final OERDefinition.Builder EncryptedData;
    public static final OERDefinition.Builder EncryptedDataEncryptionKey;
    public static final OERDefinition.Builder EndEntityType;
    public static final OERDefinition.Builder ExplicitCertificate;
    public static final OERDefinition.Builder HashedData;
    public static final OERDefinition.Builder HeaderInfo;
    public static final OERDefinition.Builder HeaderInfoContributorId;
    public static final OERDefinition.Builder Ieee1609Dot2Content;
    public static final OERDefinition.Builder Ieee1609Dot2Data;
    public static final OERDefinition.Builder ImplicitCertificate;
    public static final OERDefinition.Builder IssuerIdentifier;
    public static final OERDefinition.Builder LinkageData;
    public static final OERDefinition.Builder MissingCrlIdentifier;
    public static final OERDefinition.Builder Opaque;
    public static final OERDefinition.Builder PKRecipientInfo;
    public static final OERDefinition.Builder PduFunctionalType;
    public static final OERDefinition.Builder PreSharedKeyRecipientInfo;
    public static final OERDefinition.Builder PsidGroupPermissions;
    public static final OERDefinition.Builder RecipientInfo;
    public static final OERDefinition.Builder SequenceOfCertificate;
    public static final OERDefinition.Builder SequenceOfPsidGroupPermissions;
    public static final OERDefinition.Builder SequenceOfRecipientInfo;
    public static final OERDefinition.Builder SignedData;
    public static final OERDefinition.Builder SignedDataPayload;
    public static final OERDefinition.Builder SignerIdentifier;
    public static final OERDefinition.Builder SubjectPermissions;
    public static final OERDefinition.Builder SymmRecipientInfo;
    public static final OERDefinition.Builder SymmetricCiphertext;
    public static final OERDefinition.Builder ToBeSignedCertificate;
    public static final OERDefinition.Builder ToBeSignedData;
    public static final OERDefinition.Builder VerificationKeyIndicator;
    /* access modifiers changed from: private */
    public static final ASN1Integer etsiHeaderInfoContributorId;
    private static ASN1Integer explicitOrdinal = new ASN1Integer(BigInteger.ZERO);
    /* access modifiers changed from: private */
    public static final ASN1Encodable[] extensionBlockSwitchKeys;
    private static ASN1Integer implicitOrdinal = new ASN1Integer(BigInteger.ONE);

    static {
        OERDefinition.Builder typeName = OERDefinition.octets().typeName("Opaque");
        Opaque = typeName;
        OERDefinition.Builder typeName2 = OERDefinition.integer(0, 255).typeName("PduFunctionalType");
        PduFunctionalType = typeName2;
        OERDefinition.Builder typeName3 = OERDefinition.choice(OERDefinition.octets(32).label("sha256HashedData"), OERDefinition.extension(OERDefinition.octets(48).label("sha384HashedData"), OERDefinition.octets(32).label("reserved"))).typeName("HashedData");
        HashedData = typeName3;
        OERDefinition.Builder builder = Ieee1609Dot2BaseTypes.HashedId3;
        OERDefinition.Builder builder2 = Ieee1609Dot2BaseTypes.CrlSeries;
        OERDefinition.Builder typeName4 = OERDefinition.seq(builder.label("cracaId"), builder2.label("crlSeries"), OERDefinition.extension(new Object[0])).typeName("MissingCrlIdentifier");
        MissingCrlIdentifier = typeName4;
        ASN1Integer aSN1Integer = new ASN1Integer(BigIntegers.TWO);
        etsiHeaderInfoContributorId = aSN1Integer;
        extensionBlockSwitchKeys = new ASN1Encodable[]{aSN1Integer};
        OERDefinition.Builder validSwitchValue = OERDefinition.integer(0, 255).typeName("HeaderInfoContributorId").validSwitchValue(aSN1Integer);
        HeaderInfoContributorId = validSwitchValue;
        AnonymousClass1 r42 = new Switch() {
            public ASN1Encodable[] keys() {
                return IEEE1609dot2.extensionBlockSwitchKeys;
            }

            public Element result(SwitchIndexer switchIndexer) {
                ASN1Integer instance = ASN1Integer.getInstance(switchIndexer.get(0).toASN1Primitive());
                if (instance.equals((ASN1Primitive) IEEE1609dot2.etsiHeaderInfoContributorId)) {
                    return OERDefinition.seqof(EtsiTs103097ExtensionModule.EtsiOriginatingHeaderInfoExtension).rangeToMAXFrom(1).label("extns").build();
                }
                throw new IllegalArgumentException("No forward definition for type id " + instance);
            }
        };
        ContributedExtensionBlockSwitch = r42;
        OERDefinition.Builder typeName5 = OERDefinition.seq(validSwitchValue.label("contributorId"), OERDefinition.aSwitch(r42).label("Extn")).typeName("ContributedExtensionBlock");
        ContributedExtensionBlock = typeName5;
        OERDefinition.Builder typeName6 = OERDefinition.seqof(typeName5).rangeToMAXFrom(1).typeName("ContributedExtensionBlocks");
        ContributedExtensionBlocks = typeName6;
        OERDefinition.Builder builder3 = Ieee1609Dot2BaseTypes.HashedId8;
        OERDefinition.Builder typeName7 = builder3.typeName("PreSharedKeyRecipientInfo");
        PreSharedKeyRecipientInfo = typeName7;
        OERDefinition.Builder builder4 = Ieee1609Dot2BaseTypes.EciesP256EncryptedKey;
        OERDefinition.Builder typeName8 = OERDefinition.choice(builder4.label("eciesNistP256"), builder4.label("eciesBrainpoolP256r1"), OERDefinition.extension(new Object[0])).typeName("EncryptedDataEncryptionKey");
        EncryptedDataEncryptionKey = typeName8;
        OERDefinition.Builder typeName9 = OERDefinition.seq(builder3.label("recipientId"), typeName8.label("encKey")).typeName("PKRecipientInfo");
        PKRecipientInfo = typeName9;
        OERDefinition.Builder builder5 = typeName3;
        OERDefinition.Builder typeName10 = OERDefinition.seq(OERDefinition.octets(12).label("nonce"), typeName.label("ccmCiphertext")).typeName("AesCcmCiphertext");
        AesCcmCiphertext = typeName10;
        OERDefinition.Builder typeName11 = OERDefinition.choice(typeName10.label("aes128ccm"), OERDefinition.extension(new Object[0])).typeName("SymmetricCiphertext");
        SymmetricCiphertext = typeName11;
        OERDefinition.Builder builder6 = typeName;
        OERDefinition.Builder typeName12 = OERDefinition.seq(builder3.label("recipientId"), typeName11.label("encKey")).typeName("SymmRecipientInfo");
        SymmRecipientInfo = typeName12;
        OERDefinition.Builder typeName13 = OERDefinition.choice(typeName7.label("pskRecipInfo"), typeName12.label("symmRecipInfo"), typeName9.label("certRecipInfo"), typeName9.label("signedDataRecipInfo"), typeName9.label("rekRecipInfo")).typeName("RecipientInfo");
        RecipientInfo = typeName13;
        OERDefinition.Builder typeName14 = OERDefinition.seqof(typeName13).typeName("SequenceOfRecipientInfo");
        SequenceOfRecipientInfo = typeName14;
        OERDefinition.Builder typeName15 = OERDefinition.seq(typeName14.label("recipients"), typeName11.label("ciphertext")).typeName("EncryptedData");
        EncryptedData = typeName15;
        OERDefinition.Builder typeName16 = OERDefinition.bitString(8).defaultValue(new DERBitString(new byte[]{0}, 0)).typeName("EndEntityType");
        EndEntityType = typeName16;
        OERDefinition.Builder typeName17 = OERDefinition.choice(Ieee1609Dot2BaseTypes.SequenceOfPsidSspRange.label("explicit"), OERDefinition.nullValue().label(TtmlNode.COMBINE_ALL), OERDefinition.extension(new Object[0])).typeName("SubjectPermissions");
        SubjectPermissions = typeName17;
        OERDefinition.Builder typeName18 = OERDefinition.choice(Ieee1609Dot2BaseTypes.PublicVerificationKey.label("verificationKey"), Ieee1609Dot2BaseTypes.EccP256CurvePoint.label("reconstructionValue"), OERDefinition.extension(new Object[0])).typeName("VerificationKeyIndicator");
        VerificationKeyIndicator = typeName18;
        OERDefinition.Builder typeName19 = OERDefinition.seq(typeName17.label("subjectPermissions"), OERDefinition.integer(1).label("minChainLength"), OERDefinition.integer(0).label("chainLengthRange"), typeName16.label("eeType")).typeName("PsidGroupPermissions");
        PsidGroupPermissions = typeName19;
        OERDefinition.Builder typeName20 = OERDefinition.seqof(typeName19).typeName("SequenceOfPsidGroupPermissions");
        SequenceOfPsidGroupPermissions = typeName20;
        OERDefinition.Builder builder7 = typeName15;
        OERDefinition.Builder typeName21 = OERDefinition.seq(Ieee1609Dot2BaseTypes.IValue.label("iCert"), Ieee1609Dot2BaseTypes.LinkageValue.label("linkageValue"), OERDefinition.optional(Ieee1609Dot2BaseTypes.GroupLinkageValue.label("groupLinkageValue")), OERDefinition.extension(new Object[0])).typeName("LinkageData");
        LinkageData = typeName21;
        OERDefinition.Builder typeName22 = OERDefinition.choice(typeName21.label("linkageData"), Ieee1609Dot2BaseTypes.Hostname.label("name"), OERDefinition.octets(1, 64).label("binaryId"), OERDefinition.nullValue().label("none"), OERDefinition.extension(new Object[0])).typeName("CertificateId");
        CertificateId = typeName22;
        OERDefinition.Builder typeName23 = OERDefinition.seq(typeName22.label("id"), builder.label("cracaId"), builder2.label("crlSeries"), Ieee1609Dot2BaseTypes.ValidityPeriod.label("validityPeriod"), OERDefinition.optional(Ieee1609Dot2BaseTypes.GeographicRegion.label(TtmlNode.TAG_REGION), Ieee1609Dot2BaseTypes.SubjectAssurance.label("assuranceLevel"), Ieee1609Dot2BaseTypes.SequenceOfPsidSsp.label("appPermissions"), typeName20.label("certIssuePermissions"), typeName20.label("certRequestPermissions"), OERDefinition.nullValue().label("canRequestRollover"), Ieee1609Dot2BaseTypes.PublicEncryptionKey.label("encryptionKey")), typeName18.label("verifyKeyIndicator"), OERDefinition.extension(new Object[0])).typeName("ToBeSignedCertificate");
        ToBeSignedCertificate = typeName23;
        OERDefinition.Builder builder8 = Ieee1609Dot2BaseTypes.HashAlgorithm;
        OERDefinition.Builder typeName24 = OERDefinition.choice(builder3.label("sha256AndDigest"), builder8.label("self"), OERDefinition.extension(builder3.label("sha384AndDigest"))).typeName("IssuerIdentifier");
        IssuerIdentifier = typeName24;
        OERDefinition.Builder typeName25 = OERDefinition.enumeration(OERDefinition.enumItem("explicit"), OERDefinition.enumItem("implicit"), OERDefinition.extension(new Object[0])).typeName("CertificateType");
        CertificateType = typeName25;
        OERDefinition.Builder builder9 = Ieee1609Dot2BaseTypes.UINT8;
        OERDefinition.Builder builder10 = Ieee1609Dot2BaseTypes.Signature;
        OERDefinition.Builder typeName26 = OERDefinition.seq(builder9.label("version"), typeName25.label("type"), typeName24.label("issuer"), typeName23.label("toBeSigned"), OERDefinition.optional(builder10.label(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE))).label(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE).typeName("CertificateBase");
        CertificateBase = typeName26;
        OERDefinition.Builder typeName27 = typeName26.copy().typeName("Certificate");
        Certificate = typeName27;
        OERDefinition.Builder builder11 = builder10;
        ExplicitCertificate = typeName26.typeName("ExplicitCertificate").replaceChild(1, typeName25.validSwitchValue(explicitOrdinal).label("type"));
        ImplicitCertificate = typeName26.typeName("ImplicitCertificate").replaceChild(1, typeName25.validSwitchValue(implicitOrdinal).label("type"));
        OERDefinition.Builder typeName28 = OERDefinition.seqof(typeName27).typeName("SequenceOfCertificate");
        SequenceOfCertificate = typeName28;
        OERDefinition.Builder typeName29 = OERDefinition.choice(builder3.label("digest"), typeName28.label("certificate"), OERDefinition.nullValue().label("self"), OERDefinition.extension(new Object[0])).typeName("SignerIdentifier");
        SignerIdentifier = typeName29;
        OERDefinition.Builder builder12 = Ieee1609Dot2BaseTypes.Time64;
        OERDefinition.Builder typeName30 = OERDefinition.seq(Ieee1609Dot2BaseTypes.Psid.label("psid"), OERDefinition.optional(builder12.label("generationTime"), builder12.label("expiryTime"), Ieee1609Dot2BaseTypes.ThreeDLocation.label("generationLocation"), builder.label("p2pcdLearningRequest"), typeName4.label("missingCrlIdentifier"), Ieee1609Dot2BaseTypes.EncryptionKey.label("encryptionKey")), OERDefinition.extension(OERDefinition.optional(Ieee1609Dot2BaseTypes.SequenceOfHashedId3.label("inlineP2pcdRequest"), typeName27.label("requestedCertificate"), typeName2.label("pduFunctionalType"), typeName6.label("contributedExtensions")))).typeName("HeaderInfo");
        HeaderInfo = typeName30;
        SignedData = OERDefinition.seq(builder8.label("hashId"), OERDefinition.deferred(new ElementSupplier() {
            private Element built;

            public Element build() {
                Element element;
                synchronized (this) {
                    if (this.built == null) {
                        this.built = IEEE1609dot2.ToBeSignedData.label("tbsData").build();
                    }
                    element = this.built;
                }
                return element;
            }
        }).label("tbsData"), typeName29.label("signer"), builder11.label(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE)).typeName("SignedData");
        OERDefinition.Builder builder13 = builder6;
        OERDefinition.Builder typeName31 = OERDefinition.choice(builder13.label("unsecuredData"), OERDefinition.deferred(new ElementSupplier() {
            private Element built;

            public Element build() {
                Element element;
                synchronized (this) {
                    if (this.built == null) {
                        this.built = IEEE1609dot2.SignedData.label("signedData").mayRecurse(true).build();
                    }
                    element = this.built;
                }
                return element;
            }
        }).label("signedData").mayRecurse(true), builder7.label("encryptedData"), builder13.label("signedCertificateRequest"), OERDefinition.extension(new Object[0])).typeName("Ieee1609Dot2Content");
        Ieee1609Dot2Content = typeName31;
        OERDefinition.Builder builder14 = builder9;
        CounterSignature = OERDefinition.seq(builder14.label("protocolVersion"), typeName31.label("content")).typeName("CounterSignature");
        OERDefinition.Builder typeName32 = OERDefinition.seq(builder14.validSwitchValue(new ASN1Integer(3)).label("protocolVersion"), typeName31.label("content")).typeName("Ieee1609Dot2Data");
        Ieee1609Dot2Data = typeName32;
        OERDefinition.Builder typeName33 = OERDefinition.seq(OERDefinition.optional(typeName32.label("data"), builder5.label("extDataHash")), OERDefinition.extension(new Object[0])).typeName("SignedDataPayload");
        SignedDataPayload = typeName33;
        ToBeSignedData = OERDefinition.seq(typeName33.label("payload"), typeName30.label("headerInfo")).typeName("ToBeSignedData");
    }
}
