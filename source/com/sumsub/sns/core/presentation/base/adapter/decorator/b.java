package com.sumsub.sns.core.presentation.base.adapter.decorator;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class b extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f30906a;

    public b(int i11) {
        this.f30906a = i11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (recyclerView.getChildAdapterPosition(view) != (adapter != null ? adapter.getItemCount() : 0) - 1) {
            rect.bottom = this.f30906a;
        }
    }
}
