package org.junit.runner.notification;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.runner.Description;
import org.junit.runner.Result;

public class RunListener {

    @Documented
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    public void a(Failure failure) {
    }

    public void b(Failure failure) throws Exception {
    }

    public void c(Description description) throws Exception {
    }

    public void d(Description description) throws Exception {
    }

    public void e(Result result) throws Exception {
    }

    public void f(Description description) throws Exception {
    }

    public void g(Description description) throws Exception {
    }
}
