package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;

public class i extends V8Object {
    public i(V8 v82) {
        super(v82);
        registerJavaMethod((JavaCallback) g.f43921a, "log");
        registerJavaMethod((JavaCallback) h.f43922a, "error");
    }
}
