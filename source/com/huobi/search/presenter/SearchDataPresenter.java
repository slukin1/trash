package com.huobi.search.presenter;

import al.p;
import ar.e;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.huobi.search.bean.FlutterSearchBean;
import com.huobi.search.bean.NewSearchItem;
import com.huobi.search.bean.SearchResultCategoryItem;
import i6.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sn.t;

public class SearchDataPresenter {

    /* renamed from: a  reason: collision with root package name */
    public f f80760a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchResultCategoryItem> f80761b;

    /* renamed from: c  reason: collision with root package name */
    public List<SearchResultCategoryItem> f80762c;

    /* renamed from: d  reason: collision with root package name */
    public List<SearchResultCategoryItem> f80763d;

    /* renamed from: e  reason: collision with root package name */
    public List<SearchResultCategoryItem> f80764e;

    /* renamed from: f  reason: collision with root package name */
    public ar.e f80765f;

    /* renamed from: g  reason: collision with root package name */
    public ConcurrentHashMap<String, SearchResultCategoryItem> f80766g;

    /* renamed from: h  reason: collision with root package name */
    public ConcurrentHashMap<String, List<FlutterSearchBean>> f80767h = new ConcurrentHashMap<>();

    public class a implements Observer<SearchResultCategoryItem> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f80768b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f80769c;

        public a(g gVar, List list) {
            this.f80768b = gVar;
            this.f80769c = list;
        }

        /* renamed from: a */
        public void onNext(SearchResultCategoryItem searchResultCategoryItem) {
            this.f80769c.add(searchResultCategoryItem);
        }

        public void onCompleted() {
            g gVar = this.f80768b;
            if (gVar != null) {
                gVar.a(this.f80769c);
            }
        }

