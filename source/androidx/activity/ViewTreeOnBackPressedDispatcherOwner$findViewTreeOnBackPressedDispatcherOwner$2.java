package androidx.activity;

import android.view.View;
import d10.l;
import kotlin.jvm.internal.Lambda;

final class ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 extends Lambda implements l<View, q> {
    public static final ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 INSTANCE = new ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2();

    public ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2() {
        super(1);
    }

    public final q invoke(View view) {
        Object tag = view.getTag(R$id.view_tree_on_back_pressed_dispatcher_owner);
        if (tag instanceof q) {
            return (q) tag;
        }
        return null;
    }
}
