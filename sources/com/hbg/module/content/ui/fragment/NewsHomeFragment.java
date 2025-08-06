package com.hbg.module.content.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.ui.fragment.NewsChildFragment;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.huobi.view.rollviewpager.hintview.AnimHintView;
import com.youth.banner.Banner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.l;
import ky.j;
import lc.e2;
import sl.f0;

public final class NewsHomeFragment extends BaseFragment<e2> {

    /* renamed from: w  reason: collision with root package name */
    public static final a f18797w = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public final String f18798p = "newsCoinTag";

    /* renamed from: q  reason: collision with root package name */
    public ArrayList<Fragment> f18799q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList<TabData> f18800r = new ArrayList<>();

    /* renamed from: s  reason: collision with root package name */
    public int f18801s = 1;

    /* renamed from: t  reason: collision with root package name */
    public int f18802t;

    /* renamed from: u  reason: collision with root package name */
    public int f18803u;

    /* renamed from: v  reason: collision with root package name */
    public int f18804v = -1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final NewsHomeFragment a(int i11) {
            NewsHomeFragment newsHomeFragment = new NewsHomeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i11);
            newsHomeFragment.setArguments(bundle);
            return newsHomeFragment;
        }
    }

    public static final class b implements ne.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewsHomeFragment f18805a;

        public b(NewsHomeFragment newsHomeFragment) {
            this.f18805a = newsHomeFragment;
        }

        public void a(int i11) {
            this.f18805a.f18802t = i11;
            NewsHomeFragment.Vh(this.f18805a).G.g(!(this.f18805a.f18799q.get(i11) instanceof H5Fragment));
            nc.c.a("app_news_category_click", MapsKt__MapsKt.j(l.a("categoryId", Integer.valueOf(((TabData) this.f18805a.f18800r.get(i11)).getTabId()))));
        }
    }

    public static final class c implements f0.b {
        public void e(List<? extends SymbolPrice> list) {
        }

        public void onSuccess(List<? extends SymbolPrice> list) {
        }
    }

    public static final /* synthetic */ e2 Vh(NewsHomeFragment newsHomeFragment) {
        return (e2) newsHomeFragment.uh();
    }

    public static final NewsHomeFragment ci(int i11) {
        return f18797w.a(i11);
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        this.f18801s = arguments != null ? arguments.getInt("type") : 1;
    }

    public void Eh() {
        super.Eh();
        if (this.f18801s == 1) {
            ji(false);
        }
    }

    public void Fh() {
        super.Fh();
        if (this.f18801s == 1) {
            nc.c.b("MT_TCP_SAT_pv", (HashMap) null, 2, (Object) null);
            ji(true);
            return;
        }
        nc.c.b("MT_TCP_LAT_pv", (HashMap) null, 2, (Object) null);
    }

    public void P8(j jVar) {
        if (this.f18799q.size() > 0) {
            if (this.f18799q.get(this.f18802t) instanceof NewsChildFragment) {
                ((NewsChildFragment) this.f18799q.get(this.f18802t)).P8(jVar);
            } else if (this.f18799q.get(this.f18802t) instanceof DeepNewsChildFragment) {
                ((DeepNewsChildFragment) this.f18799q.get(this.f18802t)).P8(jVar);
            }
        }
        ((e2) uh()).G.w();
    }

    public void bf(j jVar) {
        hi();
        if (this.f18799q.size() <= 0) {
            ii();
        } else if (this.f18799q.get(this.f18802t) instanceof NewsChildFragment) {
            ((NewsChildFragment) this.f18799q.get(this.f18802t)).bf(jVar);
        } else if (this.f18799q.get(this.f18802t) instanceof DeepNewsChildFragment) {
            ((DeepNewsChildFragment) this.f18799q.get(this.f18802t)).bf(jVar);
        } else {
            ((e2) uh()).G.finishRefresh();
        }
    }

    public final void bi(ArrayList<LiveBannerData> arrayList) {
        if (!com.hbg.module.libkt.base.ext.b.w(arrayList)) {
            AnimHintView animHintView = new AnimHintView(getContext());
            animHintView.setNormalResId(0);
            animHintView.setBgResId(R$drawable.hint_indicator_bg);
            animHintView.setFocusResId(R$drawable.hint_indicator_focus);
            Banner banner = (Banner) ((e2) uh()).C.getRoot().findViewById(R$id.banner);
            Context context = getContext();
            if (context != null) {
                qc.b.b(banner, context, this.f18801s, this, arrayList);
            }
        }
    }

    /* renamed from: di */
    public e2 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return e2.K(layoutInflater, viewGroup, false);
    }

    public final void ei(Fragment fragment) {
    }

    public final void fi(CoIndicator coIndicator) {
        ne.b.f(getActivity(), this.f18800r, coIndicator, ((e2) uh()).I, 0.0f, new b(this), 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 16336, (Object) null);
    }

    public final void gi() {
        we.b.m("pageJump", (Class) null, 2, (Object) null).observe(this, new n(new NewsHomeFragment$registerBus$1(this)));
    }

    public final void hi() {
        RequestExtKt.d(v7.b.a().getLiveBanner(this.f18801s, NightHelper.e().g() ? 1 : 0), new NewsHomeFragment$requestBanner$1(this), new NewsHomeFragment$requestBanner$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void ii() {
        he.a aVar = new he.a((Fragment) this);
        if (this.f18801s == 1) {
            ((e2) uh()).H.setVisibility(8);
            this.f18800r.clear();
            this.f18799q.clear();
            this.f18799q.add(NewsChildFragment.a.b(NewsChildFragment.H, -1, "7*24", (String) null, 0, 12, (Object) null));
            aVar.a(this.f18799q);
            sh();
            ((e2) uh()).I.setAdapter(aVar);
            ((e2) uh()).G.finishRefresh();
            return;
        }
        RequestExtKt.d(v7.b.a().getDeepCategoryList(), new NewsHomeFragment$sendRequest$1(this, aVar), new NewsHomeFragment$sendRequest$2(this, aVar), (MutableLiveData) null, 4, (Object) null);
    }

    public void initView() {
        ((e2) uh()).G.j0(new SmartRefreshHeader(getActivity()));
        ((e2) uh()).G.h0(new SmartRefreshFooter(getActivity()));
        ((e2) uh()).G.e0(this);
        Lh();
        hi();
        ii();
        gi();
    }

    public final void ji(boolean z11) {
        if (z11) {
            f0.g().e(this.f18798p, new c());
            f0.g().i();
            return;
        }
        f0.g().j(this.f18798p);
        f0.g().m();
    }
}
