package com.huobi.finance.ui;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.finance.bean.TransferOrderHistory;
import com.huobi.finance.presenter.TransferOrderPresenter;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.huobi.view.rv.CommonVerticalDividerItemDecoration;
import com.huobi.view.title.HbTitleBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class TransferOrderActivity extends BaseActivity<TransferOrderPresenter, TransferOrderPresenter.d> implements TransferOrderPresenter.d {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f46803b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f46804c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f46805d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f46806e;

    /* renamed from: f  reason: collision with root package name */
    public CollapsingToolbarLayout f46807f;

    /* renamed from: g  reason: collision with root package name */
    public Toolbar f46808g;

    /* renamed from: h  reason: collision with root package name */
    public BottomMenuFragment f46809h = new BottomMenuFragment();

    /* renamed from: i  reason: collision with root package name */
    public List<MenuItem> f46810i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public ImageView f46811j;

    /* renamed from: k  reason: collision with root package name */
    public String f46812k;

    /* renamed from: l  reason: collision with root package name */
    public CoordinatorLayout f46813l;

    /* renamed from: m  reason: collision with root package name */
    public HbTitleBar f46814m;

    /* renamed from: n  reason: collision with root package name */
    public MenuItemOnClickListener f46815n = new b();

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TransferOrderActivity.this.f46809h.setMenuItems(TransferOrderActivity.this.f46810i);
            TransferOrderActivity.this.f46809h.show(TransferOrderActivity.this.getFragmentManager(), "BottomMenuFragment");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements MenuItemOnClickListener {
        public b() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            String str;
            MenuItem.MenuItemStyle menuItemStyle;
            TransferOrderActivity.this.f46809h.dismiss();
            if (i11 == 0) {
                TransferOrderActivity.this.f46811j.setImageResource(R.drawable.global_filter_unselected);
            } else {
                TransferOrderActivity.this.f46811j.setImageResource(R.drawable.global_filter_selected);
            }
            for (int i12 = 0; i12 < TransferOrderActivity.this.f46810i.size(); i12++) {
                MenuItem menuItem2 = (MenuItem) TransferOrderActivity.this.f46810i.get(i12);
                if (i12 == i11) {
                    menuItemStyle = MenuItem.MenuItemStyle.STRESS;
                } else {
                    menuItemStyle = MenuItem.MenuItemStyle.COMMON;
                }
                menuItem2.setStyle(menuItemStyle);
            }
            if (TransferOrderActivity.this.f46812k.equals("type_load_repay")) {
                if (i11 == 0) {
                    str = TransferOrderHistory.TYPE_LOAN_REPAY_ALL;
                } else if (i11 == 1) {
                    str = "apply-loan";
                } else if (i11 == 2) {
                    str = TransferOrderHistory.TYPE_LOAN_REPAY_REPAY;
                } else if (i11 == 3) {
                    str = TransferOrderHistory.TYPE_LOAN_REPAY_FEES;
                }
                ((TransferOrderPresenter) TransferOrderActivity.this.getPresenter()).Z(str);
            } else if (TransferOrderActivity.this.f46812k.equals("type_super_load_repay")) {
                if (i11 == 0) {
                    str = TransferOrderHistory.TYPE_SUPER_ALL;
                } else if (i11 == 1) {
                    str = TransferOrderHistory.TYPE_SUPER_USER_LOAN;
                } else if (i11 == 2) {
                    str = TransferOrderHistory.TYPE_SUPER_USER_REPAY;
                } else if (i11 == 3) {
                    str = TransferOrderHistory.TYPE_SUPER_SYSTEM_REPAY;
                }
                ((TransferOrderPresenter) TransferOrderActivity.this.getPresenter()).Z(str);
            } else if (TransferOrderActivity.this.f46812k.equals("type_margin")) {
                if (i11 == 0) {
                    str = "margin-transfer-in,margin-transfer-out";
                } else if (i11 == 1) {
                    str = "margin-transfer-out";
                } else if (i11 == 2) {
                    str = "margin-transfer-in";
                }
                ((TransferOrderPresenter) TransferOrderActivity.this.getPresenter()).Z(str);
            }
            str = "";
            ((TransferOrderPresenter) TransferOrderActivity.this.getPresenter()).Z(str);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        this.f46809h.setMenuItems(this.f46810i);
        this.f46809h.show(getFragmentManager(), "BottomMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ph(View view) {
        this.f46809h.setMenuItems(this.f46810i);
        this.f46809h.show(getFragmentManager(), "BottomMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Qg */
    public TransferOrderPresenter createPresenter() {
        return new TransferOrderPresenter();
    }

    public RecyclerView Y0() {
        return this.f46805d;
    }

    public void addEvent() {
        this.f46811j.setClickable(true);
        this.f46811j.setOnClickListener(new a());
        this.f46814m.setOnClickActionListener(new x7(this));
        this.f46814m.setOnClickListener(new y7(this));
    }

    public LoadingLayout f6() {
        return this.f46803b;
    }

    public int getContentView() {
        return R.layout.activity_transfer_order;
    }

    public void initView() {
        this.f46803b = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f46804c = (SmartRefreshLayout) this.viewFinder.b(R.id.transferPtrFrame);
        this.f46805d = (RecyclerView) this.viewFinder.b(R.id.transfer_order_rv);
        this.f46811j = (ImageView) this.viewFinder.b(R.id.transfer_select_tv);
        this.f46814m = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.f46805d.addItemDecoration(new CommonVerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_item_bg), ContextCompat.getDrawable(this, R.color.global_divider_color), PixelUtils.a(10.0f), PixelUtils.a(0.5f), true));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f46806e = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.f46805d.setLayoutManager(this.f46806e);
        this.f46808g = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f46807f = (CollapsingToolbarLayout) this.viewFinder.b(R.id.collapsing_toolbar);
        this.f46813l = (CoordinatorLayout) this.viewFinder.b(R.id.cl_root);
    }

    /* renamed from: oh */
    public TransferOrderPresenter.d getUI() {
        return this;
    }

    public void qa(String str) {
        this.f46812k = str;
        if (str.equals("type_margin")) {
            this.f46807f.setTitle(getString(R.string.transfer_history_title));
            setToolBar(this.f46808g, getResources().getString(R.string.transfer_history_title), true);
            this.f46814m.setTitle(getResources().getString(R.string.transfer_history_title));
            this.f46810i.add(new MenuItem("", getString(R.string.transfer_history_type_all), MenuItem.MenuItemStyle.STRESS, this.f46815n));
            List<MenuItem> list = this.f46810i;
            String string = getString(R.string.n_transfer_from_margin);
            MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
            list.add(new MenuItem("", string, menuItemStyle, this.f46815n));
            this.f46810i.add(new MenuItem("", getString(R.string.n_transfer_to_margin), menuItemStyle, this.f46815n));
        } else if (str.equals("type_load_repay")) {
            this.f46807f.setTitle(getString(R.string.n_balance_detail_records));
            setToolBar(this.f46808g, getResources().getString(R.string.n_balance_detail_records), true);
            this.f46814m.setTitle(getResources().getString(R.string.n_balance_detail_records));
            this.f46810i.add(new MenuItem("", getString(R.string.margin_records_type_all), MenuItem.MenuItemStyle.STRESS, this.f46815n));
            List<MenuItem> list2 = this.f46810i;
            String string2 = getString(R.string.margin_records_type_loan);
            MenuItem.MenuItemStyle menuItemStyle2 = MenuItem.MenuItemStyle.COMMON;
            list2.add(new MenuItem("", string2, menuItemStyle2, this.f46815n));
            this.f46810i.add(new MenuItem("", getString(R.string.margin_records_type_repay), menuItemStyle2, this.f46815n));
            this.f46810i.add(new MenuItem("", getString(R.string.margin_records_type_fees), menuItemStyle2, this.f46815n));
        } else if (str.equals("type_super_load_repay")) {
            this.f46807f.setTitle(getString(R.string.n_balance_detail_records));
            setToolBar(this.f46808g, getResources().getString(R.string.n_balance_detail_records), true);
            this.f46814m.setTitle(getResources().getString(R.string.n_balance_detail_records));
            this.f46810i.add(new MenuItem("", getString(R.string.margin_records_type_all), MenuItem.MenuItemStyle.STRESS, this.f46815n));
            List<MenuItem> list3 = this.f46810i;
            String string3 = getString(R.string.user_loan);
            MenuItem.MenuItemStyle menuItemStyle3 = MenuItem.MenuItemStyle.COMMON;
            list3.add(new MenuItem("", string3, menuItemStyle3, this.f46815n));
            this.f46810i.add(new MenuItem("", getString(R.string.user_repay), menuItemStyle3, this.f46815n));
            this.f46810i.add(new MenuItem("", getString(R.string.system_repay), menuItemStyle3, this.f46815n));
        }
    }

    public SmartRefreshLayout t2() {
        return this.f46804c;
    }
}
