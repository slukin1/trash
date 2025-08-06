package com.hbg.module.community.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.module.community.adapter.k;
import com.hbg.module.community.viewmodel.CommunityViewModel;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.hbg.module.libkt.custom.indicator.navigator.CommonNavigator;
import com.hbg.module.libkt.custom.indicator.navigator.titles.RedPointPagerTitleView;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import d10.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import lc.g1;
import rd.s;

public final class CommunityKLineFragment extends BaseFragment<g1> {
    public static final a F = new a((r) null);
    public b A;
    public boolean B;
    public int[] C;
    public List<Object> D = new ArrayList();
    public boolean E;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<Fragment> f17308p = new ArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    public final ArrayList<TabData> f17309q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    public he.a f17310r;

    /* renamed from: s  reason: collision with root package name */
    public CommunityViewModel f17311s;

    /* renamed from: t  reason: collision with root package name */
    public String f17312t = "";

    /* renamed from: u  reason: collision with root package name */
    public String f17313u = "";

    /* renamed from: v  reason: collision with root package name */
    public boolean f17314v;

    /* renamed from: w  reason: collision with root package name */
    public String f17315w = "";

    /* renamed from: x  reason: collision with root package name */
    public String f17316x = "";

    /* renamed from: y  reason: collision with root package name */
    public Boolean f17317y = Boolean.FALSE;

