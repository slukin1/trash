package org.aspectj.runtime.internal.cflowstack;

import java.util.Stack;

public class ThreadStackFactoryImpl implements y10.c {

    public static class b extends ThreadLocal implements y10.a {

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f58982a = 0;
        }

        public b() {
        }

        public Object initialValue() {
            return new a();
        }
    }

    public static class c extends ThreadLocal implements y10.b {
        public c() {
        }

        public Object initialValue() {
            return new Stack();
        }
    }

    public y10.a a() {
        return new b();
    }

    public y10.b b() {
        return new c();
    }
}
