package com.hbg.lib.common.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.lib.common.R$styleable;
import com.huobi.view.roundimg.RoundedDrawable;
import kotlin.jvm.internal.r;

public final class TriangleView extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f67562b;

    /* renamed from: c  reason: collision with root package name */
    public int f67563c;

    /* renamed from: d  reason: collision with root package name */
    public int f67564d;

    /* renamed from: e  reason: collision with root package name */
    public Direction f67565e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f67566f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f67567g;

    public enum Direction {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67568a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.hbg.lib.common.view.TriangleView$Direction[] r0 = com.hbg.lib.common.view.TriangleView.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.hbg.lib.common.view.TriangleView$Direction r1 = com.hbg.lib.common.view.TriangleView.Direction.TOP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.hbg.lib.common.view.TriangleView$Direction r1 = com.hbg.lib.common.view.TriangleView.Direction.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.hbg.lib.common.view.TriangleView$Direction r1 = com.hbg.lib.common.view.TriangleView.Direction.LEFT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.hbg.lib.common.view.TriangleView$Direction r1 = com.hbg.lib.common.view.TriangleView.Direction.RIGHT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f67568a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.view.TriangleView.a.<clinit>():void");
        }
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    public TriangleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f67562b = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f67563c = a(8.0f);
        this.f67564d = a(4.0f);
        this.f67565e = Direction.BOTTOM;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f67562b);
        this.f67566f = paint;
        this.f67567g = new Path();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.TriangleView, 0, 0);
        try {
            this.f67562b = obtainStyledAttributes.getColor(R$styleable.TriangleView_triangleColor, RoundedDrawable.DEFAULT_BORDER_COLOR);
            this.f67563c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TriangleView_triangleWidth, a(8.0f));
            this.f67564d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TriangleView_triangleHeight, a(4.0f));
            this.f67565e = Direction.values()[obtainStyledAttributes.getInt(R$styleable.TriangleView_triangleDirection, Direction.TOP.ordinal())];
            paint.setColor(this.f67562b);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final int a(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public final void b(Canvas canvas) {
        this.f67567g.reset();
        int i11 = a.f67568a[this.f67565e.ordinal()];
        if (i11 == 1) {
            this.f67567g.moveTo(((float) getWidth()) / 2.0f, 0.0f);
            this.f67567g.lineTo((((float) getWidth()) / 2.0f) - (((float) this.f67563c) / 2.0f), (float) this.f67564d);
            this.f67567g.lineTo((((float) getWidth()) / 2.0f) + (((float) this.f67563c) / 2.0f), (float) this.f67564d);
        } else if (i11 == 2) {
            this.f67567g.moveTo(((float) getWidth()) / 2.0f, (float) getHeight());
            this.f67567g.lineTo((((float) getWidth()) / 2.0f) - (((float) this.f67563c) / 2.0f), ((float) getHeight()) - ((float) this.f67564d));
            this.f67567g.lineTo((((float) getWidth()) / 2.0f) + (((float) this.f67563c) / 2.0f), ((float) getHeight()) - ((float) this.f67564d));
        } else if (i11 == 3) {
            this.f67567g.moveTo(0.0f, ((float) getHeight()) / 2.0f);
            this.f67567g.lineTo((float) this.f67563c, (((float) getHeight()) / 2.0f) - (((float) this.f67564d) / 2.0f));
            this.f67567g.lineTo((float) this.f67563c, (((float) getHeight()) / 2.0f) + (((float) this.f67564d) / 2.0f));
        } else if (i11 == 4) {
            this.f67567g.moveTo((float) getWidth(), ((float) getHeight()) / 2.0f);
            this.f67567g.lineTo(((float) getWidth()) - ((float) this.f67563c), (((float) getHeight()) / 2.0f) - (((float) this.f67564d) / 2.0f));
            this.f67567g.lineTo(((float) getWidth()) - ((float) this.f67563c), (((float) getHeight()) / 2.0f) + (((float) this.f67564d) / 2.0f));
        }
        this.f67567g.close();
        canvas.drawPath(this.f67567g, this.f67566f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
    }

    public final void setTriangleColor(int i11) {
        this.f67562b = i11;
        this.f67566f.setColor(i11);
        invalidate();
    }

    public final void setTriangleDirection(Direction direction) {
        this.f67565e = direction;
        invalidate();
    }

    public final void setTriangleHeight(int i11) {
        this.f67564d = i11;
        invalidate();
    }

    public final void setTriangleWidth(int i11) {
        this.f67563c = i11;
        invalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TriangleView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
