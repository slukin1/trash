package com.hbg.lib.core.ui;

import android.content.Context;
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
import com.hbg.lib.widgets.SubscriptTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Locale;
import k6.b;
import u6.j;
import u6.k;

public class NewestPriceItemView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public SubscriptTextView f68566b;

    /* renamed from: c  reason: collision with root package name */
    public SubscriptTextView f68567c;

    /* renamed from: d  reason: collision with root package name */
    public SubscriptTextView f68568d;

    /* renamed from: e  reason: collision with root package name */
    public b f68569e;

    public NewestPriceItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d(View view) {
        b bVar = this.f68569e;
        if (!(bVar == null || bVar.b() == null)) {
            this.f68569e.b().a(this.f68569e);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(View view) {
        b bVar = this.f68569e;
        if (!(bVar == null || bVar.b() == null)) {
            this.f68569e.b().b(this.f68569e);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void c(Context context) {
        setOrientation(1);
        setGravity(16);
        SubscriptTextView subscriptTextView = new SubscriptTextView(context);
        this.f68566b = subscriptTextView;
        subscriptTextView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        this.f68566b.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.global_text_size_18));
        this.f68566b.setOnClickListener(new j(this));
        addView(this.f68566b, new LinearLayout.LayoutParams(-2, -2));
        SubscriptTextView subscriptTextView2 = new SubscriptTextView(context);
        this.f68567c = subscriptTextView2;
        Context context2 = getContext();
        int i11 = R$font.roboto_regular;
        subscriptTextView2.setTypeface(ResourcesCompat.h(context2, i11));
        this.f68567c.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.global_text_size_10));
        SubscriptTextView subscriptTextView3 = this.f68567c;
        Context context3 = getContext();
        int i12 = R$color.baseColorSecondaryText;
        subscriptTextView3.setTextColor(ContextCompat.getColor(context3, i12));
        addView(this.f68567c, new LinearLayout.LayoutParams(-2, -2));
        SubscriptTextView subscriptTextView4 = new SubscriptTextView(context);
        this.f68568d = subscriptTextView4;
        subscriptTextView4.setBackgroundResource(R$color.app_bg);
        this.f68568d.setTypeface(ResourcesCompat.h(getContext(), i11));
        this.f68568d.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.global_text_size_11));
        this.f68568d.setTextColor(ContextCompat.getColor(context, i12));
        this.f68568d.setCompoundDrawablePadding(PixelUtils.a(3.0f));
        this.f68568d.setGravity(16);
        this.f68568d.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_2);
        this.f68568d.setOnClickListener(new k(this));
        addView(this.f68568d, layoutParams);
    }

    public void f() {
        b bVar = this.f68569e;
        if (bVar != null && bVar.c() != null) {
            this.f68566b.setText(this.f68569e.c().b());
            this.f68566b.setTextColor(this.f68569e.c().f());
            if (TextUtils.isEmpty(this.f68569e.c().g())) {
                this.f68567c.setVisibility(8);
            } else {
                this.f68567c.setVisibility(0);
                this.f68567c.setText(String.format(getResources().getString(R$string.balance_total_cny), new Object[]{this.f68569e.c().g()}) + BaseModuleConfig.a().M().toUpperCase(Locale.US));
            }
            if (!TextUtils.isEmpty(this.f68569e.c().h())) {
                this.f68568d.setText(this.f68569e.c().h());
                this.f68568d.setVisibility(0);
                if (this.f68569e.c().c() == 0) {
                    this.f68568d.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorSecondaryText));
                } else {
                    this.f68568d.setTextColor(ContextCompat.getColor(getContext(), this.f68569e.c().c()));
                }
                if (this.f68569e.c().e()) {
                    this.f68568d.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, this.f68569e.c().d(), 0);
                } else {
                    this.f68568d.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                }
            } else {
                this.f68568d.setVisibility(8);
            }
        }
    }

    public void g(b bVar) {
        this.f68569e = bVar;
        f();
    }

    public TextView getIndexTv() {
        return this.f68568d;
    }

    public NewestPriceItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewestPriceItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context);
    }
}
