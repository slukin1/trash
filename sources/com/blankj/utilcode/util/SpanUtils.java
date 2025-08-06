package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Objects;

public final class SpanUtils {

    /* renamed from: b0  reason: collision with root package name */
    public static final String f63415b0 = System.getProperty("line.separator");
    public String A;
    public Typeface B;
    public Layout.Alignment C;
    public int D;
    public ClickableSpan E;
    public String F;
    public float G;
    public BlurMaskFilter.Blur H;
    public Shader I;
    public float J;
    public float K;
    public float L;
    public int M;
    public Object[] N;
    public Bitmap O;
    public Drawable P;
    public Uri Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public SerializableSpannableStringBuilder V = new SerializableSpannableStringBuilder((w) null);
    public boolean W;
    public int X = -1;
    public final int Y = 0;
    public final int Z = 1;

    /* renamed from: a  reason: collision with root package name */
    public TextView f63416a;

    /* renamed from: a0  reason: collision with root package name */
    public final int f63417a0 = 2;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f63418b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f63419c;

    /* renamed from: d  reason: collision with root package name */
    public int f63420d;

    /* renamed from: e  reason: collision with root package name */
    public int f63421e;

    /* renamed from: f  reason: collision with root package name */
    public int f63422f;

    /* renamed from: g  reason: collision with root package name */
    public int f63423g;

    /* renamed from: h  reason: collision with root package name */
    public int f63424h;

    /* renamed from: i  reason: collision with root package name */
    public int f63425i;

    /* renamed from: j  reason: collision with root package name */
    public int f63426j;

    /* renamed from: k  reason: collision with root package name */
    public int f63427k;

    /* renamed from: l  reason: collision with root package name */
    public int f63428l;

    /* renamed from: m  reason: collision with root package name */
    public int f63429m;

    /* renamed from: n  reason: collision with root package name */
    public int f63430n;

    /* renamed from: o  reason: collision with root package name */
    public int f63431o;

    /* renamed from: p  reason: collision with root package name */
    public int f63432p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f63433q;

    /* renamed from: r  reason: collision with root package name */
    public float f63434r;

    /* renamed from: s  reason: collision with root package name */
    public float f63435s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f63436t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f63437u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f63438v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f63439w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f63440x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f63441y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f63442z;

    @SuppressLint({"ParcelCreator"})
    public static class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface newType;

        public /* synthetic */ CustomTypefaceSpan(Typeface typeface, w wVar) {
            this(typeface);
        }

