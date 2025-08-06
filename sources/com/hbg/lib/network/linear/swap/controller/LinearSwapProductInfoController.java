package com.hbg.lib.network.linear.swap.controller;

import android.text.TextUtils;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapProductInfo;
import i8.n;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class LinearSwapProductInfoController {

    /* renamed from: f  reason: collision with root package name */
    public static volatile LinearSwapProductInfoController f70326f;

    /* renamed from: a  reason: collision with root package name */
    public final List<LinearSwapProductInfo> f70327a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<LinearSwapProductInfo> f70328b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f70329c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, LinearSwapProductInfo> f70330d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, LinearSwapProductInfo> f70331e = new HashMap();

    public class a implements Action1<List<LinearSwapProductInfo>> {
        public a() {
        }

        /* renamed from: a */
        public void call(List<LinearSwapProductInfo> list) {
            synchronized (LinearSwapProductInfoController.this.f70327a) {
                LinearSwapProductInfoController.this.f70327a.clear();
                LinearSwapProductInfoController.this.f70327a.addAll(list);
            }
            synchronized (LinearSwapProductInfoController.this.f70330d) {
                LinearSwapProductInfoController.this.f70330d.clear();
                for (LinearSwapProductInfo next : list) {
                    LinearSwapProductInfoController.this.f70330d.put(next.getSymbol(), next);
                }
            }
        }
    }

    public class b implements Func1<List<LinearSwapProductInfo>, Observable<LinearSwapProductInfo>> {
        public b() {
        }

        /* renamed from: a */
        public Observable<LinearSwapProductInfo> call(List<LinearSwapProductInfo> list) {
            return Observable.from(list);
        }
    }

    public class c implements Action1<List<LinearSwapProductInfo>> {
        public c() {
        }

        /* renamed from: a */
        public void call(List<LinearSwapProductInfo> list) {
            synchronized (LinearSwapProductInfoController.this.f70328b) {
                LinearSwapProductInfoController.this.f70328b.clear();
                LinearSwapProductInfoController.this.f70328b.addAll(list);
            }
            synchronized (LinearSwapProductInfoController.this.f70331e) {
                LinearSwapProductInfoController.this.f70331e.clear();
                for (LinearSwapProductInfo next : list) {
                    LinearSwapProductInfoController.this.f70331e.put(next.getSymbol(), next);
                }
            }
        }
    }

    public class d implements Func1<List<LinearSwapProductInfo>, Observable<LinearSwapProductInfo>> {
        public d() {
        }

        /* renamed from: a */
        public Observable<LinearSwapProductInfo> call(List<LinearSwapProductInfo> list) {
            return Observable.from(list);
        }
    }

    public class e implements Action1<List<String>> {
        public e() {
        }

        /* renamed from: a */
        public void call(List<String> list) {
            synchronized (LinearSwapProductInfoController.this.f70329c) {
                LinearSwapProductInfoController.this.f70329c.clear();
                LinearSwapProductInfoController.this.f70329c.addAll(list);
            }
        }
    }

    public static LinearSwapProductInfoController o() {
        if (f70326f == null) {
            synchronized (LinearSwapProductInfoController.class) {
                if (f70326f == null) {
                    f70326f = new LinearSwapProductInfoController();
                }
            }
        }
        return f70326f;
    }

    public List<LinearSwapProductInfo> g() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f70327a) {
            if (!this.f70327a.isEmpty()) {
                arrayList.addAll(this.f70327a);
            }
        }
        return arrayList;
    }

    public Observable<List<LinearSwapProductInfo>> h(boolean z11) {
        return (!z11 || this.f70327a.isEmpty()) ? h8.a.a().v().b().concatMap(new b()).toList().doOnNext(new a()) : Observable.just(this.f70327a);
    }

    public List<LinearSwapProductInfo> i() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f70328b) {
            if (!this.f70328b.isEmpty()) {
                arrayList.addAll(this.f70328b);
            }
        }
        return arrayList;
    }

    public Observable<List<LinearSwapProductInfo>> j(boolean z11) {
        return (!z11 || this.f70328b.isEmpty()) ? h8.a.a().x0().b().concatMap(new d()).toList().doOnNext(new c()) : Observable.just(this.f70328b);
    }

    public int k(String str, int i11) {
        LinearSwapProductInfo l11 = l(str);
        return l11 != null ? l11.getAmountPrecision() : i11;
    }

    public final LinearSwapProductInfo l(String str) {
        Map<String, LinearSwapProductInfo> map;
        if (str == null) {
            return null;
        }
        String upperCase = str.toUpperCase(Locale.US);
        if (this.f70330d.isEmpty() || !this.f70330d.containsKey(upperCase)) {
            map = (this.f70331e.isEmpty() || !this.f70331e.containsKey(upperCase)) ? null : this.f70331e;
        } else {
            map = this.f70330d;
        }
        if (map != null) {
            return map.get(upperCase);
        }
        return null;
    }

    public int m(String str, int i11) {
        LinearSwapProductInfo l11 = l(str);
        return l11 != null ? l11.getFeeAmountPrecision() : i11;
    }

    public int n(String str, int i11) {
        LinearSwapProductInfo l11 = l(str);
        return l11 != null ? l11.getFinancialAmountPrecision() : i11;
    }

    public int p(String str, int i11) {
        LinearSwapProductInfo l11 = l(str);
        return l11 != null ? l11.getOtherAmountPrecision() : i11;
    }

    public int q(String str, int i11) {
        LinearSwapProductInfo l11 = l(str);
        return l11 != null ? l11.getPricePrecision() : i11;
    }

    public int r(String str, int i11) {
        if (str == null) {
            return i11;
        }
        String str2 = null;
        LinearSwapProductInfo l11 = l(str);
        if (l11 != null) {
            str2 = l11.getPriceTick();
        }
        if (TextUtils.isEmpty(str2)) {
            return i11;
        }
        try {
            int indexOf = new BigDecimal(str2).toPlainString().indexOf("1");
            if (indexOf == -1) {
                return i11;
            }
            int i12 = indexOf - 1;
            if (i12 < 0) {
                i12 = 0;
            }
            return i12;
        } catch (Exception unused) {
            return i11;
        }
    }

    public LinearSwapProductInfo s(String str, boolean z11) {
        LinearSwapProductInfo linearSwapProductInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, LinearSwapProductInfo> map = z11 ? this.f70331e : this.f70330d;
        String upperCase = str.toUpperCase(Locale.US);
        synchronized (map) {
            linearSwapProductInfo = map.get(upperCase);
        }
        return linearSwapProductInfo;
    }

    public Observable<List<String>> t(boolean z11) {
        return (!z11 || this.f70329c.isEmpty()) ? h8.a.a().f0().b().concatMap(n.f55026b).toList().doOnNext(new e()) : Observable.just(this.f70329c);
    }
}
