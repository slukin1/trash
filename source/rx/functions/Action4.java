package rx.functions;

public interface Action4<T1, T2, T3, T4> extends Action {
    void call(T1 t12, T2 t22, T3 t32, T4 t42);
}