        private void apply(Paint paint, Typeface typeface) {
            int i11;
            Typeface typeface2 = paint.getTypeface();
            if (typeface2 == null) {
                i11 = 0;
            } else {
                i11 = typeface2.getStyle();
            }
            int i12 = i11 & (~typeface.getStyle());
            if ((i12 & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((i12 & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.getShader();
            paint.setTypeface(typeface);
        }

        public void updateDrawState(TextPaint textPaint) {
            apply(textPaint, this.newType);
        }

        public void updateMeasureState(TextPaint textPaint) {
            apply(textPaint, this.newType);
        }

        private CustomTypefaceSpan(Typeface typeface) {
            super("");
            this.newType = typeface;
        }
    }

    public static class SerializableSpannableStringBuilder extends SpannableStringBuilder implements Serializable {
        private static final long serialVersionUID = 4909567650765875771L;

        private SerializableSpannableStringBuilder() {
        }

        public /* synthetic */ SerializableSpannableStringBuilder(w wVar) {
            this();
        }
    }

    public static class a implements LeadingMarginSpan {

        /* renamed from: b  reason: collision with root package name */
        public final int f63443b;

        /* renamed from: c  reason: collision with root package name */
        public final int f63444c;

        /* renamed from: d  reason: collision with root package name */
        public final int f63445d;

        /* renamed from: e  reason: collision with root package name */
        public Path f63446e;

        public /* synthetic */ a(int i11, int i12, int i13, w wVar) {
            this(i11, i12, i13);
        }

        public void drawLeadingMargin(Canvas canvas, Paint paint, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, int i17, boolean z11, Layout layout) {
            if (((Spanned) charSequence).getSpanStart(this) == i16) {
                Paint.Style style = paint.getStyle();
                int color = paint.getColor();
                paint.setColor(this.f63443b);
                paint.setStyle(Paint.Style.FILL);
                if (canvas.isHardwareAccelerated()) {
                    if (this.f63446e == null) {
                        Path path = new Path();
                        this.f63446e = path;
                        path.addCircle(0.0f, 0.0f, (float) this.f63444c, Path.Direction.CW);
                    }
                    canvas.save();
                    canvas.translate((float) (i11 + (i12 * this.f63444c)), ((float) (i13 + i15)) / 2.0f);
                    canvas.drawPath(this.f63446e, paint);
                    canvas.restore();
                } else {
                    int i18 = this.f63444c;
                    canvas.drawCircle((float) (i11 + (i12 * i18)), ((float) (i13 + i15)) / 2.0f, (float) i18, paint);
                }
                paint.setColor(color);
                paint.setStyle(style);
            }
        }

        public int getLeadingMargin(boolean z11) {
            return (this.f63444c * 2) + this.f63445d;
        }

        public a(int i11, int i12, int i13) {
            this.f63446e = null;
            this.f63443b = i11;
            this.f63444c = i12;
            this.f63445d = i13;
        }
    }

    public static abstract class b extends ReplacementSpan {

        /* renamed from: b  reason: collision with root package name */
        public final int f63447b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Drawable> f63448c;

        public /* synthetic */ b(int i11, w wVar) {
            this(i11);
        }

        public final Drawable a() {
            WeakReference<Drawable> weakReference = this.f63448c;
            Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
            if (drawable != null) {
                return drawable;
            }
            Drawable b11 = b();
            this.f63448c = new WeakReference<>(b11);
            return b11;
        }

        public abstract Drawable b();

        public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
            float f12;
            int height;
            Objects.requireNonNull(canvas, "Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Drawable a11 = a();
            Rect bounds = a11.getBounds();
            canvas.save();
            if (bounds.height() < i15 - i13) {
                int i16 = this.f63447b;
                if (i16 == 3) {
                    f12 = (float) i13;
                } else {
                    if (i16 == 2) {
                        height = ((i15 + i13) - bounds.height()) / 2;
                    } else if (i16 == 1) {
                        f12 = (float) (i14 - bounds.height());
                    } else {
                        height = i15 - bounds.height();
                    }
                    f12 = (float) height;
                }
                canvas.translate(f11, f12);
            } else {
                canvas.translate(f11, (float) i13);
            }
            a11.draw(canvas);
            canvas.restore();
        }

        public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
            int i13;
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Rect bounds = a().getBounds();
            if (fontMetricsInt != null && (i13 = fontMetricsInt.bottom - fontMetricsInt.top) < bounds.height()) {
                int i14 = this.f63447b;
                if (i14 == 3) {
                    fontMetricsInt.top = fontMetricsInt.top;
                    fontMetricsInt.bottom = bounds.height() + fontMetricsInt.top;
                } else if (i14 == 2) {
                    int i15 = i13 / 4;
                    fontMetricsInt.top = ((-bounds.height()) / 2) - i15;
                    fontMetricsInt.bottom = (bounds.height() / 2) - i15;
                } else {
                    int i16 = fontMetricsInt.bottom;
                    fontMetricsInt.top = (-bounds.height()) + i16;
                    fontMetricsInt.bottom = i16;
                }
                fontMetricsInt.ascent = fontMetricsInt.top;
                fontMetricsInt.descent = fontMetricsInt.bottom;
            }
            return bounds.right;
        }

        public b(int i11) {
            this.f63447b = i11;
        }
    }

    public static class c extends b {

        /* renamed from: d  reason: collision with root package name */
        public Drawable f63449d;

        /* renamed from: e  reason: collision with root package name */
        public Uri f63450e;

        /* renamed from: f  reason: collision with root package name */
        public int f63451f;

        public /* synthetic */ c(int i11, int i12, w wVar) {
            this(i11, i12);
        }

        public Drawable b() {
            Drawable drawable;
            Drawable drawable2 = this.f63449d;
            if (drawable2 != null) {
                return drawable2;
            }
            BitmapDrawable bitmapDrawable = null;
            if (this.f63450e != null) {
                try {
                    InputStream openInputStream = Utils.a().getContentResolver().openInputStream(this.f63450e);
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(Utils.a().getResources(), BitmapFactory.decodeStream(openInputStream));
                    try {
                        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
                        if (openInputStream != null) {
                            openInputStream.close();
                        }
                        return bitmapDrawable2;
                    } catch (Exception e11) {
                        e = e11;
                        bitmapDrawable = bitmapDrawable2;
                        Log.e("sms", "Failed to loaded content " + this.f63450e, e);
                        return bitmapDrawable;
                    }
                } catch (Exception e12) {
                    e = e12;
                    Log.e("sms", "Failed to loaded content " + this.f63450e, e);
                    return bitmapDrawable;
                }
            } else {
                try {
                    drawable = ContextCompat.getDrawable(Utils.a(), this.f63451f);
                    try {
                        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        return drawable;
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    drawable = null;
                    Log.e("sms", "Unable to find resource: " + this.f63451f);
                    return drawable;
                }
            }
        }

        public /* synthetic */ c(Bitmap bitmap, int i11, w wVar) {
            this(bitmap, i11);
        }

        public /* synthetic */ c(Drawable drawable, int i11, w wVar) {
            this(drawable, i11);
        }

        public /* synthetic */ c(Uri uri, int i11, w wVar) {
            this(uri, i11);
        }

        public c(Bitmap bitmap, int i11) {
            super(i11, (w) null);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(Utils.a().getResources(), bitmap);
            this.f63449d = bitmapDrawable;
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), this.f63449d.getIntrinsicHeight());
        }

        public c(Drawable drawable, int i11) {
            super(i11, (w) null);
            this.f63449d = drawable;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f63449d.getIntrinsicHeight());
        }

        public c(Uri uri, int i11) {
            super(i11, (w) null);
            this.f63450e = uri;
        }

        public c(int i11, int i12) {
            super(i12, (w) null);
            this.f63451f = i11;
        }
    }

