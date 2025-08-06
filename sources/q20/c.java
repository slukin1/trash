package q20;

public final class c {
    public static <T extends Throwable> void a(Throwable th2) throws Throwable {
        throw th2;
    }

    public static Exception b(Throwable th2) throws Exception {
        a(th2);
        return null;
    }
}
