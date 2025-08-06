package com.hbg.module.content.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$attr;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$string;
import com.hbg.module.content.adapter.NewsAdapter;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import lc.i2;
import u6.g;

public final class NewsChildFragment extends BaseFragment<i2> {
    public static final a H = new a((r) null);
    public boolean A;
    public HbgBaseApmProvider B;
    public boolean C;
    public ArrayList<Integer> D = new ArrayList<>();
    public boolean E;
    public final d F = new d(this);
    public boolean G;

    /* renamed from: p  reason: collision with root package name */
    public NewsAdapter f18781p;

    /* renamed from: q  reason: collision with root package name */
    public String f18782q = "";

    /* renamed from: r  reason: collision with root package name */
    public int f18783r = 20;

    /* renamed from: s  reason: collision with root package name */
    public int f18784s;

    /* renamed from: t  reason: collision with root package name */
    public Integer f18785t;

    /* renamed from: u  reason: collision with root package name */
    public String f18786u;

    /* renamed from: v  reason: collision with root package name */
    public int f18787v;

    /* renamed from: w  reason: collision with root package name */
    public String f18788w;

    /* renamed from: x  reason: collision with root package name */
    public com.hbg.module.content.custom.decoration.a f18789x;

    /* renamed from: y  reason: collision with root package name */
    public View f18790y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f18791z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ NewsChildFragment b(a aVar, int i11, String str, String str2, int i12, int i13, Object obj) {
            if ((i13 & 4) != 0) {
                str2 = null;
            }
            if ((i13 & 8) != 0) {
                i12 = -1;
            }
            return aVar.a(i11, str, str2, i12);
        }

