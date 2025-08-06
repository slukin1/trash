package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.data.future.bean.FutureUserInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.contract.entity.OptionBalanceItem;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.utils.AssetNumberUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.r;
import java.util.Locale;
import s9.c;
import z6.l;

public class OptionItemViewAdapter implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OptionBalanceItem optionBalanceItem, ViewGroup viewGroup) {
        String str;
        View view = cVar.itemView;
        Resources resources = view.getResources();
        OptionAccountInfo mAccountInfo = optionBalanceItem.getMAccountInfo();
        String symbol = mAccountInfo.getSymbol() == null ? "" : mAccountInfo.getSymbol();
        r e11 = cVar.e();
        TextView e12 = e11.e(R$id.item_balance_currency_name);
        TextView e13 = e11.e(R$id.item_balance_contract_equity);
        TextView e14 = e11.e(R$id.item_balance_contract_equity_title);
        TextView e15 = e11.e(R$id.item_balance_estimate);
        TextView e16 = e11.e(R$id.item_balance_estimate_title);
        TextView e17 = e11.e(R$id.item_balance_burrow_rate_title);
        ImageView imageView = (ImageView) e11.b(R$id.item_balance_limit_undone);
        ImageView c11 = e11.c(R$id.item_margin_balance_symbol_icon);
        TextView textView = (TextView) e11.b(R$id.item_contract_balance_estimate);
        TextView e18 = e11.e(R$id.item_balance_currency_name_all);
        TextView textView2 = (TextView) e11.b(R$id.item_balance_burrow_rate);
        CurrencyBean s11 = k.C().s(optionBalanceItem.getCurrency());
        if (s11 != null) {
            e18.setText(s11.getFullName());
        } else {
            e18.setText("");
        }
        f6.c.a().l(view.getContext(), p.k(optionBalanceItem.getCurrency()), c11, p.m());
        e12.setText(symbol.toUpperCase(Locale.US));
        e14.setText(String.format(resources.getString(R$string.n_balance_contract_option_rights2), new Object[]{symbol}));
        e16.setText(String.format(resources.getString(R$string.n_balance_available), new Object[]{symbol}));
        e17.setText(String.format(resources.getString(R$string.n_balance_contract_performance_secured_assets), new Object[]{symbol}));
        imageView.setVisibility(8);
        if (p.u()) {
            int o11 = FuturePrecisionUtil.o(symbol);
            if (TextUtils.isEmpty(mAccountInfo.getMarginBalance())) {
                str = "--";
            } else {
                str = AssetNumberUtil.a(mAccountInfo.getMarginBalance(), o11);
            }
            e13.setText(str);
            String marginAvailable = mAccountInfo.getMarginAvailable();
            if (!TextUtils.isEmpty(marginAvailable)) {
                try {
                    e15.setText(AssetNumberUtil.a(marginAvailable, o11));
                } catch (Exception e19) {
                    e19.printStackTrace();
                    e15.setText("--");
                }
            } else {
                e15.setText("--");
            }
            String marginPosition = mAccountInfo.getMarginPosition();
            if (!TextUtils.isEmpty(marginPosition)) {
                textView2.setText(AssetNumberUtil.a(marginPosition, o11));
            } else {
                textView2.setText("--");
            }
            if (!TextUtils.isEmpty(optionBalanceItem.getEstimateAmount())) {
                textView.setText(textView.getContext().getString(R$string.n_balance_contract_short_estimate2, new Object[]{optionBalanceItem.getEstimateAmount(), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
            } else {
                textView.setText("--");
            }
        } else {
            String string = cVar.itemView.getResources().getString(R$string.balance_hide_star);
            e13.setText(string);
            e15.setText(string);
            textView2.setText(string);
            textView.setText(string);
        }
        view.setTag(R$id.item_data, mAccountInfo);
        view.setOnClickListener(this);
    }

    public final void c(Context context, OptionAccountInfo optionAccountInfo) {
        if (p.d(context)) {
            AssetModuleConfig.a().Z0(context, optionAccountInfo);
        }
    }

    public int getResId() {
        return R$layout.item_option_detail;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Context context = view.getContext();
        OptionAccountInfo optionAccountInfo = (OptionAccountInfo) view.getTag(R$id.item_data);
        FutureUserInfo f11 = l.c().f();
        if (f11 == null) {
            HuobiToastUtil.j(R$string.contract_account_loading);
        } else if (1 != f11.getActiveState()) {
            AssetModuleConfig.a().Y(context, TradeType.OPTION);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        } else {
            c(context, optionAccountInfo);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
