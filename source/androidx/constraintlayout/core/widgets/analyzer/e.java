package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

public class e extends DependencyNode {

    /* renamed from: m  reason: collision with root package name */
    public int f7288m;

    public e(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof h) {
            this.f7255e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f7255e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
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
}
