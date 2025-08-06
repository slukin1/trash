package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public class SecP384R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* renamed from: x  reason: collision with root package name */
    public int[] f59431x;

    public SecP384R1FieldElement() {
        this.f59431x = Nat.create(12);
    }

    public SecP384R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.f59431x = SecP384R1Field.fromBigInteger(bigInteger);
    }

    public SecP384R1FieldElement(int[] iArr) {
        this.f59431x = iArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(12);
        SecP384R1Field.add(this.f59431x, ((SecP384R1FieldElement) eCFieldElement).f59431x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement addOne() {
        int[] create = Nat.create(12);
        SecP384R1Field.addOne(this.f59431x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(12);
        SecP384R1Field.inv(((SecP384R1FieldElement) eCFieldElement).f59431x, create);
        SecP384R1Field.multiply(create, this.f59431x, create);
        return new SecP384R1FieldElement(create);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP384R1FieldElement)) {
            return false;
        }
        return Nat.eq(12, this.f59431x, ((SecP384R1FieldElement) obj).f59431x);
    }

    public String getFieldName() {
        return "SecP384R1Field";
    }

    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f59431x, 0, 12);
    }

    public ECFieldElement invert() {
        int[] create = Nat.create(12);
        SecP384R1Field.inv(this.f59431x, create);
        return new SecP384R1FieldElement(create);
    }

    public boolean isOne() {
        return Nat.isOne(12, this.f59431x);
    }

    public boolean isZero() {
        return Nat.isZero(12, this.f59431x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(12);
        SecP384R1Field.multiply(this.f59431x, ((SecP384R1FieldElement) eCFieldElement).f59431x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement negate() {
        int[] create = Nat.create(12);
        SecP384R1Field.negate(this.f59431x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement sqrt() {
        int[] iArr = this.f59431x;
        if (Nat.isZero(12, iArr) || Nat.isOne(12, iArr)) {
            return this;
        }
        int[] create = Nat.create(24);
        int[] create2 = Nat.create(12);
        int[] create3 = Nat.create(12);
        int[] create4 = Nat.create(12);
        int[] create5 = Nat.create(12);
        SecP384R1Field.square(iArr, create2, create);
        SecP384R1Field.multiply(create2, iArr, create2, create);
        SecP384R1Field.squareN(create2, 2, create3, create);
        SecP384R1Field.multiply(create3, create2, create3, create);
        SecP384R1Field.square(create3, create3, create);
        SecP384R1Field.multiply(create3, iArr, create3, create);
        SecP384R1Field.squareN(create3, 5, create4, create);
        SecP384R1Field.multiply(create4, create3, create4, create);
        SecP384R1Field.squareN(create4, 5, create5, create);
        SecP384R1Field.multiply(create5, create3, create5, create);
        SecP384R1Field.squareN(create5, 15, create3, create);
        SecP384R1Field.multiply(create3, create5, create3, create);
        SecP384R1Field.squareN(create3, 2, create4, create);
        SecP384R1Field.multiply(create2, create4, create2, create);
        SecP384R1Field.squareN(create4, 28, create4, create);
        SecP384R1Field.multiply(create3, create4, create3, create);
        SecP384R1Field.squareN(create3, 60, create4, create);
        SecP384R1Field.multiply(create4, create3, create4, create);
        SecP384R1Field.squareN(create4, 120, create3, create);
        SecP384R1Field.multiply(create3, create4, create3, create);
        SecP384R1Field.squareN(create3, 15, create3, create);
        SecP384R1Field.multiply(create3, create5, create3, create);
        SecP384R1Field.squareN(create3, 33, create3, create);
        SecP384R1Field.multiply(create3, create2, create3, create);
        SecP384R1Field.squareN(create3, 64, create3, create);
        SecP384R1Field.multiply(create3, iArr, create3, create);
        SecP384R1Field.squareN(create3, 30, create2, create);
        SecP384R1Field.square(create2, create3, create);
        if (Nat.eq(12, iArr, create3)) {
            return new SecP384R1FieldElement(create2);
        }
        return null;
    }

    public ECFieldElement square() {
        int[] create = Nat.create(12);
        SecP384R1Field.square(this.f59431x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(12);
        SecP384R1Field.subtract(this.f59431x, ((SecP384R1FieldElement) eCFieldElement).f59431x, create);
        return new SecP384R1FieldElement(create);
    }

    public boolean testBitZero() {
        return Nat.getBit(this.f59431x, 0) == 1;
    }

    public BigInteger toBigInteger() {
        return Nat.toBigInteger(12, this.f59431x);
    }
}
