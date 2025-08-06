package com.sumsub.sns.core.presentation.base.adapter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class b<T> extends RecyclerView.ViewHolder {
    public b(View view) {
        super(view);
    }

    public static /* synthetic */ void a(b bVar, Object obj, int i11, int i12, Object obj2) {
        if (obj2 == null) {
            if ((i12 & 2) != 0) {
                i11 = Integer.MAX_VALUE;
            }
            bVar.a(obj, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bind");
    }

    public abstract void a(T t11, int i11);

    public final Context a() {
        return this.itemView.getContext();
    }
}
