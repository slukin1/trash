package jp;

import android.view.View;
import rx.functions.Action1;

public final /* synthetic */ class g implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f56015b;

    public /* synthetic */ g(View view) {
        this.f56015b = view;
    }

    public final void call(Object obj) {
        this.f56015b.setEnabled(((Boolean) obj).booleanValue());
    }
}
