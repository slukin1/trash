package cb;

import android.view.View;
import com.hbg.lite.index.bean.LiteIndexMarketItem;
import com.hbg.lite.index.viewhandler.LiteIndexMarketItemHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteIndexMarketItem f13019b;

    public /* synthetic */ c(LiteIndexMarketItem liteIndexMarketItem) {
        this.f13019b = liteIndexMarketItem;
    }

    public final void onClick(View view) {
        LiteIndexMarketItemHandler.f(this.f13019b, view);
    }
}
