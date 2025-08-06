package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;

public class EccP256CurvePoint extends EccCurvePoint implements ASN1Choice {
    public static final int compressedY0 = 2;
    public static final int compressedY1 = 3;
    public static final int fill = 1;
    public static final int uncompressedP256 = 4;
    public static final int xonly = 0;
    private final int choice;
    private final ASN1Encodable eccp256CurvePoint;

    public EccP256CurvePoint(int i11, ASN1Encodable aSN1Encodable) {
        this.choice = i11;
        this.eccp256CurvePoint = aSN1Encodable;
    }

    private EccP256CurvePoint(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1Encodable;
        this.choice = aSN1TaggedObject.getTagNo();
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo != 0) {
            if (tagNo == 1) {
                aSN1Encodable = ASN1Null.getInstance(aSN1TaggedObject.getObject());
            } else if (!(tagNo == 2 || tagNo == 3)) {
                if (tagNo == 4) {
                    aSN1Encodable = Point256.getInstance(aSN1TaggedObject.getObject());
                } else {
                    throw new IllegalArgumentException("invalid choice value " + aSN1TaggedObject.getTagNo());
                }
            }
            this.eccp256CurvePoint = aSN1Encodable;
        }
        aSN1Encodable = ASN1OctetString.getInstance(aSN1TaggedObject.getObject());
        this.eccp256CurvePoint = aSN1Encodable;
    }

    public static EccP256CurvePoint compressedY0(ASN1OctetString aSN1OctetString) {
        return new EccP256CurvePoint(2, aSN1OctetString);
    }

    public static EccP256CurvePoint compressedY0(byte[] bArr) {
        return new EccP256CurvePoint(2, new DEROctetString(Arrays.clone(bArr)));
    }

    public static EccP256CurvePoint compressedY1(ASN1OctetString aSN1OctetString) {
        return new EccP256CurvePoint(3, aSN1OctetString);
    }

    public static EccP256CurvePoint compressedY1(byte[] bArr) {
        return new EccP256CurvePoint(3, new DEROctetString(Arrays.clone(bArr)));
    }

    public static EccP256CurvePoint createEncodedPoint(byte[] bArr) {
        if (bArr[0] == 2) {
            int length = bArr.length - 1;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 1, bArr2, 0, length);
            return new EccP256CurvePoint(2, new DEROctetString(bArr2));
        } else if (bArr[0] == 3) {
            int length2 = bArr.length - 1;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, 1, bArr3, 0, length2);
            return new EccP256CurvePoint(3, new DEROctetString(bArr3));
        } else if (bArr[0] == 4) {
            return new EccP256CurvePoint(4, new Point256(new DEROctetString(Arrays.copyOfRange(bArr, 1, 34)), new DEROctetString(Arrays.copyOfRange(bArr, 34, 66))));
        } else {
            throw new IllegalArgumentException("unrecognised encoding " + bArr[0]);
        }
    }

    public static EccP256CurvePoint fill() {
        return new EccP256CurvePoint(1, DERNull.INSTANCE);
    }

    public static EccP256CurvePoint getInstance(Object obj) {
        if (obj instanceof EccP256CurvePoint) {
            return (EccP256CurvePoint) obj;
        }
        if (obj != null) {
            return new EccP256CurvePoint(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public static EccP256CurvePoint uncompressedP256(BigInteger bigInteger, BigInteger bigInteger2) {
        return new EccP256CurvePoint(4, Point256.builder().setX(bigInteger).setY(bigInteger2).createPoint256());
    }

    public static EccP256CurvePoint uncompressedP256(Point256 point256) {
        return new EccP256CurvePoint(4, point256);
    }

    public static EccP256CurvePoint xOnly(ASN1OctetString aSN1OctetString) {
        return new EccP256CurvePoint(0, aSN1OctetString);
    }

    public static EccP256CurvePoint xOnly(byte[] bArr) {
        return new EccP256CurvePoint(0, new DEROctetString(Arrays.clone(bArr)));
    }

    public EccP256CurvePoint createCompressed(ECPoint eCPoint) {
        byte[] encoded = eCPoint.getEncoded(true);
        int i11 = 3;
        if (encoded[0] == 2) {
            i11 = 2;
        } else if (encoded[0] != 3) {
            i11 = 0;
        }
        int length = encoded.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(encoded, 0, bArr, 0, length);
        return new EccP256CurvePoint(i11, new DEROctetString(bArr));
    }

    public int getChoice() {
        return this.choice;
    }

    public ASN1Encodable getEccp256CurvePoint() {
        return this.eccp256CurvePoint;
    }

    public byte[] getEncodedPoint() {
        byte[] bArr;
        int i11 = this.choice;
        if (i11 != 0) {
            if (i11 == 2) {
                byte[] octets = ASN1OctetString.getInstance(this.eccp256CurvePoint).getOctets();
                bArr = new byte[(octets.length + 1)];
                bArr[0] = 2;
                System.arraycopy(octets, 0, bArr, 1, octets.length);
            } else if (i11 == 3) {
                byte[] octets2 = ASN1OctetString.getInstance(this.eccp256CurvePoint).getOctets();
                bArr = new byte[(octets2.length + 1)];
                bArr[0] = 3;
                System.arraycopy(octets2, 0, bArr, 1, octets2.length);
            } else if (i11 == 4) {
                Point256 instance = Point256.getInstance(this.eccp256CurvePoint);
                return Arrays.concatenate(new byte[]{4}, instance.getX().getOctets(), instance.getY().getOctets());
            } else {
                throw new IllegalStateException("unknown point choice");
            }
            return bArr;
        }
        throw new IllegalStateException("x Only not implemented");
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.choice, this.eccp256CurvePoint);
    }
}
