package com.hbg.lib.network.option.controller;

import android.text.TextUtils;
import com.hbg.lib.network.option.core.bean.OptionCurrencyInfo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;

public class OptionCurrencyInfoController {

    /* renamed from: c  reason: collision with root package name */
    public static volatile OptionCurrencyInfoController f69242c;

    /* renamed from: a  reason: collision with root package name */
    public final List<OptionCurrencyInfo> f69243a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, OptionCurrencyInfo> f69244b = new HashMap();

    public class a implements Action1<List<OptionCurrencyInfo>> {
        public a() {
        }

        /* renamed from: a */
        public void call(List<OptionCurrencyInfo> list) {
            synchronized (OptionCurrencyInfoController.this.f69243a) {
                OptionCurrencyInfoController.this.f69243a.clear();
                OptionCurrencyInfoController.this.f69243a.addAll(list);
            }
            synchronized (OptionCurrencyInfoController.this.f69244b) {
                OptionCurrencyInfoController.this.f69244b.clear();
                for (OptionCurrencyInfo next : list) {
                    OptionCurrencyInfoController.this.f69244b.put(next.getOptionCode(), next);
                }
            }
        }
    }

    public static OptionCurrencyInfoController i() {
        if (f69242c == null) {
            synchronized (OptionCurrencyInfoController.class) {
                if (f69242c == null) {
                    f69242c = new OptionCurrencyInfoController();
                }
            }
        }
        return f69242c;
    }

    public int c(String str, int i11) {
        OptionCurrencyInfo optionCurrencyInfo;
        if (str == null) {
            return i11;
        }
        String str2 = null;
        synchronized (this.f69244b) {
            if (!this.f69244b.isEmpty() && (optionCurrencyInfo = this.f69244b.get(str)) != null) {
                str2 = optionCurrencyInfo.getContractFace();
            }
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

    public int d(String str, int i11) {
        if (str == null) {
            return i11;
        }
        String str2 = null;
        synchronized (this.f69243a) {
            if (!this.f69243a.isEmpty()) {
                Iterator<OptionCurrencyInfo> it2 = this.f69243a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    OptionCurrencyInfo next = it2.next();
                    if (next != null) {
                        if (next.getSymbol() != null) {
                            if (next.getSymbol().equalsIgnoreCase(str)) {
                                str2 = next.getContractFace();
                                break;
                            }
                        }
                    }
                }
            }
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

    public Observable<List<OptionCurrencyInfo>> e(boolean z11) {
        return (!z11 || this.f69243a.isEmpty()) ? p8.a.a().o("", "", "", "").b().doOnNext(new a()) : Observable.just(this.f69243a);
    }

    public int f(String str, int i11) {
        OptionCurrencyInfo optionCurrencyInfo;
        if (str == null) {
            return i11;
        }
        synchronized (this.f69244b) {
            if (!this.f69244b.isEmpty() && (optionCurrencyInfo = this.f69244b.get(str)) != null) {
                i11 = optionCurrencyInfo.getFeeAmountPrecision();
            }
        }
        return i11;
    }

    public int g(String str, int i11) {
        if (str == null) {
            return i11;
        }
        synchronized (this.f69243a) {
            if (!this.f69243a.isEmpty()) {
                Iterator<OptionCurrencyInfo> it2 = this.f69243a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    OptionCurrencyInfo next = it2.next();
                    if (next != null) {
                        if (next.getSymbol() != null) {
                            if (next.getSymbol().equalsIgnoreCase(str)) {
                                i11 = next.getFeeAmountPrecision();
                                break;
                            }
                        }
                    }
                }
            }
        }
        return i11;
    }

    public Observable<List<OptionCurrencyInfo>> h(String str, String str2, String str3, String str4) {
        return p8.a.a().o(str, str2, str3, str4).b();
    }

    public OptionCurrencyInfo j(String str) {
        OptionCurrencyInfo optionCurrencyInfo;
        synchronized (this.f69244b) {
            optionCurrencyInfo = this.f69244b.get(str);
        }
        return optionCurrencyInfo;
    }

    public int k(String str, int i11) {
        OptionCurrencyInfo optionCurrencyInfo;
        if (str == null) {
            return i11;
        }
        synchronized (this.f69244b) {
            if (!this.f69244b.isEmpty() && (optionCurrencyInfo = this.f69244b.get(str)) != null) {
                i11 = optionCurrencyInfo.getOtherAmountPrecision();
            }
        }
        return i11;
    }

    public int l(String str, int i11) {
        if (str == null) {
            return i11;
        }
        synchronized (this.f69243a) {
            if (!this.f69243a.isEmpty()) {
                Iterator<OptionCurrencyInfo> it2 = this.f69243a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    OptionCurrencyInfo next = it2.next();
                    if (next != null) {
                        if (next.getSymbol() != null) {
                            if (next.getSymbol().equalsIgnoreCase(str)) {
                                i11 = next.getOtherAmountPrecision();
                                break;
                            }
                        }
                    }
                }
            }
        }
        return i11;
    }

    public int m(String str, int i11) {
        OptionCurrencyInfo optionCurrencyInfo;
        if (str == null) {
            return i11;
        }
        String str2 = null;
        synchronized (this.f69244b) {
            if (!this.f69244b.isEmpty() && (optionCurrencyInfo = this.f69244b.get(str)) != null) {
                str2 = optionCurrencyInfo.getPriceTick();
            }
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

    public int n(String str, int i11) {
        if (str == null) {
            return i11;
        }
        String str2 = null;
        synchronized (this.f69243a) {
            if (!this.f69243a.isEmpty()) {
                Iterator<OptionCurrencyInfo> it2 = this.f69243a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    OptionCurrencyInfo next = it2.next();
                    if (next != null) {
                        if (next.getContractShortType() != null) {
                            if (next.getContractShortType().equalsIgnoreCase(str)) {
                                str2 = next.getPriceTick();
                                break;
                            }
                        }
                    }
                }
            }
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

    public int o(String str, int i11) {
        if (str == null) {
            return i11;
        }
        String str2 = null;
        synchronized (this.f69243a) {
            if (!this.f69243a.isEmpty()) {
                Iterator<OptionCurrencyInfo> it2 = this.f69243a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    OptionCurrencyInfo next = it2.next();
                    if (next != null) {
                        if (next.getSymbol() != null) {
                            if (next.getSymbol().equalsIgnoreCase(str)) {
                                str2 = next.getPriceTick();
                                break;
                            }
                        }
                    }
                }
            }
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
}
