package com.huobi.finance.presenter;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.finance.bean.FinanceRecordItem;

public final /* synthetic */ class g2 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CurrencyDetailPresenter f45888a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FinanceRecordItem f45889b;

    public /* synthetic */ g2(CurrencyDetailPresenter currencyDetailPresenter, FinanceRecordItem financeRecordItem) {
        this.f45888a = currencyDetailPresenter;
        this.f45889b = financeRecordItem;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f45888a.w0(this.f45889b, hBDialogFragment);
    }
}
