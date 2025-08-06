package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.h0;
import androidx.swiperefreshlayout.R$styleable;

class CircleImageView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    public Animation.AnimationListener f10992b;

    /* renamed from: c  reason: collision with root package name */
    public int f10993c;

    /* renamed from: d  reason: collision with root package name */
    public int f10994d;

    public static class a extends OvalShape {

        /* renamed from: b  reason: collision with root package name */
        public Paint f10995b = new Paint();

        /* renamed from: c  reason: collision with root package name */
        public int f10996c;

        /* renamed from: d  reason: collision with root package name */
        public CircleImageView f10997d;

        public a(CircleImageView circleImageView, int i11) {
            this.f10997d = circleImageView;
            this.f10996c = i11;
            b((int) rect().width());
        }

        public final void b(int i11) {
            float f11 = (float) (i11 / 2);
            this.f10995b.setShader(new RadialGradient(f11, f11, (float) this.f10996c, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.f10997d.getWidth() / 2;
            float f11 = (float) width;
            float height = (float) (this.f10997d.getHeight() / 2);
            canvas.drawCircle(f11, height, f11, this.f10995b);
            canvas.drawCircle(f11, height, (float) (width - this.f10996c), paint);
        }

        public void onResize(float f11, float f12) {
            super.onResize(f11, f12);
            b((int) f11);
        }
    }

    public CircleImageView(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f11 = getContext().getResources().getDisplayMetrics().density;
        int i11 = (int) (1.75f * f11);
        int i12 = (int) (0.0f * f11);
        this.f10993c = (int) (3.5f * f11);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R$styleable.SwipeRefreshLayout);
        this.f10994d = obtainStyledAttributes.getColor(R$styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        obtainStyledAttributes.recycle();
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            h0.F0(this, f11 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new a(this, this.f10993c));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f10993c, (float) i12, (float) i11, 503316480);
            int i13 = this.f10993c;
            setPadding(i13, i13, i13, i13);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(this.f10994d);
        h0.B0(this, shapeDrawable);
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f10992b = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f10992b;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f10992b;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f10993c * 2), getMeasuredHeight() + (this.f10993c * 2));
        }
    }

    public void setBackgroundColor(int i11) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i11);
            this.f10994d = i11;
        }
    }
}
