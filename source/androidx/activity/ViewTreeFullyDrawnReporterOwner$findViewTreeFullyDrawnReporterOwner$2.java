package androidx.activity;

import android.view.View;
import d10.l;
import kotlin.jvm.internal.Lambda;

final class ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2 extends Lambda implements l<View, m> {
    public static final ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2 INSTANCE = new ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2();

    public ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2() {
        super(1);
    }

    public final m invoke(View view) {
        Object tag = view.getTag(R$id.report_drawn);
        if (tag instanceof m) {
            return (m) tag;
        }
        return null;
    }
}