        public final NewsChildFragment a(int i11, String str, String str2, int i12) {
            NewsChildFragment newsChildFragment = new NewsChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", i11);
            bundle.putString("name", str);
            if (!com.hbg.module.libkt.base.ext.b.x(str2)) {
                bundle.putString("coinSymbols", str2);
            }
            bundle.putInt("FAST_NEWS_FIRST", i12);
            newsChildFragment.setArguments(bundle);
            return newsChildFragment;
        }
    }

    public static final class b extends BaseSubscriber<List<? extends NoticeManageResp>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewsChildFragment f18792b;

        public b(NewsChildFragment newsChildFragment) {
            this.f18792b = newsChildFragment;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }

        public void onNext(List<? extends NoticeManageResp> list) {
            super.onNext(list);
            this.f18792b.li(list);
        }
    }

    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewsChildFragment f18793a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f18794b;

        public c(NewsChildFragment newsChildFragment, Ref$IntRef ref$IntRef) {
            this.f18793a = newsChildFragment;
            this.f18794b = ref$IntRef;
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            NewsAdapter ci2 = this.f18793a.f18781p;
            if (ci2 != null) {
                Ref$IntRef ref$IntRef = this.f18794b;
                NewsChildFragment newsChildFragment = this.f18793a;
                if (ci2.getItemCount() > 0 && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                    int findLastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    if (ref$IntRef.element == 0) {
                        ref$IntRef.element = findLastVisibleItemPosition;
                    }
                    if (((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() == ref$IntRef.element && !newsChildFragment.E) {
                        newsChildFragment.E = true;
                        newsChildFragment.Ki();
                    }
                    if (findLastVisibleItemPosition >= ci2.getItemCount() - (newsChildFragment.si() / 2) && !NewsChildFragment.Zh(newsChildFragment).E.h() && !newsChildFragment.oi()) {
                        i6.d.c("ray01", "lastP " + findLastVisibleItemPosition + " count " + ci2.getItemCount() + "  1 getPreLoadNewsList mIsLoadMoreNews " + newsChildFragment.oi());
                        newsChildFragment.Ji(true);
                        newsChildFragment.Ai();
                    }
                }
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public static final class d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewsChildFragment f18795a;

        public d(NewsChildFragment newsChildFragment) {
            this.f18795a = newsChildFragment;
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 101) {
                this.f18795a.ui();
            } else if (i11 == 102) {
                NewsChildFragment.Zh(this.f18795a).G.setVisibility(8);
                this.f18795a.Fi(60000);
            }
        }
    }

    public static final class e extends EasySubscriber<Object> {
        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.p(R$string.n_content_push_open_tip);
        }
    }

    public static final class f implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f18796b;

        public f(l lVar) {
            this.f18796b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f18796b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f18796b.invoke(obj);
        }
    }

    public static final void Di(NewsChildFragment newsChildFragment) {
        ((i2) newsChildFragment.uh()).B.setVisibility(8);
    }

    public static final /* synthetic */ i2 Zh(NewsChildFragment newsChildFragment) {
        return (i2) newsChildFragment.uh();
    }

    @SensorsDataInstrumented
    public static final void wi(NewsChildFragment newsChildFragment, View view) {
        newsChildFragment.Ai();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void xi(NewsChildFragment newsChildFragment, View view) {
        ((i2) newsChildFragment.uh()).G.setVisibility(8);
        ((i2) newsChildFragment.uh()).D.smoothScrollToPosition(0);
        ((i2) newsChildFragment.uh()).E.t();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void yi(NewsChildFragment newsChildFragment, View view) {
        newsChildFragment.Bi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        String str = null;
        this.f18785t = arguments != null ? Integer.valueOf(arguments.getInt("id")) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("coinSymbols");
        }
        this.f18786u = str;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            this.f18787v = arguments3.getInt("viewType");
        }
    }

    public final void Ai() {
        if (!com.hbg.module.libkt.base.ext.b.x(this.f18786u)) {
            ri();
        } else if (this.f18787v == 1) {
            Bundle arguments = getArguments();
            this.f18788w = arguments != null ? arguments.getString("symbols") : null;
            pi();
        } else {
            qi();
        }
    }

    public final void Bi() {
        boolean z11 = false;
        nc.c.a("app_news_news_guide_open_click", MapsKt__MapsKt.j(new Pair("state", "1")));
        ArrayList<Integer> arrayList = this.D;
        if (arrayList == null || arrayList.isEmpty()) {
            z11 = true;
        }
        if (!z11) {
            i6.d.c("showPushSwitchPop", "childPushSwitchIdList ： " + this.D);
            ((i2) uh()).B.setVisibility(8);
            v7.b.a().F0(this.D, 1).b().compose(RxJavaHelper.t((g) null)).subscribe(new e());
        }
    }

    public final void Ci() {
        Handler vh2 = vh();
        if (vh2 != null) {
            vh2.postDelayed(new l(this), 10000);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void Ei() {
        we.b.m("risePut", (Class) null, 2, (Object) null).observe(this, new f(new NewsChildFragment$registerBus$1(this)));
        we.c.a(this, new f(new NewsChildFragment$registerBus$2(this)));
        we.b.m("shareNum", (Class) null, 2, (Object) null).observe(this, new f(new NewsChildFragment$registerBus$3(this)));
        we.b.m("riseFallChange", (Class) null, 2, (Object) null).observe(this, new f(new NewsChildFragment$registerBus$4(this)));
        we.b.m("pageVisible", (Class) null, 2, (Object) null).observe(this, new f(new NewsChildFragment$registerBus$5(this)));
    }

    public void Fh() {
        super.Fh();
        if (isVisible()) {
            Integer num = this.f18785t;
            if (num == null || num.intValue() != -100) {
                HashMap hashMap = new HashMap();
                int i11 = this.f18787v;
                if (i11 == 1) {
                    hashMap.put("news_state", "app_favorites_news");
                } else if (i11 != 2) {
                    hashMap.put("news_state", "app_news_news");
                    Integer num2 = this.f18785t;
                    if (num2 != null) {
                        hashMap.put("categoryId", Integer.valueOf(num2.intValue()));
                    }
                } else {
                    hashMap.put("news_state", "app_kline_news");
                }
                nc.c.a("app_news_show", hashMap);
            }
        }
    }

    public final void Fi(long j11) {
        if (isVisible()) {
            Integer num = this.f18785t;
            if (num == null || num.intValue() != -100) {
                this.F.removeMessages(101);
                this.F.sendEmptyMessageDelayed(101, j11);
            }
        }
    }

    public final void Gi(d9.a<List<NewFlashInformation>> aVar) {
        RequestExtKt.d(aVar, new NewsChildFragment$sendReq$1(this), new NewsChildFragment$sendReq$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void Hi(int i11) {
        this.f18784s = i11;
    }

    public final void Ii(String str) {
        this.f18782q = str;
    }

    public final void Ji(boolean z11) {
        this.G = z11;
    }

    public final void Ki() {
        Bundle arguments = getArguments();
        Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("FAST_NEWS_FIRST")) : null;
        if (((i2) uh()).B.getVisibility() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            String uid = BaseModuleConfig.a().getUid();
            long g11 = SP.g("PUSH_SWITCH_POP_SHOW_TIME" + uid, -1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("pushSwitchStatus : ");
            sb2.append(this.C);
            sb2.append("     date：");
            sb2.append(zi(g11, currentTimeMillis));
            sb2.append("   scrollTheScreen : ");
            sb2.append(this.E);
            sb2.append("  flag : ");
            sb2.append(valueOf != null && valueOf.intValue() == -2);
            i6.d.c("showPushSwitchPop", sb2.toString());
            if (this.C && this.E && valueOf != null && valueOf.intValue() == -2) {
                if (g11 == -1 || zi(g11, currentTimeMillis)) {
                    ((i2) uh()).B.setVisibility(0);
                    nc.c.a("app_news_news_guide_show", MapsKt__MapsKt.j(new Pair("state", "1")));
                    SP.r("PUSH_SWITCH_POP_SHOW_TIME" + uid, currentTimeMillis);
                    Ci();
                }
            }
        }
    }

    public final void Li() {
        View findViewById;
        if (Dh()) {
            RecyclerView recyclerView = ((i2) uh()).D;
            if (recyclerView.getChildCount() > 0 && (findViewById = recyclerView.getChildAt(0).findViewById(R$id.tvShare)) != null) {
                com.hbg.module.content.utls.e.f18909b.a().e(findViewById, findViewById.getResources().getString(R$string.n_market_guide_share_content), "CACHE_KEY_NEWS_SHARE_GUIDE");
            }
        }
    }

    public void P8(j jVar) {
        i6.d.c("ray01", "onLoadMore mIsLoadMoreNews " + this.G);
        if (!this.G) {
            this.G = true;
            i6.d.c("ray01", "onLoadMore getNewsList " + this.G);
            Ai();
        }
    }

    public void bf(j jVar) {
        this.f18782q = "";
        this.f18784s = 0;
        ((i2) uh()).E.setNoMoreData(false);
        Ai();
        ((i2) uh()).D.scrollToPosition(0);
    }

    public final void initListener() {
        ((i2) uh()).C.setOnRetryClickListener(new j(this));
        ((i2) uh()).D.addOnScrollListener(new c(this, new Ref$IntRef()));
    }

    public void initView() {
        String string;
        NewsAdapter newsAdapter;
        Integer num;
        if (!this.f18791z && (num = this.f18785t) != null && num.intValue() == -1) {
            this.f18791z = true;
            HbgBaseApmProvider hbgBaseApmProvider = (HbgBaseApmProvider) b2.a.d().a("/provider/apm").navigation();
            this.B = hbgBaseApmProvider;
            if (hbgBaseApmProvider != null) {
                hbgBaseApmProvider.o("huobiapp_market_content_newsflash_end");
            }
        }
        if (com.hbg.module.libkt.base.ext.b.e(getActivity())) {
            this.f18781p = new NewsAdapter(getActivity(), this.f18787v);
            Bundle arguments = getArguments();
            if (!(arguments == null || (string = arguments.getString("name", "")) == null || (newsAdapter = this.f18781p) == null)) {
                newsAdapter.u(string);
            }
            NewsAdapter newsAdapter2 = this.f18781p;
            if (newsAdapter2 != null) {
                Integer num2 = this.f18785t;
                newsAdapter2.t((num2 != null && num2.intValue() == -100) ? -1 : this.f18785t);
            }
        }
        ((i2) uh()).E.j0(new SmartRefreshHeader(getActivity()));
        SmartRefreshFooter smartRefreshFooter = new SmartRefreshFooter(getActivity());
        smartRefreshFooter.setFooterDividerVisible(false);
        smartRefreshFooter.setFooterBackgroundColor(getResources().getColor(17170445));
        smartRefreshFooter.setVisibility(8);
        ((i2) uh()).E.h0(smartRefreshFooter);
        ((i2) uh()).E.e0(this);
        com.hbg.module.content.custom.decoration.a aVar = new com.hbg.module.content.custom.decoration.a(requireContext(), -16776961, com.hbg.module.libkt.base.ext.b.o(requireContext(), R$attr.base_color_primary_text), com.hbg.module.libkt.base.ext.b.o(requireContext(), R$attr.base_color_content_background), 0.0f);
        this.f18789x = aVar;
        aVar.c(TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        NewsAdapter newsAdapter3 = this.f18781p;
        if (newsAdapter3 != null) {
            newsAdapter3.s(this.f18789x);
        }
        ((i2) uh()).D.addItemDecoration(this.f18789x);
        ((i2) uh()).D.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(getActivity()));
        ((i2) uh()).D.setHasFixedSize(true);
        ((i2) uh()).D.setNestedScrollingEnabled(true);
        ((i2) uh()).D.setAdapter(this.f18781p);
        initListener();
        ((i2) uh()).C.g();
        ((i2) uh()).C.b(1).setBackgroundDrawable((Drawable) null);
        ((i2) uh()).G.setOnClickListener(new k(this));
        ((i2) uh()).F.setOnClickListener(new i(this));
        Lh();
        Ai();
        Ei();
    }

    public final void ki() {
        i6.d.c("showPushSwitchPop", "请求开关状态");
        Bundle arguments = getArguments();
        boolean z11 = false;
        if (arguments != null && arguments.getInt("FAST_NEWS_FIRST") == -2) {
            z11 = true;
        }
        if (z11 && BaseModuleConfig.a().a()) {
            v7.b.a().B().b().compose(RxJavaHelper.t((g) null)).subscribe(new b(this));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r7 == false) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void li(java.util.List<? extends com.hbg.lib.network.hbg.core.bean.NoticeManageResp> r7) {
        /*
            r6 = this;
            java.util.ArrayList<java.lang.Integer> r0 = r6.D
            r0.clear()
            java.util.Iterator r7 = r7.iterator()
        L_0x0009:
            boolean r0 = r7.hasNext()
            r1 = 0
            if (r0 == 0) goto L_0x0024
            java.lang.Object r0 = r7.next()
            r2 = r0
            com.hbg.lib.network.hbg.core.bean.NoticeManageResp r2 = (com.hbg.lib.network.hbg.core.bean.NoticeManageResp) r2
            java.lang.String r2 = r2.getLabelName()
            java.lang.String r3 = "Push-Info"
            boolean r2 = kotlin.jvm.internal.x.b(r2, r3)
            if (r2 == 0) goto L_0x0009
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            com.hbg.lib.network.hbg.core.bean.NoticeManageResp r0 = (com.hbg.lib.network.hbg.core.bean.NoticeManageResp) r0
            if (r0 == 0) goto L_0x0036
            int r7 = r0.getId()
            java.util.ArrayList<java.lang.Integer> r2 = r6.D
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r2.add(r7)
        L_0x0036:
            if (r0 == 0) goto L_0x003d
            java.lang.String r7 = r0.getSubState()
            goto L_0x003e
        L_0x003d:
            r7 = r1
        L_0x003e:
            java.lang.String r2 = "1"
            boolean r7 = kotlin.jvm.internal.x.b(r7, r2)
            r3 = 0
            r4 = 1
            if (r7 == 0) goto L_0x0075
            java.util.List r7 = r0.getSubList()
            boolean r5 = r7 instanceof java.util.Collection
            if (r5 == 0) goto L_0x0058
            boolean r5 = r7.isEmpty()
            if (r5 == 0) goto L_0x0058
        L_0x0056:
            r7 = r3
            goto L_0x0073
        L_0x0058:
            java.util.Iterator r7 = r7.iterator()
        L_0x005c:
            boolean r5 = r7.hasNext()
            if (r5 == 0) goto L_0x0056
            java.lang.Object r5 = r7.next()
            com.hbg.lib.network.hbg.core.bean.NoticeManageResp r5 = (com.hbg.lib.network.hbg.core.bean.NoticeManageResp) r5
            java.lang.String r5 = r5.getSubState()
            boolean r5 = kotlin.jvm.internal.x.b(r5, r2)
            if (r5 == 0) goto L_0x005c
            r7 = r4
        L_0x0073:
            if (r7 != 0) goto L_0x0076
        L_0x0075:
            r3 = r4
        L_0x0076:
            r6.C = r3
            if (r0 == 0) goto L_0x00a7
            java.util.List r7 = r0.getSubList()
            if (r7 == 0) goto L_0x00a7
            java.util.ArrayList r1 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt__IterablesKt.u(r7, r0)
            r1.<init>(r0)
            java.util.Iterator r7 = r7.iterator()
        L_0x008f:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x00a7
            java.lang.Object r0 = r7.next()
            com.hbg.lib.network.hbg.core.bean.NoticeManageResp r0 = (com.hbg.lib.network.hbg.core.bean.NoticeManageResp) r0
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.add(r0)
            goto L_0x008f
        L_0x00a7:
            java.util.ArrayList<java.lang.Integer> r7 = r6.D
            if (r1 == 0) goto L_0x00ac
            goto L_0x00b1
        L_0x00ac:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x00b1:
            r7.addAll(r1)
            r6.Ki()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.fragment.NewsChildFragment.li(java.util.List):void");
    }

    public final String mi(long j11) {
        return DateTimeUtils.m(j11 / ((long) 1000));
    }

    public final String ni() {
        return this.f18782q;
    }

    public final boolean oi() {
        return this.G;
    }

    public void onDestroy() {
        super.onDestroy();
        Integer num = this.f18785t;
        if (num == null || num.intValue() != -100) {
            this.F.removeCallbacksAndMessages((Object) null);
        }
    }

    public void onPause() {
        super.onPause();
        Integer num = this.f18785t;
        if (num == null || num.intValue() != -100) {
            this.F.removeCallbacksAndMessages((Object) null);
        }
    }

    public void onResume() {
        super.onResume();
        ((i2) uh()).G.setVisibility(8);
        Integer num = this.f18785t;
        if (num == null || num.intValue() != -100) {
            Fi(60000);
            ki();
        }
    }

    public final void pi() {
        RequestExtKt.d(v7.b.a().getNewsListBySelect(this.f18782q, this.f18783r, this.f18788w), new NewsChildFragment$getNewListBySelect$1(this), new NewsChildFragment$getNewListBySelect$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void qi() {
        Integer num = this.f18785t;
        if (num != null) {
            int intValue = num.intValue();
            IHbgApi a11 = v7.b.a();
            String str = this.f18782q;
            int i11 = this.f18783r;
            if (intValue == -100) {
                intValue = -1;
            }
            Gi(a11.getNewsList(str, i11, intValue));
        }
    }

    public final void ri() {
        Gi(v7.b.a().getNewsListByCoin(this.f18782q, this.f18783r, this.f18784s, this.f18786u));
    }

    public final int si() {
        return this.f18783r;
    }

    public final int ti() {
        return this.f18787v;
    }

    public final void ui() {
        NewsAdapter newsAdapter;
        ArrayList e11;
        NewFlashInformation newFlashInformation;
        NewsAdapter newsAdapter2 = this.f18781p;
        if (!com.hbg.module.libkt.base.ext.b.w(newsAdapter2 != null ? newsAdapter2.e() : null) && (newsAdapter = this.f18781p) != null && (e11 = newsAdapter.e()) != null && (newFlashInformation = (NewFlashInformation) e11.get(0)) != null) {
            long issueTime = newFlashInformation.getIssueTime();
            IHbgApi a11 = v7.b.a();
            String valueOf = String.valueOf(issueTime);
            Integer num = this.f18785t;
            RequestExtKt.d(a11.getUnreadByCategory(valueOf, num != null ? num.intValue() : -1), new NewsChildFragment$getUnreadCount$1$1(this), new NewsChildFragment$getUnreadCount$1$2(this), (MutableLiveData) null, 4, (Object) null);
        }
    }

    /* renamed from: vi */
    public i2 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return i2.K(layoutInflater, viewGroup, false);
    }

    public final boolean zi(long j11, long j12) {
        return j11 < j12 && !x.b(mi(j11), mi(j12));
    }
}
