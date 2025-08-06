package com.sumsub.sns.internal.core.common;

public interface s {

    public static final class a implements s {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32281a = new a();

        public void a() {
            Runtime.getRuntime().gc();
            b();
            System.runFinalization();
        }

        public final void b() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException unused) {
                throw new AssertionError();
            }
        }
    }

    void a();
}
