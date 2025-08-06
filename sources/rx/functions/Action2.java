package rx.functions;

public interface Action2<T1, T2> extends Action {
    void call(T1 t12, T2 t22);
}
