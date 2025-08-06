package com.huobi.view.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRcvViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseRcvViewHolder(int i11, ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false));
        onBindViews();
        onSetViews();
    }

    public abstract void onBindViews();

    public abstract void onSetViews();

    public abstract void onUpdateViews(T t11, int i11);

    public BaseRcvViewHolder(View view, ViewGroup viewGroup) {
        super(view);
        onBindViews();
        onSetViews();
    }
}
