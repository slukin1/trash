package bj;

import android.text.TextUtils;
import android.view.View;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.controller.ContractAllowLevelController;
import com.hbg.lib.network.contract.core.controller.ContractAllowMaxLevelController;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.ContractModuleConfig;
import com.hbg.module.contract.helper.ContractRequestHelper;
import com.huobi.contract.entity.ContractLeverrate;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.j4;
import dj.p1;
import ej.f;
import i6.k;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import u6.g;

public class q2 {

    /* renamed from: a  reason: collision with root package name */
    public h2 f40875a;

    /* renamed from: b  reason: collision with root package name */
    public d1 f40876b;

    /* renamed from: c  reason: collision with root package name */
    public b0 f40877c;

    /* renamed from: d  reason: collision with root package name */
    public BaseCoreActivity f40878d;

    /* renamed from: e  reason: collision with root package name */
    public String f40879e;

    /* renamed from: f  reason: collision with root package name */
    public ContractCurrencyInfo f40880f;

    /* renamed from: g  reason: collision with root package name */
    public String f40881g = "1";

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<p1> f40882h;

    /* renamed from: i  reason: collision with root package name */
    public TradeType f40883i;

    /* renamed from: j  reason: collision with root package name */
    public j4 f40884j;

    /* renamed from: k  reason: collision with root package name */
    public e f40885k;

    /* renamed from: l  reason: collision with root package name */
    public String f40886l;

    public class a extends EasySubscriber<ContractLeverrate> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LeverSelectDialogFragment f40887b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f40888c;

        /* renamed from: bj.q2$a$a  reason: collision with other inner class name */
        public class C0558a extends EasySubscriber<Object> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LeverSelectDialogFragment f40890b;

            public C0558a(LeverSelectDialogFragment leverSelectDialogFragment) {
                this.f40890b = leverSelectDialogFragment;
            }

