package com.sumsub.sns.presentation.screen.preview.photo;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f39946a;

    public a(int i11) {
        this.f39946a = i11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i11 = this.f39946a;
        rect.right = i11;
        rect.left = i11;
    }
}
