package com.facebook.stetho.common.android;

import android.view.View;
import android.view.ViewGroup;

public final class ViewGroupUtil {
    private ViewGroupUtil() {
    }

    public static int findChildIndex(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (viewGroup.getChildAt(i11) == view) {
                return i11;
            }
        }
        return -1;
    }
}
