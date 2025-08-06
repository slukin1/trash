package ov;

import androidx.recyclerview.widget.RecyclerView;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.zeroswap.engine.widget.KLineListViewWidget;

public final /* synthetic */ class a implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f52982a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KLineListViewWidget f52983b;

    public /* synthetic */ a(RecyclerView recyclerView, KLineListViewWidget kLineListViewWidget) {
        this.f52982a = recyclerView;
        this.f52983b = kLineListViewWidget;
    }

    public final void a(String str) {
        KLineListViewWidget.a0(this.f52982a, this.f52983b, str);
    }
}
