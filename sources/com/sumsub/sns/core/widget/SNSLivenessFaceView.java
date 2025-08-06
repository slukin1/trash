package com.sumsub.sns.core.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.dynamicanimation.animation.b;
import androidx.dynamicanimation.animation.c;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.theme.d;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.ranges.h;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u00014\u0018\u0000 y2\u00020\u0001:\u0003yz{B1\b\u0007\u0012\u0006\u0010r\u001a\u00020q\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010s\u0012\b\b\u0002\u0010u\u001a\u00020\u0002\u0012\b\b\u0002\u0010v\u001a\u00020\u0002¢\u0006\u0004\bw\u0010xJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0013\u001a\u00020\u0004H\u0014J(\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0014J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0014J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014R\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"8\u0002@BX\u000e¢\u0006\f\n\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u0010(\u001a\u0004\u0018\u00010\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!\"\u0004\b*\u0010+R(\u0010-\u001a\u0004\u0018\u00010,2\b\u0010#\u001a\u0004\u0018\u00010,8\u0002@BX\u000e¢\u0006\f\n\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00102R\u0014\u00105\u001a\u0002048\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010A\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"8\u0002@BX\u000e¢\u0006\f\n\u0004\bA\u0010%\"\u0004\bB\u0010'R\u001c\u0010D\u001a\u00020C8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\bD\u0010E\u0012\u0004\bF\u0010GR\u001c\u0010H\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\bH\u0010%\u0012\u0004\bI\u0010GR\u001c\u0010J\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\bJ\u0010%\u0012\u0004\bK\u0010GR\u001a\u0010M\u001a\u00020L8\u0002X\u0004¢\u0006\f\n\u0004\bM\u0010N\u0012\u0004\bO\u0010GR\u0014\u0010Q\u001a\u00020P8\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020P8\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010RR$\u0010T\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"8\u0002@BX\u000e¢\u0006\f\n\u0004\bT\u0010%\"\u0004\bU\u0010'R\u001a\u0010V\u001a\u00020P8\u0002X\u0004¢\u0006\f\n\u0004\bV\u0010R\u0012\u0004\bW\u0010GR\u0014\u0010Y\u001a\u00020X8\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020X8\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010ZR\u0014\u0010\\\u001a\u00020X8\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010ZR\u0014\u0010]\u001a\u00020X8\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010ZR\u0014\u0010^\u001a\u00020X8\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010ZR\u0014\u0010_\u001a\u00020X8\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010ZR\u0016\u0010`\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u00102R\u0016\u0010a\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u00102R\u0016\u0010b\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u00102R\u0014\u0010c\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u00102R\u0014\u0010d\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u00102R$\u0010f\u001a\u00020e2\u0006\u0010#\u001a\u00020e8\u0002@BX\u000e¢\u0006\f\n\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020j8BX\u0004¢\u0006\u0006\u001a\u0004\bk\u0010lR\u0011\u0010p\u001a\u00020m8F¢\u0006\u0006\u001a\u0004\bn\u0010o¨\u0006|"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSLivenessFaceView;", "Landroid/view/View;", "", "color", "", "setOverlayColor", "setFaceRecognizedColor", "setFaceMarkerActiveColor", "setFaceMarkerInActiveColor", "Landroid/graphics/Canvas;", "canvas", "drawRecognizingCircle", "drawMarkers", "drawRecognizingArc", "updateOverlay", "setRecognizingState", "setFaceDetectedState", "setFaceAnalyzingState", "setScanCompleteState", "onDetachedFromWindow", "w", "h", "oldw", "oldh", "onSizeChanged", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "onDraw", "Landroid/graphics/RectF;", "helperRectF", "Landroid/graphics/RectF;", "getHelperRectF", "()Landroid/graphics/RectF;", "", "value", "recognizingFactor", "F", "setRecognizingFactor", "(F)V", "faceRectangle", "getFaceRectangle", "setFaceRectangle", "(Landroid/graphics/RectF;)V", "Landroid/graphics/Bitmap;", "bgBitmap", "Landroid/graphics/Bitmap;", "setBgBitmap", "(Landroid/graphics/Bitmap;)V", "maxRadius", "I", "focusRadius", "com/sumsub/sns/core/widget/SNSLivenessFaceView$radiusHolder$1", "radiusHolder", "Lcom/sumsub/sns/core/widget/SNSLivenessFaceView$radiusHolder$1;", "Landroidx/dynamicanimation/animation/c;", "radiusAnimation", "Landroidx/dynamicanimation/animation/c;", "Lcom/sumsub/sns/core/widget/SNSLivenessFaceView$SNSFaceStateListener;", "stateListener", "Lcom/sumsub/sns/core/widget/SNSLivenessFaceView$SNSFaceStateListener;", "getStateListener", "()Lcom/sumsub/sns/core/widget/SNSLivenessFaceView$SNSFaceStateListener;", "setStateListener", "(Lcom/sumsub/sns/core/widget/SNSLivenessFaceView$SNSFaceStateListener;)V", "detectingFactor", "setDetectingFactor", "", "detectingAnimationSpeed", "J", "getDetectingAnimationSpeed$annotations", "()V", "detectingArc1RotationAngle", "getDetectingArc1RotationAngle$annotations", "detectingArc2RotationAngle", "getDetectingArc2RotationAngle$annotations", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "updater", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "getUpdater$annotations", "Landroid/animation/ValueAnimator;", "recognizingAnimationDirect", "Landroid/animation/ValueAnimator;", "recognizingAnimationInDirect", "progressRotationAngle", "setProgressRotationAngle", "progressRotationAnimator", "getProgressRotationAnimator$annotations", "Landroid/graphics/Paint;", "mFaceProgressMarkerPaint", "Landroid/graphics/Paint;", "mFaceDetectionCirclePaint", "mFaceCutCirclePaint", "mFaceScanCompletePaint", "mFaceRecognizingPaint", "mFaceRectanglePaint", "mColorFaceMarkerActive", "mColorFaceMarkerInActive", "mColorOverlay", "mMarkerSize", "mMarkerPadding", "Lkotlin/ranges/h;", "progressRange", "Lkotlin/ranges/h;", "setProgressRange", "(Lkotlin/ranges/h;)V", "", "isAnalyzing", "()Z", "Landroid/graphics/Rect;", "getFaceCapturingRect", "()Landroid/graphics/Rect;", "faceCapturingRect", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "SNSFaceStateListener", "SNSFaceViewState", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSLivenessFaceView extends View {
    private static final float ANIMATION_MULTIPLIER = 1000.0f;
    private static final int ANIMATION_SPEED = 1000;
    public static final Companion Companion = new Companion((r) null);
    private Bitmap bgBitmap;
    private long detectingAnimationSpeed;
    private float detectingArc1RotationAngle;
    private float detectingArc2RotationAngle;
    private float detectingFactor;
    private RectF faceRectangle;
    private int focusRadius;
    private final RectF helperRectF;
    private int mColorFaceMarkerActive;
    private int mColorFaceMarkerInActive;
    private int mColorOverlay;
    private final Paint mFaceCutCirclePaint;
    private final Paint mFaceDetectionCirclePaint;
    private final Paint mFaceProgressMarkerPaint;
    private final Paint mFaceRecognizingPaint;
    private final Paint mFaceRectanglePaint;
    private final Paint mFaceScanCompletePaint;
    private final int mMarkerPadding;
    private final int mMarkerSize;
    private int maxRadius;
    private h progressRange;
    private float progressRotationAngle;
    private final ValueAnimator progressRotationAnimator;
    private final c radiusAnimation;
    private final SNSLivenessFaceView$radiusHolder$1 radiusHolder;
    /* access modifiers changed from: private */
    public final ValueAnimator recognizingAnimationDirect;
    /* access modifiers changed from: private */
    public final ValueAnimator recognizingAnimationInDirect;
    /* access modifiers changed from: private */
    public float recognizingFactor;
    private SNSFaceStateListener stateListener;
    private final ValueAnimator.AnimatorUpdateListener updater;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSLivenessFaceView$Companion;", "", "()V", "ANIMATION_MULTIPLIER", "", "ANIMATION_SPEED", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSLivenessFaceView$SNSFaceStateListener;", "", "onState", "", "state", "Lcom/sumsub/sns/core/widget/SNSLivenessFaceView$SNSFaceViewState;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface SNSFaceStateListener {
        void onState(SNSFaceViewState sNSFaceViewState);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSLivenessFaceView$SNSFaceViewState;", "", "(Ljava/lang/String;I)V", "Recognizing", "Recognized", "Analyzing", "Complete", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum SNSFaceViewState {
        Recognizing,
        Recognized,
        Analyzing,
        Complete
    }

    public SNSLivenessFaceView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e3 A[LOOP:0: B:10:0x0076->B:22:0x00e3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00f0 A[EDGE_INSN: B:24:0x00f0->B:23:0x00f0 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void drawMarkers(android.graphics.Canvas r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = 1
            float r2 = (float) r1
            float r3 = r0.recognizingFactor
            r4 = -1109309522(0xffffffffbde147ae, float:-0.11)
            r5 = 1038174126(0x3de147ae, float:0.11)
            float r3 = kotlin.ranges.RangesKt___RangesKt.i(r3, r4, r5)
            r4 = 10
            float r4 = (float) r4
            float r3 = r3 * r4
            float r3 = java.lang.Math.abs(r3)
            float r2 = r2 - r3
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x00f3
            r3 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0026
            goto L_0x00f3
        L_0x0026:
            int r3 = r0.mMarkerSize
            float r3 = (float) r3
            float r3 = r3 * r2
            int r2 = r0.focusRadius
            float r4 = (float) r2
            int r5 = r0.maxRadius
            int r5 = r5 - r2
            float r2 = (float) r5
            float r5 = r0.recognizingFactor
            float r2 = r2 * r5
            float r4 = r4 - r2
            int r2 = r0.mMarkerPadding
            float r2 = (float) r2
            float r4 = r4 + r2
            android.graphics.Rect r2 = r22.getFaceCapturingRect()
            int r2 = r2.centerX()
            float r2 = (float) r2
            android.graphics.Rect r5 = r22.getFaceCapturingRect()
            int r5 = r5.centerY()
            float r5 = (float) r5
            r23.save()
            float r6 = r0.progressRotationAngle
            r13 = r23
            r13.rotate(r6, r2, r5)
            r6 = 360(0x168, float:5.04E-43)
            r14 = 0
            kotlin.ranges.h r6 = kotlin.ranges.RangesKt___RangesKt.o(r14, r6)
            r7 = 4
            kotlin.ranges.f r6 = kotlin.ranges.RangesKt___RangesKt.n(r6, r7)
            int r7 = r6.a()
            int r15 = r6.b()
            int r6 = r6.c()
            if (r6 <= 0) goto L_0x0071
            if (r7 <= r15) goto L_0x0075
        L_0x0071:
            if (r6 >= 0) goto L_0x00f0
            if (r15 > r7) goto L_0x00f0
        L_0x0075:
            r12 = r7
        L_0x0076:
            double r7 = (double) r12
            double r7 = java.lang.Math.toRadians(r7)
            float r7 = (float) r7
            double r8 = (double) r2
            double r10 = (double) r4
            r16 = r2
            double r1 = (double) r7
            double r17 = java.lang.Math.sin(r1)
            double r17 = r17 * r10
            r19 = r15
            double r14 = r8 + r17
            float r14 = (float) r14
            r15 = r6
            double r6 = (double) r5
            double r17 = java.lang.Math.cos(r1)
            double r10 = r10 * r17
            double r10 = r6 - r10
            float r10 = (float) r10
            float r11 = r4 + r3
            r17 = r3
            r18 = r4
            double r3 = (double) r11
            double r20 = java.lang.Math.sin(r1)
            double r20 = r20 * r3
            double r8 = r8 + r20
            float r11 = (float) r8
            double r1 = java.lang.Math.cos(r1)
            double r3 = r3 * r1
            double r6 = r6 - r3
            float r1 = (float) r6
            android.graphics.Paint r2 = r0.mFaceProgressMarkerPaint
            boolean r3 = r22.isAnalyzing()
            if (r3 != 0) goto L_0x00cd
            kotlin.ranges.h r3 = r0.progressRange
            int r4 = r3.a()
            int r3 = r3.b()
            if (r12 > r3) goto L_0x00c6
            if (r4 > r12) goto L_0x00c6
            r3 = 1
            goto L_0x00c7
        L_0x00c6:
            r3 = 0
        L_0x00c7:
            if (r3 == 0) goto L_0x00ca
            goto L_0x00cd
        L_0x00ca:
            int r3 = r0.mColorFaceMarkerInActive
            goto L_0x00cf
        L_0x00cd:
            int r3 = r0.mColorFaceMarkerActive
        L_0x00cf:
            r2.setColor(r3)
            android.graphics.Paint r2 = r0.mFaceProgressMarkerPaint
            r7 = r23
            r8 = r14
            r9 = r10
            r10 = r11
            r11 = r1
            r1 = r12
            r12 = r2
            r7.drawLine(r8, r9, r10, r11, r12)
            r2 = r19
            if (r1 == r2) goto L_0x00f0
            int r12 = r1 + r15
            r6 = r15
            r3 = r17
            r4 = r18
            r1 = 1
            r14 = 0
            r15 = r2
            r2 = r16
            goto L_0x0076
        L_0x00f0:
            r23.restore()
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.SNSLivenessFaceView.drawMarkers(android.graphics.Canvas):void");
    }

    private final void drawRecognizingArc(Canvas canvas) {
        this.helperRectF.set(getFaceCapturingRect());
        float f11 = 0.0f;
        this.helperRectF.inset(0.0f, ((((float) 1) - Math.abs(this.detectingFactor)) * this.helperRectF.height()) / ((float) 2));
        if (this.detectingFactor > 0.0f) {
            f11 = 180.0f;
        }
        canvas.save();
        canvas.rotate(this.detectingArc1RotationAngle, this.helperRectF.centerX(), this.helperRectF.centerY());
        float f12 = f11;
        canvas.drawArc(this.helperRectF, f12, 180.0f, false, this.mFaceRecognizingPaint);
        canvas.rotate((-this.detectingArc1RotationAngle) - this.detectingArc2RotationAngle, this.helperRectF.centerX(), this.helperRectF.centerY());
        canvas.drawArc(this.helperRectF, f12, 180.0f, false, this.mFaceRecognizingPaint);
        canvas.restore();
    }

    private final void drawRecognizingCircle(Canvas canvas) {
        float centerX = (float) getFaceCapturingRect().centerX();
        float centerY = (float) getFaceCapturingRect().centerY();
        float max = Math.max(((float) this.focusRadius) * (((float) 1) - this.recognizingFactor), ((float) getFaceCapturingRect().width()) / 2.0f);
        Bitmap bitmap = this.bgBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        if (isAnalyzing()) {
            canvas.drawCircle(centerX, centerY, max, this.mFaceScanCompletePaint);
        } else {
            canvas.drawCircle(centerX, centerY, max, this.mFaceDetectionCirclePaint);
        }
    }

    private static /* synthetic */ void getDetectingAnimationSpeed$annotations() {
    }

    private static /* synthetic */ void getDetectingArc1RotationAngle$annotations() {
    }

    private static /* synthetic */ void getDetectingArc2RotationAngle$annotations() {
    }

    private static /* synthetic */ void getProgressRotationAnimator$annotations() {
    }

    private static /* synthetic */ void getUpdater$annotations() {
    }

    /* access modifiers changed from: private */
    public final boolean isAnalyzing() {
        return ((this.recognizingFactor > 0.0f ? 1 : (this.recognizingFactor == 0.0f ? 0 : -1)) == 0) && x.b(this.progressRange, h.f56844f.a());
    }

    /* access modifiers changed from: private */
    /* renamed from: progressRotationAnimator$lambda-8$lambda-7  reason: not valid java name */
    public static final void m30progressRotationAnimator$lambda8$lambda7(SNSLivenessFaceView sNSLivenessFaceView, ValueAnimator valueAnimator) {
        sNSLivenessFaceView.setProgressRotationAngle(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: radiusAnimation$lambda-1$lambda-0  reason: not valid java name */
    public static final void m31radiusAnimation$lambda1$lambda0(SNSLivenessFaceView sNSLivenessFaceView, b bVar, boolean z11, float f11, float f12) {
        SNSFaceViewState sNSFaceViewState;
        SNSFaceStateListener sNSFaceStateListener = sNSLivenessFaceView.stateListener;
        if (sNSFaceStateListener != null) {
            float f13 = sNSLivenessFaceView.recognizingFactor;
            boolean z12 = true;
            if (f13 == 0.0f) {
                sNSFaceViewState = sNSLivenessFaceView.isAnalyzing() ? SNSFaceViewState.Analyzing : SNSFaceViewState.Recognized;
            } else {
                if (f13 != 1.0f) {
                    z12 = false;
                }
                if (z12) {
                    sNSFaceViewState = SNSFaceViewState.Complete;
                } else {
                    sNSFaceViewState = SNSFaceViewState.Recognizing;
                }
            }
            sNSFaceStateListener.onState(sNSFaceViewState);
        }
    }

    private final void setBgBitmap(Bitmap bitmap) {
        this.bgBitmap = bitmap;
        updateOverlay();
        invalidate();
    }

    private final void setDetectingFactor(float f11) {
        if (!(this.detectingFactor == f11)) {
            this.detectingFactor = f11;
            postInvalidateOnAnimation();
        }
    }

    private final void setFaceMarkerActiveColor(int i11) {
        this.mColorFaceMarkerActive = i11;
    }

    private final void setFaceMarkerInActiveColor(int i11) {
        this.mColorFaceMarkerInActive = i11;
    }

    private final void setFaceRecognizedColor(int i11) {
        this.mFaceRecognizingPaint.setColor(i11);
        this.mFaceDetectionCirclePaint.setColor(i11);
        invalidate();
    }

    private final void setOverlayColor(int i11) {
        this.mColorOverlay = i11;
        invalidate();
    }

    private final void setProgressRange(h hVar) {
        if (!x.b(hVar, this.progressRange)) {
            this.progressRange = hVar;
            postInvalidateOnAnimation();
        }
    }

    private final void setProgressRotationAngle(float f11) {
        if (!(f11 == this.progressRotationAngle)) {
            this.progressRotationAngle = f11;
            postInvalidateOnAnimation();
        }
    }

    /* access modifiers changed from: private */
    public final void setRecognizingFactor(float f11) {
        if (!(this.recognizingFactor == f11)) {
            this.recognizingFactor = RangesKt___RangesKt.i(f11, -1.0f, 1.0f);
            updateOverlay();
            postInvalidate();
        }
    }

    private final void updateOverlay() {
        float centerX = (float) getFaceCapturingRect().centerX();
        float centerY = (float) getFaceCapturingRect().centerY();
        float max = Math.max(((float) this.focusRadius) * (((float) 1) - this.recognizingFactor), ((float) getFaceCapturingRect().width()) / 2.0f);
        Bitmap bitmap = this.bgBitmap;
        if (bitmap != null) {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(this.mColorOverlay);
            canvas.drawCircle(centerX, centerY, max, this.mFaceCutCirclePaint);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updater$lambda-2  reason: not valid java name */
    public static final void m32updater$lambda2(SNSLivenessFaceView sNSLivenessFaceView, ValueAnimator valueAnimator) {
        sNSLivenessFaceView.setDetectingFactor(((Float) valueAnimator.getAnimatedValue()).floatValue());
        sNSLivenessFaceView.detectingArc1RotationAngle += Math.abs(sNSLivenessFaceView.detectingFactor) * 0.3f;
        sNSLivenessFaceView.detectingArc2RotationAngle += Math.abs(sNSLivenessFaceView.detectingFactor) * 0.5f;
    }

    public final Rect getFaceCapturingRect() {
        int g11 = RangesKt___RangesKt.g((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) - (((this.mMarkerPadding * 2) + (this.mMarkerSize * 2)) + ((int) this.mFaceProgressMarkerPaint.getStrokeWidth()));
        int width = ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - g11) / 2) + getPaddingLeft();
        int height = ((((getHeight() - getPaddingTop()) - getPaddingBottom()) - g11) / 2) + getPaddingTop();
        return new Rect(width, height, width + g11, g11 + height);
    }

    public final RectF getFaceRectangle() {
        return this.faceRectangle;
    }

    public final RectF getHelperRectF() {
        return this.helperRectF;
    }

    public final SNSFaceStateListener getStateListener() {
        return this.stateListener;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.radiusAnimation.c();
        this.recognizingAnimationDirect.cancel();
        this.recognizingAnimationInDirect.cancel();
    }

    public void onDraw(Canvas canvas) {
        RectF rectF;
        super.onDraw(canvas);
        canvas.save();
        drawRecognizingCircle(canvas);
        if (isAnalyzing()) {
            drawMarkers(canvas);
        }
        if ((this.recognizingFactor == 0.0f) && !isAnalyzing()) {
            drawRecognizingArc(canvas);
        }
        if (this.recognizingFactor < 0.0f && (rectF = this.faceRectangle) != null) {
            canvas.drawRect(rectF, this.mFaceRectanglePaint);
        }
        canvas.restore();
    }

    public void onMeasure(int i11, int i12) {
        int g11 = RangesKt___RangesKt.g((View.MeasureSpec.getSize(i11) - getPaddingStart()) - getPaddingEnd(), (View.MeasureSpec.getSize(i12) - getPaddingTop()) - getPaddingBottom());
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getPaddingStart() + g11 + getPaddingEnd(), 1073741824), View.MeasureSpec.makeMeasureSpec(g11 + getPaddingTop() + getPaddingBottom(), 1073741824));
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        Bitmap bitmap;
        super.onSizeChanged(i11, i12, i13, i14);
        Rect faceCapturingRect = getFaceCapturingRect();
        float d11 = (float) RangesKt___RangesKt.d(faceCapturingRect.centerX(), i11 - faceCapturingRect.centerX());
        float d12 = (float) RangesKt___RangesKt.d(faceCapturingRect.centerY(), i12 - faceCapturingRect.centerY());
        this.maxRadius = (int) ((float) Math.sqrt((double) ((d11 * d11) + (d12 * d12))));
        this.focusRadius = getFaceCapturingRect().width() / 2;
        Bitmap bitmap2 = this.bgBitmap;
        if ((bitmap2 != null && !bitmap2.isRecycled()) && (bitmap = this.bgBitmap) != null) {
            bitmap.recycle();
        }
        setBgBitmap(Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888));
    }

    public final void setFaceAnalyzingState() {
        this.radiusAnimation.p(0.0f);
        setProgressRange(h.f56844f.a());
        this.recognizingAnimationDirect.cancel();
        this.recognizingAnimationInDirect.cancel();
        if (!this.progressRotationAnimator.isStarted()) {
            this.progressRotationAnimator.start();
        }
    }

    public final void setFaceDetectedState() {
        this.radiusAnimation.p(0.0f);
        if (!this.recognizingAnimationDirect.isStarted() && !this.recognizingAnimationInDirect.isStarted()) {
            this.recognizingAnimationDirect.start();
            this.recognizingAnimationInDirect.cancel();
        }
        setProgressRange(new h(0, 360));
        if (!this.progressRotationAnimator.isStarted()) {
            this.progressRotationAnimator.start();
        }
    }

    public final void setFaceRectangle(RectF rectF) {
        if (!x.b(rectF, this.faceRectangle)) {
            this.faceRectangle = rectF;
            postInvalidate();
        }
    }

    public final void setRecognizingState() {
        this.radiusAnimation.p(-50.0f);
        setProgressRange(h.f56844f.a());
        this.recognizingAnimationDirect.cancel();
        this.recognizingAnimationInDirect.cancel();
        this.progressRotationAnimator.cancel();
    }

    public final void setScanCompleteState() {
        this.radiusAnimation.p(ANIMATION_MULTIPLIER);
        setProgressRange(h.f56844f.a());
        this.recognizingAnimationDirect.cancel();
        this.recognizingAnimationInDirect.cancel();
        this.progressRotationAnimator.cancel();
    }

    public final void setStateListener(SNSFaceStateListener sNSFaceStateListener) {
        this.stateListener = sNSFaceStateListener;
    }

    public SNSLivenessFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSLivenessFaceView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSLivenessFaceView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_ProofaceViewStyle : i11, (i13 & 8) != 0 ? R.style.SNSProofaceViewStyle : i12);
    }

    public SNSLivenessFaceView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        Integer a11;
        Integer a12;
        Integer a13;
        this.helperRectF = new RectF();
        this.recognizingFactor = -1.0f;
        SNSLivenessFaceView$radiusHolder$1 sNSLivenessFaceView$radiusHolder$1 = new SNSLivenessFaceView$radiusHolder$1(this);
        this.radiusHolder = sNSLivenessFaceView$radiusHolder$1;
        c cVar = new c(this, sNSLivenessFaceView$radiusHolder$1, this.recognizingFactor);
        cVar.r().d(0.75f);
        cVar.r().f(200.0f);
        cVar.j(-1000.0f);
        cVar.i(ANIMATION_MULTIPLIER);
        cVar.b(new r(this));
        this.radiusAnimation = cVar;
        this.detectingFactor = -1.0f;
        this.detectingAnimationSpeed = 1000;
        this.detectingArc1RotationAngle = 25.0f;
        this.detectingArc2RotationAngle = 25.0f;
        p pVar = new p(this);
        this.updater = pVar;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{-1.0f, 1.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(this.detectingAnimationSpeed);
        ofFloat.addUpdateListener(pVar);
        ofFloat.addListener(new SNSLivenessFaceView$recognizingAnimationDirect$lambda4$$inlined$doOnEnd$1(this));
        this.recognizingAnimationDirect = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, -1.0f});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setDuration(this.detectingAnimationSpeed);
        ofFloat2.addUpdateListener(pVar);
        ofFloat2.addListener(new SNSLivenessFaceView$recognizingAnimationInDirect$lambda6$$inlined$doOnEnd$1(this));
        this.recognizingAnimationInDirect = ofFloat2;
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 4.0f});
        ofFloat3.setDuration(this.detectingAnimationSpeed);
        ofFloat3.setInterpolator(new LinearInterpolator());
        ofFloat3.addUpdateListener(new q(this));
        ofFloat3.setRepeatCount(-1);
        this.progressRotationAnimator = ofFloat3;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.mFaceProgressMarkerPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        this.mFaceDetectionCirclePaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mFaceCutCirclePaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mFaceScanCompletePaint = paint4;
        Paint paint5 = new Paint(1);
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        this.mFaceRecognizingPaint = paint5;
        Paint paint6 = new Paint(1);
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setColor(-65281);
        paint6.setStrokeWidth((float) i.a(2));
        this.mFaceRectanglePaint = paint6;
        this.progressRange = h.f56844f.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSLivenessFaceView, i11, i12);
        this.mColorFaceMarkerActive = com.sumsub.sns.core.common.b.a(obtainStyledAttributes, R.styleable.SNSLivenessFaceView_sns_ProofaceMarkerActiveColor, -65281);
        this.mColorFaceMarkerInActive = com.sumsub.sns.core.common.b.a(obtainStyledAttributes, R.styleable.SNSLivenessFaceView_sns_ProofaceMarkerInActiveColor, -65281);
        paint.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.SNSLivenessFaceView_sns_ProofaceMarkerStroke, 0.0f));
        paint2.setStrokeWidth(paint.getStrokeWidth());
        this.mMarkerSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSLivenessFaceView_sns_ProofaceMarkerSize, 0);
        this.mMarkerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSLivenessFaceView_sns_ProofaceMarkerPadding, 0);
        this.mColorOverlay = com.sumsub.sns.core.common.b.a(obtainStyledAttributes, R.styleable.SNSLivenessFaceView_sns_ProofaceOverlayColor, -1);
        paint4.setColor(com.sumsub.sns.core.common.b.a(obtainStyledAttributes, R.styleable.SNSLivenessFaceView_sns_ProofaceCompleteOverlayColor, -1));
        paint5.setColor(com.sumsub.sns.core.common.b.a(obtainStyledAttributes, R.styleable.SNSLivenessFaceView_sns_ProofaceRecognizingColor, -1));
        paint2.setColor(paint5.getColor());
        paint5.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.SNSLivenessFaceView_sns_ProofaceRecognizingStroke, 0.0f));
        this.detectingAnimationSpeed = (long) obtainStyledAttributes.getInt(R.styleable.SNSLivenessFaceView_sns_ProofaceRecognizingAnimationSpeed, 1000);
        int i13 = R.styleable.SNSLivenessFaceView_android_padding;
        if (obtainStyledAttributes.hasValue(i13)) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i13, 0);
            setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        } else {
            setPadding(obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSLivenessFaceView_android_paddingLeft, getPaddingLeft()), obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSLivenessFaceView_android_paddingTop, getPaddingTop()), obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSLivenessFaceView_android_paddingRight, getPaddingRight()), obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSLivenessFaceView_android_paddingBottom, getPaddingBottom()));
        }
        obtainStyledAttributes.recycle();
        paint.setColor(this.mColorFaceMarkerActive);
        a aVar = a.f31095a;
        SNSColorElement sNSColorElement = SNSColorElement.BACKGROUND_COMMON;
        d a14 = aVar.a();
        if (!(a14 == null || (a13 = aVar.a(a14, sNSColorElement, aVar.a((View) this))) == null)) {
            setOverlayColor(a13.intValue());
        }
        SNSColorElement sNSColorElement2 = SNSColorElement.CONTENT_SUCCESS;
        d a15 = aVar.a();
        if (!(a15 == null || (a12 = aVar.a(a15, sNSColorElement2, aVar.a((View) this))) == null)) {
            int intValue = a12.intValue();
            setFaceRecognizedColor(intValue);
            setFaceMarkerActiveColor(intValue);
        }
        SNSColorElement sNSColorElement3 = SNSColorElement.CONTENT_WEAK;
        d a16 = aVar.a();
        if (a16 != null && (a11 = aVar.a(a16, sNSColorElement3, aVar.a((View) this))) != null) {
            setFaceMarkerInActiveColor(a11.intValue());
        }
    }
}
