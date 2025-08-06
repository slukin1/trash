package com.huobi.asset2.index.tabfragment.contract;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import hk.a;
import java.util.HashMap;

public class AssetCoinMAllTabChildFragment extends BaseAssetChildTabFragment {
    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Object obj) {
        this.f42573d.k(JSON.parseArray(obj.toString()));
    }

    public String Ah() {
        return "coinMAllAssetListError";
    }

    public int Dh() {
        return super.Dh() - PixelUtils.a(125.0f);
    }

    public String Se() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP;
    }

    public String e9() {
        return "asset_tab_contract_b_item.xml";
    }

    public void initViews() {
        super.initViews();
        this.f42575f = false;
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            Log.e("Console", "engine null!");
        } else {
            this.f42574e.a().v("coinMAllAssetList", new ai.a(this));
        }
    }

    public void onResume() {
        super.onResume();
        a aVar = this.f42574e;
        if (!(aVar == null || aVar.a() == null)) {
            this.f42574e.a().I("assetThirdTypeEvent('11',true)");
        }
        BaseModuleConfig.a().w("app_assets_futures_coinf_exposure", (HashMap) null);
    }

    public View ve(Context context) {
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            return new View(context);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = 20;
        linearLayout.addView(Bh(), marginLayoutParams);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listTitleLeft", (Object) getResources().getString(R$string.n_market_collecation_tab_name));
        jSONObject.put("listTitleCenter", (Object) getResources().getString(R$string.n_otc_available));
        jSONObject.put("listTitleRight", (Object) getResources().getString(R$string.n_asset_contract_total_equity));
        jSONObject.put("showSelect", (Object) "0");
        linearLayout.addView(this.f42574e.a().E("asset_tab_list_header_title_layout.xml", getContext(), true, jSONObject));
        return linearLayout;
    }

    public String wa() {
        return "asset_tab_contract_u_expand_item.xml";
    }
}
