package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.d0;

public final class ExpandedMenuView extends ListView implements e.b, j, AdapterView.OnItemClickListener {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f4044d = {16842964, 16843049};

    /* renamed from: b  reason: collision with root package name */
    public e f4045b;

    /* renamed from: c  reason: collision with root package name */
    public int f4046c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public boolean a(g gVar) {
        return this.f4045b.performItemAction(gVar, 0);
    }

    public int getWindowAnimations() {
        return this.f4046c;
    }

    public void initialize(e eVar) {
        this.f4045b = eVar;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
        a((g) getAdapter().getItem(i11));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        d0 v11 = d0.v(context, attributeSet, f4044d, i11, 0);
        if (v11.s(0)) {
            setBackgroundDrawable(v11.g(0));
        }
        if (v11.s(1)) {
            setDivider(v11.g(1));
        }
        v11.w();
    }
}
