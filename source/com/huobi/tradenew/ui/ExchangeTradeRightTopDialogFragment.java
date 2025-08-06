package com.huobi.tradenew.ui;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.dialog.dialogfragment.BaseTopRightListDialogFragment;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import ws.g;

public class ExchangeTradeRightTopDialogFragment extends BaseTopRightListDialogFragment<g> {

    /* renamed from: b  reason: collision with root package name */
    public g.a f83062b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f83063c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f83064d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f83065e;

    /* renamed from: f  reason: collision with root package name */
    public TradeType f83066f;

    /* renamed from: g  reason: collision with root package name */
    public int f83067g;

    /* renamed from: h  reason: collision with root package name */
    public int f83068h;

    public void afterInit() {
        super.afterInit();
        getRootLayout().setPadding(0, this.f83067g, this.f83068h, 0);
    }

    public List<g> getDataList() {
        ArrayList arrayList = new ArrayList();
        if (TradeType.PRO == this.f83066f) {
            th(arrayList);
        } else {
            sh(arrayList);
        }
        return arrayList;
    }

    public final void sh(List<g> list) {
        list.add(new g(4, R.drawable.margin_tab_loan_btn2, getString(R.string.loan_coin), this.f83062b));
        list.add(new g(3, R.drawable.trad_switch_transfer, getString(R.string.currency_detail_transfer), this.f83062b));
        TradeType tradeType = this.f83066f;
        if (tradeType == TradeType.SUPERMARGIN || tradeType == TradeType.MARGIN) {
            if (ks.g.j()) {
                list.add(new g(7, R.drawable.margin_manual, getString(R.string.n_trade_manual_loan_repay), this.f83062b));
            } else {
                list.add(new g(7, R.drawable.margin_auto, getString(R.string.n_trade_automatic_loan_repay), this.f83062b));
            }
        }
        if (this.f83063c) {
            list.add(new g(1, R.drawable.trading_switch, getString(R.string.trade_right_top_dialog_horizontal_direction), this.f83062b));
        } else {
            list.add(new g(1, R.drawable.trading_switch, getString(R.string.trade_right_top_dialog_vertical_direction), this.f83062b));
        }
        list.add(new g(5, R.drawable.trade_right_dialog_more_about, getString(R.string.trade_margin_right_dialog_about), this.f83062b));
        if (this.f83065e) {
            list.add(new g(2, R.drawable.star_common_light2, getString(R.string.market_markets_removecollection), this.f83062b));
        } else {
            list.add(new g(2, R.drawable.star_common2, getString(R.string.market_markets_addcollection), this.f83062b));
        }
    }

    public final void th(List<g> list) {
        list.add(new g(0, R.drawable.account_tab_deposit_btn2, getString(R.string.balance_detail_deposit), this.f83062b));
        list.add(new g(3, R.drawable.trad_switch_transfer, getString(R.string.currency_detail_transfer), this.f83062b));
        list.add(new g(8, R.drawable.trade_rule, getString(R.string.n_trade_rules_tips), this.f83062b));
        if (this.f83064d) {
            list.add(new g(6, R.drawable.trade_menu_icon_etp, getString(R.string.n_trade_etp_introduce), this.f83062b));
        }
        if (this.f83065e) {
            list.add(new g(2, R.drawable.star_common_light2, getString(R.string.market_markets_removecollection), this.f83062b));
        } else {
            list.add(new g(2, R.drawable.star_common2, getString(R.string.market_markets_addcollection), this.f83062b));
        }
    }
}
