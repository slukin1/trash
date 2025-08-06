package qs;

import a7.e;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import bj.p0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.network.swap.core.bean.SwapAllowLevel;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapAllowLevelController;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.tradenew.helper.a;
import com.zopim.android.sdk.api.ZopimChat;
import i6.k;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.List;
import m9.i;
import m9.t;
import m9.z;
import pro.huobi.R;
import sn.f;
import tg.r;
import ts.a4;
import ts.i1;

public class n1 {

    /* renamed from: a  reason: collision with root package name */
    public h1 f84670a;

    /* renamed from: b  reason: collision with root package name */
    public d0 f84671b;

    /* renamed from: c  reason: collision with root package name */
    public n f84672c;

    /* renamed from: d  reason: collision with root package name */
    public Context f84673d;

    /* renamed from: e  reason: collision with root package name */
    public String f84674e;

    /* renamed from: f  reason: collision with root package name */
    public SwapCurrencyInfo f84675f;

    /* renamed from: g  reason: collision with root package name */
    public String f84676g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<i1> f84677h;

    /* renamed from: i  reason: collision with root package name */
    public TradeType f84678i;

    /* renamed from: j  reason: collision with root package name */
    public a4 f84679j;

    /* renamed from: k  reason: collision with root package name */
    public d f84680k;

    /* renamed from: l  reason: collision with root package name */
    public String f84681l;

    public class a implements a.C0857a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ContractOrderPlace f84682a;

        public a(ContractOrderPlace contractOrderPlace) {
            this.f84682a = contractOrderPlace;
        }

        public void a() {
            n1.this.w().z0(true);
            n1.this.w().pg();
        }

