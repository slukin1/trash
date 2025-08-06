package com.huobi.index.viewhandler;

import com.huobi.index.bean.IndexDeep;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import we.b;
import xe.c;

public final class NewDeepHandler$handleView$2$1$onDelClick$1 extends Lambda implements l<Object, Unit> {
    public final /* synthetic */ IndexDeep $news;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewDeepHandler$handleView$2$1$onDelClick$1(IndexDeep indexDeep) {
        super(1);
        this.$news = indexDeep;
    }

    public final void invoke(Object obj) {
        Long l11 = null;
        b.a m11 = b.m("dynamicDel", (Class) null, 2, (Object) null);
        IndexDeep indexDeep = this.$news;
        if (indexDeep != null) {
            l11 = Long.valueOf(indexDeep.getId());
        }
        m11.g(new c(String.valueOf(l11)));
    }
}
