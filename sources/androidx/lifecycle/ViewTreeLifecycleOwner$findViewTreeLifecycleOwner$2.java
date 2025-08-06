package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R$id;
import d10.l;
import kotlin.jvm.internal.Lambda;

final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 extends Lambda implements l<View, LifecycleOwner> {
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 INSTANCE = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2();

    public ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2() {
        super(1);
    }

    public final LifecycleOwner invoke(View view) {
        Object tag = view.getTag(R$id.view_tree_lifecycle_owner);
        if (tag instanceof LifecycleOwner) {
            return (LifecycleOwner) tag;
        }
        return null;
    }
}
