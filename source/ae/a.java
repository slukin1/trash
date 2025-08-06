package ae;

import android.view.View;
import com.hbg.module.kline.bean.CurrencyIntroItem;
import com.hbg.module.kline.handler.CurrencyIntroHandler;
import v9.c;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f3530b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrencyIntroItem f3531c;

    public /* synthetic */ a(c cVar, CurrencyIntroItem currencyIntroItem) {
        this.f3530b = cVar;
        this.f3531c = currencyIntroItem;
    }

    public final void onClick(View view) {
        CurrencyIntroHandler.d(this.f3530b, this.f3531c, view);
    }
}
