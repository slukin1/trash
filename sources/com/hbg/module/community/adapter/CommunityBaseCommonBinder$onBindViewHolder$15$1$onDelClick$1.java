package com.hbg.module.community.adapter;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import we.b;
import xe.c;

public final class CommunityBaseCommonBinder$onBindViewHolder$15$1$onDelClick$1 extends Lambda implements l<Object, Unit> {
    public final /* synthetic */ CommunityFeedInfo.ListBean $item;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityBaseCommonBinder$onBindViewHolder$15$1$onDelClick$1(CommunityFeedInfo.ListBean listBean) {
        super(1);
        this.$item = listBean;
    }

    public final void invoke(Object obj) {
        b.m("dynamicDel", (Class) null, 2, (Object) null).g(new c(String.valueOf(this.$item.getId())));
    }
}
