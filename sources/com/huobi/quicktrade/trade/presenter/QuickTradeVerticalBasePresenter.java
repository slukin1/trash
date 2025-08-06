package com.huobi.quicktrade.trade.presenter;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.data.symbol.ExchangeSettingsController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ExchangeSettings;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.trade.helper.f0;
import com.huobi.trade.helper.j;
import com.huobi.trade.ui.y3;
import d7.a1;
import dt.r2;
import ht.o;
import i6.m;
import java.math.BigDecimal;
import pro.huobi.R;

public abstract class QuickTradeVerticalBasePresenter<V extends y3> extends QuickTradeBasePresenter<V> {

    /* renamed from: u  reason: collision with root package name */
    public boolean f80596u = false;

    /* renamed from: v  reason: collision with root package name */
    public boolean f80597v;

    public void S0(EditText editText, Editable editable, boolean z11) {
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.dinpro_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.dinpro_medium));
        }
        boolean z02 = z0();
        int i11 = this.f80579j;
        boolean z12 = true;
        if (i11 != 1 || z02) {
            z12 = false;
        }
        if (i11 == 0 || i11 == 2 || z12) {
            String b11 = m.b(editable, 20, PrecisionUtil.C(o0()));
            if (b11 != null) {
                editText.setText(b11);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else if (i11 != 3) {
            String b12 = m.b(editable, 20, PrecisionUtil.y(o0()));
            if (b12 != null) {
                editText.setText(b12);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else if (!z0()) {
            String b13 = m.b(editable, 20, PrecisionUtil.C(o0()));
            if (b13 != null) {
                editText.setText(b13);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else if (a1()) {
            String b14 = m.b(editable, 20, PrecisionUtil.y(o0()));
            if (b14 != null) {
                editText.setText(b14);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else {
            String b15 = m.b(editable, 20, PrecisionUtil.C(o0()));
            if (b15 != null) {
                editText.setText(b15);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        T0(z11, z02);
    }

    public void T0(boolean z11, boolean z12) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal valueOf;
        if (((y3) getUI()).isCanBeSeen()) {
            int i11 = this.f80579j;
            BigDecimal bigDecimal4 = null;
            if (i11 == 0 || i11 == 2) {
                bigDecimal2 = !TextUtils.isEmpty(((y3) getUI()).getInputPriceText()) ? m.a(((y3) getUI()).getInputPriceText()) : null;
                bigDecimal = !TextUtils.isEmpty(((y3) getUI()).getInputAmountText()) ? m.a(((y3) getUI()).getInputAmountText()) : null;
                if (!(bigDecimal2 == null || bigDecimal == null)) {
                    bigDecimal4 = bigDecimal2.multiply(bigDecimal);
                }
            } else {
                if (i11 != 3) {
                    if (!TextUtils.isEmpty(((y3) getUI()).getInputAmountText())) {
                        bigDecimal4 = m.a(((y3) getUI()).getInputAmountText());
                        valueOf = BigDecimal.valueOf(this.f80576g.B());
                        if (!z12) {
                            bigDecimal3 = valueOf.multiply(bigDecimal4);
                            BigDecimal bigDecimal5 = bigDecimal3;
                            bigDecimal = bigDecimal4;
                            bigDecimal4 = bigDecimal5;
                        }
                    }
                    bigDecimal2 = null;
                    bigDecimal = null;
                } else if (a1()) {
                    if (!TextUtils.isEmpty(((y3) getUI()).getInputAmountText())) {
                        bigDecimal4 = m.a(((y3) getUI()).getInputAmountText());
                        valueOf = BigDecimal.valueOf(this.f80576g.B());
                        if (!z12) {
                            bigDecimal3 = valueOf.multiply(bigDecimal4);
                            BigDecimal bigDecimal52 = bigDecimal3;
                            bigDecimal = bigDecimal4;
                            bigDecimal4 = bigDecimal52;
                        }
                    }
                    bigDecimal2 = null;
                    bigDecimal = null;
                } else {
                    bigDecimal2 = !TextUtils.isEmpty(((y3) getUI()).getInputPriceText()) ? m.a(((y3) getUI()).getInputPriceText()) : null;
                    bigDecimal = !TextUtils.isEmpty(((y3) getUI()).getInputAmountText()) ? m.a(((y3) getUI()).getInputAmountText()) : null;
                    if (!(bigDecimal2 == null || bigDecimal == null)) {
                        bigDecimal4 = bigDecimal2.multiply(bigDecimal);
                    }
                }
                bigDecimal = bigDecimal4;
            }
            if (bigDecimal4 != null) {
                bigDecimal4 = f0.i(bigDecimal4, z12, PrecisionUtil.y(this.f80573d));
            }
            if (z12) {
                this.f80577h.j0(bigDecimal4);
            } else {
                this.f80577h.p0(bigDecimal4);
            }
            ((y3) getUI()).l(bigDecimal4);
            if (z11) {
                Y0(z12);
            }
            if (!this.f80596u) {
                e1(bigDecimal2, bigDecimal);
            }
        }
    }

    public void U0(EditText editText, Editable editable, boolean z11) {
        String str;
        this.f80597v = false;
        boolean z02 = z0();
        ((y3) getUI()).n1(z02);
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.dinpro_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.dinpro_medium));
        }
        if (z02 && this.f80579j == 1) {
            str = m.b(editable, 20, PrecisionUtil.y(o0()));
        } else if (this.f80579j != 3) {
            str = m.b(editable, 20, PrecisionUtil.A(o0()));
        } else if (!z02) {
            str = m.b(editable, 20, PrecisionUtil.A(o0()));
        } else if (a1()) {
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
        T0(z11, z02);
    }

    public void V0(EditText editText, Editable editable) {
        ((y3) getUI()).A1(z0());
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.dinpro_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.dinpro_medium));
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

    public void W0(EditText editText, Editable editable, boolean z11) {
        BigDecimal bigDecimal;
        boolean z02 = z0();
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.dinpro_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.dinpro_medium));
        }
        String b11 = m.b(editable, 20, PrecisionUtil.y(this.f80573d));
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
            return;
        }
        BigDecimal bigDecimal2 = null;
        BigDecimal a11 = !TextUtils.isEmpty(((y3) getUI()).getInputPriceText()) ? m.a(((y3) getUI()).getInputPriceText()) : null;
        BigDecimal a12 = m.a(editable.toString());
        if (a11 == null || a11.compareTo(BigDecimal.ZERO) == 0) {
            bigDecimal = null;
        } else {
            BigDecimal divide = a12.divide(a11, PrecisionUtil.C(o0()), 1);
            BigDecimal multiply = a11.multiply(divide);
            ((y3) getUI()).setInputAmountText(divide.toPlainString());
            BigDecimal bigDecimal3 = divide;
            bigDecimal2 = multiply;
            bigDecimal = bigDecimal3;
        }
        if (a11 != null) {
            bigDecimal2 = f0.i(bigDecimal2, z02, PrecisionUtil.y(this.f80573d));
        }
        if (z02) {
            this.f80577h.j0(bigDecimal2);
        } else {
            this.f80577h.p0(bigDecimal2);
        }
        if (z11) {
            Y0(z02);
        }
        if (!this.f80596u) {
            e1(a11, bigDecimal);
        }
    }

    public final void X0() {
        d1(0);
        f1();
        ((y3) getUI()).c(0);
    }

    public boolean Y0(boolean z11) {
        String str;
        String str2;
        if (getUI() == null || !((y3) getUI()).isAlive()) {
            return false;
        }
        if (this.f80579j == 0 && !o.B().P()) {
            BigDecimal a11 = m.a(((y3) getUI()).getInputPriceText());
            if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                return false;
            }
            BigDecimal valueOf = BigDecimal.valueOf(this.f80576g.B());
            if (valueOf.compareTo(BigDecimal.ZERO) == 0) {
                return true;
            }
            ExchangeSettings b11 = ExchangeSettingsController.d().b(this.f80573d);
            if (b11 != null) {
                str = b11.getBuyLimitMustLessThan();
                str2 = b11.getSellLimitMustGreaterThan();
            } else {
                str = "1.1";
                str2 = "0.9";
            }
            if (z11 && a11.compareTo(valueOf.multiply(m.a(str))) > 0) {
                if (!this.f80597v) {
                    HuobiToastUtil.m(String.format(getActivity().getString(R.string.n_trade_buy_price_high), new Object[]{m.Q(str, 0, 1)}));
                    this.f80597v = true;
                }
                return false;
            } else if (!z11 && a11.compareTo(valueOf.multiply(m.a(str2))) < 0) {
                if (!this.f80597v) {
                    HuobiToastUtil.m(String.format(getActivity().getString(R.string.n_trade_sell_price_low), new Object[]{m.Q(str2, 0, 1)}));
                    this.f80597v = true;
                }
                return false;
            }
        }
        return true;
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            if (j.a()) {
                X0();
            } else {
                ((y3) getUI()).c(Z0());
            }
            ((y3) getUI()).n0();
        }
    }

    public int Z0() {
        r2 r2Var = this.f80576g;
        if (r2Var != null) {
            return r2Var.E();
        }
        return 0;
    }

    public boolean a1() {
        return this.f80579j == 3 && (((y3) getUI()).getUiPlanTradeBuyMode() == 2 || ((y3) getUI()).getUiPlanTradeSellMode() == 2);
    }

    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        X0();
        super.afterSymbolIdChanged(symbolChangeEvent);
        ((y3) getUI()).t(a1.v().J(this.f80573d, this.f80580k));
    }

    public void b1(boolean z11) {
        this.f80596u = z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c1(int r9, boolean r10) {
        /*
            r8 = this;
            if (r10 != 0) goto L_0x0003
            return
        L_0x0003:
            int r10 = r8.f80579j
            r0 = 2
            r1 = 3
            r2 = 0
            r3 = 1
            if (r10 != r1) goto L_0x002d
            boolean r10 = r8.a1()
            if (r10 == 0) goto L_0x001d
            dt.r2 r10 = r8.f80576g
            double r4 = r10.B()
            java.math.BigDecimal r10 = java.math.BigDecimal.valueOf(r4)
        L_0x001b:
            r4 = r2
            goto L_0x004c
        L_0x001d:
            h6.a r10 = r8.getUI()
            com.huobi.trade.ui.y3 r10 = (com.huobi.trade.ui.y3) r10
            java.lang.String r10 = r10.getInputPriceText()
            java.math.BigDecimal r10 = i6.m.a(r10)
            r4 = r3
            goto L_0x004c
        L_0x002d:
            if (r10 == 0) goto L_0x003d
            if (r10 != r0) goto L_0x0032
            goto L_0x003d
        L_0x0032:
            dt.r2 r10 = r8.f80576g
            double r4 = r10.B()
            java.math.BigDecimal r10 = java.math.BigDecimal.valueOf(r4)
            goto L_0x001b
        L_0x003d:
            h6.a r10 = r8.getUI()
            com.huobi.trade.ui.y3 r10 = (com.huobi.trade.ui.y3) r10
            java.lang.String r10 = r10.getInputPriceText()
            java.math.BigDecimal r10 = i6.m.a(r10)
            goto L_0x001b
        L_0x004c:
            tg.r r5 = tg.r.x()
            boolean r5 = r5.F0()
            if (r5 != 0) goto L_0x0057
            return
        L_0x0057:
            int r5 = r8.f80579j
            if (r5 == 0) goto L_0x0060
            if (r5 != r0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r0 = r2
            goto L_0x0061
        L_0x0060:
            r0 = r3
        L_0x0061:
            if (r0 == 0) goto L_0x0072
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            int r0 = r10.compareTo(r0)
            if (r0 != 0) goto L_0x0072
            boolean r0 = r8.z0()
            if (r0 == 0) goto L_0x0072
            return
        L_0x0072:
            if (r4 == 0) goto L_0x0083
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            int r0 = r10.compareTo(r0)
            if (r0 != 0) goto L_0x0083
            boolean r0 = r8.z0()
            if (r0 == 0) goto L_0x0083
            return
        L_0x0083:
            long r4 = (long) r9
            java.math.BigDecimal r9 = java.math.BigDecimal.valueOf(r4)
            r4 = 100
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r4)
            java.math.BigDecimal r9 = r9.divide(r0)
            boolean r0 = r8.z0()
            if (r0 == 0) goto L_0x00a3
            h6.a r0 = r8.getUI()
            com.huobi.trade.ui.y3 r0 = (com.huobi.trade.ui.y3) r0
            int r0 = r0.S1()
            goto L_0x00ad
        L_0x00a3:
            h6.a r0 = r8.getUI()
            com.huobi.trade.ui.y3 r0 = (com.huobi.trade.ui.y3) r0
            int r0 = r0.c2()
        L_0x00ad:
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.data.symbol.TradeType r5 = r8.f80580k
            if (r4 != r5) goto L_0x00be
            boolean r0 = r8.z0()
            java.lang.String r4 = r8.f80573d
            java.math.BigDecimal r0 = r8.q0(r0, r4)
            goto L_0x00f0
        L_0x00be:
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.MARGIN
            if (r4 != r5) goto L_0x00d1
            dt.d3 r4 = r8.f80577h
            java.lang.String r5 = r8.o0()
            boolean r6 = r8.z0()
            java.math.BigDecimal r0 = r4.z(r5, r6, r0)
            goto L_0x00f0
        L_0x00d1:
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.C2C
            if (r4 != r5) goto L_0x00e2
            dt.d3 r0 = r8.f80577h
            java.lang.String r4 = r8.f80573d
            boolean r5 = r8.z0()
            java.math.BigDecimal r0 = r0.w(r4, r5)
            goto L_0x00f0
        L_0x00e2:
            dt.d3 r4 = r8.f80577h
            java.lang.String r6 = r8.o0()
            boolean r7 = r8.z0()
            java.math.BigDecimal r0 = r4.G(r5, r6, r7, r0)
        L_0x00f0:
            java.math.BigDecimal r9 = r9.multiply(r0)
            boolean r0 = r8.z0()
            if (r0 == 0) goto L_0x0100
            int r0 = r8.f80579j
            if (r0 != r3) goto L_0x0100
            r0 = r3
            goto L_0x0101
        L_0x0100:
            r0 = r2
        L_0x0101:
            boolean r4 = r8.z0()
            if (r4 == 0) goto L_0x0116
            d7.a1 r4 = d7.a1.v()
            java.lang.String r5 = r8.o0()
            boolean r4 = r4.Q(r5)
            if (r4 == 0) goto L_0x0116
            r2 = r3
        L_0x0116:
            if (r0 != 0) goto L_0x0124
            if (r2 == 0) goto L_0x011b
            goto L_0x0124
        L_0x011b:
            java.lang.String r0 = r8.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.C(r0)
            goto L_0x012c
        L_0x0124:
            java.lang.String r0 = r8.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.y(r0)
        L_0x012c:
            int r2 = r8.f80579j
            if (r2 != r1) goto L_0x0163
            boolean r0 = r8.z0()
            if (r0 == 0) goto L_0x015a
            boolean r0 = r8.a1()
            if (r0 == 0) goto L_0x0145
            java.lang.String r10 = r8.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.y(r10)
            goto L_0x0179
        L_0x0145:
            java.lang.String r0 = r8.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.C(r0)
            java.lang.String r1 = r8.o0()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.math.BigDecimal r9 = r9.divide(r10, r1, r3)
            goto L_0x0179
        L_0x015a:
            java.lang.String r10 = r8.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.C(r10)
            goto L_0x0179
        L_0x0163:
            boolean r1 = r8.z0()
            if (r1 == 0) goto L_0x0179
            int r1 = r8.f80579j
            if (r1 == r3) goto L_0x0179
            java.lang.String r1 = r8.o0()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.math.BigDecimal r9 = r9.divide(r10, r1, r3)
        L_0x0179:
            java.math.BigDecimal r10 = java.math.BigDecimal.ZERO
            int r10 = r9.compareTo(r10)
            if (r10 <= 0) goto L_0x018f
            h6.a r10 = r8.getUI()
            com.huobi.trade.ui.y3 r10 = (com.huobi.trade.ui.y3) r10
            java.lang.String r9 = i6.m.q(r9, r0)
            r10.setInputAmountText(r9)
            goto L_0x019e
        L_0x018f:
            h6.a r9 = r8.getUI()
            com.huobi.trade.ui.y3 r9 = (com.huobi.trade.ui.y3) r9
            r1 = 0
            java.lang.String r10 = i6.m.i(r1, r0)
            r9.setInputAmountText(r10)
        L_0x019e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.quicktrade.trade.presenter.QuickTradeVerticalBasePresenter.c1(int, boolean):void");
    }

    public void d1(int i11) {
        r2 r2Var = this.f80576g;
        if (r2Var != null) {
            r2Var.U(i11);
        }
    }

    public final void e1(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        int i11;
        BigDecimal bigDecimal3;
        String str;
        if (bigDecimal == null) {
            bigDecimal = BigDecimal.ZERO;
        }
        if (bigDecimal2 == null) {
            bigDecimal2 = BigDecimal.ZERO;
        }
        int i12 = 0;
        if (bigDecimal2.compareTo(BigDecimal.ZERO) <= 0) {
            ((y3) getUI()).T2().setProgress(0);
            return;
        }
        String o02 = o0();
        if (z0()) {
            i11 = ((y3) getUI()).S1();
        } else {
            i11 = ((y3) getUI()).c2();
        }
        TradeType tradeType = TradeType.PRO;
        TradeType tradeType2 = this.f80580k;
        if (tradeType == tradeType2) {
            bigDecimal3 = q0(z0(), this.f80573d);
        } else if (TradeType.MARGIN == tradeType2) {
            bigDecimal3 = this.f80577h.z(o02, z0(), i11);
        } else if (TradeType.C2C == tradeType2) {
            bigDecimal3 = this.f80577h.w(this.f80573d, z0());
        } else {
            bigDecimal3 = this.f80577h.G(tradeType2, this.f80573d, z0(), i11);
        }
        if (z0()) {
            str = a1.v().E(this.f80573d, this.f80580k);
        } else {
            str = a1.v().o(this.f80573d, this.f80580k);
        }
        int a11 = PrecisionUtil.a(this.f80580k, str);
        if (bigDecimal3.compareTo(BigDecimal.ZERO) > 0 && bigDecimal3.setScale(a11, 1).compareTo(BigDecimal.ZERO) > 0) {
            if (z0()) {
                int i13 = this.f80579j;
                if (i13 == 0 || i13 == 2) {
                    if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                        i12 = bigDecimal2.multiply(bigDecimal).multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
                    }
                } else if (i13 == 1) {
                    i12 = bigDecimal2.multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
                } else if (i13 == 3) {
                    if (a1()) {
                        i12 = bigDecimal2.multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
                    } else if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                        i12 = bigDecimal2.multiply(bigDecimal).multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
                    }
                }
            } else {
                i12 = bigDecimal2.multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
            }
            ((y3) getUI()).T2().setProgress(i12);
        }
    }

    public void f1() {
        this.f80576g.Z(false);
    }

    public void i0(boolean z11, boolean z12) {
        String o02 = o0();
        ((y3) getUI()).n(z12, this.f80579j, o02);
        int i11 = this.f80579j;
        ((y3) getUI()).F(this.f80579j, i11 == 2 || i11 == 3);
        x0(false, o02, true);
    }
}
