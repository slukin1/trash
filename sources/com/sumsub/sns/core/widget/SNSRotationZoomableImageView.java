package com.sumsub.sns.core.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.h0;
import androidx.dynamicanimation.animation.b;
import androidx.dynamicanimation.animation.c;
import com.sumsub.sns.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u00015\u0018\u0000 l2\u00020\u0001:\u0003lmnB'\b\u0007\u0012\u0006\u0010f\u001a\u00020e\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010g\u0012\b\b\u0002\u0010i\u001a\u00020\u0016¢\u0006\u0004\bj\u0010kJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J \u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0017J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016H\u0014J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0002H\u0014J\u0006\u0010%\u001a\u00020\u0002J\u0006\u0010&\u001a\u00020\u0002J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010-\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\u0016J\u0006\u0010.\u001a\u00020\u0002R$\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00048\u0002@BX\u000e¢\u0006\f\n\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00101R\u0014\u00106\u001a\u0002058\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u00109\u001a\u0002088\u0002X\u0004¢\u0006\f\n\u0004\b9\u0010:\u0012\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u00101R\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u00101R\u0016\u0010K\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u00101R\u0016\u0010L\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010MR\u0016\u0010O\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u00101R\u0014\u0010Q\u001a\u00020P8\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u00101R\u0016\u0010W\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u00101R\u0016\u0010X\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010Z\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bZ\u0010Y\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0011\u0010d\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\bb\u0010c¨\u0006o"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "reduceClipping", "", "getFitScale", "finishScale", "scale", "", "canTranslateX", "canTranslateY", "scaleFactor", "getDrawableScaledWidth", "getDrawableScaledHeight", "getDrawableWidth", "getDrawableHeight", "computeViewPort", "updateMatrix", "scaleTo", "drawableCenterEndX", "drawableCenterEndY", "animateScale", "", "velocityX", "velocityY", "fling", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "computeScroll", "onDetachedFromWindow", "rotateCW", "rotateCCW", "angle", "exact", "rotate", "Landroid/graphics/Bitmap;", "bm", "rotationDegrees", "setImageBitmapWithRotation", "clearImage", "value", "rotationAngle", "F", "setRotationAngle", "(F)V", "targetAngle", "com/sumsub/sns/core/widget/SNSRotationZoomableImageView$rotationPositionHolder$1", "rotationPositionHolder", "Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView$rotationPositionHolder$1;", "Landroidx/dynamicanimation/animation/c;", "rotationAnimation", "Landroidx/dynamicanimation/animation/c;", "getRotationAnimation$annotations", "()V", "Landroid/animation/ValueAnimator;", "scaleAnimation", "Landroid/animation/ValueAnimator;", "Landroid/view/GestureDetector;", "gestureDetector", "Landroid/view/GestureDetector;", "Landroid/graphics/Matrix;", "mtrx", "Landroid/graphics/Matrix;", "Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView$TouchMode;", "touchMode", "Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView$TouchMode;", "touchStartDistance", "touchStartX", "touchStartY", "pointerId1", "I", "pointerId2", "currentScale", "Landroid/graphics/RectF;", "viewPort", "Landroid/graphics/RectF;", "Landroid/widget/Scroller;", "scroller", "Landroid/widget/Scroller;", "lastViewPortCenterX", "lastViewPortCenterY", "lastViewPortCenterSaved", "Z", "zoomEnabled", "getZoomEnabled", "()Z", "setZoomEnabled", "(Z)V", "getMinScale", "()F", "minScale", "getRotation", "()I", "rotation", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "GestureListener", "TouchMode", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSRotationZoomableImageView extends AppCompatImageView {
    private static final float ANIMATION_MULTIPLIER = 1000.0f;
    public static final Companion Companion = new Companion((r) null);
    private static final float MAX_SCALE = 4.0f;
    /* access modifiers changed from: private */
    public float currentScale;
    private final GestureDetector gestureDetector;
    private boolean lastViewPortCenterSaved;
    private float lastViewPortCenterX;
    private float lastViewPortCenterY;
    private final Matrix mtrx;
    private int pointerId1;
    private int pointerId2;
    /* access modifiers changed from: private */
    public float rotationAngle;
    private final c rotationAnimation;
    private final SNSRotationZoomableImageView$rotationPositionHolder$1 rotationPositionHolder;
    private ValueAnimator scaleAnimation;
    /* access modifiers changed from: private */
    public final Scroller scroller;
    private float targetAngle;
    private TouchMode touchMode;
    private float touchStartDistance;
    private float touchStartX;
    private float touchStartY;
    /* access modifiers changed from: private */
    public final RectF viewPort;
    private boolean zoomEnabled;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView$Companion;", "", "()V", "ANIMATION_MULTIPLIER", "", "MAX_SCALE", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView;)V", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onSingleTapConfirmed", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            SNSRotationZoomableImageView.this.scroller.forceFinished(true);
            if (SNSRotationZoomableImageView.this.currentScale > SNSRotationZoomableImageView.this.getFitScale()) {
                SNSRotationZoomableImageView sNSRotationZoomableImageView = SNSRotationZoomableImageView.this;
                sNSRotationZoomableImageView.animateScale(sNSRotationZoomableImageView.getFitScale(), ((float) SNSRotationZoomableImageView.this.getWidth()) / 2.0f, ((float) SNSRotationZoomableImageView.this.getHeight()) / 2.0f);
            } else {
                SNSRotationZoomableImageView.this.computeViewPort();
                float x11 = motionEvent.getX(0) - SNSRotationZoomableImageView.this.viewPort.centerX();
                SNSRotationZoomableImageView.this.animateScale(2.6666667f, SNSRotationZoomableImageView.this.viewPort.centerX() - (x11 * 2.6666667f), SNSRotationZoomableImageView.this.viewPort.centerY() - ((motionEvent.getY(0) - SNSRotationZoomableImageView.this.viewPort.centerY()) * 2.6666667f));
            }
            return super.onDoubleTap(motionEvent);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            SNSRotationZoomableImageView.this.fling((int) f11, (int) f12);
            return super.onFling(motionEvent, motionEvent2, f11, f12);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            SNSRotationZoomableImageView.this.performClick();
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView$TouchMode;", "", "(Ljava/lang/String;I)V", "NONE", "DRAG", "ZOOM", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum TouchMode {
        NONE,
        DRAG,
        ZOOM
    }

    public SNSRotationZoomableImageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    /* access modifiers changed from: private */
    public final void animateScale(float f11, float f12, float f13) {
        ValueAnimator valueAnimator = this.scaleAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f14 = this.currentScale;
        float f15 = f11 - f14;
        float centerX = f12 - this.viewPort.centerX();
        float centerY = f13 - this.viewPort.centerY();
        Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(250);
        ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
        ofFloat.addUpdateListener(new s(f14, f15, this, ref$FloatRef, centerX, centerY));
        ofFloat.start();
        this.scaleAnimation = ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: animateScale$lambda-7$lambda-6  reason: not valid java name */
    public static final void m33animateScale$lambda7$lambda6(float f11, float f12, SNSRotationZoomableImageView sNSRotationZoomableImageView, Ref$FloatRef ref$FloatRef, float f13, float f14, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f15 = f11 + (f12 * floatValue);
        float f16 = f15 / sNSRotationZoomableImageView.currentScale;
        sNSRotationZoomableImageView.mtrx.postScale(f16, f16, sNSRotationZoomableImageView.viewPort.centerX(), sNSRotationZoomableImageView.viewPort.centerY());
        float f17 = floatValue - ref$FloatRef.element;
        sNSRotationZoomableImageView.mtrx.postTranslate(f13 * f17, f17 * f14);
        sNSRotationZoomableImageView.currentScale = f15;
        ref$FloatRef.element = floatValue;
        sNSRotationZoomableImageView.reduceClipping();
    }

    private final boolean canTranslateX(float f11) {
        if (f11 <= MAX_SCALE) {
            if (!(((this.targetAngle % ((float) 180)) > 0.0f ? 1 : ((this.targetAngle % ((float) 180)) == 0.0f ? 0 : -1)) == 0) ? getDrawableScaledHeight(f11) > ((float) getHeight()) : getDrawableScaledWidth(f11) > ((float) getWidth())) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean canTranslateX$default(SNSRotationZoomableImageView sNSRotationZoomableImageView, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = sNSRotationZoomableImageView.currentScale;
        }
        return sNSRotationZoomableImageView.canTranslateX(f11);
    }

    private final boolean canTranslateY(float f11) {
        if (f11 <= MAX_SCALE) {
            if (!(((this.targetAngle % ((float) 180)) > 0.0f ? 1 : ((this.targetAngle % ((float) 180)) == 0.0f ? 0 : -1)) == 0) ? getDrawableScaledWidth(f11) > ((float) getWidth()) : getDrawableScaledHeight(f11) > ((float) getHeight())) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean canTranslateY$default(SNSRotationZoomableImageView sNSRotationZoomableImageView, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = sNSRotationZoomableImageView.currentScale;
        }
        return sNSRotationZoomableImageView.canTranslateY(f11);
    }

    /* access modifiers changed from: private */
    public final void computeViewPort() {
        RectF rectF = this.viewPort;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getDrawableWidth();
        rectF.bottom = getDrawableHeight();
        this.mtrx.mapRect(this.viewPort);
    }

    private final void finishScale() {
        if (this.currentScale < getMinScale()) {
            this.scroller.forceFinished(true);
            animateScale(getFitScale(), ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
        } else if (this.currentScale > MAX_SCALE) {
            this.scroller.forceFinished(true);
            this.lastViewPortCenterSaved = false;
            animateScale(MAX_SCALE, this.lastViewPortCenterX, this.lastViewPortCenterY);
        }
    }

    /* access modifiers changed from: private */
    public final void fling(int i11, int i12) {
        this.scroller.forceFinished(true);
        RectF rectF = this.viewPort;
        float f11 = rectF.left;
        this.touchStartX = f11;
        float f12 = rectF.top;
        this.touchStartY = f12;
        this.scroller.fling((int) f11, (int) f12, i11, i12, getWidth() - ((int) this.viewPort.width()), 0, getHeight() - ((int) this.viewPort.height()), 0);
        h0.n0(this);
    }

    private final float getDrawableHeight() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            return (float) drawable.getIntrinsicHeight();
        }
        return 0.0f;
    }

    private final float getDrawableScaledHeight(float f11) {
        return getDrawableHeight() * f11;
    }

    public static /* synthetic */ float getDrawableScaledHeight$default(SNSRotationZoomableImageView sNSRotationZoomableImageView, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = sNSRotationZoomableImageView.currentScale;
        }
        return sNSRotationZoomableImageView.getDrawableScaledHeight(f11);
    }

    private final float getDrawableScaledWidth(float f11) {
        return getDrawableWidth() * f11;
    }

    public static /* synthetic */ float getDrawableScaledWidth$default(SNSRotationZoomableImageView sNSRotationZoomableImageView, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = sNSRotationZoomableImageView.currentScale;
        }
        return sNSRotationZoomableImageView.getDrawableScaledWidth(f11);
    }

    private final float getDrawableWidth() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            return (float) drawable.getIntrinsicWidth();
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    public final float getFitScale() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return 1.0f;
        }
        float intrinsicWidth = (float) drawable.getIntrinsicWidth();
        float intrinsicHeight = (float) drawable.getIntrinsicHeight();
        if (this.targetAngle % ((float) 180) == 0.0f) {
            return Math.min(((float) getWidth()) / intrinsicWidth, ((float) getHeight()) / intrinsicHeight);
        }
        return Math.min(((float) getWidth()) / intrinsicHeight, ((float) getHeight()) / intrinsicWidth);
    }

    private final float getMinScale() {
        return getFitScale();
    }

    private static /* synthetic */ void getRotationAnimation$annotations() {
    }

    private final void reduceClipping() {
        computeViewPort();
        if (this.viewPort.width() > ((float) getWidth())) {
            RectF rectF = this.viewPort;
            if (rectF.left > 0.0f && rectF.right > ((float) getWidth())) {
                this.mtrx.postTranslate(-this.viewPort.left, 0.0f);
            }
            if (this.viewPort.right < ((float) getWidth()) && this.viewPort.left < 0.0f) {
                this.mtrx.postTranslate(((float) getWidth()) - this.viewPort.right, 0.0f);
            }
        }
        if (this.viewPort.height() > ((float) getHeight())) {
            RectF rectF2 = this.viewPort;
            if (rectF2.top > 0.0f && rectF2.bottom > ((float) getHeight())) {
                this.mtrx.postTranslate(0.0f, -this.viewPort.top);
            }
            if (this.viewPort.bottom < ((float) getHeight()) && this.viewPort.top < 0.0f) {
                this.mtrx.postTranslate(0.0f, ((float) getHeight()) - this.viewPort.bottom);
            }
        }
        boolean z11 = true;
        if (this.viewPort.width() < ((float) getWidth())) {
            float width = (((float) getWidth()) / 2.0f) - this.viewPort.centerX();
            if (!(width == 0.0f)) {
                this.mtrx.postTranslate(width, 0.0f);
            }
        }
        if (this.viewPort.height() < ((float) getHeight())) {
            float height = (((float) getHeight()) / 2.0f) - this.viewPort.centerY();
            if (height != 0.0f) {
                z11 = false;
            }
            if (!z11) {
                this.mtrx.postTranslate(0.0f, height);
            }
        }
        updateMatrix();
    }

    public static /* synthetic */ void rotate$default(SNSRotationZoomableImageView sNSRotationZoomableImageView, float f11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        sNSRotationZoomableImageView.rotate(f11, z11);
    }

    /* access modifiers changed from: private */
    /* renamed from: rotationAnimation$lambda-3$lambda-2  reason: not valid java name */
    public static final void m34rotationAnimation$lambda3$lambda2(SNSRotationZoomableImageView sNSRotationZoomableImageView, b bVar, boolean z11, float f11, float f12) {
        float f13 = (float) 360;
        float f14 = sNSRotationZoomableImageView.targetAngle % f13;
        if (f14 < 0.0f) {
            f14 += f13;
        }
        sNSRotationZoomableImageView.setRotationAngle(f14);
        sNSRotationZoomableImageView.targetAngle = f14;
    }

    /* access modifiers changed from: private */
    public final void setRotationAngle(float f11) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            this.rotationAngle = f11;
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            Matrix matrix = this.mtrx;
            float f12 = intrinsicWidth / 2.0f;
            float f13 = intrinsicHeight / 2.0f;
            matrix.setRotate(f11, f12, f13);
            float fitScale = getFitScale();
            matrix.postScale(fitScale, fitScale, f12, f13);
            float f14 = (float) 2;
            matrix.postTranslate((-(intrinsicWidth - ((float) getWidth()))) / f14, (-(intrinsicHeight - ((float) getHeight()))) / f14);
            this.currentScale = fitScale;
            updateMatrix();
        }
    }

    private final void updateMatrix() {
        setImageMatrix(this.mtrx);
        computeViewPort();
    }

    public final void clearImage() {
        setImageResource(17170445);
        this.rotationAnimation.c();
        ValueAnimator valueAnimator = this.scaleAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.scaleAnimation = null;
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.scroller.computeScrollOffset()) {
            int currX = this.scroller.getCurrX();
            int currY = this.scroller.getCurrY();
            float f11 = (float) currX;
            float f12 = f11 - this.touchStartX;
            float f13 = (float) currY;
            float f14 = f13 - this.touchStartY;
            Matrix matrix = this.mtrx;
            if (!canTranslateX$default(this, 0.0f, 1, (Object) null)) {
                f12 = 0.0f;
            }
            if (!canTranslateY$default(this, 0.0f, 1, (Object) null)) {
                f14 = 0.0f;
            }
            matrix.postTranslate(f12, f14);
            this.touchStartX = f11;
            this.touchStartY = f13;
            reduceClipping();
            h0.n0(this);
        }
    }

    public final int getRotation() {
        return (int) this.targetAngle;
    }

    public final boolean getZoomEnabled() {
        return this.zoomEnabled;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.scaleAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.scaleAnimation = null;
        this.rotationAnimation.c();
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.currentScale = getFitScale();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r0 != 6) goto L_0x011f;
     */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            boolean r0 = r13.zoomEnabled
            if (r0 != 0) goto L_0x0009
            boolean r14 = super.onTouchEvent(r14)
            return r14
        L_0x0009:
            android.view.GestureDetector r0 = r13.gestureDetector
            r0.onTouchEvent(r14)
            int r0 = r14.getActionMasked()
            r1 = 2
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x012c
            if (r0 == r4) goto L_0x0124
            if (r0 == r1) goto L_0x002d
            r5 = 3
            if (r0 == r5) goto L_0x0028
            r5 = 5
            if (r0 == r5) goto L_0x012c
            r1 = 6
            if (r0 == r1) goto L_0x0028
            goto L_0x011f
        L_0x0028:
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView$TouchMode r14 = com.sumsub.sns.core.widget.SNSRotationZoomableImageView.TouchMode.NONE
            r13.touchMode = r14
            return r4
        L_0x002d:
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView$TouchMode r0 = r13.touchMode
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView$TouchMode r1 = com.sumsub.sns.core.widget.SNSRotationZoomableImageView.TouchMode.DRAG
            r5 = 0
            if (r0 != r1) goto L_0x0067
            float r0 = r14.getX(r3)
            float r1 = r13.touchStartX
            float r0 = r0 - r1
            float r1 = r14.getY(r3)
            float r2 = r13.touchStartY
            float r1 = r1 - r2
            android.graphics.Matrix r2 = r13.mtrx
            r6 = 0
            boolean r7 = canTranslateX$default(r13, r5, r4, r6)
            if (r7 == 0) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r0 = r5
        L_0x004d:
            boolean r6 = canTranslateY$default(r13, r5, r4, r6)
            if (r6 == 0) goto L_0x0054
            r5 = r1
        L_0x0054:
            r2.postTranslate(r0, r5)
            float r0 = r14.getX(r3)
            r13.touchStartX = r0
            float r14 = r14.getY(r3)
            r13.touchStartY = r14
            r13.reduceClipping()
            return r4
        L_0x0067:
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView$TouchMode r1 = com.sumsub.sns.core.widget.SNSRotationZoomableImageView.TouchMode.ZOOM
            if (r0 != r1) goto L_0x011f
            int r0 = r13.pointerId1
            int r0 = r14.findPointerIndex(r0)
            int r1 = r13.pointerId2
            int r1 = r14.findPointerIndex(r1)
            if (r0 < 0) goto L_0x011a
            if (r1 >= 0) goto L_0x007d
            goto L_0x011a
        L_0x007d:
            float r3 = r14.getX(r1)
            float r6 = r14.getX(r0)
            float r3 = r3 - r6
            double r6 = (double) r3
            float r3 = r14.getY(r1)
            float r8 = r14.getY(r0)
            float r3 = r3 - r8
            double r8 = (double) r3
            double r6 = java.lang.Math.hypot(r6, r8)
            float r3 = (float) r6
            float r6 = r13.touchStartDistance
            float r6 = r3 / r6
            float r7 = r14.getX(r0)
            float r8 = r14.getX(r1)
            float r7 = r7 + r8
            float r7 = r7 / r2
            float r0 = r14.getY(r0)
            float r14 = r14.getY(r1)
            float r0 = r0 + r14
            float r0 = r0 / r2
            float r14 = r13.touchStartX
            float r14 = r7 - r14
            float r1 = r13.touchStartY
            float r1 = r0 - r1
            float r8 = r13.currentScale
            float r8 = r8 * r6
            boolean r8 = r13.canTranslateX(r8)
            float r9 = r13.currentScale
            float r9 = r9 * r6
            boolean r9 = r13.canTranslateY(r9)
            float r10 = r13.currentScale
            float r10 = r10 * r6
            r11 = 1082130432(0x40800000, float:4.0)
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x00e3
            boolean r10 = r13.lastViewPortCenterSaved
            if (r10 != 0) goto L_0x00e3
            android.graphics.RectF r10 = r13.viewPort
            float r10 = r10.centerX()
            r13.lastViewPortCenterX = r10
            android.graphics.RectF r10 = r13.viewPort
            float r10 = r10.centerY()
            r13.lastViewPortCenterY = r10
            r13.lastViewPortCenterSaved = r4
        L_0x00e3:
            android.graphics.Matrix r10 = r13.mtrx
            if (r8 == 0) goto L_0x00ea
            float r11 = r13.touchStartX
            goto L_0x00f0
        L_0x00ea:
            int r11 = r13.getWidth()
            float r11 = (float) r11
            float r11 = r11 / r2
        L_0x00f0:
            if (r9 == 0) goto L_0x00f5
            float r2 = r13.touchStartY
            goto L_0x00fc
        L_0x00f5:
            int r12 = r13.getHeight()
            float r12 = (float) r12
            float r2 = r12 / r2
        L_0x00fc:
            r10.postScale(r6, r6, r11, r2)
            android.graphics.Matrix r2 = r13.mtrx
            if (r8 == 0) goto L_0x0104
            goto L_0x0105
        L_0x0104:
            r14 = r5
        L_0x0105:
            if (r9 == 0) goto L_0x0108
            r5 = r1
        L_0x0108:
            r2.postTranslate(r14, r5)
            float r14 = r13.currentScale
            float r14 = r14 * r6
            r13.currentScale = r14
            r13.touchStartDistance = r3
            r13.touchStartX = r7
            r13.touchStartY = r0
            r13.reduceClipping()
            return r4
        L_0x011a:
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView$TouchMode r14 = com.sumsub.sns.core.widget.SNSRotationZoomableImageView.TouchMode.NONE
            r13.touchMode = r14
            return r3
        L_0x011f:
            boolean r14 = super.onTouchEvent(r14)
            return r14
        L_0x0124:
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView$TouchMode r14 = com.sumsub.sns.core.widget.SNSRotationZoomableImageView.TouchMode.NONE
            r13.touchMode = r14
            r13.finishScale()
            return r4
        L_0x012c:
            android.widget.Scroller r0 = r13.scroller
            r0.forceFinished(r4)
            int r0 = r14.getPointerCount()
            if (r0 != r1) goto L_0x017f
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView$TouchMode r0 = r13.touchMode
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView$TouchMode r1 = com.sumsub.sns.core.widget.SNSRotationZoomableImageView.TouchMode.ZOOM
            if (r0 == r1) goto L_0x017f
            r13.touchMode = r1
            int r0 = r14.getPointerId(r3)
            r13.pointerId1 = r0
            int r0 = r14.getPointerId(r4)
            r13.pointerId2 = r0
            float r0 = r14.getX(r4)
            float r1 = r14.getX(r3)
            float r0 = r0 - r1
            double r0 = (double) r0
            float r5 = r14.getY(r4)
            float r6 = r14.getY(r3)
            float r5 = r5 - r6
            double r5 = (double) r5
            double r0 = java.lang.Math.hypot(r0, r5)
            float r0 = (float) r0
            r13.touchStartDistance = r0
            float r0 = r14.getX(r3)
            float r1 = r14.getX(r4)
            float r0 = r0 + r1
            float r0 = r0 / r2
            r13.touchStartX = r0
            float r0 = r14.getY(r3)
            float r14 = r14.getY(r4)
            float r0 = r0 + r14
            float r0 = r0 / r2
            r13.touchStartY = r0
            goto L_0x0199
        L_0x017f:
            int r0 = r14.getPointerCount()
            if (r0 != r4) goto L_0x0199
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView$TouchMode r0 = r13.touchMode
            com.sumsub.sns.core.widget.SNSRotationZoomableImageView$TouchMode r1 = com.sumsub.sns.core.widget.SNSRotationZoomableImageView.TouchMode.DRAG
            if (r0 == r1) goto L_0x0199
            r13.touchMode = r1
            float r0 = r14.getX(r3)
            r13.touchStartX = r0
            float r14 = r14.getY(r3)
            r13.touchStartY = r14
        L_0x0199:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.SNSRotationZoomableImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void rotate(float f11, boolean z11) {
        this.scroller.forceFinished(true);
        if (z11) {
            this.targetAngle = f11;
        } else {
            this.targetAngle += f11;
        }
        this.rotationAnimation.p(this.targetAngle * ANIMATION_MULTIPLIER);
    }

    public final void rotateCCW() {
        rotate$default(this, -90.0f, false, 2, (Object) null);
    }

    public final void rotateCW() {
        rotate$default(this, 90.0f, false, 2, (Object) null);
    }

    public final void setImageBitmapWithRotation(Bitmap bitmap, int i11) {
        setImageBitmap(bitmap);
        float f11 = (float) i11;
        this.targetAngle = f11;
        this.rotationAnimation.p(f11 * ANIMATION_MULTIPLIER);
        this.rotationAnimation.v();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.targetAngle = 0.0f;
        this.rotationAnimation.p(0.0f);
        this.rotationAnimation.v();
    }

    public final void setZoomEnabled(boolean z11) {
        this.zoomEnabled = z11;
    }

    public SNSRotationZoomableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSRotationZoomableImageView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.sns_RotationZoomableImageViewStyle : i11);
    }

    public SNSRotationZoomableImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        SNSRotationZoomableImageView$rotationPositionHolder$1 sNSRotationZoomableImageView$rotationPositionHolder$1 = new SNSRotationZoomableImageView$rotationPositionHolder$1(this);
        this.rotationPositionHolder = sNSRotationZoomableImageView$rotationPositionHolder$1;
        c cVar = new c(this, sNSRotationZoomableImageView$rotationPositionHolder$1, 0.0f);
        cVar.r().d(1.0f);
        cVar.r().f(1500.0f);
        cVar.b(new t(this));
        this.rotationAnimation = cVar;
        this.gestureDetector = new GestureDetector(context, new GestureListener());
        Matrix matrix = new Matrix();
        matrix.setTranslate(1.0f, 1.0f);
        matrix.setScale(1.0f, 1.0f);
        this.mtrx = matrix;
        this.touchMode = TouchMode.NONE;
        this.currentScale = 1.0f;
        this.viewPort = new RectF();
        this.scroller = new Scroller(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSRotationZoomableImageView, i11, 0);
        this.zoomEnabled = obtainStyledAttributes.getBoolean(R.styleable.SNSRotationZoomableImageView_sns_zoomEnabled, false);
        obtainStyledAttributes.recycle();
        setScaleType(ImageView.ScaleType.MATRIX);
        updateMatrix();
    }
}
