package com.huobi.view.showcaseview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import android.text.style.TextAppearanceSpan;
import pro.huobi.R;

class TextDrawer {
    private static final int INDEX_TEXT_START_X = 0;
    private static final int INDEX_TEXT_START_Y = 1;
    private static final int INDEX_TEXT_WIDTH = 2;
    private final float actionBarOffset;
    private final Context context;
    private int forcedTextPosition = -1;
    private boolean hasRecalculated;
    private float[] mBestTextPosition = new float[3];
    private final float padding;
    private Layout.Alignment textAlignment;
    private DynamicLayout textLayout;
    private final TextPaint textPaint;
    private MetricAffectingSpan textSpan;
    private SpannableString textString;
    private Layout.Alignment titleAlignment;
    private DynamicLayout titleLayout;
    private final TextPaint titlePaint;
    private MetricAffectingSpan titleSpan;
    private SpannableString titleString;

    public static class NoOpSpan extends MetricAffectingSpan {
        private NoOpSpan() {
        }

        public void updateDrawState(TextPaint textPaint) {
        }

        public void updateMeasureState(TextPaint textPaint) {
        }
    }

    public TextDrawer(Resources resources, Context context2) {
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        this.textAlignment = alignment;
        this.titleAlignment = alignment;
        this.padding = resources.getDimension(R.dimen.dimen_24);
        this.actionBarOffset = resources.getDimension(R.dimen.dimen_66);
        this.context = context2;
        TextPaint textPaint2 = new TextPaint();
        this.titlePaint = textPaint2;
        textPaint2.setAntiAlias(true);
        TextPaint textPaint3 = new TextPaint();
        this.textPaint = textPaint3;
        textPaint3.setAntiAlias(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008c, code lost:
        if (r7 != 3) goto L_0x00b6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void calculateTextPosition(int r11, int r12, boolean r13, android.graphics.Rect r14) {
        /*
            r10 = this;
            r0 = 4
            int[] r1 = new int[r0]
            int r2 = r14.left
            int r2 = r2 * r12
            r3 = 0
            r1[r3] = r2
            int r2 = r14.top
            int r2 = r2 * r11
            r4 = 1
            r1[r4] = r2
            int r2 = r14.right
            int r2 = r11 - r2
            int r2 = r2 * r12
            r5 = 2
            r1[r5] = r2
            int r2 = r14.bottom
            int r2 = r12 - r2
            int r2 = r2 * r11
            r6 = 3
            r1[r6] = r2
            r7 = r3
            r2 = r4
        L_0x0021:
            if (r2 >= r0) goto L_0x002d
            r8 = r1[r2]
            r9 = r1[r7]
            if (r8 <= r9) goto L_0x002a
            r7 = r2
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x0021
        L_0x002d:
            int r1 = r10.forcedTextPosition
            r2 = -1
            if (r1 == r2) goto L_0x0033
            r7 = r1
        L_0x0033:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r7 == 0) goto L_0x0075
            if (r7 == r4) goto L_0x0064
            if (r7 == r5) goto L_0x0050
            if (r7 == r6) goto L_0x003e
            goto L_0x0084
        L_0x003e:
            float[] r2 = r10.mBestTextPosition
            float r8 = r10.padding
            r2[r3] = r8
            int r14 = r14.bottom
            float r14 = (float) r14
            float r14 = r14 + r8
            r2[r4] = r14
            float r14 = (float) r11
            float r8 = r8 * r1
            float r14 = r14 - r8
            r2[r5] = r14
            goto L_0x0084
        L_0x0050:
            float[] r2 = r10.mBestTextPosition
            int r14 = r14.right
            float r8 = (float) r14
            float r9 = r10.padding
            float r8 = r8 + r9
            r2[r3] = r8
            r2[r4] = r9
            int r14 = r11 - r14
            float r14 = (float) r14
            float r9 = r9 * r1
            float r14 = r14 - r9
            r2[r5] = r14
            goto L_0x0084
        L_0x0064:
            float[] r14 = r10.mBestTextPosition
            float r2 = r10.padding
            r14[r3] = r2
            float r8 = r10.actionBarOffset
            float r8 = r8 + r2
            r14[r4] = r8
            float r8 = (float) r11
            float r2 = r2 * r1
            float r8 = r8 - r2
            r14[r5] = r8
            goto L_0x0084
        L_0x0075:
            float[] r2 = r10.mBestTextPosition
            float r8 = r10.padding
            r2[r3] = r8
            r2[r4] = r8
            int r14 = r14.left
            float r14 = (float) r14
            float r8 = r8 * r1
            float r14 = r14 - r8
            r2[r5] = r14
        L_0x0084:
            if (r13 == 0) goto L_0x00a8
            if (r7 == 0) goto L_0x009e
            if (r7 == r4) goto L_0x008f
            if (r7 == r5) goto L_0x009e
            if (r7 == r6) goto L_0x008f
            goto L_0x00b6
        L_0x008f:
            float[] r12 = r10.mBestTextPosition
            r13 = r12[r5]
            float r13 = r13 / r1
            r12[r5] = r13
            r13 = r12[r3]
            int r11 = r11 / r0
            float r11 = (float) r11
            float r13 = r13 + r11
            r12[r3] = r13
            goto L_0x00b6
        L_0x009e:
            float[] r11 = r10.mBestTextPosition
            r13 = r11[r4]
            int r12 = r12 / r0
            float r12 = (float) r12
            float r13 = r13 + r12
            r11[r4] = r13
            goto L_0x00b6
        L_0x00a8:
            if (r7 == 0) goto L_0x00ad
            if (r7 == r5) goto L_0x00ad
            goto L_0x00b6
        L_0x00ad:
            float[] r11 = r10.mBestTextPosition
            r12 = r11[r4]
            float r13 = r10.actionBarOffset
            float r12 = r12 + r13
            r11[r4] = r12
        L_0x00b6:
            r10.hasRecalculated = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.showcaseview.TextDrawer.calculateTextPosition(int, int, boolean, android.graphics.Rect):void");
    }

    public void draw(Canvas canvas) {
        if (shouldDrawText()) {
            float[] bestTextPosition = getBestTextPosition();
            int max = Math.max(0, (int) this.mBestTextPosition[2]);
            if (!TextUtils.isEmpty(this.titleString)) {
                canvas.save();
                if (this.hasRecalculated) {
                    this.titleLayout = new DynamicLayout(this.titleString, this.titlePaint, max, this.titleAlignment, 1.0f, 1.0f, true);
                }
                if (this.titleLayout != null) {
                    canvas.translate(bestTextPosition[0], bestTextPosition[1]);
                    this.titleLayout.draw(canvas);
                    canvas.restore();
                }
            }
            if (!TextUtils.isEmpty(this.textString)) {
                canvas.save();
                if (this.hasRecalculated) {
                    this.textLayout = new DynamicLayout(this.textString, this.textPaint, max, this.textAlignment, 1.2f, 1.0f, true);
                }
                DynamicLayout dynamicLayout = this.titleLayout;
                float height = dynamicLayout != null ? (float) dynamicLayout.getHeight() : 0.0f;
                if (this.textLayout != null) {
                    canvas.translate(bestTextPosition[0], bestTextPosition[1] + height);
                    this.textLayout.draw(canvas);
                    canvas.restore();
                }
            }
        }
        this.hasRecalculated = false;
    }

    public void forceTextPosition(int i11) {
        if (i11 > 3 || i11 < -1) {
            throw new IllegalArgumentException("ShowcaseView text was forced with an invalid position");
        }
        this.forcedTextPosition = i11;
    }

    public float[] getBestTextPosition() {
        return this.mBestTextPosition;
    }

    public void setContentPaint(TextPaint textPaint2) {
        this.textPaint.set(textPaint2);
        SpannableString spannableString = this.textString;
        if (spannableString != null) {
            spannableString.removeSpan(this.textSpan);
        }
        this.textSpan = new NoOpSpan();
        setContentText(this.textString);
    }

    public void setContentText(CharSequence charSequence) {
        if (charSequence != null) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(this.textSpan, 0, spannableString.length(), 0);
            this.textString = spannableString;
            this.hasRecalculated = true;
        }
    }

    public void setContentTitle(CharSequence charSequence) {
        if (charSequence != null) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(this.titleSpan, 0, spannableString.length(), 0);
            this.titleString = spannableString;
            this.hasRecalculated = true;
        }
    }

    public void setDetailStyling(int i11) {
        this.textSpan = new TextAppearanceSpan(this.context, i11);
        setContentText(this.textString);
    }

    public void setDetailTextAlignment(Layout.Alignment alignment) {
        this.textAlignment = alignment;
    }

    public void setTitlePaint(TextPaint textPaint2) {
        this.titlePaint.set(textPaint2);
        SpannableString spannableString = this.titleString;
        if (spannableString != null) {
            spannableString.removeSpan(this.titleSpan);
        }
        this.titleSpan = new NoOpSpan();
        setContentTitle(this.titleString);
    }

    public void setTitleStyling(int i11) {
        this.titleSpan = new TextAppearanceSpan(this.context, i11);
        setContentTitle(this.titleString);
    }

    public void setTitleTextAlignment(Layout.Alignment alignment) {
        this.titleAlignment = alignment;
    }

    public boolean shouldDrawText() {
        return !TextUtils.isEmpty(this.titleString) || !TextUtils.isEmpty(this.textString);
    }
}
