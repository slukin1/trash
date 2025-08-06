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
import com.huobi.finance.presenter.ContractFinanceRecordPresenter;
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

public class ContractFinanceRecordActivity extends BaseActivity<ContractFinanceRecordPresenter, ContractFinanceRecordPresenter.b> implements ContractFinanceRecordPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f46429b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f46430c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f46431d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46432e;

    /* renamed from: f  reason: collision with root package name */
    public Toolbar f46433f;

    /* renamed from: g  reason: collision with root package name */
    public AppBarLayout f46434g;

    /* renamed from: h  reason: collision with root package name */
    public BottomMenuFragment f46435h = new BottomMenuFragment();

    /* renamed from: i  reason: collision with root package name */
    public List<MenuItem> f46436i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public CoordinatorLayout f46437j;

    /* renamed from: k  reason: collision with root package name */
    public CollapsingToolbarLayout f46438k;

    /* renamed from: l  reason: collision with root package name */
    public MenuItemOnClickListener f46439l = new b();

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (ContractFinanceRecordActivity.this.f46436i.isEmpty()) {
                ContractFinanceRecordActivity.this.f46436i.add(new MenuItem("", ContractFinanceRecordActivity.this.getString(R.string.otc_balance_detail_history_type_all), MenuItem.MenuItemStyle.STRESS, ContractFinanceRecordActivity.this.f46439l));
                List Xf = ContractFinanceRecordActivity.this.f46436i;
                String string = ContractFinanceRecordActivity.this.getString(R.string.currency_detail_contract_status_open);
                MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
                Xf.add(new MenuItem("", string, menuItemStyle, ContractFinanceRecordActivity.this.f46439l));
                ContractFinanceRecordActivity.this.f46436i.add(new MenuItem("", ContractFinanceRecordActivity.this.getString(R.string.currency_detail_contract_status_flat), menuItemStyle, ContractFinanceRecordActivity.this.f46439l));
                ContractFinanceRecordActivity.this.f46436i.add(new MenuItem("", ContractFinanceRecordActivity.this.getString(R.string.currency_detail_contract_status_force_flat), menuItemStyle, ContractFinanceRecordActivity.this.f46439l));
                ContractFinanceRecordActivity.this.f46436i.add(new MenuItem("", ContractFinanceRecordActivity.this.getString(R.string.currency_detail_contract_status_settle), menuItemStyle, ContractFinanceRecordActivity.this.f46439l));
                ContractFinanceRecordActivity.this.f46436i.add(new MenuItem("", ContractFinanceRecordActivity.this.getString(R.string.currency_detail_transfer_out), menuItemStyle, ContractFinanceRecordActivity.this.f46439l));
                ContractFinanceRecordActivity.this.f46436i.add(new MenuItem("", ContractFinanceRecordActivity.this.getString(R.string.currency_detail_transfer_in), menuItemStyle, ContractFinanceRecordActivity.this.f46439l));
                ContractFinanceRecordActivity.this.f46436i.add(new MenuItem("", ContractFinanceRecordActivity.this.getString(R.string.currency_detail_contract_status_fee), menuItemStyle, ContractFinanceRecordActivity.this.f46439l));
                ContractFinanceRecordActivity.this.f46436i.add(new MenuItem("", ContractFinanceRecordActivity.this.getString(R.string.currency_detail_contract_status_reward), menuItemStyle, ContractFinanceRecordActivity.this.f46439l));
                ContractFinanceRecordActivity.this.f46436i.add(new MenuItem("", ContractFinanceRecordActivity.this.getString(R.string.currency_detail_system), menuItemStyle, ContractFinanceRecordActivity.this.f46439l));
            }
            ContractFinanceRecordActivity.this.f46435h.setMenuItems(ContractFinanceRecordActivity.this.f46436i);
            ContractFinanceRecordActivity.this.f46435h.show(ContractFinanceRecordActivity.this.getFragmentManager(), "BottomMenuFragment");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements MenuItemOnClickListener {
        public b() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            MenuItem.MenuItemStyle menuItemStyle;
            ContractFinanceRecordActivity.this.f46435h.dismiss();
            ContractFinanceRecordActivity.this.f46432e.setText(menuItem.getText());
            for (int i12 = 0; i12 < ContractFinanceRecordActivity.this.f46436i.size(); i12++) {
                MenuItem menuItem2 = (MenuItem) ContractFinanceRecordActivity.this.f46436i.get(i12);
                if (i12 == i11) {
                    menuItemStyle = MenuItem.MenuItemStyle.STRESS;
                } else {
                    menuItemStyle = MenuItem.MenuItemStyle.COMMON;
                }
                menuItem2.setStyle(menuItemStyle);
            }
            int i13 = Integer.MIN_VALUE;
            switch (i11) {
                case 1:
                    i13 = 1;
                    break;
                case 2:
                    i13 = 2;
                    break;
                case 3:
                    i13 = 3;
                    break;
                case 4:
                    i13 = 4;
                    break;
                case 5:
                    i13 = 5;
                    break;
                case 6:
                    i13 = 6;
                    break;
                case 7:
                    i13 = 7;
                    break;
                case 8:
                    i13 = 8;
                    break;
                case 9:
                    i13 = 9;
                    break;
            }
            ((ContractFinanceRecordPresenter) ContractFinanceRecordActivity.this.getPresenter()).W(i13);
        }
    }

    /* renamed from: Og */
    public ContractFinanceRecordPresenter.b getUI() {
        return this;
    }

    public RecyclerView Y0() {
        return this.f46431d;
    }

    public void addEvent() {
        this.f46432e.setClickable(true);
        this.f46432e.setOnClickListener(new a());
    }

    public LoadingLayout f6() {
        return this.f46429b;
    }

    public int getContentView() {
        return R.layout.activity_contract_currency_finance_record;
    }

    /* renamed from: gg */
    public ContractFinanceRecordPresenter createPresenter() {
        return new ContractFinanceRecordPresenter();
    }

    public void initView() {
        this.f46429b = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f46431d = (RecyclerView) this.viewFinder.b(R.id.currency_history_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.f46431d.setLayoutManager(linearLayoutManager);
        this.f46431d.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_large_divider_color), PixelUtils.a(1.0f), false, false));
        this.f46430c = (SmartRefreshLayout) this.viewFinder.b(R.id.currency_history_refresh_layout);
        this.f46432e = (TextView) this.viewFinder.b(R.id.currency_history_type_select);
        this.f46434g = (AppBarLayout) this.viewFinder.b(R.id.currency_history_appbar_layout);
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.currency_history_toolbar);
        this.f46433f = toolbar;
        toolbar.setTitle((CharSequence) getResources().getString(R.string.currency_detail_contract_finance));
        setToolBar(this.f46433f, getResources().getString(R.string.currency_detail_contract_finance_title), true);
        this.f46437j = (CoordinatorLayout) this.viewFinder.b(R.id.main_content);
        this.f46438k = (CollapsingToolbarLayout) this.viewFinder.b(R.id.currency_history_collapsing_toolbar);
    }

    public SmartRefreshLayout t2() {
        return this.f46430c;
    }
}