        public void onError(Throwable th2) {
        }
    }

    public class b implements Observer<NewSearchItem> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f80771b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f80772c;

        public b(List list, String str) {
            this.f80771b = list;
            this.f80772c = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(List list) {
            SearchDataPresenter.this.f80767h.put(RankScreenBean.SCREEN_VALUE_SPOT, SearchDataPresenter.this.n(list, false, false));
            if (SearchDataPresenter.this.f80760a != null && SearchDataPresenter.this.f80767h.size() == 3) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((Collection) SearchDataPresenter.this.f80767h.get(RankScreenBean.SCREEN_VALUE_SPOT));
                arrayList.addAll((Collection) SearchDataPresenter.this.f80767h.get("margin"));
                arrayList.addAll((Collection) SearchDataPresenter.this.f80767h.get("futures"));
                SearchDataPresenter.this.f80767h.put(TtmlNode.COMBINE_ALL, arrayList);
                SearchDataPresenter.this.f80760a.a(SearchDataPresenter.this.f80767h);
            }
        }

        /* renamed from: c */
        public void onNext(NewSearchItem newSearchItem) {
            if (newSearchItem != null) {
                SearchResultCategoryItem clone = SearchResultCategoryItem.clone(newSearchItem);
                clone.setCollection(t.w(clone.getSymbol()));
                this.f80771b.add(clone);
            }
        }

        public void onCompleted() {
            SearchDataPresenter.this.y(this.f80771b, this.f80772c, new dr.e(this), "pro");
        }

        public void onError(Throwable th2) {
            th2.printStackTrace();
        }
    }

    public class c implements Observer<NewSearchItem> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f80774b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f80775c;

        public c(List list, String str) {
            this.f80774b = list;
            this.f80775c = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(List list) {
            SearchDataPresenter.this.f80767h.put("margin", SearchDataPresenter.this.n(list, true, false));
            if (SearchDataPresenter.this.f80760a != null && SearchDataPresenter.this.f80767h.size() == 3) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((Collection) SearchDataPresenter.this.f80767h.get(RankScreenBean.SCREEN_VALUE_SPOT));
                arrayList.addAll((Collection) SearchDataPresenter.this.f80767h.get("margin"));
                arrayList.addAll((Collection) SearchDataPresenter.this.f80767h.get("futures"));
                SearchDataPresenter.this.f80767h.put(TtmlNode.COMBINE_ALL, arrayList);
                SearchDataPresenter.this.f80760a.a(SearchDataPresenter.this.f80767h);
            }
        }

        /* renamed from: c */
        public void onNext(NewSearchItem newSearchItem) {
            if (newSearchItem != null) {
                SearchResultCategoryItem clone = SearchResultCategoryItem.clone(newSearchItem);
                clone.setCollection(t.w(clone.getSymbol()));
                this.f80774b.add(clone);
            }
        }

        public void onCompleted() {
            SearchDataPresenter.this.y(this.f80774b, this.f80775c, new dr.f(this), "margin");
        }

        public void onError(Throwable th2) {
            th2.printStackTrace();
        }
    }

    public class d implements Observer<NewSearchItem> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f80777b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f80778c;

        public d(List list, String str) {
            this.f80777b = list;
            this.f80778c = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(List list) {
            SearchDataPresenter.this.f80767h.put("futures", SearchDataPresenter.this.n(list, false, true));
            if (SearchDataPresenter.this.f80760a != null && SearchDataPresenter.this.f80767h.size() == 3) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((Collection) SearchDataPresenter.this.f80767h.get(RankScreenBean.SCREEN_VALUE_SPOT));
                arrayList.addAll((Collection) SearchDataPresenter.this.f80767h.get("margin"));
                arrayList.addAll((Collection) SearchDataPresenter.this.f80767h.get("futures"));
                SearchDataPresenter.this.f80767h.put(TtmlNode.COMBINE_ALL, arrayList);
                SearchDataPresenter.this.f80760a.a(SearchDataPresenter.this.f80767h);
            }
        }

        /* renamed from: c */
        public void onNext(NewSearchItem newSearchItem) {
            if (newSearchItem != null) {
                SearchResultCategoryItem clone = SearchResultCategoryItem.clone(newSearchItem);
                clone.setCollection(t.w(clone.getContractCode()));
                this.f80777b.add(clone);
            }
        }

        public void onCompleted() {
            SearchDataPresenter.this.y(this.f80777b, this.f80778c, new dr.g(this), "contract");
        }

        public void onError(Throwable th2) {
        }
    }

    public class e implements e.d {
        public e() {
        }

        public void a(List<NewSearchItem> list) {
            i6.d.d("chao => onInitContractCoins contractSymbols" + list.size());
            List<SearchResultCategoryItem> cloneAll = SearchResultCategoryItem.cloneAll(list);
            boolean isTurkeyLanguage = AppLanguageHelper.getInstance().isTurkeyLanguage();
            boolean E = gj.d.n().E();
            if (!isTurkeyLanguage) {
                synchronized (SearchDataPresenter.this.f80763d) {
                    SearchDataPresenter.this.f80763d.clear();
                    SearchDataPresenter.this.f80763d.addAll(cloneAll);
                }
            } else if (E) {
                synchronized (SearchDataPresenter.this.f80763d) {
                    SearchDataPresenter.this.f80763d.clear();
                    SearchDataPresenter.this.f80763d.addAll(cloneAll);
                }
            }
            if (!SearchDataPresenter.this.f80763d.isEmpty()) {
                synchronized (SearchDataPresenter.this.f80764e) {
                    SearchDataPresenter.this.f80764e.clear();
                    SearchDataPresenter.this.f80764e.addAll(SearchDataPresenter.this.f80761b);
                    SearchDataPresenter.this.f80764e.addAll(SearchDataPresenter.this.f80762c);
                    SearchDataPresenter.this.f80764e.addAll(SearchDataPresenter.this.f80763d);
                }
            }
        }

        public void b(List<NewSearchItem> list, List<NewSearchItem> list2) {
            i6.d.d("chao => onInitProCoins allSymbols" + list.size());
            i6.d.d("chao => onInitProCoins marginSymbols" + list2.size());
            List<SearchResultCategoryItem> cloneAll = SearchResultCategoryItem.cloneAll(list);
            List<SearchResultCategoryItem> cloneAll2 = SearchResultCategoryItem.cloneAll(list2);
            boolean isTurkeyLanguage = AppLanguageHelper.getInstance().isTurkeyLanguage();
            boolean G = gj.d.n().G();
            synchronized (SearchDataPresenter.this.f80761b) {
                SearchDataPresenter.this.f80761b.clear();
                SearchDataPresenter.this.f80761b.addAll(cloneAll);
            }
            if (!isTurkeyLanguage) {
                synchronized (SearchDataPresenter.this.f80762c) {
                    SearchDataPresenter.this.f80762c.clear();
                    SearchDataPresenter.this.f80762c.addAll(cloneAll2);
                }
            } else if (G) {
                synchronized (SearchDataPresenter.this.f80762c) {
                    SearchDataPresenter.this.f80762c.clear();
                    SearchDataPresenter.this.f80762c.addAll(cloneAll2);
                }
            }
            if (!SearchDataPresenter.this.f80761b.isEmpty() || !SearchDataPresenter.this.f80762c.isEmpty()) {
                synchronized (SearchDataPresenter.this.f80764e) {
                    SearchDataPresenter.this.f80764e.clear();
                    SearchDataPresenter.this.f80764e.addAll(SearchDataPresenter.this.f80761b);
                    SearchDataPresenter.this.f80764e.addAll(SearchDataPresenter.this.f80762c);
                    SearchDataPresenter.this.f80764e.addAll(SearchDataPresenter.this.f80763d);
                }
            }
        }
    }

    public interface f {
        void a(ConcurrentHashMap<String, List<FlutterSearchBean>> concurrentHashMap);
    }

    public interface g {
        void a(List<SearchResultCategoryItem> list);
    }

    public static /* synthetic */ Boolean p(String str, SearchResultCategoryItem searchResultCategoryItem) {
        String upperCase = !searchResultCategoryItem.getSymbol().isEmpty() ? searchResultCategoryItem.getSymbol().toUpperCase(Locale.ROOT) : "";
        String quoteCoin = searchResultCategoryItem.getQuoteCoin();
        if (TradeType.PRO == searchResultCategoryItem.getTradeType()) {
            upperCase = searchResultCategoryItem.getBaseCoin();
        }
        boolean z11 = true;
        if (str.contains(" ") || str.contains("/")) {
            upperCase = searchResultCategoryItem.getSymbolName();
            if (str.length() == 1 && str.equalsIgnoreCase("/")) {
                return Boolean.TRUE;
            }
        }
        if (!upperCase.equalsIgnoreCase(str) && !upperCase.startsWith(str) && !upperCase.endsWith(str) && !upperCase.contains(str) && !quoteCoin.equalsIgnoreCase(str) && !quoteCoin.startsWith(str) && !quoteCoin.endsWith(str) && !quoteCoin.contains(str)) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    public static /* synthetic */ Boolean q(String str, SearchResultCategoryItem searchResultCategoryItem) {
        String upperCase = !searchResultCategoryItem.getSymbol().isEmpty() ? searchResultCategoryItem.getSymbol().toUpperCase(Locale.ROOT) : "";
        String quoteCoin = searchResultCategoryItem.getQuoteCoin();
        if (TradeType.PRO == searchResultCategoryItem.getTradeType()) {
            upperCase = searchResultCategoryItem.getBaseCoin();
        }
        boolean z11 = true;
        if (str.contains(" ") || str.contains("/")) {
            upperCase = searchResultCategoryItem.getSymbolName();
            if (str.length() == 1 && str.equalsIgnoreCase("/")) {
                return Boolean.TRUE;
            }
        }
        if (!upperCase.equalsIgnoreCase(str) && !upperCase.startsWith(str) && !upperCase.endsWith(str) && !upperCase.contains(str) && !quoteCoin.equalsIgnoreCase(str) && !quoteCoin.startsWith(str) && !quoteCoin.endsWith(str) && !quoteCoin.contains(str)) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    public static /* synthetic */ Boolean r(String str, SearchResultCategoryItem searchResultCategoryItem) {
        String upperCase = !searchResultCategoryItem.getSymbol().isEmpty() ? searchResultCategoryItem.getSymbol().toUpperCase(Locale.ROOT) : "";
        String quoteCoin = searchResultCategoryItem.getQuoteCoin();
        if (TradeType.PRO == searchResultCategoryItem.getTradeType()) {
            upperCase = searchResultCategoryItem.getBaseCoin();
        }
        boolean z11 = true;
        if (str.contains(" ") || str.contains("/")) {
            upperCase = searchResultCategoryItem.getSymbolName();
            if (str.length() == 1 && str.equalsIgnoreCase("/")) {
                return Boolean.TRUE;
            }
        }
        if (!upperCase.equalsIgnoreCase(str) && !upperCase.startsWith(str) && !upperCase.endsWith(str) && !upperCase.contains(str) && !quoteCoin.equalsIgnoreCase(str) && !quoteCoin.startsWith(str) && !quoteCoin.endsWith(str) && !quoteCoin.contains(str)) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    public static /* synthetic */ Integer s(String str, String str2, Map map, Map map2, SearchResultCategoryItem searchResultCategoryItem, SearchResultCategoryItem searchResultCategoryItem2) {
        String str3 = "";
        String upperCase = !searchResultCategoryItem.getSymbol().isEmpty() ? searchResultCategoryItem.getSymbol().toUpperCase(Locale.ROOT) : str3;
        if (!searchResultCategoryItem2.getSymbol().isEmpty()) {
            str3 = searchResultCategoryItem2.getSymbol().toUpperCase(Locale.ROOT);
        }
        String quoteCoin = searchResultCategoryItem.getQuoteCoin();
        String quoteCoin2 = searchResultCategoryItem2.getQuoteCoin();
        if (str.contains(" ") || str.contains("/")) {
            upperCase = searchResultCategoryItem.getSymbolName();
            str3 = searchResultCategoryItem2.getSymbolName();
        }
        TradeType tradeType = TradeType.PRO;
        if (tradeType == searchResultCategoryItem.getTradeType()) {
            upperCase = searchResultCategoryItem.getBaseCoin();
        }
        if (tradeType == searchResultCategoryItem2.getTradeType()) {
            str3 = searchResultCategoryItem2.getBaseCoin();
        }
        if (str2.equalsIgnoreCase(TtmlNode.COMBINE_ALL) || str2.equalsIgnoreCase("pro") || str2.equalsIgnoreCase("margin")) {
            int b11 = fr.d.b(upperCase, str3, str, quoteCoin, quoteCoin2, map);
            if (-2 == b11) {
                return Integer.valueOf(fr.d.a(upperCase, str3, str, quoteCoin, quoteCoin2));
            }
            return Integer.valueOf(b11);
        } else if (str2.equalsIgnoreCase("contract")) {
            return Integer.valueOf(fr.d.c(searchResultCategoryItem, searchResultCategoryItem2, str, map2));
        } else {
            return 0;
        }
    }

    public void m() {
        this.f80765f.v(new e());
    }

    public final ArrayList<FlutterSearchBean> n(List<SearchResultCategoryItem> list, boolean z11, boolean z12) {
        ArrayList<FlutterSearchBean> arrayList = new ArrayList<>();
        for (SearchResultCategoryItem next : list) {
            FlutterSearchBean flutterSearchBean = new FlutterSearchBean();
            flutterSearchBean.setFavorite(next.isCollection());
            if (z12) {
                flutterSearchBean.setSymbol(next.getContractShortType());
                String symbolName = next.getSymbolName();
                if (-1 != symbolName.indexOf(" ")) {
                    flutterSearchBean.setPrimaryTitle(symbolName.split(" ")[0]);
                    flutterSearchBean.setSecondaryTitle(symbolName.split(" ")[1]);
                }
                flutterSearchBean.setImageUrl(p.l(next.getSymbol()));
            } else {
                flutterSearchBean.setSymbol(next.getSymbol());
                flutterSearchBean.setPrimaryTitle(next.getBaseCoin());
                flutterSearchBean.setSecondaryTitle("/" + next.getQuoteCoin());
                flutterSearchBean.setImageUrl(p.l(next.getBaseCoin()));
            }
            if (z11) {
                flutterSearchBean.setMarginString(next.getLeverageRatio() + "X");
            } else {
                flutterSearchBean.setMarginString("");
            }
            arrayList.add(flutterSearchBean);
        }
        return arrayList;
    }

    public void o() {
        if (this.f80761b == null) {
            this.f80761b = new LinkedList();
        }
        if (this.f80762c == null) {
            this.f80762c = new LinkedList();
        }
        if (this.f80763d == null) {
            this.f80763d = new LinkedList();
        }
        if (this.f80764e == null) {
            this.f80764e = new LinkedList();
        }
        if (this.f80765f == null) {
            this.f80765f = ar.e.p();
        }
        if (this.f80766g == null) {
            this.f80766g = new ConcurrentHashMap<>();
        }
        m();
        this.f80765f.q();
    }

    public void t() {
        if (!this.f80767h.isEmpty()) {
            this.f80767h.clear();
        }
    }

    public boolean u(String str, f fVar) {
        this.f80760a = fVar;
        k.d("startSearch", str);
        if (str.isEmpty()) {
            return false;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        t();
        x(upperCase);
        w(upperCase);
        v(upperCase);
        return true;
    }

    public final void v(String str) {
        Observable.from(this.f80763d).filter(new dr.c(str)).subscribeOn(Schedulers.immediate()).subscribe(new d(new ArrayList(), str));
    }

    public final void w(String str) {
        Observable.from(this.f80762c).filter(new dr.a(str)).subscribeOn(Schedulers.immediate()).subscribe(new c(new ArrayList(), str));
    }

    public final void x(String str) {
        Observable.from(this.f80761b).filter(new dr.b(str)).subscribeOn(Schedulers.immediate()).subscribe(new b(new ArrayList(), str));
    }

    public final void y(List<SearchResultCategoryItem> list, String str, g gVar, String str2) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("USDT", 1);
        hashMap.put("HUSD", 2);
        hashMap.put("USD", 3);
        hashMap.put("BTC", 4);
        hashMap.put("HT", 5);
        hashMap.put("ALTS", 6);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("_CW", 1);
        hashMap2.put("_NW", 2);
        hashMap2.put("_CQ", 3);
        hashMap2.put("_NQ", 4);
        Observable.from(list).sorted(new dr.d(str, str2, hashMap, hashMap2)).subscribeOn(Schedulers.immediate()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(gVar, arrayList));
    }
}
