package ks;

import ad.i;
import com.hbg.lib.common.utils.StringUtils;
import com.huobi.supermargin.bean.LoanCurrency;
import com.huobi.supermargin.bean.MarginCurrency;
import com.huobi.supermargin.service.SuperMarginService;
import d7.k;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import tq.p;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static List<MarginCurrency> f84425a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static Map<Long, List<LoanCurrency>> f84426b = new HashMap();

    public class a implements Func1<List<MarginCurrency>, List<MarginCurrency>> {
        /* renamed from: a */
        public List<MarginCurrency> call(List<MarginCurrency> list) {
            d.f84425a.clear();
            d.f84425a.addAll(list);
            return list;
        }
    }

    public class b implements Func2<MarginCurrency, MarginCurrency, Integer> {
        /* renamed from: a */
        public Integer call(MarginCurrency marginCurrency, MarginCurrency marginCurrency2) {
            try {
                return Integer.valueOf(Integer.valueOf(m.k0(k.C().H(StringUtils.g(marginCurrency2.getCurrency())))).compareTo(Integer.valueOf(m.k0(k.C().H(StringUtils.g(marginCurrency.getCurrency()))))));
            } catch (Exception e11) {
                e11.printStackTrace();
                return 0;
            }
        }
    }

    public class c implements Func1<MarginCurrency, Boolean> {
        /* renamed from: a */
        public Boolean call(MarginCurrency marginCurrency) {
            if (marginCurrency == null) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(k.C().J(StringUtils.g(marginCurrency.getCurrency())));
        }
    }

    /* renamed from: ks.d$d  reason: collision with other inner class name */
    public class C0874d implements Action1<List<LoanCurrency>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Long f84427b;

        public C0874d(Long l11) {
            this.f84427b = l11;
        }

        /* renamed from: a */
        public void call(List<LoanCurrency> list) {
            if (this.f84427b != null) {
                d.f84426b.put(this.f84427b, list);
            }
        }
    }

    public class e implements Func2<LoanCurrency, LoanCurrency, Integer> {
        /* renamed from: a */
        public Integer call(LoanCurrency loanCurrency, LoanCurrency loanCurrency2) {
            try {
                return Integer.valueOf(Integer.valueOf(m.k0(k.C().H(StringUtils.g(loanCurrency2.getCurrency())))).compareTo(Integer.valueOf(m.k0(k.C().H(StringUtils.g(loanCurrency.getCurrency()))))));
            } catch (Exception e11) {
                e11.printStackTrace();
                return 0;
            }
        }
    }

    public class f implements Func1<LoanCurrency, Boolean> {
        /* renamed from: a */
        public Boolean call(LoanCurrency loanCurrency) {
            if (loanCurrency == null) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(k.C().J(StringUtils.g(loanCurrency.getCurrency())));
        }
    }

    public static Observable<List<LoanCurrency>> e(Long l11, boolean z11) {
        HashMap hashMap = new HashMap();
        if (l11 != null) {
            hashMap.put("account-id", l11);
        }
        Observable<List<R>> doOnNext = ((SuperMarginService) p.W(SuperMarginService.class)).getLoanCurrencies(hashMap).compose(p.a0()).flatMap(i.f3526b).filter(new f()).sorted(new e()).toList().doOnNext(new C0874d(l11));
        return z11 ? Observable.concat(Observable.just(f84426b.get(l11)), doOnNext).takeFirst(c.f57983b) : doOnNext;
    }

    public static List<MarginCurrency> f() {
        return f84425a;
    }

    public static Observable<List<MarginCurrency>> g(boolean z11) {
        Observable<R> map = ((SuperMarginService) p.W(SuperMarginService.class)).marginCurrencies().compose(p.a0()).flatMap(i.f3526b).filter(new c()).sorted(new b()).toList().map(new a());
        return z11 ? Observable.concat(Observable.just(f84425a), map).takeFirst(b.f57982b) : map;
    }

    public static /* synthetic */ Boolean h(List list) {
        return Boolean.valueOf(list != null);
    }

    public static /* synthetic */ Boolean i(List list) {
        return Boolean.valueOf(list != null);
    }
}
