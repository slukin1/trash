package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.concurrent.TimeUnit;
import vp.q;

public final class LiteNewOrderFormItemView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79839b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79840c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79841d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f79842e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f79843f;

    /* renamed from: g  reason: collision with root package name */
    public View f79844g;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public LiteNewOrderFormItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.lite_new_order_item_form_view, this);
        b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Void voidR) {
    }

    public final void b() {
        this.f79839b = (TextView) findViewById(R$id.title_tv);
        this.f79840c = (TextView) findViewById(R$id.value_tv);
        this.f79841d = (ImageView) findViewById(R$id.qrcode_iv);
        this.f79842e = (LinearLayout) findViewById(R$id.root_view);
        this.f79843f = (ImageView) findViewById(R$id.id_pic_left);
        this.f79844g = findViewById(R$id.order_icon_color_view);
        dw.a.a(this.f79841d).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new q(this));
        this.f79843f.setOnClickListener(new a());
    }

    public TextView getValueTv() {
        return this.f79840c;
    }
}
