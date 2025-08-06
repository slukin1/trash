package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    public final List<Keyframe<V>> keyframes;

    public BaseAnimatableValue(V v11) {
        this(Collections.singletonList(new Keyframe(v11)));
    }

    public List<Keyframe<V>> getKeyframes() {
        return this.keyframes;
    }

    public boolean isStatic() {
        return this.keyframes.isEmpty() || (this.keyframes.size() == 1 && this.keyframes.get(0).isStatic());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.keyframes.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(this.keyframes.toArray()));
        }
        return sb2.toString();
    }

    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.keyframes = list;
    }
}
