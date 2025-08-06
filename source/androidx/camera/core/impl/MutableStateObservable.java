package androidx.camera.core.impl;

public class MutableStateObservable<T> extends StateObservable<T> {
    private MutableStateObservable(Object obj, boolean z11) {
        super(obj, z11);
    }

    public static <T> MutableStateObservable<T> withInitialError(Throwable th2) {
        return new MutableStateObservable<>(th2, true);
    }

    public static <T> MutableStateObservable<T> withInitialState(T t11) {
        return new MutableStateObservable<>(t11, false);
    }

    public void setError(Throwable th2) {
        updateStateAsError(th2);
    }

    public void setState(T t11) {
        updateState(t11);
    }
}
