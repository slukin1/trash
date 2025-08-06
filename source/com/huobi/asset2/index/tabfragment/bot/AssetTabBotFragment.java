package com.huobi.asset2.index.tabfragment.bot;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.huobi.asset2.index.BaseAssetTabFragment;
import com.huobi.asset2.index.tabfragment.spot.AssetBotTabChildFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssetTabBotFragment extends BaseAssetTabFragment {

    /* renamed from: j  reason: collision with root package name */
    public boolean f42747j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f42748k;

    /* renamed from: l  reason: collision with root package name */
    public List<Fragment> f42749l = new ArrayList();

    public final void Ch() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            List<String> parseArray = JSON.parseArray(JSON.parseObject(arguments.getString("asset_contract_config")).getJSONArray("subTypeList").toJSONString(), String.class);
            this.f42747j = parseArray.contains("15");
            this.f42748k = parseArray.contains("25");
        }
    }

    public void initViews() {
        Ch();
        super.initViews();
    }

    public ArrayList<BaseAssetChildTabFragment> sh() {
        ArrayList<BaseAssetChildTabFragment> arrayList = new ArrayList<>();
        if (this.f42747j) {
            AssetBotTabChildFragment assetBotTabChildFragment = new AssetBotTabChildFragment();
            assetBotTabChildFragment.Sh(this.f42587e);
            arrayList.add(assetBotTabChildFragment);
        }
        if (this.f42748k) {
            AssetContractGridFragment assetContractGridFragment = new AssetContractGridFragment();
            assetContractGridFragment.Sh(this.f42587e);
            arrayList.add(assetContractGridFragment);
        }
        this.f42749l.clear();
        this.f42749l.addAll(arrayList);
        return arrayList;
    }

    public List<String> th() {
        ArrayList arrayList = new ArrayList();
        if (this.f42747j) {
            arrayList.add(getString(R$string.n_trade_bot_spot));
        }
        if (this.f42748k) {
            arrayList.add(getString(R$string.n_trade_bot_contract_grid));
        }
        return arrayList;
    }

    public void uh(View view) {
        HashMap hashMap = new HashMap();
        int i11 = this.f42591i;
        if (i11 == 0) {
            AssetModuleConfig.a().o(view.getContext(), this.f42591i);
            hashMap.put("tabName", "现货机器人");
        } else if (i11 == 1) {
            AssetModuleConfig.a().o(view.getContext(), this.f42591i);
            hashMap.put("tabName", "合约网格");
        }
        BaseModuleConfig.a().w("app_assets_Earn_orders_click", hashMap);
    }

    public int vh() {
        return 0;
    }

    public void zh(int i11) {
    }
}
