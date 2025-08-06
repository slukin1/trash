package com.huobi.asset2.index.tabfragment.earn;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.huobi.asset2.index.BaseAssetTabFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssetTabEarnFragment extends BaseAssetTabFragment {

    /* renamed from: j  reason: collision with root package name */
    public boolean f42752j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f42753k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f42754l;

    /* renamed from: m  reason: collision with root package name */
    public String f42755m = "";

    /* renamed from: n  reason: collision with root package name */
    public List<Fragment> f42756n = new ArrayList();

    public boolean Ch(String str) {
        try {
            return true ^ JSON.parseObject(str).getJSONArray("subTypeList").toJSONString().equals(this.f42755m);
        } catch (Exception e11) {
            e11.printStackTrace();
            return true;
        }
    }

    public final void Dh() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String jSONString = JSON.parseObject(arguments.getString("asset_contract_config")).getJSONArray("subTypeList").toJSONString();
            this.f42755m = jSONString;
            List<String> parseArray = JSON.parseArray(jSONString, String.class);
            this.f42752j = parseArray.contains("20");
            this.f42753k = parseArray.contains("21");
            this.f42754l = parseArray.contains("22");
        }
    }

    public void Wg() {
        Dh();
        super.Wg();
    }

    public void initViews() {
        Dh();
        super.initViews();
    }

    public void onResume() {
        super.onResume();
        this.f42587e.a().I("assetNewEarnGuide()");
    }

    public ArrayList<BaseAssetChildTabFragment> sh() {
        ArrayList<BaseAssetChildTabFragment> arrayList = new ArrayList<>();
        AssetEarnActivTabChildFragment assetEarnActivTabChildFragment = new AssetEarnActivTabChildFragment();
        AssetEarnFixedTabChildFragment assetEarnFixedTabChildFragment = new AssetEarnFixedTabChildFragment();
        assetEarnActivTabChildFragment.Sh(this.f42587e);
        assetEarnFixedTabChildFragment.Sh(this.f42587e);
        arrayList.add(assetEarnActivTabChildFragment);
        arrayList.add(assetEarnFixedTabChildFragment);
        if (this.f42754l) {
            AssetEarnSharkFinChildFragment assetEarnSharkFinChildFragment = new AssetEarnSharkFinChildFragment();
            assetEarnSharkFinChildFragment.Sh(this.f42587e);
            arrayList.add(assetEarnSharkFinChildFragment);
        }
        if (this.f42753k) {
            AssetEarnNodePledgeTabChildFragment assetEarnNodePledgeTabChildFragment = new AssetEarnNodePledgeTabChildFragment();
            assetEarnNodePledgeTabChildFragment.Sh(this.f42587e);
            arrayList.add(assetEarnNodePledgeTabChildFragment);
        }
        this.f42756n.clear();
        this.f42756n.addAll(arrayList);
        return arrayList;
    }

    public List<String> th() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R$string.n_asset_earn_current));
        arrayList.add(getString(R$string.n_mining_asset_fixed));
        if (this.f42754l) {
            arrayList.add(getString(R$string.n_shark_fin));
        }
        if (this.f42753k) {
            arrayList.add(getString(R$string.n_asset_point_pledge));
        }
        return arrayList;
    }

    public void uh(View view) {
        HBBaseWebActivity.showWebView(view.getContext(), BaseModuleConfig.a().W() + "financial/earn/order/h5/", (String) null, (String) null, true);
        int currentItem = this.f42585c.getCurrentItem();
        HashMap hashMap = new HashMap();
        if (currentItem == 0) {
            hashMap.put("tabName", "flexible");
        } else if (currentItem == 1) {
            hashMap.put("tabName", "fixed");
        } else if (currentItem == 2) {
            hashMap.put("tabName", "maxFlaxible");
        } else if (currentItem == 3) {
            hashMap.put("tabName", "shakeFin");
        }
        BaseModuleConfig.a().w("app_assets_Earn_orders_click", hashMap);
    }

    public int vh() {
        return 0;
    }

    public void zh(int i11) {
        if (i11 >= this.f42756n.size() || this.f42756n.get(i11).getClass() != AssetEarnNodePledgeTabChildFragment.class) {
            this.f42589g.setVisibility(0);
        } else {
            this.f42589g.setVisibility(8);
        }
    }
}
