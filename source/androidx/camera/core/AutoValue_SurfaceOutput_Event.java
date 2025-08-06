package androidx.camera.core;

import androidx.camera.core.SurfaceOutput;
import java.util.Objects;

final class AutoValue_SurfaceOutput_Event extends SurfaceOutput.Event {
    private final int eventCode;
    private final SurfaceOutput surfaceOutput;

    public AutoValue_SurfaceOutput_Event(int i11, SurfaceOutput surfaceOutput2) {
        this.eventCode = i11;
        Objects.requireNonNull(surfaceOutput2, "Null surfaceOutput");
        this.surfaceOutput = surfaceOutput2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceOutput.Event)) {
            return false;
        }
        SurfaceOutput.Event event = (SurfaceOutput.Event) obj;
        if (this.eventCode != event.getEventCode() || !this.surfaceOutput.equals(event.getSurfaceOutput())) {
            return false;
        }
        return true;
    }

    public int getEventCode() {
        return this.eventCode;
    }

    public SurfaceOutput getSurfaceOutput() {
        return this.surfaceOutput;
    }

    public int hashCode() {
        return ((this.eventCode ^ 1000003) * 1000003) ^ this.surfaceOutput.hashCode();
    }

    public String toString() {
        return "Event{eventCode=" + this.eventCode + ", surfaceOutput=" + this.surfaceOutput + "}";
    }
}
