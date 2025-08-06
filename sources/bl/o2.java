package bl;

import c6.b;
import com.huobi.finance.bean.GridAssetCurrencyListItem;
import com.huobi.finance.bean.GridAssetDetailListItem;
import com.huobi.finance.viewhandler.GridAssetDetailListItemHandler;

public final /* synthetic */ class o2 implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridAssetDetailListItem f12689b;

    public /* synthetic */ o2(GridAssetDetailListItem gridAssetDetailListItem) {
        this.f12689b = gridAssetDetailListItem;
    }

    public final void onCallback(Object obj) {
        GridAssetDetailListItemHandler.e(this.f12689b, (GridAssetCurrencyListItem) obj);
    }
}
