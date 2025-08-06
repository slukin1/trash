package com.huobi.finance.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.utils.UiFillUtil;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public abstract class BaseAssetDetailActivity extends BaseActivity<BaseAssetDetailPresenter, BaseAssetDetailPresenter.a> implements BaseAssetDetailPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f46393b;

    /* renamed from: c  reason: collision with root package name */
    public String f46394c;

    /* renamed from: d  reason: collision with root package name */
    public String f46395d;

    /* renamed from: e  reason: collision with root package name */
    public SmartRefreshLayout f46396e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f46397f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f46398g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46399h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46400i;

    /* renamed from: j  reason: collision with root package name */
    public View f46401j;

    /* renamed from: k  reason: collision with root package name */
    public AppBarLayout f46402k;

    /* renamed from: l  reason: collision with root package name */
    public Toolbar f46403l;

    /* renamed from: m  reason: collision with root package name */
    public CollapsingToolbarLayout f46404m;

    /* renamed from: n  reason: collision with root package name */
    public BottomMenuFragment f46405n = new BottomMenuFragment();

    /* renamed from: o  reason: collision with root package name */
    public List<MenuItem> f46406o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public int f46407p;

    /* renamed from: q  reason: collision with root package name */
    public MenuItemOnClickListener f46408q = new d3(this);

    /* renamed from: r  reason: collision with root package name */
    public float f46409r;

    public class a implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: b  reason: collision with root package name */
        public int f46410b;

        public a() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
            String str;
            int abs = Math.abs(i11);
            this.f46410b = abs;
            if (Float.compare((float) abs, BaseAssetDetailActivity.this.f46409r) < 0) {
                BaseAssetDetailActivity.this.f46399h.setVisibility(8);
                BaseAssetDetailActivity.this.uh(false);
            } else if (Float.compare((float) Math.abs(i11), BaseAssetDetailActivity.this.f46409r) < 0 || Math.abs(i11) >= appBarLayout.getTotalScrollRange()) {
                BaseAssetDetailActivity.this.f46399h.setText(BaseAssetDetailActivity.this.ph());
                BaseAssetDetailActivity.this.f46399h.setTextColor(ContextCompat.getColor(BaseAssetDetailActivity.this, R.color.global_main_text_color));
                BaseAssetDetailActivity.this.f46399h.setVisibility(0);
                BaseAssetDetailActivity.this.uh(true);
            } else {
                TextView gg2 = BaseAssetDetailActivity.this.f46399h;
                if (BaseAssetDetailActivity.this.wh()) {
                    str = BaseAssetDetailActivity.this.f46395d;
                } else {
                    str = StringUtils.i(BaseAssetDetailActivity.this.f46394c);
                }
                gg2.setText(str);
                if (BaseAssetDetailActivity.this.f46407p != 0) {
                    BaseAssetDetailActivity.this.f46399h.setTextColor(BaseAssetDetailActivity.this.f46407p);
                }
                BaseAssetDetailActivity.this.f46399h.setVisibility(0);
                BaseAssetDetailActivity.this.uh(false);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        xh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(View view) {
        if (getPresenter() != null) {
            ((BaseAssetDetailPresenter) getPresenter()).W();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void th(View view, MenuItem menuItem, int i11) {
        MenuItem.MenuItemStyle menuItemStyle;
        this.f46405n.dismiss();
        if (i11 == 0) {
            this.f46398g.setImageResource(R.drawable.global_filter_unselected);
        } else {
            this.f46398g.setImageResource(R.drawable.global_filter_selected);
        }
        for (int i12 = 0; i12 < this.f46406o.size(); i12++) {
            MenuItem menuItem2 = this.f46406o.get(i12);
            if (i12 == i11) {
                menuItemStyle = MenuItem.MenuItemStyle.STRESS;
            } else {
                menuItemStyle = MenuItem.MenuItemStyle.COMMON;
            }
            menuItem2.setStyle(menuItemStyle);
        }
        vh();
        Qg(i11);
    }

    private void vh() {
        CoordinatorLayout.Behavior f11 = ((CoordinatorLayout.LayoutParams) this.f46402k.getLayoutParams()).f();
        if (f11 instanceof AppBarLayout.Behavior) {
            ((AppBarLayout.Behavior) f11).setTopAndBottomOffset(0);
        }
    }

    public abstract void Qg(int i11);

    public RecyclerView Y0() {
        return this.f46397f;
    }

    public void addEvent() {
        this.f46393b.findViewById(R.id.viewErrorRetry).setOnClickListener(new c3(this));
        this.f46402k.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a());
        this.f46404m.setDrawCollapsingMiddleTitle(false);
        this.f46398g.setOnClickListener(new b3(this));
    }

    public LoadingLayout f6() {
        return this.f46393b;
    }

    public void initView() {
        removeWinBg();
        rh();
        this.f46399h = (TextView) this.viewFinder.b(R.id.currency_detail_toolbar_title);
        this.f46400i = (TextView) this.viewFinder.b(R.id.currency_detail_collapsing_toolbar_title);
        this.f46402k = (AppBarLayout) this.viewFinder.b(R.id.currency_detail_appbar_layout);
        this.f46401j = this.viewFinder.b(R.id.currency_detail_bottom_layout);
        this.f46397f = (RecyclerView) this.viewFinder.b(R.id.currency_detail_withdraw_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.f46397f.setLayoutManager(linearLayoutManager);
        this.f46397f.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_divider_color), PixelUtils.a(0.5f), false, true));
        this.f46396e = (SmartRefreshLayout) this.viewFinder.b(R.id.currency_detail_withdraw_refresh_layout);
        this.f46398g = (ImageView) this.viewFinder.b(R.id.currency_detail_detail);
        this.f46403l = (Toolbar) this.viewFinder.b(R.id.currency_detail_toolbar);
        this.f46404m = (CollapsingToolbarLayout) this.viewFinder.b(R.id.currency_detail_collapsing_toolbar);
        setToolBar(this.f46403l, "", true);
        List<MenuItem> oh2 = oh();
        if (oh2 != null && !oh2.isEmpty()) {
            for (MenuItem next : oh2) {
                if (next != null) {
                    next.setMenuItemOnClickListener(this.f46408q);
                    this.f46406o.add(next);
                }
            }
        }
        this.f46409r = getResources().getDimension(R.dimen.dimen_44);
    }

    public abstract List<MenuItem> oh();

    public void pb(BaseAssetInfo baseAssetInfo) {
        if (baseAssetInfo != null) {
            this.f46394c = baseAssetInfo.getCurrency();
            this.f46395d = k.C().z(this.f46394c);
            String str = "--";
            if (wh()) {
                String str2 = this.f46395d;
                if (str2 != null) {
                    str = str2;
                }
                yh(str);
                return;
            }
            String str3 = this.f46394c;
            if (str3 != null) {
                str = StringUtils.i(str3);
            }
            yh(str);
        }
    }

    public int ph() {
        return R.string.currency_detail_pendingorders;
    }

    /* renamed from: qh */
    public BaseAssetDetailPresenter.a getUI() {
        return this;
    }

    public void rh() {
        this.f46393b = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
    }

    public SmartRefreshLayout t2() {
        return this.f46396e;
    }

    public void uh(boolean z11) {
    }

    public void wd(BaseAssetInfo baseAssetInfo, YbbUserAssetInfoData ybbUserAssetInfoData, List<String> list) {
    }

    public boolean wh() {
        return true;
    }

    public void xh() {
        this.f46405n.setMenuItems(this.f46406o);
        this.f46405n.show(getFragmentManager(), "BottomMenuFragment");
    }

    public void yh(String str) {
        UiFillUtil.a(this.f46400i, str);
        UiFillUtil.a(this.f46399h, str);
    }
}
