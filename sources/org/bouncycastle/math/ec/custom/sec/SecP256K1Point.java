package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

public class SecP256K1Point extends ECPoint.AbstractFp {
    public SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
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
            org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement r3 = (org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement) r3
            org.bouncycastle.math.ec.ECFieldElement r4 = r0.f59403y
            org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement r4 = (org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement) r4
            org.bouncycastle.math.ec.ECFieldElement r5 = r17.getXCoord()
            org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement r5 = (org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement) r5
            org.bouncycastle.math.ec.ECFieldElement r6 = r17.getYCoord()
            org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement r6 = (org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement) r6
            org.bouncycastle.math.ec.ECFieldElement[] r7 = r0.f59404zs
            r8 = 0
            r7 = r7[r8]
            org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement r7 = (org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement) r7
            org.bouncycastle.math.ec.ECFieldElement r1 = r1.getZCoord(r8)
            org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement r1 = (org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement) r1
            int[] r9 = org.bouncycastle.math.raw.Nat256.createExt()
            int[] r10 = org.bouncycastle.math.raw.Nat256.createExt()
            int[] r11 = org.bouncycastle.math.raw.Nat256.create()
            int[] r12 = org.bouncycastle.math.raw.Nat256.create()
            int[] r13 = org.bouncycastle.math.raw.Nat256.create()
            boolean r14 = r7.isOne()
            if (r14 == 0) goto L_0x005d
            int[] r5 = r5.f59427x
            int[] r6 = r6.f59427x
            goto L_0x0073
        L_0x005d:
            int[] r15 = r7.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.square(r15, r12, r9)
            int[] r5 = r5.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiply(r12, r5, r11, r9)
            int[] r5 = r7.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiply(r12, r5, r12, r9)
            int[] r5 = r6.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiply(r12, r5, r12, r9)
            r5 = r11
            r6 = r12
        L_0x0073:
            boolean r15 = r1.isOne()
            if (r15 == 0) goto L_0x007e
            int[] r3 = r3.f59427x
            int[] r4 = r4.f59427x
            goto L_0x0094
        L_0x007e:
            int[] r8 = r1.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.square(r8, r13, r9)
            int[] r3 = r3.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiply(r13, r3, r10, r9)
            int[] r3 = r1.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiply(r13, r3, r13, r9)
            int[] r3 = r4.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiply(r13, r3, r13, r9)
            r3 = r10
            r4 = r13
        L_0x0094:
            int[] r8 = org.bouncycastle.math.raw.Nat256.create()
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.subtract(r3, r5, r8)
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.subtract(r4, r6, r11)
            boolean r5 = org.bouncycastle.math.raw.Nat256.isZero(r8)
            if (r5 == 0) goto L_0x00b4
            boolean r1 = org.bouncycastle.math.raw.Nat256.isZero(r11)
            if (r1 == 0) goto L_0x00af
            org.bouncycastle.math.ec.ECPoint r1 = r16.twice()
            return r1
        L_0x00af:
            org.bouncycastle.math.ec.ECPoint r1 = r2.getInfinity()
            return r1
        L_0x00b4:
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.square(r8, r12, r9)
            int[] r5 = org.bouncycastle.math.raw.Nat256.create()
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiply(r12, r8, r5, r9)
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiply(r12, r3, r12, r9)
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.negate(r5, r5)
            org.bouncycastle.math.raw.Nat256.mul(r4, r5, r10)
            int r3 = org.bouncycastle.math.raw.Nat256.addBothTo(r12, r12, r5)
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.reduce32(r3, r5)
            org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement r3 = new org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement
            r3.<init>((int[]) r13)
            int[] r4 = r3.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.square(r11, r4, r9)
            int[] r4 = r3.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.subtract(r4, r5, r4)
            org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement r4 = new org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement
            r4.<init>((int[]) r5)
            int[] r5 = r3.f59427x
            int[] r6 = r4.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.subtract(r12, r5, r6)
            int[] r5 = r4.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiplyAddToExt(r5, r11, r10)
            int[] r5 = r4.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.reduce(r10, r5)
            org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement r5 = new org.bouncycastle.math.ec.custom.sec.SecP256K1FieldElement
            r5.<init>((int[]) r8)
            if (r14 != 0) goto L_0x0101
            int[] r6 = r5.f59427x
            int[] r7 = r7.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiply(r6, r7, r6, r9)
        L_0x0101:
            if (r15 != 0) goto L_0x010a
            int[] r6 = r5.f59427x
            int[] r1 = r1.f59427x
            org.bouncycastle.math.ec.custom.sec.SecP256K1Field.multiply(r6, r1, r6, r9)
        L_0x010a:
            r1 = 1
            org.bouncycastle.math.ec.ECFieldElement[] r1 = new org.bouncycastle.math.ec.ECFieldElement[r1]
            r6 = 0
            r1[r6] = r5
            org.bouncycastle.math.ec.custom.sec.SecP256K1Point r5 = new org.bouncycastle.math.ec.custom.sec.SecP256K1Point
            r5.<init>(r2, r3, r4, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.custom.sec.SecP256K1Point.add(org.bouncycastle.math.ec.ECPoint):org.bouncycastle.math.ec.ECPoint");
    }

