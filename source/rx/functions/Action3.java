package rx.functions;

public interface Action3<T1, T2, T3> extends Action {
    void call(T1 t12, T2 t22, T3 t32);
}
