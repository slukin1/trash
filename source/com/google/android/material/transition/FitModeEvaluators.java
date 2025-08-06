package com.google.android.material.transition;

import android.graphics.RectF;

class FitModeEvaluators {
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() {
        public void applyMask(RectF rectF, float f11, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f11;
            rectF.left += abs;
            rectF.right -= abs;
        }

        public FitModeResult evaluate(float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
            float lerp = TransitionUtils.lerp(f15, f17, f12, f13, f11, true);
            float f18 = lerp / f15;
            float f19 = lerp / f17;
            return new FitModeResult(f18, f19, f14 * f18, lerp, f16 * f19, lerp);
        }

        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartWidth > fitModeResult.currentEndWidth;
        }
    };
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() {
        public void applyMask(RectF rectF, float f11, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f11;
        }

        public FitModeResult evaluate(float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
            float lerp = TransitionUtils.lerp(f14, f16, f12, f13, f11, true);
            float f18 = lerp / f14;
            float f19 = lerp / f16;
            return new FitModeResult(f18, f19, lerp, f15 * f18, lerp, f17 * f19);
        }

        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartHeight > fitModeResult.currentEndHeight;
        }
    };

    private FitModeEvaluators() {
    }

    public static FitModeEvaluator get(int i11, boolean z11, RectF rectF, RectF rectF2) {
        if (i11 == 0) {
            return shouldAutoFitToWidth(z11, rectF, rectF2) ? WIDTH : HEIGHT;
        }
        if (i11 == 1) {
            return WIDTH;
        }
        if (i11 == 2) {
            return HEIGHT;
        }
        throw new IllegalArgumentException("Invalid fit mode: " + i11);
    }

    private static boolean shouldAutoFitToWidth(boolean z11, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f11 = (height2 * width) / width2;
        float f12 = (width2 * height) / width;
        if (z11) {
            if (f11 >= height) {
                return true;
            }
        } else if (f12 >= height2) {
            return true;
        }
        return false;
    }
}
