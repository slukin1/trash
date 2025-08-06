package com.huobi.trade.ui;

import android.text.TextUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.MarginCourseMgtBean;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.widgets.dialog.dialogfragment.BaseTopRightListDialogFragment;
import com.huobi.store.AppConfigManager;
import com.huobi.utils.HBHTtoHTXManager;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import ws.g;

public class ExchangeTradeRightTopDialogFragment extends BaseTopRightListDialogFragment<g> {

    /* renamed from: b  reason: collision with root package name */
    public g.a f82260b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f82261c;

    /* renamed from: d  reason: collision with root package name */
    public TradeType f82262d;

    /* renamed from: e  reason: collision with root package name */
    public String f82263e;

    /* renamed from: f  reason: collision with root package name */
    public int f82264f;

    /* renamed from: g  reason: collision with root package name */
    public int f82265g;

    public void afterInit() {
        super.afterInit();
        getRootLayout().setPadding(0, this.f82264f, this.f82265g, 0);
        this.mRecyclerView.setPadding(0, PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f));
    }

    public List<g> getDataList() {
        ArrayList arrayList = new ArrayList();
        if ("htx".equalsIgnoreCase(this.f82263e)) {
            HBHTtoHTXManager hBHTtoHTXManager = HBHTtoHTXManager.f83692a;
            if (hBHTtoHTXManager.d() != null && !TextUtils.isEmpty(hBHTtoHTXManager.d().getUpgradeDetailUrl())) {
                arrayList.add(new g(12, R.drawable.trade_setting_htx, getString(R.string.pop_menu_balance_updetail), this.f82260b));
            }
        }
        if (TradeType.PRO == this.f82262d) {
            th(arrayList);
        } else {
            sh(arrayList);
        }
        return arrayList;
    }

    public final void sh(List<g> list) {
        list.add(new g(4, R.drawable.margin_tab_loan_btn2, getString(R.string.loan_coin), this.f82260b));
        list.add(new g(3, R.drawable.trad_switch_transfer, getString(R.string.currency_detail_transfer), this.f82260b));
        list.add(new g(9, R.drawable.spot_trade_setting_icon, getString(R.string.n_otc_trade_set_title), this.f82260b));
        list.add(new g(10, R.drawable.trade_guide, getString(R.string.n_new_user_guide_title), this.f82260b));
        MarginCourseMgtBean marginCourseMgtBean = (MarginCourseMgtBean) AppConfigManager.c(MgtConfigNumber.MARGIN_COURSE_STATUS.number, MarginCourseMgtBean.class);
        if (marginCourseMgtBean != null && marginCourseMgtBean.getIsShow() == 1) {
            list.add(new g(11, R.drawable.trade_margin_course, getString(R.string.n_margin_video_guide), this.f82260b));
        }
        list.add(new g(5, R.drawable.trade_right_dialog_more_about, getString(R.string.trade_margin_right_dialog_about), this.f82260b));
        if (this.f82261c) {
            list.add(new g(2, R.drawable.star_common_light2, getString(R.string.market_markets_removecollection), this.f82260b));
        } else {
            list.add(new g(2, R.drawable.star_common2, getString(R.string.market_markets_addcollection), this.f82260b));
        }
    }

    public final void th(List<g> list) {
        list.add(new g(0, R.drawable.account_tab_deposit_btn2, getString(R.string.balance_detail_deposit), this.f82260b));
        list.add(new g(3, R.drawable.trad_switch_transfer, getString(R.string.currency_detail_transfer), this.f82260b));
        list.add(new g(9, R.drawable.spot_trade_setting_icon, getString(R.string.n_otc_trade_set_title), this.f82260b));
        list.add(new g(8, R.drawable.trade_rule, getString(R.string.n_trade_rules_tips), this.f82260b));
        if (this.f82261c) {
            list.add(new g(2, R.drawable.star_common_light2, getString(R.string.market_markets_removecollection), this.f82260b));
        } else {
            list.add(new g(2, R.drawable.star_common2, getString(R.string.market_markets_addcollection), this.f82260b));
        }
    }
}
