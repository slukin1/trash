package com.huobi.index.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.h0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.hbg.core.bean.RankLabelBean;
import com.hbg.lib.network.hbg.core.bean.RankList;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.ViewHandlerFactory;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.index.bean.RankDynamicItem;
import com.huobi.index.viewhandler.RankDynamicItemHandler;
import java.util.List;
import pro.huobi.R;
import v9.a;
import v9.c;
import yl.t;

public class NewSymbolView extends LinearLayout {

    /* renamed from: j  reason: collision with root package name */
    public static RankList f73792j;

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<RankDynamicItem> f73793b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73794c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f73795d;

    /* renamed from: e  reason: collision with root package name */
    public List<RankDynamicItem> f73796e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f73797f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f73798g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout f73799h;

    /* renamed from: i  reason: collision with root package name */
    public StableLinearLayoutManager f73800i;

    public NewSymbolView(Context context) {
        super(context);
        d(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(int i11, a aVar) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f73793b.findViewHolderForAdapterPosition(i11);
        if (findViewHolderForAdapterPosition == null) {
            aVar.notifyItemChanged(i11);
        } else {
            aVar.onBindViewHolder((c) findViewHolderForAdapterPosition, i11);
        }
    }

    public void b() {
        RankList rankList;
        if (this.f73793b != null && (rankList = f73792j) != null && rankList.getTitleMap() != null && f73792j.getTitleMap().get("untradeable") != null && f73792j.getTitleMap().get("untradeable").size() >= 3) {
            List<RankDynamicItem> d11 = t.d(f73792j);
            this.f73796e = d11;
            if (d11.size() > 0) {
                List<RankDynamicItem> list = this.f73796e;
                List<RankDynamicItem> subList = list.subList(0, Math.min(4, list.size()));
                this.f73796e = subList;
                for (RankDynamicItem rankDynamicItem : subList) {
                    rankDynamicItem.f73218m = true;
                }
                setVisibility(0);
            } else {
                setVisibility(8);
            }
            c(false);
            List<RankDynamicItem> dataList = this.f73793b.getDataList();
            a adapter = this.f73793b.getAdapter();
            if (adapter == null || dataList == null || this.f73796e == null || dataList.size() != this.f73796e.size()) {
                this.f73793b.setData(this.f73796e);
            } else {
                adapter.i(this.f73796e);
                long j11 = 0;
                for (int i11 = 0; i11 < dataList.size(); i11++) {
                    if (!IndexRankingFragment.Dh(getContext(), dataList.get(i11), this.f73796e.get(i11))) {
                        this.f73793b.postDelayed(new n1(this, i11, adapter), j11);
                        j11 += 60;
                    }
                }
            }
            if (this.f73796e.size() == 0) {
                this.f73797f.setVisibility(8);
                this.f73799h.i();
            } else {
                if (t.r(f73792j.getType(), f73792j.isScreen())) {
                    this.f73797f.setVisibility(8);
                } else {
                    this.f73797f.setVisibility(0);
                }
                this.f73799h.g();
            }
            List list2 = f73792j.getTitleMap().get("untradeable");
            this.f73798g.setText(((RankLabelBean) list2.get(0)).getTitleName());
            String titleName = ((RankLabelBean) list2.get(1)).getTitleName();
            if (((RankLabelBean) list2.get(1)).getTitleProperty() == 4) {
                String y11 = LegalCurrencyConfigUtil.y();
                titleName = titleName + "(" + StringUtils.i(y11) + ")";
            }
            this.f73794c.setText(titleName);
            String titleName2 = ((RankLabelBean) list2.get(2)).getTitleName();
            if (((RankLabelBean) list2.get(2)).getTitleProperty() == 6) {
                String y12 = LegalCurrencyConfigUtil.y();
                titleName2 = titleName2 + "(" + StringUtils.i(y12) + ")";
            }
            this.f73795d.setText(titleName2);
        }
    }

    public final void c(boolean z11) {
        if (f73792j == null) {
            Log.d("NewSymbolView", "initLayoutManager--rankList is null:" + z11);
            return;
        }
        if (this.f73800i == null) {
            this.f73800i = new StableLinearLayoutManager(getContext(), 1, false);
        }
        this.f73793b.setLayoutManager(this.f73800i);
        this.f73797f.setVisibility(0);
    }

    public final void d(Context context) {
        LayoutInflater.from(context).inflate(R.layout.index_ranking_list_new_symbol_view, this);
        this.f73793b = (EasyRecyclerView) findViewById(R.id.new_symbol_ranking_list);
        this.f73797f = (RelativeLayout) findViewById(R.id.rl_new_symbol_default_title_layout);
        this.f73798g = (TextView) findViewById(R.id.new_symbol_left_text);
        this.f73795d = (TextView) findViewById(R.id.new_symbol_right_text);
        this.f73794c = (TextView) findViewById(R.id.new_symbol_middle_text);
        this.f73799h = (LoadingLayout) findViewById(R.id.new_symbol_ranking_list_loading);
        this.f73800i = new StableLinearLayoutManager(context, 1, false);
        this.f73793b.f(true);
        this.f73793b.setNestedScrollingEnabled(false);
        this.f73793b.setHasFixedSize(true);
        this.f73793b.setItemViewCacheSize(10);
        this.f73793b.setLayoutManager(this.f73800i);
        c(true);
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.m(((RankDynamicItemHandler) ViewHandlerFactory.a(RankDynamicItemHandler.class.getName())).getClass().hashCode(), 50);
        this.f73793b.setRecycledViewPool(recycledViewPool);
        this.f73793b.getItemAnimator().setChangeDuration(0);
        if (this.f73793b.getItemAnimator() instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) this.f73793b.getItemAnimator()).setSupportsChangeAnimations(false);
        }
        h0.N0(this.f73793b, false);
    }

    public int getNewSymbolViewSize() {
        List<RankDynamicItem> list = this.f73796e;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f73796e.size() + 1;
    }

    public void setRankList(RankList rankList) {
        f73792j = rankList;
    }

    public NewSymbolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    public NewSymbolView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        d(context);
    }
}
