package org.bouncycastle.asn1.x500.style;

import com.sumsub.sns.internal.core.common.n0;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1UniversalString;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class IETFUtils {
    public static void appendRDN(StringBuffer stringBuffer, RDN rdn, Hashtable hashtable) {
        if (rdn.isMultiValued()) {
            AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
            boolean z11 = true;
            for (int i11 = 0; i11 != typesAndValues.length; i11++) {
                if (z11) {
                    z11 = false;
                } else {
                    stringBuffer.append('+');
                }
                appendTypeAndValue(stringBuffer, typesAndValues[i11], hashtable);
            }
        } else if (rdn.getFirst() != null) {
            appendTypeAndValue(stringBuffer, rdn.getFirst(), hashtable);
        }
    }

    public static void appendTypeAndValue(StringBuffer stringBuffer, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
        String str = (String) hashtable.get(attributeTypeAndValue.getType());
        if (str == null) {
            str = attributeTypeAndValue.getType().getId();
        }
        stringBuffer.append(str);
        stringBuffer.append('=');
        stringBuffer.append(valueToString(attributeTypeAndValue.getValue()));
    }

    private static boolean atvAreEqual(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return true;
        }
        return attributeTypeAndValue != null && attributeTypeAndValue2 != null && attributeTypeAndValue.getType().equals((ASN1Primitive) attributeTypeAndValue2.getType()) && canonicalString(attributeTypeAndValue.getValue()).equals(canonicalString(attributeTypeAndValue2.getValue()));
    }

    public static String canonicalString(ASN1Encodable aSN1Encodable) {
        return canonicalize(valueToString(aSN1Encodable));
    }

    public static String canonicalize(String str) {
        int i11 = 0;
        if (str.length() > 0 && str.charAt(0) == '#') {
            ASN1Primitive decodeObject = decodeObject(str);
            if (decodeObject instanceof ASN1String) {
                str = ((ASN1String) decodeObject).getString();
            }
        }
        String lowerCase = Strings.toLowerCase(str);
        int length = lowerCase.length();
        if (length < 2) {
            return lowerCase;
        }
        int i12 = length - 1;
        while (i11 < i12 && lowerCase.charAt(i11) == '\\' && lowerCase.charAt(i11 + 1) == ' ') {
            i11 += 2;
        }
        int i13 = i11 + 1;
        int i14 = i12;
        while (i14 > i13 && lowerCase.charAt(i14 - 1) == '\\' && lowerCase.charAt(i14) == ' ') {
            i14 -= 2;
        }
        if (i11 > 0 || i14 < i12) {
            lowerCase = lowerCase.substring(i11, i14 + 1);
        }
        return stripInternalSpaces(lowerCase);
    }

    private static int convertHex(char c11) {
        if ('0' <= c11 && c11 <= '9') {
            return c11 - '0';
        }
        return (('a' > c11 || c11 > 'f') ? c11 - 'A' : c11 - 'a') + 10;
    }

    public static ASN1ObjectIdentifier decodeAttrName(String str, Hashtable hashtable) {
        if (Strings.toUpperCase(str).startsWith("OID.")) {
            return new ASN1ObjectIdentifier(str.substring(4));
        }
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return new ASN1ObjectIdentifier(str);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) hashtable.get(Strings.toLowerCase(str));
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        throw new IllegalArgumentException("Unknown object id - " + str + " - passed to distinguished name");
    }

    private static ASN1Primitive decodeObject(String str) {
        try {
            return ASN1Primitive.fromByteArray(Hex.decodeStrict(str, 1, str.length() - 1));
        } catch (IOException e11) {
            throw new IllegalStateException("unknown encoding in name: " + e11);
        }
    }

    public static String[] findAttrNamesForOID(ASN1ObjectIdentifier aSN1ObjectIdentifier, Hashtable hashtable) {
        Enumeration elements = hashtable.elements();
        int i11 = 0;
        int i12 = 0;
        while (elements.hasMoreElements()) {
            if (aSN1ObjectIdentifier.equals(elements.nextElement())) {
                i12++;
            }
        }
        String[] strArr = new String[i12];
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            if (aSN1ObjectIdentifier.equals(hashtable.get(str))) {
                strArr[i11] = str;
                i11++;
            }
        }
        return strArr;
    }

    private static boolean isHexDigit(char c11) {
        return ('0' <= c11 && c11 <= '9') || ('a' <= c11 && c11 <= 'f') || ('A' <= c11 && c11 <= 'F');
    }

    public static boolean rDNAreEqual(RDN rdn, RDN rdn2) {
        if (rdn.size() != rdn2.size()) {
            return false;
        }
        AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
        AttributeTypeAndValue[] typesAndValues2 = rdn2.getTypesAndValues();
        if (typesAndValues.length != typesAndValues2.length) {
            return false;
        }
        for (int i11 = 0; i11 != typesAndValues.length; i11++) {
            if (!atvAreEqual(typesAndValues[i11], typesAndValues2[i11])) {
                return false;
            }
        }
        return true;
    }

    public static RDN[] rDNsFromString(String str, X500NameStyle x500NameStyle) {
        X500NameTokenizer x500NameTokenizer = new X500NameTokenizer(str);
        X500NameBuilder x500NameBuilder = new X500NameBuilder(x500NameStyle);
        while (x500NameTokenizer.hasMoreTokens()) {
            String nextToken = x500NameTokenizer.nextToken();
            if (nextToken.indexOf(43) > 0) {
                X500NameTokenizer x500NameTokenizer2 = new X500NameTokenizer(nextToken, '+');
                X500NameTokenizer x500NameTokenizer3 = new X500NameTokenizer(x500NameTokenizer2.nextToken(), '=');
                String nextToken2 = x500NameTokenizer3.nextToken();
                if (x500NameTokenizer3.hasMoreTokens()) {
                    String nextToken3 = x500NameTokenizer3.nextToken();
                    ASN1ObjectIdentifier attrNameToOID = x500NameStyle.attrNameToOID(nextToken2.trim());
                    if (x500NameTokenizer2.hasMoreTokens()) {
                        Vector vector = new Vector();
                        Vector vector2 = new Vector();
                        while (true) {
                            vector.addElement(attrNameToOID);
                            vector2.addElement(unescape(nextToken3));
                            if (!x500NameTokenizer2.hasMoreTokens()) {
                                x500NameBuilder.addMultiValuedRDN(toOIDArray(vector), toValueArray(vector2));
                                break;
                            }
                            X500NameTokenizer x500NameTokenizer4 = new X500NameTokenizer(x500NameTokenizer2.nextToken(), '=');
                            String nextToken4 = x500NameTokenizer4.nextToken();
                            if (x500NameTokenizer4.hasMoreTokens()) {
                                nextToken3 = x500NameTokenizer4.nextToken();
                                attrNameToOID = x500NameStyle.attrNameToOID(nextToken4.trim());
                            } else {
                                throw new IllegalArgumentException("badly formatted directory string");
                            }
                        }
                    } else {
                        x500NameBuilder.addRDN(attrNameToOID, unescape(nextToken3));
                    }
                } else {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
            } else {
                X500NameTokenizer x500NameTokenizer5 = new X500NameTokenizer(nextToken, '=');
                String nextToken5 = x500NameTokenizer5.nextToken();
                if (x500NameTokenizer5.hasMoreTokens()) {
                    x500NameBuilder.addRDN(x500NameStyle.attrNameToOID(nextToken5.trim()), unescape(x500NameTokenizer5.nextToken()));
                } else {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
            }
        }
        return x500NameBuilder.build().getRDNs();
    }

    public static String stripInternalSpaces(String str) {
        if (str.indexOf("  ") < 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        char charAt = str.charAt(0);
        stringBuffer.append(charAt);
        for (int i11 = 1; i11 < str.length(); i11++) {
            char charAt2 = str.charAt(i11);
            if (charAt != ' ' || charAt2 != ' ') {
                stringBuffer.append(charAt2);
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    private static ASN1ObjectIdentifier[] toOIDArray(Vector vector) {
        int size = vector.size();
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = new ASN1ObjectIdentifier[size];
        for (int i11 = 0; i11 != size; i11++) {
            aSN1ObjectIdentifierArr[i11] = (ASN1ObjectIdentifier) vector.elementAt(i11);
        }
        return aSN1ObjectIdentifierArr;
    }

    private static String[] toValueArray(Vector vector) {
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i11 = 0; i11 != size; i11++) {
            strArr[i11] = (String) vector.elementAt(i11);
        }
        return strArr;
    }

    private static String unescape(String str) {
        int i11;
        if (str.length() == 0 || (str.indexOf(92) < 0 && str.indexOf(34) < 0)) {
            return str.trim();
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(str.length());
        if (charArray[0] == '\\' && charArray[1] == '#') {
            i11 = 2;
            stringBuffer.append("\\#");
        } else {
            i11 = 0;
        }
        boolean z11 = false;
        int i12 = 0;
        boolean z12 = false;
        boolean z13 = false;
        char c11 = 0;
        while (i11 != charArray.length) {
            char c12 = charArray[i11];
            if (c12 != ' ') {
                z13 = true;
            }
            if (c12 == '\"') {
                if (!z11) {
                    z12 = !z12;
                }
                stringBuffer.append(c12);
            } else if (c12 == '\\' && !z11 && !z12) {
                i12 = stringBuffer.length();
                z11 = true;
                i11++;
            } else if (c12 != ' ' || z11 || z13) {
                if (z11 && isHexDigit(c12)) {
                    if (c11 != 0) {
                        stringBuffer.append((char) ((convertHex(c11) * 16) + convertHex(c12)));
                        z11 = false;
                        c11 = 0;
                    } else {
                        c11 = c12;
                    }
                    i11++;
                }
                stringBuffer.append(c12);
            } else {
                i11++;
            }
            z11 = false;
            i11++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.charAt(stringBuffer.length() - 1) == ' ' && i12 != stringBuffer.length() - 1) {
                stringBuffer.setLength(stringBuffer.length() - 1);
            }
        }
        return stringBuffer.toString();
    }

    public static ASN1Encodable valueFromHexString(String str, int i11) throws IOException {
        int length = (str.length() - i11) / 2;
        byte[] bArr = new byte[length];
        for (int i12 = 0; i12 != length; i12++) {
            int i13 = (i12 * 2) + i11;
            char charAt = str.charAt(i13);
            bArr[i12] = (byte) (convertHex(str.charAt(i13 + 1)) | (convertHex(charAt) << 4));
        }
        return ASN1Primitive.fromByteArray(bArr);
    }

    public static String valueToString(ASN1Encodable aSN1Encodable) {
        int i11;
        StringBuffer stringBuffer = new StringBuffer();
        int i12 = 0;
        if (!(aSN1Encodable instanceof ASN1String) || (aSN1Encodable instanceof ASN1UniversalString)) {
            try {
                stringBuffer.append(n0.h.f32179b);
                stringBuffer.append(Hex.toHexString(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER)));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        } else {
            String string = ((ASN1String) aSN1Encodable).getString();
            if (string.length() > 0 && string.charAt(0) == '#') {
                stringBuffer.append('\\');
            }
            stringBuffer.append(string);
        }
        int length = stringBuffer.length();
        int i13 = 2;
        if (!(stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#')) {
            i13 = 0;
        }
        while (i11 != length) {
            char charAt = stringBuffer.charAt(i11);
            if (!(charAt == '\"' || charAt == '\\' || charAt == '+' || charAt == ',')) {
                switch (charAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        i11++;
                        continue;
                }
            }
            stringBuffer.insert(i11, "\\");
            i11 += 2;
            length++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.length() > i12 && stringBuffer.charAt(i12) == ' ') {
                stringBuffer.insert(i12, "\\");
                i12 += 2;
            }
        }
        int length2 = stringBuffer.length() - 1;
        while (length2 >= 0 && stringBuffer.charAt(length2) == ' ') {
            stringBuffer.insert(length2, '\\');
            length2--;
        }
        return stringBuffer.toString();
    }
}
