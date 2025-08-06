package org.junit.runner;

public abstract class Request {

    public static class a extends Request {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runner f25461a;

        public a(Runner runner) {
            this.f25461a = runner;
        }

        public Runner a() {
            return this.f25461a;
        }
    }

    public static Request b(Runner runner) {
        return new a(runner);
    }

    public abstract Runner a();
}
