package androidx.camera.core.impl;

import java.util.Objects;

final class AutoValue_Identifier extends Identifier {
    private final Object value;

    public AutoValue_Identifier(Object obj) {
        Objects.requireNonNull(obj, "Null value");
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Identifier) {
            return this.value.equals(((Identifier) obj).getValue());
        }
        return false;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Identifier{value=" + this.value + "}";
    }
}
