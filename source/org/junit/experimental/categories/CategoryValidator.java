package org.junit.experimental.categories;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import o20.a;
import o20.b;
import o20.d;
import o20.e;
import org.junit.validator.AnnotationValidator;
import x20.c;

public final class CategoryValidator extends AnnotationValidator {

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Class<? extends Annotation>> f25423b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Class[]{e.class, b.class, d.class, a.class})));

    public List<Exception> c(c cVar) {
        ArrayList arrayList = new ArrayList();
        for (Annotation annotation : cVar.getAnnotations()) {
            for (Class next : f25423b) {
                if (annotation.annotationType().isAssignableFrom(next)) {
                    d(arrayList, next);
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final void d(List<Exception> list, Class<?> cls) {
        list.add(new Exception(String.format("@%s can not be combined with @Category", new Object[]{cls.getSimpleName()})));
    }
}
