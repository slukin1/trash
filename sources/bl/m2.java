package bl;

import android.view.View;
import com.huobi.finance.bean.GridAssetCurrencyListItem;
import com.huobi.finance.viewhandler.GridAssetCurrencyListItemHandler;

public final /* synthetic */ class m2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridAssetCurrencyListItem f12667b;

    public /* synthetic */ m2(GridAssetCurrencyListItem gridAssetCurrencyListItem) {
        this.f12667b = gridAssetCurrencyListItem;
    }

    public final void onClick(View view) {
        GridAssetCurrencyListItemHandler.d(this.f12667b, view);
    }
}
