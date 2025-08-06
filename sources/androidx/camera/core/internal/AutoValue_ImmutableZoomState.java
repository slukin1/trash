package androidx.camera.core.internal;

final class AutoValue_ImmutableZoomState extends ImmutableZoomState {
    private final float linearZoom;
    private final float maxZoomRatio;
    private final float minZoomRatio;
    private final float zoomRatio;

    public AutoValue_ImmutableZoomState(float f11, float f12, float f13, float f14) {
        this.zoomRatio = f11;
        this.maxZoomRatio = f12;
        this.minZoomRatio = f13;
        this.linearZoom = f14;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableZoomState)) {
            return false;
        }
        ImmutableZoomState immutableZoomState = (ImmutableZoomState) obj;
        if (Float.floatToIntBits(this.zoomRatio) == Float.floatToIntBits(immutableZoomState.getZoomRatio()) && Float.floatToIntBits(this.maxZoomRatio) == Float.floatToIntBits(immutableZoomState.getMaxZoomRatio()) && Float.floatToIntBits(this.minZoomRatio) == Float.floatToIntBits(immutableZoomState.getMinZoomRatio()) && Float.floatToIntBits(this.linearZoom) == Float.floatToIntBits(immutableZoomState.getLinearZoom())) {
            return true;
        }
        return false;
    }

    public float getLinearZoom() {
        return this.linearZoom;
    }

    public float getMaxZoomRatio() {
        return this.maxZoomRatio;
    }

    public float getMinZoomRatio() {
        return this.minZoomRatio;
    }

    public float getZoomRatio() {
        return this.zoomRatio;
    }

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.zoomRatio) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.maxZoomRatio)) * 1000003) ^ Float.floatToIntBits(this.minZoomRatio)) * 1000003) ^ Float.floatToIntBits(this.linearZoom);
    }

    public String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.zoomRatio + ", maxZoomRatio=" + this.maxZoomRatio + ", minZoomRatio=" + this.minZoomRatio + ", linearZoom=" + this.linearZoom + "}";
    }
}
