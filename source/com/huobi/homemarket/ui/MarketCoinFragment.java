package com.huobi.homemarket.ui;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.pro.core.bean.Partitions;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.module.market.R$dimen;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.hbg.module.market.R$style;
import com.huobi.homemarket.bean.MarketCoinThirdTabClick;
import com.huobi.homemarket.handler.MarketHeaderViewHolderHandler;
import com.huobi.homemarket.presenter.HomeMarketNewPresenter;
import com.huobi.homemarket.presenter.MarketCoinPresenter;
import com.huobi.homemarket.ui.MarketSortLayout;
import com.huobi.homemarket.ui.a;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.d;
import java.util.HashMap;
import java.util.List;
import ml.c;
import org.greenrobot.eventbus.EventBus;
import rl.q;
import ul.p0;
import ul.q0;
import ul.r0;
import ul.s0;
import ul.t0;
import ul.u0;
import ul.v0;

public class MarketCoinFragment extends BaseFragment<MarketCoinPresenter, MarketCoinPresenter.c> implements MarketCoinPresenter.c, MarketSortLayout.a {
    public int A = 0;
    public boolean B = false;

    /* renamed from: l  reason: collision with root package name */
    public RecyclerView f72924l;

    /* renamed from: m  reason: collision with root package name */
    public MarketSortLayout f72925m;

    /* renamed from: n  reason: collision with root package name */
    public RadioGroup f72926n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f72927o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f72928p = true;

    /* renamed from: q  reason: collision with root package name */
    public boolean f72929q = false;

    /* renamed from: r  reason: collision with root package name */
    public final DecelerateInterpolator f72930r = new DecelerateInterpolator();

    /* renamed from: s  reason: collision with root package name */
    public HorizontalScrollView f72931s;

    /* renamed from: t  reason: collision with root package name */
    public ConstraintLayout f72932t;

    /* renamed from: u  reason: collision with root package name */
    public View f72933u;

    /* renamed from: v  reason: collision with root package name */
    public FragmentActivity f72934v;

    /* renamed from: w  reason: collision with root package name */
    public a f72935w;

    /* renamed from: x  reason: collision with root package name */
    public VerticalDividerItemDecoration f72936x;

    /* renamed from: y  reason: collision with root package name */
    public final q.b f72937y = new v0(this);

    /* renamed from: z  reason: collision with root package name */
    public int f72938z = 0;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ StableLinearLayoutManager f72939b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f72940c;

        public a(StableLinearLayoutManager stableLinearLayoutManager, int i11) {
            this.f72939b = stableLinearLayoutManager;
            this.f72940c = i11;
        }