        public void b() {
            n1.this.f84671b.a0(this.f84682a, n1.this.f84675f, n1.this.f84673d);
        }
    }

    public class b extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f84684b;

        public b(int i11) {
            this.f84684b = i11;
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            e.M(this.f84684b, n1.this.f84678i);
            i1 w11 = n1.this.w();
            int i11 = this.f84684b;
            boolean z11 = true;
            if (i11 != 1) {
                z11 = false;
            }
            w11.m(i11, z11);
        }
    }

    public class c extends EasySubscriber<List<LegalRateBean>> {
        public c() {
        }

        public void onAfter() {
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onStart() {
        }

        public void onNext(List<LegalRateBean> list) {
            if (n1.this.w().isCanBeSeen()) {
                MarketCurrentPriceItem w11 = n1.this.f84672c.w();
                if (w11 != null) {
                    w11.p(n1.this.f84672c.z());
                    n1.this.f84679j.H0(w11);
                    n1.this.f84679j.notifyDataSetChanged();
                }
                a4 h11 = n1.this.f84679j;
                n1 n1Var = n1.this;
                h11.X0(n1Var.o(n1Var.f84679j.getInputPriceText()));
            }
        }
    }

    public interface d {
        void b();
    }

    public n1(TradeType tradeType, Context context, SwapCurrencyInfo swapCurrencyInfo, i1 i1Var, a4 a4Var) {
        this.f84677h = new WeakReference<>(i1Var);
        this.f84678i = tradeType;
        this.f84673d = context;
        this.f84675f = swapCurrencyInfo;
        this.f84679j = a4Var;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(HBDialogFragment hBDialogFragment) {
        f.y(this.f84673d, (ZopimChat.SessionConfig) null);
        hBDialogFragment.dismiss();
    }

    public void C() {
        d dVar = this.f84680k;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void D() {
        SwapCurrencyInfo swapCurrencyInfo = this.f84675f;
        if (swapCurrencyInfo != null) {
            this.f84672c.N(this.f84674e, swapCurrencyInfo, this.f84678i);
        }
    }

    public void E(SwapCurrencyInfo swapCurrencyInfo) {
        this.f84675f = swapCurrencyInfo;
        this.f84670a.y0(swapCurrencyInfo);
    }

    public void F(String str) {
        this.f84676g = str;
    }

    public void G(d dVar) {
        this.f84680k = dVar;
    }

    public void H(String str) {
        this.f84674e = str;
    }

    public void I() {
        if (r.x().F0() && z.f().k()) {
            SwapAllowLevel e11 = i.d().e(this.f84674e);
            if (e11 == null || !TextUtils.isEmpty(e11.getAvailableLevelRate())) {
                List<String> c11 = SwapAllowLevelController.c(this.f84674e);
                if (c11 != null && c11.size() > 0) {
                    this.f84679j.y2();
                    return;
                }
                return;
            }
            DialogUtils.b0((FragmentActivity) oa.a.g().b(), this.f84673d.getString(R.string.swap_limit), this.f84673d.getString(R.string.swap_limit_hint), "", this.f84673d.getString(R.string.global_string_cancel), this.f84673d.getString(R.string.account_item_contact), m1.f70421a, new l1(this));
        }
    }

    public boolean J(ContractOrderPlace contractOrderPlace) {
        BigDecimal bigDecimal;
        if (contractOrderPlace.e() == 0) {
            bigDecimal = m.a(contractOrderPlace.b());
        } else {
            bigDecimal = m.a(String.valueOf(contractOrderPlace.z()));
        }
        if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.c()}));
            return false;
        }
        contractOrderPlace.q0(t.b().c(this.f84675f.getContractCode()));
        contractOrderPlace.N0(this.f84674e);
        contractOrderPlace.s0(this.f84676g);
        boolean X = contractOrderPlace.X();
        int Q = contractOrderPlace.Q();
        String w11 = contractOrderPlace.w();
        if (Q != 1) {
            if (this.f84672c.z() != 0.0d) {
                w11 = BigDecimal.valueOf(this.f84672c.z()).toPlainString();
            } else if (this.f84672c.v() != 0.0d) {
                w11 = BigDecimal.valueOf(this.f84672c.v()).toPlainString();
            } else {
                w11 = m.a(contractOrderPlace.m()).toPlainString();
            }
        }
        contractOrderPlace.B0(w11);
        if (this.f84672c.z() != 0.0d) {
            contractOrderPlace.o0(this.f84672c.z());
        } else if (X) {
            if (this.f84672c.A() != 0.0d) {
                contractOrderPlace.o0(this.f84672c.A());
            }
        } else if (this.f84672c.v() != 0.0d) {
            contractOrderPlace.o0(this.f84672c.v());
        }
        this.f84671b.Z(this.f84673d, contractOrderPlace, this.f84675f);
        return contractOrderPlace.Y();
    }

    public void K(ContractOrderPlace contractOrderPlace) {
        BigDecimal bigDecimal;
        k.o("ACTION-SWAP", "币本位永续合约下单点击");
        String S = contractOrderPlace.S();
        boolean X = contractOrderPlace.X();
        int Q = contractOrderPlace.Q();
        String w11 = contractOrderPlace.w();
        int t11 = contractOrderPlace.t();
        BigDecimal a11 = m.a(w11);
        BigDecimal a12 = m.a(S);
        int i11 = 0;
        if (t11 == 1 && a12.compareTo(BigDecimal.ZERO) <= 0) {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.R()}));
        } else if (Q != 1 || a11.compareTo(BigDecimal.ZERO) > 0) {
            if (t11 == 5) {
                BigDecimal a13 = m.a(String.valueOf(n().z()));
                if (X) {
                    if (a11.compareTo(a13) >= 0) {
                        Context context = this.f84673d;
                        HuobiToastUtil.l(context, context.getString(R.string.n_contract_active_price_lower_new_price));
                        return;
                    }
                } else if (a11.compareTo(a13) <= 0) {
                    Context context2 = this.f84673d;
                    HuobiToastUtil.l(context2, context2.getString(R.string.n_contract_active_price_greater_new_price));
                    return;
                }
            }
            BigDecimal a14 = m.a(contractOrderPlace.h());
            if (t11 == 5) {
                if (TextUtils.isEmpty(contractOrderPlace.h())) {
                    HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.g()}));
                    return;
                } else if (a14.compareTo(BigDecimal.ZERO) <= 0) {
                    Context context3 = this.f84673d;
                    HuobiToastUtil.l(context3, context3.getString(R.string.n_contract_call_back_rate_greater_zero));
                    return;
                } else if (a14.compareTo(m.f68179a) >= 0 && !X) {
                    Context context4 = this.f84673d;
                    HuobiToastUtil.l(context4, context4.getString(R.string.n_contract_call_back_rate_lower_hundred));
                    return;
                }
            }
            if (contractOrderPlace.e() == 0) {
                bigDecimal = m.a(contractOrderPlace.b());
            } else {
                bigDecimal = m.a(String.valueOf(contractOrderPlace.z()));
            }
            if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.c()}));
                return;
            }
            if (p0.h() && this.f84679j.W0() && !(this.f84679j.getTpCache() == null && this.f84679j.getSlCache() == null)) {
                if (X && this.f84679j.getTpSlDialogOpenType() != FutureTpSlSettingDialogFragment.OpenType.OpenLong) {
                    HuobiToastUtil.m(this.f84673d.getString(R.string.n_contract_tp_sl_setting_order_tip));
                    return;
                } else if (!X && this.f84679j.getTpSlDialogOpenType() == FutureTpSlSettingDialogFragment.OpenType.OpenLong) {
                    HuobiToastUtil.m(this.f84673d.getString(R.string.n_contract_tp_sl_setting_order_tip));
                    return;
                }
            }
            contractOrderPlace.q0(t.b().c(this.f84675f.getContractCode()));
            contractOrderPlace.N0(this.f84674e);
            contractOrderPlace.s0(this.f84676g);
            if (Q != 1) {
                if (this.f84672c.z() != 0.0d) {
                    w11 = BigDecimal.valueOf(this.f84672c.z()).toPlainString();
                } else if (this.f84672c.v() != 0.0d) {
                    w11 = BigDecimal.valueOf(this.f84672c.v()).toPlainString();
                } else {
                    w11 = m.a(contractOrderPlace.m()).toPlainString();
                }
            }
            contractOrderPlace.B0(w11);
            if (this.f84672c.z() != 0.0d) {
                contractOrderPlace.o0(this.f84672c.z());
            } else if (X) {
                if (this.f84672c.A() != 0.0d) {
                    contractOrderPlace.o0(this.f84672c.A());
                }
            } else if (this.f84672c.v() != 0.0d) {
                contractOrderPlace.o0(this.f84672c.v());
            }
            ContractOrderPlace x11 = this.f84671b.x(this.f84673d, contractOrderPlace, this.f84675f);
            if (x11.Y()) {
                try {
                    i11 = Integer.parseInt(x11.o());
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                if (x11.v() != 0 || i11 <= 5 || !com.huobi.tradenew.helper.a.a().d()) {
                    this.f84671b.a0(x11, this.f84675f, this.f84673d);
                } else {
                    com.huobi.tradenew.helper.a.a().c(this.f84673d, x11.o(), new a(x11));
                }
            }
        } else {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.x()}));
        }
    }

    public void L() {
        SwapCurrencyInfo swapCurrencyInfo = this.f84675f;
        if (swapCurrencyInfo != null) {
            this.f84672c.V(swapCurrencyInfo.getContractShortType(), this.f84674e, false);
        }
    }

    public final void M(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        String str;
        String str2 = "--";
        if (!r.x().F0() || z.f().h() == null || !z.f().k()) {
            this.f84679j.P0(str2, str2);
            return;
        }
        int positionType = this.f84679j.getPositionType();
        if (e.E(TradeType.SWAP)) {
            if (positionType == 0) {
                BigDecimal multiply = this.f84671b.A(this.f84674e).multiply(m.a(this.f84676g));
                str2 = m.q(multiply, us.i.c(this.f84674e));
                str = m.q(multiply, us.i.c(this.f84674e));
            } else if (positionType == 1 && bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal divide = this.f84671b.B(this.f84675f.getContractCode(), true).multiply(bigDecimal2).divide(bigDecimal, 32, 1);
                BigDecimal divide2 = this.f84671b.B(this.f84675f.getContractCode(), false).multiply(bigDecimal2).divide(bigDecimal, 32, 1);
                str2 = m.q(divide, us.i.c(this.f84674e));
                str = m.q(divide2, us.i.c(this.f84674e));
            }
            this.f84679j.P0(str2, str);
        } else if (positionType == 0) {
            if (!(bigDecimal2.compareTo(BigDecimal.ZERO) == 0 || bigDecimal.compareTo(BigDecimal.ZERO) == 0)) {
                BigDecimal divide3 = this.f84671b.A(this.f84674e).multiply(bigDecimal).multiply(m.a(this.f84676g)).divide(bigDecimal2, 32, 1);
                BigDecimal divide4 = this.f84671b.A(this.f84674e).multiply(bigDecimal).multiply(m.a(this.f84676g)).divide(bigDecimal2, 32, 1);
                str2 = m.q(divide3, us.i.b(this.f84674e));
                str = m.q(divide4, us.i.b(this.f84674e));
                this.f84679j.P0(str2, str);
            }
        } else if (positionType == 1) {
            BigDecimal B = this.f84671b.B(this.f84675f.getContractCode(), true);
            BigDecimal B2 = this.f84671b.B(this.f84675f.getContractCode(), false);
            str2 = m.q(B, us.i.b(this.f84674e));
            str = m.q(B2, us.i.b(this.f84674e));
            this.f84679j.P0(str2, str);
        }
        str = str2;
        this.f84679j.P0(str2, str);
    }

    public void N(int i11, int i12) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        String str;
        String str2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        if (this.f84679j.getTradeAmountType() != 0 && this.f84675f != null) {
            BigDecimal r11 = r();
            BigDecimal a11 = m.a(this.f84675f.getContractFace());
            String str3 = "";
            if (r.x().F0()) {
                TradeType tradeType = TradeType.SWAP;
                if (e.E(tradeType)) {
                    if (i11 == 0) {
                        BigDecimal divide = m.a(FutureUnitUtil.e(this.f84671b.A(this.f84674e).multiply(m.a(this.f84676g)).toPlainString(), r11.toPlainString(), this.f84675f.getContractFace(), this.f84678i, FuturePrecisionUtil.g(this.f84674e))).multiply(m.a(String.valueOf(i12))).divide(m.f68179a, us.i.b(this.f84674e), 1);
                        this.f84681l = divide.setScale(us.i.b(this.f84674e), 1).toPlainString();
                        String m11 = m.m(FutureUnitUtil.d(divide.toPlainString(), r11.toPlainString(), this.f84675f.getContractFace(), this.f84678i), us.i.c(this.f84674e));
                        if (e.H(tradeType)) {
                            BigDecimal a12 = m.a(this.f84676g);
                            if (a12.compareTo(BigDecimal.ZERO) == 1) {
                                m11 = m.a(m11).divide(a12, us.i.c(this.f84674e), 1).toPlainString();
                            }
                        }
                        str3 = m11;
                    } else if (i11 == 1 && r11.compareTo(BigDecimal.ZERO) != 0) {
                        BigDecimal multiply = this.f84671b.B(this.f84675f.getContractCode(), true).multiply(m.a(String.valueOf(i12)));
                        BigDecimal bigDecimal5 = m.f68179a;
                        BigDecimal divide2 = multiply.divide(bigDecimal5, 32, 1);
                        BigDecimal divide3 = this.f84671b.B(this.f84675f.getContractCode(), false).multiply(m.a(String.valueOf(i12))).divide(bigDecimal5, 32, 1);
                        if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                            bigDecimal3 = divide2.setScale(us.i.b(this.f84674e), 1);
                        } else {
                            bigDecimal3 = BigDecimal.ONE;
                        }
                        if (divide3.compareTo(BigDecimal.ONE) >= 0 || divide3.compareTo(BigDecimal.ZERO) <= 0) {
                            bigDecimal4 = divide3.setScale(us.i.b(this.f84674e), 1);
                        } else {
                            bigDecimal4 = BigDecimal.ONE;
                        }
                        if (z()) {
                            this.f84681l = bigDecimal3.toPlainString();
                            str3 = m.a(FutureUnitUtil.d(bigDecimal3.toPlainString(), r11.toPlainString(), this.f84675f.getContractFace(), this.f84678i)).setScale(us.i.c(this.f84674e), 1).toPlainString();
                        } else {
                            this.f84681l = bigDecimal4.toPlainString();
                            str3 = m.a(FutureUnitUtil.d(bigDecimal4.toPlainString(), r11.toPlainString(), this.f84675f.getContractFace(), this.f84678i)).setScale(us.i.c(this.f84674e), 1).toPlainString();
                        }
                    }
                } else if (i11 == 0) {
                    if (!(a11.compareTo(BigDecimal.ZERO) == 0 || r11.compareTo(BigDecimal.ZERO) == 0)) {
                        BigDecimal divide4 = this.f84671b.A(this.f84674e).multiply(r11).multiply(m.a(this.f84676g)).divide(a11, 32, 1);
                        BigDecimal divide5 = this.f84671b.A(this.f84674e).multiply(r11).multiply(m.a(this.f84676g)).divide(a11, 32, 1);
                        if (z()) {
                            str2 = divide4.multiply(m.a(String.valueOf(i12))).divide(m.f68179a, us.i.b(this.f84674e), 1).toPlainString();
                        } else {
                            str2 = divide5.multiply(m.a(String.valueOf(i12))).divide(m.f68179a, us.i.b(this.f84674e), 1).toPlainString();
                        }
                        str3 = str2;
                        this.f84681l = str3;
                    }
                } else if (i11 == 1) {
                    BigDecimal B = this.f84671b.B(this.f84675f.getContractCode(), true);
                    BigDecimal B2 = this.f84671b.B(this.f84675f.getContractCode(), false);
                    if (B.compareTo(BigDecimal.ONE) >= 0 || B.compareTo(BigDecimal.ZERO) <= 0) {
                        bigDecimal = B.setScale(us.i.b(this.f84674e), 1);
                    } else {
                        bigDecimal = BigDecimal.ONE;
                    }
                    if (B2.compareTo(BigDecimal.ONE) >= 0 || B2.compareTo(BigDecimal.ZERO) <= 0) {
                        bigDecimal2 = B2.setScale(us.i.b(this.f84674e), 1);
                    } else {
                        bigDecimal2 = BigDecimal.ONE;
                    }
                    if (z()) {
                        str = bigDecimal.multiply(m.a(String.valueOf(i12))).divide(m.f68179a, us.i.b(this.f84674e), 1).toPlainString();
                    } else {
                        str = bigDecimal2.multiply(m.a(String.valueOf(i12))).divide(m.f68179a, us.i.b(this.f84674e), 1).toPlainString();
                    }
                    str3 = str;
                    this.f84681l = str3;
                }
            }
            if (TextUtils.isEmpty(str3) || m.a(str3).compareTo(BigDecimal.ZERO) == 0) {
                this.f84679j.S0(i12 + "%", i12 + "%");
                return;
            }
            this.f84679j.S0(i12 + "%", i12 + "%(≈ " + str3 + ")");
        }
    }

    public final void O(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        BigDecimal a11 = m.a(this.f84679j.getInputAmountText());
        TradeType tradeType = TradeType.SWAP;
        if (e.E(tradeType)) {
            if (bigDecimal2.compareTo(BigDecimal.ZERO) != 0 && this.f84679j.getTradeAmountType() == 0) {
                if (e.H(tradeType) && w().getPositionType() == 0) {
                    a11 = a11.multiply(m.a(this.f84676g));
                }
                bigDecimal3 = a11.multiply(bigDecimal).divide(bigDecimal2, 32, 1);
                this.f84681l = bigDecimal3.setScale(us.i.b(this.f84674e), 1).toPlainString();
            }
        } else if (bigDecimal.compareTo(BigDecimal.ZERO) != 0 && this.f84679j.getTradeAmountType() == 0) {
            bigDecimal3 = a11.multiply(bigDecimal2).divide(bigDecimal, 32, 1);
        }
        if (bigDecimal3.compareTo(BigDecimal.ZERO) > 0) {
            if (!e.E(tradeType)) {
                bigDecimal3 = bigDecimal3.setScale(us.i.y(this.f84674e), 1);
            } else if (w().getPositionType() != 1 && w().getPositionType() != 2) {
                bigDecimal3 = bigDecimal3.setScale(us.i.z(this.f84674e), 1);
            } else if (bigDecimal3.compareTo(BigDecimal.ONE) < 0) {
                bigDecimal3 = bigDecimal3.setScale(us.i.z(this.f84674e), 0);
            } else {
                bigDecimal3 = bigDecimal3.setScale(us.i.z(this.f84674e), 1);
            }
        }
        this.f84679j.x2(bigDecimal3.toPlainString());
    }

    public void i(boolean z11) {
        j(z11, false);
    }

    public void j(boolean z11, boolean z12) {
        if (this.f84675f != null) {
            BigDecimal r11 = r();
            BigDecimal a11 = m.a(this.f84675f.getContractFace());
            M(r11, a11);
            if (!TextUtils.isEmpty(this.f84679j.getInputAmountText()) && !z12) {
                N(this.f84679j.getPositionType(), this.f84679j.getSeekBarProgress());
            }
            O(r11, a11);
        }
    }

    public String[] k(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
        String str2;
        String t11 = t();
        BigDecimal a11 = m.a(String.valueOf(n().z()));
        BigDecimal a12 = m.a(m().getContractFace());
        BigDecimal a13 = m.a(levelAvailableMarginInfo.getAvailableMargin());
        String str3 = "--";
        if (e.E(this.f84678i)) {
            str3 = m.q(a13.multiply(m.a(str)), us.i.c(this.f84675f.getSymbol()));
        } else if (!(a12.compareTo(BigDecimal.ZERO) == 0 || a11.compareTo(BigDecimal.ZERO) == 0)) {
            BigDecimal divide = a13.multiply(a11).multiply(m.a(str)).divide(a12, 32, 1);
            str3 = m.q(divide, us.i.b(t11));
            str2 = m.q(divide, us.i.b(t11));
            return new String[]{str3, str2};
        }
        str2 = str3;
        return new String[]{str3, str2};
    }

    public void l(int i11) {
        if (ContractModuleConfig.a().a()) {
            e.L(i11, this.f84678i).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new b(i11));
            return;
        }
        e.M(i11, this.f84678i);
        i1 w11 = w();
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        w11.m(i11, z11);
    }

    public SwapCurrencyInfo m() {
        return this.f84675f;
    }

    public n n() {
        return this.f84672c;
    }

    public String o(String str) {
        return (TextUtils.isEmpty(str) || InstructionFileId.DOT.equals(str) || "usd".equals(LegalCurrencyConfigUtil.y())) ? "" : LegalCurrencyConfigUtil.B(str);
    }

    public String p() {
        return this.f84676g;
    }

    public TradeType q() {
        return this.f84678i;
    }

    public BigDecimal r() {
        BigDecimal bigDecimal;
        int orderType = this.f84679j.getOrderType();
        int tradePriceType = this.f84679j.getTradePriceType();
        if (orderType == 6) {
            bigDecimal = BigDecimal.ZERO;
        } else if (tradePriceType == 1) {
            bigDecimal = m.a(this.f84679j.getInputPriceText());
        } else if (this.f84672c.z() != 0.0d) {
            bigDecimal = BigDecimal.valueOf(this.f84672c.z());
        } else if (this.f84672c.v() != 0.0d) {
            bigDecimal = BigDecimal.valueOf(this.f84672c.v());
        } else {
            bigDecimal = m.a(t.b().c(this.f84675f.getContractCode()));
        }
        if (orderType == 1 && tradePriceType != 1) {
            bigDecimal = m.a(this.f84679j.getTriggerPriceText());
        }
        return (bigDecimal.compareTo(BigDecimal.ZERO) != 0 || orderType == 1) ? bigDecimal : BigDecimal.valueOf(this.f84672c.z());
    }

    public String s() {
        return this.f84681l;
    }

    public String t() {
        return this.f84674e;
    }

    public d0 u() {
        return this.f84671b;
    }

    public h1 v() {
        return this.f84670a;
    }

    public i1 w() {
        return (i1) this.f84677h.get();
    }

    public void x() {
        LegalCurrencyConfigUtil.X(true).compose(com.hbg.lib.core.util.RxJavaHelper.t(w())).subscribe(new c());
    }

    public void y() {
        this.f84671b = new d0(w());
        h1 h1Var = new h1(w(), this.f84678i);
        this.f84670a = h1Var;
        h1Var.y0(this.f84675f);
        this.f84672c = new n(this.f84679j, this.f84670a, this.f84678i);
    }

    public boolean z() {
        if (w().getPositionType() == 0) {
            if (this.f84679j.getTradePosition() == 0) {
                return true;
            }
            return false;
        } else if (this.f84679j.getTradePosition() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
