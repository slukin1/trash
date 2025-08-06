package com.huobi.asset2.index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.v;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.ArrayList;
import java.util.List;
import wh.k1;
import wh.l1;
import wh.m1;

public abstract class BaseAssetTabFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public TabLayout f42584b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager2 f42585c;

    /* renamed from: d  reason: collision with root package name */
    public TabLayoutMediator f42586d;

    /* renamed from: e  reason: collision with root package name */
    public hk.a f42587e;

    /* renamed from: f  reason: collision with root package name */
    public View f42588f;

    /* renamed from: g  reason: collision with root package name */
    public View f42589g;

    /* renamed from: h  reason: collision with root package name */
    public View f42590h;

    /* renamed from: i  reason: collision with root package name */
    public int f42591i = 0;

    public class a extends FragmentStateAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f42592b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FragmentManager fragmentManager, Lifecycle lifecycle, ArrayList arrayList) {
            super(fragmentManager, lifecycle);
            this.f42592b = arrayList;
        }

        public Fragment createFragment(int i11) {
            return (Fragment) this.f42592b.get(i11);
        }

        public int getItemCount() {
            return this.f42592b.size();
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
            BaseAssetTabFragment baseAssetTabFragment = BaseAssetTabFragment.this;
            baseAssetTabFragment.f42591i = i11;
            baseAssetTabFragment.zh(i11);
        }
    }

    public static /* synthetic */ void wh(TabLayout tabLayout) {
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        for (int i11 = 0; i11 < linearLayout.getChildCount(); i11++) {
            View childAt = linearLayout.getChildAt(i11);
            int a11 = v.a(8.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (i11 == 0) {
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = a11;
            }
            layoutParams.rightMargin = 0;
            childAt.setLayoutParams(layoutParams);
            childAt.invalidate();
        }
    }

    public void Ah(hk.a aVar) {
        this.f42587e = aVar;
    }

    public final void Bh(TabLayout tabLayout) {
        tabLayout.post(new m1(tabLayout));
    }

    public void Wg() {
        List<String> th2 = th();
        ArrayList sh2 = sh();
        if (!CollectionsUtils.b(th2) && !CollectionsUtils.b(sh2)) {
            for (String text : th2) {
                TabLayout.Tab newTab = this.f42584b.newTab();
                newTab.setText((CharSequence) text);
                this.f42584b.addTab(newTab);
            }
            this.f42585c.setAdapter(new a(getChildFragmentManager(), getLifecycle(), sh2));
            this.f42585c.registerOnPageChangeCallback(new b());
            TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(this.f42584b, this.f42585c, true, false, new l1(th2));
            this.f42586d = tabLayoutMediator;
            tabLayoutMediator.attach();
        }
    }

    public void initViews() {
        this.f42584b = (TabLayout) this.f42588f.findViewById(R$id.asset_child_tab_layout);
        this.f42585c = (ViewPager2) this.f42588f.findViewById(R$id.asset_child_pager_layout);
        this.f42589g = this.f42588f.findViewById(R$id.tab_right_img);
        this.f42590h = this.f42588f.findViewById(R$id.tab_right_img_1);
        this.f42585c.setSaveEnabled(false);
        this.f42585c.setUserInputEnabled(false);
        Wg();
        Bh(this.f42584b);
        this.f42589g.setVisibility(vh());
        yh();
        rh();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f42588f = layoutInflater.inflate(R$layout.fragment_asset_base_tab_layout, viewGroup, false);
        initViews();
        return this.f42588f;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f42586d.detach();
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

    public final void rh() {
        this.f42589g.setOnClickListener(new k1(this));
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public abstract <T extends Fragment> ArrayList<T> sh();

    public abstract List<String> th();

    public abstract void uh(View view);

    public abstract int vh();

    public void yh() {
    }

    public abstract void zh(int i11);
}
