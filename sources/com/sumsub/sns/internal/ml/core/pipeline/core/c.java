package com.sumsub.sns.internal.ml.core.pipeline.core;

import com.sumsub.sns.internal.core.common.s;

public abstract class c<Input, Output> implements b<Input, Output> {
    public Output a(Input input) {
        try {
            return b(input);
        } catch (OutOfMemoryError unused) {
            s.a.f32281a.a();
            return b(input);
        }
    }

    public abstract Output b(Input input);
}
