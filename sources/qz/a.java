package qz;

import android.view.View;
import io.flutter.util.ViewUtils;

public final /* synthetic */ class a implements ViewUtils.ViewVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class[] f70495a;

    public /* synthetic */ a(Class[] clsArr) {
        this.f70495a = clsArr;
    }

    public final boolean run(View view) {
        return ViewUtils.lambda$hasChildViewOfType$1(this.f70495a, view);
    }
}
