package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat128;

public class SecP128R1Point extends ECPoint.AbstractFp {
    public SecP128R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP128R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECPoint add(ECPoint eCPoint) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        if (this == eCPoint) {
            return twice();
        }
        ECCurve curve = getCurve();
        SecP128R1FieldElement secP128R1FieldElement = (SecP128R1FieldElement) this.f59402x;
        SecP128R1FieldElement secP128R1FieldElement2 = (SecP128R1FieldElement) this.f59403y;
        SecP128R1FieldElement secP128R1FieldElement3 = (SecP128R1FieldElement) eCPoint.getXCoord();
        SecP128R1FieldElement secP128R1FieldElement4 = (SecP128R1FieldElement) eCPoint.getYCoord();
        SecP128R1FieldElement secP128R1FieldElement5 = (SecP128R1FieldElement) this.f59404zs[0];
        SecP128R1FieldElement secP128R1FieldElement6 = (SecP128R1FieldElement) eCPoint.getZCoord(0);
        int[] createExt = Nat128.createExt();
        int[] create = Nat128.create();
        int[] create2 = Nat128.create();
        int[] create3 = Nat128.create();
        boolean isOne = secP128R1FieldElement5.isOne();
        if (isOne) {
            iArr2 = secP128R1FieldElement3.f59412x;
            iArr = secP128R1FieldElement4.f59412x;
        } else {
            SecP128R1Field.square(secP128R1FieldElement5.f59412x, create2);
            SecP128R1Field.multiply(create2, secP128R1FieldElement3.f59412x, create);
            SecP128R1Field.multiply(create2, secP128R1FieldElement5.f59412x, create2);
            SecP128R1Field.multiply(create2, secP128R1FieldElement4.f59412x, create2);
            iArr2 = create;
            iArr = create2;
        }
        boolean isOne2 = secP128R1FieldElement6.isOne();
        if (isOne2) {
            iArr4 = secP128R1FieldElement.f59412x;
            iArr3 = secP128R1FieldElement2.f59412x;
        } else {
            SecP128R1Field.square(secP128R1FieldElement6.f59412x, create3);
            SecP128R1Field.multiply(create3, secP128R1FieldElement.f59412x, createExt);
            SecP128R1Field.multiply(create3, secP128R1FieldElement6.f59412x, create3);
            SecP128R1Field.multiply(create3, secP128R1FieldElement2.f59412x, create3);
            iArr4 = createExt;
            iArr3 = create3;
        }
        int[] create4 = Nat128.create();
        SecP128R1Field.subtract(iArr4, iArr2, create4);
        SecP128R1Field.subtract(iArr3, iArr, create);
        if (Nat128.isZero(create4)) {
            return Nat128.isZero(create) ? twice() : curve.getInfinity();
        }
        SecP128R1Field.square(create4, create2);
        int[] create5 = Nat128.create();
        SecP128R1Field.multiply(create2, create4, create5);
        SecP128R1Field.multiply(create2, iArr4, create2);
        SecP128R1Field.negate(create5, create5);
        Nat128.mul(iArr3, create5, createExt);
        SecP128R1Field.reduce32(Nat128.addBothTo(create2, create2, create5), create5);
        SecP128R1FieldElement secP128R1FieldElement7 = new SecP128R1FieldElement(create3);
        SecP128R1Field.square(create, secP128R1FieldElement7.f59412x);
        int[] iArr5 = secP128R1FieldElement7.f59412x;
        SecP128R1Field.subtract(iArr5, create5, iArr5);
        SecP128R1FieldElement secP128R1FieldElement8 = new SecP128R1FieldElement(create5);
        SecP128R1Field.subtract(create2, secP128R1FieldElement7.f59412x, secP128R1FieldElement8.f59412x);
        SecP128R1Field.multiplyAddToExt(secP128R1FieldElement8.f59412x, create, createExt);
        SecP128R1Field.reduce(createExt, secP128R1FieldElement8.f59412x);
        SecP128R1FieldElement secP128R1FieldElement9 = new SecP128R1FieldElement(create4);
        if (!isOne) {
            int[] iArr6 = secP128R1FieldElement9.f59412x;
            SecP128R1Field.multiply(iArr6, secP128R1FieldElement5.f59412x, iArr6);
        }
        if (!isOne2) {
            int[] iArr7 = secP128R1FieldElement9.f59412x;
            SecP128R1Field.multiply(iArr7, secP128R1FieldElement6.f59412x, iArr7);
        }
        return new SecP128R1Point(curve, secP128R1FieldElement7, secP128R1FieldElement8, new ECFieldElement[]{secP128R1FieldElement9});
    }

    public ECPoint detach() {
        return new SecP128R1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECPoint negate() {
        return isInfinity() ? this : new SecP128R1Point(this.curve, this.f59402x, this.f59403y.negate(), this.f59404zs);
    }

    public ECPoint threeTimes() {
        return (isInfinity() || this.f59403y.isZero()) ? this : twice().add(this);
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP128R1FieldElement secP128R1FieldElement = (SecP128R1FieldElement) this.f59403y;
        if (secP128R1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP128R1FieldElement secP128R1FieldElement2 = (SecP128R1FieldElement) this.f59402x;
        SecP128R1FieldElement secP128R1FieldElement3 = (SecP128R1FieldElement) this.f59404zs[0];
        int[] create = Nat128.create();
        int[] create2 = Nat128.create();
        int[] create3 = Nat128.create();
        SecP128R1Field.square(secP128R1FieldElement.f59412x, create3);
        int[] create4 = Nat128.create();
        SecP128R1Field.square(create3, create4);
        boolean isOne = secP128R1FieldElement3.isOne();
        int[] iArr = secP128R1FieldElement3.f59412x;
        if (!isOne) {
            SecP128R1Field.square(iArr, create2);
            iArr = create2;
        }
        SecP128R1Field.subtract(secP128R1FieldElement2.f59412x, iArr, create);
        SecP128R1Field.add(secP128R1FieldElement2.f59412x, iArr, create2);
        SecP128R1Field.multiply(create2, create, create2);
        SecP128R1Field.reduce32(Nat128.addBothTo(create2, create2, create2), create2);
        SecP128R1Field.multiply(create3, secP128R1FieldElement2.f59412x, create3);
        SecP128R1Field.reduce32(Nat.shiftUpBits(4, create3, 2, 0), create3);
        SecP128R1Field.reduce32(Nat.shiftUpBits(4, create4, 3, 0, create), create);
        SecP128R1FieldElement secP128R1FieldElement4 = new SecP128R1FieldElement(create4);
        SecP128R1Field.square(create2, secP128R1FieldElement4.f59412x);
        int[] iArr2 = secP128R1FieldElement4.f59412x;
        SecP128R1Field.subtract(iArr2, create3, iArr2);
        int[] iArr3 = secP128R1FieldElement4.f59412x;
        SecP128R1Field.subtract(iArr3, create3, iArr3);
        SecP128R1FieldElement secP128R1FieldElement5 = new SecP128R1FieldElement(create3);
        SecP128R1Field.subtract(create3, secP128R1FieldElement4.f59412x, secP128R1FieldElement5.f59412x);
        int[] iArr4 = secP128R1FieldElement5.f59412x;
        SecP128R1Field.multiply(iArr4, create2, iArr4);
        int[] iArr5 = secP128R1FieldElement5.f59412x;
        SecP128R1Field.subtract(iArr5, create, iArr5);
        SecP128R1FieldElement secP128R1FieldElement6 = new SecP128R1FieldElement(create2);
        SecP128R1Field.twice(secP128R1FieldElement.f59412x, secP128R1FieldElement6.f59412x);
        if (!isOne) {
            int[] iArr6 = secP128R1FieldElement6.f59412x;
            SecP128R1Field.multiply(iArr6, secP128R1FieldElement3.f59412x, iArr6);
        }
        return new SecP128R1Point(curve, secP128R1FieldElement4, secP128R1FieldElement5, new ECFieldElement[]{secP128R1FieldElement6});
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        return this == eCPoint ? threeTimes() : isInfinity() ? eCPoint : eCPoint.isInfinity() ? twice() : this.f59403y.isZero() ? eCPoint : twice().add(eCPoint);
    }
}
