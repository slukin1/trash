package com.huobi.feature.ui;

import a7.e;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import bj.p0;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.contract.entity.PriceType;
import com.huobi.feature.bean.FutureTpSlDialogShowBean;
import com.huobi.feature.bean.FutureTpSlSettingParams;
import com.huobi.feature.util.FutureTpSlFuturesHelper;
import com.huobi.feature.util.FutureTpSlHelper;
import com.huobi.view.TradePriceEditext;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ej.f;
import ej.g;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import pk.k;
import pk.l;
import pro.huobi.R;
import qk.m0;
import us.i;
import us.j;

public class FutureTpSlSettingDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f44704b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f44705c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f44706d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f44707e;

    /* renamed from: f  reason: collision with root package name */
    public FutureTpSlDialogShowBean f44708f;

    /* renamed from: g  reason: collision with root package name */
    public FutureTpSlSettingParams f44709g;

    /* renamed from: h  reason: collision with root package name */
    public FutureTpSlSettingParams f44710h;

    /* renamed from: i  reason: collision with root package name */
    public BigDecimal f44711i;

    /* renamed from: j  reason: collision with root package name */
    public FutureTpSlHelper f44712j;

    /* renamed from: k  reason: collision with root package name */
    public c f44713k;

    public enum OpenType {
        None,
        OpenLong,
        OpenShort
    }

    public class b implements FutureTpSlHelper.i {
        public b() {
        }

        public String E0() {
            return FutureTpSlSettingDialogFragment.this.f44708f.getContractCode();
        }

        public void a() {
            FutureTpSlSettingDialogFragment.this.Ih();
        }

        public boolean b(EditText editText, Editable editable) {
            return false;
        }

        public BigDecimal c(String str, int i11) {
            int i12;
            String plainString = FutureTpSlSettingDialogFragment.this.Eh().toPlainString();
            boolean isOpenLong = FutureTpSlSettingDialogFragment.this.f44709g.isOpenLong();
            boolean Ah = FutureTpSlSettingDialogFragment.this.Jh(i11);
            if (FutureTpSlSettingDialogFragment.this.f44708f.isLinearSwap()) {
                i12 = FuturePrecisionUtil.y(FutureTpSlSettingDialogFragment.this.f44708f.getContractCode(), FutureTpSlSettingDialogFragment.this.f44708f.getContractShortType(), (String) null);
            } else if (FutureTpSlSettingDialogFragment.this.f44708f.isSwap()) {
                i12 = i.m(FutureTpSlSettingDialogFragment.this.f44708f.getSymbol());
            } else {
                i12 = f.p(FutureTpSlSettingDialogFragment.this.f44708f.getContractCode());
            }
            return FutureTpSlFuturesHelper.k(str, i12, plainString, isOpenLong, Ah);
        }

        public String d(String str, boolean z11, BigDecimal bigDecimal) {
            int i11;
            int i12;
            if (!(TextUtils.isEmpty(str) || bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) == 0)) {
                if (z11) {
                    i11 = FutureTpSlSettingDialogFragment.this.f44712j.w0();
                } else {
                    i11 = FutureTpSlSettingDialogFragment.this.f44712j.v0();
                }
                BigDecimal a11 = m.a(str);
                BigDecimal i13 = FutureTpSlFuturesHelper.i(FutureTpSlSettingDialogFragment.this.f44708f, FutureTpSlSettingDialogFragment.this.f44709g.isOpenLong(), FutureTpSlSettingDialogFragment.this.Eh(), i11, a11, a11);
                if (!(i13 == null || i13.compareTo(BigDecimal.ZERO) == 0)) {
                    BigDecimal multiply = i13.multiply(bigDecimal);
                    if (FutureTpSlSettingDialogFragment.this.f44708f.isLinearSwap()) {
                        i12 = 4;
                    } else {
                        i12 = i.p(FutureTpSlSettingDialogFragment.this.f44708f.getContractCode());
                    }
                    return multiply.setScale(i12, 1).toPlainString();
                }
            }
            return "--";
        }

        public FutureTpSlFuturesHelper.a e(int i11, String str, boolean z11) {
            return FutureTpSlSettingDialogFragment.this.Lh(i11);
        }

        public String f() {
            return FutureTpSlSettingDialogFragment.this.f44709g.isOpenLong() ? "buy" : "sell";
        }

        public BigDecimal g(String str, boolean z11, BigDecimal bigDecimal) {
            int i11;
            if (TextUtils.isEmpty(str)) {
                return BigDecimal.ZERO;
            }
            BigDecimal h11 = FutureTpSlFuturesHelper.h(FutureTpSlSettingDialogFragment.this.f44708f.getContractFace(), BigDecimal.valueOf(FutureTpSlSettingDialogFragment.this.f44708f.getContVolume().longValue()), FutureTpSlSettingDialogFragment.this.f44709g.isOpenLong(), FutureTpSlSettingDialogFragment.this.Eh(), m.a(str), FutureTpSlSettingDialogFragment.this.f44708f.getTradeType());
            if (h11 == null || h11.compareTo(BigDecimal.ZERO) <= 0) {
                return BigDecimal.ZERO;
            }
            if (FutureTpSlSettingDialogFragment.this.f44708f.isLinearSwap()) {
                i11 = FuturePrecisionUtil.y(FutureTpSlSettingDialogFragment.this.f44708f.getContractCode(), FutureTpSlSettingDialogFragment.this.f44708f.getContractShortType(), (String) null);
            } else if (FutureTpSlSettingDialogFragment.this.f44708f.isSwap()) {
                i11 = i.m(FutureTpSlSettingDialogFragment.this.f44708f.getSymbol());
            } else {
                i11 = f.p(FutureTpSlSettingDialogFragment.this.f44708f.getContractCode());
            }
            return h11.setScale(i11, 1);
        }

        public Activity getActivity() {
            return FutureTpSlSettingDialogFragment.this.getActivity();
        }

        public String getQuoteCurrency() {
            if (FutureTpSlSettingDialogFragment.this.f44708f.isLinearSwap()) {
                return "USDT";
            }
            return FutureTpSlSettingDialogFragment.this.getString(R.string.usd_en_uppercase);
        }

        public int getTradePricePrecision() {
            if (FutureTpSlSettingDialogFragment.this.f44708f.isLinearSwap()) {
                return FuturePrecisionUtil.y(FutureTpSlSettingDialogFragment.this.f44708f.getContractCode(), FutureTpSlSettingDialogFragment.this.f44708f.getContractShortType(), (String) null);
            }
            if (FutureTpSlSettingDialogFragment.this.f44708f.isSwap()) {
                return i.m(FutureTpSlSettingDialogFragment.this.f44708f.getSymbol());
            }
            return f.p(FutureTpSlSettingDialogFragment.this.f44708f.getContractCode());
        }

        public String h(String str, int i11) {
            String plainString = FutureTpSlSettingDialogFragment.this.Eh().toPlainString();
            boolean isOpenLong = FutureTpSlSettingDialogFragment.this.f44709g.isOpenLong();
            String lever = FutureTpSlSettingDialogFragment.this.f44708f.getLever();
            boolean Ah = FutureTpSlSettingDialogFragment.this.Jh(i11);
            if (FutureTpSlSettingDialogFragment.this.f44708f.isLinearSwap()) {
                return FutureTpSlFuturesHelper.j(str, FuturePrecisionUtil.y(FutureTpSlSettingDialogFragment.this.f44708f.getContractCode(), FutureTpSlSettingDialogFragment.this.f44708f.getContractShortType(), (String) null), plainString, lever, isOpenLong, Ah, TradeType.LINEAR_SWAP);
            } else if (FutureTpSlSettingDialogFragment.this.f44708f.isSwap()) {
                return FutureTpSlFuturesHelper.j(str, i.m(FutureTpSlSettingDialogFragment.this.f44708f.getSymbol()), plainString, lever, isOpenLong, Ah, TradeType.SWAP);
            } else {
                return FutureTpSlFuturesHelper.j(str, f.p(FutureTpSlSettingDialogFragment.this.f44708f.getContractCode()), plainString, lever, isOpenLong, Ah, TradeType.CONTRACT);
            }
        }

        public String o0() {
            return FutureTpSlSettingDialogFragment.this.f44708f.getSymbol();
        }
    }

    public interface c {
        void a(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2);
    }

    public static FutureTpSlSettingDialogFragment Kh(FutureTpSlDialogShowBean futureTpSlDialogShowBean) {
        FutureTpSlSettingDialogFragment futureTpSlSettingDialogFragment = new FutureTpSlSettingDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("params", futureTpSlDialogShowBean);
        futureTpSlSettingDialogFragment.setArguments(bundle);
        return futureTpSlSettingDialogFragment;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismissAllowingStateLoss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        Nh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Oh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        Ph();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final BigDecimal Ch() {
        BigDecimal valueOf = BigDecimal.valueOf(this.f44708f.getContVolume().longValue());
        BigDecimal multiply = valueOf.multiply(this.f44708f.getContractFace());
        if (!this.f44708f.isLinearSwap()) {
            return e.E(this.f44708f.getTradeType()) ? m.a(m.q(multiply.divide(Eh(), 1), f.n(this.f44708f.getContractCode()))) : valueOf;
        }
        if (e.E(TradeType.LINEAR_SWAP)) {
            return m.a(m.q(multiply, FuturePrecisionUtil.s(this.f44708f.getContractCode(), this.f44708f.getContractShortType(), (String) null)));
        }
        return m.a(m.q(multiply.multiply(Eh()), FuturePrecisionUtil.g(this.f44708f.getSymbol())));
    }

    public final BigDecimal Dh() {
        return BigDecimal.valueOf(this.f44708f.getContVolume().longValue());
    }

    public final BigDecimal Eh() {
        BigDecimal entrustPrice = this.f44708f.getEntrustPrice();
        if (entrustPrice != null) {
            return entrustPrice;
        }
        BigDecimal bigDecimal = this.f44711i;
        if (bigDecimal != null) {
            return bigDecimal;
        }
        return BigDecimal.ZERO;
    }

    public final int Fh(boolean z11) {
        if (z11) {
            return R.drawable.shape_contract_trade_view_indicator_green_bg;
        }
        return w.l() ? R.drawable.shape_exchange_red_vertical_light_bg : R.drawable.shape_exchange_green_vertical_light_bg;
    }

    public final int Gh(boolean z11) {
        if (!z11) {
            return R.drawable.shape_contract_trade_view_indicator_red_bg_right;
        }
        return w.l() ? R.drawable.shape_exchange_green_vertical_light_bg_right : R.drawable.shape_exchange_red_vertical_light_bg_right;
    }

    public PriceType Hh(String str) {
        if (TextUtils.equals("optimal_5", str)) {
            return PriceType.OPTIMAL_FIVE;
        }
        if (TextUtils.equals("optimal_10", str)) {
            return PriceType.OPTIMAL_TEN;
        }
        if (TextUtils.equals("optimal_20", str)) {
            return PriceType.OPTIMAL_TWENTY;
        }
        if (TextUtils.equals(PrimeRounds.ROUND_TRADE_MARKET_TYPE, str)) {
            return PriceType.MARKET;
        }
        return PriceType.LIMIT;
    }

    public final void Ih() {
        View findFocus;
        if (getView() != null && (findFocus = getView().findFocus()) != null) {
            SoftInputUtils.g(getActivity(), findFocus);
        }
    }

    public final boolean Jh(int i11) {
        return i11 == 0;
    }

    public FutureTpSlFuturesHelper.a Lh(int i11) {
        int n11;
        BigDecimal Dh = Dh();
        String symbol = this.f44708f.getSymbol();
        String contractCode = this.f44708f.getContractCode();
        String plainString = this.f44708f.getContractFace().toPlainString();
        String contractShortType = this.f44708f.getContractShortType();
        if (this.f44708f.isLinearSwap()) {
            n11 = FuturePrecisionUtil.s(contractCode, contractShortType, (String) null);
        } else if (this.f44708f.isSwap()) {
            n11 = i.c(symbol);
        } else {
            n11 = f.n(contractCode);
        }
        return FutureTpSlFuturesHelper.g(this.f44708f.getTradeType(), plainString, Dh, symbol, BigDecimal.valueOf((long) i11), Eh().toPlainString(), n11);
    }

    public final void Mh(int i11) {
        FutureTpSlFuturesHelper.a Lh = Lh(i11);
        EditText l02 = this.f44712j.l0();
        this.f44712j.B1(Lh.f45107b);
        l02.setText(Lh.f45106a);
    }

    public final void Nh() {
        FutureTpSlSettingParams futureTpSlSettingParams;
        if (this.f44712j.e0() && this.f44712j.f0()) {
            FutureTpSlSettingParams futureTpSlSettingParams2 = null;
            if (this.f44712j.q0()) {
                String E0 = this.f44712j.E0(0);
                if (m0.a(true, this.f44709g.isOpenLong(), m.a(E0), Eh())) {
                    String D0 = this.f44712j.D0(0);
                    int C0 = this.f44712j.C0(0);
                    String F0 = this.f44712j.F0(0);
                    String r02 = this.f44712j.r0(0);
                    this.f44709g.setTriggerPrice(m.a(E0));
                    this.f44709g.setTriggerInputValue(D0);
                    this.f44709g.setTriggerInputType(C0);
                    this.f44709g.setEntrustPrice(m.a(F0));
                    this.f44709g.setPriceType(Hh(r02));
                    if (this.f44712j.X0()) {
                        this.f44709g.setTriggerType("3");
                    } else {
                        this.f44709g.setTriggerType((String) null);
                    }
                    this.f44709g.setTpslVolumeRate(1.0d);
                    this.f44709g.setTpslAdvanced(true);
                    futureTpSlSettingParams = this.f44709g;
                } else {
                    return;
                }
            } else {
                futureTpSlSettingParams = null;
            }
            if (this.f44712j.p0()) {
                String E02 = this.f44712j.E0(1);
                if (m0.a(false, this.f44710h.isOpenLong(), m.a(E02), Eh())) {
                    String D02 = this.f44712j.D0(1);
                    int C02 = this.f44712j.C0(1);
                    String F02 = this.f44712j.F0(1);
                    String r03 = this.f44712j.r0(1);
                    this.f44710h.setTriggerPrice(m.a(E02));
                    this.f44710h.setTriggerInputValue(D02);
                    this.f44710h.setTriggerInputType(C02);
                    this.f44710h.setEntrustPrice(m.a(F02));
                    this.f44710h.setPriceType(Hh(r03));
                    if (this.f44712j.W0()) {
                        this.f44710h.setTriggerType("3");
                    } else {
                        this.f44710h.setTriggerType((String) null);
                    }
                    this.f44710h.setTpslVolumeRate(1.0d);
                    this.f44710h.setTpslAdvanced(true);
                    futureTpSlSettingParams2 = this.f44710h;
                } else {
                    return;
                }
            }
            c cVar = this.f44713k;
            if (cVar != null) {
                cVar.a(futureTpSlSettingParams, futureTpSlSettingParams2);
            }
            Ih();
            dismiss();
        }
    }

    public final void Oh() {
        if (!this.f44709g.isOpenLong()) {
            Rh(OpenType.OpenLong);
        }
    }

    public final void Ph() {
        if (!this.f44709g.isOpenShort()) {
            Rh(OpenType.OpenShort);
        }
    }

    public final void Qh() {
        String str;
        if (this.f44708f.getEntrustPrice() == null) {
            TradeType tradeType = this.f44708f.getTradeType();
            if (this.f44708f.isLinearSwap()) {
                if (e.E(tradeType)) {
                    str = this.f44708f.getSymbol();
                } else {
                    str = "usdt".toUpperCase(Locale.US);
                }
            } else if (e.E(tradeType)) {
                str = this.f44708f.getSymbol();
            } else {
                str = getString(R.string.contract_trade_unit_sheet);
            }
            TextView textView = this.f44707e;
            textView.setText(Ch().toPlainString() + " " + str);
            Mh(this.f44712j.z0());
            this.f44712j.H1(0);
            this.f44712j.H1(1);
        }
    }

    public final void Rh(OpenType openType) {
        this.f44709g.setOpenType(openType);
        this.f44710h.setOpenType(openType);
        Sh();
        this.f44712j.s1();
    }

    public final void Sh() {
        this.f44705c.setBackgroundResource(Fh(this.f44709g.isOpenShort()));
        this.f44706d.setBackgroundResource(Gh(this.f44709g.isOpenShort()));
        if (this.f44709g.isOpenShort()) {
            this.f44705c.setTextColor(getResources().getColor(R.color.global_secondary_text_color));
            this.f44706d.setTextColor(getResources().getColor(R.color.baseTextColor));
            return;
        }
        this.f44705c.setTextColor(getResources().getColor(R.color.baseTextColor));
        this.f44706d.setTextColor(getResources().getColor(R.color.global_secondary_text_color));
    }

    public final void Th() {
        String str;
        String str2;
        String upperCase = this.f44708f.getSymbol().toUpperCase();
        if (this.f44708f.isLinearSwap()) {
            str2 = e.f(this.f44708f.getContractShortType());
            str = "USDT";
        } else if (this.f44708f.isSwap()) {
            str = getString(R.string.usd_en_uppercase);
            str2 = j.j(getContext());
        } else {
            str = getString(R.string.usd_en_uppercase);
            str2 = g.c(this.f44708f.getContractShortType());
        }
        TextView textView = this.f44704b;
        textView.setText(upperCase + str + str2);
    }

    public void Uh(c cVar) {
        this.f44713k = cVar;
    }

    public void Vh(BigDecimal bigDecimal) {
        this.f44711i = bigDecimal;
        if (isAdded() && getDialog() != null && getDialog().isShowing()) {
            Qh();
        }
    }

    public final void Wh() {
        String str;
        String str2;
        String str3;
        if (this.f44709g.getTriggerPrice() != null) {
            this.f44709g.getTriggerPrice().toPlainString();
        }
        if (this.f44710h.getTriggerPrice() != null) {
            this.f44710h.getTriggerPrice().toPlainString();
        }
        String str4 = "";
        if (this.f44709g.getTriggerInputValue() == null) {
            str = str4;
        } else {
            str = this.f44709g.getTriggerInputValue();
        }
        if (this.f44710h.getTriggerInputValue() == null) {
            str2 = str4;
        } else {
            str2 = this.f44710h.getTriggerInputValue();
        }
        int triggerInputType = this.f44709g.getTriggerInputType();
        int triggerInputType2 = this.f44710h.getTriggerInputType();
        String triggerType = this.f44709g.getTriggerType();
        String triggerType2 = this.f44710h.getTriggerType();
        if (this.f44709g.getEntrustPrice() == null) {
            str3 = str4;
        } else {
            str3 = this.f44709g.getEntrustPrice().toPlainString();
        }
        if (this.f44710h.getEntrustPrice() != null) {
            str4 = this.f44710h.getEntrustPrice().toPlainString();
        }
        PriceType priceType = this.f44709g.getPriceType();
        PriceType priceType2 = this.f44710h.getPriceType();
        this.f44712j.L0(str, str2, triggerInputType, triggerInputType2, triggerType, triggerType2, str3, str4, priceType, priceType2);
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.close_button).setOnClickListener(new pk.m(this));
        rVar.e(R.id.dialog_confirm_button).setOnClickListener(new pk.j(this));
        this.f44705c.setOnClickListener(new k(this));
        this.f44706d.setOnClickListener(new l(this));
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R.layout.dialog_future_open_order_tpsl;
    }

    public int getGravity() {
        return 80;
    }

    public final void initData() {
        String str;
        this.f44712j.K0();
        TradeType tradeType = this.f44708f.getTradeType();
        if (this.f44708f.isLinearSwap()) {
            if (e.E(tradeType)) {
                str = this.f44708f.getSymbol();
            } else {
                str = "usdt".toUpperCase(Locale.US);
            }
        } else if (e.E(tradeType)) {
            str = this.f44708f.getSymbol();
        } else {
            str = getString(R.string.contract_trade_unit_sheet);
        }
        TextView textView = this.f44707e;
        textView.setText(Ch().toPlainString() + " " + str);
        Wh();
        if (this.f44709g.getTpslVolumeRate() != 0.0d) {
            int tpslVolumeRate = (int) (this.f44709g.getTpslVolumeRate() * 100.0d);
            this.f44712j.E1((float) tpslVolumeRate);
            Mh(tpslVolumeRate);
        } else if (this.f44710h.getTpslVolumeRate() != 0.0d) {
            int tpslVolumeRate2 = (int) (this.f44710h.getTpslVolumeRate() * 100.0d);
            this.f44712j.E1((float) tpslVolumeRate2);
            Mh(tpslVolumeRate2);
        }
        this.f44712j.H1(0);
        this.f44712j.H1(1);
    }

    public void initView(r rVar) {
        rVar.b(R.id.open_long_short_tab).setVisibility((!this.f44708f.isLinearSwap() ? !p0.h() : !p0.g()) ? 8 : 0);
        ((TradePriceEditext) rVar.b(R.id.tpeCount)).getEditText().setEnabled(false);
        this.f44704b = rVar.e(R.id.contract_name);
        TextView e11 = rVar.e(R.id.title_margin_mode);
        TextView e12 = rVar.e(R.id.title_lever);
        this.f44705c = rVar.e(R.id.open_long_button);
        this.f44706d = rVar.e(R.id.open_short_button);
        this.f44707e = rVar.e(R.id.dialog_contract_available);
        Sh();
        this.f44712j.z1(!this.f44708f.isSingleMode());
        ViewGroup viewGroup = (ViewGroup) rVar.b(R.id.ll_tpsl_content);
        this.f44712j.I0(viewGroup, this, true);
        this.f44712j.G0(viewGroup);
        rVar.b(R.id.rl_tpsl_available).setVisibility(8);
        String lever = this.f44708f.getLever();
        e12.setText(lever + "X");
        e12.setVisibility(0);
        String marginMode = this.f44708f.getMarginMode();
        if (!TextUtils.isEmpty(marginMode)) {
            e11.setText(marginMode);
            e11.setVisibility(0);
        }
        initData();
        Th();
        viewGroup.requestFocus();
        viewGroup.requestFocusFromTouch();
    }

    public boolean isTransparent() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            FutureTpSlDialogShowBean futureTpSlDialogShowBean = (FutureTpSlDialogShowBean) arguments.getSerializable("params");
            this.f44708f = futureTpSlDialogShowBean;
            this.f44709g = futureTpSlDialogShowBean.getStopProfitSetting();
            this.f44710h = this.f44708f.getStopLossSetting();
        }
        this.f44712j = new FutureTpSlHelper(this.f44708f.getTradeType(), new b());
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f44712j.k0();
    }
}
