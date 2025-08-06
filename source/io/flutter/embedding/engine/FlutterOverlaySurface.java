package io.flutter.embedding.engine;

import android.view.Surface;
import androidx.annotation.Keep;

@Keep
public class FlutterOverlaySurface {

    /* renamed from: id  reason: collision with root package name */
    private final int f55127id;
    private final Surface surface;

    public FlutterOverlaySurface(int i11, Surface surface2) {
        this.f55127id = i11;
        this.surface = surface2;
    }

    public int getId() {
        return this.f55127id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
