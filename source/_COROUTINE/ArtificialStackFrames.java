package _COROUTINE;

public final class ArtificialStackFrames {
    public final StackTraceElement a() {
        return a.b(new Exception(), _BOUNDARY.class.getSimpleName());
    }

    public final StackTraceElement b() {
        return a.b(new Exception(), _CREATION.class.getSimpleName());
    }
}
