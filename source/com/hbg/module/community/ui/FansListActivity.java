package com.hbg.module.community.ui;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.z;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.WatchFansBean;
import com.hbg.module.community.adapter.WatchFansAdapter;
import com.hbg.module.community.viewmodel.WatchFansViewModel;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.List;
import kotlin.f;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import lc.e;
import nc.c;

@Route(path = "/content/FansFollowList")
public final class FansListActivity extends BaseActivity<e> {

    /* renamed from: q  reason: collision with root package name */
    public static final a f17412q = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public int f17413i = 1;

    /* renamed from: j  reason: collision with root package name */
    public String f17414j = "";

    /* renamed from: k  reason: collision with root package name */
    public int f17415k;

    /* renamed from: l  reason: collision with root package name */
    public long f17416l = System.currentTimeMillis();

    /* renamed from: m  reason: collision with root package name */
    public String f17417m = "fans-list";

    /* renamed from: n  reason: collision with root package name */
    public WatchFansViewModel f17418n;

    /* renamed from: o  reason: collision with root package name */
    public WatchFansAdapter f17419o;

    /* renamed from: p  reason: collision with root package name */
    public int f17420p = 1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f17421b;

        public b(l lVar) {
            this.f17421b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f17421b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17421b.invoke(obj);
        }
    }

    public static final /* synthetic */ e Ah(FansListActivity fansListActivity) {
        return (e) fansListActivity.Yf();
    }

    @SensorsDataInstrumented
    public static final void Fh(FansListActivity fansListActivity, View view) {
        fansListActivity.Gh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Eh */
    public e Og() {
        return e.K(getLayoutInflater());
    }

    public final void Gh() {
        WatchFansViewModel watchFansViewModel = this.f17418n;
        if (watchFansViewModel != null) {
            watchFansViewModel.i0(this.f17417m, this.f17414j, this.f17416l);
        }
    }

    public void P8(j jVar) {
        super.P8(jVar);
        Gh();
    }

    public void bf(j jVar) {
        super.bf(jVar);
        this.f17420p = 1;
        this.f17416l = System.currentTimeMillis();
        ((e) Yf()).C.g(true);
        Gh();
    }

    public void initView() {
        MutableLiveData<VmState<List<WatchFansBean>>> h02;
        super.initView();
        Qg(NightHelper.e().g());
        c.a("app_community_grzyfsbg", MapsKt__MapsKt.j(kotlin.l.a("uid", this.f17414j)));
        ((e) Yf()).M(this);
        this.f17418n = (WatchFansViewModel) new ViewModelProvider(this).a(WatchFansViewModel.class);
        ((e) Yf()).C.j0(new SmartRefreshHeader(this));
        ((e) Yf()).C.h0(new SmartRefreshFooter(this));
        ((e) Yf()).C.e0(this);
        this.f17419o = new WatchFansAdapter(this, this.f17413i, this.f17415k);
        ((e) Yf()).D.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(this));
        ((e) Yf()).D.setAdapter(this.f17419o);
        ((e) Yf()).B.setOnRetryClickListener(new j(this));
        ((e) Yf()).B.g();
        WatchFansViewModel watchFansViewModel = this.f17418n;
        if (!(watchFansViewModel == null || (h02 = watchFansViewModel.h0()) == null)) {
            h02.observe(this, new b(new FansListActivity$initView$2(this)));
        }
        Gh();
    }

    public void oh() {
        String stringExtra;
        String stringExtra2;
        super.oh();
        Intent intent = getIntent();
        if (!(intent == null || (stringExtra2 = intent.getStringExtra("uidUnique")) == null)) {
            this.f17414j = stringExtra2;
        }
        Intent intent2 = getIntent();
        if (!(intent2 == null || (stringExtra = intent2.getStringExtra("isSelf")) == null)) {
            this.f17415k = Integer.parseInt(stringExtra);
        }
        ((e) Yf()).E.setText(getResources().getString(R$string.n_content_community_userinfo_fans));
    }
}
