package gw;

import com.jumio.commons.camera.Camera1Manager;
import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera1Manager f54895b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f54896c;

    public /* synthetic */ c(Camera1Manager camera1Manager, Ref$ObjectRef ref$ObjectRef) {
        this.f54895b = camera1Manager;
        this.f54896c = ref$ObjectRef;
    }

    public final void run() {
        Camera1Manager.a(this.f54895b, this.f54896c);
    }
}
