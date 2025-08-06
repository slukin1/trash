package creativemaybeno.wakelock;

public final class NoActivityException extends Exception {
    public NoActivityException() {
        super("wakelock requires a foreground activity");
    }
}
