package androidx.activity;

import android.view.View;
import kotlinx.coroutines.channels.k;

public final /* synthetic */ class r implements View.OnLayoutChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f3686b;

    public /* synthetic */ r(k kVar) {
        this.f3686b = kVar;
    }

    public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(this.f3686b, view, i11, i12, i13, i14, i15, i16, i17, i18);
    }
}
