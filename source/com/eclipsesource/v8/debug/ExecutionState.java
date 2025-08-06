package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.debug.mirror.Frame;

public class ExecutionState implements Releasable {
    private static final String FRAME = "frame";
    private static final String FRAME_COUNT = "frameCount";
    private static final String PREPARE_STEP = "prepareStep";
    private V8Object v8Object;

    public ExecutionState(V8Object v8Object2) {
        this.v8Object = v8Object2.twin();
    }

    public void close() {
        V8Object v8Object2 = this.v8Object;
        if (v8Object2 != null && !v8Object2.isReleased()) {
            this.v8Object.close();
            this.v8Object = null;
        }
    }

    public Frame getFrame(int i11) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i11);
        V8Object v8Object2 = null;
        try {
            v8Object2 = this.v8Object.executeObjectFunction(FRAME, v8Array);
            return new Frame(v8Object2);
        } finally {
            v8Array.close();
            if (v8Object2 != null) {
                v8Object2.close();
            }
        }
    }

    public int getFrameCount() {
        return this.v8Object.executeIntegerFunction(FRAME_COUNT, (V8Array) null);
    }

    public void prepareStep(StepAction stepAction) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(stepAction.index);
        try {
            this.v8Object.executeVoidFunction(PREPARE_STEP, v8Array);
        } finally {
            v8Array.close();
        }
    }

    @Deprecated
    public void release() {
        close();
    }
}
