package jumio.liveness;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import com.jumio.core.MobileContext;
import com.jumio.core.R;
import com.jumio.core.overlay.BaseLivenessOverlay;

public final class l extends BaseLivenessOverlay {

    /* renamed from: a  reason: collision with root package name */
    public final int f56488a;

    /* renamed from: b  reason: collision with root package name */
    public final int f56489b;

    public l(MobileContext mobileContext) {
        super(mobileContext);
        new RectF();
        new RectF();
        Integer num = getStyleMap().get(Integer.valueOf(R.attr.jumio_scanOverlay_livenessStrokeAnimation));
        this.f56488a = num != null ? num.intValue() : R.color.jumio_green_3;
        Integer num2 = getStyleMap().get(Integer.valueOf(R.attr.jumio_scanOverlay_livenessStrokeAnimationCompleted));
        this.f56489b = num2 != null ? num2.intValue() : R.color.jumio_green_6;
        Paint paint = new Paint(1);
        paint.setStrokeJoin(Paint.Join.MITER);
        Integer num3 = getStyleMap().get(Integer.valueOf(R.attr.jumio_scanOverlay));
        paint.setColor(num3 != null ? num3.intValue() : -65536);
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        paint2.setStrokeJoin(Paint.Join.MITER);
        paint2.setColor(-65536);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint(1);
        paint3.setStrokeJoin(Paint.Join.MITER);
        paint3.setColor(-16711936);
        paint3.setStyle(Paint.Style.STROKE);
    }

    public final void a() {
        if (!isHoldStill()) {
            setHoldStill(true);
            for (ImageView drawable : getOverlayImageViewList()) {
                Drawable findDrawableByLayerId = ((LayerDrawable) drawable.getDrawable()).findDrawableByLayerId(R.id.liveness_overlay_part_main);
                findDrawableByLayerId.setTint(this.f56488a);
                ((AnimatedVectorDrawable) findDrawableByLayerId).start();
            }
            changeColorOfOverlayCircle(this.f56489b, 500);
            changeColorOfOverlayCircle(this.f56488a, 660);
            changeColorOfOverlayCircle(this.f56489b, 830);
        }
    }

    public final void calculate(Rect rect, Rect rect2) {
        super.calculate(rect, rect2);
    }

    public final void doDraw(Canvas canvas) {
    }

