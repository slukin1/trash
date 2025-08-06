package com.huobi.view.chart.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.huobi.view.chart.components.Legend;
import com.huobi.view.chart.components.LegendEntry;
import com.huobi.view.chart.utils.FSize;
import com.huobi.view.chart.utils.Utils;
import com.huobi.view.chart.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class LegendRenderer extends Renderer {
    public List<LegendEntry> computedEntries = new ArrayList(16);
    public Paint.FontMetrics legendFontMetrics = new Paint.FontMetrics();
    public Legend mLegend;
    public Paint mLegendFormPaint;
    public Paint mLegendLabelPaint;
    private Path mLineFormPath = new Path();

    /* renamed from: com.huobi.view.chart.renderer.LegendRenderer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huobi$view$chart$components$Legend$LegendForm;
        public static final /* synthetic */ int[] $SwitchMap$com$huobi$view$chart$components$Legend$LegendHorizontalAlignment;
        public static final /* synthetic */ int[] $SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation;
        public static final /* synthetic */ int[] $SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|(2:21|22)|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x009a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a4 */
        static {
            /*
                com.huobi.view.chart.components.Legend$LegendForm[] r0 = com.huobi.view.chart.components.Legend.LegendForm.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huobi$view$chart$components$Legend$LegendForm = r0
                r1 = 1
                com.huobi.view.chart.components.Legend$LegendForm r2 = com.huobi.view.chart.components.Legend.LegendForm.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendForm     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.view.chart.components.Legend$LegendForm r3 = com.huobi.view.chart.components.Legend.LegendForm.EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendForm     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.view.chart.components.Legend$LegendForm r4 = com.huobi.view.chart.components.Legend.LegendForm.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendForm     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.view.chart.components.Legend$LegendForm r4 = com.huobi.view.chart.components.Legend.LegendForm.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendForm     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.view.chart.components.Legend$LegendForm r4 = com.huobi.view.chart.components.Legend.LegendForm.SQUARE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendForm     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.view.chart.components.Legend$LegendForm r4 = com.huobi.view.chart.components.Legend.LegendForm.LINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.huobi.view.chart.components.Legend$LegendOrientation[] r3 = com.huobi.view.chart.components.Legend.LegendOrientation.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation = r3
                com.huobi.view.chart.components.Legend$LegendOrientation r4 = com.huobi.view.chart.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r3 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.huobi.view.chart.components.Legend$LegendOrientation r4 = com.huobi.view.chart.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.huobi.view.chart.components.Legend$LegendVerticalAlignment[] r3 = com.huobi.view.chart.components.Legend.LegendVerticalAlignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment = r3
                com.huobi.view.chart.components.Legend$LegendVerticalAlignment r4 = com.huobi.view.chart.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                int[] r3 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment     // Catch:{ NoSuchFieldError -> 0x007f }
                com.huobi.view.chart.components.Legend$LegendVerticalAlignment r4 = com.huobi.view.chart.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x007f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r3 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.huobi.view.chart.components.Legend$LegendVerticalAlignment r4 = com.huobi.view.chart.components.Legend.LegendVerticalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                com.huobi.view.chart.components.Legend$LegendHorizontalAlignment[] r3 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$huobi$view$chart$components$Legend$LegendHorizontalAlignment = r3
                com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r4 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x009a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x009a }
            L_0x009a:
                int[] r1 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendHorizontalAlignment     // Catch:{ NoSuchFieldError -> 0x00a4 }
                com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r3 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x00a4 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a4 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00a4 }
            L_0x00a4:
                int[] r0 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendHorizontalAlignment     // Catch:{ NoSuchFieldError -> 0x00ae }
                com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r1 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x00ae }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ae }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ae }
            L_0x00ae:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.chart.renderer.LegendRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.mLegend = legend;
        Paint paint = new Paint(1);
        this.mLegendLabelPaint = paint;
        paint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.mLegendFormPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.huobi.view.chart.data.ChartData<?>} */
    /* JADX WARNING: type inference failed for: r4v1, types: [com.huobi.view.chart.interfaces.datasets.IDataSet] */
    /* JADX WARNING: type inference failed for: r7v6, types: [com.huobi.view.chart.interfaces.datasets.IDataSet] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeLegend(com.huobi.view.chart.data.ChartData<?> r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.huobi.view.chart.components.Legend r2 = r0.mLegend
            boolean r2 = r2.isLegendCustom()
            if (r2 != 0) goto L_0x00f1
            java.util.List<com.huobi.view.chart.components.LegendEntry> r2 = r0.computedEntries
            r2.clear()
            r3 = 0
        L_0x0012:
            int r4 = r19.getDataSetCount()
            if (r3 >= r4) goto L_0x00d7
            com.huobi.view.chart.interfaces.datasets.IDataSet r4 = r1.getDataSetByIndex(r3)
            java.util.List r5 = r4.getColors()
            int r6 = r4.getEntryCount()
            boolean r7 = r4 instanceof com.huobi.view.chart.interfaces.datasets.IPieDataSet
            if (r7 == 0) goto L_0x008b
            r7 = r4
            com.huobi.view.chart.interfaces.datasets.IPieDataSet r7 = (com.huobi.view.chart.interfaces.datasets.IPieDataSet) r7
            r8 = 0
        L_0x002c:
            int r9 = r5.size()
            if (r8 >= r9) goto L_0x006b
            if (r8 >= r6) goto L_0x006b
            java.util.List<com.huobi.view.chart.components.LegendEntry> r9 = r0.computedEntries
            com.huobi.view.chart.components.LegendEntry r15 = new com.huobi.view.chart.components.LegendEntry
            com.huobi.view.chart.data.Entry r10 = r7.getEntryForIndex(r8)
            com.huobi.view.chart.data.PieEntry r10 = (com.huobi.view.chart.data.PieEntry) r10
            java.lang.String r11 = r10.getLabel()
            com.huobi.view.chart.components.Legend$LegendForm r12 = r4.getForm()
            float r13 = r4.getFormSize()
            float r14 = r4.getFormLineWidth()
            android.graphics.DashPathEffect r16 = r4.getFormLineDashEffect()
            java.lang.Object r10 = r5.get(r8)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r17 = r10.intValue()
            r10 = r15
            r2 = r15
            r15 = r16
            r16 = r17
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r9.add(r2)
            int r8 = r8 + 1
            goto L_0x002c
        L_0x006b:
            java.lang.String r2 = r7.getLabel()
            if (r2 == 0) goto L_0x00d3
            java.util.List<com.huobi.view.chart.components.LegendEntry> r2 = r0.computedEntries
            com.huobi.view.chart.components.LegendEntry r12 = new com.huobi.view.chart.components.LegendEntry
            java.lang.String r6 = r4.getLabel()
            com.huobi.view.chart.components.Legend$LegendForm r7 = com.huobi.view.chart.components.Legend.LegendForm.NONE
            r8 = 2143289344(0x7fc00000, float:NaN)
            r9 = 2143289344(0x7fc00000, float:NaN)
            r10 = 0
            r11 = 1122867(0x112233, float:1.573472E-39)
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2.add(r12)
            goto L_0x00d3
        L_0x008b:
            r2 = 0
        L_0x008c:
            int r7 = r5.size()
            if (r2 >= r7) goto L_0x00d3
            if (r2 >= r6) goto L_0x00d3
            int r7 = r5.size()
            int r7 = r7 + -1
            if (r2 >= r7) goto L_0x00a2
            int r7 = r6 + -1
            if (r2 >= r7) goto L_0x00a2
            r7 = 0
            goto L_0x00aa
        L_0x00a2:
            com.huobi.view.chart.interfaces.datasets.IDataSet r7 = r1.getDataSetByIndex(r3)
            java.lang.String r7 = r7.getLabel()
        L_0x00aa:
            r9 = r7
            java.util.List<com.huobi.view.chart.components.LegendEntry> r7 = r0.computedEntries
            com.huobi.view.chart.components.LegendEntry r15 = new com.huobi.view.chart.components.LegendEntry
            com.huobi.view.chart.components.Legend$LegendForm r10 = r4.getForm()
            float r11 = r4.getFormSize()
            float r12 = r4.getFormLineWidth()
            android.graphics.DashPathEffect r13 = r4.getFormLineDashEffect()
            java.lang.Object r8 = r5.get(r2)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r14 = r8.intValue()
            r8 = r15
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r7.add(r15)
            int r2 = r2 + 1
            goto L_0x008c
        L_0x00d3:
            int r3 = r3 + 1
            goto L_0x0012
        L_0x00d7:
            com.huobi.view.chart.components.Legend r1 = r0.mLegend
            com.huobi.view.chart.components.LegendEntry[] r1 = r1.getExtraEntries()
            if (r1 == 0) goto L_0x00ea
            java.util.List<com.huobi.view.chart.components.LegendEntry> r1 = r0.computedEntries
            com.huobi.view.chart.components.Legend r2 = r0.mLegend
            com.huobi.view.chart.components.LegendEntry[] r2 = r2.getExtraEntries()
            java.util.Collections.addAll(r1, r2)
        L_0x00ea:
            com.huobi.view.chart.components.Legend r1 = r0.mLegend
            java.util.List<com.huobi.view.chart.components.LegendEntry> r2 = r0.computedEntries
            r1.setEntries(r2)
        L_0x00f1:
            com.huobi.view.chart.components.Legend r1 = r0.mLegend
            android.graphics.Typeface r1 = r1.getTypeface()
            if (r1 == 0) goto L_0x00fe
            android.graphics.Paint r2 = r0.mLegendLabelPaint
            r2.setTypeface(r1)
        L_0x00fe:
            android.graphics.Paint r1 = r0.mLegendLabelPaint
            com.huobi.view.chart.components.Legend r2 = r0.mLegend
            float r2 = r2.getTextSize()
            r1.setTextSize(r2)
            android.graphics.Paint r1 = r0.mLegendLabelPaint
            com.huobi.view.chart.components.Legend r2 = r0.mLegend
            int r2 = r2.getTextColor()
            r1.setColor(r2)
            com.huobi.view.chart.components.Legend r1 = r0.mLegend
            android.graphics.Paint r2 = r0.mLegendLabelPaint
            com.huobi.view.chart.utils.ViewPortHandler r3 = r0.mViewPortHandler
            r1.calculateDimensions(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.chart.renderer.LegendRenderer.computeLegend(com.huobi.view.chart.data.ChartData):void");
    }

    public void drawForm(Canvas canvas, float f11, float f12, LegendEntry legendEntry, Legend legend) {
        float f13;
        float f14;
        int i11 = legendEntry.formColor;
        if (i11 != 1122868 && i11 != 1122867 && i11 != 0) {
            int save = canvas.save();
            Legend.LegendForm legendForm = legendEntry.form;
            if (legendForm == Legend.LegendForm.DEFAULT) {
                legendForm = legend.getForm();
            }
            this.mLegendFormPaint.setColor(legendEntry.formColor);
            if (Float.isNaN(legendEntry.formSize)) {
                f13 = legend.getFormSize();
            } else {
                f13 = legendEntry.formSize;
            }
            float convertDpToPixel = Utils.convertDpToPixel(f13);
            float f15 = convertDpToPixel / 2.0f;
            int i12 = AnonymousClass1.$SwitchMap$com$huobi$view$chart$components$Legend$LegendForm[legendForm.ordinal()];
            if (i12 == 3 || i12 == 4) {
                this.mLegendFormPaint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(f11 + f15, f12, f15, this.mLegendFormPaint);
            } else if (i12 == 5) {
                this.mLegendFormPaint.setStyle(Paint.Style.FILL);
                canvas.drawRect(f11, f12 - f15, f11 + convertDpToPixel, f12 + f15, this.mLegendFormPaint);
            } else if (i12 == 6) {
                if (Float.isNaN(legendEntry.formLineWidth)) {
                    f14 = legend.getFormLineWidth();
                } else {
                    f14 = legendEntry.formLineWidth;
                }
                float convertDpToPixel2 = Utils.convertDpToPixel(f14);
                DashPathEffect dashPathEffect = legendEntry.formLineDashEffect;
                if (dashPathEffect == null) {
                    dashPathEffect = legend.getFormLineDashEffect();
                }
                this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
                this.mLegendFormPaint.setStrokeWidth(convertDpToPixel2);
                this.mLegendFormPaint.setPathEffect(dashPathEffect);
                this.mLineFormPath.reset();
                this.mLineFormPath.moveTo(f11, f12);
                this.mLineFormPath.lineTo(f11 + convertDpToPixel, f12);
                canvas.drawPath(this.mLineFormPath, this.mLegendFormPaint);
            }
            canvas.restoreToCount(save);
        }
    }

    public void drawLabel(Canvas canvas, float f11, float f12, String str) {
        canvas.drawText(str, f11, f12, this.mLegendLabelPaint);
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public void renderLegend(Canvas canvas) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        List<Boolean> list;
        List<FSize> list2;
        int i11;
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        float f24;
        float f25;
        float f26;
        float f27;
        float f28;
        Legend.LegendDirection legendDirection;
        LegendEntry legendEntry;
        float f29;
        float f31;
        float f32;
        float f33;
        float f34;
        double d11;
        Canvas canvas2 = canvas;
        if (this.mLegend.isEnabled()) {
            Typeface typeface = this.mLegend.getTypeface();
            if (typeface != null) {
                this.mLegendLabelPaint.setTypeface(typeface);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float lineHeight = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
            float lineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
            float calcTextHeight = lineHeight - (((float) Utils.calcTextHeight(this.mLegendLabelPaint, "ABC")) / 2.0f);
            LegendEntry[] entries = this.mLegend.getEntries();
            float convertDpToPixel = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
            float convertDpToPixel2 = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
            Legend.LegendOrientation orientation = this.mLegend.getOrientation();
            Legend.LegendHorizontalAlignment horizontalAlignment = this.mLegend.getHorizontalAlignment();
            Legend.LegendVerticalAlignment verticalAlignment = this.mLegend.getVerticalAlignment();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float convertDpToPixel3 = Utils.convertDpToPixel(this.mLegend.getFormSize());
            float convertDpToPixel4 = Utils.convertDpToPixel(this.mLegend.getStackSpace());
            float yOffset = this.mLegend.getYOffset();
            float xOffset = this.mLegend.getXOffset();
            int i12 = AnonymousClass1.$SwitchMap$com$huobi$view$chart$components$Legend$LegendHorizontalAlignment[horizontalAlignment.ordinal()];
            float f35 = convertDpToPixel4;
            float f36 = convertDpToPixel2;
            if (i12 == 1) {
                f12 = lineHeight;
                f11 = lineSpacing;
                if (orientation != Legend.LegendOrientation.VERTICAL) {
                    xOffset += this.mViewPortHandler.contentLeft();
                }
                f13 = direction == Legend.LegendDirection.RIGHT_TO_LEFT ? xOffset + this.mLegend.mNeededWidth : xOffset;
            } else if (i12 == 2) {
                f12 = lineHeight;
                f11 = lineSpacing;
                if (orientation == Legend.LegendOrientation.VERTICAL) {
                    f32 = this.mViewPortHandler.getChartWidth();
                } else {
                    f32 = this.mViewPortHandler.contentRight();
                }
                f13 = f32 - xOffset;
                if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f13 -= this.mLegend.mNeededWidth;
                }
            } else if (i12 != 3) {
                f12 = lineHeight;
                f11 = lineSpacing;
                f13 = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                if (orientation == legendOrientation) {
                    f33 = this.mViewPortHandler.getChartWidth() / 2.0f;
                } else {
                    f33 = this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f);
                }
                Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                if (direction == legendDirection2) {
                    f11 = lineSpacing;
                    f34 = xOffset;
                } else {
                    f11 = lineSpacing;
                    f34 = -xOffset;
                }
                f13 = f33 + f34;
                if (orientation == legendOrientation) {
                    double d12 = (double) f13;
                    if (direction == legendDirection2) {
                        f12 = lineHeight;
                        d11 = (((double) (-this.mLegend.mNeededWidth)) / 2.0d) + ((double) xOffset);
                    } else {
                        f12 = lineHeight;
                        d11 = (((double) this.mLegend.mNeededWidth) / 2.0d) - ((double) xOffset);
                    }
                    f13 = (float) (d12 + d11);
                } else {
                    f12 = lineHeight;
                }
            }
            int i13 = AnonymousClass1.$SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation[orientation.ordinal()];
            if (i13 == 1) {
                Canvas canvas3 = canvas;
                float f37 = f13;
                float f38 = calcTextHeight;
                float f39 = f35;
                Legend.LegendDirection legendDirection3 = direction;
                List<FSize> calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
                List<FSize> calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
                List<Boolean> calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
                int i14 = AnonymousClass1.$SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
                if (i14 != 1) {
                    if (i14 == 2) {
                        yOffset = (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
                    } else if (i14 != 3) {
                        yOffset = 0.0f;
                    } else {
                        yOffset += (this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f;
                    }
                }
                int length = entries.length;
                float f40 = f37;
                int i15 = 0;
                int i16 = 0;
                while (i15 < length) {
                    float f41 = f39;
                    LegendEntry legendEntry2 = entries[i15];
                    float f42 = f40;
                    int i17 = length;
                    boolean z11 = legendEntry2.form != Legend.LegendForm.NONE;
                    if (Float.isNaN(legendEntry2.formSize)) {
                        f14 = convertDpToPixel3;
                    } else {
                        f14 = Utils.convertDpToPixel(legendEntry2.formSize);
                    }
                    if (i15 >= calculatedLabelBreakPoints.size() || !calculatedLabelBreakPoints.get(i15).booleanValue()) {
                        f16 = f42;
                        f15 = yOffset;
                    } else {
                        f15 = yOffset + f12 + f11;
                        f16 = f37;
                    }
                    if (f16 == f37 && horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i16 < calculatedLineSizes.size()) {
                        if (legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f22 = calculatedLineSizes.get(i16).width;
                        } else {
                            f22 = -calculatedLineSizes.get(i16).width;
                        }
                        f16 += f22 / 2.0f;
                        i16++;
                    }
                    int i18 = i16;
                    boolean z12 = legendEntry2.label == null;
                    if (z11) {
                        if (legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f16 -= f14;
                        }
                        float f43 = f16;
                        list2 = calculatedLineSizes;
                        i11 = i15;
                        list = calculatedLabelBreakPoints;
                        drawForm(canvas, f43, f15 + f38, legendEntry2, this.mLegend);
                        f16 = legendDirection3 == Legend.LegendDirection.LEFT_TO_RIGHT ? f43 + f14 : f43;
                    } else {
                        list = calculatedLabelBreakPoints;
                        list2 = calculatedLineSizes;
                        i11 = i15;
                    }
                    if (!z12) {
                        if (z11) {
                            f16 += legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT ? -convertDpToPixel : convertDpToPixel;
                        }
                        Legend.LegendDirection legendDirection4 = Legend.LegendDirection.RIGHT_TO_LEFT;
                        if (legendDirection3 == legendDirection4) {
                            f16 -= calculatedLabelSizes.get(i11).width;
                        }
                        drawLabel(canvas3, f16, f15 + f12, legendEntry2.label);
                        if (legendDirection3 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            f16 += calculatedLabelSizes.get(i11).width;
                        }
                        if (legendDirection3 == legendDirection4) {
                            f18 = f36;
                            f21 = -f18;
                        } else {
                            f18 = f36;
                            f21 = f18;
                        }
                        f40 = f16 + f21;
                        f17 = f41;
                    } else {
                        f18 = f36;
                        if (legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f17 = f41;
                            f19 = -f17;
                        } else {
                            f17 = f41;
                            f19 = f17;
                        }
                        f40 = f16 + f19;
                    }
                    f36 = f18;
                    f39 = f17;
                    i15 = i11 + 1;
                    yOffset = f15;
                    length = i17;
                    i16 = i18;
                    calculatedLineSizes = list2;
                    calculatedLabelBreakPoints = list;
                }
            } else if (i13 == 2) {
                int i19 = AnonymousClass1.$SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
                if (i19 == 1) {
                    if (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                        f29 = 0.0f;
                    } else {
                        f29 = this.mViewPortHandler.contentTop();
                    }
                    f23 = f29 + yOffset;
                } else if (i19 == 2) {
                    if (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                        f31 = this.mViewPortHandler.getChartHeight();
                    } else {
                        f31 = this.mViewPortHandler.contentBottom();
                    }
                    f23 = f31 - (this.mLegend.mNeededHeight + yOffset);
                } else if (i19 != 3) {
                    f23 = 0.0f;
                } else {
                    Legend legend = this.mLegend;
                    f23 = ((this.mViewPortHandler.getChartHeight() / 2.0f) - (legend.mNeededHeight / 2.0f)) + legend.getYOffset();
                }
                float f44 = f23;
                float f45 = 0.0f;
                boolean z13 = false;
                int i21 = 0;
                while (i21 < entries.length) {
                    LegendEntry legendEntry3 = entries[i21];
                    boolean z14 = legendEntry3.form != Legend.LegendForm.NONE;
                    if (Float.isNaN(legendEntry3.formSize)) {
                        f24 = convertDpToPixel3;
                    } else {
                        f24 = Utils.convertDpToPixel(legendEntry3.formSize);
                    }
                    if (z14) {
                        Legend.LegendDirection legendDirection5 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        f27 = direction == legendDirection5 ? f13 + f45 : f13 - (f24 - f45);
                        Legend.LegendDirection legendDirection6 = legendDirection5;
                        float f46 = f44 + calcTextHeight;
                        f26 = calcTextHeight;
                        f28 = f35;
                        LegendEntry legendEntry4 = legendEntry3;
                        f25 = f13;
                        legendDirection = direction;
                        drawForm(canvas, f27, f46, legendEntry3, this.mLegend);
                        if (legendDirection == legendDirection6) {
                            f27 += f24;
                        }
                        legendEntry = legendEntry4;
                    } else {
                        f25 = f13;
                        f26 = calcTextHeight;
                        f28 = f35;
                        legendDirection = direction;
                        legendEntry = legendEntry3;
                        f27 = f25;
                    }
                    String str = legendEntry.label;
                    if (str != null) {
                        if (z14 && !z13) {
                            f27 += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? convertDpToPixel : -convertDpToPixel;
                        } else if (z13) {
                            f27 = f25;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f27 -= (float) Utils.calcTextWidth(this.mLegendLabelPaint, str);
                        }
                        float f47 = f27;
                        if (!z13) {
                            drawLabel(canvas, f47, f44 + f12, legendEntry.label);
                        } else {
                            f44 += f12 + f11;
                            drawLabel(canvas, f47, f44 + f12, legendEntry.label);
                        }
                        f44 += f12 + f11;
                        f45 = 0.0f;
                    } else {
                        Canvas canvas4 = canvas;
                        f45 += f24 + f28;
                        z13 = true;
                    }
                    i21++;
                    direction = legendDirection;
                    f35 = f28;
                    calcTextHeight = f26;
                    f13 = f25;
                }
            }
        }
    }
}
