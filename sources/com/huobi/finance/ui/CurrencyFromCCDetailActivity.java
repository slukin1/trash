package com.huobi.finance.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.LoadingView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.presenter.CurrencyFromCCDetailPresenter;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import q6.d;
import rx.Observable;
import u6.g;
import uf.c;

public class CurrencyFromCCDetailActivity extends BaseAssetDetailActivity {
    public View A;

    /* renamed from: s  reason: collision with root package name */
    public TextView f46497s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f46498t;

    /* renamed from: u  reason: collision with root package name */
    public View f46499u;

    /* renamed from: v  reason: collision with root package name */
    public View f46500v;

    /* renamed from: w  reason: collision with root package name */
    public View f46501w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f46502x;

    /* renamed from: y  reason: collision with root package name */
    public View f46503y;

    /* renamed from: z  reason: collision with root package name */
    public LoadingView f46504z;

    public interface a {
        void onBack();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kh(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lh(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ((CurrencyFromCCDetailPresenter) getPresenter()).f0(0, this.f46394c);
        HashMap hashMap = new HashMap();
        hashMap.put("fiat_name", this.f46394c);
        c.b().j("click_deposit", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mh(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ((CurrencyFromCCDetailPresenter) getPresenter()).f0(1, this.f46394c);
        HashMap hashMap = new HashMap();
        hashMap.put("fiat_name", this.f46394c);
        c.b().k("click_withdraw", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ Observable Oh(BalanceDataTotal balanceDataTotal) {
        List<? extends BaseAssetInfo> detailInfos = balanceDataTotal != null ? balanceDataTotal.getDetailInfos() : null;
        if (detailInfos != null && !detailInfos.isEmpty()) {
            return Observable.from(detailInfos);
        }
        throw new NullPointerException("Get balance data is null.");
    }

    public static /* synthetic */ BalanceDetailInfo Qh(BaseAssetInfo baseAssetInfo) {
        return (BalanceDetailInfo) baseAssetInfo;
    }

    public static /* synthetic */ void Sh(Context context, a aVar, BalanceDetailInfo balanceDetailInfo) {
        Intent intent = new Intent(context, CurrencyFromCCDetailActivity.class);
        intent.putExtra("currency_detail_info", balanceDetailInfo);
        context.startActivity(intent);
        if (aVar != null) {
            aVar.onBack();
        }
    }

    public static void Uh(Context context, g gVar, String str, a aVar) {
        AssetDataCacheManager.k0().q0().flatMap(s4.f47319b).filter(t4.f47334b).map(u4.f47348b).filter(new r4(str)).compose(RxJavaHelper.t(gVar)).first().subscribe(d.c(gVar, new q4(context, aVar)));
    }

    /* renamed from: Ih */
    public CurrencyFromCCDetailPresenter createPresenter() {
        return new CurrencyFromCCDetailPresenter();
    }

    public final void Jh() {
        String str = this.f46394c;
        if (str != null) {
            UnifyTransferActivity.Th(this, str, "2");
        }
    }

    public void Qg(int i11) {
        int i12 = 3;
        if (i11 == 1) {
            i12 = 1;
        } else if (i11 == 2) {
            i12 = 2;
        } else if (i11 != 3) {
            i12 = 0;
        }
        ((CurrencyFromCCDetailPresenter) getPresenter()).g0(i12);
    }

    public void Th(boolean z11) {
        if (z11) {
            this.f46503y.setVisibility(0);
            this.f46504z.c();
            return;
        }
        this.f46504z.d();
        this.f46503y.setVisibility(8);
    }

    public void addEvent() {
        super.addEvent();
        this.f46501w.setOnClickListener(new o4(this));
        this.f46499u.setOnClickListener(new m4(this));
        this.f46500v.setOnClickListener(new n4(this));
        this.f46503y.setOnClickListener(p4.f47276b);
    }

    public int getContentView() {
        return R.layout.activity_balance_currency_from_cc_detail;
    }

    public void initView() {
        super.initView();
        this.f46497s = (TextView) this.viewFinder.b(R.id.currency_detail_avaialbe_amount);
        this.f46498t = (TextView) this.viewFinder.b(R.id.currency_detail_onorders_amount);
        this.f46502x = (TextView) this.viewFinder.b(R.id.currency_detail_estimate_amount);
        this.f46499u = this.viewFinder.b(R.id.currency_detail_deposit);
        this.f46500v = this.viewFinder.b(R.id.currency_detail_withdraw);
        this.f46501w = this.viewFinder.b(R.id.currency_detail_transfer);
        ((TextView) this.viewFinder.b(R.id.currency_detail_desc_estimate)).setText(String.format(getResources().getString(R.string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
        this.f46503y = this.viewFinder.b(R.id.loading_view_currency_from_cc_detail_container);
        this.f46504z = (LoadingView) this.viewFinder.b(R.id.loading_view_currency_from_cc_detail);
        this.A = this.viewFinder.b(R.id.currency_detail_bottom_layout);
    }

    public List<MenuItem> oh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MenuItem("", getString(R.string.n_currency_operation_type_all), MenuItem.MenuItemStyle.STRESS, this.f46408q));
        String string = getString(R.string.n_currency_operation_type_deposit);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        arrayList.add(new MenuItem("", string, menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.n_currency_operation_type_withdraw), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.n_currency_operation_type_transfer), menuItemStyle, this.f46408q));
        return arrayList;
    }

    public void pb(BaseAssetInfo baseAssetInfo) {
        super.pb(baseAssetInfo);
        if (baseAssetInfo instanceof BalanceDetailInfo) {
            BalanceDetailInfo balanceDetailInfo = (BalanceDetailInfo) baseAssetInfo;
            String u02 = m.u0(balanceDetailInfo.getAvaialAble(), 12, 2);
            String u03 = m.u0(balanceDetailInfo.getOnOrders(), 12, 2);
            this.f46497s.setText(u02);
            this.f46498t.setText(u03);
            this.f46502x.setText(balanceDetailInfo.getEstimateAmount());
            if ("BRL".equals(balanceDetailInfo.getDisplayName())) {
                setResult(1630461439);
            }
            this.A.setVisibility(0);
        }
    }

    /* renamed from: qh */
    public BaseAssetDetailPresenter.a getUI() {
        return this;
    }

    public boolean wh() {
        return k.C().L(this.f46394c);
    }
}
