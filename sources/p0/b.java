package p0;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;

public final /* synthetic */ class b implements SharedElementCallback.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener f52994a;

    public /* synthetic */ b(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f52994a = onSharedElementsReadyListener;
    }

    public final void a() {
        ActivityCompat.e.a(this.f52994a);
    }
}
