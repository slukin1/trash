package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;

public class c0 extends V8Function {
    public c0(V8 v82, u uVar) {
        super(v82, new b0(uVar, v82));
    }

    public static /* synthetic */ Object f(u uVar, V8 v82, V8Object v8Object, V8Array v8Array) {
        if (v8Array == null || v8Array.length() != 2 || !(v8Array.get(0) instanceof V8Function) || !(v8Array.get(1) instanceof Integer)) {
            return -1;
        }
        return Integer.valueOf(uVar.e(v82, (V8Function) v8Array.get(0), ((Integer) v8Array.get(1)).intValue()));
    }
}
