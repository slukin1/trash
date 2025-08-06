package com.hbg.lib.network.option.controller;

import android.text.TextUtils;
import com.hbg.lib.network.option.core.bean.OptionProductInfo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

public class OptionProductInfoController {

    /* renamed from: c  reason: collision with root package name */
    public static volatile OptionProductInfoController f69251c;

    /* renamed from: a  reason: collision with root package name */
    public final List<OptionProductInfo> f69252a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, OptionProductInfo> f69253b = new HashMap();

    public class a implements Action1<List<OptionProductInfo>> {
        public a() {
        }

        /* renamed from: a */
        public void call(List<OptionProductInfo> list) {
            synchronized (OptionProductInfoController.this.f69252a) {
                OptionProductInfoController.this.f69252a.clear();
                OptionProductInfoController.this.f69252a.addAll(list);
            }
            synchronized (OptionProductInfoController.this.f69253b) {
                OptionProductInfoController.this.f69253b.clear();
                for (OptionProductInfo next : list) {
                    OptionProductInfoController.this.f69253b.put(next.getSymbol(), next);
                }
            }
        }
    }

    public class b implements Func2<OptionProductInfo, OptionProductInfo, Integer> {
        public b() {
        }

        /* renamed from: a */
        public Integer call(OptionProductInfo optionProductInfo, OptionProductInfo optionProductInfo2) {
            return Integer.valueOf(optionProductInfo.getSort() - optionProductInfo2.getSort());
        }
    }

    public class c implements Func1<List<OptionProductInfo>, Observable<OptionProductInfo>> {
        public c() {
        }

        /* renamed from: a */
        public Observable<OptionProductInfo> call(List<OptionProductInfo> list) {
            return Observable.from(list);
        }
    }

    public static OptionProductInfoController h() {
        if (f69251c == null) {
            synchronized (OptionProductInfoController.class) {
                if (f69251c == null) {
                    f69251c = new OptionProductInfoController();
                }
            }
        }
        return f69251c;
    }

    public List<OptionProductInfo> c() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f69252a) {
            if (!this.f69252a.isEmpty()) {
                arrayList.addAll(this.f69252a);
            }
        }
        return arrayList;
    }

    public Observable<List<OptionProductInfo>> d(boolean z11) {
        return (!z11 || this.f69252a.isEmpty()) ? p8.a.a().getProductInfo("").b().concatMap(new c()).sorted(new b()).toList().doOnNext(new a()) : Observable.just(this.f69252a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = r1.f69253b.get(r2.toUpperCase(java.util.Locale.US));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int e(java.lang.String r2, int r3) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001f
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r2 = r2.toUpperCase(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            java.lang.Object r2 = r0.get(r2)
            com.hbg.lib.network.option.core.bean.OptionProductInfo r2 = (com.hbg.lib.network.option.core.bean.OptionProductInfo) r2
            if (r2 == 0) goto L_0x001f
            int r3 = r2.getAmountPrecision()
        L_0x001f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.option.controller.OptionProductInfoController.e(java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = r1.f69253b.get(r2.toUpperCase(java.util.Locale.US));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int f(java.lang.String r2, int r3) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001f
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r2 = r2.toUpperCase(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            java.lang.Object r2 = r0.get(r2)
            com.hbg.lib.network.option.core.bean.OptionProductInfo r2 = (com.hbg.lib.network.option.core.bean.OptionProductInfo) r2
            if (r2 == 0) goto L_0x001f
            int r3 = r2.getFeeAmountPrecision()
        L_0x001f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.option.controller.OptionProductInfoController.f(java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = r1.f69253b.get(r2.toUpperCase(java.util.Locale.US));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int g(java.lang.String r2, int r3) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001f
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r2 = r2.toUpperCase(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            java.lang.Object r2 = r0.get(r2)
            com.hbg.lib.network.option.core.bean.OptionProductInfo r2 = (com.hbg.lib.network.option.core.bean.OptionProductInfo) r2
            if (r2 == 0) goto L_0x001f
            int r3 = r2.getFinancialAmountPrecision()
        L_0x001f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.option.controller.OptionProductInfoController.g(java.lang.String, int):int");
    }

    public int i(String str, int i11) {
        OptionProductInfo optionProductInfo;
        if (str == null) {
            return i11;
        }
        String str2 = null;
        if (!this.f69253b.isEmpty() && (optionProductInfo = this.f69253b.get(str.toUpperCase(Locale.US))) != null) {
            str2 = optionProductInfo.getIndexPriceTick();
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

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = r1.f69253b.get(r2.toUpperCase(java.util.Locale.US));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int j(java.lang.String r2, int r3) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001f
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r2 = r2.toUpperCase(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            java.lang.Object r2 = r0.get(r2)
            com.hbg.lib.network.option.core.bean.OptionProductInfo r2 = (com.hbg.lib.network.option.core.bean.OptionProductInfo) r2
            if (r2 == 0) goto L_0x001f
            int r3 = r2.getOptionPricePrecision()
        L_0x001f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.option.controller.OptionProductInfoController.j(java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = r1.f69253b.get(r2.toUpperCase(java.util.Locale.US));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int k(java.lang.String r2, int r3) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001f
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r2 = r2.toUpperCase(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            java.lang.Object r2 = r0.get(r2)
            com.hbg.lib.network.option.core.bean.OptionProductInfo r2 = (com.hbg.lib.network.option.core.bean.OptionProductInfo) r2
            if (r2 == 0) goto L_0x001f
            int r3 = r2.getOtherAmountPrecision()
        L_0x001f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.option.controller.OptionProductInfoController.k(java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = r1.f69253b.get(r2.toUpperCase(java.util.Locale.US));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int l(java.lang.String r2, int r3) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001f
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r2 = r2.toUpperCase(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.option.core.bean.OptionProductInfo> r0 = r1.f69253b
            java.lang.Object r2 = r0.get(r2)
            com.hbg.lib.network.option.core.bean.OptionProductInfo r2 = (com.hbg.lib.network.option.core.bean.OptionProductInfo) r2
            if (r2 == 0) goto L_0x001f
            int r3 = r2.getPricePrecision()
        L_0x001f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.option.controller.OptionProductInfoController.l(java.lang.String, int):int");
    }

    public OptionProductInfo m(String str) {
        OptionProductInfo optionProductInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String upperCase = str.toUpperCase(Locale.US);
        synchronized (this.f69253b) {
            optionProductInfo = this.f69253b.get(upperCase);
        }
        return optionProductInfo;
    }

    public List<String> n() {
        ArrayList arrayList = new ArrayList();
        if (this.f69252a.size() > 0) {
            for (OptionProductInfo next : this.f69252a) {
                if (next.getIsTrade() == 1) {
                    arrayList.add(next.getSymbol());
                }
            }
        }
        return arrayList;
    }
}
