package androidx.camera.core.internal;

import androidx.camera.core.ZoomState;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ImmutableZoomState implements ZoomState {
    public static ZoomState create(float f11, float f12, float f13, float f14) {
        return new AutoValue_ImmutableZoomState(f11, f12, f13, f14);
    }

    public abstract float getLinearZoom();

    public abstract float getMaxZoomRatio();

    public abstract float getMinZoomRatio();

    public abstract float getZoomRatio();

    public static ZoomState create(ZoomState zoomState) {
        return new AutoValue_ImmutableZoomState(zoomState.getZoomRatio(), zoomState.getMaxZoomRatio(), zoomState.getMinZoomRatio(), zoomState.getLinearZoom());
    }
}
