package androidx.savedstate;

import android.view.View;
import d10.l;
import kotlin.jvm.internal.Lambda;

final class ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 extends Lambda implements l<View, c> {
    public static final ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 INSTANCE = new ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2();

    public ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2() {
        super(1);
    }

    public final c invoke(View view) {
        Object tag = view.getTag(R$id.view_tree_saved_state_registry_owner);
        if (tag instanceof c) {
            return (c) tag;
        }
        return null;
    }
}
