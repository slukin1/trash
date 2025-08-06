package androidx.camera.core.processing;

import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.Objects;

final class AutoValue_DefaultSurfaceProcessor_PendingSnapshot extends DefaultSurfaceProcessor.PendingSnapshot {
    private final CallbackToFutureAdapter.a<Void> completer;
    private final int jpegQuality;
    private final int rotationDegrees;

    public AutoValue_DefaultSurfaceProcessor_PendingSnapshot(int i11, int i12, CallbackToFutureAdapter.a<Void> aVar) {
        this.jpegQuality = i11;
        this.rotationDegrees = i12;
        Objects.requireNonNull(aVar, "Null completer");
        this.completer = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultSurfaceProcessor.PendingSnapshot)) {
            return false;
        }
        DefaultSurfaceProcessor.PendingSnapshot pendingSnapshot = (DefaultSurfaceProcessor.PendingSnapshot) obj;
        if (this.jpegQuality == pendingSnapshot.getJpegQuality() && this.rotationDegrees == pendingSnapshot.getRotationDegrees() && this.completer.equals(pendingSnapshot.getCompleter())) {
            return true;
        }
        return false;
    }

    public CallbackToFutureAdapter.a<Void> getCompleter() {
        return this.completer;
    }

    public int getJpegQuality() {
        return this.jpegQuality;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public int hashCode() {
        return ((((this.jpegQuality ^ 1000003) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.completer.hashCode();
    }

    public String toString() {
        return "PendingSnapshot{jpegQuality=" + this.jpegQuality + ", rotationDegrees=" + this.rotationDegrees + ", completer=" + this.completer + "}";
    }
}