    /* renamed from: z  reason: collision with root package name */
    public String f17318z = "";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final CommunityKLineFragment a(String str, String str2, boolean z11, String str3, String str4) {
            CommunityKLineFragment communityKLineFragment = new CommunityKLineFragment();
            Bundle bundle = new Bundle();
            bundle.putString("symbolId", str);
            bundle.putString("tradeType", str2);
            bundle.putBoolean("isGrid", z11);
            bundle.putString("symbolName", str3);
            bundle.putString("plateId", str4);
            communityKLineFragment.setArguments(bundle);
            return communityKLineFragment;
        }
    }

    public interface b {
        void a();
    }

    public static final class c implements ne.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommunityKLineFragment f17319a;

        public c(CommunityKLineFragment communityKLineFragment) {
            this.f17319a = communityKLineFragment;
        }

        public void a(int i11) {
            ((CommunityKLineChildFragment) this.f17319a.f17308p.get(i11)).ii();
            HashMap hashMap = new HashMap();
            hashMap.put("TransPair_current_id", this.f17319a.f17312t);
            hashMap.put("markets_kline_class", k.a(this.f17319a.f17313u, this.f17319a.f17314v));
            if (((TabData) this.f17319a.f17309q.get(i11)).getType() == 1) {
                nc.c.a("Kcommunity_zxclick", hashMap);
            } else if (((TabData) this.f17319a.f17309q.get(i11)).getType() == 0) {
                nc.c.a("Kcommunity_zrclick", hashMap);
            }
            try {
                if (StringsKt__StringsJVMKt.w(((TabData) this.f17319a.f17309q.get(i11)).getName(), this.f17319a.getResources().getString(R$string.n_home_feed_tab_news), true)) {
                    b Th = this.f17319a.A;
                    if (Th != null) {
                        Th.a();
                    }
                    CommunityKLineFragment.di(this.f17319a, false, 1, (Object) null);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static final class d implements CoIndicator.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommunityKLineFragment f17320a;

        public d(CommunityKLineFragment communityKLineFragment) {
            this.f17320a = communityKLineFragment;
        }

        public void onSelected(int i11) {
            he.b.l(CommunityKLineFragment.Sh(this.f17320a).C, String.valueOf(this.f17320a.ei()[i11]));
        }
    }

    public static final class e extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommunityKLineFragment f17321a;

        public e(CommunityKLineFragment communityKLineFragment) {
            this.f17321a = communityKLineFragment;
        }

        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            try {
                if (StringsKt__StringsJVMKt.w(((TabData) this.f17321a.f17309q.get(i11)).getName(), this.f17321a.getResources().getString(R$string.n_home_feed_tab_news), true)) {
                    b Th = this.f17321a.A;
                    if (Th != null) {
                        Th.a();
                    }
                    CommunityKLineFragment.di(this.f17321a, false, 1, (Object) null);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static final class f implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17322b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17323c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f17324d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityKLineFragment f17325e;

        public f(View view, long j11, HashMap hashMap, CommunityKLineFragment communityKLineFragment) {
            this.f17322b = view;
            this.f17323c = j11;
            this.f17324d = hashMap;
            this.f17325e = communityKLineFragment;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17322b) > this.f17323c || (this.f17322b instanceof Checkable)) {
                sVar.e(this.f17322b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17322b;
                nc.c.a("Kcommunity_fbclick", this.f17324d);
                if (!(this.f17325e.getActivity() == null || this.f17325e.wh() == null)) {
                    HbgBaseProvider wh2 = this.f17325e.wh();
                    boolean z11 = false;
                    if (wh2 != null && !wh2.j(this.f17325e.getActivity())) {
                        z11 = true;
                    }
                    if (!z11) {
                        if (x.b(this.f17325e.f17317y, Boolean.TRUE)) {
                            gc.b.e(gc.b.f19131a, (String) null, (TopicDetailInfo.HeaderInfo) null, this.f17325e.f17312t, k.a(this.f17325e.f17313u, this.f17325e.f17314v), this.f17325e.f17315w, 3, (Object) null);
                            nc.c.a("app_community_fbdj", this.f17324d);
                        } else {
                            gc.b.f();
                        }
                    }
                }
            }
            return true;
        }
    }

    public static final class g implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f17326b;

        public g(l lVar) {
            this.f17326b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f17326b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17326b.invoke(obj);
        }
    }

    public static final /* synthetic */ g1 Sh(CommunityKLineFragment communityKLineFragment) {
        return (g1) communityKLineFragment.uh();
    }

    public static /* synthetic */ void di(CommunityKLineFragment communityKLineFragment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        communityKLineFragment.ci(z11);
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        String str = null;
        this.f17312t = String.valueOf(arguments != null ? arguments.getString("symbolId") : null);
        Bundle arguments2 = getArguments();
        this.f17313u = String.valueOf(arguments2 != null ? arguments2.getString("tradeType") : null);
        Bundle arguments3 = getArguments();
        this.f17314v = arguments3 != null ? arguments3.getBoolean("isGrid") : false;
        Bundle arguments4 = getArguments();
        this.f17315w = String.valueOf(arguments4 != null ? arguments4.getString("symbolName") : null);
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            str = arguments5.getString("plateId");
        }
        this.f17316x = String.valueOf(str);
        Log.d("K线评论", "symbolId = " + this.f17312t + " , symbolName = " + this.f17315w + " , plateId = " + this.f17316x);
    }

    public final void ci(boolean z11) {
        this.B = z11;
        try {
            RedPointPagerTitleView redPointPagerTitleView = (RedPointPagerTitleView) ((CommonNavigator) ((g1) uh()).E.getNavigator()).c(0);
            if (z11) {
                redPointPagerTitleView.b();
            } else {
                redPointPagerTitleView.a();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final int[] ei() {
        int[] iArr = this.C;
        if (iArr != null) {
            return iArr;
        }
        return null;
    }

    public final he.a fi() {
        he.a aVar = this.f17310r;
        if (aVar != null) {
            return aVar;
        }
        return null;
    }

    /* renamed from: gi */
    public g1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return g1.K(layoutInflater, viewGroup, false);
    }

    public final void hi(CoIndicator coIndicator) {
        ne.b.f(getActivity(), this.f17309q, coIndicator, ((g1) uh()).H, 0.0f, new c(this), 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 16336, (Object) null);
        ((g1) uh()).H.setOffscreenPageLimit(this.f17309q.size());
        ((g1) uh()).H.setCurrentItem(0, false);
        coIndicator.setOnPageSelectListener(new d(this));
        ci(this.B);
        ((g1) uh()).H.registerOnPageChangeCallback(new e(this));
    }

    public final void ii() {
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", this.f17312t);
        hashMap.put("markets_kline_class", k.a(this.f17313u, this.f17314v));
        hashMap.put("pagename", "comunityKline");
        nc.c.a("app_community_fb", hashMap);
        s sVar = s.f23381a;
        ImageView imageView = ((g1) uh()).D;
        imageView.setOnTouchListener(new f(imageView, 800, hashMap, this));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void initObservers() {
        MutableLiveData<CommunityUserPermissions> k02;
        CommunityViewModel communityViewModel = this.f17311s;
        if (!(communityViewModel == null || (k02 = communityViewModel.k0()) == null)) {
            k02.observe(this, new g(new CommunityKLineFragment$initObservers$1(this)));
        }
        we.c.f(this, new g(new CommunityKLineFragment$initObservers$2(this)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0045, code lost:
        r1 = r1.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
            r11 = this;
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            boolean r0 = com.hbg.module.libkt.base.ext.b.e(r0)
            if (r0 == 0) goto L_0x015b
            gc.e r0 = gc.e.f19132a
            java.lang.Class<com.hbg.module.community.viewmodel.CommunityViewModel> r1 = com.hbg.module.community.viewmodel.CommunityViewModel.class
            androidx.lifecycle.ViewModel r0 = r0.a(r11, r1)
            com.hbg.module.community.viewmodel.CommunityViewModel r0 = (com.hbg.module.community.viewmodel.CommunityViewModel) r0
            r11.f17311s = r0
            x1.a r0 = r11.uh()
            lc.g1 r0 = (lc.g1) r0
            com.business.common.airdrop.view.AirdropView r0 = r0.B
            androidx.fragment.app.FragmentActivity r1 = r11.requireActivity()
            r0.q(r1)
            x1.a r0 = r11.uh()
            lc.g1 r0 = (lc.g1) r0
            com.business.common.airdrop.view.AirdropView r0 = r0.B
            java.lang.String r1 = r11.f17312t
            r0.t(r1)
            he.a r0 = new he.a
            r0.<init>((androidx.fragment.app.Fragment) r11)
            r11.ki(r0)
            java.util.ArrayList<com.hbg.module.libkt.custom.indicator.TabData> r0 = r11.f17309q
            com.hbg.module.libkt.custom.indicator.TabData r7 = new com.hbg.module.libkt.custom.indicator.TabData
            android.content.Context r1 = r11.getContext()
            r8 = 0
            if (r1 == 0) goto L_0x0053
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0053
            int r2 = com.hbg.module.content.R$string.n_home_feed_tab_news
            java.lang.String r1 = r1.getString(r2)
            r2 = r1
            goto L_0x0054
        L_0x0053:
            r2 = r8
        L_0x0054:
            r3 = 1
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r0.add(r7)
            java.util.ArrayList<com.hbg.module.libkt.custom.indicator.TabData> r0 = r11.f17309q
            com.hbg.module.libkt.custom.indicator.TabData r7 = new com.hbg.module.libkt.custom.indicator.TabData
            android.content.Context r1 = r11.getContext()
            if (r1 == 0) goto L_0x0075
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0075
            int r2 = com.hbg.module.content.R$string.n_home_feed_tab_hot
            java.lang.String r8 = r1.getString(r2)
        L_0x0075:
            r2 = r8
            r3 = 0
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r0.add(r7)
            java.util.ArrayList<com.hbg.module.libkt.custom.indicator.TabData> r0 = r11.f17309q
            int r0 = r0.size()
            int[] r1 = new int[r0]
            r2 = 0
            r3 = r2
        L_0x008b:
            if (r3 >= r0) goto L_0x0092
            r1[r3] = r2
            int r3 = r3 + 1
            goto L_0x008b
        L_0x0092:
            r11.ji(r1)
            java.util.ArrayList<com.hbg.module.libkt.custom.indicator.TabData> r0 = r11.f17309q
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00c4
            x1.a r0 = r11.uh()
            lc.g1 r0 = (lc.g1) r0
            com.hbg.module.libkt.custom.indicator.CoIndicator r0 = r0.E
            r11.hi(r0)
            x1.a r0 = r11.uh()
            lc.g1 r0 = (lc.g1) r0
            androidx.viewpager2.widget.ViewPager2 r0 = r0.H
            java.util.ArrayList<com.hbg.module.libkt.custom.indicator.TabData> r1 = r11.f17309q
            int r1 = r1.size()
            r0.setOffscreenPageLimit(r1)
            x1.a r0 = r11.uh()
            lc.g1 r0 = (lc.g1) r0
            androidx.viewpager2.widget.ViewPager2 r0 = r0.H
            r0.setCurrentItem(r2, r2)
        L_0x00c4:
            java.util.ArrayList<com.hbg.module.libkt.custom.indicator.TabData> r0 = r11.f17309q
            java.util.Iterator r0 = r0.iterator()
        L_0x00ca:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00f0
            java.lang.Object r1 = r0.next()
            com.hbg.module.libkt.custom.indicator.TabData r1 = (com.hbg.module.libkt.custom.indicator.TabData) r1
            java.util.ArrayList<androidx.fragment.app.Fragment> r3 = r11.f17308p
            com.hbg.module.community.ui.CommunityKLineChildFragment$a r4 = com.hbg.module.community.ui.CommunityKLineChildFragment.D
            int r5 = r1.getType()
            java.lang.String r6 = r11.f17312t
            java.lang.String r7 = r11.f17315w
            java.lang.String r8 = r11.f17313u
            boolean r9 = r11.f17314v
            java.lang.String r10 = r11.f17316x
            com.hbg.module.community.ui.CommunityKLineChildFragment r1 = r4.a(r5, r6, r7, r8, r9, r10)
            r3.add(r1)
            goto L_0x00ca
        L_0x00f0:
            he.a r0 = r11.fi()
            java.util.ArrayList<androidx.fragment.app.Fragment> r1 = r11.f17308p
            r0.a(r1)
            x1.a r0 = r11.uh()
            lc.g1 r0 = (lc.g1) r0
            androidx.viewpager2.widget.ViewPager2 r0 = r0.H
            he.a r1 = r11.fi()
            r0.setAdapter(r1)
            r11.initObservers()
            r11.ii()
            com.hbg.module.libkt.provider.HbgBaseProvider r0 = r11.wh()
            r1 = 1
            if (r0 == 0) goto L_0x011d
            boolean r0 = r0.n()
            if (r0 != r1) goto L_0x011d
            r0 = r1
            goto L_0x011e
        L_0x011d:
            r0 = r2
        L_0x011e:
            if (r0 == 0) goto L_0x0127
            com.hbg.module.community.viewmodel.CommunityViewModel r0 = r11.f17311s
            if (r0 == 0) goto L_0x0127
            r0.s0()
        L_0x0127:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r3 = r11.f17312t
            java.lang.String r4 = "topicId"
            r0.put(r4, r3)
            java.lang.String r3 = r11.f17312t
            java.lang.String r4 = "TransPair_current_id"
            r0.put(r4, r3)
            java.lang.String r3 = r11.f17313u
            boolean r4 = r11.f17314v
            java.lang.String r3 = com.hbg.module.community.adapter.k.a(r3, r4)
            java.lang.String r4 = "markets_kline_class"
            r0.put(r4, r3)
            java.lang.String r3 = "Kcommunity_show"
            nc.c.a(r3, r0)
            com.hbg.module.libkt.provider.HbgBaseProvider r0 = r11.wh()
            if (r0 == 0) goto L_0x0159
            boolean r0 = r0.n()
            if (r0 != r1) goto L_0x0159
            r2 = r1
        L_0x0159:
            r11.E = r2
        L_0x015b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.ui.CommunityKLineFragment.initView():void");
    }

    public final void ji(int[] iArr) {
        this.C = iArr;
    }

    public final void ki(he.a aVar) {
        this.f17310r = aVar;
    }

    public void onResume() {
        super.onResume();
        HbgBaseProvider wh2 = wh();
        boolean z11 = true;
        if (!(wh2 != null && wh2.n() == this.E)) {
            CommunityViewModel communityViewModel = this.f17311s;
            if (communityViewModel != null) {
                communityViewModel.s0();
            }
            HbgBaseProvider wh3 = wh();
            if (wh3 == null || !wh3.n()) {
                z11 = false;
            }
            this.E = z11;
        }
    }
}
