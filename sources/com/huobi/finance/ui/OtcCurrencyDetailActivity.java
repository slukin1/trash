package com.huobi.finance.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.hbg.lib.common.utils.ViewUtil;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.LegalDetailInfo;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.presenter.OtcCurrencyDetailPresenter;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import jp.k0;
import pro.huobi.R;
import va.b;

public class OtcCurrencyDetailActivity extends BaseAssetDetailActivity {
    public CoordinatorLayout A;
    public Boolean B;

    /* renamed from: s  reason: collision with root package name */
    public TextView f46700s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f46701t;

    /* renamed from: u  reason: collision with root package name */
    public View f46702u;

    /* renamed from: v  reason: collision with root package name */
    public View f46703v;

    /* renamed from: w  reason: collision with root package name */
    public View f46704w;

    /* renamed from: x  reason: collision with root package name */
    public View f46705x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f46706y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f46707z;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        Ch();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(View view) {
        k0.p(this, Dh() ? "btc" : this.f46394c);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Bh */
    public OtcCurrencyDetailPresenter createPresenter() {
        return new OtcCurrencyDetailPresenter();
    }

    public final void Ch() {
        String str = this.f46394c;
        if (str != null) {
            UnifyTransferActivity.Th(this, str, "2");
        }
    }

    public final boolean Dh() {
        Boolean bool = this.B;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z11 = false;
        Intent intent = getIntent();
        if (intent != null) {
            LegalDetailInfo legalDetailInfo = (LegalDetailInfo) intent.getSerializableExtra("currency_detail_info");
            if (legalDetailInfo != null) {
                z11 = k.C().L(legalDetailInfo.getCurrency());
            } else {
                z11 = k.C().L(b.d(intent.getIntExtra("currency_detail_coin_id", Integer.MIN_VALUE)));
            }
        }
        this.B = Boolean.valueOf(z11);
        return z11;
    }

    public void Qg(int i11) {
        int i12;
        String str;
        switch (i11) {
            case 1:
                i12 = 2;
                break;
            case 2:
                i12 = 3;
                break;
            case 3:
                i12 = 5;
                break;
            case 4:
                i12 = 6;
                break;
            case 5:
                i12 = 7;
                break;
            case 6:
                i12 = 45;
                break;
            case 7:
                i12 = 43;
                break;
            default:
                i12 = Integer.MIN_VALUE;
                break;
        }
        BaseAssetDetailPresenter baseAssetDetailPresenter = (BaseAssetDetailPresenter) getPresenter();
        if (i12 == Integer.MIN_VALUE) {
            str = null;
        } else {
            str = String.valueOf(i12);
        }
        baseAssetDetailPresenter.V(str);
    }

    public void addEvent() {
        super.addEvent();
        this.f46702u.setOnClickListener(new b7(this));
        this.f46704w.setOnClickListener(new a7(this));
    }

    public int getContentView() {
        return R.layout.activity_balance_otc_currency_detail;
    }

    public void initView() {
        super.initView();
        this.f46700s = (TextView) this.viewFinder.b(R.id.currency_detail_avaialbe_amount);
        this.f46701t = (TextView) this.viewFinder.b(R.id.currency_detail_onorders_amount);
        this.f46707z = (TextView) this.viewFinder.b(R.id.currency_detail_estimate_amount);
        this.f46702u = this.viewFinder.b(R.id.currency_detail_transfer);
        this.f46703v = this.viewFinder.b(R.id.currency_detail_transfer_layout);
        this.f46704w = this.viewFinder.b(R.id.currency_detail_otc);
        this.f46705x = this.viewFinder.b(R.id.currency_detail_otc_layout);
        TextView textView = (TextView) this.viewFinder.b(R.id.currency_detail_desc_estimate);
        this.f46706y = textView;
        textView.setText(String.format(getResources().getString(R.string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
        this.A = (CoordinatorLayout) this.viewFinder.b(R.id.cl_root);
    }

    public List<MenuItem> oh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MenuItem("", getString(R.string.otc_balance_detail_history_type_all), MenuItem.MenuItemStyle.STRESS, this.f46408q));
        String string = getString(R.string.otc_balance_detail_sell);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        arrayList.add(new MenuItem("", string, menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.otc_balance_detail_buy), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.otc_balance_detail_in), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.otc_balance_detail_out), menuItemStyle, this.f46408q));
        if (!Dh()) {
            arrayList.add(new MenuItem("", getString(R.string.n_otc_balance_detail_deposit), menuItemStyle, this.f46408q));
            arrayList.add(new MenuItem("", getString(R.string.otc_balance_detail_fee), menuItemStyle, this.f46408q));
            arrayList.add(new MenuItem("", getString(R.string.otc_balance_detail_legal), menuItemStyle, this.f46408q));
        }
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
        if (baseAssetInfo instanceof LegalDetailInfo) {
            LegalDetailInfo legalDetailInfo = (LegalDetailInfo) baseAssetInfo;
            int i11 = Dh() ? 2 : 8;
            String u02 = m.u0(legalDetailInfo.getAvaialAble(), 12, i11);
            String u03 = m.u0(legalDetailInfo.getOnOrders(), 12, i11);
            this.f46700s.setText(u02);
            this.f46701t.setText(u03);
            this.f46707z.setText(legalDetailInfo.getEstimateAmount());
            int status = legalDetailInfo.getStatus();
            boolean z11 = false;
            if ((status & 2) != 0) {
                this.f46703v.setVisibility(8);
            } else {
                this.f46703v.setVisibility(0);
            }
            boolean z12 = (status & 1) == 0;
            View view = this.f46705x;
            if (z12 || Dh()) {
                z11 = true;
            }
            ViewUtil.m(view, z11);
        }
    }

    public boolean wh() {
        return k.C().L(this.f46394c);
    }
}
