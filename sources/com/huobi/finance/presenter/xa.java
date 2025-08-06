package com.huobi.finance.presenter;

import java.util.List;
import rx.functions.Func3;

public final /* synthetic */ class xa implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f46181b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f46182c;

    public /* synthetic */ xa(UnifyWithdrawPresenter unifyWithdrawPresenter, boolean z11) {
        this.f46181b = unifyWithdrawPresenter;
        this.f46182c = z11;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return this.f46181b.u1(this.f46182c, (List) obj, (String) obj2, (List) obj3);
    }
}
