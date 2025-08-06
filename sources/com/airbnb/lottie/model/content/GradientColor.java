package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

public class GradientColor {
    private final int[] colors;
    private final float[] positions;

    public GradientColor(float[] fArr, int[] iArr) {
        this.positions = fArr;
        this.colors = iArr;
    }

    public int[] getColors() {
        return this.colors;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void lerp(GradientColor gradientColor, GradientColor gradientColor2, float f11) {
        if (gradientColor.colors.length == gradientColor2.colors.length) {
            for (int i11 = 0; i11 < gradientColor.colors.length; i11++) {
                this.positions[i11] = MiscUtils.lerp(gradientColor.positions[i11], gradientColor2.positions[i11], f11);
                this.colors[i11] = GammaEvaluator.evaluate(f11, gradientColor.colors[i11], gradientColor2.colors[i11]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.colors.length + " vs " + gradientColor2.colors.length + ")");
    }
}
