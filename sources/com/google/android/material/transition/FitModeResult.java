package com.google.android.material.transition;

class FitModeResult {
    public final float currentEndHeight;
    public final float currentEndWidth;
    public final float currentStartHeight;
    public final float currentStartWidth;
    public final float endScale;
    public final float startScale;

    public FitModeResult(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.startScale = f11;
        this.endScale = f12;
        this.currentStartWidth = f13;
        this.currentStartHeight = f14;
        this.currentEndWidth = f15;
        this.currentEndHeight = f16;
    }
}
