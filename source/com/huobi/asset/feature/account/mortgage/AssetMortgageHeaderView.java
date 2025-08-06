package com.huobi.asset.feature.account.mortgage;

import al.p;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.PledgeAssetContent;
import com.hbg.lib.widgets.NumAnimTextView;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gh.b;
import i6.m;
import java.util.HashMap;
import java.util.Locale;
import kh.f;
import kh.g;
import kh.h;
import kh.i;
import kh.j;
import kh.k;
import org.greenrobot.eventbus.EventBus;

public class AssetMortgageHeaderView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final bc.a f42265b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42266c;

    /* renamed from: d  reason: collision with root package name */
    public NumAnimTextView f42267d;

    /* renamed from: e  reason: collision with root package name */
    public NumAnimTextView f42268e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f42269f;

    /* renamed from: g  reason: collision with root package name */
    public NumAnimTextView f42270g;

    /* renamed from: h  reason: collision with root package name */
    public NumAnimTextView f42271h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42272i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42273j;

    /* renamed from: k  reason: collision with root package name */
    public String f42274k;

    /* renamed from: l  reason: collision with root package name */
    public String f42275l;

    /* renamed from: m  reason: collision with root package name */
    public String f42276m;

    /* renamed from: n  reason: collision with root package name */
    public String f42277n;

    /* renamed from: o  reason: collision with root package name */
    public String f42278o;

    /* renamed from: p  reason: collision with root package name */
    public a f42279p;

    public interface a {
        void a(boolean z11);
    }

    public AssetMortgageHeaderView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ String n(String str) {
        if (!m.a0(str)) {
            return str;
        }
        return "≈" + str + " " + LegalCurrencyConfigUtil.d().toUpperCase(Locale.US);
    }

    public static /* synthetic */ String o(String str) {
        if (!m.a0(str)) {
            return str;
        }
        return "≈" + str + " " + LegalCurrencyConfigUtil.d().toUpperCase(Locale.US);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void p(View view) {
        BaseModuleConfig.a().w("app_assets_collateral_account_borrow_click", (HashMap) null);
        this.f42265b.V(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        BaseModuleConfig.a().w("app_assets_collateral_account_order_click", (HashMap) null);
        this.f42265b.n0(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r(View view) {
        boolean z11 = !this.f42266c;
        this.f42266c = z11;
        p.t(z11);
        EventBus.d().k(new b(this.f42266c));
        t();
        i(this.f42266c, false);
        a aVar = this.f42279p;
        if (aVar != null) {
            aVar.a(this.f42266c);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void s(View view) {
        AssetModuleConfig.a().n0(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void g(PledgeAssetContent pledgeAssetContent) {
        if (pledgeAssetContent != null) {
            boolean u11 = p.u();
            this.f42266c = u11;
            i(u11, false);
            h(pledgeAssetContent);
        }
    }

    public final void h(PledgeAssetContent pledgeAssetContent) {
        String d11 = LegalCurrencyConfigUtil.d();
        this.f42275l = m.u0(pledgeAssetContent.getLoaningUSDT(), 12, 8);
        this.f42277n = m.u0(pledgeAssetContent.getPledgingUSDT(), 12, 8);
        if ("btc".equals(d11)) {
            this.f42276m = LegalCurrencyConfigUtil.Q("btc", this.f42275l);
            this.f42278o = LegalCurrencyConfigUtil.Q("btc", this.f42277n);
        } else if ("usdt".equals(d11)) {
            this.f42276m = this.f42275l;
            this.f42278o = this.f42277n;
        } else {
            this.f42276m = LegalCurrencyConfigUtil.B(this.f42275l);
            this.f42278o = LegalCurrencyConfigUtil.B(this.f42277n);
        }
        i(this.f42266c, true);
    }

    public void i(boolean z11, boolean z12) {
        t();
        if (!z11) {
            this.f42270g.setText(this.f42274k);
            this.f42271h.setText(this.f42274k);
            this.f42267d.setText(this.f42274k);
            this.f42268e.setText(this.f42274k);
            return;
        }
        uh.a.b(this.f42270g, this.f42278o, z12);
        uh.a.b(this.f42267d, this.f42276m, z12);
    }

    public final void j() {
        t();
        this.f42268e.setCallback(k.f56577a);
        this.f42271h.setCallback(j.f56576a);
    }

    public final void k() {
        this.f42272i.setOnClickListener(new h(this));
        this.f42273j.setOnClickListener(new f(this));
        this.f42269f.setOnClickListener(new g(this));
        findViewById(R$id.iv_record).setOnClickListener(i.f56575b);
    }

    public final void l() {
        this.f42274k = getResources().getString(R$string.balance_hide_star);
        j();
    }

    public final void m() {
        LayoutInflater.from(getContext()).inflate(R$layout.item_asset_mortgage_header, this);
        NumAnimTextView numAnimTextView = (NumAnimTextView) findViewById(R$id.mortgage_header_borrow_price);
        this.f42267d = numAnimTextView;
        numAnimTextView.setText("--");
        NumAnimTextView numAnimTextView2 = (NumAnimTextView) findViewById(R$id.mortgage_header_borrow_price_to_currency);
        this.f42268e = numAnimTextView2;
        numAnimTextView2.setText("--");
        this.f42269f = (ImageView) findViewById(R$id.mortgage_header_show_balances);
        NumAnimTextView numAnimTextView3 = (NumAnimTextView) findViewById(R$id.mortgage_header_price);
        this.f42270g = numAnimTextView3;
        numAnimTextView3.setText("--");
        NumAnimTextView numAnimTextView4 = (NumAnimTextView) findViewById(R$id.mortgage_header_price_to_currency);
        this.f42271h = numAnimTextView4;
        numAnimTextView4.setText("--");
        this.f42272i = (TextView) findViewById(R$id.mortgage_header_to_borrow);
        this.f42273j = (TextView) findViewById(R$id.mortgage_header_open_detail);
        String upperCase = LegalCurrencyConfigUtil.d().toUpperCase(Locale.US);
        ((TextView) findViewById(R$id.mortgage_header_borrow_title)).setText(getResources().getString(R$string.n_balance_pledge_loan_amount_new, new Object[]{upperCase}));
        ((TextView) findViewById(R$id.mortgage_header_title)).setText(getResources().getString(R$string.n_balance_pledge_amount_new, new Object[]{upperCase}));
    }

    public void setCallback(a aVar) {
        this.f42279p = aVar;
    }

    public final void t() {
        boolean u11 = p.u();
        this.f42266c = u11;
        this.f42269f.setBackgroundResource(u11 ? R$drawable.balances_show : R$drawable.balances_hide);
    }

    public AssetMortgageHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssetMortgageHeaderView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public AssetMortgageHeaderView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f42265b = AssetModuleConfig.a();
        this.f42266c = true;
        m();
        k();
        l();
    }
}
