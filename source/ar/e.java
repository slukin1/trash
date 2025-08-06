package ar;

import android.app.Application;
import android.text.TextUtils;
import bh.j;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.controller.LinearSwapHiddenInstrumentsController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.search.bean.NewSearchItem;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import qk.h;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import sn.t;

public final class e {

    /* renamed from: k  reason: collision with root package name */
    public static volatile e f76982k = new e();

    /* renamed from: a  reason: collision with root package name */
    public List<SymbolBean> f76983a = Collections.synchronizedList(new LinkedList());

    /* renamed from: b  reason: collision with root package name */
    public List<ContractCurrencyInfo> f76984b = Collections.synchronizedList(new LinkedList());

    /* renamed from: c  reason: collision with root package name */
    public List<SwapCurrencyInfo> f76985c = Collections.synchronizedList(new LinkedList());

    /* renamed from: d  reason: collision with root package name */
    public List<LinearSwapContractInfo> f76986d = Collections.synchronizedList(new LinkedList());

    /* renamed from: e  reason: collision with root package name */
    public final List<NewSearchItem> f76987e = Collections.synchronizedList(new LinkedList());

    /* renamed from: f  reason: collision with root package name */
    public final List<NewSearchItem> f76988f = Collections.synchronizedList(new LinkedList());

    /* renamed from: g  reason: collision with root package name */
    public final List<NewSearchItem> f76989g = Collections.synchronizedList(new LinkedList());

    /* renamed from: h  reason: collision with root package name */
    public final List<NewSearchItem> f76990h = Collections.synchronizedList(new LinkedList());

    /* renamed from: i  reason: collision with root package name */
    public final List<NewSearchItem> f76991i = Collections.synchronizedList(new LinkedList());

    /* renamed from: j  reason: collision with root package name */
    public d f76992j;

    public class a extends BaseSubscriber<List<SymbolBean>> {
        public a() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }

        public void printLog(Throwable th2) {
            super.printLog(th2);
        }

