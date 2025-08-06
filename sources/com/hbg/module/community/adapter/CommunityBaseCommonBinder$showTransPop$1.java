package com.hbg.module.community.adapter;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.b;
import oc.a;

public final class CommunityBaseCommonBinder$showTransPop$1 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17046a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder<ItemData, SubViewHolder> f17047b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder.a f17048c;

    public CommunityBaseCommonBinder$showTransPop$1(CommunityFeedInfo.ListBean listBean, CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder, CommunityBaseCommonBinder.a aVar) {
        this.f17046a = listBean;
        this.f17047b = communityBaseCommonBinder;
        this.f17048c = aVar;
    }

    public void a() {
        a.C0131a.a(this);
    }

    public void b() {
        if (this.f17046a.isTrans()) {
            CommunityBaseCommonBinder.L(this.f17047b, this.f17048c, this.f17046a, false, 4, (Object) null);
        } else if (b.x(this.f17046a.getOldContent())) {
            RequestExtKt.d(v7.b.a().f0(String.valueOf(this.f17046a.getId()), 4), new CommunityBaseCommonBinder$showTransPop$1$transContent$1(this.f17046a, this.f17048c, this.f17047b), CommunityBaseCommonBinder$showTransPop$1$transContent$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        } else {
            this.f17047b.K(this.f17048c, this.f17046a, true);
        }
    }
}
