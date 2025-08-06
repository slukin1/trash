package yl;

import c6.b;
import com.hbg.lib.core.util.o;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import i6.m;
import java.math.BigDecimal;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static int f76852a = -1;

    public static void a() {
        f76852a = -1;
    }

    public static int b() {
        return f76852a;
    }

    public static void c(b<Integer> bVar) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        if (bVar != null && !d()) {
            boolean z11 = false;
            BaseAssetTotal Q = AssetDataCacheManager.k0().Q(0);
            BaseAssetTotal Q2 = AssetDataCacheManager.k0().Q(1);
            BaseAssetTotal Q3 = AssetDataCacheManager.k0().Q(2);
            BaseAssetTotal Q4 = AssetDataCacheManager.k0().Q(3);
            if (Q4 == null) {
                bigDecimal = BigDecimal.ZERO;
            } else {
                bigDecimal = m.a(Q4.getNetAssetToBtc());
            }
            if (Q == null) {
                bigDecimal2 = BigDecimal.ZERO;
            } else {
                bigDecimal2 = m.a(Q.getNetAssetToBtc());
            }
            if (Q2 == null) {
                bigDecimal3 = BigDecimal.ZERO;
            } else {
                bigDecimal3 = m.a(Q2.getNetAssetToBtc());
            }
            if (Q3 == null) {
                bigDecimal4 = BigDecimal.ZERO;
            } else {
                bigDecimal4 = m.a(Q3.getNetAssetToBtc());
            }
            boolean z12 = bigDecimal4.compareTo(BigDecimal.ZERO) == 0;
            boolean z13 = bigDecimal2.compareTo(BigDecimal.ZERO) == 0 && bigDecimal3.compareTo(BigDecimal.ZERO) == 0;
            if (o.h()) {
                if (z13 && bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                    z11 = true;
                }
                z13 = z11;
            }
            if (!z13) {
                return;
            }
            if (z12) {
                bVar.onCallback(1);
            } else {
                bVar.onCallback(2);
            }
        }
    }

    public static boolean d() {
        BaseAssetTotal Q = AssetDataCacheManager.k0().Q(0);
        BaseAssetTotal Q2 = AssetDataCacheManager.k0().Q(1);
        BaseAssetTotal Q3 = AssetDataCacheManager.k0().Q(2);
        BaseAssetTotal Q4 = AssetDataCacheManager.k0().Q(3);
        boolean z11 = Q == null || Q2 == null || Q3 == null;
        if (!o.h()) {
            return z11;
        }
        if (z11 || Q4 == null) {
            return true;
        }
        return false;
    }

    public static void e(int i11) {
        f76852a = i11;
    }
}
