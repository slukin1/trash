package p039do;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.main.trade.enums.TradeTabsType;
import com.huobi.trade.helper.EtpRiskHintUtil;
import d7.a1;
import d7.k;
import d7.q0;
import d7.y;
import i6.a;
import i6.i;
import i6.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import ml.d;
import pro.huobi.R;
import rx.Observable;
import rx.schedulers.Schedulers;
import sl.f0;
import sn.t;
import u6.g;

/* renamed from: do.s  reason: invalid package */
public class s extends a<co.a> implements d.a, a.C0739a {

    /* renamed from: w  reason: collision with root package name */
    public static final Object f83880w = new Object();

    /* renamed from: j  reason: collision with root package name */
    public Set<String> f83881j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f83882k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f83883l;

    /* renamed from: m  reason: collision with root package name */
    public int f83884m;

    /* renamed from: n  reason: collision with root package name */
    public int f83885n;

    /* renamed from: o  reason: collision with root package name */
    public Map<String, Integer> f83886o;

    /* renamed from: p  reason: collision with root package name */
    public List<SymbolPrice> f83887p;

    /* renamed from: q  reason: collision with root package name */
    public List<s9.a> f83888q;

    /* renamed from: r  reason: collision with root package name */
    public List<String> f83889r;

    /* renamed from: s  reason: collision with root package name */
    public String f83890s;

    /* renamed from: t  reason: collision with root package name */
    public i6.a f83891t;

    /* renamed from: u  reason: collision with root package name */
    public List<String> f83892u;

    /* renamed from: v  reason: collision with root package name */
    public f0.b f83893v;

    /* renamed from: do.s$a */
    public class a extends BaseSubscriber<List<String>> {
        public a() {
        }

        public void onAfter() {
            super.onAfter();
            s.this.V(new ArrayList(s.this.f83887p));
        }

        public void onNext(List<String> list) {
            List<String> r11;
            super.onNext(list);
            if (s.this.f83882k && (r11 = t.r()) != null) {
                s.this.H(r11);
            }
        }
    }

