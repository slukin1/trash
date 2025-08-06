package com.hbg.module.community.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import com.youth.banner.Banner;
import java.util.List;
import lc.q4;

public final class b extends ItemViewBinder<List<? extends LiveBannerData>, ItemViewBinder.a<q4>> {

    /* renamed from: e  reason: collision with root package name */
    public final int f17180e;

    /* renamed from: f  reason: collision with root package name */
    public final LifecycleOwner f17181f;

    public b(int i11, LifecycleOwner lifecycleOwner) {
        this.f17180e = i11;
        this.f17181f = lifecycleOwner;
    }

    /* renamed from: q */
    public void c(ItemViewBinder.a<q4> aVar, List<? extends LiveBannerData> list, boolean z11, int i11) {
        Banner banner = aVar.e().B;
        qc.b.b(banner, banner.getContext(), this.f17180e, this.f17181f, list);
    }

    /* renamed from: r */
    public ItemViewBinder.a<q4> m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ItemViewBinder.a<>(q4.K(layoutInflater, viewGroup, false));
    }
}
