package qh;

import android.view.View;
import com.hbg.lib.core.ui.BaseFragment;

public final /* synthetic */ class o0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p0 f53365b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseFragment f53366c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f53367d;

    public /* synthetic */ o0(p0 p0Var, BaseFragment baseFragment, View view) {
        this.f53365b = p0Var;
        this.f53366c = baseFragment;
        this.f53367d = view;
    }

    public final void run() {
        this.f53365b.u(this.f53366c, this.f53367d);
    }
}
