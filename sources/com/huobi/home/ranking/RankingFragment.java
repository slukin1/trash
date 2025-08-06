package com.huobi.home.ranking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huobi.index.ui.BaseRankingFragment;
import pro.huobi.R;
import rj.b;

public class RankingFragment extends BaseRankingFragment {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f72507b;

    /* renamed from: c  reason: collision with root package name */
    public View f72508c = null;

    /* renamed from: d  reason: collision with root package name */
    public b f72509d;

    /* renamed from: e  reason: collision with root package name */
    public int f72510e;

    /* renamed from: f  reason: collision with root package name */
    public String f72511f;

    /* renamed from: g  reason: collision with root package name */
    public String f72512g;

    public View getRootView() {
        return this.f72507b;
    }

    public final void initView(View view) {
        this.f72507b = (FrameLayout) view.findViewById(R.id.rankingListRoot);
        View sh2 = sh();
        this.f72508c = sh2;
        this.f72507b.addView(sh2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home_ranking_view, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
    }

    public int ph() {
        return this.f72510e;
    }

    public int qh() {
        return 0;
    }

    public String rh() {
        return this.f72512g;
    }

    public final View sh() {
        b bVar = this.f72509d;
        return bVar.D(this.f72511f + ".xml", getContext());
    }
}
