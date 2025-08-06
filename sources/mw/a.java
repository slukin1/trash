package mw;

import com.jumio.core.overlay.BaseLivenessOverlay;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseLivenessOverlay f58282b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58283c;

    public /* synthetic */ a(BaseLivenessOverlay baseLivenessOverlay, int i11) {
        this.f58282b = baseLivenessOverlay;
        this.f58283c = i11;
    }

    public final void run() {
        BaseLivenessOverlay.a(this.f58282b, this.f58283c);
    }
}
