package i5;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class i extends o {

    /* renamed from: b  reason: collision with root package name */
    public Paint f66322b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f66323c;

    /* renamed from: d  reason: collision with root package name */
    public Legend f66324d;

    /* renamed from: e  reason: collision with root package name */
    public List<LegendEntry> f66325e = new ArrayList(16);

    /* renamed from: f  reason: collision with root package name */
    public Paint.FontMetrics f66326f = new Paint.FontMetrics();

    /* renamed from: g  reason: collision with root package name */
    public Path f66327g = new Path();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f66328a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f66329b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f66330c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f66331d;

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
                com.github.mikephil.charting.components.Legend$LegendForm[] r0 = com.github.mikephil.charting.components.Legend.LegendForm.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f66331d = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendForm r2 = com.github.mikephil.charting.components.Legend.LegendForm.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f66331d     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendForm r3 = com.github.mikephil.charting.components.Legend.LegendForm.EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f66331d     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f66331d     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f66331d     // Catch:{ NoSuchFieldError -> 0x003e }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.SQUARE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f66331d     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.LINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r3 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f66330c = r3
                com.github.mikephil.charting.components.Legend$LegendOrientation r4 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r3 = f66330c     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.github.mikephil.charting.components.Legend$LegendOrientation r4 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment[] r3 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f66329b = r3
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                int[] r3 = f66329b     // Catch:{ NoSuchFieldError -> 0x007f }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x007f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r3 = f66329b     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment[] r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f66328a = r3
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x009a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x009a }
            L_0x009a:
                int[] r1 = f66328a     // Catch:{ NoSuchFieldError -> 0x00a4 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x00a4 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a4 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00a4 }
            L_0x00a4:
                int[] r0 = f66328a     // Catch:{ NoSuchFieldError -> 0x00ae }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r1 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x00ae }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ae }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ae }
            L_0x00ae:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i5.i.a.<clinit>():void");
        }
    }

    public i(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.f66324d = legend;
        Paint paint = new Paint(1);
        this.f66322b = paint;
        paint.setTextSize(Utils.e(9.0f));
        this.f66322b.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.f66323c = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: com.github.mikephil.charting.data.ChartData<?>} */
    /* JADX WARNING: type inference failed for: r7v2, types: [g5.e] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.github.mikephil.charting.data.ChartData<?> r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.github.mikephil.charting.components.Legend r2 = r0.f66324d
            boolean r2 = r2.F()
            if (r2 != 0) goto L_0x01c1
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.f66325e
            r2.clear()
            r3 = 0
        L_0x0012:
            int r4 = r19.f()
            if (r3 >= r4) goto L_0x01a7
            g5.e r4 = r1.e(r3)
            java.util.List r5 = r4.getColors()
            int r6 = r4.getEntryCount()
            boolean r7 = r4 instanceof g5.a
            if (r7 == 0) goto L_0x0096
            r7 = r4
            g5.a r7 = (g5.a) r7
            boolean r8 = r7.u()
            if (r8 == 0) goto L_0x0096
            java.lang.String[] r6 = r7.v()
            r8 = 0
        L_0x0036:
            int r9 = r5.size()
            if (r8 >= r9) goto L_0x0074
            int r9 = r7.h()
            if (r8 >= r9) goto L_0x0074
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r9 = r0.f66325e
            com.github.mikephil.charting.components.LegendEntry r15 = new com.github.mikephil.charting.components.LegendEntry
            int r10 = r6.length
            int r10 = r8 % r10
            r11 = r6[r10]
            com.github.mikephil.charting.components.Legend$LegendForm r12 = r4.getForm()
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
            goto L_0x0036
        L_0x0074:
            java.lang.String r2 = r7.getLabel()
            if (r2 == 0) goto L_0x0093
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.f66325e
            com.github.mikephil.charting.components.LegendEntry r12 = new com.github.mikephil.charting.components.LegendEntry
            java.lang.String r6 = r4.getLabel()
            com.github.mikephil.charting.components.Legend$LegendForm r7 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            r8 = 2143289344(0x7fc00000, float:NaN)
            r9 = 2143289344(0x7fc00000, float:NaN)
            r10 = 0
            r11 = 1122867(0x112233, float:1.573472E-39)
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2.add(r12)
        L_0x0093:
            r2 = r1
            goto L_0x01a2
        L_0x0096:
            boolean r2 = r4 instanceof g5.i
            if (r2 == 0) goto L_0x00fe
            r2 = r4
            g5.i r2 = (g5.i) r2
            r7 = 0
        L_0x009e:
            int r8 = r5.size()
            if (r7 >= r8) goto L_0x00dd
            if (r7 >= r6) goto L_0x00dd
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r8 = r0.f66325e
            com.github.mikephil.charting.components.LegendEntry r15 = new com.github.mikephil.charting.components.LegendEntry
            com.github.mikephil.charting.data.Entry r9 = r2.getEntryForIndex(r7)
            com.github.mikephil.charting.data.PieEntry r9 = (com.github.mikephil.charting.data.PieEntry) r9
            java.lang.String r10 = r9.getLabel()
            com.github.mikephil.charting.components.Legend$LegendForm r11 = r4.getForm()
            float r12 = r4.getFormSize()
            float r13 = r4.getFormLineWidth()
            android.graphics.DashPathEffect r14 = r4.getFormLineDashEffect()
            java.lang.Object r9 = r5.get(r7)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r16 = r9.intValue()
            r9 = r15
            r1 = r15
            r15 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r8.add(r1)
            int r7 = r7 + 1
            r1 = r19
            goto L_0x009e
        L_0x00dd:
            java.lang.String r1 = r2.getLabel()
            if (r1 == 0) goto L_0x01a0
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r1 = r0.f66325e
            com.github.mikephil.charting.components.LegendEntry r2 = new com.github.mikephil.charting.components.LegendEntry
            java.lang.String r6 = r4.getLabel()
            com.github.mikephil.charting.components.Legend$LegendForm r7 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            r8 = 2143289344(0x7fc00000, float:NaN)
            r9 = 2143289344(0x7fc00000, float:NaN)
            r10 = 0
            r11 = 1122867(0x112233, float:1.573472E-39)
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1.add(r2)
            goto L_0x01a0
        L_0x00fe:
            boolean r1 = r4 instanceof g5.d
            if (r1 == 0) goto L_0x0153
            r1 = r4
            g5.d r1 = (g5.d) r1
            int r2 = r1.z()
            r7 = 1122867(0x112233, float:1.573472E-39)
            if (r2 == r7) goto L_0x0153
            int r14 = r1.z()
            int r1 = r1.i()
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.f66325e
            com.github.mikephil.charting.components.LegendEntry r5 = new com.github.mikephil.charting.components.LegendEntry
            r9 = 0
            com.github.mikephil.charting.components.Legend$LegendForm r10 = r4.getForm()
            float r11 = r4.getFormSize()
            float r12 = r4.getFormLineWidth()
            android.graphics.DashPathEffect r13 = r4.getFormLineDashEffect()
            r8 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r2.add(r5)
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.f66325e
            com.github.mikephil.charting.components.LegendEntry r12 = new com.github.mikephil.charting.components.LegendEntry
            java.lang.String r6 = r4.getLabel()
            com.github.mikephil.charting.components.Legend$LegendForm r7 = r4.getForm()
            float r8 = r4.getFormSize()
            float r9 = r4.getFormLineWidth()
            android.graphics.DashPathEffect r10 = r4.getFormLineDashEffect()
            r5 = r12
            r11 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2.add(r12)
            goto L_0x01a0
        L_0x0153:
            r1 = 0
        L_0x0154:
            int r2 = r5.size()
            if (r1 >= r2) goto L_0x01a0
            if (r1 >= r6) goto L_0x01a0
            int r2 = r5.size()
            int r2 = r2 + -1
            if (r1 >= r2) goto L_0x016d
            int r2 = r6 + -1
            if (r1 >= r2) goto L_0x016d
            r2 = 0
            r9 = r2
            r2 = r19
            goto L_0x0178
        L_0x016d:
            r2 = r19
            g5.e r7 = r2.e(r3)
            java.lang.String r7 = r7.getLabel()
            r9 = r7
        L_0x0178:
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r7 = r0.f66325e
            com.github.mikephil.charting.components.LegendEntry r15 = new com.github.mikephil.charting.components.LegendEntry
            com.github.mikephil.charting.components.Legend$LegendForm r10 = r4.getForm()
            float r11 = r4.getFormSize()
            float r12 = r4.getFormLineWidth()
            android.graphics.DashPathEffect r13 = r4.getFormLineDashEffect()
            java.lang.Object r8 = r5.get(r1)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r14 = r8.intValue()
            r8 = r15
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r7.add(r15)
            int r1 = r1 + 1
            goto L_0x0154
        L_0x01a0:
            r2 = r19
        L_0x01a2:
            int r3 = r3 + 1
            r1 = r2
            goto L_0x0012
        L_0x01a7:
            com.github.mikephil.charting.components.Legend r1 = r0.f66324d
            com.github.mikephil.charting.components.LegendEntry[] r1 = r1.p()
            if (r1 == 0) goto L_0x01ba
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r1 = r0.f66325e
            com.github.mikephil.charting.components.Legend r2 = r0.f66324d
            com.github.mikephil.charting.components.LegendEntry[] r2 = r2.p()
            java.util.Collections.addAll(r1, r2)
        L_0x01ba:
            com.github.mikephil.charting.components.Legend r1 = r0.f66324d
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.f66325e
            r1.G(r2)
        L_0x01c1:
            com.github.mikephil.charting.components.Legend r1 = r0.f66324d
            android.graphics.Typeface r1 = r1.c()
            if (r1 == 0) goto L_0x01ce
            android.graphics.Paint r2 = r0.f66322b
            r2.setTypeface(r1)
        L_0x01ce:
            android.graphics.Paint r1 = r0.f66322b
            com.github.mikephil.charting.components.Legend r2 = r0.f66324d
            float r2 = r2.b()
            r1.setTextSize(r2)
            android.graphics.Paint r1 = r0.f66322b
            com.github.mikephil.charting.components.Legend r2 = r0.f66324d
            int r2 = r2.a()
            r1.setColor(r2)
            com.github.mikephil.charting.components.Legend r1 = r0.f66324d
            android.graphics.Paint r2 = r0.f66322b
            com.github.mikephil.charting.utils.ViewPortHandler r3 = r0.f66370a
            r1.j(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.i.a(com.github.mikephil.charting.data.ChartData):void");
    }

    public void b(Canvas canvas, float f11, float f12, LegendEntry legendEntry, Legend legend) {
        int i11 = legendEntry.f65448f;
        if (i11 != 1122868 && i11 != 1122867 && i11 != 0) {
            int save = canvas.save();
            Legend.LegendForm legendForm = legendEntry.f65444b;
            if (legendForm == Legend.LegendForm.DEFAULT) {
                legendForm = legend.q();
            }
            this.f66323c.setColor(legendEntry.f65448f);
            float e11 = Utils.e(Float.isNaN(legendEntry.f65445c) ? legend.t() : legendEntry.f65445c);
            float f13 = e11 / 2.0f;
            int i12 = a.f66331d[legendForm.ordinal()];
            if (i12 == 3 || i12 == 4) {
                this.f66323c.setStyle(Paint.Style.FILL);
                canvas.drawCircle(f11 + f13, f12, f13, this.f66323c);
            } else if (i12 == 5) {
                this.f66323c.setStyle(Paint.Style.FILL);
                canvas.drawRect(f11, f12 - f13, f11 + e11, f12 + f13, this.f66323c);
            } else if (i12 == 6) {
                float e12 = Utils.e(Float.isNaN(legendEntry.f65446d) ? legend.s() : legendEntry.f65446d);
                DashPathEffect dashPathEffect = legendEntry.f65447e;
                if (dashPathEffect == null) {
                    dashPathEffect = legend.r();
                }
                this.f66323c.setStyle(Paint.Style.STROKE);
                this.f66323c.setStrokeWidth(e12);
                this.f66323c.setPathEffect(dashPathEffect);
                this.f66327g.reset();
                this.f66327g.moveTo(f11, f12);
                this.f66327g.lineTo(f11 + e11, f12);
                canvas.drawPath(this.f66327g, this.f66323c);
            }
            canvas.restoreToCount(save);
        }
    }

    public void c(Canvas canvas, float f11, float f12, String str) {
        canvas.drawText(str, f11, f12, this.f66322b);
    }

    public Paint d() {
        return this.f66322b;
    }

    public void e(Canvas canvas) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        List<Boolean> list;
        List<FSize> list2;
        int i11;
        float f16;
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        float f24;
        float f25;
        float f26;
        Legend.LegendDirection legendDirection;
        LegendEntry legendEntry;
        float f27;
        float f28;
        float f29;
        float f31;
        double d11;
        Canvas canvas2 = canvas;
        if (this.f66324d.f()) {
            Typeface c11 = this.f66324d.c();
            if (c11 != null) {
                this.f66322b.setTypeface(c11);
            }
            this.f66322b.setTextSize(this.f66324d.b());
            this.f66322b.setColor(this.f66324d.a());
            float l11 = Utils.l(this.f66322b, this.f66326f);
            float n11 = Utils.n(this.f66322b, this.f66326f) + Utils.e(this.f66324d.D());
            float a11 = l11 - (((float) Utils.a(this.f66322b, "ABC")) / 2.0f);
            LegendEntry[] o11 = this.f66324d.o();
            float e11 = Utils.e(this.f66324d.u());
            float e12 = Utils.e(this.f66324d.C());
            Legend.LegendOrientation z11 = this.f66324d.z();
            Legend.LegendHorizontalAlignment v11 = this.f66324d.v();
            Legend.LegendVerticalAlignment B = this.f66324d.B();
            Legend.LegendDirection n12 = this.f66324d.n();
            float e13 = Utils.e(this.f66324d.t());
            float e14 = Utils.e(this.f66324d.A());
            float e15 = this.f66324d.e();
            float d12 = this.f66324d.d();
            int i12 = a.f66328a[v11.ordinal()];
            float f32 = e14;
            float f33 = e12;
            if (i12 == 1) {
                f12 = l11;
                f11 = n11;
                if (z11 != Legend.LegendOrientation.VERTICAL) {
                    d12 += this.f66370a.h();
                }
                f13 = n12 == Legend.LegendDirection.RIGHT_TO_LEFT ? d12 + this.f66324d.f65438x : d12;
            } else if (i12 == 2) {
                f12 = l11;
                f11 = n11;
                if (z11 == Legend.LegendOrientation.VERTICAL) {
                    f29 = this.f66370a.m();
                } else {
                    f29 = this.f66370a.i();
                }
                f13 = f29 - d12;
                if (n12 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f13 -= this.f66324d.f65438x;
                }
            } else if (i12 != 3) {
                f12 = l11;
                f11 = n11;
                f13 = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                if (z11 == legendOrientation) {
                    f31 = this.f66370a.m() / 2.0f;
                } else {
                    f31 = this.f66370a.h() + (this.f66370a.k() / 2.0f);
                }
                Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                f11 = n11;
                f13 = f31 + (n12 == legendDirection2 ? d12 : -d12);
                if (z11 == legendOrientation) {
                    double d13 = (double) f13;
                    if (n12 == legendDirection2) {
                        f12 = l11;
                        d11 = (((double) (-this.f66324d.f65438x)) / 2.0d) + ((double) d12);
                    } else {
                        f12 = l11;
                        d11 = (((double) this.f66324d.f65438x) / 2.0d) - ((double) d12);
                    }
                    f13 = (float) (d13 + d11);
                } else {
                    f12 = l11;
                }
            }
            int i13 = a.f66330c[z11.ordinal()];
            if (i13 == 1) {
                Canvas canvas3 = canvas;
                float f34 = f13;
                float f35 = a11;
                float f36 = f32;
                Legend.LegendDirection legendDirection3 = n12;
                List<FSize> m11 = this.f66324d.m();
                List<FSize> l12 = this.f66324d.l();
                List<Boolean> k11 = this.f66324d.k();
                int i14 = a.f66329b[B.ordinal()];
                if (i14 != 1) {
                    if (i14 == 2) {
                        e15 = (this.f66370a.l() - e15) - this.f66324d.f65439y;
                    } else if (i14 != 3) {
                        e15 = 0.0f;
                    } else {
                        e15 += (this.f66370a.l() - this.f66324d.f65439y) / 2.0f;
                    }
                }
                int length = o11.length;
                float f37 = f34;
                int i15 = 0;
                int i16 = 0;
                while (i15 < length) {
                    float f38 = f36;
                    LegendEntry legendEntry2 = o11[i15];
                    float f39 = f37;
                    int i17 = length;
                    boolean z12 = legendEntry2.f65444b != Legend.LegendForm.NONE;
                    float e16 = Float.isNaN(legendEntry2.f65445c) ? e13 : Utils.e(legendEntry2.f65445c);
                    if (i15 >= k11.size() || !k11.get(i15).booleanValue()) {
                        f15 = f39;
                        f14 = e15;
                    } else {
                        f14 = e15 + f12 + f11;
                        f15 = f34;
                    }
                    if (f15 == f34 && v11 == Legend.LegendHorizontalAlignment.CENTER && i16 < m11.size()) {
                        if (legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f21 = m11.get(i16).f65542c;
                        } else {
                            f21 = -m11.get(i16).f65542c;
                        }
                        f15 += f21 / 2.0f;
                        i16++;
                    }
                    int i18 = i16;
                    boolean z13 = legendEntry2.f65443a == null;
                    if (z12) {
                        if (legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f15 -= e16;
                        }
                        float f40 = f15;
                        list2 = m11;
                        i11 = i15;
                        list = k11;
                        b(canvas, f40, f14 + f35, legendEntry2, this.f66324d);
                        f15 = legendDirection3 == Legend.LegendDirection.LEFT_TO_RIGHT ? f40 + e16 : f40;
                    } else {
                        list = k11;
                        list2 = m11;
                        i11 = i15;
                    }
                    if (!z13) {
                        if (z12) {
                            f15 += legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT ? -e11 : e11;
                        }
                        Legend.LegendDirection legendDirection4 = Legend.LegendDirection.RIGHT_TO_LEFT;
                        if (legendDirection3 == legendDirection4) {
                            f15 -= l12.get(i11).f65542c;
                        }
                        c(canvas3, f15, f14 + f12, legendEntry2.f65443a);
                        if (legendDirection3 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            f15 += l12.get(i11).f65542c;
                        }
                        if (legendDirection3 == legendDirection4) {
                            f17 = f33;
                            f19 = -f17;
                        } else {
                            f17 = f33;
                            f19 = f17;
                        }
                        f37 = f15 + f19;
                        f16 = f38;
                    } else {
                        f17 = f33;
                        if (legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f16 = f38;
                            f18 = -f16;
                        } else {
                            f16 = f38;
                            f18 = f16;
                        }
                        f37 = f15 + f18;
                    }
                    f33 = f17;
                    f36 = f16;
                    i15 = i11 + 1;
                    e15 = f14;
                    length = i17;
                    i16 = i18;
                    m11 = list2;
                    k11 = list;
                }
            } else if (i13 == 2) {
                int i19 = a.f66329b[B.ordinal()];
                if (i19 == 1) {
                    if (v11 == Legend.LegendHorizontalAlignment.CENTER) {
                        f27 = 0.0f;
                    } else {
                        f27 = this.f66370a.j();
                    }
                    f22 = f27 + e15;
                } else if (i19 == 2) {
                    if (v11 == Legend.LegendHorizontalAlignment.CENTER) {
                        f28 = this.f66370a.l();
                    } else {
                        f28 = this.f66370a.f();
                    }
                    f22 = f28 - (this.f66324d.f65439y + e15);
                } else if (i19 != 3) {
                    f22 = 0.0f;
                } else {
                    Legend legend = this.f66324d;
                    f22 = ((this.f66370a.l() / 2.0f) - (legend.f65439y / 2.0f)) + legend.e();
                }
                float f41 = f22;
                float f42 = 0.0f;
                boolean z14 = false;
                int i21 = 0;
                while (i21 < o11.length) {
                    LegendEntry legendEntry3 = o11[i21];
                    boolean z15 = legendEntry3.f65444b != Legend.LegendForm.NONE;
                    float e17 = Float.isNaN(legendEntry3.f65445c) ? e13 : Utils.e(legendEntry3.f65445c);
                    if (z15) {
                        Legend.LegendDirection legendDirection5 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        f25 = n12 == legendDirection5 ? f13 + f42 : f13 - (e17 - f42);
                        Legend.LegendDirection legendDirection6 = legendDirection5;
                        float f43 = f41 + a11;
                        f24 = a11;
                        f26 = f32;
                        LegendEntry legendEntry4 = legendEntry3;
                        f23 = f13;
                        legendDirection = n12;
                        b(canvas, f25, f43, legendEntry3, this.f66324d);
                        if (legendDirection == legendDirection6) {
                            f25 += e17;
                        }
                        legendEntry = legendEntry4;
                    } else {
                        f23 = f13;
                        f24 = a11;
                        f26 = f32;
                        legendDirection = n12;
                        legendEntry = legendEntry3;
                        f25 = f23;
                    }
                    String str = legendEntry.f65443a;
                    if (str != null) {
                        if (z15 && !z14) {
                            f25 += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? e11 : -e11;
                        } else if (z14) {
                            f25 = f23;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f25 -= (float) Utils.d(this.f66322b, str);
                        }
                        float f44 = f25;
                        if (!z14) {
                            c(canvas, f44, f41 + f12, legendEntry.f65443a);
                        } else {
                            f41 += f12 + f11;
                            c(canvas, f44, f41 + f12, legendEntry.f65443a);
                        }
                        f41 += f12 + f11;
                        f42 = 0.0f;
                    } else {
                        Canvas canvas4 = canvas;
                        f42 += e17 + f26;
                        z14 = true;
                    }
                    i21++;
                    n12 = legendDirection;
                    f32 = f26;
                    a11 = f24;
                    f13 = f23;
                }
            }
        }
    }
}
