package cb;

import android.view.View;
import com.hbg.lite.index.bean.LiteIndexMarketItem;
import com.hbg.lite.index.viewhandler.LiteIndexMarketItemHandler;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteIndexMarketItem f13020b;

    public /* synthetic */ d(LiteIndexMarketItem liteIndexMarketItem) {
        this.f13020b = liteIndexMarketItem;
    }

    public final void onClick(View view) {
        LiteIndexMarketItemHandler.e(this.f13020b, view);
    }
}
