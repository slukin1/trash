package kotlin.coroutines;

public interface c<T> {
    CoroutineContext getContext();

    void resumeWith(Object obj);
}
