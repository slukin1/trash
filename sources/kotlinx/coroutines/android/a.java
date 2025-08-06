package kotlinx.coroutines.android;

import kotlinx.coroutines.x0;

public final /* synthetic */ class a implements x0 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HandlerContext f56985b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f56986c;

    public /* synthetic */ a(HandlerContext handlerContext, Runnable runnable) {
        this.f56985b = handlerContext;
        this.f56986c = runnable;
    }

    public final void dispose() {
        HandlerContext.O(this.f56985b, this.f56986c);
    }
}
