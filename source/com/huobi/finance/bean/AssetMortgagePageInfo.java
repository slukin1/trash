package com.huobi.finance.bean;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.huobi.finance.viewhandler.AssetMortgageViewAdapter;
import java.util.List;

public class AssetMortgagePageInfo extends BaseAssetInfo {
    private List<Fragment> fragmentList;
    private FragmentManager fragmentManager;
    private List<String> titles;

    public AssetMortgagePageInfo(List<String> list, FragmentManager fragmentManager2, List<Fragment> list2) {
        this.titles = list;
        this.fragmentManager = fragmentManager2;
        this.fragmentList = list2;
    }

    public List<Fragment> getFragmentList() {
        return this.fragmentList;
    }

    public FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public List<String> getTitleList() {
        return this.titles;
    }

    public List<String> getTitles() {
        return this.titles;
    }

    public String getViewHandlerName() {
        return AssetMortgageViewAdapter.class.getName();
    }

    public void setTitles(List<String> list) {
        this.titles = list;
    }
}
