package com.huobi.copytrading.ui;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.n0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.m;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.content.custom.widget.TagLayoutWidget;
import com.hbg.module.libkt.base.ext.f;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.copytrading.p038enum.ActionBar;
import com.huobi.copytrading.p038enum.Module;
import com.huobi.copytrading.p038enum.Tab;
import com.huobi.copytrading.p038enum.TabInfoBean;
import com.huobi.copytrading.ui.CopyTradingTradeFragment;
import com.huobi.copytrading.vm.CopyTradingViewModel;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.trade.engine.TradeDataParser;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.l;
import lj.i;
import pro.huobi.R;
import rd.s;

@Route(path = "/Contract/CopyTrading_TraderInfo")
public final class CopyTradingTraderInfoActivity extends BaseActivity<i> {

    /* renamed from: t  reason: collision with root package name */
    public static final a f43662t = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public final kotlin.i f43663i = new n0(Reflection.b(CopyTradingViewModel.class), new CopyTradingTraderInfoActivity$special$$inlined$viewModels$default$2(this), new CopyTradingTraderInfoActivity$special$$inlined$viewModels$default$1(this), new CopyTradingTraderInfoActivity$special$$inlined$viewModels$default$3((d10.a) null, this));

    /* renamed from: j  reason: collision with root package name */
    public String f43664j;

    /* renamed from: k  reason: collision with root package name */
    public int f43665k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f43666l = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f43667m = -1;

    /* renamed from: n  reason: collision with root package name */
    public int f43668n = -1;

    /* renamed from: o  reason: collision with root package name */
    public String f43669o;

    /* renamed from: p  reason: collision with root package name */
    public String f43670p;

    /* renamed from: q  reason: collision with root package name */
    public Widget f43671q;

    /* renamed from: r  reason: collision with root package name */
    public ArrayList<Widget> f43672r = new ArrayList<>();

    /* renamed from: s  reason: collision with root package name */
    public final ArrayList<TraceMap.a> f43673s = new ArrayList<>();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b extends yj.i<CopyTradingTraderInfoActivity> {

        public static final class a extends yj.i<CopyTradingTraderInfoActivity> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f43674b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity, int i11) {
                super(copyTradingTraderInfoActivity);
                this.f43674b = i11;
            }

