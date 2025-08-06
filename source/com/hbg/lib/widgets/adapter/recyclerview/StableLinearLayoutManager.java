package com.hbg.lib.widgets.adapter.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import i6.d;

public class StableLinearLayoutManager extends LinearLayoutManager {
    public StableLinearLayoutManager(Context context) {
        super(context);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e11) {
            d.d("-->" + e11.toString());
            e11.printStackTrace();
        }
    }

    public int scrollVerticallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i11, recycler, state);
        } catch (Exception unused) {
            return 0;
        }
    }

    public StableLinearLayoutManager(Context context, int i11, boolean z11) {
        super(context, i11, z11);
    }

    public StableLinearLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }
}
