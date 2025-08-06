package com.huobi.points.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.page.SmartRefreshFooter;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.points.entity.Points;
import com.huobi.points.entity.PointsAction;
import com.huobi.points.presenter.TransferOrderListPresenter;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.title.HbTabTitleBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fq.r;
import fq.s;
import fq.t;
import java.util.ArrayList;
import java.util.List;
import ky.j;
import ny.d;
import pro.huobi.R;

public class TransferOrderListActivity extends BaseActivity<TransferOrderListPresenter, TransferOrderListPresenter.b> implements TransferOrderListPresenter.b, MenuItemOnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f80439b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f80440c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80441d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f80442e;

    /* renamed from: f  reason: collision with root package name */
    public EasyRecyclerView f80443f;

    /* renamed from: g  reason: collision with root package name */
    public BottomMenuFragment f80444g = new BottomMenuFragment();

    /* renamed from: h  reason: collision with root package name */
    public MenuItem f80445h;

    /* renamed from: i  reason: collision with root package name */
    public MenuItem f80446i;

    /* renamed from: j  reason: collision with root package name */
    public MenuItem f80447j;

    /* renamed from: k  reason: collision with root package name */
    public MenuItem f80448k;

    /* renamed from: l  reason: collision with root package name */
    public MenuItem f80449l;

    /* renamed from: m  reason: collision with root package name */
    public String f80450m = PointsAction.TYPE_TRANSFER_IN;

    /* renamed from: n  reason: collision with root package name */
    public int f80451n;

    /* renamed from: o  reason: collision with root package name */
    public SmartRefreshHeader f80452o;

    /* renamed from: p  reason: collision with root package name */
    public SmartRefreshFooter f80453p;

    public class a implements d {
        public a() {
        }

        public void P8(j jVar) {
            ((TransferOrderListPresenter) TransferOrderListActivity.this.getPresenter()).c0();
        }

        public void bf(j jVar) {
            ((TransferOrderListPresenter) TransferOrderListActivity.this.getPresenter()).d0();
            ((TransferOrderListPresenter) TransferOrderListActivity.this.getPresenter()).c0();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void qh(View view) {
        doFinish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void rh(View view) {
        BottomMenuFragment bottomMenuFragment = this.f80444g;
        if (bottomMenuFragment != null) {
            bottomMenuFragment.show(getFragmentManager(), "mStateMenuFragment");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(int i11) {
        if (i11 != 0) {
            if (i11 == 1 && !PointsAction.TYPE_TRANSFER_OUT.equals(this.f80450m)) {
                this.f80450m = PointsAction.TYPE_TRANSFER_OUT;
                this.f80451n = 0;
                wh();
                ((TransferOrderListPresenter) getPresenter()).d0();
                ((TransferOrderListPresenter) getPresenter()).c0();
            }
        } else if (!PointsAction.TYPE_TRANSFER_IN.equals(this.f80450m)) {
            this.f80450m = PointsAction.TYPE_TRANSFER_IN;
            this.f80451n = 0;
            wh();
            ((TransferOrderListPresenter) getPresenter()).d0();
            ((TransferOrderListPresenter) getPresenter()).c0();
        }
    }

    public static void uh(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, TransferOrderListActivity.class));
        }
    }

    public static void vh(Context context, String str, int i11) {
        if (context != null) {
            Intent intent = new Intent(context, TransferOrderListActivity.class);
            intent.putExtra("extra_type", str);
            intent.putExtra("extra_state", i11);
            context.startActivity(intent);
        }
    }

    public String C7() {
        int i11 = this.f80451n;
        if (i11 == 1) {
            return "submitted";
        }
        if (i11 == 2) {
            return "canceled";
        }
        if (i11 != 3) {
            return i11 != 4 ? "" : Points.STATE_DENIED;
        }
        return "finished";
    }

    public void G(List<s9.a> list) {
        th(list == null || list.isEmpty());
        this.f80443f.setData(list);
        hideLoading();
    }

    /* renamed from: Pg */
    public TransferOrderListPresenter createPresenter() {
        return new TransferOrderListPresenter();
    }

    /* renamed from: Qg */
    public TransferOrderListPresenter.b getUI() {
        return this;
    }

    public void addEvent() {
        this.f80440c.e0(new a());
    }

    public int getContentView() {
        return R.layout.activity_transfer_to_me_list;
    }

    public String getType() {
        return this.f80450m;
    }

    public final void hideLoading() {
        if (this.f80440c.M()) {
            this.f80440c.finishRefresh();
        }
        if (this.f80440c.K()) {
            this.f80440c.w();
        }
        this.f80452o.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
    }

    public void initView() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f80451n = intent.getIntExtra("extra_state", 0);
            String stringExtra = intent.getStringExtra("extra_type");
            this.f80450m = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.f80450m = PointsAction.TYPE_TRANSFER_IN;
            }
        }
        i6.d.b("TransferOrderListActivity-->initView-->mType:" + this.f80450m + " mMenuType:" + this.f80451n);
        this.f80439b = this.viewFinder.b(R.id.id_common_empty_view);
        this.f80443f = (EasyRecyclerView) this.viewFinder.b(R.id.id_transfer_to_me_list_recyclerView);
        this.f80440c = (SmartRefreshLayout) this.viewFinder.b(R.id.id_ptrLayout);
        ph();
        oh();
        this.f80452o = new SmartRefreshHeader(this);
        this.f80453p = new SmartRefreshFooter(this);
        this.f80440c.j0(this.f80452o);
        this.f80440c.h0(this.f80453p);
        this.f80440c.V(false);
    }

    public final void oh() {
        String string = getString(R.string.points_history_filter_all);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        this.f80445h = new MenuItem(0, "", string, menuItemStyle, this);
        MenuItem.MenuItemStyle menuItemStyle2 = menuItemStyle;
        this.f80446i = new MenuItem(1, "", "", menuItemStyle2, this);
        this.f80447j = new MenuItem(2, "", "", menuItemStyle2, this);
        this.f80448k = new MenuItem(3, "", getString(R.string.points_transfer_order_status_finished), menuItemStyle2, this);
        this.f80449l = new MenuItem(4, "", "", menuItemStyle2, this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f80445h);
        arrayList.add(this.f80446i);
        arrayList.add(this.f80449l);
        arrayList.add(this.f80447j);
        arrayList.add(this.f80448k);
        this.f80444g.setMenuItems(arrayList);
        wh();
    }

    public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
        BottomMenuFragment bottomMenuFragment = this.f80444g;
        if (bottomMenuFragment != null) {
            bottomMenuFragment.dismiss();
        }
        if (menuItem != null && this.f80451n != menuItem.getType()) {
            this.f80451n = menuItem.getType();
            wh();
            ((TransferOrderListPresenter) getPresenter()).d0();
            ((TransferOrderListPresenter) getPresenter()).c0();
        }
    }

    public final void ph() {
        HbTabTitleBar hbTabTitleBar = (HbTabTitleBar) this.viewFinder.b(R.id.hb_title_bar_points);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R.string.transfer_to_me_title));
        arrayList.add(getResources().getString(R.string.my_transfer_title));
        if (PointsAction.TYPE_TRANSFER_OUT.equals(this.f80450m)) {
            hbTabTitleBar.setTitles(1, arrayList);
        } else {
            hbTabTitleBar.setTitles(arrayList);
        }
        hbTabTitleBar.setOnClickBackListener(new s(this));
        this.f80442e = hbTabTitleBar.getIvAction();
        this.f80441d = hbTabTitleBar.getTvAction();
        hbTabTitleBar.setOnClickActionListener(new r(this));
        hbTabTitleBar.setOnTabChangedListener(new t(this));
    }

    public final void th(boolean z11) {
        View view = this.f80439b;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void wh() {
        MenuItem.MenuItemStyle menuItemStyle;
        MenuItem.MenuItemStyle menuItemStyle2;
        MenuItem.MenuItemStyle menuItemStyle3;
        MenuItem.MenuItemStyle menuItemStyle4;
        MenuItem.MenuItemStyle menuItemStyle5;
        MenuItem menuItem = this.f80445h;
        if (this.f80451n == 0) {
            menuItemStyle = MenuItem.MenuItemStyle.STRESS;
        } else {
            menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        }
        menuItem.setStyle(menuItemStyle);
        MenuItem menuItem2 = this.f80446i;
        if (this.f80451n == 1) {
            menuItemStyle2 = MenuItem.MenuItemStyle.STRESS;
        } else {
            menuItemStyle2 = MenuItem.MenuItemStyle.COMMON;
        }
        menuItem2.setStyle(menuItemStyle2);
        MenuItem menuItem3 = this.f80447j;
        if (this.f80451n == 2) {
            menuItemStyle3 = MenuItem.MenuItemStyle.STRESS;
        } else {
            menuItemStyle3 = MenuItem.MenuItemStyle.COMMON;
        }
        menuItem3.setStyle(menuItemStyle3);
        MenuItem menuItem4 = this.f80448k;
        if (this.f80451n == 3) {
            menuItemStyle4 = MenuItem.MenuItemStyle.STRESS;
        } else {
            menuItemStyle4 = MenuItem.MenuItemStyle.COMMON;
        }
        menuItem4.setStyle(menuItemStyle4);
        MenuItem menuItem5 = this.f80449l;
        if (this.f80451n == 4) {
            menuItemStyle5 = MenuItem.MenuItemStyle.STRESS;
        } else {
            menuItemStyle5 = MenuItem.MenuItemStyle.COMMON;
        }
        menuItem5.setStyle(menuItemStyle5);
        if (PointsAction.TYPE_TRANSFER_IN.equals(this.f80450m)) {
            this.f80446i.setText(getString(R.string.my_transfer_item_waiting_receive));
            this.f80447j.setText(getString(R.string.points_transfer_order_status_he_cancel));
            this.f80449l.setText(getString(R.string.points_transfer_order_status_i_rejecct));
        } else {
            this.f80446i.setText(getString(R.string.points_transfer_order_status_waiting));
            this.f80447j.setText(getString(R.string.points_transfer_order_status_canceled));
            this.f80449l.setText(getString(R.string.points_transfer_order_status_reject));
        }
        int i11 = this.f80451n;
        if (i11 == 0) {
            this.f80441d.setText(this.f80445h.getText());
        } else if (i11 == 1) {
            this.f80441d.setText(this.f80446i.getText());
        } else if (i11 == 2) {
            this.f80441d.setText(this.f80447j.getText());
        } else if (i11 == 3) {
            this.f80441d.setText(this.f80448k.getText());
        } else if (i11 == 4) {
            this.f80441d.setText(this.f80449l.getText());
        }
        if (MenuItem.MenuItemStyle.STRESS == this.f80445h.getStyle()) {
            this.f80442e.setImageResource(R.drawable.global_filter_unselected);
        } else {
            this.f80442e.setImageResource(R.drawable.global_filter_selected);
        }
    }
}
