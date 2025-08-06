package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;

class SmoothCalendarLayoutManager extends LinearLayoutManager {
    private static final float MILLISECONDS_PER_INCH = 100.0f;

    public SmoothCalendarLayoutManager(Context context, int i11, boolean z11) {
        super(context, i11, z11);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
        AnonymousClass1 r22 = new n(recyclerView.getContext()) {
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
        r22.setTargetPosition(i11);
        startSmoothScroll(r22);
    }
}
