package com.huobi.finance.viewhandler;

import al.p;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bc.a;
import com.hbg.lib.network.hbg.core.bean.PledgeBalance;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.AssetMortgageItemInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import g6.b;
import i6.r;
import java.util.Locale;
import s9.c;

public class AssetMortgageItemViewHandler implements c, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final a f67580b = AssetModuleConfig.a();

    @SuppressLint({"StringFormatInvalid"})
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, AssetMortgageItemInfo assetMortgageItemInfo, ViewGroup viewGroup) {
        boolean z11 = !p.u();
        View view = cVar.itemView;
        Context context = view.getContext();
        assetMortgageItemInfo.getCurrency();
        String string = context.getString(R$string.balance_hide_star);
        r e11 = cVar.e();
        ImageView c11 = e11.c(R$id.asset_coin_logo);
        TextView e12 = e11.e(R$id.asset_coin_title);
        TextView e13 = e11.e(R$id.asset_coin_title_all);
        TextView e14 = e11.e(R$id.asset_coin_number_title);
        TextView e15 = e11.e(R$id.asset_coin_number);
        TextView e16 = e11.e(R$id.asset_coin_price_title);
        TextView e17 = e11.e(R$id.asset_coin_price);
        PledgeBalance.CurrencyBalance itemBean = assetMortgageItemInfo.getItemBean();
        if (itemBean != null) {
            b.c().i(c11, itemBean.getCurrencyIcon(), p.m());
            e12.setText(itemBean.getCurrency().toUpperCase());
            CurrencyBean s11 = k.C().s(itemBean.getCurrency());
            if (s11 != null) {
                e13.setText(s11.getFullName());
            } else {
                e13.setText("");
            }
            e15.setText(p.j(itemBean.getAmount(), itemBean.getCurrency()));
            e17.setText(LegalCurrencyConfigUtil.B(itemBean.getUsdtAmount()));
        }
        if (z11) {
            e15.setText(string);
            e17.setText(string);
        }
        e14.setText(assetMortgageItemInfo.getCoinNumberTitle());
        e16.setText(String.format(context.getString(R$string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
        view.setTag(R$id.item_data, assetMortgageItemInfo);
        view.setOnClickListener(this);
    }

    public int getResId() {
        return R$layout.item_asset_mortgage;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
