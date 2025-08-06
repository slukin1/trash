package com.huobi.trade.presenter;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.data.symbol.ExchangeSettingsController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ExchangeSettings;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.trade.helper.f0;
import com.huobi.trade.ui.y3;
import d7.a1;
import dt.r2;
import ht.o;
import i6.m;
import ij.j;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import tg.r;

public abstract class TradeVerticalBasePresenter<V extends y3> extends TradeBasePresenter<V> {
    public boolean G = false;
    public boolean H;
    public boolean I;
    public CouponReturn J;

    /* access modifiers changed from: private */
    public /* synthetic */ void w2(List list, int i11) {
        if (list == null || list.isEmpty()) {
            ((y3) getUI()).Yd(8, "", 0);
            return;
        }
        String string = getString(R.string.n_exchange_coupon_available_number);
        ((y3) getUI()).Yd(0, String.format(string, new Object[]{list.size() + ""}), R.color.baseColorPrimaryText);
    }

    public void A0() {
        this.J = null;
        o2();
    }

    public void A2(int i11) {
        r2 r2Var = this.f82098i;
        if (r2Var != null) {
            r2Var.U(i11);
        }
    }

    public final void B2(int i11) {
        if (this.f82103n == 1) {
            BigDecimal divide = BigDecimal.valueOf((long) i11).divide(m.f68179a);
            if (a1()) {
                BigDecimal q22 = q2();
                if (q22 != null) {
                    BigDecimal multiply = divide.multiply(q22);
                    if (multiply.compareTo(BigDecimal.ZERO) > 0) {
                        ((y3) getUI()).P4(m.q(multiply, PrecisionUtil.C(o0())));
                    } else {
                        ((y3) getUI()).P4("");
                    }
                }
            } else {
                BigDecimal r22 = r2();
                if (r22 != null) {
                    BigDecimal i12 = f0.i(divide.multiply(r22), a1(), PrecisionUtil.y(this.f82094e));
                    if (i12.compareTo(BigDecimal.ZERO) > 0) {
                        ((y3) getUI()).M4(i12.toPlainString());
                    } else {
                        ((y3) getUI()).M4("");
                    }
                }
            }
        }
    }

