package hf;

import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.index.core.util.ContractIndexPrecisionUtil;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.kline.util.MarketSymbolTitleUtil;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$string;
import com.hbg.module.market.widget.bean.MarketWidgetInfo;
import com.hbg.module.market.widget.view.MarketWidgetView;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import g9.a;
import i6.a;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sl.f0;
import us.j;

public class b implements a.C0739a {

    /* renamed from: r  reason: collision with root package name */
    public static String f29025r = "SP_MARKET_WIDGET_DATA";

    /* renamed from: s  reason: collision with root package name */
    public static String f29026s = "SP_MARKET_WIDGET_LIMIT_COUNT";

    /* renamed from: t  reason: collision with root package name */
    public static String f29027t = "SP_MARKET_WIDGET_INIT_LIST";

    /* renamed from: u  reason: collision with root package name */
    public static int f29028u = 3;

    /* renamed from: v  reason: collision with root package name */
    public static final String f29029v = "b";

    /* renamed from: b  reason: collision with root package name */
    public final List<MarketWidgetInfo> f29030b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, MarketWidgetInfo> f29031c;

    /* renamed from: d  reason: collision with root package name */
    public h f29032d;

    /* renamed from: e  reason: collision with root package name */
    public List<SymbolPrice> f29033e;

    /* renamed from: f  reason: collision with root package name */
    public List<SymbolPrice> f29034f;

    /* renamed from: g  reason: collision with root package name */
    public List<SymbolPrice> f29035g;

    /* renamed from: h  reason: collision with root package name */
    public List<SymbolPrice> f29036h;

    /* renamed from: i  reason: collision with root package name */
    public List<SymbolPrice> f29037i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, SymbolPrice> f29038j;

    /* renamed from: k  reason: collision with root package name */
    public MarketOverviewListener f29039k;

    /* renamed from: l  reason: collision with root package name */
    public MarketOverviewListener f29040l;

    /* renamed from: m  reason: collision with root package name */
    public MarketOverviewListener f29041m;

    /* renamed from: n  reason: collision with root package name */
    public MarketOverviewListener f29042n;

    /* renamed from: o  reason: collision with root package name */
    public MarketOverviewListener f29043o;

    /* renamed from: p  reason: collision with root package name */
    public i6.a f29044p;

    /* renamed from: q  reason: collision with root package name */
    public a.d f29045q;

    public class a extends TypeToken<List<MarketWidgetInfo>> {
        public a() {
        }
    }

