package org.bouncycastle.math.ec.custom.sec;

import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;
import org.jmrtd.cbeff.ISO781611;

public class SecT239FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x  reason: collision with root package name */
    public long[] f59439x;

    public SecT239FieldElement() {
        this.f59439x = Nat256.create64();
    }

    public SecT239FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.f59439x = SecT239Field.fromBigInteger(bigInteger);
    }

    public SecT239FieldElement(long[] jArr) {
        this.f59439x = jArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] create64 = Nat256.create64();
        SecT239Field.add(this.f59439x, ((SecT239FieldElement) eCFieldElement).f59439x, create64);
        return new SecT239FieldElement(create64);
    }

    public ECFieldElement addOne() {
        long[] create64 = Nat256.create64();
        SecT239Field.addOne(this.f59439x, create64);
        return new SecT239FieldElement(create64);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT239FieldElement)) {
            return false;
        }
        return Nat256.eq64(this.f59439x, ((SecT239FieldElement) obj).f59439x);
    }

    public String getFieldName() {
        return "SecT239Field";
    }

    public int getFieldSize() {
        return TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE;
    }

    public int getK1() {
        return ISO781611.SMT_DO_DS;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE;
    }

    public int getRepresentation() {
        return 2;
    }

    public ECFieldElement halfTrace() {
        long[] create64 = Nat256.create64();
        SecT239Field.halfTrace(this.f59439x, create64);
        return new SecT239FieldElement(create64);
    }

    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f59439x, 0, 4) ^ 23900158;
    }

    public ECFieldElement invert() {
        long[] create64 = Nat256.create64();
        SecT239Field.invert(this.f59439x, create64);
        return new SecT239FieldElement(create64);
    }

    public boolean isOne() {
        return Nat256.isOne64(this.f59439x);
    }

    public boolean isZero() {
        return Nat256.isZero64(this.f59439x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] create64 = Nat256.create64();
        SecT239Field.multiply(this.f59439x, ((SecT239FieldElement) eCFieldElement).f59439x, create64);
        return new SecT239FieldElement(create64);
    }

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f59439x;
        long[] jArr2 = ((SecT239FieldElement) eCFieldElement).f59439x;
        long[] jArr3 = ((SecT239FieldElement) eCFieldElement2).f59439x;
        long[] jArr4 = ((SecT239FieldElement) eCFieldElement3).f59439x;
        long[] createExt64 = Nat256.createExt64();
        SecT239Field.multiplyAddToExt(jArr, jArr2, createExt64);
        SecT239Field.multiplyAddToExt(jArr3, jArr4, createExt64);
        long[] create64 = Nat256.create64();
        SecT239Field.reduce(createExt64, create64);
        return new SecT239FieldElement(create64);
    }

    public ECFieldElement negate() {
        return this;
    }

    public ECFieldElement sqrt() {
        long[] create64 = Nat256.create64();
        SecT239Field.sqrt(this.f59439x, create64);
        return new SecT239FieldElement(create64);
    }

    public ECFieldElement square() {
        long[] create64 = Nat256.create64();
        SecT239Field.square(this.f59439x, create64);
        return new SecT239FieldElement(create64);
    }

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f59439x;
        long[] jArr2 = ((SecT239FieldElement) eCFieldElement).f59439x;
        long[] jArr3 = ((SecT239FieldElement) eCFieldElement2).f59439x;
        long[] createExt64 = Nat256.createExt64();
        SecT239Field.squareAddToExt(jArr, createExt64);
        SecT239Field.multiplyAddToExt(jArr2, jArr3, createExt64);
        long[] create64 = Nat256.create64();
        SecT239Field.reduce(createExt64, create64);
        return new SecT239FieldElement(create64);
    }

    public ECFieldElement squarePow(int i11) {
        if (i11 < 1) {
            return this;
        }
        long[] create64 = Nat256.create64();
        SecT239Field.squareN(this.f59439x, i11, create64);
        return new SecT239FieldElement(create64);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return add(eCFieldElement);
    }

    public boolean testBitZero() {
        return (this.f59439x[0] & 1) != 0;
    }

    public BigInteger toBigInteger() {
        return Nat256.toBigInteger64(this.f59439x);
    }

    public int trace() {
        return SecT239Field.trace(this.f59439x);
    }
}
