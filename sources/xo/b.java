package xo;

import android.view.View;
import com.huobi.order.persenter.TradeOrderHistoryDetailPresenter;
import java.util.ArrayList;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeOrderHistoryDetailPresenter f61658b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArrayList f61659c;

    public /* synthetic */ b(TradeOrderHistoryDetailPresenter tradeOrderHistoryDetailPresenter, ArrayList arrayList) {
        this.f61658b = tradeOrderHistoryDetailPresenter;
        this.f61659c = arrayList;
    }

    public final void onClick(View view) {
        this.f61658b.b0(this.f61659c, view);
    }
}
