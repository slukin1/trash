package com.hbg.module.content.custom.widget;

import com.hbg.module.content.custom.tag.TagLayout;
import com.huobi.edgeengine.node.trace.ArrayListener;
import java.util.List;
import rj.n;

public final /* synthetic */ class h implements ArrayListener.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TagLayout f18224a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f18225b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TagViewWidget f18226c;

    public /* synthetic */ h(TagLayout tagLayout, n nVar, TagViewWidget tagViewWidget) {
        this.f18224a = tagLayout;
        this.f18225b = nVar;
        this.f18226c = tagViewWidget;
    }

    public final void a(int i11, List list, List list2) {
        TagViewWidget.f0(this.f18224a, this.f18225b, this.f18226c, i11, list, list2);
    }
}
