package com.huobi.copytrading.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.m;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.huobi.copytrading.p038enum.History;
import com.huobi.copytrading.p038enum.Module;
import com.huobi.copytrading.p038enum.Tab;
import com.huobi.copytrading.p038enum.TabInfoBean;
import com.huobi.copytrading.vm.CopyTradingViewModel;
import com.huobi.copytrading.widget.HBNestedScrollView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import lj.c0;
import org.json.JSONObject;
import pro.huobi.R;
import rd.s;
import rx.Observable;
import rx.Subscriber;

public final class CopyTradingTradeFragment extends CopyBaseFragment {

    /* renamed from: k  reason: collision with root package name */
    public static final a f43647k = new a((r) null);

    /* renamed from: f  reason: collision with root package name */
    public final kotlin.i f43648f = FragmentViewModelLazyKt.c(this, Reflection.b(CopyTradingViewModel.class), new CopyTradingTradeFragment$special$$inlined$activityViewModels$default$1(this), new CopyTradingTradeFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new CopyTradingTradeFragment$special$$inlined$activityViewModels$default$3(this));

    /* renamed from: g  reason: collision with root package name */
    public c0 f43649g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f43650h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43651i;

    /* renamed from: j  reason: collision with root package name */
    public Subscriber<List<FutureContractInfo>> f43652j;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final CopyTradingTradeFragment a() {
            return new CopyTradingTradeFragment();
        }
    }

    public static final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public final List<View> f43653a;

        public static final class a extends RecyclerView.ViewHolder {
            public a(HBNestedScrollView hBNestedScrollView) {
                super(hBNestedScrollView);
            }
        }

        public b(List<? extends View> list) {
            this.f43653a = list;
        }

        public int getItemCount() {
            return this.f43653a.size();
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            ((ViewGroup) viewHolder.itemView).addView(this.f43653a.get(i11), new ViewGroup.LayoutParams(-1, -1));
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            HBNestedScrollView hBNestedScrollView = new HBNestedScrollView(viewGroup.getContext());
            hBNestedScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new a(hBNestedScrollView);
        }
    }

    public static final class c extends BaseSubscriber<List<? extends FutureContractInfo>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CopyTradingTradeFragment f43654b;

        public c(CopyTradingTradeFragment copyTradingTradeFragment) {
            this.f43654b = copyTradingTradeFragment;
        }

        public void onNext(List<? extends FutureContractInfo> list) {
            super.onNext(list);
            this.f43654b.Vh(list);
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CopyTradingTradeFragment f43655b;

        public d(CopyTradingTradeFragment copyTradingTradeFragment) {
            this.f43655b = copyTradingTradeFragment;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f43655b.w3();
        }
    }

    public static final class e extends DecelerateInterpolator {
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f43656b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f43657c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CopyTradingTradeFragment f43658d;

        public f(View view, long j11, CopyTradingTradeFragment copyTradingTradeFragment) {
            this.f43656b = view;
            this.f43657c = j11;
            this.f43658d = copyTradingTradeFragment;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f43656b) > this.f43657c || (this.f43656b instanceof Checkable)) {
                sVar.e(this.f43656b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f43656b;
                if (this.f43658d.f43651i) {
                    this.f43658d.Kh();
                } else {
                    c0 Bh = this.f43658d.f43649g;
                    c0 c0Var = null;
                    if (Bh == null) {
                        Bh = null;
                    }
                    Bh.L.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_down_button, 0);
                    c0 Bh2 = this.f43658d.f43649g;
                    if (Bh2 != null) {
                        c0Var = Bh2;
                    }
                    ViewPropertyAnimator duration = c0Var.E.animate().translationY(0.0f).setInterpolator(new i()).setDuration(220);
                    duration.setListener(new h(this.f43658d));
                    duration.start();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements TabLayout.OnTabSelectedListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TabInfoBean f43659b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CopyTradingTradeFragment f43660c;

        public g(TabInfoBean tabInfoBean, CopyTradingTradeFragment copyTradingTradeFragment) {
            this.f43659b = tabInfoBean;
            this.f43660c = copyTradingTradeFragment;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        @SensorsDataInstrumented
        public void onTabSelected(TabLayout.Tab tab) {
            Tab tab2;
            String onAppear;
            String module;
            List<Tab> tabs = this.f43659b.getTabs();
            c0 c0Var = null;
            if (tabs != null) {
                tab2 = tabs.get(tab != null ? tab.getPosition() : 0);
            } else {
                tab2 = null;
            }
            boolean z11 = true;
            if (tab2 == null || (module = tab2.getModule()) == null || !module.equals("historyOrder")) {
                z11 = false;
            }
            if (z11) {
                c0 Bh = this.f43660c.f43649g;
                if (Bh != null) {
                    c0Var = Bh;
                }
                c0Var.N.setVisibility(0);
            } else {
                c0 Bh2 = this.f43660c.f43649g;
                if (Bh2 != null) {
                    c0Var = Bh2;
                }
                c0Var.N.setVisibility(8);
            }
            if (!(tab2 == null || (onAppear = tab2.getOnAppear()) == null)) {
                this.f43660c.Jh().h0().I(onAppear + "()");
            }
            SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CopyTradingTradeFragment f43661b;

        public h(CopyTradingTradeFragment copyTradingTradeFragment) {
            this.f43661b = copyTradingTradeFragment;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f43661b.f43651i = true;
            c0 Bh = this.f43661b.f43649g;
            c0 c0Var = null;
            if (Bh == null) {
                Bh = null;
            }
            Bh.D.r();
            c0 Bh2 = this.f43661b.f43649g;
            if (Bh2 != null) {
                c0Var = Bh2;
            }
            c0Var.B.setVisibility(0);
        }
    }

    public static final class i extends DecelerateInterpolator {
    }

    public static final void Mh(CopyTradingTradeFragment copyTradingTradeFragment, Object obj) {
        if ((obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            TabInfoBean tabInfoBean = (TabInfoBean) m.c((String) obj, TabInfoBean.class);
            List<Tab> tabs = tabInfoBean.getTabs();
            String str = "";
            if (tabs != null) {
                int i11 = 0;
                for (T next : tabs) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        CollectionsKt__CollectionsKt.t();
                    }
                    Tab tab = (Tab) next;
                    CopyTradingViewModel Jh = copyTradingTradeFragment.Jh();
                    StringBuilder sb2 = new StringBuilder();
                    String template = tab.getTemplate();
                    if (template == null) {
                        template = str;
                    }
                    sb2.append(template);
                    sb2.append(".xml");
                    String sb3 = sb2.toString();
                    String module = tab.getModule();
                    if (module == null) {
                        module = str;
                    }
                    View k02 = Jh.k0(sb3, module);
                    if (k02 != null) {
                        arrayList.add(k02);
                    }
                    String title = tab.getTitle();
                    if (title == null) {
                        title = str;
                    }
                    arrayList2.add(title);
                    CopyTradingViewModel Jh2 = copyTradingTradeFragment.Jh();
                    String onTitleChange = tab.getOnTitleChange();
                    if (onTitleChange == null) {
                        onTitleChange = str;
                    }
                    Jh2.p0(onTitleChange, new x(copyTradingTradeFragment, i11));
                    i11 = i12;
                }
            }
            c0 c0Var = copyTradingTradeFragment.f43649g;
            c0 c0Var2 = null;
            if (c0Var == null) {
                c0Var = null;
            }
            c0Var.P.setUserInputEnabled(false);
            c0 c0Var3 = copyTradingTradeFragment.f43649g;
            if (c0Var3 == null) {
                c0Var3 = null;
            }
            c0Var3.P.setOffscreenPageLimit(arrayList.size());
            c0 c0Var4 = copyTradingTradeFragment.f43649g;
            if (c0Var4 == null) {
                c0Var4 = null;
            }
            c0Var4.P.setAdapter(new b(arrayList));
            c0 c0Var5 = copyTradingTradeFragment.f43649g;
            if (c0Var5 == null) {
                c0Var5 = null;
            }
            TabLayout tabLayout = c0Var5.I;
            c0 c0Var6 = copyTradingTradeFragment.f43649g;
            if (c0Var6 == null) {
                c0Var6 = null;
            }
            new TabLayoutMediator(tabLayout, c0Var6.P, new q(arrayList2)).attach();
            c0 c0Var7 = copyTradingTradeFragment.f43649g;
            if (c0Var7 == null) {
                c0Var7 = null;
            }
            c0Var7.I.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new g(tabInfoBean, copyTradingTradeFragment));
            History history = tabInfoBean.getHistory();
            if (!com.hbg.module.libkt.base.ext.b.x(history != null ? history.getTemplate() : null)) {
                History history2 = tabInfoBean.getHistory();
                if (!com.hbg.module.libkt.base.ext.b.x(history2 != null ? history2.getModule() : null)) {
                    CopyTradingViewModel Jh3 = copyTradingTradeFragment.Jh();
                    StringBuilder sb4 = new StringBuilder();
                    History history3 = tabInfoBean.getHistory();
                    String template2 = history3 != null ? history3.getTemplate() : null;
                    if (template2 == null) {
                        template2 = str;
                    }
                    sb4.append(template2);
                    sb4.append(".xml");
                    String sb5 = sb4.toString();
                    History history4 = tabInfoBean.getHistory();
                    String module2 = history4 != null ? history4.getModule() : null;
                    if (module2 != null) {
                        str = module2;
                    }
                    View k03 = Jh3.k0(sb5, str);
                    if (k03 != null) {
                        c0 c0Var8 = copyTradingTradeFragment.f43649g;
                        if (c0Var8 == null) {
                            c0Var8 = null;
                        }
                        c0Var8.F.setVisibility(0);
                        c0 c0Var9 = copyTradingTradeFragment.f43649g;
                        if (c0Var9 != null) {
                            c0Var2 = c0Var9;
                        }
                        c0Var2.F.addView(k03);
                    }
                }
            }
        }
    }

    public static final void Nh(CopyTradingTradeFragment copyTradingTradeFragment, int i11, Object obj) {
        if ((obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
            c0 c0Var = copyTradingTradeFragment.f43649g;
            c0 c0Var2 = null;
            if (c0Var == null) {
                c0Var = null;
            }
            if (c0Var.I.getTabCount() > i11) {
                c0 c0Var3 = copyTradingTradeFragment.f43649g;
                if (c0Var3 != null) {
                    c0Var2 = c0Var3;
                }
                TabLayout.Tab tabAt = c0Var2.I.getTabAt(i11);
                if (tabAt != null) {
                    tabAt.setText((CharSequence) obj.toString());
                }
            }
        }
    }

    public static final void Oh(ArrayList arrayList, TabLayout.Tab tab, int i11) {
        tab.setText((CharSequence) arrayList.get(i11));
    }

    public static final void Ph(CopyTradingTradeFragment copyTradingTradeFragment) {
        c0 c0Var = copyTradingTradeFragment.f43649g;
        c0 c0Var2 = null;
        if (c0Var == null) {
            c0Var = null;
        }
        RelativeLayout relativeLayout = c0Var.E;
        c0 c0Var3 = copyTradingTradeFragment.f43649g;
        if (c0Var3 == null) {
            c0Var3 = null;
        }
        relativeLayout.setTranslationY((float) c0Var3.D.getLayoutParams().height);
        c0 c0Var4 = copyTradingTradeFragment.f43649g;
        if (c0Var4 != null) {
            c0Var2 = c0Var4;
        }
        c0Var2.D.setVisibility(0);
    }

    public static final void Qh(CopyTradingTradeFragment copyTradingTradeFragment, Object obj) {
        if (x.b((Boolean) obj, Boolean.TRUE) && copyTradingTradeFragment.f43651i) {
            copyTradingTradeFragment.Kh();
        }
    }

    public static final void Rh(CopyTradingTradeFragment copyTradingTradeFragment, Object obj) {
        String obj2;
        if (obj != null && (obj2 = obj.toString()) != null) {
            try {
                copyTradingTradeFragment.f43650h = new JSONObject(obj2);
                copyTradingTradeFragment.Vh(FutureContractInfoController.n().e(TradeType.LINEAR_SWAP));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static final Observable Sh(l lVar, Object obj) {
        return (Observable) lVar.invoke(obj);
    }

    public static final Observable Th(l lVar, Object obj) {
        return (Observable) lVar.invoke(obj);
    }

    public final Subscriber<List<FutureContractInfo>> Ih() {
        return new c(this);
    }

    public final CopyTradingViewModel Jh() {
        return (CopyTradingViewModel) this.f43648f.getValue();
    }

    public final void Kh() {
        c0 c0Var = this.f43649g;
        c0 c0Var2 = null;
        if (c0Var == null) {
            c0Var = null;
        }
        c0Var.L.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_up, 0);
        c0 c0Var3 = this.f43649g;
        if (c0Var3 == null) {
            c0Var3 = null;
        }
        ViewPropertyAnimator animate = c0Var3.E.animate();
        c0 c0Var4 = this.f43649g;
        if (c0Var4 != null) {
            c0Var2 = c0Var4;
        }
        ViewPropertyAnimator duration = animate.translationY((float) c0Var2.D.getHeight()).setInterpolator(new e()).setDuration(220);
        duration.setListener(new d(this));
        duration.start();
    }

    public final void Lh() {
        CopyTradingViewModel Jh = Jh();
        Module module = Module.TRADE_TITLE;
        c0 c0Var = this.f43649g;
        c0 c0Var2 = null;
        if (c0Var == null) {
            c0Var = null;
        }
        Jh.m0(module, c0Var.H);
        CopyTradingViewModel Jh2 = Jh();
        Module module2 = Module.TRADE_PANEL;
        c0 c0Var3 = this.f43649g;
        if (c0Var3 == null) {
            c0Var3 = null;
        }
        Jh2.m0(module2, c0Var3.G);
        Jh().p0("drawer.isOpen", new v(this));
        Jh().p0("orderBook.contractInfo", new u(this));
        Jh().p0("tradePanel.tabInfo", new w(this));
        c0 c0Var4 = this.f43649g;
        if (c0Var4 == null) {
            c0Var4 = null;
        }
        c0Var4.K.post(new r(this));
        s sVar = s.f23381a;
        c0 c0Var5 = this.f43649g;
        if (c0Var5 != null) {
            c0Var2 = c0Var5;
        }
        RelativeLayout relativeLayout = c0Var2.K;
        relativeLayout.setOnClickListener(new f(relativeLayout, 800, this));
    }

    public final void Uh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void Vh(List<? extends FutureContractInfo> list) {
        if (list != null) {
            for (FutureContractInfo futureContractInfo : list) {
                String contractCode = futureContractInfo.getContractCode();
                JSONObject jSONObject = this.f43650h;
                if (x.b(contractCode, jSONObject != null ? jSONObject.getString("contractCode") : null)) {
                    Wh(a7.e.v(getActivity(), futureContractInfo.getSymbol(), futureContractInfo.getQuoteCurrency(), futureContractInfo.getContractCode(), futureContractInfo.getContractType()), TradeType.LINEAR_SWAP.toString(), futureContractInfo.getContractShortType(), FuturePrecisionUtil.y(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null), FuturePrecisionUtil.s(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), ""));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        r9 = r9.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Wh(java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, int r13) {
        /*
            r8 = this;
            lj.c0 r0 = r8.f43649g
            r1 = 0
            if (r0 != 0) goto L_0x0006
            r0 = r1
        L_0x0006:
            android.widget.TextView r0 = r0.M
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            r9 = 32
            r2.append(r9)
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            if (r9 == 0) goto L_0x0029
            android.content.res.Resources r9 = r9.getResources()
            if (r9 == 0) goto L_0x0029
            r3 = 2132018204(0x7f14041c, float:1.9674708E38)
            java.lang.String r9 = r9.getString(r3)
            goto L_0x002a
        L_0x0029:
            r9 = r1
        L_0x002a:
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r0.setText(r9)
            lj.c0 r9 = r8.f43649g
            if (r9 != 0) goto L_0x0039
            r9 = r1
        L_0x0039:
            com.huobi.tradenew.ui.kline.KlineView r2 = r9.D
            r3 = 0
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r2.i(r3, r4, r5, r6, r7)
            boolean r9 = r8.f43651i
            if (r9 == 0) goto L_0x0052
            lj.c0 r9 = r8.f43649g
            if (r9 != 0) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r1 = r9
        L_0x004d:
            com.huobi.tradenew.ui.kline.KlineView r9 = r1.D
            r9.r()
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.copytrading.ui.CopyTradingTradeFragment.Wh(java.lang.String, java.lang.String, java.lang.String, int, int):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c0 c0Var = (c0) androidx.databinding.c.e(layoutInflater, R.layout.fragment_copy_trading_trade, viewGroup, false);
        this.f43649g = c0Var;
        c0 c0Var2 = null;
        if (c0Var == null) {
            c0Var = null;
        }
        c0Var.K(this);
        Lh();
        c0 c0Var3 = this.f43649g;
        if (c0Var3 != null) {
            c0Var2 = c0Var3;
        }
        return c0Var2.getRoot();
    }

    public void onPause() {
        super.onPause();
        w3();
    }

    public void ph() {
        Subscriber<List<FutureContractInfo>> subscriber = this.f43652j;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f43652j = Ih();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new s(CopyTradingTradeFragment$onActivityResume$1.INSTANCE)).retryWhen(new t(CopyTradingTradeFragment$onActivityResume$2.INSTANCE)).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(this.f43652j);
    }

    public void qh() {
        Subscriber<List<FutureContractInfo>> subscriber = this.f43652j;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void w3() {
        c0 c0Var = this.f43649g;
        if (c0Var != null) {
            c0 c0Var2 = null;
            if (c0Var == null) {
                c0Var = null;
            }
            c0Var.L.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_up, 0);
            if (this.f43651i) {
                c0 c0Var3 = this.f43649g;
                if (c0Var3 == null) {
                    c0Var3 = null;
                }
                RelativeLayout relativeLayout = c0Var3.E;
                c0 c0Var4 = this.f43649g;
                if (c0Var4 == null) {
                    c0Var4 = null;
                }
                relativeLayout.setTranslationY((float) c0Var4.D.getHeight());
                c0 c0Var5 = this.f43649g;
                if (c0Var5 == null) {
                    c0Var5 = null;
                }
                ((KlineViewWrapper) c0Var5.D.findViewById(R.id.klineViewWrapper)).C();
            }
            this.f43651i = false;
            c0 c0Var6 = this.f43649g;
            if (c0Var6 != null) {
                c0Var2 = c0Var6;
            }
            c0Var2.B.setVisibility(8);
        }
    }
}
