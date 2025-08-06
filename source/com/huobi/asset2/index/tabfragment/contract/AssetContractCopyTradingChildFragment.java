package com.huobi.asset2.index.tabfragment.contract;

import ai.e;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import hk.a;
import java.util.HashMap;

public class AssetContractCopyTradingChildFragment extends BaseAssetChildTabFragment {
    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Object obj) {
        JSONArray parseArray = JSON.parseArray(obj.toString());
        Log.e("ActivFragment", "initData=:" + parseArray);
        this.f42573d.k(parseArray);
    }

    public String Ah() {
        return "copyTradingListError";
    }

    public int Dh() {
        return super.Dh() + PixelUtils.a(4.0f);
    }

    public String Se() {
        return "19";
    }

    public String e9() {
        return "asset_tab_copy_trading_item.xml";
    }

    public void initViews() {
        super.initViews();
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            Log.e("Console", "engine null!");
        } else {
            this.f42574e.a().v("copyTradingList", new e(this));
        }
    }

    public void onResume() {
        super.onResume();
        BaseModuleConfig.a().w("app_assets_Earn_AutoInvest_exposure", (HashMap) null);
    }

    public View ve(Context context) {
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            return new View(context);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(this.f42574e.a().E("asset_tab_copy_trading_header_layout_new.xml", getContext(), false, (JSONObject) null));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = 20;
        linearLayout.addView(Bh(), marginLayoutParams);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listTitleLeft", (Object) getResources().getString(R$string.n_market_collecation_tab_name));
        jSONObject.put("listTitleCenter", (Object) getResources().getString(R$string.n_transfer_can_transfer_amount));
        jSONObject.put("listTitleRight", (Object) getResources().getString(R$string.n_asset_contract_total_equity));
        jSONObject.put("showTitleIcon", (Object) "gone");
        jSONObject.put("showSelect", (Object) "0");
        linearLayout.addView(this.f42574e.a().E("asset_tab_list_header_title_layout.xml", getContext(), true, jSONObject));
        return linearLayout;
    }

    public String wa() {
        return "asset_tab_copy_trading_expand.xml";
    }
}
