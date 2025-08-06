package com.huobi.asset2.index.tabfragment.fiat;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import hk.a;

public class AssetFiatTabChildFragment extends BaseAssetChildTabFragment {
    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Object obj) {
        this.f42573d.k(JSON.parseArray(obj.toString()));
    }

    public String Ah() {
        return "otcListError";
    }

    public int Dh() {
        return (PixelUtils.f() - PixelUtils.a(45.0f)) - Ch();
    }

    public String Se() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC;
    }

    public String e9() {
        return "asset_tab_fiat_item.xml";
    }

    public void initViews() {
        super.initViews();
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            Log.e("Console", "engine null!");
        } else {
            this.f42574e.a().v("otcList", new ci.a(this));
        }
    }

    public View ve(Context context) {
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            return new View(getContext());
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(this.f42574e.a().E("asset_tab_fiat_header_layout.xml", getContext(), false, (JSONObject) null));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = 20;
        linearLayout.addView(Bh(), marginLayoutParams);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listTitleLeft", (Object) getResources().getString(R$string.n_market_collecation_tab_name));
        jSONObject.put("listTitleCenter", (Object) getResources().getString(R$string.n_in_order));
        jSONObject.put("listTitleRight", (Object) getResources().getString(R$string.asset_marginall_table_top_mid));
        jSONObject.put("showSelect", (Object) "0");
        linearLayout.addView(this.f42574e.a().E("asset_tab_list_header_title_layout.xml", getContext(), true, jSONObject));
        return linearLayout;
    }

    public String wa() {
        return "asset_tab_fiat_expand_item.xml";
    }
}
