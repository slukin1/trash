package com.huobi.tradenew.presenter;

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
import com.huobi.tradenew.prime.helper.TradeMarginHelper;
import com.huobi.tradenew.ui.n3;
import d7.a1;
import java.math.BigDecimal;
import java.math.RoundingMode;
import pro.huobi.R;
import qt.m;
import rt.i;
import ut.o;

public abstract class TradeVerticalBasePresenter<V extends n3> extends TradeBasePresenter<V> {
    public boolean J = false;
    public boolean K;
    public boolean L;

    public void B0(boolean z11, boolean z12) {
        String o02 = o0();
        ((n3) getUI()).n(z12, this.f82879m, o02);
        int i11 = this.f82879m;
        ((n3) getUI()).F(this.f82879m, i11 == 2 || i11 == 3);
        a2();
        c1(false, o02, true);
    }

    public String N0() {
        String inputPriceText = ((n3) getUI()).getInputPriceText();
        return TextUtils.isEmpty(inputPriceText) ? String.valueOf(this.f82875i.z()) : inputPriceText;
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            if (m.a()) {
                i2();
            } else {
                ((n3) getUI()).c(l2());
            }
            ((n3) getUI()).n0();
        }
    }

    public void a2() {
        int i11;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        int i12;
        boolean e12 = e1();
        String o02 = o0();
        if (e12) {
            i11 = ((n3) getUI()).S1();
        } else {
            i11 = ((n3) getUI()).c2();
        }
        TradeType tradeType = TradeType.PRO;
        TradeType tradeType2 = this.f82880n;
        if (tradeType == tradeType2) {
            bigDecimal = R0(e12, o02);
        } else if (TradeType.MARGIN == tradeType2) {
            bigDecimal = this.f82877k.z(o02, e12, i11);
        } else if (TradeType.C2C == tradeType2) {
            bigDecimal = this.f82877k.v(o02, e12);
        } else {
            bigDecimal = this.f82877k.F(tradeType2, o02, e12, i11);
        }
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        int i13 = this.f82879m;
        if (i13 == 0 || i13 == 2) {
            int C = PrecisionUtil.C(o0());
            if (e1()) {
                if (a1.v().Q(o0())) {
                    int y11 = PrecisionUtil.y(o0());
                    if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                        bigDecimal2 = BigDecimal.ZERO.setScale(y11, RoundingMode.FLOOR);
                    } else {
                        bigDecimal2 = bigDecimal.setScale(y11, RoundingMode.FLOOR);
                    }
                } else if (TextUtils.isEmpty(((n3) getUI()).getInputPriceText())) {
                    bigDecimal2 = BigDecimal.ZERO.setScale(C, RoundingMode.FLOOR);
                } else {
                    BigDecimal a11 = i6.m.a(((n3) getUI()).getInputPriceText());
                    if (a11.compareTo(BigDecimal.ZERO) <= 0 || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                        bigDecimal2 = BigDecimal.ZERO.setScale(C, RoundingMode.FLOOR);
                    } else {
                        bigDecimal2 = bigDecimal.divide(a11, C, RoundingMode.FLOOR);
                    }
                }
            } else if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal2 = BigDecimal.ZERO.setScale(C, RoundingMode.FLOOR);
            } else {
                bigDecimal2 = bigDecimal.setScale(C, RoundingMode.FLOOR);
            }
        } else if (i13 != 3) {
            if (i13 != 1 || e1()) {
                i12 = PrecisionUtil.y(o0());
            } else {
                i12 = PrecisionUtil.C(o0());
            }
            if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal2 = BigDecimal.ZERO.setScale(i12, RoundingMode.FLOOR);
            } else {
                bigDecimal2 = bigDecimal.setScale(i12, RoundingMode.FLOOR);
            }
        } else if (!e1()) {
            int C2 = PrecisionUtil.C(o0());
            if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal2 = BigDecimal.ZERO.setScale(C2, RoundingMode.FLOOR);
            } else {
                bigDecimal2 = bigDecimal.setScale(C2, RoundingMode.FLOOR);
            }
        } else if (n2()) {
            int y12 = PrecisionUtil.y(o0());
            if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal2 = BigDecimal.ZERO.setScale(y12, RoundingMode.FLOOR);
            } else {
                bigDecimal2 = bigDecimal.setScale(y12, RoundingMode.FLOOR);
            }
        } else {
            int C3 = PrecisionUtil.C(o0());
            if (TextUtils.isEmpty(((n3) getUI()).getInputPriceText())) {
                bigDecimal2 = BigDecimal.ZERO.setScale(C3, RoundingMode.FLOOR);
            } else {
                BigDecimal a12 = i6.m.a(((n3) getUI()).getInputPriceText());
                if (a12.compareTo(BigDecimal.ZERO) <= 0 || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = BigDecimal.ZERO.setScale(C3, RoundingMode.FLOOR);
                } else {
                    bigDecimal2 = bigDecimal.divide(a12, C3, RoundingMode.FLOOR);
                }
            }
        }
        if (bigDecimal2.compareTo(BigDecimal.ZERO) <= 0) {
            bigDecimal2 = BigDecimal.ZERO.setScale(bigDecimal2.scale(), RoundingMode.FLOOR);
        }
        ((n3) getUI()).setProgressText(bigDecimal2.toPlainString());
    }

    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        i2();
        super.afterSymbolIdChanged(symbolChangeEvent);
        ((n3) getUI()).t(a1.v().J(this.f82871e, this.f82880n));
        this.K = false;
    }

    public void d2(EditText editText, Editable editable, boolean z11) {
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        boolean e12 = e1();
        int i11 = this.f82879m;
        boolean z12 = i11 == 1 && !e12;
        if (i11 == 0 || i11 == 2 || z12) {
            if (!e12 || !a1.v().Q(o0())) {
                String b11 = i6.m.b(editable, 20, PrecisionUtil.C(o0()));
                if (b11 != null) {
                    editText.setText(b11);
                    editText.setSelection(editText.getText().length());
                    return;
                }
            } else {
                String b12 = i6.m.b(editable, 20, PrecisionUtil.y(o0()));
                if (b12 != null) {
                    editText.setText(b12);
                    editText.setSelection(editText.getText().length());
                    return;
                }
            }
        } else if (i11 != 3) {
            String b13 = i6.m.b(editable, 20, PrecisionUtil.y(o0()));
            if (b13 != null) {
                editText.setText(b13);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else if (!e1()) {
            String b14 = i6.m.b(editable, 20, PrecisionUtil.C(o0()));
            if (b14 != null) {
                editText.setText(b14);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else if (n2()) {
            String b15 = i6.m.b(editable, 20, PrecisionUtil.y(o0()));
            if (b15 != null) {
                editText.setText(b15);
                editText.setSelection(editText.getText().length());
                return;
            }
        } else {
            String b16 = i6.m.b(editable, 20, PrecisionUtil.C(o0()));
            if (b16 != null) {
                editText.setText(b16);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        if (editable.length() <= 0 || new BigDecimal(editable.toString()).compareTo(BigDecimal.ZERO) <= 0) {
            ((n3) getUI()).ha(false);
        } else {
            ((n3) getUI()).ha(true);
        }
        e2(z11, e12);
    }

    public void e2(boolean z11, boolean z12) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        int i11;
        BigDecimal bigDecimal3;
        BigDecimal valueOf;
        if (((n3) getUI()).isCanBeSeen()) {
            int i12 = this.f82879m;
            BigDecimal bigDecimal4 = null;
            if (i12 == 0 || i12 == 2) {
                bigDecimal2 = !TextUtils.isEmpty(((n3) getUI()).getInputPriceText()) ? i6.m.a(((n3) getUI()).getInputPriceText()) : null;
                bigDecimal = !TextUtils.isEmpty(((n3) getUI()).getInputAmountText()) ? i6.m.a(((n3) getUI()).getInputAmountText()) : null;
                a2();
                if (!(bigDecimal2 == null || bigDecimal == null)) {
                    bigDecimal4 = bigDecimal2.multiply(bigDecimal);
                }
            } else {
                if (i12 != 3) {
                    if (!TextUtils.isEmpty(((n3) getUI()).getInputAmountText())) {
                        bigDecimal4 = i6.m.a(((n3) getUI()).getInputAmountText());
                        valueOf = BigDecimal.valueOf(this.f82875i.z());
                        if (!z12) {
                            bigDecimal3 = valueOf.multiply(bigDecimal4);
                            BigDecimal bigDecimal5 = bigDecimal3;
                            bigDecimal = bigDecimal4;
                            bigDecimal4 = bigDecimal5;
                        }
                    }
                    bigDecimal2 = null;
                    bigDecimal = null;
                } else if (n2()) {
                    if (!TextUtils.isEmpty(((n3) getUI()).getInputAmountText())) {
                        bigDecimal4 = i6.m.a(((n3) getUI()).getInputAmountText());
                        valueOf = BigDecimal.valueOf(this.f82875i.z());
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
                    bigDecimal2 = !TextUtils.isEmpty(((n3) getUI()).getInputPriceText()) ? i6.m.a(((n3) getUI()).getInputPriceText()) : null;
                    bigDecimal = !TextUtils.isEmpty(((n3) getUI()).getInputAmountText()) ? i6.m.a(((n3) getUI()).getInputAmountText()) : null;
                    a2();
                    if (!(bigDecimal2 == null || bigDecimal == null)) {
                        bigDecimal4 = bigDecimal2.multiply(bigDecimal);
                    }
                }
                bigDecimal = bigDecimal4;
            }
            if (bigDecimal4 != null) {
                bigDecimal4 = f0.i(bigDecimal4, z12, PrecisionUtil.y(this.f82871e));
            }
            if (z12) {
                this.f82877k.k0(bigDecimal4);
            } else {
                this.f82877k.q0(bigDecimal4);
            }
            ((n3) getUI()).l(bigDecimal4);
            ((n3) getUI()).c4(m2(bigDecimal2, bigDecimal));
            U1(bigDecimal4, bigDecimal, z12);
            if (z11) {
                j2(z12);
            }
            if (!this.J) {
                r2(bigDecimal2, bigDecimal);
            }
            if (z11) {
                if (z12) {
                    i11 = ((n3) getUI()).S1();
                } else {
                    i11 = ((n3) getUI()).c2();
                }
                D0(bigDecimal2, bigDecimal, z12, i11);
            }
        }
    }

    public void f2(EditText editText, Editable editable, boolean z11) {
        String str;
        this.L = false;
        boolean e12 = e1();
        ((n3) getUI()).n1(e12);
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        if (e12 && this.f82879m == 1) {
            str = i6.m.b(editable, 20, PrecisionUtil.y(o0()));
        } else if (this.f82879m != 3) {
            str = i6.m.b(editable, 20, PrecisionUtil.A(o0()));
        } else if (!e12) {
            str = i6.m.b(editable, 20, PrecisionUtil.A(o0()));
        } else if (n2()) {
            str = i6.m.b(editable, 20, PrecisionUtil.y(o0()));
        } else {
            str = i6.m.b(editable, 20, PrecisionUtil.A(o0()));
        }
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.getText().length());
            return;
        }
        if (editable.length() <= 0 || new BigDecimal(editable.toString()).compareTo(BigDecimal.ZERO) <= 0) {
            ((n3) getUI()).z(false, 1);
        } else {
            ((n3) getUI()).z(true, 1);
        }
        e2(z11, e12);
    }

    public void g2(EditText editText, Editable editable) {
        ((n3) getUI()).A1(e1());
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String b11 = i6.m.b(editable, 20, PrecisionUtil.A(o0()));
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
        } else if (editable.length() <= 0 || new BigDecimal(editable.toString()).compareTo(BigDecimal.ZERO) <= 0) {
            ((n3) getUI()).z(false, 3);
        } else {
            ((n3) getUI()).z(true, 3);
        }
    }

    public void h2(EditText editText, Editable editable, boolean z11) {
        BigDecimal bigDecimal;
        int i11;
        BigDecimal bigDecimal2;
        boolean e12 = e1();
        if (editable == null || editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String b11 = i6.m.b(editable, 20, PrecisionUtil.y(this.f82871e));
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
            return;
        }
        BigDecimal bigDecimal3 = null;
        BigDecimal a11 = !TextUtils.isEmpty(((n3) getUI()).getInputPriceText()) ? i6.m.a(((n3) getUI()).getInputPriceText()) : null;
        BigDecimal a12 = i6.m.a(editable.toString());
        if (a11 == null || a11.compareTo(BigDecimal.ZERO) == 0) {
            bigDecimal = null;
        } else {
            BigDecimal divide = a12.divide(a11, PrecisionUtil.C(o0()), 1);
            BigDecimal multiply = a11.multiply(divide);
            ((n3) getUI()).setInputAmountText(divide.toPlainString());
            BigDecimal bigDecimal4 = multiply;
            bigDecimal = divide;
            bigDecimal3 = bigDecimal4;
        }
        String o02 = o0();
        if (a11 != null) {
            bigDecimal3 = f0.i(bigDecimal3, e12, PrecisionUtil.y(this.f82871e));
        }
        if (e12) {
            this.f82877k.k0(bigDecimal3);
        } else {
            this.f82877k.q0(bigDecimal3);
        }
        U1(bigDecimal3, bigDecimal, e12);
        if (z11) {
            j2(e12);
        }
        if (!this.J) {
            r2(a11, bigDecimal);
        }
        if (e12) {
            i11 = ((n3) getUI()).S1();
        } else {
            i11 = ((n3) getUI()).c2();
        }
        TradeType tradeType = TradeType.PRO;
        TradeType tradeType2 = this.f82880n;
        if (tradeType == tradeType2) {
            bigDecimal2 = R0(e12, o02);
        } else if (TradeType.MARGIN == tradeType2) {
            bigDecimal2 = this.f82877k.z(o02, e12, i11);
        } else if (TradeType.C2C == tradeType2) {
            bigDecimal2 = this.f82877k.v(o02, e12);
        } else {
            bigDecimal2 = this.f82877k.F(tradeType2, o02, e12, i11);
        }
        ((n3) getUI()).c4(bigDecimal3);
        if (e12) {
            a12.subtract(bigDecimal2).compareTo(BigDecimal.ZERO);
        } else {
            i6.m.a(((n3) getUI()).getInputAmountText()).subtract(bigDecimal2).compareTo(BigDecimal.ZERO);
        }
    }

    public final void i2() {
        q2(0);
        s2();
        ((n3) getUI()).c(0);
    }

    public boolean j2(boolean z11) {
        String str;
        String str2;
        if (getUI() == null || !((n3) getUI()).isAlive()) {
            return false;
        }
        if (this.f82879m == 0 && !o.C().T()) {
            BigDecimal a11 = i6.m.a(((n3) getUI()).getInputPriceText());
            if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                return false;
            }
            BigDecimal valueOf = BigDecimal.valueOf(this.f82875i.z());
            if (valueOf.compareTo(BigDecimal.ZERO) == 0) {
                return true;
            }
            ExchangeSettings b11 = ExchangeSettingsController.d().b(this.f82871e);
            if (b11 != null) {
                str = b11.getBuyLimitMustLessThan();
                str2 = b11.getSellLimitMustGreaterThan();
            } else {
                str = "1.1";
                str2 = "0.9";
            }
            if (z11 && a11.compareTo(valueOf.multiply(i6.m.a(str))) > 0) {
                if (!this.L) {
                    HuobiToastUtil.m(String.format(getActivity().getString(R.string.n_trade_buy_price_high), new Object[]{i6.m.Q(str, 0, 1)}));
                    this.L = true;
                }
                return false;
            } else if (!z11 && a11.compareTo(valueOf.multiply(i6.m.a(str2))) < 0) {
                if (!this.L) {
                    HuobiToastUtil.m(String.format(getActivity().getString(R.string.n_trade_sell_price_low), new Object[]{i6.m.Q(str2, 0, 1)}));
                    this.L = true;
                }
                return false;
            }
        }
        return true;
    }

    public void k2(int i11) {
        this.f82875i.s(this.f82871e, i11);
    }

    public int l2() {
        i iVar = this.f82875i;
        if (iVar != null) {
            return iVar.C();
        }
        return 0;
    }

    public final BigDecimal m2(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal == null || bigDecimal2 == null) {
            return null;
        }
        return this.f82877k.H(this.f82871e, this.f82879m, e1(), e1() ? ((n3) getUI()).getUiPlanTradeBuyMode() : ((n3) getUI()).getUiPlanTradeSellMode(), bigDecimal, bigDecimal2);
    }

    public boolean n2() {
        return this.f82879m == 3 && (((n3) getUI()).getUiPlanTradeBuyMode() == 2 || ((n3) getUI()).getUiPlanTradeSellMode() == 2);
    }

    public void o2(boolean z11) {
        this.J = z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p2(int r9, boolean r10) {
        /*
            r8 = this;
            if (r10 != 0) goto L_0x0003
            return
        L_0x0003:
            int r10 = r8.f82879m
            r0 = 2
            r1 = 3
            r2 = 0
            r3 = 1
            if (r10 != r1) goto L_0x002d
            boolean r10 = r8.n2()
            if (r10 == 0) goto L_0x001d
            rt.i r10 = r8.f82875i
            double r4 = r10.z()
            java.math.BigDecimal r10 = java.math.BigDecimal.valueOf(r4)
        L_0x001b:
            r4 = r2
            goto L_0x004c
        L_0x001d:
            h6.a r10 = r8.getUI()
            com.huobi.tradenew.ui.n3 r10 = (com.huobi.tradenew.ui.n3) r10
            java.lang.String r10 = r10.getInputPriceText()
            java.math.BigDecimal r10 = i6.m.a(r10)
            r4 = r3
            goto L_0x004c
        L_0x002d:
            if (r10 == 0) goto L_0x003d
            if (r10 != r0) goto L_0x0032
            goto L_0x003d
        L_0x0032:
            rt.i r10 = r8.f82875i
            double r4 = r10.z()
            java.math.BigDecimal r10 = java.math.BigDecimal.valueOf(r4)
            goto L_0x001b
        L_0x003d:
            h6.a r10 = r8.getUI()
            com.huobi.tradenew.ui.n3 r10 = (com.huobi.tradenew.ui.n3) r10
            java.lang.String r10 = r10.getInputPriceText()
            java.math.BigDecimal r10 = i6.m.a(r10)
            goto L_0x001b
        L_0x004c:
            tg.r r5 = tg.r.x()
            boolean r5 = r5.F0()
            if (r5 != 0) goto L_0x0057
            return
        L_0x0057:
            int r5 = r8.f82879m
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
            boolean r0 = r8.e1()
            if (r0 == 0) goto L_0x0072
            return
        L_0x0072:
            if (r4 == 0) goto L_0x0083
            java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
            int r0 = r10.compareTo(r0)
            if (r0 != 0) goto L_0x0083
            boolean r0 = r8.e1()
            if (r0 == 0) goto L_0x0083
            return
        L_0x0083:
            long r4 = (long) r9
            java.math.BigDecimal r9 = java.math.BigDecimal.valueOf(r4)
            r4 = 100
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r4)
            java.math.BigDecimal r9 = r9.divide(r0)
            boolean r0 = r8.e1()
            if (r0 == 0) goto L_0x00a3
            h6.a r0 = r8.getUI()
            com.huobi.tradenew.ui.n3 r0 = (com.huobi.tradenew.ui.n3) r0
            int r0 = r0.S1()
            goto L_0x00ad
        L_0x00a3:
            h6.a r0 = r8.getUI()
            com.huobi.tradenew.ui.n3 r0 = (com.huobi.tradenew.ui.n3) r0
            int r0 = r0.c2()
        L_0x00ad:
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.data.symbol.TradeType r5 = r8.f82880n
            if (r4 != r5) goto L_0x00d1
            boolean r0 = r8.i1()
            if (r0 == 0) goto L_0x00c6
            com.huobi.tradenew.prime.helper.TradeMarginHelper r0 = com.huobi.tradenew.prime.helper.TradeMarginHelper.b()
            java.lang.String r0 = r0.c()
            java.math.BigDecimal r0 = i6.m.a(r0)
            goto L_0x0103
        L_0x00c6:
            boolean r0 = r8.e1()
            java.lang.String r4 = r8.f82871e
            java.math.BigDecimal r0 = r8.R0(r0, r4)
            goto L_0x0103
        L_0x00d1:
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.MARGIN
            if (r4 != r5) goto L_0x00e4
            rt.z r4 = r8.f82877k
            java.lang.String r5 = r8.o0()
            boolean r6 = r8.e1()
            java.math.BigDecimal r0 = r4.z(r5, r6, r0)
            goto L_0x0103
        L_0x00e4:
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.C2C
            if (r4 != r5) goto L_0x00f5
            rt.z r0 = r8.f82877k
            java.lang.String r4 = r8.f82871e
            boolean r5 = r8.e1()
            java.math.BigDecimal r0 = r0.v(r4, r5)
            goto L_0x0103
        L_0x00f5:
            rt.z r4 = r8.f82877k
            java.lang.String r6 = r8.o0()
            boolean r7 = r8.e1()
            java.math.BigDecimal r0 = r4.F(r5, r6, r7, r0)
        L_0x0103:
            java.math.BigDecimal r9 = r9.multiply(r0)
            boolean r0 = r8.e1()
            if (r0 == 0) goto L_0x0113
            int r0 = r8.f82879m
            if (r0 != r3) goto L_0x0113
            r0 = r3
            goto L_0x0114
        L_0x0113:
            r0 = r2
        L_0x0114:
            boolean r4 = r8.e1()
            if (r4 == 0) goto L_0x0129
            d7.a1 r4 = d7.a1.v()
            java.lang.String r5 = r8.o0()
            boolean r4 = r4.Q(r5)
            if (r4 == 0) goto L_0x0129
            r2 = r3
        L_0x0129:
            if (r0 != 0) goto L_0x0137
            if (r2 == 0) goto L_0x012e
            goto L_0x0137
        L_0x012e:
            java.lang.String r0 = r8.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.C(r0)
            goto L_0x013f
        L_0x0137:
            java.lang.String r0 = r8.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.y(r0)
        L_0x013f:
            int r2 = r8.f82879m
            if (r2 != r1) goto L_0x0176
            boolean r0 = r8.e1()
            if (r0 == 0) goto L_0x016d
            boolean r0 = r8.n2()
            if (r0 == 0) goto L_0x0158
            java.lang.String r10 = r8.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.y(r10)
            goto L_0x019f
        L_0x0158:
            java.lang.String r0 = r8.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.C(r0)
            java.lang.String r1 = r8.o0()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.math.BigDecimal r9 = r9.divide(r10, r1, r3)
            goto L_0x019f
        L_0x016d:
            java.lang.String r10 = r8.o0()
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.C(r10)
            goto L_0x019f
        L_0x0176:
            boolean r1 = r8.e1()
            if (r1 == 0) goto L_0x019f
            int r1 = r8.f82879m
            if (r1 == r3) goto L_0x019f
            d7.a1 r1 = d7.a1.v()
            java.lang.String r2 = r8.o0()
            boolean r1 = r1.Q(r2)
            if (r1 == 0) goto L_0x0193
            int r1 = r8.f82879m
            if (r1 != 0) goto L_0x0193
            goto L_0x019f
        L_0x0193:
            java.lang.String r1 = r8.o0()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.math.BigDecimal r9 = r9.divide(r10, r1, r3)
        L_0x019f:
            java.math.BigDecimal r10 = java.math.BigDecimal.ZERO
            int r10 = r9.compareTo(r10)
            if (r10 <= 0) goto L_0x01b5
            h6.a r10 = r8.getUI()
            com.huobi.tradenew.ui.n3 r10 = (com.huobi.tradenew.ui.n3) r10
            java.lang.String r9 = i6.m.q(r9, r0)
            r10.setInputAmountText(r9)
            goto L_0x01c4
        L_0x01b5:
            h6.a r9 = r8.getUI()
            com.huobi.tradenew.ui.n3 r9 = (com.huobi.tradenew.ui.n3) r9
            r1 = 0
            java.lang.String r10 = i6.m.i(r1, r0)
            r9.setInputAmountText(r10)
        L_0x01c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradenew.presenter.TradeVerticalBasePresenter.p2(int, boolean):void");
    }

    public void q2(int i11) {
        i iVar = this.f82875i;
        if (iVar != null) {
            iVar.S(i11);
        }
    }

    public final void r2(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
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
            ((n3) getUI()).T2().setProgress(0);
            ((n3) getUI()).Hb(0);
            return;
        }
        String o02 = o0();
        if (e1()) {
            i11 = ((n3) getUI()).S1();
        } else {
            i11 = ((n3) getUI()).c2();
        }
        TradeType tradeType = TradeType.PRO;
        TradeType tradeType2 = this.f82880n;
        if (tradeType == tradeType2) {
            if (i1()) {
                bigDecimal3 = i6.m.a(TradeMarginHelper.b().c());
            } else {
                bigDecimal3 = R0(e1(), this.f82871e);
            }
        } else if (TradeType.MARGIN == tradeType2) {
            bigDecimal3 = this.f82877k.z(o02, e1(), i11);
        } else if (TradeType.C2C == tradeType2) {
            bigDecimal3 = this.f82877k.v(this.f82871e, e1());
        } else {
            bigDecimal3 = this.f82877k.F(tradeType2, this.f82871e, e1(), i11);
        }
        if (e1()) {
            str = a1.v().E(this.f82871e, this.f82880n);
        } else {
            str = a1.v().o(this.f82871e, this.f82880n);
        }
        int a11 = PrecisionUtil.a(this.f82880n, str);
        if (bigDecimal3.compareTo(BigDecimal.ZERO) > 0 && bigDecimal3.setScale(a11, 1).compareTo(BigDecimal.ZERO) > 0) {
            int i13 = 100;
            if (e1()) {
                int i14 = this.f82879m;
                if (i14 == 0 || i14 == 2) {
                    if (a1.v().Q(this.f82871e)) {
                        if (bigDecimal2.compareTo(bigDecimal3) <= 0) {
                            i13 = bigDecimal2.multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
                        }
                    } else if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                        if (bigDecimal2.multiply(bigDecimal).compareTo(bigDecimal3) <= 0) {
                            i13 = bigDecimal2.multiply(bigDecimal).multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
                        }
                    }
                } else if (i14 == 1) {
                    if (bigDecimal2.compareTo(bigDecimal3) <= 0) {
                        i13 = bigDecimal2.multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
                    }
                } else if (i14 == 3) {
                    if (n2()) {
                        if (bigDecimal2.compareTo(bigDecimal3) <= 0) {
                            i13 = bigDecimal2.multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
                        }
                    } else if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                        if (bigDecimal2.multiply(bigDecimal).compareTo(bigDecimal3) <= 0) {
                            i13 = bigDecimal2.multiply(bigDecimal).multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
                        }
                    }
                }
                i13 = 0;
            } else if (bigDecimal2.compareTo(bigDecimal3) <= 0) {
                i13 = bigDecimal2.multiply(BigDecimal.valueOf(100)).divide(bigDecimal3, PrecisionUtil.E(o02), 1).intValue();
            }
            if (i13 >= 0) {
                i12 = i13;
            }
            ((n3) getUI()).T2().setProgress(i12);
            ((n3) getUI()).Hb(i12);
        }
    }

    public void s2() {
        this.f82875i.X(false);
    }
}
