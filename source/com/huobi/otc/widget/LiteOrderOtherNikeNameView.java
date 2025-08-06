package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;

public class LiteOrderOtherNikeNameView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79879b = ((TextView) findViewById(R$id.title_tv));

    /* renamed from: c  reason: collision with root package name */
    public TextView f79880c = ((TextView) findViewById(R$id.content_tv));

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79881d = ((ImageView) findViewById(R$id.content_icon_fist_iv));

    /* renamed from: e  reason: collision with root package name */
    public ImageView f79882e = ((ImageView) findViewById(R$id.content_icon_two_iv));

    /* renamed from: f  reason: collision with root package name */
    public ImageView f79883f = ((ImageView) findViewById(R$id.icon_iv));

    /* renamed from: g  reason: collision with root package name */
    public ImageView f79884g = ((ImageView) findViewById(R$id.content_icon_thumbs_up));

    public LiteOrderOtherNikeNameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.lite_order_other_nike_name_view, this);
    }
}