    public final void C2(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        String str;
        if (bigDecimal == null) {
            bigDecimal = BigDecimal.ZERO;
        }
        if (bigDecimal2 == null) {
            bigDecimal2 = BigDecimal.ZERO;
        }
        float f11 = 0.0f;
        if (bigDecimal2.compareTo(BigDecimal.ZERO) <= 0) {
            ((y3) getUI()).dd().setProgress(0.0f);
            return;
        }
        String o02 = o0();
        BigDecimal n22 = n2();
        if (a1()) {
            str = a1.v().E(this.f82094e, this.f82105p);
        } else {
            str = a1.v().o(this.f82094e, this.f82105p);
        }
        int a11 = PrecisionUtil.a(this.f82105p, str);
        if (n22.compareTo(BigDecimal.ZERO) > 0 && n22.setScale(a11, 1).compareTo(BigDecimal.ZERO) > 0) {
            if (a1()) {
                int i11 = this.f82103n;
                if (i11 == 0 || i11 == 2) {
                    if (a1.v().Q(this.f82094e)) {
                        f11 = bigDecimal2.multiply(m.f68179a).divide(n22, PrecisionUtil.E(o02), 1).floatValue();
                    } else if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                        f11 = bigDecimal2.multiply(bigDecimal).multiply(m.f68179a).divide(n22, PrecisionUtil.E(o02), 1).floatValue();
                    }
                } else if (i11 == 1) {
                    f11 = bigDecimal2.multiply(m.f68179a).divide(n22, PrecisionUtil.E(o02), 1).floatValue();
                } else if (i11 == 3) {
                    if (u2()) {
                        f11 = bigDecimal2.multiply(m.f68179a).divide(n22, PrecisionUtil.E(o02), 1).floatValue();
                    } else if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                        f11 = bigDecimal2.multiply(bigDecimal).multiply(m.f68179a).divide(n22, PrecisionUtil.E(o02), 1).floatValue();
                    }
                }
            } else {
                f11 = bigDecimal2.multiply(m.f68179a).divide(n22, PrecisionUtil.E(o02), 1).floatValue();
            }
            ((y3) getUI()).dd().setProgress(f11);
        }
    }

    public void D2() {
        this.f82098i.Z(false);
    }

    public void E2(BigDecimal bigDecimal) {
        TradeType tradeType;
        if (a1.v().p0(this.f82094e) || (tradeType = TradeType.PRO) != this.f82105p || !r.x().F0()) {
            ((y3) getUI()).Yd(8, "", 0);
            return;
        }
        this.E = false;
        CouponReturn couponReturn = this.J;
        int i11 = R.color.baseColorPrimaryText;
        if (couponReturn != null) {
            boolean z11 = this.f82103n == 1 && !a1();
            if (m.a(this.J.getMeetCondition()).compareTo(BigDecimal.ZERO) == 0) {
                this.E = true;
            } else if (z11) {
                this.E = true;
            } else if (bigDecimal != null && m.a(LegalCurrencyConfigUtil.V(bigDecimal.toPlainString(), a1.v().D(this.f82094e), tradeType)).compareTo(m.a(this.J.getMeetCondition())) >= 0) {
                this.E = true;
            } else {
                i11 = R.color.baseColorSecondaryText;
            }
            String string = getString(R.string.n_exchange_coupon_max_return);
            ((y3) getUI()).Yd(0, String.format(string, new Object[]{this.J.getAmount() + "usdt".toUpperCase()}), i11);
            return;
        }
        ArrayList<CouponReturn> f11 = j.g().f("9", (CouponReturn) null);
        if (f11 == null || f11.size() <= 0) {
            ((y3) getUI()).Yd(8, "", 0);
        } else {
            ((y3) getUI()).Yd(0, String.format(getString(R.string.n_exchange_coupon_available_number), new Object[]{Integer.valueOf(f11.size())}), R.color.baseColorPrimaryText);
        }
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            if (com.huobi.trade.helper.j.a()) {
                k2();
            } else {
                ((y3) getUI()).c(t2());
            }
            ((y3) getUI()).n0();
            this.J = null;
            o2();
        }
    }

    public void Z1() {
        BigDecimal bigDecimal;
        int i11;
        BigDecimal n22 = n2();
        int i12 = this.f82103n;
        if (i12 == 0 || i12 == 2) {
            int C = PrecisionUtil.C(o0());
            if (a1()) {
                if (a1.v().Q(o0())) {
                    int y11 = PrecisionUtil.y(o0());
                    if (n22.compareTo(BigDecimal.ZERO) == 0) {
                        bigDecimal = BigDecimal.ZERO.setScale(y11, RoundingMode.FLOOR);
                    } else {
                        bigDecimal = n22.setScale(y11, RoundingMode.FLOOR);
                    }
                } else if (TextUtils.isEmpty(((y3) getUI()).getInputPriceText())) {
                    bigDecimal = BigDecimal.ZERO.setScale(C, RoundingMode.FLOOR);
                } else {
                    BigDecimal a11 = m.a(((y3) getUI()).getInputPriceText());
                    if (a11.compareTo(BigDecimal.ZERO) <= 0 || n22.compareTo(BigDecimal.ZERO) <= 0) {
                        bigDecimal = BigDecimal.ZERO.setScale(C, RoundingMode.FLOOR);
                    } else {
                        bigDecimal = n22.divide(a11, C, RoundingMode.FLOOR);
                    }
                }
            } else if (n22.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal = BigDecimal.ZERO.setScale(C, RoundingMode.FLOOR);
            } else {
                bigDecimal = n22.setScale(C, RoundingMode.FLOOR);
            }
        } else if (i12 != 3) {
            if (i12 != 1 || a1()) {
                i11 = PrecisionUtil.y(o0());
            } else {
                i11 = PrecisionUtil.C(o0());
            }
            if (n22.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal = BigDecimal.ZERO.setScale(i11, RoundingMode.FLOOR);
            } else {
                bigDecimal = n22.setScale(i11, RoundingMode.FLOOR);
            }
        } else if (!a1()) {
            int C2 = PrecisionUtil.C(o0());
            if (n22.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal = BigDecimal.ZERO.setScale(C2, RoundingMode.FLOOR);
            } else {
                bigDecimal = n22.setScale(C2, RoundingMode.FLOOR);
            }
        } else if (u2()) {
            int y12 = PrecisionUtil.y(o0());
            if (n22.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal = BigDecimal.ZERO.setScale(y12, RoundingMode.FLOOR);
            } else {
                bigDecimal = n22.setScale(y12, RoundingMode.FLOOR);
            }
        } else {
            int C3 = PrecisionUtil.C(o0());
            if (TextUtils.isEmpty(((y3) getUI()).getInputPriceText())) {
                bigDecimal = BigDecimal.ZERO.setScale(C3, RoundingMode.FLOOR);
            } else {
                BigDecimal a12 = m.a(((y3) getUI()).getInputPriceText());
                if (a12.compareTo(BigDecimal.ZERO) <= 0 || n22.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal = BigDecimal.ZERO.setScale(C3, RoundingMode.FLOOR);
                } else {
                    bigDecimal = n22.divide(a12, C3, RoundingMode.FLOOR);
                }
            }
        }
        if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
            bigDecimal = BigDecimal.ZERO.setScale(bigDecimal.scale(), RoundingMode.FLOOR);
        }
        ((y3) getUI()).setProgressText(bigDecimal.toPlainString());
    }

    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        k2();
        super.afterSymbolIdChanged(symbolChangeEvent);
        ((y3) getUI()).t(a1.v().J(this.f82094e, this.f82105p));
        this.H = false;
        o2();
    }

    public void d2(EditText editText, Editable editable, boolean z11) {
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        boolean a12 = a1();
        int i11 = this.f82103n;
        boolean z12 = true;
        if (i11 != 1 || a12) {
            z12 = false;
        }
        if (i11 == 0 || i11 == 7 || i11 == 2 || z12) {
            if (!a12 || !a1.v().Q(o0())) {
                String b11 = m.b(editable, 20, PrecisionUtil.C(o0()));
                if (b11 != null) {
                    editText.setText(b11);
                    editText.setSelection(editText.getText().length());
                    return;
                }
            } else {
                String b12 = m.b(editable, 20, PrecisionUtil.y(o0()));
                if (b12 != null) {
                    editText.setText(b12);
                    editText.setSelection(editText.getText().length());
                    return;
                }
            }
        } else if (i11 != 3) {
            String b13 = m.b(editable, 20, PrecisionUtil.y(o0()));
            if (b13 != null) {
                editText.setText(b13);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else if (!a1()) {
            String b14 = m.b(editable, 20, PrecisionUtil.C(o0()));
            if (b14 != null) {
                editText.setText(b14);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else if (u2()) {
            String b15 = m.b(editable, 20, PrecisionUtil.y(o0()));
            if (b15 != null) {
                editText.setText(b15);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else {
            String b16 = m.b(editable, 20, PrecisionUtil.C(o0()));
            if (b16 != null) {
                editText.setText(b16);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        e2(z11, a12);
    }

    public void e2(boolean z11, boolean z12) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        int i11;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        if (((y3) getUI()).isCanBeSeen()) {
            int i12 = this.f82103n;
            BigDecimal bigDecimal5 = null;
            if (i12 == 0 || i12 == 7 || i12 == 2) {
                bigDecimal2 = !TextUtils.isEmpty(((y3) getUI()).getInputPriceText()) ? m.a(((y3) getUI()).getInputPriceText()) : null;
                bigDecimal = !TextUtils.isEmpty(((y3) getUI()).getInputAmountText()) ? m.a(((y3) getUI()).getInputAmountText()) : null;
                Z1();
                if (!(bigDecimal2 == null || bigDecimal == null)) {
                    bigDecimal5 = bigDecimal2.multiply(bigDecimal);
                }
            } else {
                if (i12 != 3) {
                    BigDecimal valueOf = BigDecimal.valueOf(this.f82098i.B());
                    if (a1()) {
                        bigDecimal = m.a(((y3) getUI()).Kc());
                        bigDecimal2 = valueOf;
                        bigDecimal5 = bigDecimal;
                    } else {
                        BigDecimal a11 = m.a(((y3) getUI()).d8());
                        bigDecimal3 = m.a(((y3) getUI()).Kc());
                        bigDecimal4 = a11;
                        bigDecimal2 = valueOf;
                    }
                } else if (!u2()) {
                    bigDecimal2 = !TextUtils.isEmpty(((y3) getUI()).getInputPriceText()) ? m.a(((y3) getUI()).getInputPriceText()) : null;
                    bigDecimal = !TextUtils.isEmpty(((y3) getUI()).getInputAmountText()) ? m.a(((y3) getUI()).getInputAmountText()) : null;
                    Z1();
                    if (!(bigDecimal2 == null || bigDecimal == null)) {
                        bigDecimal5 = bigDecimal2.multiply(bigDecimal);
                    }
                } else if (!TextUtils.isEmpty(((y3) getUI()).getInputAmountText())) {
                    bigDecimal5 = m.a(((y3) getUI()).getInputAmountText());
                    bigDecimal2 = BigDecimal.valueOf(this.f82098i.B());
                    if (z12) {
                        bigDecimal = bigDecimal5;
                    } else {
                        bigDecimal3 = bigDecimal2.multiply(bigDecimal5);
                        bigDecimal4 = bigDecimal5;
                    }
                } else {
                    bigDecimal2 = null;
                    bigDecimal = null;
                }
                bigDecimal5 = bigDecimal3;
            }
            if (bigDecimal5 != null) {
                bigDecimal5 = f0.i(bigDecimal5, z12, PrecisionUtil.y(this.f82094e));
            }
            if (z12) {
                this.f82100k.j0(bigDecimal5);
            } else {
                this.f82100k.p0(bigDecimal5);
            }
            ((y3) getUI()).l(bigDecimal5);
            E2(bigDecimal5);
            T1(bigDecimal5, this.f82103n == 1 ? m.a(((y3) getUI()).d8()) : bigDecimal, z12);
            if (z11) {
                l2(z12);
            }
            if (!this.G) {
                C2(bigDecimal2, bigDecimal);
            }
            if (z11) {
                if (z12) {
                    i11 = ((y3) getUI()).S1();
                } else {
                    i11 = ((y3) getUI()).c2();
                }
                y0(bigDecimal2, bigDecimal, z12, i11);
            }
        }
    }

    public void f2(EditText editText, Editable editable) {
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String b11 = m.b(editable, 20, PrecisionUtil.C(o0()));
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
            return;
        }
        BigDecimal q22 = q2();
        BigDecimal a11 = m.a(editable.toString());
        if (q22 == null || q22.compareTo(BigDecimal.ZERO) <= 0 || a11.compareTo(BigDecimal.ZERO) <= 0) {
            ((y3) getUI()).M4("");
        } else {
            ((y3) getUI()).dd().setProgress(a11.multiply(m.f68179a).divide(q22, PrecisionUtil.E(o0()), 1).floatValue());
            BigDecimal r22 = r2();
            if (r22 == null) {
                ((y3) getUI()).M4("");
            } else {
                BigDecimal i11 = f0.i(r22.multiply(a11).divide(q22, PrecisionUtil.y(this.f82094e), 1), a1(), PrecisionUtil.y(this.f82094e));
                if (i11.compareTo(BigDecimal.ZERO) > 0) {
                    ((y3) getUI()).M4(i11.toPlainString());
                } else {
                    ((y3) getUI()).M4("");
                }
            }
        }
        e2(!TextUtils.isEmpty(editable.toString()), a1());
    }

    public void g2(EditText editText, Editable editable) {
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String b11 = m.b(editable, 20, PrecisionUtil.y(o0()));
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
            return;
        }
        BigDecimal r22 = r2();
        BigDecimal a11 = m.a(editable.toString());
        if (r22 == null || r22.compareTo(BigDecimal.ZERO) <= 0 || a11.compareTo(BigDecimal.ZERO) <= 0) {
            ((y3) getUI()).P4("");
        } else {
            ((y3) getUI()).dd().setProgress(a11.multiply(m.f68179a).divide(r22, PrecisionUtil.E(o0()), 1).floatValue());
            BigDecimal q22 = q2();
            if (q22 == null) {
                ((y3) getUI()).P4("");
            } else {
                BigDecimal divide = q22.multiply(a11).divide(r22, PrecisionUtil.C(this.f82094e), 1);
                if (divide.compareTo(BigDecimal.ZERO) > 0) {
                    ((y3) getUI()).P4(m.q(divide, PrecisionUtil.C(o0())));
                } else {
                    ((y3) getUI()).P4("");
                }
            }
        }
        e2(!TextUtils.isEmpty(editable.toString()), a1());
    }

    public void h2(EditText editText, Editable editable, boolean z11) {
        String str;
        this.I = false;
        boolean a12 = a1();
        ((y3) getUI()).n1(a12);
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        if (a12 && this.f82103n == 1) {
            str = m.b(editable, 20, PrecisionUtil.y(o0()));
        } else if (this.f82103n != 3) {
            str = m.b(editable, 20, PrecisionUtil.A(o0()));
        } else if (!a12) {
            str = m.b(editable, 20, PrecisionUtil.A(o0()));
        } else if (u2()) {
            str = m.b(editable, 20, PrecisionUtil.y(o0()));
        } else {
            str = m.b(editable, 20, PrecisionUtil.A(o0()));
        }
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.getText().length());
            return;
        }
        if (editable.length() <= 0 || new BigDecimal(editable.toString()).compareTo(BigDecimal.ZERO) <= 0) {
            ((y3) getUI()).z(false, 1);
        } else {
            ((y3) getUI()).z(true, 1);
        }
        e2(z11, a12);
    }

    public void i2(EditText editText, Editable editable) {
        ((y3) getUI()).A1(a1());
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String b11 = m.b(editable, 20, PrecisionUtil.A(o0()));
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
        } else if (editable.length() <= 0 || new BigDecimal(editable.toString()).compareTo(BigDecimal.ZERO) <= 0) {
            ((y3) getUI()).z(false, 3);
        } else {
            ((y3) getUI()).z(true, 3);
        }
    }

    public void j2(EditText editText, Editable editable, boolean z11) {
        BigDecimal bigDecimal;
        boolean a12 = a1();
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String b11 = m.b(editable, 20, PrecisionUtil.y(this.f82094e));
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
            return;
        }
        BigDecimal bigDecimal2 = null;
        BigDecimal a11 = !TextUtils.isEmpty(((y3) getUI()).getInputPriceText()) ? m.a(((y3) getUI()).getInputPriceText()) : null;
        BigDecimal a13 = m.a(editable.toString());
        if (a11 == null || a11.compareTo(BigDecimal.ZERO) == 0) {
            bigDecimal = null;
        } else {
            BigDecimal divide = a13.divide(a11, PrecisionUtil.C(o0()), 1);
            BigDecimal multiply = a11.multiply(divide);
            ((y3) getUI()).setInputAmountText(divide.toPlainString());
            BigDecimal bigDecimal3 = divide;
            bigDecimal2 = multiply;
            bigDecimal = bigDecimal3;
        }
        o0();
        if (a11 != null) {
            bigDecimal2 = f0.i(bigDecimal2, a12, PrecisionUtil.y(this.f82094e));
        }
        if (a12) {
            this.f82100k.j0(bigDecimal2);
        } else {
            this.f82100k.p0(bigDecimal2);
        }
        E2(bigDecimal2);
        T1(bigDecimal2, bigDecimal, a12);
        if (z11) {
            l2(a12);
        }
        if (!this.G) {
            C2(a11, bigDecimal);
        }
    }

    public final void k2() {
        A2(0);
        D2();
        ((y3) getUI()).c(0);
    }

    public boolean l2(boolean z11) {
        String str;
        String str2;
        if (getUI() == null || !((y3) getUI()).isAlive()) {
            return false;
        }
        if (this.f82103n == 0 && !o.B().P()) {
            BigDecimal a11 = m.a(((y3) getUI()).getInputPriceText());
            if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                return false;
            }
            BigDecimal valueOf = BigDecimal.valueOf(this.f82098i.B());
            if (valueOf.compareTo(BigDecimal.ZERO) == 0) {
                return true;
            }
            ExchangeSettings b11 = ExchangeSettingsController.d().b(this.f82094e);
            if (b11 != null) {
                str = b11.getBuyLimitMustLessThan();
                str2 = b11.getSellLimitMustGreaterThan();
            } else {
                str = "1.1";
                str2 = "0.9";
            }
            if (z11 && a11.compareTo(valueOf.multiply(m.a(str))) > 0) {
                if (!this.I) {
                    HuobiToastUtil.m(String.format(getActivity().getString(R.string.n_trade_buy_price_high), new Object[]{m.Q(str, 0, 1)}));
                    this.I = true;
                }
                return false;
            } else if (!z11 && a11.compareTo(valueOf.multiply(m.a(str2))) < 0) {
                if (!this.I) {
                    HuobiToastUtil.m(String.format(getActivity().getString(R.string.n_trade_sell_price_low), new Object[]{m.Q(str2, 0, 1)}));
                    this.I = true;
                }
                return false;
            }
        }
        return true;
    }

    public void m2(int i11) {
        this.f82098i.u(this.f82094e, i11);
    }

    public BigDecimal n2() {
        int i11;
        if (a1()) {
            i11 = ((y3) getUI()).S1();
        } else {
            i11 = ((y3) getUI()).c2();
        }
        TradeType tradeType = TradeType.PRO;
        TradeType tradeType2 = this.f82105p;
        if (tradeType == tradeType2) {
            return M0(a1(), this.f82094e);
        }
        if (TradeType.MARGIN == tradeType2) {
            return this.f82100k.z(o0(), a1(), i11);
        }
        if (TradeType.C2C == tradeType2) {
            return this.f82100k.w(this.f82094e, a1());
        }
        return this.f82100k.G(tradeType2, o0(), a1(), i11);
    }

    public void o2() {
        if (!r.x().F0()) {
            this.J = null;
            ((y3) getUI()).Yd(8, "", 0);
        } else if (a1.v().p0(this.f82094e) || TradeType.PRO != this.f82105p) {
            ((y3) getUI()).Yd(8, "", 0);
        } else if (this.J == null) {
            j.g().i(0, "9", new et.m(this));
        }
    }

    public void p1() {
        this.J = null;
        o2();
    }

    public final BigDecimal p2() {
        BigDecimal bigDecimal;
        ExchangeSettings b11 = ExchangeSettingsController.d().b(o0());
        if (b11 != null) {
            bigDecimal = m.a(b11.getMarketBSCalcMaxScale());
        } else {
            bigDecimal = BigDecimal.ONE;
        }
        return bigDecimal.divide(m.f68179a);
    }

    public BigDecimal q2() {
        BigDecimal n22 = n2();
        if (!a1()) {
            return n22;
        }
        BigDecimal a11 = m.a(this.f82103n == 1 ? O0() : "");
        if (a11.compareTo(BigDecimal.ZERO) == 0) {
            return null;
        }
        return n22.divide(a11.multiply(BigDecimal.ONE.add(p2())), PrecisionUtil.C(o0()), 1);
    }

    public BigDecimal r2() {
        String str;
        BigDecimal n22 = n2();
        if (a1()) {
            return n22;
        }
        int i11 = this.f82103n;
        if (i11 == 1) {
            str = F0();
        } else {
            str = (i11 != 3 || !u2()) ? "" : ((y3) getUI()).eg();
        }
        BigDecimal a11 = m.a(str);
        if (a11.compareTo(BigDecimal.ZERO) == 0) {
            return null;
        }
        return n22.multiply(a11.multiply(BigDecimal.ONE.subtract(p2())));
    }

    public CouponReturn s2() {
        return this.J;
    }

    public int t2() {
        r2 r2Var = this.f82098i;
        if (r2Var != null) {
            return r2Var.E();
        }
        return 0;
    }

    public boolean u2() {
        return this.f82103n == 3 && (((y3) getUI()).getUiPlanTradeBuyMode() == 2 || ((y3) getUI()).getUiPlanTradeSellMode() == 2);
    }

    public boolean v2() {
        return this.G;
    }

    public void w0(boolean z11, boolean z12) {
        String o02 = o0();
        ((y3) getUI()).n(z12, this.f82103n, o02);
        int i11 = this.f82103n;
        ((y3) getUI()).F(this.f82103n, i11 == 2 || i11 == 3);
        Z1();
        Y0(false, o02, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x2(int r7, boolean r8) {
        /*
            r6 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            tg.r r8 = tg.r.x()
            boolean r8 = r8.F0()
            if (r8 != 0) goto L_0x000e
            return
        L_0x000e:
            r6.B2(r7)
            int r8 = r6.f82103n
            r0 = 2
            r1 = 3
            r2 = 0
            r3 = 1
            if (r8 != r1) goto L_0x003b
            boolean r8 = r6.u2()
            if (r8 == 0) goto L_0x002b
            dt.r2 r8 = r6.f82098i
            double r4 = r8.B()
            java.math.BigDecimal r8 = java.math.BigDecimal.valueOf(r4)
        L_0x0029:
            r4 = r2
            goto L_0x005a
        L_0x002b:
            h6.a r8 = r6.getUI()
            com.huobi.trade.ui.y3 r8 = (com.huobi.trade.ui.y3) r8
            java.lang.String r8 = r8.getInputPriceText()
            java.math.BigDecimal r8 = i6.m.a(r8)
            r4 = r3
            goto L_0x005a
        L_0x003b:
            if (r8 == 0) goto L_0x004b
            if (r8 != r0) goto L_0x0040
            goto L_0x004b
        L_0x0040:
            dt.r2 r8 = r6.f82098i
            double r4 = r8.B()
            java.math.BigDecimal r8 = java.math.BigDecimal.valueOf(r4)
            goto L_0x0029
        L_0x004b:
            h6.a r8 = r6.getUI()
            com.huobi.trade.ui.y3 r8 = (com.huobi.trade.ui.y3) r8
            java.lang.String r8 = r8.getInputPriceText()
            java.math.BigDecimal r8 = i6.m.a(r8)
            goto L_0x0029
        L_0x005a:
            int r5 = r6.f82103n
            if (r5 == 0) goto L_0x0063
            if (r5 != r0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r0 = r2
            goto L_0x0064
        L_0x0063:
            r0 = r3
        L_0x0064:
            if (r0 == 0) goto L_0x0075
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            int r0 = r8.compareTo(r0)
            if (r0 != 0) goto L_0x0075
            boolean r0 = r6.a1()
            if (r0 == 0) goto L_0x0075
            return
        L_0x0075:
            if (r4 == 0) goto L_0x0086
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            int r0 = r8.compareTo(r0)
            if (r0 != 0) goto L_0x0086
            boolean r0 = r6.a1()
            if (r0 == 0) goto L_0x0086
            return
        L_0x0086:
            long r4 = (long) r7
            java.math.BigDecimal r7 = java.math.BigDecimal.valueOf(r4)
            java.math.BigDecimal r0 = i6.m.f68179a
            java.math.BigDecimal r7 = r7.divide(r0)
            java.math.BigDecimal r0 = r6.n2()
            java.math.BigDecimal r7 = r7.multiply(r0)
            boolean r0 = r6.a1()
            if (r0 == 0) goto L_0x00a5
            int r0 = r6.f82103n
            if (r0 != r3) goto L_0x00a5
            r0 = r3
            goto L_0x00a6
        L_0x00a5:
            r0 = r2
        L_0x00a6:
            boolean r4 = r6.a1()
            if (r4 == 0) goto L_0x00bb
            d7.a1 r4 = d7.a1.v()
            java.lang.String r5 = r6.o0()
            boolean r4 = r4.Q(r5)
            if (r4 == 0) goto L_0x00bb
            r2 = r3
        L_0x00bb:
            if (r0 != 0) goto L_0x00c9
            if (r2 == 0) goto L_0x00c0
            goto L_0x00c9
        L_0x00c0:
            java.lang.String r0 = r6.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.C(r0)
            goto L_0x00d1
        L_0x00c9:
            java.lang.String r0 = r6.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.y(r0)
        L_0x00d1:
            int r2 = r6.f82103n
            if (r2 != r1) goto L_0x0108
            boolean r0 = r6.a1()
            if (r0 == 0) goto L_0x00ff
            boolean r0 = r6.u2()
            if (r0 == 0) goto L_0x00ea
            java.lang.String r8 = r6.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.y(r8)
            goto L_0x0131
        L_0x00ea:
            java.lang.String r0 = r6.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.C(r0)
            java.lang.String r1 = r6.o0()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.math.BigDecimal r7 = r7.divide(r8, r1, r3)
            goto L_0x0131
        L_0x00ff:
            java.lang.String r8 = r6.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.C(r8)
            goto L_0x0131
        L_0x0108:
            boolean r1 = r6.a1()
            if (r1 == 0) goto L_0x0131
            int r1 = r6.f82103n
            if (r1 == r3) goto L_0x0131
            d7.a1 r1 = d7.a1.v()
            java.lang.String r2 = r6.o0()
            boolean r1 = r1.Q(r2)
            if (r1 == 0) goto L_0x0125
            int r1 = r6.f82103n
            if (r1 != 0) goto L_0x0125
            goto L_0x0131
        L_0x0125:
            java.lang.String r1 = r6.o0()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.math.BigDecimal r7 = r7.divide(r8, r1, r3)
        L_0x0131:
            java.math.BigDecimal r8 = java.math.BigDecimal.ZERO
            int r8 = r7.compareTo(r8)
            if (r8 <= 0) goto L_0x0147
            h6.a r8 = r6.getUI()
            com.huobi.trade.ui.y3 r8 = (com.huobi.trade.ui.y3) r8
            java.lang.String r7 = i6.m.q(r7, r0)
            r8.setInputAmountText(r7)
            goto L_0x0152
        L_0x0147:
            h6.a r7 = r6.getUI()
            com.huobi.trade.ui.y3 r7 = (com.huobi.trade.ui.y3) r7
            java.lang.String r8 = ""
            r7.setInputAmountText(r8)
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.trade.presenter.TradeVerticalBasePresenter.x2(int, boolean):void");
    }

    public void y2(CouponReturn couponReturn) {
        this.J = couponReturn;
    }

    public void z2(boolean z11) {
        this.G = z11;
    }
}
