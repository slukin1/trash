package com.hbg.lib.data.symbol;

import com.hbg.lib.network.pro.core.bean.SuperMarginSymbol;
import com.hbg.lib.network.pro.db.ProDbHelper;
import com.hbg.lib.network.pro.db.SuperMarginSymbolDbHelper;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import d7.b1;
import d7.r0;
import d7.s0;
import d7.t0;
import d7.u0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class SuperMarginSymbolConfigUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f68856a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final List<SuperMarginSymbol> f68857b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, SuperMarginSymbol> f68858c = new HashMap();

    public class a extends BaseSubscriber<List<SuperMarginSymbol>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Subscriber f68859b;

        public a(Subscriber subscriber) {
            this.f68859b = subscriber;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f68859b.onNext(SuperMarginSymbolConfigUtil.i());
            this.f68859b.onCompleted();
        }

        public void onNext(List<SuperMarginSymbol> list) {
            this.f68859b.onNext(list);
            this.f68859b.onCompleted();
        }
    }

    public static void e() {
        SuperMarginSymbolDbHelper.g();
        synchronized (f68856a) {
            f68857b.clear();
            f68858c.clear();
        }
    }

    public static Map<String, SuperMarginSymbol> f() {
        HashMap hashMap;
        synchronized (f68856a) {
            hashMap = new HashMap(f68858c);
        }
        return hashMap;
    }

    public static Observable<List<SuperMarginSymbol>> g(boolean z11) {
        return Observable.create(new r0(z11));
    }

    public static String h() {
        return b1.a().b().b();
    }

    public static List<SuperMarginSymbol> i() {
        ArrayList arrayList;
        synchronized (f68856a) {
            arrayList = new ArrayList(f68857b);
        }
        return arrayList;
    }

    public static boolean j() {
        return !f68857b.isEmpty();
    }

    public static void k(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        List<SuperMarginSymbol> h11 = SuperMarginSymbolDbHelper.h(str);
        RetrofitLogger.a("SuperMarginSymbolConfigUtil-->initLocalData--> key: " + str + " 本地有: " + h11.size() + " 个 耗时:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        if (!h11.isEmpty()) {
            p(h11, str);
        }
    }

    public static /* synthetic */ void o(boolean z11, Subscriber subscriber) {
        String h11 = h();
        if (!z11 || !j()) {
            List arrayList = new ArrayList();
            if (!j()) {
                k(h11);
                if (j()) {
                    arrayList = i();
                }
            }
            if (arrayList.isEmpty()) {
                x8.a.a().getSuperMarginSymbols().b().onErrorReturn(u0.f53535b).doOnNext(new s0(h11)).subscribeOn(Schedulers.io()).subscribe(new a(subscriber));
                return;
            }
            subscriber.onNext(arrayList);
            subscriber.onCompleted();
            x8.a.a().getSuperMarginSymbols().b().doOnNext(new t0(h11)).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new BaseSubscriber());
            return;
        }
        subscriber.onNext(i());
        subscriber.onCompleted();
    }

    public static void p(List<SuperMarginSymbol> list, String str) {
        if (list != null) {
            synchronized (f68856a) {
                List<SuperMarginSymbol> list2 = f68857b;
                list2.clear();
                list2.addAll(list);
                f68858c.clear();
                for (SuperMarginSymbol next : list) {
                    next.setKey(str);
                    f68858c.put(next.getSymbol(), next);
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ProDbHelper.d(list);
            RetrofitLogger.a("SuperMarginSymbolConfigUtil-->setSymbolList--> key: " + str + " 插入: " + list.size() + " 个 耗时:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }
}
