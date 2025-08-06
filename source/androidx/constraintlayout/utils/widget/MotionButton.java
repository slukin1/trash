package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R$styleable;

public class MotionButton extends AppCompatButton {

    /* renamed from: b  reason: collision with root package name */
    public float f7866b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f7867c = Float.NaN;

    /* renamed from: d  reason: collision with root package name */
    public Path f7868d;

    /* renamed from: e  reason: collision with root package name */
    public ViewOutlineProvider f7869e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f7870f;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public void getOutline(View view, Outline outline) {
            int width = MotionButton.this.getWidth();
            int height = MotionButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionButton.this.f7866b) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.f7867c);
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public final void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == R$styleable.ImageFilterView_roundPercent && Build.VERSION.SDK_INT >= 21) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void draw(Canvas canvas) {
        boolean z11;
        if (Build.VERSION.SDK_INT >= 21 || this.f7867c == 0.0f || this.f7868d == null) {
            z11 = false;
        } else {
            z11 = true;
            canvas.save();
            canvas.clipPath(this.f7868d);
        }
        super.draw(canvas);
        if (z11) {
            canvas.restore();
        }
    }

    public float getRound() {
        return this.f7867c;
    }

    public float getRoundPercent() {
        return this.f7866b;
    }

    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7867c = f11;
            float f12 = this.f7866b;
            this.f7866b = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z11 = this.f7867c != f11;
        this.f7867c = f11;
        if (f11 != 0.0f) {
            if (this.f7868d == null) {
                this.f7868d = new Path();
            }
            if (this.f7870f == null) {
                this.f7870f = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f7869e == null) {
                    b bVar = new b();
                    this.f7869e = bVar;
                    setOutlineProvider(bVar);
                }
                setClipToOutline(true);
            }
            this.f7870f.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f7868d.reset();
            Path path = this.f7868d;
            RectF rectF = this.f7870f;
            float f13 = this.f7867c;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z11 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f11) {
        boolean z11 = this.f7866b != f11;
        this.f7866b = f11;
        if (f11 != 0.0f) {
            if (this.f7868d == null) {
                this.f7868d = new Path();
            }
            if (this.f7870f == null) {
                this.f7870f = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f7869e == null) {
                    a aVar = new a();
                    this.f7869e = aVar;
                    setOutlineProvider(aVar);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f7866b) / 2.0f;
            this.f7870f.set(0.0f, 0.0f, (float) width, (float) height);
            this.f7868d.reset();
            this.f7868d.addRoundRect(this.f7870f, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z11 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context, attributeSet);
    }
}
