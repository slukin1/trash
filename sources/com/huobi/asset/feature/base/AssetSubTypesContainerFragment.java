package com.huobi.asset.feature.base;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.widgets.tablayout.TabItemLayoutData;
import com.hbg.lib.widgets.tablayout.TabItemLayoutIndicator;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.asset.feature.summary.AssetSummaryAccountType;
import java.util.ArrayList;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.ThreadMode;
import ph.g;

public abstract class AssetSubTypesContainerFragment extends BaseAssetFragment {

    /* renamed from: q  reason: collision with root package name */
    public static AssetSummaryAccountType f42318q;

    /* renamed from: n  reason: collision with root package name */
    public b f42319n;

    /* renamed from: o  reason: collision with root package name */
    public ViewPager f42320o;

    /* renamed from: p  reason: collision with root package name */
    public TabItemLayoutIndicator f42321p;

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            AssetSubTypesContainerFragment.this.f42321p.onItemClick(i11);
            SP.q(AssetSubTypesContainerFragment.this.Qh(), i11);
        }
    }

    public static class b extends b0 {

        /* renamed from: a  reason: collision with root package name */
        public List<Fragment> f42323a;

        public b(FragmentManager fragmentManager, List<Fragment> list) {
            super(fragmentManager, 1);
            this.f42323a = list;
        }

        public int getCount() {
            return this.f42323a.size();
        }

        public Fragment getItem(int i11) {
            return this.f42323a.get(i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Sh(int i11) {
        this.f42320o.setCurrentItem(i11);
        SP.q(Qh(), i11);
    }

    public int Fh() {
        return R$layout.fragment_asset_future;
    }

    public void Jh() {
        Fragment item = this.f42319n.getItem(this.f42320o.getCurrentItem());
        if (item instanceof AssetSubTypeBaseFragment) {
            ((AssetSubTypeBaseFragment) item).Vh();
        }
    }

    public abstract List<Fragment> Oh();

    public abstract int Ph(AssetSummaryAccountType assetSummaryAccountType);

    public final String Qh() {
        return "asset_sub_type_select_index_" + getClass().getName();
    }

    public abstract List<String> Rh();

    public final void Th(AssetSummaryAccountType assetSummaryAccountType) {
        int Ph = Ph(assetSummaryAccountType);
        if (Ph >= 0) {
            this.f42321p.onItemClick(Ph);
        }
    }

    public void initViews() {
        super.initViews();
        this.f42320o = (ViewPager) this.f67460i.b(R$id.f16938vp);
        b bVar = new b(getChildFragmentManager(), Oh());
        this.f42319n = bVar;
        this.f42320o.setAdapter(bVar);
        this.f42320o.setOffscreenPageLimit(4);
        this.f42321p = (TabItemLayoutIndicator) this.f67460i.b(R$id.tab_item_layout);
        List<String> Rh = Rh();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < Rh.size()) {
            TabItemLayoutData tabItemLayoutData = new TabItemLayoutData();
            tabItemLayoutData.setMiddleTabText(Rh.get(i11));
            tabItemLayoutData.setCheck(i11 == 0);
            arrayList.add(tabItemLayoutData);
            i11++;
        }
        this.f42321p.setTabItemLayoutData(arrayList);
        this.f42321p.setItemClickCallBack(new g(this));
        this.f42320o.addOnPageChangeListener(new a());
        AssetSummaryAccountType assetSummaryAccountType = f42318q;
        if (assetSummaryAccountType != null) {
            Th(assetSummaryAccountType);
            return;
        }
        int e11 = SP.e(Qh(), 0);
        if (e11 >= 0 && e11 < Rh.size()) {
            this.f42321p.u(e11);
            this.f42320o.setCurrentItem(e11, false);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onNavigationEvent(th.a aVar) {
        AssetSummaryAccountType c11 = aVar.c();
        if (c11 != null) {
            Th(c11);
        }
    }
}
