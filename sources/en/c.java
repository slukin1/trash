package en;

import android.view.View;
import com.huobi.contract.entity.PriceProtectionItem;
import com.huobi.linearswap.viewhandler.PriceProtectionItemHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PriceProtectionItem f54359b;

    public /* synthetic */ c(PriceProtectionItem priceProtectionItem) {
        this.f54359b = priceProtectionItem;
    }

    public final void onClick(View view) {
        PriceProtectionItemHandler.f(this.f54359b, view);
    }
}
