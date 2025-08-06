package d7;

import ad.i;
import com.hbg.lib.data.main.CurrencyDataDiffTools;
import com.hbg.lib.data.symbol.ProCurrenciesUtil;
import com.hbg.lib.network.hbg.core.bean.PioneerActivityLimit;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import d9.a;
import gj.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.schedulers.Schedulers;
import x7.f;

public class q0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f68994a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static List<CurrencyBean> f68995b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, CurrencyBean> f68996c = new HashMap();

    public static void e() {
        q((List<CurrencyBean>) null);
    }

    public static Observable<List<CurrencyBean>> f(boolean z11, String str) {
        if (!z11 || !j()) {
            try {
                Observable<List<PioneerActivityLimit>> just = Observable.just(null);
                if (b1.a().b().a()) {
                    just = f.b(z11);
                }
                return Observable.zip(CurrencyDataDiffTools.r().j().subscribeOn(Schedulers.io()), just.subscribeOn(Schedulers.io()).onErrorResumeNext(Observable.just(null)), p0.f53526b).flatMap(i.f3526b).filter(m0.f53517b).doOnNext(l0.f53516b).sorted(o0.f53524b).toList().map(n0.f53520b);
            } catch (Exception e11) {
                e11.printStackTrace();
                return Observable.just(new ArrayList());
            }
        } else {
            List<CurrencyBean> g11 = g();
            for (CurrencyBean next : g11) {
                if (next != null) {
                    f68996c.put(next.getName(), next);
                }
            }
            return Observable.just(g11);
        }
    }

    public static List<CurrencyBean> g() {
        return new ArrayList(f68995b);
    }

    public static Map<String, CurrencyBean> h() {
        return new HashMap(f68996c);
    }

    public static int i(String str) {
        CurrencyBean currencyBean = f68996c.get(str);
        if (currencyBean == null) {
            return 0;
        }
        try {
            return Integer.parseInt(currencyBean.getWeight());
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static boolean j() {
        return !f68995b.isEmpty();
    }

    public static void k() {
        List<CurrencyBean> c11 = ProCurrenciesUtil.c();
        if (!c11.isEmpty()) {
            q(c11);
        }
        RetrofitLogger.a("ProCurrencyProvider-->initLocalData-->本地有" + c11.size() + "个");
    }

    public static /* synthetic */ List l(List list, List list2) {
        return list;
    }

    public static void p(boolean z11, String str, RequestCallback1<List<CurrencyBean>> requestCallback1) {
        if (!z11 || requestCallback1 == null || !j()) {
            if (!j()) {
                k();
                if (requestCallback1 != null && j()) {
                    new a(Observable.just(g())).d(requestCallback1);
                }
            }
            new a(f(false, str)).d(requestCallback1);
            return;
        }
        new a(Observable.just(g())).d(requestCallback1);
    }

    public static void q(List<CurrencyBean> list) {
        RetrofitLogger.a("ProCurrencyProvider-->setDataList-->" + list);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (CurrencyBean next : list) {
                if (d.n().G() || !next.isEtpTag()) {
                    arrayList.add(next);
                }
            }
            synchronized (f68994a) {
                f68995b.clear();
                f68995b.addAll(arrayList);
            }
        } else {
            f68995b.clear();
            f68996c.clear();
        }
        ProCurrenciesUtil.d(list);
    }
}
