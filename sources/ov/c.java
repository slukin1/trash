package ov;

import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.zeroswap.engine.view.KLineEdgeItemView;
import com.huobi.zeroswap.engine.widget.KLineViewWidget;

public final /* synthetic */ class c implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KLineEdgeItemView f52986a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KLineViewWidget f52987b;

    public /* synthetic */ c(KLineEdgeItemView kLineEdgeItemView, KLineViewWidget kLineViewWidget) {
        this.f52986a = kLineEdgeItemView;
        this.f52987b = kLineViewWidget;
    }

    public final void a(String str) {
        KLineViewWidget.c0(this.f52986a, this.f52987b, str);
    }
}
