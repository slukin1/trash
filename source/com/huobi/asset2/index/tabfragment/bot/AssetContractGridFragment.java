package com.huobi.asset2.index.tabfragment.bot;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import hk.a;

public class AssetContractGridFragment extends BaseAssetChildTabFragment {
    public String Ah() {
        return "";
    }

    public int Dh() {
        return super.Dh() + PixelUtils.a(4.0f);
    }

    public String Se() {
        return "25";
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
        View E = this.f42574e.a().E("asset_tab_earn_contract_grid_layout.xml", getContext(), false, (JSONObject) null);
        E.getLayoutParams().height = Dh();
        return E;
    }

    public void onResume() {
        super.onResume();
    }

    public View ve(Context context) {
        return null;
    }

    public String wa() {
        return "";
    }
}
