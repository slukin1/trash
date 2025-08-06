package org.bouncycastle.pqc.crypto.gmss;

import org.bouncycastle.util.Arrays;

public class GMSSParameters {
    private int[] K;
    private int[] heightOfTrees;
    private int numOfLayers;
    private int[] winternitzParameter;

    public GMSSParameters(int i11) throws IllegalArgumentException {
        if (i11 <= 10) {
            init(1, new int[]{10}, new int[]{3}, new int[]{2});
        } else if (i11 <= 20) {
            init(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2});
        } else {
            init(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2});
        }
    }

    public GMSSParameters(int i11, int[] iArr, int[] iArr2, int[] iArr3) throws IllegalArgumentException {
        init(i11, iArr, iArr2, iArr3);
    }

    private void init(int i11, int[] iArr, int[] iArr2, int[] iArr3) throws IllegalArgumentException {
        boolean z11;
        String str;
        this.numOfLayers = i11;
        if (i11 == iArr2.length && i11 == iArr.length && i11 == iArr3.length) {
            z11 = true;
            str = "";
        } else {
            str = "Unexpected parameterset format";
            z11 = false;
        }
        for (int i12 = 0; i12 < this.numOfLayers; i12++) {
            if (iArr3[i12] < 2 || (iArr[i12] - iArr3[i12]) % 2 != 0) {
                str = "Wrong parameter K (K >= 2 and H-K even required)!";
                z11 = false;
            }
            if (iArr[i12] < 4 || iArr2[i12] < 2) {
                str = "Wrong parameter H or w (H > 3 and w > 1 required)!";
                z11 = false;
            }
        }
        if (z11) {
            this.heightOfTrees = Arrays.clone(iArr);
            this.winternitzParameter = Arrays.clone(iArr2);
            this.K = Arrays.clone(iArr3);
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public int[] getHeightOfTrees() {
        return Arrays.clone(this.heightOfTrees);
    }

    public int[] getK() {
        return Arrays.clone(this.K);
    }

    public int getNumOfLayers() {
        return this.numOfLayers;
    }

    public int[] getWinternitzParameter() {
        return Arrays.clone(this.winternitzParameter);
    }
}
