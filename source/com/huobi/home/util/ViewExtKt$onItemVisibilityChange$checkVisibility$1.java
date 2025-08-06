package com.huobi.home.util;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d10.a;
import d10.q;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class ViewExtKt$onItemVisibilityChange$checkVisibility$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ q<View, Integer, Boolean, Unit> $block;
    public final /* synthetic */ float $percent;
    public final /* synthetic */ RecyclerView $this_onItemVisibilityChange;
    public final /* synthetic */ Set<Integer> $visibleAdapterIndexs;
    public final /* synthetic */ Rect $visibleRect;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewExtKt$onItemVisibilityChange$checkVisibility$1(RecyclerView recyclerView, Rect rect, float f11, Set<Integer> set, q<? super View, ? super Integer, ? super Boolean, Unit> qVar) {
        super(0);
        this.$this_onItemVisibilityChange = recyclerView;
        this.$visibleRect = rect;
        this.$percent = f11;
        this.$visibleAdapterIndexs = set;
        this.$block = qVar;
    }

    public final void invoke() {
        int childCount = this.$this_onItemVisibilityChange.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.$this_onItemVisibilityChange.getChildAt(i11);
            int childAdapterPosition = this.$this_onItemVisibilityChange.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1) {
                boolean localVisibleRect = childAt.getLocalVisibleRect(this.$visibleRect);
                Rect rect = this.$visibleRect;
                int height = rect.height() * rect.width();
                int width = childAt.getWidth() * childAt.getHeight();
                float f11 = ViewExtKt.f(this.$this_onItemVisibilityChange, this.$visibleRect);
                float f12 = this.$percent;
                if (f11 <= f12 || !localVisibleRect || ((float) height) < ((float) width) * f12) {
                    if (this.$visibleAdapterIndexs.contains(Integer.valueOf(childAdapterPosition))) {
                        this.$block.invoke(childAt, Integer.valueOf(childAdapterPosition), Boolean.FALSE);
                        this.$visibleAdapterIndexs.remove(Integer.valueOf(childAdapterPosition));
                    }
                } else if (this.$visibleAdapterIndexs.add(Integer.valueOf(childAdapterPosition))) {
                    this.$block.invoke(childAt, Integer.valueOf(childAdapterPosition), Boolean.TRUE);
                }
            }
        }
    }
}
