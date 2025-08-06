package com.huobi.asset2.index.tabfragment.earn;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import hk.a;
import java.util.HashMap;

public class AssetEarnSharkFinChildFragment extends BaseAssetChildTabFragment {
    public String Ah() {
        return "earnSharkFinListError";
    }

    public int Dh() {
        return super.Dh() + PixelUtils.a(4.0f);
    }

    public String Se() {
        return "22";
    }

    public String e9() {
        return "";
    }

    public void initViews() {
        super.initViews();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            return new View(getContext());
        }
        View E = this.f42574e.a().E("asset_tab_earn_shark_fin_layout.xml", getContext(), false, (JSONObject) null);
        E.getLayoutParams().height = Dh();
        return E;
    }

    public void onResume() {
        super.onResume();
        BaseModuleConfig.a().w("app_assets_Earn_ShakeFin_exposure", (HashMap) null);
    }

    public View ve(Context context) {
        return null;
    }

    public String wa() {
        return "";
    }
}
