package hc;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f54931b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f54932c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f54933d;

    public /* synthetic */ c(Dialog dialog, Activity activity, e eVar) {
        this.f54931b = dialog;
        this.f54932c = activity;
        this.f54933d = eVar;
    }

    public final void onClick(View view) {
        d.i(this.f54931b, this.f54932c, this.f54933d, view);
    }
}
