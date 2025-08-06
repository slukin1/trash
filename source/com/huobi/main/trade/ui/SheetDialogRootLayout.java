package com.huobi.main.trade.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

public class SheetDialogRootLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f77787b;

    public SheetDialogRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(View view) {
        if (view instanceof ViewGroup) {
            int i11 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i11 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (childAt instanceof RecyclerView) {
                        this.f77787b = (RecyclerView) childAt;
                        return;
                    } else {
                        a(childAt);
                        i11++;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i11) {
        RecyclerView recyclerView;
        if (this.f77787b == null) {
            a(this);
        }
        if (i11 != 2 || (recyclerView = this.f77787b) == null || !recyclerView.canScrollVertically(-1)) {
            return super.onStartNestedScroll(view, view2, i11);
        }
        return true;
    }
}
