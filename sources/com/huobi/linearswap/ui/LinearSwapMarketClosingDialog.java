package com.huobi.linearswap.ui;

import a7.e;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import bh.j;
import bj.p0;
import cn.a0;
import cn.b0;
import cn.c0;
import cn.k2;
import cn.y;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.ui.ContractMarketTwTradeLayout;
import com.huobi.contract.utils.KycLimitCodeUtils;
import com.huobi.feature.util.KycAndHasTradeDialogUtils;
import com.huobi.feature.util.MarketTwTradeStateObservable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import tg.r;
import u6.g;
import ym.z;

public class LinearSwapMarketClosingDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public AppCompatTextView f75222b;

    /* renamed from: c  reason: collision with root package name */
    public CheckBox f75223c;

    /* renamed from: d  reason: collision with root package name */
    public AppCompatTextView f75224d;

    /* renamed from: e  reason: collision with root package name */
    public AppCompatTextView f75225e;

    /* renamed from: f  reason: collision with root package name */
    public AppCompatTextView f75226f;

    /* renamed from: g  reason: collision with root package name */
    public FutureContractInfo f75227g;

    /* renamed from: h  reason: collision with root package name */
    public LinearSwapPosition f75228h;

    /* renamed from: i  reason: collision with root package name */
    public String f75229i;

    /* renamed from: j  reason: collision with root package name */
    public String f75230j;

    /* renamed from: k  reason: collision with root package name */
    public z f75231k;

    /* renamed from: l  reason: collision with root package name */
    public b f75232l;

    /* renamed from: m  reason: collision with root package name */
    public View f75233m;

    /* renamed from: n  reason: collision with root package name */
    public LoadingView f75234n;

    /* renamed from: o  reason: collision with root package name */
    public ContractMarketTwTradeLayout f75235o;

    /* renamed from: p  reason: collision with root package name */
    public int f75236p;

    /* renamed from: q  reason: collision with root package name */
    public BigDecimal f75237q;

    /* renamed from: r  reason: collision with root package name */
    public BigDecimal f75238r;

    /* renamed from: s  reason: collision with root package name */
    public int f75239s;

    /* renamed from: t  reason: collision with root package name */
    public String f75240t;

    /* renamed from: u  reason: collision with root package name */
    public String f75241u;

    /* renamed from: v  reason: collision with root package name */
    public String f75242v;

    /* renamed from: w  reason: collision with root package name */
    public String f75243w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f75244x;

    public class a implements ContractMarketTwTradeLayout.b {
        public a() {
        }

        public void a(boolean z11) {
            if (!TextUtils.isEmpty(LinearSwapMarketClosingDialog.this.f75242v)) {
                if (z11) {
                    LinearSwapMarketClosingDialog.this.f75226f.setText(LinearSwapMarketClosingDialog.this.f75243w);
                } else {
                    AppCompatTextView yh2 = LinearSwapMarketClosingDialog.this.f75226f;
                    yh2.setText(LinearSwapMarketClosingDialog.this.f75243w + LinearSwapMarketClosingDialog.this.f75242v);
                }
            }
            MarketTwTradeStateObservable.a().b(z11);
        }
    }

    public interface b {
        void a();
    }

    public class c extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public boolean f75246b;

        public c(boolean z11) {
            this.f75246b = z11;
        }

        public void onAfter() {
            super.onAfter();
            LinearSwapMarketClosingDialog.this.f75233m.setVisibility(8);
            LinearSwapMarketClosingDialog.this.f75234n.d();
            LinearSwapMarketClosingDialog.this.f75225e.setEnabled(true);
        }

        public void onError2(Throwable th2) {
            if (!NetworkStatus.c(BaseApplication.b())) {
                HuobiToastUtil.j(R.string.n_no_network);
            } else {
                HuobiToastUtil.k(BaseApplication.b(), R.string.string_order_op_fail);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (KycLimitCodeUtils.a(aPIStatusErrorException.getErrCode())) {
                LinearSwapMarketClosingDialog.this.t1(aPIStatusErrorException.getErrMsg());
            } else if (KycLimitCodeUtils.b(aPIStatusErrorException.getErrCode())) {
                LinearSwapMarketClosingDialog.this.q(aPIStatusErrorException.getErrMsg());
            } else {
                String errCode = aPIStatusErrorException.getErrCode();
                errCode.hashCode();
                if (!errCode.equals("1096")) {
                    if (errCode.equals("1501")) {
                        LinearSwapMarketClosingDialog.this.b1();
                        return;
                    }
                } else if (this.f75246b) {
                    HuobiToastUtil.k(BaseApplication.b(), R.string.n_trail_fund_above_60_toast);
                    return;
                }
                if (TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                    HuobiToastUtil.k(j.c(), R.string.string_order_op_fail);
                } else {
                    HuobiToastUtil.l(j.c(), aPIStatusErrorException.getErrMsg());
                }
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.t(j.c(), R.string.n_contract_market_closing_submit);
            s6.a.b(j.c()).c(R.raw.order_success);
            if (LinearSwapMarketClosingDialog.this.f75223c.isChecked()) {
                p0.i(0);
            } else {
                p0.i(1);
            }
            EventBus.d().k(new ContractAssetAndOrderUpdateEvent());
            i.b().g(new c0(LinearSwapMarketClosingDialog.this), 10);
        }

        public void onStart() {
            super.onStart();
            LinearSwapMarketClosingDialog.this.f75233m.setVisibility(0);
            LinearSwapMarketClosingDialog.this.f75225e.setEnabled(false);
            LinearSwapMarketClosingDialog.this.f75234n.c();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        Oh(this.f75241u, this.f75240t, 2, 6);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Eh() {
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.X0(6);
        contractOrderPlace.B0(this.f75241u);
        contractOrderPlace.y0(0);
        contractOrderPlace.r0(m.a(this.f75228h.getLastPrice()).doubleValue());
        contractOrderPlace.h0(w2());
        contractOrderPlace.A0(2);
        contractOrderPlace.N0(this.f75229i);
        contractOrderPlace.v0(this.f75236p);
        contractOrderPlace.E0(this.f75239s);
        Qh(this.f75231k.s(contractOrderPlace));
    }

    public final String Fh() {
        String str;
        LinearSwapPosition linearSwapPosition = this.f75228h;
        if (linearSwapPosition == null) {
            str = null;
        } else {
            str = linearSwapPosition.getLastPrice();
        }
        if (str == null) {
            return i8.m.b().c(this.f75230j);
        }
        return m.a(str).toPlainString();
    }

    public final Observable<Object> Gh(ContractOrderPlace contractOrderPlace) {
        contractOrderPlace.z0(this.f75228h.getPositionSide());
        return this.f75231k.o0(contractOrderPlace, this.f75227g).compose(RxJavaHelper.t((g) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0026, code lost:
        if (com.hbg.lib.core.util.w.l() != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
        if (com.hbg.lib.core.util.w.l() != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Jh(com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            com.hbg.lib.network.option.core.util.OptionDirection r0 = com.hbg.lib.network.option.core.util.OptionDirection.BUY
            java.lang.String r0 = r0.direction
            java.lang.String r1 = r8.getDirection()
            boolean r0 = r0.equalsIgnoreCase(r1)
            r1 = 2131100818(0x7f060492, float:1.7814028E38)
            r2 = 2131100799(0x7f06047f, float:1.781399E38)
            if (r0 == 0) goto L_0x0029
            android.content.res.Resources r0 = r7.getResources()
            r3 = 2132021025(0x7f140f21, float:1.968043E38)
            java.lang.String r0 = r0.getString(r3)
            boolean r3 = com.hbg.lib.core.util.w.l()
            if (r3 == 0) goto L_0x003c
            goto L_0x003b
        L_0x0029:
            android.content.res.Resources r0 = r7.getResources()
            r3 = 2132021034(0x7f140f2a, float:1.9680448E38)
            java.lang.String r0 = r0.getString(r3)
            boolean r3 = com.hbg.lib.core.util.w.l()
            if (r3 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r1 = r2
        L_0x003c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r8.getSymbol()
            r2.append(r3)
            com.hbg.lib.data.future.bean.FutureContractInfo r3 = r7.f75227g
            java.lang.String r3 = r3.getQuoteCurrency()
            r2.append(r3)
            r2.append(r0)
            java.lang.String r8 = r8.getLeverRate()
            r2.append(r8)
            java.lang.String r8 = "X"
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            android.content.res.Resources r2 = r7.getResources()
            r3 = 2132020902(0x7f140ea6, float:1.968018E38)
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r8
            java.lang.String r8 = r2.getString(r3, r4)
            android.content.res.Resources r2 = r7.getResources()
            r3 = 2132020903(0x7f140ea7, float:1.9680182E38)
            java.lang.String r2 = r2.getString(r3)
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder
            r3.<init>(r8)
            int r4 = r8.indexOf(r0)
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan
            android.content.Context r6 = r7.getContext()
            int r1 = androidx.core.content.ContextCompat.getColor(r6, r1)
            r5.<init>(r1)
            int r0 = r0.length()
            int r0 = r0 + r4
            r1 = 33
            r3.setSpan(r5, r4, r0, r1)
            int r8 = r8.indexOf(r2)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            android.content.Context r4 = r7.getContext()
            r5 = 2131099897(0x7f0600f9, float:1.781216E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r0.<init>(r4)
            int r2 = r2.length()
            int r2 = r2 + r8
            r3.setSpan(r0, r8, r2, r1)
            androidx.appcompat.widget.AppCompatTextView r8 = r7.f75222b
            r8.setText(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.linearswap.ui.LinearSwapMarketClosingDialog.Jh(com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition):void");
    }

    public void Kh(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        LinearSwapPosition e11 = linearSwapPositionOrderItem.e();
        this.f75228h = e11;
        if (e11 != null) {
            this.f75227g = linearSwapPositionOrderItem.d();
            this.f75229i = this.f75228h.getSymbol();
            this.f75230j = this.f75228h.getContractCode();
            this.f75241u = m.m(Fh(), FuturePrecisionUtil.y(this.f75227g.getContractCode(), this.f75227g.getContractShortType(), this.f75227g.getOptionCode()));
            if (this.f75228h.isSingleMode()) {
                this.f75243w = BaseApplication.b().getString(R.string.n_contract_market_closing_intro_single);
            } else {
                this.f75243w = BaseApplication.b().getString(R.string.n_contract_market_closing_intro_double);
            }
        }
    }

    public void Lh(int i11) {
        this.f75236p = i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = r3.f75227g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Mh() {
        /*
            r3 = this;
            qk.a r0 = qk.a.b()
            boolean r0 = r0.e()
            r3.f75244x = r0
            r1 = 0
            if (r0 == 0) goto L_0x0019
            com.hbg.lib.data.future.bean.FutureContractInfo r0 = r3.f75227g
            if (r0 == 0) goto L_0x0019
            boolean r0 = r0.isLinearSwapSwap()
            if (r0 == 0) goto L_0x0019
            r0 = 1
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            r3.f75244x = r0
            r2 = 8
            if (r0 == 0) goto L_0x0067
            com.huobi.contract.ui.ContractMarketTwTradeLayout r0 = r3.f75235o
            r0.setDash(r1)
            com.huobi.contract.ui.ContractMarketTwTradeLayout r0 = r3.f75235o
            r0.setVisibility(r1)
            android.widget.CheckBox r0 = r3.f75223c
            r0.setVisibility(r2)
            qk.a r0 = qk.a.b()
            boolean r0 = r0.d()
            com.huobi.contract.ui.ContractMarketTwTradeLayout r1 = r3.f75235o
            r1.setChecked(r0)
            java.lang.String r1 = r3.f75242v
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0071
            if (r0 == 0) goto L_0x004e
            androidx.appcompat.widget.AppCompatTextView r0 = r3.f75226f
            java.lang.String r1 = r3.f75243w
            r0.setText(r1)
            goto L_0x0071
        L_0x004e:
            androidx.appcompat.widget.AppCompatTextView r0 = r3.f75226f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r3.f75243w
            r1.append(r2)
            java.lang.String r2 = r3.f75242v
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            goto L_0x0071
        L_0x0067:
            com.huobi.contract.ui.ContractMarketTwTradeLayout r0 = r3.f75235o
            r0.setVisibility(r2)
            android.widget.CheckBox r0 = r3.f75223c
            r0.setVisibility(r1)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.linearswap.ui.LinearSwapMarketClosingDialog.Mh():void");
    }

    public final void Nh(ContractOrderPlace contractOrderPlace) {
        Gh(contractOrderPlace).subscribe(new c(false));
    }

    public void Oh(String str, String str2, int i11, int i12) {
        if (i12 != 1) {
            str = Fh();
        }
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.N0(this.f75229i);
        contractOrderPlace.B0(str);
        contractOrderPlace.d0(str2);
        contractOrderPlace.h0(w2());
        contractOrderPlace.A0(i11);
        contractOrderPlace.X0(i12);
        contractOrderPlace.r0(m.a(this.f75228h.getLastPrice()).doubleValue());
        contractOrderPlace.g0(4);
        contractOrderPlace.v0(this.f75236p);
        contractOrderPlace.E0(this.f75239s);
        LinearSwapPosition linearSwapPosition = this.f75228h;
        if (linearSwapPosition != null) {
            contractOrderPlace.s0(linearSwapPosition.getLeverRate());
        }
        if (w2()) {
            contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
        } else {
            contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
        }
        contractOrderPlace.x0(getString(R.string.contract_trade_position_close_quick));
        FutureContractInfo futureContractInfo = this.f75227g;
        contractOrderPlace.b1(qk.a.b().j(true, futureContractInfo == null || futureContractInfo.isLinearSwapSwap()));
        ContractOrderPlace e11 = this.f75231k.e(getActivity(), contractOrderPlace, this.f75227g);
        if (this.f75227g != null) {
            Nh(e11);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "hold_list");
            hashMap.put("margin_type", gs.g.d());
            gs.g.j("market_price_flat", "usdt_contract", "confirm", hashMap);
        }
    }

    public final void Ph(int i11) {
        BigDecimal bigDecimal;
        String str;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.X0(6);
        contractOrderPlace.B0(this.f75241u);
        contractOrderPlace.y0(0);
        contractOrderPlace.r0(m.a(this.f75228h.getLastPrice()).doubleValue());
        contractOrderPlace.h0(w2());
        contractOrderPlace.A0(2);
        contractOrderPlace.N0(this.f75229i);
        contractOrderPlace.v0(this.f75236p);
        contractOrderPlace.E0(this.f75239s);
        ContractOrderPlace s11 = this.f75231k.s(contractOrderPlace);
        this.f75239s = i11;
        if (w2()) {
            bigDecimal = this.f75237q;
        } else {
            bigDecimal = this.f75238r;
        }
        if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            this.f75240t = i11 + "%";
            return;
        }
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (e.E(tradeType)) {
            BigDecimal divide = bigDecimal.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, RoundingMode.DOWN);
            if (divide.compareTo(BigDecimal.ONE) >= 0 || divide.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal4 = divide.setScale(FuturePrecisionUtil.B(), RoundingMode.DOWN);
            } else {
                bigDecimal4 = BigDecimal.ONE;
            }
            str = m.m(FutureUnitUtil.d(bigDecimal4.toPlainString(), s11.w(), this.f75227g.getContractFace(), tradeType), FuturePrecisionUtil.s(this.f75227g.getContractCode(), this.f75227g.getContractShortType(), this.f75227g.getOptionCode()));
        } else if (e.G(tradeType)) {
            BigDecimal divide2 = bigDecimal.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, RoundingMode.DOWN);
            if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal3 = divide2.setScale(FuturePrecisionUtil.B(), RoundingMode.DOWN);
            } else {
                bigDecimal3 = BigDecimal.ONE;
            }
            str = m.m(FutureUnitUtil.d(bigDecimal3.toPlainString(), s11.w(), this.f75227g.getContractFace(), tradeType), FuturePrecisionUtil.g(this.f75229i));
        } else {
            BigDecimal divide3 = bigDecimal.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, RoundingMode.DOWN);
            if (divide3.compareTo(BigDecimal.ONE) >= 0 || divide3.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal2 = divide3.setScale(FuturePrecisionUtil.B(), RoundingMode.DOWN);
            } else {
                bigDecimal2 = BigDecimal.ONE;
            }
            str = bigDecimal2.toPlainString();
        }
        if (TextUtils.isEmpty(str) || m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            this.f75240t = i11 + "%";
            return;
        }
        this.f75240t = i11 + "%(≈ " + str + ")";
    }

    public final void Qh(ContractOrderPlace contractOrderPlace) {
        int v11 = contractOrderPlace.v();
        if (r.x().F0()) {
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (e.E(tradeType)) {
                if (v11 == 0) {
                    this.f75231k.d(contractOrderPlace, this.f75227g);
                    this.f75231k.b(contractOrderPlace, this.f75227g);
                } else {
                    this.f75231k.c(contractOrderPlace, this.f75227g);
                    this.f75231k.a(contractOrderPlace, this.f75227g);
                }
                if (this.f75231k.g() != null) {
                    this.f75231k.g().setScale(FuturePrecisionUtil.s(this.f75227g.getContractCode(), this.f75227g.getContractShortType(), this.f75227g.getOptionCode()), RoundingMode.DOWN).toPlainString();
                }
                if (this.f75231k.k() != null) {
                    this.f75231k.k().setScale(FuturePrecisionUtil.s(this.f75227g.getContractCode(), this.f75227g.getContractShortType(), this.f75227g.getOptionCode()), RoundingMode.DOWN).toPlainString();
                }
            } else if (e.G(tradeType)) {
                if (v11 == 0) {
                    this.f75231k.d(contractOrderPlace, this.f75227g);
                    this.f75231k.b(contractOrderPlace, this.f75227g);
                } else {
                    this.f75231k.c(contractOrderPlace, this.f75227g);
                    this.f75231k.a(contractOrderPlace, this.f75227g);
                }
                if (this.f75231k.g() != null) {
                    this.f75231k.g().setScale(FuturePrecisionUtil.g(this.f75229i)).toPlainString();
                }
                if (this.f75231k.k() != null) {
                    this.f75231k.k().setScale(FuturePrecisionUtil.g(this.f75229i)).toPlainString();
                }
            } else {
                if (v11 == 0) {
                    this.f75231k.d(contractOrderPlace, this.f75227g);
                } else {
                    this.f75231k.c(contractOrderPlace, this.f75227g);
                }
                if (this.f75231k.i() != null) {
                    this.f75231k.i().toPlainString();
                }
                if (this.f75231k.j() != null) {
                    this.f75231k.j().toPlainString();
                }
            }
        }
        if (this.f75231k.i() == null) {
            this.f75237q = BigDecimal.ZERO;
        } else {
            this.f75237q = this.f75231k.i();
        }
        if (this.f75231k.j() == null) {
            this.f75238r = BigDecimal.ZERO;
        } else {
            this.f75238r = this.f75231k.j();
        }
    }

    public void Rh(String str) {
        if (str == null) {
            str = this.f75228h.getMarketClosingSlippage();
        }
        this.f75243w = getString(R.string.n_contract_market_closing_intro_double);
        if (this.f75228h == null || TextUtils.isEmpty(str)) {
            this.f75226f.setText(this.f75243w);
            return;
        }
        String m11 = m.m(str, FuturePrecisionUtil.y(this.f75227g.getContractCode(), this.f75227g.getContractShortType(), this.f75227g.getOptionCode()));
        String string = getResources().getString(R.string.n_contract_market_closing_slippage_new);
        String format = String.format(string, new Object[]{m11 + " " + this.f75227g.getQuoteCurrency()});
        AppCompatTextView appCompatTextView = this.f75226f;
        appCompatTextView.setText(this.f75243w + format);
    }

    public void addEvent(i6.r rVar) {
        this.f75224d.setOnClickListener(new cn.z(this));
        this.f75225e.setOnClickListener(new y(this));
    }

    public void afterInit() {
        Jh(this.f75228h);
        Eh();
        Ph(100);
        Rh((String) null);
        Mh();
    }

    public final void b1() {
        KycAndHasTradeDialogUtils.m(getContext());
    }

    public void dismiss() {
        b bVar = this.f75232l;
        if (bVar != null) {
            bVar.a();
        }
        super.dismiss();
    }

    public int getContentViewResId() {
        return R.layout.dialog_market_closing_confirm;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(i6.r rVar) {
        this.f75222b = (AppCompatTextView) rVar.b(R.id.tv_title);
        this.f75223c = (CheckBox) rVar.b(R.id.noMorePrompt);
        this.f75224d = (AppCompatTextView) rVar.b(R.id.marketClosingCancel);
        this.f75225e = (AppCompatTextView) rVar.b(R.id.marketClosingConfirm);
        this.f75233m = rVar.b(R.id.dialog_loading);
        this.f75234n = (LoadingView) rVar.b(R.id.loading_dialog_loading_view);
        this.f75226f = (AppCompatTextView) rVar.b(R.id.tv_sub_title);
        z zVar = new z((k2) null);
        this.f75231k = zVar;
        if (!(this.f75228h == null || this.f75227g == null)) {
            zVar.u0(this.f75227g.getContractCode() + "_" + this.f75228h.getMarginMode() + this.f75228h.getDirection(), this.f75228h);
        }
        ContractMarketTwTradeLayout contractMarketTwTradeLayout = (ContractMarketTwTradeLayout) rVar.b(R.id.contract_market_twtrade_rl);
        this.f75235o = contractMarketTwTradeLayout;
        contractMarketTwTradeLayout.setCallBack(new a());
    }

    public boolean isTransparent() {
        return false;
    }

    public void q(String str) {
        KycAndHasTradeDialogUtils.l(getContext(), str, a0.f13114a);
    }

    public void t1(String str) {
        KycAndHasTradeDialogUtils.n(getContext(), str, b0.f13118a);
    }

    public final boolean w2() {
        LinearSwapPosition linearSwapPosition = this.f75228h;
        return linearSwapPosition == null || !"buy".equalsIgnoreCase(linearSwapPosition.getDirection());
    }
}
