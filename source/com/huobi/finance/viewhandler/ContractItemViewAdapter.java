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
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.utils.AssetNumberUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import ej.f;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import s9.c;

public class ContractItemViewAdapter implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, ContractAccountInfo contractAccountInfo, ViewGroup viewGroup) {
        String str;
        v9.c cVar2 = cVar;
        View view = cVar2.itemView;
        Resources resources = view.getResources();
        String symbol = contractAccountInfo.getSymbol() == null ? "" : contractAccountInfo.getSymbol();
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
        TextView e17 = e11.e(R$id.item_balance_currency_name_all);
        CurrencyBean s11 = k.C().s(contractAccountInfo.getCurrency());
        if (s11 != null) {
            e17.setText(s11.getFullName());
        } else {
            e17.setText("");
        }
        f6.c.a().l(view.getContext(), p.k(contractAccountInfo.getCurrency()), e11.c(R$id.item_margin_balance_symbol_icon), p.m());
        if (p.u()) {
            if (TextUtils.isEmpty(contractAccountInfo.getMarginBalance())) {
                str = "--";
            } else {
                str = AssetNumberUtil.a(contractAccountInfo.getMarginBalance(), ContractCurrencyUtils.r(symbol, 8));
            }
            e13.setText(str);
            String liquidationPrice = contractAccountInfo.getLiquidationPrice();
            if (!TextUtils.isEmpty(liquidationPrice)) {
                try {
                    e15.setText(AssetNumberUtil.a(liquidationPrice, f.b(symbol, 8)));
                } catch (Exception e18) {
                    e18.printStackTrace();
                    e15.setText("--");
                }
            } else {
                e15.setText("--");
            }
            String riskRate = contractAccountInfo.getRiskRate();
            if (!TextUtils.isEmpty(riskRate)) {
                BigDecimal a11 = m.a(riskRate);
                textView.setText(m.q(a11.multiply(m.f68179a), f.k(symbol)) + "%");
            } else {
                textView.setText("--");
            }
            if (!TextUtils.isEmpty(contractAccountInfo.getEstimateAmount())) {
                textView2.setText(textView2.getContext().getString(R$string.n_balance_contract_short_estimate2, new Object[]{contractAccountInfo.getEstimateAmount(), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
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
        view.setTag(R$id.item_data, contractAccountInfo);
        view.setOnClickListener(this);
    }

    public final void c(Context context, ContractAccountInfo contractAccountInfo) {
        if (p.d(context)) {
            AssetModuleConfig.a().s(context, contractAccountInfo);
        }
    }

    public int getResId() {
        return R$layout.item_contract_detail;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Context context = view.getContext();
        ContractAccountInfo contractAccountInfo = (ContractAccountInfo) view.getTag(R$id.item_data);
        ContractUserInfo.UserBean R = AssetModuleConfig.a().R();
        if (R == null) {
            HuobiToastUtil.j(R$string.contract_account_loading);
        } else if (1 != R.getActiveState()) {
            AssetModuleConfig.a().U(context);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        } else {
            c(context, contractAccountInfo);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
