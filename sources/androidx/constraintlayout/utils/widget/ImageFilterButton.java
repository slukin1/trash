package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R$styleable;

public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: b  reason: collision with root package name */
    public ImageFilterView.c f7812b = new ImageFilterView.c();

    /* renamed from: c  reason: collision with root package name */
    public float f7813c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f7814d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f7815e = Float.NaN;

    /* renamed from: f  reason: collision with root package name */
    public Path f7816f;

    /* renamed from: g  reason: collision with root package name */
    public ViewOutlineProvider f7817g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f7818h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable[] f7819i = new Drawable[2];

    /* renamed from: j  reason: collision with root package name */
    public LayerDrawable f7820j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7821k = true;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f7822l = null;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f7823m = null;

    /* renamed from: n  reason: collision with root package name */
    public float f7824n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f7825o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    public float f7826p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    public float f7827q = Float.NaN;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public void getOutline(View view, Outline outline) {
            int width = ImageFilterButton.this.getWidth();
            int height = ImageFilterButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterButton.this.f7814d) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f7815e);
        }
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    private void setOverlay(boolean z11) {
        this.f7821k = z11;
    }

    public final void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f7822l = obtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.f7813c = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f7821k));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f7824n));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f7825o));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f7827q));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f7826p));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f7823m = drawable;
            if (this.f7822l == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f7823m = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f7819i;
                    Drawable mutate = drawable2.mutate();
                    this.f7823m = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f7819i;
            Drawable mutate2 = getDrawable().mutate();
            this.f7823m = mutate2;
            drawableArr2[0] = mutate2;
            this.f7819i[1] = this.f7822l.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f7819i);
            this.f7820j = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f7813c * 255.0f));
            if (!this.f7821k) {
                this.f7820j.getDrawable(0).setAlpha((int) ((1.0f - this.f7813c) * 255.0f));
            }
            super.setImageDrawable(this.f7820j);
        }
    }

    public final void d() {
        if (!Float.isNaN(this.f7824n) || !Float.isNaN(this.f7825o) || !Float.isNaN(this.f7826p) || !Float.isNaN(this.f7827q)) {
            float f11 = 0.0f;
            float f12 = Float.isNaN(this.f7824n) ? 0.0f : this.f7824n;
            float f13 = Float.isNaN(this.f7825o) ? 0.0f : this.f7825o;
            float f14 = Float.isNaN(this.f7826p) ? 1.0f : this.f7826p;
            if (!Float.isNaN(this.f7827q)) {
                f11 = this.f7827q;
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

    public void draw(Canvas canvas) {
        boolean z11;
        if (Build.VERSION.SDK_INT >= 21 || this.f7815e == 0.0f || this.f7816f == null) {
            z11 = false;
        } else {
            z11 = true;
            canvas.save();
            canvas.clipPath(this.f7816f);
        }
        super.draw(canvas);
        if (z11) {
            canvas.restore();
        }
    }

    public final void e() {
        if (!Float.isNaN(this.f7824n) || !Float.isNaN(this.f7825o) || !Float.isNaN(this.f7826p) || !Float.isNaN(this.f7827q)) {
            d();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public float getContrast() {
        return this.f7812b.f7853f;
    }

    public float getCrossfade() {
        return this.f7813c;
    }

    public float getImagePanX() {
        return this.f7824n;
    }

    public float getImagePanY() {
        return this.f7825o;
    }

    public float getImageRotate() {
        return this.f7827q;
    }

    public float getImageZoom() {
        return this.f7826p;
    }

    public float getRound() {
        return this.f7815e;
    }

    public float getRoundPercent() {
        return this.f7814d;
    }

    public float getSaturation() {
        return this.f7812b.f7852e;
    }

    public float getWarmth() {
        return this.f7812b.f7854g;
    }

    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        d();
    }

    public void setAltImageResource(int i11) {
        Drawable mutate = c.a.b(getContext(), i11).mutate();
        this.f7822l = mutate;
        Drawable[] drawableArr = this.f7819i;
        drawableArr[0] = this.f7823m;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7819i);
        this.f7820j = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7813c);
    }

    public void setBrightness(float f11) {
        ImageFilterView.c cVar = this.f7812b;
        cVar.f7851d = f11;
        cVar.c(this);
    }

    public void setContrast(float f11) {
        ImageFilterView.c cVar = this.f7812b;
        cVar.f7853f = f11;
        cVar.c(this);
    }

    public void setCrossfade(float f11) {
        this.f7813c = f11;
        if (this.f7819i != null) {
            if (!this.f7821k) {
                this.f7820j.getDrawable(0).setAlpha((int) ((1.0f - this.f7813c) * 255.0f));
            }
            this.f7820j.getDrawable(1).setAlpha((int) (this.f7813c * 255.0f));
            super.setImageDrawable(this.f7820j);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.f7822l == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f7823m = mutate;
        Drawable[] drawableArr = this.f7819i;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f7822l;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7819i);
        this.f7820j = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7813c);
    }

    public void setImagePanX(float f11) {
        this.f7824n = f11;
        e();
    }

    public void setImagePanY(float f11) {
        this.f7825o = f11;
        e();
    }

    public void setImageResource(int i11) {
        if (this.f7822l != null) {
            Drawable mutate = c.a.b(getContext(), i11).mutate();
            this.f7823m = mutate;
            Drawable[] drawableArr = this.f7819i;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f7822l;
            LayerDrawable layerDrawable = new LayerDrawable(this.f7819i);
            this.f7820j = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f7813c);
            return;
        }
        super.setImageResource(i11);
    }

    public void setImageRotate(float f11) {
        this.f7827q = f11;
        e();
    }

    public void setImageZoom(float f11) {
        this.f7826p = f11;
        e();
    }

    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7815e = f11;
            float f12 = this.f7814d;
            this.f7814d = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z11 = this.f7815e != f11;
        this.f7815e = f11;
        if (f11 != 0.0f) {
            if (this.f7816f == null) {
                this.f7816f = new Path();
            }
            if (this.f7818h == null) {
                this.f7818h = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f7817g == null) {
                    b bVar = new b();
                    this.f7817g = bVar;
                    setOutlineProvider(bVar);
                }
                setClipToOutline(true);
            }
            this.f7818h.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f7816f.reset();
            Path path = this.f7816f;
            RectF rectF = this.f7818h;
            float f13 = this.f7815e;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z11 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f11) {
        boolean z11 = this.f7814d != f11;
        this.f7814d = f11;
        if (f11 != 0.0f) {
            if (this.f7816f == null) {
                this.f7816f = new Path();
            }
            if (this.f7818h == null) {
                this.f7818h = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f7817g == null) {
                    a aVar = new a();
                    this.f7817g = aVar;
                    setOutlineProvider(aVar);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f7814d) / 2.0f;
            this.f7818h.set(0.0f, 0.0f, (float) width, (float) height);
            this.f7816f.reset();
            this.f7816f.addRoundRect(this.f7818h, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z11 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f11) {
        ImageFilterView.c cVar = this.f7812b;
        cVar.f7852e = f11;
        cVar.c(this);
    }

    public void setWarmth(float f11) {
        ImageFilterView.c cVar = this.f7812b;
        cVar.f7854g = f11;
        cVar.c(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context, attributeSet);
    }
}
