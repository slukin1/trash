package com.hbg.module.community.adapter;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.content.utls.m;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import nc.c;
import v7.b;

public final class CommunityBaseCommonBinder$onBindViewHolder$15$1 implements m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17032a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder<ItemData, SubViewHolder> f17033b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f17034c;

    public CommunityBaseCommonBinder$onBindViewHolder$15$1(CommunityFeedInfo.ListBean listBean, CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder, Context context) {
        this.f17032a = listBean;
        this.f17033b = communityBaseCommonBinder;
        this.f17034c = context;
    }

    public void a() {
        m.a.c(this);
        c.a("app_community_jb", this.f17033b.G(this.f17032a));
        DialogUtils.S((FragmentActivity) this.f17034c);
    }

    public void b() {
        m.a.e(this);
        this.f17033b.p0(this.f17034c, this.f17032a.getUidUnique());
    }

    public void c(int i11) {
        m.a.b(this, i11);
        this.f17033b.o0(this.f17034c, i11, this.f17032a.getUidUnique());
    }

    public void d() {
        m.a.d(this);
    }

    public void e() {
        m.a.a(this);
        RequestExtKt.d(b.a().y0(String.valueOf(this.f17032a.getId())), new CommunityBaseCommonBinder$onBindViewHolder$15$1$onDelClick$1(this.f17032a), CommunityBaseCommonBinder$onBindViewHolder$15$1$onDelClick$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }
}
