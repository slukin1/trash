package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1Util {
    public static ASN1TaggedObject checkTag(ASN1TaggedObject aSN1TaggedObject, int i11, int i12) {
        if (aSN1TaggedObject.hasTag(i11, i12)) {
            return aSN1TaggedObject;
        }
        String tagText = getTagText(i11, i12);
        String tagText2 = getTagText(aSN1TaggedObject);
        throw new IllegalStateException("Expected " + tagText + " tag but found " + tagText2);
    }

    public static ASN1TaggedObjectParser checkTag(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12) {
        if (aSN1TaggedObjectParser.hasTag(i11, i12)) {
            return aSN1TaggedObjectParser;
        }
        String tagText = getTagText(i11, i12);
        String tagText2 = getTagText(aSN1TaggedObjectParser);
        throw new IllegalStateException("Expected " + tagText + " tag but found " + tagText2);
    }

    public static ASN1Primitive getBaseUniversal(ASN1TaggedObject aSN1TaggedObject, int i11, int i12, boolean z11, int i13) {
        return checkTag(aSN1TaggedObject, i11, i12).getBaseUniversal(z11, i13);
    }

    public static ASN1Primitive getContextBaseUniversal(ASN1TaggedObject aSN1TaggedObject, int i11, boolean z11, int i12) {
        return getBaseUniversal(aSN1TaggedObject, 128, i11, z11, i12);
    }

    public static ASN1Object getExplicitBaseObject(ASN1TaggedObject aSN1TaggedObject, int i11, int i12) {
        return checkTag(aSN1TaggedObject, i11, i12).getExplicitBaseObject();
    }

    public static ASN1TaggedObject getExplicitBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i11, int i12) {
        return checkTag(aSN1TaggedObject, i11, i12).getExplicitBaseTagged();
    }

    public static ASN1Object getExplicitContextBaseObject(ASN1TaggedObject aSN1TaggedObject, int i11) {
        return getExplicitBaseObject(aSN1TaggedObject, 128, i11);
    }

    public static ASN1TaggedObject getExplicitContextBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i11) {
        return getExplicitBaseTagged(aSN1TaggedObject, 128, i11);
    }

    public static ASN1TaggedObject getImplicitBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i11, int i12, int i13, int i14) {
        return checkTag(aSN1TaggedObject, i11, i12).getImplicitBaseTagged(i13, i14);
    }

    public static ASN1TaggedObject getImplicitContextBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i11, int i12, int i13) {
        return getImplicitBaseTagged(aSN1TaggedObject, 128, i11, i12, i13);
    }

    public static String getTagText(int i11, int i12) {
        StringBuilder sb2;
        String str;
        if (i11 == 64) {
            sb2 = new StringBuilder();
            str = "[APPLICATION ";
        } else if (i11 == 128) {
            sb2 = new StringBuilder();
            str = "[CONTEXT ";
        } else if (i11 != 192) {
            sb2 = new StringBuilder();
            str = "[UNIVERSAL ";
        } else {
            sb2 = new StringBuilder();
            str = "[PRIVATE ";
        }
        sb2.append(str);
        sb2.append(i12);
        sb2.append("]");
        return sb2.toString();
    }

    public static String getTagText(ASN1Tag aSN1Tag) {
        return getTagText(aSN1Tag.getTagClass(), aSN1Tag.getTagNumber());
    }

    public static String getTagText(ASN1TaggedObject aSN1TaggedObject) {
        return getTagText(aSN1TaggedObject.getTagClass(), aSN1TaggedObject.getTagNo());
    }

    public static String getTagText(ASN1TaggedObjectParser aSN1TaggedObjectParser) {
        return getTagText(aSN1TaggedObjectParser.getTagClass(), aSN1TaggedObjectParser.getTagNo());
    }

    public static ASN1Encodable parseBaseUniversal(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12, boolean z11, int i13) throws IOException {
        return checkTag(aSN1TaggedObjectParser, i11, i12).parseBaseUniversal(z11, i13);
    }

    public static ASN1Encodable parseContextBaseUniversal(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, boolean z11, int i12) throws IOException {
        return parseBaseUniversal(aSN1TaggedObjectParser, 128, i11, z11, i12);
    }

    public static ASN1Encodable parseExplicitBaseObject(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12) throws IOException {
        return checkTag(aSN1TaggedObjectParser, i11, i12).parseExplicitBaseObject();
    }

    public static ASN1TaggedObjectParser parseExplicitBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12) throws IOException {
        return checkTag(aSN1TaggedObjectParser, i11, i12).parseExplicitBaseTagged();
    }

    public static ASN1Encodable parseExplicitContextBaseObject(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11) throws IOException {
        return parseExplicitBaseObject(aSN1TaggedObjectParser, 128, i11);
    }

    public static ASN1TaggedObjectParser parseExplicitContextBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11) throws IOException {
        return parseExplicitBaseTagged(aSN1TaggedObjectParser, 128, i11);
    }

    public static ASN1TaggedObjectParser parseImplicitBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12, int i13, int i14) throws IOException {
        return checkTag(aSN1TaggedObjectParser, i11, i12).parseImplicitBaseTagged(i13, i14);
    }

    public static ASN1TaggedObjectParser parseImplicitContextBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12, int i13) throws IOException {
        return parseImplicitBaseTagged(aSN1TaggedObjectParser, 128, i11, i12, i13);
    }

    public static ASN1Primitive tryGetBaseUniversal(ASN1TaggedObject aSN1TaggedObject, int i11, int i12, boolean z11, int i13) {
        if (!aSN1TaggedObject.hasTag(i11, i12)) {
            return null;
        }
        return aSN1TaggedObject.getBaseUniversal(z11, i13);
    }

    public static ASN1Primitive tryGetContextBaseUniversal(ASN1TaggedObject aSN1TaggedObject, int i11, boolean z11, int i12) {
        return tryGetBaseUniversal(aSN1TaggedObject, 128, i11, z11, i12);
    }

    public static ASN1Object tryGetExplicitBaseObject(ASN1TaggedObject aSN1TaggedObject, int i11, int i12) {
        if (!aSN1TaggedObject.hasTag(i11, i12)) {
            return null;
        }
        return aSN1TaggedObject.getExplicitBaseObject();
    }

    public static ASN1TaggedObject tryGetExplicitBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i11, int i12) {
        if (!aSN1TaggedObject.hasTag(i11, i12)) {
            return null;
        }
        return aSN1TaggedObject.getExplicitBaseTagged();
    }

    public static ASN1Object tryGetExplicitContextBaseObject(ASN1TaggedObject aSN1TaggedObject, int i11) {
        return tryGetExplicitBaseObject(aSN1TaggedObject, 128, i11);
    }

    public static ASN1TaggedObject tryGetExplicitContextBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i11) {
        return tryGetExplicitBaseTagged(aSN1TaggedObject, 128, i11);
    }

    public static ASN1TaggedObject tryGetImplicitBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i11, int i12, int i13, int i14) {
        if (!aSN1TaggedObject.hasTag(i11, i12)) {
            return null;
        }
        return aSN1TaggedObject.getImplicitBaseTagged(i13, i14);
    }

    public static ASN1TaggedObject tryGetImplicitContextBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i11, int i12, int i13) {
        return tryGetImplicitBaseTagged(aSN1TaggedObject, 128, i11, i12, i13);
    }

    public static ASN1Encodable tryParseBaseUniversal(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12, boolean z11, int i13) throws IOException {
        if (!aSN1TaggedObjectParser.hasTag(i11, i12)) {
            return null;
        }
        return aSN1TaggedObjectParser.parseBaseUniversal(z11, i13);
    }

    public static ASN1Encodable tryParseContextBaseUniversal(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, boolean z11, int i12) throws IOException {
        return tryParseBaseUniversal(aSN1TaggedObjectParser, 128, i11, z11, i12);
    }

    public static ASN1Encodable tryParseExplicitBaseObject(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12) throws IOException {
        if (!aSN1TaggedObjectParser.hasTag(i11, i12)) {
            return null;
        }
        return aSN1TaggedObjectParser.parseExplicitBaseObject();
    }

    public static ASN1TaggedObjectParser tryParseExplicitBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12) throws IOException {
        if (!aSN1TaggedObjectParser.hasTag(i11, i12)) {
            return null;
        }
        return aSN1TaggedObjectParser.parseExplicitBaseTagged();
    }

    public static ASN1Encodable tryParseExplicitContextBaseObject(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11) throws IOException {
        return tryParseExplicitBaseObject(aSN1TaggedObjectParser, 128, i11);
    }

    public static ASN1TaggedObjectParser tryParseExplicitContextBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11) throws IOException {
        return tryParseExplicitBaseTagged(aSN1TaggedObjectParser, 128, i11);
    }

    public static ASN1TaggedObjectParser tryParseImplicitBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12, int i13, int i14) throws IOException {
        if (!aSN1TaggedObjectParser.hasTag(i11, i12)) {
            return null;
        }
        return aSN1TaggedObjectParser.parseImplicitBaseTagged(i13, i14);
    }

    public static ASN1TaggedObjectParser tryParseImplicitContextBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i11, int i12, int i13) throws IOException {
        return tryParseImplicitBaseTagged(aSN1TaggedObjectParser, 128, i11, i12, i13);
    }
}
