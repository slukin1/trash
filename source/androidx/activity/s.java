package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlinx.coroutines.channels.k;

public final /* synthetic */ class s implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f3725b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f3726c;

    public /* synthetic */ s(k kVar, View view) {
        this.f3725b = kVar;
        this.f3726c = view;
    }

    public final void onScrollChanged() {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(this.f3725b, this.f3726c);
    }
}
