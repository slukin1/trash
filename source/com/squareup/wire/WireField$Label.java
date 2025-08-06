package com.squareup.wire;

public enum WireField$Label {
    REQUIRED,
    OPTIONAL,
    REPEATED,
    ONE_OF,
    PACKED;

    public boolean isOneOf() {
        return this == ONE_OF;
    }

    public boolean isPacked() {
        return this == PACKED;
    }

    public boolean isRepeated() {
        return this == REPEATED || this == PACKED;
    }
}
