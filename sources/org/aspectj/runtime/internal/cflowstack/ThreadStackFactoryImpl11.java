package org.aspectj.runtime.internal.cflowstack;

import y10.a;
import y10.b;
import y10.c;

public class ThreadStackFactoryImpl11 implements c {
    public a a() {
        return new ThreadCounterImpl11();
    }

    public b b() {
        return new ThreadStackImpl11();
    }
}
