package com.huobi.index.viewhandler;

import androidx.lifecycle.MutableLiveData;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.huobi.index.bean.IndexDeep;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import v7.b;

public final class NewDeepHandler$handleView$1$4$1 extends Lambda implements l<Integer, Unit> {
    public final /* synthetic */ IndexDeep $news;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewDeepHandler$handleView$1$4$1(IndexDeep indexDeep) {
        super(1);
        this.$news = indexDeep;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.f56620a;
    }

    public final void invoke(Integer num) {
        RequestExtKt.d(b.a().V0(String.valueOf(this.$news.getId()), "3", num.intValue()), AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }
}
