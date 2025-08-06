package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;

public final class PendingResultsCreator {

    public static class DiscardedPendingResult<R extends Result> extends EmptyPendingResult {
        public DiscardedPendingResult() {
        }

        public boolean isCanceled() {
            return true;
        }

        public DiscardedPendingResult(R r11) {
            setResult(r11);
        }
    }

    public static class InstantPendingResult<R extends Result> extends EmptyPendingResult {
        public InstantPendingResult(R r11) {
            setResult(r11);
        }

        public void cancel() {
            throw new IllegalStateException("cancel() is not available.");
        }

        public void setResultCallback(ResultCallback resultCallback) {
            resultCallback.onResult(getResult());
        }
    }

    public static PendingResult<Status> discardedPendingResult() {
        return new DiscardedPendingResult();
    }

    public static PendingResult<Status> instantPendingResult(Status status) {
        return new InstantPendingResult(status);
    }

    public static <R extends Result> PendingResult<R> discardedPendingResult(R r11) {
        return new DiscardedPendingResult(r11);
    }

    public static <R extends Result> OptionalPendingResult<R> instantPendingResult(R r11) {
        return new OptionalPendingResultImpl(new InstantPendingResult(r11));
    }
}
