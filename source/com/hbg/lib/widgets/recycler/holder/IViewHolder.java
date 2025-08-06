package com.hbg.lib.widgets.recycler.holder;

import java.io.Serializable;
import ka.a;

public interface IViewHolder<T extends a> extends Serializable {
    void bind(T t11, int i11);
}
