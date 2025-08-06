package com.huobi.view.chart.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.huobi.view.chart.utils.FSize;
import com.huobi.view.chart.utils.Utils;
import com.huobi.view.chart.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class Legend extends ComponentBase {
    private List<Boolean> mCalculatedLabelBreakPoints;
    private List<FSize> mCalculatedLabelSizes;
    private List<FSize> mCalculatedLineSizes;
    private LegendDirection mDirection;
    private boolean mDrawInside;
    private LegendEntry[] mEntries;
    private LegendEntry[] mExtraEntries;
    private DashPathEffect mFormLineDashEffect;
    private float mFormLineWidth;
    private float mFormSize;
    private float mFormToTextSpace;
    private LegendHorizontalAlignment mHorizontalAlignment;
    private boolean mIsLegendCustom;
    private float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    private LegendOrientation mOrientation;
    private LegendForm mShape;
    private float mStackSpace;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private LegendVerticalAlignment mVerticalAlignment;
    private boolean mWordWrapEnabled;
    private float mXEntrySpace;
    private float mYEntrySpace;

    /* renamed from: com.huobi.view.chart.components.Legend$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.huobi.view.chart.components.Legend$LegendOrientation[] r0 = com.huobi.view.chart.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation = r0
                com.huobi.view.chart.components.Legend$LegendOrientation r1 = com.huobi.view.chart.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.view.chart.components.Legend$LegendOrientation r1 = com.huobi.view.chart.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.chart.components.Legend.AnonymousClass1.<clinit>():void");
        }
    }

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.mEntries = new LegendEntry[0];
        this.mIsLegendCustom = false;
        this.mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
        this.mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
        this.mOrientation = LegendOrientation.HORIZONTAL;
        this.mDrawInside = false;
        this.mDirection = LegendDirection.LEFT_TO_RIGHT;
        this.mShape = LegendForm.SQUARE;
        this.mFormSize = 8.0f;
        this.mFormLineWidth = 3.0f;
        this.mFormLineDashEffect = null;
        this.mXEntrySpace = 6.0f;
        this.mYEntrySpace = 0.0f;
        this.mFormToTextSpace = 5.0f;
        this.mStackSpace = 3.0f;
        this.mMaxSizePercent = 0.95f;
        this.mWordWrapEnabled = false;
        this.mCalculatedLabelSizes = new ArrayList(16);
        this.mCalculatedLabelBreakPoints = new ArrayList(16);
        this.mCalculatedLineSizes = new ArrayList(16);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(3.0f);
    }

    public void calculateDimensions(Paint paint, ViewPortHandler viewPortHandler) {
        float f11;
        int i11;
        float f12;
        float f13;
        float f14;
        float f15;
        Paint paint2 = paint;
        float convertDpToPixel = Utils.convertDpToPixel(this.mFormSize);
        float convertDpToPixel2 = Utils.convertDpToPixel(this.mStackSpace);
        float convertDpToPixel3 = Utils.convertDpToPixel(this.mFormToTextSpace);
        float convertDpToPixel4 = Utils.convertDpToPixel(this.mXEntrySpace);
        float convertDpToPixel5 = Utils.convertDpToPixel(this.mYEntrySpace);
        boolean z11 = this.mWordWrapEnabled;
        LegendEntry[] legendEntryArr = this.mEntries;
        int length = legendEntryArr.length;
        this.mTextWidthMax = getMaximumEntryWidth(paint);
        this.mTextHeightMax = getMaximumEntryHeight(paint);
        int i12 = AnonymousClass1.$SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation[this.mOrientation.ordinal()];
        if (i12 == 1) {
            float f16 = convertDpToPixel;
            float f17 = convertDpToPixel2;
            LegendEntry[] legendEntryArr2 = legendEntryArr;
            float lineHeight = Utils.getLineHeight(paint);
            float f18 = 0.0f;
            float f19 = 0.0f;
            float f21 = 0.0f;
            boolean z12 = false;
            for (int i13 = 0; i13 < length; i13++) {
                LegendEntry legendEntry = legendEntryArr2[i13];
                boolean z13 = legendEntry.form != LegendForm.NONE;
                if (Float.isNaN(legendEntry.formSize)) {
                    f11 = f16;
                } else {
                    f11 = Utils.convertDpToPixel(legendEntry.formSize);
                }
                String str = legendEntry.label;
                if (!z12) {
                    f21 = 0.0f;
                }
                if (z13) {
                    if (z12) {
                        f21 += f17;
                    }
                    f21 += f11;
                }
                if (str != null) {
                    if (z13 && !z12) {
                        f21 += convertDpToPixel3;
                    } else if (z12) {
                        f18 = Math.max(f18, f21);
                        f19 += lineHeight + convertDpToPixel5;
                        f21 = 0.0f;
                        z12 = false;
                    }
                    f21 += (float) Utils.calcTextWidth(paint2, str);
                    if (i13 < length - 1) {
                        f19 += lineHeight + convertDpToPixel5;
                    }
                } else {
                    f21 += f11;
                    if (i13 < length - 1) {
                        f21 += f17;
                    }
                    z12 = true;
                }
                f18 = Math.max(f18, f21);
            }
            this.mNeededWidth = f18;
            this.mNeededHeight = f19;
        } else if (i12 == 2) {
            float lineHeight2 = Utils.getLineHeight(paint);
            float lineSpacing = Utils.getLineSpacing(paint) + convertDpToPixel5;
            float contentWidth = viewPortHandler.contentWidth() * this.mMaxSizePercent;
            this.mCalculatedLabelBreakPoints.clear();
            this.mCalculatedLabelSizes.clear();
            this.mCalculatedLineSizes.clear();
            int i14 = 0;
            float f22 = 0.0f;
            int i15 = -1;
            float f23 = 0.0f;
            float f24 = 0.0f;
            while (i14 < length) {
                LegendEntry legendEntry2 = legendEntryArr[i14];
                float f25 = convertDpToPixel;
                float f26 = convertDpToPixel4;
                boolean z14 = legendEntry2.form != LegendForm.NONE;
                if (Float.isNaN(legendEntry2.formSize)) {
                    f12 = f25;
                } else {
                    f12 = Utils.convertDpToPixel(legendEntry2.formSize);
                }
                String str2 = legendEntry2.label;
                LegendEntry[] legendEntryArr3 = legendEntryArr;
                float f27 = lineSpacing;
                this.mCalculatedLabelBreakPoints.add(Boolean.FALSE);
                float f28 = i15 == -1 ? 0.0f : f23 + convertDpToPixel2;
                if (str2 != null) {
                    f13 = convertDpToPixel2;
                    this.mCalculatedLabelSizes.add(Utils.calcTextSize(paint2, str2));
                    f14 = f28 + (z14 ? convertDpToPixel3 + f12 : 0.0f) + this.mCalculatedLabelSizes.get(i14).width;
                } else {
                    f13 = convertDpToPixel2;
                    float f29 = f12;
                    this.mCalculatedLabelSizes.add(FSize.getInstance(0.0f, 0.0f));
                    f14 = f28 + (z14 ? f29 : 0.0f);
                    if (i15 == -1) {
                        i15 = i14;
                    }
                }
                if (str2 != null || i14 == length - 1) {
                    float f31 = f24;
                    int i16 = (f31 > 0.0f ? 1 : (f31 == 0.0f ? 0 : -1));
                    float f32 = i16 == 0 ? 0.0f : f26;
                    if (!z11 || i16 == 0 || contentWidth - f31 >= f32 + f14) {
                        f15 = f31 + f32 + f14;
                    } else {
                        this.mCalculatedLineSizes.add(FSize.getInstance(f31, lineHeight2));
                        float max = Math.max(f22, f31);
                        this.mCalculatedLabelBreakPoints.set(i15 > -1 ? i15 : i14, Boolean.TRUE);
                        f22 = max;
                        f15 = f14;
                    }
                    if (i14 == length - 1) {
                        this.mCalculatedLineSizes.add(FSize.getInstance(f15, lineHeight2));
                        f22 = Math.max(f22, f15);
                    }
                    f24 = f15;
                }
                if (str2 != null) {
                    i15 = -1;
                }
                i14++;
                convertDpToPixel2 = f13;
                convertDpToPixel = f25;
                convertDpToPixel4 = f26;
                lineSpacing = f27;
                f23 = f14;
                legendEntryArr = legendEntryArr3;
            }
            float f33 = lineSpacing;
            this.mNeededWidth = f22;
            float size = lineHeight2 * ((float) this.mCalculatedLineSizes.size());
            if (this.mCalculatedLineSizes.size() == 0) {
                i11 = 0;
            } else {
                i11 = this.mCalculatedLineSizes.size() - 1;
            }
            this.mNeededHeight = size + (f33 * ((float) i11));
        }
        this.mNeededHeight += this.mYOffset;
        this.mNeededWidth += this.mXOffset;
    }

    public List<Boolean> getCalculatedLabelBreakPoints() {
        return this.mCalculatedLabelBreakPoints;
    }

    public List<FSize> getCalculatedLabelSizes() {
        return this.mCalculatedLabelSizes;
    }

    public List<FSize> getCalculatedLineSizes() {
        return this.mCalculatedLineSizes;
    }

    public LegendDirection getDirection() {
        return this.mDirection;
    }

    public LegendEntry[] getEntries() {
        return this.mEntries;
    }

    public LegendEntry[] getExtraEntries() {
        return this.mExtraEntries;
    }

    public LegendForm getForm() {
        return this.mShape;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.mFormLineDashEffect;
    }

    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public float getFormToTextSpace() {
        return this.mFormToTextSpace;
    }

    public LegendHorizontalAlignment getHorizontalAlignment() {
        return this.mHorizontalAlignment;
    }

    public float getMaxSizePercent() {
        return this.mMaxSizePercent;
    }

    public float getMaximumEntryHeight(Paint paint) {
        float f11 = 0.0f;
        for (LegendEntry legendEntry : this.mEntries) {
            String str = legendEntry.label;
            if (str != null) {
                float calcTextHeight = (float) Utils.calcTextHeight(paint, str);
                if (calcTextHeight > f11) {
                    f11 = calcTextHeight;
                }
            }
        }
        return f11;
    }

    public float getMaximumEntryWidth(Paint paint) {
        float convertDpToPixel = Utils.convertDpToPixel(this.mFormToTextSpace);
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (LegendEntry legendEntry : this.mEntries) {
            float convertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? this.mFormSize : legendEntry.formSize);
            if (convertDpToPixel2 > f12) {
                f12 = convertDpToPixel2;
            }
            String str = legendEntry.label;
            if (str != null) {
                float calcTextWidth = (float) Utils.calcTextWidth(paint, str);
                if (calcTextWidth > f11) {
                    f11 = calcTextWidth;
                }
            }
        }
        return f11 + f12 + convertDpToPixel;
    }

    public LegendOrientation getOrientation() {
        return this.mOrientation;
    }

    public float getStackSpace() {
        return this.mStackSpace;
    }

    public LegendVerticalAlignment getVerticalAlignment() {
        return this.mVerticalAlignment;
    }

    public float getXEntrySpace() {
        return this.mXEntrySpace;
    }

    public float getYEntrySpace() {
        return this.mYEntrySpace;
    }

    public boolean isDrawInsideEnabled() {
        return this.mDrawInside;
    }

    public boolean isLegendCustom() {
        return this.mIsLegendCustom;
    }

    public boolean isWordWrapEnabled() {
        return this.mWordWrapEnabled;
    }

    public void resetCustom() {
        this.mIsLegendCustom = false;
    }

    public void setCustom(LegendEntry[] legendEntryArr) {
        this.mEntries = legendEntryArr;
        this.mIsLegendCustom = true;
    }

    public void setDirection(LegendDirection legendDirection) {
        this.mDirection = legendDirection;
    }

    public void setDrawInside(boolean z11) {
        this.mDrawInside = z11;
    }

    public void setEntries(List<LegendEntry> list) {
        this.mEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setExtra(List<LegendEntry> list) {
        this.mExtraEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setForm(LegendForm legendForm) {
        this.mShape = legendForm;
    }

    public void setFormLineDashEffect(DashPathEffect dashPathEffect) {
        this.mFormLineDashEffect = dashPathEffect;
    }

    public void setFormLineWidth(float f11) {
        this.mFormLineWidth = f11;
    }

    public void setFormSize(float f11) {
        this.mFormSize = f11;
    }

    public void setFormToTextSpace(float f11) {
        this.mFormToTextSpace = f11;
    }

    public void setHorizontalAlignment(LegendHorizontalAlignment legendHorizontalAlignment) {
        this.mHorizontalAlignment = legendHorizontalAlignment;
    }

    public void setMaxSizePercent(float f11) {
        this.mMaxSizePercent = f11;
    }

    public void setOrientation(LegendOrientation legendOrientation) {
        this.mOrientation = legendOrientation;
    }

    public void setStackSpace(float f11) {
        this.mStackSpace = f11;
    }

    public void setVerticalAlignment(LegendVerticalAlignment legendVerticalAlignment) {
        this.mVerticalAlignment = legendVerticalAlignment;
    }

    public void setWordWrapEnabled(boolean z11) {
        this.mWordWrapEnabled = z11;
    }

    public void setXEntrySpace(float f11) {
        this.mXEntrySpace = f11;
    }

    public void setYEntrySpace(float f11) {
        this.mYEntrySpace = f11;
    }

    public void setExtra(LegendEntry[] legendEntryArr) {
        if (legendEntryArr == null) {
            legendEntryArr = new LegendEntry[0];
        }
        this.mExtraEntries = legendEntryArr;
    }

    public void setCustom(List<LegendEntry> list) {
        this.mEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
        this.mIsLegendCustom = true;
    }

    public void setExtra(int[] iArr, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < Math.min(iArr.length, strArr.length); i11++) {
            LegendEntry legendEntry = new LegendEntry();
            int i12 = iArr[i11];
            legendEntry.formColor = i12;
            legendEntry.label = strArr[i11];
            if (i12 == 1122868 || i12 == 0) {
                legendEntry.form = LegendForm.NONE;
            } else if (i12 == 1122867) {
                legendEntry.form = LegendForm.EMPTY;
            }
            arrayList.add(legendEntry);
        }
        this.mExtraEntries = (LegendEntry[]) arrayList.toArray(new LegendEntry[arrayList.size()]);
    }

    public Legend(LegendEntry[] legendEntryArr) {
        this();
        if (legendEntryArr != null) {
            this.mEntries = legendEntryArr;
            return;
        }
        throw new IllegalArgumentException("entries array is NULL");
    }
}
