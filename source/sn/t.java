package sn;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.homemarket.bean.CollectionMultiple;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.xiaomi.mipush.sdk.Constants;
import i6.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import pro.huobi.R;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.observables.SyncOnSubscribe;
import td.g;
import tg.r;
import tq.p;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f76554a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f76555b;

    public class a extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f76556b;

        public a(g gVar) {
            this.f76556b = gVar;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            g gVar = this.f76556b;
            if (gVar != null) {
                gVar.a(true, (Throwable) null);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (this.f76556b != null) {
                HuobiToastUtil.s(R.string.market_delete_collection_failed);
                this.f76556b.a(false, th2);
            }
        }
    }

    public class b extends SyncOnSubscribe<String, List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f76557b;

        public b(Context context) {
            this.f76557b = context;
        }

        /* renamed from: a */
        public String generateState() {
            return "TradingPairCollectionUtils";
        }

        /* renamed from: b */
        public String next(String str, Observer<? super List<String>> observer) {
            observer.onNext(br.c.g(this.f76557b).i());
            observer.onCompleted();
            return str;
        }
    }

    public class c extends SyncOnSubscribe<String, List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f76558b;

        public c(Context context) {
            this.f76558b = context;
        }

        /* renamed from: a */
        public String generateState() {
            return "TradingPairCollectionUtils";
        }

        /* renamed from: b */
        public String next(String str, Observer<? super List<String>> observer) {
            observer.onNext(br.c.g(this.f76558b).i());
            observer.onCompleted();
            return str;
        }
    }

    public class d implements Action1<Throwable> {
        /* renamed from: a */
        public void call(Throwable th2) {
            k.j("trading_pair/multiple/list", th2);
        }
    }

    public static /* synthetic */ List A(List list) {
        List<String> q11 = q(list);
        f76554a = q11;
        return q11;
    }

    public static /* synthetic */ Observable B(Context context, List list) {
        List<String> q11 = q(list);
        f76554a = q11;
        f76555b = q11;
        return br.c.g(context).k(f76554a);
    }

    public static /* synthetic */ List D(List list) {
        List<String> q11 = q(list);
        f76554a = q11;
        return q11;
    }

    public static void E(List<String> list, Context context) {
        for (String next : list) {
            br.c.g(context).l(next);
            List<String> list2 = f76554a;
            if (list2 != null && !list2.contains(next)) {
                f76554a.add(0, next);
            }
        }
    }

    public static Observable<Object> h(String str, Context context) {
        return i(str, context, "PRO");
    }

    public static Observable<Object> i(String str, Context context, String str2) {
        if (r.x().F0()) {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.WEBSITE, str2);
            hashMap.put("trading_pair", str);
            return UserCenterRemoteDataSource.A().addTradingPair(hashMap).compose(p.c0()).map(new o(str, context));
        }
        br.c.g(context).l(str);
        List<String> list = f76554a;
        if (list != null && !list.contains(str)) {
            f76554a.add(0, str);
        }
        return Observable.just(new Object());
    }

    public static Observable<Object> j(List<String> list, Context context, String str) {
        if (r.x().F0()) {
            HashMap hashMap = new HashMap();
            hashMap.put("tradingPairs", list);
            hashMap.put(PlaceFields.WEBSITE, str);
            return UserCenterRemoteDataSource.A().addMultipleTradingPair(hashMap).compose(p.c0()).map(new p(list, context));
        }
        for (String next : list) {
            br.c.g(context).l(next);
            List<String> list2 = f76554a;
            if (list2 != null && !list2.contains(next)) {
                f76554a.add(0, next);
            }
        }
        return Observable.just(new Object());
    }

    public static Observable<Object> k(String str, Context context) {
        return l(str, context, "PRO");
    }

    public static Observable<Object> l(String str, Context context, String str2) {
        if (r.x().F0()) {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.WEBSITE, str2);
            hashMap.put("trading_pair", str);
            return UserCenterRemoteDataSource.A().cancelTradingPair(hashMap).compose(p.c0()).map(new n(str, context));
        }
        br.c.g(context).e(str);
        List<String> list = f76554a;
        if (list != null && list.contains(str)) {
            f76554a.remove(str);
        }
        return Observable.just(new Object());
    }

    public static void m() {
        List<String> list = f76554a;
        if (list != null) {
            list.clear();
        }
        List<String> list2 = f76555b;
        if (list2 != null) {
            list2.clear();
        }
    }

    public static void n(List<String> list) {
        List<String> list2;
        f76554a.clear();
        f76554a.addAll(list);
        if (r.x().F0() && (list2 = f76555b) != null) {
            list2.clear();
            f76555b.addAll(list);
        }
    }

    public static void o(String str, g gVar) {
        if (r.x().F0()) {
            v7.b.a().delStare(str).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a(gVar));
        } else if (gVar != null) {
            gVar.a(true, (Throwable) null);
        }
    }

    public static Observable<Object> p(List<CollectionMultiple> list, Context context) {
        if (r.x().F0()) {
            HashMap hashMap = new HashMap();
            hashMap.put("trading_pairs", list.toArray());
            return UserCenterRemoteDataSource.A().r(hashMap).compose(p.c0());
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (CollectionMultiple tradingPair : list) {
                arrayList.add(tradingPair.getTradingPair());
            }
        }
        return br.c.g(context).k(arrayList);
    }

    public static List<String> q(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!next.endsWith("_INDEX")) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static List<String> r() {
        return f76554a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0062, code lost:
        r2 = f76554a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static rx.Observable<java.util.List<java.lang.String>> s(boolean r2, android.content.Context r3) {
        /*
            tg.r r0 = tg.r.x()
            boolean r0 = r0.F0()
            if (r0 != 0) goto L_0x001a
            sn.t$c r0 = new sn.t$c
            r0.<init>(r3)
            rx.Observable r3 = rx.Observable.create(r0)
            sn.q r0 = sn.q.f70175b
            rx.Observable r3 = r3.map(r0)
            goto L_0x0060
        L_0x001a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "PRO"
            r0.add(r1)
            java.lang.String r1 = "CONTRACT"
            r0.add(r1)
            java.lang.String r1 = "CONTRACT_SWAP"
            r0.add(r1)
            java.lang.String r1 = "LINEAR_SWAP"
            r0.add(r1)
            java.lang.String r1 = "FUTURES_INDEX"
            r0.add(r1)
            com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource r1 = com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource.A()
            rx.Observable r0 = r1.C(r0)
            rx.Observable$Transformer r1 = tq.p.c0()
            rx.Observable r0 = r0.compose(r1)
            sn.m r1 = new sn.m
            r1.<init>(r3)
            rx.Observable r3 = r0.flatMap(r1)
            sn.s r0 = sn.s.f70177b
            rx.Observable r3 = r3.flatMap(r0)
            sn.t$d r0 = new sn.t$d
            r0.<init>()
            rx.Observable r3 = r3.doOnError(r0)
        L_0x0060:
            if (r2 == 0) goto L_0x006b
            java.util.List<java.lang.String> r2 = f76554a
            if (r2 == 0) goto L_0x006b
            rx.Observable r2 = rx.Observable.just(r2)
            return r2
        L_0x006b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sn.t.s(boolean, android.content.Context):rx.Observable");
    }

    public static List<String> t(Context context) {
        List<String> q11 = q(br.c.g(context).i());
        f76554a = q11;
        return q11;
    }

    public static Observable<List<String>> u(boolean z11, Context context) {
        return Observable.create(new b(context)).map(r.f70176b);
    }

    public static String v(String str) {
        if (str.endsWith("-Index")) {
            return "FUTURES_INDEX";
        }
        if (str.contains("_")) {
            return "CONTRACT";
        }
        if (!str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return "PRO";
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split.length != 2 || !"USD".equals(split[1])) {
            return (split.length == 2 || split.length == 3) ? "LINEAR_SWAP" : "PRO";
        }
        return "CONTRACT_SWAP";
    }

    public static boolean w(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && (list = f76554a) != null && list.contains(str)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ Object x(String str, Context context, Object obj) {
        List<String> list = f76554a;
        if (list != null && !list.contains(str)) {
            f76554a.add(0, str);
        }
        if (f76555b == null) {
            f76555b = new ArrayList();
        }
        if (!f76555b.contains(str)) {
            f76555b.add(0, str);
        }
        br.c.g(context).l(str);
        return obj;
    }

    public static /* synthetic */ Object y(List list, Context context, Object obj) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            List<String> list2 = f76554a;
            if (list2 != null && !list2.contains(str)) {
                f76554a.add(0, str);
            }
            if (f76555b == null) {
                f76555b = new ArrayList();
            }
            if (!f76555b.contains(str)) {
                f76555b.add(0, str);
            }
            br.c.g(context).l(str);
        }
        return obj;
    }

    public static /* synthetic */ Object z(String str, Context context, Object obj) {
        List<String> list = f76554a;
        if (list != null) {
            list.remove(str);
        }
        List<String> list2 = f76555b;
        if (list2 != null) {
            list2.remove(str);
        }
        br.c.g(context).e(str);
        return 0;
    }
}
