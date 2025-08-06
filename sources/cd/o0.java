package cd;

import android.view.View;

public final class o0 {
    public static void a(View view, String str, boolean z11) {
        k kVar = new k(view.getContext(), z11, str);
        kVar.e(str);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        kVar.g(view, iArr[0] - (view.getWidth() / 2));
    }
}
