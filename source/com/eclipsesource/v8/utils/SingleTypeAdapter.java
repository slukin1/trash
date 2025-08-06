package com.eclipsesource.v8.utils;

public abstract class SingleTypeAdapter implements TypeAdapter {
    private int typeToAdapt;

    public SingleTypeAdapter(int i11) {
        this.typeToAdapt = i11;
    }

    public Object adapt(int i11, Object obj) {
        if (i11 == this.typeToAdapt) {
            return adapt(obj);
        }
        return TypeAdapter.DEFAULT;
    }

    public abstract Object adapt(Object obj);
}
