package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;

public class ImageFilterView extends AppCompatImageView {

    /* renamed from: b  reason: collision with root package name */
    public c f7830b = new c();

    /* renamed from: c  reason: collision with root package name */
    public boolean f7831c = true;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f7832d = null;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f7833e = null;

    /* renamed from: f  reason: collision with root package name */
    public float f7834f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f7835g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f7836h = Float.NaN;

    /* renamed from: i  reason: collision with root package name */
    public Path f7837i;

    /* renamed from: j  reason: collision with root package name */
    public ViewOutlineProvider f7838j;

    /* renamed from: k  reason: collision with root package name */
    public RectF f7839k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable[] f7840l = new Drawable[2];

    /* renamed from: m  reason: collision with root package name */
    public LayerDrawable f7841m;

    /* renamed from: n  reason: collision with root package name */
    public float f7842n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f7843o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    public float f7844p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    public float f7845q = Float.NaN;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public void getOutline(View view, Outline outline) {
            int width = ImageFilterView.this.getWidth();
            int height = ImageFilterView.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterView.this.f7835g) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f7836h);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public float[] f7848a = new float[20];

        /* renamed from: b  reason: collision with root package name */
        public ColorMatrix f7849b = new ColorMatrix();

        /* renamed from: c  reason: collision with root package name */
        public ColorMatrix f7850c = new ColorMatrix();

        /* renamed from: d  reason: collision with root package name */
        public float f7851d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f7852e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f7853f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f7854g = 1.0f;

        public final void a(float f11) {
            float[] fArr = this.f7848a;
            fArr[0] = f11;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f11;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f11;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public final void b(float f11) {
            float f12 = 1.0f - f11;
            float f13 = 0.2999f * f12;
            float f14 = 0.587f * f12;
            float f15 = f12 * 0.114f;
            float[] fArr = this.f7848a;
            fArr[0] = f13 + f11;
            fArr[1] = f14;
            fArr[2] = f15;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f13;
            fArr[6] = f14 + f11;
            fArr[7] = f15;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f13;
            fArr[11] = f14;
            fArr[12] = f15 + f11;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public void c(ImageView imageView) {
            boolean z11;
            this.f7849b.reset();
            float f11 = this.f7852e;
            boolean z12 = true;
            if (f11 != 1.0f) {
                b(f11);
                this.f7849b.set(this.f7848a);
                z11 = true;
            } else {
                z11 = false;
            }
            float f12 = this.f7853f;
            if (f12 != 1.0f) {
                this.f7850c.setScale(f12, f12, f12, 1.0f);
                this.f7849b.postConcat(this.f7850c);
                z11 = true;
            }
            float f13 = this.f7854g;
            if (f13 != 1.0f) {
                d(f13);
                this.f7850c.set(this.f7848a);
                this.f7849b.postConcat(this.f7850c);
                z11 = true;
            }
            float f14 = this.f7851d;
            if (f14 != 1.0f) {
                a(f14);
                this.f7850c.set(this.f7848a);
                this.f7849b.postConcat(this.f7850c);
            } else {
                z12 = z11;
            }
            if (z12) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f7849b));
            } else {
                imageView.clearColorFilter();
            }
        }

        public final void d(float f11) {
            float f12;
            float f13;
            if (f11 <= 0.0f) {
                f11 = 0.01f;
            }
            float f14 = (5000.0f / f11) / 100.0f;
            if (f14 > 66.0f) {
                double d11 = (double) (f14 - 60.0f);
                f13 = ((float) Math.pow(d11, -0.13320475816726685d)) * 329.69873f;
                f12 = ((float) Math.pow(d11, 0.07551484555006027d)) * 288.12216f;
            } else {
                f12 = (((float) Math.log((double) f14)) * 99.4708f) - 161.11957f;
                f13 = 255.0f;
            }
            float log = f14 < 66.0f ? f14 > 19.0f ? (((float) Math.log((double) (f14 - 10.0f))) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f13, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f12, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log((double) 50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log((double) 40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.f7848a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void setOverlay(boolean z11) {
        this.f7831c = z11;
    }

    public void draw(Canvas canvas) {
        boolean z11;
        if (Build.VERSION.SDK_INT >= 21 || this.f7835g == 0.0f || this.f7837i == null) {
            z11 = false;
        } else {
            z11 = true;
            canvas.save();
            canvas.clipPath(this.f7837i);
        }
        super.draw(canvas);
        if (z11) {
            canvas.restore();
        }
    }

    public final void e() {
        if (!Float.isNaN(this.f7842n) || !Float.isNaN(this.f7843o) || !Float.isNaN(this.f7844p) || !Float.isNaN(this.f7845q)) {
            float f11 = 0.0f;
            float f12 = Float.isNaN(this.f7842n) ? 0.0f : this.f7842n;
            float f13 = Float.isNaN(this.f7843o) ? 0.0f : this.f7843o;
            float f14 = Float.isNaN(this.f7844p) ? 1.0f : this.f7844p;
            if (!Float.isNaN(this.f7845q)) {
                f11 = this.f7845q;
            }
            Matrix matrix = new Matrix();
            matrix.reset();
            float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
            float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
            float width = (float) getWidth();
            float height = (float) getHeight();
            float f15 = f14 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
            matrix.postScale(f15, f15);
            float f16 = intrinsicWidth * f15;
            float f17 = f15 * intrinsicHeight;
            matrix.postTranslate((((f12 * (width - f16)) + width) - f16) * 0.5f, (((f13 * (height - f17)) + height) - f17) * 0.5f);
            matrix.postRotate(f11, width / 2.0f, height / 2.0f);
            setImageMatrix(matrix);
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public final void f() {
        if (!Float.isNaN(this.f7842n) || !Float.isNaN(this.f7843o) || !Float.isNaN(this.f7844p) || !Float.isNaN(this.f7845q)) {
            e();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public float getBrightness() {
        return this.f7830b.f7851d;
    }

    public float getContrast() {
        return this.f7830b.f7853f;
    }

    public float getCrossfade() {
        return this.f7834f;
    }

    public float getImagePanX() {
        return this.f7842n;
    }

    public float getImagePanY() {
        return this.f7843o;
    }

    public float getImageRotate() {
        return this.f7845q;
    }

    public float getImageZoom() {
        return this.f7844p;
    }

    public float getRound() {
        return this.f7836h;
    }

    public float getRoundPercent() {
        return this.f7835g;
    }

    public float getSaturation() {
        return this.f7830b.f7852e;
    }

    public float getWarmth() {
        return this.f7830b.f7854g;
    }

    public final void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f7832d = obtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.f7834f = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f7831c));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f7842n));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f7843o));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f7845q));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f7844p));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f7833e = drawable;
            if (this.f7832d == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f7833e = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f7840l;
                    Drawable mutate = drawable2.mutate();
                    this.f7833e = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f7840l;
            Drawable mutate2 = getDrawable().mutate();
            this.f7833e = mutate2;
            drawableArr2[0] = mutate2;
            this.f7840l[1] = this.f7832d.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f7840l);
            this.f7841m = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f7834f * 255.0f));
            if (!this.f7831c) {
                this.f7841m.getDrawable(0).setAlpha((int) ((1.0f - this.f7834f) * 255.0f));
            }
            super.setImageDrawable(this.f7841m);
        }
    }

    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        e();
    }

    public void setAltImageResource(int i11) {
        Drawable mutate = c.a.b(getContext(), i11).mutate();
        this.f7832d = mutate;
        Drawable[] drawableArr = this.f7840l;
        drawableArr[0] = this.f7833e;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7840l);
        this.f7841m = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7834f);
    }

    public void setBrightness(float f11) {
        c cVar = this.f7830b;
        cVar.f7851d = f11;
        cVar.c(this);
    }

    public void setContrast(float f11) {
        c cVar = this.f7830b;
        cVar.f7853f = f11;
        cVar.c(this);
    }

    public void setCrossfade(float f11) {
        this.f7834f = f11;
        if (this.f7840l != null) {
            if (!this.f7831c) {
                this.f7841m.getDrawable(0).setAlpha((int) ((1.0f - this.f7834f) * 255.0f));
            }
            this.f7841m.getDrawable(1).setAlpha((int) (this.f7834f * 255.0f));
            super.setImageDrawable(this.f7841m);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.f7832d == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f7833e = mutate;
        Drawable[] drawableArr = this.f7840l;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f7832d;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7840l);
        this.f7841m = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7834f);
    }

    public void setImagePanX(float f11) {
        this.f7842n = f11;
        f();
    }

    public void setImagePanY(float f11) {
        this.f7843o = f11;
        f();
    }

    public void setImageResource(int i11) {
        if (this.f7832d != null) {
            Drawable mutate = c.a.b(getContext(), i11).mutate();
            this.f7833e = mutate;
            Drawable[] drawableArr = this.f7840l;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f7832d;
            LayerDrawable layerDrawable = new LayerDrawable(this.f7840l);
            this.f7841m = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f7834f);
            return;
        }
        super.setImageResource(i11);
    }

    public void setImageRotate(float f11) {
        this.f7845q = f11;
        f();
    }

    public void setImageZoom(float f11) {
        this.f7844p = f11;
        f();
    }

    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7836h = f11;
            float f12 = this.f7835g;
            this.f7835g = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z11 = this.f7836h != f11;
        this.f7836h = f11;
        if (f11 != 0.0f) {
            if (this.f7837i == null) {
                this.f7837i = new Path();
            }
            if (this.f7839k == null) {
                this.f7839k = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f7838j == null) {
                    b bVar = new b();
                    this.f7838j = bVar;
                    setOutlineProvider(bVar);
                }
                setClipToOutline(true);
            }
            this.f7839k.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f7837i.reset();
            Path path = this.f7837i;
            RectF rectF = this.f7839k;
            float f13 = this.f7836h;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z11 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f11) {
        boolean z11 = this.f7835g != f11;
        this.f7835g = f11;
        if (f11 != 0.0f) {
            if (this.f7837i == null) {
                this.f7837i = new Path();
            }
            if (this.f7839k == null) {
                this.f7839k = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f7838j == null) {
                    a aVar = new a();
                    this.f7838j = aVar;
                    setOutlineProvider(aVar);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f7835g) / 2.0f;
            this.f7839k.set(0.0f, 0.0f, (float) width, (float) height);
            this.f7837i.reset();
            this.f7837i.addRoundRect(this.f7839k, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z11 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f11) {
        c cVar = this.f7830b;
        cVar.f7852e = f11;
        cVar.c(this);
    }

    public void setWarmth(float f11) {
        c cVar = this.f7830b;
        cVar.f7854g = f11;
        cVar.c(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
