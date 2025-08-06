package com.hbg.lib.data.symbol;

import ad.i;
import android.text.TextUtils;
import com.hbg.lib.data.main.SymbolDataDiffTools;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.db.ProDbHelper;
import com.hbg.lib.network.pro.db.ProSymbolDbHelper;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.iproov.sdk.bridge.OptionsBridge;
import d7.d1;
import d7.e1;
import d7.f1;
import d7.g1;
import d7.h1;
import d7.i1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public final class SymbolsDataProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f68860a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final List<SymbolBean> f68861b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, SymbolBean> f68862c = new HashMap();

    public class a extends BaseSubscriber<List<SymbolBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Subscriber f68863b;

        public a(Subscriber subscriber) {
            this.f68863b = subscriber;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f68863b.onNext(SymbolsDataProvider.j());
            this.f68863b.onCompleted();
        }

        public void onNext(List<SymbolBean> list) {
            this.f68863b.onNext(list);
            this.f68863b.onCompleted();
        }
    }

    public class b implements Action1<List<SymbolBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f68864b;

        public b(String str) {
            this.f68864b = str;
        }

        /* renamed from: a */
        public void call(List<SymbolBean> list) {
            Collections.sort(list, d1.f53497b);
            SymbolsDataProvider.s(list, this.f68864b);
        }
    }

    public static void g() {
        synchronized (f68860a) {
            f68861b.clear();
            f68862c.clear();
        }
    }

    public static Observable<List<SymbolBean>> h(boolean z11, String str) {
        Observable<List<SymbolBean>> map = SymbolDataDiffTools.r().j().flatMap(i.f3526b).sorted(i1.f53512b).toList().map(new g1(str));
        return z11 ? Observable.concat(Observable.just(j()), map).takeFirst(h1.f53509b) : map;
    }

    public static String i(String str) {
        return TextUtils.isEmpty(str) ? OptionsBridge.NULL_VALUE : str;
    }

    public static List<SymbolBean> j() {
        ArrayList arrayList;
        synchronized (f68860a) {
            arrayList = new ArrayList(f68861b);
        }
        return arrayList;
    }

    public static List<String> k() {
        ArrayList arrayList = new ArrayList();
        if (l()) {
            for (SymbolBean next : j()) {
                if (next.isCanTrade() && "usdt".equalsIgnoreCase(next.getQuoteCurrency())) {
                    arrayList.add(next.getBaseCurrency());
                }
            }
        }
        return arrayList;
    }

    public static boolean l() {
        return !f68861b.isEmpty();
    }

    public static void m(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        List<SymbolBean> g11 = ProSymbolDbHelper.g(str);
        RetrofitLogger.a("SymbolsDataProvider-->initLocalData--> key: " + str + " 本地有: " + g11.size() + " 个 耗时:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        if (!g11.isEmpty()) {
            s(g11, str);
        }
    }

    public static /* synthetic */ Boolean o(List list) {
        return Boolean.valueOf(list != null && list.size() > 0);
    }

    public static /* synthetic */ void p(String str, List list) {
        Collections.sort(list, d1.f53497b);
        s(list, str);
    }

    public static /* synthetic */ void q(boolean z11, String str, Subscriber subscriber) {
        if (!z11 || !l()) {
            List arrayList = new ArrayList();
            if (!l()) {
                m(str);
                if (l()) {
                    arrayList = j();
                }
            }
            if (arrayList.isEmpty()) {
                SymbolDataDiffTools.r().j().doOnNext(new f1(str)).subscribeOn(Schedulers.io()).subscribe(new a(subscriber));
                return;
            }
            subscriber.onNext(arrayList);
            subscriber.onCompleted();
            SymbolDataDiffTools.r().j().doOnNext(new b(str)).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new BaseSubscriber());
            return;
        }
        subscriber.onNext(j());
        subscriber.onCompleted();
    }

    public static Observable<List<SymbolBean>> r(boolean z11, String str) {
        RetrofitLogger.a("SymbolsDataProvider-->requestSymbols-->useCache:" + z11);
        return Observable.create(new e1(z11, str));
    }

    public static void s(List<SymbolBean> list, String str) {
        if (list != null) {
            synchronized (f68860a) {
                List<SymbolBean> list2 = f68861b;
                list2.clear();
                list2.addAll(list);
                f68862c.clear();
                for (SymbolBean next : list2) {
                    next.setKey(str);
                    f68862c.put(next.getSymbol(), next);
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ProDbHelper.d(list);
            RetrofitLogger.a("SymbolsDataProvider-->setSymbolList--> key: " + str + " 插入: " + list.size() + " 个 耗时:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }
}
