package com.google.android.gms.tasks;

public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, Throwable th2) {
        super(str, th2);
    }

    public static IllegalStateException of(Task<?> task) {
        String str;
        if (!task.isComplete()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception = task.getException();
        if (exception != null) {
            str = LoginLogger.EVENT_EXTRAS_FAILURE;
        } else if (task.isSuccessful()) {
            str = "result ".concat(String.valueOf(task.getResult()));
        } else {
            str = task.isCanceled() ? "cancellation" : "unknown issue";
        }
        return new DuplicateTaskCompletionException("Complete with: ".concat(str), exception);
    }
}