        public void onNext(List<SymbolBean> list) {
            i6.d.d("chao=> requestSymbols : " + list.size());
            synchronized (e.this.f76987e) {
                List<SymbolBean> Z = a1.v().Z(TradeType.PRO);
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < Z.size(); i11++) {
                    SymbolBean symbolBean = Z.get(i11);
                    if (symbolBean.getIsTradeEnabled()) {
                        arrayList.add(symbolBean);
                    } else if (symbolBean.getState().equalsIgnoreCase(SymbolBean.PRE_ONLINE) || symbolBean.getState().equalsIgnoreCase(SymbolBean.SUSPEND)) {
                        arrayList.add(symbolBean);
                        i6.d.i("SearchDataHelper=> getIsTradeEnabled : " + symbolBean.getSymbolName());
                    }
                }
                e eVar = e.this;
                eVar.n(eVar.f76987e, arrayList, false, TradeType.PRO);
                e.this.f76983a.clear();
                e.this.f76983a.addAll(a1.v().Z(TradeType.SUPERMARGIN));
                List<SymbolBean> Z2 = a1.v().Z(TradeType.MARGIN);
                ArrayList arrayList2 = new ArrayList();
                int i12 = 0;
                while (true) {
                    boolean z11 = true;
                    if (i12 >= Z2.size()) {
                        break;
                    }
                    SymbolBean symbolBean2 = Z2.get(i12);
                    int i13 = 0;
                    while (true) {
                        if (i13 >= e.this.f76983a.size()) {
                            z11 = false;
                            break;
                        } else if (((SymbolBean) e.this.f76983a.get(i13)).getSymbol().equalsIgnoreCase(symbolBean2.getSymbol())) {
                            break;
                        } else {
                            i13++;
                        }
                    }
                    if (!z11) {
                        arrayList2.add(symbolBean2);
                    }
                    i12++;
                }
                e.this.f76983a.addAll(arrayList2);
                e eVar2 = e.this;
                eVar2.n(eVar2.f76988f, e.this.f76983a, true, TradeType.PRO);
                if (e.this.f76992j != null && e.this.f76987e.size() > 0) {
                    e.this.f76992j.b(new ArrayList(e.this.f76987e), new ArrayList(e.this.f76988f));
                }
            }
        }
    }

    public class b extends BaseSubscriber<Object> {
        public b() {
        }

        public void onCompleted() {
            e.this.o();
        }
    }

    public class c extends BaseSubscriber<Object> {
        public c() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }

        public void onNext(Object obj) {
            if (e.this.f76992j != null) {
                ArrayList arrayList = new ArrayList(e.this.f76989g);
                arrayList.addAll(e.this.f76990h);
                arrayList.addAll(e.this.f76991i);
                e.this.f76992j.a(arrayList);
                i6.d.d("chao => onInitContractCoins contractSymbols" + e.this.f76989g.size());
                i6.d.d("chao => onInitContractCoins swapSymbols" + e.this.f76990h.size());
                i6.d.d("chao => onInitContractCoins linearSwapSymbols" + e.this.f76991i.size());
            }
        }

        public void printLog(Throwable th2) {
            super.printLog(th2);
        }
    }

    public interface d {
        void a(List<NewSearchItem> list);

        void b(List<NewSearchItem> list, List<NewSearchItem> list2);
    }

    public static e p() {
        return f76982k;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List r(List list) {
        synchronized (this.f76987e) {
            this.f76984b.clear();
            this.f76989g.clear();
            for (int i11 = 0; i11 < list.size(); i11++) {
                ContractCurrencyInfo contractCurrencyInfo = (ContractCurrencyInfo) list.get(i11);
                if (!LinearSwapHiddenInstrumentsController.d(contractCurrencyInfo.getContractCode())) {
                    this.f76984b.add(contractCurrencyInfo);
                    contractCurrencyInfo.getContractShortType();
                    String str = "";
                    if (contractCurrencyInfo.getContractType() != null && !TextUtils.isEmpty(contractCurrencyInfo.getContractType())) {
                        str = a7.e.v(j.c(), contractCurrencyInfo.getSymbol(), "USD", contractCurrencyInfo.getContractCode(), contractCurrencyInfo.getContractType());
                    }
                    NewSearchItem newSearchItem = new NewSearchItem(TradeType.CONTRACT, contractCurrencyInfo.getSymbol(), contractCurrencyInfo.getContractCode(), "", "USD", (Double) null, (Double) null, str, t.w(contractCurrencyInfo.getContractCode()));
                    newSearchItem.setContractShortType(contractCurrencyInfo.getContractShortType());
                    newSearchItem.setContractType(contractCurrencyInfo.getContractType());
                    this.f76989g.add(newSearchItem);
                }
            }
        }
        return this.f76984b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List s(List list) {
        String str;
        String str2;
        synchronized (this.f76987e) {
            this.f76985c.clear();
            this.f76990h.clear();
            for (int i11 = 0; i11 < list.size(); i11++) {
                SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) list.get(i11);
                if (!LinearSwapHiddenInstrumentsController.d(swapCurrencyInfo.getContractCode())) {
                    this.f76985c.add(swapCurrencyInfo);
                    String contractCode = swapCurrencyInfo.getContractCode();
                    String str3 = "";
                    if (contractCode.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) > 0) {
                        String[] split = contractCode.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        str3 = split.length > 1 ? split[1] : "";
                    }
                    String str4 = str3;
                    Application c11 = j.c();
                    String symbol = swapCurrencyInfo.getSymbol();
                    String contractCode2 = swapCurrencyInfo.getContractCode();
                    if (TextUtils.isEmpty(swapCurrencyInfo.getContractType())) {
                        str = "swap";
                    } else {
                        str = swapCurrencyInfo.getContractType();
                    }
                    NewSearchItem newSearchItem = new NewSearchItem(TradeType.SWAP, swapCurrencyInfo.getSymbol(), swapCurrencyInfo.getContractCode(), "", str4, (Double) null, (Double) null, a7.e.v(c11, symbol, str4, contractCode2, str), t.w(swapCurrencyInfo.getContractCode()));
                    newSearchItem.setContractShortType(swapCurrencyInfo.getContractShortType());
                    if (TextUtils.isEmpty(swapCurrencyInfo.getContractType())) {
                        str2 = "swap";
                    } else {
                        str2 = swapCurrencyInfo.getContractType();
                    }
                    newSearchItem.setContractType(str2);
                    this.f76990h.add(newSearchItem);
                }
            }
        }
        return this.f76985c;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List t(List list) {
        synchronized (this.f76987e) {
            this.f76986d.clear();
            this.f76991i.clear();
            for (int i11 = 0; i11 < list.size(); i11++) {
                LinearSwapContractInfo linearSwapContractInfo = (LinearSwapContractInfo) list.get(i11);
                if (!LinearSwapHiddenInstrumentsController.d(linearSwapContractInfo.getContractCode())) {
                    this.f76986d.add(linearSwapContractInfo);
                    String contractCode = linearSwapContractInfo.getContractCode();
                    String str = "";
                    if (contractCode.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) > 0) {
                        String[] split = contractCode.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        str = split.length > 1 ? split[1] : "";
                    }
                    String str2 = str;
                    String str3 = "";
                    if (linearSwapContractInfo.getContractType() != null && !TextUtils.isEmpty(linearSwapContractInfo.getContractType())) {
                        str3 = a7.e.v(j.c(), linearSwapContractInfo.getSymbol(), str2, linearSwapContractInfo.getContractCode(), linearSwapContractInfo.getContractType());
                    }
                    NewSearchItem newSearchItem = new NewSearchItem(TradeType.LINEAR_SWAP, linearSwapContractInfo.getSymbol(), linearSwapContractInfo.getContractCode(), "", str2, (Double) null, (Double) null, str3, t.w(linearSwapContractInfo.getContractCode()));
                    newSearchItem.setContractShortType(linearSwapContractInfo.getContractShortType());
                    newSearchItem.setContractType(linearSwapContractInfo.getContractType());
                    this.f76991i.add(newSearchItem);
                }
            }
        }
        return this.f76986d;
    }

    public static /* synthetic */ List u(List list, List list2, List list3) {
        return null;
    }

    public final void n(List<NewSearchItem> list, List<SymbolBean> list2, boolean z11, TradeType tradeType) {
        if (list2.size() != 0) {
            list.clear();
            for (int i11 = 0; i11 < list2.size(); i11++) {
                SymbolBean symbolBean = list2.get(i11);
                if (symbolBean != null) {
                    TradeType tradeType2 = TradeType.PRO;
                    String symbol = symbolBean.getSymbol();
                    String baseCurrency = symbolBean.getBaseCurrency();
                    String quoteCurrency = symbolBean.getQuoteCurrency();
                    NewSearchItem newSearchItem = new NewSearchItem(tradeType2, symbol, (String) null, baseCurrency, quoteCurrency, (Double) null, (Double) null, symbolBean.getBaseCurrencyDisplayName() + "/" + symbolBean.getQuoteCurrencyDisplayName(), t.w(symbolBean.getSymbol()));
                    newSearchItem.setWeight(i11);
                    newSearchItem.setState(symbolBean.getState());
                    newSearchItem.setTradeOpenAt(symbolBean.getTradeOpenAt());
                    if (z11) {
                        if (!TextUtils.isEmpty(symbolBean.getSuperMarginLeverageRatio())) {
                            newSearchItem.setLeverageRatio(symbolBean.getSuperMarginLeverageRatio());
                        } else {
                            newSearchItem.setLeverageRatio(symbolBean.getLeverageRatio());
                        }
                    }
                    List<NewSearchItem> list3 = list;
                    list.add(newSearchItem);
                } else {
                    List<NewSearchItem> list4 = list;
                }
            }
        }
    }

    public final void o() {
        Observable.zip(ContractCurrencyUtils.g(true).compose(RxJavaHelper.s()).map(new c(this)), SwapCurrencyInfoController.k().f(true).compose(RxJavaHelper.s()).map(new a(this)), LinearSwapCurrencyInfoController.l().h(true).compose(RxJavaHelper.s()).map(new b(this)), d.f12173b).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new c());
    }

    public void q() {
        a1.v().z0(true).compose(RxJavaHelper.s()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new a());
        h.g().compose(RxJavaHelper.s()).subscribe(new b());
    }

    public void v(d dVar) {
        this.f76992j = dVar;
    }
}
