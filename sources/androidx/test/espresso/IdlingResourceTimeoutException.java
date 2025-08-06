package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.List;

public final class IdlingResourceTimeoutException extends RuntimeException {
    public IdlingResourceTimeoutException(List<String> list) {
        super(String.format("Wait for %s to become idle timed out", new Object[]{Preconditions.i(list)}));
    }
}
