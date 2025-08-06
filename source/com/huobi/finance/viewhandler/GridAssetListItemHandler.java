package com.huobi.finance.viewhandler;

import al.p;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.p2;
import bl.q2;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.grid.bean.GridAccountConvertInfo;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.GridAssetCurrencyListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.ArrayList;
import java.util.Locale;
import s9.c;
import vk.o;

public class GridAssetListItemHandler implements c {
    public static /* synthetic */ void e(o oVar, GridAssetCurrencyListItem gridAssetCurrencyListItem) {
        if (oVar.d() != null) {
            oVar.d().onCallback(oVar);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(o oVar, View view) {
        if (oVar.d() != null) {
            oVar.d().onCallback(oVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, o oVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Resources resources = cVar.itemView.getResources();
        GridAccountConvertInfo c11 = oVar.c();
        ((TextView) e11.b(R$id.id_grid_asset_list_item_title)).setText(c11.getBaseCurrency() + "/" + c11.getQuoteCurrency());
        String i12 = StringUtils.i(LegalCurrencyConfigUtil.y());
        ((TextView) e11.b(R$id.id_grid_asset_list_item_title_legal)).setText(String.format(Locale.US, resources.getString(R$string.n_balance_equivalent_ph), new Object[]{i12}));
        ArrayList arrayList = new ArrayList();
        q2 q2Var = new q2(oVar);
        GridAssetCurrencyListItem gridAssetCurrencyListItem = new GridAssetCurrencyListItem();
        gridAssetCurrencyListItem.j(c11.getBaseCurrency());
        gridAssetCurrencyListItem.k(!p.u());
        gridAssetCurrencyListItem.h(c11.getBaseAmount());
        gridAssetCurrencyListItem.l(LegalCurrencyConfigUtil.D(gridAssetCurrencyListItem.c(), c11.getSymbol(), TradeType.PRO));
        gridAssetCurrencyListItem.i(q2Var);
        arrayList.add(gridAssetCurrencyListItem);
        GridAssetCurrencyListItem gridAssetCurrencyListItem2 = new GridAssetCurrencyListItem();
        gridAssetCurrencyListItem2.j(c11.getQuoteCurrency());
        gridAssetCurrencyListItem2.h(c11.getQuoteAmount());
        gridAssetCurrencyListItem2.k(!p.u());
        gridAssetCurrencyListItem2.l(LegalCurrencyConfigUtil.B(gridAssetCurrencyListItem2.c()));
        gridAssetCurrencyListItem2.i(q2Var);
        arrayList.add(gridAssetCurrencyListItem2);
        ((EasyRecyclerView) e11.b(R$id.id_grid_asset_list_item_recyclerView)).setData(arrayList);
        cVar.itemView.setOnClickListener(new p2(oVar));
    }

    public int getResId() {
        return R$layout.layout_grid_asset_list_item;
    }
}
