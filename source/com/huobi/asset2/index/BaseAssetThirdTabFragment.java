package com.huobi.asset2.index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.ArrayList;
import java.util.List;
import wh.n1;

public abstract class BaseAssetThirdTabFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public TabLayout f42595b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager2 f42596c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f42597d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f42598e;

    /* renamed from: f  reason: collision with root package name */
    public TabLayoutMediator f42599f;

    /* renamed from: g  reason: collision with root package name */
    public hk.a f42600g;

    /* renamed from: h  reason: collision with root package name */
    public View f42601h;

    public class a extends FragmentStateAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f42602b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FragmentManager fragmentManager, Lifecycle lifecycle, ArrayList arrayList) {
            super(fragmentManager, lifecycle);
            this.f42602b = arrayList;
        }

        public Fragment createFragment(int i11) {
            return (Fragment) this.f42602b.get(i11);
        }

        public int getItemCount() {
            return this.f42602b.size();
        }
    }

    public class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
        }

        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
        }
    }

    public void Wg() {
        List<String> rh2 = rh();
        ArrayList qh2 = qh();
        if (!CollectionsUtils.b(rh2) && !CollectionsUtils.b(qh2)) {
            for (String text : rh2) {
                TabLayout.Tab newTab = this.f42595b.newTab();
                newTab.setText((CharSequence) text);
                this.f42595b.addTab(newTab);
            }
            this.f42596c.setAdapter(new a(getChildFragmentManager(), getLifecycle(), qh2));
            this.f42596c.registerOnPageChangeCallback(new b());
            TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(this.f42595b, this.f42596c, true, false, new n1(rh2));
            this.f42599f = tabLayoutMediator;
            tabLayoutMediator.attach();
        }
    }

    public void initViews() {
        this.f42595b = (TabLayout) this.f42601h.findViewById(R$id.asset_child_tab_layout);
        ViewPager2 viewPager2 = (ViewPager2) this.f42601h.findViewById(R$id.asset_child_pager_layout);
        this.f42596c = viewPager2;
        viewPager2.setSaveEnabled(false);
        this.f42596c.setUserInputEnabled(false);
        ImageView imageView = (ImageView) this.f42601h.findViewById(R$id.tab_right_img);
        this.f42598e = imageView;
        imageView.setVisibility(8);
        this.f42597d = (FrameLayout) this.f42601h.findViewById(R$id.asset_child_tab_header_layout);
        Wg();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f42601h = layoutInflater.inflate(R$layout.fragment_asset_third_tab_layout, viewGroup, false);
        initViews();
        return this.f42601h;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f42599f.detach();
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public abstract <T extends Fragment> ArrayList<T> qh();

    public List<String> rh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R$string.n_asset_all_balances));
        arrayList.add(getString(R$string.n_trade_hold));
        return arrayList;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void th(hk.a aVar) {
        this.f42600g = aVar;
    }
}
