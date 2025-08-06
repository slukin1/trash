package rx.functions;

public interface Func3<T1, T2, T3, R> extends Function {
    R call(T1 t12, T2 t22, T3 t32);
}
