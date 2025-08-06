package org.bouncycastle.oer.its.template.etsi103097.extension;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.oer.Element;
import org.bouncycastle.oer.OERDefinition;
import org.bouncycastle.oer.Switch;
import org.bouncycastle.oer.SwitchIndexer;
import org.bouncycastle.oer.its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;

public class EtsiTs103097ExtensionModule {
    public static final OERDefinition.Builder EtsiOriginatingHeaderInfoExtension;
    public static final OERDefinition.Builder EtsiTs102941CrlRequest;
    public static final OERDefinition.Builder EtsiTs102941CtlRequest;
    public static final OERDefinition.Builder EtsiTs102941DeltaCtlRequest;
    public static final OERDefinition.Builder ExtId;
    public static final OERDefinition.Builder Extension;
    public static final ASN1Integer etsiTs102941CrlRequestId;
    public static final ASN1Integer etsiTs102941DeltaCtlRequestId;
    /* access modifiers changed from: private */
    public static final ASN1Encodable[] extensionKeys;

    static {
        ASN1Integer aSN1Integer = new ASN1Integer(1);
        etsiTs102941CrlRequestId = aSN1Integer;
        ASN1Integer aSN1Integer2 = new ASN1Integer(2);
        etsiTs102941DeltaCtlRequestId = aSN1Integer2;
        extensionKeys = new ASN1Encodable[]{aSN1Integer, aSN1Integer2};
        OERDefinition.Builder typeName = OERDefinition.integer(0, 255).validSwitchValue(aSN1Integer, aSN1Integer2).typeName("ExtId");
        ExtId = typeName;
        OERDefinition.Builder builder = Ieee1609Dot2BaseTypes.HashedId8;
        EtsiTs102941CrlRequest = OERDefinition.seq(builder.label("issuerId"), OERDefinition.optional(Ieee1609Dot2BaseTypes.Time32.label("lastKnownUpdate"))).typeName("EtsiTs102941CrlRequest");
        OERDefinition.Builder typeName2 = OERDefinition.seq(builder.label("issuerId"), OERDefinition.optional(OERDefinition.integer(0, 255).label("lastKnownCtlSequence"))).typeName("EtsiTs102941CtlRequest");
        EtsiTs102941CtlRequest = typeName2;
        EtsiTs102941DeltaCtlRequest = typeName2.typeName("EtsiTs102941DeltaCtlRequest");
        OERDefinition.Builder typeName3 = OERDefinition.seq(typeName.label("id"), OERDefinition.aSwitch(new Switch() {
            private final Element etsiTs102941CrlRequestIdDef = EtsiTs103097ExtensionModule.EtsiTs102941CrlRequest.label("content").build();
            private final Element etsiTs102941DeltaCtlRequestIdDef = EtsiTs103097ExtensionModule.EtsiTs102941DeltaCtlRequest.label("content").build();

            public ASN1Encodable[] keys() {
                return EtsiTs103097ExtensionModule.extensionKeys;
            }

            public Element result(SwitchIndexer switchIndexer) {
                ASN1Integer instance = ASN1Integer.getInstance(switchIndexer.get(0).toASN1Primitive());
                if (instance.equals((ASN1Primitive) EtsiTs103097ExtensionModule.etsiTs102941CrlRequestId)) {
                    return this.etsiTs102941CrlRequestIdDef;
                }
                if (instance.equals((ASN1Primitive) EtsiTs103097ExtensionModule.etsiTs102941DeltaCtlRequestId)) {
                    return this.etsiTs102941DeltaCtlRequestIdDef;
                }
                throw new IllegalStateException("unknown extension type " + instance);
            }
        }).label("content")).typeName("Extension");
        Extension = typeName3;
        EtsiOriginatingHeaderInfoExtension = typeName3.typeName("EtsiOriginatingHeaderInfoExtension");
    }
}
