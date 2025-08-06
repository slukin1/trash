package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.s;

public class FitWindowsLinearLayout extends LinearLayout implements s {

    /* renamed from: b  reason: collision with root package name */
    public s.a f4423b;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean fitSystemWindows(Rect rect) {
        s.a aVar = this.f4423b;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(s.a aVar) {
        this.f4423b = aVar;
    }
}
