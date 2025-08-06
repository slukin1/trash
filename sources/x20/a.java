package x20;

import java.lang.annotation.Annotation;

public interface a {
    <T extends Annotation> T getAnnotation(Class<T> cls);

    Annotation[] getAnnotations();
}
