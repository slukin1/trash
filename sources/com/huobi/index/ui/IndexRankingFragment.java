package com.huobi.index.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.h0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RankList;
import com.hbg.lib.network.hbg.core.bean.RankListItemBean;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.ViewHandlerFactory;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.custom.decoration.WrapContentGridLayoutManager;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.index.bean.RankDynamicItem;
import com.huobi.index.presenter.IndexPresenter;
import com.huobi.index.presenter.g;
import com.huobi.index.ui.IndexRankingFragmentDecorator;
import com.huobi.index.viewhandler.RankDynamicItemHandler;
import com.huobi.trade.helper.f0;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import yl.t;

public class IndexRankingFragment extends BaseRankingFragment {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f73747b;

    /* renamed from: c  reason: collision with root package name */
    public NewSymbolView f73748c;

    /* renamed from: d  reason: collision with root package name */
    public EasyRecyclerView<RankDynamicItem> f73749d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f73750e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f73751f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f73752g;

    /* renamed from: h  reason: collision with root package name */
    public IndexPresenter.s0 f73753h;

    /* renamed from: i  reason: collision with root package name */
    public List<RankDynamicItem> f73754i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f73755j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f73756k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f73757l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingLayout f73758m;

    /* renamed from: n  reason: collision with root package name */
    public RelativeLayout f73759n;

    /* renamed from: o  reason: collision with root package name */
    public RankList f73760o;

    /* renamed from: p  reason: collision with root package name */
    public int f73761p;

    /* renamed from: q  reason: collision with root package name */
    public t.a f73762q;

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f73763r;

    /* renamed from: s  reason: collision with root package name */
    public StableLinearLayoutManager f73764s;

    /* renamed from: t  reason: collision with root package name */
    public WrapContentGridLayoutManager f73765t;

    /* renamed from: u  reason: collision with root package name */
    public HashMap<Integer, String> f73766u = new HashMap<>();

    /* renamed from: v  reason: collision with root package name */
    public BottomMenuFragment f73767v;

    /* renamed from: w  reason: collision with root package name */
    public List<MenuItem> f73768w = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    public MenuItemOnClickListener f73769x = new a();

    /* renamed from: y  reason: collision with root package name */
    public boolean f73770y = false;

    public class a implements MenuItemOnClickListener {
        public a() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            IndexRankingFragment.this.f73767v.dismiss();
            EventBus.d().k(new IndexRankingFragmentDecorator.c(i11));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            Log.d("IndexRankingFragment", "go to add");
            if (IndexRankingFragment.this.getActivity() != null) {
                MarketModuleConfig.a().h(IndexRankingFragment.this.getActivity());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c extends RecyclerView.ItemDecoration {
        public c() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int i11;
            int i12;
            super.getItemOffsets(rect, view, recyclerView, state);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int a11 = PixelUtils.a(8.0f);
            if (childAdapterPosition % 2 != 0) {
                i12 = PixelUtils.a(4.0f);
                i11 = PixelUtils.a(16.0f);
            } else {
                i12 = PixelUtils.a(16.0f);
                i11 = PixelUtils.a(4.0f);
            }
            rect.set(i12, 0, i11, a11);
        }
    }

