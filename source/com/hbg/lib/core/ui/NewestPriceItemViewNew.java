package com.hbg.lib.core.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
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
import u6.l;

public class NewestPriceItemViewNew extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public SubscriptTextView f68570b;

    /* renamed from: c  reason: collision with root package name */
    public SubscriptTextView f68571c;

    /* renamed from: d  reason: collision with root package name */
    public b f68572d;

    /* renamed from: e  reason: collision with root package name */
    public final int f68573e;

    public NewestPriceItemViewNew(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void c(View view) {
        b bVar = this.f68572d;
        if (!(bVar == null || bVar.b() == null)) {
            this.f68572d.b().a(this.f68572d);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void b(Context context) {
        int i11 = this.f68573e;
        setPadding(0, i11, 0, i11);
        setOrientation(1);
        setGravity(16);
        SubscriptTextView subscriptTextView = new SubscriptTextView(context);
        this.f68570b = subscriptTextView;
        subscriptTextView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        this.f68570b.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.global_text_size_18));
        this.f68570b.setOnClickListener(new l(this));
        this.f68570b.setText("--");
        addView(this.f68570b, new LinearLayout.LayoutParams(-2, -2));
        SubscriptTextView subscriptTextView2 = new SubscriptTextView(context);
        this.f68571c = subscriptTextView2;
        subscriptTextView2.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_regular));
        this.f68571c.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.global_text_size_10));
        this.f68571c.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorSecondaryText));
        this.f68571c.setText("--");
        addView(this.f68571c, new LinearLayout.LayoutParams(-2, -2));
    }

    public void d() {
        b bVar = this.f68572d;
        if (bVar != null && bVar.c() != null) {
            this.f68570b.setText(this.f68572d.c().b());
            this.f68570b.setTextColor(this.f68572d.c().f());
            if (TextUtils.isEmpty(this.f68572d.c().g())) {
                this.f68571c.setText("--");
                return;
            }
            this.f68571c.setText(String.format(getResources().getString(R$string.balance_total_cny), new Object[]{this.f68572d.c().g()}) + BaseModuleConfig.a().M().toUpperCase(Locale.US));
        }
    }

    public void e(b bVar) {
        this.f68572d = bVar;
        d();
    }

    public NewestPriceItemViewNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewestPriceItemViewNew(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f68573e = PixelUtils.a(4.0f);
        b(context);
    }
}
