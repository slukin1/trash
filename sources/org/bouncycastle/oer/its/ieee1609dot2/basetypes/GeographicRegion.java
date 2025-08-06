package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class GeographicRegion extends ASN1Object implements ASN1Choice {
    public static final int circularRegion = 0;
    public static final int identifiedRegion = 3;
    public static final int polygonalRegion = 2;
    public static final int rectangularRegion = 1;
    private final int choice;
    private final ASN1Encodable geographicRegion;

    public GeographicRegion(int i11, ASN1Encodable aSN1Encodable) {
        this.choice = i11;
        this.geographicRegion = aSN1Encodable;
    }

    private GeographicRegion(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1Encodable;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.choice = tagNo;
        if (tagNo == 0) {
            aSN1Encodable = CircularRegion.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 1) {
            aSN1Encodable = SequenceOfRectangularRegion.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 2) {
            aSN1Encodable = PolygonalRegion.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 3) {
            aSN1Encodable = SequenceOfIdentifiedRegion.getInstance(aSN1TaggedObject.getObject());
        } else {
            throw new IllegalArgumentException("invalid choice value " + tagNo);
        }
        this.geographicRegion = aSN1Encodable;
    }

    public static GeographicRegion circularRegion(CircularRegion circularRegion2) {
        return new GeographicRegion(0, circularRegion2);
    }

    public static GeographicRegion getInstance(Object obj) {
        if (obj instanceof GeographicRegion) {
            return (GeographicRegion) obj;
        }
        if (obj != null) {
            return new GeographicRegion(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public static GeographicRegion identifiedRegion(SequenceOfIdentifiedRegion sequenceOfIdentifiedRegion) {
        return new GeographicRegion(3, sequenceOfIdentifiedRegion);
    }

    public static GeographicRegion polygonalRegion(PolygonalRegion polygonalRegion2) {
        return new GeographicRegion(2, polygonalRegion2);
    }

    public static GeographicRegion rectangularRegion(SequenceOfRectangularRegion sequenceOfRectangularRegion) {
        return new GeographicRegion(1, sequenceOfRectangularRegion);
    }

    public int getChoice() {
        return this.choice;
    }

    public ASN1Encodable getGeographicRegion() {
        return this.geographicRegion;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.choice, this.geographicRegion);
    }
}
