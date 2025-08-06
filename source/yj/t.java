package yj;

import android.content.Context;
import android.view.View;
import com.huobi.edgeengine.template.widget.Widget;
import rj.n;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Widget f61780b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f61781c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f61782d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n f61783e;

    public /* synthetic */ t(Widget widget, Context context, View view, n nVar) {
        this.f61780b = widget;
        this.f61781c = context;
        this.f61782d = view;
        this.f61783e = nVar;
    }

    public final void run() {
        this.f61780b.J(this.f61781c, this.f61782d, this.f61783e);
    }
}
