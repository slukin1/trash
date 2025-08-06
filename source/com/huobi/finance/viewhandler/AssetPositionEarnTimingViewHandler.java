package com.huobi.finance.viewhandler;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.finance.bean.AssetPositionEarnTimingHeaderData;
import i6.r;
import s9.c;

public class AssetPositionEarnTimingViewHandler implements c<v9.c, AssetPositionEarnTimingHeaderData> {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, AssetPositionEarnTimingHeaderData assetPositionEarnTimingHeaderData, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        String upperCase = BaseModuleConfig.a().M().toUpperCase();
        ((TextView) e11.b(R$id.contract_header_title_name)).setText(context.getString(R$string.n_market_collecation_tab_name));
        ((TextView) e11.b(R$id.contract_header_center_text)).setText(context.getString(R$string.n_asset_position_number, new Object[]{upperCase}));
        ((TextView) e11.b(R$id.contract_header_end_text)).setText(context.getString(R$string.n_asset_position_this_day_number, new Object[]{upperCase}));
    }

    public int getResId() {
        return R$layout.item_position_earn_timing_header;
    }
}
