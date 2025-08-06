package com.huobi.index.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.h0;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.widgets.adapter.ViewHandlerFactory;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.index.bean.RankingListData;
import com.huobi.index.viewhandler.RankingNewSymbolItemHandler;
import java.util.List;
import java.util.Map;
import pro.huobi.R;
import rj.b;
import v9.a;
import v9.c;

public class RankingNewSymbolView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f73836b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73837c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f73838d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f73839e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f73840f;

    /* renamed from: g  reason: collision with root package name */
    public NestedScrollView f73841g;

    /* renamed from: h  reason: collision with root package name */
    public RankingWaitNewSymbolView f73842h;

    /* renamed from: i  reason: collision with root package name */
    public View f73843i;

    /* renamed from: j  reason: collision with root package name */
    public b f73844j;

    /* renamed from: k  reason: collision with root package name */
    public RankingListData f73845k;

    public class RankingWaitNewSymbolView extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        public TextView f73846b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f73847c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f73848d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f73849e;

        /* renamed from: f  reason: collision with root package name */
        public EasyRecyclerView<RankingListData.NewSymbolItemData> f73850f;

        /* renamed from: g  reason: collision with root package name */
        public StableLinearLayoutManager f73851g;

        /* renamed from: h  reason: collision with root package name */
        public RankingListData.NewSymbolData f73852h;

        public RankingWaitNewSymbolView(Context context) {
            super(context);
            c(context);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(int i11, a aVar) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f73850f.findViewHolderForAdapterPosition(i11);
            if (findViewHolderForAdapterPosition == null) {
                aVar.notifyItemChanged(i11);
            } else {
                aVar.onBindViewHolder((c) findViewHolderForAdapterPosition, i11);
            }
        }

        public final void b() {
            if (this.f73852h != null) {
                if (this.f73851g == null) {
                    this.f73851g = new StableLinearLayoutManager(getContext(), 1, false);
                }
                this.f73850f.setLayoutManager(this.f73851g);
                this.f73849e.setVisibility(0);
            }
        }

        public final void c(Context context) {
            LayoutInflater.from(context).inflate(R.layout.ranking_wait_new_symbol_view, this);
            this.f73850f = (EasyRecyclerView) findViewById(R.id.wait_new_symbol_ranking_list);
            this.f73849e = (RelativeLayout) findViewById(R.id.wait_rl_new_symbol_default_title_layout);
            this.f73846b = (TextView) findViewById(R.id.wait_new_symbol_left_text);
            this.f73848d = (TextView) findViewById(R.id.wait_new_symbol_right_text);
            this.f73847c = (TextView) findViewById(R.id.wait_new_symbol_middle_text);
            this.f73851g = new StableLinearLayoutManager(context, 1, false);
            this.f73850f.f(true);
            this.f73850f.setNestedScrollingEnabled(false);
            this.f73850f.setHasFixedSize(true);
            this.f73850f.setItemViewCacheSize(10);
            this.f73850f.setLayoutManager(this.f73851g);
            b();
            RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
            recycledViewPool.m(((RankingNewSymbolItemHandler) ViewHandlerFactory.a(RankingNewSymbolItemHandler.class.getName())).getClass().hashCode(), 50);
            this.f73850f.setRecycledViewPool(recycledViewPool);
            this.f73850f.getItemAnimator().setChangeDuration(0);
            if (this.f73850f.getItemAnimator() instanceof SimpleItemAnimator) {
                ((SimpleItemAnimator) this.f73850f.getItemAnimator()).setSupportsChangeAnimations(false);
            }
            h0.N0(this.f73850f, false);
        }

        public void e() {
            RankingListData.NewSymbolData newSymbolData = this.f73852h;
            setVisibility(newSymbolData != null && newSymbolData.getUntradeableData() != null && this.f73852h.getUntradeableData().getData() != null && !this.f73852h.getUntradeableData().getData().isEmpty() ? 0 : 8);
            b();
            List<RankingListData.NewSymbolItemData> data = this.f73852h.getUntradeableData().getData();
            List<RankingListData.NewSymbolItemData> dataList = this.f73850f.getDataList();
            a adapter = this.f73850f.getAdapter();
            if (adapter == null || dataList == null || data == null || dataList.size() != data.size()) {
                this.f73850f.setData(data);
                return;
            }
            adapter.i(data);
            long j11 = 0;
            for (int i11 = 0; i11 < dataList.size(); i11++) {
                if (!RankingListData.NewSymbolItemData.isSame(dataList.get(i11), data.get(i11))) {
                    this.f73850f.postDelayed(new u1(this, i11, adapter), j11);
                    j11 += 60;
                }
            }
        }

        public void f() {
            RankingListData.NewSymbolData newSymbolData;
            if (this.f73850f != null && (newSymbolData = this.f73852h) != null && newSymbolData.getUntradeableData() != null && this.f73852h.getUntradeableData().getSectionHeader() != null && this.f73852h.getUntradeableData().getSectionHeader().size() >= 3) {
                if (this.f73852h.getUntradeableData().getData().size() > 0) {
                    setVisibility(0);
                } else {
                    setVisibility(8);
                }
                b();
                this.f73850f.setData(this.f73852h.getUntradeableData().getData());
                Map<String, String> sectionHeader = this.f73852h.getUntradeableData().getSectionHeader();
                this.f73846b.setText(sectionHeader.get("leftTitle"));
                this.f73847c.setText(sectionHeader.get("middleTitle"));
                this.f73848d.setText(sectionHeader.get("rightTitle"));
            }
        }

        public void setNewSymbolData(RankingListData.NewSymbolData newSymbolData) {
            this.f73852h = newSymbolData;
        }
    }

    public RankingNewSymbolView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.ranking_new_symbol_view, this);
        this.f73840f = (FrameLayout) findViewById(R.id.new_symbol_view);
        this.f73841g = (NestedScrollView) findViewById(R.id.new_symbol_ranking_list);
        this.f73839e = (RelativeLayout) findViewById(R.id.rl_default_title_layout);
        this.f73836b = (TextView) findViewById(R.id.left_text);
        this.f73838d = (TextView) findViewById(R.id.right_text);
        this.f73837c = (TextView) findViewById(R.id.middle_text);
    }

    public void b() {
        RankingWaitNewSymbolView rankingWaitNewSymbolView = this.f73842h;
        if (rankingWaitNewSymbolView != null) {
            rankingWaitNewSymbolView.setNewSymbolData(this.f73845k.getNewSymbolData());
            this.f73842h.e();
        }
        if (this.f73845k.getNewSymbolData().getTradeableData() == null || this.f73845k.getNewSymbolData().getTradeableData().isEmpty()) {
            this.f73839e.setVisibility(8);
            View view = this.f73843i;
            if (view == null) {
                this.f73841g.removeView(view);
                return;
            }
            return;
        }
        Map<String, String> sectionHeader = this.f73845k.getNewSymbolData().getTradeableData().getSectionHeader();
        this.f73839e.setVisibility(0);
        this.f73836b.setText(sectionHeader.get("leftTitle"));
        this.f73837c.setText(sectionHeader.get("middleTitle"));
        this.f73838d.setText(sectionHeader.get("rightTitle"));
        if (this.f73843i == null) {
            View E = this.f73844j.E("new_symbol_ranking_list.xml", getContext(), false, (JSONObject) null);
            this.f73843i = E;
            this.f73841g.addView(E);
        }
    }

    public void c() {
        RankingListData rankingListData = this.f73845k;
        if (rankingListData != null || rankingListData.getNewSymbolData() != null) {
            RankingWaitNewSymbolView rankingWaitNewSymbolView = new RankingWaitNewSymbolView(getContext());
            this.f73842h = rankingWaitNewSymbolView;
            rankingWaitNewSymbolView.setNewSymbolData(this.f73845k.getNewSymbolData());
            this.f73842h.f();
            this.f73840f.addView(this.f73842h);
            if (this.f73845k.getNewSymbolData().getTradeableData() == null || this.f73845k.getNewSymbolData().getTradeableData().isEmpty()) {
                this.f73839e.setVisibility(8);
                return;
            }
            Map<String, String> sectionHeader = this.f73845k.getNewSymbolData().getTradeableData().getSectionHeader();
            this.f73839e.setVisibility(0);
            this.f73836b.setText(sectionHeader.get("leftTitle"));
            this.f73837c.setText(sectionHeader.get("middleTitle"));
            this.f73838d.setText(sectionHeader.get("rightTitle"));
            View E = this.f73844j.E("new_symbol_ranking_list.xml", getContext(), false, (JSONObject) null);
            this.f73843i = E;
            this.f73841g.addView(E);
        }
    }

    public void setEdgeEngine(b bVar) {
        this.f73844j = bVar;
    }

    public void setRankingListData(RankingListData rankingListData) {
        this.f73845k = rankingListData;
    }

    public RankingNewSymbolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RankingNewSymbolView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
