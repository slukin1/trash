package androidx.core.view;

import android.view.ViewParent;
import d10.l;
import kotlin.jvm.internal.FunctionReferenceImpl;

final /* synthetic */ class ViewKt$ancestors$1 extends FunctionReferenceImpl implements l<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    public final ViewParent invoke(ViewParent viewParent) {
        return viewParent.getParent();
    }
}
