package com.hbg.lib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import i6.d;

public class FragmentContainerLayout extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f71338b = 0;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f71339c = new a();

    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        public void onChildViewAdded(View view, View view2) {
        }

        public void onChildViewRemoved(View view, View view2) {
            if (view2.getTag(R$id.fragment_container) != null && FragmentContainerLayout.this.f71338b > 0) {
                FragmentContainerLayout.b(FragmentContainerLayout.this);
            }
        }
    }

    public FragmentContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ int b(FragmentContainerLayout fragmentContainerLayout) {
        int i11 = fragmentContainerLayout.f71338b;
        fragmentContainerLayout.f71338b = i11 - 1;
        return i11;
    }

    public void addView(View view) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setOnHierarchyChangeListener(this.f71339c);
            this.f71338b++;
            viewGroup.addView(view, viewGroup.indexOfChild(this) + this.f71338b, getLayoutParams());
            view.setTag(R$id.fragment_container, new Object());
            return;
        }
        super.addView(view);
    }

    public void removeView(View view) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null || viewGroup.indexOfChild(view) < 0) {
            super.removeView(view);
            return;
        }
        d.b("view index:" + viewGroup.indexOfChild(view));
        viewGroup.removeView(view);
    }

    public FragmentContainerLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
