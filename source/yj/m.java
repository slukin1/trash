package yj;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.huobi.edgeengine.template.widget.Widget;
import rj.n;

public final /* synthetic */ class m implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Widget f61763b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f61764c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f61765d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n f61766e;

    public /* synthetic */ m(Widget widget, View view, Context context, n nVar) {
        this.f61763b = widget;
        this.f61764c = view;
        this.f61765d = context;
        this.f61766e = nVar;
    }

    public final void onGlobalLayout() {
        this.f61763b.K(this.f61764c, this.f61765d, this.f61766e);
    }
}
