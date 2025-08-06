package com.hbg.module.community.adapter;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.ShareResultBean;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import d10.l;
import d9.a;
import i6.d;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import v7.b;

public final class CommunityBaseCommonBinder$onBindShareAction$2 extends Lambda implements l<Integer, Unit> {
    public final /* synthetic */ CommunityBaseCommonBinder.a $holder;
    public final /* synthetic */ CommunityFeedInfo.ListBean $item;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityBaseCommonBinder$onBindShareAction$2(CommunityFeedInfo.ListBean listBean, CommunityBaseCommonBinder.a aVar) {
        super(1);
        this.$item = listBean;
        this.$holder = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11) {
        a<ShareResultBean> V0 = b.a().V0(String.valueOf(this.$item.getId()), "4", i11);
        final CommunityFeedInfo.ListBean listBean = this.$item;
        final CommunityBaseCommonBinder.a aVar = this.$holder;
        RequestExtKt.d(V0, new l<ShareResultBean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ShareResultBean) obj);
                return Unit.f56620a;
            }

            public final void invoke(ShareResultBean shareResultBean) {
                Integer shared;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("转发次数 Success : ");
                sb2.append(shareResultBean != null ? shareResultBean.getShared() : null);
                d.b(sb2.toString());
                listBean.setShareNum((shareResultBean == null || (shared = shareResultBean.getShared()) == null) ? listBean.getShareNum() : shared.intValue());
                aVar.e().f19334e0.setText(he.b.a(listBean.getShareNum()));
            }
        }, AnonymousClass2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }
}
