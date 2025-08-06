package org.bouncycastle.math.ec;

public class SimpleLookupTable extends AbstractECLookupTable {
    private final ECPoint[] points;

    public SimpleLookupTable(ECPoint[] eCPointArr, int i11, int i12) {
        this.points = copy(eCPointArr, i11, i12);
    }

    private static ECPoint[] copy(ECPoint[] eCPointArr, int i11, int i12) {
        ECPoint[] eCPointArr2 = new ECPoint[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            eCPointArr2[i13] = eCPointArr[i11 + i13];
        }
        return eCPointArr2;
    }

    public int getSize() {
        return this.points.length;
    }

    public ECPoint lookup(int i11) {
        throw new UnsupportedOperationException("Constant-time lookup not supported");
    }

    public ECPoint lookupVar(int i11) {
        return this.points[i11];
    }
}
