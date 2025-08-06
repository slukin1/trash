package bl;

import c6.b;
import com.huobi.finance.bean.GridAssetCurrencyListItem;
import com.huobi.finance.viewhandler.GridAssetListItemHandler;
import vk.o;

public final /* synthetic */ class q2 implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f12710b;

    public /* synthetic */ q2(o oVar) {
        this.f12710b = oVar;
    }

    public final void onCallback(Object obj) {
        GridAssetListItemHandler.e(this.f12710b, (GridAssetCurrencyListItem) obj);
    }
}
