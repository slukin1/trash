package com.huobi.points.activity;

import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.points.entity.PointsAction;
import com.huobi.points.presenter.PointsDetailListPresenter;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.rv.CommonVerticalDividerItemDecoration;
import com.huobi.view.title.HbTitleBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fq.h;
import fq.i;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class PointsDetailListActivity extends BaseActivity<PointsDetailListPresenter, PointsDetailListPresenter.b> implements PointsDetailListPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f80381b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f80382c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f80383d;

    /* renamed from: e  reason: collision with root package name */
    public BottomMenuFragment f80384e = new BottomMenuFragment();

    /* renamed from: f  reason: collision with root package name */
    public List<MenuItem> f80385f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public MenuItemOnClickListener f80386g = new a();

    /* renamed from: h  reason: collision with root package name */
    public HbTitleBar f80387h;

    public class a implements MenuItemOnClickListener {
        public a() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            MenuItem.MenuItemStyle menuItemStyle;
            if (i11 == 0) {
                PointsDetailListActivity.this.f80387h.getIvAction().setImageResource(R.drawable.global_filter_unselected);
            } else {
                PointsDetailListActivity.this.f80387h.getIvAction().setImageResource(R.drawable.global_filter_selected);
            }
            for (int i12 = 0; i12 < PointsDetailListActivity.this.f80385f.size(); i12++) {
                MenuItem menuItem2 = (MenuItem) PointsDetailListActivity.this.f80385f.get(i12);
                if (i12 == i11) {
                    menuItemStyle = MenuItem.MenuItemStyle.STRESS;
                } else {
                    menuItemStyle = MenuItem.MenuItemStyle.COMMON;
                }
                menuItem2.setStyle(menuItemStyle);
            }
            ((PointsDetailListPresenter) PointsDetailListActivity.this.getPresenter()).U(menuItem.getItem_name());
            ((PointsDetailListPresenter) PointsDetailListActivity.this.getPresenter()).T();
            PointsDetailListActivity.this.f80384e.dismiss();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(View view) {
        doFinish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void th(View view) {
        this.f80384e.show(getFragmentManager(), "filterFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Qg */
    public PointsDetailListPresenter createPresenter() {
        return new PointsDetailListPresenter();
    }

    public RecyclerView Y0() {
        return this.f80381b;
    }

    public void addEvent() {
    }

    public void afterInit() {
        super.afterInit();
        qh();
        rh();
        initRefreshLayout();
        ph();
    }

    public LoadingLayout f6() {
        return this.f80383d;
    }

    public int getContentView() {
        return R.layout.activity_points_detail_list;
    }

    public final void initRefreshLayout() {
        this.f80382c.j0(new SmartRefreshHeader(this));
        this.f80382c.h0(new SmartRefreshFooter(this));
    }

    public void initView() {
        this.f80381b = (EasyRecyclerView) this.viewFinder.b(R.id.id_points_detail_recyclerView);
        this.f80382c = (SmartRefreshLayout) this.viewFinder.b(R.id.id_points_detail_smartRefreshLayout);
        this.f80383d = (LoadingLayout) this.viewFinder.b(R.id.id_points_detail_loadingLayout);
    }

    /* renamed from: oh */
    public PointsDetailListPresenter.b getUI() {
        return this;
    }

    public final void ph() {
        this.f80385f.add(new MenuItem("", getString(R.string.points_history_filter_all), MenuItem.MenuItemStyle.STRESS, this.f80386g));
        List<MenuItem> list = this.f80385f;
        String string = getString(R.string.points_history_filter_buy_points);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem("purchase", string, menuItemStyle, this.f80386g));
        this.f80385f.add(new MenuItem(PointsAction.TYPE_TRANSFER_IN, getString(R.string.transfer_to_me_title), menuItemStyle, this.f80386g));
        this.f80385f.add(new MenuItem(PointsAction.TYPE_TRANSFER_OUT, getString(R.string.my_transfer_title), menuItemStyle, this.f80386g));
        this.f80385f.add(new MenuItem(PointsAction.TYPE_FEE_DEDUCTION, getString(R.string.points_history_filter_trade_fee), menuItemStyle, this.f80386g));
        this.f80385f.add(new MenuItem(PointsAction.TYPE_BROKERAGE, getString(R.string.points_history_filter_invite), menuItemStyle, this.f80386g));
        this.f80385f.add(new MenuItem(PointsAction.TYPE_ALL_MARGIN_INTEREST_DEDUCTION, getString(R.string.points_history_filter_margin_fee), menuItemStyle, this.f80386g));
        this.f80385f.add(new MenuItem(PointsAction.TYPE_MINE_POOL_PAY, getString(R.string.points_history_filter_pool_fee), menuItemStyle, this.f80386g));
        this.f80385f.add(new MenuItem(PointsAction.TYPE_ACTIVITY_TRANSFER_IN, getString(R.string.points_history_filter_activity_reward), menuItemStyle, this.f80386g));
        this.f80385f.add(new MenuItem(PointsAction.TYPE_TRANSFER_BETWEEN_MASTER, getString(R.string.points_history_filter_points_transfer_between_master), menuItemStyle, this.f80386g));
        this.f80385f.add(new MenuItem(PointsAction.TYPE_POINTS_EXCHANGE, getString(R.string.points_exchange), menuItemStyle, this.f80386g));
        this.f80385f.add(new MenuItem(PointsAction.TYPE_POINTS_REVOKE, getString(R.string.points_revoke), menuItemStyle, this.f80386g));
        this.f80384e.setMenuItems(this.f80385f);
    }

    public final void qh() {
        this.f80381b.addItemDecoration(new CommonVerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_item_bg), ContextCompat.getDrawable(this, R.color.global_large_divider_color), PixelUtils.a(10.0f), PixelUtils.a(0.5f), true));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.f80381b.setLayoutManager(linearLayoutManager);
    }

    public final void rh() {
        HbTitleBar hbTitleBar = (HbTitleBar) this.viewFinder.b(R.id.hb_title_bar);
        this.f80387h = hbTitleBar;
        hbTitleBar.setTitle(getResources().getString(R.string.detail_order_title));
        this.f80387h.setOnClickBackListener(new i(this));
        this.f80387h.setOnClickActionListener(new h(this));
    }

    public SmartRefreshLayout t2() {
        return this.f80382c;
    }
}
