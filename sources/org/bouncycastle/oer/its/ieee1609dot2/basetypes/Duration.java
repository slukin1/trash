package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class Duration extends ASN1Object implements ASN1Choice {
    public static final int hours = 4;
    public static final int microseconds = 0;
    public static final int milliseconds = 1;
    public static final int minutes = 3;
    public static final int seconds = 2;
    public static final int sixtyHours = 5;
    public static final int years = 6;
    private final int choice;
    private final UINT16 duration;

    public Duration(int i11, UINT16 uint16) {
        this.choice = i11;
        this.duration = uint16;
    }

    private Duration(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.choice = tagNo;
        switch (tagNo) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                try {
                    this.duration = UINT16.getInstance(aSN1TaggedObject.getObject());
                    return;
                } catch (Exception e11) {
                    throw new IllegalStateException(e11.getMessage(), e11);
                }
            default:
                throw new IllegalArgumentException("invalid choice value " + tagNo);
        }
    }

    public static Duration getInstance(Object obj) {
        if (obj instanceof Duration) {
            return (Duration) obj;
        }
        if (obj != null) {
            return new Duration(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public static Duration hours(UINT16 uint16) {
        return new Duration(4, uint16);
    }

    public static Duration microseconds(UINT16 uint16) {
        return new Duration(0, uint16);
    }

    public static Duration milliseconds(UINT16 uint16) {
        return new Duration(1, uint16);
    }

    public static Duration minutes(UINT16 uint16) {
        return new Duration(3, uint16);
    }

    public static Duration seconds(UINT16 uint16) {
        return new Duration(2, uint16);
    }

    public static Duration sixtyHours(UINT16 uint16) {
        return new Duration(5, uint16);
    }

    public static Duration years(UINT16 uint16) {
        return new Duration(6, uint16);
    }

    public int getChoice() {
        return this.choice;
    }

    public UINT16 getDuration() {
        return this.duration;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.choice, this.duration);
    }

    public String toString() {
        StringBuilder sb2;
        String str;
        switch (this.choice) {
            case 0:
                sb2 = new StringBuilder();
                sb2.append(this.duration.value);
                str = "uS";
                break;
            case 1:
                sb2 = new StringBuilder();
                sb2.append(this.duration.value);
                str = "mS";
                break;
            case 2:
                sb2 = new StringBuilder();
                sb2.append(this.duration.value);
                str = " seconds";
                break;
            case 3:
                sb2 = new StringBuilder();
                sb2.append(this.duration.value);
                str = " minute";
                break;
            case 4:
                sb2 = new StringBuilder();
                sb2.append(this.duration.value);
                str = " hours";
                break;
            case 5:
                sb2 = new StringBuilder();
                sb2.append(this.duration.value);
                str = " sixty hours";
                break;
            case 6:
                sb2 = new StringBuilder();
                sb2.append(this.duration.value);
                str = " years";
                break;
            default:
                sb2 = new StringBuilder();
                sb2.append(this.duration.value);
                str = " unknown choice";
                break;
        }
        sb2.append(str);
        return sb2.toString();
    }
}
