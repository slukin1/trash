package com.huobi.finance.viewhandler;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.n2;
import bl.o2;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.grid.bean.GridAccountRunningStrategyInfo;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.GridAssetCurrencyListItem;
import com.huobi.finance.bean.GridAssetDetailListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import i6.r;
import java.util.ArrayList;
import java.util.Locale;
import s9.c;

public class GridAssetDetailListItemHandler implements c {
    public static /* synthetic */ void e(GridAssetDetailListItem gridAssetDetailListItem, GridAssetCurrencyListItem gridAssetCurrencyListItem) {
        if (gridAssetDetailListItem.c() != null) {
            gridAssetDetailListItem.c().a(gridAssetDetailListItem);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(GridAssetDetailListItem gridAssetDetailListItem, View view) {
        if (gridAssetDetailListItem.c() != null) {
            gridAssetDetailListItem.c().a(gridAssetDetailListItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, GridAssetDetailListItem gridAssetDetailListItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Resources resources = cVar.itemView.getResources();
        GridAccountRunningStrategyInfo d11 = gridAssetDetailListItem.d();
        ((TextView) e11.b(R$id.id_grid_asset_detail_item_title)).setText(resources.getString(R$string.n_grid_grid_strategy) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + d11.getName());
        String i12 = StringUtils.i(LegalCurrencyConfigUtil.y());
        ((TextView) e11.b(R$id.id_grid_asset_list_item_title_legal)).setText(String.format(Locale.US, resources.getString(R$string.n_balance_equivalent_ph), new Object[]{i12}));
        o2 o2Var = new o2(gridAssetDetailListItem);
        ArrayList arrayList = new ArrayList();
        GridAssetCurrencyListItem gridAssetCurrencyListItem = new GridAssetCurrencyListItem();
        gridAssetCurrencyListItem.j(d11.getBaseCurrency());
        gridAssetCurrencyListItem.h(d11.getBaseAmount());
        gridAssetCurrencyListItem.l(LegalCurrencyConfigUtil.D(gridAssetCurrencyListItem.c(), gridAssetDetailListItem.e(), TradeType.PRO));
        gridAssetCurrencyListItem.i(o2Var);
        arrayList.add(gridAssetCurrencyListItem);
        GridAssetCurrencyListItem gridAssetCurrencyListItem2 = new GridAssetCurrencyListItem();
        gridAssetCurrencyListItem2.j(d11.getQuoteCurrency());
        gridAssetCurrencyListItem2.h(d11.getQuoteAmount());
        gridAssetCurrencyListItem2.l(LegalCurrencyConfigUtil.B(gridAssetCurrencyListItem2.c()));
        gridAssetCurrencyListItem2.i(o2Var);
        arrayList.add(gridAssetCurrencyListItem2);
        ((EasyRecyclerView) e11.b(R$id.id_grid_asset_list_item_recyclerView)).setData(arrayList);
        cVar.itemView.setOnClickListener(new n2(gridAssetDetailListItem));
    }

    public int getResId() {
        return R$layout.layout_grid_asset_detail_list_item;
    }
}
