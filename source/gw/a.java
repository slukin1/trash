package gw;

import android.hardware.Camera;
import com.jumio.commons.camera.Camera1Manager;

public final /* synthetic */ class a implements Camera.AutoFocusCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera1Manager f54892b;

    public /* synthetic */ a(Camera1Manager camera1Manager) {
        this.f54892b = camera1Manager;
    }

    public final void onAutoFocus(boolean z11, Camera camera) {
        Camera1Manager.a(this.f54892b, z11, camera);
    }
}
