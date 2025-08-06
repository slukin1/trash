package rx.plugins;

import rx.exceptions.Exceptions;

public abstract class RxJavaErrorHandler {
    public static final String ERROR_IN_RENDERING_SUFFIX = ".errorRendering";

    @Deprecated
    public void handleError(Throwable th2) {
    }

    public final String handleOnNextValueRendering(Object obj) {
        try {
            return render(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ERROR_IN_RENDERING_SUFFIX;
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            return obj.getClass().getName() + ERROR_IN_RENDERING_SUFFIX;
        }
    }

    public String render(Object obj) throws InterruptedException {
        return null;
    }
}
