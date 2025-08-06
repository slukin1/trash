package androidx.core.view;

import android.view.View;

public interface t {
    boolean onNestedFling(View view, float f11, float f12, boolean z11);

    boolean onNestedPreFling(View view, float f11, float f12);

    void onNestedPreScroll(View view, int i11, int i12, int[] iArr);

    void onNestedScroll(View view, int i11, int i12, int i13, int i14);

    void onNestedScrollAccepted(View view, View view2, int i11);

    boolean onStartNestedScroll(View view, View view2, int i11);

    void onStopNestedScroll(View view);
}
