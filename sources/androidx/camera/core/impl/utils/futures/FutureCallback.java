package androidx.camera.core.impl.utils.futures;

public interface FutureCallback<V> {
    void onFailure(Throwable th2);

    void onSuccess(V v11);
}
