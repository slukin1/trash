package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1BMPString;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.ASN1VisibleString;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERVisibleString;

public class DisplayText extends ASN1Object implements ASN1Choice {
    public static final int CONTENT_TYPE_BMPSTRING = 1;
    public static final int CONTENT_TYPE_IA5STRING = 0;
    public static final int CONTENT_TYPE_UTF8STRING = 2;
    public static final int CONTENT_TYPE_VISIBLESTRING = 3;
    public static final int DISPLAY_TEXT_MAXIMUM_SIZE = 200;
    public int contentType;
    public ASN1String contents;

    public DisplayText(int i11, String str) {
        str = str.length() > 200 ? str.substring(0, 200) : str;
        this.contentType = i11;
        this.contents = i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? new DERUTF8String(str) : new DERVisibleString(str) : new DERUTF8String(str) : new DERBMPString(str) : new DERIA5String(str);
    }

    public DisplayText(String str) {
        str = str.length() > 200 ? str.substring(0, 200) : str;
        this.contentType = 2;
        this.contents = new DERUTF8String(str);
    }

    private DisplayText(ASN1String aSN1String) {
        int i11;
        this.contents = aSN1String;
        if (aSN1String instanceof ASN1UTF8String) {
            i11 = 2;
        } else if (aSN1String instanceof ASN1BMPString) {
            i11 = 1;
        } else if (aSN1String instanceof ASN1IA5String) {
            i11 = 0;
        } else if (aSN1String instanceof ASN1VisibleString) {
            i11 = 3;
        } else {
            throw new IllegalArgumentException("unknown STRING type in DisplayText");
        }
        this.contentType = i11;
    }

    public static DisplayText getInstance(Object obj) {
        if (obj instanceof ASN1String) {
            return new DisplayText((ASN1String) obj);
        }
        if (obj == null || (obj instanceof DisplayText)) {
            return (DisplayText) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DisplayText getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public String getString() {
        return this.contents.getString();
    }

    public ASN1Primitive toASN1Primitive() {
        return (ASN1Primitive) this.contents;
    }
}
