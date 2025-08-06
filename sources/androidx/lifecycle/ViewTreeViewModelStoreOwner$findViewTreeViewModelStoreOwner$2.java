package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R$id;
import d10.l;
import kotlin.jvm.internal.Lambda;

final class ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 extends Lambda implements l<View, q0> {
    public static final ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 INSTANCE = new ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2();

    public ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2() {
        super(1);
    }

    public final q0 invoke(View view) {
        Object tag = view.getTag(R$id.view_tree_view_model_store_owner);
        if (tag instanceof q0) {
            return (q0) tag;
        }
        return null;
    }
}
