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
import lc.g;
import nc.c;

@Route(path = "/content/UserFollowList")
public final class FollowListActivity extends BaseActivity<g> {

    /* renamed from: q  reason: collision with root package name */
    public static final a f17422q = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public int f17423i;

    /* renamed from: j  reason: collision with root package name */
    public String f17424j = "";

    /* renamed from: k  reason: collision with root package name */
    public int f17425k;

    /* renamed from: l  reason: collision with root package name */
    public long f17426l = System.currentTimeMillis();

    /* renamed from: m  reason: collision with root package name */
    public String f17427m = "focus-list";

    /* renamed from: n  reason: collision with root package name */
    public WatchFansViewModel f17428n;

    /* renamed from: o  reason: collision with root package name */
    public WatchFansAdapter f17429o;

    /* renamed from: p  reason: collision with root package name */
    public int f17430p = 1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f17431b;

        public b(l lVar) {
            this.f17431b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f17431b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17431b.invoke(obj);
        }
    }

    public static final /* synthetic */ g Ah(FollowListActivity followListActivity) {
        return (g) followListActivity.Yf();
    }

    @SensorsDataInstrumented
    public static final void Fh(FollowListActivity followListActivity, View view) {
        followListActivity.Gh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Eh */
    public g Og() {
        return g.K(getLayoutInflater());
    }

    public final void Gh() {
        WatchFansViewModel watchFansViewModel = this.f17428n;
        if (watchFansViewModel != null) {
            watchFansViewModel.i0(this.f17427m, this.f17424j, this.f17426l);
        }
    }

    public void P8(j jVar) {
        super.P8(jVar);
        Gh();
    }

    public void bf(j jVar) {
        super.bf(jVar);
        this.f17430p = 1;
        this.f17426l = System.currentTimeMillis();
        Gh();
    }

    public void initView() {
        MutableLiveData<VmState<List<WatchFansBean>>> h02;
        super.initView();
        Qg(NightHelper.e().g());
        c.a("app_community_grzygzbg", MapsKt__MapsKt.j(kotlin.l.a("uid", this.f17424j)));
        ((g) Yf()).M(this);
        this.f17428n = (WatchFansViewModel) new ViewModelProvider(this).a(WatchFansViewModel.class);
        ((g) Yf()).C.j0(new SmartRefreshHeader(this));
        ((g) Yf()).C.h0(new SmartRefreshFooter(this));
        ((g) Yf()).C.e0(this);
        this.f17429o = new WatchFansAdapter(this, this.f17423i, this.f17425k);
        ((g) Yf()).D.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(this));
        ((g) Yf()).D.setAdapter(this.f17429o);
        ((g) Yf()).B.setOnRetryClickListener(new k(this));
        ((g) Yf()).B.g();
        WatchFansViewModel watchFansViewModel = this.f17428n;
        if (!(watchFansViewModel == null || (h02 = watchFansViewModel.h0()) == null)) {
            h02.observe(this, new b(new FollowListActivity$initView$2(this)));
        }
        Gh();
    }

    public void oh() {
        String stringExtra;
        String stringExtra2;
        super.oh();
        Intent intent = getIntent();
        if (!(intent == null || (stringExtra2 = intent.getStringExtra("uidUnique")) == null)) {
            this.f17424j = stringExtra2;
        }
        Intent intent2 = getIntent();
        if (!(intent2 == null || (stringExtra = intent2.getStringExtra("isSelf")) == null)) {
            this.f17425k = Integer.parseInt(stringExtra);
        }
        ((g) Yf()).E.setText(getResources().getString(R$string.n_content_community_userinfo_focus));
    }
}
