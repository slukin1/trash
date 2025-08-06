package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.contract.entity.LinearSwapBalanceItem;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.utils.AssetNumberUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import i8.s;
import java.util.Locale;
import s9.c;

public class LinearSwapItemViewAdapter implements c, View.OnClickListener {
    public final String b(String str) {
        return String.format("%s%%", new Object[]{m.q(m.a(str).multiply(m.f68179a), 2)});
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, LinearSwapBalanceItem linearSwapBalanceItem, ViewGroup viewGroup) {
        View view = cVar.itemView;
        Resources resources = view.getResources();
        String i12 = StringUtils.i("usdt");
        LinearSwapAccountInfo mLinearSwapAccountInfo = linearSwapBalanceItem.getMLinearSwapAccountInfo();
        String symbol = mLinearSwapAccountInfo.getSymbol() == null ? "" : mLinearSwapAccountInfo.getSymbol();
        r e11 = cVar.e();
        if (mLinearSwapAccountInfo.getTradePartition() != null) {
            i12 = mLinearSwapAccountInfo.getTradePartition().toUpperCase();
        } else if (mLinearSwapAccountInfo.isCross() && mLinearSwapAccountInfo.getSymbol() != null) {
            i12 = mLinearSwapAccountInfo.getSymbol().toUpperCase();
        }
        TextView e12 = e11.e(R$id.item_balance_currency_name);
        int i13 = R$id.item_balance_estimate_title;
        TextView e13 = e11.e(i13);
        TextView e14 = e11.e(R$id.item_balance_contract_equity);
        TextView e15 = e11.e(R$id.item_balance_contract_equity_title);
        TextView e16 = e11.e(R$id.item_balance_estimate);
        TextView e17 = e11.e(i13);
        Resources resources2 = e17.getContext().getResources();
        View view2 = view;
        int i14 = R$string.n_balance_contract_prediction_of_strong_parity2;
        String string = resources2.getString(i14);
        TextView textView = (TextView) e11.b(R$id.item_balance_burrow_rate);
        e17.setText(String.format(string, new Object[]{"(USDT)"}));
        ImageView imageView = (ImageView) e11.b(R$id.item_balance_limit_undone);
        TextView textView2 = (TextView) e11.b(R$id.item_contract_balance_estimate);
        e11.c(R$id.item_margin_balance_symbol_icon).setVisibility(8);
        if (!mLinearSwapAccountInfo.isCross()) {
            e12.setText(StringUtils.i(linearSwapBalanceItem.getTitle()));
        } else if (mLinearSwapAccountInfo.getSymbol().equalsIgnoreCase("USDT")) {
            e12.setText(resources.getString(R$string.n_linear_swap_cross_account));
        } else {
            e12.setText(resources.getString(R$string.n_linear_swap_cross_husd_account));
        }
        e15.setText(resources.getString(R$string.n_asset_position_equity) + "(" + i12 + ")");
        String string2 = resources.getString(i14);
        e13.setText(String.format(string2, new Object[]{"(" + i12 + ")"}));
        imageView.setVisibility(8);
        if (p.u()) {
            int g11 = FuturePrecisionUtil.g(symbol);
            String marginBalance = mLinearSwapAccountInfo.getMarginBalance();
            if (TextUtils.isEmpty(marginBalance)) {
                e14.setText("--");
            } else {
                e14.setText(AssetNumberUtil.a(marginBalance, g11));
            }
            String liquidationPrice = mLinearSwapAccountInfo.getLiquidationPrice();
            if (!TextUtils.isEmpty(liquidationPrice)) {
                try {
                    e16.setText(AssetNumberUtil.a(liquidationPrice, FuturePrecisionUtil.h(symbol)));
                } catch (Exception e18) {
                    e18.printStackTrace();
                    e16.setText("--");
                }
            } else {
                e16.setText("--");
            }
            String riskRate = mLinearSwapAccountInfo.getRiskRate();
            if (!TextUtils.isEmpty(riskRate)) {
                textView.setText(b(riskRate));
            } else {
                textView.setText("--");
            }
            if (!TextUtils.isEmpty(linearSwapBalanceItem.getEstimateAmount())) {
                textView2.setText(textView2.getContext().getString(R$string.n_balance_contract_short_estimate2, new Object[]{linearSwapBalanceItem.getEstimateAmount(), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
            } else {
                textView2.setText("--");
            }
        } else {
            String string3 = cVar.itemView.getResources().getString(R$string.balance_hide_star);
            e14.setText(string3);
            e16.setText(string3);
            textView.setText(string3);
            textView2.setText(string3);
        }
        View view3 = view2;
        view3.setTag(R$id.item_data, mLinearSwapAccountInfo);
        view3.setOnClickListener(this);
    }

    public final void d(Context context, LinearSwapAccountInfo linearSwapAccountInfo) {
        if (p.d(context)) {
            AssetModuleConfig.a().G(context, linearSwapAccountInfo);
        }
    }

    public int getResId() {
        return R$layout.item_contract_detail;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Context context = view.getContext();
        LinearSwapAccountInfo linearSwapAccountInfo = (LinearSwapAccountInfo) view.getTag(R$id.item_data);
        LinearSwapUserInfo f11 = s.d().f();
        if (f11 == null) {
            HuobiToastUtil.j(R$string.contract_account_loading);
        } else if (1 != f11.getActiveState()) {
            AssetModuleConfig.a().Y(context, TradeType.LINEAR_SWAP);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        } else {
            d(context, linearSwapAccountInfo);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