            /* renamed from: b */
            public void a(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity, Object obj) {
                TabLayout.Tab tabAt;
                if (copyTradingTraderInfoActivity != null && (obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj) && CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).K.getTabCount() > this.f43674b && (tabAt = CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).K.getTabAt(this.f43674b)) != null) {
                    tabAt.setText((CharSequence) ((String) obj).toString());
                }
            }
        }

        /* renamed from: com.huobi.copytrading.ui.CopyTradingTraderInfoActivity$b$b  reason: collision with other inner class name */
        public static final class C0565b implements TabLayout.OnTabSelectedListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TabInfoBean f43675b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ CopyTradingTraderInfoActivity f43676c;

            public C0565b(TabInfoBean tabInfoBean, CopyTradingTraderInfoActivity copyTradingTraderInfoActivity) {
                this.f43675b = tabInfoBean;
                this.f43676c = copyTradingTraderInfoActivity;
            }

            public void onTabReselected(TabLayout.Tab tab) {
            }

            @SensorsDataInstrumented
            public void onTabSelected(TabLayout.Tab tab) {
                Tab tab2;
                String onAppear;
                List<Tab> tabs = this.f43675b.getTabs();
                if (tabs != null) {
                    tab2 = tabs.get(tab != null ? tab.getPosition() : 0);
                } else {
                    tab2 = null;
                }
                if (!(tab2 == null || (onAppear = tab2.getOnAppear()) == null)) {
                    rj.b h02 = this.f43676c.Jh().h0();
                    h02.I(onAppear + "()");
                }
                SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }
        }

        public b(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity) {
            super(copyTradingTraderInfoActivity);
        }

        public static final void d(ArrayList arrayList, TabLayout.Tab tab, int i11) {
            tab.setText((CharSequence) arrayList.get(i11));
        }

        /* renamed from: c */
        public void a(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity, Object obj) {
            if (copyTradingTraderInfoActivity != null && !copyTradingTraderInfoActivity.isFinishing() && (obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
                String str = (String) obj;
                if (!StringsKt__StringsJVMKt.x(copyTradingTraderInfoActivity.f43669o, str, false, 2, (Object) null)) {
                    copyTradingTraderInfoActivity.f43669o = str;
                    System.out.println("CopyTrading---->>> " + copyTradingTraderInfoActivity);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    TabInfoBean tabInfoBean = (TabInfoBean) m.c(str, TabInfoBean.class);
                    ActionBar actionBar = tabInfoBean.getActionBar();
                    if (actionBar != null) {
                        CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).M.setText(actionBar.getTitle());
                        com.hbg.module.libkt.base.ext.b.J(CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).C, actionBar.getIcon());
                    }
                    copyTradingTraderInfoActivity.Nh();
                    List<Tab> tabs = tabInfoBean.getTabs();
                    if (tabs != null) {
                        int i11 = 0;
                        for (T next : tabs) {
                            int i12 = i11 + 1;
                            if (i11 < 0) {
                                CollectionsKt__CollectionsKt.t();
                            }
                            Tab tab = (Tab) next;
                            CopyTradingViewModel Dh = copyTradingTraderInfoActivity.Jh();
                            StringBuilder sb2 = new StringBuilder();
                            String template = tab.getTemplate();
                            String str2 = "";
                            if (template == null) {
                                template = str2;
                            }
                            sb2.append(template);
                            sb2.append(".xml");
                            String sb3 = sb2.toString();
                            String module = tab.getModule();
                            if (module == null) {
                                module = str2;
                            }
                            Widget l02 = Dh.l0(copyTradingTraderInfoActivity, sb3, module);
                            if (l02 != null) {
                                copyTradingTraderInfoActivity.f43672r.add(l02);
                                View P = l02.P(copyTradingTraderInfoActivity);
                                if (P != null) {
                                    arrayList.add(P);
                                }
                            }
                            String title = tab.getTitle();
                            if (title == null) {
                                title = str2;
                            }
                            arrayList2.add(title);
                            ArrayList Bh = copyTradingTraderInfoActivity.f43673s;
                            CopyTradingViewModel Dh2 = copyTradingTraderInfoActivity.Jh();
                            String onTitleChange = tab.getOnTitleChange();
                            if (onTitleChange != null) {
                                str2 = onTitleChange;
                            }
                            Bh.add(Dh2.p0(str2, new a(copyTradingTraderInfoActivity, i11)));
                            i11 = i12;
                        }
                    }
                    CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).O.setUserInputEnabled(false);
                    CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).O.setOffscreenPageLimit(arrayList.size());
                    CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).O.setAdapter(new CopyTradingTradeFragment.b(arrayList));
                    new TabLayoutMediator(CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).K, CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).O, new a0(arrayList2)).attach();
                    CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).K.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C0565b(tabInfoBean, copyTradingTraderInfoActivity));
                }
            }
        }
    }

    public static final class c extends yj.i<CopyTradingTraderInfoActivity> {

        public static final class a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f43677b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43678c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ CopyTradingTraderInfoActivity f43679d;

            public a(View view, long j11, CopyTradingTraderInfoActivity copyTradingTraderInfoActivity) {
                this.f43677b = view;
                this.f43678c = j11;
                this.f43679d = copyTradingTraderInfoActivity;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                s sVar = s.f23381a;
                if (currentTimeMillis - sVar.b(this.f43677b) > this.f43678c || (this.f43677b instanceof Checkable)) {
                    sVar.e(this.f43677b, currentTimeMillis);
                    TextView textView = (TextView) this.f43677b;
                    this.f43679d.Jh().h0().I("traderInfo.toCopy('true')");
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public static final class b implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f43680b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f43681c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ CopyTradingTraderInfoActivity f43682d;

            public b(View view, long j11, CopyTradingTraderInfoActivity copyTradingTraderInfoActivity) {
                this.f43680b = view;
                this.f43681c = j11;
                this.f43682d = copyTradingTraderInfoActivity;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                s sVar = s.f23381a;
                if (currentTimeMillis - sVar.b(this.f43680b) > this.f43681c || (this.f43680b instanceof Checkable)) {
                    sVar.e(this.f43680b, currentTimeMillis);
                    TextView textView = (TextView) this.f43680b;
                    this.f43682d.Jh().h0().I("traderInfo.toCopy('false')");
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public c(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity) {
            super(copyTradingTraderInfoActivity);
        }

        /* renamed from: b */
        public void a(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity, Object obj) {
            if (copyTradingTraderInfoActivity != null && !copyTradingTraderInfoActivity.isFinishing() && (obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
                String str = (String) obj;
                if (!StringsKt__StringsJVMKt.x(copyTradingTraderInfoActivity.f43670p, str, false, 2, (Object) null)) {
                    copyTradingTraderInfoActivity.f43670p = str;
                    switch (str.hashCode()) {
                        case 48:
                            if (str.equals("0")) {
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setEnabled(true);
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setTextColor(copyTradingTraderInfoActivity.getResources().getColor(R.color.white));
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setText(copyTradingTraderInfoActivity.getResources().getString(R.string.n_copy_trading_edit));
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setBackgroundResource(R.drawable.btn_blue_radius_4_bg);
                                s sVar = s.f23381a;
                                TextView textView = CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L;
                                textView.setOnClickListener(new a(textView, 800, copyTradingTraderInfoActivity));
                                return;
                            }
                            return;
                        case 49:
                            if (str.equals("1")) {
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setEnabled(false);
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setTextColor(copyTradingTraderInfoActivity.getResources().getColor(R.color.kColorThreeLevelText));
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setText(copyTradingTraderInfoActivity.getResources().getString(R.string.copy_trading_full));
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setBackgroundResource(R.drawable.btn_gray_radius_4_bg);
                                return;
                            }
                            return;
                        case 50:
                            if (str.equals("2")) {
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setEnabled(false);
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setTextColor(copyTradingTraderInfoActivity.getResources().getColor(R.color.kColorThreeLevelText));
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setText(copyTradingTraderInfoActivity.getResources().getString(R.string.n_asset_contract_to_copy_trading));
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setBackgroundResource(R.drawable.btn_gray_radius_4_bg);
                                return;
                            }
                            return;
                        case 51:
                            if (str.equals("3")) {
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setEnabled(true);
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setTextColor(copyTradingTraderInfoActivity.getResources().getColor(R.color.white));
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setText(copyTradingTraderInfoActivity.getResources().getString(R.string.n_asset_contract_to_copy_trading));
                                CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L.setBackgroundResource(R.drawable.btn_blue_radius_4_bg);
                                s sVar2 = s.f23381a;
                                TextView textView2 = CopyTradingTraderInfoActivity.Ch(copyTradingTraderInfoActivity).L;
                                textView2.setOnClickListener(new b(textView2, 800, copyTradingTraderInfoActivity));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    public static final /* synthetic */ i Ch(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity) {
        return (i) copyTradingTraderInfoActivity.Yf();
    }

    public static final void Lh(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity) {
        if (((i) copyTradingTraderInfoActivity.Yf()).H.getHeight() > 0) {
            copyTradingTraderInfoActivity.f43665k = ((i) copyTradingTraderInfoActivity.Yf()).H.getHeight();
        }
    }

    public static final void Mh(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity, AppBarLayout appBarLayout, int i11) {
        int i12 = 0;
        ((i) copyTradingTraderInfoActivity.Yf()).H.getChildAt(0).setBackgroundColor(copyTradingTraderInfoActivity.Ih(i11));
        ((i) copyTradingTraderInfoActivity.Yf()).N.setBackgroundColor(copyTradingTraderInfoActivity.Ih(i11));
        ((i) copyTradingTraderInfoActivity.Yf()).I.setBackgroundColor(copyTradingTraderInfoActivity.Ih(i11));
        ((i) copyTradingTraderInfoActivity.Yf()).J.setBackgroundColor(copyTradingTraderInfoActivity.Ih(i11));
        LinearLayout linearLayout = ((i) copyTradingTraderInfoActivity.Yf()).G;
        if (copyTradingTraderInfoActivity.f43665k - Math.abs(i11) < 20) {
            ((i) copyTradingTraderInfoActivity.Yf()).D.setImageResource(R.drawable.edge_engine_back);
            ((i) copyTradingTraderInfoActivity.Yf()).E.setImageResource(R.drawable.edge_engine_share);
            copyTradingTraderInfoActivity.Qg(NightHelper.e().g());
        } else {
            ((i) copyTradingTraderInfoActivity.Yf()).D.setImageResource(R.drawable.edge_engine_back_white);
            ((i) copyTradingTraderInfoActivity.Yf()).E.setImageResource(R.drawable.edge_engine_share_white);
            copyTradingTraderInfoActivity.Qg(true);
            i12 = 8;
        }
        linearLayout.setVisibility(i12);
    }

    public final int Ih(int i11) {
        return Color.rgb(((int) (((((float) this.f43666l) * 1.0f) * ((float) Math.abs(i11))) / ((float) this.f43665k))) + 22, ((int) (((((float) this.f43667m) * 1.0f) * ((float) Math.abs(i11))) / ((float) this.f43665k))) + 22, ((int) (((((float) this.f43668n) * 1.0f) * ((float) Math.abs(i11))) / ((float) this.f43665k))) + 22);
    }

    public final CopyTradingViewModel Jh() {
        return (CopyTradingViewModel) this.f43663i.getValue();
    }

    /* renamed from: Kh */
    public i Og() {
        return i.K(getLayoutInflater());
    }

    public final void Nh() {
        Iterator<Widget> it2 = this.f43672r.iterator();
        while (it2.hasNext()) {
            it2.next().O();
        }
        this.f43672r.clear();
    }

    public final void Oh() {
        rj.b h02 = Jh().h0();
        h02.I(Module.TRADER_INFO.getModuleName() + ".shareAction()");
    }

    public final void initData() {
        CopyTradingViewModel Jh = Jh();
        Module module = Module.TRADER_INFO;
        Jh.r0(module.getModuleName());
        int color = getResources().getColor(R.color.baseColorContentBackground);
        this.f43666l = Color.red(color) - 22;
        this.f43667m = Color.green(color) - 22;
        this.f43668n = Color.blue(color) - 22;
        this.f43671q = Jh().n0(module, ((i) Yf()).H);
        rj.b h02 = Jh().h0();
        h02.I(module.getModuleName() + ".onCreate('" + f.f(MapsKt__MapsKt.j(l.a("userSign", this.f43664j))) + "')");
        this.f43673s.add(Jh().p0("traderInfo.tabInfo", new b(this)));
        this.f43673s.add(Jh().p0("traderInfo.copyStatus", new c(this)));
    }

    public void initView() {
        super.initView();
        ((i) Yf()).M(this);
        Qg(true);
        getLifecycle().a(Jh());
        rj.b b11 = ek.b.f47515a.b(this, "copytrading");
        com.huobi.copytrading.engine.a.f43594a.a(b11);
        Jh().q0(b11);
        Jh().t0("copytrading");
        b11.A("TraderListTags", TagLayoutWidget.class);
        b11.z("trade_parser", TradeDataParser.class);
        Jh().z0();
        initData();
        ((i) Yf()).H.getViewTreeObserver().addOnGlobalLayoutListener(new y(this));
        ((i) Yf()).B.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new z(this));
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra("userSign");
        if (stringExtra != null) {
            this.f43664j = stringExtra;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Widget widget = this.f43671q;
        if (widget != null) {
            widget.O();
        }
        this.f43671q = null;
        Nh();
        for (TraceMap.a aVar : this.f43673s) {
            if (aVar != null) {
                aVar.destroy();
            }
        }
        this.f43673s.clear();
    }
}
