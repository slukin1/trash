package pt;

import android.view.View;
import com.huobi.tradenew.handler.TradeGuideListItemHandler;
import ws.e;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f53239b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f53240c;

    public /* synthetic */ l(e eVar, int i11) {
        this.f53239b = eVar;
        this.f53240c = i11;
    }

    public final void onClick(View view) {
        TradeGuideListItemHandler.d(this.f53239b, this.f53240c, view);
    }
}
