package nb;

import android.view.View;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f58314b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f58315c;

    public /* synthetic */ b(View.OnClickListener onClickListener, View view) {
        this.f58314b = onClickListener;
        this.f58315c = view;
    }

    public final void call(Object obj) {
        c.e(this.f58314b, this.f58315c, (Void) obj);
    }
}
