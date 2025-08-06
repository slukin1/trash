package e0;

import android.graphics.SurfaceTexture;
import androidx.camera.view.PreviewView;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PreviewView.d f54262b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f54263c;

    public /* synthetic */ s(PreviewView.d dVar, SurfaceTexture surfaceTexture) {
        this.f54262b = dVar;
        this.f54263c = surfaceTexture;
    }

    public final void run() {
        this.f54262b.a(this.f54263c.getTimestamp());
    }
}