    /* JADX WARNING: type inference failed for: r4v10, types: [android.graphics.RectF] */
    /* JADX WARNING: type inference failed for: r4v13, types: [android.graphics.RectF] */
    /* JADX WARNING: type inference failed for: r4v15, types: [android.graphics.RectF] */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f4, code lost:
        if (r0.intValue() != r1) goto L_0x00f7;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void update(com.jumio.core.extraction.ExtractionUpdateInterface<?> r8) {
        /*
            r7 = this;
            super.update(r8)
            java.lang.Integer r0 = r8.getState()
            com.jumio.core.extraction.liveness.extraction.LivenessUpdateState r1 = com.jumio.core.extraction.liveness.extraction.LivenessUpdateState.INSTANCE
            int r2 = r1.getFaceRoiRect()
            java.lang.String r3 = "LivenessOverlay"
            r4 = 0
            if (r0 != 0) goto L_0x0013
            goto L_0x0041
        L_0x0013:
            int r5 = r0.intValue()
            if (r5 != r2) goto L_0x0041
            java.lang.Object r8 = r8.getData()
            boolean r0 = r8 instanceof android.graphics.RectF
            if (r0 == 0) goto L_0x0024
            r4 = r8
            android.graphics.RectF r4 = (android.graphics.RectF) r4
        L_0x0024:
            if (r4 != 0) goto L_0x002b
            android.graphics.RectF r4 = new android.graphics.RectF
            r4.<init>()
        L_0x002b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Current corners are "
            r8.append(r0)
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            com.jumio.commons.log.Log.d((java.lang.String) r3, (java.lang.String) r8)
            goto L_0x0111
        L_0x0041:
            int r2 = r1.getFaceCenterArea()
            if (r0 != 0) goto L_0x0048
            goto L_0x0062
        L_0x0048:
            int r5 = r0.intValue()
            if (r5 != r2) goto L_0x0062
            java.lang.Object r8 = r8.getData()
            boolean r0 = r8 instanceof android.graphics.RectF
            if (r0 == 0) goto L_0x0059
            r4 = r8
            android.graphics.RectF r4 = (android.graphics.RectF) r4
        L_0x0059:
            if (r4 != 0) goto L_0x0111
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            goto L_0x0111
        L_0x0062:
            int r2 = com.jumio.core.extraction.ExtractionUpdateState.resetOverlay
            if (r0 != 0) goto L_0x0067
            goto L_0x0094
        L_0x0067:
            int r5 = r0.intValue()
            if (r5 != r2) goto L_0x0094
            r7.resetHoldStillAnimation()
            java.lang.Object r8 = r8.getData()
            boolean r0 = r8 instanceof java.lang.Float
            if (r0 == 0) goto L_0x007b
            r4 = r8
            java.lang.Float r4 = (java.lang.Float) r4
        L_0x007b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Resizing overlay to "
            r8.append(r0)
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            com.jumio.commons.log.Log.d((java.lang.String) r3, (java.lang.String) r8)
            r7.resizeOverlay(r4, r4)
            goto L_0x0111
        L_0x0094:
            int r2 = com.jumio.core.extraction.ExtractionUpdateState.holdStill
            if (r0 != 0) goto L_0x0099
            goto L_0x00a4
        L_0x0099:
            int r4 = r0.intValue()
            if (r4 != r2) goto L_0x00a4
            r7.a()
            goto L_0x0111
        L_0x00a4:
            int r2 = r1.getLevelEyesAndDevice()
            r4 = 0
            r5 = 1
            if (r0 != 0) goto L_0x00ad
            goto L_0x00b4
        L_0x00ad:
            int r6 = r0.intValue()
            if (r6 != r2) goto L_0x00b4
            goto L_0x00bf
        L_0x00b4:
            int r2 = com.jumio.core.extraction.ExtractionUpdateState.fallbackRequired
            if (r0 != 0) goto L_0x00b9
            goto L_0x00c1
        L_0x00b9:
            int r6 = r0.intValue()
            if (r6 != r2) goto L_0x00c1
        L_0x00bf:
            r2 = r5
            goto L_0x00c2
        L_0x00c1:
            r2 = r4
        L_0x00c2:
            if (r2 == 0) goto L_0x00c8
            r7.resetHoldStillAnimation()
            goto L_0x0111
        L_0x00c8:
            int r2 = r1.getCenterFace()
            if (r0 != 0) goto L_0x00cf
            goto L_0x00d6
        L_0x00cf:
            int r6 = r0.intValue()
            if (r6 != r2) goto L_0x00d6
            goto L_0x00e3
        L_0x00d6:
            int r2 = r1.getMoveFaceCloser()
            if (r0 != 0) goto L_0x00dd
            goto L_0x00e5
        L_0x00dd:
            int r6 = r0.intValue()
            if (r6 != r2) goto L_0x00e5
        L_0x00e3:
            r2 = r5
            goto L_0x00e6
        L_0x00e5:
            r2 = r4
        L_0x00e6:
            if (r2 == 0) goto L_0x00e9
            goto L_0x00f6
        L_0x00e9:
            int r1 = r1.getFaceTooClose()
            if (r0 != 0) goto L_0x00f0
            goto L_0x00f7
        L_0x00f0:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x00f7
        L_0x00f6:
            r4 = r5
        L_0x00f7:
            if (r4 == 0) goto L_0x00fd
            r7.resetHoldStillAnimation()
            goto L_0x0111
        L_0x00fd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Skipped handling for update "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            com.jumio.commons.log.Log.d((java.lang.String) r3, (java.lang.String) r8)
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.liveness.l.update(com.jumio.core.extraction.ExtractionUpdateInterface):void");
    }
}