    public static class d implements LineHeightSpan {

        /* renamed from: d  reason: collision with root package name */
        public static Paint.FontMetricsInt f63452d;

        /* renamed from: b  reason: collision with root package name */
        public final int f63453b;

        /* renamed from: c  reason: collision with root package name */
        public final int f63454c;

        public d(int i11, int i12) {
            this.f63453b = i11;
            this.f63454c = i12;
        }

        public void chooseHeight(CharSequence charSequence, int i11, int i12, int i13, int i14, Paint.FontMetricsInt fontMetricsInt) {
            Paint.FontMetricsInt fontMetricsInt2 = f63452d;
            if (fontMetricsInt2 == null) {
                Paint.FontMetricsInt fontMetricsInt3 = new Paint.FontMetricsInt();
                f63452d = fontMetricsInt3;
                fontMetricsInt3.top = fontMetricsInt.top;
                fontMetricsInt3.ascent = fontMetricsInt.ascent;
                fontMetricsInt3.descent = fontMetricsInt.descent;
                fontMetricsInt3.bottom = fontMetricsInt.bottom;
                fontMetricsInt3.leading = fontMetricsInt.leading;
            } else {
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
                fontMetricsInt.leading = fontMetricsInt2.leading;
            }
            int i15 = this.f63453b;
            int i16 = fontMetricsInt.descent;
            int i17 = fontMetricsInt.ascent;
            int i18 = i15 - (((i14 + i16) - i17) - i13);
            if (i18 > 0) {
                int i19 = this.f63454c;
                if (i19 == 3) {
                    fontMetricsInt.descent = i16 + i18;
                } else if (i19 == 2) {
                    int i21 = i18 / 2;
                    fontMetricsInt.descent = i16 + i21;
                    fontMetricsInt.ascent = i17 - i21;
                } else {
                    fontMetricsInt.ascent = i17 - i18;
                }
            }
            int i22 = fontMetricsInt.bottom;
            int i23 = fontMetricsInt.top;
            int i24 = i15 - (((i14 + i22) - i23) - i13);
            if (i24 > 0) {
                int i25 = this.f63454c;
                if (i25 == 3) {
                    fontMetricsInt.bottom = i22 + i24;
                } else if (i25 == 2) {
                    int i26 = i24 / 2;
                    fontMetricsInt.bottom = i22 + i26;
                    fontMetricsInt.top = i23 - i26;
                } else {
                    fontMetricsInt.top = i23 - i24;
                }
            }
            if (i12 == ((Spanned) charSequence).getSpanEnd(this)) {
                f63452d = null;
            }
        }
    }

    public static class e implements LeadingMarginSpan {

        /* renamed from: b  reason: collision with root package name */
        public final int f63455b;

        /* renamed from: c  reason: collision with root package name */
        public final int f63456c;

        /* renamed from: d  reason: collision with root package name */
        public final int f63457d;

        public /* synthetic */ e(int i11, int i12, int i13, w wVar) {
            this(i11, i12, i13);
        }

        public void drawLeadingMargin(Canvas canvas, Paint paint, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, int i17, boolean z11, Layout layout) {
            Paint paint2 = paint;
            int i18 = i11;
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.f63455b);
            canvas.drawRect((float) i18, (float) i13, (float) (i18 + (this.f63456c * i12)), (float) i15, paint);
            paint.setStyle(style);
            paint.setColor(color);
        }

        public int getLeadingMargin(boolean z11) {
            return this.f63456c + this.f63457d;
        }

