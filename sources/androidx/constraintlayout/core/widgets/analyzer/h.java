package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

public class h extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    public static int[] f7289k = new int[2];

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7290a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7290a = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7290a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7290a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.h.a.<clinit>():void");
        }
    }

    public h(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f7273h.f7255e = DependencyNode.Type.LEFT;
        this.f7274i.f7255e = DependencyNode.Type.RIGHT;
        this.f7271f = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02b9, code lost:
        if (r14 != 1) goto L_0x031e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.core.widgets.analyzer.c r17) {
        /*
            r16 = this;
            r8 = r16
            int[] r0 = androidx.constraintlayout.core.widgets.analyzer.h.a.f7290a
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = r8.f7275j
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 3
            r9 = 1
            r10 = 0
            if (r0 == r9) goto L_0x0029
            if (r0 == r1) goto L_0x0023
            if (r0 == r2) goto L_0x0017
            goto L_0x002e
        L_0x0017:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            r3 = r17
            r8.n(r3, r1, r0, r10)
            return
        L_0x0023:
            r3 = r17
            r16.o(r17)
            goto L_0x002e
        L_0x0029:
            r3 = r17
            r16.p(r17)
        L_0x002e:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            boolean r0 = r0.f7260j
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r0 != 0) goto L_0x031e
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f7269d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r3) goto L_0x031e
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            int r3 = r0.f7130v
            if (r3 == r1) goto L_0x0301
            if (r3 == r2) goto L_0x0046
            goto L_0x031e
        L_0x0046:
            int r1 = r0.f7132w
            r3 = -1
            if (r1 == 0) goto L_0x008e
            if (r1 != r2) goto L_0x004e
            goto L_0x008e
        L_0x004e:
            int r0 = r0.x()
            if (r0 == r3) goto L_0x0077
            if (r0 == 0) goto L_0x0068
            if (r0 == r9) goto L_0x005a
            r0 = r10
            goto L_0x0087
        L_0x005a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.analyzer.j r1 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r1.f7270e
            int r1 = r1.f7257g
            float r1 = (float) r1
            float r0 = r0.w()
            goto L_0x0084
        L_0x0068:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.analyzer.j r1 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r1.f7270e
            int r1 = r1.f7257g
            float r1 = (float) r1
            float r0 = r0.w()
            float r1 = r1 / r0
            goto L_0x0085
        L_0x0077:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.analyzer.j r1 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r1.f7270e
            int r1 = r1.f7257g
            float r1 = (float) r1
            float r0 = r0.w()
        L_0x0084:
            float r1 = r1 * r0
        L_0x0085:
            float r1 = r1 + r11
            int r0 = (int) r1
        L_0x0087:
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r8.f7270e
            r1.d(r0)
            goto L_0x031e
        L_0x008e:
            androidx.constraintlayout.core.widgets.analyzer.j r1 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12 = r1.f7273h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r13 = r1.f7274i
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f7083f
            if (r1 == 0) goto L_0x009c
            r1 = r9
            goto L_0x009d
        L_0x009c:
            r1 = r10
        L_0x009d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f7083f
            if (r2 == 0) goto L_0x00a5
            r2 = r9
            goto L_0x00a6
        L_0x00a5:
            r2 = r10
        L_0x00a6:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f7083f
            if (r4 == 0) goto L_0x00ae
            r4 = r9
            goto L_0x00af
        L_0x00ae:
            r4 = r10
        L_0x00af:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f7083f
            if (r5 == 0) goto L_0x00b7
            r5 = r9
            goto L_0x00b8
        L_0x00b7:
            r5 = r10
        L_0x00b8:
            int r14 = r0.x()
            if (r1 == 0) goto L_0x01ff
            if (r2 == 0) goto L_0x01ff
            if (r4 == 0) goto L_0x01ff
            if (r5 == 0) goto L_0x01ff
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            float r15 = r0.w()
            boolean r0 = r12.f7260j
            if (r0 == 0) goto L_0x012d
            boolean r0 = r13.f7260j
            if (r0 == 0) goto L_0x012d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7273h
            boolean r1 = r0.f7253c
            if (r1 == 0) goto L_0x012c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7274i
            boolean r1 = r1.f7253c
            if (r1 != 0) goto L_0x00df
            goto L_0x012c
        L_0x00df:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7273h
            int r1 = r1.f7256f
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7274i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7274i
            int r1 = r1.f7256f
            int r3 = r0 - r1
            int r0 = r12.f7257g
            int r1 = r12.f7256f
            int r4 = r0 + r1
            int r0 = r13.f7257g
            int r1 = r13.f7256f
            int r5 = r0 - r1
            int[] r1 = f7289k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.q(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            int[] r1 = f7289k
            r1 = r1[r10]
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f7270e
            int[] r1 = f7289k
            r1 = r1[r9]
            r0.d(r1)
        L_0x012c:
            return
        L_0x012d:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7273h
            boolean r1 = r0.f7260j
            if (r1 == 0) goto L_0x018a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7274i
            boolean r2 = r1.f7260j
            if (r2 == 0) goto L_0x018a
            boolean r2 = r12.f7253c
            if (r2 == 0) goto L_0x0189
            boolean r2 = r13.f7253c
            if (r2 != 0) goto L_0x0142
            goto L_0x0189
        L_0x0142:
            int r2 = r0.f7257g
            int r0 = r0.f7256f
            int r2 = r2 + r0
            int r0 = r1.f7257g
            int r1 = r1.f7256f
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f7257g
            int r1 = r12.f7256f
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f7257g
            int r1 = r13.f7256f
            int r5 = r0 - r1
            int[] r1 = f7289k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.q(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            int[] r1 = f7289k
            r1 = r1[r10]
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f7270e
            int[] r1 = f7289k
            r1 = r1[r9]
            r0.d(r1)
            goto L_0x018a
        L_0x0189:
            return
        L_0x018a:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7273h
            boolean r1 = r0.f7253c
            if (r1 == 0) goto L_0x01fe
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7274i
            boolean r1 = r1.f7253c
            if (r1 == 0) goto L_0x01fe
            boolean r1 = r12.f7253c
            if (r1 == 0) goto L_0x01fe
            boolean r1 = r13.f7253c
            if (r1 != 0) goto L_0x019f
            goto L_0x01fe
        L_0x019f:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7273h
            int r1 = r1.f7256f
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7274i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7274i
            int r1 = r1.f7256f
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f7257g
            int r1 = r12.f7256f
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f7257g
            int r1 = r13.f7256f
            int r5 = r0 - r1
            int[] r1 = f7289k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.q(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            int[] r1 = f7289k
            r1 = r1[r10]
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f7270e
            int[] r1 = f7289k
            r1 = r1[r9]
            r0.d(r1)
            goto L_0x031e
        L_0x01fe:
            return
        L_0x01ff:
            if (r1 == 0) goto L_0x0288
            if (r4 == 0) goto L_0x0288
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7273h
            boolean r0 = r0.f7253c
            if (r0 == 0) goto L_0x0287
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7274i
            boolean r0 = r0.f7253c
            if (r0 != 0) goto L_0x0211
            goto L_0x0287
        L_0x0211:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            float r0 = r0.w()
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7273h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f7262l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f7273h
            int r2 = r2.f7256f
            int r1 = r1 + r2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f7274i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r2.f7262l
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.f7274i
            int r4 = r4.f7256f
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x0264
            if (r14 == 0) goto L_0x0264
            if (r14 == r9) goto L_0x0241
            goto L_0x031e
        L_0x0241:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r10)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r9)
            if (r2 == r3) goto L_0x0254
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x0254:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f7270e
            r0.d(r3)
            goto L_0x031e
        L_0x0264:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r10)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r9)
            if (r2 == r3) goto L_0x0277
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x0277:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f7270e
            r0.d(r3)
            goto L_0x031e
        L_0x0287:
            return
        L_0x0288:
            if (r2 == 0) goto L_0x031e
            if (r5 == 0) goto L_0x031e
            boolean r0 = r12.f7253c
            if (r0 == 0) goto L_0x0300
            boolean r0 = r13.f7253c
            if (r0 != 0) goto L_0x0295
            goto L_0x0300
        L_0x0295:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            float r0 = r0.w()
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r12.f7262l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.f7257g
            int r2 = r12.f7256f
            int r1 = r1 + r2
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r13.f7262l
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.f7257g
            int r4 = r13.f7256f
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x02de
            if (r14 == 0) goto L_0x02bc
            if (r14 == r9) goto L_0x02de
            goto L_0x031e
        L_0x02bc:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r9)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r10)
            if (r2 == r3) goto L_0x02cf
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02cf:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            r0.d(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f7270e
            r0.d(r1)
            goto L_0x031e
        L_0x02de:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r9)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r10)
            if (r2 == r3) goto L_0x02f1
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02f1:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            r0.d(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r0.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f7270e
            r0.d(r1)
            goto L_0x031e
        L_0x0300:
            return
        L_0x0301:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.L()
            if (r0 == 0) goto L_0x031e
            androidx.constraintlayout.core.widgets.analyzer.h r0 = r0.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f7270e
            boolean r1 = r0.f7260j
            if (r1 == 0) goto L_0x031e
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.f7267b
            float r1 = r1.A
            int r0 = r0.f7257g
            float r0 = (float) r0
            float r0 = r0 * r1
            float r0 = r0 + r11
            int r0 = (int) r0
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r8.f7270e
            r1.d(r0)
        L_0x031e:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7273h
            boolean r1 = r0.f7253c
            if (r1 == 0) goto L_0x043e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7274i
            boolean r2 = r1.f7253c
            if (r2 != 0) goto L_0x032c
            goto L_0x043e
        L_0x032c:
            boolean r0 = r0.f7260j
            if (r0 == 0) goto L_0x033b
            boolean r0 = r1.f7260j
            if (r0 == 0) goto L_0x033b
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            boolean r0 = r0.f7260j
            if (r0 == 0) goto L_0x033b
            return
        L_0x033b:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            boolean r0 = r0.f7260j
            if (r0 != 0) goto L_0x0385
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f7269d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0385
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f7267b
            int r1 = r0.f7130v
            if (r1 != 0) goto L_0x0385
            boolean r0 = r0.g0()
            if (r0 != 0) goto L_0x0385
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7273h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7274i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f7262l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f7273h
            int r3 = r2.f7256f
            int r0 = r0 + r3
            int r1 = r1.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.f7274i
            int r3 = r3.f7256f
            int r1 = r1 + r3
            int r3 = r1 - r0
            r2.d(r0)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7274i
            r0.d(r1)
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            r0.d(r3)
            return
        L_0x0385:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            boolean r0 = r0.f7260j
            if (r0 != 0) goto L_0x03e9
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f7269d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x03e9
            int r0 = r8.f7266a
            if (r0 != r9) goto L_0x03e9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7273h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f7262l
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03e9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7274i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f7262l
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03e9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7273h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7274i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f7262l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f7273h
            int r2 = r2.f7256f
            int r0 = r0 + r2
            int r1 = r1.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f7274i
            int r2 = r2.f7256f
            int r1 = r1 + r2
            int r1 = r1 - r0
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            int r0 = r0.f7288m
            int r0 = java.lang.Math.min(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.f7267b
            int r2 = r1.f7138z
            int r1 = r1.f7136y
            int r0 = java.lang.Math.max(r1, r0)
            if (r2 <= 0) goto L_0x03e4
            int r0 = java.lang.Math.min(r2, r0)
        L_0x03e4:
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r8.f7270e
            r1.d(r0)
        L_0x03e9:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            boolean r0 = r0.f7260j
            if (r0 != 0) goto L_0x03f0
            return
        L_0x03f0:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7273h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f7262l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7274i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f7262l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r2 = r0.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.f7273h
            int r3 = r3.f7256f
            int r2 = r2 + r3
            int r3 = r1.f7257g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.f7274i
            int r4 = r4.f7256f
            int r3 = r3 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r8.f7267b
            float r4 = r4.z()
            if (r0 != r1) goto L_0x041f
            int r2 = r0.f7257g
            int r3 = r1.f7257g
            r4 = r11
        L_0x041f:
            int r3 = r3 - r2
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f7270e
            int r0 = r0.f7257g
            int r3 = r3 - r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7273h
            float r1 = (float) r2
            float r1 = r1 + r11
            float r2 = (float) r3
            float r2 = r2 * r4
            float r1 = r1 + r2
            int r1 = (int) r1
            r0.d(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f7274i
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f7273h
            int r1 = r1.f7257g
            androidx.constraintlayout.core.widgets.analyzer.e r2 = r8.f7270e
            int r2 = r2.f7257g
            int r1 = r1 + r2
            r0.d(r1)
        L_0x043e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.h.a(androidx.constraintlayout.core.widgets.analyzer.c):void");
    }

    public void d() {
        ConstraintWidget L;
        ConstraintWidget L2;
        ConstraintWidget constraintWidget = this.f7267b;
        if (constraintWidget.f7088a) {
            this.f7270e.d(constraintWidget.U());
        }
        if (!this.f7270e.f7260j) {
            ConstraintWidget.DimensionBehaviour B = this.f7267b.B();
            this.f7269d = B;
            if (B != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (B == dimensionBehaviour && (L2 = this.f7267b.L()) != null && (L2.B() == ConstraintWidget.DimensionBehaviour.FIXED || L2.B() == dimensionBehaviour)) {
                    int U = (L2.U() - this.f7267b.P.f()) - this.f7267b.R.f();
                    b(this.f7273h, L2.f7096e.f7273h, this.f7267b.P.f());
                    b(this.f7274i, L2.f7096e.f7274i, -this.f7267b.R.f());
                    this.f7270e.d(U);
                    return;
                } else if (this.f7269d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f7270e.d(this.f7267b.U());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f7269d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (L = this.f7267b.L()) != null && (L.B() == ConstraintWidget.DimensionBehaviour.FIXED || L.B() == dimensionBehaviour3)) {
                b(this.f7273h, L.f7096e.f7273h, this.f7267b.P.f());
                b(this.f7274i, L.f7096e.f7274i, -this.f7267b.R.f());
                return;
            }
        }
        e eVar = this.f7270e;
        if (eVar.f7260j) {
            ConstraintWidget constraintWidget2 = this.f7267b;
            if (constraintWidget2.f7088a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.X;
                if (constraintAnchorArr[0].f7083f == null || constraintAnchorArr[1].f7083f == null) {
                    if (constraintAnchorArr[0].f7083f != null) {
                        DependencyNode h11 = h(constraintAnchorArr[0]);
                        if (h11 != null) {
                            b(this.f7273h, h11, this.f7267b.X[0].f());
                            b(this.f7274i, this.f7273h, this.f7270e.f7257g);
                            return;
                        }
                        return;
                    } else if (constraintAnchorArr[1].f7083f != null) {
                        DependencyNode h12 = h(constraintAnchorArr[1]);
                        if (h12 != null) {
                            b(this.f7274i, h12, -this.f7267b.X[1].f());
                            b(this.f7273h, this.f7274i, -this.f7270e.f7257g);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof l0.a) && constraintWidget2.L() != null && this.f7267b.p(ConstraintAnchor.Type.CENTER).f7083f == null) {
                        b(this.f7273h, this.f7267b.L().f7096e.f7273h, this.f7267b.V());
                        b(this.f7274i, this.f7273h, this.f7270e.f7257g);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget2.g0()) {
                    this.f7273h.f7256f = this.f7267b.X[0].f();
                    this.f7274i.f7256f = -this.f7267b.X[1].f();
                    return;
                } else {
                    DependencyNode h13 = h(this.f7267b.X[0]);
                    if (h13 != null) {
                        b(this.f7273h, h13, this.f7267b.X[0].f());
                    }
                    DependencyNode h14 = h(this.f7267b.X[1]);
                    if (h14 != null) {
                        b(this.f7274i, h14, -this.f7267b.X[1].f());
                    }
                    this.f7273h.f7252b = true;
                    this.f7274i.f7252b = true;
                    return;
                }
            }
        }
        if (this.f7269d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f7267b;
            int i11 = constraintWidget3.f7130v;
            if (i11 == 2) {
                ConstraintWidget L3 = constraintWidget3.L();
                if (L3 != null) {
                    e eVar2 = L3.f7098f.f7270e;
                    this.f7270e.f7262l.add(eVar2);
                    eVar2.f7261k.add(this.f7270e);
                    e eVar3 = this.f7270e;
                    eVar3.f7252b = true;
                    eVar3.f7261k.add(this.f7273h);
                    this.f7270e.f7261k.add(this.f7274i);
                }
            } else if (i11 == 3) {
                if (constraintWidget3.f7132w == 3) {
                    this.f7273h.f7251a = this;
                    this.f7274i.f7251a = this;
                    j jVar = constraintWidget3.f7098f;
                    jVar.f7273h.f7251a = this;
                    jVar.f7274i.f7251a = this;
                    eVar.f7251a = this;
                    if (constraintWidget3.i0()) {
                        this.f7270e.f7262l.add(this.f7267b.f7098f.f7270e);
                        this.f7267b.f7098f.f7270e.f7261k.add(this.f7270e);
                        j jVar2 = this.f7267b.f7098f;
                        jVar2.f7270e.f7251a = this;
                        this.f7270e.f7262l.add(jVar2.f7273h);
                        this.f7270e.f7262l.add(this.f7267b.f7098f.f7274i);
                        this.f7267b.f7098f.f7273h.f7261k.add(this.f7270e);
                        this.f7267b.f7098f.f7274i.f7261k.add(this.f7270e);
                    } else if (this.f7267b.g0()) {
                        this.f7267b.f7098f.f7270e.f7262l.add(this.f7270e);
                        this.f7270e.f7261k.add(this.f7267b.f7098f.f7270e);
                    } else {
                        this.f7267b.f7098f.f7270e.f7262l.add(this.f7270e);
                    }
                } else {
                    e eVar4 = constraintWidget3.f7098f.f7270e;
                    eVar.f7262l.add(eVar4);
                    eVar4.f7261k.add(this.f7270e);
                    this.f7267b.f7098f.f7273h.f7261k.add(this.f7270e);
                    this.f7267b.f7098f.f7274i.f7261k.add(this.f7270e);
                    e eVar5 = this.f7270e;
                    eVar5.f7252b = true;
                    eVar5.f7261k.add(this.f7273h);
                    this.f7270e.f7261k.add(this.f7274i);
                    this.f7273h.f7262l.add(this.f7270e);
                    this.f7274i.f7262l.add(this.f7270e);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f7267b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.X;
        if (constraintAnchorArr2[0].f7083f == null || constraintAnchorArr2[1].f7083f == null) {
            if (constraintAnchorArr2[0].f7083f != null) {
                DependencyNode h15 = h(constraintAnchorArr2[0]);
                if (h15 != null) {
                    b(this.f7273h, h15, this.f7267b.X[0].f());
                    c(this.f7274i, this.f7273h, 1, this.f7270e);
                }
            } else if (constraintAnchorArr2[1].f7083f != null) {
                DependencyNode h16 = h(constraintAnchorArr2[1]);
                if (h16 != null) {
                    b(this.f7274i, h16, -this.f7267b.X[1].f());
                    c(this.f7273h, this.f7274i, -1, this.f7270e);
                }
            } else if (!(constraintWidget4 instanceof l0.a) && constraintWidget4.L() != null) {
                b(this.f7273h, this.f7267b.L().f7096e.f7273h, this.f7267b.V());
                c(this.f7274i, this.f7273h, 1, this.f7270e);
            }
        } else if (constraintWidget4.g0()) {
            this.f7273h.f7256f = this.f7267b.X[0].f();
            this.f7274i.f7256f = -this.f7267b.X[1].f();
        } else {
            DependencyNode h17 = h(this.f7267b.X[0]);
            DependencyNode h18 = h(this.f7267b.X[1]);
            if (h17 != null) {
                h17.b(this);
            }
            if (h18 != null) {
                h18.b(this);
            }
            this.f7275j = WidgetRun.RunType.CENTER;
        }
    }

    public void e() {
        DependencyNode dependencyNode = this.f7273h;
        if (dependencyNode.f7260j) {
            this.f7267b.h1(dependencyNode.f7257g);
        }
    }

    public void f() {
        this.f7268c = null;
        this.f7273h.c();
        this.f7274i.c();
        this.f7270e.c();
        this.f7272g = false;
    }

    public boolean m() {
        if (this.f7269d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f7267b.f7130v == 0) {
            return true;
        }
        return false;
    }

    public final void q(int[] iArr, int i11, int i12, int i13, int i14, float f11, int i15) {
        int i16 = i12 - i11;
        int i17 = i14 - i13;
        if (i15 == -1) {
            int i18 = (int) ((((float) i17) * f11) + 0.5f);
            int i19 = (int) ((((float) i16) / f11) + 0.5f);
            if (i18 <= i16) {
                iArr[0] = i18;
                iArr[1] = i17;
            } else if (i19 <= i17) {
                iArr[0] = i16;
                iArr[1] = i19;
            }
        } else if (i15 == 0) {
            iArr[0] = (int) ((((float) i17) * f11) + 0.5f);
            iArr[1] = i17;
        } else if (i15 == 1) {
            iArr[0] = i16;
            iArr[1] = (int) ((((float) i16) * f11) + 0.5f);
        }
    }

    public void r() {
        this.f7272g = false;
        this.f7273h.c();
        this.f7273h.f7260j = false;
        this.f7274i.c();
        this.f7274i.f7260j = false;
        this.f7270e.f7260j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f7267b.u();
    }
}
