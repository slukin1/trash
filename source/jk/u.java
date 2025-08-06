package jk;

import android.view.View;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.engineutils.widget.SortSelectWidget;
import rj.n;

public final /* synthetic */ class u implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SortSelectWidget f55989a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f55990b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f55991c;

    public /* synthetic */ u(SortSelectWidget sortSelectWidget, View view, n nVar) {
        this.f55989a = sortSelectWidget;
        this.f55990b = view;
        this.f55991c = nVar;
    }

    public final void a(String str) {
        this.f55989a.e0(this.f55990b, this.f55991c, str);
    }
}
