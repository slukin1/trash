package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public ConstraintWidgetContainer f7279a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7280b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7281c = true;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintWidgetContainer f7282d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<WidgetRun> f7283e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<i> f7284f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public BasicMeasure.a f7285g = null;

    /* renamed from: h  reason: collision with root package name */
    public BasicMeasure.Measure f7286h = new BasicMeasure.Measure();

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<i> f7287i = new ArrayList<>();

    public d(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f7279a = constraintWidgetContainer;
        this.f7282d = constraintWidgetContainer;
    }

    public final void a(DependencyNode dependencyNode, int i11, int i12, DependencyNode dependencyNode2, ArrayList<i> arrayList, i iVar) {
        WidgetRun widgetRun = dependencyNode.f7254d;
        if (widgetRun.f7268c == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.f7279a;
            if (widgetRun != constraintWidgetContainer.f7096e && widgetRun != constraintWidgetContainer.f7098f) {
                if (iVar == null) {
                    iVar = new i(widgetRun, i12);
                    arrayList.add(iVar);
                }
                widgetRun.f7268c = iVar;
                iVar.a(widgetRun);
                for (c next : widgetRun.f7273h.f7261k) {
                    if (next instanceof DependencyNode) {
                        a((DependencyNode) next, i11, 0, dependencyNode2, arrayList, iVar);
                    }
                }
                for (c next2 : widgetRun.f7274i.f7261k) {
                    if (next2 instanceof DependencyNode) {
                        a((DependencyNode) next2, i11, 1, dependencyNode2, arrayList, iVar);
                    }
                }
                if (i11 == 1 && (widgetRun instanceof j)) {
                    for (c next3 : ((j) widgetRun).f7299k.f7261k) {
                        if (next3 instanceof DependencyNode) {
                            a((DependencyNode) next3, i11, 2, dependencyNode2, arrayList, iVar);
                        }
                    }
                }
                for (DependencyNode next4 : widgetRun.f7273h.f7262l) {
                    if (next4 == dependencyNode2) {
                        iVar.f7293b = true;
                    }
                    a(next4, i11, 0, dependencyNode2, arrayList, iVar);
                }
                for (DependencyNode next5 : widgetRun.f7274i.f7262l) {
                    if (next5 == dependencyNode2) {
                        iVar.f7293b = true;
                    }
                    a(next5, i11, 1, dependencyNode2, arrayList, iVar);
                }
                if (i11 == 1 && (widgetRun instanceof j)) {
                    for (DependencyNode a11 : ((j) widgetRun).f7299k.f7262l) {
                        a(a11, i11, 2, dependencyNode2, arrayList, iVar);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0286, code lost:
        r4 = r0.f7089a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r17) {
        /*
            r16 = this;
            r0 = r17
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r0.T0
            java.util.Iterator r1 = r1.iterator()
        L_0x0008:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x033e
            java.lang.Object r2 = r1.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r2.f7089a0
            r5 = r4[r3]
            r10 = 1
            r4 = r4[r10]
            int r6 = r2.T()
            r7 = 8
            if (r6 != r7) goto L_0x0027
            r2.f7088a = r10
            goto L_0x0008
        L_0x0027:
            float r6 = r2.A
            r11 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            r7 = 2
            if (r6 >= 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0036
            r2.f7130v = r7
        L_0x0036:
            float r6 = r2.D
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 >= 0) goto L_0x0042
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r6) goto L_0x0042
            r2.f7132w = r7
        L_0x0042:
            float r6 = r2.w()
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r8 = 3
            if (r6 <= 0) goto L_0x0078
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x005b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 == r9) goto L_0x0058
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r4 != r9) goto L_0x005b
        L_0x0058:
            r2.f7130v = r8
            goto L_0x0078
        L_0x005b:
            if (r4 != r6) goto L_0x0068
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r9) goto L_0x0065
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 != r9) goto L_0x0068
        L_0x0065:
            r2.f7132w = r8
            goto L_0x0078
        L_0x0068:
            if (r5 != r6) goto L_0x0078
            if (r4 != r6) goto L_0x0078
            int r6 = r2.f7130v
            if (r6 != 0) goto L_0x0072
            r2.f7130v = r8
        L_0x0072:
            int r6 = r2.f7132w
            if (r6 != 0) goto L_0x0078
            r2.f7132w = r8
        L_0x0078:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x008e
            int r9 = r2.f7130v
            if (r9 != r10) goto L_0x008e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f7083f
            if (r9 == 0) goto L_0x008c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f7083f
            if (r9 != 0) goto L_0x008e
        L_0x008c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x008e:
            r9 = r5
            if (r4 != r6) goto L_0x00a3
            int r5 = r2.f7132w
            if (r5 != r10) goto L_0x00a3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f7083f
            if (r5 == 0) goto L_0x00a1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f7083f
            if (r5 != 0) goto L_0x00a3
        L_0x00a1:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x00a3:
            r12 = r4
            androidx.constraintlayout.core.widgets.analyzer.h r4 = r2.f7096e
            r4.f7269d = r9
            int r5 = r2.f7130v
            r4.f7266a = r5
            androidx.constraintlayout.core.widgets.analyzer.j r4 = r2.f7098f
            r4.f7269d = r12
            int r13 = r2.f7132w
            r4.f7266a = r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r9 == r4) goto L_0x00c0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r9 == r14) goto L_0x00c0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r9 != r14) goto L_0x00cc
        L_0x00c0:
            if (r12 == r4) goto L_0x02e8
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r12 == r14) goto L_0x02e8
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 != r14) goto L_0x00cc
            goto L_0x02e8
        L_0x00cc:
            r14 = 1056964608(0x3f000000, float:0.5)
            if (r9 != r6) goto L_0x019c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r15) goto L_0x00d8
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r12 != r11) goto L_0x019c
        L_0x00d8:
            if (r5 != r8) goto L_0x0113
            if (r12 != r15) goto L_0x00e6
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r15
            r4.l(r5, r6, r7, r8, r9)
        L_0x00e6:
            int r9 = r2.y()
            float r3 = (float) r9
            float r4 = r2.f7097e0
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r7 = (int) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.h r3 = r2.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.U()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.y()
            r3.d(r4)
            r2.f7088a = r10
            goto L_0x0008
        L_0x0113:
            if (r5 != r10) goto L_0x012b
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.h r3 = r2.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r2 = r2.U()
            r3.f7288m = r2
            goto L_0x0008
        L_0x012b:
            if (r5 != r7) goto L_0x016a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r11 = r0.f7089a0
            r15 = r11[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r15 == r7) goto L_0x0139
            r11 = r11[r3]
            if (r11 != r4) goto L_0x019c
        L_0x0139:
            float r3 = r2.A
            int r4 = r17.U()
            float r4 = (float) r4
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r3 = (int) r3
            int r9 = r2.y()
            r4 = r16
            r5 = r2
            r6 = r7
            r7 = r3
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.h r3 = r2.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.U()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.y()
            r3.d(r4)
            r2.f7088a = r10
            goto L_0x0008
        L_0x016a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r2.X
            r11 = r7[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f7083f
            if (r11 == 0) goto L_0x0178
            r7 = r7[r10]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.f7083f
            if (r7 != 0) goto L_0x019c
        L_0x0178:
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.h r3 = r2.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.U()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.y()
            r3.d(r4)
            r2.f7088a = r10
            goto L_0x0008
        L_0x019c:
            if (r12 != r6) goto L_0x0278
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r9 == r11) goto L_0x01a6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r9 != r7) goto L_0x0278
        L_0x01a6:
            if (r13 != r8) goto L_0x01ec
            if (r9 != r11) goto L_0x01b4
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r11
            r8 = r11
            r4.l(r5, r6, r7, r8, r9)
        L_0x01b4:
            int r7 = r2.U()
            float r3 = r2.f7097e0
            int r4 = r2.x()
            r5 = -1
            if (r4 != r5) goto L_0x01c5
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = r4 / r3
        L_0x01c5:
            float r4 = (float) r7
            float r4 = r4 * r3
            float r4 = r4 + r14
            int r9 = (int) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.h r3 = r2.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.U()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.y()
            r3.d(r4)
            r2.f7088a = r10
            goto L_0x0008
        L_0x01ec:
            if (r13 != r10) goto L_0x0205
            r7 = 0
            r3 = 0
            r4 = r16
            r5 = r2
            r6 = r9
            r8 = r11
            r9 = r3
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r2 = r2.y()
            r3.f7288m = r2
            goto L_0x0008
        L_0x0205:
            r7 = 2
            if (r13 != r7) goto L_0x0245
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r0.f7089a0
            r8 = r7[r10]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r8 == r11) goto L_0x0214
            r7 = r7[r10]
            if (r7 != r4) goto L_0x0278
        L_0x0214:
            float r3 = r2.D
            int r7 = r2.U()
            int r4 = r17.y()
            float r4 = (float) r4
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r3 = (int) r3
            r4 = r16
            r5 = r2
            r6 = r9
            r8 = r11
            r9 = r3
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.h r3 = r2.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.U()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.y()
            r3.d(r4)
            r2.f7088a = r10
            goto L_0x0008
        L_0x0245:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r2.X
            r7 = 2
            r15 = r4[r7]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r15.f7083f
            if (r7 == 0) goto L_0x0254
            r4 = r4[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f7083f
            if (r4 != 0) goto L_0x0278
        L_0x0254:
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r11
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.h r3 = r2.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.U()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.y()
            r3.d(r4)
            r2.f7088a = r10
            goto L_0x0008
        L_0x0278:
            if (r9 != r6) goto L_0x0008
            if (r12 != r6) goto L_0x0008
            if (r5 == r10) goto L_0x02c7
            if (r13 != r10) goto L_0x0281
            goto L_0x02c7
        L_0x0281:
            r4 = 2
            if (r13 != r4) goto L_0x0008
            if (r5 != r4) goto L_0x0008
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.f7089a0
            r3 = r4[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r3 != r8) goto L_0x0008
            r3 = r4[r10]
            if (r3 != r8) goto L_0x0008
            float r3 = r2.A
            float r4 = r2.D
            int r5 = r17.U()
            float r5 = (float) r5
            float r3 = r3 * r5
            float r3 = r3 + r14
            int r7 = (int) r3
            int r3 = r17.y()
            float r3 = (float) r3
            float r4 = r4 * r3
            float r4 = r4 + r14
            int r9 = (int) r4
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.h r3 = r2.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.U()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.y()
            r3.d(r4)
            r2.f7088a = r10
            goto L_0x0008
        L_0x02c7:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.h r3 = r2.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.U()
            r3.f7288m = r4
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r2 = r2.y()
            r3.f7288m = r2
            goto L_0x0008
        L_0x02e8:
            int r3 = r2.U()
            if (r9 != r4) goto L_0x0301
            int r3 = r17.U()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.P
            int r5 = r5.f7084g
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.R
            int r5 = r5.f7084g
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r7 = r3
            r6 = r5
            goto L_0x0303
        L_0x0301:
            r7 = r3
            r6 = r9
        L_0x0303:
            int r3 = r2.y()
            if (r12 != r4) goto L_0x031c
            int r3 = r17.y()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r2.Q
            int r4 = r4.f7084g
            int r3 = r3 - r4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r2.S
            int r4 = r4.f7084g
            int r3 = r3 - r4
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r9 = r3
            r8 = r4
            goto L_0x031e
        L_0x031c:
            r9 = r3
            r8 = r12
        L_0x031e:
            r4 = r16
            r5 = r2
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.h r3 = r2.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.U()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f7270e
            int r4 = r2.y()
            r3.d(r4)
            r2.f7088a = r10
            goto L_0x0008
        L_0x033e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.d.b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):boolean");
    }

    public void c() {
        d(this.f7283e);
        this.f7287i.clear();
        i.f7291h = 0;
        i(this.f7279a.f7096e, 0, this.f7287i);
        i(this.f7279a.f7098f, 1, this.f7287i);
        this.f7280b = false;
    }

    public void d(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.f7282d.f7096e.f();
        this.f7282d.f7098f.f();
        arrayList.add(this.f7282d.f7096e);
        arrayList.add(this.f7282d.f7098f);
        Iterator<ConstraintWidget> it2 = this.f7282d.T0.iterator();
        HashSet hashSet = null;
        while (it2.hasNext()) {
            ConstraintWidget next = it2.next();
            if (next instanceof Guideline) {
                arrayList.add(new f(next));
            } else {
                if (next.g0()) {
                    if (next.f7092c == null) {
                        next.f7092c = new b(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f7092c);
                } else {
                    arrayList.add(next.f7096e);
                }
                if (next.i0()) {
                    if (next.f7094d == null) {
                        next.f7094d = new b(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f7094d);
                } else {
                    arrayList.add(next.f7098f);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new g(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            it3.next().f();
        }
        Iterator<WidgetRun> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            WidgetRun next2 = it4.next();
            if (next2.f7267b != this.f7282d) {
                next2.d();
            }
        }
    }

    public final int e(ConstraintWidgetContainer constraintWidgetContainer, int i11) {
        int size = this.f7287i.size();
        long j11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            j11 = Math.max(j11, this.f7287i.get(i12).b(constraintWidgetContainer, i11));
        }
        return (int) j11;
    }

    public boolean f(boolean z11) {
        boolean z12;
        boolean z13 = true;
        boolean z14 = z11 & true;
        if (this.f7280b || this.f7281c) {
            Iterator<ConstraintWidget> it2 = this.f7279a.T0.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                next.o();
                next.f7088a = false;
                next.f7096e.r();
                next.f7098f.q();
            }
            this.f7279a.o();
            ConstraintWidgetContainer constraintWidgetContainer = this.f7279a;
            constraintWidgetContainer.f7088a = false;
            constraintWidgetContainer.f7096e.r();
            this.f7279a.f7098f.q();
            this.f7281c = false;
        }
        if (b(this.f7282d)) {
            return false;
        }
        this.f7279a.h1(0);
        this.f7279a.i1(0);
        ConstraintWidget.DimensionBehaviour v11 = this.f7279a.v(0);
        ConstraintWidget.DimensionBehaviour v12 = this.f7279a.v(1);
        if (this.f7280b) {
            c();
        }
        int V = this.f7279a.V();
        int W = this.f7279a.W();
        this.f7279a.f7096e.f7273h.d(V);
        this.f7279a.f7098f.f7273h.d(W);
        m();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (v11 == dimensionBehaviour || v12 == dimensionBehaviour) {
            if (z14) {
                Iterator<WidgetRun> it3 = this.f7283e.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (!it3.next().m()) {
                            z14 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z14 && v11 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f7279a.K0(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.f7279a;
                constraintWidgetContainer2.f1(e(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f7279a;
                constraintWidgetContainer3.f7096e.f7270e.d(constraintWidgetContainer3.U());
            }
            if (z14 && v12 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f7279a.b1(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.f7279a;
                constraintWidgetContainer4.G0(e(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.f7279a;
                constraintWidgetContainer5.f7098f.f7270e.d(constraintWidgetContainer5.y());
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer6 = this.f7279a;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidgetContainer6.f7089a0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 == dimensionBehaviour3 || dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int U = constraintWidgetContainer6.U() + V;
            this.f7279a.f7096e.f7274i.d(U);
            this.f7279a.f7096e.f7270e.d(U - V);
            m();
            ConstraintWidgetContainer constraintWidgetContainer7 = this.f7279a;
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer7.f7089a0;
            if (dimensionBehaviourArr2[1] == dimensionBehaviour3 || dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int y11 = constraintWidgetContainer7.y() + W;
                this.f7279a.f7098f.f7274i.d(y11);
                this.f7279a.f7098f.f7270e.d(y11 - W);
            }
            m();
            z12 = true;
        } else {
            z12 = false;
        }
        Iterator<WidgetRun> it4 = this.f7283e.iterator();
        while (it4.hasNext()) {
            WidgetRun next2 = it4.next();
            if (next2.f7267b != this.f7279a || next2.f7272g) {
                next2.e();
            }
        }
        Iterator<WidgetRun> it5 = this.f7283e.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            WidgetRun next3 = it5.next();
            if ((z12 || next3.f7267b != this.f7279a) && (!next3.f7273h.f7260j || ((!next3.f7274i.f7260j && !(next3 instanceof f)) || (!next3.f7270e.f7260j && !(next3 instanceof b) && !(next3 instanceof f))))) {
                z13 = false;
            }
        }
        z13 = false;
        this.f7279a.K0(v11);
        this.f7279a.b1(v12);
        return z13;
    }

    public boolean g(boolean z11) {
        if (this.f7280b) {
            Iterator<ConstraintWidget> it2 = this.f7279a.T0.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                next.o();
                next.f7088a = false;
                h hVar = next.f7096e;
                hVar.f7270e.f7260j = false;
                hVar.f7272g = false;
                hVar.r();
                j jVar = next.f7098f;
                jVar.f7270e.f7260j = false;
                jVar.f7272g = false;
                jVar.q();
            }
            this.f7279a.o();
            ConstraintWidgetContainer constraintWidgetContainer = this.f7279a;
            constraintWidgetContainer.f7088a = false;
            h hVar2 = constraintWidgetContainer.f7096e;
            hVar2.f7270e.f7260j = false;
            hVar2.f7272g = false;
            hVar2.r();
            j jVar2 = this.f7279a.f7098f;
            jVar2.f7270e.f7260j = false;
            jVar2.f7272g = false;
            jVar2.q();
            c();
        }
        if (b(this.f7282d)) {
            return false;
        }
        this.f7279a.h1(0);
        this.f7279a.i1(0);
        this.f7279a.f7096e.f7273h.d(0);
        this.f7279a.f7098f.f7273h.d(0);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0143 A[EDGE_INSN: B:77:0x0143->B:62:0x0143 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(boolean r10, int r11) {
        /*
            r9 = this;
            r0 = 1
            r10 = r10 & r0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r9.f7279a
            r2 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r1.v(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r3 = r9.f7279a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.v(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r9.f7279a
            int r4 = r4.V()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r9.f7279a
            int r5 = r5.W()
            if (r10 == 0) goto L_0x0089
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 == r6) goto L_0x0023
            if (r3 != r6) goto L_0x0089
        L_0x0023:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r6 = r9.f7283e
            java.util.Iterator r6 = r6.iterator()
        L_0x0029:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0040
            java.lang.Object r7 = r6.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            int r8 = r7.f7271f
            if (r8 != r11) goto L_0x0029
            boolean r7 = r7.m()
            if (r7 != 0) goto L_0x0029
            r10 = r2
        L_0x0040:
            if (r11 != 0) goto L_0x0066
            if (r10 == 0) goto L_0x0089
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r10) goto L_0x0089
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f7279a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.K0(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f7279a
            int r6 = r9.e(r10, r2)
            r10.f1(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f7279a
            androidx.constraintlayout.core.widgets.analyzer.h r6 = r10.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r6 = r6.f7270e
            int r10 = r10.U()
            r6.d(r10)
            goto L_0x0089
        L_0x0066:
            if (r10 == 0) goto L_0x0089
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r10) goto L_0x0089
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f7279a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.b1(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f7279a
            int r6 = r9.e(r10, r0)
            r10.G0(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f7279a
            androidx.constraintlayout.core.widgets.analyzer.j r6 = r10.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r6 = r6.f7270e
            int r10 = r10.y()
            r6.d(r10)
        L_0x0089:
            if (r11 != 0) goto L_0x00b4
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f7279a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r10.f7089a0
            r6 = r5[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r6 == r7) goto L_0x009b
            r5 = r5[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r5 != r6) goto L_0x00c5
        L_0x009b:
            int r10 = r10.U()
            int r10 = r10 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r9.f7279a
            androidx.constraintlayout.core.widgets.analyzer.h r5 = r5.f7096e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r5.f7274i
            r5.d(r10)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r9.f7279a
            androidx.constraintlayout.core.widgets.analyzer.h r5 = r5.f7096e
            androidx.constraintlayout.core.widgets.analyzer.e r5 = r5.f7270e
            int r10 = r10 - r4
            r5.d(r10)
            goto L_0x00df
        L_0x00b4:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f7279a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r10.f7089a0
            r6 = r4[r0]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r6 == r7) goto L_0x00c7
            r4 = r4[r0]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r4 != r6) goto L_0x00c5
            goto L_0x00c7
        L_0x00c5:
            r10 = r2
            goto L_0x00e0
        L_0x00c7:
            int r10 = r10.y()
            int r10 = r10 + r5
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r9.f7279a
            androidx.constraintlayout.core.widgets.analyzer.j r4 = r4.f7098f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r4.f7274i
            r4.d(r10)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r9.f7279a
            androidx.constraintlayout.core.widgets.analyzer.j r4 = r4.f7098f
            androidx.constraintlayout.core.widgets.analyzer.e r4 = r4.f7270e
            int r10 = r10 - r5
            r4.d(r10)
        L_0x00df:
            r10 = r0
        L_0x00e0:
            r9.m()
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r9.f7283e
            java.util.Iterator r4 = r4.iterator()
        L_0x00e9:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0109
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r5 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r5
            int r6 = r5.f7271f
            if (r6 == r11) goto L_0x00fa
            goto L_0x00e9
        L_0x00fa:
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.f7267b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r9.f7279a
            if (r6 != r7) goto L_0x0105
            boolean r6 = r5.f7272g
            if (r6 != 0) goto L_0x0105
            goto L_0x00e9
        L_0x0105:
            r5.e()
            goto L_0x00e9
        L_0x0109:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r9.f7283e
            java.util.Iterator r4 = r4.iterator()
        L_0x010f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0143
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r5 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r5
            int r6 = r5.f7271f
            if (r6 == r11) goto L_0x0120
            goto L_0x010f
        L_0x0120:
            if (r10 != 0) goto L_0x0129
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.f7267b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r9.f7279a
            if (r6 != r7) goto L_0x0129
            goto L_0x010f
        L_0x0129:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r6 = r5.f7273h
            boolean r6 = r6.f7260j
            if (r6 != 0) goto L_0x0131
        L_0x012f:
            r0 = r2
            goto L_0x0143
        L_0x0131:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r6 = r5.f7274i
            boolean r6 = r6.f7260j
            if (r6 != 0) goto L_0x0138
            goto L_0x012f
        L_0x0138:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.analyzer.b
            if (r6 != 0) goto L_0x010f
            androidx.constraintlayout.core.widgets.analyzer.e r5 = r5.f7270e
            boolean r5 = r5.f7260j
            if (r5 != 0) goto L_0x010f
            goto L_0x012f
        L_0x0143:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f7279a
            r10.K0(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f7279a
            r10.b1(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.d.h(boolean, int):boolean");
    }

    public final void i(WidgetRun widgetRun, int i11, ArrayList<i> arrayList) {
        for (c next : widgetRun.f7273h.f7261k) {
            if (next instanceof DependencyNode) {
                a((DependencyNode) next, i11, 0, widgetRun.f7274i, arrayList, (i) null);
            } else if (next instanceof WidgetRun) {
                a(((WidgetRun) next).f7273h, i11, 0, widgetRun.f7274i, arrayList, (i) null);
            }
        }
        for (c next2 : widgetRun.f7274i.f7261k) {
            if (next2 instanceof DependencyNode) {
                a((DependencyNode) next2, i11, 1, widgetRun.f7273h, arrayList, (i) null);
            } else if (next2 instanceof WidgetRun) {
                a(((WidgetRun) next2).f7274i, i11, 1, widgetRun.f7273h, arrayList, (i) null);
            }
        }
        if (i11 == 1) {
            for (c next3 : ((j) widgetRun).f7299k.f7261k) {
                if (next3 instanceof DependencyNode) {
                    a((DependencyNode) next3, i11, 2, (DependencyNode) null, arrayList, (i) null);
                }
            }
        }
    }

    public void j() {
        this.f7280b = true;
    }

    public void k() {
        this.f7281c = true;
    }

    public final void l(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i11, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i12) {
        BasicMeasure.Measure measure = this.f7286h;
        measure.f7241a = dimensionBehaviour;
        measure.f7242b = dimensionBehaviour2;
        measure.f7243c = i11;
        measure.f7244d = i12;
        this.f7285g.b(constraintWidget, measure);
        constraintWidget.f1(this.f7286h.f7245e);
        constraintWidget.G0(this.f7286h.f7246f);
        constraintWidget.F0(this.f7286h.f7248h);
        constraintWidget.v0(this.f7286h.f7247g);
    }

    public void m() {
        e eVar;
        Iterator<ConstraintWidget> it2 = this.f7279a.T0.iterator();
        while (it2.hasNext()) {
            ConstraintWidget next = it2.next();
            if (!next.f7088a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.f7089a0;
                boolean z11 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i11 = next.f7130v;
                int i12 = next.f7132w;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z12 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i11 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i12 == 1)) {
                    z11 = true;
                }
                e eVar2 = next.f7096e.f7270e;
                boolean z13 = eVar2.f7260j;
                e eVar3 = next.f7098f.f7270e;
                boolean z14 = eVar3.f7260j;
                if (z13 && z14) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    l(next, dimensionBehaviour4, eVar2.f7257g, dimensionBehaviour4, eVar3.f7257g);
                    next.f7088a = true;
                } else if (z13 && z11) {
                    l(next, ConstraintWidget.DimensionBehaviour.FIXED, eVar2.f7257g, dimensionBehaviour3, eVar3.f7257g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f7098f.f7270e.f7288m = next.y();
                    } else {
                        next.f7098f.f7270e.d(next.y());
                        next.f7088a = true;
                    }
                } else if (z14 && z12) {
                    l(next, dimensionBehaviour3, eVar2.f7257g, ConstraintWidget.DimensionBehaviour.FIXED, eVar3.f7257g);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f7096e.f7270e.f7288m = next.U();
                    } else {
                        next.f7096e.f7270e.d(next.U());
                        next.f7088a = true;
                    }
                }
                if (next.f7088a && (eVar = next.f7098f.f7300l) != null) {
                    eVar.d(next.q());
                }
            }
        }
    }

    public void n(BasicMeasure.a aVar) {
        this.f7285g = aVar;
    }
}
