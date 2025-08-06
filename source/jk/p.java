package jk;

import com.huobi.engineutils.widget.CurrencySelectWidget;
import com.huobi.view.BaseBottomCurrencyDialogFragment;

public final /* synthetic */ class p implements BaseBottomCurrencyDialogFragment.OnCurrencyMethodChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CurrencySelectWidget f55980a;

    public /* synthetic */ p(CurrencySelectWidget currencySelectWidget) {
        this.f55980a = currencySelectWidget;
    }

    public final void onCurrencyMethodChanged(String str) {
        this.f55980a.c0(str);
    }
}
