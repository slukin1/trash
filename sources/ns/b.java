package ns;

import android.view.View;
import com.huobi.supermargin.bean.MarginCurrency;
import com.huobi.supermargin.viewhandler.MarginCurrencyViewHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarginCurrency f58706b;

    public /* synthetic */ b(MarginCurrency marginCurrency) {
        this.f58706b = marginCurrency;
    }

    public final void onClick(View view) {
        MarginCurrencyViewHandler.d(this.f58706b, view);
    }
}
