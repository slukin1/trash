package com.hbg.module.exchange.grid.presenter;

import ad.k;
import ad.m;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.clear.controller.ClearDialogConfigController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.ClearDialogConfig;
import com.hbg.lib.network.hbg.grid.bean.GridAiQuote;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolDetail;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsBean;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.response.LastKlineResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.exchange.R$color;
import com.hbg.module.exchange.R$string;
import com.hbg.module.exchange.grid.ui.GridConfirmStrategyFragment;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import d7.y;
import g9.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GridTradePresenter extends ActivityPresenter<i> {

    /* renamed from: a  reason: collision with root package name */
    public String f19444a;

    /* renamed from: b  reason: collision with root package name */
    public String f19445b;

    /* renamed from: c  reason: collision with root package name */
    public GridSymbolsConfig f19446c;

    /* renamed from: d  reason: collision with root package name */
    public GridSymbolDetail f19447d;

    /* renamed from: e  reason: collision with root package name */
    public KlineInfo f19448e;

    /* renamed from: f  reason: collision with root package name */
    public GridAiQuote f19449f;

    /* renamed from: g  reason: collision with root package name */
    public String f19450g;

    /* renamed from: h  reason: collision with root package name */
    public String f19451h;

    /* renamed from: i  reason: collision with root package name */
    public k f19452i;

    /* renamed from: j  reason: collision with root package name */
    public GridConfirmStrategyFragment f19453j = new GridConfirmStrategyFragment();

    /* renamed from: k  reason: collision with root package name */
    public LastKlineListener f19454k = new b();

    /* renamed from: l  reason: collision with root package name */
    public a.d f19455l = new bd.d(this);

    public class a extends q6.d<String> {
        public a(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(String str) {
            super.onNext(str);
            HuobiToastUtil.s(R$string.n_grid_trade_create_success);
            ((i) GridTradePresenter.this.getUI()).Gf();
            GridTradePresenter.this.L0();
            GridTradePresenter.this.f19452i.s();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if ("600015".equals(aPIStatusErrorException.getErrCode())) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_8);
            } else {
                super.onFailed(aPIStatusErrorException);
            }
        }
    }

    public class b extends LastKlineListener {
        public b() {
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            KlineInfo unused = GridTradePresenter.this.f19448e = lastKlineResponse.getTick();
            GridTradePresenter gridTradePresenter = GridTradePresenter.this;
            gridTradePresenter.U0(Double.valueOf(gridTradePresenter.f19448e.getOpen()), Double.valueOf(GridTradePresenter.this.f19448e.getClose()));
            GridTradePresenter.this.q0();
        }
    }

    public class c extends BaseSubscriber<TradeRiskReminder> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(TradeRiskReminder tradeRiskReminder) {
            super.onNext(tradeRiskReminder);
            if (!ad.d.b() || !ad.d.c()) {
                ((i) GridTradePresenter.this.getUI()).n5(false);
                if (!ad.d.b() && !ad.d.c()) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("1");
                    BaseCoreActivity g02 = GridTradePresenter.this.getActivity();
                    int i11 = R$color.baseColorMajorTheme100;
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(g02, i11)), 0, spannableStringBuilder.length(), 17);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("/2 ");
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(GridTradePresenter.this.getActivity(), R$color.baseColorSecondaryText)), 0, spannableStringBuilder2.length(), 17);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(GridTradePresenter.this.getString(R$string.n_grid_trade_top_tips_desc));
                    spannableStringBuilder3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(GridTradePresenter.this.getActivity(), i11)), 0, spannableStringBuilder3.length(), 17);
                    ((i) GridTradePresenter.this.getUI()).Ef(spannableStringBuilder.append(spannableStringBuilder2).append(spannableStringBuilder3), GridTradePresenter.this.getString(R$string.n_grid_trade_top_tips_btn));
                } else if (!ad.d.b() && ad.d.c()) {
                    SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(GridTradePresenter.this.getString(R$string.n_grid_trade_top_tips_desc));
                    spannableStringBuilder4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(GridTradePresenter.this.getActivity(), R$color.baseColorMajorTheme100)), 0, spannableStringBuilder4.length(), 17);
                    ((i) GridTradePresenter.this.getUI()).Ef(spannableStringBuilder4, GridTradePresenter.this.getString(R$string.n_grid_trade_top_tips_btn));
                } else if (ad.d.b() && !ad.d.c()) {
                    SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder(GridTradePresenter.this.getString(R$string.n_grid_trade_top_tips_desc2));
                    spannableStringBuilder5.setSpan(new ForegroundColorSpan(ContextCompat.getColor(GridTradePresenter.this.getActivity(), R$color.baseColorMajorTheme100)), 0, spannableStringBuilder5.length(), 17);
                    ((i) GridTradePresenter.this.getUI()).Ef(spannableStringBuilder5, GridTradePresenter.this.getString(R$string.n_grid_trade_top_tips_evaluation_btn));
                }
            } else {
                ((i) GridTradePresenter.this.getUI()).H5();
                ((i) GridTradePresenter.this.getUI()).n5(true);
            }
        }
    }

    public class d extends q6.a<GridAiQuote> {
        public d(u6.g gVar, boolean z11) {
            super(gVar, z11);
        }

        /* renamed from: a */
        public void onRequestSuccess(GridAiQuote gridAiQuote) {
            GridAiQuote unused = GridTradePresenter.this.f19449f = gridAiQuote;
            ((i) GridTradePresenter.this.getUI()).of(gridAiQuote);
            GridTradePresenter.this.q0();
        }
    }

    public class e extends BaseSubscriber<ClearDialogConfig> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(ClearDialogConfig clearDialogConfig) {
            super.onNext(clearDialogConfig);
            if (ClearDialogConfigController.i(6)) {
                ((i) GridTradePresenter.this.getUI()).p0(clearDialogConfig.getRulesUrl(), clearDialogConfig.getTips());
            } else if (ClearDialogConfigController.h(6)) {
                ((i) GridTradePresenter.this.getUI()).p0(clearDialogConfig.getRulesUrl(), clearDialogConfig.getTips());
            } else {
                m.b(GridTradePresenter.this.getActivity().getSupportFragmentManager(), (u6.g) GridTradePresenter.this.getUI());
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            m.b(GridTradePresenter.this.getActivity().getSupportFragmentManager(), (u6.g) GridTradePresenter.this.getUI());
        }
    }

    public class f extends q6.a<Map<String, String>> {
        public f(u6.g gVar, boolean z11) {
            super(gVar, z11);
        }

        /* renamed from: a */
        public void onRequestSuccess(Map<String, String> map) {
            String quoteCurrency = ((i) GridTradePresenter.this.getUI()).getQuoteCurrency();
            String unused = GridTradePresenter.this.f19450g = i6.m.m(map.get(quoteCurrency), PrecisionUtil.b(quoteCurrency));
            String baseCurrency = ((i) GridTradePresenter.this.getUI()).getBaseCurrency();
            String unused2 = GridTradePresenter.this.f19451h = i6.m.m(map.get(baseCurrency), PrecisionUtil.b(baseCurrency));
            ((i) GridTradePresenter.this.getUI()).Qa(GridTradePresenter.this.f19450g, GridTradePresenter.this.f19451h);
            GridTradePresenter.this.q0();
        }
    }

    public class g extends BaseSubscriber<GridSymbolsConfig> {
        public g() {
        }

        /* renamed from: a */
        public void onNext(GridSymbolsConfig gridSymbolsConfig) {
            GridSymbolsBean gridSymbolsBean;
            super.onNext(gridSymbolsConfig);
            GridSymbolsConfig unused = GridTradePresenter.this.f19446c = gridSymbolsConfig;
            if (TextUtils.isEmpty(GridTradePresenter.this.o0())) {
                List<GridSymbolsBean> n11 = y.n();
                if (!n11.isEmpty() && (gridSymbolsBean = n11.get(0)) != null) {
                    String unused2 = GridTradePresenter.this.f19445b = gridSymbolsBean.getSymbolCode();
                    ((i) GridTradePresenter.this.getUI()).fe(GridTradePresenter.this.f19445b);
                    ((i) GridTradePresenter.this.getUI()).Z8(GridTradePresenter.this.f19445b);
                    GridTradePresenter.this.K0();
                    GridTradePresenter.this.M0();
                    GridTradePresenter.this.O0();
                    GridTradePresenter.this.T0(ad.e.a());
                    if (!TextUtils.isEmpty(GridTradePresenter.this.o0())) {
                        x8.a.a().g(true, GridTradePresenter.this.o0(), Period.day, GridTradePresenter.this.f19454k);
                    }
                }
            }
            GridTradePresenter.this.q0();
        }
    }

    public class h extends q6.a<GridSymbolDetail> {
        public h(u6.g gVar, boolean z11) {
            super(gVar, z11);
        }

        /* renamed from: a */
        public void onRequestSuccess(GridSymbolDetail gridSymbolDetail) {
            GridSymbolDetail unused = GridTradePresenter.this.f19447d = gridSymbolDetail;
            GridTradePresenter.this.q0();
        }
    }

    public interface i extends u6.g {
        void Aa(String str);

        String Cc();

        void D8(String str);

        void Ef(SpannableStringBuilder spannableStringBuilder, String str);

        void Gf();

        void H5();

        void L6(String str, String str2, String str3, int i11, int i12, int i13);

        void Mf(String str);

        void Qa(String str, String str2);

        boolean Qf();

        String Te();

        String Tg();

        void We();

        void Yc(String str);

        void Z8(String str);

        void b(v9.a aVar);

        String b5();

        void fe(String str);

        int gb();

        String getBaseCurrency();

        String getQuoteCurrency();

        void k7();

        void n5(boolean z11);

        int na();

        String o0();

        void of(GridAiQuote gridAiQuote);

        void p0(String str, String str2);

        String q8();

        String we();

        String xd();

        boolean y8();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A0(int i11, String str) {
        v7.b.a().i(o0(), "spot-android", i11, ((i) getUI()).gb(), ((i) getUI()).na(), ((i) getUI()).b5(), ((i) getUI()).we(), str, ((i) getUI()).Te(), ((i) getUI()).q8(), ((i) getUI()).Cc(), ((i) getUI()).xd()).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new a((u6.g) getUI()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z0() {
        x8.a.a().g(true, o0(), Period.day, this.f19454k);
    }

    public void B0(String str) {
        BigDecimal p02 = p0();
        if (this.f19449f != null && !TextUtils.isEmpty(str)) {
            BigDecimal a11 = i6.m.a(str);
            if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_input_amount);
            } else if (p02 != null && a11.compareTo(BigDecimal.ZERO) > 0 && a11.compareTo(p02) < 0) {
                String z11 = d7.k.C().z(((i) getUI()).getQuoteCurrency());
                HuobiToastUtil.m(String.format(Locale.US, getString(R$string.n_grid_trade_error_toast_3), new Object[]{p02.toPlainString(), z11}));
            } else if (i6.m.a(this.f19450g).compareTo(a11) < 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_5);
            }
        }
    }

    public void C0(String str) {
        if (!TextUtils.isEmpty(str)) {
            BigDecimal a11 = i6.m.a(str);
            if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_input_amount);
                return;
            }
            BigDecimal r02 = r0();
            if (r02 != null && r02.compareTo(BigDecimal.ZERO) > 0 && a11.compareTo(r02) < 0) {
                String z11 = d7.k.C().z(((i) getUI()).getBaseCurrency());
                HuobiToastUtil.m(String.format(Locale.US, getString(R$string.n_grid_trade_error_toast_3), new Object[]{r02.toPlainString(), z11}));
            } else if (i6.m.a(this.f19451h).compareTo(a11) < 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_5);
            }
        }
    }

    public void D0(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(((i) getUI()).b5())) {
            BigDecimal a11 = i6.m.a(str);
            if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_max_price);
            } else if (i6.m.a(((i) getUI()).b5()).compareTo(a11) >= 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_1);
            }
        }
    }

    public void E0(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(((i) getUI()).we())) {
            BigDecimal a11 = i6.m.a(str);
            if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_min_price);
            } else if (a11.compareTo(i6.m.a(((i) getUI()).we())) >= 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_1);
            }
        }
    }

    public void F0(String str) {
        if (!TextUtils.isEmpty(str)) {
            BigDecimal a11 = i6.m.a(str);
            if (a11.compareTo(i6.m.a("2")) < 0 || a11.compareTo(i6.m.a("99")) > 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_2);
            }
        }
    }

    public void G0(String str) {
        if (!TextUtils.isEmpty(str)) {
            BigDecimal a11 = i6.m.a(str);
            if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_input_amount);
                return;
            }
            BigDecimal s02 = s0();
            if (s02 != null && s02.compareTo(BigDecimal.ZERO) > 0 && a11.compareTo(s02) < 0) {
                String z11 = d7.k.C().z(((i) getUI()).getQuoteCurrency());
                HuobiToastUtil.m(String.format(Locale.US, getString(R$string.n_grid_trade_error_toast_3), new Object[]{s02.toPlainString(), z11}));
            } else if (i6.m.a(this.f19450g).compareTo(a11) < 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_5);
            }
        }
    }

    public void H0(String str) {
        if (!TextUtils.isEmpty(str)) {
            BigDecimal a11 = i6.m.a(str);
            BigDecimal a12 = i6.m.a(((i) getUI()).b5());
            if (a11.compareTo(BigDecimal.ZERO) <= 0 || a11.compareTo(a12) < 0) {
                KlineInfo klineInfo = this.f19448e;
                if (klineInfo != null) {
                    BigDecimal a13 = i6.m.a(String.valueOf(klineInfo.getClose()));
                    if (a13.compareTo(BigDecimal.ZERO) > 0 && a11.compareTo(a13) >= 0) {
                        HuobiToastUtil.j(R$string.n_grid_trade_error_toast_7);
                        return;
                    }
                    return;
                }
                return;
            }
            HuobiToastUtil.j(R$string.n_grid_trade_error_toast_7);
        }
    }

    public void I0(String str) {
        if (!TextUtils.isEmpty(str)) {
            BigDecimal a11 = i6.m.a(str);
            BigDecimal a12 = i6.m.a(((i) getUI()).we());
            if (a12.compareTo(BigDecimal.ZERO) <= 0 || a11.compareTo(a12) > 0) {
                KlineInfo klineInfo = this.f19448e;
                if (klineInfo != null) {
                    BigDecimal a13 = i6.m.a(String.valueOf(klineInfo.getClose()));
                    if (a13.compareTo(BigDecimal.ZERO) > 0 && a11.compareTo(a13) <= 0) {
                        HuobiToastUtil.j(R$string.n_grid_trade_error_toast_6);
                        return;
                    }
                    return;
                }
                return;
            }
            HuobiToastUtil.j(R$string.n_grid_trade_error_toast_6);
        }
    }

    /* renamed from: J0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, i iVar) {
        super.onUIReady(baseCoreActivity, iVar);
        S0(iVar.o0());
        this.f19452i = new k(iVar, baseCoreActivity);
        ((i) getUI()).b(this.f19452i.h());
        this.f19452i.r(0);
        iVar.We();
    }

    public void K0() {
        if (!TextUtils.isEmpty(o0())) {
            v7.b.a().aiQuote(o0()).d(new d((u6.g) getUI(), false));
        }
    }

    public void L0() {
        K0();
        M0();
        P0();
        O0();
        T0(ad.e.a());
        x0();
    }

    public void M0() {
        if (!TextUtils.isEmpty(o0())) {
            new d9.a(vc.b.a().f()).d(new f((u6.g) getUI(), false));
        }
    }

    public void N0() {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        String str;
        GridAiQuote gridAiQuote = this.f19449f;
        BigDecimal bigDecimal3 = null;
        String yieldRate = gridAiQuote != null ? gridAiQuote.getYieldRate() : null;
        if (!((i) getUI()).y8()) {
            if (i6.m.a(((i) getUI()).b5()).compareTo(BigDecimal.ZERO) == 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_min_price);
                return;
            } else if (i6.m.a(((i) getUI()).we()).compareTo(BigDecimal.ZERO) == 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_max_price);
                return;
            } else if (((i) getUI()).na() <= 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_num);
                return;
            }
        }
        if (((i) getUI()).y8() || ((i) getUI()).Qf()) {
            bigDecimal2 = p0();
            bigDecimal = null;
        } else {
            bigDecimal2 = s0();
            bigDecimal = r0();
        }
        BigDecimal a11 = i6.m.a(((i) getUI()).Cc());
        BigDecimal a12 = i6.m.a(((i) getUI()).xd());
        if (((i) getUI()).y8()) {
            if (a11.compareTo(BigDecimal.ZERO) == 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_input_amount);
                return;
            }
        } else if (((i) getUI()).Qf()) {
            if (a11.compareTo(BigDecimal.ZERO) == 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_input_amount);
                return;
            }
        } else if (a11.compareTo(BigDecimal.ZERO) == 0 && a12.compareTo(BigDecimal.ZERO) == 0) {
            HuobiToastUtil.j(R$string.n_grid_trade_error_toast_input_amount);
            return;
        } else if (bigDecimal2 != null && bigDecimal2.compareTo(BigDecimal.ZERO) > 0 && a11.compareTo(BigDecimal.ZERO) <= 0) {
            HuobiToastUtil.j(R$string.n_grid_trade_error_toast_input_amount);
            return;
        } else if (bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) > 0 && a12.compareTo(BigDecimal.ZERO) <= 0) {
            HuobiToastUtil.j(R$string.n_grid_trade_error_toast_input_amount);
            return;
        }
        if (!((i) getUI()).y8() || this.f19449f != null) {
            BigDecimal a13 = i6.m.a(((i) getUI()).b5());
            BigDecimal a14 = i6.m.a(((i) getUI()).we());
            if (a13.compareTo(a14) >= 0) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_1);
                return;
            }
            int i11 = 2;
            if (((i) getUI()).na() < 2 || ((i) getUI()).na() > 99) {
                HuobiToastUtil.j(R$string.n_grid_trade_error_toast_2);
            } else if (bigDecimal2 == null || bigDecimal2.compareTo(BigDecimal.ZERO) <= 0 || a11.compareTo(bigDecimal2) >= 0) {
                BigDecimal a15 = i6.m.a(this.f19450g);
                BigDecimal a16 = i6.m.a(this.f19451h);
                if (a15.compareTo(a11) < 0) {
                    HuobiToastUtil.j(R$string.n_grid_trade_error_toast_5);
                    return;
                }
                if (!((i) getUI()).y8() && !((i) getUI()).Qf()) {
                    if (bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) > 0 && a12.compareTo(bigDecimal) < 0) {
                        HuobiToastUtil.m(String.format(Locale.US, getString(R$string.n_grid_trade_error_toast_3), new Object[]{bigDecimal.toPlainString(), d7.k.C().z(((i) getUI()).getBaseCurrency())}));
                        return;
                    } else if (a16.compareTo(a12) < 0) {
                        HuobiToastUtil.j(R$string.n_grid_trade_error_toast_5);
                        return;
                    }
                }
                BigDecimal a17 = i6.m.a(((i) getUI()).Te());
                BigDecimal a18 = i6.m.a(((i) getUI()).q8());
                KlineInfo klineInfo = this.f19448e;
                if (klineInfo != null) {
                    bigDecimal3 = i6.m.a(String.valueOf(klineInfo.getClose()));
                }
                if (!((i) getUI()).y8()) {
                    if (!TextUtils.isEmpty(((i) getUI()).Te())) {
                        if (a17.compareTo(BigDecimal.ZERO) > 0 && a17.compareTo(a14) <= 0) {
                            HuobiToastUtil.j(R$string.n_grid_trade_error_toast_6);
                            return;
                        } else if (bigDecimal3 != null && bigDecimal3.compareTo(BigDecimal.ZERO) > 0 && a17.compareTo(bigDecimal3) <= 0) {
                            HuobiToastUtil.j(R$string.n_grid_trade_error_toast_6);
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(((i) getUI()).q8())) {
                        if (a18.compareTo(BigDecimal.ZERO) > 0 && a18.compareTo(a13) >= 0) {
                            HuobiToastUtil.j(R$string.n_grid_trade_error_toast_7);
                            return;
                        } else if (bigDecimal3 != null && bigDecimal3.compareTo(BigDecimal.ZERO) > 0 && a18.compareTo(bigDecimal3) >= 0) {
                            HuobiToastUtil.j(R$string.n_grid_trade_error_toast_7);
                            return;
                        }
                    }
                }
                if (((i) getUI()).y8()) {
                    i11 = 1;
                } else if (!((i) getUI()).Qf()) {
                    i11 = 4;
                }
                this.f19453j.bc(o0());
                int A = PrecisionUtil.A(o0());
                int z11 = PrecisionUtil.z(o0());
                int z12 = PrecisionUtil.z(o0());
                String m11 = i6.m.m(((i) getUI()).b5(), A);
                String m12 = i6.m.m(((i) getUI()).we(), A);
                this.f19453j.Bh(m11 + " - " + m12);
                this.f19453j.xh(String.valueOf(((i) getUI()).na()));
                GridConfirmStrategyFragment gridConfirmStrategyFragment = this.f19453j;
                if (((i) getUI()).gb() == 0) {
                    str = getActivity().getString(R$string.n_grid_trade_dengcha);
                } else {
                    str = getActivity().getString(R$string.n_grid_trade_dengbi);
                }
                gridConfirmStrategyFragment.yh(str);
                this.f19453j.Ch(((i) getUI()).Tg());
                String str2 = "";
                if (((i) getUI()).y8()) {
                    this.f19453j.Eh(str2);
                    this.f19453j.Dh(str2);
                } else {
                    if (TextUtils.isEmpty(((i) getUI()).Te())) {
                        this.f19453j.Eh(str2);
                    } else {
                        this.f19453j.Eh(i6.m.m(((i) getUI()).Te(), A));
                    }
                    if (TextUtils.isEmpty(((i) getUI()).q8())) {
                        this.f19453j.Dh(str2);
                    } else {
                        this.f19453j.Dh(i6.m.m(((i) getUI()).q8(), A));
                    }
                }
                this.f19453j.wh(i6.m.a(((i) getUI()).Cc()).compareTo(BigDecimal.ZERO) > 0 ? i6.m.m(((i) getUI()).Cc(), z11) : str2);
                if (!((i) getUI()).Qf() && i6.m.a(((i) getUI()).xd()).compareTo(BigDecimal.ZERO) > 0) {
                    str2 = i6.m.m(((i) getUI()).xd(), z12);
                }
                this.f19453j.vh(str2);
                this.f19453j.zh(!((i) getUI()).y8());
                this.f19453j.Ah(new bd.c(this, i11, yieldRate));
                this.f19453j.show(getActivity().getSupportFragmentManager(), "mConfirmDialogFragment");
            } else {
                HuobiToastUtil.m(String.format(Locale.US, getString(R$string.n_grid_trade_error_toast_3), new Object[]{bigDecimal2.toPlainString(), d7.k.C().z(((i) getUI()).getQuoteCurrency())}));
            }
        } else {
            HuobiToastUtil.j(R$string.n_no_network);
        }
    }

    public final void O0() {
        if (!TextUtils.isEmpty(o0())) {
            v7.b.a().getSymbolDetail(o0()).d(new h((u6.g) getUI(), false));
        }
    }

    public final void P0() {
        y.h(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g());
    }

    public void Q0() {
        ad.d.g().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
    }

    public void R0(String str) {
        this.f19444a = str;
    }

    public void S0(String str) {
        this.f19445b = str;
        ((i) getUI()).fe(str);
    }

    public void T0(boolean z11) {
        if (!TextUtils.isEmpty(o0())) {
            if (z11) {
                this.f19452i.t(this.f19445b, a1.v().n(this.f19445b), a1.v().D(this.f19445b), 1, -1, 0);
            } else {
                this.f19452i.t(this.f19445b, "", "", 1, -1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void U0(java.lang.Double r16, java.lang.Double r17) {
        /*
            r15 = this;
            java.lang.String r0 = r15.o0()
            r1 = 0
            if (r17 == 0) goto L_0x0014
            if (r16 == 0) goto L_0x0014
            double r3 = r17.doubleValue()
            double r5 = r16.doubleValue()
            double r3 = r3 - r5
            goto L_0x0015
        L_0x0014:
            r3 = r1
        L_0x0015:
            java.lang.String r5 = ""
            java.lang.String r6 = "--"
            if (r17 == 0) goto L_0x0056
            double r7 = r17.doubleValue()
            int r7 = java.lang.Double.compare(r7, r1)
            if (r7 == 0) goto L_0x0056
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r8 = java.lang.Double.compare(r3, r1)
            if (r8 <= 0) goto L_0x0033
            java.lang.String r8 = "+"
            goto L_0x0034
        L_0x0033:
            r8 = r5
        L_0x0034:
            r7.append(r8)
            double r8 = r16.doubleValue()
            double r8 = r3 / r8
            r10 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r8 = r8 * r10
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.v(r0)
            java.lang.String r8 = i6.m.i(r8, r10)
            r7.append(r8)
            java.lang.String r8 = "%"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r11 = r7
            goto L_0x0057
        L_0x0056:
            r11 = r6
        L_0x0057:
            int r7 = java.lang.Double.compare(r3, r1)
            if (r7 <= 0) goto L_0x006f
            android.content.res.Resources r1 = r15.getResources()
            int r2 = com.hbg.lib.core.util.w.h()
            int r1 = r1.getColor(r2)
            int r2 = com.hbg.module.exchange.R$drawable.shape_raise_color_bg
        L_0x006b:
            r12 = r1
            r14 = r12
            r13 = r2
            goto L_0x009d
        L_0x006f:
            int r1 = java.lang.Double.compare(r3, r1)
            if (r1 >= 0) goto L_0x0084
            android.content.res.Resources r1 = r15.getResources()
            int r2 = com.hbg.lib.core.util.w.d()
            int r1 = r1.getColor(r2)
            int r2 = com.hbg.module.exchange.R$drawable.shape_down_color_bg
            goto L_0x006b
        L_0x0084:
            android.content.res.Resources r1 = r15.getResources()
            int r2 = com.hbg.module.exchange.R$color.grid_quote_changed_percentage
            int r1 = r1.getColor(r2)
            android.content.res.Resources r2 = r15.getResources()
            int r3 = com.hbg.module.exchange.R$color.color_flat
            int r2 = r2.getColor(r3)
            int r3 = com.hbg.module.exchange.R$drawable.shape_flat_color_bg
            r12 = r1
            r14 = r2
            r13 = r3
        L_0x009d:
            if (r17 == 0) goto L_0x00ad
            java.lang.String r1 = java.lang.String.valueOf(r17)
            int r2 = com.hbg.lib.data.symbol.PrecisionUtil.x(r0)
            java.lang.String r1 = i6.m.m(r1, r2)
            r9 = r1
            goto L_0x00ae
        L_0x00ad:
            r9 = r6
        L_0x00ae:
            boolean r1 = r6.equalsIgnoreCase(r9)
            if (r1 != 0) goto L_0x00c1
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 == 0) goto L_0x00bb
            goto L_0x00c1
        L_0x00bb:
            r1 = r15
            java.lang.String r5 = r15.v0(r9, r0)
            goto L_0x00c2
        L_0x00c1:
            r1 = r15
        L_0x00c2:
            r10 = r5
            h6.a r0 = r15.getUI()
            r8 = r0
            com.hbg.module.exchange.grid.presenter.GridTradePresenter$i r8 = (com.hbg.module.exchange.grid.presenter.GridTradePresenter.i) r8
            r8.L6(r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.exchange.grid.presenter.GridTradePresenter.U0(java.lang.Double, java.lang.Double):void");
    }

    public String o0() {
        return this.f19445b;
    }

    public void onPause() {
        super.onPause();
        if (!TextUtils.isEmpty(o0())) {
            x8.a.a().g(false, o0(), Period.day, this.f19454k);
        }
        x8.a.a().c(this.f19455l);
        this.f19452i.v();
        this.f19452i.u();
    }

    public void onResume() {
        super.onResume();
        x8.a.a().d(this.f19455l);
        if (!TextUtils.isEmpty(o0())) {
            x8.a.a().g(true, o0(), Period.day, this.f19454k);
        }
        L0();
        w0();
        this.f19452i.s();
        Q0();
    }

    public BigDecimal p0() {
        boolean z11 = this.f19448e == null;
        if (this.f19449f == null) {
            z11 = true;
        }
        if (this.f19447d == null) {
            z11 = true;
        }
        if (this.f19446c == null) {
            z11 = true;
        }
        BigDecimal a11 = i6.m.a(((i) getUI()).b5());
        if (a11.compareTo(BigDecimal.ZERO) <= 0) {
            z11 = true;
        }
        BigDecimal a12 = i6.m.a(((i) getUI()).we());
        if (a12.compareTo(BigDecimal.ZERO) <= 0) {
            z11 = true;
        }
        BigDecimal a13 = i6.m.a(String.valueOf(((i) getUI()).na()));
        if (a13.compareTo(i6.m.a("2")) < 0) {
            z11 = true;
        }
        if (a13.compareTo(i6.m.a("99")) > 0) {
            z11 = true;
        }
        if (a11.compareTo(a12) >= 0) {
            z11 = true;
        }
        if (!z11) {
            BigDecimal a14 = i6.m.a(String.valueOf(this.f19448e.getClose()));
            BigDecimal y02 = y0(a12);
            BigDecimal a15 = i6.m.a(this.f19447d.getUserFeeRate());
            BigDecimal a16 = i6.m.a(this.f19446c.getAssetBuff());
            BigDecimal a17 = i6.m.a(this.f19446c.getAssetMulti());
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ad.a.b(arrayList, arrayList2, a14, a11, a12, a13, ((i) getUI()).gb() == 0);
            String I = i6.m.I(ad.a.a(i6.m.v0(arrayList), i6.m.v0(arrayList2), a11, y02, a15, a16, a17), i6.m.a(this.f19447d.getBasePrecision()).intValue());
            i6.m.a(I).compareTo(BigDecimal.ZERO);
            if (((i) getUI()).y8()) {
                GridAiQuote gridAiQuote = this.f19449f;
                if (gridAiQuote != null && !TextUtils.isEmpty(gridAiQuote.getMinInvest())) {
                    I = this.f19449f.getMinInvest();
                    ((i) getUI()).Aa("≥ " + this.f19449f.getMinInvest());
                }
            } else if (((i) getUI()).Qf() && !TextUtils.isEmpty(this.f19444a)) {
                I = this.f19444a;
                ((i) getUI()).D8("≥ " + I);
            }
            return i6.m.a(I);
        } else if (((i) getUI()).y8()) {
            ((i) getUI()).Aa("");
            return null;
        } else if (!((i) getUI()).Qf()) {
            return null;
        } else {
            ((i) getUI()).D8("");
            return null;
        }
    }

    public void q0() {
        p0();
        s0();
        r0();
        t0();
    }

    public BigDecimal r0() {
        if (((i) getUI()).y8()) {
            return null;
        }
        boolean z11 = this.f19448e == null;
        if (this.f19447d == null) {
            z11 = true;
        }
        if (this.f19446c == null) {
            z11 = true;
        }
        BigDecimal a11 = i6.m.a(((i) getUI()).b5());
        if (a11.compareTo(BigDecimal.ZERO) <= 0) {
            z11 = true;
        }
        BigDecimal a12 = i6.m.a(((i) getUI()).we());
        if (a12.compareTo(BigDecimal.ZERO) <= 0) {
            z11 = true;
        }
        BigDecimal a13 = i6.m.a(String.valueOf(((i) getUI()).na()));
        if (a13.compareTo(i6.m.a("2")) < 0) {
            z11 = true;
        }
        if (a13.compareTo(i6.m.a("99")) > 0) {
            z11 = true;
        }
        if (a11.compareTo(a12) >= 0) {
            z11 = true;
        }
        if (z11) {
            ((i) getUI()).Yc("");
            return null;
        }
        BigDecimal a14 = i6.m.a(String.valueOf(this.f19448e.getClose()));
        BigDecimal u02 = u0(a11);
        BigDecimal a15 = i6.m.a(this.f19446c.getAssetBuff());
        ArrayList arrayList = new ArrayList();
        ad.a.b((List<BigDecimal>) null, arrayList, a14, a11, a12, a13, ((i) getUI()).gb() == 0);
        String I = i6.m.I(ad.a.c(i6.m.a(String.valueOf(arrayList.size())), u02, a15), i6.m.a(this.f19447d.getBasePrecision()).intValue());
        ((i) getUI()).Yc("≥ " + I);
        return i6.m.a(I);
    }

    public BigDecimal s0() {
        if (((i) getUI()).y8() || ((i) getUI()).Qf()) {
            return null;
        }
        boolean z11 = this.f19448e == null;
        if (this.f19447d == null) {
            z11 = true;
        }
        if (this.f19446c == null) {
            z11 = true;
        }
        BigDecimal a11 = i6.m.a(((i) getUI()).b5());
        if (a11.compareTo(BigDecimal.ZERO) <= 0) {
            z11 = true;
        }
        BigDecimal a12 = i6.m.a(((i) getUI()).we());
        if (a12.compareTo(BigDecimal.ZERO) <= 0) {
            z11 = true;
        }
        BigDecimal a13 = i6.m.a(String.valueOf(((i) getUI()).na()));
        if (a13.compareTo(i6.m.a("2")) < 0) {
            z11 = true;
        }
        if (a13.compareTo(i6.m.a("99")) > 0) {
            z11 = true;
        }
        if (a11.compareTo(a12) >= 0) {
            z11 = true;
        }
        if (z11) {
            ((i) getUI()).D8("");
            return null;
        }
        BigDecimal a14 = i6.m.a(String.valueOf(this.f19448e.getClose()));
        BigDecimal y02 = y0(a12);
        BigDecimal a15 = i6.m.a(this.f19447d.getUserFeeRate());
        BigDecimal a16 = i6.m.a(this.f19446c.getAssetBuff());
        ArrayList arrayList = new ArrayList();
        ad.a.b(arrayList, (List<BigDecimal>) null, a14, a11, a12, a13, ((i) getUI()).gb() == 0);
        String I = i6.m.I(ad.a.d(i6.m.v0(arrayList), a11, y02, a15, a16), i6.m.a(this.f19447d.getBasePrecision()).intValue());
        ((i) getUI()).D8("≥ " + I);
        return i6.m.a(I);
    }

    public void t0() {
        String str;
        if (!((i) getUI()).y8()) {
            boolean z11 = false;
            boolean z12 = true;
            if (this.f19447d == null) {
                z11 = true;
            }
            BigDecimal a11 = i6.m.a(((i) getUI()).b5());
            if (a11.compareTo(BigDecimal.ZERO) <= 0) {
                z11 = true;
            }
            BigDecimal a12 = i6.m.a(((i) getUI()).we());
            if (a12.compareTo(BigDecimal.ZERO) <= 0) {
                z11 = true;
            }
            BigDecimal a13 = i6.m.a(String.valueOf(((i) getUI()).na()));
            if (a13.compareTo(i6.m.a("2")) < 0) {
                z11 = true;
            }
            if (a13.compareTo(i6.m.a("99")) > 0) {
                z11 = true;
            }
            if (a11.compareTo(a12) < 0) {
                z12 = z11;
            }
            if (z12) {
                ((i) getUI()).Mf("--");
                return;
            }
            BigDecimal a14 = i6.m.a(this.f19447d.getUserFeeRate());
            if (((i) getUI()).gb() == 0) {
                BigDecimal i11 = ad.a.i(a12, a11, a13);
                BigDecimal subtract = a12.subtract(i11);
                BigDecimal add = a11.add(i11);
                str = i6.m.Q(ad.a.f(a12, subtract, a14).toPlainString(), 2, 4) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i6.m.Q(ad.a.e(a11, add, a14).toPlainString(), 2, 4);
            } else {
                str = i6.m.Q(ad.a.g(a11, a11.multiply(BigDecimal.ONE.add(ad.a.h(a12, a11, a13))), a14).toPlainString(), 2, 4);
            }
            ((i) getUI()).Mf(str);
        }
    }

    public final BigDecimal u0(BigDecimal bigDecimal) {
        BigDecimal a11 = i6.m.a(this.f19447d.getMinBaseAmount());
        BigDecimal divide = i6.m.a(this.f19447d.getMinQuoteAmount()).divide(bigDecimal, 32, 0);
        return a11.compareTo(divide) >= 0 ? a11 : divide;
    }

    public String v0(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return "--";
        }
        if (TextUtils.isEmpty(str2) || !a1.v().D(str2).equalsIgnoreCase("usdt")) {
            str3 = LegalCurrencyConfigUtil.A(str, str2, TradeType.PRO);
        } else {
            str3 = LegalCurrencyConfigUtil.B(str);
        }
        String i11 = StringUtils.i(LegalCurrencyConfigUtil.y());
        String string = getResources().getString(R$string.balance_total_cny);
        return String.format(string, new Object[]{" " + str3 + " " + i11});
    }

    public final void w0() {
        if (vc.b.a().a()) {
            ClearDialogConfigController.c(6, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
        }
    }

    public void x0() {
        vc.b.a().k(getActivity());
    }

    public final BigDecimal y0(BigDecimal bigDecimal) {
        BigDecimal a11 = i6.m.a(this.f19447d.getMinQuoteAmount());
        BigDecimal multiply = bigDecimal.multiply(i6.m.a(this.f19447d.getMinBaseAmount()));
        return a11.compareTo(multiply) >= 0 ? a11 : multiply;
    }
}
