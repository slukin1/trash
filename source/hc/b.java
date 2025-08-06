package hc;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f54928b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f54929c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f54930d;

    public /* synthetic */ b(Dialog dialog, Activity activity, e eVar) {
        this.f54928b = dialog;
        this.f54929c = activity;
        this.f54930d = eVar;
    }

    public final void onClick(View view) {
        d.j(this.f54928b, this.f54929c, this.f54930d, view);
    }
}
