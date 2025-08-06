package com.huobi.finance.ui;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.finance.presenter.OtcCurrencyFinanceRecordPresenter;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class OtcCurrencyFinanceRecordActivity extends BaseActivity<OtcCurrencyFinanceRecordPresenter, OtcCurrencyFinanceRecordPresenter.b> implements OtcCurrencyFinanceRecordPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f46716b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f46717c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f46718d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46719e;

    /* renamed from: f  reason: collision with root package name */
    public Toolbar f46720f;

    /* renamed from: g  reason: collision with root package name */
    public AppBarLayout f46721g;

    /* renamed from: h  reason: collision with root package name */
    public BottomMenuFragment f46722h = new BottomMenuFragment();

    /* renamed from: i  reason: collision with root package name */
    public List<MenuItem> f46723i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public CoordinatorLayout f46724j;

    /* renamed from: k  reason: collision with root package name */
    public CollapsingToolbarLayout f46725k;

    /* renamed from: l  reason: collision with root package name */
    public MenuItemOnClickListener f46726l = new b();

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (OtcCurrencyFinanceRecordActivity.this.f46723i.isEmpty()) {
                if (((OtcCurrencyFinanceRecordPresenter) OtcCurrencyFinanceRecordActivity.this.getPresenter()).i0() == 1) {
                    OtcCurrencyFinanceRecordActivity.this.f46723i.add(new MenuItem("", OtcCurrencyFinanceRecordActivity.this.getString(R.string.transfer_history_type_all), MenuItem.MenuItemStyle.STRESS, OtcCurrencyFinanceRecordActivity.this.f46726l));
                    List Xf = OtcCurrencyFinanceRecordActivity.this.f46723i;
                    String string = OtcCurrencyFinanceRecordActivity.this.getString(R.string.n_transfer_from_margin);
                    MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
                    Xf.add(new MenuItem("", string, menuItemStyle, OtcCurrencyFinanceRecordActivity.this.f46726l));
                    OtcCurrencyFinanceRecordActivity.this.f46723i.add(new MenuItem("", OtcCurrencyFinanceRecordActivity.this.getString(R.string.n_transfer_to_margin), menuItemStyle, OtcCurrencyFinanceRecordActivity.this.f46726l));
                } else {
                    OtcCurrencyFinanceRecordActivity.this.f46723i.add(new MenuItem("", OtcCurrencyFinanceRecordActivity.this.getString(R.string.otc_balance_detail_history_type_all), MenuItem.MenuItemStyle.STRESS, OtcCurrencyFinanceRecordActivity.this.f46726l));
                    List Xf2 = OtcCurrencyFinanceRecordActivity.this.f46723i;
                    String string2 = OtcCurrencyFinanceRecordActivity.this.getString(R.string.otc_balance_detail_sell);
                    MenuItem.MenuItemStyle menuItemStyle2 = MenuItem.MenuItemStyle.COMMON;
                    Xf2.add(new MenuItem("", string2, menuItemStyle2, OtcCurrencyFinanceRecordActivity.this.f46726l));
                    OtcCurrencyFinanceRecordActivity.this.f46723i.add(new MenuItem("", OtcCurrencyFinanceRecordActivity.this.getString(R.string.otc_balance_detail_buy), menuItemStyle2, OtcCurrencyFinanceRecordActivity.this.f46726l));
                    OtcCurrencyFinanceRecordActivity.this.f46723i.add(new MenuItem("", OtcCurrencyFinanceRecordActivity.this.getString(R.string.otc_balance_detail_in), menuItemStyle2, OtcCurrencyFinanceRecordActivity.this.f46726l));
                    OtcCurrencyFinanceRecordActivity.this.f46723i.add(new MenuItem("", OtcCurrencyFinanceRecordActivity.this.getString(R.string.otc_balance_detail_out), menuItemStyle2, OtcCurrencyFinanceRecordActivity.this.f46726l));
                    OtcCurrencyFinanceRecordActivity.this.f46723i.add(new MenuItem("", OtcCurrencyFinanceRecordActivity.this.getString(R.string.n_otc_balance_detail_deposit), menuItemStyle2, OtcCurrencyFinanceRecordActivity.this.f46726l));
                    OtcCurrencyFinanceRecordActivity.this.f46723i.add(new MenuItem("", OtcCurrencyFinanceRecordActivity.this.getString(R.string.otc_balance_detail_fee), menuItemStyle2, OtcCurrencyFinanceRecordActivity.this.f46726l));
                    OtcCurrencyFinanceRecordActivity.this.f46723i.add(new MenuItem("", OtcCurrencyFinanceRecordActivity.this.getString(R.string.otc_balance_detail_legal), menuItemStyle2, OtcCurrencyFinanceRecordActivity.this.f46726l));
                }
            }
            OtcCurrencyFinanceRecordActivity.this.f46722h.setMenuItems(OtcCurrencyFinanceRecordActivity.this.f46723i);
            OtcCurrencyFinanceRecordActivity.this.f46722h.show(OtcCurrencyFinanceRecordActivity.this.getFragmentManager(), "BottomMenuFragment");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements MenuItemOnClickListener {
        public b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
            if (r7 != 2) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0063, code lost:
            r5 = 5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClickMenuItem(android.view.View r5, com.huobi.view.bottompopfragmentmenu.MenuItem r6, int r7) {
            /*
                r4 = this;
                com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity r5 = com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity.this
                com.huobi.view.bottompopfragmentmenu.BottomMenuFragment r5 = r5.f46722h
                r5.dismiss()
                com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity r5 = com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity.this
                android.widget.TextView r5 = r5.f46719e
                java.lang.String r6 = r6.getText()
                r5.setText(r6)
                r5 = 0
            L_0x0017:
                com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity r6 = com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity.this
                java.util.List r6 = r6.f46723i
                int r6 = r6.size()
                if (r5 >= r6) goto L_0x003c
                com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity r6 = com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity.this
                java.util.List r6 = r6.f46723i
                java.lang.Object r6 = r6.get(r5)
                com.huobi.view.bottompopfragmentmenu.MenuItem r6 = (com.huobi.view.bottompopfragmentmenu.MenuItem) r6
                if (r5 != r7) goto L_0x0034
                com.huobi.view.bottompopfragmentmenu.MenuItem$MenuItemStyle r0 = com.huobi.view.bottompopfragmentmenu.MenuItem.MenuItemStyle.STRESS
                goto L_0x0036
            L_0x0034:
                com.huobi.view.bottompopfragmentmenu.MenuItem$MenuItemStyle r0 = com.huobi.view.bottompopfragmentmenu.MenuItem.MenuItemStyle.COMMON
            L_0x0036:
                r6.setStyle(r0)
                int r5 = r5 + 1
                goto L_0x0017
            L_0x003c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity r6 = com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity.this
                com.hbg.lib.common.mvp.ActivityPresenter r6 = r6.getPresenter()
                com.huobi.finance.presenter.OtcCurrencyFinanceRecordPresenter r6 = (com.huobi.finance.presenter.OtcCurrencyFinanceRecordPresenter) r6
                int r6 = r6.i0()
                r0 = 6
                r1 = 5
                r2 = 2
                r3 = 1
                if (r6 != r3) goto L_0x0055
                if (r7 == r3) goto L_0x0061
                if (r7 == r2) goto L_0x0063
                goto L_0x0068
            L_0x0055:
                switch(r7) {
                    case 1: goto L_0x0067;
                    case 2: goto L_0x0065;
                    case 3: goto L_0x0063;
                    case 4: goto L_0x0061;
                    case 5: goto L_0x005f;
                    case 6: goto L_0x005c;
                    case 7: goto L_0x0059;
                    default: goto L_0x0058;
                }
            L_0x0058:
                goto L_0x0068
            L_0x0059:
                r5 = 43
                goto L_0x0068
            L_0x005c:
                r5 = 45
                goto L_0x0068
            L_0x005f:
                r5 = 7
                goto L_0x0068
            L_0x0061:
                r5 = r0
                goto L_0x0068
            L_0x0063:
                r5 = r1
                goto L_0x0068
            L_0x0065:
                r5 = 3
                goto L_0x0068
            L_0x0067:
                r5 = r2
            L_0x0068:
                com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity r6 = com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity.this
                com.hbg.lib.common.mvp.ActivityPresenter r6 = r6.getPresenter()
                com.huobi.finance.presenter.OtcCurrencyFinanceRecordPresenter r6 = (com.huobi.finance.presenter.OtcCurrencyFinanceRecordPresenter) r6
                r6.v0(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.ui.OtcCurrencyFinanceRecordActivity.b.onClickMenuItem(android.view.View, com.huobi.view.bottompopfragmentmenu.MenuItem, int):void");
        }
    }

    /* renamed from: Pg */
    public OtcCurrencyFinanceRecordPresenter createPresenter() {
        return new OtcCurrencyFinanceRecordPresenter();
    }

    /* renamed from: Qg */
    public OtcCurrencyFinanceRecordPresenter.b getUI() {
        return this;
    }

    public RecyclerView Y0() {
        return this.f46718d;
    }

    public void addEvent() {
        this.f46719e.setClickable(true);
        this.f46719e.setOnClickListener(new a());
    }

    public LoadingLayout f6() {
        return this.f46716b;
    }

    public void f9(String str) {
        this.f46725k.setTitle(str);
    }

    public int getContentView() {
        return R.layout.activity_otc_currency_finance_record;
    }

    public void initView() {
        this.f46716b = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f46718d = (RecyclerView) this.viewFinder.b(R.id.currency_history_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.f46718d.setLayoutManager(linearLayoutManager);
        this.f46718d.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_large_divider_color), PixelUtils.a(1.0f), false, false));
        this.f46717c = (SmartRefreshLayout) this.viewFinder.b(R.id.currency_history_refresh_layout);
        this.f46719e = (TextView) this.viewFinder.b(R.id.currency_history_type_select);
        this.f46721g = (AppBarLayout) this.viewFinder.b(R.id.currency_history_appbar_layout);
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.currency_history_toolbar);
        this.f46720f = toolbar;
        toolbar.setTitle((CharSequence) getResources().getString(R.string.currency_history_title));
        setToolBar(this.f46720f, getResources().getString(R.string.currency_history_title), true);
        this.f46724j = (CoordinatorLayout) this.viewFinder.b(R.id.main_content);
        this.f46725k = (CollapsingToolbarLayout) this.viewFinder.b(R.id.currency_history_collapsing_toolbar);
    }

    public SmartRefreshLayout t2() {
        return this.f46717c;
    }
}
