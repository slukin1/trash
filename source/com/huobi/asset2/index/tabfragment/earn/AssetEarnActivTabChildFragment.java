package com.huobi.asset2.index.tabfragment.earn;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import bi.b;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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

public class AssetEarnActivTabChildFragment extends BaseAssetChildTabFragment {

    /* renamed from: o  reason: collision with root package name */
    public View f42751o;

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Object obj) {
        JSONArray parseArray = JSON.parseArray(obj.toString());
        Log.e("ActivFragment", "initData=:" + parseArray);
        this.f42573d.k(parseArray);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Wh(View view) {
        AssetModuleConfig.a().m1(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String Ah() {
        return "earnYbbListError";
    }

    public int Dh() {
        return super.Dh() + PixelUtils.a(4.0f);
    }

    public String Se() {
        return "17";
    }

    public String e9() {
        return "asset_tab_earn_ybb_item.xml";
    }

    public void initViews() {
        super.initViews();
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            Log.e("Console", "engine null!");
            return;
        }
        this.f42574e.a().v("earnYbbList", new b(this));
        this.f42573d.m((String) null, getString(R$string.n_balance_mining_deposit), bi.a.f12395b);
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
        View E = this.f42574e.a().E("asset_tab_earn_ybb_header_layout.xml", getContext(), false, (JSONObject) null);
        this.f42751o = E;
        linearLayout.addView(E);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = 20;
        linearLayout.addView(Bh(), marginLayoutParams);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listTitleLeft", (Object) getResources().getString(R$string.n_market_collecation_tab_name));
        jSONObject.put("listTitleCenter", (Object) getResources().getString(R$string.asset_spot_table_top_balance_new));
        jSONObject.put("listTitleRight", (Object) getResources().getString(R$string.n_asset_yestoday_interest_amount));
        jSONObject.put("showTitleIcon", (Object) "gone");
        jSONObject.put("showSelect", (Object) "0");
        linearLayout.addView(this.f42574e.a().E("asset_tab_list_header_title_layout.xml", getContext(), true, jSONObject));
        return linearLayout;
    }

    public String wa() {
        return "asset_tab_earn_expand_ybb_item.xml";
    }
}