        public void run() {
            int findLastCompletelyVisibleItemPosition = this.f72939b.findLastCompletelyVisibleItemPosition();
            int i11 = this.f72940c;
            if (i11 == findLastCompletelyVisibleItemPosition) {
                MarketCoinFragment.this.f72924l.smoothScrollBy(0, DimenUtils.a(40.0f));
            } else if (i11 > findLastCompletelyVisibleItemPosition) {
                MarketCoinFragment.this.f72924l.smoothScrollBy(0, DimenUtils.a(40.0f));
            }
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            if (i12 > 0) {
                MarketCoinFragment marketCoinFragment = MarketCoinFragment.this;
                int i13 = marketCoinFragment.f72938z + i12;
                marketCoinFragment.f72938z = i13;
                if (i13 >= marketCoinFragment.A) {
                    marketCoinFragment.f72938z = 0;
                    if (marketCoinFragment.f72924l != null && MarketCoinFragment.this.f72935w != null) {
                        MarketCoinFragment.this.f72935w.t();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Th(RadioGroup radioGroup, int i11) {
        q.b().f((String) null, -1);
        int scrollX = this.f72931s.getScrollX();
        RadioButton radioButton = (RadioButton) this.f67460i.b(i11);
        int left = radioButton.getLeft();
        if (left < scrollX) {
            this.f72931s.smoothScrollBy(left - scrollX, 0);
        }
        int right = radioButton.getRight();
        int measuredWidth = this.f72932t.getMeasuredWidth();
        if (measuredWidth + scrollX < right) {
            this.f72931s.smoothScrollBy((right - scrollX) - measuredWidth, 0);
        }
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uh(View view, int i11, int i12, int i13, int i14) {
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.f72931s.getChildAt(0).getWidth()) {
            Oh();
        } else {
            Nh();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wh(View view, int i11, int i12) {
        StableLinearLayoutManager stableLinearLayoutManager;
        if (this.f72924l.indexOfChild(view) != -1 && (stableLinearLayoutManager = (StableLinearLayoutManager) this.f72924l.getLayoutManager()) != null) {
            RecyclerView.Adapter adapter = this.f72924l.getAdapter();
            if (!(adapter == null || i12 == -1)) {
                adapter.notifyItemChanged(i12);
            }
            this.f72924l.postDelayed(new a(stableLinearLayoutManager, i11), 200);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Xh(MarketCoinPresenter marketCoinPresenter, CompoundButton compoundButton, boolean z11) {
        if (z11 && marketCoinPresenter != null) {
            marketCoinPresenter.x0(-1L);
            ConfigPreferences.k("user_config", "config_home_market_contractindex" + marketCoinPresenter.z0(), this.f72926n.indexOfChild(compoundButton));
            Zh(marketCoinPresenter, compoundButton);
            if (compoundButton != null && compoundButton.isPressed()) {
                EventBus.d().k(new MarketCoinThirdTabClick(0L, marketCoinPresenter.z0()));
                d.e("tab", "setOnCheckedChangeListener isPressed-现货二级- ");
            }
            d.e("tab", "setOnCheckedChangeListener -现货二级- 全");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Yh(MarketCoinPresenter marketCoinPresenter, Partitions partitions, CompoundButton compoundButton, boolean z11) {
        if (z11) {
            marketCoinPresenter.x0(partitions.getId());
            ConfigPreferences.k("user_config", "config_home_market_contractindex" + marketCoinPresenter.z0(), this.f72926n.indexOfChild(compoundButton));
            Zh(marketCoinPresenter, compoundButton);
            if (compoundButton != null && compoundButton.isPressed()) {
                EventBus.d().k(new MarketCoinThirdTabClick(partitions.getId(), marketCoinPresenter.z0()));
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        HorizontalScrollView horizontalScrollView = this.f72931s;
        if (horizontalScrollView != null) {
            horizontalScrollView.smoothScrollTo(Integer.MAX_VALUE, 0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f72925m.setSrotTypeListener(this);
        this.f72927o.setOnClickListener(new p0(this));
        this.f72926n.setOnCheckedChangeListener(new t0(this));
        HorizontalScrollView horizontalScrollView = this.f72931s;
        if (horizontalScrollView != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new q0(this));
        }
    }

    public void Lh() {
        RadioGroup radioGroup;
        HomeMarketNewPresenter A0 = ((MarketCoinPresenter) yh()).A0();
        if (A0 != null) {
            if ("2".equalsIgnoreCase(A0.z1("primaryTitle")) && A0.z1("secondaryTitle").equalsIgnoreCase(((MarketCoinPresenter) yh()).z0())) {
                String z12 = A0.z1("filter");
                String z13 = A0.z1("sortType");
                String z14 = A0.z1("sort");
                if (!TextUtils.isEmpty(z12) && (radioGroup = this.f72926n) != null && radioGroup.getVisibility() == 0) {
                    for (int i11 = 0; i11 < this.f72926n.getChildCount(); i11++) {
                        View childAt = this.f72926n.getChildAt(i11);
                        if ((childAt instanceof RadioButton) && childAt.getTag() != null && childAt.getTag().toString().equalsIgnoreCase(z12)) {
                            ((RadioButton) childAt).setChecked(true);
                        }
                    }
                }
                if (!TextUtils.isEmpty(z13) && !TextUtils.isEmpty(z14)) {
                    this.f72925m.k(z13, z14);
                    this.f72925m.m();
                    w8(z13, z14);
                }
            }
            A0.n1();
        }
    }

    /* renamed from: Mh */
    public MarketCoinPresenter xh() {
        return new MarketCoinPresenter();
    }

    public final void Nh() {
        if (!this.f72928p) {
            this.f72928p = true;
            this.f72927o.animate().setInterpolator(this.f72930r).setDuration(300).translationX(0.0f).alpha(1.0f);
        }
    }

    public final void Oh() {
        if (this.f72928p) {
            this.f72928p = false;
            this.f72927o.animate().setInterpolator(this.f72930r).setDuration(300).translationX((float) this.f72927o.getWidth()).alpha(0.0f);
        }
    }

    public int Ph() {
        return ConfigPreferences.g("user_config", "config_home_market_contractindex" + ((MarketCoinPresenter) yh()).z0(), 0);
    }

    /* renamed from: Qh */
    public MarketCoinPresenter.c zh() {
        return this;
    }

    public void Rh() {
        if (yh() != null) {
            int y02 = ((MarketCoinPresenter) yh()).y0();
            if (y02 > -1) {
                this.f72924l.post(new u0((LinearLayoutManager) this.f72924l.getLayoutManager(), y02));
            }
            this.f72929q = false;
            return;
        }
        this.f72929q = true;
    }

    public boolean Sh() {
        return this.B;
    }

    public final void Zh(MarketCoinPresenter marketCoinPresenter, CompoundButton compoundButton) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, marketCoinPresenter.z0());
        hashMap.put("type", compoundButton.getText());
        BaseModuleConfig.a().d("4748", hashMap, "1000047");
    }

    public View a4() {
        RecyclerView recyclerView = this.f72924l;
        if (recyclerView == null) {
            return null;
        }
        LinearLayoutManager linearLayoutManager = recyclerView.getLayoutManager() instanceof LinearLayoutManager ? (LinearLayoutManager) this.f72924l.getLayoutManager() : null;
        if (linearLayoutManager == null) {
            return null;
        }
        try {
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (((v9.a) this.f72924l.getAdapter()).c().get(findFirstCompletelyVisibleItemPosition) instanceof c) {
                return linearLayoutManager.findViewByPosition(findFirstCompletelyVisibleItemPosition + 1);
            }
            return linearLayoutManager.findViewByPosition(findFirstCompletelyVisibleItemPosition);
        } catch (Exception unused) {
            return null;
        }
    }

    public void b(v9.a<s9.a> aVar) {
        this.f72924l.setAdapter(aVar);
    }

    public void initViews() {
        super.initViews();
        this.f72934v = getActivity();
        this.f72926n = (RadioGroup) this.f67460i.b(R$id.radio_group_indicator_coin_filter);
        RecyclerView recyclerView = (RecyclerView) this.f67460i.b(R$id.market_coin_rv);
        this.f72924l = recyclerView;
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f72925m = (MarketSortLayout) this.f67460i.b(R$id.market_sort);
        this.f72927o = (ImageView) this.f67460i.b(R$id.image_view_market_indicator_arrow_right);
        this.f72924l.setLayoutManager(new StableLinearLayoutManager(this.f72934v));
        this.f72931s = (HorizontalScrollView) this.f67460i.b(R$id.horizontal_scroll_view_indicator_coin_filter);
        this.f72932t = (ConstraintLayout) this.f67460i.b(R$id.constrain_layout_market_indicator_box);
        this.f72933u = this.f67460i.b(R$id.market_coin_divide);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        q.b().a(this.f72937y);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        q.b().e(this.f72937y);
        super.onDestroyView();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_coin, viewGroup, false);
    }

    public void s6(List<Partitions> list) {
        if (this.f72926n.getChildCount() <= 0) {
            int i11 = 0;
            int size = list != null ? list.size() : 0;
            if (size > 0) {
                RadioButton radioButton = (RadioButton) LayoutInflater.from(this.f72934v).inflate(R$layout.layout_market_filter_item, (ViewGroup) null);
                if (Build.VERSION.SDK_INT >= 23) {
                    radioButton.setTextAppearance(R$style.marketFilter);
                }
                radioButton.setText(this.f72934v.getResources().getString(R$string.market_title_table_all));
                radioButton.setTag("-1");
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
                Resources resources = this.f72934v.getResources();
                int i12 = R$dimen.dimen_10;
                layoutParams.topMargin = resources.getDimensionPixelSize(i12);
                layoutParams.bottomMargin = this.f72934v.getResources().getDimensionPixelSize(i12);
                layoutParams.leftMargin = this.f72934v.getResources().getDimensionPixelOffset(R$dimen.dimen_16);
                this.f72926n.addView(radioButton, layoutParams);
                MarketCoinPresenter marketCoinPresenter = (MarketCoinPresenter) yh();
                radioButton.setOnCheckedChangeListener(new r0(this, marketCoinPresenter));
                for (int i13 = 0; i13 < size; i13++) {
                    Partitions partitions = list.get(i13);
                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.f72934v).inflate(R$layout.layout_market_filter_item, (ViewGroup) null);
                    if (Build.VERSION.SDK_INT >= 23) {
                        radioButton2.setTextAppearance(R$style.marketFilter);
                    }
                    radioButton2.setText(partitions.getName());
                    radioButton2.setTag(String.valueOf(partitions.getId()));
                    RadioGroup.LayoutParams layoutParams2 = new RadioGroup.LayoutParams(-2, -2);
                    Resources resources2 = this.f72934v.getResources();
                    int i14 = R$dimen.dimen_10;
                    layoutParams2.topMargin = resources2.getDimensionPixelSize(i14);
                    layoutParams2.bottomMargin = this.f72934v.getResources().getDimensionPixelSize(i14);
                    Resources resources3 = this.f72934v.getResources();
                    int i15 = R$dimen.dimen_16;
                    layoutParams2.leftMargin = resources3.getDimensionPixelSize(i15);
                    if (i13 == size - 1) {
                        layoutParams2.rightMargin = this.f72934v.getResources().getDimensionPixelOffset(i15);
                    }
                    this.f72926n.addView(radioButton2, layoutParams2);
                    radioButton2.setOnCheckedChangeListener(new s0(this, marketCoinPresenter, partitions));
                }
                if (this.f72926n.getVisibility() != 0) {
                    this.f72926n.setVisibility(0);
                }
                if (this.f72933u.getVisibility() != 0) {
                    this.f72933u.setVisibility(0);
                }
                int Ph = Ph();
                if (Ph >= 0 && Ph < size) {
                    i11 = Ph;
                }
                View childAt = this.f72926n.getChildAt(i11);
                if (childAt instanceof RadioButton) {
                    ((RadioButton) childAt).setChecked(true);
                }
            } else if (this.f72926n.getVisibility() != 8) {
                this.f72926n.removeAllViews();
                this.f72926n.setVisibility(8);
                this.f72933u.setVisibility(4);
            }
        }
    }

    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        if (z11 && this.f72926n != null) {
            s6(a1.v().C(((MarketCoinPresenter) yh()).z0()));
        }
        if (yh() != null && ((MarketCoinPresenter) yh()).A0() != null && ((MarketCoinPresenter) yh()).A0().F1() != null) {
            this.f72925m.m();
        }
    }

    public void uh(boolean z11) {
        this.B = z11;
        super.uh(z11);
        if (z11) {
            if (this.f72929q) {
                Rh();
            }
            Lh();
        }
        if (z11) {
            a aVar = this.f72935w;
            if (aVar != null) {
                aVar.u();
                return;
            }
            return;
        }
        a aVar2 = this.f72935w;
        if (aVar2 != null) {
            aVar2.s();
        }
    }

    public void w5() {
    }

    public void w8(String str, String str2) {
        q.b().f((String) null, -1);
        ((MarketCoinPresenter) yh()).A0().v2(str, str2);
        ((MarketCoinPresenter) yh()).A0().u2(str, str2);
        ((MarketCoinPresenter) yh()).A0().w2(str, str2);
        ((MarketCoinPresenter) yh()).A0().x2(str, str2);
        ((MarketCoinPresenter) yh()).A0().k1();
    }

    public void xc() {
        if (Ph() == 0) {
            if (this.f72935w == null) {
                a g11 = new a.f(MarketHeaderViewHolderHandler.class.hashCode()).i(R$drawable.market_divider).h(false).g();
                this.f72935w = g11;
                this.f72924l.addItemDecoration(g11);
                this.A = (int) getResources().getDimension(R$dimen.dimen_35);
                this.f72924l.addOnScrollListener(new b());
            }
            VerticalDividerItemDecoration verticalDividerItemDecoration = this.f72936x;
            if (verticalDividerItemDecoration != null) {
                this.f72924l.removeItemDecoration(verticalDividerItemDecoration);
            }
        } else if (this.f72936x == null) {
            VerticalDividerItemDecoration verticalDividerItemDecoration2 = new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R$drawable.vertical_divider_bg), PixelUtils.a(0.5f), false, false);
            this.f72936x = verticalDividerItemDecoration2;
            this.f72924l.addItemDecoration(verticalDividerItemDecoration2);
        }
    }
}
