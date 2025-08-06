package com.huobi.finance.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import androidx.viewpager.widget.ViewPager;
import bl.e;
import com.hbg.lib.widgets.tablayout.TabItemLayoutData;
import com.hbg.lib.widgets.tablayout.TabItemLayoutIndicator;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.finance.bean.AssetMortgagePageInfo;
import java.util.ArrayList;
import java.util.List;
import s9.c;

public class AssetMortgageViewAdapter implements c {

    public static class a extends b0 {

        /* renamed from: a  reason: collision with root package name */
        public List<Fragment> f67581a;

        public a(FragmentManager fragmentManager, List<Fragment> list) {
            super(fragmentManager, 1);
            this.f67581a = list;
        }

        public int getCount() {
            return this.f67581a.size();
        }

        public Fragment getItem(int i11) {
            return this.f67581a.get(i11);
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, AssetMortgagePageInfo assetMortgagePageInfo, ViewGroup viewGroup) {
        c(cVar.itemView, assetMortgagePageInfo.getFragmentManager(), assetMortgagePageInfo.getFragmentList(), assetMortgagePageInfo.getTitleList());
    }

    public final void c(View view, FragmentManager fragmentManager, List<Fragment> list, List<String> list2) {
        ViewPager viewPager = (ViewPager) view.findViewById(R$id.f16938vp);
        viewPager.setAdapter(new a(fragmentManager, list));
        TabItemLayoutIndicator tabItemLayoutIndicator = (TabItemLayoutIndicator) view.findViewById(R$id.tab_item_layout);
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < list2.size()) {
            TabItemLayoutData tabItemLayoutData = new TabItemLayoutData();
            tabItemLayoutData.setMiddleTabText(list2.get(i11));
            tabItemLayoutData.setCheck(i11 == 0);
            arrayList.add(tabItemLayoutData);
            i11++;
        }
        tabItemLayoutIndicator.setTabItemLayoutData(arrayList);
        tabItemLayoutIndicator.setItemClickCallBack(new e(viewPager));
    }

    public int getResId() {
        return R$layout.fragment_asset_future;
    }
}
