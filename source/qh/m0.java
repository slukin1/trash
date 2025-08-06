package qh;

import android.app.Activity;
import android.view.View;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p0 f53358b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f53359c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f53360d;

    public /* synthetic */ m0(p0 p0Var, Activity activity, View view) {
        this.f53358b = p0Var;
        this.f53359c = activity;
        this.f53360d = view;
    }

    public final void run() {
        this.f53358b.s(this.f53359c, this.f53360d);
    }
}
