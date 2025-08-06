package androidx.camera.core;

import android.graphics.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.core.util.Consumer;
import com.google.auto.value.AutoValue;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

public interface SurfaceOutput extends Closeable {

    @AutoValue
    public static abstract class Event {
        public static final int EVENT_REQUEST_CLOSE = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EventCode {
        }

        public static Event of(int i11, SurfaceOutput surfaceOutput) {
            return new AutoValue_SurfaceOutput_Event(i11, surfaceOutput);
        }

        public abstract int getEventCode();

        public abstract SurfaceOutput getSurfaceOutput();
    }

    void close();

    int getFormat();

    Matrix getSensorToBufferTransform();

    Size getSize();

    Surface getSurface(Executor executor, Consumer<Event> consumer);

    int getTargets();

    void updateTransformMatrix(float[] fArr, float[] fArr2);
}
