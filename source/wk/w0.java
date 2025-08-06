package wk;

import android.util.Log;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.CurrencyRef;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.utils.UiFillUtil;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.functions.Func1;

public class w0 implements Func1<BaseAssetInfo, Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, List<CurrencyRef.ChainsItem>> f48080b = new HashMap();

    public w0(List<CurrencyRef> list) {
        for (CurrencyRef next : list) {
            this.f48080b.put(next.getCurrency(), next.getChains());
        }
    }

    /* renamed from: a */
    public Boolean call(BaseAssetInfo baseAssetInfo) {
        boolean z11 = !"usdt".equalsIgnoreCase(baseAssetInfo.getCurrency()) && d(baseAssetInfo) && c(baseAssetInfo) && b(baseAssetInfo);
        if (z11) {
            Log.i("UsdtExchangeFilter", baseAssetInfo.getCurrency());
        }
        return Boolean.valueOf(z11);
    }

    public final boolean b(BaseAssetInfo baseAssetInfo) {
        BigDecimal e11 = e(baseAssetInfo.getCurrency(), baseAssetInfo.getAvaialAble());
        if (e11.compareTo(BigDecimal.ZERO) > 0 && m.a(baseAssetInfo.getAvaialAble()).compareTo(e11) < 0) {
            return true;
        }
        return false;
    }

    public final boolean c(BaseAssetInfo baseAssetInfo) {
        boolean z11;
        CurrencyBean s11 = k.C().s(baseAssetInfo.getCurrency());
        if (s11 != null) {
            String state = s11.getState();
            if (SymbolBean.OFFLINE.equals(state) || SymbolBean.SUSPEND.equals(state)) {
                z11 = false;
                if (m.b0(UiFillUtil.d(baseAssetInfo.getAvaialAble())) && z11) {
                    return true;
                }
            }
        }
        z11 = true;
        return m.b0(UiFillUtil.d(baseAssetInfo.getAvaialAble())) ? false : false;
    }

    public final boolean d(BaseAssetInfo baseAssetInfo) {
        CurrencyBean s11 = k.C().s(baseAssetInfo.getCurrency());
        if (s11 != null) {
            return !s11.isFiatTag();
        }
        return true;
    }

    public final BigDecimal e(String str, String str2) {
        List<CurrencyRef.ChainsItem> list = this.f48080b.get(str);
        if (list == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (CurrencyRef.ChainsItem chainsItem : list) {
            if (chainsItem != null) {
                BigDecimal bigDecimal2 = BigDecimal.ZERO;
                String withdrawFeeType = chainsItem.getWithdrawFeeType();
                withdrawFeeType.hashCode();
                char c11 = 65535;
                switch (withdrawFeeType.hashCode()) {
                    case -846336256:
                        if (withdrawFeeType.equals("circulated")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case 97445748:
                        if (withdrawFeeType.equals("fixed")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 108285963:
                        if (withdrawFeeType.equals("ratio")) {
                            c11 = 2;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        bigDecimal2 = m.a(chainsItem.getMaxTransactFeeWithdraw());
                        break;
                    case 1:
                        bigDecimal2 = m.a(chainsItem.getTransactFeeWithdraw());
                        break;
                    case 2:
                        bigDecimal2 = m.a(chainsItem.getTransactFeeRateWithdraw()).multiply(m.a(str2));
                        break;
                }
                BigDecimal add = bigDecimal2.add(m.a(chainsItem.getMinWithdrawAmt()));
                if (bigDecimal.compareTo(add) < 0) {
                    bigDecimal = add;
                }
            }
        }
        return bigDecimal;
    }
}
