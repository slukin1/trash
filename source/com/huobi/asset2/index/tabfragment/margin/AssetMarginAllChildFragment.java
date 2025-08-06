package com.huobi.asset2.index.tabfragment.margin;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import hk.a;
import java.util.HashMap;

public class AssetMarginAllChildFragment extends BaseAssetChildTabFragment {
    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Object obj) {
        this.f42573d.k(JSON.parseArray(obj.toString()));
    }

    public String Ah() {
        return "longLevelDataListError";
    }

    public int Dh() {
        return super.Dh() + PixelUtils.a(5.0f);
    }

    public String Se() {
        return "3";
    }

    public String e9() {
        return "asset_tab_margin_item.xml";
    }

    public void initViews() {
        super.initViews();
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            Log.e("Console", "engine null!");
        } else {
            this.f42574e.a().v("longLevelDataList", new di.a(this));
        }
    }

    public void onResume() {
        super.onResume();
        BaseModuleConfig.a().w("app_assets_margin_cross_exposure", (HashMap) null);
    }

    public View ve(Context context) {
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            return new View(getContext());
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(this.f42574e.a().E("asset_tab_margin_all_header_layout.xml", getContext(), false, (JSONObject) null));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = 20;
        linearLayout.addView(Bh(), marginLayoutParams);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listTitleLeft", (Object) getResources().getString(R$string.n_market_collecation_tab_name));
        jSONObject.put("listTitleCenter", (Object) getResources().getString(R$string.n_asset_margin_usable_loan));
        jSONObject.put("listTitleRight", (Object) getResources().getString(R$string.asset_marginpart_table_top_mid));
        jSONObject.put("showSelect", (Object) "0");
        linearLayout.addView(this.f42574e.a().E("asset_tab_list_header_title_layout.xml", getContext(), true, jSONObject));
        return linearLayout;
    }

    public String wa() {
        return "asset_tab_margin_expand_item.xml";
    }
}
