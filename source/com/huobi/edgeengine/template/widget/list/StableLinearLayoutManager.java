package com.huobi.edgeengine.template.widget.list;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StableLinearLayoutManager extends LinearLayoutManager {
    public StableLinearLayoutManager(Context context) {
        super(context);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e11) {
            Log.e("EdgeEngine", "StableLinearLayoutManager-->onLayoutChildren:", e11);
        }
    }

    public int scrollVerticallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i11, recycler, state);
        } catch (Exception unused) {
            return 0;
        }
    }

    public StableLinearLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }
}
