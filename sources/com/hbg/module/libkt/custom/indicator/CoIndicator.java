package com.hbg.module.libkt.custom.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public final class CoIndicator extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public a f24775b;

    /* renamed from: c  reason: collision with root package name */
    public oe.a f24776c;

    /* renamed from: d  reason: collision with root package name */
    public View f24777d;

    public interface a {
        void onSelected(int i11);
    }

    public CoIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i11) {
        oe.a aVar = this.f24776c;
        if (aVar != null) {
            aVar.onPageScrollStateChanged(i11);
        }
    }

    public final void b(int i11, float f11, int i12) {
        oe.a aVar = this.f24776c;
        if (aVar != null) {
            aVar.onPageScrolled(i11, f11, i12);
        }
    }

    public final void c(int i11) {
        oe.a aVar = this.f24776c;
        if (aVar != null) {
            aVar.onPageSelected(i11);
        }
        a aVar2 = this.f24775b;
        if (aVar2 != null) {
            aVar2.onSelected(i11);
        }
    }

    public final a getListener() {
        return this.f24775b;
    }

    public final oe.a getNavigator() {
        return this.f24776c;
    }

    public final View getViewLine() {
        return this.f24777d;
    }

    public final void setListener(a aVar) {
        this.f24775b = aVar;
    }

    public final void setNavigator(oe.a aVar) {
        oe.a aVar2 = this.f24776c;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar.onDetachFromMagicIndicator();
            }
            this.f24776c = aVar;
            removeAllViews();
            if (this.f24776c instanceof View) {
                addView((View) this.f24776c, new FrameLayout.LayoutParams(-1, -1));
                aVar.onAttachToMagicIndicator();
            }
        }
    }

    public final void setOnPageSelectListener(a aVar) {
        this.f24775b = aVar;
    }

    public final void setViewLine(View view) {
        this.f24777d = view;
    }
}
