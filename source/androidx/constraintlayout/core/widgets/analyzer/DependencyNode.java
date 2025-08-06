package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.List;

public class DependencyNode implements c {

    /* renamed from: a  reason: collision with root package name */
    public c f7251a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7252b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7253c = false;

    /* renamed from: d  reason: collision with root package name */
    public WidgetRun f7254d;

    /* renamed from: e  reason: collision with root package name */
    public Type f7255e = Type.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    public int f7256f;

    /* renamed from: g  reason: collision with root package name */
    public int f7257g;

    /* renamed from: h  reason: collision with root package name */
    public int f7258h = 1;

    /* renamed from: i  reason: collision with root package name */
    public e f7259i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7260j = false;

    /* renamed from: k  reason: collision with root package name */
    public List<c> f7261k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public List<DependencyNode> f7262l = new ArrayList();

    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f7254d = widgetRun;
    }

    public void a(c cVar) {
        for (DependencyNode dependencyNode : this.f7262l) {
            if (!dependencyNode.f7260j) {
                return;
            }
        }
        this.f7253c = true;
        c cVar2 = this.f7251a;
        if (cVar2 != null) {
            cVar2.a(this);
        }
        if (this.f7252b) {
            this.f7254d.a(this);
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i11 = 0;
        for (DependencyNode next : this.f7262l) {
            if (!(next instanceof e)) {
                i11++;
                dependencyNode2 = next;
            }
        }
        if (dependencyNode2 != null && i11 == 1 && dependencyNode2.f7260j) {
            e eVar = this.f7259i;
            if (eVar != null) {
                if (eVar.f7260j) {
                    this.f7256f = this.f7258h * eVar.f7257g;
                } else {
                    return;
                }
            }
            d(dependencyNode2.f7257g + this.f7256f);
        }
        c cVar3 = this.f7251a;
        if (cVar3 != null) {
            cVar3.a(this);
        }
    }

    public void b(c cVar) {
        this.f7261k.add(cVar);
        if (this.f7260j) {
            cVar.a(cVar);
        }
    }

    public void c() {
        this.f7262l.clear();
        this.f7261k.clear();
        this.f7260j = false;
        this.f7257g = 0;
        this.f7253c = false;
        this.f7252b = false;
    }

    public void d(int i11) {
        if (!this.f7260j) {
            this.f7260j = true;
            this.f7257g = i11;
            for (c next : this.f7261k) {
                next.a(next);
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f7254d.f7267b.u());
        sb2.append(":");
        sb2.append(this.f7255e);
        sb2.append("(");
        sb2.append(this.f7260j ? Integer.valueOf(this.f7257g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f7262l.size());
        sb2.append(":d=");
        sb2.append(this.f7261k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