    /* renamed from: hf.b$b  reason: collision with other inner class name */
    public class C0253b extends MarketOverviewListener {
        public C0253b() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            List unused = b.this.f29033e = (List) marketOverviewResponse.getData();
            b bVar = b.this;
            bVar.t(bVar.f29033e);
        }
    }

    public class c extends MarketOverviewListener {
        public c() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            List unused = b.this.f29034f = (List) marketOverviewResponse.getData();
            b bVar = b.this;
            bVar.t(bVar.f29034f);
        }
    }

    public class d extends MarketOverviewListener {
        public d() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            List unused = b.this.f29035g = (List) marketOverviewResponse.getData();
            b bVar = b.this;
            bVar.t(bVar.f29035g);
        }
    }

    public class e extends MarketOverviewListener {
        public e() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            List unused = b.this.f29037i = (List) marketOverviewResponse.getData();
            b bVar = b.this;
            bVar.t(bVar.f29037i);
        }
    }

    public class f extends MarketOverviewListener {
        public f() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            for (SymbolPrice symbolPrice : (List) marketOverviewResponse.getData()) {
                if (!symbolPrice.getSymbol().endsWith("-Index")) {
                    symbolPrice.setSymbol(symbolPrice.getSymbol() + "-Index");
                }
            }
            List unused = b.this.f29036h = (List) marketOverviewResponse.getData();
            b bVar = b.this;
            bVar.t(bVar.f29036h);
        }
    }

    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29052a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29052a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29052a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29052a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT_INDEX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29052a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP_INDEX     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f29052a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: hf.b.g.<clinit>():void");
        }
    }

    public interface h {
        void a(List<MarketWidgetInfo> list);
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public static final b f29053a = new b((a) null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static void A() {
        List<MarketWidgetInfo> p11 = p();
        ArrayList arrayList = new ArrayList();
        for (MarketWidgetInfo next : p11) {
            int i11 = g.f29052a[next.getTradeType().ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5) {
                if (!gj.d.n().E()) {
                    arrayList.add(next);
                }
            } else if (a1.v().p0(next.getSymbol()) && !gj.d.n().G()) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            MarketWidgetView.setCurrentPage(0);
            p11.removeAll(arrayList);
            C(p11);
        }
    }

    public static boolean B(String str, TradeType tradeType) {
        int i11 = 0;
        while (i11 < i.f29053a.f29030b.size()) {
            MarketWidgetInfo marketWidgetInfo = i.f29053a.f29030b.get(i11);
            if (marketWidgetInfo == null || !StringUtils.c(str, marketWidgetInfo.getSymbol()) || tradeType != marketWidgetInfo.getTradeType()) {
                i11++;
            } else {
                i.f29053a.f29030b.remove(i11);
                return true;
            }
        }
        return false;
    }

    public static void C(List<MarketWidgetInfo> list) {
        SP.y(f29027t, true);
        synchronized (i.f29053a.f29030b) {
            i.f29053a.f29030b.clear();
            i.f29053a.f29030b.addAll(list);
            i.f29053a.f29031c.clear();
            for (MarketWidgetInfo next : i.f29053a.f29030b) {
                i.f29053a.f29031c.put(next.getSymbol(), next);
            }
            SP.s(f29025r, new Gson().toJson((Object) i.f29053a.f29030b));
        }
        I();
        if (!u()) {
            gf.a.g();
        } else if (gf.a.j() && !gf.a.k()) {
            gf.a.o(false);
        }
        i.f29053a.F();
    }

    public static void D(int i11) {
        b unused = i.f29053a;
        f29028u = i11;
        MarketWidgetView.setCurrentPage(0);
        I();
        SP.q(f29026s, i11);
    }

    public static void E(h hVar) {
        i.f29053a.f29032d = hVar;
        if (i.f29053a.f29032d != null) {
            i.f29053a.f29032d.a(q());
            i.f29053a.F();
            return;
        }
        i.f29053a.G();
    }

    public static void I() {
        J(TradeType.PRO);
        J(TradeType.CONTRACT);
        J(TradeType.SWAP);
        J(TradeType.LINEAR_SWAP);
        J(TradeType.CONTRACT_INDEX);
        J(TradeType.LINEAR_SWAP_INDEX);
    }

    public static void J(TradeType tradeType) {
        List<SymbolPrice> list;
        int i11 = g.f29052a[tradeType.ordinal()];
        if (i11 == 1) {
            list = i.f29053a.f29034f;
        } else if (i11 == 2) {
            list = i.f29053a.f29035g;
        } else if (i11 == 3 || i11 == 4) {
            list = i.f29053a.f29036h;
        } else if (i11 != 5) {
            list = i.f29053a.f29033e;
        } else {
            list = i.f29053a.f29037i;
        }
        i.f29053a.t(list);
    }

    public static void m(String str, TradeType tradeType, boolean z11) {
        gf.a.n(true);
        SP.y(f29027t, true);
        synchronized (i.f29053a.f29030b) {
            B(str, tradeType);
            MarketWidgetInfo marketWidgetInfo = new MarketWidgetInfo(str, tradeType.toString());
            i.f29053a.f29030b.add(marketWidgetInfo);
            i.f29053a.f29031c.put(str, marketWidgetInfo);
            SP.s(f29025r, new Gson().toJson((Object) i.f29053a.f29030b));
        }
        J(tradeType);
        if (!gf.a.j() || !gf.a.k()) {
            gf.a.o(z11);
        }
        i.f29053a.F();
    }

    public static void n() {
        E((h) null);
    }

    public static boolean o(String str, TradeType tradeType) {
        return s(str, tradeType) != null;
    }

    public static List<MarketWidgetInfo> p() {
        ArrayList arrayList;
        synchronized (i.f29053a.f29030b) {
            arrayList = new ArrayList(i.f29053a.f29030b);
        }
        return arrayList;
    }

    public static List<MarketWidgetInfo> q() {
        ArrayList arrayList;
        synchronized (i.f29053a.f29030b) {
            arrayList = new ArrayList();
            for (MarketWidgetInfo symbol : i.f29053a.f29030b) {
                arrayList.add(i.f29053a.f29031c.get(symbol.getSymbol()));
            }
        }
        return arrayList;
    }

    public static int r() {
        b unused = i.f29053a;
        return f29028u;
    }

    public static MarketWidgetInfo s(String str, TradeType tradeType) {
        for (MarketWidgetInfo next : i.f29053a.f29030b) {
            if (next != null && StringUtils.c(str, next.getSymbol()) && tradeType == next.getTradeType()) {
                return next;
            }
        }
        return null;
    }

    public static boolean u() {
        boolean z11;
        synchronized (i.f29053a.f29030b) {
            z11 = i.f29053a.f29030b.size() > 0;
        }
        return z11;
    }

    public static void v() {
        if (u()) {
            synchronized (i.f29053a.f29030b) {
                for (MarketWidgetInfo next : i.f29053a.f29030b) {
                    String x11 = x(next);
                    if (!TextUtils.isEmpty(x11)) {
                        next.setName(x11);
                    }
                }
                SP.s(f29025r, new Gson().toJson((Object) i.f29053a.f29030b));
            }
        }
    }

    public static void w(MarketWidgetInfo marketWidgetInfo) {
        String symbol = marketWidgetInfo.getSymbol();
        String[] split = symbol.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        int i11 = g.f29052a[marketWidgetInfo.getTradeType().ordinal()];
        if (i11 == 1) {
            marketWidgetInfo.setBaseCurrency(StringUtils.i(ej.g.f(symbol)));
            marketWidgetInfo.setQuoteCurrency("");
            marketWidgetInfo.setName(MarketSymbolTitleUtil.a(symbol));
        } else if (i11 == 2) {
            marketWidgetInfo.setBaseCurrency(split[0]);
            marketWidgetInfo.setQuoteCurrency("USD");
            marketWidgetInfo.setName(MarketSymbolTitleUtil.a(symbol));
        } else if (i11 == 3) {
            marketWidgetInfo.setBaseCurrency(split[0]);
            marketWidgetInfo.setQuoteCurrency("USD");
            marketWidgetInfo.setName(j.b(split[0], BaseApplication.b(), marketWidgetInfo.getQuoteCurrency()));
        } else if (i11 == 4) {
            marketWidgetInfo.setBaseCurrency(split[0]);
            marketWidgetInfo.setQuoteCurrency(split[1]);
            marketWidgetInfo.setName(j.b(split[0], BaseApplication.b(), marketWidgetInfo.getQuoteCurrency()));
        } else if (i11 != 5) {
            marketWidgetInfo.setBaseCurrency(a1.v().p(symbol));
            marketWidgetInfo.setQuoteCurrency(a1.v().F(symbol));
            marketWidgetInfo.setName(a1.v().W(symbol));
        } else {
            marketWidgetInfo.setBaseCurrency(split[0]);
            marketWidgetInfo.setQuoteCurrency(split[1]);
            marketWidgetInfo.setName(MarketSymbolTitleUtil.b(symbol));
        }
    }

    public static String x(MarketWidgetInfo marketWidgetInfo) {
        String symbol = marketWidgetInfo.getSymbol();
        int i11 = g.f29052a[marketWidgetInfo.getTradeType().ordinal()];
        if (i11 == 1 || i11 == 2) {
            return MarketSymbolTitleUtil.a(symbol);
        }
        if (i11 == 3 || i11 == 4) {
            return j.b(symbol.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0], BaseApplication.b(), marketWidgetInfo.getQuoteCurrency());
        }
        if (i11 != 5) {
            return a1.v().W(symbol);
        }
        return MarketSymbolTitleUtil.b(symbol);
    }

    public static void z(String str, TradeType tradeType) {
        SP.y(f29027t, true);
        synchronized (i.f29053a.f29030b) {
            B(str, tradeType);
            i.f29053a.f29031c.remove(str);
            SP.s(f29025r, new Gson().toJson((Object) i.f29053a.f29030b));
        }
        J(tradeType);
        if (!u()) {
            gf.a.g();
        } else {
            i.f29053a.F();
        }
    }

    public final void F() {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        int i11;
        if (i.f29053a.f29032d != null && gf.a.j()) {
            if (this.f29039k == null) {
                this.f29039k = new C0253b();
            }
            synchronized (i.f29053a.f29030b) {
                z11 = false;
                z12 = false;
                z13 = false;
                z14 = false;
                z15 = false;
                for (MarketWidgetInfo symbol : i.f29053a.f29030b) {
                    String symbol2 = symbol.getSymbol();
                    if (symbol2.toLowerCase().endsWith("-index")) {
                        z11 = true;
                    } else if (symbol2.contains("_")) {
                        z12 = true;
                    } else if (symbol2.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                        String[] split = symbol2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        if (split == null) {
                            i11 = 0;
                        } else {
                            i11 = split.length;
                        }
                        if (i11 == 2 && "USD".equals(split[1])) {
                            z13 = true;
                        } else if (i11 == 2 || i11 == 3) {
                            z14 = true;
                        }
                    } else {
                        z15 = true;
                    }
                }
            }
            i6.d.e(f29029v, "hasIndex:" + z11 + " hasContract:" + z12 + " hasSwap:" + z13 + " hasLinearSwap:" + z14 + " hasPro:" + z15 + " isTurkeyContractOpen:" + gj.d.n().E());
            if (z15) {
                x8.a.a().e(true, this.f29039k);
                x8.a.a().d(this.f29045q);
            } else {
                x8.a.a().e(false, this.f29039k);
                x8.a.a().c(this.f29045q);
            }
            if (!gj.d.n().E()) {
                H();
                return;
            }
            if (this.f29040l == null) {
                this.f29040l = new c();
            }
            if (z12) {
                q7.a.a().e(true, this.f29040l);
                q7.a.a().d(this.f29045q);
            } else {
                q7.a.a().e(false, this.f29040l);
                q7.a.a().c(this.f29045q);
            }
            if (this.f29042n == null) {
                this.f29042n = new d();
            }
            if (z13) {
                l9.a.a().e(true, this.f29042n);
                l9.a.a().d(this.f29045q);
            } else {
                l9.a.a().e(false, this.f29042n);
                l9.a.a().c(this.f29045q);
            }
            if (this.f29043o == null) {
                this.f29043o = new e();
            }
            if (z14) {
                h8.a.a().e(true, this.f29043o);
                h8.a.a().d(this.f29045q);
            } else {
                h8.a.a().e(false, this.f29043o);
                h8.a.a().c(this.f29045q);
            }
            if (this.f29041m == null) {
                this.f29041m = new f();
            }
            if (z11) {
                b8.a.a().e(true, this.f29041m);
                b8.a.a().d(this.f29045q);
                return;
            }
            b8.a.a().e(false, this.f29041m);
            b8.a.a().c(this.f29045q);
        }
    }

    public final void G() {
        if (this.f29039k != null) {
            x8.a.a().e(false, this.f29039k);
            x8.a.a().c(this.f29045q);
        }
        this.f29039k = null;
        H();
    }

    public final void H() {
        if (this.f29040l != null) {
            q7.a.a().e(false, this.f29040l);
            q7.a.a().c(this.f29045q);
        }
        this.f29040l = null;
        if (this.f29042n != null) {
            l9.a.a().e(false, this.f29042n);
            l9.a.a().c(this.f29045q);
        }
        this.f29042n = null;
        if (this.f29043o != null) {
            h8.a.a().e(false, this.f29043o);
            h8.a.a().c(this.f29045q);
        }
        this.f29043o = null;
        if (this.f29041m != null) {
            b8.a.a().e(false, this.f29041m);
            b8.a.a().c(this.f29045q);
        }
        this.f29041m = null;
    }

    public void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj != null) {
            for (SymbolPrice symbolPrice : (List) obj) {
                this.f29038j.put(symbolPrice.getSymbol(), symbolPrice);
            }
            List<MarketWidgetInfo> p11 = p();
            ArrayList arrayList = new ArrayList();
            for (MarketWidgetInfo next : p11) {
                String symbol = next.getSymbol();
                MarketWidgetInfo marketWidgetInfo = this.f29031c.get(symbol);
                if (marketWidgetInfo != null) {
                    SymbolPrice symbolPrice2 = this.f29038j.get(next.getSymbol());
                    if (symbolPrice2 == null && (symbolPrice2 = f0.g().h(symbol)) != null) {
                        this.f29038j.put(symbolPrice2.getSymbol(), symbolPrice2);
                    }
                    if (symbolPrice2 != null) {
                        y(marketWidgetInfo, symbolPrice2);
                    }
                    arrayList.add(marketWidgetInfo);
                }
            }
            h hVar = this.f29032d;
            if (hVar != null) {
                hVar.a(arrayList);
            }
        }
    }

    public final void t(List<SymbolPrice> list) {
        Message obtain = Message.obtain();
        obtain.obj = list;
        this.f29044p.sendMessage(obtain);
    }

    public final void y(MarketWidgetInfo marketWidgetInfo, SymbolPrice symbolPrice) {
        String str;
        double d11;
        int i11;
        int i12 = R$color.global_secondary_text_color;
        String symbol = marketWidgetInfo.getSymbol();
        if (symbolPrice != null) {
            Double close = symbolPrice.getClose();
            String str2 = "--";
            if (close != null) {
                String valueOf = String.valueOf(close);
                int i13 = g.f29052a[marketWidgetInfo.getTradeType().ordinal()];
                int i14 = 4;
                if (i13 == 1) {
                    ContractCurrencyInfo b11 = ContractCurrencyUtils.b(symbol);
                    if (b11 != null) {
                        i14 = ej.f.p(b11.getContractCode());
                    }
                    valueOf = BaseApplication.b().getString(R$string.contract_symbol_price_dollar) + m.m(valueOf, i14);
                } else if (i13 == 2) {
                    SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(symbol);
                    if (c11 != null) {
                        i14 = us.i.o(c11.getSymbol());
                    }
                    valueOf = BaseApplication.b().getString(R$string.contract_symbol_price_dollar) + m.m(valueOf, i14);
                } else if (i13 == 3) {
                    Map<String, IndexCurrencyInfo> h11 = IndexCurrencyInfoController.k().h();
                    if (h11 != null) {
                        IndexCurrencyInfo indexCurrencyInfo = h11.get(symbol);
                        if (indexCurrencyInfo != null) {
                            i14 = ContractIndexPrecisionUtil.a(indexCurrencyInfo.getContractCode());
                        }
                        valueOf = BaseApplication.b().getString(R$string.contract_symbol_price_dollar) + m.m(valueOf, i14);
                    }
                } else if (i13 == 4) {
                    Map<String, IndexCurrencyInfo> h12 = IndexCurrencyInfoController.k().h();
                    if (h12 != null) {
                        IndexCurrencyInfo indexCurrencyInfo2 = h12.get(symbol);
                        if (indexCurrencyInfo2 != null) {
                            i14 = FuturePrecisionUtil.b(indexCurrencyInfo2.getContractCode());
                        }
                        valueOf = m.m(valueOf, i14);
                    }
                } else if (i13 != 5) {
                    valueOf = m.m(valueOf, PrecisionUtil.x(symbol));
                } else {
                    LinearSwapContractInfo n11 = LinearSwapCurrencyInfoController.l().n(symbol);
                    if (n11 != null) {
                        i14 = FuturePrecisionUtil.y(n11.getContractCode(), n11.getContractShortType(), (String) null);
                    }
                    valueOf = m.m(valueOf, i14);
                }
                Double open = symbolPrice.getOpen();
                if (open != null) {
                    d11 = close.doubleValue() - open.doubleValue();
                    if (Double.compare(close.doubleValue(), 0.0d) != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(Double.compare(d11, 0.0d) > 0 ? "+" : "");
                        sb2.append(m.i((d11 / open.doubleValue()) * 100.0d, PrecisionUtil.v(symbol)));
                        sb2.append("%");
                        str2 = sb2.toString();
                    }
                } else {
                    d11 = 0.0d;
                }
                if (Double.compare(d11, 0.0d) > 0) {
                    i11 = w.h();
                } else if (Double.compare(d11, 0.0d) < 0) {
                    i11 = w.d();
                } else {
                    i11 = R$color.baseColorSecondaryText;
                }
                String str3 = valueOf;
                i12 = i11;
                str = str2;
                str2 = str3;
            } else {
                str = str2;
            }
            marketWidgetInfo.setPrice(str2);
            marketWidgetInfo.setPercent(str);
            marketWidgetInfo.setColor(BaseApplication.b().getResources().getColor(i12));
        }
    }

    public b() {
        ArrayList arrayList = new ArrayList();
        this.f29030b = arrayList;
        HashMap hashMap = new HashMap();
        this.f29031c = hashMap;
        this.f29038j = new HashMap();
        this.f29045q = new a(this);
        f29028u = SP.e(f29026s, 3);
        this.f29044p = new i6.a("MarketWidgetDataProvider", this);
        List<MarketWidgetInfo> list = (List) new Gson().fromJson(SP.i(f29025r, ""), new a().getType());
        synchronized (arrayList) {
            arrayList.clear();
            hashMap.clear();
            if ((list == null || list.isEmpty()) && !SP.l(f29027t, false)) {
                list = list == null ? new ArrayList<>() : list;
                TradeType tradeType = TradeType.PRO;
                MarketWidgetInfo marketWidgetInfo = new MarketWidgetInfo("btcusdt", tradeType.toString());
                marketWidgetInfo.setBaseCurrency("BTC");
                marketWidgetInfo.setQuoteCurrency("USDT");
                marketWidgetInfo.setName("BTC/USDT");
                list.add(marketWidgetInfo);
                MarketWidgetInfo marketWidgetInfo2 = new MarketWidgetInfo("ethusdt", tradeType.toString());
                marketWidgetInfo2.setBaseCurrency(DefiChainInfo.CHAIN_ETH);
                marketWidgetInfo2.setQuoteCurrency("USDT");
                marketWidgetInfo2.setName("ETH/USDT");
                list.add(marketWidgetInfo2);
            }
            if (list != null) {
                for (MarketWidgetInfo marketWidgetInfo3 : list) {
                    String x11 = x(marketWidgetInfo3);
                    if (!TextUtils.isEmpty(x11)) {
                        marketWidgetInfo3.setName(x11);
                    }
                    this.f29030b.add(marketWidgetInfo3);
                    this.f29031c.put(marketWidgetInfo3.getSymbol(), marketWidgetInfo3);
                }
            }
        }
    }
}
