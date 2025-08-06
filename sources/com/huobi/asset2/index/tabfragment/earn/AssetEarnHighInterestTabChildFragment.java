package com.huobi.asset2.index.tabfragment.earn;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import bi.e;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hk.a;
import java.util.HashMap;

public class AssetEarnHighInterestTabChildFragment extends BaseAssetChildTabFragment {
    @SensorsDataInstrumented
    public static /* synthetic */ void Vh(View view) {
        AssetModuleConfig.a().m1(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String Ah() {
        return "earnHighListError";
    }

    public int Dh() {
        return super.Dh() + PixelUtils.a(4.0f);
    }

    public String Se() {
        return "20";
    }

    public String e9() {
        return "asset_tab_earn_item.xml";
    }

    public void initViews() {
        super.initViews();
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            Log.e("Console", "engine null!");
        } else {
            this.f42573d.m((String) null, getString(R$string.n_balance_mining_deposit), e.f12399b);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            return new View(getContext());
        }
        this.f42571b.addView(this.f42574e.a().E("asset_tab_earn_high_interest_layout.xml", getContext(), false, (JSONObject) null), new ViewGroup.LayoutParams(-1, Dh()));
        return this.f42571b;
    }

    public void onResume() {
        super.onResume();
        BaseModuleConfig.a().w("app_assets_Earn_MaxFlexible_exposure", (HashMap) null);
    }

    public View ve(Context context) {
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            return new View(context);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(this.f42574e.a().E("asset_tab_earn_header_layout.xml", getContext(), false, (JSONObject) null));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = 20;
        linearLayout.addView(Bh(), marginLayoutParams);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listTitleLeft", (Object) getResources().getString(R$string.n_market_collecation_tab_name));
        jSONObject.put("listTitleCenter", (Object) getResources().getString(R$string.asset_spot_table_top_balance));
        jSONObject.put("listTitleRight", (Object) getResources().getString(R$string.n_asset_yestoday_interest_amount));
        jSONObject.put("showTitleIcon", (Object) "gone");
        jSONObject.put("showSelect", (Object) "0");
        linearLayout.addView(this.f42574e.a().E("asset_tab_list_header_title_layout.xml", getContext(), true, jSONObject));
        return linearLayout;
    }

    public String wa() {
        return "asset_tab_earn_expand_item.xml";
    }
}
