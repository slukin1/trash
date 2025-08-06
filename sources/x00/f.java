package x00;

import junit.framework.AssertionFailedError;
import junit.framework.Test;

public interface f {
    void a(Test test, Throwable th2);

    void b(Test test, AssertionFailedError assertionFailedError);

    void c(Test test);

    void d(Test test);
}
