package com.huobi.asset2.index.tabfragment.contract;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetTabFragment;
import java.util.ArrayList;
import java.util.List;

public class AssetContractTabFragment extends BaseAssetTabFragment {

    /* renamed from: j  reason: collision with root package name */
    public Boolean f42750j = Boolean.TRUE;

    public void initViews() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f42750j = Boolean.valueOf(JSON.parseArray(JSON.parseObject(arguments.getString("asset_contract_config")).getJSONArray("subTypeList").toJSONString(), String.class).contains("19"));
        }
        super.initViews();
    }

    public ArrayList<Fragment> sh() {
        ArrayList<Fragment> arrayList = new ArrayList<>();
        AssetLinearSwapTabChildFragment assetLinearSwapTabChildFragment = new AssetLinearSwapTabChildFragment();
        AssetCoinPTabChildFragment assetCoinPTabChildFragment = new AssetCoinPTabChildFragment();
        AssetCoinMTabChildFragment assetCoinMTabChildFragment = new AssetCoinMTabChildFragment();
        assetLinearSwapTabChildFragment.th(this.f42587e);
        assetCoinMTabChildFragment.th(this.f42587e);
        assetCoinPTabChildFragment.th(this.f42587e);
        arrayList.add(assetLinearSwapTabChildFragment);
        arrayList.add(assetCoinPTabChildFragment);
        arrayList.add(assetCoinMTabChildFragment);
        if (this.f42750j.booleanValue()) {
            AssetContractCopyTradingChildFragment assetContractCopyTradingChildFragment = new AssetContractCopyTradingChildFragment();
            assetContractCopyTradingChildFragment.Sh(this.f42587e);
            arrayList.add(assetContractCopyTradingChildFragment);
        }
        return arrayList;
    }

    public List<String> th() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R$string.n_balance_contract_linear_swap_title));
        arrayList.add(getString(R$string.n_balance_contract_swap_title));
        arrayList.add(getString(R$string.n_balance_contract_contract_title));
        if (this.f42750j.booleanValue()) {
            arrayList.add(getString(R$string.n_transfer_follower_account));
        }
        return arrayList;
    }

    public void uh(View view) {
        if (this.f42591i == 3) {
            AssetModuleConfig.a().a1("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/copyTradingTransferRecord");
        }
    }

    public int vh() {
        return 8;
    }

    public void yh() {
        super.yh();
        this.f42585c.setOffscreenPageLimit(4);
    }

    public void zh(int i11) {
    }
}
