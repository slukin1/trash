package org.junit.runners.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import q20.c;

public class MultipleFailureException extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> fErrors;

    public MultipleFailureException(List<Throwable> list) {
        this.fErrors = new ArrayList(list);
    }

    public static void assertEmpty(List<Throwable> list) throws Exception {
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                throw c.b(list.get(0));
            }
            throw new org.junit.internal.runners.model.MultipleFailureException(list);
        }
    }

    public List<Throwable> getFailures() {
        return Collections.unmodifiableList(this.fErrors);
    }

    public String getMessage() {
        StringBuilder sb2 = new StringBuilder(String.format("There were %d errors:", new Object[]{Integer.valueOf(this.fErrors.size())}));
        for (Throwable next : this.fErrors) {
            sb2.append(String.format("\n  %s(%s)", new Object[]{next.getClass().getName(), next.getMessage()}));
        }
        return sb2.toString();
    }
}
