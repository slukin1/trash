package com.huobi.otcoption.ui;

import android.view.View;
import android.widget.TextView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.presenter.OtcOptionsDetailPresenter;
import com.huobi.finance.ui.BaseAssetDetailActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import wp.a;

public class OtcOptionsDetailActivity extends BaseAssetDetailActivity {

    /* renamed from: s  reason: collision with root package name */
    public TextView f80220s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f80221t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f80222u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f80223v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f80224w;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        UnifyTransferActivity.Th(this, this.f46394c, "12");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Ah */
    public BaseAssetDetailPresenter createPresenter() {
        return new OtcOptionsDetailPresenter();
    }

    public void Qg(int i11) {
        ((BaseAssetDetailPresenter) getPresenter()).V(i11 != 1 ? i11 != 2 ? FinanceRecordItem.TYPE_OTC_OPTIONS_BETWEEN_PRO : FinanceRecordItem.TYPE_OTC_OPTIONS_TO_PRO : FinanceRecordItem.TYPE_PRO_TO_OTC_OPTIONS);
    }

    public void addEvent() {
        super.addEvent();
        this.viewFinder.b(R.id.currency_detail_transfer).setOnClickListener(new a(this));
    }

    public int getContentView() {
        return R.layout.activity_otc_options_currency_detail;
    }

    public void initView() {
        super.initView();
        removeWinBg();
        this.f80220s = (TextView) this.viewFinder.b(R.id.currency_detail_avaialbe_amount);
        this.f80221t = (TextView) this.viewFinder.b(R.id.currency_detail_onorders_amount);
        this.f80222u = (TextView) this.viewFinder.b(R.id.currency_detail_lock_amount);
        this.f80224w = (TextView) this.viewFinder.b(R.id.currency_detail_estimate_amount);
        TextView textView = (TextView) this.viewFinder.b(R.id.currency_detail_desc_estimate);
        this.f80223v = textView;
        textView.setText(String.format(getResources().getString(R.string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.d().toUpperCase(Locale.US)}));
    }

    public List<MenuItem> oh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MenuItem("", getString(R.string.currency_history_type_all), MenuItem.MenuItemStyle.STRESS, this.f46408q));
        String string = getString(R.string.currency_history_type_transfer_in);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        arrayList.add(new MenuItem("", string, menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_history_type_transfer_out), menuItemStyle, this.f46408q));
        return arrayList;
    }

    public void pb(BaseAssetInfo baseAssetInfo) {
        super.pb(baseAssetInfo);
        if (baseAssetInfo instanceof OtcOptionsDetailInfo) {
            OtcOptionsDetailInfo otcOptionsDetailInfo = (OtcOptionsDetailInfo) baseAssetInfo;
            String u02 = m.u0(otcOptionsDetailInfo.getAvaialAble(), 12, 8);
            this.f80221t.setText(m.u0(otcOptionsDetailInfo.getHoldingsNum(), 12, 8));
            this.f80220s.setText(u02);
            this.f80222u.setVisibility(8);
            this.f80224w.setText(otcOptionsDetailInfo.getEstimateAmount());
        }
    }
}
