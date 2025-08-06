package com.hbg.module.libkt.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.hbg.lib.widgets.R$string;
import com.hbg.lib.widgets.R$styleable;
import com.hbg.module.libkt.base.ext.c;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import ke.g;
import kotlin.jvm.internal.r;

public final class HexagonalRatingView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final double[] f24673b;

    /* renamed from: c  reason: collision with root package name */
    public final Point[][] f24674c;

    /* renamed from: d  reason: collision with root package name */
    public final Point[] f24675d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24676e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f24677f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f24678g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f24679h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f24680i;

    /* renamed from: j  reason: collision with root package name */
    public final Paint f24681j;

    /* renamed from: k  reason: collision with root package name */
    public final TextPaint f24682k;

    /* renamed from: l  reason: collision with root package name */
    public final Paint f24683l;

    /* renamed from: m  reason: collision with root package name */
    public final DashPathEffect f24684m;

    /* renamed from: n  reason: collision with root package name */
    public int f24685n;

    /* renamed from: o  reason: collision with root package name */
    public final double f24686o;

    /* renamed from: p  reason: collision with root package name */
    public final String[] f24687p;

    /* renamed from: q  reason: collision with root package name */
    public float f24688q;

    /* renamed from: r  reason: collision with root package name */
    public float f24689r;

    /* renamed from: s  reason: collision with root package name */
    public int f24690s;

    /* renamed from: t  reason: collision with root package name */
    public int f24691t;

    /* renamed from: u  reason: collision with root package name */
    public final Float[][] f24692u;

    /* renamed from: v  reason: collision with root package name */
    public g f24693v;

    public HexagonalRatingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HexagonalRatingView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void a(Canvas canvas) {
        Canvas canvas2 = canvas;
        int measuredWidth = getMeasuredWidth() / 2;
        int measuredHeight = getMeasuredHeight() / 2;
        for (int i11 = 0; i11 < 6; i11++) {
            double d11 = (this.f24686o / ((double) 6)) * ((double) ((i11 * 2) + 1));
            double d12 = (double) 100;
            this.f24675d[i11].y = measuredHeight - ((int) (Math.sin(d11) * (((double) ((this.f24685n * 5) / 6)) * (this.f24673b[i11] / d12))));
            this.f24675d[i11].x = measuredWidth - ((int) (Math.cos(d11) * (((double) ((this.f24685n * 5) / 6)) * (this.f24673b[i11] / d12))));
        }
        Path path = new Path();
        Point[] pointArr = this.f24675d;
        path.moveTo((float) pointArr[0].x, (float) pointArr[0].y);
        Point[] pointArr2 = this.f24675d;
        path.lineTo((float) pointArr2[1].x, (float) pointArr2[1].y);
        Point[] pointArr3 = this.f24675d;
        path.lineTo((float) pointArr3[2].x, (float) pointArr3[2].y);
        Point[] pointArr4 = this.f24675d;
        path.lineTo((float) pointArr4[3].x, (float) pointArr4[3].y);
        Point[] pointArr5 = this.f24675d;
        path.lineTo((float) pointArr5[4].x, (float) pointArr5[4].y);
        Point[] pointArr6 = this.f24675d;
        path.lineTo((float) pointArr6[5].x, (float) pointArr6[5].y);
        path.close();
        this.f24680i.setAlpha(19);
        if (canvas2 != null) {
            canvas2.drawPath(path, this.f24680i);
        }
        if (canvas2 != null) {
            canvas2.drawPath(path, this.f24681j);
        }
        Point[] pointArr7 = this.f24675d;
        e(canvas2, (float) pointArr7[0].x, (float) pointArr7[0].y);
        Point[] pointArr8 = this.f24675d;
        e(canvas2, (float) pointArr8[1].x, (float) pointArr8[1].y);
        Point[] pointArr9 = this.f24675d;
        e(canvas2, (float) pointArr9[2].x, (float) pointArr9[2].y);
        Point[] pointArr10 = this.f24675d;
        e(canvas2, (float) pointArr10[3].x, (float) pointArr10[3].y);
        Point[] pointArr11 = this.f24675d;
        e(canvas2, (float) pointArr11[4].x, (float) pointArr11[4].y);
        Point[] pointArr12 = this.f24675d;
        e(canvas2, (float) pointArr12[5].x, (float) pointArr12[5].y);
    }

    public final void b(Canvas canvas) {
        if (this.f24674c[0][0] != null) {
            for (int i11 = 1; i11 < 6; i11++) {
                Path path = new Path();
                path.moveTo((float) this.f24674c[i11][0].x, (float) this.f24674c[i11][0].y);
                path.lineTo((float) this.f24674c[i11][1].x, (float) this.f24674c[i11][1].y);
                path.lineTo((float) this.f24674c[i11][2].x, (float) this.f24674c[i11][2].y);
                path.lineTo((float) this.f24674c[i11][3].x, (float) this.f24674c[i11][3].y);
                path.lineTo((float) this.f24674c[i11][4].x, (float) this.f24674c[i11][4].y);
                path.lineTo((float) this.f24674c[i11][5].x, (float) this.f24674c[i11][5].y);
                path.close();
                if (canvas != null) {
                    canvas.drawPath(path, i11 % 2 == 0 ? this.f24678g : this.f24679h);
                }
            }
        }
    }

    public final void c(Canvas canvas) {
        int i11;
        float f11;
        float f12;
        Canvas canvas2 = canvas;
        int i12 = 1;
        if (this.f24674c[1][0] != null) {
            int width = getWidth() / 2;
            int height = getHeight() / 2;
            int i13 = 0;
            while (true) {
                i11 = 6;
                if (i13 >= 6) {
                    break;
                }
                if (canvas2 != null) {
                    canvas.drawLine((float) width, (float) height, ((float) this.f24674c[1][i13].x) - (((float) (this.f24674c[1][i13].x - width)) / 35.0f), ((float) this.f24674c[1][i13].y) - (((float) (this.f24674c[1][i13].y - height)) / 35.0f), this.f24677f);
                }
                i13++;
            }
            float e11 = c.e(Float.valueOf(4.0f));
            double d11 = (double) 2;
            float sqrt = (float) ((Math.sqrt(3.0d) / d11) * ((double) c.e(Float.valueOf(8.0f))));
            float e12 = c.e(Float.valueOf(2.0f));
            float sqrt2 = (float) ((Math.sqrt(3.0d) / d11) * ((double) c.e(Float.valueOf(4.0f))));
            int i14 = 1;
            while (i14 < i11) {
                if (i14 == i12) {
                    f12 = e11;
                    f11 = sqrt;
                } else {
                    f11 = sqrt2;
                    f12 = e12;
                }
                Path path = new Path();
                float f13 = ((float) 2) * f12;
                path.moveTo((float) this.f24674c[i14][0].x, ((float) this.f24674c[i14][0].y) + f13);
                path.quadTo((float) this.f24674c[i14][0].x, (float) this.f24674c[i14][0].y, ((float) this.f24674c[i14][0].x) + f11, ((float) this.f24674c[i14][0].y) - f12);
                path.lineTo(((float) this.f24674c[i14][1].x) - f11, ((float) this.f24674c[i14][1].y) + f12);
                path.quadTo((float) this.f24674c[i14][1].x, (float) this.f24674c[i14][1].y, ((float) this.f24674c[i14][1].x) + f11, ((float) this.f24674c[i14][1].y) + f12);
                path.lineTo(((float) this.f24674c[i14][2].x) - f11, ((float) this.f24674c[i14][2].y) - f12);
                path.quadTo((float) this.f24674c[i14][2].x, (float) this.f24674c[i14][2].y, (float) this.f24674c[i14][2].x, ((float) this.f24674c[i14][2].y) + f13);
                path.lineTo((float) this.f24674c[i14][3].x, ((float) this.f24674c[i14][3].y) - f13);
                path.quadTo((float) this.f24674c[i14][3].x, (float) this.f24674c[i14][3].y, ((float) this.f24674c[i14][3].x) - f11, ((float) this.f24674c[i14][3].y) + f12);
                path.lineTo(((float) this.f24674c[i14][4].x) + f11, ((float) this.f24674c[i14][4].y) - f12);
                path.quadTo((float) this.f24674c[i14][4].x, (float) this.f24674c[i14][4].y, ((float) this.f24674c[i14][4].x) - f11, ((float) this.f24674c[i14][4].y) - f12);
                path.lineTo(((float) this.f24674c[i14][5].x) + f11, ((float) this.f24674c[i14][5].y) + f12);
                path.quadTo((float) this.f24674c[i14][5].x, (float) this.f24674c[i14][5].y, (float) this.f24674c[i14][5].x, ((float) this.f24674c[i14][5].y) - f13);
                path.close();
                canvas2.drawPath(path, this.f24677f);
                i14++;
                i11 = 6;
                i12 = 1;
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.f24674c[0][0] != null) {
            for (int i11 = 0; i11 < 6; i11++) {
                f(i11, canvas);
            }
        }
    }

    public final void e(Canvas canvas, float f11, float f12) {
        if (canvas != null) {
            canvas.drawCircle(f11, f12, 8.0f, this.f24681j);
        }
        if (canvas != null) {
            canvas.drawCircle(f11, f12, 7.0f, this.f24679h);
        }
    }

    public final void f(int i11, Canvas canvas) {
        int i12;
        int i13;
        int i14;
        float f11;
        int i15;
        int i16;
        float f12;
        boolean z11;
        int i17 = i11;
        Canvas canvas2 = canvas;
        this.f24682k.setColor(this.f24690s);
        this.f24682k.setTextSize(this.f24688q);
        Paint.FontMetrics fontMetrics = this.f24682k.getFontMetrics();
        String str = this.f24687p[i17];
        String i18 = i(this.f24673b[i17]);
        float f13 = (float) this.f24674c[0][i17].x;
        if (i17 == 0 || i17 == 5) {
            i12 = c.d(Float.valueOf(-15.0f));
        } else if (i17 == 2 || i17 == 3) {
            i12 = c.d(Float.valueOf(15.0f));
        } else {
            i12 = 0;
        }
        float f14 = f13 + ((float) i12);
        float f15 = (float) this.f24674c[0][i17].y;
        boolean z12 = true;
        if (i17 == 1 || i17 == 4) {
            i13 = c.d(Float.valueOf(140.0f));
        } else {
            i13 = c.d(Float.valueOf(80.0f));
        }
        StaticLayout build = StaticLayout.Builder.obtain(str, 0, str.length(), this.f24682k, i13).setAlignment(Layout.Alignment.ALIGN_CENTER).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build();
        if (i17 == 4) {
            f11 = f15 - ((float) c.d(Float.valueOf(10.0f)));
        } else {
            float lineCount = f15 - ((fontMetrics.descent - fontMetrics.ascent) * ((float) build.getLineCount()));
            if (i17 != 0) {
                if (i17 == 1) {
                    i14 = c.d(Float.valueOf(-10.0f));
                } else if (i17 != 2) {
                    i14 = c.d(Float.valueOf(25.0f));
                }
                f11 = lineCount + ((float) i14);
            }
            i14 = c.d(Float.valueOf(-20.0f));
            f11 = lineCount + ((float) i14);
        }
        float f16 = f11;
        if (canvas2 != null) {
            canvas.save();
        }
        if (canvas2 != null) {
            canvas2.translate(f14 - (((float) build.getWidth()) / 2.0f), f16);
        }
        build.draw(canvas2);
        if (canvas2 != null) {
            canvas.restore();
        }
        float f17 = fontMetrics.descent - fontMetrics.ascent;
        int lineCount2 = build.getLineCount();
        int i19 = 0;
        while (i19 < lineCount2) {
            float f18 = (((float) i19) * f17) + f16;
            float measureText = this.f24682k.measureText(str.substring(build.getLineStart(i19), build.getLineEnd(i19)));
            if (canvas2 != null) {
                float f19 = measureText / 2.0f;
                float f21 = f18 + f17;
                i16 = i19;
                i15 = lineCount2;
                f12 = f16;
                z11 = true;
                canvas.drawLine(f14 - f19, f21, f14 + f19, f21, this.f24683l);
            } else {
                i16 = i19;
                i15 = lineCount2;
                f12 = f16;
                z11 = true;
            }
            i19 = i16 + 1;
            z12 = z11;
            f16 = f12;
            lineCount2 = i15;
        }
        float f22 = f16;
        char c11 = z12;
        this.f24682k.setColor(this.f24691t);
        this.f24682k.setTextSize(this.f24689r);
        float measureText2 = this.f24682k.measureText(i18);
        if (canvas2 != null) {
            canvas2.drawText(i18, f14 - (measureText2 / ((float) 2)), f22 + (((float) build.getLineCount()) * f17) + c.e(Float.valueOf(15.0f)), this.f24682k);
        }
        this.f24692u[i17][0] = Float.valueOf(f14 - (((float) build.getWidth()) / 2.0f));
        this.f24692u[i17][c11] = Float.valueOf(f14 + (((float) build.getWidth()) / 2.0f));
        this.f24692u[i17][2] = Float.valueOf(f22);
        this.f24692u[i17][3] = Float.valueOf(f22 + (f17 * ((float) build.getLineCount())) + c.e(Float.valueOf(25.0f)));
    }

    public final String g(int i11) {
        return getContext().getResources().getString(i11);
    }

    public final void h(int i11, int i12) {
        int i13 = i11 / 2;
        int i14 = i12 / 2;
        Paint.FontMetrics fontMetrics = this.f24682k.getFontMetrics();
        int ceil = (int) (((float) ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent)))) + c.e(Float.valueOf(40.0f)));
        this.f24685n = (i13 < i14 ? i13 - ceil : i14 - ceil) - 5;
        for (int i15 = 0; i15 < 6; i15++) {
            int i16 = (this.f24685n / 6) * i15;
            for (int i17 = 0; i17 < 6; i17++) {
                this.f24674c[i15][i17] = new Point();
                double d11 = (this.f24686o / ((double) 6)) * ((double) ((i17 * 2) + 1));
                this.f24674c[i15][i17].y = i14 - ((int) (Math.sin(d11) * ((double) (this.f24685n - i16))));
                this.f24674c[i15][i17].x = i13 - ((int) (Math.cos(d11) * ((double) (this.f24685n - i16))));
            }
        }
    }

    public final String i(double d11) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(d11);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        d(canvas);
        c(canvas);
        a(canvas);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f11 = 0.0f;
        float x11 = motionEvent != null ? motionEvent.getX() : 0.0f;
        if (motionEvent != null) {
            f11 = motionEvent.getY();
        }
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            Float[][] fArr = this.f24692u;
            int length = fArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                Float[] fArr2 = fArr[i11];
                if (fArr2[0].floatValue() > x11 || fArr2[1].floatValue() < x11 || fArr2[2].floatValue() > f11 || fArr2[3].floatValue() < f11) {
                    i11++;
                } else {
                    g gVar = this.f24693v;
                    if (gVar != null) {
                        gVar.a(i11);
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setData(double... dArr) {
        try {
            double[] dArr2 = this.f24673b;
            dArr2[0] = dArr[0];
            dArr2[1] = dArr[1];
            dArr2[2] = dArr[2];
            dArr2[3] = dArr[3];
            dArr2[4] = dArr[4];
            dArr2[5] = dArr[5];
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        invalidate();
    }

    public final void setOnTextClickListener(g gVar) {
        this.f24693v = gVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HexagonalRatingView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f24673b = new double[6];
        Point[][] pointArr = new Point[6][];
        for (int i12 = 0; i12 < 6; i12++) {
            pointArr[i12] = new Point[6];
        }
        this.f24674c = pointArr;
        Point[] pointArr2 = new Point[6];
        for (int i13 = 0; i13 < 6; i13++) {
            pointArr2[i13] = new Point();
        }
        this.f24675d = pointArr2;
        this.f24676e = Color.rgb(51, 205, 207);
        this.f24677f = new Paint();
        this.f24678g = new Paint();
        this.f24679h = new Paint();
        this.f24680i = new Paint();
        this.f24681j = new Paint();
        this.f24682k = new TextPaint();
        this.f24683l = new Paint();
        this.f24684m = new DashPathEffect(new float[]{c.e(Float.valueOf(3.0f)), c.e(Float.valueOf(3.0f))}, 0.0f);
        this.f24685n = 250;
        this.f24686o = 3.1415926d;
        this.f24688q = c.e(Float.valueOf(12.0f));
        this.f24689r = c.e(Float.valueOf(14.0f));
        Float[][] fArr = new Float[6][];
        for (int i14 = 0; i14 < 6; i14++) {
            Float[] fArr2 = new Float[4];
            for (int i15 = 0; i15 < 4; i15++) {
                fArr2[i15] = Float.valueOf(0.0f);
            }
            fArr[i14] = fArr2;
        }
        this.f24692u = fArr;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HexagonalRatingView);
        this.f24677f.setAntiAlias(true);
        this.f24677f.setStyle(Paint.Style.STROKE);
        this.f24677f.setColor(this.f24676e);
        this.f24678g.setStyle(Paint.Style.FILL);
        this.f24678g.setAntiAlias(true);
        this.f24679h.setStyle(Paint.Style.FILL);
        this.f24679h.setAntiAlias(true);
        this.f24680i.setStyle(Paint.Style.FILL);
        this.f24680i.setAntiAlias(true);
        this.f24681j.setStyle(Paint.Style.STROKE);
        this.f24681j.setAntiAlias(true);
        this.f24681j.setStrokeWidth(c.e(Float.valueOf(1.0f)));
        this.f24682k.setAntiAlias(true);
        this.f24683l.setStyle(Paint.Style.STROKE);
        this.f24683l.setPathEffect(this.f24684m);
        this.f24683l.setStrokeWidth(c.e(Float.valueOf(1.0f)));
        this.f24688q = obtainStyledAttributes.getDimension(R$styleable.HexagonalRatingView_hexagonal_TitleSize, this.f24688q);
        this.f24689r = obtainStyledAttributes.getDimension(R$styleable.HexagonalRatingView_hexagonal_ScoreSize, this.f24689r);
        this.f24690s = obtainStyledAttributes.getColor(R$styleable.HexagonalRatingView_hexagonal_TitleColor, Color.rgb(152, 160, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION));
        this.f24691t = obtainStyledAttributes.getColor(R$styleable.HexagonalRatingView_hexagonal_ScoreColor, Color.rgb(28, 28, 30));
        this.f24677f.setColor(obtainStyledAttributes.getColor(R$styleable.HexagonalRatingView_hexagonal_edgecolor, this.f24676e));
        this.f24678g.setColor(obtainStyledAttributes.getColor(R$styleable.HexagonalRatingView_hexagonal_fillcolor_one, Color.rgb(51, 205, 207)));
        this.f24679h.setColor(obtainStyledAttributes.getColor(R$styleable.HexagonalRatingView_hexagonal_fillcolor_two, Color.rgb(51, 205, 207)));
        Paint paint = this.f24680i;
        int i16 = R$styleable.HexagonalRatingView_hexagonal_secondfillcolor;
        paint.setColor(obtainStyledAttributes.getColor(i16, Color.rgb(255, 126, 39)));
        this.f24681j.setColor(obtainStyledAttributes.getColor(i16, Color.rgb(255, 126, 39)));
        this.f24683l.setColor(obtainStyledAttributes.getColor(R$styleable.HexagonalRatingView_hexagonal_dash_color, Color.rgb(230, 231, 232)));
        this.f24687p = new String[]{g(R$string.n_kline_title_rating_code), g(R$string.n_kline_title_rating_base), g(R$string.n_kline_title_rating_stability), g(R$string.n_kline_title_rating_govern), g(R$string.n_kline_title_rating_elasticity), g(R$string.n_kline_title_rating_community)};
        obtainStyledAttributes.recycle();
    }
}
