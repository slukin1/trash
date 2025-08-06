package com.hbg.component.kline.render;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public interface m {
    void a(Canvas canvas);

    boolean b(MotionEvent motionEvent);

    void c(boolean z11, int i11, int i12, int i13, int i14);

    int computeVerticalScrollExtent();

    int computeVerticalScrollOffset();

    int computeVerticalScrollRange();

    void d(int i11, int i12);

    int e();

    void f();

    void g(int i11, int i12, int i13, int i14);

    int h();

    int i();

    void j(View view, Context context, AttributeSet attributeSet, int i11);

    void onAttachedToWindow();

    void onDetachedFromWindow();
}
