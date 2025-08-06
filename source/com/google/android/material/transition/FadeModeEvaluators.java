package com.google.android.material.transition;

class FadeModeEvaluators {
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f11, float f12, float f13, float f14) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f12, f13, f11), TransitionUtils.lerp(0, 255, f12, f13, f11));
        }
    };
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f11, float f12, float f13, float f14) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f12, f13, f11));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f11, float f12, float f13, float f14) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f12, f13, f11), 255);
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f11, float f12, float f13, float f14) {
            float f15 = ((f13 - f12) * f14) + f12;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f12, f15, f11), TransitionUtils.lerp(0, 255, f15, f13, f11));
        }
    };

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i11, boolean z11) {
        if (i11 == 0) {
            return z11 ? IN : OUT;
        }
        if (i11 == 1) {
            return z11 ? OUT : IN;
        }
        if (i11 == 2) {
            return CROSS;
        }
        if (i11 == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i11);
    }
}
