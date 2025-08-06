package bl;

import android.view.View;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.viewhandler.CurrencyRecordViewHandler;
import v9.c;

public final /* synthetic */ class i2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyRecordViewHandler f12617b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FinanceRecordItem f12618c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f12619d;

    public /* synthetic */ i2(CurrencyRecordViewHandler currencyRecordViewHandler, FinanceRecordItem financeRecordItem, c cVar) {
        this.f12617b = currencyRecordViewHandler;
        this.f12618c = financeRecordItem;
        this.f12619d = cVar;
    }

    public final void onClick(View view) {
        this.f12617b.i(this.f12618c, this.f12619d, view);
    }
}
