package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class AnimateLayoutChangeDetector {
    private static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS;
    private LinearLayoutManager mLayoutManager;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public AnimateLayoutChangeDetector(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    private boolean arePagesLaidOutContiguously() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i11;
        int i12;
        int i13;
        int i14;
        int childCount = this.mLayoutManager.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z11 = this.mLayoutManager.getOrientation() == 0;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = childCount;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i15 = 0;
        while (i15 < childCount) {
            View childAt = this.mLayoutManager.getChildAt(i15);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = ZERO_MARGIN_LAYOUT_PARAMS;
                }
                int[] iArr3 = iArr2[i15];
                if (z11) {
                    i12 = childAt.getLeft();
                    i11 = marginLayoutParams.leftMargin;
                } else {
                    i12 = childAt.getTop();
                    i11 = marginLayoutParams.topMargin;
                }
                iArr3[0] = i12 - i11;
                int[] iArr4 = iArr2[i15];
                if (z11) {
                    i14 = childAt.getRight();
                    i13 = marginLayoutParams.rightMargin;
                } else {
                    i14 = childAt.getBottom();
                    i13 = marginLayoutParams.bottomMargin;
                }
                iArr4[1] = i14 + i13;
                i15++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr2, new Comparator<int[]>() {
            public int compare(int[] iArr, int[] iArr2) {
                return iArr[0] - iArr2[0];
            }
        });
        for (int i16 = 1; i16 < childCount; i16++) {
            if (iArr2[i16 - 1][1] != iArr2[i16][0]) {
                return false;
            }
        }
        int i17 = iArr2[0][1] - iArr2[0][0];
        if (iArr2[0][0] > 0 || iArr2[childCount - 1][1] < i17) {
            return false;
        }
        return true;
    }

    private boolean hasRunningChangingLayoutTransition() {
        int childCount = this.mLayoutManager.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(i11))) {
                return true;
            }
        }
        return false;
    }

    public boolean mayHaveInterferingAnimations() {
        if ((!arePagesLaidOutContiguously() || this.mLayoutManager.getChildCount() <= 1) && hasRunningChangingLayoutTransition()) {
            return true;
        }
        return false;
    }

    private static boolean hasRunningChangingLayoutTransition(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                if (hasRunningChangingLayoutTransition(viewGroup.getChildAt(i11))) {
                    return true;
                }
            }
        }
        return false;
    }
}
