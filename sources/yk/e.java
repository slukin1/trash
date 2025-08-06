package yk;

import com.huobi.finance.transfer.ui.SuperMarginChooseCurrencyActivity;
import com.huobi.supermargin.bean.MarginCurrency;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f61788b;

    public /* synthetic */ e(boolean z11) {
        this.f61788b = z11;
    }

    public final Object call(Object obj) {
        return SuperMarginChooseCurrencyActivity.zj(this.f61788b, (MarginCurrency) obj);
    }
}
