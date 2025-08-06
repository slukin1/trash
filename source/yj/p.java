package yj;

import android.widget.PopupWindow;
import com.huobi.edgeengine.template.widget.Widget;
import rj.n;

public final /* synthetic */ class p implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Widget f61774b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Widget f61775c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f61776d;

    public /* synthetic */ p(Widget widget, Widget widget2, n nVar) {
        this.f61774b = widget;
        this.f61775c = widget2;
        this.f61776d = nVar;
    }

    public final void onDismiss() {
        this.f61774b.N(this.f61775c, this.f61776d);
    }
}
