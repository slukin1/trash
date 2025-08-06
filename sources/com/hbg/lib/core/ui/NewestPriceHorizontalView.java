package com.hbg.lib.core.ui;

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
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$dimen;
import com.hbg.lib.core.R$font;
import com.hbg.lib.core.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Locale;
import k6.b;
import u6.h;
import u6.i;

public class NewestPriceHorizontalView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f68553b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f68554c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f68555d;

    /* renamed from: e  reason: collision with root package name */
    public b f68556e;

    /* renamed from: f  reason: collision with root package name */
    public int f68557f;

    /* renamed from: g  reason: collision with root package name */
    public int f68558g;

    /* renamed from: h  reason: collision with root package name */
    public int f68559h;

    /* renamed from: i  reason: collision with root package name */
    public int f68560i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f68561j;

    /* renamed from: k  reason: collision with root package name */
    public long f68562k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f68563l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f68564m;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            long unused = NewestPriceHorizontalView.this.f68562k = System.currentTimeMillis();
            NewestPriceHorizontalView.this.j();
        }
    }

    public NewestPriceHorizontalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        b bVar = this.f68556e;
        if (!(bVar == null || bVar.b() == null)) {
            this.f68556e.b().a(this.f68556e);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        b bVar = this.f68556e;
        if (!(bVar == null || bVar.b() == null)) {
            this.f68556e.b().b(this.f68556e);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void d() {
        b bVar = this.f68556e;
        if (bVar != null && bVar.c() != null) {
            this.f68553b.getPaint().setTextSize((float) this.f68559h);
            String b11 = this.f68556e.c().b();
            String str = String.format(getResources().getString(R$string.balance_total_cny), new Object[]{this.f68556e.c().g()}) + BaseModuleConfig.a().M().toUpperCase(Locale.US);
            float measureText = this.f68553b.getPaint().measureText(b11) + this.f68554c.getPaint().measureText(str) + ((float) this.f68560i);
            int width = getWidth();
            if (measureText < ((float) width) || width == 0) {
                this.f68553b.setTextSize(0, (float) this.f68559h);
                this.f68553b.setText(b11);
                this.f68553b.setTextColor(this.f68556e.c().f());
                if (TextUtils.isEmpty(this.f68556e.c().g())) {
                    this.f68554c.setVisibility(4);
                } else {
                    this.f68554c.setVisibility(this.f68564m ? 0 : 8);
                    this.f68554c.setText(str);
                }
                if (!this.f68563l || TextUtils.isEmpty(this.f68556e.c().h())) {
                    this.f68555d.setVisibility(8);
                    return;
                }
                this.f68555d.setText(this.f68556e.c().h());
                this.f68555d.setVisibility(0);
                if (this.f68556e.c().c() == 0) {
                    this.f68555d.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText));
                } else {
                    this.f68555d.setTextColor(ContextCompat.getColor(getContext(), this.f68556e.c().c()));
                }
                if (this.f68556e.c().e()) {
                    this.f68555d.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, this.f68556e.c().d(), 0);
                } else {
                    this.f68555d.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                }
            } else {
                int i11 = this.f68557f - 1;
                this.f68557f = i11;
                this.f68559h = PixelUtils.a((float) i11);
                d();
            }
        }
    }

    public final void e(Context context) {
        setOrientation(1);
        setGravity(16);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.f68560i = PixelUtils.a(5.0f);
        int a11 = PixelUtils.a((float) this.f68557f);
        this.f68558g = a11;
        this.f68559h = a11;
        TextView textView = new TextView(context);
        this.f68553b = textView;
        textView.setTextSize(0, (float) this.f68559h);
        this.f68553b.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        this.f68553b.setOnClickListener(new h(this));
        linearLayout.addView(this.f68553b, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(context);
        this.f68554c = textView2;
        textView2.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.global_text_size_10));
        this.f68554c.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorThreeLevelText));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f68560i;
        linearLayout.addView(this.f68554c, layoutParams);
        addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(context);
        this.f68555d = textView3;
        textView3.setVisibility(8);
        this.f68555d.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.global_text_size_11));
        this.f68555d.setTextColor(ContextCompat.getColor(context, R$color.baseColorPrimaryText));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_1);
        this.f68555d.setCompoundDrawablePadding(PixelUtils.a(3.0f));
        this.f68555d.setGravity(16);
        this.f68555d.setOnClickListener(new i(this));
        addView(this.f68555d, layoutParams2);
    }

    public TextView getIndexTv() {
        return this.f68555d;
    }

    public void h() {
        if (this.f68561j != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.f68561j.hasMessages(1)) {
                this.f68561j.sendEmptyMessageDelayed(1, 250);
            } else if (currentTimeMillis - this.f68562k > 200) {
                this.f68562k = currentTimeMillis;
                this.f68561j.removeMessages(1);
                this.f68561j.sendEmptyMessage(1);
            }
        }
    }

    public void i(boolean z11) {
        this.f68563l = z11;
    }

    public void j() {
        this.f68557f = 24;
        this.f68559h = this.f68558g;
        d();
    }

    public void k(b bVar) {
        this.f68556e = bVar;
        j();
    }

    public void setPriceTvSize(int i11) {
        this.f68557f = i11;
        this.f68558g = i11;
    }

    public void setShowLegalPrice(boolean z11) {
        TextView textView;
        this.f68564m = z11;
        if (!z11 && (textView = this.f68554c) != null) {
            textView.setVisibility(0);
        }
    }

    public NewestPriceHorizontalView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f68557f = 24;
        this.f68561j = new a(Looper.getMainLooper());
        this.f68563l = true;
        this.f68564m = true;
        e(context);
    }
}
