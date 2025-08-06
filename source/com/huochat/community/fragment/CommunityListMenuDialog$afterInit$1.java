package com.huochat.community.fragment;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.huochat.community.R;

public final class CommunityListMenuDialog$afterInit$1 extends RecyclerView.ItemDecoration {
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int dimensionPixelOffset = recyclerView.getResources().getDimensionPixelOffset(R.dimen.dimen_5);
        rect.set(0, recyclerView.getChildAdapterPosition(view) == 0 ? dimensionPixelOffset : 0, 0, dimensionPixelOffset);
    }
}