            public void onError2(Throwable th2) {
                super.onError2(th2);
                this.f40890b.Zh();
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                super.onFailed(aPIStatusErrorException);
                this.f40890b.Zh();
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                ContractUserInfoProvider.i().p(false).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
                this.f40890b.oi();
            }
        }

        public a(LeverSelectDialogFragment leverSelectDialogFragment, Map map) {
            this.f40887b = leverSelectDialogFragment;
            this.f40888c = map;
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void d(LeverSelectDialogFragment leverSelectDialogFragment, View view) {
            leverSelectDialogFragment.Zh();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void f(Map map, LeverSelectDialogFragment leverSelectDialogFragment, View view) {
            q7.a.a().agreeHighLever().b().flatMap(new p2(map)).compose(RxJavaHelper.t((g) null)).subscribe(new C0558a(leverSelectDialogFragment));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: g */
        public void onNext(ContractLeverrate contractLeverrate) {
            super.onNext(contractLeverrate);
            this.f40887b.oi();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f40887b.Zh();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!"1233".equals(aPIStatusErrorException.getErrCode()) || BaseModuleConfig.a().c()) {
                if (BaseModuleConfig.a().c() && aPIStatusErrorException.getErrCode().equals(EasySubscriber.ERROR_CODE_1451)) {
                    this.f40887b.Bi(true);
                } else if (BaseModuleConfig.a().c() || !aPIStatusErrorException.getErrCode().equals(EasySubscriber.ERROR_CODE_1450)) {
                    super.onFailed(aPIStatusErrorException);
                } else {
                    this.f40887b.Bi(false);
                }
                this.f40887b.Zh();
                return;
            }
            us.e.a(this.f40887b.getActivity(), new o2(this.f40887b), new n2(this, this.f40888c, this.f40887b));
        }
    }

    public class b extends EasySubscriber<List<LegalRateBean>> {
        public b() {
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
            if (q2.this.u().isCanBeSeen()) {
                MarketCurrentPriceItem w11 = q2.this.f40877c.w();
                if (w11 != null) {
                    w11.p(q2.this.f40877c.z());
                    q2.this.f40884j.H0(w11);
                    q2.this.f40884j.notifyDataSetChanged();
                }
                j4 d11 = q2.this.f40884j;
                q2 q2Var = q2.this;
                d11.X0(q2Var.m(q2Var.f40884j.getInputPriceText()));
            }
        }
    }

    public class c extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f40893b;

        public c(int i11) {
            this.f40893b = i11;
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            a7.e.M(this.f40893b, q2.this.f40883i);
            p1 u11 = q2.this.u();
            int i11 = this.f40893b;
            boolean z11 = true;
            if (i11 != 1) {
                z11 = false;
            }
            u11.m(i11, z11);
        }
    }

    public class d extends EasySubscriber<Object> {
        public d() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public interface e {
        void b();
    }

    public q2(TradeType tradeType, BaseCoreActivity baseCoreActivity, ContractCurrencyInfo contractCurrencyInfo, p1 p1Var, j4 j4Var) {
        this.f40882h = new WeakReference<>(p1Var);
        this.f40883i = tradeType;
        this.f40878d = baseCoreActivity;
        this.f40880f = contractCurrencyInfo;
        this.f40884j = j4Var;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(HBDialogFragment hBDialogFragment) {
        BaseModuleConfig.a().N(this.f40878d);
        hBDialogFragment.dismiss();
    }

    public void A(LeverSelectDialogFragment leverSelectDialogFragment, String str, String str2) {
        Map<String, Object> b11 = MapParamsBuilder.c().a("symbol", str2).a("lever_rate", str).b();
        ContractRequestHelper.b(b11).compose(RxJavaHelper.t(u())).subscribe(new a(leverSelectDialogFragment, b11));
    }

    public void B() {
        e eVar = this.f40885k;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void C() {
        ContractCurrencyInfo contractCurrencyInfo = this.f40880f;
        if (contractCurrencyInfo != null) {
            this.f40877c.N(this.f40879e, contractCurrencyInfo, this.f40883i);
        }
    }

    public void D(ContractCurrencyInfo contractCurrencyInfo) {
        this.f40880f = contractCurrencyInfo;
        this.f40875a.z0(contractCurrencyInfo);
    }

    public void E(String str) {
        this.f40881g = str;
    }

    public void F(e eVar) {
        this.f40885k = eVar;
    }

    public void G(String str) {
        q7.a.a().v(str).b().compose(RxJavaHelper.t((g) null)).subscribe(new d());
    }

    public void H(String str) {
        this.f40879e = str;
    }

    public void I() {
        if (BaseModuleConfig.a().a() && ContractUserInfoProvider.i().r()) {
            List<String> c11 = ContractAllowMaxLevelController.c(this.f40879e);
            if (c11 == null || !c11.isEmpty()) {
                List<String> c12 = ContractAllowLevelController.c(this.f40879e);
                if (c12 != null && !c12.isEmpty()) {
                    this.f40884j.a();
                    return;
                }
                return;
            }
            BaseCoreActivity baseCoreActivity = this.f40878d;
            DialogUtils.b0(baseCoreActivity, baseCoreActivity.getString(R$string.swap_limit), this.f40878d.getString(R$string.swap_limit_hint), "", this.f40878d.getString(R$string.global_string_cancel), this.f40878d.getString(R$string.account_item_contact), m2.f12459a, new l2(this));
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
            BaseCoreActivity baseCoreActivity = this.f40878d;
            HuobiToastUtil.l(baseCoreActivity, String.format(baseCoreActivity.getString(R$string.input_unknow_text), new Object[]{contractOrderPlace.c()}));
            return false;
        }
        contractOrderPlace.q0(n0.b().c(this.f40879e));
        contractOrderPlace.N0(this.f40879e);
        contractOrderPlace.s0(this.f40881g);
        boolean X = contractOrderPlace.X();
        int Q = contractOrderPlace.Q();
        String w11 = contractOrderPlace.w();
        if (Q != 1) {
            if (this.f40877c.z() != 0.0d) {
                w11 = BigDecimal.valueOf(this.f40877c.z()).toPlainString();
            } else if (this.f40877c.v() != 0.0d) {
                w11 = BigDecimal.valueOf(this.f40877c.v()).toPlainString();
            } else {
                w11 = m.a(contractOrderPlace.m()).toPlainString();
            }
        }
        contractOrderPlace.B0(w11);
        if (this.f40877c.z() != 0.0d) {
            contractOrderPlace.o0(this.f40877c.z());
        } else if (X) {
            if (this.f40877c.A() != 0.0d) {
                contractOrderPlace.o0(this.f40877c.A());
            }
        } else if (this.f40877c.v() != 0.0d) {
            contractOrderPlace.o0(this.f40877c.v());
        }
        ContractCurrencyInfo contractCurrencyInfo = this.f40880f;
        if (contractCurrencyInfo == null) {
            return true;
        }
        return this.f40876b.V(this.f40878d, contractOrderPlace, contractCurrencyInfo).Y();
    }

    public void K(ContractOrderPlace contractOrderPlace) {
        BigDecimal bigDecimal;
        k.o("ACTION-CONTRACT", "交割合约下单点击");
        String S = contractOrderPlace.S();
        boolean X = contractOrderPlace.X();
        int Q = contractOrderPlace.Q();
        String w11 = contractOrderPlace.w();
        int t11 = contractOrderPlace.t();
        BigDecimal a11 = m.a(w11);
        BigDecimal a12 = m.a(S);
        if (t11 != 1 || a12.compareTo(BigDecimal.ZERO) > 0) {
            if (t11 == 5) {
                BigDecimal a13 = m.a(String.valueOf(l().z()));
                if (X) {
                    if (a11.compareTo(a13) >= 0) {
                        BaseCoreActivity baseCoreActivity = this.f40878d;
                        HuobiToastUtil.l(baseCoreActivity, baseCoreActivity.getString(R$string.n_contract_active_price_lower_new_price));
                        return;
                    }
                } else if (a11.compareTo(a13) <= 0) {
                    BaseCoreActivity baseCoreActivity2 = this.f40878d;
                    HuobiToastUtil.l(baseCoreActivity2, baseCoreActivity2.getString(R$string.n_contract_active_price_greater_new_price));
                    return;
                }
            }
            if (Q != 1 || a11.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal a14 = m.a(contractOrderPlace.h());
                if (t11 == 5) {
                    if (TextUtils.isEmpty(contractOrderPlace.h())) {
                        BaseCoreActivity baseCoreActivity3 = this.f40878d;
                        HuobiToastUtil.l(baseCoreActivity3, String.format(baseCoreActivity3.getString(R$string.input_unknow_text), new Object[]{contractOrderPlace.g()}));
                        return;
                    } else if (a14.compareTo(BigDecimal.ZERO) <= 0) {
                        BaseCoreActivity baseCoreActivity4 = this.f40878d;
                        HuobiToastUtil.l(baseCoreActivity4, baseCoreActivity4.getString(R$string.n_contract_call_back_rate_greater_zero));
                        return;
                    } else if (a14.compareTo(m.f68179a) >= 0 && !X) {
                        BaseCoreActivity baseCoreActivity5 = this.f40878d;
                        HuobiToastUtil.l(baseCoreActivity5, baseCoreActivity5.getString(R$string.n_contract_call_back_rate_lower_hundred));
                        return;
                    }
                }
                if (contractOrderPlace.e() == 0) {
                    bigDecimal = m.a(contractOrderPlace.b());
                } else {
                    bigDecimal = m.a(String.valueOf(contractOrderPlace.z()));
                }
                if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                    BaseCoreActivity baseCoreActivity6 = this.f40878d;
                    HuobiToastUtil.l(baseCoreActivity6, String.format(baseCoreActivity6.getString(R$string.input_unknow_text), new Object[]{contractOrderPlace.c()}));
                    return;
                }
                if (p0.h() && this.f40884j.W0() && this.f40884j.b()) {
                    if (X && !this.f40884j.getTpSlDialogOpenTypeisOpenLong()) {
                        HuobiToastUtil.m(this.f40878d.getString(R$string.n_contract_tp_sl_setting_order_tip));
                        return;
                    } else if (!X && this.f40884j.getTpSlDialogOpenTypeisOpenLong()) {
                        HuobiToastUtil.m(this.f40878d.getString(R$string.n_contract_tp_sl_setting_order_tip));
                        return;
                    }
                }
                contractOrderPlace.q0(n0.b().c(this.f40879e));
                contractOrderPlace.N0(this.f40879e);
                contractOrderPlace.s0(this.f40881g);
                if (Q != 1) {
                    if (this.f40877c.z() != 0.0d) {
                        w11 = BigDecimal.valueOf(this.f40877c.z()).toPlainString();
                    } else if (this.f40877c.v() != 0.0d) {
                        w11 = BigDecimal.valueOf(this.f40877c.v()).toPlainString();
                    } else {
                        w11 = m.a(contractOrderPlace.m()).toPlainString();
                    }
                }
                contractOrderPlace.B0(w11);
                if (this.f40877c.z() != 0.0d) {
                    contractOrderPlace.o0(this.f40877c.z());
                } else if (X) {
                    if (this.f40877c.A() != 0.0d) {
                        contractOrderPlace.o0(this.f40877c.A());
                    }
                } else if (this.f40877c.v() != 0.0d) {
                    contractOrderPlace.o0(this.f40877c.v());
                }
                ContractCurrencyInfo contractCurrencyInfo = this.f40880f;
                if (contractCurrencyInfo != null) {
                    ContractOrderPlace N = this.f40876b.N(this.f40878d, contractOrderPlace, contractCurrencyInfo);
                    if (N.Y()) {
                        this.f40876b.W(N, this.f40880f, this.f40878d);
                        return;
                    }
                    return;
                }
                return;
            }
            BaseCoreActivity baseCoreActivity7 = this.f40878d;
            HuobiToastUtil.l(baseCoreActivity7, String.format(baseCoreActivity7.getString(R$string.input_unknow_text), new Object[]{contractOrderPlace.x()}));
            return;
        }
        BaseCoreActivity baseCoreActivity8 = this.f40878d;
        HuobiToastUtil.l(baseCoreActivity8, String.format(baseCoreActivity8.getString(R$string.input_unknow_text), new Object[]{contractOrderPlace.R()}));
    }

    public void L() {
        ContractCurrencyInfo contractCurrencyInfo = this.f40880f;
        if (contractCurrencyInfo != null) {
            this.f40877c.V(contractCurrencyInfo.getContractShortType(), this.f40879e, false);
        }
    }

    public final void M(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        String str;
        String str2 = "--";
        if (!ContractModuleConfig.a().a() || ContractUserInfoProvider.i().o() == null || !ContractUserInfoProvider.i().r()) {
            this.f40884j.P0(str2, str2);
            return;
        }
        int positionType = this.f40884j.getPositionType();
        if (a7.e.E(TradeType.CONTRACT)) {
            if (positionType == 0) {
                str2 = m.q(this.f40876b.w(this.f40879e).multiply(m.a(this.f40881g)), f.n(this.f40880f.getContractCode()));
            } else if (positionType == 1 && bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal divide = this.f40876b.x(this.f40880f.getContractCode(), true).multiply(bigDecimal2).divide(bigDecimal, 32, 1);
                BigDecimal divide2 = this.f40876b.x(this.f40880f.getContractCode(), false).multiply(bigDecimal2).divide(bigDecimal, 32, 1);
                str2 = m.q(divide, f.n(this.f40880f.getContractCode()));
                str = m.q(divide2, f.n(this.f40880f.getContractCode()));
                this.f40884j.P0(str2, str);
            }
        } else if (positionType == 0) {
            if (!(bigDecimal2.compareTo(BigDecimal.ZERO) == 0 || bigDecimal.compareTo(BigDecimal.ZERO) == 0)) {
                str2 = m.q(this.f40876b.w(this.f40879e).multiply(bigDecimal).multiply(m.a(this.f40881g)).divide(bigDecimal2, 32, 1), f.c(this.f40879e));
            }
        } else if (positionType == 1) {
            BigDecimal x11 = this.f40876b.x(this.f40880f.getContractCode(), true);
            BigDecimal x12 = this.f40876b.x(this.f40880f.getContractCode(), false);
            str2 = m.q(x11, f.c(this.f40879e));
            str = m.q(x12, f.c(this.f40879e));
            this.f40884j.P0(str2, str);
        }
        str = str2;
        this.f40884j.P0(str2, str);
    }

    public void N(int i11, int i12) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        String str = "";
        if (this.f40880f != null) {
            if (this.f40884j.getTradeAmountType() != 0) {
                BigDecimal p11 = p();
                BigDecimal a11 = m.a(this.f40880f.getContractFace());
                String r11 = r();
                String n11 = n();
                if (BaseModuleConfig.a().a()) {
                    TradeType tradeType = TradeType.CONTRACT;
                    if (a7.e.E(tradeType)) {
                        if (i11 == 0) {
                            int n12 = f.n(this.f40880f.getContractCode());
                            BigDecimal divide = m.a(FutureUnitUtil.e(this.f40876b.w(r11).multiply(m.a(n11)).setScale(n12, 1).toPlainString(), p11.toPlainString(), this.f40880f.getContractFace(), this.f40883i, FuturePrecisionUtil.g(this.f40879e))).multiply(m.a(String.valueOf(i12))).divide(m.f68179a, f.c(r11), 1);
                            this.f40886l = divide.toPlainString();
                            String m11 = m.m(FutureUnitUtil.d(divide.toPlainString(), p11.toPlainString(), this.f40880f.getContractFace(), this.f40883i), n12);
                            str = (!a7.e.H(tradeType) || m.a(n11).compareTo(BigDecimal.ZERO) != 1) ? m11 : m.a(m11).divide(m.a(n11), n12, 1).toPlainString();
                        } else if (i11 == 1 && p11.compareTo(BigDecimal.ZERO) != 0) {
                            BigDecimal divide2 = this.f40876b.x(this.f40880f.getContractCode(), x()).multiply(m.a(String.valueOf(i12))).divide(m.f68179a, 32, 1);
                            if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                                bigDecimal2 = divide2.setScale(f.t(r11), 1);
                            } else {
                                bigDecimal2 = BigDecimal.ONE;
                            }
                            this.f40886l = bigDecimal2.toPlainString();
                            str = m.a(FutureUnitUtil.d(bigDecimal2.toPlainString(), p11.toPlainString(), this.f40880f.getContractFace(), this.f40883i)).setScale(f.n(this.f40880f.getContractCode()), 1).toPlainString();
                        }
                    } else if (i11 == 0) {
                        BigDecimal divide3 = this.f40876b.w(r11).multiply(p11).multiply(m.a(n11)).divide(a11, f.c(r11), 1).multiply(m.a(String.valueOf(i12))).divide(m.f68179a, f.c(r11), 1);
                        this.f40886l = divide3.toPlainString();
                        str = divide3.toPlainString();
                    } else if (i11 == 1) {
                        BigDecimal divide4 = this.f40876b.x(this.f40880f.getContractCode(), x()).multiply(m.a(String.valueOf(i12))).divide(m.f68179a, 32, 1);
                        if (divide4.compareTo(BigDecimal.ONE) >= 0 || divide4.compareTo(BigDecimal.ZERO) <= 0) {
                            bigDecimal = divide4.setScale(f.t(r11), 1);
                        } else {
                            bigDecimal = BigDecimal.ONE;
                        }
                        this.f40886l = bigDecimal.toPlainString();
                        str = bigDecimal.toPlainString();
                    }
                }
            } else {
                return;
            }
        }
        if (TextUtils.isEmpty(str) || m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            this.f40884j.S0(i12 + "%", i12 + "%");
            return;
        }
        this.f40884j.S0(i12 + "%", i12 + "%(≈ " + str + ")");
    }

    public final void O(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        BigDecimal a11 = m.a(this.f40884j.getInputAmountText());
        TradeType tradeType = TradeType.CONTRACT;
        if (a7.e.E(tradeType)) {
            if (bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal3 = BigDecimal.ZERO;
            } else if (this.f40884j.getTradeAmountType() == 0) {
                if (a7.e.H(tradeType) && u().getPositionType() == 0) {
                    a11 = a11.multiply(m.a(this.f40881g));
                }
                bigDecimal3 = a11.multiply(bigDecimal).divide(bigDecimal2, 32, 1);
                this.f40886l = bigDecimal3.setScale(f.c(this.f40879e), 1).toPlainString();
            }
        } else if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            bigDecimal3 = BigDecimal.ZERO;
        } else if (this.f40884j.getTradeAmountType() == 0) {
            bigDecimal3 = a11.multiply(bigDecimal2).divide(bigDecimal, 32, 1);
        }
        this.f40884j.l(bigDecimal3);
    }

    public void f(boolean z11) {
        g(z11, false);
    }

    public void g(boolean z11, boolean z12) {
        if (this.f40880f != null) {
            BigDecimal p11 = p();
            BigDecimal a11 = m.a(this.f40880f.getContractFace());
            M(p11, a11);
            if (!TextUtils.isEmpty(this.f40884j.getInputAmountText()) && !z12) {
                N(this.f40884j.getPositionType(), this.f40884j.getSeekBarProgress());
            }
            O(p11, a11);
        }
    }

    public String[] h(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
        String str2;
        String r11 = r();
        BigDecimal a11 = m.a(String.valueOf(l().z()));
        BigDecimal a12 = m.a(j().getContractFace());
        BigDecimal a13 = m.a(levelAvailableMarginInfo.getAvailableMargin());
        String str3 = "--";
        if (a7.e.E(this.f40883i)) {
            str3 = m.q(a13.multiply(m.a(str)), f.n(this.f40880f.getContractCode()));
        } else if (!(a12.compareTo(BigDecimal.ZERO) == 0 || a11.compareTo(BigDecimal.ZERO) == 0)) {
            BigDecimal divide = a13.multiply(a11).multiply(m.a(str)).divide(a12, 32, 1);
            str3 = m.q(divide, f.c(r11));
            str2 = m.q(divide, f.c(r11));
            return new String[]{str3, str2};
        }
        str2 = str3;
        return new String[]{str3, str2};
    }

    public void i(int i11) {
        if (ContractModuleConfig.a().a()) {
            a7.e.L(i11, this.f40883i).compose(com.hbg.lib.network.retrofit.rxjava.RxJavaHelper.g((RequestCallback1) null)).subscribe(new c(i11));
            return;
        }
        a7.e.M(i11, this.f40883i);
        p1 u11 = u();
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        u11.m(i11, z11);
    }

    public ContractCurrencyInfo j() {
        return this.f40880f;
    }

    public String k() {
        return ej.g.d(this.f40880f.getContractShortType(), this.f40880f.getContractCode(), 2);
    }

    public b0 l() {
        return this.f40877c;
    }

    public String m(String str) {
        return (TextUtils.isEmpty(str) || InstructionFileId.DOT.equals(str) || "usd".equals(LegalCurrencyConfigUtil.y())) ? "" : LegalCurrencyConfigUtil.B(str);
    }

    public String n() {
        return this.f40881g;
    }

    public TradeType o() {
        return this.f40883i;
    }

    public BigDecimal p() {
        BigDecimal bigDecimal;
        int orderType = this.f40884j.getOrderType();
        int tradePriceType = this.f40884j.getTradePriceType();
        if (orderType == 6) {
            bigDecimal = BigDecimal.ZERO;
        } else if (tradePriceType == 1) {
            bigDecimal = m.a(this.f40884j.getInputPriceText());
        } else if (this.f40877c.z() != 0.0d) {
            bigDecimal = BigDecimal.valueOf(this.f40877c.z());
        } else if (this.f40877c.v() != 0.0d) {
            bigDecimal = BigDecimal.valueOf(this.f40877c.v());
        } else {
            bigDecimal = m.a(n0.b().c(this.f40879e));
        }
        if (orderType == 1 && tradePriceType != 1) {
            bigDecimal = m.a(this.f40884j.getTriggerPriceText());
        }
        return (bigDecimal.compareTo(BigDecimal.ZERO) != 0 || orderType == 1) ? bigDecimal : BigDecimal.valueOf(this.f40877c.z());
    }

    public String q() {
        return this.f40886l;
    }

    public String r() {
        return this.f40879e;
    }

    public d1 s() {
        return this.f40876b;
    }

    public h2 t() {
        return this.f40875a;
    }

    public p1 u() {
        return (p1) this.f40882h.get();
    }

    public void v() {
        LegalCurrencyConfigUtil.X(true).compose(RxJavaHelper.t(u())).subscribe(new b());
    }

    public void w() {
        this.f40876b = new d1(u());
        h2 h2Var = new h2(u(), this.f40883i);
        this.f40875a = h2Var;
        h2Var.z0(this.f40880f);
        this.f40877c = new b0(this.f40884j, this.f40875a, this.f40883i);
    }

    public boolean x() {
        if (u().getPositionType() == 0) {
            if (this.f40884j.getTradePosition() == 0) {
                return true;
            }
            return false;
        } else if (this.f40884j.getTradePosition() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
