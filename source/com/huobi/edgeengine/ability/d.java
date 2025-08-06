package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;

public class d extends V8Function {
    public d(V8 v82, u uVar) {
        super(v82, new c(uVar));
    }

    public static /* synthetic */ Object f(u uVar, V8Object v8Object, V8Array v8Array) {
        if (v8Array != null && v8Array.length() == 1 && (v8Array.get(0) instanceof Integer)) {
            uVar.b(((Integer) v8Array.get(0)).intValue());
        }
        return null;
    }
}
