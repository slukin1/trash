package androidx.camera.video;

import android.util.Range;
import androidx.camera.video.w1;
import androidx.core.util.Consumer;

public final /* synthetic */ class p0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f6335b;

    public /* synthetic */ p0(int i11) {
        this.f6335b = i11;
    }

    public final void accept(Object obj) {
        ((w1.a) obj).c(new Range(Integer.valueOf(this.f6335b), Integer.valueOf(this.f6335b)));
    }
}
