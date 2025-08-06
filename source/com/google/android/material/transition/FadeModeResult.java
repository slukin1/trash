package com.google.android.material.transition;

class FadeModeResult {
    public final int endAlpha;
    public final boolean endOnTop;
    public final int startAlpha;

    private FadeModeResult(int i11, int i12, boolean z11) {
        this.startAlpha = i11;
        this.endAlpha = i12;
        this.endOnTop = z11;
    }

    public static FadeModeResult endOnTop(int i11, int i12) {
        return new FadeModeResult(i11, i12, true);
    }

    public static FadeModeResult startOnTop(int i11, int i12) {
        return new FadeModeResult(i11, i12, false);
    }
}
