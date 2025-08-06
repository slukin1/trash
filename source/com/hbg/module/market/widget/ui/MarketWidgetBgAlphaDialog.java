package com.hbg.module.market.widget.ui;

import android.view.View;
import android.widget.TextView;
import c6.b;
import com.hbg.lib.widgets.CommonProgressBar;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.market.R$dimen;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import mf.c;

public class MarketWidgetBgAlphaDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public double f26734b = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    public double f26735c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26736d;

    /* renamed from: e  reason: collision with root package name */
    public CommonProgressBar f26737e;

    /* renamed from: f  reason: collision with root package name */
    public b<Float> f26738f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26739g;

    /* renamed from: h  reason: collision with root package name */
    public int f26740h;

    /* renamed from: i  reason: collision with root package name */
    public int f26741i;

    public class a implements CommonProgressBar.a {
        public a() {
        }

        public void a(double d11, double d12, double d13) {
            double unused = MarketWidgetBgAlphaDialog.this.f26734b = d11;
            gf.a.l((float) MarketWidgetBgAlphaDialog.this.f26734b, false);
            TextView wh2 = MarketWidgetBgAlphaDialog.this.f26739g;
            wh2.setText(((int) (d11 * 100.0d)) + "%");
        }

        public void b(float f11) {
            int width = MarketWidgetBgAlphaDialog.this.f26739g.getWidth() / 4;
            MarketWidgetBgAlphaDialog.this.f26739g.setTranslationX(Math.min((float) (MarketWidgetBgAlphaDialog.this.f26737e.getWidth() - width), f11 - ((float) width)));
        }

        public void c(boolean z11) {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        gf.a.m(true);
        this.f26736d = true;
        b<Float> bVar = this.f26738f;
        if (bVar != null) {
            double d11 = this.f26734b;
            if (d11 < 0.0d) {
                d11 = this.f26735c;
            }
            bVar.onCallback(Float.valueOf((float) d11));
        }
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.id_market_widget_bg_alpha_cancel).setOnClickListener(new mf.b(this));
        rVar.b(R$id.id_market_widget_bg_alpha_confirm).setOnClickListener(new c(this));
        this.f26737e.setCallback(new a());
    }

    public void afterInit() {
        this.f26740h = getResources().getDisplayMetrics().widthPixels - getResources().getDimensionPixelOffset(R$dimen.dimen_50);
        this.f26741i = getResources().getDimensionPixelOffset(R$dimen.dimen_30);
        this.f26736d = false;
        this.f26734b = -1.0d;
        double b11 = (double) gf.a.b();
        this.f26735c = b11;
        this.f26737e.i(b11 * 100.0d, true);
    }

    public int getContentViewResId() {
        return R$layout.dialog_market_widget_bg_alpha;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f26737e = (CommonProgressBar) rVar.b(R$id.id_market_widget_bg_alpha_progressBar);
        this.f26739g = (TextView) rVar.b(R$id.id_market_widget_bg_alpha_progress_text);
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onPause() {
        super.onPause();
        double d11 = this.f26734b;
        if (d11 < 0.0d) {
            return;
        }
        if (this.f26736d) {
            gf.a.l((float) d11, true);
        } else {
            gf.a.l((float) this.f26735c, false);
        }
    }

    public boolean useWindowBg() {
        return false;
    }

    public void yh(b<Float> bVar) {
        this.f26738f = bVar;
    }
}
