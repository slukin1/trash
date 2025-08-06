package gw;

import com.jumio.commons.camera.Camera1Manager;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera1Manager f54897b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f54898c;

    public /* synthetic */ d(Camera1Manager camera1Manager, boolean z11) {
        this.f54897b = camera1Manager;
        this.f54898c = z11;
    }

    public final void run() {
        Camera1Manager.a(this.f54897b, this.f54898c);
    }
}
