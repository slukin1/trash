package oa;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public View f76382a;

    /* renamed from: b  reason: collision with root package name */
    public int f76383b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup.LayoutParams f76384c;

    public k(View view) {
        if (view != null) {
            this.f76382a = view;
            view.getViewTreeObserver().addOnGlobalLayoutListener(new j(this));
            this.f76384c = this.f76382a.getLayoutParams();
        }
    }

    public static void b(View view) {
        new k(view);
    }

    public final int c() {
        Rect rect = new Rect();
        this.f76382a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public final void d() {
        int c11 = c();
        if (c11 != this.f76383b) {
            this.f76384c.height = c11;
            this.f76382a.requestLayout();
            this.f76383b = c11;
        }
    }
}
