package com.hbg.lib.widgets.recycler.holder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ka.a;

public abstract class BaseViewHolder<T extends a> extends RecyclerView.ViewHolder implements IViewHolder<T> {
    public Context mContext;

    public BaseViewHolder(Context context, View view) {
        super(view);
        this.mContext = context;
    }

    public int getColor(int i11) {
        return this.mContext.getResources().getColor(i11);
    }

    public String getString(int i11) {
        return this.mContext.getResources().getString(i11);
    }
}
