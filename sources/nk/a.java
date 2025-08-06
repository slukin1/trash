package nk;

import a7.e;
import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeSharingGlobalConfig;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractOrderTimingRequestData;
import com.huobi.feature.util.TimeSharingOrderHelper;
import com.huobi.future.bean.FutureUserOrderLimitType;
import gl.d;
import i6.m;
import java.math.BigDecimal;
import pro.huobi.R;
import ym.z;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f47635a;

    /* renamed from: b  reason: collision with root package name */
    public z f47636b;

    /* renamed from: c  reason: collision with root package name */
    public C0579a f47637c;

    /* renamed from: nk.a$a  reason: collision with other inner class name */
    public interface C0579a {
        void close();
    }

    public a(z zVar, C0579a aVar) {
        this.f47636b = zVar;
        this.f47637c = aVar;
    }

    public boolean a(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            Context context = this.f47635a;
            HuobiToastUtil.l(context, String.format(context.getString(R.string.n_exchange_timing_tips_prefix), new Object[]{this.f47635a.getString(R.string.n_exchange_timing_one_order_amount)}));
            return true;
        } else if (bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
            Context context2 = this.f47635a;
            HuobiToastUtil.l(context2, String.format(context2.getString(R.string.n_exchange_timing_tips_prefix), new Object[]{this.f47635a.getString(R.string.n_exchange_timing_order_total_amount)}));
            return true;
        } else if (bigDecimal.compareTo(bigDecimal2) <= 0) {
            return false;
        } else {
            Context context3 = this.f47635a;
            HuobiToastUtil.l(context3, context3.getString(R.string.n_exchange_timing_order_amount_limit));
            return true;
        }
    }

    public boolean b(boolean z11, String str, String str2, int i11) {
        BigDecimal bigDecimal;
        LinearSwapTimeSharingGlobalConfig a11 = qk.a.b().a();
        if (a11 != null) {
            BigDecimal a12 = m.a(str2);
            BigDecimal a13 = m.a(str);
            BigDecimal add = m.a(a11.getTwMinPriceIntervalRatio()).multiply(a12).add(a12);
            BigDecimal add2 = m.a(a11.getTwMaxPriceIntervalRatio()).multiply(a12).add(a12);
            if (i11 == 0) {
                if (a13.compareTo(BigDecimal.ZERO) == 0) {
                    Context context = this.f47635a;
                    HuobiToastUtil.l(context, String.format(context.getString(R.string.n_exchange_timing_tips_prefix), new Object[]{this.f47635a.getString(R.string.n_exchange_timing_price_range)}));
                    return true;
                }
            } else if (a13.compareTo(BigDecimal.ZERO) == 0) {
                Context context2 = this.f47635a;
                String string = context2.getString(R.string.n_exchange_timing_tips_prefix);
                HuobiToastUtil.l(context2, String.format(string, new Object[]{this.f47635a.getString(R.string.n_exchange_timing_price_range) + this.f47635a.getString(R.string.n_exchange_timing_ratio)}));
                return true;
            } else {
                if (z11) {
                    bigDecimal = a12.add(a12.multiply(a13.divide(m.a("100"))));
                } else {
                    bigDecimal = a12.subtract(a12.multiply(a13.divide(m.a("100"))));
                }
                boolean z12 = bigDecimal.compareTo(add) < 0 || bigDecimal.compareTo(add2) > 0;
                if (z12) {
                    Context context3 = this.f47635a;
                    HuobiToastUtil.l(context3, String.format(context3.getString(R.string.n_exchange_timing_taker_price_range_tips), new Object[]{m.P(m.a(a11.getTwMinPriceIntervalRatio())), m.P(m.a(a11.getTwMaxPriceIntervalRatio()))}));
                }
                return z12;
            }
        }
        return false;
    }

    public boolean c(String str) {
        LinearSwapTimeSharingGlobalConfig a11 = qk.a.b().a();
        if (a11 == null) {
            return true;
        }
        if (m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            Context context = this.f47635a;
            HuobiToastUtil.l(context, String.format(context.getString(R.string.n_exchange_timing_tips_prefix), new Object[]{this.f47635a.getString(R.string.n_exchange_timing_interval)}));
            return true;
        }
        boolean z11 = Integer.parseInt(str) < a11.getTwMinTimeInterval() || Integer.parseInt(str) > a11.getTwMaxTimeInterval();
        if (z11) {
            Context context2 = this.f47635a;
            HuobiToastUtil.l(context2, String.format(context2.getString(R.string.n_exchange_timing_interval_range), new Object[]{String.valueOf(a11.getTwMinTimeInterval()), String.valueOf(a11.getTwMaxTimeInterval())}));
        }
        return z11;
    }

    public boolean d(BigDecimal bigDecimal, int i11, BigDecimal bigDecimal2, TradeType tradeType, FutureContractInfo futureContractInfo) {
        BigDecimal i12 = i(bigDecimal2, futureContractInfo, tradeType, i11);
        boolean z11 = i12.compareTo(BigDecimal.ZERO) > 0 && bigDecimal.compareTo(i12) > 0;
        if (z11) {
            HuobiToastUtil.l(this.f47635a, String.format(this.f47635a.getString(R.string.n_contract_order_amount_exceeds_the_limit), new Object[]{m.q(i12, FuturePrecisionUtil.w(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), futureContractInfo.getOptionCode())), e.G(tradeType) ? "USDT" : futureContractInfo.getSymbol()}));
        }
        return z11;
    }

    public boolean e(BigDecimal bigDecimal, String str, FutureContractInfo futureContractInfo) {
        boolean M = this.f47636b.M(bigDecimal, m.a(str));
        if (M) {
            k(str, futureContractInfo);
        }
        return M;
    }

    public boolean f(EditText editText) {
        if (m.a(editText.getText().toString()).compareTo(BigDecimal.ZERO) != 0) {
            return false;
        }
        Context context = this.f47635a;
        HuobiToastUtil.l(context, String.format(context.getString(R.string.n_exchange_timing_tips_prefix), new Object[]{this.f47635a.getString(R.string.n_exchange_timing_taker_price_limit)}));
        return true;
    }

    public String g(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() <= i11) {
            return str;
        }
        return str.substring(0, i11) + "...";
    }

    public BigDecimal h(String str, String str2, FutureContractInfo futureContractInfo) {
        return m.a(FutureUnitUtil.e(str, str2, futureContractInfo.getContractFace(), TradeType.LINEAR_SWAP, FuturePrecisionUtil.g(futureContractInfo.getSymbol()))).setScale(FuturePrecisionUtil.B(), 1);
    }

    public final BigDecimal i(BigDecimal bigDecimal, FutureContractInfo futureContractInfo, TradeType tradeType, int i11) {
        FutureUserOrderLimitType e11 = d.e(tradeType, futureContractInfo.getSymbol(), 1, 0, futureContractInfo.getContractCode());
        if (e11 == null) {
            return BigDecimal.ZERO;
        }
        if (i11 != 0) {
            return BigDecimal.ZERO;
        }
        if (TextUtils.isEmpty(e11.getOpenOrdersLong())) {
            return BigDecimal.ZERO;
        }
        if (TextUtils.isEmpty(e11.getOpenLimit())) {
            return BigDecimal.ZERO;
        }
        String d11 = FutureUnitUtil.d(e11.getOpenLimit(), bigDecimal.toPlainString(), futureContractInfo.getContractFace(), tradeType);
        if (m.a(d11).compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return m.a(d11);
    }

    public void j(FragmentActivity fragmentActivity) {
        this.f47635a = fragmentActivity;
    }

    public void k(String str, FutureContractInfo futureContractInfo) {
        if (e.G(TradeType.LINEAR_SWAP)) {
            String contractFace = futureContractInfo.getContractFace();
            String quoteCurrency = futureContractInfo.getQuoteCurrency();
            String I = m.I(m.a(contractFace).multiply(m.a(str)), 4);
            Context context = this.f47635a;
            HuobiToastUtil.l(context, String.format(context.getString(R.string.contract_trade_lowest_amount), new Object[]{I, quoteCurrency}));
            return;
        }
        BigDecimal a11 = m.a(futureContractInfo.getContractFace());
        Context context2 = this.f47635a;
        HuobiToastUtil.l(context2, String.format(context2.getString(R.string.contract_trade_lowest_amount), new Object[]{m.F(a11.toPlainString(), FuturePrecisionUtil.s(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null)), futureContractInfo.getSymbol()}));
    }

    public void l(ContractOrderTimingRequestData contractOrderTimingRequestData) {
        if (contractOrderTimingRequestData.isCanTrade()) {
            new TimeSharingOrderHelper().a(this.f47635a, contractOrderTimingRequestData);
            C0579a aVar = this.f47637c;
            if (aVar != null) {
                aVar.close();
            }
        }
    }
}
