package com.huochat.community.util.glideformation;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;
import n3.b;

public class RoundedCornersTransformation extends BitmapTransformation {
    private static final String ID = "glideformation.RoundedCornersTransformation.1";
    private static final int VERSION = 1;
    private CornerType cornerType;
    private int diameter;
    private int margin;
    private int radius;

    /* renamed from: com.huochat.community.util.glideformation.RoundedCornersTransformation$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType[] r0 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType = r0
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.ALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.TOP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.LEFT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.RIGHT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.OTHER_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.OTHER_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.OTHER_BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.OTHER_BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.huochat.community.util.glideformation.RoundedCornersTransformation$CornerType r1 = com.huochat.community.util.glideformation.RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.glideformation.RoundedCornersTransformation.AnonymousClass1.<clinit>():void");
        }
    }

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(int i11, int i12) {
        this(i11, i12, CornerType.ALL);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.margin;
        int i12 = this.diameter;
        RectF rectF = new RectF((float) i11, f12 - ((float) i12), (float) (i11 + i12), f12);
        int i13 = this.radius;
        canvas.drawRoundRect(rectF, (float) i13, (float) i13, paint);
        int i14 = this.margin;
        canvas.drawRect(new RectF((float) i14, (float) i14, (float) (i14 + this.diameter), f12 - ((float) this.radius)), paint);
        int i15 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i15), (float) i15, f11, f12), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.diameter;
        RectF rectF = new RectF(f11 - ((float) i11), f12 - ((float) i11), f11, f12);
        int i12 = this.radius;
        canvas.drawRoundRect(rectF, (float) i12, (float) i12, paint);
        int i13 = this.margin;
        canvas.drawRect(new RectF((float) i13, (float) i13, f11 - ((float) this.radius), f12), paint);
        int i14 = this.radius;
        canvas.drawRect(new RectF(f11 - ((float) i14), (float) this.margin, f11, f12 - ((float) i14)), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        RectF rectF = new RectF((float) this.margin, f12 - ((float) this.diameter), f11, f12);
        int i11 = this.radius;
        canvas.drawRoundRect(rectF, (float) i11, (float) i11, paint);
        int i12 = this.margin;
        canvas.drawRect(new RectF((float) i12, (float) i12, f11, f12 - ((float) this.radius)), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.margin;
        int i12 = this.diameter;
        RectF rectF = new RectF((float) i11, (float) i11, (float) (i11 + i12), (float) (i11 + i12));
        int i13 = this.radius;
        canvas.drawRoundRect(rectF, (float) i13, (float) i13, paint);
        int i14 = this.diameter;
        RectF rectF2 = new RectF(f11 - ((float) i14), f12 - ((float) i14), f11, f12);
        int i15 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i15, (float) i15, paint);
        int i16 = this.margin;
        canvas.drawRect(new RectF((float) i16, (float) (i16 + this.radius), f11 - ((float) this.diameter), f12), paint);
        int i17 = this.margin;
        canvas.drawRect(new RectF((float) (this.diameter + i17), (float) i17, f11, f12 - ((float) this.radius)), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.diameter;
        int i12 = this.margin;
        RectF rectF = new RectF(f11 - ((float) i11), (float) i12, f11, (float) (i12 + i11));
        int i13 = this.radius;
        canvas.drawRoundRect(rectF, (float) i13, (float) i13, paint);
        int i14 = this.margin;
        int i15 = this.diameter;
        RectF rectF2 = new RectF((float) i14, f12 - ((float) i15), (float) (i14 + i15), f12);
        int i16 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i16, (float) i16, paint);
        int i17 = this.margin;
        int i18 = this.radius;
        canvas.drawRect(new RectF((float) i17, (float) i17, f11 - ((float) i18), f12 - ((float) i18)), paint);
        int i19 = this.margin;
        int i21 = this.radius;
        canvas.drawRect(new RectF((float) (i19 + i21), (float) (i19 + i21), f11, f12), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.margin;
        RectF rectF = new RectF((float) i11, (float) i11, (float) (i11 + this.diameter), f12);
        int i12 = this.radius;
        canvas.drawRoundRect(rectF, (float) i12, (float) i12, paint);
        int i13 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i13), (float) i13, f11, f12), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.margin;
        RectF rectF = new RectF((float) i11, (float) i11, f11, (float) (i11 + this.diameter));
        int i12 = this.radius;
        canvas.drawRoundRect(rectF, (float) i12, (float) i12, paint);
        RectF rectF2 = new RectF(f11 - ((float) this.diameter), (float) this.margin, f11, f12);
        int i13 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i13, (float) i13, paint);
        int i14 = this.margin;
        int i15 = this.radius;
        canvas.drawRect(new RectF((float) i14, (float) (i14 + i15), f11 - ((float) i15), f12), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.margin;
        RectF rectF = new RectF((float) i11, (float) i11, f11, (float) (i11 + this.diameter));
        int i12 = this.radius;
        canvas.drawRoundRect(rectF, (float) i12, (float) i12, paint);
        int i13 = this.margin;
        RectF rectF2 = new RectF((float) i13, (float) i13, (float) (i13 + this.diameter), f12);
        int i14 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i14, (float) i14, paint);
        int i15 = this.margin;
        int i16 = this.radius;
        canvas.drawRect(new RectF((float) (i15 + i16), (float) (i15 + i16), f11, f12), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        RectF rectF = new RectF((float) this.margin, f12 - ((float) this.diameter), f11, f12);
        int i11 = this.radius;
        canvas.drawRoundRect(rectF, (float) i11, (float) i11, paint);
        RectF rectF2 = new RectF(f11 - ((float) this.diameter), (float) this.margin, f11, f12);
        int i12 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i12, (float) i12, paint);
        int i13 = this.margin;
        int i14 = this.radius;
        canvas.drawRect(new RectF((float) i13, (float) i13, f11 - ((float) i14), f12 - ((float) i14)), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.margin;
        RectF rectF = new RectF((float) i11, (float) i11, (float) (i11 + this.diameter), f12);
        int i12 = this.radius;
        canvas.drawRoundRect(rectF, (float) i12, (float) i12, paint);
        RectF rectF2 = new RectF((float) this.margin, f12 - ((float) this.diameter), f11, f12);
        int i13 = this.radius;
        canvas.drawRoundRect(rectF2, (float) i13, (float) i13, paint);
        int i14 = this.margin;
        int i15 = this.radius;
        canvas.drawRect(new RectF((float) (i14 + i15), (float) i14, f11, f12 - ((float) i15)), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        RectF rectF = new RectF(f11 - ((float) this.diameter), (float) this.margin, f11, f12);
        int i11 = this.radius;
        canvas.drawRoundRect(rectF, (float) i11, (float) i11, paint);
        int i12 = this.margin;
        canvas.drawRect(new RectF((float) i12, (float) i12, f11 - ((float) this.radius), f12), paint);
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.margin;
        float f13 = f11 - ((float) i11);
        float f14 = f12 - ((float) i11);
        switch (AnonymousClass1.$SwitchMap$com$huochat$community$util$glideformation$RoundedCornersTransformation$CornerType[this.cornerType.ordinal()]) {
            case 1:
                int i12 = this.margin;
                RectF rectF = new RectF((float) i12, (float) i12, f13, f14);
                int i13 = this.radius;
                canvas.drawRoundRect(rectF, (float) i13, (float) i13, paint);
                return;
            case 2:
                drawTopLeftRoundRect(canvas, paint, f13, f14);
                return;
            case 3:
                drawTopRightRoundRect(canvas, paint, f13, f14);
                return;
            case 4:
                drawBottomLeftRoundRect(canvas, paint, f13, f14);
                return;
            case 5:
                drawBottomRightRoundRect(canvas, paint, f13, f14);
                return;
            case 6:
                drawTopRoundRect(canvas, paint, f13, f14);
                return;
            case 7:
                drawBottomRoundRect(canvas, paint, f13, f14);
                return;
            case 8:
                drawLeftRoundRect(canvas, paint, f13, f14);
                return;
            case 9:
                drawRightRoundRect(canvas, paint, f13, f14);
                return;
            case 10:
                drawOtherTopLeftRoundRect(canvas, paint, f13, f14);
                return;
            case 11:
                drawOtherTopRightRoundRect(canvas, paint, f13, f14);
                return;
            case 12:
                drawOtherBottomLeftRoundRect(canvas, paint, f13, f14);
                return;
            case 13:
                drawOtherBottomRightRoundRect(canvas, paint, f13, f14);
                return;
            case 14:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f13, f14);
                return;
            case 15:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f13, f14);
                return;
            default:
                int i14 = this.margin;
                RectF rectF2 = new RectF((float) i14, (float) i14, f13, f14);
                int i15 = this.radius;
                canvas.drawRoundRect(rectF2, (float) i15, (float) i15, paint);
                return;
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.margin;
        int i12 = this.diameter;
        RectF rectF = new RectF((float) i11, (float) i11, (float) (i11 + i12), (float) (i11 + i12));
        int i13 = this.radius;
        canvas.drawRoundRect(rectF, (float) i13, (float) i13, paint);
        int i14 = this.margin;
        int i15 = this.radius;
        canvas.drawRect(new RectF((float) i14, (float) (i14 + i15), (float) (i14 + i15), f12), paint);
        int i16 = this.margin;
        canvas.drawRect(new RectF((float) (this.radius + i16), (float) i16, f11, f12), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.diameter;
        int i12 = this.margin;
        RectF rectF = new RectF(f11 - ((float) i11), (float) i12, f11, (float) (i12 + i11));
        int i13 = this.radius;
        canvas.drawRoundRect(rectF, (float) i13, (float) i13, paint);
        int i14 = this.margin;
        canvas.drawRect(new RectF((float) i14, (float) i14, f11 - ((float) this.radius), f12), paint);
        int i15 = this.radius;
        canvas.drawRect(new RectF(f11 - ((float) i15), (float) (this.margin + i15), f11, f12), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        int i11 = this.margin;
        RectF rectF = new RectF((float) i11, (float) i11, f11, (float) (i11 + this.diameter));
        int i12 = this.radius;
        canvas.drawRoundRect(rectF, (float) i12, (float) i12, paint);
        int i13 = this.margin;
        canvas.drawRect(new RectF((float) i13, (float) (i13 + this.radius), f11, f12), paint);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            return roundedCornersTransformation.radius == this.radius && roundedCornersTransformation.diameter == this.diameter && roundedCornersTransformation.margin == this.margin && roundedCornersTransformation.cornerType == this.cornerType;
        }
    }

    public int hashCode() {
        return -838078049 + (this.radius * 10000) + (this.diameter * 1000) + (this.margin * 100) + (this.cornerType.ordinal() * 10);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.radius + ", margin=" + this.margin + ", diameter=" + this.diameter + ", cornerType=" + this.cornerType.name() + ")";
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap d11 = eVar.d(width, height, Bitmap.Config.ARGB_8888);
        d11.setHasAlpha(true);
        Canvas canvas = new Canvas(d11);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        drawRoundRect(canvas, paint, (float) width, (float) height);
        return d11;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.diameter + this.margin + this.cornerType).getBytes(b.f66506a));
    }

    public RoundedCornersTransformation(int i11, int i12, CornerType cornerType2) {
        this.radius = i11;
        this.diameter = i11 * 2;
        this.margin = i12;
        this.cornerType = cornerType2;
    }
}
