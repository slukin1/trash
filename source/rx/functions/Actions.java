package rx.functions;

import rx.exceptions.OnErrorNotImplementedException;

public final class Actions {
    private static final EmptyAction EMPTY_ACTION = new EmptyAction();

    public static final class Action1CallsAction0<T> implements Action1<T> {
        public final Action0 action;

        public Action1CallsAction0(Action0 action0) {
            this.action = action0;
        }

        public void call(T t11) {
            this.action.call();
        }
    }

    public static final class EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements Action0, Action1<T0>, Action2<T0, T1>, Action3<T0, T1, T2>, Action4<T0, T1, T2, T3>, Action5<T0, T1, T2, T3, T4>, Action6<T0, T1, T2, T3, T4, T5>, Action7<T0, T1, T2, T3, T4, T5, T6>, Action8<T0, T1, T2, T3, T4, T5, T6, T7>, Action9<T0, T1, T2, T3, T4, T5, T6, T7, T8>, ActionN {
        public void call() {
        }

        public void call(T0 t02) {
        }

        public void call(T0 t02, T1 t12) {
        }

        public void call(T0 t02, T1 t12, T2 t22) {
        }

        public void call(T0 t02, T1 t12, T2 t22, T3 t32) {
        }

        public void call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42) {
        }

        public void call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t52) {
        }

        public void call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62) {
        }

        public void call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72) {
        }

        public void call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72, T8 t82) {
        }

        public void call(Object... objArr) {
        }
    }

    public enum NotImplemented implements Action1<Throwable> {
        INSTANCE;

        public void call(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }
    }

    private Actions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8> empty() {
        return EMPTY_ACTION;
    }

    public static Action1<Throwable> errorNotImplemented() {
        return NotImplemented.INSTANCE;
    }

    public static <T> Action1<T> toAction1(Action0 action0) {
        return new Action1CallsAction0(action0);
    }

    public static Func0<Void> toFunc(Action0 action0) {
        return toFunc(action0, (Object) null);
    }

    public static <T1> Func1<T1, Void> toFunc(Action1<T1> action1) {
        return toFunc(action1, (Object) null);
    }

    public static <T1, T2> Func2<T1, T2, Void> toFunc(Action2<T1, T2> action2) {
        return toFunc(action2, (Object) null);
    }

    public static <T1, T2, T3> Func3<T1, T2, T3, Void> toFunc(Action3<T1, T2, T3> action3) {
        return toFunc(action3, (Object) null);
    }

    public static <T1, T2, T3, T4> Func4<T1, T2, T3, T4, Void> toFunc(Action4<T1, T2, T3, T4> action4) {
        return toFunc(action4, (Object) null);
    }

    public static <T1, T2, T3, T4, T5> Func5<T1, T2, T3, T4, T5, Void> toFunc(Action5<T1, T2, T3, T4, T5> action5) {
        return toFunc(action5, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6> Func6<T1, T2, T3, T4, T5, T6, Void> toFunc(Action6<T1, T2, T3, T4, T5, T6> action6) {
        return toFunc(action6, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Func7<T1, T2, T3, T4, T5, T6, T7, Void> toFunc(Action7<T1, T2, T3, T4, T5, T6, T7> action7) {
        return toFunc(action7, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Func8<T1, T2, T3, T4, T5, T6, T7, T8, Void> toFunc(Action8<T1, T2, T3, T4, T5, T6, T7, T8> action8) {
        return toFunc(action8, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Void> toFunc(Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> action9) {
        return toFunc(action9, (Object) null);
    }

    public static FuncN<Void> toFunc(ActionN actionN) {
        return toFunc(actionN, (Object) null);
    }

    public static <R> Func0<R> toFunc(final Action0 action0, final R r11) {
        return new Func0<R>() {
            public R call() {
                action0.call();
                return r11;
            }
        };
    }

    public static <T1, R> Func1<T1, R> toFunc(final Action1<T1> action1, final R r11) {
        return new Func1<T1, R>() {
            public R call(T1 t12) {
                action1.call(t12);
                return r11;
            }
        };
    }

    public static <T1, T2, R> Func2<T1, T2, R> toFunc(final Action2<T1, T2> action2, final R r11) {
        return new Func2<T1, T2, R>() {
            public R call(T1 t12, T2 t22) {
                action2.call(t12, t22);
                return r11;
            }
        };
    }

    public static <T1, T2, T3, R> Func3<T1, T2, T3, R> toFunc(final Action3<T1, T2, T3> action3, final R r11) {
        return new Func3<T1, T2, T3, R>() {
            public R call(T1 t12, T2 t22, T3 t32) {
                action3.call(t12, t22, t32);
                return r11;
            }
        };
    }

    public static <T1, T2, T3, T4, R> Func4<T1, T2, T3, T4, R> toFunc(final Action4<T1, T2, T3, T4> action4, final R r11) {
        return new Func4<T1, T2, T3, T4, R>() {
            public R call(T1 t12, T2 t22, T3 t32, T4 t42) {
                action4.call(t12, t22, t32, t42);
                return r11;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, R> Func5<T1, T2, T3, T4, T5, R> toFunc(final Action5<T1, T2, T3, T4, T5> action5, final R r11) {
        return new Func5<T1, T2, T3, T4, T5, R>() {
            public R call(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52) {
                action5.call(t12, t22, t32, t42, t52);
                return r11;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, R> Func6<T1, T2, T3, T4, T5, T6, R> toFunc(final Action6<T1, T2, T3, T4, T5, T6> action6, final R r11) {
        return new Func6<T1, T2, T3, T4, T5, T6, R>() {
            public R call(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62) {
                action6.call(t12, t22, t32, t42, t52, t62);
                return r11;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Func7<T1, T2, T3, T4, T5, T6, T7, R> toFunc(final Action7<T1, T2, T3, T4, T5, T6, T7> action7, final R r11) {
        return new Func7<T1, T2, T3, T4, T5, T6, T7, R>() {
            public R call(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72) {
                action7.call(t12, t22, t32, t42, t52, t62, t72);
                return r11;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Func8<T1, T2, T3, T4, T5, T6, T7, T8, R> toFunc(final Action8<T1, T2, T3, T4, T5, T6, T7, T8> action8, final R r11) {
        return new Func8<T1, T2, T3, T4, T5, T6, T7, T8, R>() {
            public R call(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72, T8 t82) {
                action8.call(t12, t22, t32, t42, t52, t62, t72, t82);
                return r11;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> toFunc(final Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> action9, final R r11) {
        return new Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>() {
            public R call(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72, T8 t82, T9 t92) {
                action9.call(t12, t22, t32, t42, t52, t62, t72, t82, t92);
                return r11;
            }
        };
    }

    public static <R> FuncN<R> toFunc(final ActionN actionN, final R r11) {
        return new FuncN<R>() {
            public R call(Object... objArr) {
                actionN.call(objArr);
                return r11;
            }
        };
    }
}
