package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;

public final class ExoFlags {
    private final SparseBooleanArray flags;

    public boolean contains(int i11) {
        return this.flags.get(i11);
    }

    public boolean containsAny(int... iArr) {
        for (int contains : iArr) {
            if (contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExoFlags)) {
            return false;
        }
        return this.flags.equals(((ExoFlags) obj).flags);
    }

    public int get(int i11) {
        Assertions.checkIndex(i11, 0, size());
        return this.flags.keyAt(i11);
    }

    public int hashCode() {
        return this.flags.hashCode();
    }

    public int size() {
        return this.flags.size();
    }

    public static final class Builder {
        private boolean buildCalled;
        private final SparseBooleanArray flags = new SparseBooleanArray();

        public Builder add(int i11) {
            Assertions.checkState(!this.buildCalled);
            this.flags.append(i11, true);
            return this;
        }

        public Builder addAll(int... iArr) {
            for (int add : iArr) {
                add(add);
            }
            return this;
        }

        public Builder addIf(int i11, boolean z11) {
            return z11 ? add(i11) : this;
        }

        public ExoFlags build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new ExoFlags(this.flags);
        }

        public Builder addAll(ExoFlags exoFlags) {
            for (int i11 = 0; i11 < exoFlags.size(); i11++) {
                add(exoFlags.get(i11));
            }
            return this;
        }
    }

    private ExoFlags(SparseBooleanArray sparseBooleanArray) {
        this.flags = sparseBooleanArray;
    }
}
