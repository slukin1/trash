package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

public class MotionTelltales extends MockView {

    /* renamed from: m  reason: collision with root package name */
    public Paint f7900m = new Paint();

    /* renamed from: n  reason: collision with root package name */
    public MotionLayout f7901n;

    /* renamed from: o  reason: collision with root package name */
    public float[] f7902o = new float[2];

    /* renamed from: p  reason: collision with root package name */
    public Matrix f7903p = new Matrix();

    /* renamed from: q  reason: collision with root package name */
    public int f7904q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f7905r = -65281;

    /* renamed from: s  reason: collision with root package name */
    public float f7906s = 0.25f;

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionTelltales_telltales_tailColor) {
                    this.f7905r = obtainStyledAttributes.getColor(index, this.f7905r);
                } else if (index == R$styleable.MotionTelltales_telltales_velocityMode) {
                    this.f7904q = obtainStyledAttributes.getInt(index, this.f7904q);
                } else if (index == R$styleable.MotionTelltales_telltales_tailScale) {
                    this.f7906s = obtainStyledAttributes.getFloat(index, this.f7906s);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f7900m.setColor(this.f7905r);
        this.f7900m.setStrokeWidth(5.0f);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f7903p);
        if (this.f7901n == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f7901n = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i11 = 0; i11 < 5; i11++) {
            float f11 = fArr[i11];
            for (int i12 = 0; i12 < 5; i12++) {
                float f12 = fArr[i12];
                this.f7901n.f0(this, f12, f11, this.f7902o, this.f7904q);
                this.f7903p.mapVectors(this.f7902o);
                float f13 = ((float) width) * f12;
                float f14 = ((float) height) * f11;
                float[] fArr2 = this.f7902o;
                float f15 = fArr2[0];
                float f16 = this.f7906s;
                float f17 = f14 - (fArr2[1] * f16);
                this.f7903p.mapVectors(fArr2);
                canvas.drawLine(f13, f14, f13 - (f15 * f16), f17, this.f7900m);
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f7860g = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }
}
