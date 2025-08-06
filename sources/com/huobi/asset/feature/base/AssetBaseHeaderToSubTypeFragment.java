package com.huobi.asset.feature.base;

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
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.List;

public abstract class AssetBaseHeaderToSubTypeFragment extends BaseAssetFragment {

    /* renamed from: n  reason: collision with root package name */
    public View f42301n;

    public class a implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TabItemLayoutIndicator f42302b;

        public a(TabItemLayoutIndicator tabItemLayoutIndicator) {
            this.f42302b = tabItemLayoutIndicator;
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            this.f42302b.onItemClick(i11);
        }
    }

    public static class b extends b0 {

        /* renamed from: a  reason: collision with root package name */
        public List<Fragment> f42304a;

        public b(FragmentManager fragmentManager, List<Fragment> list) {
            super(fragmentManager, 1);
            this.f42304a = list;
        }

        public int getCount() {
            return this.f42304a.size();
        }

        public Fragment getItem(int i11) {
            return this.f42304a.get(i11);
        }
    }

    public void Ah() {
        super.Ah();
    }

    public int Fh() {
        return R$layout.fragment_asset_tobar_list;
    }

    public void Jh() {
        Qh();
    }

    public abstract List<Fragment> Lh();

    public abstract View Mh();

    public abstract List<String> Nh();

    public abstract void Oh(View view);

    public final void Ph() {
        ViewPager viewPager = (ViewPager) this.f67460i.b(R$id.f16938vp);
        viewPager.setAdapter(new b(getChildFragmentManager(), Lh()));
        TabItemLayoutIndicator tabItemLayoutIndicator = (TabItemLayoutIndicator) this.f67460i.b(R$id.tab_item_layout);
        List<String> Nh = Nh();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < Nh.size()) {
            TabItemLayoutData tabItemLayoutData = new TabItemLayoutData();
            tabItemLayoutData.setMiddleTabText(Nh.get(i11));
            tabItemLayoutData.setCheck(i11 == 0);
            arrayList.add(tabItemLayoutData);
            i11++;
        }
        tabItemLayoutIndicator.setTabItemLayoutData(arrayList);
        tabItemLayoutIndicator.setItemClickCallBack(new e(viewPager));
        viewPager.addOnPageChangeListener(new a(tabItemLayoutIndicator));
    }

    public abstract void Qh();

    public final void Rh() {
        CollapsingToolbarLayout.LayoutParams layoutParams = new CollapsingToolbarLayout.LayoutParams(-1, -2);
        View Mh = Mh();
        this.f42301n = Mh;
        Oh(Mh);
        ((ViewGroup) this.f67460i.b(R$id.header_layout)).addView(this.f42301n, layoutParams);
    }

    public void initViews() {
        super.initViews();
        Rh();
        Ph();
        Qh();
    }
}
