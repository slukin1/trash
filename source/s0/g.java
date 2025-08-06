package s0;

import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f53424b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f53425c;

    public /* synthetic */ g(ResourcesCompat.FontCallback fontCallback, int i11) {
        this.f53424b = fontCallback;
        this.f53425c = i11;
    }

    public final void run() {
        this.f53424b.lambda$callbackFailAsync$1(this.f53425c);
    }
}
