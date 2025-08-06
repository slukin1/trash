package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8ResultUndefined;

public class ScriptBreakPoint implements Releasable {
    private static final String CONDITION = "condition";
    private static final String LINE = "line";
    private static final String NUMBER = "number";
    private static final String SET_CONDITION = "setCondition";
    private V8Object v8Object;

    public ScriptBreakPoint(V8Object v8Object2) {
        this.v8Object = v8Object2.twin();
    }

    public void close() {
        V8Object v8Object2 = this.v8Object;
        if (v8Object2 != null && !v8Object2.isReleased()) {
            this.v8Object.close();
            this.v8Object = null;
        }
    }

    public int getBreakPointNumber() {
        return this.v8Object.executeIntegerFunction(NUMBER, (V8Array) null);
    }

    public String getCondition() {
        try {
            return this.v8Object.executeStringFunction(CONDITION, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return "undefined";
        }
    }

    public int getLine() {
        return this.v8Object.executeIntegerFunction("line", (V8Array) null);
    }

    public void release() {
        close();
    }

    public void setCondition(String str) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        try {
            this.v8Object.executeVoidFunction(SET_CONDITION, v8Array);
        } finally {
            v8Array.close();
        }
    }
}
