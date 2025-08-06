package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import d10.l;
import kotlin.jvm.internal.Lambda;

final class ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1 extends Lambda implements l<View, View> {
    public static final ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1 INSTANCE = new ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1();

    public ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1() {
        super(1);
    }

    public final View invoke(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
