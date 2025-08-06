package com.google.firebase.crashlytics;

import java.util.HashMap;
import java.util.Map;

public class CustomKeysAndValues {
    public final Map<String, String> keysAndValues;

    public static class Builder {
        /* access modifiers changed from: private */
        public Map<String, String> keysAndValues = new HashMap();

        public CustomKeysAndValues build() {
            return new CustomKeysAndValues(this);
        }

        public Builder putBoolean(String str, boolean z11) {
            this.keysAndValues.put(str, Boolean.toString(z11));
            return this;
        }

        public Builder putDouble(String str, double d11) {
            this.keysAndValues.put(str, Double.toString(d11));
            return this;
        }

        public Builder putFloat(String str, float f11) {
            this.keysAndValues.put(str, Float.toString(f11));
            return this;
        }

        public Builder putInt(String str, int i11) {
            this.keysAndValues.put(str, Integer.toString(i11));
            return this;
        }

        public Builder putLong(String str, long j11) {
            this.keysAndValues.put(str, Long.toString(j11));
            return this;
        }

        public Builder putString(String str, String str2) {
            this.keysAndValues.put(str, str2);
            return this;
        }
    }

    public CustomKeysAndValues(Builder builder) {
        this.keysAndValues = builder.keysAndValues;
    }
}
