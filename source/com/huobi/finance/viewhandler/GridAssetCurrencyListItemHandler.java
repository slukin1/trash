package com.huobi.finance.viewhandler;

import al.p;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.m2;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.finance.bean.GridAssetCurrencyListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.r;
import s9.c;

public class GridAssetCurrencyListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(GridAssetCurrencyListItem gridAssetCurrencyListItem, View view) {
        if (gridAssetCurrencyListItem.d() != null) {
            gridAssetCurrencyListItem.d().onCallback(gridAssetCurrencyListItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, GridAssetCurrencyListItem gridAssetCurrencyListItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.id_grid_asset_currency_list_item_currency);
        TextView textView2 = (TextView) e11.b(R$id.id_grid_asset_currency_list_item_amount);
        TextView textView3 = (TextView) e11.b(R$id.id_grid_asset_currency_list_item_legal);
        String string = cVar.itemView.getResources().getString(R$string.balance_hide_star);
        if (gridAssetCurrencyListItem.g()) {
            textView2.setText(string);
            textView3.setText(string);
        } else {
            textView2.setText(p.j(gridAssetCurrencyListItem.c(), gridAssetCurrencyListItem.e()));
            textView3.setText(gridAssetCurrencyListItem.f());
        }
        textView.setText(k.C().z(gridAssetCurrencyListItem.e()));
        cVar.itemView.setOnClickListener(new m2(gridAssetCurrencyListItem));
    }

    public int getResId() {
        return R$layout.layout_grid_asset_currency_list_item;
    }
}
