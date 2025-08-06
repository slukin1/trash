package com.scwang.smartrefresh.layout.internal.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class PathsView extends View {

    /* renamed from: b  reason: collision with root package name */
    public PathsDrawable f29937b = new PathsDrawable();

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i11) {
        this.f29937b = new PathsDrawable();
    }

    public void b(int... iArr) {
        this.f29937b.h(iArr);
    }

    public void c(String... strArr) {
        this.f29937b.i(strArr);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f29937b.draw(canvas);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            c(getTag().toString());
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f29937b.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i13 - i11) - getPaddingRight(), getPaddingLeft()), Math.max((i14 - i12) - getPaddingTop(), getPaddingTop()));
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(this.f29937b.n() + getPaddingLeft() + getPaddingRight(), i11), View.resolveSize(this.f29937b.f() + getPaddingTop() + getPaddingBottom(), i12));
    }

    public PathsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet, i11);
    }
}
