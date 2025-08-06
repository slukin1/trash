package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.R$attr;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.widget.R$styleable;
import com.google.android.material.badge.BadgeDrawable;

public class MotionLabel extends View implements androidx.constraintlayout.motion.widget.b {
    public static String W = "MotionLabel";
    public boolean A = false;
    public float B;
    public float C;
    public float D;
    public Drawable E;
    public Matrix F;
    public Bitmap G;
    public BitmapShader H;
    public Matrix I;
    public float J = Float.NaN;
    public float K = Float.NaN;
    public float L = 0.0f;
    public float M = 0.0f;
    public Paint N = new Paint();
    public int O = 0;
    public Rect P;
    public Paint Q;
    public float R;
    public float S = Float.NaN;
    public float T = Float.NaN;
    public float U = Float.NaN;
    public float V = Float.NaN;

    /* renamed from: b  reason: collision with root package name */
    public TextPaint f7873b = new TextPaint();

    /* renamed from: c  reason: collision with root package name */
    public Path f7874c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public int f7875d = 65535;

    /* renamed from: e  reason: collision with root package name */
    public int f7876e = 65535;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7877f = false;

    /* renamed from: g  reason: collision with root package name */
    public float f7878g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f7879h = Float.NaN;

    /* renamed from: i  reason: collision with root package name */
    public ViewOutlineProvider f7880i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f7881j;

    /* renamed from: k  reason: collision with root package name */
    public float f7882k = 48.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f7883l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public int f7884m;

    /* renamed from: n  reason: collision with root package name */
    public int f7885n;

    /* renamed from: o  reason: collision with root package name */
    public float f7886o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    public String f7887p = "Hello World";

    /* renamed from: q  reason: collision with root package name */
    public boolean f7888q = true;

    /* renamed from: r  reason: collision with root package name */
    public Rect f7889r = new Rect();

    /* renamed from: s  reason: collision with root package name */
    public int f7890s = 1;

    /* renamed from: t  reason: collision with root package name */
    public int f7891t = 1;

    /* renamed from: u  reason: collision with root package name */
    public int f7892u = 1;

    /* renamed from: v  reason: collision with root package name */
    public int f7893v = 1;

    /* renamed from: w  reason: collision with root package name */
    public String f7894w;

    /* renamed from: x  reason: collision with root package name */
    public Layout f7895x;

    /* renamed from: y  reason: collision with root package name */
    public int f7896y = BadgeDrawable.TOP_START;

