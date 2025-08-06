package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public class SecP256R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: x  reason: collision with root package name */
    public int[] f59429x;

    public SecP256R1FieldElement() {
        this.f59429x = Nat256.create();
    }

    public SecP256R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        this.f59429x = SecP256R1Field.fromBigInteger(bigInteger);
    }

    public SecP256R1FieldElement(int[] iArr) {
        this.f59429x = iArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] create = Nat256.create();
        SecP256R1Field.add(this.f59429x, ((SecP256R1FieldElement) eCFieldElement).f59429x, create);
        return new SecP256R1FieldElement(create);
    }

    public ECFieldElement addOne() {
        int[] create = Nat256.create();
        SecP256R1Field.addOne(this.f59429x, create);
        return new SecP256R1FieldElement(create);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] create = Nat256.create();
        SecP256R1Field.inv(((SecP256R1FieldElement) eCFieldElement).f59429x, create);
        SecP256R1Field.multiply(create, this.f59429x, create);
        return new SecP256R1FieldElement(create);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP256R1FieldElement)) {
            return false;
        }
        return Nat256.eq(this.f59429x, ((SecP256R1FieldElement) obj).f59429x);
    }

    public String getFieldName() {
        return "SecP256R1Field";
    }

    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f59429x, 0, 8);
    }

    public ECFieldElement invert() {
        int[] create = Nat256.create();
        SecP256R1Field.inv(this.f59429x, create);
        return new SecP256R1FieldElement(create);
    }

    public boolean isOne() {
        return Nat256.isOne(this.f59429x);
    }

    public boolean isZero() {
        return Nat256.isZero(this.f59429x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] create = Nat256.create();
        SecP256R1Field.multiply(this.f59429x, ((SecP256R1FieldElement) eCFieldElement).f59429x, create);
        return new SecP256R1FieldElement(create);
    }

    public ECFieldElement negate() {
        int[] create = Nat256.create();
        SecP256R1Field.negate(this.f59429x, create);
        return new SecP256R1FieldElement(create);
    }

    public ECFieldElement sqrt() {
        int[] iArr = this.f59429x;
        if (Nat256.isZero(iArr) || Nat256.isOne(iArr)) {
            return this;
        }
        int[] createExt = Nat256.createExt();
        int[] create = Nat256.create();
        int[] create2 = Nat256.create();
        SecP256R1Field.square(iArr, create, createExt);
        SecP256R1Field.multiply(create, iArr, create, createExt);
        SecP256R1Field.squareN(create, 2, create2, createExt);
        SecP256R1Field.multiply(create2, create, create2, createExt);
        SecP256R1Field.squareN(create2, 4, create, createExt);
        SecP256R1Field.multiply(create, create2, create, createExt);
        SecP256R1Field.squareN(create, 8, create2, createExt);
        SecP256R1Field.multiply(create2, create, create2, createExt);
        SecP256R1Field.squareN(create2, 16, create, createExt);
        SecP256R1Field.multiply(create, create2, create, createExt);
        SecP256R1Field.squareN(create, 32, create, createExt);
        SecP256R1Field.multiply(create, iArr, create, createExt);
        SecP256R1Field.squareN(create, 96, create, createExt);
        SecP256R1Field.multiply(create, iArr, create, createExt);
        SecP256R1Field.squareN(create, 94, create, createExt);
        SecP256R1Field.square(create, create2, createExt);
        if (Nat256.eq(iArr, create2)) {
            return new SecP256R1FieldElement(create);
        }
        return null;
    }

    public ECFieldElement square() {
        int[] create = Nat256.create();
        SecP256R1Field.square(this.f59429x, create);
        return new SecP256R1FieldElement(create);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] create = Nat256.create();
        SecP256R1Field.subtract(this.f59429x, ((SecP256R1FieldElement) eCFieldElement).f59429x, create);
        return new SecP256R1FieldElement(create);
    }

    public boolean testBitZero() {
        return Nat256.getBit(this.f59429x, 0) == 1;
    }

    public BigInteger toBigInteger() {
        return Nat256.toBigInteger(this.f59429x);
    }
}
