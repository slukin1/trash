package ov;

import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.zeroswap.engine.view.KLineEdgeItemView;
import com.huobi.zeroswap.engine.widget.KLineViewWidget;

public final /* synthetic */ class b implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KLineEdgeItemView f52984a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KLineViewWidget f52985b;

    public /* synthetic */ b(KLineEdgeItemView kLineEdgeItemView, KLineViewWidget kLineViewWidget) {
        this.f52984a = kLineEdgeItemView;
        this.f52985b = kLineViewWidget;
    }

    public final void a(String str) {
        KLineViewWidget.e0(this.f52984a, this.f52985b, str);
    }
}
