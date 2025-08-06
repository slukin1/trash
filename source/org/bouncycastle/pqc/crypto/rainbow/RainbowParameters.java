package org.bouncycastle.pqc.crypto.rainbow;

import org.bouncycastle.crypto.CipherParameters;

public class RainbowParameters implements CipherParameters {
    private final int[] DEFAULT_VI;

    /* renamed from: vi  reason: collision with root package name */
    private int[] f59596vi;

    public RainbowParameters() {
        int[] iArr = {6, 12, 17, 22, 33};
        this.DEFAULT_VI = iArr;
        this.f59596vi = iArr;
    }

    public RainbowParameters(int[] iArr) {
        this.DEFAULT_VI = new int[]{6, 12, 17, 22, 33};
        this.f59596vi = iArr;
        checkParams();
    }

    private void checkParams() {
        int[] iArr;
        int i11;
        int[] iArr2 = this.f59596vi;
        if (iArr2 == null) {
            throw new IllegalArgumentException("no layers defined.");
        } else if (iArr2.length > 1) {
            int i12 = 0;
            do {
                iArr = this.f59596vi;
                if (i12 < iArr.length - 1) {
                    i11 = iArr[i12];
                    i12++;
                } else {
                    return;
                }
            } while (i11 < iArr[i12]);
            throw new IllegalArgumentException("v[i] has to be smaller than v[i+1]");
        } else {
            throw new IllegalArgumentException("Rainbow needs at least 1 layer, such that v1 < v2.");
        }
    }

    public int getDocLength() {
        int[] iArr = this.f59596vi;
        return iArr[iArr.length - 1] - iArr[0];
    }

    public int getNumOfLayers() {
        return this.f59596vi.length - 1;
    }

    public int[] getVi() {
        return this.f59596vi;
    }
}
