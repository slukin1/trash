package com.hbg.lite.trade.ui;

import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.TradingHoseQuoteBean;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.view.TradingHoseAnimatorView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import qb.c;
import ra.d;

public class LiteTradingHouseBuySellDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public b f77526b;

    /* renamed from: c  reason: collision with root package name */
    public TradingHoseQuoteBean f77527c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f77528d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f77529e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f77530f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f77531g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f77532h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f77533i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f77534j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f77535k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f77536l;

    /* renamed from: m  reason: collision with root package name */
    public SafeLottieView f77537m;

    /* renamed from: n  reason: collision with root package name */
    public FrameLayout f77538n;

    /* renamed from: o  reason: collision with root package name */
    public TradingHoseAnimatorView f77539o;

    /* renamed from: p  reason: collision with root package name */
    public View f77540p;

    public class a implements TradingHoseAnimatorView.b {
        public a() {
        }

        public void a() {
            LiteTradingHouseBuySellDialogFragment.this.xh();
            LiteTradingHouseBuySellDialogFragment.this.f77526b.a((int) LiteTradingHouseBuySellDialogFragment.this.f77527c.getExpireTime());
        }

        public void onComplete() {
            if (LiteTradingHouseBuySellDialogFragment.this.f77527c != null) {
                LiteTradingHouseBuySellDialogFragment.this.yh().n(LiteTradingHouseBuySellDialogFragment.this.f77528d ? "202" : "204", va.b.g(LiteTradingHouseBuySellDialogFragment.this.f77527c.getQuoteCoinId()));
                LiteTradingHouseBuySellDialogFragment.this.f77526b.b(LiteTradingHouseBuySellDialogFragment.this.f77527c);
            }
        }
    }

    public interface b {
        void a(int i11);

        void b(TradingHoseQuoteBean tradingHoseQuoteBean);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        xh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Ah(long j11) {
        if (j11 <= 0) {
            j11 = 1000;
        }
        this.f77539o.setMaxTime(j11);
        this.f77539o.r();
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.close_tv).setOnClickListener(new c(this));
        this.f77539o.setTradingHoseAnimaViewCallback(new a());
    }

    public void afterInit() {
        zh();
    }

    public int getContentViewResId() {
        return R$layout.fragment_dialog_vendor_buy_sell_dialog;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f77529e = (TextView) rVar.b(R$id.confirm_title_tv);
        this.f77530f = (TextView) rVar.b(R$id.coin_count_tv);
        this.f77531g = (TextView) rVar.b(R$id.coin_price_tv);
        this.f77534j = (TextView) rVar.b(R$id.coin_trade_type_tv);
        this.f77535k = (TextView) rVar.b(R$id.coin_currency_tv);
        this.f77532h = (TextView) rVar.b(R$id.pay_get_title_tv);
        this.f77533i = (TextView) rVar.b(R$id.pay_get_tv);
        this.f77536l = (ImageView) rVar.b(R$id.dialog_coin_icon_iv);
        this.f77537m = (SafeLottieView) rVar.b(R$id.loading_lottie_view);
        this.f77538n = (FrameLayout) rVar.b(R$id.loading_lottie_fl);
        this.f77539o = (TradingHoseAnimatorView) rVar.b(R$id.trading_hose_animator_view);
        this.f77540p = rVar.b(R$id.location_point_view);
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f77539o.s();
    }

    public boolean useWindowBg() {
        return false;
    }

    public final void xh() {
        dismiss();
    }

    public d yh() {
        return ra.c.c();
    }

    public final void zh() {
        if (this.f77527c != null) {
            if (!this.f77528d) {
                this.f77529e.setText(getString(R$string.sale_confirmation));
                this.f77532h.setText(getString(R$string.will_get));
            }
            this.f77534j.setText(this.f77528d ? R$string.otc_buy : R$string.otc_sell);
            this.f77530f.setText(this.f77527c.getQuantity() + " " + va.b.g(this.f77527c.getQuoteCoinId()));
            this.f77531g.setText(this.f77527c.getPrice() + " " + va.b.g(this.f77527c.getBaseCoinId()));
            String b11 = nb.c.b(this.f77527c.getConvertAmount(), m.U(this.f77527c.getConvertAmount()));
            this.f77535k.setText(String.format("≈ %s%s", new Object[]{va.b.n(sa.a.c()), b11}));
            this.f77533i.setText(this.f77527c.getAmount() + " " + va.b.g(this.f77527c.getBaseCoinId()));
            Ah(this.f77527c.getExpireTime() * 1000);
        }
    }
}
