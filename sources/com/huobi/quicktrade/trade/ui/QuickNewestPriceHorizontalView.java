package com.huobi.quicktrade.trade.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Locale;
import k6.b;
import pro.huobi.R;

public class QuickNewestPriceHorizontalView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f80611b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80612c;

    /* renamed from: d  reason: collision with root package name */
    public b f80613d;

    /* renamed from: e  reason: collision with root package name */
    public int f80614e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f80615f;

    /* renamed from: g  reason: collision with root package name */
    public long f80616g;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            long unused = QuickNewestPriceHorizontalView.this.f80616g = System.currentTimeMillis();
            QuickNewestPriceHorizontalView.this.f();
        }
    }

    public QuickNewestPriceHorizontalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d(View view) {
        b bVar = this.f80613d;
        if (!(bVar == null || bVar.b() == null)) {
            this.f80613d.b().a(this.f80613d);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void c(Context context) {
        setOrientation(1);
        setGravity(16);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.f80614e = PixelUtils.a(5.0f);
        TextView textView = new TextView(context);
        this.f80611b = textView;
        textView.setTextSize(0, (float) getResources().getDimensionPixelOffset(R.dimen.global_text_size_14));
        this.f80611b.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.f80611b.setTypeface(ResourcesCompat.h(context, R.font.dinpro_medium));
        this.f80611b.setOnClickListener(new sq.a(this));
        linearLayout.addView(this.f80611b, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(context);
        this.f80612c = textView2;
        textView2.setTextSize(0, (float) getResources().getDimensionPixelOffset(R.dimen.global_text_size_12));
        this.f80612c.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryTextNew));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f80614e;
        linearLayout.addView(this.f80612c, layoutParams);
        addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
    }

    public void e() {
        if (this.f80615f != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.f80615f.hasMessages(1)) {
                this.f80615f.sendEmptyMessageDelayed(1, 250);
            } else if (currentTimeMillis - this.f80616g > 200) {
                this.f80616g = currentTimeMillis;
                this.f80615f.removeMessages(1);
                this.f80615f.sendEmptyMessage(1);
            }
        }
    }

    public void f() {
        b bVar = this.f80613d;
        if (bVar != null && bVar.c() != null && this.f80611b != null && this.f80612c != null) {
            this.f80611b.setText(this.f80613d.c().b());
            String str = String.format(getResources().getString(R.string.balance_total_cny), new Object[]{this.f80613d.c().g()}) + BaseModuleConfig.a().M().toUpperCase(Locale.US);
            if (TextUtils.isEmpty(this.f80613d.c().g())) {
                this.f80612c.setVisibility(4);
                return;
            }
            this.f80612c.setVisibility(0);
            this.f80612c.setText(str);
        }
    }

    public void g(b bVar) {
        this.f80613d = bVar;
        f();
    }

    public QuickNewestPriceHorizontalView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f80615f = new a(Looper.getMainLooper());
        c(context);
    }
}
