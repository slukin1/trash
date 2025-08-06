package com.huobi.finance.viewhandler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bc.a;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BaseAssetInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.Locale;
import s9.c;

public class AssetItemQuantativeViewHandler implements c, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final a f67579b = AssetModuleConfig.a();

    @SuppressLint({"StringFormatInvalid"})
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, BaseAssetInfo baseAssetInfo, ViewGroup viewGroup) {
        View view = cVar.itemView;
        Context context = view.getContext();
        baseAssetInfo.getCurrency();
        r e11 = cVar.e();
        e11.c(R$id.quantitative_coin_logo);
        TextView e12 = e11.e(R$id.quantitative_coin_title);
        e11.e(R$id.quantitative_coin_title_all);
        TextView e13 = e11.e(R$id.quantitative_coin_number);
        TextView e14 = e11.e(R$id.quantitative_coin_price_title);
        TextView e15 = e11.e(R$id.quantitative_coin_price);
        e12.setText(baseAssetInfo.getDisplayName());
        e13.setText(baseAssetInfo.getAvaialAble());
        e14.setText(String.format(context.getString(R$string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
        e15.setText(baseAssetInfo.getEstimateAmount());
        view.setTag(R$id.item_data, baseAssetInfo);
        view.setOnClickListener(this);
    }

    public int getResId() {
        return R$layout.item_asset_quantative;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
