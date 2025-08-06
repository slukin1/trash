package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import uk.co.senab.photoview.c;

public class PhotoView extends ImageView implements b {

    /* renamed from: b  reason: collision with root package name */
    public c f60711b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView.ScaleType f60712c;

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a() {
        c cVar = this.f60711b;
        if (cVar == null || cVar.r() == null) {
            this.f60711b = new c(this);
        }
        ImageView.ScaleType scaleType = this.f60712c;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f60712c = null;
        }
    }

    public RectF getDisplayRect() {
        return this.f60711b.n();
    }

    public b getIPhotoViewImplementation() {
        return this.f60711b;
    }

    public Matrix getImageMatrix() {
        return this.f60711b.q();
    }

    public float getMaximumScale() {
        return this.f60711b.u();
    }

    public float getMediumScale() {
        return this.f60711b.v();
    }

    public float getMinimumScale() {
        return this.f60711b.w();
    }

    public float getScale() {
        return this.f60711b.z();
    }

    public ImageView.ScaleType getScaleType() {
        return this.f60711b.A();
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.f60711b.C();
    }

    public void onAttachedToWindow() {
        a();
        super.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.f60711b.m();
        this.f60711b = null;
        super.onDetachedFromWindow();
    }

    public void setAllowParentInterceptOnEdge(boolean z11) {
        this.f60711b.G(z11);
    }

    public boolean setFrame(int i11, int i12, int i13, int i14) {
        boolean frame = super.setFrame(i11, i12, i13, i14);
        c cVar = this.f60711b;
        if (cVar != null) {
            cVar.b0();
        }
        return frame;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        c cVar = this.f60711b;
        if (cVar != null) {
            cVar.b0();
        }
    }

    public void setImageResource(int i11) {
        super.setImageResource(i11);
        c cVar = this.f60711b;
        if (cVar != null) {
            cVar.b0();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        c cVar = this.f60711b;
        if (cVar != null) {
            cVar.b0();
        }
    }

    public void setMaximumScale(float f11) {
        this.f60711b.J(f11);
    }

    public void setMediumScale(float f11) {
        this.f60711b.K(f11);
    }

    public void setMinimumScale(float f11) {
        this.f60711b.L(f11);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f60711b.M(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f60711b.N(onLongClickListener);
    }

    public void setOnMatrixChangeListener(c.e eVar) {
        this.f60711b.O(eVar);
    }

    public void setOnPhotoTapListener(c.f fVar) {
        this.f60711b.P(fVar);
    }

    public void setOnScaleChangeListener(c.g gVar) {
        this.f60711b.Q(gVar);
    }

    public void setOnSingleFlingListener(c.h hVar) {
        this.f60711b.R(hVar);
    }

    public void setOnViewTapListener(c.i iVar) {
        this.f60711b.S(iVar);
    }

    public void setRotationBy(float f11) {
        this.f60711b.T(f11);
    }

    public void setRotationTo(float f11) {
        this.f60711b.U(f11);
    }

    public void setScale(float f11) {
        this.f60711b.V(f11);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        c cVar = this.f60711b;
        if (cVar != null) {
            cVar.Y(scaleType);
        } else {
            this.f60712c = scaleType;
        }
    }

    public void setZoomTransitionDuration(int i11) {
        this.f60711b.Z(i11);
    }

    public void setZoomable(boolean z11) {
        this.f60711b.a0(z11);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        a();
    }
}
