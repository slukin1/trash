package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class RainbowParameterSpec implements AlgorithmParameterSpec {
    private static final int[] DEFAULT_VI = {6, 12, 17, 22, 33};

    /* renamed from: vi  reason: collision with root package name */
    private int[] f59625vi;

    public RainbowParameterSpec() {
        this.f59625vi = DEFAULT_VI;
    }

    public RainbowParameterSpec(int[] iArr) {
        this.f59625vi = iArr;
        checkParams();
    }

    private void checkParams() {
        int[] iArr;
        int i11;
        int[] iArr2 = this.f59625vi;
        if (iArr2 == null) {
            throw new IllegalArgumentException("no layers defined.");
        } else if (iArr2.length > 1) {
            int i12 = 0;
            do {
                iArr = this.f59625vi;
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

    public int getDocumentLength() {
        int[] iArr = this.f59625vi;
        return iArr[iArr.length - 1] - iArr[0];
    }

    public int getNumOfLayers() {
        return this.f59625vi.length - 1;
    }

    public int[] getVi() {
        return Arrays.clone(this.f59625vi);
    }
}
