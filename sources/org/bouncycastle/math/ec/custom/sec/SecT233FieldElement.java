package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

public class SecT233FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x  reason: collision with root package name */
    public long[] f59438x;

    public SecT233FieldElement() {
        this.f59438x = Nat256.create64();
    }

    public SecT233FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        this.f59438x = SecT233Field.fromBigInteger(bigInteger);
    }

    public SecT233FieldElement(long[] jArr) {
        this.f59438x = jArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] create64 = Nat256.create64();
        SecT233Field.add(this.f59438x, ((SecT233FieldElement) eCFieldElement).f59438x, create64);
        return new SecT233FieldElement(create64);
    }

    public ECFieldElement addOne() {
        long[] create64 = Nat256.create64();
        SecT233Field.addOne(this.f59438x, create64);
        return new SecT233FieldElement(create64);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT233FieldElement)) {
            return false;
        }
        return Nat256.eq64(this.f59438x, ((SecT233FieldElement) obj).f59438x);
    }

    public String getFieldName() {
        return "SecT233Field";
    }

    public int getFieldSize() {
        return 233;
    }

    public int getK1() {
        return 74;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 233;
    }

    public int getRepresentation() {
        return 2;
    }

    public ECFieldElement halfTrace() {
        long[] create64 = Nat256.create64();
        SecT233Field.halfTrace(this.f59438x, create64);
        return new SecT233FieldElement(create64);
    }

    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f59438x, 0, 4) ^ 2330074;
    }

    public ECFieldElement invert() {
        long[] create64 = Nat256.create64();
        SecT233Field.invert(this.f59438x, create64);
        return new SecT233FieldElement(create64);
    }

    public boolean isOne() {
        return Nat256.isOne64(this.f59438x);
    }

    public boolean isZero() {
        return Nat256.isZero64(this.f59438x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] create64 = Nat256.create64();
        SecT233Field.multiply(this.f59438x, ((SecT233FieldElement) eCFieldElement).f59438x, create64);
        return new SecT233FieldElement(create64);
    }

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f59438x;
        long[] jArr2 = ((SecT233FieldElement) eCFieldElement).f59438x;
        long[] jArr3 = ((SecT233FieldElement) eCFieldElement2).f59438x;
        long[] jArr4 = ((SecT233FieldElement) eCFieldElement3).f59438x;
        long[] createExt64 = Nat256.createExt64();
        SecT233Field.multiplyAddToExt(jArr, jArr2, createExt64);
        SecT233Field.multiplyAddToExt(jArr3, jArr4, createExt64);
        long[] create64 = Nat256.create64();
        SecT233Field.reduce(createExt64, create64);
        return new SecT233FieldElement(create64);
    }

    public ECFieldElement negate() {
        return this;
    }

    public ECFieldElement sqrt() {
        long[] create64 = Nat256.create64();
        SecT233Field.sqrt(this.f59438x, create64);
        return new SecT233FieldElement(create64);
    }

    public ECFieldElement square() {
        long[] create64 = Nat256.create64();
        SecT233Field.square(this.f59438x, create64);
        return new SecT233FieldElement(create64);
    }

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f59438x;
        long[] jArr2 = ((SecT233FieldElement) eCFieldElement).f59438x;
        long[] jArr3 = ((SecT233FieldElement) eCFieldElement2).f59438x;
        long[] createExt64 = Nat256.createExt64();
        SecT233Field.squareAddToExt(jArr, createExt64);
        SecT233Field.multiplyAddToExt(jArr2, jArr3, createExt64);
        long[] create64 = Nat256.create64();
        SecT233Field.reduce(createExt64, create64);
        return new SecT233FieldElement(create64);
    }

    public ECFieldElement squarePow(int i11) {
        if (i11 < 1) {
            return this;
        }
        long[] create64 = Nat256.create64();
        SecT233Field.squareN(this.f59438x, i11, create64);
        return new SecT233FieldElement(create64);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return add(eCFieldElement);
    }

    public boolean testBitZero() {
        return (this.f59438x[0] & 1) != 0;
    }

    public BigInteger toBigInteger() {
        return Nat256.toBigInteger64(this.f59438x);
    }

    public int trace() {
        return SecT233Field.trace(this.f59438x);
    }
}
