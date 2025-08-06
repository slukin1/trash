package ov;

import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.zeroswap.engine.view.KLineEdgeItemView;
import com.huobi.zeroswap.engine.widget.KLineViewWidget;

public final /* synthetic */ class d implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KLineEdgeItemView f52988a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KLineViewWidget f52989b;

    public /* synthetic */ d(KLineEdgeItemView kLineEdgeItemView, KLineViewWidget kLineViewWidget) {
        this.f52988a = kLineEdgeItemView;
        this.f52989b = kLineViewWidget;
    }

    public final void a(String str) {
        KLineViewWidget.d0(this.f52988a, this.f52989b, str);
    }
}
