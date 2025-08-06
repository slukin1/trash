package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Placeholder extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f8099b = -1;

    /* renamed from: c  reason: collision with root package name */
    public View f8100c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f8101d = 4;

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        super.setVisibility(this.f8101d);
        this.f8099b = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_placeholder_content) {
                    this.f8099b = obtainStyledAttributes.getResourceId(index, this.f8099b);
                } else if (index == R$styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f8101d = obtainStyledAttributes.getInt(index, this.f8101d);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f8100c != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f8100c.getLayoutParams();
            layoutParams2.f7969u0.e1(0);
            ConstraintWidget.DimensionBehaviour B = layoutParams.f7969u0.B();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
            if (B != dimensionBehaviour) {
                layoutParams.f7969u0.f1(layoutParams2.f7969u0.U());
            }
            if (layoutParams.f7969u0.R() != dimensionBehaviour) {
                layoutParams.f7969u0.G0(layoutParams2.f7969u0.y());
            }
            layoutParams2.f7969u0.e1(8);
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        if (this.f8099b == -1 && !isInEditMode()) {
            setVisibility(this.f8101d);
        }
        View findViewById = constraintLayout.findViewById(this.f8099b);
        this.f8100c = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).f7945i0 = true;
            this.f8100c.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f8100c;
    }

    public int getEmptyVisibility() {
        return this.f8101d;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i11) {
        View findViewById;
        if (this.f8099b != i11) {
            View view = this.f8100c;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.LayoutParams) this.f8100c.getLayoutParams()).f7945i0 = false;
                this.f8100c = null;
            }
            this.f8099b = i11;
            if (i11 != -1 && (findViewById = ((View) getParent()).findViewById(i11)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i11) {
        this.f8101d = i11;
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(attributeSet);
    }
}
