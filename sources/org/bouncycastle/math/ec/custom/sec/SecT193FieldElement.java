package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

public class SecT193FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x  reason: collision with root package name */
    public long[] f59437x;

    public SecT193FieldElement() {
        this.f59437x = Nat256.create64();
    }

    public SecT193FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        this.f59437x = SecT193Field.fromBigInteger(bigInteger);
    }

    public SecT193FieldElement(long[] jArr) {
        this.f59437x = jArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] create64 = Nat256.create64();
        SecT193Field.add(this.f59437x, ((SecT193FieldElement) eCFieldElement).f59437x, create64);
        return new SecT193FieldElement(create64);
    }

    public ECFieldElement addOne() {
        long[] create64 = Nat256.create64();
        SecT193Field.addOne(this.f59437x, create64);
        return new SecT193FieldElement(create64);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT193FieldElement)) {
            return false;
        }
        return Nat256.eq64(this.f59437x, ((SecT193FieldElement) obj).f59437x);
    }

    public String getFieldName() {
        return "SecT193Field";
    }

    public int getFieldSize() {
        return 193;
    }

    public int getK1() {
        return 15;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 193;
    }

    public int getRepresentation() {
        return 2;
    }

    public ECFieldElement halfTrace() {
        long[] create64 = Nat256.create64();
        SecT193Field.halfTrace(this.f59437x, create64);
        return new SecT193FieldElement(create64);
    }

    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f59437x, 0, 4) ^ 1930015;
    }

    public ECFieldElement invert() {
        long[] create64 = Nat256.create64();
        SecT193Field.invert(this.f59437x, create64);
        return new SecT193FieldElement(create64);
    }

    public boolean isOne() {
        return Nat256.isOne64(this.f59437x);
    }

    public boolean isZero() {
        return Nat256.isZero64(this.f59437x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] create64 = Nat256.create64();
        SecT193Field.multiply(this.f59437x, ((SecT193FieldElement) eCFieldElement).f59437x, create64);
        return new SecT193FieldElement(create64);
    }

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f59437x;
        long[] jArr2 = ((SecT193FieldElement) eCFieldElement).f59437x;
        long[] jArr3 = ((SecT193FieldElement) eCFieldElement2).f59437x;
        long[] jArr4 = ((SecT193FieldElement) eCFieldElement3).f59437x;
        long[] createExt64 = Nat256.createExt64();
        SecT193Field.multiplyAddToExt(jArr, jArr2, createExt64);
        SecT193Field.multiplyAddToExt(jArr3, jArr4, createExt64);
        long[] create64 = Nat256.create64();
        SecT193Field.reduce(createExt64, create64);
        return new SecT193FieldElement(create64);
    }

    public ECFieldElement negate() {
        return this;
    }

    public ECFieldElement sqrt() {
        long[] create64 = Nat256.create64();
        SecT193Field.sqrt(this.f59437x, create64);
        return new SecT193FieldElement(create64);
    }

    public ECFieldElement square() {
        long[] create64 = Nat256.create64();
        SecT193Field.square(this.f59437x, create64);
        return new SecT193FieldElement(create64);
    }

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f59437x;
        long[] jArr2 = ((SecT193FieldElement) eCFieldElement).f59437x;
        long[] jArr3 = ((SecT193FieldElement) eCFieldElement2).f59437x;
        long[] createExt64 = Nat256.createExt64();
        SecT193Field.squareAddToExt(jArr, createExt64);
        SecT193Field.multiplyAddToExt(jArr2, jArr3, createExt64);
        long[] create64 = Nat256.create64();
        SecT193Field.reduce(createExt64, create64);
        return new SecT193FieldElement(create64);
    }

    public ECFieldElement squarePow(int i11) {
        if (i11 < 1) {
            return this;
        }
        long[] create64 = Nat256.create64();
        SecT193Field.squareN(this.f59437x, i11, create64);
        return new SecT193FieldElement(create64);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return add(eCFieldElement);
    }

    public boolean testBitZero() {
        return (this.f59437x[0] & 1) != 0;
    }

    public BigInteger toBigInteger() {
        return Nat256.toBigInteger64(this.f59437x);
    }

    public int trace() {
        return SecT193Field.trace(this.f59437x);
    }
}
