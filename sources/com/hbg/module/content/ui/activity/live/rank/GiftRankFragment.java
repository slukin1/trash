package com.hbg.module.content.ui.activity.live.rank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.z;
import com.hbg.lib.network.hbg.core.bean.LiveGiftRank;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import kotlin.f;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import lc.k1;
import rd.s;

public final class GiftRankFragment extends BaseFragment<k1> {

    /* renamed from: s  reason: collision with root package name */
    public static final a f18688s = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public String f18689p = "";

    /* renamed from: q  reason: collision with root package name */
    public int f18690q;

    /* renamed from: r  reason: collision with root package name */
    public GiftRankViewModel f18691r;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ GiftRankFragment b(a aVar, String str, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i11 = 1;
            }
            return aVar.a(str, i11);
        }

        public final GiftRankFragment a(String str, int i11) {
            GiftRankFragment giftRankFragment = new GiftRankFragment();
            Bundle bundle = new Bundle();
            bundle.putString("liveId", str);
            bundle.putInt("type", i11);
            giftRankFragment.setArguments(bundle);
            return giftRankFragment;
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18692b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18693c;

        public b(View view, long j11) {
            this.f18692b = view;
            this.f18693c = j11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18692b) > this.f18693c || (this.f18692b instanceof Checkable)) {
                sVar.e(this.f18692b, currentTimeMillis);
                TextView textView = (TextView) this.f18692b;
                we.c.x();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f18694b;

        public c(l lVar) {
            this.f18694b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f18694b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f18694b.invoke(obj);
        }
    }

    public static final /* synthetic */ k1 Th(GiftRankFragment giftRankFragment) {
        return (k1) giftRankFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void Xh(GiftRankFragment giftRankFragment, View view) {
        GiftRankViewModel giftRankViewModel = giftRankFragment.f18691r;
        if (giftRankViewModel != null) {
            giftRankViewModel.i0(giftRankFragment.f18689p, giftRankFragment.f18690q);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Yh(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        String string;
        super.Ah();
        Bundle arguments = getArguments();
        if (!(arguments == null || (string = arguments.getString("liveId")) == null)) {
            this.f18689p = string;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            this.f18690q = arguments2.getInt("type");
        }
    }

    /* renamed from: Vh */
    public k1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return k1.K(layoutInflater, viewGroup, false);
    }

    public final void Wh() {
        MutableLiveData<VmState<LiveGiftRank>> h02;
        GiftRankViewModel giftRankViewModel = (GiftRankViewModel) new ViewModelProvider(this).a(GiftRankViewModel.class);
        this.f18691r = giftRankViewModel;
        if (giftRankViewModel != null && (h02 = giftRankViewModel.h0()) != null) {
            h02.observe(this, new c(new GiftRankFragment$initVM$1(this)));
        }
    }

    public void initView() {
        Wh();
        ((k1) uh()).D.p();
        ((k1) uh()).D.setOnRetryClickListener(new b(this));
        GiftRankViewModel giftRankViewModel = this.f18691r;
        if (giftRankViewModel != null) {
            giftRankViewModel.i0(this.f18689p, this.f18690q);
        }
        ((k1) uh()).B.setOnClickListener(c.f18698b);
        s sVar = s.f23381a;
        TextView textView = ((k1) uh()).F;
        textView.setOnClickListener(new b(textView, 800));
    }
}
