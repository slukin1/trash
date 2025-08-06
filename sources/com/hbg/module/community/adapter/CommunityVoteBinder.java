package com.hbg.module.community.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.hbg.lib.network.hbg.core.bean.CommonPkData;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import lc.y3;

public final class CommunityVoteBinder extends ItemViewBinder<CommonPkData, ItemViewBinder.a<y3>> {
    /* renamed from: q */
    public void c(ItemViewBinder.a<y3> aVar, CommonPkData commonPkData, boolean z11, int i11) {
        aVar.e().B.setView(commonPkData);
        aVar.e().B.o(j(), k.a(k(), l()));
    }

    /* renamed from: r */
    public ItemViewBinder.a<y3> m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ItemViewBinder.a<>(y3.K(layoutInflater, viewGroup, false));
    }
}
