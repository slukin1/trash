package com.huobi.finance.presenter;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.finance.bean.FinanceRecordItem;

public final /* synthetic */ class t4 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MineCurrencyDetailPresenter f46117a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FinanceRecordItem f46118b;

    public /* synthetic */ t4(MineCurrencyDetailPresenter mineCurrencyDetailPresenter, FinanceRecordItem financeRecordItem) {
        this.f46117a = mineCurrencyDetailPresenter;
        this.f46118b = financeRecordItem;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f46117a.r0(this.f46118b, hBDialogFragment);
    }
}
