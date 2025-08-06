package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;

public class Grouping {
    public static k a(ConstraintWidget constraintWidget, int i11, ArrayList<k> arrayList, k kVar) {
        int i12;
        int n12;
        if (i11 == 0) {
            i12 = constraintWidget.Q0;
        } else {
            i12 = constraintWidget.R0;
        }
        int i13 = 0;
        if (i12 != -1 && (kVar == null || i12 != kVar.f7304b)) {
            int i14 = 0;
            while (true) {
                if (i14 >= arrayList.size()) {
                    break;
                }
                k kVar2 = arrayList.get(i14);
                if (kVar2.c() == i12) {
                    if (kVar != null) {
                        kVar.g(i11, kVar2);
                        arrayList.remove(kVar);
                    }
                    kVar = kVar2;
                } else {
                    i14++;
                }
            }
        } else if (i12 != -1) {
            return kVar;
        }
        if (kVar == null) {
            if ((constraintWidget instanceof HelperWidget) && (n12 = ((HelperWidget) constraintWidget).n1(i11)) != -1) {
                int i15 = 0;
                while (true) {
                    if (i15 >= arrayList.size()) {
                        break;
                    }
                    k kVar3 = arrayList.get(i15);
                    if (kVar3.c() == n12) {
                        kVar = kVar3;
                        break;
                    }
                    i15++;
                }
            }
            if (kVar == null) {
                kVar = new k(i11);
            }
            arrayList.add(kVar);
        }
        if (kVar.a(constraintWidget)) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                ConstraintAnchor m12 = guideline.m1();
                if (guideline.n1() == 0) {
                    i13 = 1;
                }
                m12.c(i13, arrayList, kVar);
            }
            if (i11 == 0) {
                constraintWidget.Q0 = kVar.c();
                constraintWidget.P.c(i11, arrayList, kVar);
                constraintWidget.R.c(i11, arrayList, kVar);
            } else {
                constraintWidget.R0 = kVar.c();
                constraintWidget.Q.c(i11, arrayList, kVar);
                constraintWidget.T.c(i11, arrayList, kVar);
                constraintWidget.S.c(i11, arrayList, kVar);
            }
            constraintWidget.W.c(i11, arrayList, kVar);
        }
        return kVar;
    }

    public static k b(ArrayList<k> arrayList, int i11) {
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            k kVar = arrayList.get(i12);
            if (i11 == kVar.f7304b) {
                return kVar;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:178:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x03a0 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r16, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.a r17) {
        /*
            r0 = r16
            java.util.ArrayList r1 = r16.m1()
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        L_0x000c:
            if (r4 >= r2) goto L_0x0033
            java.lang.Object r5 = r1.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r16.B()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = r16.R()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.B()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = r5.R()
            boolean r6 = d(r6, r7, r8, r9)
            if (r6 != 0) goto L_0x002b
            return r3
        L_0x002b:
            boolean r5 = r5 instanceof androidx.constraintlayout.core.widgets.Flow
            if (r5 == 0) goto L_0x0030
            return r3
        L_0x0030:
            int r4 = r4 + 1
            goto L_0x000c
        L_0x0033:
            androidx.constraintlayout.core.Metrics r4 = r0.Z0
            if (r4 == 0) goto L_0x003e
            long r5 = r4.F
            r7 = 1
            long r5 = r5 + r7
            r4.F = r5
        L_0x003e:
            r5 = r3
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0045:
            if (r5 >= r2) goto L_0x0121
            java.lang.Object r13 = r1.get(r5)
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = r16.B()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = r16.R()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r13.B()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r13.R()
            boolean r4 = d(r14, r15, r4, r12)
            if (r4 != 0) goto L_0x006d
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = r0.f7166y1
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f7238k
            r14 = r17
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.O1(r3, r13, r14, r4, r12)
            goto L_0x006f
        L_0x006d:
            r14 = r17
        L_0x006f:
            boolean r4 = r13 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r4 == 0) goto L_0x0098
            r12 = r13
            androidx.constraintlayout.core.widgets.Guideline r12 = (androidx.constraintlayout.core.widgets.Guideline) r12
            int r15 = r12.n1()
            if (r15 != 0) goto L_0x0086
            if (r8 != 0) goto L_0x0083
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0083:
            r8.add(r12)
        L_0x0086:
            int r15 = r12.n1()
            r3 = 1
            if (r15 != r3) goto L_0x0098
            if (r6 != 0) goto L_0x0095
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r6 = r3
        L_0x0095:
            r6.add(r12)
        L_0x0098:
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.HelperWidget
            if (r3 == 0) goto L_0x00dc
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 == 0) goto L_0x00c5
            r3 = r13
            androidx.constraintlayout.core.widgets.Barrier r3 = (androidx.constraintlayout.core.widgets.Barrier) r3
            int r12 = r3.s1()
            if (r12 != 0) goto L_0x00b3
            if (r7 != 0) goto L_0x00b0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x00b0:
            r7.add(r3)
        L_0x00b3:
            int r12 = r3.s1()
            r15 = 1
            if (r12 != r15) goto L_0x00dc
            if (r9 != 0) goto L_0x00c1
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x00c1:
            r9.add(r3)
            goto L_0x00dc
        L_0x00c5:
            r3 = r13
            androidx.constraintlayout.core.widgets.HelperWidget r3 = (androidx.constraintlayout.core.widgets.HelperWidget) r3
            if (r7 != 0) goto L_0x00cf
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x00cf:
            r7.add(r3)
            if (r9 != 0) goto L_0x00d9
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x00d9:
            r9.add(r3)
        L_0x00dc:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f7083f
            if (r3 != 0) goto L_0x00f9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f7083f
            if (r3 != 0) goto L_0x00f9
            if (r4 != 0) goto L_0x00f9
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 != 0) goto L_0x00f9
            if (r10 != 0) goto L_0x00f6
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r10 = r3
        L_0x00f6:
            r10.add(r13)
        L_0x00f9:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f7083f
            if (r3 != 0) goto L_0x011c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f7083f
            if (r3 != 0) goto L_0x011c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f7083f
            if (r3 != 0) goto L_0x011c
            if (r4 != 0) goto L_0x011c
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 != 0) goto L_0x011c
            if (r11 != 0) goto L_0x0119
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r11 = r3
        L_0x0119:
            r11.add(r13)
        L_0x011c:
            int r5 = r5 + 1
            r3 = 0
            goto L_0x0045
        L_0x0121:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            if (r6 == 0) goto L_0x013e
            java.util.Iterator r4 = r6.iterator()
        L_0x012c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x013e
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.Guideline r5 = (androidx.constraintlayout.core.widgets.Guideline) r5
            r6 = 0
            r12 = 0
            a(r5, r6, r3, r12)
            goto L_0x012c
        L_0x013e:
            r6 = 0
            r12 = 0
            if (r7 == 0) goto L_0x015f
            java.util.Iterator r4 = r7.iterator()
        L_0x0146:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x015f
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.HelperWidget r5 = (androidx.constraintlayout.core.widgets.HelperWidget) r5
            androidx.constraintlayout.core.widgets.analyzer.k r7 = a(r5, r6, r3, r12)
            r5.m1(r3, r6, r7)
            r7.b(r3)
            r6 = 0
            r12 = 0
            goto L_0x0146
        L_0x015f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.p(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x0187
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x0173:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0187
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f7081d
            r6 = 0
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x0173
        L_0x0187:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.p(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x01af
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x019b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01af
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f7081d
            r6 = 0
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x019b
        L_0x01af:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.p(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x01d7
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x01c3:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01d7
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f7081d
            r6 = 0
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x01c3
        L_0x01d7:
            r6 = 0
            r7 = 0
            if (r10 == 0) goto L_0x01ef
            java.util.Iterator r4 = r10.iterator()
        L_0x01df:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01ef
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            a(r5, r6, r3, r7)
            goto L_0x01df
        L_0x01ef:
            if (r8 == 0) goto L_0x0206
            java.util.Iterator r4 = r8.iterator()
        L_0x01f5:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0206
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.Guideline r5 = (androidx.constraintlayout.core.widgets.Guideline) r5
            r6 = 1
            a(r5, r6, r3, r7)
            goto L_0x01f5
        L_0x0206:
            r6 = 1
            if (r9 == 0) goto L_0x0226
            java.util.Iterator r4 = r9.iterator()
        L_0x020d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0226
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.HelperWidget r5 = (androidx.constraintlayout.core.widgets.HelperWidget) r5
            androidx.constraintlayout.core.widgets.analyzer.k r8 = a(r5, r6, r3, r7)
            r5.m1(r3, r6, r8)
            r8.b(r3)
            r6 = 1
            r7 = 0
            goto L_0x020d
        L_0x0226:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.p(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x024e
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x023a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x024e
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f7081d
            r6 = 1
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x023a
        L_0x024e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.p(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x0276
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x0262:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0276
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f7081d
            r6 = 1
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x0262
        L_0x0276:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.p(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x029e
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x028a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x029e
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f7081d
            r6 = 1
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x028a
        L_0x029e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.p(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x02c6
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x02b2:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02c6
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f7081d
            r6 = 1
            r12 = 0
            a(r5, r6, r3, r12)
            goto L_0x02b2
        L_0x02c6:
            r6 = 1
            r12 = 0
            if (r11 == 0) goto L_0x02de
            java.util.Iterator r4 = r11.iterator()
        L_0x02ce:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02de
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            a(r5, r6, r3, r12)
            goto L_0x02ce
        L_0x02de:
            r4 = 0
        L_0x02df:
            if (r4 >= r2) goto L_0x030b
            java.lang.Object r5 = r1.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5.q0()
            if (r6 == 0) goto L_0x0308
            int r6 = r5.Q0
            androidx.constraintlayout.core.widgets.analyzer.k r6 = b(r3, r6)
            int r5 = r5.R0
            androidx.constraintlayout.core.widgets.analyzer.k r5 = b(r3, r5)
            if (r6 == 0) goto L_0x0308
            if (r5 == 0) goto L_0x0308
            r7 = 0
            r6.g(r7, r5)
            r7 = 2
            r5.i(r7)
            r3.remove(r6)
        L_0x0308:
            int r4 = r4 + 1
            goto L_0x02df
        L_0x030b:
            int r1 = r3.size()
            r2 = 1
            if (r1 > r2) goto L_0x0314
            r1 = 0
            return r1
        L_0x0314:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r16.B()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r2) goto L_0x0356
            java.util.Iterator r1 = r3.iterator()
            r2 = r12
            r6 = 0
        L_0x0322:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0347
            java.lang.Object r4 = r1.next()
            androidx.constraintlayout.core.widgets.analyzer.k r4 = (androidx.constraintlayout.core.widgets.analyzer.k) r4
            int r5 = r4.d()
            r7 = 1
            if (r5 != r7) goto L_0x0336
            goto L_0x0322
        L_0x0336:
            r5 = 0
            r4.h(r5)
            androidx.constraintlayout.core.LinearSystem r7 = r16.G1()
            int r7 = r4.f(r7, r5)
            if (r7 <= r6) goto L_0x0322
            r2 = r4
            r6 = r7
            goto L_0x0322
        L_0x0347:
            if (r2 == 0) goto L_0x0356
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.K0(r1)
            r0.f1(r6)
            r1 = 1
            r2.h(r1)
            goto L_0x0357
        L_0x0356:
            r2 = r12
        L_0x0357:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r16.R()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r4) goto L_0x039b
            java.util.Iterator r1 = r3.iterator()
            r3 = r12
            r6 = 0
        L_0x0365:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x038a
            java.lang.Object r4 = r1.next()
            androidx.constraintlayout.core.widgets.analyzer.k r4 = (androidx.constraintlayout.core.widgets.analyzer.k) r4
            int r5 = r4.d()
            if (r5 != 0) goto L_0x0378
            goto L_0x0365
        L_0x0378:
            r5 = 0
            r4.h(r5)
            androidx.constraintlayout.core.LinearSystem r7 = r16.G1()
            r8 = 1
            int r7 = r4.f(r7, r8)
            if (r7 <= r6) goto L_0x0365
            r3 = r4
            r6 = r7
            goto L_0x0365
        L_0x038a:
            r5 = 0
            r8 = 1
            if (r3 == 0) goto L_0x039d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.b1(r1)
            r0.G0(r6)
            r3.h(r8)
            r4 = r3
            goto L_0x039e
        L_0x039b:
            r5 = 0
            r8 = 1
        L_0x039d:
            r4 = r12
        L_0x039e:
            if (r2 != 0) goto L_0x03a5
            if (r4 == 0) goto L_0x03a3
            goto L_0x03a5
        L_0x03a3:
            r3 = r5
            goto L_0x03a6
        L_0x03a5:
            r3 = r8
        L_0x03a6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.c(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$a):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r5, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r6, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r7, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r8) {
        /*
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1 = 0
            r2 = 1
            if (r7 == r0) goto L_0x0013
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 == r3) goto L_0x0013
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r7 != r4) goto L_0x0011
            if (r5 == r3) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r5 = r1
            goto L_0x0014
        L_0x0013:
            r5 = r2
        L_0x0014:
            if (r8 == r0) goto L_0x0023
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 == r7) goto L_0x0023
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r8 != r0) goto L_0x0021
            if (r6 == r7) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r6 = r1
            goto L_0x0024
        L_0x0023:
            r6 = r2
        L_0x0024:
            if (r5 != 0) goto L_0x002a
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            return r1
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.d(androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour):boolean");
    }
}
