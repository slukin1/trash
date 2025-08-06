package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.view.TitleLayout;
import java.util.List;

public class OtcTopTabLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TitleLayout f80058b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f80059c;

    /* renamed from: d  reason: collision with root package name */
    public a f80060d;

    public interface a {
    }

    public OtcTopTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void a(Context context) {
        FrameLayout.inflate(context, R$layout.view_otc_top_tab_layout, this);
        this.f80058b = (TitleLayout) findViewById(R$id.id_title_layout);
    }

    public void setCurrentItem(int i11) {
        if (i11 < this.f80059c.size()) {
            this.f80058b.setIndex(i11);
        }
    }

    public void setOtcTopTabCallback(a aVar) {
        this.f80060d = aVar;
    }

    public OtcTopTabLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
