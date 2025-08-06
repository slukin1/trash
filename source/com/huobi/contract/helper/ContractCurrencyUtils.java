package com.huobi.contract.helper;

import android.text.TextUtils;
import bj.e;
import bj.n;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.huobi.contract.entity.ContractCoinInfo;
import com.huobi.contract.entity.ContractLightLimitLevel;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import rx.Observable;

public class ContractCurrencyUtils {

    /* renamed from: a  reason: collision with root package name */
    public static e f43110a = new ContractCurrencyConfigImpl();

    public static int A(String str, int i11) {
        int indexOf;
        if (str == null) {
            return i11;
        }
        String str2 = null;
        List<ContractCurrencyInfo> g11 = f43110a.g();
        if (g11 != null && !g11.isEmpty()) {
            Iterator<ContractCurrencyInfo> it2 = g11.iterator();
            while (true) {
                if (it2.hasNext()) {
                    ContractCurrencyInfo next = it2.next();
                    if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                        str2 = next.getPriceTick();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(str2) || (indexOf = str2.indexOf("1")) == -1) {
            return i11;
        }
        int i12 = indexOf - 1;
        if (i12 < 0) {
            return 0;
        }
        return i12;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ rx.Observable B(java.lang.String r5, java.util.List r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L_0x0043
            if (r6 == 0) goto L_0x0043
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x0043
            java.util.Iterator r0 = r6.iterator()
        L_0x0013:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r0.next()
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r2 = (com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo) r2
            if (r2 != 0) goto L_0x0022
            goto L_0x0013
        L_0x0022:
            java.lang.String r3 = r2.getSymbol()
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0013
            java.lang.String r3 = r2.getContractType()
            java.lang.String r4 = "quarter"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0013
            r1 = r2
        L_0x0039:
            if (r1 != 0) goto L_0x0043
            r5 = 0
            java.lang.Object r5 = r6.get(r5)
            r1 = r5
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r1 = (com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo) r1
        L_0x0043:
            if (r1 == 0) goto L_0x004a
            rx.Observable r5 = rx.Observable.just(r1)
            goto L_0x004e
        L_0x004a:
            rx.Observable r5 = rx.Observable.empty()
        L_0x004e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.helper.ContractCurrencyUtils.B(java.lang.String, java.util.List):rx.Observable");
    }

    public static ContractCurrencyInfo b(String str) {
        List<ContractCurrencyInfo> m11;
        if (TextUtils.isEmpty(str) || (m11 = m()) == null) {
            return null;
        }
        for (int i11 = 0; i11 < m11.size(); i11++) {
            if (str.equals(m11.get(i11).getContractShortType()) || str.equals(m11.get(i11).getContractCode())) {
                return m11.get(i11);
            }
        }
        return null;
    }

    public static int c(String str, int i11) {
        return f43110a.q(str, i11);
    }

    public static List<ContractCoinInfo> d() {
        return f43110a.l();
    }

    public static List<ContractCoinInfo> e() {
        return f43110a.j();
    }

    public static Observable<List<ContractCoinInfo>> f(boolean z11, String str) {
        return f43110a.i(z11, str);
    }

    public static Observable<List<ContractCurrencyInfo>> g(boolean z11) {
        return f43110a.h(z11);
    }

    public static ContractCurrencyInfo h(String str) {
        return f43110a.e(str);
    }

    public static String i(String str) {
        List<ContractCurrencyInfo> m11 = m();
        if (m11 == null) {
            return "0";
        }
        for (ContractCurrencyInfo next : m11) {
            if (next != null && next.getSymbol().equals(str)) {
                return next.getContractFace();
            }
        }
        return "0";
    }

    public static Observable<ContractCurrencyInfo> j(boolean z11, String str) {
        if (str == null) {
            return Observable.empty();
        }
        return g(z11).flatMap(new n(str));
    }

    public static List<ContractCurrencyInfo> k() {
        return f43110a.p();
    }

    public static LinkedHashSet<String> l() {
        return f43110a.k();
    }

    public static List<ContractCurrencyInfo> m() {
        return f43110a.g();
    }

    public static Observable<List<ContractCurrencyInfo>> n(boolean z11) {
        return f43110a.o(z11);
    }

    public static int o(String str, int i11) {
        return f43110a.d(str, i11);
    }

    public static ContractCurrencyInfo p() {
        return f43110a.f();
    }

    public static Observable<Map<String, ContractLightLimitLevel>> q(boolean z11) {
        return f43110a.m(z11);
    }

    public static int r(String str, int i11) {
        return f43110a.c(str, i11);
    }

    public static int s(String str, int i11) {
        return f43110a.n(str, i11);
    }

    public static int t(String str, int i11) {
        int indexOf;
        if (str == null) {
            return i11;
        }
        String str2 = null;
        List<ContractCoinInfo> j11 = f43110a.j();
        if (j11 != null && !j11.isEmpty()) {
            Iterator<ContractCoinInfo> it2 = j11.iterator();
            while (true) {
                if (it2.hasNext()) {
                    ContractCoinInfo next = it2.next();
                    if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                        str2 = next.getPriceTick();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(str2) || (indexOf = str2.indexOf("1")) == -1) {
            return i11;
        }
        int i12 = indexOf - 1;
        if (i12 < 0) {
            return 0;
        }
        return i12;
    }

    public static int u(String str, int i11) {
        List<ContractCurrencyInfo> g11 = f43110a.g();
        if (str == null || g11 == null || g11.isEmpty()) {
            return i11;
        }
        for (ContractCurrencyInfo next : g11) {
            if (next != null && next.getContractCode() != null && next.getContractCode().equalsIgnoreCase(str)) {
                return next.getFeeAmountPrecision();
            }
        }
        return i11;
    }

    public static int v(String str, int i11) {
        List<ContractCurrencyInfo> g11 = f43110a.g();
        if (str == null || g11 == null || g11.isEmpty()) {
            return i11;
        }
        for (ContractCurrencyInfo next : g11) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getFeeAmountPrecision();
            }
        }
        return i11;
    }

    public static int w(String str, int i11) {
        List<ContractCurrencyInfo> g11 = f43110a.g();
        if (str == null || g11 == null || g11.isEmpty()) {
            return i11;
        }
        for (ContractCurrencyInfo next : g11) {
            if (next != null && next.getContractCode() != null && next.getContractCode().equalsIgnoreCase(str)) {
                return next.getOtherAmountPrecision();
            }
        }
        return i11;
    }

    public static int x(String str, int i11) {
        List<ContractCurrencyInfo> g11 = f43110a.g();
        if (str == null || g11 == null || g11.isEmpty()) {
            return i11;
        }
        for (ContractCurrencyInfo next : g11) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getOtherAmountPrecision();
            }
        }
        return i11;
    }

    public static int y(String str, int i11) {
        return f43110a.b(str, i11);
    }

    public static int z(String str, int i11) {
        int indexOf;
        if (str == null) {
            return i11;
        }
        String str2 = null;
        List<ContractCurrencyInfo> g11 = f43110a.g();
        if (g11 != null && !g11.isEmpty()) {
            Iterator<ContractCurrencyInfo> it2 = g11.iterator();
            while (true) {
                if (it2.hasNext()) {
                    ContractCurrencyInfo next = it2.next();
                    if (next != null && next.getSymbol() != null && next.getContractShortType().equalsIgnoreCase(str)) {
                        str2 = next.getPriceTick();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(str2) || (indexOf = str2.indexOf("1")) == -1) {
            return i11;
        }
        int i12 = indexOf - 1;
        if (i12 < 0) {
            return 0;
        }
        return i12;
    }
}
