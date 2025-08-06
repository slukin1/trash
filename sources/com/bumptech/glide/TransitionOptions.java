package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import d4.a;

public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public a<? super TranscodeType> f63592b = NoTransition.b();

    /* renamed from: b */
    public final CHILD clone() {
        try {
            return (TransitionOptions) super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final a<? super TranscodeType> c() {
        return this.f63592b;
    }
}
