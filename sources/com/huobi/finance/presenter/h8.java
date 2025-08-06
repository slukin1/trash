package com.huobi.finance.presenter;

import androidx.fragment.app.FragmentManager;
import rx.functions.Action1;

public final /* synthetic */ class h8 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f45909b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f45910c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f45911d;

    public /* synthetic */ h8(UnifyTransferPresenter unifyTransferPresenter, FragmentManager fragmentManager, String str) {
        this.f45909b = unifyTransferPresenter;
        this.f45910c = fragmentManager;
        this.f45911d = str;
    }

    public final void call(Object obj) {
        this.f45909b.y2(this.f45910c, this.f45911d, obj);
    }
}
