package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class Legend extends ComponentBase {
    public float A = 0.0f;
    public boolean B = false;
    public List<FSize> C = new ArrayList(16);
    public List<Boolean> D = new ArrayList(16);
    public List<FSize> E = new ArrayList(16);

    /* renamed from: g  reason: collision with root package name */
    public LegendEntry[] f65421g = new LegendEntry[0];

    /* renamed from: h  reason: collision with root package name */
    public LegendEntry[] f65422h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65423i = false;

    /* renamed from: j  reason: collision with root package name */
    public LegendHorizontalAlignment f65424j = LegendHorizontalAlignment.LEFT;

    /* renamed from: k  reason: collision with root package name */
    public LegendVerticalAlignment f65425k = LegendVerticalAlignment.BOTTOM;

    /* renamed from: l  reason: collision with root package name */
    public LegendOrientation f65426l = LegendOrientation.HORIZONTAL;

    /* renamed from: m  reason: collision with root package name */
    public boolean f65427m = false;

    /* renamed from: n  reason: collision with root package name */
    public LegendDirection f65428n = LegendDirection.LEFT_TO_RIGHT;

    /* renamed from: o  reason: collision with root package name */
    public LegendForm f65429o = LegendForm.SQUARE;

    /* renamed from: p  reason: collision with root package name */
    public float f65430p = 8.0f;

    /* renamed from: q  reason: collision with root package name */
    public float f65431q = 3.0f;

    /* renamed from: r  reason: collision with root package name */
    public DashPathEffect f65432r = null;

    /* renamed from: s  reason: collision with root package name */
    public float f65433s = 6.0f;

    /* renamed from: t  reason: collision with root package name */
    public float f65434t = 0.0f;

    /* renamed from: u  reason: collision with root package name */
    public float f65435u = 5.0f;

    /* renamed from: v  reason: collision with root package name */
    public float f65436v = 3.0f;

    /* renamed from: w  reason: collision with root package name */
    public float f65437w = 0.95f;

    /* renamed from: x  reason: collision with root package name */
    public float f65438x = 0.0f;

    /* renamed from: y  reason: collision with root package name */
    public float f65439y = 0.0f;

    /* renamed from: z  reason: collision with root package name */
    public float f65440z = 0.0f;

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

    @Deprecated
    public enum LegendPosition {
        RIGHT_OF_CHART,
        RIGHT_OF_CHART_CENTER,
        RIGHT_OF_CHART_INSIDE,
        LEFT_OF_CHART,
        LEFT_OF_CHART_CENTER,
        LEFT_OF_CHART_INSIDE,
        BELOW_CHART_LEFT,
        BELOW_CHART_RIGHT,
        BELOW_CHART_CENTER,
        ABOVE_CHART_LEFT,
        ABOVE_CHART_RIGHT,
        ABOVE_CHART_CENTER,
        PIECHART_CENTER
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65441a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f65442b;

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00ab */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f65442b = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendOrientation r2 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f65442b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r3 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.github.mikephil.charting.components.Legend$LegendPosition[] r2 = com.github.mikephil.charting.components.Legend.LegendPosition.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f65441a = r2
                com.github.mikephil.charting.components.Legend$LegendPosition r3 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f65441a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_INSIDE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_INSIDE     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x006f }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_LEFT     // Catch:{ NoSuchFieldError -> 0x006f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x007b }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x0087 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_RIGHT     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_LEFT     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x009f }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_CENTER     // Catch:{ NoSuchFieldError -> 0x009f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x00ab }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_RIGHT     // Catch:{ NoSuchFieldError -> 0x00ab }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ab }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ab }
            L_0x00ab:
                int[] r0 = f65441a     // Catch:{ NoSuchFieldError -> 0x00b7 }
                com.github.mikephil.charting.components.Legend$LegendPosition r1 = com.github.mikephil.charting.components.Legend.LegendPosition.PIECHART_CENTER     // Catch:{ NoSuchFieldError -> 0x00b7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b7 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b7 }
            L_0x00b7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.a.<clinit>():void");
        }
    }

    public Legend() {
        this.f65416e = Utils.e(10.0f);
        this.f65413b = Utils.e(5.0f);
        this.f65414c = Utils.e(3.0f);
    }

    public float A() {
        return this.f65436v;
    }

    public LegendVerticalAlignment B() {
        return this.f65425k;
    }

    public float C() {
        return this.f65433s;
    }

    public float D() {
        return this.f65434t;
    }

    public boolean E() {
        return this.f65427m;
    }

    public boolean F() {
        return this.f65423i;
    }

    public void G(List<LegendEntry> list) {
        this.f65421g = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void j(Paint paint, ViewPortHandler viewPortHandler) {
        float f11;
        int i11;
        float f12;
        float f13;
        float f14;
        float f15;
        Paint paint2 = paint;
        float e11 = Utils.e(this.f65430p);
        float e12 = Utils.e(this.f65436v);
        float e13 = Utils.e(this.f65435u);
        float e14 = Utils.e(this.f65433s);
        float e15 = Utils.e(this.f65434t);
        boolean z11 = this.B;
        LegendEntry[] legendEntryArr = this.f65421g;
        int length = legendEntryArr.length;
        this.A = y(paint);
        this.f65440z = x(paint);
        int i12 = a.f65442b[this.f65426l.ordinal()];
        if (i12 == 1) {
            float f16 = e11;
            float f17 = e12;
            LegendEntry[] legendEntryArr2 = legendEntryArr;
            float k11 = Utils.k(paint);
            float f18 = 0.0f;
            float f19 = 0.0f;
            float f21 = 0.0f;
            boolean z12 = false;
            for (int i13 = 0; i13 < length; i13++) {
                LegendEntry legendEntry = legendEntryArr2[i13];
                boolean z13 = legendEntry.f65444b != LegendForm.NONE;
                if (Float.isNaN(legendEntry.f65445c)) {
                    f11 = f16;
                } else {
                    f11 = Utils.e(legendEntry.f65445c);
                }
                String str = legendEntry.f65443a;
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
                        f21 += e13;
                    } else if (z12) {
                        f18 = Math.max(f18, f21);
                        f19 += k11 + e15;
                        f21 = 0.0f;
                        z12 = false;
                    }
                    f21 += (float) Utils.d(paint2, str);
                    if (i13 < length - 1) {
                        f19 += k11 + e15;
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
            this.f65438x = f18;
            this.f65439y = f19;
        } else if (i12 == 2) {
            float k12 = Utils.k(paint);
            float m11 = Utils.m(paint) + e15;
            float k13 = viewPortHandler.k() * this.f65437w;
            this.D.clear();
            this.C.clear();
            this.E.clear();
            int i14 = 0;
            float f22 = 0.0f;
            int i15 = -1;
            float f23 = 0.0f;
            float f24 = 0.0f;
            while (i14 < length) {
                LegendEntry legendEntry2 = legendEntryArr[i14];
                float f25 = e11;
                float f26 = e14;
                boolean z14 = legendEntry2.f65444b != LegendForm.NONE;
                if (Float.isNaN(legendEntry2.f65445c)) {
                    f12 = f25;
                } else {
                    f12 = Utils.e(legendEntry2.f65445c);
                }
                String str2 = legendEntry2.f65443a;
                LegendEntry[] legendEntryArr3 = legendEntryArr;
                float f27 = m11;
                this.D.add(Boolean.FALSE);
                float f28 = i15 == -1 ? 0.0f : f23 + e12;
                if (str2 != null) {
                    f13 = e12;
                    this.C.add(Utils.b(paint2, str2));
                    f14 = f28 + (z14 ? e13 + f12 : 0.0f) + this.C.get(i14).f65542c;
                } else {
                    f13 = e12;
                    float f29 = f12;
                    this.C.add(FSize.b(0.0f, 0.0f));
                    f14 = f28 + (z14 ? f29 : 0.0f);
                    if (i15 == -1) {
                        i15 = i14;
                    }
                }
                if (str2 != null || i14 == length - 1) {
                    float f31 = f24;
                    int i16 = (f31 > 0.0f ? 1 : (f31 == 0.0f ? 0 : -1));
                    float f32 = i16 == 0 ? 0.0f : f26;
                    if (!z11 || i16 == 0 || k13 - f31 >= f32 + f14) {
                        f15 = f31 + f32 + f14;
                    } else {
                        this.E.add(FSize.b(f31, k12));
                        float max = Math.max(f22, f31);
                        this.D.set(i15 > -1 ? i15 : i14, Boolean.TRUE);
                        f22 = max;
                        f15 = f14;
                    }
                    if (i14 == length - 1) {
                        this.E.add(FSize.b(f15, k12));
                        f22 = Math.max(f22, f15);
                    }
                    f24 = f15;
                }
                if (str2 != null) {
                    i15 = -1;
                }
                i14++;
                e12 = f13;
                e11 = f25;
                e14 = f26;
                m11 = f27;
                f23 = f14;
                legendEntryArr = legendEntryArr3;
            }
            float f33 = m11;
            this.f65438x = f22;
            float size = k12 * ((float) this.E.size());
            if (this.E.size() == 0) {
                i11 = 0;
            } else {
                i11 = this.E.size() - 1;
            }
            this.f65439y = size + (f33 * ((float) i11));
        }
        this.f65439y += this.f65414c;
        this.f65438x += this.f65413b;
    }

    public List<Boolean> k() {
        return this.D;
    }

    public List<FSize> l() {
        return this.C;
    }

    public List<FSize> m() {
        return this.E;
    }

    public LegendDirection n() {
        return this.f65428n;
    }

    public LegendEntry[] o() {
        return this.f65421g;
    }

    public LegendEntry[] p() {
        return this.f65422h;
    }

    public LegendForm q() {
        return this.f65429o;
    }

    public DashPathEffect r() {
        return this.f65432r;
    }

    public float s() {
        return this.f65431q;
    }

    public float t() {
        return this.f65430p;
    }

    public float u() {
        return this.f65435u;
    }

    public LegendHorizontalAlignment v() {
        return this.f65424j;
    }

    public float w() {
        return this.f65437w;
    }

    public float x(Paint paint) {
        float f11 = 0.0f;
        for (LegendEntry legendEntry : this.f65421g) {
            String str = legendEntry.f65443a;
            if (str != null) {
                float a11 = (float) Utils.a(paint, str);
                if (a11 > f11) {
                    f11 = a11;
                }
            }
        }
        return f11;
    }

    public float y(Paint paint) {
        float e11 = Utils.e(this.f65435u);
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (LegendEntry legendEntry : this.f65421g) {
            float e12 = Utils.e(Float.isNaN(legendEntry.f65445c) ? this.f65430p : legendEntry.f65445c);
            if (e12 > f12) {
                f12 = e12;
            }
            String str = legendEntry.f65443a;
            if (str != null) {
                float d11 = (float) Utils.d(paint, str);
                if (d11 > f11) {
                    f11 = d11;
                }
            }
        }
        return f11 + f12 + e11;
    }

    public LegendOrientation z() {
        return this.f65426l;
    }
}
