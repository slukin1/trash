package com.huobi.otc.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.Ads;

public class OtcTradeDescView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public Context f80094b;

    /* renamed from: c  reason: collision with root package name */
    public AvatarImageView f80095c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80096d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80097e;

    /* renamed from: f  reason: collision with root package name */
    public Ads f80098f;

    public OtcTradeDescView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        this.f80094b = context;
        View inflate = FrameLayout.inflate(context, R$layout.otc_trade_desc_layout, this);
        this.f80095c = (AvatarImageView) inflate.findViewById(R$id.merchantHeader);
        this.f80097e = (TextView) inflate.findViewById(R$id.id_desc_content_tv);
        this.f80096d = (TextView) inflate.findViewById(R$id.id_desc_title_tv);
    }

    public TextView getIdDescContentTv() {
        return this.f80097e;
    }

    public void setAdsData(Ads ads) {
        int i11;
        int i12;
        this.f80098f = ads;
        if (ads != null && this.f80094b != null) {
            if (!TextUtils.isEmpty(ads.getUserName())) {
                this.f80095c.setText(String.valueOf(ads.getUserName().charAt(0)));
                String string = this.f80094b.getString(R$string.n_otc_trade_remind);
                String str = ads.getUserName() + " " + string;
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f80094b, R$color.otc_trade_desc_hint_color)), str.length() - string.length(), str.length(), 34);
                this.f80096d.setText(spannableString);
            }
            this.f80095c.setBgColor(0);
            AvatarImageView avatarImageView = this.f80095c;
            if (ads.getMerchantLevel() != 3) {
                i11 = ContextCompat.getColor(this.f80094b, R$color.baseColorMajorTheme100);
            } else {
                i11 = ContextCompat.getColor(this.f80094b, R$color.otc_out_button_normal_color);
            }
            avatarImageView.setStartColor(i11);
            AvatarImageView avatarImageView2 = this.f80095c;
            if (ads.getMerchantLevel() != 3) {
                i12 = ContextCompat.getColor(this.f80094b, R$color.baseColorMajorTheme100);
            } else {
                i12 = ContextCompat.getColor(this.f80094b, R$color.otc_out_button_normal_color);
            }
            avatarImageView2.setEndColor(i12);
        }
    }

    public void setContentData(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f80097e) != null) {
            textView.setText(str);
        }
    }

    public OtcTradeDescView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
