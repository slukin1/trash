package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import net.lucode.hackware.magicindicator.buildins.UIUtil;

public class LiteOrderNoPayNikeNameView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79871b = ((TextView) findViewById(R$id.title_tv));

    /* renamed from: c  reason: collision with root package name */
    public TextView f79872c = ((TextView) findViewById(R$id.content_tv));

    /* renamed from: d  reason: collision with root package name */
    public OrderAutoWrapViewGroup f79873d = ((OrderAutoWrapViewGroup) findViewById(R$id.vg_auto_wrap));

    /* renamed from: e  reason: collision with root package name */
    public ImageView f79874e = ((ImageView) findViewById(R$id.content_icon_fist_iv));

    /* renamed from: f  reason: collision with root package name */
    public ImageView f79875f = ((ImageView) findViewById(R$id.content_icon_two_iv));

    /* renamed from: g  reason: collision with root package name */
    public ImageView f79876g = ((ImageView) findViewById(R$id.icon_iv));

    /* renamed from: h  reason: collision with root package name */
    public ImageView f79877h = ((ImageView) findViewById(R$id.content_no_pay_icon_thumbs_up));

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f79878i = ((LinearLayout) findViewById(R$id.guarantee_ll));

    public LiteOrderNoPayNikeNameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.lite_order_no_pay_nike_name_view, this);
        this.f79873d.setSpacingHorizontal(UIUtil.a(context, 18.0d));
        this.f79873d.setSpacingVertical(UIUtil.a(context, 8.0d));
    }

    public void setSecurityVisible(boolean z11) {
        ViewUtil.m(this.f79878i, z11);
    }
}
