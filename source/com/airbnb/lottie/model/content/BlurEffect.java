package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableFloatValue;

public class BlurEffect {
    public final AnimatableFloatValue blurriness;

    public BlurEffect(AnimatableFloatValue animatableFloatValue) {
        this.blurriness = animatableFloatValue;
    }

    public AnimatableFloatValue getBlurriness() {
        return this.blurriness;
    }
}
