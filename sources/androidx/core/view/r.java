package androidx.core.view;

import android.view.View;

public interface r extends t {
    void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13);

    void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15);

    void onNestedScrollAccepted(View view, View view2, int i11, int i12);

    boolean onStartNestedScroll(View view, View view2, int i11, int i12);

    void onStopNestedScroll(View view, int i11);
}
