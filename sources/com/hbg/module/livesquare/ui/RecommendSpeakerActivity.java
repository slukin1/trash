package com.hbg.module.livesquare.ui;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.z;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.livesquare.adapter.g;
import com.hbg.module.livesquare.viewmodel.RecommendSpeakerViewModel;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import kotlin.f;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import lc.w;

public final class RecommendSpeakerActivity extends BaseActivity<w> {

    /* renamed from: i  reason: collision with root package name */
    public RecommendSpeakerViewModel f26649i;

    /* renamed from: j  reason: collision with root package name */
    public int f26650j = 1;

    /* renamed from: k  reason: collision with root package name */
    public g f26651k;

    public static final class a implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f26652b;

        public a(l lVar) {
            this.f26652b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f26652b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f26652b.invoke(obj);
        }
    }

    public static final /* synthetic */ w Bh(RecommendSpeakerActivity recommendSpeakerActivity) {
        return (w) recommendSpeakerActivity.Yf();
    }

    public static final void Gh(RecommendSpeakerActivity recommendSpeakerActivity, AppBarLayout appBarLayout, int i11) {
        int height = ((w) recommendSpeakerActivity.Yf()).G.getHeight();
        int abs = Math.abs(i11);
        if (abs > height) {
            ((w) recommendSpeakerActivity.Yf()).I.setAlpha(1.0f);
            ((w) recommendSpeakerActivity.Yf()).J.setAlpha(1.0f);
            ((w) recommendSpeakerActivity.Yf()).K.setAlpha(1.0f);
            return;
        }
        float f11 = ((float) abs) / ((float) height);
        ((w) recommendSpeakerActivity.Yf()).I.setAlpha(f11);
        ((w) recommendSpeakerActivity.Yf()).J.setAlpha(f11);
        ((w) recommendSpeakerActivity.Yf()).K.setAlpha(f11);
    }

    @SensorsDataInstrumented
    public static final void Hh(RecommendSpeakerActivity recommendSpeakerActivity, View view) {
        ((w) recommendSpeakerActivity.Yf()).B.p();
        RecommendSpeakerViewModel recommendSpeakerViewModel = recommendSpeakerActivity.f26649i;
        if (recommendSpeakerViewModel != null) {
            recommendSpeakerViewModel.c(recommendSpeakerActivity.f26650j);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Eh */
    public w Og() {
        return w.K(getLayoutInflater());
    }

    public final void Fh() {
        ((w) Yf()).I.setAlpha(1.0f);
        ((w) Yf()).C.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new k(this));
    }

    public final void Ih() {
        MutableLiveData<VmState<RecommendSpeakerList>> h02;
        RecommendSpeakerViewModel recommendSpeakerViewModel = (RecommendSpeakerViewModel) new ViewModelProvider(this).a(RecommendSpeakerViewModel.class);
        this.f26649i = recommendSpeakerViewModel;
        if (recommendSpeakerViewModel != null && (h02 = recommendSpeakerViewModel.h0()) != null) {
            h02.observe(this, new a(new RecommendSpeakerActivity$initVm$1(this)));
        }
    }

    public void P8(j jVar) {
        super.P8(jVar);
        RecommendSpeakerViewModel recommendSpeakerViewModel = this.f26649i;
        if (recommendSpeakerViewModel != null) {
            recommendSpeakerViewModel.c(this.f26650j);
        }
    }

    public void bf(j jVar) {
        super.bf(jVar);
        ((w) Yf()).E.setNoMoreData(false);
        this.f26650j = 1;
        RecommendSpeakerViewModel recommendSpeakerViewModel = this.f26649i;
        if (recommendSpeakerViewModel != null) {
            recommendSpeakerViewModel.c(1);
        }
    }

    public void initView() {
        super.initView();
        ((w) Yf()).M(this);
        Qg(NightHelper.e().g());
        Fh();
        Ih();
        ((w) Yf()).E.j0(new SmartRefreshHeader(this));
        ((w) Yf()).E.h0(new SmartRefreshFooter(this));
        ((w) Yf()).E.e0(this);
        ((w) Yf()).F.setLayoutManager(b.t(this));
        this.f26651k = new g(this);
        ((w) Yf()).F.setAdapter(this.f26651k);
        ((w) Yf()).B.setOnRetryClickListener(new j(this));
        RecommendSpeakerViewModel recommendSpeakerViewModel = this.f26649i;
        if (recommendSpeakerViewModel != null) {
            recommendSpeakerViewModel.c(this.f26650j);
        }
        we.b.m("followStatus", (Class) null, 2, (Object) null).observe(this, new a(new RecommendSpeakerActivity$initView$2(this)));
    }
}
