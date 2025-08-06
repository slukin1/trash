package org.junit.validator;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class AnnotationsValidator implements y20.a {

    /* renamed from: a  reason: collision with root package name */
    public static final List<b<?>> f25490a = Arrays.asList(new b[]{new c(), new e(), new d()});

    public static abstract class b<T extends x20.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final AnnotationValidatorFactory f25491a = new AnnotationValidatorFactory();

        public b() {
        }

        public abstract Iterable<T> a(x20.e eVar);

        public abstract List<Exception> b(AnnotationValidator annotationValidator, T t11);

        public final List<Exception> c(T t11) {
            ArrayList arrayList = new ArrayList();
            for (Annotation annotationType : t11.getAnnotations()) {
                y20.b bVar = (y20.b) annotationType.annotationType().getAnnotation(y20.b.class);
                if (bVar != null) {
                    arrayList.addAll(b(f25491a.a(bVar), t11));
                }
            }
            return arrayList;
        }

        public List<Exception> d(x20.e eVar) {
            ArrayList arrayList = new ArrayList();
            for (x20.a c11 : a(eVar)) {
                arrayList.addAll(c(c11));
            }
            return arrayList;
        }
    }

    public static class c extends b<x20.e> {
        public c() {
            super();
        }

        public Iterable<x20.e> a(x20.e eVar) {
            return Collections.singletonList(eVar);
        }

        /* renamed from: e */
        public List<Exception> b(AnnotationValidator annotationValidator, x20.e eVar) {
            return annotationValidator.a(eVar);
        }
    }

    public static class d extends b<x20.b> {
        public d() {
            super();
        }

        public Iterable<x20.b> a(x20.e eVar) {
            return eVar.d();
        }

        /* renamed from: e */
        public List<Exception> b(AnnotationValidator annotationValidator, x20.b bVar) {
            return annotationValidator.b(bVar);
        }
    }

    public static class e extends b<x20.c> {
        public e() {
            super();
        }

        public Iterable<x20.c> a(x20.e eVar) {
            return eVar.h();
        }

        /* renamed from: e */
        public List<Exception> b(AnnotationValidator annotationValidator, x20.c cVar) {
            return annotationValidator.c(cVar);
        }
    }

    public List<Exception> a(x20.e eVar) {
        ArrayList arrayList = new ArrayList();
        for (b<?> d11 : f25490a) {
            arrayList.addAll(d11.d(eVar));
        }
        return arrayList;
    }
}
