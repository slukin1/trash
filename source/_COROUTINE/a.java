package _COROUTINE;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3459a = "_COROUTINE";

    public static final StackTraceElement b(Throwable th2, String str) {
        StackTraceElement stackTraceElement = th2.getStackTrace()[0];
        return new StackTraceElement(f3459a + '.' + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }

    public static final String c() {
        return f3459a;
    }
}
