package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import i6.d;

public class OtcFoldHeaderLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f79986b;

    /* renamed from: c  reason: collision with root package name */
    public int f79987c;

    /* renamed from: d  reason: collision with root package name */
    public a f79988d;

    public interface a {
        void a(View view, int i11);
    }

    public OtcFoldHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        d.e("OtcFoldHeaderLayout-->", "onSizeChanged");
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 == 4) {
            this.f79986b = i11;
        } else if (this.f79986b == 4) {
            this.f79986b = i11;
        } else {
            this.f79987c = i11;
            a aVar = this.f79988d;
            if (aVar != null) {
                aVar.a(view, i11);
            }
        }
    }

    public void setVisibleListener(a aVar) {
        this.f79988d = aVar;
    }

    public OtcFoldHeaderLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f79986b = 8;
        this.f79987c = 8;
        setTag(OtcFoldHeaderLayout.class.getName());
    }
}
