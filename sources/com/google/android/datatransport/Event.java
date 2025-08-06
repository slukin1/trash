package com.google.android.datatransport;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Event<T> {
    public static <T> Event<T> ofData(int i11, T t11) {
        return new AutoValue_Event(Integer.valueOf(i11), t11, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(int i11, T t11) {
        return new AutoValue_Event(Integer.valueOf(i11), t11, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(int i11, T t11) {
        return new AutoValue_Event(Integer.valueOf(i11), t11, Priority.HIGHEST);
    }

    public abstract Integer getCode();

    public abstract T getPayload();

    public abstract Priority getPriority();

    public static <T> Event<T> ofData(T t11) {
        return new AutoValue_Event((Integer) null, t11, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(T t11) {
        return new AutoValue_Event((Integer) null, t11, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(T t11) {
        return new AutoValue_Event((Integer) null, t11, Priority.HIGHEST);
    }
}
