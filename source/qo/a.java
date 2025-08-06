package qo;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.data.symbol.ExchangeSettingsController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ExchangeSettings;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.trade.helper.f0;
import d7.a1;
import ht.o;
import i6.m;
import java.math.BigDecimal;
import pro.huobi.R;
import ro.l;
import tg.r;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public l f84577a;

    /* renamed from: b  reason: collision with root package name */
    public TradeType f84578b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f84579c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84580d;

    /* renamed from: e  reason: collision with root package name */
    public int f84581e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f84582f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f84583g = false;

    /* renamed from: h  reason: collision with root package name */
    public Context f84584h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f84585i;

    public a(l lVar, Context context) {
        this.f84577a = lVar;
        this.f84584h = context;
    }

    public void a(Editable editable, boolean z11) {
        boolean o11 = o();
        int i11 = this.f84581e;
        boolean z12 = true;
        if (i11 != 1 || o11) {
            z12 = false;
        }
        if (i11 == 0 || i11 == 2 || z12) {
            if (!o11 || !a1.v().Q(l())) {
                String b11 = m.b(editable, 20, PrecisionUtil.C(l()));
                if (b11 != null) {
                    this.f84577a.d(b11);
                    return;
                }
            } else {
                String b12 = m.b(editable, 20, PrecisionUtil.y(l()));
                if (b12 != null) {
                    this.f84577a.d(b12);
                    return;
                }
            }
        } else if (i11 != 3) {
            String b13 = m.b(editable, 20, PrecisionUtil.y(l()));
            if (b13 != null) {
                this.f84577a.d(b13);
                return;
            }
        } else if (!o()) {
            String b14 = m.b(editable, 20, PrecisionUtil.C(l()));
            if (b14 != null) {
                this.f84577a.d(b14);
                return;
            }
        } else if (q()) {
            String b15 = m.b(editable, 20, PrecisionUtil.y(l()));
            if (b15 != null) {
                this.f84577a.d(b15);
                return;
            }
        } else {
            String b16 = m.b(editable, 20, PrecisionUtil.C(l()));
            if (b16 != null) {
                this.f84577a.d(b16);
                return;
            }
        }
        b(z11, o11);
    }

    public void b(boolean z11, boolean z12) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        int i11 = this.f84581e;
        BigDecimal bigDecimal4 = null;
        if (i11 == 0 || i11 == 2) {
            bigDecimal2 = !TextUtils.isEmpty(this.f84577a.getInputPriceText()) ? m.a(this.f84577a.getInputPriceText()) : null;
            bigDecimal = !TextUtils.isEmpty(this.f84577a.getInputAmountText()) ? m.a(this.f84577a.getInputAmountText()) : null;
            x();
            if (!(bigDecimal2 == null || bigDecimal == null)) {
                bigDecimal4 = bigDecimal2.multiply(bigDecimal);
            }
        } else {
            if (i11 != 3) {
                if (!TextUtils.isEmpty(this.f84577a.getInputAmountText())) {
                    bigDecimal3 = m.a(this.f84577a.getInputAmountText());
                }
                bigDecimal2 = null;
                bigDecimal = null;
            } else if (q()) {
                if (!TextUtils.isEmpty(this.f84577a.getInputAmountText())) {
                    bigDecimal3 = m.a(this.f84577a.getInputAmountText());
                }
                bigDecimal2 = null;
                bigDecimal = null;
            } else {
                bigDecimal2 = !TextUtils.isEmpty(this.f84577a.getInputPriceText()) ? m.a(this.f84577a.getInputPriceText()) : null;
                bigDecimal = !TextUtils.isEmpty(this.f84577a.getInputAmountText()) ? m.a(this.f84577a.getInputAmountText()) : null;
                x();
                if (!(bigDecimal2 == null || bigDecimal == null)) {
                    bigDecimal4 = bigDecimal2.multiply(bigDecimal);
                }
            }
            bigDecimal = bigDecimal3;
            bigDecimal2 = null;
        }
        if (bigDecimal4 != null) {
            bigDecimal4 = f0.i(bigDecimal4, z12, PrecisionUtil.y(this.f84582f));
        }
        this.f84577a.l(bigDecimal4);
        if (z11) {
            h(z12);
        }
        if (!this.f84583g) {
            y(bigDecimal2, bigDecimal);
        }
    }

    public void c(Editable editable, boolean z11) {
        String str;
        this.f84585i = false;
        boolean o11 = o();
        this.f84577a.n1(o11);
        if (o11 && this.f84581e == 1) {
            str = m.b(editable, 20, PrecisionUtil.y(l()));
        } else if (this.f84581e != 3) {
            str = m.b(editable, 20, PrecisionUtil.A(l()));
        } else if (!o11) {
            str = m.b(editable, 20, PrecisionUtil.A(l()));
        } else if (q()) {
            str = m.b(editable, 20, PrecisionUtil.y(l()));
        } else {
            str = m.b(editable, 20, PrecisionUtil.A(l()));
        }
        if (str != null) {
            this.f84577a.f(str);
            return;
        }
        if (editable.length() <= 0 || new BigDecimal(editable.toString()).compareTo(BigDecimal.ZERO) <= 0) {
            this.f84577a.z(false, 1);
        } else {
            this.f84577a.z(true, 1);
        }
        b(z11, o11);
    }

    public void d(Editable editable) {
        this.f84577a.A1(o());
        String b11 = m.b(editable, 20, PrecisionUtil.A(l()));
        if (b11 != null) {
            this.f84577a.e(b11);
        } else if (editable.length() <= 0 || new BigDecimal(editable.toString()).compareTo(BigDecimal.ZERO) <= 0) {
            this.f84577a.z(false, 3);
        } else {
            this.f84577a.z(true, 3);
        }
    }

    public void e(Editable editable, boolean z11) {
        String b11 = m.b(editable, 20, PrecisionUtil.y(this.f84582f));
        if (b11 != null) {
            this.f84577a.g(b11);
            return;
        }
        BigDecimal bigDecimal = null;
        if (!TextUtils.isEmpty(this.f84577a.getInputPriceText())) {
            bigDecimal = m.a(this.f84577a.getInputPriceText());
        }
        BigDecimal a11 = m.a(editable.toString());
        if (!(bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) == 0)) {
            BigDecimal divide = a11.divide(bigDecimal, PrecisionUtil.C(l()), 1);
            bigDecimal.multiply(divide);
            this.f84577a.setInputAmountText(divide.toPlainString());
        }
        l();
    }

    public void f(boolean z11, boolean z12) {
        this.f84577a.n(z12, this.f84581e, l());
        int i11 = this.f84581e;
        this.f84577a.F(i11, i11 == 2 || i11 == 3);
        x();
    }

    public void g(int i11, boolean z11) {
        r.x().F0();
        this.f84580d = false;
        int i12 = this.f84581e;
        this.f84581e = i11;
        this.f84577a.v(i12, i11, o(), l());
        x();
    }

    public boolean h(boolean z11) {
        String str;
        String str2;
        if (this.f84581e == 0 && !o.B().P()) {
            BigDecimal a11 = m.a(this.f84577a.getInputPriceText());
            if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                return false;
            }
            BigDecimal bigDecimal = BigDecimal.ZERO;
            if (bigDecimal.compareTo(bigDecimal) == 0) {
                return true;
            }
            ExchangeSettings b11 = ExchangeSettingsController.d().b(this.f84582f);
            if (b11 != null) {
                str = b11.getBuyLimitMustLessThan();
                str2 = b11.getSellLimitMustGreaterThan();
            } else {
                str = "1.1";
                str2 = "0.9";
            }
            if (z11 && a11.compareTo(bigDecimal.multiply(m.a(str))) > 0) {
                if (!this.f84585i) {
                    Context context = this.f84584h;
                    HuobiToastUtil.l(context, String.format(context.getString(R.string.n_trade_buy_price_high), new Object[]{m.Q(str, 0, 1)}));
                    this.f84585i = true;
                }
                return false;
            } else if (!z11 && a11.compareTo(bigDecimal.multiply(m.a(str2))) < 0) {
                if (!this.f84585i) {
                    Context context2 = this.f84584h;
                    HuobiToastUtil.l(context2, String.format(context2.getString(R.string.n_trade_sell_price_low), new Object[]{m.Q(str2, 0, 1)}));
                    this.f84585i = true;
                }
                return false;
            }
        }
        return true;
    }

    public String i() {
        return "";
    }

    public String j(String str) {
        if (TextUtils.isEmpty(str) || InstructionFileId.DOT.equals(str)) {
            return "";
        }
        if (TextUtils.isEmpty(this.f84582f) || !a1.v().D(this.f84582f).equalsIgnoreCase("usdt")) {
            return LegalCurrencyConfigUtil.A(str, this.f84582f, this.f84578b);
        }
        return LegalCurrencyConfigUtil.B(str);
    }

    public String k() {
        return "";
    }

    public String l() {
        return this.f84582f;
    }

    public TradeType m() {
        return this.f84578b;
    }

    public int n() {
        return this.f84581e;
    }

    public boolean o() {
        return this.f84579c;
    }

    public boolean p() {
        return this.f84580d;
    }

    public boolean q() {
        return this.f84581e == 3 && (this.f84577a.getUiPlanTradeBuyMode() == 2 || this.f84577a.getUiPlanTradeSellMode() == 2);
    }

    public void r(int i11, boolean z11) {
    }

    public void s(boolean z11) {
        this.f84579c = z11;
    }

    public void t(boolean z11) {
        this.f84580d = z11;
    }

    public void u(String str) {
        this.f84582f = str;
    }

    public void v(boolean z11) {
        this.f84583g = z11;
    }

    public void w(TradeType tradeType) {
        this.f84578b = tradeType;
    }

    public void x() {
    }

    public final void y(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        String str;
        if (bigDecimal == null) {
            BigDecimal bigDecimal3 = BigDecimal.ZERO;
        }
        if (bigDecimal2 == null) {
            bigDecimal2 = BigDecimal.ZERO;
        }
        if (bigDecimal2.compareTo(BigDecimal.ZERO) <= 0) {
            this.f84577a.setProgress(0.0f);
            return;
        }
        l();
        if (o()) {
            str = a1.v().E(this.f84582f, this.f84578b);
        } else {
            str = a1.v().o(this.f84582f, this.f84578b);
        }
        PrecisionUtil.a(this.f84578b, str);
    }
}
