package com.huobi.finance.presenter;

import com.huobi.finance.bean.MarginSettings;
import java.util.List;
import rx.functions.Func3;

public final /* synthetic */ class j4 implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoanPresenter f45935b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f45936c;

    public /* synthetic */ j4(LoanPresenter loanPresenter, boolean z11) {
        this.f45935b = loanPresenter;
        this.f45936c = z11;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return this.f45935b.l0(this.f45936c, (List) obj, (MarginSettings) obj2, (List) obj3);
    }
}
