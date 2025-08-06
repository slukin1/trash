package com.huobi.tradenew.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.margin.entity.OrderConfirmResponse;
import com.huobi.trade.bean.OrderConfirmBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import gs.g;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;
import qt.f;

public class TradeOrderConfirmFragment extends BaseDialogFragment implements View.OnClickListener, BaseDialogFragment.c {

    /* renamed from: b  reason: collision with root package name */
    public a f83196b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f83197c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f83198d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f83199e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f83200f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f83201g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f83202h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f83203i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f83204j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f83205k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f83206l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f83207m;

    /* renamed from: n  reason: collision with root package name */
    public CheckBox f83208n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f83209o;

    /* renamed from: p  reason: collision with root package name */
    public OrderConfirmBean f83210p;

    /* renamed from: q  reason: collision with root package name */
    public View f83211q;

    /* renamed from: r  reason: collision with root package name */
    public String f83212r = "--";

    /* renamed from: s  reason: collision with root package name */
    public View f83213s;

    /* renamed from: t  reason: collision with root package name */
    public View f83214t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f83215u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f83216v;

    /* renamed from: w  reason: collision with root package name */
    public b f83217w;

    public interface a {
        void cancel();

        void confirm();
    }

    public interface b {
        void onDismiss();
    }

    public static TradeOrderConfirmFragment uh() {
        return new TradeOrderConfirmFragment();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void vh(CompoundButton compoundButton, boolean z11) {
        this.f83209o = z11;
        if (this.f83210p.isLoan()) {
            ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_SPOT_LOAN_CONFIRM_DIALOG", z11);
        } else {
            ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_SPOT_CONFIRM_DIALOG", z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wh(OrderConfirmResponse orderConfirmResponse) {
        if (orderConfirmResponse != null) {
            this.f83212r = String.format("%s%%", new Object[]{String.format("%.1f", new Object[]{Double.valueOf(orderConfirmResponse.b() * 100.0d)})});
            this.f83205k.setText(String.format(getString(R.string.n_spot_order_interestRate_subtitle), new Object[]{this.f83212r}));
            try {
                int parseInt = Integer.parseInt(orderConfirmResponse.c());
                if (parseInt == 0) {
                    this.f83206l.setText(getString(R.string.n_spot_order_not_risk));
                    this.f83206l.setTextColor(ContextCompat.getColor(getContext(), R.color.trade_risk_level_low));
                } else if (parseInt == 1) {
                    this.f83206l.setText(getString(R.string.n_spot_order_little_risk));
                    this.f83206l.setTextColor(ContextCompat.getColor(getContext(), R.color.trade_risk_level_low));
                } else if (parseInt == 2) {
                    this.f83206l.setText(getString(R.string.n_spot_order_middle_risk));
                    this.f83206l.setTextColor(ContextCompat.getColor(getContext(), R.color.trade_risk_level_middle));
                } else if (parseInt == 3) {
                    this.f83206l.setText(getString(R.string.n_spot_order_high_risk));
                    this.f83206l.setTextColor(ContextCompat.getColor(getContext(), R.color.trade_risk_level_high));
                } else if (parseInt == 4) {
                    this.f83206l.setText(getString(R.string.n_spot_order_very_high_risk));
                    this.f83206l.setTextColor(ContextCompat.getColor(getContext(), R.color.trade_risk_level_high));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void Ah() {
        if (this.f83210p.isBuy()) {
            this.f83197c.setText(getString(R.string.n_exchange_buy_in));
            this.f83197c.setTextColor(ContextCompat.getColor(getContext(), w.h()));
            this.f83204j.setText(String.format("%s%s", new Object[]{this.f83210p.getDiaplayLoan(), a1.v().D(this.f83210p.getSymbol()).toUpperCase()}));
        } else {
            this.f83197c.setText(getString(R.string.n_exchange_sell_out));
            this.f83197c.setTextColor(ContextCompat.getColor(getContext(), w.d()));
            this.f83204j.setText(String.format("%s%s", new Object[]{this.f83210p.getDiaplayLoan(), a1.v().n(this.f83210p.getSymbol()).toUpperCase()}));
        }
        if (this.f83210p.getCallActionPhase() == 1) {
            this.f83199e.setVisibility(0);
            this.f83198d.setText(String.format(getString(R.string.n_exchange_call_auction_order_confirm_first_hint), new Object[]{this.f83210p.getDisplaySymbol()}));
        } else if (this.f83210p.getCallActionPhase() == 2) {
            this.f83199e.setVisibility(0);
            this.f83198d.setText(String.format(getString(R.string.n_exchange_call_auction_order_confirm_second_hint), new Object[]{this.f83210p.getDisplaySymbol()}));
        }
        this.f83200f.setText(this.f83210p.getDisplaySymbol());
        this.f83207m.setText(this.f83210p.getDisplayOrderType());
        this.f83201g.setText(String.format("%s%s", new Object[]{this.f83210p.getDisplayPrice(), a1.v().D(this.f83210p.getSymbol()).toUpperCase()}));
        this.f83203i.setText(String.format("%s%s", new Object[]{this.f83210p.getDisplayVolume(), a1.v().D(this.f83210p.getSymbol()).toUpperCase()}));
        ViewUtil.m(this.f83211q, this.f83210p.isLoan());
        this.f83206l.setText("--");
        this.f83205k.setVisibility(0);
        this.f83205k.setText(String.format(getString(R.string.n_spot_order_interestRate_subtitle), new Object[]{this.f83212r}));
        if (this.f83210p.getTradeViewType() == 1 || (this.f83210p.getTradeViewType() == 3 && this.f83210p.getOrderType().equals(PrimeRounds.ROUND_TRADE_MARKET_TYPE))) {
            this.f83213s.setVisibility(8);
            if (this.f83210p.isBuy()) {
                this.f83201g.setText(String.format("%s", new Object[]{getString(R.string.n_trade_market_buy_hint)}));
            } else {
                this.f83201g.setText(String.format("%s", new Object[]{getString(R.string.n_trade_market_sell_hint)}));
            }
        } else {
            this.f83213s.setVisibility(0);
            this.f83202h.setText(String.format("%s%s", new Object[]{this.f83210p.getDisplayAmount(), a1.v().n(this.f83210p.getSymbol()).toUpperCase()}));
        }
        if (this.f83210p.getTradeViewType() == 3 || this.f83210p.getTradeViewType() == 2) {
            ViewUtil.m(this.f83214t, true);
            this.f83215u.setText(String.format("%s%s", new Object[]{this.f83210p.getDiaplayTriggerValue(), a1.v().D(this.f83210p.getSymbol()).toUpperCase()}));
        } else {
            ViewUtil.m(this.f83214t, false);
        }
        OrderConfirmBean orderConfirmBean = this.f83210p;
        if (orderConfirmBean != null && !orderConfirmBean.isBuy()) {
            int tradeViewType = this.f83210p.getTradeViewType();
            if (tradeViewType == 1) {
                this.f83216v.setText(getString(R.string.n_trade_sell_amount));
                this.f83203i.setText(String.format("%s%s", new Object[]{this.f83210p.getDisplayAmount(), a1.v().n(this.f83210p.getSymbol()).toUpperCase()}));
            } else if (tradeViewType != 3) {
                this.f83216v.setText(getString(R.string.n_spot_order_total));
            } else if (PrimeRounds.ROUND_TRADE_MARKET_TYPE.equals(this.f83210p.getOrderType())) {
                this.f83216v.setText(getString(R.string.n_trade_sell_amount));
                this.f83203i.setText(String.format("%s%s", new Object[]{this.f83210p.getDisplayAmount(), a1.v().n(this.f83210p.getSymbol()).toUpperCase()}));
            } else {
                this.f83216v.setText(getString(R.string.n_spot_order_total));
            }
        }
        xh();
    }

    public void addEvent(r rVar) {
        this.f83208n.setOnCheckedChangeListener(new z1(this));
    }

    public void afterInit() {
        setCanDismissOnBackPress(true);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void doDismiss() {
        super.doDismiss();
        b bVar = this.f83217w;
        if (bVar != null) {
            bVar.onDismiss();
        }
    }

    public int getContentViewResId() {
        return R.layout.layout_trade_order_confirm;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        rVar.b(R.id.v_root).setOnClickListener(this);
        rVar.b(R.id.tv_close).setOnClickListener(this);
        rVar.b(R.id.btn_trade_confirm).setOnClickListener(this);
        rVar.b(R.id.btn_trade_cancel).setOnClickListener(this);
        this.f83199e = (FrameLayout) rVar.b(R.id.fl_call_auction_tips);
        this.f83198d = (TextView) rVar.b(R.id.tv_call_action);
        this.f83211q = rVar.b(R.id.ll_loan);
        this.f83197c = (TextView) rVar.b(R.id.tv_title_prefix);
        this.f83208n = (CheckBox) rVar.b(R.id.cb_selector);
        this.f83200f = (TextView) rVar.b(R.id.tv_symbol);
        this.f83207m = (TextView) rVar.b(R.id.tv_order_type);
        this.f83201g = (TextView) rVar.b(R.id.tv_price_value);
        this.f83202h = (TextView) rVar.b(R.id.tv_amount_value);
        this.f83203i = (TextView) rVar.b(R.id.tv_total_value);
        this.f83204j = (TextView) rVar.b(R.id.tv_loan_value);
        this.f83205k = (TextView) rVar.b(R.id.tv_rate_value);
        this.f83206l = (TextView) rVar.b(R.id.tv_risk_value);
        this.f83213s = rVar.b(R.id.rl_amount_layout);
        this.f83214t = rVar.b(R.id.rl_trigger_condition_layout);
        this.f83215u = (TextView) rVar.b(R.id.tv_trigger_condition_value);
        this.f83216v = (TextView) rVar.b(R.id.tv_total_value_tag);
        if (this.f83210p != null) {
            Ah();
            if (this.f83210p.isLoan()) {
                yh();
            }
        }
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.v_root || view.getId() == R.id.tv_close) {
            doDismiss();
            b bVar = this.f83217w;
            if (bVar != null) {
                bVar.onDismiss();
            }
        } else if (view.getId() == R.id.btn_trade_confirm) {
            doDismiss();
            a aVar = this.f83196b;
            if (aVar != null) {
                aVar.confirm();
            }
            if (this.f83209o) {
                ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_CONFIRM_DIALOG", true);
            }
        } else if (view.getId() == R.id.btn_trade_cancel) {
            doDismiss();
            a aVar2 = this.f83196b;
            if (aVar2 != null) {
                aVar2.cancel();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f83210p = (OrderConfirmBean) getArguments().getSerializable("DATA");
    }

    public void onDialogFragmentBackPressed() {
    }

    public void onDialogFragmentPause() {
    }

    public void onDialogFragmentResume() {
    }

    public final void xh() {
        int tradeViewType = this.f83210p.getTradeViewType();
        String str = tradeViewType != 0 ? tradeViewType != 1 ? tradeViewType != 2 ? "triggerorder" : "stoplimit" : PrimeRounds.ROUND_TRADE_MARKET_TYPE : "limit";
        HashMap hashMap = new HashMap();
        hashMap.put("OrderType_id", str);
        hashMap.put("TradeType_id", this.f83210p.isLoan() ? RankScreenBean.SCREEN_VALUE_SPOT : "margin");
        g.i("App_trade_Handicap_click", hashMap);
    }

    public final void yh() {
        f.a().b(this.f83210p.getAccountId(), this.f83210p.getSymbol(), this.f83210p.getOrderType(), this.f83210p.isBuy() ? "buy" : "sell", this.f83210p.getAmount(), this.f83210p.getMarginAmount(), this.f83210p.getPrice(), new a2(this));
    }

    public void zh(a aVar) {
        this.f83196b = aVar;
    }
}