    /* renamed from: do.s$b */
    public class b implements f0.b {
        public b() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            s.this.f83887p.clear();
            s.this.f83887p.addAll(list);
            s.this.V(new ArrayList(s.this.f83887p));
        }
    }

    /* renamed from: do.s$c */
    public class c extends BaseSubscriber<List<SymbolBean>> {
        public c() {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            s.this.D();
            s.this.J();
            s sVar = s.this;
            sVar.X(sVar.f83884m);
            ((co.a) s.this.h()).y7(s.this.f83884m);
        }
    }

    public s(Context context, co.a aVar, g gVar) {
        this(context, TradeType.GRID, aVar, gVar);
    }

    public static /* synthetic */ int M(Map map, String str, String str2) {
        Integer num;
        int i11 = 0;
        try {
            num = map.get(str2) != null ? Integer.valueOf(m.k0(((CurrencyBean) map.get(str2)).getWeight())) : 0;
            try {
                if (map.get(str) != null) {
                    i11 = Integer.valueOf(m.k0(((CurrencyBean) map.get(str)).getWeight()));
                }
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num.compareTo(i11);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = 0;
            e.printStackTrace();
            return num.compareTo(i11);
        }
        return num.compareTo(i11);
    }

    public static /* synthetic */ Boolean N(String str, s9.a aVar) {
        if (aVar instanceof d) {
            d dVar = (d) aVar;
            String j11 = dVar.j();
            String o11 = dVar.o();
            String str2 = a1.v().p(o11).toUpperCase() + "/" + a1.v().F(o11).toUpperCase();
            boolean z11 = true;
            boolean z12 = !TextUtils.isEmpty(j11) && j11.contains(str);
            if (!str.contains("/") || TextUtils.isEmpty(str2) || !str2.contains(str)) {
                z11 = false;
            }
            if (z12 || z11) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(List list) {
        ((co.a) h()).xa(TradeType.GRID, TradeTabsType.getTabsType(this.f83832e, this.f83890s), this.f83889r, list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int Q(d dVar, d dVar2) {
        Integer num;
        Integer num2 = 0;
        try {
            num = this.f83886o.get(dVar2.o());
            try {
                num2 = this.f83886o.get(dVar.o());
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num2.compareTo(num);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = num2;
            e.printStackTrace();
            return num2.compareTo(num);
        }
        return num2.compareTo(num);
    }

    public static /* synthetic */ int R(Map map, d dVar, d dVar2) {
        Integer num;
        int i11 = 0;
        try {
            num = Integer.valueOf(a1.v().y(dVar2.o(), map));
            try {
                i11 = Integer.valueOf(a1.v().y(dVar.o(), map));
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num.compareTo(i11);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = 0;
            e.printStackTrace();
            return num.compareTo(i11);
        }
        return num.compareTo(i11);
    }

    public static /* synthetic */ List S(List list, List list2, GridSymbolsConfig gridSymbolsConfig) {
        return list;
    }

    public final void D() {
        int i11 = this.f83884m;
        TradeType tradeType = TradeType.GRID;
        this.f83892u = y.f();
        Map<String, CurrencyBean> u11 = k.C().u();
        if (u11 != null) {
            Collections.sort(this.f83892u, new o(u11));
        }
        K(i11, tradeType, this.f83892u);
        L(this.f83892u);
    }

    public void E(int i11) {
        this.f83884m = i11;
        K(i11, TradeType.GRID, this.f83892u);
        J();
        X(this.f83884m);
        ((co.a) h()).y7(this.f83884m);
    }

    public void F() {
        this.f83890s = null;
    }

    public final void G(List<s9.a> list, String str) {
        if (TextUtils.isEmpty(str)) {
            ((co.a) h()).xa(TradeType.GRID, TradeTabsType.getTabsType(this.f83832e, this.f83890s), this.f83889r, list);
            ((co.a) h()).sb(this.f83884m);
            return;
        }
        Observable.from(list).filter(new q(str)).compose(RxJavaHelper.t(j())).toList().subscribe(EasySubscriber.create(new p(this)));
    }

    public final void H(List<String> list) {
        List<String> l11 = y.l(TradeType.PRO);
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (l11.contains(next)) {
                arrayList.add(next);
            }
        }
        this.f83881j = new LinkedHashSet(arrayList);
    }

    public final Set<String> I() {
        List<SymbolBean> Z;
        String nf2 = ((co.a) h()).nf();
        String n11 = a1.v().n(nf2);
        String D = a1.v().D(nf2);
        boolean p02 = a1.v().p0(nf2);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(n11) && (Z = a1.v().Z(this.f83831d)) != null && !Z.isEmpty()) {
            for (SymbolBean next : Z) {
                if (next.isCanTrade()) {
                    if (!p02 && (n11.equalsIgnoreCase(next.getBaseCurrency()) || n11.equalsIgnoreCase(EtpRiskHintUtil.c(next.getBaseCurrency())))) {
                        arrayList.add(next.getSymbol());
                    } else if (p02 && next.isEtpTag() && EtpRiskHintUtil.c(n11).equalsIgnoreCase(EtpRiskHintUtil.c(next.getBaseCurrency()))) {
                        arrayList.add(next.getSymbol());
                    } else if (p02 && !next.isEtpTag() && EtpRiskHintUtil.c(n11).equalsIgnoreCase(next.getBaseCurrency()) && D.equalsIgnoreCase(next.getQuoteCurrency())) {
                        arrayList.add(next.getSymbol());
                    }
                }
            }
        }
        i6.d.b("ExchangeTradeDataProvider-->initSymbolChangeList-->" + arrayList);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            linkedHashSet.add(arrayList.get(i11));
        }
        return linkedHashSet;
    }

    public void J() {
        if (this.f83882k) {
            t.s(false, this.f83829b).compose(RxJavaHelper.t(j())).subscribe(new a());
        } else {
            V(new ArrayList(this.f83887p));
        }
    }

    public final void K(int i11, TradeType tradeType, List<String> list) {
        List<String> list2;
        if (i11 == 0) {
            this.f83832e = TradeTabsType.COLLECTION;
            List<String> r11 = t.r();
            if (r11 != null) {
                H(r11);
            }
            this.f83882k = true;
            return;
        }
        boolean z11 = this.f83883l;
        if (!z11 || i11 != 1) {
            this.f83832e = TradeTabsType.OTHER;
            int i12 = i11 - 1;
            if (z11) {
                i12--;
            }
            if (i12 <= list.size() - 1) {
                list2 = y.o(list.get(i12), tradeType);
            } else {
                if (list.size() > 0) {
                    list2 = y.o(list.get(0), this.f83831d);
                } else {
                    list2 = new ArrayList<>();
                }
                c0(1);
            }
            this.f83881j = new LinkedHashSet(list2);
            this.f83882k = false;
            return;
        }
        this.f83832e = TradeTabsType.COMPARE;
        this.f83881j = I();
        this.f83882k = false;
    }

    public final void L(List<String> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f83829b.getString(R.string.market_markets_collection));
        if (this.f83883l) {
            String i11 = StringUtils.i(k.C().z(a1.v().n(((co.a) h()).nf())));
            arrayList.add(String.format(Locale.US, g(R.string.n_close_path_eos_compare), new Object[]{i11}));
        }
        Map<String, CurrencyBean> h11 = q0.h();
        for (String next : list) {
            if (SymbolBean.FIAT.equalsIgnoreCase(next)) {
                arrayList.add(StringUtils.i(next));
            } else if (SymbolBean.ALTS.equalsIgnoreCase(next)) {
                arrayList.add(StringUtils.i(next));
            } else if (SymbolBean.CRYPTO.equalsIgnoreCase(next)) {
                arrayList.add(StringUtils.i(next));
            } else {
                arrayList.add(k.C().y(k.C().t(next, h11)));
            }
        }
        this.f83889r.clear();
        this.f83889r.addAll(arrayList);
    }

    public final void T(List<SymbolPrice> list) {
        TradeType tradeType;
        SymbolBean J;
        TradeType tradeType2;
        SymbolBean J2;
        Set<String> set;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Map<String, SymbolPrice> T = LegalCurrencyConfigUtil.T();
        if (this.f83882k && (set = this.f83881j) != null) {
            W(set);
        }
        Set<String> set2 = this.f83881j;
        if (set2 != null && set2.size() > 0) {
            for (SymbolPrice next : list) {
                T.put(next.getSymbol(), next);
                if (this.f83881j.contains(next.getSymbol()) && (J2 = a1.v().J(next.getSymbol(), tradeType2)) != null) {
                    d dVar = new d(1);
                    Y(J2, dVar);
                    dVar.F(J2.getDirection());
                    dVar.E(this.f83882k);
                    dVar.R(J2.getTradeOpenAt());
                    String baseCurrency = J2.getBaseCurrency();
                    String quoteCurrency = J2.getQuoteCurrency();
                    hashSet.add(next.getSymbol());
                    if (this.f83882k) {
                        if (!TextUtils.isEmpty(baseCurrency) && !TextUtils.isEmpty(quoteCurrency)) {
                            dVar.O(J2.getState());
                            dVar.T((tradeType2 = TradeType.PRO));
                        }
                    } else if (!J2.isHadSt()) {
                        dVar.O(J2.getState());
                        dVar.T(this.f83831d);
                    }
                    String baseCurrencyDisplayName = J2.getBaseCurrencyDisplayName();
                    if (next.getSymbol().equals(((co.a) h()).nf())) {
                        dVar.S(true);
                    } else {
                        dVar.S(false);
                    }
                    dVar.L(a1.v().S(next.getSymbol()));
                    dVar.J(baseCurrencyDisplayName);
                    dVar.G(J2.isHadaxTag());
                    dVar.N(J2.isStTag());
                    dVar.Q(next);
                    dVar.D(this);
                    dVar.K(((co.a) h()).G2());
                    arrayList.add(dVar);
                }
            }
            int size = this.f83881j.size();
            String[] strArr = (String[]) this.f83881j.toArray(new String[0]);
            for (int i11 = 0; i11 < size; i11++) {
                if (!hashSet.contains(strArr[i11]) && !strArr[i11].contains("bt1") && !strArr[i11].contains("bt2") && (J = a1.v().J(strArr[i11], tradeType)) != null) {
                    d dVar2 = new d(1);
                    Y(J, dVar2);
                    dVar2.F(J.getDirection());
                    dVar2.E(this.f83882k);
                    dVar2.R(J.getTradeOpenAt());
                    SymbolPrice symbolPrice = new SymbolPrice();
                    symbolPrice.setSymbol(strArr[i11]);
                    if (symbolPrice.getSymbol().equals(((co.a) h()).nf())) {
                        dVar2.S(true);
                    } else {
                        dVar2.S(false);
                    }
                    if (this.f83882k) {
                        dVar2.O(J.getState());
                        dVar2.T((tradeType = TradeType.PRO));
                    } else if (!J.isHadSt()) {
                        dVar2.O(J.getState());
                        dVar2.T(this.f83831d);
                    }
                    String baseCurrencyDisplayName2 = J.getBaseCurrencyDisplayName();
                    dVar2.L(a1.v().S(symbolPrice.getSymbol()));
                    dVar2.G(J.isHadaxTag());
                    dVar2.N(J.isStTag());
                    dVar2.J(baseCurrencyDisplayName2);
                    dVar2.Q(symbolPrice);
                    dVar2.D(this);
                    dVar2.K(((co.a) h()).G2());
                    arrayList.add(dVar2);
                }
            }
            if (this.f83882k) {
                Collections.sort(arrayList, new m(this));
            } else {
                Collections.sort(arrayList, new n(a1.v().V(this.f83831d)));
            }
        }
        synchronized (f83880w) {
            this.f83888q.clear();
            this.f83888q.addAll(arrayList);
        }
    }

    public final void U() {
        a0(true);
        Observable.zip(a1.v().Y(true, false).subscribeOn(Schedulers.io()), k.C().n(true, p.b(), "2").subscribeOn(Schedulers.io()), y.h(true).subscribeOn(Schedulers.io()), r.f53856b).compose(RxJavaHelper.t(j())).subscribe(new c());
    }

    public final void V(List<SymbolPrice> list) {
        Message obtain = Message.obtain();
        obtain.obj = list;
        this.f83891t.sendMessage(obtain);
    }

    public final void W(Set<String> set) {
        this.f83886o.clear();
        int i11 = 0;
        for (String put : set) {
            this.f83886o.put(put, Integer.valueOf(i11));
            i11++;
        }
    }

    public void X(int i11) {
        this.f83885n = i11;
    }

    public final void Y(SymbolBean symbolBean, d dVar) {
        TradeType tradeType = this.f83831d;
        if (tradeType == TradeType.PRO) {
            if (symbolBean.isEtpTag()) {
                dVar.I(com.huobi.trade.helper.f0.d(this.f83829b, symbolBean.getDirection(), symbolBean.getEtpLeverageRatio()));
            }
        } else if (tradeType == TradeType.MARGIN) {
            dVar.I(symbolBean.getLeverageRatio() + "X");
        } else if (tradeType == TradeType.SUPERMARGIN) {
            dVar.I(symbolBean.getSuperMarginLeverageRatio() + "X");
        } else if (tradeType == TradeType.C2C) {
            dVar.I(symbolBean.getFundingLeverageRatio() + "X");
        }
    }

    public void Z(String str) {
        this.f83890s = str;
        P();
    }

    public final void a0(boolean z11) {
        if (z11) {
            f0.g().e("pro_drawer_overview_listener_tag", this.f83893v);
            f0.g().i();
            return;
        }
        f0.g().m();
        f0.g().j("pro_drawer_overview_listener_tag");
    }

    public final void b0() {
        a0(false);
    }

    public void c(d dVar) {
        if (h() != null) {
            ((co.a) h()).a(this.f83831d, dVar);
        }
    }

    public final void c0(int i11) {
        this.f83884m = i11;
        ConfigPreferences.k("user_config", "config_market_grid_index", i11);
    }

    public void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj != null) {
            T((List) obj);
            i.b().f(new l(this));
        }
    }

    public void k() {
        F();
        P();
        U();
    }

    public void l() {
    }

    public void o() {
        b0();
    }

    /* renamed from: p */
    public void P() {
        this.f83834g.clear();
        this.f83834g.addAll(this.f83888q);
        G(this.f83834g, this.f83890s);
    }

    public s(Context context, TradeType tradeType, co.a aVar, g gVar) {
        super(context, tradeType, aVar, gVar);
        this.f83883l = false;
        this.f83884m = -1;
        this.f83886o = new HashMap();
        this.f83887p = new ArrayList();
        this.f83888q = new ArrayList();
        this.f83889r = new ArrayList();
        this.f83893v = new b();
        this.f83891t = new i6.a("GridTradeDataProvider", this);
        this.f83884m = ConfigPreferences.f("user_config", "config_market_grid_index");
        List<String> r11 = t.r();
        if ((r11 == null || r11.isEmpty()) && this.f83884m == 0) {
            c0(1);
        }
    }
}
