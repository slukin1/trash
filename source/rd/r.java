package rd;

import android.view.View;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f70542b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f70543c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f70544d;

    public /* synthetic */ r(View view, long j11, View.OnClickListener onClickListener) {
        this.f70542b = view;
        this.f70543c = j11;
        this.f70544d = onClickListener;
    }

    public final void onClick(View view) {
        s.m(this.f70542b, this.f70543c, this.f70544d, view);
    }
}
