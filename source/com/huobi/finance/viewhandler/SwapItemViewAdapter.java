package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.contract.entity.SwapBalanceItem;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.utils.AssetNumberUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import m9.z;
import qs.a;
import s9.c;

public class SwapItemViewAdapter implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, SwapBalanceItem swapBalanceItem, ViewGroup viewGroup) {
        String str;
        v9.c cVar2 = cVar;
        View view = cVar2.itemView;
        Resources resources = view.getResources();
        SwapAccountInfo mSwapAccountInfo = swapBalanceItem.getMSwapAccountInfo();
        String symbol = mSwapAccountInfo.getSymbol() == null ? "" : mSwapAccountInfo.getSymbol();
        r e11 = cVar.e();
        TextView e12 = e11.e(R$id.item_balance_currency_name);
        TextView e13 = e11.e(R$id.item_balance_contract_equity);
        TextView e14 = e11.e(R$id.item_balance_contract_equity_title);
        TextView e15 = e11.e(R$id.item_balance_estimate);
        TextView e16 = e11.e(R$id.item_balance_estimate_title);
        e16.setText(String.format(e16.getContext().getResources().getString(R$string.n_balance_contract_prediction_of_strong_parity2), new Object[]{"(USD)"}));
        TextView textView = (TextView) e11.b(R$id.item_balance_burrow_rate);
        TextView textView2 = (TextView) e11.b(R$id.item_contract_balance_estimate);
        e12.setText(symbol.toUpperCase(Locale.US));
        e14.setText(String.format(resources.getString(R$string.n_balance_contract_account_equity2), new Object[]{symbol}));
        ((ImageView) e11.b(R$id.item_balance_limit_undone)).setVisibility(8);
        ImageView c11 = e11.c(R$id.item_margin_balance_symbol_icon);
        TextView e17 = e11.e(R$id.item_balance_currency_name_all);
        CurrencyBean s11 = k.C().s(swapBalanceItem.getCurrency());
        if (s11 != null) {
            e17.setText(s11.getFullName());
        } else {
            e17.setText("");
        }
        f6.c.a().l(view.getContext(), p.k(swapBalanceItem.getCurrency()), c11, p.m());
        if (p.u()) {
            if (TextUtils.isEmpty(mSwapAccountInfo.getMarginBalance())) {
                str = "--";
            } else {
                str = AssetNumberUtil.a(mSwapAccountInfo.getMarginBalance(), a.f84586a.c(symbol, 8));
            }
            e13.setText(str);
            String liquidationPrice = mSwapAccountInfo.getLiquidationPrice();
            if (!TextUtils.isEmpty(liquidationPrice)) {
                try {
                    e15.setText(AssetNumberUtil.a(liquidationPrice, a.f84586a.b(symbol, 8)));
                } catch (Exception e18) {
                    e18.printStackTrace();
                    e15.setText("--");
                }
            } else {
                e15.setText("--");
            }
            String riskRate = mSwapAccountInfo.getRiskRate();
            if (!TextUtils.isEmpty(riskRate)) {
                BigDecimal a11 = m.a(riskRate);
                textView.setText(m.q(a11.multiply(m.f68179a), a.f84586a.e()) + "%");
            } else {
                textView.setText("--");
            }
            if (!TextUtils.isEmpty(swapBalanceItem.getEstimateAmount())) {
                textView2.setText(textView2.getContext().getString(R$string.n_balance_contract_short_estimate2, new Object[]{swapBalanceItem.getEstimateAmount(), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
            } else {
                textView2.setText("--");
            }
        } else {
            String string = cVar2.itemView.getResources().getString(R$string.balance_hide_star);
            e13.setText(string);
            e15.setText(string);
            textView.setText(string);
            textView2.setText(string);
        }
        view.setTag(R$id.item_data, mSwapAccountInfo);
        view.setOnClickListener(this);
    }

    public final void c(Context context, SwapAccountInfo swapAccountInfo) {
        if (p.d(context)) {
            AssetModuleConfig.a().Q(context, swapAccountInfo);
        }
    }

    public int getResId() {
        return R$layout.item_contract_detail;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Context context = view.getContext();
        SwapAccountInfo swapAccountInfo = (SwapAccountInfo) view.getTag(R$id.item_data);
        SwapUserInfo.UserBean h11 = z.f().h();
        if (h11 == null) {
            HuobiToastUtil.j(R$string.contract_account_loading);
        } else if (1 != h11.getActiveState()) {
            AssetModuleConfig.a().c0(context);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        } else {
            c(context, swapAccountInfo);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
