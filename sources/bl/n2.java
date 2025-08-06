package bl;

import android.view.View;
import com.huobi.finance.bean.GridAssetDetailListItem;
import com.huobi.finance.viewhandler.GridAssetDetailListItemHandler;

public final /* synthetic */ class n2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridAssetDetailListItem f12679b;

    public /* synthetic */ n2(GridAssetDetailListItem gridAssetDetailListItem) {
        this.f12679b = gridAssetDetailListItem;
    }

    public final void onClick(View view) {
        GridAssetDetailListItemHandler.f(this.f12679b, view);
    }
}
