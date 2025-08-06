package com.huobi.finance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.grid.bean.GridAccountConvertInfo;
import com.hbg.lib.network.hbg.grid.bean.GridAccountRunningStrategyInfo;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.GridAssetCurrencyListItem;
import com.huobi.finance.bean.GridAssetDetailListItem;
import com.huobi.finance.presenter.GridAssetDetailPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class GridAssetDetailActivity extends BaseActivity<GridAssetDetailPresenter, GridAssetDetailPresenter.b> implements GridAssetDetailPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<GridAssetCurrencyListItem> f46546b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView<GridAssetDetailListItem> f46547c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46548d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46549e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46550f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46551g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46552h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46553i;

    /* renamed from: j  reason: collision with root package name */
    public GridAccountConvertInfo f46554j;

    /* renamed from: k  reason: collision with root package name */
    public GridAssetDetailListItem.a f46555k = new n5(this);

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_SYMBOL", this.f46554j.getSymbol());
        HbgRouter.i(this, "/trade/grid", bundle);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Pg(GridAssetDetailListItem gridAssetDetailListItem) {
        AssetModuleConfig.a().X0(this, String.valueOf(gridAssetDetailListItem.d().getId()));
        finish();
    }

    public static void Qg(Activity activity, GridAccountConvertInfo gridAccountConvertInfo) {
        Intent intent = new Intent(activity, GridAssetDetailActivity.class);
        intent.putExtra("EXTRA_DATA", gridAccountConvertInfo);
        BaseActivity.start(activity, intent);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent() {
        this.viewFinder.b(R$id.id_back_btn).setOnClickListener(new m5(this));
        this.viewFinder.b(R$id.id_grid_asset_detail_trade_layout).setOnClickListener(new l5(this));
    }

    public void afterInit() {
        super.afterInit();
        Intent intent = getIntent();
        if (intent != null) {
            this.f46554j = (GridAccountConvertInfo) intent.getSerializableExtra("EXTRA_DATA");
        }
        TextView textView = this.f46548d;
        textView.setText(this.f46554j.getBaseCurrency() + "/" + this.f46554j.getQuoteCurrency());
        String i11 = StringUtils.i(LegalCurrencyConfigUtil.y());
        this.f46549e.setText(String.format(Locale.US, getString(R$string.n_balance_equivalent_ph), new Object[]{i11}));
        ph();
        oh();
        HashMap hashMap = new HashMap();
        hashMap.put("tradepair_name", this.f46554j.getSymbol());
        BaseModuleConfig.a().w("app_assets_quant_account_details_view", hashMap);
    }

    public void ah(String str, String str2, int i11) {
        this.f46550f.setText(StringUtils.i(this.f46554j.getBaseCurrency()));
        TextView textView = this.f46551g;
        textView.setText("/" + StringUtils.i(this.f46554j.getQuoteCurrency()));
        this.f46552h.setText(str);
        this.f46553i.setText(str2);
        this.f46553i.setTextColor(i11);
    }

    /* renamed from: fg */
    public GridAssetDetailPresenter createPresenter() {
        return new GridAssetDetailPresenter();
    }

    public int getContentView() {
        return R$layout.activity_grid_asset_detail;
    }

    /* renamed from: gg */
    public GridAssetDetailPresenter.b getUI() {
        return this;
    }

    public void initView() {
        this.f46546b = (EasyRecyclerView) this.viewFinder.b(R$id.id_grid_asset_detail_top_recyclerView);
        this.f46547c = (EasyRecyclerView) this.viewFinder.b(R$id.id_grid_asset_detail_recyclerView);
        this.f46548d = (TextView) this.viewFinder.b(R$id.id_grid_asset_detail_symbol);
        this.f46549e = (TextView) this.viewFinder.b(R$id.id_grid_asset_list_item_title_legal);
        this.f46550f = (TextView) this.viewFinder.b(R$id.tv_base_currency);
        this.f46551g = (TextView) this.viewFinder.b(R$id.tv_quote_currency);
        this.f46552h = (TextView) this.viewFinder.b(R$id.tv_price);
        this.f46553i = (TextView) this.viewFinder.b(R$id.tv_rise_rate);
        this.f46550f.setText("--");
        this.f46551g.setText("/--");
        this.f46552h.setText("--");
        this.f46553i.setText("--");
    }

    public String o0() {
        return this.f46554j.getSymbol();
    }

    public final void oh() {
        List<GridAccountRunningStrategyInfo> runningstrategys = this.f46554j.getRunningstrategys();
        ArrayList arrayList = new ArrayList();
        if (runningstrategys != null && !runningstrategys.isEmpty()) {
            for (GridAccountRunningStrategyInfo g11 : runningstrategys) {
                GridAssetDetailListItem gridAssetDetailListItem = new GridAssetDetailListItem();
                gridAssetDetailListItem.h(this.f46554j.getSymbol());
                gridAssetDetailListItem.g(g11);
                gridAssetDetailListItem.f(this.f46555k);
                arrayList.add(gridAssetDetailListItem);
            }
        }
        this.f46547c.setData(arrayList);
    }

    public final void ph() {
        ArrayList arrayList = new ArrayList();
        GridAssetCurrencyListItem gridAssetCurrencyListItem = new GridAssetCurrencyListItem();
        gridAssetCurrencyListItem.j(this.f46554j.getBaseCurrency());
        gridAssetCurrencyListItem.h(this.f46554j.getBaseAmount());
        gridAssetCurrencyListItem.l(LegalCurrencyConfigUtil.D(gridAssetCurrencyListItem.c(), this.f46554j.getSymbol(), TradeType.PRO));
        arrayList.add(gridAssetCurrencyListItem);
        GridAssetCurrencyListItem gridAssetCurrencyListItem2 = new GridAssetCurrencyListItem();
        gridAssetCurrencyListItem2.j(this.f46554j.getQuoteCurrency());
        gridAssetCurrencyListItem2.h(this.f46554j.getQuoteAmount());
        gridAssetCurrencyListItem2.l(LegalCurrencyConfigUtil.B(gridAssetCurrencyListItem2.c()));
        arrayList.add(gridAssetCurrencyListItem2);
        this.f46546b.setData(arrayList);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
