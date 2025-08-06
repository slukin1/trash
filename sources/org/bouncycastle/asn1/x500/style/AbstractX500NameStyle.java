package org.bouncycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

public abstract class AbstractX500NameStyle implements X500NameStyle {
    private int calcHashCode(ASN1Encodable aSN1Encodable) {
        return IETFUtils.canonicalString(aSN1Encodable).hashCode();
    }

    public static Hashtable copyHashTable(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            hashtable2.put(nextElement, hashtable.get(nextElement));
        }
        return hashtable2;
    }

    private boolean foundMatch(boolean z11, RDN rdn, RDN[] rdnArr) {
        if (z11) {
            int length = rdnArr.length - 1;
            while (length >= 0) {
                if (rdnArr[length] == null || !rdnAreEqual(rdn, rdnArr[length])) {
                    length--;
                } else {
                    rdnArr[length] = null;
                    return true;
                }
            }
        } else {
            int i11 = 0;
            while (i11 != rdnArr.length) {
                if (rdnArr[i11] == null || !rdnAreEqual(rdn, rdnArr[i11])) {
                    i11++;
                } else {
                    rdnArr[i11] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean areEqual(X500Name x500Name, X500Name x500Name2) {
        RDN[] rDNs = x500Name.getRDNs();
        RDN[] rDNs2 = x500Name2.getRDNs();
        if (rDNs.length != rDNs2.length) {
            return false;
        }
        boolean z11 = (rDNs[0].getFirst() == null || rDNs2[0].getFirst() == null) ? false : !rDNs[0].getFirst().getType().equals((ASN1Primitive) rDNs2[0].getFirst().getType());
        for (int i11 = 0; i11 != rDNs.length; i11++) {
            if (!foundMatch(z11, rDNs[i11], rDNs2)) {
                return false;
            }
        }
        return true;
    }

    public int calculateHashCode(X500Name x500Name) {
        RDN[] rDNs = x500Name.getRDNs();
        int i11 = 0;
        for (int i12 = 0; i12 != rDNs.length; i12++) {
            if (rDNs[i12].isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = rDNs[i12].getTypesAndValues();
                for (int i13 = 0; i13 != typesAndValues.length; i13++) {
                    i11 = (i11 ^ typesAndValues[i13].getType().hashCode()) ^ calcHashCode(typesAndValues[i13].getValue());
                }
            } else {
                i11 = (i11 ^ rDNs[i12].getFirst().getType().hashCode()) ^ calcHashCode(rDNs[i12].getFirst().getValue());
            }
        }
        return i11;
    }

    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return new DERUTF8String(str);
    }

    public boolean rdnAreEqual(RDN rdn, RDN rdn2) {
        return IETFUtils.rDNAreEqual(rdn, rdn2);
    }

    public ASN1Encodable stringToValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return encodeStringValue(aSN1ObjectIdentifier, str);
        }
        try {
            return IETFUtils.valueFromHexString(str, 1);
        } catch (IOException unused) {
            throw new ASN1ParsingException("can't recode value for oid " + aSN1ObjectIdentifier.getId());
        }
    }
}
