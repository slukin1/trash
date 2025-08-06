package androidx.window.layout;

import androidx.core.util.Consumer;
import kotlinx.coroutines.channels.d;

public final /* synthetic */ class r implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f12156b;

    public /* synthetic */ r(d dVar) {
        this.f12156b = dVar;
    }

    public final void accept(Object obj) {
        WindowInfoTrackerImpl$windowLayoutInfo$1.m12invokeSuspend$lambda0(this.f12156b, (s) obj);
    }
}
