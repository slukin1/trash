package androidx.camera.core.impl;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Identifier {
    public static Identifier create(Object obj) {
        return new AutoValue_Identifier(obj);
    }

    public abstract Object getValue();
}
