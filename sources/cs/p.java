package cs;

import a7.e;
import android.annotation.SuppressLint;
import android.content.Context;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FutureTypeUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.huobi.contract.helper.ContractCurrencyUtils;
import d7.a1;
import ej.g;
import us.j;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final String f83823a;

    /* renamed from: b  reason: collision with root package name */
    public int f83824b;

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static p f83825a = new p();
    }

    public static p c() {
        return b.f83825a;
    }

    public int a() {
        return this.f83824b;
    }

    public int b() {
        return SP.e("sp_key_tab", 0);
    }

    public RemindBusinessType d(String str) {
        TradeType a11 = FutureTypeUtil.a((String) null, str, (String) null);
        if (a11 == TradeType.CONTRACT) {
            return RemindBusinessType.CONTRACT;
        }
        if (a11 == TradeType.SWAP) {
            return RemindBusinessType.SWAP;
        }
        if (a11 == TradeType.LINEAR_SWAP) {
            return RemindBusinessType.LINEAR_SWAP;
        }
        return null;
    }

    public RemindContractType e(String str) {
        TradeType a11 = FutureTypeUtil.a((String) null, str, (String) null);
        if (a11 == TradeType.CONTRACT) {
            RemindContractType remindContractType = RemindContractType.TYPE_CURRENT_WEEK;
            if (str.endsWith("NQ")) {
                return RemindContractType.TYPE_NEXT_SEASON;
            }
            if (str.endsWith("CQ")) {
                return RemindContractType.TYPE_CURRENT_SEASON;
            }
            if (str.endsWith("NW")) {
                return RemindContractType.TYPE_NEXT_WEEK;
            }
            return remindContractType;
        } else if (a11 == TradeType.SWAP) {
            return RemindContractType.TYPE_SWAP;
        } else {
            if (a11 == TradeType.LINEAR_SWAP) {
                return RemindContractType.TYPE_LINEAR_SWAP;
            }
            return null;
        }
    }

    public String f(Context context, boolean z11, RemindBusinessType remindBusinessType, String str) {
        if (!z11) {
            return a1.v().W(str);
        }
        if (remindBusinessType == RemindBusinessType.CONTRACT) {
            ContractCurrencyInfo b11 = ContractCurrencyUtils.b(str);
            if (b11 != null) {
                return g.l(context, b11.getSymbol(), b11.getContractCode(), b11.getContractType());
            }
            return null;
        } else if (remindBusinessType == RemindBusinessType.SWAP) {
            SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(str);
            if (c11 != null) {
                return j.l(context, c11.getSymbol());
            }
            return null;
        } else if (remindBusinessType != RemindBusinessType.LINEAR_SWAP) {
            return null;
        } else {
            FutureContractInfo o11 = FutureContractInfoController.n().o(str);
            if (o11 == null) {
                o11 = FutureContractInfoController.n().m(str);
            }
            if (o11 != null) {
                return e.v(context, o11.getSymbol(), o11.getQuoteCurrency(), o11.getContractCode(), o11.getContractType());
            }
            return null;
        }
    }

    public boolean g() {
        return this.f83824b == 1;
    }

    public void h(int i11) {
        if (this.f83824b != i11) {
            this.f83824b = i11;
            SP.q("sp_key_tab", i11);
        }
    }

    public p() {
        this.f83823a = "sp_key_tab";
        this.f83824b = 0;
    }
}