    public static boolean Dh(Context context, RankDynamicItem rankDynamicItem, RankDynamicItem rankDynamicItem2) {
        if (rankDynamicItem == null || rankDynamicItem2 == null || rankDynamicItem.j() != rankDynamicItem2.j() || rankDynamicItem.l() != rankDynamicItem2.l() || rankDynamicItem.i() != rankDynamicItem2.i() || !Objects.equals(rankDynamicItem.getBaseCurrencyDisplayName(), rankDynamicItem2.getBaseCurrencyDisplayName()) || !Objects.equals(rankDynamicItem.f(), rankDynamicItem2.f()) || !Objects.equals(rankDynamicItem.e(), rankDynamicItem2.e()) || rankDynamicItem.k() != rankDynamicItem2.k() || !Objects.equals(rankDynamicItem.d(), rankDynamicItem2.d())) {
            return false;
        }
        g.b c11 = rankDynamicItem.c();
        g.b c12 = rankDynamicItem2.c();
        if (c11 == null && c12 != null) {
            return false;
        }
        if (c11 != null && c12 == null) {
            return false;
        }
        if (c11 == null && c12 == null) {
            a1 v11 = a1.v();
            String symbol = rankDynamicItem.g().getSymbol();
            TradeType tradeType = TradeType.PRO;
            SymbolBean J = v11.J(symbol, tradeType);
            SymbolBean J2 = a1.v().J(rankDynamicItem2.g().getSymbol(), tradeType);
            if (J == null && J2 != null) {
                return false;
            }
            if (J != null && J2 == null) {
                return false;
            }
            if (!(J == null || J2 == null || (J.isEtpTag() == J2.isEtpTag() && Objects.equals(f0.d(context, J.getDirection(), J.getEtpLeverageRatio()), f0.d(context, J2.getDirection(), J2.getEtpLeverageRatio())) && Objects.equals(J.getDirection(), J2.getDirection())))) {
                return false;
            }
        }
        RankListItemBean g11 = rankDynamicItem.g();
        RankListItemBean g12 = rankDynamicItem2.g();
        if (g11 == null && g12 != null) {
            return false;
        }
        if (g11 != null && g12 == null) {
            return false;
        }
        if ((g11 == null || g12 == null || (g11.getFlag() == g12.getFlag() && Objects.equals(g11.getFlagURL(), g12.getFlagURL()) && g11.getBeginTradeDate() == g12.getBeginTradeDate() && Objects.equals(g11.getUpAndDown(), g12.getUpAndDown()) && g11.getBeginTradePrice() == g12.getBeginTradePrice() && g11.getBeginTradeUpAndDown() == g12.getBeginTradeUpAndDown() && g11.getContractBusinessType() == g12.getContractBusinessType() && Objects.equals(g11.getContractShowSymbol(), g12.getContractShowSymbol()) && Objects.equals(g11.getContractBusinessTypeTag(), g12.getContractBusinessTypeTag()) && Objects.equals(g11.getTotalProfitRate(), g12.getTotalProfitRate()) && Objects.equals(g11.getTotalProfitAmount(), g12.getTotalProfitAmount()) && Objects.equals(g11.getJumpUrl(), g12.getJumpUrl()) && Objects.equals(g11.getNftDid(), g12.getNftDid()) && Objects.equals(g11.getNftImg(), g12.getNftImg()) && Objects.equals(g11.getNewProfitAmount(), g12.getNewProfitAmount()) && g11.getWinCount() == g12.getWinCount())) && Objects.equals(rankDynamicItem.h(), rankDynamicItem2.h())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fh(int i11, v9.a aVar) {
        if (!isHidden() && isAdded()) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f73749d.findViewHolderForAdapterPosition(i11);
            if (findViewHolderForAdapterPosition == null) {
                aVar.notifyItemChanged(i11);
            } else {
                aVar.onBindViewHolder((v9.c) findViewHolderForAdapterPosition, i11);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gh(int i11) {
        Log.d("IndexRankingFragment", "amount:" + i11);
        if (i11 == 0) {
            this.f73759n.setClickable(false);
            this.f73759n.setBackgroundColor(getResources().getColor(R.color.home_rank_add_to_favorite_bg_gray_color));
            return;
        }
        this.f73759n.setClickable(true);
        this.f73759n.setBackgroundColor(getResources().getColor(R.color.community_label_background));
    }

    public static /* synthetic */ int Hh(Map.Entry entry, Map.Entry entry2) {
        return ((Integer) entry.getKey()).intValue() - ((Integer) entry2.getKey()).intValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(Object obj) {
        if (getContext() != null) {
            HuobiToastUtil.v(getContext().getString(R.string.market_add_collection_success));
        }
        IndexPresenter.s0 s0Var = this.f73753h;
        if (s0Var != null) {
            s0Var.Q6();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(RankDynamicItemHandler rankDynamicItemHandler, View view) {
        if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.j(R.string.n_no_network);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f73766u = rankDynamicItemHandler.f74419d.get(RankScreenBean.SCREEN_VALUE_SPOT);
        Log.d("IndexRankingFragment", "mParamSymbols:" + this.f73766u);
        HashMap<Integer, String> hashMap = this.f73766u;
        if (hashMap != null || !hashMap.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f73766u.entrySet());
            Collections.sort(arrayList, g1.f73896b);
            new LinkedHashSet();
            ArrayList arrayList2 = new ArrayList();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList2.add((String) ((Map.Entry) arrayList.get(size)).getValue());
            }
            sn.t.j(arrayList2, getContext(), "PRO").compose(RxJavaHelper.t((u6.g) null)).subscribe(EasySubscriber.create(new h1(this)));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        HuobiToastUtil.j(R.string.n_no_network);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kh() {
        this.f73757l.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R.drawable.icon_rank_arrow_down), (Drawable) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Lh() {
        this.f73757l.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R.drawable.icon_rank_arrow_up), (Drawable) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        Rh();
        if (this.f73760o.getScreenListObject().size() > 0) {
            int i11 = 0;
            while (i11 < this.f73768w.size()) {
                this.f73768w.get(i11).setStyle(i11 == this.f73761p ? MenuItem.MenuItemStyle.STRESS : MenuItem.MenuItemStyle.COMMON);
                i11++;
            }
            this.f73767v.show(getActivity().getFragmentManager(), IndexRankingFragmentDecorator.class.getName());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        if (r0.size() >= 3) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c7, code lost:
        if (r0.size() >= 3) goto L_0x0050;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Bh(boolean r14) {
        /*
            r13 = this;
            com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView<com.huobi.index.bean.RankDynamicItem> r0 = r13.f73749d
            if (r0 == 0) goto L_0x0314
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            if (r0 != 0) goto L_0x000a
            goto L_0x0314
        L_0x000a:
            java.util.List r0 = r0.getTitle()
            r1 = 3
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0022
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.List r0 = r0.getTitle()
            int r0 = r0.size()
            if (r0 >= r1) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r0 = r3
            goto L_0x0023
        L_0x0022:
            r0 = r2
        L_0x0023:
            com.hbg.lib.network.hbg.core.bean.RankList r4 = r13.f73760o
            int r4 = r4.getType()
            r5 = 9
            r6 = 0
            r7 = 4
            if (r4 != r7) goto L_0x0056
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.Map r0 = r0.getTitleMap()
            if (r0 == 0) goto L_0x0046
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.Map r0 = r0.getTitleMap()
            java.lang.String r4 = "tradeable"
            java.lang.Object r0 = r0.get(r4)
            java.util.List r0 = (java.util.List) r0
            goto L_0x0047
        L_0x0046:
            r0 = r6
        L_0x0047:
            if (r0 == 0) goto L_0x0053
            int r0 = r0.size()
            if (r0 >= r1) goto L_0x0050
            goto L_0x0053
        L_0x0050:
            r0 = r3
            goto L_0x00ca
        L_0x0053:
            r0 = r2
            goto L_0x00ca
        L_0x0056:
            com.hbg.lib.network.hbg.core.bean.RankList r4 = r13.f73760o
            int r4 = r4.getType()
            if (r4 != r5) goto L_0x00ca
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.List r0 = r0.getScreenListObject()
            if (r0 == 0) goto L_0x009d
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.List r0 = r0.getScreenListObject()
            int r0 = r0.size()
            int r4 = r13.f73761p
            if (r0 <= r4) goto L_0x009d
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.Map r0 = r0.getTitleMap()
            if (r0 == 0) goto L_0x009b
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.Map r0 = r0.getTitleMap()
            com.hbg.lib.network.hbg.core.bean.RankList r4 = r13.f73760o
            java.util.List r4 = r4.getScreenListObject()
            int r8 = r13.f73761p
            java.lang.Object r4 = r4.get(r8)
            com.hbg.lib.network.hbg.core.bean.RankScreenBean r4 = (com.hbg.lib.network.hbg.core.bean.RankScreenBean) r4
            java.lang.String r4 = r4.getScreenValue()
            java.lang.Object r0 = r0.get(r4)
            java.util.List r0 = (java.util.List) r0
            goto L_0x00c1
        L_0x009b:
            r0 = r6
            goto L_0x00c1
        L_0x009d:
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.Map r0 = r0.getTitleMap()
            if (r0 == 0) goto L_0x009b
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.Map r0 = r0.getTitleMap()
            com.hbg.lib.network.hbg.core.bean.RankList r4 = r13.f73760o
            java.util.Map r4 = r4.getTitleMap()
            java.util.Set r4 = r4.keySet()
            java.lang.Object[] r4 = r4.toArray()
            r4 = r4[r3]
            java.lang.Object r0 = r0.get(r4)
            java.util.List r0 = (java.util.List) r0
        L_0x00c1:
            if (r0 == 0) goto L_0x0053
            int r0 = r0.size()
            if (r0 >= r1) goto L_0x0050
            goto L_0x0053
        L_0x00ca:
            if (r0 == 0) goto L_0x00cd
            return
        L_0x00cd:
            com.huobi.index.ui.NewSymbolView r0 = r13.f73748c
            if (r0 == 0) goto L_0x00db
            r0.b()
            com.huobi.index.ui.NewSymbolView r0 = r13.f73748c
            int r0 = r0.getNewSymbolViewSize()
            goto L_0x00dc
        L_0x00db:
            r0 = r3
        L_0x00dc:
            int r1 = r13.f73761p
            com.hbg.lib.network.hbg.core.bean.RankList r4 = r13.f73760o
            yl.t$a r8 = r13.f73762q
            java.util.List r14 = yl.t.e(r14, r1, r4, r8)
            r13.f73754i = r14
            com.hbg.lib.network.hbg.core.bean.RankList r14 = r13.f73760o
            int r14 = r14.getType()
            com.hbg.lib.network.hbg.core.bean.RankList r1 = r13.f73760o
            boolean r1 = r1.isScreen()
            boolean r14 = yl.t.r(r14, r1)
            r1 = 6
            if (r14 == 0) goto L_0x010b
            java.util.List<com.huobi.index.bean.RankDynamicItem> r14 = r13.f73754i
            int r14 = r14.size()
            if (r14 <= r1) goto L_0x010b
            java.util.List<com.huobi.index.bean.RankDynamicItem> r14 = r13.f73754i
            java.util.List r14 = r14.subList(r3, r1)
            r13.f73754i = r14
        L_0x010b:
            com.hbg.lib.network.hbg.core.bean.RankList r14 = r13.f73760o
            int r14 = r14.getType()
            if (r14 != r7) goto L_0x012b
            java.util.List<com.huobi.index.bean.RankDynamicItem> r14 = r13.f73754i
            if (r14 == 0) goto L_0x012b
            int r14 = r14.size()
            int r14 = r14 + r0
            r4 = 10
            if (r14 <= r4) goto L_0x012b
            java.util.List<com.huobi.index.bean.RankDynamicItem> r14 = r13.f73754i
            int r4 = r4 - r0
            java.util.List r14 = r14.subList(r3, r4)
            r13.f73754i = r14
            r14 = r2
            goto L_0x012c
        L_0x012b:
            r14 = r3
        L_0x012c:
            r13.Ch(r3)
            if (r14 == 0) goto L_0x0133
            r13.f73770y = r2
        L_0x0133:
            com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView<com.huobi.index.bean.RankDynamicItem> r14 = r13.f73749d
            java.util.List r14 = r14.getDataList()
            com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView<com.huobi.index.bean.RankDynamicItem> r0 = r13.f73749d
            v9.a r0 = r0.getAdapter()
            if (r0 == 0) goto L_0x018b
            if (r14 == 0) goto L_0x018b
            java.util.List<com.huobi.index.bean.RankDynamicItem> r4 = r13.f73754i
            if (r4 == 0) goto L_0x018b
            int r4 = r14.size()
            java.util.List<com.huobi.index.bean.RankDynamicItem> r8 = r13.f73754i
            int r8 = r8.size()
            if (r4 != r8) goto L_0x018b
            java.util.List<com.huobi.index.bean.RankDynamicItem> r4 = r13.f73754i
            r0.i(r4)
            r8 = 0
            r4 = r3
        L_0x015b:
            int r10 = r14.size()
            if (r4 >= r10) goto L_0x0192
            com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView<com.huobi.index.bean.RankDynamicItem> r10 = r13.f73749d
            android.content.Context r10 = r10.getContext()
            java.lang.Object r11 = r14.get(r4)
            com.huobi.index.bean.RankDynamicItem r11 = (com.huobi.index.bean.RankDynamicItem) r11
            java.util.List<com.huobi.index.bean.RankDynamicItem> r12 = r13.f73754i
            java.lang.Object r12 = r12.get(r4)
            com.huobi.index.bean.RankDynamicItem r12 = (com.huobi.index.bean.RankDynamicItem) r12
            boolean r10 = Dh(r10, r11, r12)
            if (r10 != 0) goto L_0x0188
            com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView<com.huobi.index.bean.RankDynamicItem> r10 = r13.f73749d
            com.huobi.index.ui.f1 r11 = new com.huobi.index.ui.f1
            r11.<init>(r13, r4, r0)
            r10.postDelayed(r11, r8)
            r10 = 60
            long r8 = r8 + r10
        L_0x0188:
            int r4 = r4 + 1
            goto L_0x015b
        L_0x018b:
            com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView<com.huobi.index.bean.RankDynamicItem> r14 = r13.f73749d
            java.util.List<com.huobi.index.bean.RankDynamicItem> r0 = r13.f73754i
            r14.setData(r0)
        L_0x0192:
            java.util.List<com.huobi.index.bean.RankDynamicItem> r14 = r13.f73754i
            int r14 = r14.size()
            r0 = 8
            if (r14 != 0) goto L_0x01e2
            com.hbg.lib.network.hbg.core.bean.RankList r14 = r13.f73760o
            int r14 = r14.getType()
            if (r14 != r5) goto L_0x01cd
            android.content.Context r14 = r13.getContext()
            android.view.LayoutInflater r14 = android.view.LayoutInflater.from(r14)
            r4 = 2131624736(0x7f0e0320, float:1.887666E38)
            android.view.View r14 = r14.inflate(r4, r6)
            r4 = 2131436284(0x7f0b22fc, float:1.8494434E38)
            android.view.View r4 = r14.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            com.huobi.index.ui.IndexRankingFragment$b r6 = new com.huobi.index.ui.IndexRankingFragment$b
            r6.<init>()
            r4.setOnClickListener(r6)
            com.hbg.lib.widgets.LoadingLayout r4 = r13.f73758m
            r4.setEmptyView(r14)
            r13.Qh()
            goto L_0x01d2
        L_0x01cd:
            android.widget.RelativeLayout r14 = r13.f73755j
            r14.setVisibility(r0)
        L_0x01d2:
            android.widget.TextView r14 = r13.f73752g
            r14.setVisibility(r0)
            com.hbg.lib.widgets.LoadingLayout r14 = r13.f73758m
            r14.i()
            android.widget.RelativeLayout r14 = r13.f73759n
            r14.setVisibility(r0)
            goto L_0x0254
        L_0x01e2:
            com.hbg.lib.network.hbg.core.bean.RankList r14 = r13.f73760o
            int r14 = r14.getType()
            com.hbg.lib.network.hbg.core.bean.RankList r4 = r13.f73760o
            boolean r4 = r4.isScreen()
            boolean r14 = yl.t.r(r14, r4)
            if (r14 == 0) goto L_0x0204
            android.widget.TextView r14 = r13.f73752g
            r14.setVisibility(r3)
            android.widget.RelativeLayout r14 = r13.f73755j
            r14.setVisibility(r0)
            android.widget.RelativeLayout r14 = r13.f73759n
            r14.setVisibility(r3)
            goto L_0x020e
        L_0x0204:
            android.widget.TextView r14 = r13.f73752g
            r14.setVisibility(r0)
            android.widget.RelativeLayout r14 = r13.f73755j
            r14.setVisibility(r3)
        L_0x020e:
            android.widget.RelativeLayout r14 = r13.f73755j
            android.view.ViewGroup$LayoutParams r14 = r14.getLayoutParams()
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            int r0 = r0.getType()
            if (r0 != r7) goto L_0x023d
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.lang.String r4 = "untradeable"
            java.util.List r0 = yl.t.c(r0, r4)
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x023d
            android.content.res.Resources r0 = r13.getResources()
            r4 = 2131166164(0x7f0703d4, float:1.7946566E38)
            int r0 = r0.getDimensionPixelSize(r4)
            r14.height = r0
            android.widget.RelativeLayout r0 = r13.f73755j
            r0.setLayoutParams(r14)
            goto L_0x024f
        L_0x023d:
            android.content.res.Resources r0 = r13.getResources()
            r4 = 2131165974(0x7f070316, float:1.794618E38)
            int r0 = r0.getDimensionPixelSize(r4)
            r14.height = r0
            android.widget.RelativeLayout r0 = r13.f73755j
            r0.setLayoutParams(r14)
        L_0x024f:
            com.hbg.lib.widgets.LoadingLayout r14 = r13.f73758m
            r14.g()
        L_0x0254:
            com.hbg.lib.network.hbg.core.bean.RankList r14 = r13.f73760o
            java.util.List r14 = r14.getTitle()
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            int r0 = r0.getType()
            if (r0 != r5) goto L_0x0290
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.List r0 = r0.getScreenListObject()
            if (r0 == 0) goto L_0x029f
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r13.f73760o
            java.util.List r0 = r0.getScreenListObject()
            int r0 = r0.size()
            int r3 = r13.f73761p
            if (r0 <= r3) goto L_0x029f
            android.widget.TextView r0 = r13.f73757l
            com.hbg.lib.network.hbg.core.bean.RankList r3 = r13.f73760o
            java.util.List r3 = r3.getScreenListObject()
            int r4 = r13.f73761p
            java.lang.Object r3 = r3.get(r4)
            com.hbg.lib.network.hbg.core.bean.RankScreenBean r3 = (com.hbg.lib.network.hbg.core.bean.RankScreenBean) r3
            java.lang.String r3 = r3.getScreenTitle()
            r0.setText(r3)
            goto L_0x029f
        L_0x0290:
            android.widget.TextView r0 = r13.f73756k
            java.lang.Object r3 = r14.get(r3)
            com.hbg.lib.network.hbg.core.bean.RankLabelBean r3 = (com.hbg.lib.network.hbg.core.bean.RankLabelBean) r3
            java.lang.String r3 = r3.getTitleName()
            r0.setText(r3)
        L_0x029f:
            java.lang.Object r0 = r14.get(r2)
            com.hbg.lib.network.hbg.core.bean.RankLabelBean r0 = (com.hbg.lib.network.hbg.core.bean.RankLabelBean) r0
            java.lang.String r0 = r0.getTitleName()
            java.lang.Object r2 = r14.get(r2)
            com.hbg.lib.network.hbg.core.bean.RankLabelBean r2 = (com.hbg.lib.network.hbg.core.bean.RankLabelBean) r2
            int r2 = r2.getTitleProperty()
            java.lang.String r3 = ")"
            java.lang.String r4 = "("
            if (r2 != r7) goto L_0x02d6
            java.lang.String r2 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.y()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = com.hbg.lib.common.utils.StringUtils.i(r2)
            r5.append(r0)
            r5.append(r3)
            java.lang.String r0 = r5.toString()
        L_0x02d6:
            android.widget.TextView r2 = r13.f73750e
            r2.setText(r0)
            r0 = 2
            java.lang.Object r2 = r14.get(r0)
            com.hbg.lib.network.hbg.core.bean.RankLabelBean r2 = (com.hbg.lib.network.hbg.core.bean.RankLabelBean) r2
            java.lang.String r2 = r2.getTitleName()
            java.lang.Object r14 = r14.get(r0)
            com.hbg.lib.network.hbg.core.bean.RankLabelBean r14 = (com.hbg.lib.network.hbg.core.bean.RankLabelBean) r14
            int r14 = r14.getTitleProperty()
            if (r14 != r1) goto L_0x030f
            java.lang.String r14 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.y()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r4)
            java.lang.String r14 = com.hbg.lib.common.utils.StringUtils.i(r14)
            r0.append(r14)
            r0.append(r3)
            java.lang.String r2 = r0.toString()
        L_0x030f:
            android.widget.TextView r14 = r13.f73751f
            r14.setText(r2)
        L_0x0314:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.ui.IndexRankingFragment.Bh(boolean):void");
    }

    public final void Ch(boolean z11) {
        List<RankDynamicItem> list;
        RankList rankList = this.f73760o;
        if (rankList == null) {
            Log.d("IndexRankingFragment", "initLayoutManager--rankList is null:" + z11);
        } else if (t.r(rankList.getType(), this.f73760o.isScreen())) {
            if (this.f73765t == null) {
                this.f73765t = new WrapContentGridLayoutManager(getContext(), 2);
            }
            this.f73749d.setLayoutManager(this.f73765t);
            if (z11) {
                this.f73749d.addItemDecoration(new c());
            }
            this.f73759n.setVisibility(0);
            this.f73752g.setVisibility(0);
            this.f73755j.setVisibility(8);
            if (this.f73753h != null) {
                this.f73770y = false;
            }
        } else {
            if (this.f73764s == null) {
                this.f73764s = new StableLinearLayoutManager(getActivity(), 1, false);
            }
            this.f73749d.setLayoutManager(this.f73764s);
            this.f73759n.setVisibility(8);
            this.f73752g.setVisibility(8);
            this.f73755j.setVisibility(0);
            if (this.f73753h != null && (list = this.f73754i) != null) {
                if (list.size() < 10) {
                    this.f73770y = false;
                } else {
                    this.f73770y = true;
                }
            }
        }
    }

    public boolean Eh() {
        return this.f73770y;
    }

    public void Mh(IndexPresenter.s0 s0Var) {
        this.f73753h = s0Var;
    }

    public void Nh(RankList rankList) {
        this.f73760o = rankList;
        Ph(rankList);
    }

    public void Oh(int i11) {
        this.f73761p = i11;
    }

    public final void Ph(RankList rankList) {
        if (rankList == null || rankList.getType() != 4 || t.c(rankList, "untradeable").size() < 0) {
            NewSymbolView newSymbolView = this.f73748c;
            if (newSymbolView != null) {
                newSymbolView.setVisibility(8);
            }
        } else if (this.f73749d != null) {
            NewSymbolView newSymbolView2 = this.f73748c;
            if (newSymbolView2 == null) {
                this.f73748c = new NewSymbolView(this.f73749d.getContext());
                this.f73747b.removeAllViews();
                this.f73747b.addView(this.f73748c, new ViewGroup.LayoutParams(-1, -2));
            } else {
                newSymbolView2.setVisibility(0);
            }
            this.f73748c.setRankList(rankList);
        }
    }

    public final void Qh() {
        this.f73755j.setVisibility(0);
        this.f73756k.setVisibility(8);
        this.f73757l.setVisibility(0);
    }

    public final void Rh() {
        BottomMenuFragment bottomMenuFragment = this.f73767v;
        if (bottomMenuFragment == null) {
            bottomMenuFragment = new BottomMenuFragment();
        }
        this.f73767v = bottomMenuFragment;
        bottomMenuFragment.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
        this.f73768w.clear();
        int i11 = 0;
        while (i11 < this.f73760o.getScreenListObject().size()) {
            this.f73768w.add(new MenuItem("", this.f73760o.getScreenListObject().get(i11).getScreenTitle(), this.f73761p == i11 ? MenuItem.MenuItemStyle.STRESS : MenuItem.MenuItemStyle.COMMON, this.f73769x));
            i11++;
        }
        this.f73767v.setBottomMenuDismissListener(new d1(this));
        this.f73767v.setBottomMenuShowListener(new e1(this));
        this.f73767v.setMenuItems(this.f73768w);
    }

    public View getRootView() {
        return this.f73763r;
    }

    public final void initView(View view) {
        this.f73763r = (LinearLayout) view.findViewById(R.id.root_view);
        this.f73747b = (FrameLayout) view.findViewById(R.id.new_symbol_view);
        this.f73749d = (EasyRecyclerView) view.findViewById(R.id.ranking_list);
        Ph(this.f73760o);
        this.f73755j = (RelativeLayout) view.findViewById(R.id.rl_default_title_layout);
        this.f73756k = (TextView) view.findViewById(R.id.left_text);
        this.f73757l = (TextView) view.findViewById(R.id.sub_market_rank_tv);
        this.f73751f = (TextView) view.findViewById(R.id.right_text);
        this.f73750e = (TextView) view.findViewById(R.id.middle_text);
        this.f73752g = (TextView) view.findViewById(R.id.tv_title_select_crypto);
        this.f73758m = (LoadingLayout) view.findViewById(R.id.ranking_list_loading);
        this.f73759n = (RelativeLayout) view.findViewById(R.id.add_favorite_layout);
        if (this.f73760o.getType() == 9) {
            this.f73756k.setVisibility(8);
            this.f73757l.setVisibility(0);
            this.f73757l.setOnClickListener(new b1(this));
        }
        this.f73764s = new StableLinearLayoutManager(getActivity(), 1, false);
        this.f73749d.f(true);
        this.f73749d.setNestedScrollingEnabled(false);
        this.f73749d.setHasFixedSize(true);
        this.f73749d.setItemViewCacheSize(10);
        this.f73749d.setLayoutManager(this.f73764s);
        Ch(true);
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        RankDynamicItemHandler rankDynamicItemHandler = (RankDynamicItemHandler) ViewHandlerFactory.a(RankDynamicItemHandler.class.getName());
        recycledViewPool.m(rankDynamicItemHandler.getClass().hashCode(), 10);
        this.f73749d.setRecycledViewPool(recycledViewPool);
        this.f73749d.getItemAnimator().setChangeDuration(0);
        if (this.f73749d.getItemAnimator() instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) this.f73749d.getItemAnimator()).setSupportsChangeAnimations(false);
        }
        h0.N0(this.f73749d, false);
        RankList rankList = this.f73760o;
        if (rankList != null && rankList.getType() == 9) {
            rankDynamicItemHandler.c(new i1(this));
        }
        this.f73759n.setOnClickListener(new c1(this, rankDynamicItemHandler));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.index_ranking_list_view, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Log.d("IndexRankingFragment", "onViewCreated---subPosition:" + this.f73761p);
        initView(view);
        Bh(true);
    }

    public int ph() {
        return this.f73760o.getType();
    }

    public int qh() {
        return 0;
    }

    public String rh() {
        RankList rankList = this.f73760o;
        if (rankList == null) {
            return "";
        }
        return rankList.getTypeTitle();
    }
}
