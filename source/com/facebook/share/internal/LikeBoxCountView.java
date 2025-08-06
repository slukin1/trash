package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.R;

@Deprecated
public class LikeBoxCountView extends FrameLayout {
    private int additionalTextPadding;
    private Paint borderPaint;
    private float borderRadius;
    private float caretHeight;
    private LikeBoxCountViewCaretPosition caretPosition = LikeBoxCountViewCaretPosition.LEFT;
    private float caretWidth;
    private TextView likeCountLabel;
    private int textPadding;

    /* renamed from: com.facebook.share.internal.LikeBoxCountView$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.share.internal.LikeBoxCountView$LikeBoxCountViewCaretPosition[] r0 = com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition = r0
                com.facebook.share.internal.LikeBoxCountView$LikeBoxCountViewCaretPosition r1 = com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.share.internal.LikeBoxCountView$LikeBoxCountViewCaretPosition r1 = com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.share.internal.LikeBoxCountView$LikeBoxCountViewCaretPosition r1 = com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.share.internal.LikeBoxCountView$LikeBoxCountViewCaretPosition r1 = com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.LikeBoxCountView.AnonymousClass1.<clinit>():void");
        }
    }

    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    @Deprecated
    public LikeBoxCountView(Context context) {
        super(context);
        initialize(context);
    }

    private void drawBorder(Canvas canvas, float f11, float f12, float f13, float f14) {
        Path path = new Path();
        float f15 = this.borderRadius * 2.0f;
        float f16 = f11 + f15;
        float f17 = f12 + f15;
        path.addArc(new RectF(f11, f12, f16, f17), -180.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.TOP) {
            float f18 = f13 - f11;
            path.lineTo(((f18 - this.caretWidth) / 2.0f) + f11, f12);
            path.lineTo((f18 / 2.0f) + f11, f12 - this.caretHeight);
            path.lineTo(((f18 + this.caretWidth) / 2.0f) + f11, f12);
        }
        path.lineTo(f13 - this.borderRadius, f12);
        float f19 = f13 - f15;
        path.addArc(new RectF(f19, f12, f13, f17), -90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.RIGHT) {
            float f21 = f14 - f12;
            path.lineTo(f13, ((f21 - this.caretWidth) / 2.0f) + f12);
            path.lineTo(this.caretHeight + f13, (f21 / 2.0f) + f12);
            path.lineTo(f13, ((f21 + this.caretWidth) / 2.0f) + f12);
        }
        path.lineTo(f13, f14 - this.borderRadius);
        float f22 = f14 - f15;
        path.addArc(new RectF(f19, f22, f13, f14), 0.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.BOTTOM) {
            float f23 = f13 - f11;
            path.lineTo(((this.caretWidth + f23) / 2.0f) + f11, f14);
            path.lineTo((f23 / 2.0f) + f11, this.caretHeight + f14);
            path.lineTo(((f23 - this.caretWidth) / 2.0f) + f11, f14);
        }
        path.lineTo(this.borderRadius + f11, f14);
        path.addArc(new RectF(f11, f22, f16, f14), 90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.LEFT) {
            float f24 = f14 - f12;
            path.lineTo(f11, ((this.caretWidth + f24) / 2.0f) + f12);
            path.lineTo(f11 - this.caretHeight, (f24 / 2.0f) + f12);
            path.lineTo(f11, ((f24 - this.caretWidth) / 2.0f) + f12);
        }
        path.lineTo(f11, f12 + this.borderRadius);
        canvas.drawPath(path, this.borderPaint);
    }

    private void initialize(Context context) {
        setWillNotDraw(false);
        this.caretHeight = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_height);
        this.caretWidth = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_width);
        this.borderRadius = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_radius);
        Paint paint = new Paint();
        this.borderPaint = paint;
        paint.setColor(getResources().getColor(R.color.com_facebook_likeboxcountview_border_color));
        this.borderPaint.setStrokeWidth(getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_width));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        initializeLikeCountLabel(context);
        addView(this.likeCountLabel);
        setCaretPosition(this.caretPosition);
    }

    private void initializeLikeCountLabel(Context context) {
        this.likeCountLabel = new TextView(context);
        this.likeCountLabel.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.likeCountLabel.setGravity(17);
        this.likeCountLabel.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeboxcountview_text_size));
        this.likeCountLabel.setTextColor(getResources().getColor(R.color.com_facebook_likeboxcountview_text_color));
        this.textPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_text_padding);
        this.additionalTextPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_caret_height);
    }

    private void setAdditionalTextPadding(int i11, int i12, int i13, int i14) {
        TextView textView = this.likeCountLabel;
        int i15 = this.textPadding;
        textView.setPadding(i11 + i15, i12 + i15, i13 + i15, i15 + i14);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int i11 = AnonymousClass1.$SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[this.caretPosition.ordinal()];
        if (i11 == 1) {
            paddingLeft = (int) (((float) paddingLeft) + this.caretHeight);
        } else if (i11 == 2) {
            paddingTop = (int) (((float) paddingTop) + this.caretHeight);
        } else if (i11 == 3) {
            width = (int) (((float) width) - this.caretHeight);
        } else if (i11 == 4) {
            height = (int) (((float) height) - this.caretHeight);
        }
        drawBorder(canvas, (float) paddingLeft, (float) paddingTop, (float) width, (float) height);
    }

    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.caretPosition = likeBoxCountViewCaretPosition;
        int i11 = AnonymousClass1.$SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[likeBoxCountViewCaretPosition.ordinal()];
        if (i11 == 1) {
            setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
        } else if (i11 == 2) {
            setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
        } else if (i11 == 3) {
            setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
        } else if (i11 == 4) {
            setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
        }
    }

    @Deprecated
    public void setText(String str) {
        this.likeCountLabel.setText(str);
    }
}
