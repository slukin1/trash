package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.core.widget.k;

class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f4359b = (Build.VERSION.SDK_INT < 21);

    /* renamed from: a  reason: collision with root package name */
    public boolean f4360a;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet, i11, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i11, int i12) {
        d0 v11 = d0.v(context, attributeSet, R$styleable.PopupWindow, i11, i12);
        int i13 = R$styleable.PopupWindow_overlapAnchor;
        if (v11.s(i13)) {
            b(v11.a(i13, false));
        }
        setBackgroundDrawable(v11.g(R$styleable.PopupWindow_android_popupBackground));
        v11.w();
    }

    public final void b(boolean z11) {
        if (f4359b) {
            this.f4360a = z11;
        } else {
            k.a(this, z11);
        }
    }

    public void showAsDropDown(View view, int i11, int i12) {
        if (f4359b && this.f4360a) {
            i12 -= view.getHeight();
        }
        super.showAsDropDown(view, i11, i12);
    }

    public void update(View view, int i11, int i12, int i13, int i14) {
        if (f4359b && this.f4360a) {
            i12 -= view.getHeight();
        }
        super.update(view, i11, i12, i13, i14);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        a(context, attributeSet, i11, i12);
    }

    public void showAsDropDown(View view, int i11, int i12, int i13) {
        if (f4359b && this.f4360a) {
            i12 -= view.getHeight();
        }
        super.showAsDropDown(view, i11, i12, i13);
    }
}
