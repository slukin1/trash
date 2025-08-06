package com.huobi.asset.feature.summary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class AssetSummaryUserGuideView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public d f42409b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (AssetSummaryUserGuideView.this.f42409b != null) {
                AssetSummaryUserGuideView.this.f42409b.a();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (AssetSummaryUserGuideView.this.f42409b != null) {
                AssetSummaryUserGuideView.this.f42409b.c();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (AssetSummaryUserGuideView.this.f42409b != null) {
                AssetSummaryUserGuideView.this.f42409b.b();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface d {
        void a();

        void b();

        void c();
    }

    public AssetSummaryUserGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R$layout.item_asset_header_user_guide, this);
        findViewById(R$id.user_guide_iv_close).setOnClickListener(new a());
        findViewById(R$id.user_guide_tv_action_deposit).setOnClickListener(new b());
        findViewById(R$id.user_guide_tv_action_fast_purchase).setOnClickListener(new c());
    }

    public void setCallback(d dVar) {
        this.f42409b = dVar;
    }

    public AssetSummaryUserGuideView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public AssetSummaryUserGuideView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        b();
    }
}
