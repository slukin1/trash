package com.huobi.finance.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bj.d;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.future.bean.FutureProductInfo;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import com.huobi.contract.entity.OptionBalanceItem;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.presenter.OptionDetailPresenter;
import com.huobi.finance.utils.AssetNumberUtil;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;

public class OptionDetailActivity extends BaseAssetDetailActivity {
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;

    /* renamed from: s  reason: collision with root package name */
    public View f46685s;

    /* renamed from: t  reason: collision with root package name */
    public View f46686t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f46687u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f46688v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f46689w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f46690x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f46691y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f46692z;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("currency_name", k.C().z(this.f46394c));
        g.i("app_assets_derivatives_details_transfer_click", hashMap);
        UnifyTransferActivity.Th(this, this.f46394c, CouponReturn.TYPE_EXPERIENCE);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("currency_name", k.C().z(this.f46394c));
        g.i("app_assets_derivatives_details_contract_trade_click", hashMap);
        if (getPresenter() instanceof OptionDetailPresenter) {
            ((OptionDetailPresenter) getPresenter()).c0();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Bh */
    public OptionDetailPresenter createPresenter() {
        return new OptionDetailPresenter();
    }

    public final void Ch(TextView textView, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "--";
        } else {
            str2 = AssetNumberUtil.a(str, FuturePrecisionUtil.o(this.f46394c));
        }
        textView.setText(str2);
    }

    public final void Dh(TextView textView, int i11, String str) {
        textView.setText(String.format(getString(i11), new Object[]{str}));
    }

    public void Qg(int i11) {
        String str;
        int i12 = i11 >= 3 ? i11 + 1 : i11;
        BaseAssetDetailPresenter baseAssetDetailPresenter = (BaseAssetDetailPresenter) getPresenter();
        if (i11 == 0) {
            str = null;
        } else {
            str = d.i(i12);
        }
        baseAssetDetailPresenter.V(str);
    }

    public void addEvent() {
        super.addEvent();
        this.f46685s.setOnClickListener(new y6(this));
        this.f46686t.setOnClickListener(new z6(this));
    }

    public int getContentView() {
        return R.layout.activity_option_detail;
    }

    public void initView() {
        super.initView();
        this.f46688v = (TextView) findViewById(R.id.tv_label_option_rights);
        this.f46689w = (TextView) findViewById(R.id.tv_label_option_static_rights);
        this.f46690x = (TextView) findViewById(R.id.tv_label_option_available);
        this.f46691y = (TextView) findViewById(R.id.tv_content_option_rights);
        this.f46692z = (TextView) findViewById(R.id.tv_content_option_static_rights);
        this.A = (TextView) findViewById(R.id.tv_content_option_available);
        this.B = (TextView) findViewById(R.id.tv_label_option_cover_asset);
        this.C = (TextView) findViewById(R.id.tv_label_option_frozen_rights);
        this.D = (TextView) findViewById(R.id.tv_label_option_frozen_asset);
        this.E = (TextView) findViewById(R.id.tv_content_option_cover_asset);
        this.F = (TextView) findViewById(R.id.tv_content_option_frozen_rights);
        this.G = (TextView) findViewById(R.id.tv_content_option_frozen_asset);
        this.H = (TextView) findViewById(R.id.tv_label_option_future_benefit);
        this.I = (TextView) findViewById(R.id.tv_label_option_real_benefit);
        this.J = (TextView) findViewById(R.id.tv_content_option_future_benefit);
        this.K = (TextView) findViewById(R.id.tv_content_option_real_benefit);
        this.f46685s = this.viewFinder.b(R.id.currency_detail_transfer);
        this.f46686t = this.viewFinder.b(R.id.currency_detail_contract);
        this.f46687u = (TextView) this.viewFinder.b(R.id.currency_detail_contract_trade_tv);
    }

    public List<MenuItem> oh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MenuItem("", getString(R.string.otc_balance_detail_history_type_all), MenuItem.MenuItemStyle.STRESS, this.f46408q));
        String k11 = d.k(1);
        String string = getString(R.string.currency_detail_contract_status_open);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        arrayList.add(new MenuItem(k11, string, menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_contract_status_flat), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_contract_status_settle), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_transfer_out), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_transfer_in), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_contract_status_fee), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_contract_status_reward), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_system), menuItemStyle, this.f46408q));
        return arrayList;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            ((BaseAssetDetailPresenter) getPresenter()).W();
        }
    }

    public void pb(BaseAssetInfo baseAssetInfo) {
        super.pb(baseAssetInfo);
        if (baseAssetInfo instanceof OptionBalanceItem) {
            OptionAccountInfo mAccountInfo = ((OptionBalanceItem) baseAssetInfo).getMAccountInfo();
            String symbol = mAccountInfo.getSymbol();
            this.f46394c = symbol;
            String i11 = StringUtils.i(symbol);
            StringUtils.i("usdt");
            yh(i11);
            Dh(this.f46688v, R.string.n_balance_option_rights, i11);
            Dh(this.f46689w, R.string.n_balance_option_static_rights, i11);
            Dh(this.f46690x, R.string.n_balance_option_available, i11);
            Dh(this.B, R.string.n_balance_option_cover_asset, i11);
            this.C.setText(R.string.n_balance_option_frozen_rights);
            this.D.setText(R.string.n_balance_option_frozen_asset);
            Dh(this.H, R.string.n_balance_option_future_benefit, i11);
            Dh(this.I, R.string.n_balance_option_real_benefit, i11);
            Ch(this.f46691y, mAccountInfo.getMarginBalance());
            Ch(this.f46692z, mAccountInfo.getMarginStatic());
            Ch(this.A, mAccountInfo.getMarginAvailable());
            Ch(this.E, mAccountInfo.getMarginPosition());
            Ch(this.F, mAccountInfo.getPremiumFrozen());
            Ch(this.G, mAccountInfo.getMarginFrozen());
            Ch(this.J, mAccountInfo.getProfitUnreal());
            Ch(this.K, mAccountInfo.getProfitReal());
            FutureProductInfo g11 = FutureProductInfoController.d().g(this.f46394c);
            if (g11 != null && g11.getIsTrade() == 0) {
                this.f46686t.setEnabled(false);
                this.f46687u.setTextColor(ContextCompat.getColor(this, R.color.baseColorThreeLevelText));
            }
        }
    }

    public int ph() {
        return R.string.currency_detail_contract_finance_title;
    }

    public boolean wh() {
        return false;
    }
}
