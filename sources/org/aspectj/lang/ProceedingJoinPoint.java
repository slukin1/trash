package org.aspectj.lang;

import org.aspectj.runtime.internal.AroundClosure;

public interface ProceedingJoinPoint extends JoinPoint {
    Object a() throws Throwable;

    void d(AroundClosure aroundClosure);

    Object e(Object[] objArr) throws Throwable;

    void f(AroundClosure aroundClosure);
}
