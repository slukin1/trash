package net.lucode.hackware.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import p10.a;

public class MagicIndicator extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public a f58462b;

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(int i11) {
        a aVar = this.f58462b;
        if (aVar != null) {
            aVar.onPageScrollStateChanged(i11);
        }
    }

    public void b(int i11, float f11, int i12) {
        a aVar = this.f58462b;
        if (aVar != null) {
            aVar.onPageScrolled(i11, f11, i12);
        }
    }

    public void c(int i11) {
        a aVar = this.f58462b;
        if (aVar != null) {
            aVar.onPageSelected(i11);
        }
    }

    public a getNavigator() {
        return this.f58462b;
    }

    public void setNavigator(a aVar) {
        a aVar2 = this.f58462b;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.onDetachFromMagicIndicator();
            }
            this.f58462b = aVar;
            removeAllViews();
            if (this.f58462b instanceof View) {
                addView((View) this.f58462b, new FrameLayout.LayoutParams(-1, -1));
                this.f58462b.onAttachToMagicIndicator();
            }
        }
    }
}
