package com.hbg.module.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import d10.a;
import kotlin.Unit;
import lc.u2;

public final class CommunityRecommendFollowBinder extends ItemViewBinder<CommunityFeedInfo.ListBean, ItemViewBinder.a<u2>> {

    /* renamed from: e  reason: collision with root package name */
    public a<Unit> f17089e;

    /* renamed from: f  reason: collision with root package name */
    public a<Unit> f17090f;

    /* renamed from: q */
    public void c(ItemViewBinder.a<u2> aVar, CommunityFeedInfo.ListBean listBean, boolean z11, int i11) {
        Context context = aVar.itemView.getContext();
        aVar.e().B.setLayoutManager(new LinearLayoutManager(context));
        AttentionRecommendCellAdapter attentionRecommendCellAdapter = new AttentionRecommendCellAdapter((FragmentActivity) context);
        attentionRecommendCellAdapter.g().clear();
        attentionRecommendCellAdapter.g().addAll(listBean.getFocusList());
        aVar.e().B.setAdapter(attentionRecommendCellAdapter);
        attentionRecommendCellAdapter.s(this.f17089e);
        attentionRecommendCellAdapter.r(this.f17090f);
    }

    /* renamed from: r */
    public ItemViewBinder.a<u2> m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ItemViewBinder.a<>(u2.K(layoutInflater, viewGroup, false));
    }

    public final void s(a<Unit> aVar) {
        this.f17090f = aVar;
    }

    public final void t(a<Unit> aVar) {
        this.f17089e = aVar;
    }
}
