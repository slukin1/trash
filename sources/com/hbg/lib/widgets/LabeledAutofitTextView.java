package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

public class LabeledAutofitTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public int f71464b;

    /* renamed from: c  reason: collision with root package name */
    public int f71465c;

    /* renamed from: d  reason: collision with root package name */
    public float f71466d;

    /* renamed from: e  reason: collision with root package name */
    public float f71467e;

    /* renamed from: f  reason: collision with root package name */
    public float f71468f;

    /* renamed from: g  reason: collision with root package name */
    public final float f71469g;

    /* renamed from: h  reason: collision with root package name */
    public float f71470h;

    /* renamed from: i  reason: collision with root package name */
    public float f71471i;

    /* renamed from: j  reason: collision with root package name */
    public float f71472j;

    /* renamed from: k  reason: collision with root package name */
    public int f71473k;

    /* renamed from: l  reason: collision with root package name */
    public int f71474l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f71475m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f71476n;

    /* renamed from: o  reason: collision with root package name */
    public final Paint f71477o;

    /* renamed from: p  reason: collision with root package name */
    public final Paint f71478p;

    /* renamed from: q  reason: collision with root package name */
    public String f71479q;

    /* renamed from: r  reason: collision with root package name */
    public String f71480r;

    public LabeledAutofitTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public final String d(String str) {
        int paddingLeft = (this.f71464b - getPaddingLeft()) - getPaddingRight();
        this.f71467e = this.f71477o.measureText(this.f71479q);
        float measureText = this.f71478p.measureText(this.f71480r);
        this.f71466d = measureText;
        float f11 = (float) paddingLeft;
        if (this.f71467e + measureText > f11) {
            this.f71467e = f11 - measureText;
            int breakText = this.f71477o.breakText(str, 0, str.length(), true, this.f71467e, (float[]) null);
            if (breakText > 0) {
                str = str.substring(0, breakText - 1) + "...";
            } else {
                str = str.charAt(0) + "...";
            }
            this.f71467e = this.f71477o.measureText(str);
        }
        return str;
    }

    public void draw(Canvas canvas) {
        float f11;
        super.draw(canvas);
        if (this.f71475m) {
            e();
        }
        int gravity = getGravity();
        if (17 == gravity || 1 == gravity || 16 == gravity) {
            f11 = ((((float) this.f71464b) - this.f71466d) - this.f71467e) / 2.0f;
        } else if (5 == gravity || 85 == gravity || 53 == gravity || 21 == gravity) {
            f11 = (((float) this.f71464b) - this.f71466d) - this.f71467e;
        } else {
            f11 = 0.0f;
        }
        float f12 = (((float) (this.f71465c >> 1)) + this.f71468f) - 1.0f;
        String str = this.f71479q;
        if (this.f71476n && !this.f71475m) {
            str = d(str);
            this.f71479q = str;
        }
        canvas.drawText(str, f11, f12, this.f71477o);
        canvas.drawText(this.f71480r, f11 + this.f71467e, f12, this.f71478p);
    }

    public final void e() {
        if (this.f71464b > 0 && !TextUtils.isEmpty(this.f71479q)) {
            int paddingLeft = (this.f71464b - getPaddingLeft()) - getPaddingRight();
            float textSize = getTextSize();
            float f11 = this.f71471i;
            float f12 = this.f71472j;
            if (textSize <= f11) {
                f11 = textSize - 2.0f;
            }
            float f13 = (float) paddingLeft;
            if (i(this.f71477o, this.f71479q, textSize) + i(this.f71478p, this.f71480r, f11) <= f13) {
                j(textSize, f11);
                return;
            }
            while (textSize - f12 > 0.5f) {
                if (textSize <= f11) {
                    f11 = textSize - 2.0f;
                }
                float f14 = (textSize + f12) / 2.0f;
                if (i(this.f71477o, this.f71479q, f14) + i(this.f71478p, this.f71480r, f11) > f13) {
                    textSize = f14;
                } else {
                    f12 = f14;
                }
            }
            if (f12 <= f11) {
                f11 = f12 - 2.0f;
            }
            j(f12, f11);
        }
    }

    public final void f() {
        int currentTextColor = getCurrentTextColor();
        if (this.f71473k <= 0) {
            this.f71473k = currentTextColor;
        }
        if (this.f71474l <= 0) {
            this.f71474l = currentTextColor;
        }
        this.f71477o.setColor(this.f71473k);
        this.f71478p.setColor(this.f71474l);
    }

    public final void g() {
        float textSize = getTextSize();
        if (this.f71470h == -1.0f) {
            if (textSize > 0.0f) {
                this.f71470h = textSize;
            } else {
                this.f71470h = getResources().getDimension(R$dimen.global_text_size_6);
            }
        }
        float f11 = this.f71472j;
        if (f11 != -1.0f && this.f71470h < f11) {
            this.f71470h = f11;
        }
        if (this.f71471i == -1.0f) {
            this.f71471i = this.f71470h / 2.0f;
        }
        setTextSize(0, this.f71470h);
        this.f71477o.setTextSize(this.f71470h);
        this.f71478p.setTextSize(this.f71471i);
    }

    public final void h(Context context, AttributeSet attributeSet, int i11) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LabeledAutofitTextView, i11, 0);
            this.f71470h = obtainStyledAttributes.getDimension(R$styleable.LabeledAutofitTextView_lat_content_text_size, this.f71470h);
            this.f71471i = obtainStyledAttributes.getDimension(R$styleable.LabeledAutofitTextView_lat_label_text_size, this.f71471i);
            this.f71472j = obtainStyledAttributes.getDimension(R$styleable.LabeledAutofitTextView_lat_min_text_size, this.f71472j);
            this.f71473k = obtainStyledAttributes.getColor(R$styleable.LabeledAutofitTextView_lat_content_text_color, this.f71473k);
            this.f71474l = obtainStyledAttributes.getColor(R$styleable.LabeledAutofitTextView_lat_label_text_color, this.f71474l);
            this.f71479q = obtainStyledAttributes.getString(R$styleable.LabeledAutofitTextView_lat_content_text);
            this.f71480r = obtainStyledAttributes.getString(R$styleable.LabeledAutofitTextView_lat_label_text);
            this.f71475m = obtainStyledAttributes.getBoolean(R$styleable.LabeledAutofitTextView_lat_autofit_enable, this.f71475m);
            this.f71476n = obtainStyledAttributes.getBoolean(R$styleable.LabeledAutofitTextView_lat_break_text_enable, this.f71476n);
            obtainStyledAttributes.recycle();
        }
        Paint paint = this.f71477o;
        Context context2 = getContext();
        int i12 = R$font.roboto_medium;
        paint.setTypeface(ResourcesCompat.h(context2, i12));
        this.f71478p.setTypeface(ResourcesCompat.h(getContext(), i12));
        g();
        f();
    }

    public final float i(Paint paint, String str, float f11) {
        if (paint == null || TextUtils.isEmpty(str) || f11 <= 0.0f) {
            return 0.0f;
        }
        paint.setTextSize(f11);
        return paint.measureText(str);
    }

    public final void j(float f11, float f12) {
        Paint.FontMetrics fontMetrics = this.f71477o.getFontMetrics();
        float f13 = fontMetrics.descent;
        this.f71468f = ((f13 - fontMetrics.ascent) / 2.0f) - f13;
        this.f71467e = i(this.f71477o, this.f71479q, f11);
        this.f71466d = i(this.f71478p, this.f71480r, f12);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (int) (fontMetrics.descent - fontMetrics.ascent);
            setLayoutParams(layoutParams);
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f71464b = i11;
        this.f71465c = i12;
    }

    public void setContentTextColor(int i11) {
        this.f71473k = i11;
        this.f71477o.setColor(i11);
    }

    public void setLabelTextColor(int i11) {
        this.f71474l = i11;
        this.f71478p.setColor(i11);
    }

    public LabeledAutofitTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71469g = 2.0f;
        this.f71470h = -1.0f;
        this.f71471i = -1.0f;
        this.f71472j = -1.0f;
        this.f71473k = -1;
        this.f71474l = -1;
        this.f71475m = true;
        this.f71476n = false;
        this.f71477o = new Paint(1);
        this.f71478p = new Paint(1);
        this.f71479q = "";
        this.f71480r = "";
        h(context, attributeSet, i11);
    }
}
