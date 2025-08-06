package eo;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.main.trade.ui.SymbolSelectionFragment;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SymbolSelectionFragment f54367b;

    public /* synthetic */ b(SymbolSelectionFragment symbolSelectionFragment) {
        this.f54367b = symbolSelectionFragment;
    }

    public final void call(Object obj) {
        this.f54367b.Hh((BalanceDataTotal) obj);
    }
}
