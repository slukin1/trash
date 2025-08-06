package com.huobi.index.viewhandler;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.content.utls.m;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import gs.g;
import v7.b;

public final class NewsCommunityHandler$handleView$14$1 implements m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f74305a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewsCommunityHandler f74306b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f74307c;

    public NewsCommunityHandler$handleView$14$1(CommunityFeedInfo.ListBean listBean, NewsCommunityHandler newsCommunityHandler, Context context) {
        this.f74305a = listBean;
        this.f74306b = newsCommunityHandler;
        this.f74307c = context;
    }

    public void a() {
        m.a.c(this);
        g.i("app_community_jb", this.f74306b.l(this.f74305a));
        DialogUtils.S((FragmentActivity) this.f74307c);
    }

    public void b() {
        m.a.e(this);
        this.f74306b.E(this.f74307c, this.f74305a.getUidUnique());
    }

    public void c(int i11) {
        m.a.b(this, i11);
        this.f74306b.D(this.f74307c, i11, this.f74305a.getUidUnique());
    }

    public void d() {
        m.a.d(this);
    }

    public void e() {
        m.a.a(this);
        RequestExtKt.d(b.a().y0(String.valueOf(this.f74305a.getId())), new NewsCommunityHandler$handleView$14$1$onDelClick$1(this.f74305a), NewsCommunityHandler$handleView$14$1$onDelClick$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }
}