    /* renamed from: z  reason: collision with root package name */
    public int f7897z = 0;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public void getOutline(View view, Outline outline) {
            int width = MotionLabel.this.getWidth();
            int height = MotionLabel.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionLabel.this.f7878g) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.f7879h);
        }
    }

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context, attributeSet);
    }

    private float getHorizontalOffset() {
        float f11 = Float.isNaN(this.f7883l) ? 1.0f : this.f7882k / this.f7883l;
        TextPaint textPaint = this.f7873b;
        String str = this.f7887p;
        return (((((Float.isNaN(this.C) ? (float) getMeasuredWidth() : this.C) - ((float) getPaddingLeft())) - ((float) getPaddingRight())) - (f11 * textPaint.measureText(str, 0, str.length()))) * (this.L + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f11 = Float.isNaN(this.f7883l) ? 1.0f : this.f7882k / this.f7883l;
        Paint.FontMetrics fontMetrics = this.f7873b.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.D) ? (float) getMeasuredHeight() : this.D) - ((float) getPaddingTop())) - ((float) getPaddingBottom());
        float f12 = fontMetrics.descent;
        float f13 = fontMetrics.ascent;
        return (((measuredHeight - ((f12 - f13) * f11)) * (1.0f - this.M)) / 2.0f) - (f11 * f13);
    }

    public void a(float f11, float f12, float f13, float f14) {
        int i11 = (int) (f11 + 0.5f);
        this.B = f11 - ((float) i11);
        int i12 = (int) (f13 + 0.5f);
        int i13 = i12 - i11;
        int i14 = (int) (f14 + 0.5f);
        int i15 = (int) (0.5f + f12);
        int i16 = i14 - i15;
        float f15 = f13 - f11;
        this.C = f15;
        float f16 = f14 - f12;
        this.D = f16;
        d(f11, f12, f13, f14);
        if (getMeasuredHeight() == i16 && getMeasuredWidth() == i13) {
            super.layout(i11, i15, i12, i14);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), View.MeasureSpec.makeMeasureSpec(i16, 1073741824));
            super.layout(i11, i15, i12, i14);
        }
        if (this.A) {
            if (this.P == null) {
                this.Q = new Paint();
                this.P = new Rect();
                this.Q.set(this.f7873b);
                this.R = this.Q.getTextSize();
            }
            this.C = f15;
            this.D = f16;
            Paint paint = this.Q;
            String str = this.f7887p;
            paint.getTextBounds(str, 0, str.length(), this.P);
            int width = this.P.width();
            float height = ((float) this.P.height()) * 1.3f;
            float f17 = (f15 - ((float) this.f7891t)) - ((float) this.f7890s);
            float f18 = (f16 - ((float) this.f7893v)) - ((float) this.f7892u);
            float f19 = (float) width;
            if (f19 * f18 > height * f17) {
                this.f7873b.setTextSize((this.R * f17) / f19);
            } else {
                this.f7873b.setTextSize((this.R * f18) / height);
            }
            if (this.f7877f || !Float.isNaN(this.f7883l)) {
                f(Float.isNaN(this.f7883l) ? 1.0f : this.f7882k / this.f7883l);
            }
        }
    }

    public final void d(float f11, float f12, float f13, float f14) {
        if (this.I != null) {
            this.C = f13 - f11;
            this.D = f14 - f12;
            l();
        }
    }

    public Bitmap e(Bitmap bitmap, int i11) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i12 = 0; i12 < i11 && width >= 32 && height >= 32; i12++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    public void f(float f11) {
        if (this.f7877f || f11 != 1.0f) {
            this.f7874c.reset();
            String str = this.f7887p;
            int length = str.length();
            this.f7873b.getTextBounds(str, 0, length, this.f7889r);
            this.f7873b.getTextPath(str, 0, length, 0.0f, 0.0f, this.f7874c);
            if (f11 != 1.0f) {
                Log.v(W, Debug.a() + " scale " + f11);
                Matrix matrix = new Matrix();
                matrix.postScale(f11, f11);
                this.f7874c.transform(matrix);
            }
            Rect rect = this.f7889r;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = (float) getHeight();
            rectF.right = (float) getWidth();
            this.f7888q = false;
        }
    }

    public final void g(Context context, AttributeSet attributeSet) {
        i(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R$styleable.MotionLabel_android_fontFamily) {
                    this.f7894w = obtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MotionLabel_scaleFromTextSize) {
                    this.f7883l = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f7883l);
                } else if (index == R$styleable.MotionLabel_android_textSize) {
                    this.f7882k = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f7882k);
                } else if (index == R$styleable.MotionLabel_android_textStyle) {
                    this.f7884m = obtainStyledAttributes.getInt(index, this.f7884m);
                } else if (index == R$styleable.MotionLabel_android_typeface) {
                    this.f7885n = obtainStyledAttributes.getInt(index, this.f7885n);
                } else if (index == R$styleable.MotionLabel_android_textColor) {
                    this.f7875d = obtainStyledAttributes.getColor(index, this.f7875d);
                } else if (index == R$styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.f7879h);
                    this.f7879h = dimension;
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(dimension);
                    }
                } else if (index == R$styleable.MotionLabel_borderRoundPercent) {
                    float f11 = obtainStyledAttributes.getFloat(index, this.f7878g);
                    this.f7878g = f11;
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(f11);
                    }
                } else if (index == R$styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R$styleable.MotionLabel_android_autoSizeTextType) {
                    this.f7897z = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.MotionLabel_textOutlineColor) {
                    this.f7876e = obtainStyledAttributes.getInt(index, this.f7876e);
                    this.f7877f = true;
                } else if (index == R$styleable.MotionLabel_textOutlineThickness) {
                    this.f7886o = obtainStyledAttributes.getDimension(index, this.f7886o);
                    this.f7877f = true;
                } else if (index == R$styleable.MotionLabel_textBackground) {
                    this.E = obtainStyledAttributes.getDrawable(index);
                    this.f7877f = true;
                } else if (index == R$styleable.MotionLabel_textBackgroundPanX) {
                    this.S = obtainStyledAttributes.getFloat(index, this.S);
                } else if (index == R$styleable.MotionLabel_textBackgroundPanY) {
                    this.T = obtainStyledAttributes.getFloat(index, this.T);
                } else if (index == R$styleable.MotionLabel_textPanX) {
                    this.L = obtainStyledAttributes.getFloat(index, this.L);
                } else if (index == R$styleable.MotionLabel_textPanY) {
                    this.M = obtainStyledAttributes.getFloat(index, this.M);
                } else if (index == R$styleable.MotionLabel_textBackgroundRotate) {
                    this.V = obtainStyledAttributes.getFloat(index, this.V);
                } else if (index == R$styleable.MotionLabel_textBackgroundZoom) {
                    this.U = obtainStyledAttributes.getFloat(index, this.U);
                } else if (index == R$styleable.MotionLabel_textureHeight) {
                    this.J = obtainStyledAttributes.getDimension(index, this.J);
                } else if (index == R$styleable.MotionLabel_textureWidth) {
                    this.K = obtainStyledAttributes.getDimension(index, this.K);
                } else if (index == R$styleable.MotionLabel_textureEffect) {
                    this.O = obtainStyledAttributes.getInt(index, this.O);
                }
            }
            obtainStyledAttributes.recycle();
        }
        k();
        j();
    }

    public float getRound() {
        return this.f7879h;
    }

    public float getRoundPercent() {
        return this.f7878g;
    }

    public float getScaleFromTextSize() {
        return this.f7883l;
    }

    public float getTextBackgroundPanX() {
        return this.S;
    }

    public float getTextBackgroundPanY() {
        return this.T;
    }

    public float getTextBackgroundRotate() {
        return this.V;
    }

    public float getTextBackgroundZoom() {
        return this.U;
    }

    public int getTextOutlineColor() {
        return this.f7876e;
    }

    public float getTextPanX() {
        return this.L;
    }

    public float getTextPanY() {
        return this.M;
    }

    public float getTextureHeight() {
        return this.J;
    }

    public float getTextureWidth() {
        return this.K;
    }

    public Typeface getTypeface() {
        return this.f7873b.getTypeface();
    }

    public final void h(String str, int i11, int i12) {
        Typeface typeface;
        Typeface typeface2;
        if (str != null) {
            typeface = Typeface.create(str, i12);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        boolean z11 = true;
        if (i11 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i11 == 2) {
            typeface = Typeface.SERIF;
        } else if (i11 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        float f11 = 0.0f;
        if (i12 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i12);
            } else {
                typeface2 = Typeface.create(typeface, i12);
            }
            setTypeface(typeface2);
            int i13 = (~(typeface2 != null ? typeface2.getStyle() : 0)) & i12;
            TextPaint textPaint = this.f7873b;
            if ((i13 & 1) == 0) {
                z11 = false;
            }
            textPaint.setFakeBoldText(z11);
            TextPaint textPaint2 = this.f7873b;
            if ((i13 & 2) != 0) {
                f11 = -0.25f;
            }
            textPaint2.setTextSkewX(f11);
            return;
        }
        this.f7873b.setFakeBoldText(false);
        this.f7873b.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    public final void i(Context context, AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f7873b;
        int i11 = typedValue.data;
        this.f7875d = i11;
        textPaint.setColor(i11);
    }

    public void j() {
        this.f7890s = getPaddingLeft();
        this.f7891t = getPaddingRight();
        this.f7892u = getPaddingTop();
        this.f7893v = getPaddingBottom();
        h(this.f7894w, this.f7885n, this.f7884m);
        this.f7873b.setColor(this.f7875d);
        this.f7873b.setStrokeWidth(this.f7886o);
        this.f7873b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f7873b.setFlags(128);
        setTextSize(this.f7882k);
        this.f7873b.setAntiAlias(true);
    }

    public final void k() {
        if (this.E != null) {
            this.I = new Matrix();
            int intrinsicWidth = this.E.getIntrinsicWidth();
            int intrinsicHeight = this.E.getIntrinsicHeight();
            int i11 = 128;
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.K) ? 128 : (int) this.K;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                if (!Float.isNaN(this.J)) {
                    i11 = (int) this.J;
                }
                intrinsicHeight = i11;
            }
            if (this.O != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.G = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.G);
            this.E.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.E.setFilterBitmap(true);
            this.E.draw(canvas);
            if (this.O != 0) {
                this.G = e(this.G, 4);
            }
            Bitmap bitmap = this.G;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.H = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    public final void l() {
        float f11 = 0.0f;
        float f12 = Float.isNaN(this.S) ? 0.0f : this.S;
        float f13 = Float.isNaN(this.T) ? 0.0f : this.T;
        float f14 = Float.isNaN(this.U) ? 1.0f : this.U;
        if (!Float.isNaN(this.V)) {
            f11 = this.V;
        }
        this.I.reset();
        float width = (float) this.G.getWidth();
        float height = (float) this.G.getHeight();
        float f15 = Float.isNaN(this.K) ? this.C : this.K;
        float f16 = Float.isNaN(this.J) ? this.D : this.J;
        float f17 = f14 * (width * f16 < height * f15 ? f15 / width : f16 / height);
        this.I.postScale(f17, f17);
        float f18 = width * f17;
        float f19 = f15 - f18;
        float f21 = f17 * height;
        float f22 = f16 - f21;
        if (!Float.isNaN(this.J)) {
            f22 = this.J / 2.0f;
        }
        if (!Float.isNaN(this.K)) {
            f19 = this.K / 2.0f;
        }
        this.I.postTranslate((((f12 * f19) + f15) - f18) * 0.5f, (((f13 * f22) + f16) - f21) * 0.5f);
        this.I.postRotate(f11, f15 / 2.0f, f16 / 2.0f);
        this.H.setLocalMatrix(this.I);
    }

    public void layout(int i11, int i12, int i13, int i14) {
        float f11;
        super.layout(i11, i12, i13, i14);
        boolean isNaN = Float.isNaN(this.f7883l);
        if (isNaN) {
            f11 = 1.0f;
        } else {
            f11 = this.f7882k / this.f7883l;
        }
        this.C = (float) (i13 - i11);
        this.D = (float) (i14 - i12);
        if (this.A) {
            if (this.P == null) {
                this.Q = new Paint();
                this.P = new Rect();
                this.Q.set(this.f7873b);
                this.R = this.Q.getTextSize();
            }
            Paint paint = this.Q;
            String str = this.f7887p;
            paint.getTextBounds(str, 0, str.length(), this.P);
            int width = this.P.width();
            int height = (int) (((float) this.P.height()) * 1.3f);
            float f12 = (this.C - ((float) this.f7891t)) - ((float) this.f7890s);
            float f13 = (this.D - ((float) this.f7893v)) - ((float) this.f7892u);
            if (isNaN) {
                float f14 = (float) width;
                float f15 = (float) height;
                if (f14 * f13 > f15 * f12) {
                    this.f7873b.setTextSize((this.R * f12) / f14);
                } else {
                    this.f7873b.setTextSize((this.R * f13) / f15);
                }
            } else {
                float f16 = (float) width;
                float f17 = (float) height;
                f11 = f16 * f13 > f17 * f12 ? f12 / f16 : f13 / f17;
            }
        }
        if (this.f7877f || !isNaN) {
            d((float) i11, (float) i12, (float) i13, (float) i14);
            f(f11);
        }
    }

    public void onDraw(Canvas canvas) {
        float f11 = Float.isNaN(this.f7883l) ? 1.0f : this.f7882k / this.f7883l;
        super.onDraw(canvas);
        if (this.f7877f || f11 != 1.0f) {
            if (this.f7888q) {
                f(f11);
            }
            if (this.F == null) {
                this.F = new Matrix();
            }
            if (this.f7877f) {
                this.N.set(this.f7873b);
                this.F.reset();
                float horizontalOffset = ((float) this.f7890s) + getHorizontalOffset();
                float verticalOffset = ((float) this.f7892u) + getVerticalOffset();
                this.F.postTranslate(horizontalOffset, verticalOffset);
                this.F.preScale(f11, f11);
                this.f7874c.transform(this.F);
                if (this.H != null) {
                    this.f7873b.setFilterBitmap(true);
                    this.f7873b.setShader(this.H);
                } else {
                    this.f7873b.setColor(this.f7875d);
                }
                this.f7873b.setStyle(Paint.Style.FILL);
                this.f7873b.setStrokeWidth(this.f7886o);
                canvas.drawPath(this.f7874c, this.f7873b);
                if (this.H != null) {
                    this.f7873b.setShader((Shader) null);
                }
                this.f7873b.setColor(this.f7876e);
                this.f7873b.setStyle(Paint.Style.STROKE);
                this.f7873b.setStrokeWidth(this.f7886o);
                canvas.drawPath(this.f7874c, this.f7873b);
                this.F.reset();
                this.F.postTranslate(-horizontalOffset, -verticalOffset);
                this.f7874c.transform(this.F);
                this.f7873b.set(this.N);
                return;
            }
            float horizontalOffset2 = ((float) this.f7890s) + getHorizontalOffset();
            float verticalOffset2 = ((float) this.f7892u) + getVerticalOffset();
            this.F.reset();
            this.F.preTranslate(horizontalOffset2, verticalOffset2);
            this.f7874c.transform(this.F);
            this.f7873b.setColor(this.f7875d);
            this.f7873b.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f7873b.setStrokeWidth(this.f7886o);
            canvas.drawPath(this.f7874c, this.f7873b);
            this.F.reset();
            this.F.preTranslate(-horizontalOffset2, -verticalOffset2);
            this.f7874c.transform(this.F);
            return;
        }
        canvas.drawText(this.f7887p, this.B + ((float) this.f7890s) + getHorizontalOffset(), ((float) this.f7892u) + getVerticalOffset(), this.f7873b);
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        this.A = false;
        this.f7890s = getPaddingLeft();
        this.f7891t = getPaddingRight();
        this.f7892u = getPaddingTop();
        this.f7893v = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f7873b;
            String str = this.f7887p;
            textPaint.getTextBounds(str, 0, str.length(), this.f7889r);
            if (mode != 1073741824) {
                size = (int) (((float) this.f7889r.width()) + 0.99999f);
            }
            size += this.f7890s + this.f7891t;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (((float) this.f7873b.getFontMetricsInt((Paint.FontMetricsInt) null)) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f7892u + this.f7893v + fontMetricsInt;
            }
        } else if (this.f7897z != 0) {
            this.A = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i11) {
        if ((i11 & 8388615) == 0) {
            i11 |= 8388611;
        }
        if ((i11 & 112) == 0) {
            i11 |= 48;
        }
        if (i11 != this.f7896y) {
            invalidate();
        }
        this.f7896y = i11;
        int i12 = i11 & 112;
        if (i12 == 48) {
            this.M = -1.0f;
        } else if (i12 != 80) {
            this.M = 0.0f;
        } else {
            this.M = 1.0f;
        }
        int i13 = i11 & 8388615;
        if (i13 != 3) {
            if (i13 != 5) {
                if (i13 != 8388611) {
                    if (i13 != 8388613) {
                        this.L = 0.0f;
                        return;
                    }
                }
            }
            this.L = 1.0f;
            return;
        }
        this.L = -1.0f;
    }

    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7879h = f11;
            float f12 = this.f7878g;
            this.f7878g = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z11 = this.f7879h != f11;
        this.f7879h = f11;
        if (f11 != 0.0f) {
            if (this.f7874c == null) {
                this.f7874c = new Path();
            }
            if (this.f7881j == null) {
                this.f7881j = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f7880i == null) {
                    b bVar = new b();
                    this.f7880i = bVar;
                    setOutlineProvider(bVar);
                }
                setClipToOutline(true);
            }
            this.f7881j.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f7874c.reset();
            Path path = this.f7874c;
            RectF rectF = this.f7881j;
            float f13 = this.f7879h;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z11 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f11) {
        boolean z11 = this.f7878g != f11;
        this.f7878g = f11;
        if (f11 != 0.0f) {
            if (this.f7874c == null) {
                this.f7874c = new Path();
            }
            if (this.f7881j == null) {
                this.f7881j = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f7880i == null) {
                    a aVar = new a();
                    this.f7880i = aVar;
                    setOutlineProvider(aVar);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f7878g) / 2.0f;
            this.f7881j.set(0.0f, 0.0f, (float) width, (float) height);
            this.f7874c.reset();
            this.f7874c.addRoundRect(this.f7881j, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z11 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f11) {
        this.f7883l = f11;
    }

    public void setText(CharSequence charSequence) {
        this.f7887p = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f11) {
        this.S = f11;
        l();
        invalidate();
    }

    public void setTextBackgroundPanY(float f11) {
        this.T = f11;
        l();
        invalidate();
    }

    public void setTextBackgroundRotate(float f11) {
        this.V = f11;
        l();
        invalidate();
    }

    public void setTextBackgroundZoom(float f11) {
        this.U = f11;
        l();
        invalidate();
    }

    public void setTextFillColor(int i11) {
        this.f7875d = i11;
        invalidate();
    }

    public void setTextOutlineColor(int i11) {
        this.f7876e = i11;
        this.f7877f = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f11) {
        this.f7886o = f11;
        this.f7877f = true;
        if (Float.isNaN(f11)) {
            this.f7886o = 1.0f;
            this.f7877f = false;
        }
        invalidate();
    }

    public void setTextPanX(float f11) {
        this.L = f11;
        invalidate();
    }

    public void setTextPanY(float f11) {
        this.M = f11;
        invalidate();
    }

    public void setTextSize(float f11) {
        this.f7882k = f11;
        String str = W;
        Log.v(str, Debug.a() + "  " + f11 + " / " + this.f7883l);
        TextPaint textPaint = this.f7873b;
        if (!Float.isNaN(this.f7883l)) {
            f11 = this.f7883l;
        }
        textPaint.setTextSize(f11);
        f(Float.isNaN(this.f7883l) ? 1.0f : this.f7882k / this.f7883l);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f11) {
        this.J = f11;
        l();
        invalidate();
    }

    public void setTextureWidth(float f11) {
        this.K = f11;
        l();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.f7873b.getTypeface() != typeface) {
            this.f7873b.setTypeface(typeface);
            if (this.f7895x != null) {
                this.f7895x = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        g(context, attributeSet);
    }
}
