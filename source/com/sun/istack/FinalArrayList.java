package com.sun.istack;

import java.util.ArrayList;
import java.util.Collection;

public final class FinalArrayList<T> extends ArrayList<T> {
    public FinalArrayList(int i11) {
        super(i11);
    }

    public FinalArrayList() {
    }

    public FinalArrayList(Collection<? extends T> collection) {
        super(collection);
    }
}
