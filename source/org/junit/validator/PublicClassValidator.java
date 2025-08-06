package org.junit.validator;

import java.util.Collections;
import java.util.List;
import x20.e;
import y20.a;

public class PublicClassValidator implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final List<Exception> f25492a = Collections.emptyList();

    public List<Exception> a(e eVar) {
        if (eVar.p()) {
            return f25492a;
        }
        return Collections.singletonList(new Exception("The class " + eVar.k() + " is not public."));
    }
}
