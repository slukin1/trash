package com.huobi.finance.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.bean.SavingsDetailInfo;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.presenter.SavingsCurrencyDetailPresenter;
import com.huobi.savings.ui.SavingsDataActivity;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;

public class SavingsCurrencyDetailActivity extends BaseAssetDetailActivity {

    /* renamed from: s  reason: collision with root package name */
    public TextView f46775s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f46776t;

    /* renamed from: u  reason: collision with root package name */
    public View f46777u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f46778v;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        startActivity(new Intent(this, SavingsDataActivity.class));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Ah */
    public SavingsCurrencyDetailPresenter createPresenter() {
        return new SavingsCurrencyDetailPresenter();
    }

    public void Qg(int i11) {
        ((BaseAssetDetailPresenter) getPresenter()).V(i11 != 1 ? i11 != 2 ? FinanceRecordItem.TYPE_SAVINGS_ALL : FinanceRecordItem.TYPE_SAVINGS_TRANSFER_OUT : FinanceRecordItem.TYPE_SAVINGS_TRANSFER_IN);
    }

    public void addEvent() {
        super.addEvent();
        this.f46777u.setOnClickListener(new o7(this));
    }

    public int getContentView() {
        return R.layout.activity_savings_currency_detail;
    }

    public void initView() {
        super.initView();
        removeWinBg();
        this.f46775s = (TextView) this.viewFinder.b(R.id.currency_detail_avaialbe_amount);
        this.f46776t = (TextView) this.viewFinder.b(R.id.currency_detail_onorders_amount);
        this.f46778v = (TextView) this.viewFinder.b(R.id.currency_detail_estimate_amount);
        this.f46777u = this.viewFinder.b(R.id.iv_currency_detail_savings);
        ((TextView) this.viewFinder.b(R.id.currency_detail_desc_estimate)).setText(String.format(getResources().getString(R.string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
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

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            ((BaseAssetDetailPresenter) getPresenter()).W();
        }
    }

    public void pb(BaseAssetInfo baseAssetInfo) {
        super.pb(baseAssetInfo);
        if (baseAssetInfo instanceof SavingsDetailInfo) {
            SavingsDetailInfo savingsDetailInfo = (SavingsDetailInfo) baseAssetInfo;
            String u02 = m.u0(savingsDetailInfo.getAvaialAble(), 12, 8);
            this.f46776t.setText(m.u0(m.a(savingsDetailInfo.getLending()).toPlainString(), 12, 8));
            this.f46775s.setText(u02);
            this.f46778v.setText(savingsDetailInfo.getEstimateAmount());
        }
    }

    public boolean wh() {
        return false;
    }
}
