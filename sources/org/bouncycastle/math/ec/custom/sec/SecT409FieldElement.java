package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat448;
import org.bouncycastle.util.Arrays;

public class SecT409FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x  reason: collision with root package name */
    public long[] f59441x;

    public SecT409FieldElement() {
        this.f59441x = Nat448.create64();
    }

    public SecT409FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.f59441x = SecT409Field.fromBigInteger(bigInteger);
    }

    public SecT409FieldElement(long[] jArr) {
        this.f59441x = jArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] create64 = Nat448.create64();
        SecT409Field.add(this.f59441x, ((SecT409FieldElement) eCFieldElement).f59441x, create64);
        return new SecT409FieldElement(create64);
    }

    public ECFieldElement addOne() {
        long[] create64 = Nat448.create64();
        SecT409Field.addOne(this.f59441x, create64);
        return new SecT409FieldElement(create64);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT409FieldElement)) {
            return false;
        }
        return Nat448.eq64(this.f59441x, ((SecT409FieldElement) obj).f59441x);
    }

    public String getFieldName() {
        return "SecT409Field";
    }

    public int getFieldSize() {
        return 409;
    }

    public int getK1() {
        return 87;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 409;
    }

    public int getRepresentation() {
        return 2;
    }

    public ECFieldElement halfTrace() {
        long[] create64 = Nat448.create64();
        SecT409Field.halfTrace(this.f59441x, create64);
        return new SecT409FieldElement(create64);
    }

    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f59441x, 0, 7) ^ 4090087;
    }

    public ECFieldElement invert() {
        long[] create64 = Nat448.create64();
        SecT409Field.invert(this.f59441x, create64);
        return new SecT409FieldElement(create64);
    }

    public boolean isOne() {
        return Nat448.isOne64(this.f59441x);
    }

    public boolean isZero() {
        return Nat448.isZero64(this.f59441x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] create64 = Nat448.create64();
        SecT409Field.multiply(this.f59441x, ((SecT409FieldElement) eCFieldElement).f59441x, create64);
        return new SecT409FieldElement(create64);
    }

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f59441x;
        long[] jArr2 = ((SecT409FieldElement) eCFieldElement).f59441x;
        long[] jArr3 = ((SecT409FieldElement) eCFieldElement2).f59441x;
        long[] jArr4 = ((SecT409FieldElement) eCFieldElement3).f59441x;
        long[] create64 = Nat.create64(13);
        SecT409Field.multiplyAddToExt(jArr, jArr2, create64);
        SecT409Field.multiplyAddToExt(jArr3, jArr4, create64);
        long[] create642 = Nat448.create64();
        SecT409Field.reduce(create64, create642);
        return new SecT409FieldElement(create642);
    }

    public ECFieldElement negate() {
        return this;
    }

    public ECFieldElement sqrt() {
        long[] create64 = Nat448.create64();
        SecT409Field.sqrt(this.f59441x, create64);
        return new SecT409FieldElement(create64);
    }

    public ECFieldElement square() {
        long[] create64 = Nat448.create64();
        SecT409Field.square(this.f59441x, create64);
        return new SecT409FieldElement(create64);
    }

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f59441x;
        long[] jArr2 = ((SecT409FieldElement) eCFieldElement).f59441x;
        long[] jArr3 = ((SecT409FieldElement) eCFieldElement2).f59441x;
        long[] create64 = Nat.create64(13);
        SecT409Field.squareAddToExt(jArr, create64);
        SecT409Field.multiplyAddToExt(jArr2, jArr3, create64);
        long[] create642 = Nat448.create64();
        SecT409Field.reduce(create64, create642);
        return new SecT409FieldElement(create642);
    }

    public ECFieldElement squarePow(int i11) {
        if (i11 < 1) {
            return this;
        }
        long[] create64 = Nat448.create64();
        SecT409Field.squareN(this.f59441x, i11, create64);
        return new SecT409FieldElement(create64);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return add(eCFieldElement);
    }

    public boolean testBitZero() {
        return (this.f59441x[0] & 1) != 0;
    }

    public BigInteger toBigInteger() {
        return Nat448.toBigInteger64(this.f59441x);
    }

    public int trace() {
        return SecT409Field.trace(this.f59441x);
    }
}
