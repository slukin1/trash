package rx.functions;

public interface Func2<T1, T2, R> extends Function {
    R call(T1 t12, T2 t22);
}
