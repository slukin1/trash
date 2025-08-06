package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import java.util.List;

public class SecurityBannerView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public SecurityScrollLayout f80125b;

    /* renamed from: c  reason: collision with root package name */
    public SafeLottieView f80126c;

    public SecurityBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        FrameLayout.inflate(getContext(), R$layout.view_security_banner_layout, this);
        this.f80125b = (SecurityScrollLayout) findViewById(R$id.security_scroll_layout);
        this.f80126c = (SafeLottieView) findViewById(R$id.success_lottie_view);
    }

    public void setData(List<String> list) {
        SecurityScrollLayout securityScrollLayout = this.f80125b;
        if (securityScrollLayout != null) {
            securityScrollLayout.setDatas(list);
        }
    }

    public SecurityBannerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
