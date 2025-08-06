package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;

public class MockView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f7855b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public Paint f7856c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    public Paint f7857d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    public boolean f7858e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7859f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f7860g = null;

    /* renamed from: h  reason: collision with root package name */
    public Rect f7861h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    public int f7862i = Color.argb(255, 0, 0, 0);

    /* renamed from: j  reason: collision with root package name */
    public int f7863j = Color.argb(255, 200, 200, 200);

    /* renamed from: k  reason: collision with root package name */
    public int f7864k = Color.argb(255, 50, 50, 50);

    /* renamed from: l  reason: collision with root package name */
    public int f7865l = 4;

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MockView_mock_label) {
                    this.f7860g = obtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MockView_mock_showDiagonals) {
                    this.f7858e = obtainStyledAttributes.getBoolean(index, this.f7858e);
                } else if (index == R$styleable.MockView_mock_diagonalsColor) {
                    this.f7862i = obtainStyledAttributes.getColor(index, this.f7862i);
                } else if (index == R$styleable.MockView_mock_labelBackgroundColor) {
                    this.f7864k = obtainStyledAttributes.getColor(index, this.f7864k);
                } else if (index == R$styleable.MockView_mock_labelColor) {
                    this.f7863j = obtainStyledAttributes.getColor(index, this.f7863j);
                } else if (index == R$styleable.MockView_mock_showLabel) {
                    this.f7859f = obtainStyledAttributes.getBoolean(index, this.f7859f);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f7860g == null) {
            try {
                this.f7860g = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f7855b.setColor(this.f7862i);
        this.f7855b.setAntiAlias(true);
        this.f7856c.setColor(this.f7863j);
        this.f7856c.setAntiAlias(true);
        this.f7857d.setColor(this.f7864k);
        this.f7865l = Math.round(((float) this.f7865l) * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f7858e) {
            width--;
            height--;
            float f11 = (float) width;
            float f12 = (float) height;
            canvas.drawLine(0.0f, 0.0f, f11, f12, this.f7855b);
            Canvas canvas2 = canvas;
            float f13 = f11;
            canvas2.drawLine(0.0f, f12, f13, 0.0f, this.f7855b);
            canvas2.drawLine(0.0f, 0.0f, f13, 0.0f, this.f7855b);
            float f14 = f11;
            float f15 = f12;
            canvas2.drawLine(f14, 0.0f, f13, f15, this.f7855b);
            float f16 = f12;
            canvas2.drawLine(f14, f16, 0.0f, f15, this.f7855b);
            canvas2.drawLine(0.0f, f16, 0.0f, 0.0f, this.f7855b);
        }
        String str = this.f7860g;
        if (str != null && this.f7859f) {
            this.f7856c.getTextBounds(str, 0, str.length(), this.f7861h);
            float width2 = ((float) (width - this.f7861h.width())) / 2.0f;
            float height2 = (((float) (height - this.f7861h.height())) / 2.0f) + ((float) this.f7861h.height());
            this.f7861h.offset((int) width2, (int) height2);
            Rect rect = this.f7861h;
            int i11 = rect.left;
            int i12 = this.f7865l;
            rect.set(i11 - i12, rect.top - i12, rect.right + i12, rect.bottom + i12);
            canvas.drawRect(this.f7861h, this.f7857d);
            canvas.drawText(this.f7860g, width2, height2, this.f7856c);
        }
    }

    public MockView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }
}
