package nw;

import com.jumio.core.views.CameraScanView;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f58709b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraScanView f58710c;

    public /* synthetic */ a(boolean z11, CameraScanView cameraScanView) {
        this.f58709b = z11;
        this.f58710c = cameraScanView;
    }

    public final void run() {
        CameraScanView.a(this.f58709b, this.f58710c);
    }
}