        public e(int i11, int i12, int i13) {
            this.f63455b = i11;
            this.f63456c = i12;
            this.f63457d = i13;
        }
    }

    public static class f extends CharacterStyle implements UpdateAppearance {

        /* renamed from: b  reason: collision with root package name */
        public Shader f63458b;

        public /* synthetic */ f(Shader shader, w wVar) {
            this(shader);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShader(this.f63458b);
        }

        public f(Shader shader) {
            this.f63458b = shader;
        }
    }

    public static class g extends CharacterStyle implements UpdateAppearance {

        /* renamed from: b  reason: collision with root package name */
        public float f63459b;

        /* renamed from: c  reason: collision with root package name */
        public float f63460c;

        /* renamed from: d  reason: collision with root package name */
        public float f63461d;

        /* renamed from: e  reason: collision with root package name */
        public int f63462e;

        public /* synthetic */ g(float f11, float f12, float f13, int i11, w wVar) {
            this(f11, f12, f13, i11);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShadowLayer(this.f63459b, this.f63460c, this.f63461d, this.f63462e);
        }

        public g(float f11, float f12, float f13, int i11) {
            this.f63459b = f11;
            this.f63460c = f12;
            this.f63461d = f13;
            this.f63462e = i11;
        }
    }

    public static class h extends ReplacementSpan {

        /* renamed from: b  reason: collision with root package name */
        public final int f63463b;

        /* renamed from: c  reason: collision with root package name */
        public final Paint f63464c;

        public /* synthetic */ h(int i11, int i12, w wVar) {
            this(i11, i12);
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
            Objects.requireNonNull(canvas, "Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            canvas.drawRect(f11, (float) i13, f11 + ((float) this.f63463b), (float) i15, this.f63464c);
        }

        public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            return this.f63463b;
        }

        public h(int i11, int i12) {
            Paint paint = new Paint();
            this.f63464c = paint;
            this.f63463b = i11;
            paint.setColor(i12);
            paint.setStyle(Paint.Style.FILL);
        }
    }

    public static class i extends ReplacementSpan {

        /* renamed from: b  reason: collision with root package name */
        public final int f63465b;

        public i(int i11) {
            this.f63465b = i11;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
            Objects.requireNonNull(canvas, "Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            CharSequence subSequence = charSequence.subSequence(i11, i12);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.drawText(subSequence.toString(), f11, (float) (i14 - (((((fontMetricsInt.descent + i14) + i14) + fontMetricsInt.ascent) / 2) - ((i15 + i13) / 2))), paint);
        }

        public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            return (int) paint.measureText(charSequence.subSequence(i11, i12).toString());
        }
    }

    public SpanUtils() {
        f();
    }

    public SpanUtils a(CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "Argument 'text' of type CharSequence (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        b(0);
        this.f63418b = charSequence;
        return this;
    }

    public final void b(int i11) {
        c();
        this.X = i11;
    }

    public final void c() {
        if (!this.W) {
            int i11 = this.X;
            if (i11 == 0) {
                h();
            } else if (i11 == 1) {
                i();
            } else if (i11 == 2) {
                j();
            }
            f();
        }
    }

    public SpannableStringBuilder d() {
        c();
        TextView textView = this.f63416a;
        if (textView != null) {
            textView.setText(this.V);
        }
        this.W = true;
        return this.V;
    }

    public SpanUtils e() {
        this.f63440x = true;
        return this;
    }

    public final void f() {
        this.f63419c = 33;
        this.f63420d = -16777217;
        this.f63421e = -16777217;
        this.f63422f = -1;
        this.f63424h = -16777217;
        this.f63427k = -1;
        this.f63429m = -16777217;
        this.f63432p = -1;
        this.f63434r = -1.0f;
        this.f63435s = -1.0f;
        this.f63436t = false;
        this.f63437u = false;
        this.f63438v = false;
        this.f63439w = false;
        this.f63440x = false;
        this.f63441y = false;
        this.f63442z = false;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = -1;
        this.E = null;
        this.F = null;
        this.G = -1.0f;
        this.I = null;
        this.J = -1.0f;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.T = -1;
    }

    public SpanUtils g(int i11) {
        this.f63420d = i11;
        return this;
    }

    public final void h() {
        if (this.f63418b.length() != 0) {
            int length = this.V.length();
            if (length == 0 && this.f63422f != -1) {
                this.V.append(Character.toString(2)).append("\n").setSpan(new AbsoluteSizeSpan(0), 0, 2, 33);
                length = 2;
            }
            this.V.append(this.f63418b);
            int length2 = this.V.length();
            if (this.D != -1) {
                this.V.setSpan(new i(this.D), length, length2, this.f63419c);
            }
            if (this.f63420d != -16777217) {
                this.V.setSpan(new ForegroundColorSpan(this.f63420d), length, length2, this.f63419c);
            }
            if (this.f63421e != -16777217) {
                this.V.setSpan(new BackgroundColorSpan(this.f63421e), length, length2, this.f63419c);
            }
            if (this.f63427k != -1) {
                this.V.setSpan(new LeadingMarginSpan.Standard(this.f63427k, this.f63428l), length, length2, this.f63419c);
            }
            int i11 = this.f63424h;
            if (i11 != -16777217) {
                this.V.setSpan(new e(i11, this.f63425i, this.f63426j, (w) null), length, length2, this.f63419c);
            }
            int i12 = this.f63429m;
            if (i12 != -16777217) {
                this.V.setSpan(new a(i12, this.f63430n, this.f63431o, (w) null), length, length2, this.f63419c);
            }
            if (this.f63432p != -1) {
                this.V.setSpan(new AbsoluteSizeSpan(this.f63432p, this.f63433q), length, length2, this.f63419c);
            }
            if (this.f63434r != -1.0f) {
                this.V.setSpan(new RelativeSizeSpan(this.f63434r), length, length2, this.f63419c);
            }
            if (this.f63435s != -1.0f) {
                this.V.setSpan(new ScaleXSpan(this.f63435s), length, length2, this.f63419c);
            }
            int i13 = this.f63422f;
            if (i13 != -1) {
                this.V.setSpan(new d(i13, this.f63423g), length, length2, this.f63419c);
            }
            if (this.f63436t) {
                this.V.setSpan(new StrikethroughSpan(), length, length2, this.f63419c);
            }
            if (this.f63437u) {
                this.V.setSpan(new UnderlineSpan(), length, length2, this.f63419c);
            }
            if (this.f63438v) {
                this.V.setSpan(new SuperscriptSpan(), length, length2, this.f63419c);
            }
            if (this.f63439w) {
                this.V.setSpan(new SubscriptSpan(), length, length2, this.f63419c);
            }
            if (this.f63440x) {
                this.V.setSpan(new StyleSpan(1), length, length2, this.f63419c);
            }
            if (this.f63441y) {
                this.V.setSpan(new StyleSpan(2), length, length2, this.f63419c);
            }
            if (this.f63442z) {
                this.V.setSpan(new StyleSpan(3), length, length2, this.f63419c);
            }
            if (this.A != null) {
                this.V.setSpan(new TypefaceSpan(this.A), length, length2, this.f63419c);
            }
            if (this.B != null) {
                this.V.setSpan(new CustomTypefaceSpan(this.B, (w) null), length, length2, this.f63419c);
            }
            if (this.C != null) {
                this.V.setSpan(new AlignmentSpan.Standard(this.C), length, length2, this.f63419c);
            }
            ClickableSpan clickableSpan = this.E;
            if (clickableSpan != null) {
                this.V.setSpan(clickableSpan, length, length2, this.f63419c);
            }
            if (this.F != null) {
                this.V.setSpan(new URLSpan(this.F), length, length2, this.f63419c);
            }
            if (this.G != -1.0f) {
                this.V.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.G, this.H)), length, length2, this.f63419c);
            }
            if (this.I != null) {
                this.V.setSpan(new f(this.I, (w) null), length, length2, this.f63419c);
            }
            if (this.J != -1.0f) {
                this.V.setSpan(new g(this.J, this.K, this.L, this.M, (w) null), length, length2, this.f63419c);
            }
            Object[] objArr = this.N;
            if (objArr != null) {
                for (Object span : objArr) {
                    this.V.setSpan(span, length, length2, this.f63419c);
                }
            }
        }
    }

    public final void i() {
        int length = this.V.length();
        this.f63418b = "<img>";
        h();
        int length2 = this.V.length();
        if (this.O != null) {
            this.V.setSpan(new c(this.O, this.S, (w) null), length, length2, this.f63419c);
        } else if (this.P != null) {
            this.V.setSpan(new c(this.P, this.S, (w) null), length, length2, this.f63419c);
        } else if (this.Q != null) {
            this.V.setSpan(new c(this.Q, this.S, (w) null), length, length2, this.f63419c);
        } else if (this.R != -1) {
            this.V.setSpan(new c(this.R, this.S, (w) null), length, length2, this.f63419c);
        }
    }

    public final void j() {
        int length = this.V.length();
        this.f63418b = "< >";
        h();
        this.V.setSpan(new h(this.T, this.U, (w) null), length, this.V.length(), this.f63419c);
    }
}
