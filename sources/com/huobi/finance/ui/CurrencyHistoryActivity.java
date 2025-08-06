package com.huobi.finance.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.finance.presenter.CurrencyHistoryPresenter;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.rv.CommonVerticalDividerItemDecoration;
import com.huobi.view.title.HbTitleBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class CurrencyHistoryActivity extends BaseActivity<CurrencyHistoryPresenter, CurrencyHistoryPresenter.e> implements CurrencyHistoryPresenter.e {

    /* renamed from: b  reason: collision with root package name */
    public SmartRefreshLayout f46521b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f46522c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f46523d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f46524e;

    /* renamed from: f  reason: collision with root package name */
    public BottomMenuFragment f46525f;

    /* renamed from: g  reason: collision with root package name */
    public List<MenuItem> f46526g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public HbTitleBar f46527h;

    /* renamed from: i  reason: collision with root package name */
    public MenuItemOnClickListener f46528i = new b();

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            MenuItem.MenuItemStyle menuItemStyle;
            if (CurrencyHistoryActivity.this.f46526g.isEmpty()) {
                List<String> Z = ((CurrencyHistoryPresenter) CurrencyHistoryActivity.this.getPresenter()).Z();
                int size = Z.size();
                for (int i11 = 0; i11 < size; i11++) {
                    String str = Z.get(i11);
                    String str2 = Z.get(i11);
                    if (i11 == 0) {
                        menuItemStyle = MenuItem.MenuItemStyle.STRESS;
                    } else {
                        menuItemStyle = MenuItem.MenuItemStyle.COMMON;
                    }
                    CurrencyHistoryActivity.this.f46526g.add(new MenuItem(str, str2, menuItemStyle, CurrencyHistoryActivity.this.f46528i));
                }
                CurrencyHistoryActivity.this.f46525f.setMenuItems(CurrencyHistoryActivity.this.f46526g);
            }
            CurrencyHistoryActivity.this.f46525f.show(CurrencyHistoryActivity.this.getFragmentManager(), "BottomMenuFragment");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements MenuItemOnClickListener {
        public b() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            MenuItem.MenuItemStyle menuItemStyle;
            CurrencyHistoryActivity.this.f46525f.dismiss();
            if (i11 == 0) {
                CurrencyHistoryActivity.this.f46527h.getIvAction().setImageResource(R.drawable.global_filter_unselected);
            } else {
                CurrencyHistoryActivity.this.f46527h.getIvAction().setImageResource(R.drawable.global_filter_selected);
            }
            for (int i12 = 0; i12 < CurrencyHistoryActivity.this.f46526g.size(); i12++) {
                MenuItem menuItem2 = (MenuItem) CurrencyHistoryActivity.this.f46526g.get(i12);
                if (i12 == i11) {
                    menuItemStyle = MenuItem.MenuItemStyle.STRESS;
                } else {
                    menuItemStyle = MenuItem.MenuItemStyle.COMMON;
                }
                menuItem2.setStyle(menuItemStyle);
            }
            ((CurrencyHistoryPresenter) CurrencyHistoryActivity.this.getPresenter()).i0(((CurrencyHistoryPresenter) CurrencyHistoryActivity.this.getPresenter()).b0(i11));
        }
    }

    public static void oh(Activity activity, String str, String str2) {
        ph(activity, str, (String) null, (String) null, str2);
    }

    public static void ph(Activity activity, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(activity, CurrencyHistoryActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("coin", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("JUMP_SYMBOL_PAIR", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra(Constants.FLAG_ACCOUNT, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra("KEY_JUMP_FOR", str4);
        }
        activity.startActivity(intent);
    }

    /* renamed from: Pg */
    public CurrencyHistoryPresenter createPresenter() {
        return new CurrencyHistoryPresenter();
    }

    /* renamed from: Qg */
    public CurrencyHistoryPresenter.e getUI() {
        return this;
    }

    public RecyclerView Y0() {
        return this.f46522c;
    }

    public void addEvent() {
        this.f46527h.setOnClickActionListener(new a());
    }

    public LoadingLayout f6() {
        return this.f46523d;
    }

    public int getContentView() {
        return R.layout.activity_currency_deposit_history;
    }

    public void initView() {
        removeWinBg();
        RecyclerView recyclerView = (RecyclerView) this.viewFinder.b(R.id.hisory_order_rv);
        this.f46522c = recyclerView;
        recyclerView.addItemDecoration(new CommonVerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_item_bg), ContextCompat.getDrawable(this, R.drawable.divider_with_left_margin), PixelUtils.a(10.0f), PixelUtils.a(0.5f), false));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f46524e = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.f46522c.setLayoutManager(this.f46524e);
        this.f46521b = (SmartRefreshLayout) this.viewFinder.b(R.id.tradePtrFrame);
        this.f46523d = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f46527h = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
    }

    public void q2() {
        if ("3".equals(((CurrencyHistoryPresenter) getPresenter()).Y())) {
            if (this.f46525f == null) {
                this.f46525f = new BottomMenuFragment();
            }
            this.f46527h.setTitleRes(R.string.transfer_history_title);
            this.f46527h.getIvAction().setVisibility(0);
            return;
        }
        this.f46527h.setTitleRes(R.string.currency_history_title);
        this.f46527h.getIvAction().setVisibility(8);
    }

    public SmartRefreshLayout t2() {
        return this.f46521b;
    }
}
