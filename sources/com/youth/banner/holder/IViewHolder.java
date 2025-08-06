package com.youth.banner.holder;

import android.view.ViewGroup;

public interface IViewHolder<T, VH> {
    void onBindView(VH vh2, T t11, int i11, int i12);

    VH onCreateHolder(ViewGroup viewGroup, int i11);
}
