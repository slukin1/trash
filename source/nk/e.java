package nk;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import bj.p0;
import cn.k2;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.linear.swap.controller.LinearSwapAllowLevelController;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapLeverRate;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.controller.FutureMarketDepthController;
import com.huobi.feature.controller.FutureTradeActionController;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.tradenew.helper.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zopim.android.sdk.api.ZopimChat;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.List;
import pk.o;
import pro.huobi.R;
import rx.Observable;
import sn.f;
import tg.r;
import u6.g;
import ym.f1;
import ym.k;
import ym.z;
import z6.l;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public b f47638a;

    /* renamed from: b  reason: collision with root package name */
    public FutureTradeActionController f47639b;

    /* renamed from: c  reason: collision with root package name */
    public FutureMarketDepthController f47640c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentActivity f47641d;

    /* renamed from: e  reason: collision with root package name */
    public String f47642e;

    /* renamed from: f  reason: collision with root package name */
    public FutureContractInfo f47643f;

    /* renamed from: g  reason: collision with root package name */
    public String f47644g;

    /* renamed from: h  reason: collision with root package name */
    public int f47645h;

    /* renamed from: i  reason: collision with root package name */
    public WeakReference<o> f47646i;

    /* renamed from: j  reason: collision with root package name */
    public TradeType f47647j;

    /* renamed from: k  reason: collision with root package name */
    public com.huobi.feature.ui.a f47648k;

    /* renamed from: l  reason: collision with root package name */
    public AccountBalanceInfoV5 f47649l;

    /* renamed from: m  reason: collision with root package name */
    public d f47650m;

    /* renamed from: n  reason: collision with root package name */
    public String f47651n;

    public class a implements a.C0857a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ContractOrderPlace f47652a;

        public a(ContractOrderPlace contractOrderPlace) {
            this.f47652a = contractOrderPlace;
        }

        public void a() {
            e.this.y().z0(true);
            e.this.O();
        }

        public void b() {
            e.this.f47639b.w(this.f47652a, e.this.f47643f, e.this.f47641d);
        }
    }

    public class b extends EasySubscriber<List<LegalRateBean>> {
        public b() {
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onNext(List<LegalRateBean> list) {
            if (e.this.y().isCanBeSeen()) {
                MarketCurrentPriceItem d11 = e.this.f47640c.d();
                if (d11 != null) {
                    d11.p(e.this.f47640c.e());
                    e.this.f47648k.H0(d11);
                    e.this.f47648k.notifyDataSetChanged();
                }
                com.huobi.feature.ui.a g11 = e.this.f47648k;
                e eVar = e.this;
                g11.X0(eVar.q(eVar.f47648k.getInputPriceText()));
            }
        }
    }

    public class c extends EasySubscriber<LinearSwapLeverRate> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LeverSelectDialogFragment f47655b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47656c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47657d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47658e;

        public class a extends EasySubscriber<Object> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LeverSelectDialogFragment f47660b;

            public a(LeverSelectDialogFragment leverSelectDialogFragment) {
                this.f47660b = leverSelectDialogFragment;
            }

            public void onError2(Throwable th2) {
                super.onError2(th2);
                this.f47660b.Zh();
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                super.onFailed(aPIStatusErrorException);
                this.f47660b.Zh();
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                l.c().d(e.this.f47647j, false).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
                this.f47660b.oi();
            }
        }

        public c(LeverSelectDialogFragment leverSelectDialogFragment, String str, String str2, int i11) {
            this.f47655b = leverSelectDialogFragment;
            this.f47656c = str;
            this.f47657d = str2;
            this.f47658e = i11;
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void d(LeverSelectDialogFragment leverSelectDialogFragment, View view) {
            leverSelectDialogFragment.Zh();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Observable e(String str, String str2, int i11, Object obj) {
            return e.this.n(str, str2, i11);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void f(String str, String str2, int i11, LeverSelectDialogFragment leverSelectDialogFragment, View view) {
            h8.a.a().agreeHighLever().b().flatMap(new h(this, str, str2, i11)).compose(RxJavaHelper.t((g) null)).subscribe(new a(leverSelectDialogFragment));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: g */
        public void onNext(LinearSwapLeverRate linearSwapLeverRate) {
            super.onNext(linearSwapLeverRate);
            this.f47655b.oi();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f47655b.Zh();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!"1233".equals(aPIStatusErrorException.getErrCode()) || r.x().X()) {
                if (BaseModuleConfig.a().c() && aPIStatusErrorException.getErrCode().equals(EasySubscriber.ERROR_CODE_1451)) {
                    this.f47655b.Bi(true);
                } else if (BaseModuleConfig.a().c() || !aPIStatusErrorException.getErrCode().equals(EasySubscriber.ERROR_CODE_1450)) {
                    super.onFailed(aPIStatusErrorException);
                } else {
                    this.f47655b.Bi(false);
                }
                this.f47655b.Zh();
                return;
            }
            us.e.a(this.f47655b.getActivity(), new f(this.f47655b), new g(this, this.f47656c, this.f47657d, this.f47658e, this.f47655b));
        }
    }

    public interface d {
        void b();
    }

    public e(TradeType tradeType, FragmentActivity fragmentActivity, FutureContractInfo futureContractInfo, o oVar, com.huobi.feature.ui.a aVar) {
        this.f47646i = new WeakReference<>(oVar);
        this.f47647j = tradeType;
        this.f47641d = fragmentActivity;
        this.f47643f = futureContractInfo;
        this.f47648k = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(HBDialogFragment hBDialogFragment) {
        f.y(this.f47641d, (ZopimChat.SessionConfig) null);
        hBDialogFragment.dismiss();
    }

    public void A() {
        this.f47638a = new f1((k2) y(), this.f47647j);
        this.f47639b = new z((k2) y());
        this.f47640c = new k(this.f47648k, this.f47638a, this.f47647j);
        this.f47638a.f(this.f47643f);
    }

    public boolean B() {
        FutureContractInfo futureContractInfo = this.f47643f;
        return futureContractInfo == null || futureContractInfo.isLinearSwapSwap();
    }

    public void E(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
        if (this.f47647j == TradeType.LINEAR_SWAP) {
            G(leverSelectDialogFragment, str, this.f47643f.getContractCode(), this.f47645h);
        }
    }

    public void F() {
        d dVar = this.f47650m;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void G(LeverSelectDialogFragment leverSelectDialogFragment, String str, String str2, int i11) {
        n(str2, str, i11).compose(RxJavaHelper.t(y())).subscribe(new c(leverSelectDialogFragment, str2, str, i11));
    }

    public void H() {
        FutureContractInfo futureContractInfo = this.f47643f;
        if (futureContractInfo != null) {
            this.f47640c.i(this.f47642e, futureContractInfo, this.f47647j);
        }
    }

    public void I(AccountBalanceInfoV5 accountBalanceInfoV5) {
        this.f47649l = accountBalanceInfoV5;
    }

    public void J(FutureContractInfo futureContractInfo) {
        this.f47643f = futureContractInfo;
        this.f47638a.f(futureContractInfo);
    }

    public void K(String str) {
        this.f47644g = str;
    }

    public void L(int i11) {
        this.f47645h = i11;
    }

    public void M(d dVar) {
        this.f47650m = dVar;
    }

    public void N(String str) {
        this.f47642e = str;
    }

    public void O() {
        if (this.f47647j == TradeType.LINEAR_SWAP && r.x().F0() && l.c().i(this.f47647j)) {
            List<String> d11 = LinearSwapAllowLevelController.d(this.f47643f.getContractCode(), this.f47645h);
            if (d11 == null || d11.size() <= 0) {
                FragmentActivity fragmentActivity = this.f47641d;
                DialogUtils.b0(fragmentActivity, fragmentActivity.getString(R.string.swap_limit), this.f47641d.getString(R.string.swap_limit_hint), "", this.f47641d.getString(R.string.global_string_cancel), this.f47641d.getString(R.string.account_item_contact), d.f58545a, new c(this));
                return;
            }
            this.f47648k.y2();
        }
    }

    public boolean P(ContractOrderPlace contractOrderPlace) {
        BigDecimal bigDecimal;
        contractOrderPlace.N0(this.f47642e);
        contractOrderPlace.s0(this.f47644g);
        contractOrderPlace.r0(this.f47640c.e());
        contractOrderPlace.i0(this.f47640c.c());
        contractOrderPlace.G0(this.f47640c.f());
        contractOrderPlace.v0(this.f47645h);
        if (contractOrderPlace.e() == 0) {
            bigDecimal = m.a(contractOrderPlace.b());
        } else {
            bigDecimal = m.a(String.valueOf(contractOrderPlace.z()));
        }
        if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.c()}));
            return false;
        }
        this.f47639b.v(this.f47641d, contractOrderPlace, this.f47643f);
        return contractOrderPlace.Y();
    }

    public void Q(ContractOrderPlace contractOrderPlace) {
        BigDecimal bigDecimal;
        if (this.f47645h == 1) {
            i6.k.o("ACTION-LINEAR_SWAP", "u本位全仓永续合约下单点击");
        } else {
            i6.k.o("ACTION-LINEAR_SWAP", "u本位逐仓永续合约下单点击");
        }
        String S = contractOrderPlace.S();
        boolean X = contractOrderPlace.X();
        int Q = contractOrderPlace.Q();
        String w11 = contractOrderPlace.w();
        int t11 = contractOrderPlace.t();
        BigDecimal a11 = m.a(w11);
        BigDecimal a12 = m.a(S);
        int i11 = 0;
        if (t11 != 1 || a12.compareTo(BigDecimal.ZERO) > 0) {
            if (t11 == 5) {
                BigDecimal a13 = m.a(String.valueOf(p().e()));
                if (X) {
                    if (a11.compareTo(a13) >= 0) {
                        FragmentActivity fragmentActivity = this.f47641d;
                        HuobiToastUtil.l(fragmentActivity, fragmentActivity.getString(R.string.n_contract_active_price_lower_new_price));
                        return;
                    }
                } else if (a11.compareTo(a13) <= 0) {
                    FragmentActivity fragmentActivity2 = this.f47641d;
                    HuobiToastUtil.l(fragmentActivity2, fragmentActivity2.getString(R.string.n_contract_active_price_greater_new_price));
                    return;
                }
            }
            if (Q != 1 || a11.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal a14 = m.a(contractOrderPlace.h());
                if (t11 == 5) {
                    if (TextUtils.isEmpty(contractOrderPlace.h())) {
                        HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.g()}));
                        return;
                    } else if (a14.compareTo(BigDecimal.ZERO) <= 0) {
                        FragmentActivity fragmentActivity3 = this.f47641d;
                        HuobiToastUtil.l(fragmentActivity3, fragmentActivity3.getString(R.string.n_contract_call_back_rate_greater_zero));
                        return;
                    } else if (a14.compareTo(m.f68179a) >= 0 && !X) {
                        FragmentActivity fragmentActivity4 = this.f47641d;
                        HuobiToastUtil.l(fragmentActivity4, fragmentActivity4.getString(R.string.n_contract_call_back_rate_lower_hundred));
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
                if ((p0.h() || p0.g()) && this.f47648k.W0() && !(this.f47648k.getTpCache() == null && this.f47648k.getSlCache() == null)) {
                    if (X && this.f47648k.getTpSlDialogOpenType() != FutureTpSlSettingDialogFragment.OpenType.OpenLong) {
                        HuobiToastUtil.m(this.f47641d.getString(R.string.n_contract_tp_sl_setting_order_tip));
                        return;
                    } else if (!X && this.f47648k.getTpSlDialogOpenType() == FutureTpSlSettingDialogFragment.OpenType.OpenLong) {
                        HuobiToastUtil.m(this.f47641d.getString(R.string.n_contract_tp_sl_setting_order_tip));
                        return;
                    }
                }
                contractOrderPlace.N0(this.f47642e);
                contractOrderPlace.s0(this.f47644g);
                contractOrderPlace.r0(this.f47640c.e());
                contractOrderPlace.i0(this.f47640c.c());
                contractOrderPlace.G0(this.f47640c.f());
                contractOrderPlace.v0(this.f47645h);
                ContractOrderPlace e11 = this.f47639b.e(this.f47641d, contractOrderPlace, this.f47643f);
                if (e11.Y()) {
                    try {
                        i11 = Integer.parseInt(e11.o());
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                    if (e11.v() != 0 || i11 <= 5 || !com.huobi.tradenew.helper.a.a().d()) {
                        this.f47639b.w(e11, this.f47643f, this.f47641d);
                    } else {
                        com.huobi.tradenew.helper.a.a().c(this.f47641d, e11.o(), new a(e11));
                    }
                }
            } else {
                HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.x()}));
            }
        } else {
            HuobiToastUtil.l(j.c(), String.format(j.c().getString(R.string.input_unknow_text), new Object[]{contractOrderPlace.R()}));
        }
    }

    public void R() {
        FutureContractInfo futureContractInfo = this.f47643f;
        if (futureContractInfo != null) {
            this.f47640c.k(futureContractInfo.getContractCode(), this.f47642e, false);
        }
    }

    public final void S(ContractOrderPlace contractOrderPlace) {
        String str;
        String str2;
        String plainString;
        String str3 = "--";
        if (!r.x().F0() || l.c().g(this.f47647j) == null || !l.c().i(this.f47647j)) {
            this.f47648k.P0(str3, str3);
            return;
        }
        int v11 = contractOrderPlace.v();
        if (TextUtils.isEmpty(contractOrderPlace.w()) && this.f47648k.getOrderType() != 1) {
            contractOrderPlace.B0(String.valueOf(contractOrderPlace.n()));
        }
        if (a7.e.E(this.f47647j)) {
            if (v11 == 0) {
                this.f47639b.d(contractOrderPlace, this.f47643f);
                this.f47639b.b(contractOrderPlace, this.f47643f);
            } else {
                this.f47639b.c(contractOrderPlace, this.f47643f);
                this.f47639b.a(contractOrderPlace, this.f47643f);
            }
            if (this.f47639b.g() == null) {
                str2 = str3;
            } else {
                str2 = this.f47639b.g().setScale(FuturePrecisionUtil.s(this.f47643f.getContractCode(), this.f47643f.getContractShortType(), (String) null), 1).toPlainString();
            }
            if (this.f47639b.k() != null) {
                str3 = this.f47639b.k().setScale(FuturePrecisionUtil.s(this.f47643f.getContractCode(), this.f47643f.getContractShortType(), (String) null), 1).toPlainString();
            }
        } else if (a7.e.G(this.f47647j)) {
            if (v11 == 0) {
                this.f47639b.d(contractOrderPlace, this.f47643f);
                this.f47639b.b(contractOrderPlace, this.f47643f);
            } else {
                this.f47639b.c(contractOrderPlace, this.f47643f);
                this.f47639b.a(contractOrderPlace, this.f47643f);
            }
            if (this.f47639b.g() == null) {
                plainString = str3;
            } else {
                plainString = this.f47639b.g().setScale(FuturePrecisionUtil.g(this.f47643f.getSymbol()), 1).toPlainString();
            }
            if (this.f47639b.k() != null) {
                str3 = this.f47639b.k().setScale(FuturePrecisionUtil.g(this.f47643f.getSymbol()), 1).toPlainString();
            }
        } else {
            str = str3;
            this.f47648k.P0(str3, str);
        }
        String str4 = str3;
        str3 = str2;
        str = str4;
        this.f47648k.P0(str3, str);
    }

    public final void T(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        if (bigDecimal2.compareTo(bigDecimal3) != 0 && this.f47648k.getTradeAmountType() == 0) {
            bigDecimal3 = m.a(FutureUnitUtil.e(this.f47648k.getOrderPlaceInputAmount(), bigDecimal.toPlainString(), bigDecimal2.toPlainString(), this.f47647j, FuturePrecisionUtil.g(this.f47642e)));
            this.f47651n = bigDecimal3.setScale(ej.f.c(this.f47642e), 1).toPlainString();
        }
        if (bigDecimal3.compareTo(BigDecimal.ZERO) > 0) {
            if (y().getPositionType() != 1 && y().getPositionType() != 2) {
                bigDecimal3 = bigDecimal3.setScale(FuturePrecisionUtil.B(), 1);
            } else if (bigDecimal3.compareTo(BigDecimal.ONE) < 0) {
                bigDecimal3 = bigDecimal3.setScale(FuturePrecisionUtil.B(), 0);
            } else {
                bigDecimal3 = bigDecimal3.setScale(FuturePrecisionUtil.B(), 1);
            }
        }
        this.f47648k.x2(bigDecimal3.toPlainString());
    }

    public void U(int i11, int i12) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        if (this.f47648k.getTradeAmountType() != 0) {
            ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
            contractOrderPlace.X0(this.f47648k.getTradePriceType());
            contractOrderPlace.B0(this.f47648k.getInputPriceText());
            contractOrderPlace.y0(this.f47648k.getOrderType());
            contractOrderPlace.Z0(this.f47648k.getTriggerPriceText());
            contractOrderPlace.i0(this.f47640c.c());
            contractOrderPlace.G0(this.f47640c.f());
            contractOrderPlace.r0(this.f47640c.e());
            contractOrderPlace.h0(this.f47648k.w2());
            contractOrderPlace.A0(this.f47648k.getPositionType());
            contractOrderPlace.N0(this.f47642e);
            contractOrderPlace.s0(this.f47644g);
            contractOrderPlace.v0(this.f47645h);
            BigDecimal a11 = m.a(this.f47639b.s(contractOrderPlace).w());
            if (r.x().F0()) {
                if (a7.e.E(this.f47647j) || a7.e.G(this.f47647j)) {
                    if (i12 == 0) {
                        int s11 = FuturePrecisionUtil.s(this.f47643f.getContractCode(), this.f47643f.getContractShortType(), (String) null);
                        if (this.f47639b.i() != null) {
                            BigDecimal divide = this.f47639b.i().multiply(m.a(String.valueOf(i11))).divide(m.f68179a, FuturePrecisionUtil.B(), 1);
                            this.f47651n = divide.toPlainString();
                            String m11 = m.m(FutureUnitUtil.d(divide.toPlainString(), a11.toPlainString(), this.f47643f.getContractFace(), this.f47647j), s11);
                            if (a7.e.H(TradeType.LINEAR_SWAP)) {
                                BigDecimal a12 = m.a(this.f47644g);
                                if (a12.compareTo(BigDecimal.ZERO) == 1) {
                                    m.a(m11).divide(a12, s11, 1).toPlainString();
                                }
                            }
                        }
                        if (this.f47639b.j() != null) {
                            BigDecimal divide2 = this.f47639b.j().multiply(m.a(String.valueOf(i11))).divide(m.f68179a, FuturePrecisionUtil.B(), 1);
                            this.f47651n = divide2.toPlainString();
                            String m12 = m.m(FutureUnitUtil.d(divide2.toPlainString(), a11.toPlainString(), this.f47643f.getContractFace(), this.f47647j), s11);
                            if (a7.e.H(TradeType.LINEAR_SWAP)) {
                                BigDecimal a13 = m.a(this.f47644g);
                                if (a13.compareTo(BigDecimal.ZERO) == 1) {
                                    m.a(m12).divide(a13, s11, 1).toPlainString();
                                }
                            }
                        }
                    } else if (i12 == 1 || i12 == 2) {
                        if (this.f47639b.i() != null) {
                            BigDecimal divide3 = this.f47639b.i().multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                            if (divide3.compareTo(BigDecimal.ONE) >= 0 || divide3.compareTo(BigDecimal.ZERO) <= 0) {
                                bigDecimal2 = divide3.setScale(FuturePrecisionUtil.B(), 1);
                            } else {
                                bigDecimal2 = BigDecimal.ONE;
                            }
                            m.m(FutureUnitUtil.d(bigDecimal2.toPlainString(), a11.toPlainString(), this.f47643f.getContractFace(), this.f47647j), FuturePrecisionUtil.s(this.f47643f.getContractCode(), this.f47643f.getContractShortType(), (String) null));
                            this.f47651n = bigDecimal2.toPlainString();
                        }
                        if (this.f47639b.j() != null) {
                            BigDecimal divide4 = this.f47639b.j().multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, 1);
                            if (divide4.compareTo(BigDecimal.ONE) >= 0 || divide4.compareTo(BigDecimal.ZERO) <= 0) {
                                bigDecimal = divide4.setScale(FuturePrecisionUtil.B(), 1);
                            } else {
                                bigDecimal = BigDecimal.ONE;
                            }
                            m.m(FutureUnitUtil.d(bigDecimal.toPlainString(), a11.toPlainString(), this.f47643f.getContractFace(), this.f47647j), FuturePrecisionUtil.s(this.f47643f.getContractCode(), this.f47643f.getContractShortType(), (String) null));
                            this.f47651n = bigDecimal.toPlainString();
                        }
                    }
                } else if (i12 == 0) {
                    if (this.f47639b.i() != null) {
                        this.f47651n = this.f47639b.i().multiply(new BigDecimal(i11)).divide(m.f68179a, FuturePrecisionUtil.B(), 1).toPlainString();
                    }
                    if (this.f47639b.j() != null) {
                        this.f47651n = this.f47639b.j().multiply(new BigDecimal(i11)).divide(m.f68179a, FuturePrecisionUtil.B(), 1).toPlainString();
                    }
                } else if (i12 == 1 || i12 == 2) {
                    if (this.f47639b.i() != null) {
                        BigDecimal divide5 = this.f47639b.i().multiply(new BigDecimal(i11)).divide(m.f68179a, 32, 1);
                        if (divide5.compareTo(BigDecimal.ONE) >= 0 || divide5.compareTo(BigDecimal.ZERO) <= 0) {
                            bigDecimal4 = divide5.setScale(FuturePrecisionUtil.B(), 1);
                        } else {
                            bigDecimal4 = BigDecimal.ONE;
                        }
                        this.f47651n = bigDecimal4.toPlainString();
                    }
                    if (this.f47639b.j() != null) {
                        BigDecimal divide6 = this.f47639b.j().multiply(new BigDecimal(i11)).divide(m.f68179a, 32, 1);
                        if (divide6.compareTo(BigDecimal.ONE) >= 0 || divide6.compareTo(BigDecimal.ZERO) <= 0) {
                            bigDecimal3 = divide6.setScale(FuturePrecisionUtil.B(), 1);
                        } else {
                            bigDecimal3 = BigDecimal.ONE;
                        }
                        this.f47651n = bigDecimal3.toPlainString();
                    }
                }
            }
            this.f47648k.S0(i11 + "%", i11 + "%");
        }
    }

    public void j(boolean z11) {
        k(z11, false);
    }

    public void k(boolean z11, boolean z12) {
        if (this.f47643f != null) {
            this.f47648k.getTradePriceType();
            ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
            contractOrderPlace.X0(this.f47648k.getTradePriceType());
            contractOrderPlace.B0(this.f47648k.getInputPriceText());
            contractOrderPlace.y0(this.f47648k.getOrderType());
            contractOrderPlace.Z0(this.f47648k.getTriggerPriceText());
            contractOrderPlace.i0(this.f47640c.c());
            contractOrderPlace.G0(this.f47640c.f());
            contractOrderPlace.r0(this.f47640c.e());
            contractOrderPlace.h0(this.f47648k.w2());
            contractOrderPlace.A0(this.f47648k.getPositionType());
            contractOrderPlace.N0(this.f47642e);
            contractOrderPlace.s0(this.f47644g);
            contractOrderPlace.v0(this.f47645h);
            ContractOrderPlace s11 = this.f47639b.s(contractOrderPlace);
            BigDecimal a11 = m.a(s11.w());
            this.f47639b.t(this.f47651n);
            BigDecimal a12 = m.a(this.f47643f.getContractFace());
            S(s11);
            T(a11, a12);
            if (!TextUtils.isEmpty(this.f47648k.getInputAmountText()) && !z12) {
                U(this.f47648k.getSeekBarProgress(), this.f47648k.getPositionType());
            }
        }
    }

    public String[] l(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
        String str2;
        String str3;
        String plainString;
        String plainString2;
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.X0(this.f47648k.getTradePriceType());
        contractOrderPlace.B0(this.f47648k.getInputPriceText());
        contractOrderPlace.y0(this.f47648k.getOrderType());
        contractOrderPlace.Z0(this.f47648k.getTriggerPriceText());
        contractOrderPlace.i0(this.f47640c.c());
        contractOrderPlace.G0(this.f47640c.f());
        contractOrderPlace.r0(this.f47640c.e());
        contractOrderPlace.h0(this.f47648k.w2());
        contractOrderPlace.A0(this.f47648k.getPositionType());
        contractOrderPlace.N0(this.f47642e);
        contractOrderPlace.s0(str);
        contractOrderPlace.v0(this.f47645h);
        contractOrderPlace.t0(true);
        contractOrderPlace.u0(levelAvailableMarginInfo.getAvailableMargin());
        ContractOrderPlace s11 = this.f47639b.s(contractOrderPlace);
        s11.v();
        if (TextUtils.isEmpty(s11.w())) {
            s11.B0(String.valueOf(s11.n()));
        }
        String str4 = "";
        if (r.x().F0()) {
            if (a7.e.E(this.f47647j)) {
                this.f47639b.d(s11, this.f47643f);
                this.f47639b.b(s11, this.f47643f);
                if (this.f47639b.g() == null) {
                    str3 = str4;
                } else {
                    str3 = this.f47639b.g().setScale(FuturePrecisionUtil.s(this.f47643f.getContractCode(), this.f47643f.getContractShortType(), (String) null), 1).toPlainString();
                }
                if (this.f47639b.k() != null) {
                    str4 = this.f47639b.k().setScale(FuturePrecisionUtil.s(this.f47643f.getContractCode(), this.f47643f.getContractShortType(), (String) null), 1).toPlainString();
                }
            } else if (a7.e.G(this.f47647j)) {
                this.f47639b.d(s11, this.f47643f);
                this.f47639b.b(s11, this.f47643f);
                if (this.f47639b.g() == null) {
                    plainString2 = str4;
                } else {
                    plainString2 = this.f47639b.g().setScale(FuturePrecisionUtil.g(this.f47643f.getSymbol()), 1).toPlainString();
                }
                if (this.f47639b.k() != null) {
                    str4 = this.f47639b.k().setScale(FuturePrecisionUtil.g(this.f47643f.getSymbol()), 1).toPlainString();
                }
            } else {
                this.f47639b.d(s11, this.f47643f);
                if (this.f47639b.i() == null) {
                    plainString = str4;
                } else {
                    plainString = this.f47639b.i().toPlainString();
                }
                if (this.f47639b.j() != null) {
                    str4 = this.f47639b.j().toPlainString();
                }
            }
            String str5 = str4;
            str4 = str3;
            str2 = str5;
        } else {
            str2 = str4;
        }
        return new String[]{str4, str2};
    }

    public String m(Editable editable) {
        if (this.f47643f == null) {
            return null;
        }
        if (a7.e.G(this.f47647j)) {
            return m.b(editable, 10, FuturePrecisionUtil.g(this.f47642e));
        }
        return m.b(editable, 10, FuturePrecisionUtil.s(this.f47643f.getContractCode(), this.f47643f.getContractShortType(), (String) null));
    }

    public final Observable<LinearSwapLeverRate> n(String str, String str2, int i11) {
        if (i11 == 2) {
            boolean b11 = pk.e.a().b(false, str);
            if (SPUtil.j()) {
                b11 = pk.e.a().c();
            }
            return h8.a.a().w0(str, str2, FutureContractInfo.MARGIN_ISOLATED, b11).b();
        }
        boolean b12 = pk.e.a().b(true, str);
        if (SPUtil.j()) {
            b12 = pk.e.a().c();
        }
        return h8.a.a().I(str, str2, FutureContractInfo.MARGIN_CROSS, b12).b();
    }

    public FutureContractInfo o() {
        return this.f47643f;
    }

    public FutureMarketDepthController p() {
        return this.f47640c;
    }

    public String q(String str) {
        return (TextUtils.isEmpty(str) || InstructionFileId.DOT.equals(str) || "usd".equals(LegalCurrencyConfigUtil.y())) ? "" : LegalCurrencyConfigUtil.B(str);
    }

    public String r() {
        return this.f47644g;
    }

    public TradeType s() {
        return this.f47647j;
    }

    public int t() {
        return this.f47645h;
    }

    public String u() {
        return this.f47651n;
    }

    public String v() {
        return this.f47642e;
    }

    public FutureTradeActionController w() {
        return this.f47639b;
    }

    public b x() {
        return this.f47638a;
    }

    public o y() {
        return (o) this.f47646i.get();
    }

    public void z() {
        LegalCurrencyConfigUtil.X(true).compose(RxJavaHelper.t(y())).subscribe(new b());
    }
}
