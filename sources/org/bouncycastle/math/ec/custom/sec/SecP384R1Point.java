package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;

public class SecP384R1Point extends ECPoint.AbstractFp {
    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    /* JADX WARNING: type inference failed for: r17v0, types: [org.bouncycastle.math.ec.ECPoint] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.bouncycastle.math.ec.ECPoint add(org.bouncycastle.math.ec.ECPoint r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            boolean r2 = r16.isInfinity()
            if (r2 == 0) goto L_0x000b
            return r1
        L_0x000b:
            boolean r2 = r17.isInfinity()
            if (r2 == 0) goto L_0x0012
            return r0
        L_0x0012:
            if (r0 != r1) goto L_0x0019
            org.bouncycastle.math.ec.ECPoint r1 = r16.twice()
            return r1
        L_0x0019:
            org.bouncycastle.math.ec.ECCurve r2 = r16.getCurve()
            org.bouncycastle.math.ec.ECFieldElement r3 = r0.f59402x
            org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r3 = (org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r3
            org.bouncycastle.math.ec.ECFieldElement r4 = r0.f59403y
            org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r4 = (org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r4
            org.bouncycastle.math.ec.ECFieldElement r5 = r17.getXCoord()
            org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r5 = (org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r5
            org.bouncycastle.math.ec.ECFieldElement r6 = r17.getYCoord()
            org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r6 = (org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r6
            org.bouncycastle.math.ec.ECFieldElement[] r7 = r0.f59404zs
            r8 = 0
            r7 = r7[r8]
            org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r7 = (org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r7
            org.bouncycastle.math.ec.ECFieldElement r1 = r1.getZCoord(r8)
            org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r1 = (org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r1
            r9 = 24
            int[] r10 = org.bouncycastle.math.raw.Nat.create(r9)
            int[] r11 = org.bouncycastle.math.raw.Nat.create(r9)
            int[] r9 = org.bouncycastle.math.raw.Nat.create(r9)
            r12 = 12
            int[] r13 = org.bouncycastle.math.raw.Nat.create(r12)
            int[] r14 = org.bouncycastle.math.raw.Nat.create(r12)
            boolean r15 = r7.isOne()
            if (r15 == 0) goto L_0x0061
            int[] r5 = r5.f59431x
            int[] r6 = r6.f59431x
            goto L_0x0077
        L_0x0061:
            int[] r8 = r7.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.square(r8, r13, r10)
            int[] r5 = r5.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r13, r5, r9, r10)
            int[] r5 = r7.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r13, r5, r13, r10)
            int[] r5 = r6.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r13, r5, r13, r10)
            r5 = r9
            r6 = r13
        L_0x0077:
            boolean r8 = r1.isOne()
            if (r8 == 0) goto L_0x0082
            int[] r3 = r3.f59431x
            int[] r4 = r4.f59431x
            goto L_0x009a
        L_0x0082:
            int[] r12 = r1.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.square(r12, r14, r10)
            int[] r3 = r3.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r14, r3, r11, r10)
            int[] r3 = r1.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r14, r3, r14, r10)
            int[] r3 = r4.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r14, r3, r14, r10)
            r3 = r11
            r4 = r14
            r12 = 12
        L_0x009a:
            int[] r0 = org.bouncycastle.math.raw.Nat.create(r12)
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.subtract(r3, r5, r0)
            int[] r5 = org.bouncycastle.math.raw.Nat.create(r12)
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.subtract(r4, r6, r5)
            boolean r6 = org.bouncycastle.math.raw.Nat.isZero(r12, r0)
            if (r6 == 0) goto L_0x00be
            boolean r0 = org.bouncycastle.math.raw.Nat.isZero(r12, r5)
            if (r0 == 0) goto L_0x00b9
            org.bouncycastle.math.ec.ECPoint r0 = r16.twice()
            return r0
        L_0x00b9:
            org.bouncycastle.math.ec.ECPoint r0 = r2.getInfinity()
            return r0
        L_0x00be:
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.square(r0, r13, r10)
            int[] r6 = org.bouncycastle.math.raw.Nat.create(r12)
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r13, r0, r6, r10)
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r13, r3, r13, r10)
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.negate(r6, r6)
            org.bouncycastle.math.raw.Nat384.mul(r4, r6, r11)
            int r3 = org.bouncycastle.math.raw.Nat.addBothTo(r12, r13, r13, r6)
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.reduce32(r3, r6)
            org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r3 = new org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement
            r3.<init>((int[]) r14)
            int[] r4 = r3.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.square(r5, r4, r10)
            int[] r4 = r3.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.subtract(r4, r6, r4)
            org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r4 = new org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement
            r4.<init>((int[]) r6)
            int[] r6 = r3.f59431x
            int[] r12 = r4.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.subtract(r13, r6, r12)
            int[] r6 = r4.f59431x
            org.bouncycastle.math.raw.Nat384.mul(r6, r5, r9)
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.addExt(r11, r9, r11)
            int[] r5 = r4.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.reduce(r11, r5)
            org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r5 = new org.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement
            r5.<init>((int[]) r0)
            if (r15 != 0) goto L_0x010e
            int[] r0 = r5.f59431x
            int[] r6 = r7.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r0, r6, r0, r10)
        L_0x010e:
            if (r8 != 0) goto L_0x0117
            int[] r0 = r5.f59431x
            int[] r1 = r1.f59431x
            org.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r0, r1, r0, r10)
        L_0x0117:
            r0 = 1
            org.bouncycastle.math.ec.ECFieldElement[] r0 = new org.bouncycastle.math.ec.ECFieldElement[r0]
            r1 = 0
            r0[r1] = r5
            org.bouncycastle.math.ec.custom.sec.SecP384R1Point r1 = new org.bouncycastle.math.ec.custom.sec.SecP384R1Point
            r1.<init>(r2, r3, r4, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.custom.sec.SecP384R1Point.add(org.bouncycastle.math.ec.ECPoint):org.bouncycastle.math.ec.ECPoint");
    }

    public ECPoint detach() {
        return new SecP384R1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECPoint negate() {
        return isInfinity() ? this : new SecP384R1Point(this.curve, this.f59402x, this.f59403y.negate(), this.f59404zs);
    }

    public ECPoint threeTimes() {
        return (isInfinity() || this.f59403y.isZero()) ? this : twice().add(this);
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement) this.f59403y;
        if (secP384R1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP384R1FieldElement secP384R1FieldElement2 = (SecP384R1FieldElement) this.f59402x;
        SecP384R1FieldElement secP384R1FieldElement3 = (SecP384R1FieldElement) this.f59404zs[0];
        int[] create = Nat.create(24);
        int[] create2 = Nat.create(12);
        int[] create3 = Nat.create(12);
        int[] create4 = Nat.create(12);
        SecP384R1Field.square(secP384R1FieldElement.f59431x, create4, create);
        int[] create5 = Nat.create(12);
        SecP384R1Field.square(create4, create5, create);
        boolean isOne = secP384R1FieldElement3.isOne();
        int[] iArr = secP384R1FieldElement3.f59431x;
        if (!isOne) {
            SecP384R1Field.square(iArr, create3, create);
            iArr = create3;
        }
        SecP384R1Field.subtract(secP384R1FieldElement2.f59431x, iArr, create2);
        SecP384R1Field.add(secP384R1FieldElement2.f59431x, iArr, create3);
        SecP384R1Field.multiply(create3, create2, create3, create);
        SecP384R1Field.reduce32(Nat.addBothTo(12, create3, create3, create3), create3);
        SecP384R1Field.multiply(create4, secP384R1FieldElement2.f59431x, create4, create);
        SecP384R1Field.reduce32(Nat.shiftUpBits(12, create4, 2, 0), create4);
        SecP384R1Field.reduce32(Nat.shiftUpBits(12, create5, 3, 0, create2), create2);
        SecP384R1FieldElement secP384R1FieldElement4 = new SecP384R1FieldElement(create5);
        SecP384R1Field.square(create3, secP384R1FieldElement4.f59431x, create);
        int[] iArr2 = secP384R1FieldElement4.f59431x;
        SecP384R1Field.subtract(iArr2, create4, iArr2);
        int[] iArr3 = secP384R1FieldElement4.f59431x;
        SecP384R1Field.subtract(iArr3, create4, iArr3);
        SecP384R1FieldElement secP384R1FieldElement5 = new SecP384R1FieldElement(create4);
        SecP384R1Field.subtract(create4, secP384R1FieldElement4.f59431x, secP384R1FieldElement5.f59431x);
        int[] iArr4 = secP384R1FieldElement5.f59431x;
        SecP384R1Field.multiply(iArr4, create3, iArr4, create);
        int[] iArr5 = secP384R1FieldElement5.f59431x;
        SecP384R1Field.subtract(iArr5, create2, iArr5);
        SecP384R1FieldElement secP384R1FieldElement6 = new SecP384R1FieldElement(create3);
        SecP384R1Field.twice(secP384R1FieldElement.f59431x, secP384R1FieldElement6.f59431x);
        if (!isOne) {
            int[] iArr6 = secP384R1FieldElement6.f59431x;
            SecP384R1Field.multiply(iArr6, secP384R1FieldElement3.f59431x, iArr6, create);
        }
        return new SecP384R1Point(curve, secP384R1FieldElement4, secP384R1FieldElement5, new ECFieldElement[]{secP384R1FieldElement6});
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        return this == eCPoint ? threeTimes() : isInfinity() ? eCPoint : eCPoint.isInfinity() ? twice() : this.f59403y.isZero() ? eCPoint : twice().add(eCPoint);
    }
}
