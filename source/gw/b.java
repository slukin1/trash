package gw;

import android.graphics.Matrix;
import com.jumio.commons.camera.Camera1Manager;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera1Manager f54893b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Matrix f54894c;

    public /* synthetic */ b(Camera1Manager camera1Manager, Matrix matrix) {
        this.f54893b = camera1Manager;
        this.f54894c = matrix;
    }

    public final void run() {
        Camera1Manager.a(this.f54893b, this.f54894c);
    }
}
