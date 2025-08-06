package com.tencent.qcloud.tuikit.timcommon.component;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomLinearLayoutManager extends LinearLayoutManager {
    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e11) {
            Log.w("CustomLinearLayoutManager", e11.getLocalizedMessage());
        }
    }

    public CustomLinearLayoutManager(Context context, int i11, boolean z11) {
        super(context, i11, z11);
    }

    public CustomLinearLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }
}
