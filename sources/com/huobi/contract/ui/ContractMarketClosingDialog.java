package com.huobi.contract.ui;

import a7.e;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import bh.j;
import bj.d1;
import bj.p0;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.ContractPosition;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.n0;
import dj.w;
import dj.x;
import dj.y;
import ej.f;
import i6.i;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import u6.g;

public class ContractMarketClosingDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public AppCompatTextView f43281b;

    /* renamed from: c  reason: collision with root package name */
    public CheckBox f43282c;

    /* renamed from: d  reason: collision with root package name */
    public AppCompatTextView f43283d;

    /* renamed from: e  reason: collision with root package name */
    public AppCompatTextView f43284e;

    /* renamed from: f  reason: collision with root package name */
    public AppCompatTextView f43285f;

    /* renamed from: g  reason: collision with root package name */
    public View f43286g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingView f43287h;

    /* renamed from: i  reason: collision with root package name */
    public ContractCurrencyInfo f43288i;

    /* renamed from: j  reason: collision with root package name */
    public ContractPosition f43289j;

    /* renamed from: k  reason: collision with root package name */
    public String f43290k;

    /* renamed from: l  reason: collision with root package name */
    public d1 f43291l;

    /* renamed from: m  reason: collision with root package name */
    public b f43292m;

    /* renamed from: n  reason: collision with root package name */
    public BigDecimal f43293n;

    /* renamed from: o  reason: collision with root package name */
    public int f43294o;

    /* renamed from: p  reason: collision with root package name */
    public String f43295p;

    /* renamed from: q  reason: collision with root package name */
    public String f43296q;

    public interface b {
        void a();
    }

    public class c extends EasySubscriber<Object> {
        public c() {
        }

        public void onAfter() {
            super.onAfter();
            ContractMarketClosingDialog.this.f43286g.setVisibility(8);
            ContractMarketClosingDialog.this.f43287h.d();
        }

        public void onError2(Throwable th2) {
            if (!NetworkStatus.c(BaseApplication.b())) {
                HuobiToastUtil.j(R.string.n_no_network);
            } else {
                HuobiToastUtil.k(BaseApplication.b(), R.string.string_order_op_fail);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.k(j.c(), R.string.string_order_op_fail);
            } else {
                HuobiToastUtil.l(j.c(), aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            if (ContractMarketClosingDialog.this.f43282c.isChecked()) {
                p0.i(0);
            } else {
                p0.i(1);
            }
            HuobiToastUtil.t(j.c(), R.string.n_contract_market_closing_submit);
            s6.a.b(j.c()).c(R.raw.order_success);
            EventBus.d().k(new ContractAssetAndOrderUpdateEvent());
            i.b().g(new y(ContractMarketClosingDialog.this), 10);
        }

        public void onStart() {
            super.onStart();
            ContractMarketClosingDialog.this.f43286g.setVisibility(0);
            ContractMarketClosingDialog.this.f43287h.c();
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
        Eh(this.f43296q, this.f43295p, 2, 6);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final BigDecimal Ah() {
        return m.a(this.f43296q);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0026, code lost:
        if (com.hbg.lib.core.util.w.l() != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
        if (com.hbg.lib.core.util.w.l() != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Bh(com.huobi.contract.entity.ContractPosition r8) {
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
            java.lang.String r3 = "usd"
            java.lang.String r3 = r3.toUpperCase()
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
            androidx.appcompat.widget.AppCompatTextView r8 = r7.f43281b
            r8.setText(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.ui.ContractMarketClosingDialog.Bh(com.huobi.contract.entity.ContractPosition):void");
    }

    public void Ch(ContractPosition contractPosition) {
        this.f43289j = contractPosition;
        if (contractPosition != null) {
            this.f43288i = contractPosition.getContractCurrencyInfo();
            this.f43290k = contractPosition.getSymbol();
        }
        this.f43296q = m.m(yh(), f.p(this.f43289j.getContractCode()));
    }

    public final void Dh(ContractOrderPlace contractOrderPlace) {
        if (contractOrderPlace.Y()) {
            zh(contractOrderPlace).subscribe(new c());
        }
    }

    public void Eh(String str, String str2, int i11, int i12) {
        if (i12 != 1) {
            str = yh();
        }
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.N0(this.f43290k);
        contractOrderPlace.B0(str);
        contractOrderPlace.d0(str2);
        contractOrderPlace.h0(w2());
        contractOrderPlace.A0(i11);
        contractOrderPlace.X0(i12);
        contractOrderPlace.g0(4);
        contractOrderPlace.E0(this.f43294o);
        if (w2()) {
            contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
        } else {
            contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
        }
        ContractPosition contractPosition = this.f43289j;
        if (contractPosition != null) {
            contractOrderPlace.s0(contractPosition.getLeverRate());
        }
        contractOrderPlace.x0(getString(R.string.contract_trade_position_close_quick));
        Dh(this.f43291l.P(getActivity(), contractOrderPlace, this.f43288i));
    }

    public final void Fh(int i11) {
        String str;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        this.f43294o = i11;
        BigDecimal Ah = Ah();
        BigDecimal bigDecimal3 = this.f43293n;
        if (bigDecimal3 == null || bigDecimal3.compareTo(BigDecimal.ZERO) == 0) {
            this.f43295p = i11 + "%";
            return;
        }
        TradeType tradeType = TradeType.CONTRACT;
        if (e.E(tradeType)) {
            BigDecimal divide = this.f43293n.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, RoundingMode.DOWN);
            if (divide.compareTo(BigDecimal.ONE) >= 0 || divide.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal2 = divide.setScale(f.t(this.f43290k), RoundingMode.DOWN);
            } else {
                bigDecimal2 = BigDecimal.ONE;
            }
            str = m.a(FutureUnitUtil.d(bigDecimal2.toPlainString(), Ah.toPlainString(), this.f43288i.getContractFace(), tradeType)).setScale(f.n(this.f43288i.getContractCode()), RoundingMode.DOWN).toPlainString();
        } else {
            BigDecimal divide2 = this.f43293n.multiply(m.a(String.valueOf(i11))).divide(m.f68179a, 32, RoundingMode.DOWN);
            if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                bigDecimal = divide2.setScale(f.t(this.f43290k), RoundingMode.DOWN);
            } else {
                bigDecimal = BigDecimal.ONE;
            }
            str = bigDecimal.toPlainString();
        }
        if (TextUtils.isEmpty(str) || m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            this.f43295p = i11 + "%";
            return;
        }
        this.f43295p = i11 + "%(≈ " + str + ")";
    }

    public final void Gh() {
        BigDecimal bigDecimal;
        ContractPosition contractPosition = this.f43289j;
        if (contractPosition == null) {
            bigDecimal = BigDecimal.ZERO;
        } else {
            bigDecimal = m.a(contractPosition.getAvailable());
        }
        this.f43293n = bigDecimal;
    }

    public void addEvent(r rVar) {
        this.f43283d.setOnClickListener(new w(this));
        this.f43284e.setOnClickListener(new x(this));
    }

    public void afterInit() {
        Bh(this.f43289j);
        xh();
        Fh(100);
        ContractPosition contractPosition = this.f43289j;
        if (contractPosition != null && !TextUtils.isEmpty(contractPosition.getMarketClosingSlippage())) {
            String m11 = m.m(this.f43289j.getMarketClosingSlippage(), f.p(this.f43289j.getContractCode()));
            String string = getResources().getString(R.string.n_contract_market_closing_slippage_new);
            String format = String.format(string, new Object[]{m11 + " USD"});
            AppCompatTextView appCompatTextView = this.f43285f;
            appCompatTextView.setText(getString(R.string.n_contract_market_closing_intro_double) + format);
        }
    }

    public void dismiss() {
        b bVar = this.f43292m;
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

    public void initView(r rVar) {
        this.f43281b = (AppCompatTextView) rVar.b(R.id.tv_title);
        this.f43282c = (CheckBox) rVar.b(R.id.noMorePrompt);
        this.f43283d = (AppCompatTextView) rVar.b(R.id.marketClosingCancel);
        this.f43284e = (AppCompatTextView) rVar.b(R.id.marketClosingConfirm);
        this.f43286g = rVar.b(R.id.dialog_loading);
        this.f43287h = (LoadingView) rVar.b(R.id.loading_dialog_loading_view);
        this.f43285f = (AppCompatTextView) rVar.b(R.id.tv_sub_title);
        d1 d1Var = new d1((n0) null);
        this.f43291l = d1Var;
        if (this.f43289j != null && this.f43288i != null) {
            d1Var.T(this.f43288i.getContractCode() + this.f43289j.getDirection(), this.f43289j);
        }
    }

    public boolean isTransparent() {
        return false;
    }

    public final boolean w2() {
        ContractPosition contractPosition = this.f43289j;
        return contractPosition == null || !"buy".equalsIgnoreCase(contractPosition.getDirection());
    }

    public void xh() {
        Gh();
    }

    public final String yh() {
        String str;
        ContractPosition contractPosition = this.f43289j;
        if (contractPosition == null) {
            str = null;
        } else {
            str = contractPosition.getLastPrice();
        }
        if (str == null) {
            str = bj.n0.b().c(this.f43290k);
        }
        return m.a(str).toPlainString();
    }

    public final Observable<Object> zh(ContractOrderPlace contractOrderPlace) {
        return this.f43291l.M(contractOrderPlace, this.f43288i).compose(RxJavaHelper.t((g) null));
    }
}
