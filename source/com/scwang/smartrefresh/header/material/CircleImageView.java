package com.scwang.smartrefresh.header.material;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;

public class CircleImageView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    public Animation.AnimationListener f29680b;

    /* renamed from: c  reason: collision with root package name */
    public int f29681c;

    public class a extends OvalShape {

        /* renamed from: b  reason: collision with root package name */
        public RadialGradient f29682b;

        /* renamed from: c  reason: collision with root package name */
        public Paint f29683c = new Paint();

        public a(int i11) {
            CircleImageView.this.f29681c = i11;
            b((int) rect().width());
        }

        public final void b(int i11) {
            float f11 = (float) (i11 / 2);
            RadialGradient radialGradient = new RadialGradient(f11, f11, (float) CircleImageView.this.f29681c, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f29682b = radialGradient;
            this.f29683c.setShader(radialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = CircleImageView.this.getWidth() / 2;
            float f11 = (float) width;
            float height = (float) (CircleImageView.this.getHeight() / 2);
            canvas.drawCircle(f11, height, f11, this.f29683c);
            canvas.drawCircle(f11, height, (float) (width - CircleImageView.this.f29681c), paint);
        }

        public void onResize(float f11, float f12) {
            super.onResize(f11, f12);
            b((int) f11);
        }
    }

    public CircleImageView(Context context, int i11) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f11 = getContext().getResources().getDisplayMetrics().density;
        int i12 = (int) (1.75f * f11);
        int i13 = (int) (0.0f * f11);
        this.f29681c = (int) (3.5f * f11);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            setElevation(f11 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new a(this.f29681c));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f29681c, (float) i13, (float) i12, 503316480);
            int i14 = this.f29681c;
            setPadding(i14, i14, i14, i14);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i11);
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(shapeDrawable);
        } else {
            setBackgroundDrawable(shapeDrawable);
        }
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f29680b;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f29680b;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f29681c * 2), getMeasuredHeight() + (this.f29681c * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f29680b = animationListener;
    }

    public void setBackgroundColor(int i11) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i11);
        }
    }

    public void setBackgroundColorRes(int i11) {
        Context context = getContext();
        if (Build.VERSION.SDK_INT >= 23) {
            setBackgroundColor(context.getResources().getColor(i11, context.getTheme()));
        } else {
            setBackgroundColor(context.getResources().getColor(i11));
        }
    }
}
