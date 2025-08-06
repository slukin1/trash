package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import vp.y;

public class OtcAdsFilterItemView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79926b;

    /* renamed from: c  reason: collision with root package name */
    public a f79927c;

    public interface a {
        void a();
    }

    public OtcAdsFilterItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void c(View view) {
        a aVar = this.f79927c;
        if (aVar != null) {
            aVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void b(Context context) {
        FrameLayout.inflate(context, R$layout.otc_ads_fliter_item_layout, this);
        this.f79926b = (TextView) findViewById(R$id.id_filter_item_name_tv);
        setOnClickListener(new y(this));
    }

    public void d() {
        this.f79926b.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorMajorTheme100));
    }

    public void e() {
        this.f79926b.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText));
    }

    public void setCallBack(a aVar) {
        this.f79927c = aVar;
    }

    public void setText(String str) {
        this.f79926b.setText(str);
    }

    public OtcAdsFilterItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context);
    }
}
