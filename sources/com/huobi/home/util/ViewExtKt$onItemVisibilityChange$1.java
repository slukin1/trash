package com.huobi.home.util;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d10.a;
import d10.p;
import d10.q;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class ViewExtKt$onItemVisibilityChange$1 extends Lambda implements p<View, Boolean, Unit> {
    public final /* synthetic */ q<View, Integer, Boolean, Unit> $block;
    public final /* synthetic */ a<Unit> $checkVisibility;
    public final /* synthetic */ RecyclerView $this_onItemVisibilityChange;
    public final /* synthetic */ Set<Integer> $visibleAdapterIndexs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewExtKt$onItemVisibilityChange$1(a<Unit> aVar, RecyclerView recyclerView, Set<Integer> set, q<? super View, ? super Integer, ? super Boolean, Unit> qVar) {
        super(2);
        this.$checkVisibility = aVar;
        this.$this_onItemVisibilityChange = recyclerView;
        this.$visibleAdapterIndexs = set;
        this.$block = qVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((View) obj, ((Boolean) obj2).booleanValue());
        return Unit.f56620a;
    }

    public final void invoke(View view, boolean z11) {
        if (z11) {
            this.$checkVisibility.invoke();
            return;
        }
        int childCount = this.$this_onItemVisibilityChange.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.$this_onItemVisibilityChange.getChildAt(i11);
            int childAdapterPosition = this.$this_onItemVisibilityChange.getChildAdapterPosition(childAt);
            if (this.$visibleAdapterIndexs.contains(Integer.valueOf(childAdapterPosition))) {
                this.$block.invoke(childAt, Integer.valueOf(childAdapterPosition), Boolean.FALSE);
                this.$visibleAdapterIndexs.remove(Integer.valueOf(childAdapterPosition));
            }
        }
    }
}
