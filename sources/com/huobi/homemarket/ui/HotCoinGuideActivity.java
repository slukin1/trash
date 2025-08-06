package com.huobi.homemarket.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$style;
import com.huobi.homemarket.view.HotCoinGuideHoleView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import kotlin.jvm.internal.r;
import ul.o0;

public final class HotCoinGuideActivity extends EmptyMVPActivity {

    /* renamed from: h  reason: collision with root package name */
    public static final a f72917h = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public HotCoinGuideHoleView f72918b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f72919c;

    /* renamed from: d  reason: collision with root package name */
    public double f72920d;

    /* renamed from: e  reason: collision with root package name */
    public double f72921e;

    /* renamed from: f  reason: collision with root package name */
    public double f72922f;

    /* renamed from: g  reason: collision with root package name */
    public double f72923g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final void a(Context context, Double d11, Double d12, Double d13, Double d14) {
            d.c("HotCoinGuideActivity", "startActivity left= " + d12 + " top= " + d11 + " popWidth= " + d13 + " popHeight= " + d14);
            Intent intent = new Intent(context, HotCoinGuideActivity.class);
            if (d11 != null) {
                intent.putExtra(ViewHierarchyConstants.DIMENSION_TOP_KEY, d11.doubleValue());
            }
            if (d12 != null) {
                intent.putExtra("left", d12.doubleValue());
            }
            if (d13 != null) {
                intent.putExtra("popWidth", d13.doubleValue());
            }
            if (d14 != null) {
                intent.putExtra("popHeight", d14.doubleValue());
            }
            context.startActivity(intent);
        }
    }

    @SensorsDataInstrumented
    public static final void Yf(HotCoinGuideActivity hotCoinGuideActivity, View view) {
        SPUtil.r("hot_coin_guide_showed", true);
        hotCoinGuideActivity.finish();
        hotCoinGuideActivity.overridePendingTransition(0, 0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getContentView() {
        return R$layout.activity_hot_coin_guide;
    }

    public void initExtra() {
        this.f72920d = getIntent().getDoubleExtra(ViewHierarchyConstants.DIMENSION_TOP_KEY, 0.0d);
        this.f72921e = getIntent().getDoubleExtra("left", 0.0d);
        this.f72922f = getIntent().getDoubleExtra("popWidth", 0.0d);
        this.f72923g = getIntent().getDoubleExtra("popHeight", 0.0d);
    }

    public void initView() {
        try {
            if (NightHelper.e().g()) {
                setTheme(R$style.ActivityKlineNight);
            } else {
                setTheme(R$style.ActivityKlineLight);
            }
            setStatusBarColor(getResources().getColor(R$color.KBasePopCoverColor));
            this.f72918b = (HotCoinGuideHoleView) this.viewFinder.b(R$id.hotCoinGuideHoleView);
            d.c("HotCoinGuideActivity", "initView 1 left= " + this.f72921e + " top= " + this.f72920d + " popWidth= " + this.f72922f + " popHeight= " + this.f72923g);
            HotCoinGuideHoleView hotCoinGuideHoleView = this.f72918b;
            TextView textView = null;
            (hotCoinGuideHoleView == null ? null : hotCoinGuideHoleView).a(this.f72920d, this.f72921e, this.f72922f, this.f72923g);
            TextView textView2 = (TextView) this.viewFinder.b(R$id.tvConfrim);
            this.f72919c = textView2;
            if (textView2 != null) {
                textView = textView2;
            }
            textView.setOnClickListener(new o0(this));
        } catch (Throwable unused) {
            finish();
            overridePendingTransition(0, 0);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
