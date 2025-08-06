package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import org.junit.runners.model.MultipleFailureException;

public class ErrorCollector extends Verifier {

    /* renamed from: a  reason: collision with root package name */
    public List<Throwable> f25442a = new ArrayList();

    public void b() throws Throwable {
        MultipleFailureException.assertEmpty(this.f25442a);
    }
}
