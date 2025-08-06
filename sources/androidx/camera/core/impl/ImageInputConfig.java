package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.Config;

public interface ImageInputConfig extends ReadableConfig {
    public static final Config.Option<DynamicRange> OPTION_INPUT_DYNAMIC_RANGE = Config.Option.create("camerax.core.imageInput.inputDynamicRange", DynamicRange.class);
    public static final Config.Option<Integer> OPTION_INPUT_FORMAT = Config.Option.create("camerax.core.imageInput.inputFormat", Integer.TYPE);

    public interface Builder<B> {
        B setDynamicRange(DynamicRange dynamicRange);
    }

    DynamicRange getDynamicRange();

    int getInputFormat();

    boolean hasDynamicRange();
}
