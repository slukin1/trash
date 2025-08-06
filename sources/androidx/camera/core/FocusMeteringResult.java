package androidx.camera.core;

public final class FocusMeteringResult {
    private boolean mIsFocusSuccessful;

    private FocusMeteringResult(boolean z11) {
        this.mIsFocusSuccessful = z11;
    }

    public static FocusMeteringResult create(boolean z11) {
        return new FocusMeteringResult(z11);
    }

    public static FocusMeteringResult emptyInstance() {
        return new FocusMeteringResult(false);
    }

    public boolean isFocusSuccessful() {
        return this.mIsFocusSuccessful;
    }
}
