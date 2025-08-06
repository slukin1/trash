package com.huobi.asset2.index.tabfragment.spot;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.v;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fi.b;
import fi.c;
import hk.a;
import java.util.HashMap;

public class AssetBotTabChildFragment extends BaseAssetChildTabFragment {

    /* renamed from: o  reason: collision with root package name */
    public String f42757o;

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Object obj) {
        this.f42573d.k(JSON.parseArray(obj.toString()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xh(Object obj) {
        if (obj instanceof String) {
            this.f42757o = (String) obj;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Yh(View view) {
        String str = this.f42757o;
        if (str == null || str.isEmpty()) {
            AssetModuleConfig.a().p(view.getContext(), "");
        } else {
            AssetModuleConfig.a().a1(this.f42757o);
        }
        BaseModuleConfig.a().w("app_assets_tradingbot_found_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String Ah() {
        return "botListError";
    }

    public String Se() {
        return "15";
    }

    public String e9() {
        return "asset_tab_spot_bot_item.xml";
    }

    public void initViews() {
        super.initViews();
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            Log.e("Console", "engine null!");
            return;
        }
        this.f42574e.a().v("botList", new c(this));
        this.f42574e.a().u("spotRobotJumpUrl", new b(this));
        this.f42573d.m((String) null, getString(R$string.n_cloud_wallet_go_create), new fi.a(this));
    }

    public void onResume() {
        super.onResume();
        BaseModuleConfig.a().w("app_assets_spot_tradingbot_exposure", (HashMap) null);
    }

    public View ve(Context context) {
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            return new View(getContext());
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(this.f42574e.a().E("asset_tab_bot_header_layout_new.xml", getContext(), false, (JSONObject) null));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listTitleLeft", (Object) getResources().getString(R$string.n_market_collecation_tab_name));
        jSONObject.put("listTitleCenter", (Object) getResources().getString(R$string.n_balance_cost_title));
        jSONObject.put("listTitleRight", (Object) getResources().getString(R$string.asset_spotbot_table_top_income));
        jSONObject.put("showSelect", (Object) "0");
        jSONObject.put("isBot", (Object) "1");
        View E = this.f42574e.a().E("asset_tab_list_header_title_layout.xml", getContext(), true, jSONObject);
        ((ViewGroup.MarginLayoutParams) E.getLayoutParams()).topMargin = v.a(12.0f);
        linearLayout.addView(E);
        return linearLayout;
    }

    public String wa() {
        return "asset_tab_bot_expand_item.xml";
    }
}
