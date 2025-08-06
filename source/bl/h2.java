package bl;

import android.view.View;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.viewhandler.CurrencyRecordViewHandler;

public final /* synthetic */ class h2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyRecordViewHandler f12605b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f12606c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FinanceRecordItem f12607d;

    public /* synthetic */ h2(CurrencyRecordViewHandler currencyRecordViewHandler, View view, FinanceRecordItem financeRecordItem) {
        this.f12605b = currencyRecordViewHandler;
        this.f12606c = view;
        this.f12607d = financeRecordItem;
    }

    public final void onClick(View view) {
        this.f12605b.h(this.f12606c, this.f12607d, view);
    }
}
