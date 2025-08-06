package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;

public class LiteOrderSingeFromView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79906b = ((TextView) findViewById(R$id.title_tv));

    /* renamed from: c  reason: collision with root package name */
    public TextView f79907c = ((TextView) findViewById(R$id.content_tv));

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79908d = ((ImageView) findViewById(R$id.content_icon_fist_iv));

    /* renamed from: e  reason: collision with root package name */
    public ImageView f79909e = ((ImageView) findViewById(R$id.content_icon_two_iv));

    /* renamed from: f  reason: collision with root package name */
    public ImageView f79910f = ((ImageView) findViewById(R$id.icon_iv));

    /* renamed from: g  reason: collision with root package name */
    public View f79911g = findViewById(R$id.id_color_view);

    public LiteOrderSingeFromView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.lite_order_singe_from_view, this);
    }

    public void setStartColor(int i11) {
        this.f79911g.setBackgroundColor(i11);
        this.f79911g.setVisibility(0);
    }
}
