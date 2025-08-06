package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

public class i {

    /* renamed from: h  reason: collision with root package name */
    public static int f7291h;

    /* renamed from: a  reason: collision with root package name */
    public int f7292a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7293b = false;

    /* renamed from: c  reason: collision with root package name */
    public WidgetRun f7294c = null;

    /* renamed from: d  reason: collision with root package name */
    public WidgetRun f7295d = null;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<WidgetRun> f7296e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public int f7297f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f7298g;

    public i(WidgetRun widgetRun, int i11) {
        int i12 = f7291h;
        this.f7297f = i12;
        f7291h = i12 + 1;
        this.f7294c = widgetRun;
        this.f7295d = widgetRun;
        this.f7298g = i11;
    }

    public void a(WidgetRun widgetRun) {
        this.f7296e.add(widgetRun);
        this.f7295d = widgetRun;
    }

    public long b(ConstraintWidgetContainer constraintWidgetContainer, int i11) {
        int i12;
        long j11;
        WidgetRun widgetRun = this.f7294c;
        long j12 = 0;
        if (widgetRun instanceof b) {
            if (((b) widgetRun).f7271f != i11) {
                return 0;
            }
        } else if (i11 == 0) {
            if (!(widgetRun instanceof h)) {
                return 0;
            }
        } else if (!(widgetRun instanceof j)) {
            return 0;
        }
        DependencyNode dependencyNode = (i11 == 0 ? constraintWidgetContainer.f7096e : constraintWidgetContainer.f7098f).f7273h;
        DependencyNode dependencyNode2 = (i11 == 0 ? constraintWidgetContainer.f7096e : constraintWidgetContainer.f7098f).f7274i;
        boolean contains = widgetRun.f7273h.f7262l.contains(dependencyNode);
        boolean contains2 = this.f7294c.f7274i.f7262l.contains(dependencyNode2);
        long j13 = this.f7294c.j();
        if (contains && contains2) {
            long d11 = d(this.f7294c.f7273h, 0);
            long c11 = c(this.f7294c.f7274i, 0);
            long j14 = d11 - j13;
            WidgetRun widgetRun2 = this.f7294c;
            int i13 = widgetRun2.f7274i.f7256f;
            if (j14 >= ((long) (-i13))) {
                j14 += (long) i13;
            }
            int i14 = widgetRun2.f7273h.f7256f;
            long j15 = ((-c11) - j13) - ((long) i14);
            if (j15 >= ((long) i14)) {
                j15 -= (long) i14;
            }
            float r11 = widgetRun2.f7267b.r(i11);
            if (r11 > 0.0f) {
                j12 = (long) ((((float) j15) / r11) + (((float) j14) / (1.0f - r11)));
            }
            float f11 = (float) j12;
            long j16 = ((long) ((f11 * r11) + 0.5f)) + j13 + ((long) ((f11 * (1.0f - r11)) + 0.5f));
            WidgetRun widgetRun3 = this.f7294c;
            j11 = ((long) widgetRun3.f7273h.f7256f) + j16;
            i12 = widgetRun3.f7274i.f7256f;
        } else if (contains) {
            DependencyNode dependencyNode3 = this.f7294c.f7273h;
            return Math.max(d(dependencyNode3, (long) dependencyNode3.f7256f), ((long) this.f7294c.f7273h.f7256f) + j13);
        } else if (contains2) {
            DependencyNode dependencyNode4 = this.f7294c.f7274i;
            return Math.max(-c(dependencyNode4, (long) dependencyNode4.f7256f), ((long) (-this.f7294c.f7274i.f7256f)) + j13);
        } else {
            WidgetRun widgetRun4 = this.f7294c;
            j11 = ((long) widgetRun4.f7273h.f7256f) + widgetRun4.j();
            i12 = this.f7294c.f7274i.f7256f;
        }
        return j11 - ((long) i12);
    }

    public final long c(DependencyNode dependencyNode, long j11) {
        WidgetRun widgetRun = dependencyNode.f7254d;
        if (widgetRun instanceof g) {
            return j11;
        }
        int size = dependencyNode.f7261k.size();
        long j12 = j11;
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = dependencyNode.f7261k.get(i11);
            if (cVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) cVar;
                if (dependencyNode2.f7254d != widgetRun) {
                    j12 = Math.min(j12, c(dependencyNode2, ((long) dependencyNode2.f7256f) + j11));
                }
            }
        }
        if (dependencyNode != widgetRun.f7274i) {
            return j12;
        }
        long j13 = j11 - widgetRun.j();
        return Math.min(Math.min(j12, c(widgetRun.f7273h, j13)), j13 - ((long) widgetRun.f7273h.f7256f));
    }

    public final long d(DependencyNode dependencyNode, long j11) {
        WidgetRun widgetRun = dependencyNode.f7254d;
        if (widgetRun instanceof g) {
            return j11;
        }
        int size = dependencyNode.f7261k.size();
        long j12 = j11;
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = dependencyNode.f7261k.get(i11);
            if (cVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) cVar;
                if (dependencyNode2.f7254d != widgetRun) {
                    j12 = Math.max(j12, d(dependencyNode2, ((long) dependencyNode2.f7256f) + j11));
                }
            }
        }
        if (dependencyNode != widgetRun.f7273h) {
            return j12;
        }
        long j13 = j11 + widgetRun.j();
        return Math.max(Math.max(j12, d(widgetRun.f7274i, j13)), j13 - ((long) widgetRun.f7274i.f7256f));
    }
}
