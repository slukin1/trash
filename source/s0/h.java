package s0;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f53426b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Typeface f53427c;

    public /* synthetic */ h(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f53426b = fontCallback;
        this.f53427c = typeface;
    }

    public final void run() {
        this.f53426b.lambda$callbackSuccessAsync$0(this.f53427c);
    }
}