    public ECPoint detach() {
        return new SecP256K1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECPoint negate() {
        return isInfinity() ? this : new SecP256K1Point(this.curve, this.f59402x, this.f59403y.negate(), this.f59404zs);
    }

    public ECPoint threeTimes() {
        return (isInfinity() || this.f59403y.isZero()) ? this : twice().add(this);
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement) this.f59403y;
        if (secP256K1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement) this.f59402x;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement) this.f59404zs[0];
        int[] createExt = Nat256.createExt();
        int[] create = Nat256.create();
        SecP256K1Field.square(secP256K1FieldElement.f59427x, create, createExt);
        int[] create2 = Nat256.create();
        SecP256K1Field.square(create, create2, createExt);
        int[] create3 = Nat256.create();
        SecP256K1Field.square(secP256K1FieldElement2.f59427x, create3, createExt);
        SecP256K1Field.reduce32(Nat256.addBothTo(create3, create3, create3), create3);
        SecP256K1Field.multiply(create, secP256K1FieldElement2.f59427x, create, createExt);
        SecP256K1Field.reduce32(Nat.shiftUpBits(8, create, 2, 0), create);
        int[] create4 = Nat256.create();
        SecP256K1Field.reduce32(Nat.shiftUpBits(8, create2, 3, 0, create4), create4);
        SecP256K1FieldElement secP256K1FieldElement4 = new SecP256K1FieldElement(create2);
        SecP256K1Field.square(create3, secP256K1FieldElement4.f59427x, createExt);
        int[] iArr = secP256K1FieldElement4.f59427x;
        SecP256K1Field.subtract(iArr, create, iArr);
        int[] iArr2 = secP256K1FieldElement4.f59427x;
        SecP256K1Field.subtract(iArr2, create, iArr2);
        SecP256K1FieldElement secP256K1FieldElement5 = new SecP256K1FieldElement(create);
        SecP256K1Field.subtract(create, secP256K1FieldElement4.f59427x, secP256K1FieldElement5.f59427x);
        int[] iArr3 = secP256K1FieldElement5.f59427x;
        SecP256K1Field.multiply(iArr3, create3, iArr3, createExt);
        int[] iArr4 = secP256K1FieldElement5.f59427x;
        SecP256K1Field.subtract(iArr4, create4, iArr4);
        SecP256K1FieldElement secP256K1FieldElement6 = new SecP256K1FieldElement(create3);
        SecP256K1Field.twice(secP256K1FieldElement.f59427x, secP256K1FieldElement6.f59427x);
        if (!secP256K1FieldElement3.isOne()) {
            int[] iArr5 = secP256K1FieldElement6.f59427x;
            SecP256K1Field.multiply(iArr5, secP256K1FieldElement3.f59427x, iArr5, createExt);
        }
        return new SecP256K1Point(curve, secP256K1FieldElement4, secP256K1FieldElement5, new ECFieldElement[]{secP256K1FieldElement6});
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        return this == eCPoint ? threeTimes() : isInfinity() ? eCPoint : eCPoint.isInfinity() ? twice() : this.f59403y.isZero() ? eCPoint : twice().add(eCPoint);
    }
}
