package com.huobi.contract.ui;

import aj.b;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import bj.p0;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.contract.R$drawable;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.contract.R$style;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.widgets.dialog.dialogfragment.BaseListDialogFragment;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.s1;
import dj.t1;
import ej.d;
import i6.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import m9.z;
import z6.l;

public class ContractTradePopDialogFragment extends BaseListDialogFragment<b> {

    /* renamed from: b  reason: collision with root package name */
    public b.a f43388b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43389c;

    /* renamed from: d  reason: collision with root package name */
    public TradeType f43390d = TradeType.CONTRACT;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43391e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f43392f;

    /* renamed from: g  reason: collision with root package name */
    public int f43393g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<Integer, Boolean> f43394h = new HashMap<>();

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.rootView).setOnClickListener(new s1(this));
        rVar.b(R$id.iv_close).setOnClickListener(new t1(this));
    }

    public void afterInit() {
        super.afterInit();
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.mRecyclerView.setPadding(PixelUtils.a(16.0f), 0, PixelUtils.a(16.0f), PixelUtils.a(16.0f));
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.dialog_contract_bottom_menu;
    }

    public List<b> getDataList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(2, R$drawable.contract_more_set, getString(R$string.n_contract_trade_popwindow_item_unit_setting), this.f43388b));
        TradeType tradeType = this.f43390d;
        TradeType tradeType2 = TradeType.LINEAR_SWAP;
        if (tradeType == tradeType2 && BaseModuleConfig.a().a()) {
            if (this.f43391e) {
                arrayList.add(new b(21, R$drawable.contract_asset_pattern, getString(R$string.n_asset_pattern), ConfigPreferences.c("user_config", "KEY_DEPOSIT_DOT", true), this.f43388b));
            }
            if (p0.g()) {
                arrayList.add(new b(19, R$drawable.contract_more_pattern_both, getString(R$string.n_contract_side_mode_pattern), this.f43388b));
            } else {
                arrayList.add(new b(19, R$drawable.contract_more_pattern_single, getString(R$string.n_contract_side_mode_pattern), this.f43388b));
            }
        }
        arrayList.add(new b(17, R$drawable.contract_more_copytrading, getString(R$string.n_copy_trading_home_title), this.f43388b));
        if (d.a().c(MgtConfigNumber.ZERO_SWAP.number)) {
            arrayList.add(new b(22, R$drawable.contract_more_zero_swap, getString(R$string.n_zero_swap_name), this.f43388b, Boolean.TRUE.equals(this.f43394h.get(22))));
        }
        arrayList.add(new b(3, R$drawable.contract_more_calculator_2, getString(R$string.n_contract_trade_popwindow_item_calculate), this.f43388b));
        if (this.f43390d == tradeType2) {
            arrayList.add(new b(15, R$drawable.contract_more_order_tutorial, getString(R$string.n_linear_swap_guide), this.f43388b));
        }
        arrayList.add(new b(4, R$drawable.contract_more_rate, getString(R$string.n_contract_trade_popwindow_item_price_rate), this.f43388b));
        if (BaseModuleConfig.a().a() && this.f43390d == tradeType2) {
            arrayList.add(new b(20, R$drawable.contract_more_up_position_limit, getString(R$string.n_contract_position_limit_improve), this.f43388b));
        }
        arrayList.add(new b(9, R$drawable.contract_more_information, getString(R$string.n_contract_market_info), this.f43388b));
        if (BaseModuleConfig.a().a()) {
            TradeType tradeType3 = this.f43390d;
            if (tradeType3 == TradeType.CONTRACT) {
                ContractUserInfo.UserBean o11 = ContractUserInfoProvider.i().o();
                if (o11 != null && o11.getActiveState() == 1) {
                    arrayList.add(new b(10, R$drawable.contract_more_limit, getString(R$string.contract_trade_popwindow_item_trade_limit), this.f43388b));
                }
            } else if (tradeType3 == TradeType.SWAP) {
                if (z.f().k()) {
                    arrayList.add(new b(10, R$drawable.contract_more_limit, getString(R$string.contract_trade_popwindow_item_trade_limit), this.f43388b));
                }
            } else if (tradeType3 == tradeType2) {
                if (l.c().i(tradeType2)) {
                    arrayList.add(new b(10, R$drawable.contract_more_limit, getString(R$string.contract_trade_popwindow_item_trade_limit), this.f43388b));
                }
            } else if (tradeType3 == TradeType.OPTION && l.c().h()) {
                arrayList.add(new b(10, R$drawable.contract_more_limit, getString(R$string.contract_trade_popwindow_item_trade_limit), this.f43388b));
            }
        }
        if (BaseModuleConfig.a().a() && !BaseModuleConfig.a().c()) {
            arrayList.add(new b(12, R$drawable.contract_more_subaccount, getString(R$string.n_contract_sub_account_manage), this.f43388b));
        }
        arrayList.add(new b(14, R$drawable.contract_more_help_center, getString(R$string.n_contract_help_center), this.f43388b));
        arrayList.add(new b(6, R$drawable.contract_more_about, getString(R$string.n_contract_trade_about_contract), this.f43388b));
        TradeType tradeType4 = this.f43390d;
        if (tradeType4 == TradeType.CONTRACT || tradeType4 == TradeType.SWAP || tradeType4 == tradeType2) {
            if (this.f43389c) {
                arrayList.add(new b(11, R$drawable.contract_more_star_selected, getString(R$string.n_contract_removecollection), this.f43388b));
            } else {
                arrayList.add(new b(11, R$drawable.contract_more_star, getString(R$string.n_contract_addcollection), this.f43388b));
            }
        }
        if (this.f43390d == tradeType2) {
            arrayList.add(new b(16, R$drawable.contract_more_new_guide, getString(R$string.n_contract_trade_new_guide_menu), this.f43388b));
        }
        if (BaseModuleConfig.a().a()) {
            arrayList.add(new b(18, R$drawable.contract_more_calm_period, getString(R$string.n_contract_calm_period_name), this.f43388b));
        }
        return arrayList;
    }

    public int getGravity() {
        return 80;
    }

    public boolean isFullScreen() {
        return true;
    }

    public void setTradeType(TradeType tradeType) {
        this.f43390d = tradeType;
    }

    public void uh(b.a aVar) {
        this.f43388b = aVar;
    }

    public void vh(String str) {
        this.f43392f = str;
    }

    public void wh(int i11) {
        this.f43393g = i11;
    }

    public void xh(int i11, boolean z11) {
        this.f43394h.put(Integer.valueOf(i11), Boolean.valueOf(z11));
    }

    public void yh(boolean z11) {
        this.f43391e = z11;
    }

    public void zh(FragmentManager fragmentManager, String str, boolean z11) {
        this.f43389c = z11;
        super.show(fragmentManager, str);
        ContractModuleConfig.a().c("App_more_menu_pop_expose", (HashMap) null);
    }
}
