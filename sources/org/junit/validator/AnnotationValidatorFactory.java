package org.junit.validator;

import java.util.concurrent.ConcurrentHashMap;
import y20.b;

public class AnnotationValidatorFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<b, AnnotationValidator> f25489a = new ConcurrentHashMap<>();

    public AnnotationValidator a(b bVar) {
        ConcurrentHashMap<b, AnnotationValidator> concurrentHashMap = f25489a;
        AnnotationValidator annotationValidator = concurrentHashMap.get(bVar);
        if (annotationValidator != null) {
            return annotationValidator;
        }
        Class<? extends AnnotationValidator> value = bVar.value();
        if (value != null) {
            try {
                concurrentHashMap.putIfAbsent(bVar, (AnnotationValidator) value.newInstance());
                return concurrentHashMap.get(bVar);
            } catch (Exception e11) {
                throw new RuntimeException("Exception received when creating AnnotationValidator class " + value.getName(), e11);
            }
        } else {
            throw new IllegalArgumentException("Can't create validator, value is null in annotation " + bVar.getClass().getName());
        }
    }
}
